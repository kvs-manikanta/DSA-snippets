import java.util.Scanner;

public class Day12GridUniquePaths {
    public static int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 ||j==0)
                {
                    dp[i][j]=1;
                }
                else
                dp[i][j]=-1;
            }
        }
        

        return getPaths(m-1,n-1,dp);
    }

    public static int getPaths(int m, int n,int dp[][])
    {
        if(n<0 || m<0)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        dp[m][n]=getPaths(m-1,n,dp)+getPaths(m,n-1,dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the values of m and n : ");
        int m=sc.nextInt();
        int n=sc.nextInt();
        sc.close();
        int ways=uniquePaths(m,n);

        System.out.println("No of ways is :"+ways);
    }
}
