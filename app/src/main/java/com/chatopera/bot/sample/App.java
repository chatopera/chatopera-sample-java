package com.chatopera.bot.sample;

import com.chatopera.bot.exception.ChatbotException;
import com.chatopera.bot.sdk.Chatbot;
import com.chatopera.bot.sdk.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Properties;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, ChatbotException {
        Properties props = new Properties();

        // 复制 app/src/main/resources/sample.properties 为 app/src/main/resources/sample.dev.properties
        // 修改 sample.dev.properties 的内容，注册 bot.chatopera.com/ 以及创建聊天机器人，获得 bot.clientId 和 bot.secret
        props.load(App.class.getResourceAsStream("/sample.dev.properties"));
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
             * FAQ 热门问题
             * https://docs.chatopera.com/products/chatbot-platform/howto-guides/faq-hot.html
             */
            Response result = chatbot.command("GET", "/faq/database/inquiryrank?topN=2");
            System.out.println(result.toString());
            JSONArray dataArray = (JSONArray) result.getData();
            System.out.println(dataArray.toString());

            /**
             * FAQ 知识库 接口
             * https://docs.chatopera.com/products/chatbot-platform/references/sdk/chatbot/chat.html
             */
            System.out.println("【SDK】发送请求 ...");
            JSONObject body = new JSONObject();
            body.put("fromUserId", "zhangsan");
            body.put("query", "开源许可协议");
            body.put("faqBestReplyThreshold", 0.7);
            body.put("faqSuggReplyThreshold", 0.1);

            Response result2 = chatbot.command("POST", "/faq/query", body);
            System.out.println("【SDK】打印返回结果");
            // result2.getRc() == 0 代表请求被正常处理，
            // 得到结果是 (JSONArray)result2.getData(),
            // 如果 这个 JSONArray 包含 0 个元素，就是没有和查询匹配的问答对。
            System.out.println(((JSONArray)result2.getData()).toString());

        } else {
            System.out.println("未发现配置 clientId和secret");
            System.out.println("Usage \n mvn clean compile exec:java -Dexec.mainClass=\"com.chatopera.bot.sample.App\"");
        }

    }
}
