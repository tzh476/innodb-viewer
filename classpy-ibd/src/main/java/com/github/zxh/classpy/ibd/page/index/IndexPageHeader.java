package com.github.zxh.classpy.ibd.page.index;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 *    public Short PAGE_N_DIR_SLOTS	;//	2	字节	在页目录中的槽数量
 *     public Short PAGE_HEAP_TOP	;//	2	字节	还未使用的空间最小地址，也就是说从该地址之后就是	Free	Space
 *     public Short PAGE_N_HEAP	;//	2	字节	本页中的记录的数量（包括最小和最大记录以及标记为删除的记录）
 *     public Short PAGE_FREE	;//	2	字节 第一个已经标记为删除的记录地址（各个已删除的记录通过 next_record 也会组成一个单链表，这个单链表中的记录可以被重新利用
 *     public Short PAGE_GARBAGE	;//	2	字节	已删除记录占用的字节数
 *     public Short PAGE_LAST_INSERT	;//	2	字节	最后插入记录的位置
 *     public Short PAGE_DIRECTION	;//	2	字节	记录插入的方向
 *     public Short PAGE_N_DIRECTION	;//	2	字节	一个方向连续插入的记录数量
 *     public Short PAGE_N_RECS	;//	2	字节	该页中记录的数量（不包括最小和最大记录以及被标记为删除的记录）
 *     public Long PAGE_MAX_TRX_ID	;//	8	字节	修改当前页的最大事务ID，该值仅在二级索引中定义
 *     public Short PAGE_LEVEL	;//	2	字节	当前页在B+树中所处的层级
 *     public Long PAGE_INDEX_ID	;//	8	字节	索引ID，表示当前页属于哪个索引
 *     public SegmentHeader PAGE_BTR_SEG_LEAF	;//	10	字节	B+树叶子段的头部信息，仅在B+树的Root页定义
 *     public SegmentHeader PAGE_BTR_SEG_TOP	;//	10	字节	B+树非叶子段的头部信息，仅在B+树的Root页定义
 */
public class IndexPageHeader extends TableSpacePart {
    {
        u2hex("PAGE_N_DIR_SLOTS");
        u2hex("PAGE_HEAP_TOP");
        u2hex("PAGE_N_HEAP");
        u2hex("PAGE_FREE");
        u2hex("PAGE_GARBAGE");
        u2hex("PAGE_LAST_INSERT");
        u2hex("PAGE_DIRECTION");
        u2hex("PAGE_N_DIRECTION");
        u2hex("PAGE_N_RECS");
        u8hex("PAGE_MAX_TRX_ID");
        u2hex("PAGE_LEVEL");
        u8hex("PAGE_INDEX_ID");
        part("PAGE_BTR_SEG_LEAF", SegmentHeader.class);
        part("PAGE_BTR_SEG_TOP", SegmentHeader.class);

    }
}
