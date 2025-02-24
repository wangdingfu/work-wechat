package io.github.wangdingfu.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-14 13:41
 **/
@XmlAccessorType(XmlAccessType.FIELD)
public class NotifyNodes {

    @XmlElement(name = "NotifyNode")
    private List<NotifyNode> notifyNodes;

    public List<NotifyNode> getNotifyNodes() {
        return notifyNodes;
    }

    public void setNotifyNodes(List<NotifyNode> notifyNodes) {
        this.notifyNodes = notifyNodes;
    }
}
