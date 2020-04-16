This package contains code to play with 2 datasets namely : 

1. Address.csv
2. TestDataSale.csv

Code comprise of three scenario

1. Calculate average expense of each city
2. Distribute total TestDataSale into multiple files according to prices
3. Calculate Number of transaction, total amount of transaction in each city and also display the associated city name. This solution uses concept of hadoop joins.

Command to run jar : 
hadoop jar retail.jar "fully qualified Classname of driver  class" "path of input files seperated by space" "path of output directory" 

Note: 
1. Output directory should be non-existing
2. Use NullWritable class for null where ever applicable.