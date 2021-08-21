package com.github.zxh.classpy.ibd;

import com.github.zxh.classpy.common.FileParser;
import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.constant.ConstantPool;

public class TableSpaceParser implements FileParser {
    @Override
    public FilePart parse(byte[] data) {
        TableSpace tb = new TableSpace();
        tb.read(new TableSpaceReader(data));
        postRead(tb, new ConstantPool());
        return tb;
    }

    private static void postRead(TableSpacePart fc, ConstantPool cp) {
        for (FilePart c : fc.getParts()) {
            postRead((TableSpacePart) c, cp);
        }
        fc.postRead(cp);
    }
}
