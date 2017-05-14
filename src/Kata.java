/**
 * Kata 12/05/2017
 */
public class Kata {
    public static String HighAndLow(String numbers) {
        // Code here or
        int max;
        int min;
        String[] numbersSplit = numbers.split(" ");
        if(numbersSplit.length == 1){
            return (numbersSplit[0] + " " + numbersSplit[0]);
        }
        else {
            max = Math.max(Integer.parseInt(numbersSplit[0]), Integer.parseInt(numbersSplit[1]));
            min = Math.min(Integer.parseInt(numbersSplit[0]), Integer.parseInt(numbersSplit[1]));
            if (numbersSplit.length == 3){
                int thirdNumber = Integer.parseInt(numbersSplit[2]);
                max = Math.max(max, thirdNumber);
                min = Math.min(min, thirdNumber);
            } else {
                for (int i = 2; i < (numbersSplit.length - 1); i++) {
                    int firstNumber = Integer.parseInt(numbersSplit[i]);
                    int secondNumber = Integer.parseInt(numbersSplit[i + 1]);
                    if (firstNumber < secondNumber) {
                        min = Math.min(min, firstNumber);
                        max = Math.max(max, secondNumber);
                    } else {
                        //Note, this will also catch if firstNumber == secondNumber (this will still carry out the necessary comparison
                        min = Math.min(min, secondNumber);
                        max = Math.max(max, firstNumber);
                    }
                }
            }
            return max + " " + min;
        }
    }

    public static void main(String[] args) {
        Kata test = new Kata();
        System.out.println(test.HighAndLow("1 2 3 4 5"));
        System.out.println(test.HighAndLow("1 2 -3 4 5"));
        System.out.println(test.HighAndLow("1 9 3 4 -5"));
        System.out.println(test.HighAndLow("1"));
        System.out.println(test.HighAndLow("-1 -1 0"));
        System.out.println(Math.max(0, -1));
        System.out.println(test.HighAndLow("0 1 1"));
    }
}
