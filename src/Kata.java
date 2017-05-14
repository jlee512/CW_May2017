/**
 * Kata 12/05/2017
 */
public class Kata {
    public static String HighAndLow(String numbers) {
        // Code here or
        int max;
        int min;
        String[] numbersSplit = numbers.split()
        if(numbers.length() == 1){
            return (numbers + numbers);
        }
        else {
            max = Math.max(Integer.parseInt(numbers.substring(0, 0)), Integer.parseInt(numbers.substring(1,1)));
            min = Math.min(Integer.parseInt(numbers.substring(0, 0)), Integer.parseInt(numbers.substring(1,1)));
            for (int i = 2; i < (numbers.length() - 1); i++) {
                int firstNumber = Integer.parseInt(numbers.substring(i,i));
                int secondNumber = Integer.parseInt(numbers.substring(i + 1, i + 1));
                if (firstNumber < secondNumber){
                    min = Math.min(min, firstNumber);
                    max = Math.max(max, secondNumber);
                } else {
                    //Note, this will also catch if firstNumber == secondNumber (this will still carry out the necessary comparison
                    min = Math.min(min, secondNumber);
                    max = Math.max(max, firstNumber);
                }
            }
            return max + " " + min;
        }
    }

    public static void main(String[] args) {
        Kata test = new Kata();
        test.HighAndLow("1 2 3 4 5");
        test.HighAndLow("1 2 -3 4 5");
        test.HighAndLow("1 9 3 4 -5");
    }
}
