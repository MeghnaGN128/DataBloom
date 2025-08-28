public class CountCharacters {
    public static void main(String[] args) {
        String str = "Hello World 123";
        int vowels = 0, consonants = 0, digits = 0, spaces = 0;

        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            } else if (ch >= '0' && ch <= '9') digits++;
            else if (ch == ' ') spaces++;
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Whitespaces: " + spaces);
    }
}