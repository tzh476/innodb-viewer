package com.github.zxh.classpy.ibd.page.index.record.compact;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 * Info Flags (4 bits)
 *  * Number of Records Owned (4 bits)
 *  * Order (13 bits)
 *  * Record Type (3 bits)
 *  * Next Record Offset (2 byte)
 */
public class UserRecord extends TableSpacePart {
    {
        UserRecordHeader header = new UserRecordHeader();
        add("UserRecordHeader", header);
        add("UserRecordBody", new UserRecordBody(header));

    }
}
