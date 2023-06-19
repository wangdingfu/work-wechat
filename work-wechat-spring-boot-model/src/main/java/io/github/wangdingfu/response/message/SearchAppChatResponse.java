package io.github.wangdingfu.response.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.message.ChatInfo;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 19:07
 **/
public class SearchAppChatResponse extends AbstractBaseResponse {
    @JsonProperty("chat_info")
    private ChatInfo chatInfo;

    public ChatInfo getChatInfo() {
        return chatInfo;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SearchAppChatResponse.class.getSimpleName() + "[", "]")
                .add("chatInfo=" + chatInfo)
                .toString();
    }
}
