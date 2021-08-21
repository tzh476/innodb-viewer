package com.github.zxh.classpy.ibd.page.index.record.compact;

import com.github.zxh.classpy.ibd.TableSpacePart;

/**
 * Info Flags (4 bits)
 * Number of Records Owned (4 bits)
 * Order (13 bits)
 * Record Type (3 bits)
 * Next Record Offset (2 byte)
 * "infimum\0" (8 byte)
 * Info Flags (4 bits)
 * Number of Records Owned (4 bits)
 * Order (13 bits)
 * Record Type (3 bits)
 * Next Record Offset (2)
 * "supremum" (8)
 *
 */
public class SysRecord extends TableSpacePart {
    {
        bytes("Flags&Records Owned",1);
        bytes("Order&type",2);
        u2hex("nextOffset");
        u8("value");
    }
}
