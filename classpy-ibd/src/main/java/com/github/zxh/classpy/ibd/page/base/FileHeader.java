package com.github.zxh.classpy.ibd.page.base;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.datatype.UInt;

/**
 *     public Integer CHKSUM;//4
 *     public Integer FIL_PAGE_OFFSET;//4
 *     public Integer FIL_PAGE_PREV;//4
 *     public Integer FIL_PAGE_NEXT;//4
 *     public Long FIL_PAGE_LSN;//8
 *     public Short FIL_PAGE_TYPE;//2
 *     public Long FIL_PAGE_FILE_FLUSH_LSN;//8
 *     public Integer FIL_PAGE_ARCH_LOG_NO_OR_SPACE_ID;//4
 */
public class FileHeader extends TableSpacePart {

    {
        u4hex("CHKSUM");
        u4hex("PAGE_OFFSET");
        u4hex("PAGE_PREV");
        u4hex("PAGE_NEXT");
        u8hex("PAGE_LSN");
        u2hex("PAGE_TYPE");
        u8hex("FLUSH_LSN");
        u4hex("SPACE_ID");
    }



    public int getPageType(){
        return ((UInt)getParts().get(5)).getValue();
    }
}
