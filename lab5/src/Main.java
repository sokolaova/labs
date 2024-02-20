import java.util.Scanner;

class maths{
    double x;
    double a;
    double b;
    maths (double x, double a, double b){
        this.x = x;
        this.a = a;
        this.b = b;
    }
    double factorial(double m) {
        double res = 1;
        if (m == 0) {
            res = 1;
        }
        else{
        for (double i = 1; i <= m; i++) {
            res = res * i;
        }}
        return res;
    }
    double virazjenie1(double x){
        return 3*x+5;
    }
    double virazjenie2(double a, double b) {
        if ((a - b) == 0) {
            System.out.println("You can't divide by zero");
        }
            return (a + b) / (a - b);

    }

        double virazjenie3(double x, double a, double b){
            if (b == 0) {
                System.out.println("You can't divide by zero");
            }
        return factorial((a*x/b));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n1) y = 3*x+5 \n Enter x: ");
        double x = input.nextDouble();
        double a = 0;
        double b = 0;
        maths vir1 = new maths(x, a, b);
        System.out.printf("\n y = %f", vir1.virazjenie1(x));

        x = 0;
        System.out.println("\n2) y = (a+b)/(a-b) \n Enter a: ");
        a = input.nextDouble();
        System.out.println("Enter b: ");
        b = input.nextDouble();
        maths vir2 = new maths(x, a, b);
        System.out.printf("\n y = %f", vir2.virazjenie2(a, b));

        System.out.println("\n3) y = (a*x/b)! \n Enter x: ");
        x = input.nextDouble();
        System.out.println("Enter a: ");
        a = input.nextDouble();
        System.out.println("Enter b: ");
        b = input.nextDouble();
        maths vir3 = new maths(x, a, b);
        System.out.printf("\n y = %f", vir3.virazjenie3(x, a, b));
        }
    }
