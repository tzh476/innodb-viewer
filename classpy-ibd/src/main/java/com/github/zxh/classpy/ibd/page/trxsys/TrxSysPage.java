package com.github.zxh.classpy.ibd.page.trxsys;

import com.github.zxh.classpy.ibd.page.AbstractPage;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.base.FileTrailer;
import com.github.zxh.classpy.ibd.page.index.SegmentHeader;
import com.github.zxh.classpy.ibd.page.sys.RollbackSegmentPageNum;

public class TrxSysPage extends AbstractPage {
    private static final Integer ROLLBACK_SEGMENT_NUM = 128;
    private static final Integer EMPTY_SIZE = 13304;
    private static final Integer MASTER_LOG_INFO_SIZE = 112;
    private static final Integer EMPTY_SIZE_1 = 888;
    //private static final Integer BINARY_LOG_INFO_SIZE = 112;//innod_structure标识的大小有误？
    private static final Integer BINARY_LOG_INFO_SIZE = 12;
    //private static final Integer EMPTY_SIZE_2 = 980;//innod_structure标识的大小有误？
    private static final Integer EMPTY_SIZE_2 = 788;
    private static final Integer EMPTY_SIZE_3 = 154;

    public TrxSysPage(FileHeader fileHeader) {
        super(fileHeader);
        u8hex("transactionId");
        part("TRX_SYS FSEG Entry", SegmentHeader.class);//事务系统页所属的段
        partList("Rollback Segment", RollbackSegmentPageNum.class, ROLLBACK_SEGMENT_NUM);
        bytes("empty space", EMPTY_SIZE);
        bytes("masterLogInfo", MASTER_LOG_INFO_SIZE);
        bytes("EMPTY_1", EMPTY_SIZE_1);
        bytes("binaryLogInfo", BINARY_LOG_INFO_SIZE);
        bytes("EMPTY_2", EMPTY_SIZE_2);
        //系统表空间的extent 1 和extent 2 这两个区，也就是页号从64 ~ 191
        // 这128个页面被称为Doublewrite buffer ，也就是双写缓冲区
        part("DoublewriteBufferInfo", DoublewriteBufferInfo.class);
        bytes("EMPTY_3", EMPTY_SIZE_3);
        part("fileTrailer", FileTrailer.class);
    }
}