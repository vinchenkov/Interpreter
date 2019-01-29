package interpreter;
import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    public void addByteCode(ByteCode bCode) {
        program.add(bCode);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        //Creates a map to store addresses associated with certain labels
        Map<String, Integer> addresses = new HashMap<String, Integer>();
        //Creates a list of all bytecodes that need their addresses
        //resolved after iteration of the program list.
        ArrayList<jumpCode> jumpCodes = new ArrayList<jumpCode>();

        int listSize = program.size();

        //Iterate through program list
        for(int i = 0; i < listSize; i++) {
            ByteCode bc = program.get(i);
            //Add jumpcodes to array list
            if(bc instanceof jumpCode) {
                jumpCodes.add( (jumpCode) bc);
            }
            //Add label and associated key into map
            else if(bc instanceof LabelCode) {
                String label = ( (LabelCode) bc).getLabel();
                addresses.put(label, i);
            }
        }
        //Resolve addresses using map and array list
        for( jumpCode code: jumpCodes ) {
            String addrs = code.getAddrs();
            int resolvedAddrs = addresses.get(addrs);
            code.setResolvedAddrs(resolvedAddrs);
        }
    }

}
