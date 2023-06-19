package com.wdf.client;

/**
 * 通用信息
 *
 * @author ddshuai
 * date 2022-08-31 22:22
 **/
public interface CommonClient {
    String HEAD_KEY = "app";
    String HEAD = HEAD_KEY + "={app}";
    String ACCESS_TOKEN = "access_token";
    String GET_TOKEN = "/gettoken";
    String DOWNLOAD_FILE_PATH = "downloadFilePath";
    String DEBUG = "debug";
}
