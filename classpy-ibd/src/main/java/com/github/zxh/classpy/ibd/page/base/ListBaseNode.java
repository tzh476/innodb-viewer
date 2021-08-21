package com.github.zxh.classpy.ibd.page.base;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *     public Integer length;
 *     public PageOffset first;
 *     public PageOffset last;
 */
public class ListBaseNode extends TableSpacePart {
    {
        u4hex("length");
        part("first", PageOffset.class);
        part("last", PageOffset.class);
    }
}
