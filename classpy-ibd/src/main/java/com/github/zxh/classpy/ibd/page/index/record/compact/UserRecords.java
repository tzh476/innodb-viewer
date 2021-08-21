package com.github.zxh.classpy.ibd.page.index.record.compact;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.datatype.UInt;
import com.github.zxh.classpy.ibd.page.base.FileHeader;
import com.github.zxh.classpy.ibd.page.index.IndexPageHeader;


public class UserRecords extends TableSpacePart {
    private final FileHeader fileHeader;
    private final IndexPageHeader pageHeader;
    private final SysRecord infimum;


    public UserRecords(FileHeader fileHeader, IndexPageHeader pageHeader, SysRecord sysRecord) {
        this.fileHeader = fileHeader;
        this.pageHeader = pageHeader;
        this.infimum = sysRecord;
    }

    @Override
    protected void readContent(TableSpaceReader reader) {

        //该方法判断最后一条记录存疑，最后一条实际记录的nextOffset是0xFED2,是有符号数？改用其他pageHeader的记录数处理
        //        Integer nextOffset = ((UInt)infimum.getParts().get(2)).getValue();
        //        Integer num = 0;
        //        while (nextOffset != 0){
        //            UserRecord record = new UserRecord();
        //            add(num++ + "", record);
        //            record.read(reader);
        //            nextOffset = ((UInt)record.getParts().get(0).getParts().get(2)).getValue();
        //        }
        Integer recordNum = ((UInt) pageHeader.getParts().get(8)).getValue();
        for (int i = 0; i < recordNum; i++) {
            UserRecord record = new UserRecord();
            add(i + "", record);
            record.read(reader);
        }
    }

}
