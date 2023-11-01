package org.example.parenthesis.check.assesment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisCheckTest {

    private static final int OK = 1;
    private static final int WRONG = 0;

    public static int checkParenthesis(String str) {
        if (containsParenthesis(str)) {
            return checkParenthesisParity(str);
        } else {
            return OK;
        }
    }

    private static int checkParenthesisParity(String str) {


        return WRONG;
    }

    private static boolean containsParenthesis(String str) {
        List<Pair> listOfPairs = List.of(
                new Pair("(", ")"),
                new Pair("[", "]"),
                new Pair("{", "}")
        );

//        str.chars().forEach(System.out::println);
//        listOfPairs.get(0).start.chars().forEach(System.out::println);
        System.out.println(str);
        System.out.println(listOfPairs);
        System.out.println(
            str.chars().anyMatch(value -> listOfPairs.contains(value))
        );

        return str.contains("(")
                || str.contains(")")
                || str.contains("[")
                || str.contains("]")
                || str.contains("{")
                || str.contains("}");
    }

    @Test
    void checkParenthesisOrderAndParity() {
        String strPositive = "xxx(aaa)ahoj(tuky[tuk]){hoj}";
        String strNegative = "xxx(zz(kk)hh]pp";
    }

    @Test
    void checkEmptyString() {
        Assertions.assertEquals(OK, checkParenthesis(""));
    }

    @Test
    void checkParenthesisNotClosed() {
        Assertions.assertEquals(WRONG, checkParenthesis("("));
        Assertions.assertEquals(WRONG, checkParenthesis(")"));
        Assertions.assertEquals(WRONG, checkParenthesis("["));
        Assertions.assertEquals(WRONG, checkParenthesis("]"));
        Assertions.assertEquals(WRONG, checkParenthesis("{"));
        Assertions.assertEquals(WRONG, checkParenthesis("}"));
    }

    @Test
    void checkBasicParenthesisAreOk() {
        Assertions.assertEquals(OK, checkParenthesis("()"));
    }

    private static class Pair {
        final String start;
        final String end;

        public Pair(String start, String end) {
            this.start = start;
            this.end = end;
        }

        //        ArrayList<ParenthesisPair> parenthesisPairs = new ArrayList<ParenthesisPair>();
//        for (ParenthesisPair parenthesisPair : parenthesisPairs) {
//            if (str.contains(parenthesisPair.getStart())
//                    && str.contains(parenthesisPair.getEnd())) {
//                return OK;
//            }
//        }
    }
}
