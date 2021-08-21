package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListBaseNode;
import com.github.zxh.classpy.ibd.page.index.SegmentHeader;

public class RollbackSegmentHeader extends TableSpacePart {
    {
        u4hex("maxSize");
        u4hex("historySize");
        part("historyBaseNode", ListBaseNode.class);
        part("Rollback Segment FSEG Entry", SegmentHeader.class);
    }
}
