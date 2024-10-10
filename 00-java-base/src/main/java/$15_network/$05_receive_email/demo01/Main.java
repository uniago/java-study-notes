package $15_network.$05_receive_email.demo01;

import com.sun.mail.pop3.POP3SSLStore;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeUtility;

import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, MessagingException {
        // 准备登录信息:
        String host = "pop3.example.com";
        int port = 995;
        String username = "bob@example.com";
        String password = "password";

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "pop3"); // 协议名称
        props.setProperty("mail.pop3.host", host);// POP3主机名
        props.setProperty("mail.pop3.port", String.valueOf(port)); // 端口号
        // 启动SSL:
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", String.valueOf(port));

        // 连接到Store:
        URLName url = new URLName("pop3", host, port, "", username, password);
        Session session = Session.getInstance(props, null);
        session.setDebug(true); // 显示调试信息
        Store store = new POP3SSLStore(session, url);
        store.connect();

        receive(store);

        store.close();
    }

    private static void receive(Store store) throws IOException, MessagingException {
        // 获取收件箱:
        Folder folder = store.getFolder("INBOX");
        // 以读写方式打开:
        folder.open(Folder.READ_WRITE);
        // 打印邮件总数/新邮件数量/未读数量/已删除数量:
        System.out.println("Total messages: " + folder.getMessageCount());
        System.out.println("New messages: " + folder.getNewMessageCount());
        System.out.println("Unread messages: " + folder.getUnreadMessageCount());
        System.out.println("Deleted messages: " + folder.getDeletedMessageCount());
        // 获取每一封邮件:
        Message[] messages = folder.getMessages();
        for (Message message : messages) {
            // 打印每一封邮件:
            printMessage((MimeMessage) message);
        }

        folder.close(true); // 传入true表示删除操作会同步到服务器上（即删除服务器收件箱的邮件）
    }

    private static void printMessage(MimeMessage msg) throws IOException, MessagingException {
        // 邮件主题:
        System.out.println("Subject: " + MimeUtility.decodeText(msg.getSubject()));
        // 发件人:
        Address[] froms = msg.getFrom();
        InternetAddress address = (InternetAddress) froms[0];
        String personal = address.getPersonal();
        String from = personal == null ? address.getAddress() : (MimeUtility.decodeText(personal) + " <" + address.getAddress() + ">");
        System.out.println("From: " + from);
        // 继续打印收件人:
    }

    String getBody(Part part) throws MessagingException, IOException {
        if (part.isMimeType("text/*")) {
            // Part是文本:
            return part.getContent().toString();
        }
        if (part.isMimeType("multipart/*")) {
            // Part是一个Multipart对象:
            Multipart multipart = (Multipart) part.getContent();
            // 循环解析每个子Part:
            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String body = getBody(bodyPart);
                if (!body.isEmpty()) {
                    return body;
                }
            }
        }
        return "";
    }


}
