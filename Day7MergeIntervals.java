import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Day7MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        //Sort the intervals array based on start time if equal sort based in end time 
        Arrays.sort(intervals , new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2)
            {
                if(i1[0]!=i2[0])
                {
                    return i1[0]-i2[0];
                }
                return i1[1]-i2[1];
            }
        });
        int n=intervals.length;

        //take array list of integer to store the mnerge intervals 
        //if i1.end >= i2.start that means both are overlapping which can be merged 

        ArrayList<int[]> mergeintervals=new ArrayList<>();
        
        int[] currinterval=intervals[0];
        for(int i=1;i<n;i++)
        {
            int[] nextinterval=intervals[i];
            if(currinterval[1]<nextinterval[0])
            {
                mergeintervals.add(currinterval);
                currinterval=nextinterval;
            }
            else
            {
                currinterval[0]=Math.min(currinterval[0],nextinterval[0]);
                currinterval[1]=Math.max(currinterval[1],nextinterval[1]);
            }
        }
        mergeintervals.add(currinterval);

        int[][] resultintervals=new int[mergeintervals.size()][2];
        for(int i=0;i<mergeintervals.size();i++)
        {
            resultintervals[i]=mergeintervals.get(i);
        }

        return resultintervals;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions of the 2D array
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create the 2D array
        int[][] A= new int[rows][columns];

        // Input elements for the 2D array
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("Enter element at position (%d, %d): ", i, j);
                A[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int[][] result=merge(A);

        for(int i=0;i<result.length;i++)
        {
            for(int j=0;j<result[0].length;j++)
            {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
