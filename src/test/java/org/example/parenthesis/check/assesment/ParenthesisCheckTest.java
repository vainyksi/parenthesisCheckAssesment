package org.example.parenthesis.check.assesment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        return str.contains("(")
                || str.contains(")");
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
    void checkBasicParenthesisNotClosed() {
        Assertions.assertEquals(WRONG, checkParenthesis("("));
    }

    @Test
    void checkBasicParenthesisAreOk() {
        Assertions.assertEquals(OK, checkParenthesis("()"));
    }

    private static class ParenthesisPair {
        //        ArrayList<ParenthesisPair> parenthesisPairs = new ArrayList<ParenthesisPair>();
//        for (ParenthesisPair parenthesisPair : parenthesisPairs) {
//            if (str.contains(parenthesisPair.getStart())
//                    && str.contains(parenthesisPair.getEnd())) {
//                return OK;
//            }
//        }
    }
}
