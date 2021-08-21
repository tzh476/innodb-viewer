package com.github.zxh.classpy.ibd.page.fsp;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

/**
 *    public FileSpaceHeader fileSpaceHeader;
 *     public XdesEntry[] XDESEntrys;
 *     public byte[] empty;
 *    public FileTrailer fileTrailer;
 */
public class FspHdrPage extends TableSpacePart {
    private static final Integer XDES_ENTRY_NUM = 256;
    public static Integer EMPTY_SIZE = 5986;
    public FspHdrPage(){
        part("FileHeader", FileHeader.class);
        part("FileSpaceHeader", FileSpaceHeader.class);
        partList("XDESEntrys", XdesEntry.class, XDES_ENTRY_NUM);
        bytes("empty", EMPTY_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
    public FspHdrPage(boolean isFirstPage){

        part("FileSpaceHeader", FileSpaceHeader.class);
        partList("XDESEntrys", XdesEntry.class, XDES_ENTRY_NUM);
        bytes("empty", EMPTY_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
}
