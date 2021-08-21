package com.github.zxh.classpy.ibd.datatype;

import com.github.zxh.classpy.common.ParseException;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;

/**
 * 读取数组
 */
public class PartList extends TableSpacePart {
    private final Class<? extends TableSpacePart> entryClass;
    private final Integer size;

    public PartList(Class<? extends TableSpacePart> entryClass, Integer size) {
        this.entryClass = entryClass;
        this.size = size;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        try {
            for (int i = 0; i < size; i++) {
                TableSpacePart part = readEntry(reader);
                part.setDesc(i + "-" + part.getClass().getSimpleName());
                super.add(part);
            }
        } catch (ReflectiveOperationException e) {
            throw new ParseException(e);
        }
    }

    private TableSpacePart readEntry(TableSpaceReader reader) throws ReflectiveOperationException {
        TableSpacePart c = entryClass.newInstance();
        c.read(reader);
        return c;
    }
}
