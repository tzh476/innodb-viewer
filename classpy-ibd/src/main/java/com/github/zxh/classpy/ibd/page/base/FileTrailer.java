package com.github.zxh.classpy.ibd.page.base;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *    public Integer checkSum;
 *    public Integer lsn;
 */
public class FileTrailer extends TableSpacePart {

    {
        u4hex("checkSum");
        u4hex("lsn");
    }
}
