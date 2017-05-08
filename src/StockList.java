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
        // Variable initialisation
        String listPairSummaryString = "";
        int[] categoryCount = new int[lstOf1stLetter.length];
        Arrays.sort(lstOfArt);
        Arrays.sort(lstOf1stLetter);

        // Confirm number length based on first book code entry
        boolean endOfNumber = false;
        int lengthOfNum = 1;
        while (!endOfNumber){
            if (Character.isDigit(lstOfArt[0].charAt(lstOfArt[0].length() - (lengthOfNum + 1)))){
                lengthOfNum += 1;
            } else {
                endOfNumber = true;
            }
        }

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return listPairSummaryString;
        } else {
            //Convert lstOf1stLetter to a char array and setup integer of category count (note charArray indices will correspond to category count indices)
            String stringOf1stLetter = "";
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                stringOf1stLetter += lstOf1stLetter[i];
                categoryCount[i] = 0;
            }
            char[] charArray = stringOf1stLetter.toCharArray();
            categoryCount = new int[charArray.length];

            //Loop through each book code in stock and
            for (int i = 0; i < lstOfArt.length; i++) {
                char artCategory = lstOfArt[i].charAt(0);
                int artStockCount = Integer.parseInt(lstOfArt[i].substring((lstOfArt[i].length() - lengthOfNum), lstOfArt[i].length()));

                //Binary search the artCategory from within the lstOf1stLetter array
                int foundCategoryIndex = Arrays.binarySearch(charArray, artCategory);
                if (foundCategoryIndex > -1) {
                    categoryCount[foundCategoryIndex] += artStockCount;
                }
            }
        }

        //Format output string and return
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            if (i < (lstOf1stLetter.length -1)) {
                listPairSummaryString += "(" + lstOf1stLetter[i] + " : " + categoryCount[i] + ") - ";
            } else {
                listPairSummaryString += "(" + lstOf1stLetter[i] + " : " + categoryCount[i] + ")";
            }
        }
        System.out.println(listPairSummaryString);
        return listPairSummaryString;
        }

    public static void main(String[] args) {
        String[] L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String [] M = {"A", "C", "B", "W"};
        StockList.stockSummary(L, M);
    }
}
