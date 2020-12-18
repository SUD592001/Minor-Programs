public class Analyzer {
    //Method that uses linear searching to return index of element.
    public static int linearSearch(String[] dataSet, String element)

    {
        for(int i=0;i< dataSet.length; i++)

            if(element.equals(dataSet[i]))

                return i;

        return -1;

    }
    //Method that uses binary searching to return index of element
    public static int binarySearch(String[] dataSet, String element)
    {
        int low = 0,high = dataSet.length-1;
        int mid;
        while(low <=high)
        {
            mid = (low+high)/2;
            if(dataSet[mid].equals(element))
                return mid;
            else if(element.compareTo(dataSet[mid]) < 0)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    //Main method that executes linear and search methods and prints results to screen.
    public static void main(String[] args)
    {
        String dataSet[] = StringData.getData(); //1
        long beginning = System.nanoTime();
        int index = linearSearch(dataSet,"not_here");
        long end = System.nanoTime();
        //If- else statements to print out results based on whether index is -1 or not.
        if(index == -1)
            System.out.println("Linear Search : not_here not present with index at " +index+ ". Time taken : "+(end - beginning));
        else
            System.out.println("Linear Search : not_here present at"+index+". Time taken : "+(end - beginning));
        beginning = System.nanoTime();
        index =binarySearch(dataSet,"not_here");
        end = System.nanoTime();
        if(index == -1)
            System.out.println("Binary Search : not_here not present at " +index+ ". Time taken : "+(end - beginning));
        else
            System.out.println("Binary Search : not_here present at "+index+". Time taken : "+(end - beginning));
        beginning = System.nanoTime();
        index = linearSearch(dataSet,"mzzzz");
        end = System.nanoTime();
        if(index == -1)

            System.out.println("Linear Search : mzzzz not present. Time taken : "+(end - beginning));
        else
            System.out.println("Linear Search : mzzzz present at "+index+". Time taken : "+(end - beginning));
        beginning = System.nanoTime();
        index = binarySearch(dataSet,"mzzzz");
        end = System.nanoTime();
        if(index == -1)
            System.out.println("Binary Search : mzzzz not present. Time taken : "+(end - beginning));
        else
            System.out.println("Binary Search : mzzzz present at "+index+". Time taken : "+(end - beginning));
        beginning = System.nanoTime();
        index = linearSearch(dataSet,"aaaaa");
        end = System.nanoTime();
        if(index == -1)
            System.out.println("Linear Search : aaaaa not present. Time taken : "+(end - beginning));
        else
            System.out.println("Linear Search : aaaaa present at "+index+". Time taken : "+(end - beginning));
        beginning = System.nanoTime();
        index =binarySearch(dataSet,"aaaaa");
        end = System.nanoTime();
        if(index == -1)
            System.out.println("Binary Search : aaaaa not present. Time taken : "+(end - beginning));
        else
            System.out.println("Binary Search : aaaaa present at "+index+". Time taken : "+(end - beginning));
    }
}