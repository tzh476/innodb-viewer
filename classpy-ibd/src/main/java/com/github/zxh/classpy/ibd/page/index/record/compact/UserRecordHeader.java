package com.github.zxh.classpy.ibd.page.index.record.compact;

import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.datatype.I2Hex;

/**
 * Info Flags (4 bits)
 *  * Number of Records Owned (4 bits)
 *  * Order (13 bits)
 *  * Record Type (3 bits)
 *  * Next Record Offset (2 byte)
 */
public class UserRecordHeader extends TableSpacePart {
    {
        bytes("Flags&Records Owned",1);
        bytes("Order&type",2);
        i2hex("nextOffset");
    }
}
