public class BulgarianSorter
{
   public static void sort(int[] a)
   {
      while(!isSorted(a))
      {
    	  for (int i = 0; i< a.length;i = i+2)
    	  {
    		  sortThree(a,i);
    	  }
    	  
      }
   }

   /**
      Sorts the three elements a[start], a[start + 1], a[start + 2].
      If start > a.length - 3, sorts the one or two remaining elements.
   */
   public static void sortThree(int[] a, int start)
   {
	   if(start< a.length && start>=0)
	   {
	   // for the cases where there aren't 3 elements to compare
	   if(start == a.length - 1)
	   {
	   }
   else if(start >= a.length - 2)
	   {
		   int secondElement = a[start];
		   int thirdElement = a[start+1];
		   if(secondElement>thirdElement)
		   {
			   swap(a,start,start+1);
		   }
			     
		   //otherwise if there are 3 or more elements to compare
	   }
	   else 
	   {  
		//intializes the elements   
      int firstElement  = a[start];
      int secondElement = a[start+1];
      int thirdElement = a[start+2];
      
      // if first is greater than second then swap and store the new values
      if(firstElement>secondElement)
	   {
		   swap(a,(start),(start+1));
		   firstElement = a[start];
		   secondElement = a[start+1];

	   }
      // if second is greater than third then swap and store the new values
	   if(secondElement>thirdElement)
	   {
		   swap(a,(start+1),(start+2));
	       secondElement = a[start+1];
	       thirdElement = a[start+2];
	   }
	   // check the new first and second values. If the first is greater than the second then swap and store those values
	   if(firstElement>secondElement)
	   {
		   swap(a,(start),(start+1));
		   firstElement = a[start];
		   secondElement = a[start+1];

	   }
	   }
	   }
   }

   /**
      Checks whether the given array is sorted.
      @param a an array
      @return true if the array is sorted
   */
   public static boolean isSorted(int[] a)
   {
	   for(int i = 0; i< a.length-1;i++)
	   {
		   if(a[i]>a[i+1])
		   {
			   return false;   
		   }
	   }
     return true;
   }

   /**
      Swaps two entries of the array.
      @param a an array
      @param i the first position to swap
      @param j the second position to swap
   */
   private static void swap(int[] a, int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }
}
