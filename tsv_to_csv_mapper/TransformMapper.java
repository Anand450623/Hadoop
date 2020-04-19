package poc;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TransformMapper extends Mapper<LongWritable, Text, NullWritable, Text>
{

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		
		String[] tokens = value.toString().split("\t");
		String details = tokens[0] + "," + tokens[1] + "," + tokens[5] + "," + tokens[10] + "," + tokens[4] + ","+ tokens[11] + "," + tokens[12];
		context.write(NullWritable.get(), new Text(details));

	}

}
