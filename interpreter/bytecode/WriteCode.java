package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {

    public void init(String[] arguments) {
        return;
    }
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    public String toString() { return "WRITE"; }
}
