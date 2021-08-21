package com.github.zxh.classpy.ibd.page.fsp;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListNode;

/**
 *     public Long segmentId;
 *     public ListNode listNode;
 *     public Integer state;
 *     public byte[] bitMap;
 */
public class XdesEntry extends TableSpacePart {
    {
        u8hex("segmentId");
        part("listNode", ListNode.class);
        u4hex("state");
        bytes("bitMap",16);
    }
}
