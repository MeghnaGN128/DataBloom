public class SumEvenOddDigits {
    public static void main(String[] args) {
        int num = 54873;
        int evenSum = 0, oddSum = 0;
        while (num > 0) {
            int d = num % 10;
            if (d % 2 == 0) evenSum += d;
            else oddSum += d;
            num /= 10;
        }
        System.out.println("Sum of even digits = " + evenSum);
        System.out.println("Sum of odd digits = " + oddSum);
    }
}
