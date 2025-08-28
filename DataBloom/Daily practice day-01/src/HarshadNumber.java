public class HarshadNumber {
    public static void main(String[] args) {
        int num = 156;
        int temp = num, sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        if (num % sum == 0)
            System.out.println(num + " is a Harshad Number");
        else
            System.out.println(num + " is not a Harshad Number");
    }
}
