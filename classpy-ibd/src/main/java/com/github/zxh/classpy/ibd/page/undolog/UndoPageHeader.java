package com.github.zxh.classpy.ibd.page.undolog;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.page.base.ListNode;

public class UndoPageHeader extends TableSpacePart {
    public final static Integer LENGTH = 18;

    {
        u2hex("TRX_UNDO_PAGE_TYPE");
        u2hex("TRX_UNDO_PAGE_START");
        u2hex("TRX_UNDO_PAGE_FREE");
        part("TRX_UNDO_PAGE_NODE", ListNode.class);
    }
}