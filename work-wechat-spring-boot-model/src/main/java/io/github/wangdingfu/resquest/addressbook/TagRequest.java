package io.github.wangdingfu.resquest.addressbook;

import io.github.wangdingfu.dto.addressbook.Tag;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-06 07:29
 **/
public class TagRequest extends Tag {
    @Override
    public String toString() {
        return new StringJoiner(", ", TagRequest.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .toString();
    }
}
