package com.github.zxh.classpy.ibd.page.base;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *     public Integer pageNum;
 *     public Short offset;
 */
public class PageOffset extends TableSpacePart {
    {
        u4hex("pageNum");
        u2("offset");
    }
}
