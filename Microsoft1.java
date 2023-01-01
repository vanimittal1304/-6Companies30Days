import java.util.Stack;

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Normal : 2+3=5
// RPN : 23+=5
// normal : 12-2+5=15
// RPN : 122-5+=15

// we will be using stack data structure

// st[]
// for t in tokens:
// if t in "+-*/":
// opd2=st.pop()
// opd1=st.pop()
// st.append(eval(opd1, opd2, t))
// else
// st.append(int(t))

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for (String t : tokens) {
            if ("+-*/".contains(t))
                st.push(eval(st.pop(), st.pop(), t));
            else
                st.push(Integer.parseInt(t));
        }
        return st.pop();
    }

    private int eval(int b, int a, String op) {
        if ("+".equals(op))
            return a + b;
        else if ("-".equals(op))
            return a - b;
        else if ("*".equals(op))
            return a * b;
        else
            return a / b;

    }
}
