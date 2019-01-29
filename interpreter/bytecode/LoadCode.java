package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {

    private int offset;
    private String dumpComment;

    public void init(String[] arguments) {
        offset = Integer.parseInt(arguments[1]);
        if(arguments.length == 3) {
            dumpComment = arguments[2];
        }
    }
    public void execute(VirtualMachine vm) { vm.load(offset); }

    public String toString() {
        if (dumpComment != null) {
            return "LOAD " + offset + " int " + dumpComment;
        } else {
            return "LOAD " + offset;
        }
    }
}
