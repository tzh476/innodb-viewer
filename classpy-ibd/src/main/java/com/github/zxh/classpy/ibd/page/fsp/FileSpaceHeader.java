package com.github.zxh.classpy.ibd.page.fsp;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListBaseNode;

/**
 *     public Integer spaceId;
 *     public Integer notUsed;
 *     public Integer size;
 *     public Integer freeLimit;
 *     public Integer spaceFlags;
 *     public Integer FRAG_N_USED;
 *     public ListBaseNode freeList;
 *     public ListBaseNode freeFragList;
 *     public ListBaseNode fullFragList;
 *     public Long nextUnusedSegmentId;
 *     public ListBaseNode segInodeFullList;
 *     public ListBaseNode segInodeFreeList;
 */
public class FileSpaceHeader extends TableSpacePart {
    {
        u4hex("spaceId");
        u4hex("notUsed");
        u4hex("size");
        u4hex("freeLimit");
        u4hex("spaceFlags");
        u4hex("FRAG_N_USED");
        part("freeList", ListBaseNode.class);
        part("freeFragList", ListBaseNode.class);
        part("fullFragList", ListBaseNode.class);
        u8hex("nextUnusedSegmentId");
        part("segInodeFullList", ListBaseNode.class);
        part("segInodeFreeList", ListBaseNode.class);
    }
}
