package com.wdf.response.wedrive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.wedrive.FileItem;
import com.wdf.response.AbstractBaseResponse;

import java.util.StringJoiner;

/**
 * @author ddshuai
 * date 2022-09-03 06:00
 **/
public class FileInfoResponse extends AbstractBaseResponse {

    @JsonProperty("file_info")
    private FileItem fileInfo;

    public FileItem getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileItem fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FileInfoResponse.class.getSimpleName() + "[", "]")
                .add("fileInfo=" + fileInfo)
                .toString();
    }
}
