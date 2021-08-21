package com.github.zxh.classpy.ibd.page;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.Constant;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

import java.util.List;

public class AllocatedPage extends AbstractPage {
    public AllocatedPage(FileHeader fileHeader) {
        super(fileHeader);
        bytes("empty", Constant.PAGE_SIZE - Constant.FILE_HEADER_SIZE - Constant.FILE_TRAILER_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
}