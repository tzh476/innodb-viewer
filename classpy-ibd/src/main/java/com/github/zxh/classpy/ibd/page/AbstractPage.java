package com.github.zxh.classpy.ibd.page;

import com.github.zxh.classpy.common.FilePart;
import com.github.zxh.classpy.ibd.TableSpacePart;
import com.github.zxh.classpy.ibd.TableSpaceReader;
import com.github.zxh.classpy.ibd.page.base.FileHeader;

import java.util.List;

public class AbstractPage extends TableSpacePart {
    public AbstractPage(FileHeader fileHeader) {
        add("fileHeader", fileHeader);
    }

    /**
     * Reads content using ClassFileReader. * @param reader
     */
    protected void readContent(TableSpaceReader reader) {
        List<FilePart> fileParts = getParts();
        int size = fileParts.size();
        for (int i = 1; i < size; i++) {
            ((TableSpacePart) fileParts.get(i)).read(reader);
        }
    }
}
