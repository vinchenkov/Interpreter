package interpreter.bytecode;

import interpreter.VirtualMachine;

abstract public class ByteCode {

    public abstract void init(String[] arguments);
    public abstract void execute(VirtualMachine vm);
}
