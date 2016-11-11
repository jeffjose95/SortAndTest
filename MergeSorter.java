/**
   This class sorts an array, using the merge sort 
   algorithm nonrecursively.
*/
public class MergeSorter
{
   /**
      Merges from 0 to length of array based on int length and then does this again on doubling the value of length until length is greater than that of the length of the array
      @param int[] a insert the array of integers which we want to merge
      @param boolean debug if true then sort 
      @param boolean debug if false don't sort
   */
   public static void sort(int[] a, boolean debug)
   {
/**
 *   	length = 1
	   
	   	while length is lesser than length of the array 
	   
	   	start = 0
	   	mid = start+length-1
	   	end = mid + length

	   	while end is lesser than the length of the array
	   	merge using the merge method to merge the start, mid and end values and print the result
	   	update the start, mid and end value so that it doesn't repeat itself
	   
	   	once it finishes the loop, check if there are any remaining elements in the array that were not merged in the given loop
	   	merge the remaining elements with the previously merged elements only if there are elements that weren't merged 
	  	double the value of length and go through the loop again
	   
	   	end the program once length becomes greater than that of the length of the array
	    then check if for the previous value of end, if it is lesser than the length of the array. 
	    If it is, merge one more time from the beginning to the previous end value and then to the length of the array
	   

 */
	  
	   int length = 1; // The size of the sorted regions; a power of 2
      int lastEndValue = 0;
      // while the entire array hasn't yet been sorted
      while (length <= a.length)
      {
    	// sort starts at the beginning of the array
         int start = 0; 
         int mid = start+ length-1;
         int end = mid+length;
         
         // for each pair of adjacent regions of the given length
         while (end<a.length)
         {           	
            // merge the pair into a sorted region of size 2 * length
            merge(start, mid, end, a, debug);
        	 
            //updates the values
            start = end+1;
            mid = start+ length-1;
            lastEndValue = end;
            end = mid + length;    
         }
         
         //value of the elements in the array that weren't sorted
         int remainingElements = a.length-lastEndValue-1;
      if(remainingElements>0 && ((2*length)<a.length))
      {
    	  //merge the unsorted part of the array with the part of the array that was sorted last
    	  merge(lastEndValue-(2*length)+1, lastEndValue, a.length-1, a, false);   	
      }
      
// doubles the length
   	  length= 2*length;
         
      }
      
      // if the last merge doesn't merge to atleast a.length-1. then do one more merge for just that case
      if(lastEndValue< a.length-1)
      {
      merge(0,lastEndValue,a.length-1,a,debug);
      }


   }

   /**
      method to print out the result for each situation
      got the code from simply checking out what was given in the textbook
      
      if debug == true then print the wanted message
      
      create an array which can store the values between from and mid
      create another array to store values between mid+1 and to
      
       add elements from the original array to the two arrays based on the index 
       add values from index from -> mid in the first array
       add values from mid+1 -> to in the second array
       
       then store the index value for each array separately and then add the smaller value to the original array
       increment the value of the index of the array from which you took the smaller element
       
       once one of the arrays has run out of elements, simply add the remaining values of the other array into the original array
   */
   public static void merge(int from, int mid, int to, int[] a, boolean debug)
	{
	   /*
		if (debug = true)
		{
			System.out.println("Merging " + from + "..." + mid 
					+ " and " + (mid + 1) + "..." + to);
		}
		*/
		
			int[] firstPart = new int[mid - from + 1];
			for(int i = 0; i < firstPart.length; i++)
			{
				firstPart[i] = a[i + from];
			}
			int[] secondPart = new int[to - mid];
			for(int i = 0; i < secondPart.length; i++)
			{
				secondPart[i] = a[i + mid + 1];
			}

			int iFirst = 0;
			int iSecond = 0;
			int n = from; 
			while (iFirst<firstPart.length && iSecond<secondPart.length)
			{

				if (firstPart[iFirst]<secondPart[iSecond])
				{
					a[n] = firstPart[iFirst];
					iFirst++;
					n++;

				}
				else
				{
					a[n] = secondPart[iSecond];
					iSecond++;	
					n++;
				}

			}
			while(iFirst<firstPart.length)
			{

				a[n] = firstPart[iFirst];
				iFirst++;
				n++;
			}
			while(iSecond<secondPart.length)
			{

				a[n] = secondPart[iSecond];
				iSecond++;
				n++;
			}
		
	}
}

