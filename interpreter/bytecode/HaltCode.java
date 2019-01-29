package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {

    public void init(String[] arguments) {
        return;
    }
    public void execute(VirtualMachine vm) {
        vm.setIsRunning(false);
    }

    public String toString() { return "HALT"; }
}
