import java.util.*;

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
        // Initialise lstOf1stLetter as a HashMap to log counts and initialise output string
        String listPairSummaryString = "";
        Map<Character, Integer> categories = new HashMap<>();

        /*If either of the input string arrays are blank, return an empty array or progress to stock search/add process*/
        if (lstOf1stLetter.length == 0 && lstOfArt.length == 0) {
            return "";
        } else if (lstOfArt.length == 0) {
            return "";
        } else if (lstOf1stLetter.length == 0) {
            return "";
        } else {
            for (int i = 0; i < lstOf1stLetter.length; i++) {
                categories.put(lstOf1stLetter[i].charAt(0), 0);
            }
        }

        // Confirm number length based on first book code entry
        boolean endOfNumber = false;
        int lengthOfNum = 1;
        while (!endOfNumber) {
            if (Character.isDigit(lstOfArt[0].charAt(lstOfArt[0].length() - (lengthOfNum + 1)))) {
                lengthOfNum += 1;
            } else {
                endOfNumber = true;
            }
        }


            //Loop through each book code in stock and add corresponding stock count to hashmap values
            for (int i = 0; i < lstOfArt.length; i++) {
                char artCategory = lstOfArt[i].charAt(0);
                int artStockCount = Integer.parseInt(lstOfArt[i].substring((lstOfArt[i].length() - lengthOfNum), lstOfArt[i].length()));

                //If the value is in the hashmap already, find the value and increase by the specific book's stock count, otherwise set the stock count to the specific book's count
                if (categories.containsKey(artCategory)){
                    categories.put(artCategory, categories.get(artCategory) + artStockCount);
                } else {
                    categories.put(artCategory, artStockCount);
                }
            }

        //Format output string and return
        for(int i = 0; i < lstOf1stLetter.length; i++) {
            listPairSummaryString += "(" + lstOf1stLetter[i] + " : " + categories.get(lstOf1stLetter[i].charAt(0)) + ") - ";
        }
        listPairSummaryString = listPairSummaryString.substring(0, (listPairSummaryString.length() - 3));
        return listPairSummaryString;
    }

    public static void main(String[] args) {
        String[] L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] L2 = {"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String [] M = {"A", "C", "B", "W"};
        String[] M2 = {};
        String[] L3 = {};
        System.out.println(StockList.stockSummary(L, M));
        System.out.println(StockList.stockSummary(L, M2));
        System.out.println(StockList.stockSummary(L3, M));
    }
}
