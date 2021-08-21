package com.github.zxh.classpy.ibd.page.inode;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.datatype.U4;
import com.github.zxh.classpy.ibd.page.base.ListBaseNode;

/**
 * 用来描述一个段的信息
 * 段由一些零散的页(fragArrEntries)和一些完整的区(3个ListBaseNode)组成，在物理上并不连续
 */
public class INodeEntry extends TableSpacePart {
    {
        u8hex("segmentId");
        u4hex("NOT_FULL_N_USED");
        part("freeList", ListBaseNode.class);
        part("notFullList",ListBaseNode.class);
        part("fullList",ListBaseNode.class);
        u4hex("magicNum");
        partList("fragArrEntries", U4.class,32);
    }
}
