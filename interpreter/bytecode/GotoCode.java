package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends jumpCode {

    private String addrs;
    private int resolvedAddrs;

    public void init(String[] arguments) {
        addrs = arguments[1];
    }
    public void execute(VirtualMachine vm) {
        vm.setPC(resolvedAddrs - 1);
    }

    public String getAddrs() {
        return addrs;
    }
    public void setResolvedAddrs(int addrs) {
        resolvedAddrs = addrs;
    }

    public String toString() { return "GOTO " + addrs; }
}
