package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
    private String label = "";

    public void init(String[] arguments) {
        label =  arguments[1];
    }
    public void execute(VirtualMachine vm) {
        return;
    }

    public String getLabel () { return label; }
    public String toString() { return "LABEL " + label; }
}

