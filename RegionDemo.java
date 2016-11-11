public class RegionDemo
{
   public static void main(String[] args)
   {
      System.out.println("Array of length 4: ");
      MergeSorter.sort(new int[4], true);
      System.out.println("Array of length 15: ");
      MergeSorter.sort(new int[15], true);
      System.out.println("Array of length 20: ");
      MergeSorter.sort(new int[20], true);
   }
}