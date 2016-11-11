import java.util.Comparator;

/**
   The sort method of this class sorts an array, using the selection 
   sort algorithm.
*/
import java.util.Comparator;

public class SelectionSorter
{
   /**
      Sorts an array, using selection sort.
      @param a the array to sort
      @param c the comparator
   */
   public static void sort(Object[] a, Comparator c)
   {
	   if (a.length>1)
	   {
	   for(int i = 0; i<a.length-1; i++)
	   {
		   int minimumValue =  minimumPosition(a,i,c);
		   
	 Object temp = a[i];
	 a[i] = a[minimumValue];
	 a[minimumValue] = temp;
		   
	   }
	    }
	   }
   

   /**
      Finds the smallest element in a tail range of the array.
      @param a the array to sort
      @param from the first position in a to compare
      @param c the comparator
      @return the position of the smallest element in the range a[from] . . . a[a.length - 1]
   */
   public static int minimumPosition(Object[] a, int from, Comparator c)
   {  
	   int minimumPosition = from;
     for(int i = from+1;i<a.length;i++)
     {
    	 //if the value of a at minimumPosition > value of a at i, then minimumPosition = i
    	if( c.compare(a[minimumPosition],a[i])>0)
    	{
    		minimumPosition = i;
    	}
     }
     return minimumPosition;
   }
}
