import java.util.Scanner;

public class Day10PowerFunction {
    public static double myPow(double x, int n) {

        double power=powfun(x , Math.abs(n));
        if(n<0)
        {
            return 1/power;
        }
        else
        return power;
    }

    public static double powfun(double x , int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(n==1)
        {
            return x;
        }
        double p=powfun(x,n/2);
        if(n%2==0)
        {
            return (p*p);
        }
        else
        {
            return ((p*p)*x);
        }   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of x :");
        double x=sc.nextDouble();
        System.out.println("Enter the value of n :");
        int n=sc.nextInt();
        sc.close();
        double power=myPow(x,n);
        System.out.println(power);
    }
}
