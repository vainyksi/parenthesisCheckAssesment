package org.example.parenthesis.check.assesment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

public class ParenthesisCheckTest {

    private static final int OK = 1;
    private static final int WRONG = 0;

    public static int checkParenthesis(String str) {
        Stack<Character> parenthesisConsumed = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (isStartParenthesis(character)) {
                parenthesisConsumed.push(character);
            } else if (isEndParenthesisOfPreviouslyCOnsumed(character, parenthesisConsumed)) {
                if (parenthesisConsumed.isEmpty()) {
                    return WRONG;
                }
                parenthesisConsumed.pop();
            }
        }

        return parenthesisConsumed.isEmpty() ? OK : WRONG;
    }

    private static boolean isEndParenthesisOfPreviouslyCOnsumed(Character character, Stack<Character> consumed) {
        return List.of(')', ']', '}').contains(character);
    }

    private static boolean isStartParenthesis(Character character) {
        return List.of('(', '[', '{').contains(character);
    }

    private static int checkParenthesisParity(String str) {

        return WRONG;
    }

    private static boolean containsParenthesis(String str) {

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

    @Test
    void checkMultipleParenthesisAreOk() {
        Assertions.assertEquals(OK, checkParenthesis("()[]{}"));
        Assertions.assertEquals(OK, checkParenthesis("(aa)aa[aa]aa{aa}"));
    }

    @Test
    void checkCombinedParenthesisAreOk() {
        Assertions.assertEquals(OK, checkParenthesis("{([])}"));
        Assertions.assertEquals(OK, checkParenthesis("{a(b[c]b)a}"));
    }

    @Test
    void checkCombinedParenthesisAreWrong() {
        Assertions.assertEquals(WRONG, checkParenthesis("([)]"));
//        Assertions.assertEquals(OK, checkParenthesis("{a(b[c]b)a}"));
    }

    private static class Pair {
        final char start;
        final char end;

        public Pair(char start, char end) {
            this.start = start;
            this.end = end;
        }

        public Pair(String start, String end) {
            this.start = start.charAt(0);
            this.end = end.charAt(0);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public boolean contains(int charIntValue) {
            return this.start == charIntValue || this.end == charIntValue;
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
