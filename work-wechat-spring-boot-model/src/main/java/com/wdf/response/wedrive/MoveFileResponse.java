package com.wdf.response.wedrive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.wedrive.FileList;
import com.wdf.response.AbstractBaseResponse;

import java.util.StringJoiner;

/**
 * @author ddshuai
 * date 2022-09-02 22:16
 **/
public class MoveFileResponse extends AbstractBaseResponse {

    @JsonProperty("file_list")
    private FileList fileList;

    public FileList getFileList() {
        return fileList;
    }

    public void setFileList(FileList fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MoveFileResponse.class.getSimpleName() + "[", "]")
                .add("fileList=" + fileList)
                .toString();
    }
}
