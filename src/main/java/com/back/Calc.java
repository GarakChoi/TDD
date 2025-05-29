package com.back;

import java.util.*;

public class Calc {
    public static int run(String expression) {
        List<String> tokens = new ArrayList<>(Arrays.asList(expression.split(" ")));

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/")) {
                int left = Integer.parseInt(tokens.get(i - 1));
                int right = Integer.parseInt(tokens.get(i + 1));
                int result;

                if (token.equals("*")) {
                    result = left * right;
                } else {
                    result = left / right;
                }

                tokens.set(i - 1, String.valueOf(result));
                tokens.remove(i);
                tokens.remove(i);
                i--;
            }
        }

        int result = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String nums = tokens.get(i);
            int num = Integer.parseInt(tokens.get(i + 1));

            if (nums.equals("+")) {
                result += num;
            } else if (nums.equals("-")) {
                result -= num;
            }
        }

        return result;
    }
}



//package com.back;
//
//public class Calc {
//    private static String[] tokens;
//    private static int index;
//
//    public static int run(String expression) {
//        tokens = expression.replace("(", " ( ").replace(")", " ) ").trim().split("\\s+");
//        index = 0;
//        return parseExpression();
//    }
//
//    // expression ::= term ( ('+' | '-') term )*
//    private static int parseExpression() {
//        int result = parseTerm();
//        while (index < tokens.length) {
//            String op = tokens[index];
//            if (op.equals("+") || op.equals("-")) {
//                index++;
//                int right = parseTerm();
//                result = op.equals("+") ? result + right : result - right;
//            } else {
//                break;
//            }
//        }
//        return result;
//    }
//
//    // term ::= factor ( ('*' | '/') factor )*
//    private static int parseTerm() {
//        int result = parseFactor();
//        while (index < tokens.length) {
//            String op = tokens[index];
//            if (op.equals("*") || op.equals("/")) {
//                index++;
//                int right = parseFactor();
//                if (op.equals("*")) {
//                    result *= right;
//                } else {
//                    if (right == 0) throw new ArithmeticException("Division by zero");
//                    result /= right;
//                }
//            } else {
//                break;
//            }
//        }
//        return result;
//    }
//
//
//    private static int parseFactor() {
//        String token = tokens[index++];
//        if (token.equals("(")) {
//            int value = parseExpression();
//            if (!tokens[index++].equals(")")) {
//                throw new RuntimeException("Missing closing parenthesis");
//            }
//            return value;
//        } else if (token.equals("-")) {
//            return -parseFactor();
//        } else {
//            return Integer.parseInt(token);
//        }
//    }
//}

