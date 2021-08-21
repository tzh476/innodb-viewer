package com.github.zxh.classpy.ibd.datatype;


import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.constant.ConstantPool;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class ULong extends TableSpacePart {

    protected static final Function<TableSpaceReader, Long> READ_U8 = TableSpaceReader::readLong;


    protected static final BiFunction<Long, ConstantPool, String> TO_STRING =
            (val, cp) -> val.toString();
    protected static final BiFunction<Long, ConstantPool, String> TO_HEX =
            (val, cp) -> "0x" + Long.toHexString(val).toUpperCase();
    protected static final BiFunction<Long, ConstantPool, String> TO_CONST =
            (val, cp) -> val > 0
                    ? "#" + val + "->" + "cp.getConstantDesc(val)"
                    : "#" + val;


    private final Function<TableSpaceReader, Long> longReader;
    private final BiFunction<Long, ConstantPool, String> longDescriber;
    private long value;

    public ULong(Function<TableSpaceReader, Long> intReader,
                 BiFunction<Long, ConstantPool, String> intDescriber) {
        this.longReader = intReader;
        this.longDescriber = intDescriber;
    }

    public final long getValue() {
        return value;
    }

    @Override
    protected final void readContent(TableSpaceReader reader) {
        value = longReader.apply(reader);
    }

    protected final void postRead(ConstantPool cp) {
        setDesc(longDescriber.apply(value, cp));
    }
    
}
