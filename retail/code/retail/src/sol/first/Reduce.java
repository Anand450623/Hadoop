package sol.first;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, FloatWritable, Text, FloatWritable>  
{
	public void reduce(Text key, Iterable<FloatWritable>  values, Context context) throws IOException, InterruptedException
	{
		Float count = 0.0f;
		Float sum = 0.0f;
		for(FloatWritable value:values)
		{
			sum += value.get();
			count += 1.0f;
		}
		Float avg = (float)sum/count;
		context.write(key, new 	FloatWritable(avg));
	}
}
