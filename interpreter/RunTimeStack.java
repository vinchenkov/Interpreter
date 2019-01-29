package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<Integer>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        int size = runTimeStack.size();
        if (!runTimeStack.isEmpty()) {
            String stackPrint = "[" + runTimeStack.get(0);
            ;
            for (int i = 1; i < size; i++) {
                if (framePointer.contains(i)) {
                    stackPrint += "][" + runTimeStack.get(i);
                } else {
                    stackPrint += "," + runTimeStack.get(i);
                }
            }
            stackPrint += "]";
            System.out.println(stackPrint);
        }
        else {
            System.out.println("[]");
        }
    }

    public int peek() {
        int size = runTimeStack.size() - 1;
        if (!runTimeStack.isEmpty()) {
            return runTimeStack.get(size);
        }
        return 0;
    }

    public int pop() {
        int size = runTimeStack.size() - 1;
        if (!runTimeStack.isEmpty()) {
            return runTimeStack.remove(size);
        }
        return 0;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        int frame = runTimeStack.size() - offset;
        framePointer.push(frame);
    }

    public void popFrame() {
        int returnValue = pop();
        int currentFrame = framePointer.pop();
        int size = runTimeStack.size();

        for (int i = currentFrame; i < size; i++) {
            runTimeStack.remove(i);
        }

        runTimeStack.add(returnValue);
    }

    public int store(int offset) {
        int storeValue = pop();
        int indexToStore = framePointer.peek() + offset;

        runTimeStack.set(indexToStore, storeValue);
        return storeValue;
    }

    public int load(int offset) {
        int indexToCopy = framePointer.peek() + offset;
        int loadValue = runTimeStack.get(indexToCopy);

        runTimeStack.add(loadValue);
        return loadValue;
    }

    //For Call Code
    public int getArg(int offset) {
        int argToGrab = runTimeStack.size() - 1 - offset;
        return runTimeStack.get(argToGrab);
    }

    public int stackSize() {
        return runTimeStack.size();
    }

    public int peekFramePointer(){ return framePointer.peek(); }

}
