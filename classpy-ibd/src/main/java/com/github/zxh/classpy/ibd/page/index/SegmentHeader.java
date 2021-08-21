package com.github.zxh.classpy.ibd.page.index;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *     public Integer spaceId;
 *     public Integer pageNum;
 *     public Short offset;
 */
public class SegmentHeader extends TableSpacePart {
    {
        u4hex("spaceId");
        u4hex("pageNum");
        u2("offset");
    }
}
