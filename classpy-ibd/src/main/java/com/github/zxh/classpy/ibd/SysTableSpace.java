package com.github.zxh.classpy.ibd;


import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.datatype.UInt;
import com.github.zxh.classpy.ibd.page.AllocatedPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.fsp.FspHdrPage;
import com.github.zxh.classpy.ibd.page.ibuf.IbufBitmapPage;
import com.github.zxh.classpy.ibd.page.index.IndexPage;
import com.github.zxh.classpy.ibd.page.inode.INodePage;
import com.github.zxh.classpy.ibd.page.sys.DataDirectoryPage;
import com.github.zxh.classpy.ibd.page.sys.RollbackSegHeaderPage;
import com.github.zxh.classpy.ibd.page.sys.SysPage;
import com.github.zxh.classpy.ibd.page.trxsys.TrxSysPage;
import com.github.zxh.classpy.ibd.page.undolog.UndologPage;

import java.util.List;

import static com.github.zxh.classpy.ibd.page.PageType.*;

public class SysTableSpace extends TableSpacePart {
    private Integer filePageNum = 0;//读取的文件有多少个16K(16K取决于PAGE_SIZE)
    //private final static Integer MAX_PARSE_NUM = 1000;
    {
        part("0-FspHdrPage", FspHdrPage.class);
    }

    protected void readContent(TableSpaceReader reader) {
        setFile16KNum(reader);
        List<FilePart> fileParts = getParts();
        FilePart fspHdrPage = fileParts.get(0);
        ((TableSpacePart) fspHdrPage).read(reader);
        Integer pageNum = getPageNum();
        Integer realParseNum = Math.min(filePageNum, pageNum);
        for (int i = 1; i < realParseNum; i++) {
            String prefix = i + "-";
            TableSpacePart page = null;
            FileHeader fileHeader = new FileHeader();
            fileHeader.read(reader);
            int pageType = fileHeader.getPageType();
            switch (pageType) {
                case PAGE_TYPE_ALLOCATED:
                    page = new AllocatedPage(fileHeader);
                    add(prefix + "AllocatedPage", page);
                    break;
                case PAGE_UNDO_LOG:
                    page = new UndologPage(fileHeader);
                    add(prefix + "PAGE_UNDO_LOG", page);
                    break;
                case PAGE_INODE:
                    page = new INodePage(fileHeader);
                    add(prefix + "INodePage", page);
                    break;
                case PAGE_IBUF_FREE_LIST:
                    page = new AllocatedPage(fileHeader);
                    add(prefix + "PAGE_IBUF_FREE_LIST", page);
                    break;
                case PAGE_IBUF_BITMAP:
                    page = new IbufBitmapPage(fileHeader);
                    add(prefix + "IbufBitmapPage", page);
                    break;
                case PAGE_TYPE_SYS:
                    if (i == 6) {
                        page = new RollbackSegHeaderPage(fileHeader);
                        add(prefix + "RollbackSegHeaderPage", page);
                    } else if (i == 7) {
                        page = new DataDirectoryPage(fileHeader);
                        add(prefix + "DataDirectoryPage", page);
                    } else {
                        page = new SysPage(fileHeader);
                        add(prefix + "SysPage", page);
                    }
                    break;
                case PAGE_TYPE_TRX_SYS:
                    page = new TrxSysPage(fileHeader);
                    add(prefix + "TrxSysPage", page);
                    break;
                case PAGE_TYPE_FSP_HDR:
                    page = new FspHdrPage(false);
                    add(prefix + "FspHdrPage", page);
                    break;
                case PAGE_TYPE_XDES:
                    page = new AllocatedPage(fileHeader);
                    add(prefix + "PAGE_TYPE_XDES", page);
                    break;
                case PAGE_TYPE_BLOB:
                    page = new AllocatedPage(fileHeader);
                    add(prefix + "PAGE_TYPE_BLOB", page);
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

    private void setFile16KNum(TableSpaceReader reader) {
        filePageNum = reader.remaining() / Constant.PAGE_SIZE;
    }

    public int getPageNum() {
        FilePart spaceHeaderPart = getParts().get(0).getParts().get(1);
        return ((UInt) spaceHeaderPart.getParts().get(2)).getValue();
    }
}
