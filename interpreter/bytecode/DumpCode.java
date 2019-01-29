package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {

    private boolean isDumping;

    public void init(String[] arguments) {
        String dumpSwitch = arguments[1];

        if(dumpSwitch == "ON") { isDumping = true; }
        else { isDumping = false; }
    }
    public void execute(VirtualMachine vm) {
        vm.setIsDumping(isDumping);
    }

    public String toString() { return null; }
}
