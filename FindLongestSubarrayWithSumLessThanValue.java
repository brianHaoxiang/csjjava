
public class FindLongestSubarrayWithSumLessThanValue {
	
	public static void main(String[] args)
	{
		int[] a = {3,1,3,2,5};
		compute(19,a);
	}
	public static void compute(int k, int[] a)
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
		System.out.println(l+","+(r-1));
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

