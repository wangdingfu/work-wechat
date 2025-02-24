package io.github.wangdingfu.event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-11-25 12:34
 **/

@XmlRootElement(name = "xml")
public class KfMsgOrEventData extends BaseEventData {

    @XmlElement(name = "Token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
