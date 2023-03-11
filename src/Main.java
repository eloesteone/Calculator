import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char operator;
        System.out.println("Choose operator: +, -, *, /");
        operator = sc.next().charAt(0);

        System.out.println("Enter first number");
        double n1 = sc.nextDouble();

        System.out.println("Enter second number");
        double n2 = sc.nextDouble();

        switch (operator){
            case '+':
                System.out.println(n1+n2);
                break;
            case '-':
                System.out.println(n1-n2);
                break;
            case '*':
                System.out.println(n1*n2);
                break;
            case '/':
                System.out.println(n1/n2);
                break;
            default:
                System.out.println("Invalid");

        }
    }
}