package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    int numOfPops;

    public void init(String[] arguments) {
        numOfPops = Integer.parseInt(arguments[1]);
    }
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < numOfPops; i++) {
            vm.pop();
        }
    }

    public String toString() { return "POP " + numOfPops; }
}
