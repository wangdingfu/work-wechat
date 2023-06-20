package io.github.wangdingfu;

import io.github.wangdingfu.callback.AbstractCallBackChain;
import io.github.wangdingfu.enums.ChangeType;
import io.github.wangdingfu.event.BaseEventData;
import io.github.wangdingfu.event.UserEventData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述 处理通讯录回调
 *
 * @author ddshuai
 * date 2021-07-20 16:10
 **/

@Component
public class AddressBookCallBack extends AbstractCallBackChain {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean match(String applicationName, BaseEventData eventData) {
        logger.info("回调的应用为--{}", applicationName);
        return "address-book".equals(applicationName);
    }

    @Override
    public void handle(String applicationName, BaseEventData eventData) {
        logger.info("change-type---{}", eventData.getChangeType());
        if (ChangeType.UPDATE_USER.getChangeType().equals(eventData.getChangeType())) {
            UserEventData userEventData = (UserEventData) eventData;
            logger.info("更新的用户数据为--{}", userEventData);
        }
    }
}
