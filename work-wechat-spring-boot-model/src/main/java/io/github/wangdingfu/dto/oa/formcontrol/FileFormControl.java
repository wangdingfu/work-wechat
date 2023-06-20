package io.github.wangdingfu.dto.oa.formcontrol;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 描述 附件控件
 *
 * @author ddshuai
 * date 2021-07-16 14:25
 **/
public class FileFormControl implements ApplyFormControl {

    private List<FileData> files;

    public List<FileData> getFiles() {
        return files;
    }

    public void setFiles(List<FileData> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FileFormControl.class.getSimpleName() + "[", "]")
                .add("files=" + files)
                .toString();
    }

    @Override
    public String formControlName() {
        return "File";
    }
}
