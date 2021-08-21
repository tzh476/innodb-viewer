package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 * 52字节
 */
public class DataDirectoryHeader extends TableSpacePart {
    {
        u8hex("maxRowId");
        u8hex("maxTableId");
        u8hex("maxIndexId");
        u4hex("maxSpaceId");
        u4hex("mixIdLow");
        u4hex("rootPageNumOfSysPriInx");
        u4hex("rootPageNumOfSysSecInx");
        u4hex("rootPageNumOfColPriInx");
        u4hex("rootPageNumOfInxPriInx");
        u4hex("rootPageNumOfFiePriInx");
    }
}
