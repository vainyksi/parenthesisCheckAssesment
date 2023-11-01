package org.example.parenthesisCheckAssesment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.Stack;

public class ParenthesisCheckTest {

    private static final int OK = 1;
    private static final int WRONG = 0;

    public static int checkParenthesis(String str) {
        Stack<Character> parenthesisConsumed = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (isStartCharacter(character)) {
                parenthesisConsumed.push(character);
            } else {
                if (isEndCharacter(character)) {
                    if (parenthesisConsumed.isEmpty()) {
                        return WRONG;
                    }

                    if (isCorrectEnd(character, parenthesisConsumed.peek())) {
                        parenthesisConsumed.pop();
                    }
                }
            }
        }

        return parenthesisConsumed.isEmpty() ? OK : WRONG;
    }

    private static boolean isCorrectEnd(Character character, Character lastOpenParenthesis) {
        if (lastOpenParenthesis.equals('(')) {
            return character.equals(')');
        } else if (lastOpenParenthesis.equals('[')) {
            return character.equals(']');
        } else if (lastOpenParenthesis.equals('{')) {
            return character.equals('}');
        }

        return false;
    }

    private static boolean isEndCharacter(Character character) {
        return Set.of(')', ']', '}').contains(character);
    }

    private static boolean isStartCharacter(Character character) {
        return Set.of('(', '[', '{').contains(character);
    }

    @Test
    void checkParenthesisOrderAndParity() {
        String strPositive = "xxx(aaa)ahoj(tuky[tuk]){hoj}";
        Assertions.assertEquals(OK, checkParenthesis(strPositive));
        String strNegative = "xxx(zz(kk)hh]pp";
        Assertions.assertEquals(WRONG, checkParenthesis(strNegative));
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
        Assertions.assertEquals(OK, checkParenthesis("{a(b[c]b)a}"));
    }

}
