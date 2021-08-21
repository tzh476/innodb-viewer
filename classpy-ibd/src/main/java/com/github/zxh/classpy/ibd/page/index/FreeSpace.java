package com.github.zxh.classpy.ibd.page.index;

import com.github.zxh.classpy.ibd.Constant;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.datatype.Bytes;
import com.github.zxh.classpy.ibd.datatype.UInt;
import com.github.zxh.classpy.ibd.page.base.FileHeader;

public class FreeSpace extends TableSpacePart {
    private final FileHeader fileHeader;
    private final IndexPageHeader pageHeader;

    public FreeSpace(FileHeader fileHeader, IndexPageHeader pageHeader) {
        this.fileHeader = fileHeader;
        this.pageHeader = pageHeader;
    }
//不使用该方法，会报错。不确定fileheader中的pageoffset是否是指page在ibdata1文件中以16kb为单位的offset
//    @Override
//    protected void readContent(TableSpaceReader reader) {
//        Integer pageOffset = ((UInt) fileHeader.getParts().get(1)).getValue();
//        Integer slotSize = ((UInt) pageHeader.getParts().get(0)).getValue() * Constant.SLOT_SIZE;
//        Integer nPageSize = (pageOffset + 1) * Constant.PAGE_SIZE;
//        Integer curPosition = reader.getPosition();
//        Integer freeSpaceSize = nPageSize - curPosition - Constant.FILE_TRAILER_SIZE - slotSize;
//        Bytes bytes = new Bytes(freeSpaceSize);
//        add("freeSpace", bytes);
//        bytes.read(reader);
//    }
    @Override
    protected void readContent(TableSpaceReader reader) {
        Integer slotSize = ((UInt) pageHeader.getParts().get(0)).getValue() * Constant.SLOT_SIZE;
        Integer curPosition = reader.getPosition();
        Integer curPageReadSize = curPosition % Constant.PAGE_SIZE;
        Integer freeSpaceSize = Constant.PAGE_SIZE - curPageReadSize - Constant.FILE_TRAILER_SIZE - slotSize;
        Bytes bytes = new Bytes(freeSpaceSize);
        add("freeSpace", bytes);
        bytes.read(reader);
    }
}