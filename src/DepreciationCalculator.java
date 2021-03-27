import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DepreciationCalculator {

    int assetDepreciationRange;
    String acquisitionDate;
    double acquisitionCosts;

    public DepreciationCalculator(int assetDepreciationRange, String acquisitionDate, double acquisitionCosts) {
        this.assetDepreciationRange = assetDepreciationRange;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionCosts = acquisitionCosts;
    }

    public void calculateLinearDepreciation(){

        LocalDate localDate1 = dateParser(acquisitionDate);

        List<LocalDate> listOfAllMonthsYears = createListOfAllMonthsAndYears(localDate1, assetDepreciationRange);

        long includedYearCount = findIncludedYears(listOfAllMonthsYears);

        finalPrint1(acquisitionCosts, includedYearCount, localDate1, listOfAllMonthsYears, assetDepreciationRange);
    }

    public  void calculateDegressiveDepreciation() {

        LocalDate localDate = dateParser(acquisitionDate);

        int percentagePerYear = percentagePerYearChecker(localDate);

        List<LocalDate> listOfAllMonthsYears = createListOfAllMonthsAndYears(localDate, assetDepreciationRange);

        Map<Integer, Map<Integer, Long>>  findInclusiveMonthsPerYearA =  findInclusiveMonthsPerYearB( listOfAllMonthsYears, assetDepreciationRange);

        long includedYearCount = findIncludedYears(listOfAllMonthsYears);

        finalPrint2(acquisitionCosts, includedYearCount, localDate, percentagePerYear, findInclusiveMonthsPerYearA);

    }

    private static void  finalPrint1(double acquisitionCosts, long includedYearCount, LocalDate localDate, List<LocalDate> listOfAllMonthsYears, int assetDepreciationRange){

        double output = (acquisitionCosts) / (assetDepreciationRange * 12);

        double reducedBookValue = acquisitionCosts;

        for (int x = 0; x < includedYearCount; x++) {

            int year  = localDate.plusYears( x ).getYear();
            long nrOfYears =  findRestMonthsOfYear( listOfAllMonthsYears, year);
            double deprecationAmount = roundScale2(output * nrOfYears);
            reducedBookValue = reducedBookValue -  deprecationAmount ;

            System.out.println(localDate.plusYears(x).getYear() + ": | Depreciation amount: " + deprecationAmount + "  | Residual book value: "+ roundScale2(reducedBookValue));

        }

    }

    private static long findRestMonthsOfYear(List<LocalDate> lostOfAllMonthsYears, int year){

        long nrOfYears  = lostOfAllMonthsYears.stream()
                                              .filter(x -> x.getYear() == year)
                                              .count();
        return nrOfYears;
    }


      private static void finalPrint2(double acquisitionCosts, long includedYearCount, LocalDate localDate,  int  percentagePerYear, Map<Integer, Map<Integer, Long>> findInclusiveMonthsPerYearA){
          double reducedBookValue = acquisitionCosts;
          double deprecationAmountPerYear;

          double currentYearValue = 0.0;
          double oldPendingYearValue = 0.0;
          double newPendingYearValue = 0.0;
          for (int x = 0; x < includedYearCount; x++) {

              int year =  localDate.plusYears(x).getYear();

              deprecationAmountPerYear = (reducedBookValue / 100 ) * percentagePerYear;
              reducedBookValue = reducedBookValue - deprecationAmountPerYear;

              double deprecationAmountPerMonth =   deprecationAmountPerYear / 12;

              if(x < findInclusiveMonthsPerYearA.size()) {
                  for (Map.Entry<Integer, Long> dd : findInclusiveMonthsPerYearA.get(x).entrySet()) {

                      if (dd.getKey() == year) {
                          currentYearValue = dd.getValue();
                          currentYearValue *= deprecationAmountPerMonth;
                      }

                      if (dd.getKey() == year + 1) {
                          newPendingYearValue = dd.getValue();
                          newPendingYearValue *= deprecationAmountPerMonth;
                      }
                  }
              }
              if (oldPendingYearValue > 0){
                  currentYearValue += oldPendingYearValue;
              }

              oldPendingYearValue = newPendingYearValue;


              double currentAcquisitionCosts =  acquisitionCosts;
              acquisitionCosts = acquisitionCosts - currentYearValue;



              System.out.println(year + " | AcquisitionCost: "+ roundScale2(currentAcquisitionCosts)  +"  | " +"    Depreciation amount: " + roundScale2(currentYearValue) + " |  Residual book value: "+ roundScale2(acquisitionCosts));
              currentYearValue = 0;
          }
      }


    private static  Map<Integer, Map<Integer, Long>> findInclusiveMonthsPerYearB (List<LocalDate> listOfAllMonthsYears, int assetDepreciationRange){


            Map<Integer, Map<Integer, Long>> allList =  new HashMap<>();

               Map<Integer,Long >  map1  = new HashMap<>();
                 int s = 0;
                 int z = 0;
                List<LocalDate> cc = null;
                for(int i=0; i < assetDepreciationRange ; i++){

                    cc = new ArrayList<>();
                   for(int x=0; x < 12; x++) {
                       cc.add(listOfAllMonthsYears.get(s++));
                   }
                   map1  = findInclusiveMonthsPerYearC(cc);
                   allList.put(z++ , map1);
                }
        return allList;
    }


    private static Map<Integer, Long> findInclusiveMonthsPerYearC(List<LocalDate> listOfTwelveMonths){

     Map<Integer, Long> includedMonthsOfYears = listOfTwelveMonths.stream()
                                                       .sorted()
                                                       .map( x-> x.getYear())
                                                       .collect(Collectors.groupingBy( e -> e,Collectors.counting()));

         return includedMonthsOfYears;
    }

    private static long findIncludedYears(List<LocalDate> lostOfAllMonthsYears){

        long includedYearsCount =   lostOfAllMonthsYears.stream()
                                                        .map(x -> x.getYear())
                                                        .distinct()
                                                        .count();
        return includedYearsCount;
    }



    private static List<LocalDate> createListOfAllMonthsAndYears(LocalDate localDate1, int serviceLife) {

        LocalDate current = localDate1;
        LocalDate endDate = localDate1.plusMonths((serviceLife * 12) - 1);

        long monthsBetween = ChronoUnit.MONTHS.between(current.withDayOfMonth(1), endDate.withDayOfMonth(1));

        List<LocalDate> listOfAllMonthsYears = new ArrayList<>();

        for (int x = 0; x <= monthsBetween; x++) {
            listOfAllMonthsYears.add(current);
            current = current.plusMonths(1);
        }
        return  listOfAllMonthsYears;
    }

    private static  LocalDate  dateParser(String acquisitionDate) {

        List<String> allMonths =  Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        String [] s2 =  acquisitionDate.replace(",", "").split(" ");

        int month = 0;
        if(allMonths.contains(s2[0])){
         month = allMonths.indexOf(s2[0]) + 1;
        }

        String newFormattedDate = "";

        if(s2[1].length() < 2){
            newFormattedDate = 0 + s2[1];
        }else newFormattedDate = s2[1];

        if(month < 10) {
            newFormattedDate = newFormattedDate +"-"+ 0 + month +"-"+ s2[2];
        }else {
            newFormattedDate = newFormattedDate +"-"+ month +"-"+ s2[2];
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDateValue = LocalDate.parse(newFormattedDate, dateTimeFormatter);


        return  parsedDateValue;
    }


    private static  int percentagePerYearChecker(LocalDate localDate) {

        int decliningPercentage;
        LocalDate dateChecking  = LocalDate.parse("2006-01-01");
        int dateValue =   dateChecking.compareTo(localDate);
        if(dateValue <= 0) {
            decliningPercentage = 30;
        } else decliningPercentage = 20;

        return  decliningPercentage;
    }

    private static double roundScale2(double value) {
        double roundedDouble = Math.round(value * 100.0) / 100.0;
        return roundedDouble;
    }


}

