package com.wdf;

import com.wdf.dto.tool.ApplicationButton;
import com.wdf.enums.ButtonType;
import com.wdf.response.application.ApplicationButtonResponse;
import com.wdf.response.application.WeChatApplicationResponse;
import com.wdf.resquest.application.ApplicationButtonRequest;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 15:27
 **/
public class ApplicationServiceTest extends AbstractTest {

    public static final String OY = "oy";

    @Test
    public void getApplication() {
        WeChatApplicationResponse response = weChatManager.applicationService().getApplication("1000010", OY);
        logger.info("获取应用--{}", response);
    }

    @Test
    public void getApplicationButtons() {
        ApplicationButtonResponse response = weChatManager.applicationService().getApplicationButtons("1000010", OY);
        logger.info("获取菜单--{}", response);
    }

    @Test
    public void createApplicationButton() {
        ApplicationButtonRequest request = new ApplicationButtonRequest();

        ApplicationButton button = new ApplicationButton();
        button.setKey("jump-home");
        button.setName("主页");
        button.setType(ButtonType.VIEW);
        button.setUrl("https://www.baidu.com");

        request.setButtonList(Collections.singletonList(button));
        weChatManager.applicationService().createApplicationButton(request, "1000010", OY);
        logger.info("创建应用菜单--成功");
    }

    @Test
    public void deleteApplicationButtons() {
        weChatManager.applicationService().deleteApplicationButtons("1000010", OY);
        logger.info("删除菜单--成功");
    }
}
