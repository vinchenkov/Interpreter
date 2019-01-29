package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends jumpCode {

    private String addrs;
    private int resolvedAddrs;
    private int[] commentArguments = new int[5];
    int numOfcommentArgs;

    public void init(String[] arguments) {
        addrs = arguments[1];
    }
    public void execute(VirtualMachine vm) {
        int returnAddrs = vm.getPc();
        vm.pushReturnAddrs(returnAddrs);
        vm.setPC(resolvedAddrs - 1);
        //Prepare code for toString
        numOfcommentArgs =  vm.stackSize() - vm.peekFramePointer();
        for(int i = 0; i < numOfcommentArgs; i++) {
            commentArguments[i] = vm.getArg(i);
        }

    }

    public String getAddrs() {
        return addrs;
    }
    public void setResolvedAddrs(int addrs) {
        resolvedAddrs = addrs;
    }

    public String toString() {
        //Prepare dumpComment
        String functionString = "f(";
        for(int i = 0 ; i < numOfcommentArgs; i++ ) {
            if(numOfcommentArgs == 1 || i == numOfcommentArgs - 1) {
                functionString += commentArguments[i];
            }
            else {
                functionString += commentArguments[i] + ",";
            }
        }
        functionString += ")";
        return "CALL " + addrs + " " + functionString;
    }
}