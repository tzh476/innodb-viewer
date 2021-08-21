package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.datatype.U4Hex;
import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

public class RollbackSegHeaderPage extends AbstractPage {
    //private static final Integer EMPTY_SIZE = 12212;//innodb_structures算错了？
    private static final Integer EMPTY_SIZE = 12208;

    public RollbackSegHeaderPage(FileHeader fileHeader) {
        super(fileHeader);
        part("RollbackSegmentHeader", RollbackSegmentHeader.class);
        partList("Undo Segment Slots", U4Hex.class, 1024);
        bytes("empty space", EMPTY_SIZE);
        part("fileTrailer", FileTrailer.class);
    }
}
