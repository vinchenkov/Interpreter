package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode{

    private int offset;
    private String dumpComment;

    public void init(String[] arguments) {
        offset = Integer.parseInt(arguments[1]);
        if(arguments.length == 3) {
            dumpComment = arguments[2];
        }
    }
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    public String toString() { return "STORE " + offset + " " + dumpComment; }
}
