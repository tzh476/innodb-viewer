package com.github.zxh.classpy.gui.support;

import java.net.URL;
import java.util.Arrays;

public class FileTypeInferer {

    private static final byte[] wasmMagicNumber = {0, 'a', 's', 'm'};
    private static final byte[] binaryChunkSig = {0x1B, 'L', 'u', 'a'};
    private static final byte[] classMagicNumber = {
            (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE
    };

    public static FileType inferFileType(String url) {
        url = url.toLowerCase();
        if (url.endsWith(".ibd")) {
            return FileType.IBD;
        }else if (url.contains("ibdata")) {
            return FileType.IBDATA;
        } else {
            return FileType.UNKNOWN;
        }
    }

    public static FileType inferFileType(byte[] data) {
        if (data.length >= 4) {
            byte[] magicNumber = Arrays.copyOf(data, 4);
            //todo
        }
        return FileType.UNKNOWN;
    }

}
