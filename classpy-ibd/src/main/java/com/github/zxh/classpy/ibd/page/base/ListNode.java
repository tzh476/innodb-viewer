package com.github.zxh.classpy.ibd.page.base;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *     public PageOffset prev;
 *     public PageOffset next;
 */
public class ListNode extends TableSpacePart {
    {
        part("prev", PageOffset.class);
        part("next", PageOffset.class);
    }
}
