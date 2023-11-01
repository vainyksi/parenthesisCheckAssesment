package org.example.parenthesis.check.assesment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParenthesisCheckTest {

    private static final int OK = 1;
    private static final int WRONG = 0;

    public static int checkParenthesis(String str) {
        ArrayList<ParenthesisPair> parenthesisPairs = new ArrayList<ParenthesisPair>();
        parenthesisPairs
        return str.contains();
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

    private static class ParenthesisPair {
    }
}
