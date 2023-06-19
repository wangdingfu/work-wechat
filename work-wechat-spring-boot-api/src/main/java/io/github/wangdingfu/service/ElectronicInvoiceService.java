package io.github.wangdingfu.service;

import io.github.wangdingfu.response.invoice.BatchInvoiceResponse;
import io.github.wangdingfu.response.invoice.GetInvoiceResponse;
import io.github.wangdingfu.resquest.invoice.BatchInvoiceRequest;
import io.github.wangdingfu.resquest.invoice.BatchUpdateInvoiceRequest;
import io.github.wangdingfu.resquest.invoice.GetInvoiceRequest;
import io.github.wangdingfu.resquest.invoice.UpdateInvoiceRequest;
import org.springframework.stereotype.Service;

/**
 * 电子发票
 */
@Service
public class ElectronicInvoiceService extends AbstractBaseService {

    /**
     * 查询电子发票
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 发票信息
     */
    public GetInvoiceResponse getInvoice(GetInvoiceRequest request, String applicationName) {
        return electronicInvoiceClient.getInvoice(request, applicationName);
    }

    /**
     * 更新发票状态
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void updateInvoice(UpdateInvoiceRequest request, String applicationName) {
        electronicInvoiceClient.updateInvoice(request, applicationName);
    }

    /**
     * 批量更新发票状态
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void batchUpdateInvoice(BatchUpdateInvoiceRequest request, String applicationName) {
        electronicInvoiceClient.batchUpdateInvoice(request, applicationName);
    }

    /**
     * 批量查询电子发票
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 电子发票详情
     */
    public BatchInvoiceResponse getInvoices(BatchInvoiceRequest request, String applicationName) {
        return electronicInvoiceClient.getInvoices(request, applicationName);
    }
}
