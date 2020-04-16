package sol.second;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partition extends Partitioner<Text, Text> 
{

	@Override
	public int getPartition(Text key, Text value, int reducerToUse) 
	{
		
		Integer price = Integer.parseInt(key.toString());
		
		if(price<10000)
			return 0;
		else if(price >= 10000 && price < 20000)
			return 1;
		else if(price >= 20000 && price < 40000)
			return 2;
		else
			return 3;
		
	}

}
