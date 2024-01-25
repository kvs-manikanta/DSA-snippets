import java.util.Scanner;

public class Day10SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        /*
        for(int i=0;i<n;i++)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(target>matrix[i][j])
                {
                    break;
                }
                else if(matrix[i][j]==target)
                {
                    return true ;
                }
                else
                {
                    continue;
                }
            }
        }

        return false;
        */
        int low =0;
        int high=m*n-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int i=mid/m;   //for getting row 
            int j=mid%m;   //for getting column 
            if(matrix[i][j]==target)
            {
                return true;
            }
            else if(matrix[i][j]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return false;  //TC O(log(m*n))
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][]=new int[4][4];
            
        System.out.println("Entere the value of the matrix"+" ");
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat.length;j++)
            {
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the target value :");
        int target=sc.nextInt();
        sc.close();

        boolean res=searchMatrix(mat,target);

        System.out.println(res);
    }
}
