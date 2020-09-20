<p align="center">
  <b>Chatopera开发者平台：809987971， <a href="https://jq.qq.com/?_wv=1027&k=5S51T2a" target="_blank">点击链接加入群聊</a></b><br>
  <img src="https://user-images.githubusercontent.com/3538629/48105854-0bfcca00-e274-11e8-8eb4-ffb46a2c9179.png" width="200">
</p>

# chatopera-sample-java

企业聊天机器人-Java 端示例程序

本教程介绍如何使用 Chatopera 机器人开发者平台的 Java SDK 与机器人进行集成，阅读本教程需要 20 分钟时间。

## 快速开始

参考[系统集成#快速开始](https://docs.chatopera.com/products/chatbot-platform/integration.html#%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B)，并完成`注册账号`-`创建机器人`-`导入知识库文件`-`获取ClientId和Secret`几个步骤。

## 获取源码

```
git clone https://github.com/chatopera/chatopera-sample-java.git
```

## 安装

```
cd chatopera-sample-java/app
mvn install
```

## 执行程序

在完成如上步骤后，修改程序的配置文件，使用文本编辑器打开`src/main/resources/sample.properties`，并设置如下内容：

```
bot.clientId=机器人的ClientId
bot.secret=机器人的Secret
```

然后执行命令

```
cd chatopera-sample-java/app
mvn clean compile exec:java -Dexec.mainClass="com.chatopera.bot.sample.App"
```

可以看到控制台打印从知识库获得的回复，程序执行完毕，以上。

## 开发者文档

关于项目配置，机器人的 Java 接口等更多细节，请参考[开发者文档](https://github.com/chatopera/chatopera-sample-java/wiki)。

## Trouble Shooting

参考[文档中心/系统集成/常见问题](https://docs.chatopera.com/products/chatbot-platform/integration.html#%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)。

## 开源许可协议

Copyright (2018-2020) [北京华夏春松科技有限公司](https://www.chatopera.com/)

[Apache License Version 2.0](./LICENSE)

Copyright 2018-2020, [北京华夏春松科技有限公司](https://www.chatopera.com/). All rights reserved. This software and related documentation are provided under a license agreement containing restrictions on use and disclosure and are protected by intellectual property laws. Except as expressly permitted in your license agreement or allowed by law, you may not use, copy, reproduce, translate, broadcast, modify, license, transmit, distribute, exhibit, perform, publish, or display any part, in any form, or by any means. Reverse engineering, disassembly, or decompilation of this software, unless required by law for interoperability, is prohibited.

[![chatoper banner][co-banner-image]][co-url]

[co-banner-image]: https://user-images.githubusercontent.com/3538629/42383104-da925942-8168-11e8-8195-868d5fcec170.png
[co-url]: https://www.chatopera.com
