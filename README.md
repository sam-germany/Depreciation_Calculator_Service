# Depreciation Calculator Service


### Calculating Linear Depreciation

#### Test Case-1
Please enter data in three steps
* Enter assetDepreciationRange in years: 5
* Enter AcquisitionDate                : January 1, 2015
* Enter AcquisitionCosts               : €1,000.00

#### Output
* 2015: | Depreciation amount: 200.0 | Residual book value: 800.0
* 2016: | Depreciation amount: 200.0 | Residual book value: 600.0
* 2017: | Depreciation amount: 200.0 | Residual book value: 400.0
* 2018: | Depreciation amount: 200.0 | Residual book value: 200.0
* 2019: | Depreciation amount: 200.0 | Residual book value: 0.0

#### Description
* In this Application their is a class called as DepreciationCalculator_Main_Method Class, in this i have defined the Main method.
* As in the above case example we are trying to calculate  Linear Depreciation so in this case frist we have to uncomment this method dC.calculateLinearDepreciation()
  and comment the method name  dC.calculateDegressiveDepreciation();
* Now we need to execute this class, as i have used Scanner in this Application so in the Console it will display messages and ask us to enter Data, please enter 
  Data as shown above for this case and it will give required output.
* As the given time-period is of 5 Year, it means 5x12=60  so it gives us  60 months
* The AcquisitionDate is January 1, 2015, so we need to add 60 months in it, it starts from  January 2015  till December 2019
* As we are using Linear Depreciation so we will find the  value for 1 month out from the AcquisitionCost and  after that we will take the same value for all 60 months 
* At end we are displaying reports per Year basis just adding   month value x 12


#### Test Case-2
Please enter data in three steps
* Enter assetDepreciationRange in years: 5
* Enter AcquisitionDate                : February 1, 2015
* Enter AcquisitionCosts               : €1,000.00

#### Output
* 2015: | Depreciation amount: 183.33 | Residual book value: 816.67
* 2016: | Depreciation amount: 200.0  | Residual book value: 616.67
* 2017: | Depreciation amount: 200.0  | Residual book value: 416.67
* 2018: | Depreciation amount: 200.0  | Residual book value: 216.67
* 2019: | Depreciation amount: 200.0  | Residual book value: 16.67
* 2020: | Depreciation amount: 16.67  | Residual book value: 0.0

#### Description
* In this Application their is a class called as DepreciationCalculator_Main_Method Class, in this i have defined the Main method.
* As in the above case example we are trying to calculate  Linear Depreciation so in this case frist we have to uncomment this method dC.calculateLinearDepreciation()
  and comment the method name  dC.calculateDegressiveDepreciation();
* Now we need to execute this class, as i have used Scanner in this Application so in the Console it will display messages and ask us to enter Data, please enter 
  Data as shown above for this case and it will give required output.
* As the given time-period is of 5 Year, it means 5x12=60  so it gives us  60 months
* The AcquisitionDate is February 1, 2015 so we need to add 60 months in it, it starts from  February 2015  till  January 2020
* As we are using Linear Depreciation so we will find the  value for 1 month out from the AcquisitionCost and  after that we will take the same value for all 60 months 
* At end we are displaying reports as per Year basis just adding  included months of a Year

___
### Calculating Declining Depreciation

#### Test Case-3
Please enter data in three steps
* Enter assetDepreciationRange in years: 5
* Enter AcquisitionDate                : January 1, 2015
* Enter AcquisitionCosts               : €1,000.00

#### Output
* 2015 | AcquisitionCost: 1000.0 | Depreciation amount: 300.0 |  Residual book value: 700.0
* 2016 | AcquisitionCost: 700.0  | Depreciation amount: 210.0 |  Residual book value: 490.0
* 2017 | AcquisitionCost: 490.0  | Depreciation amount: 147.0 |  Residual book value: 343.0
* 2018 | AcquisitionCost: 343.0  | Depreciation amount: 102.9 |  Residual book value: 240.1
* 2019 | AcquisitionCost: 240.1  | Depreciation amount: 72.03 |  Residual book value: 168.07

#### Description
* In this Application their is a class called as DepreciationCalculator_Main_Method Class, in this i have defined the Main method.
* As in the above case example we are trying to calculate  Linear Depreciation so in this case frist we have to uncomment this method  dC.calculateDegressiveDepreciation();
  and comment the method name  dC.calculateLinearDepreciation();
* Now we need to execute this class, as i have used Scanner in this Application so in the Console it will display messages and ask us to enter Data, please enter 
  Data as shown above for this case and it will give required output.
* As the given time-period is of 5 Year, it means 5x12=60  so it gives us  60 months
* The AcquisitionDate is January 1, 2015 so we need to add 60 months in it, it starts from  January 2015  till  December 2019
* As per the gien Coding Task if AcquisitionDate >= January 1, 2006   then we need to calculate with 30%, if it is less then 20%
* In this case we need to use 30%, as at first Step we are deducting 30% from 1000 for year 2015 and the rest amount will be transfered to the next year, after that from every year amount we will deduct 30% 
* At end we are diplaying reports on the basis of deducted and Remaining amount per year


#### Test Case-4
Please enter data in three steps
* Enter assetDepreciationRange in years: 10 
* Enter AcquisitionDate                : February 1, 2001
* Enter AcquisitionCosts               : €100,000.00

#### Output
* 2001 | AcquisitionCost: 100000.0  |     Depreciation amount: 18333.33 |  Residual book value: 81666.67
* 2002 | AcquisitionCost: 81666.67  |    Depreciation amount: 16333.33  |  Residual book value: 65333.33
* 2003 | AcquisitionCost: 65333.33  |     Depreciation amount: 13066.67 |  Residual book value: 52266.67
* 2004 | AcquisitionCost: 52266.67  |     Depreciation amount: 10453.33 |  Residual book value: 41813.33
* 2005 | AcquisitionCost: 41813.33  |     Depreciation amount: 8362.67  |  Residual book value: 33450.67
* 2006 | AcquisitionCost: 33450.67  |     Depreciation amount: 6690.13  |  Residual book value: 26760.53
* 2007 | AcquisitionCost: 26760.53  |     Depreciation amount: 5352.11  |  Residual book value: 21408.43
* 2008 | AcquisitionCost: 21408.43  |     Depreciation amount: 4281.69  |  Residual book value: 17126.74
* 2009 | AcquisitionCost: 17126.74  |     Depreciation amount: 3425.35  |  Residual book value: 13701.39
* 2010 | AcquisitionCost: 13701.39  |     Depreciation amount: 2740.28  |  Residual book value: 10961.11
* 2011 | AcquisitionCost: 10961.11  |     Depreciation amount: 223.7    |  Residual book value: 10737.42

#### Description
* In this Application their is a class called as DepreciationCalculator_Main_Method Class, in this i have defined the Main method.
* As in the above case example we are trying to calculate  Linear Depreciation so in this case frist we have to uncomment this method  dC.calculateDegressiveDepreciation();
  and comment the method name  dC.calculateLinearDepreciation();
* Now we need to execute this class, as i have used Scanner in this Application so in the Console it will display messages and ask us to enter Data, please enter 
  Data as shown above for this case and it will give required output.
* As the given time-period is of 5 Year, it means 5x12=60  so it gives us  60 months
* The AcquisitionDate is February 1, 2015 so we need to add 60 months in it, it starts from  February 2015  till  January 2020
* Below is the Internal report how it calculate internally as we are calucing 20% on 12 months period and we need report as per year, as in our case 11 months are included for 2001 and 1 month is of 2002, so here we are calculating 20% on this perior and after that goes further in the same way
* But as we need a year report we so are calculating the amount on the basis  of  included months per Year and in which period of months it comes, as every period is of 12 months and we are calculating 20% on the rest amount from the pervious basis,
   
## Report-1

|  12 months included   |     Amount per month year count          |  Amount per 12 months period   |     Deducted yearly amount      |
|         ---           |               ---                        |           ---                  |              ---                |
| 0={2001=11, 2002=1},  |  {2001=11   18333.33, 2002=1  1666.66},  | 18333.33 + 1666.66 = 19999.99  |    100000 - 19999.99 = 80000    |       
| 1={2002=11, 2003=1},  |  {2002=11   14666.66, 2003=1  1333.33},  | 14666.66 + 1333.33 = 15999.99  |   80000  - 15999.99 = 64000     |
| 2={2003=11, 2004=1},  |  {2003=11   11733.33, 2004=1  1066.66},  | 11733.33 + 1066.66 = 12799.99  |  64000  - 12799.99 = 51200      | 
| 3={2004=11, 2005=1},  |  {2004=11   9386.66,  2005=1  853.33 },  | 9386.66  + 853.33  = 10239.99  |   51200  - 10239.99 = 40960     | 
| 4={2005=11, 2006=1},  |  {2005=11   7509.33,  2006=1  682.66 },  | 7509.33  + 682.66  = 8191.99   |   40960  - 8192.99  = 32768     | 
| 5={2006=11, 2007=1},  |  {2006=11   6007.46,  2007=1  546.13 },  | 6007.46  + 546.13  = 6553.59   |   32768  - 6553.59  = 26214.4   | 
| 6={2007=11, 2008=1},  |  {2007=11   4805.97,  2008=1  436.98 },  | 4805.97  + 436.98  = 5242.95   |   26214.4 - 5242.95 = 20971.52  | 
| 7={2008=11, 2009=1},  |  {2008=11   3844.77,  2009=1  349.52},   | 3844.77  + 349.52  = 4194,29   |  20971.50 - 4194.29 = 16777.216 | 
| 8={2009=11, 2010=1},  |  {2009=11   3075.82,  2010=1  279.62},   | 3075.82  + 279.62  = 3355.44   |   16777.20 - 3355.44 = 13421.80 | 
| 9={2010=11, 2011=1}   |  {2010=11   2460.65,  2011=1  233.69}    | 2460.65  + 233.69  = 2694.34   |   13421.80 - 2694.34 = 10737.41 | 


## Report-2
|   Months included in 12 months period      |   Amount per months in a year        |     End deducting amount       |  
|    ---   |            ---       |     ---      |
| 2001=11  |  18333.33            | =  18333.33  | 
| 2002=1   |  1666.66             |              |    
| 2002=11  |  14666.66 + 1666.66  | =  16333.33  |
| 2003=1   |  1333.33             |              |
| 2003=11  |  11733.33 + 1333.33  | =  13066.66  |
| 2004=1   |  1066.66             |              |  
| 2004=11  |  9386.66  + 1066.66  | =  10453.32  | 
| 2005=1   |  853.33              |              | 
| 2005=11  |  7509.33  + 853.33   | =  8362,66   |
| 2006=1   |  682.66              |              |
| 2006=11  |  6007.46  + 682.66   | =  6690.12   |
| 2007=1   |  546.13              |              |
| 2007=11  |  4805.97 + 546.13    | =  5352.10   |
| 2008=1   |  436.98              |              |
| 2008=11  |  384.77  + 436.98    | =  821.75    |
| 2009=1   |  349.52              |              |
| 2009=11  |  3075.82 + 349.52    | =  3425.34   |
| 2010=1   |  279.62              |              |
| 2010=11  |  2460.65 + 279.62    | =  2740.27   | 
| 2011=1   |  233.69              | =  233.69    |      


