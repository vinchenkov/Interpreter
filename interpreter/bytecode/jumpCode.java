package interpreter.bytecode;

public abstract class jumpCode extends ByteCode {

    public abstract String getAddrs();
    public abstract void setResolvedAddrs(int addrs);

}
