import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jlee512 on 8/05/2017.
 * CW -Problem: "Help the Bookseller!"
 */

public class StockList {

    // @param lstOfArt is the stocklist (L in example),
    // @param lstOf1stLetter is list of categories (M in example)
    //This function compares a string list of book codes with a string array of categories to assess how many books within each category are included in the fulll book list


    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        // New code here
        String listPairSummaryString = "";
        Arrays.sort(lstOfArt);
        Arrays.sort(lstOf1stLetter);

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return listPairSummaryString;
        } else {
            System.out.println(lstOfArt);
            System.out.println(lstOf1stLetter);

        }
        return listPairSummaryString;
    }

    public static void main(String[] args) {
        String[] L = Keyboard
        StockList test = new StockList();
    }
}
