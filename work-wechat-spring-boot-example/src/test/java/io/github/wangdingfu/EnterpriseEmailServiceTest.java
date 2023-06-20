package io.github.wangdingfu;

import io.github.wangdingfu.resquest.exmail.DeleteMailGroupRequest;
import io.github.wangdingfu.resquest.exmail.MailGroupRequest;
import io.github.wangdingfu.service.EnterpriseEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 企业邮箱单元测试 企业号没授权，暂时无法自测
 */
public class EnterpriseEmailServiceTest extends AbstractTest {
    public static final String EMAIL = "email";

    @Autowired
    EnterpriseEmailService emailService;

    @Test
    public void createMailGroup() {
        MailGroupRequest request = new MailGroupRequest();
        emailService.createMailGroup(request, EMAIL);
    }

    @Test
    public void updateMailGroup() {
        MailGroupRequest request = new MailGroupRequest();
        emailService.updateMailGroup(request, EMAIL);
    }

    @Test
    public void deleteMailGroup() {
        DeleteMailGroupRequest request = new DeleteMailGroupRequest();
        emailService.deleteMailGroup(request, EMAIL);
    }
}
