import java.util.Scanner;

public class Day6RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        //Do the transpose of matrix 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                
            }
        }

        //To get the rotated matrix now reverse the each row of matrix 
        //when j=0 swapping with last of the same row happens till 1/2 the array for revrsing 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][((m-1)-j)];
                matrix[i][((m-1)-j)]=temp;
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int mat[][]=new int[4][4];
            
            System.out.println("Entere the value of the matrix"+" ");
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat.length;j++)
                {
                    mat[i][j]=sc.nextInt();
                }
            }

            rotate(mat);
            System.out.println("The rotated matrix"+" ");
            for(int i=0;i<mat.length;i++)
            {
                for(int j=0;j<mat.length;j++)
                {
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
}
