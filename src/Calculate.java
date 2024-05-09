import java.util.Scanner;

    class Calculate {
        public static void main(String[] args) {

            Scanner read = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ ВЫРАЖЕНИЕ ДВУХ ЧИСЕЛ  ОТ 1 ДО 10 : НАПРИМЕР (5 + 5) ИЛИ (I + V)");

            String inputData = read.nextLine();
            String result = calculator(inputData);
            System.out.println("Результат: " + result);
        }


        public static String calculator(String input) {

            String[] operand = input.split(" ");
            int a, b;
            if (operand.length > 3) {
                throw new IllegalArgumentException("Больше трех операндов");
            }

            try {
                if (isRoman(operand[0]) && isRoman(operand[2])) {

                    a = romanToArabic(operand[0]);
                    b = romanToArabic(operand[2]);

                } else if (!isRoman(operand[0]) && !isRoman(operand[2])) {
                    a = Integer.parseInt(operand[0]);
                    b = Integer.parseInt(operand[2]);
                } else {
                    throw new IllegalArgumentException("Введены неподходящие числа");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Введены неподходящие числа");
            }


            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
            }

            int result;
            switch (operand[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неверная операция");
            }

            if (isRoman(operand[0]) && isRoman(operand[2])) {
                if (result <= 0) {
                    throw new IllegalArgumentException("Результат римской операции меньше 1");
                }
                return arabicToRoman(result);
            } else {
                return String.valueOf(result);
            }
        }

        private static boolean isRoman(String s) {
            return s.equals("I") || s.equals("II") || s.equals("III") || s.equals("IV") ||
                    s.equals("V") || s.equals("VI") || s.equals("VII") || s.equals("VIII") ||
                    s.equals("IX") || s.equals("X");
        }


        private static int romanToArabic(String s) {
            // II
            int result = 0;
            int prevValue = 0;

            for (int i = s.length() - 1; i >= 0; i--) {
                int value = getValue(s.charAt(i));

                if (value < prevValue) {

                    result = result - value;
                } else {
                    result = result + value;
                }
                prevValue = value;
            }
            return result;
        }



        private static int getValue(char romanChar) {
            switch (romanChar) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                default:
                    throw new IllegalArgumentException("Неправильный символ: " + romanChar);
            }
        }

    private static String arabicToRoman(int num) {
        if (num < 1 || num > 100) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 100");
        }
//                                0    1    2      3     4
        String[] romanSymbols = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"};
//                           11
        return romanSymbols[num];
    }
}

