package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {

    private String operator = "";

    public void init(String[] arguments) {
        operator = arguments[1];
    }
    public void execute(VirtualMachine vm) {
        int op2 = vm.pop();
        int op1 = vm.pop();

        int returnValue = 0;

        switch (operator) {
            case "+":
                returnValue = op1 + op2;
                break;
            case "-":
                returnValue = op1 - op2;
                break;
            case "*":
                returnValue = op1 * op2;
                break;
            case "/":
                returnValue = op1 / op2;
                break;
            case "==":
                if (op1 == op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case "!=":
                if (op1 != op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case "<=":
                if (op1 <= op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case ">":
                if (op1 > op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case ">=":
                if (op1 >= op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case "<":
                if (op1 < op2) {
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case "|":
                returnValue = (op1 | op2);
                break;
            case "&":
                returnValue = (op1 & op2);
                break;
        }

        vm.push(returnValue);
    }

    public String toString() {
        return "BOP " + operator;
    }
}
