package com.github.zxh.classpy.ibd.page.ibuf;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;

/**
 *     public byte[] changeBufferBitmap;//8192 byte,4bits per page
 *     public byte[] empty;//8146 bytes
 */
public class IbufBitmapPage extends AbstractPage {
    private static final Integer XDES_ENTRY_NUM = 256;
    private static Integer CHANGE_BUFFER_BITMAP_SIZE = 8192;
    public static Integer EMPTY_SIZE = 8146;

    public IbufBitmapPage(FileHeader fileHeader) {
        super(fileHeader);
        bytes("changeBufferBitmap", CHANGE_BUFFER_BITMAP_SIZE);
        bytes("empty", EMPTY_SIZE);
        part("FileTrailer", FileTrailer.class);
    }
}
