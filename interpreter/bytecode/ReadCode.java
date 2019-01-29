package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.Scanner;

public class ReadCode extends ByteCode {

    public void init(String[] arguments) {
        return;
    }
    public void execute(VirtualMachine vm) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int valueRead = userInput.nextInt();
        vm.push(valueRead);
    }

    public String toString() { return "READ"; }
}
