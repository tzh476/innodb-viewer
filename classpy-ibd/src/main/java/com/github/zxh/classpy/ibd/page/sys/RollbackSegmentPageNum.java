package com.github.zxh.classpy.ibd.page.sys;

import com.github.zxh.classpy.ibd.TableSpacePart;

public class RollbackSegmentPageNum extends TableSpacePart {
    {
        u4hex("spaceId");
        u4hex("pageNum");
    }
}