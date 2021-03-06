package com.chatopera.bot.sample;

import com.chatopera.bot.exception.ChatbotException;
import com.chatopera.bot.sdk.Chatbot;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Properties;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, ChatbotException {
        Properties props = new Properties();

        props.load(App.class.getResourceAsStream("/sample.properties"));
        String clientId = props.get("bot.clientId").toString();
        String secret = props.get("bot.secret").toString();

        // 尝试从环境变量加载
        if ((System.getenv("BOT_CLIENT_ID") != null) && (System.getenv("BOT_CLIENT_SECRET") != null)) {
            clientId = System.getenv("BOT_CLIENT_ID");
            secret = System.getenv("BOT_CLIENT_SECRET");
        }

        if (clientId != null && secret != null) {
            System.out.println("【SDK】获取到clientId 和 secret:");
            System.out.println("clientId " + clientId);
            System.out.println("secret " + secret);
            Chatbot chatbot = new Chatbot(clientId, secret);

            /**
             * FAQ 知识库 接口
             */
            System.out.println("【SDK】发送请求 ...");
            JSONObject response = chatbot.faq("javasdk", "不锈钢板现在是什么价格");
            System.out.println("【SDK】打印返回结果");
            System.out.println(response.toString());

        } else {
            System.out.println("未发现配置 clientId和secret");
            System.out.println("Usage \n mvn clean compile exec:java -Dexec.mainClass=\"com.chatopera.bot.sample.App\"");
        }

    }
}
