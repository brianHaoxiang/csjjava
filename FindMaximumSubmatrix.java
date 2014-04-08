//extend Kadane algorithm
public class FindMaximumSubmatrix {
	static int m[][] = {{1, 2, -1, -4, -20},
        {-8, -3, 4, 2, 1},
        {3, 8, 10, 1, 3},
        {-4, -1, 1, 7, -6}
       };
	public static void main(String[] args)
	{
		m(m);
	}
	
	public static void m(int[][] m)
	{
		int temp[] = new int[m[0].length];
		int max = 0;
		int upper_x = 0;
		int upper_y = 0;
		int bot_x = 0;
		int bot_y = 0;
		for (int i=0; i<m.length; i++)
		{
			for (int j=i; j<m.length; j++)
			{
				if (j==i)
					temp = m[j];
				else
				{
					for (int h=0; h<m[0].length; h++)
					{
						temp[h]+=m[j][h];
					}
				}
				Result result = Kadane(temp);
				if (result.max>max)
				{
					max = result.max;
					upper_x=result.begin;
					upper_y=i;
					bot_x=result.end;
					bot_y=j;
				}
			}
		}
		System.out.println(max+"\n Upper:"+upper_x+","+upper_y+"\n Bottom:"+bot_x+","+bot_y);
	}
	public static class Result
	{
		int max;
		int begin;
		int end;
		public Result(int max, int begin, int end)
		{
			this.max = max;
			this.begin = begin;
			this.end = end;
		}
	}
	public static Result Kadane(int[] array)
	{
		int max = array[0]; 
		int max_for_now = array[0];
		int begin=0;
		int end=0;
		int finalbegin=0;
		int finalend=0;
		for (int i=1; i<array.length; i++)
		{
			if (max_for_now<0)
			{
				max_for_now = array[i];
				begin=i;
				end=i;
			}
			else
			{
				max_for_now += array[i];
				end=i;
			}
			if (max_for_now>=max)
			{
				max = max_for_now;
				finalbegin=begin;
				finalend=end;
			}
		}
		return new Result(max,finalbegin,finalend);
	}
	
}
