package com.github.zxh.classpy.ibd;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.datatype.UInt;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.index.IndexPageHeader;


public class RecordContainer extends TableSpacePart {
    private final FileHeader fileHeader;
    private final IndexPageHeader pageHeader;

    public RecordContainer(FileHeader fileHeader, IndexPageHeader pageHeader) {
        this.fileHeader = fileHeader;
        this.pageHeader = pageHeader;
    }
    @Override
    protected void readContent(TableSpaceReader reader) {
        Integer global = getGlobalFreeOffset();
        Integer skip = global - reader.getPosition();

    }

    private Integer getGlobalFreeOffset() {
        //获得页号
        FilePart filePart = fileHeader.getParts().get(1);
        Integer pageNum = ((UInt)filePart).getValue();

        //获得record的接收的第一个字节的偏移量
        filePart = pageHeader.getParts().get(2);
        Integer pageHeapTop = ((UInt)filePart).getValue();

        Integer global = pageNum * Constant.PAGE_SIZE + pageHeapTop;

        return global;
    }
}
