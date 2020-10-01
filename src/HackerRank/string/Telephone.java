package HackerRank.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c59785a
 * Created on 2020-09-24 19:56
 *
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 **/
public class Telephone {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<String>();

        if(digits == null || digits.length() ==0){
            return result;
        }
        String[] mapping = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        createCombos(digits, result, mapping, 0,""   );
        return result;

    }

    private void createCombos(String digits, List<String> result,String[] mapping, int index, String current ) {

        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) -'0'];

        for(int i =0; i< letters.length(); i++){
            createCombos(digits,result,mapping, index+1,  current+ letters.charAt(i));
        }

    }

}
