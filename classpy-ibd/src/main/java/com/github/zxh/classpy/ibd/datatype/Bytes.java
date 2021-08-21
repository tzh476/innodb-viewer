package com.github.zxh.classpy.ibd.datatype;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;

/**
 * Unparsed bytes.
 */
public class Bytes extends TableSpacePart {

    private Integer count;

    public Bytes(Integer count) {
        this.count = count;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        reader.skipBytes(count);
    }

}
