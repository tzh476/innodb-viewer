package com.github.zxh.classpy.ibd.page.undolog;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListNode;

public class UndoLogHeader extends TableSpacePart {
    public final static Integer LENGTH = 186;

    {
        u8hex("TRX_UNDO_TRX_ID");//：生成本组undo日志的事务id
        u8hex("TRX_UNDO_TRX_NO");//事务提交后生成的一个需要序号，使用此序号来标记事务的提交顺序（先提交的此序号小，后提交的此序号大
        u2hex("TRX_UNDO_DEL_MARKS");//标记本组undo 日志中是否包含由于Delete mark 操作产生的undo日志
        u2hex("TRX_UNDO_LOG_START");//表示本组undo 日志中第一条undo日志的在页面中的偏移量
        bytes("TRX_UNDO_XID_EXISTS", 1);//本组undo日志是否包含XID信息
        bytes("TRX_UNDO_DICT_TRANS", 1);//是否由DDL产生
        u8hex("TRX_UNDO_TABLE_ID");//如果TRX_UNDO_DICT_TRANS 为真，那么本属性表示DDL语句操作的表的table id
        u2hex("TRX_UNDO_NEXT_LOG");//下一组的undo日志在页面中开始的偏移量。
        u2hex("TRX_UNDO_PREV_LOG");//上一组的undo日志在页面中开始的偏移量
        part("TRX_UNDO_HISTORY_NODE", ListNode.class);//一个12字节的List Node 结构，代表一个称之为History 链表的节点。
        bytes("xid", 140);
    }
}