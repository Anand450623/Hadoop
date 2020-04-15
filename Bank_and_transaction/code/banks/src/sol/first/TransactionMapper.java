package sol.first;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TransactionMapper extends Mapper<Object, Text, Text, Text> 
{
	public void map(Object Key, Text value, Context context) throws IOException, InterruptedException
	{
		String record = value.toString();
		String[] parts = record.split(",");
		context.write(new Text(parts[1]), new Text("trans\t"+parts[3]));
	}
}
