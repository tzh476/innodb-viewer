package com.github.zxh.classpy.ibd.datatype;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.common.ParseException;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;

/**
 * 读取对象
 */
public class Part extends TableSpacePart {
    private final Class<? extends TableSpacePart> entryClass;

    public Part(Class<? extends TableSpacePart> entryClass) {
        this.entryClass = entryClass;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        try {
            readEntry(reader);
        } catch (ReflectiveOperationException e) {
            throw new ParseException(e);
        }
    }

    private void readEntry(TableSpaceReader reader) throws ReflectiveOperationException {
        TableSpacePart cur = entryClass.newInstance();
        cur.read(reader);
        for (FilePart fc : cur.getParts()) {
            //this其实就是parent的属性，属性在调用构造方法就生成了，现在是填充属性的值
            this.add((TableSpacePart) fc);
        }
    }
}
