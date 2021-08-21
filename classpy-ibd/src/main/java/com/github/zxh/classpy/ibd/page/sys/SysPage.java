package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.Constant;
import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

public class SysPage extends AbstractPage {
    public SysPage(FileHeader fileHeader) {
        super(fileHeader);
        bytes("empty", Constant.PAGE_SIZE - Constant.FILE_HEADER_SIZE - Constant.FILE_TRAILER_SIZE);
        part("fileTrailer", FileTrailer.class);
    }
}
