package com.github.zxh.classpy.ibd;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.constant.ConstantPool;
import com.github.zxh.classpy.ibd.datatype.*;

/**
 * Base class for all class file parts.
 */
public abstract class TableSpacePart extends FilePart {

    /**
     * Reads content, records offset and length.
     * @param reader
     */
    public final void read(TableSpaceReader reader) {
        try {
            int offset = reader.getPosition();
            readContent(reader);
            int length = reader.getPosition() - offset;
            super.setOffset(offset);
            super.setLength(length);
        } catch (Exception e) {
            System.out.println("error parsing: " + getClass());
            throw e;
        }
    }

    /**
     * Reads content using ClassFileReader.
     * @param reader
     */
    protected void readContent(TableSpaceReader reader) {
        for (FilePart fc : getParts()) {
            ((TableSpacePart) fc).read(reader);
        }
    }

    protected final void u4hex(String name) {
        this.add(name, new U4Hex());
    }

    protected final void u8hex(String name) {
        this.add(name, new U8Hex());
    }
    protected final void u8(String name) {
        this.add(name, new U8());
    }

    protected final void u2hex(String name) {
        this.add(name, new U2Hex());
    }
    protected final void i2hex(String name) {
        this.add(name, new I2Hex());
    }

    protected final void u2(String name) {
        this.add(name, new U2());
    }

    protected void postRead(ConstantPool cp) {

    }

    protected final void add(TableSpacePart subPart) {
        this.add(null, subPart);
    }

    protected final void partList(String name,
                                  Class<? extends TableSpacePart> entryClass, Integer size) {
        PartList page = new PartList(entryClass, size);
        this.add(name, page);
    }
    protected final void part(String name,
                                  Class<? extends TableSpacePart> entryClass) {
        Part part = new Part(entryClass);
        this.add(name, part);
    }

    protected final void bytes(String name, Integer count) {
        Bytes bytes = new Bytes(count);
        this.add(name, bytes);
    }
}
