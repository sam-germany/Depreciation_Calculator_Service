import java.util.Scanner;

public class DepreciationCalculator_Main_Method {

    public static void main(String[] args) {

        int assetDepreciationRange;
        String acquisitionDate;
        double acquisitionCosts;

        Scanner input = new Scanner(System.in);

          while(true){

              try {
                  System.out.println("Please enter number of Years for AssetDepreciationRange, Please enter only numeric value  e.g  enter   5   for  5 years");
                  assetDepreciationRange = input.nextInt();

                  input.nextLine();
                  System.out.println("Please enter AcquisitionDate, Please enter only in this given format    Month Day, Year    January 1, 2015 ");
                  acquisitionDate = input.nextLine();


                  System.out.println("Please enter AcquisitionCosts, Please enter value only in this given format   €1,000.00");
                  String date = input.next().replace("€", "").replace(",", "");
                  acquisitionCosts = Double.valueOf(date);


                  DepreciationCalculator dC = new DepreciationCalculator(assetDepreciationRange, acquisitionDate, acquisitionCosts);
              //     dC.calculateLinearDepreciation();
                   dC.calculateDegressiveDepreciation();

              }catch (Exception e ){
                  System.out.println("Entered Data is in Wrong  Format, Please try again with defined format in the message");
                 continue;
              }


            System.out.println("Please enter n for Exit else press Enter y to continue");
            String exit = input.next();

            if(exit.equalsIgnoreCase("n")){
                input.close();
                break;
            }else
               continue;
         }

    }
}

