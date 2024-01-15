public class DAY1SetZerosOfMatrix {
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        /*
        int row[]=new int[matrix[0].length];
        int col[]=new int[matrix.length];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[j]=1;
                    col[i]=1;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]!=0)
                {
                    if(row[j]==1 || col[i]==1)
                    {
                        matrix[i][j]=0;
                    }
                }
            }
        }
        */

        int col0=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {

                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0; //marking cols arrays
                    if(j!=0)
                    {
                        matrix[0][j]=0; //marking rows array
                    }
                    else
                    col0=0;  //edge case for first col
                }
            }
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j]!=0)
                {
                    if(matrix[i][0]==0 || matrix[0][j]==0)
                    {
                        matrix[i][j]=0;
                    }
                }
                
            }
        }
        if(matrix[0][0]==0)
        {
            for(int i=0;i<m;i++)
            {
                matrix[0][i]=0;
            }
        }
        if(col0==0)
        {
            for(int i=0;i<n;i++)
            {
                matrix[i][0]=0;
            }
        }

    }

    public static void main(String[] args) {
        int matrix[][]=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(i==j)
                {
                    matrix[i][j]=0;
                }
                else
                matrix[i][j]=1;
            }
        }
        matrix[2][2]=1;
        setZeroes(matrix);
        
        System.out.println("Answer array is :"+ " ");
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
