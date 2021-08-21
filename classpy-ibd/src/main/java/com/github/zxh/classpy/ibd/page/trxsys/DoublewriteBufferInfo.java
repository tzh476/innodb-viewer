package com.github.zxh.classpy.ibd.page.trxsys;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.index.SegmentHeader;

public class DoublewriteBufferInfo extends TableSpacePart {
    {
        part("Doublewrite Buffer FSEG Entry", SegmentHeader.class);
        u4hex("Doublewrite Magic Number");
        u4hex("Block 1 Start Page");
        u4hex("Block 2 Start Page");
        u4hex("Doublewrite Magic Number");
        u4hex("Block 1 Start Page");
        u4hex("Block 2 Start Page");
        u4hex("Space ID Stored Magic Number");
    }
}
