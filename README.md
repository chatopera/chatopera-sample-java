<p align="center">
  <b>Chatopera开发者平台：809987971， <a href="https://jq.qq.com/?_wv=1027&k=5S51T2a" target="_blank">点击链接加入群聊</a></b><br>
  <img src="https://user-images.githubusercontent.com/3538629/48062941-7e32c780-e1fe-11e8-9d51-8702de9a16ed.png" width="200">
</p>


# chatopera-sample-java
企业聊天机器人-Java端示例程序

本教程介绍如何使用Chatopera机器人开发者平台的Java SDK与机器人进行集成，阅读本教程需要20分钟时间。

[获取源码](#获取源码)

[安装](#安装)

[创建机器人](#创建机器人)

[执行程序](#执行程序)

[开发者文档](#开发者文档)

[更多SDK](#更多SDK)

[开源许可协议](#开源许可协议)

## 获取源码


```
git clone https://github.com/chatopera/chatopera-sample-java.git
```

## 安装

```
cd chatopera-sample-java/app
mvn install
```


<p align="center">
  <b>登录Chatopera聊天机器人平台</b><br>
  <a href="http://bot.chatopera.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/3538629/48039685-e35fcc00-e1b0-11e8-81a9-f26d744fcd1d.png" width="800">
  </a>
</p>


## 创建机器人

### 点击“立即使用”

第一登录输入“邮箱”和“密码”，点击“回车键”，完成账户创建。

### 创建聊天机器人

点击“创建机器人”，并填入下面各项：

| 项目 | 值 | 描述 |
| --- | --- | --- |
| 机器人名称 | 小松 | 机器人的名字 |
| 描述 | 机器人示例 | 机器人的描述 |
| 语言 | zh_CN | 机器人的语言，目前支持中文(zh_CN)和英文(en_US) |

【提示】其它项如兜底回复，问候语可以在创建后，设置页面修改。


### 下载知识库文件

下载知识库示例文件[保全作业中常见问题.csv](https://raw.githubusercontent.com/chatopera/chatbot-sales/master/%E4%BF%9D%E9%99%A9/faq/%E4%BF%9D%E5%85%A8%E4%BD%9C%E4%B8%9A%E4%B8%AD%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98.csv)，保存文件名为*保全作业中常见问题.csv*。


### 导入知识库

<p align="center">
  <b>上传知识库文件</b><br>
  <a href="http://bot.chatopera.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/3538629/48044619-c97db380-e1c7-11e8-841b-b00ca6e29185.png" width="500">
  </a>
</p>

选择*保全作业中常见问题.csv*，这时，会显示问答对列表，点击“提交”，在进度条完成后，知识库导入成功。

### 测试知识库

<p align="center">
  <b>知识库测试窗口</b><br>
  <a href="http://bot.chatopera.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/3538629/48043965-5161be80-e1c4-11e8-99c6-53f36fc5e29a.png" width="300">
  </a>
</p>

**输入：** 保全作业中常见问题 

确认得到回复。

### 获取*ClientId*和*Secret*

集成机器人服务的方式是通过SDK，每个机器人实例需要通过*ClientId*和*Secret*初始化，完成认证和授权。打开机器人【设置】页面，拷贝*ClientId*和*Secret*。


<p align="center">
  <b>显示Secret</b><br>
  <a href="http://bot.chatopera.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/3538629/48044641-f4680780-e1c7-11e8-889e-01df6b0cbd7f.png" width="800">
  </a>
</p>


## 执行程序


在完成如上步骤后，修改程序的配置文件，使用文本编辑器打开```src/main/resources/sample.properties```，并设置如下内容：

```
chatbot.clientId=机器人的ClientId
chatbot.secret=机器人的Secret
```

然后执行命令

```
cd chatopera-sample-java/app
mvn install
mvn clean compile exec:java -Dexec.mainClass="com.chatopera.bot.sample.App"
```

得到返回结果为

```
{
  "rc": 0,
  "data": [
    {
      "score": 1,
      "post": " 保全作业中常见问题",
      "id": "AWbnZqarlisN5CGJnl0M",
      "reply": " 按照条款第18条规定：“合同有效期内可申请增加保额”。因此\n隔论年金是否给付，客户均可申请办理加保，同时公司从风险防范的角度出发，又对该保全项目做了如下规定：1、   申请加保时仍在主险缴费期内；2、  加保次数不限，但需相\n  2年以上；3、  每次加保的保额不得超过申请时保险金额的20%；4、  危险保额必须符合投保规则，加保需经本公司审核同意；5、  必须征得被保人同意。"
    },
    {
      "score": 0.36363636363636365,
      "post": " 为何一次保全作业形成两个内容相同的批文？",
      "id": "AWbnZqzilisN5CGJnl0X",
      "reply": " 主要是电脑软件性能问题，需要报总公司查询出错原因。"
    }]
}
```

以上。

## 开发者文档

关于项目配置，机器人的Java接口等更多细节，请参考[开发者文档](https://github.com/chatopera/chatopera-sample-java/wiki)。

## 更多SDK


<p align="center">
  <b>集成面板</b><br>
  <a href="http://bot.chatopera.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/3538629/48044669-1e212e80-e1c8-11e8-918c-8e6fdf4e95c0.png" width="800">
  </a>
</p>


## Trouble Shooting

1. ```mvn install```抛出异常，SunCertPathBuilderException

```
sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
```

[解决方案](https://github.com/chatopera/chatopera-sample-java/issues/1)


2. 运行程序，得到如下返回结果

```
clientId foo
secret bar
{"rc":1,"error":"invalid appId."}
```

这是因为```clientId```和```secret```配置不正确。请确保该值是写入```src/main/resources/sample.properties```的有效的聊天机器人配置。



## 开源许可协议

Copyright (2018) [北京华夏春松科技有限公司](https://www.chatopera.com/)

[Apache License Version 2.0](./LICENSE)

Copyright 2017-2018, [北京华夏春松科技有限公司](https://www.chatopera.com/). All rights reserved. This software and related documentation are provided under a license agreement containing restrictions on use and disclosure and are protected by intellectual property laws. Except as expressly permitted in your license agreement or allowed by law, you may not use, copy, reproduce, translate, broadcast, modify, license, transmit, distribute, exhibit, perform, publish, or display any part, in any form, or by any means. Reverse engineering, disassembly, or decompilation of this software, unless required by law for interoperability, is prohibited.

[![chatoper banner][co-banner-image]][co-url]

[co-banner-image]: https://user-images.githubusercontent.com/3538629/42383104-da925942-8168-11e8-8195-868d5fcec170.png
[co-url]: https://www.chatopera.com