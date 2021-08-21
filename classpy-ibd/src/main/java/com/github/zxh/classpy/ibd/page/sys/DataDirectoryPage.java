package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;
import com.github.zxh.classpy.ibd.page.index.SegmentHeader;

public class DataDirectoryPage extends AbstractPage {
   // private Integer EMPTY_SIZE = 16336;//小册子写错了？
    private Integer EMPTY_SIZE = 16272;//小册子写错了？


    public DataDirectoryPage(FileHeader fileHeader) {
        super(fileHeader);
        part("DataDirectoryHeader", DataDirectoryHeader.class);
        u4hex("unUsed");
        part("segmentHeader", SegmentHeader.class);
        bytes("emptySpace", EMPTY_SIZE);
        part("fileTrailer", FileTrailer.class);
    }
}