package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int offset;

    public void init(String[] arguments) {
        offset = Integer.parseInt(arguments[1]);
    }
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(offset);
    }

    public String toString() {
        return "ARGS " + offset;
    }
}
