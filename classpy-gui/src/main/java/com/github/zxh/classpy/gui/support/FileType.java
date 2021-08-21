package com.github.zxh.classpy.gui.support;

import com.github.zxh.classpy.common.FileParser;
import com.github.zxh.classpy.ibd.SysTableSpaceParser;
import com.github.zxh.classpy.ibd.TableSpaceParser;
import javafx.scene.image.Image;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Supported file types.
 */
public enum FileType {

    FOLDER       ("/folder.png",  "Folder",              "/",       null),
    IBD   ("/ibd16.png",    "IBD",          "*.ibd", new TableSpaceParser()),
    IBDATA   ("/ibd16.png",    "ibdata",          "*.*", new SysTableSpaceParser()),
    UNKNOWN      ("/file.png",    "Unknown",             "*.*",     FileParser.NOP),
    ;

    public final Image icon;
    public final ExtensionFilter filter;
    public final FileParser parser;

    FileType(String icon,
             String description,
             String extension,
             FileParser parser) {
        this.icon = ImageHelper.loadImage(icon);
        this.filter = new ExtensionFilter(description, extension);
        this.parser = parser;
    }

    public boolean isIbdOrIbdata() {
        return this == IBD || this == IBDATA;
    }
}
