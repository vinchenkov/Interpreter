package interpreter;

import interpreter.bytecode.*;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping; //LOL

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if( !(code instanceof DumpCode) && isDumping) {
                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }
    }

    //VM data getters and setters
    public int popReturnAddrs() { return returnAddrs.pop(); }
    public void pushReturnAddrs(int i){ returnAddrs.push(i); }
    public int getPc() { return pc; }
    public void setPC(int i) { pc = i; }
    public void setIsRunning(boolean value) { this.isRunning = value; }
    public void setIsDumping(boolean value) { this.isDumping = value; }

    //RunTimeStack interface methods
    public int stackSize(){ return runStack.stackSize(); }
    public int peek() { return runStack.peek(); }
    public int pop() { return runStack.pop(); }
    public int push(int i) { return runStack.push(i); }
    public void newFrameAt(int offset){ runStack.newFrameAt(offset); }
    public void popFrame() { runStack.popFrame(); }
    public int peekFramePointer() { return runStack.peekFramePointer(); }
    public int store(int offset) { return runStack.store(offset); }
    public int load(int offset) { return runStack.load(offset); }
    public int getArg(int offset) { return runStack.getArg(offset); }
}
