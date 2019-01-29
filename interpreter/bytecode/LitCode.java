package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {

    private int intToLoad;
    private String dumpComment;

    public void init(String[] arguments) {
        intToLoad = Integer.parseInt(arguments[1]);
        if (arguments.length == 3) {
            dumpComment = arguments[2];
        }
    }

    public void execute(VirtualMachine vm) {
        vm.push(intToLoad);
    }

    public String toString() {
        if (dumpComment != null) {
            return "LIT " + intToLoad + " int " + dumpComment;
        } else {
            return "LIT " + intToLoad;
        }
    }
}