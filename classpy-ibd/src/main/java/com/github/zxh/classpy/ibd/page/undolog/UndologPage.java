package com.github.zxh.classpy.ibd.page.undolog;

import com.github.zxh.classpy.ibd.Constant;
import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

public class UndologPage extends AbstractPage {
    public UndologPage(FileHeader fileHeader) {
        super(fileHeader);
        part("UndoPageHeader", UndoPageHeader.class);//18字节
        part("UndoLogHeader", UndoLogHeader.class);
        bytes("undolog-todo", Constant.PAGE_SIZE - Constant.FILE_HEADER_SIZE - Constant.FILE_TRAILER_SIZE - UndoPageHeader.LENGTH - UndoLogHeader.LENGTH);
        part("fileTrailer", FileTrailer.class);
    }
}