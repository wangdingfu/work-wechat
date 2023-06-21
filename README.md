# work-wechat-spring-boot-starter

<p align="center">
	<strong>🍬封装企业微信api的框架集.</strong>
</p>
<p align="center">
	<a target="_blank" href="https://search.maven.org/artifact/io.github.wangdingfu/work-wechat-spring-boot-starter">
		<img src="https://img.shields.io/maven-central/v/io.github.wangdingfu/work-wechat-spring-boot-starter.svg?label=Maven%20Central" />
	</a>
	<a target="_blank" href="http://license.coscl.org.cn/MulanPSL2/index.html">
		<img src="https://img.shields.io/:license-MulanPSL2-blue.svg" />
	</a>
	<a target="_blank" href="https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html">
		<img src="https://img.shields.io/badge/JDK-8+-green.svg" />
	</a>

</p>


## 📚简介

封装企业微信api、让调用企业微信api变得简单


## 📦安装

### 🍊Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
    <groupId>io.github.wangdingfu</groupId>
    <artifactId>work-wechat-spring-boot-starter</artifactId>
    <version>2.3.1</version>
</dependency>
```

### 🍐Gradle
```
implementation 'io.github.wangdingfu:work-wechat-spring-boot-starter:2.3.1'
```
-------------------------------------------------------------------------------


使用示例
``` 
配置application.yml

work-wechat:
  corp-id: xxxx（企业号）
  application-list:
  - secret: Kx4sovYN5C0_MEzPY0cOymwbMhGmqdA9VjMFHrAKjdE
    agentId: 1000003
    application-name: little-helper
  - secret: DXB-FXVZNkLGUlLaIJy6CK67WD-dpN1HnPLIzNPo0N4
    agentId: 1000004
    application-name: reporter
  - secret: AfjvAed_ulqhK0OqTprDQ6xOSnqaT34ll2LsRe0D2NA
    application-name: address-book
  url: https://qyapi.weixin.qq.com
  public-path: cgi-bin

```
``` 
public class WeChatTest extends BaseTest {

    /**
    * 查询用户信息
    */
    @Test
    public void getUser(){
        weChatManager.addressBookService().getUser("13259220281", "address-book");
    }
}

实例 可以查看 work-wechat-spring-boot-example 模块
```

### 回调配置

![回调配置](https://upload-images.jianshu.io/upload_images/26817983-13eab16b4f158217.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
