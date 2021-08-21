package com.github.zxh.classpy.ibd;


import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.datatype.UInt;
import com.github.zxh.classpy.ibd.page.AllocatedPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.fsp.FspHdrPage;
import com.github.zxh.classpy.ibd.page.inode.INodePage;
import com.github.zxh.classpy.ibd.page.ibuf.IbufBitmapPage;
import com.github.zxh.classpy.ibd.page.index.IndexPage;

import java.util.List;

import static com.github.zxh.classpy.ibd.page.PageType.*;

public class TableSpace extends TableSpacePart {
    {
        part("0-FspHdrPage", FspHdrPage.class);
    }

    protected void readContent(TableSpaceReader reader) {
        List<FilePart> fileParts = getParts();
        FilePart fspHdrPage = fileParts.get(0);
        ((TableSpacePart) fspHdrPage).read(reader);
        Integer pageNum = getPageNum();
        for (int i = 1; i < pageNum; i++) {
            TableSpacePart page = null;
            FileHeader fileHeader = new FileHeader();
            fileHeader.read(reader);
            int pageType = fileHeader.getPageType();
            String prefix = i + "-";
            switch (pageType) {
                case PAGE_TYPE_ALLOCATED:
                    page = new AllocatedPage(fileHeader);
                    add(prefix + "AllocatedPage", page);
                    break;
                case PAGE_UNDO_LOG:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_INODE:
                    page = new INodePage(fileHeader);
                    add(prefix + "INodePage", page);
                    break;
                case PAGE_IBUF_FREE_LIST:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_IBUF_BITMAP:
                    page = new IbufBitmapPage(fileHeader);
                    add(prefix + "IbufBitmapPage", page);
                    break;
                case PAGE_TYPE_SYS:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_TYPE_TRX_SYS:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_TYPE_FSP_HDR:
                    page = new FspHdrPage(true);
                    add(prefix + "FspHdrPage", page);
                    break;
                case PAGE_TYPE_XDES:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_TYPE_BLOB:
                    new IndexPage(fileHeader);
                    break;
                case PAGE_INDEX:
                    page = new IndexPage(fileHeader);
                    add(prefix + "IndexPage", page);
                    break;
            }
            System.out.println("read page " + i + ". type:" + pageType + ". page num:" + pageNum);
            page.readContent(reader);
        }
    }

    public int getPageNum() {
        FilePart spaceHeaderPart = getParts().get(0).getParts().get(1);
        return ((UInt) spaceHeaderPart.getParts().get(2)).getValue();
    }

}
