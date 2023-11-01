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
            } else if (isEndParenthesis(character) && !parenthesisConsumed.isEmpty()) {
                parenthesisConsumed.pop();
            }
        }

        return parenthesisConsumed.isEmpty() ? OK : WRONG;

//        if (containsParenthesis(str)) {
//            return checkParenthesisParity(str);
//        } else {
//            return OK;
//        }
    }

    private static boolean isEndParenthesis(Character character) {
        return List.of(')', ']', '}').contains(character);
    }

    private static boolean isStartParenthesis(Character character) {
        return List.of('(', '[', '{').contains(character);
    }

    private static int checkParenthesisParity(String str) {

        return WRONG;
    }

    private static boolean containsParenthesis(String str) {
//        List<Pair> listOfPairs = List.of(
//                new Pair("(", ")"),
//                new Pair("[", "]"),
//                new Pair("{", "}")
//        );
//
//        return str.chars().anyMatch(charIntValue -> listOfPairs.stream().anyMatch(pair -> pair.contains(charIntValue)));

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
