/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.configure;

public class ToolExt {

    /**
     * 后缀名转换
     * @param ext
     * @return
     */
    public static String suffix(String ext){
        String type = null;
        switch (ext){
            case ".doc":
            case ".docx":
                type = "word";
                break;
            case ".pptx":
            case ".ppt":
                type = "ppt";
                break;
            case  ".xls":
            case  ".xlsx":
                type = "ruled";
                break;
            case "txt":
                type = "text";
                break;
            case ".jpg":
            case ".jpeg":
            case ".png":
            case ".pdf":
                type = "image";
                break;
            case ".mp3":
            case ".flac":
            case ".ape":
                type = "music";
                break;
        }
        return type;
    }
}
