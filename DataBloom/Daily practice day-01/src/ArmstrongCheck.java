public class ArmstrongCheck {
    public static void main(String[] args) {
        int num = 153; // change number
        int original = num, sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, 3);
            num /= 10;
        }

        if (sum == original)
            System.out.println(original + " is an Armstrong number.");
        else
            System.out.println(original + " is NOT an Armstrong number.");
    }
}
