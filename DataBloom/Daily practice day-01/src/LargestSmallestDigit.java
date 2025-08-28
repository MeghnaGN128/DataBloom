public class LargestSmallestDigit {
    public static void main(String[] args) {
        int num = 593286;
        int largest = 0, smallest = 9;
        while (num > 0) {
            int d = num % 10;
            if (d > largest) largest = d;
            if (d < smallest) smallest = d;
            num /= 10;
        }
        System.out.println("Largest digit = " + largest);
        System.out.println("Smallest digit = " + smallest);
    }
}
