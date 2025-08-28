import java.util.Scanner;

public class AverageNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter count of numbers: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += sc.nextInt();
        }
        System.out.println("Average = " + (sum / (double)n));
        sc.close();
    }
}
