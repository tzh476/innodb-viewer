package com.github.zxh.classpy.ibd.page;

import java.util.HashMap;
import java.util.Map;

public class PageType {
    /**
     * FIL_PAGE_TYPE_ALLOCATED	0x0000	最新分配，还没使用
     * FIL_PAGE_UNDO_LOG	0x0002	Undo日志页
     * FIL_PAGE_INODE	0x0003	段信息节点
     * FIL_PAGE_IBUF_FREE_LIST	0x0004	Insert Buffer空闲列表
     * FIL_PAGE_IBUF_BITMAP	0x0005	Insert Buffer位图
     * FIL_PAGE_TYPE_SYS	0x0006	系统页
     * FIL_PAGE_TYPE_TRX_SYS	0x0007	事务系统数据
     * FIL_PAGE_TYPE_FSP_HDR	0x0008	表空间头部信息
     * FIL_PAGE_TYPE_XDES	0x0009	扩展描述页
     * FIL_PAGE_TYPE_BLOB	0x000A	溢出页
     * FIL_PAGE_INDEX	0x45BF	索引页，也就是我们所说的数据页
     */
    public static final int PAGE_TYPE_ALLOCATED = 0;
    public static final int PAGE_UNDO_LOG = 2;
    public static final int PAGE_INODE = 3;
    public static final int PAGE_IBUF_FREE_LIST = 4;
    public static final int PAGE_IBUF_BITMAP = 5;
    public static final int PAGE_TYPE_SYS = 6;
    public static final int PAGE_TYPE_TRX_SYS = 7;
    public static final int PAGE_TYPE_FSP_HDR = 8;
    public static final int PAGE_TYPE_XDES = 9;
    public static final int PAGE_TYPE_BLOB = 10;
    public static final int PAGE_INDEX = 0x45BF;
    

    public static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(PAGE_TYPE_ALLOCATED, "PAGE_TYPE_ALLOCATED");
        map.put(PAGE_UNDO_LOG, "PAGE_UNDO_LOG");
        map.put(PAGE_INODE, "PAGE_INODE");
        map.put(PAGE_IBUF_FREE_LIST, "PAGE_IBUF_FREE_LIST");
        map.put(PAGE_IBUF_BITMAP, "PAGE_IBUF_BITMAP");
        map.put(PAGE_TYPE_SYS, "PAGE_TYPE_SYS");
        map.put(PAGE_TYPE_TRX_SYS, "PAGE_TYPE_TRX_SYS");
        map.put(PAGE_TYPE_FSP_HDR, "PAGE_TYPE_FSP_HDR");
        map.put(PAGE_TYPE_XDES, "PAGE_TYPE_XDES");
        map.put(PAGE_TYPE_BLOB, "PAGE_TYPE_BLOB");
        map.put(PAGE_INDEX, "PAGE_INDEX");
    }
    public static String getValue(int key){
        return map.get(key);
    }

}
