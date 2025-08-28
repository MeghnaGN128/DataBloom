public class StrongNumber {
    public static void main(String[] args) {
        int num = 145, temp = num, sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            int fact = 1;
            for (int i = 1; i <= d; i++) fact *= i;
            sum += fact;
            temp /= 10;
        }

        if (sum == num)
            System.out.println(num + " is a Strong Number");
        else
            System.out.println(num + " is not a Strong Number");
    }
}
