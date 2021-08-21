package com.github.zxh.classpy.ibd.page.index;

import com.github.zxh.classpy.ibd.Constant;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.datatype.Bytes;
import com.github.zxh.classpy.ibd.datatype.UInt;

public class PageDirectory extends TableSpacePart {
    private final IndexPageHeader pageHeader;

    public PageDirectory(IndexPageHeader pageHeader) {
        this.pageHeader = pageHeader;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {
        Integer slotNum = ((UInt) pageHeader.getParts().get(0)).getValue();
        for (int i = 0; i < slotNum; i++) {
            Bytes bytes = new Bytes(Constant.SLOT_SIZE);
            add(i + "", bytes);
            bytes.read(reader);
        }
    }
}
