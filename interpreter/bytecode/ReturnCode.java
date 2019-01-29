package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {

    private String dumpComment;

    public void init(String[] arguments) {
        if(arguments.length == 2) {
            dumpComment = arguments[1];
        }
    }
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        int returnAddrs = vm.popReturnAddrs();
        vm.setPC(returnAddrs);
    }

    public String toString() { return "RETURN"; }
}
