package com.github.zxh.classpy.ibd;

import com.github.zxh.classpy.common.BytesReader;

import java.nio.ByteOrder;

public class TableSpaceReader extends BytesReader {


    public TableSpaceReader(byte[] data) {
        super(data, ByteOrder.BIG_ENDIAN);
    }

}
