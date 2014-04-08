

public class FindLargestSubmatrix {
	public static void main(String[] args)
	{
		int m[][]={{1,1,1,1,88},{2,2,2,1,99},{1,1,1,4,100}};
		m(12,m);
	}
	public static void m(int k,int[][] m)
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
				Result result = compute(k,temp);
				int temp_max = (result.end-result.begin)*(j-i+1);
				if (temp_max>max)
				{
					max = temp_max;
					upper_x=result.begin;
					upper_y=i;
					bot_x=result.end;
					bot_y=j;
				}
			}
		}
		System.out.println("Size:"+max+"\n Upper:"+upper_x+","+upper_y+"\n Bottom:"+bot_x+","+bot_y);
	}
	public static class Result
	{
		int begin;
		int end;
		public Result(int begin, int end)
		{
			this.begin = begin;
			this.end = end;
		}
	}
	public static Result compute(int k, int[] a)
	{
		int l = 0;
		int r = 0;
		/*
		 * 3,4,7,9,14
		 * 13,0,4
		 * */
		int all[] = new int[a.length+1];
		all[0] = 0;
		for (int i=0; i<a.length; i++)
		{
			all[i+1] = all[i]+a[i];
		}
		for (int i=0; i<all.length; i++)
		{
			int index = binarySearch(k+all[i],i,all.length-1,all);
			if (index-i>r-l)
			{
				r = index;
				l = i;
			}
		}
		return new Result(l,r);
	}
	public static int binarySearch(int k, int l, int r, int[] array)
	{
		if (l==r)
			return l;
		int mid = (l+r)/2;
		if (array[mid]>k)
			return binarySearch(k,l,mid,array);
		else if (array[mid+1]>k)
			return mid;
		else
			return binarySearch(k,mid+1,r,array);
	}
	
}

