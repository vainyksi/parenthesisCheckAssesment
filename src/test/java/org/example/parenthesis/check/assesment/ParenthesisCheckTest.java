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
            } else if (isEndParenthesis(character, parenthesisConsumed.peek())) {
                if (parenthesisConsumed.isEmpty()) {
                    return WRONG;
                }
//                if (isCorrectType(character, parenthesisConsumed)) {
//                    return WRONG;
//                }
                parenthesisConsumed.pop();
            }
        }

        return parenthesisConsumed.isEmpty() ? OK : WRONG;
    }

    private static boolean isCorrectType(Character character, Stack<Character> parenthesisConsumed) {
        Character endParenthesis = getEndParenthesisForLastConsumed(parenthesisConsumed.peek());
        return character.equals(endParenthesis);
    }

    private static Character getEndParenthesisForLastConsumed(Character startParenthesis) {
        return switch (startParenthesis) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> ' ';
        };
    }

    private static boolean isEndParenthesis(Character character, Character peek) {
        if (peek.equals('(')) {
            return character.equals(')');
        } else if (peek.equals('[')) {
            return character.equals('}');
        } else if (peek.equals('{')) {
            return character.equals('}');
        }

        return List.of(')', ']', '}').contains(character);
    }

    private static boolean isStartParenthesis(Character character) {
        return List.of('(', '[', '{').contains(character);
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

}
