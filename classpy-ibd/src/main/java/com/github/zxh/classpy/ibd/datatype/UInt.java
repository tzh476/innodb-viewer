package com.github.zxh.classpy.ibd.datatype;


import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.constant.ConstantPool;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class UInt extends TableSpacePart {

    protected static final Function<TableSpaceReader, Integer> READ_U1 = TableSpaceReader::readUnsignedByte;
    protected static final Function<TableSpaceReader, Integer> READ_U2 = TableSpaceReader::readUnsignedShort;
    protected static final Function<TableSpaceReader, Integer> READ_I2 = TableSpaceReader::readShort2Int;
    protected static final Function<TableSpaceReader, Integer> READ_U4 = TableSpaceReader::readInt;

    protected static final BiFunction<Integer, ConstantPool, String> TO_STRING =
            (val, cp) -> val.toString();
    protected static final BiFunction<Integer, ConstantPool, String> TO_HEX =
            (val, cp) -> "0x" + Integer.toHexString(val).toUpperCase();
    protected static final BiFunction<Integer, ConstantPool, String> TO_CONST =
            (val, cp) -> val > 0
                    ? "#" + val + "->" + "cp.getConstantDesc(val)"
                    : "#" + val;


    private final Function<TableSpaceReader, Integer> intReader;
    private final BiFunction<Integer, ConstantPool, String> intDescriber;
    private int value;

    public UInt(Function<TableSpaceReader, Integer> intReader,
                BiFunction<Integer, ConstantPool, String> intDescriber) {
        this.intReader = intReader;
        this.intDescriber = intDescriber;
    }

    public final int getValue() {
        return value;
    }

    @Override
    protected final void readContent(TableSpaceReader reader) {
        value = intReader.apply(reader);
    }

    protected final void postRead(ConstantPool cp) {
        setDesc(intDescriber.apply(value, cp));
    }
    
}
