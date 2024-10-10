package $15_network.$04_send_email.demo01;

import jakarta.activation.DataHandler;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        // 服务器地址:
        String smtp = "smtp.office365.com";
        // 登录用户名:
        String username = "jxsmtp101@outlook.com";
        // 登录口令:
        String password = "********";
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        sendText(session);
    }

    private static void sendText(Session session) {
        try {
            MimeMessage message = new MimeMessage(session);
            // 设置发送方地址:
            message.setFrom(new InternetAddress("me@example.com"));
            // 设置接收方地址:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("xiaoming@somewhere.com"));
            // 设置邮件主题:
            message.setSubject("Hello", "UTF-8");
            // 设置邮件正文:
            // message.setText("Hi Xiaoming...", "UTF-8");
            message.setText("Hi Xiaoming...", "UTF-8", "html");
            // sendMime(message, Main.class.getResourceAsStream("/image.jpg"), "image.jpg");
            // sendInnerImg(message, Main.class.getResourceAsStream("/image.jpg"), "image.jpg");
            // 发送:
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendMime(Message message, InputStream input, String fileName) {
        try {
            Multipart multipart = new MimeMultipart();
            // 添加text:
            BodyPart textpart = new MimeBodyPart();
            textpart.setContent("Hello", "text/html;charset=utf-8");
            multipart.addBodyPart(textpart);
            // 添加image:
            BodyPart imagepart = new MimeBodyPart();
            imagepart.setFileName(fileName);
            imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
            multipart.addBodyPart(imagepart);
            // 设置邮件内容为multipart:
            message.setContent(multipart);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendInnerImg(Message message, InputStream input, String fileName) {
        try {
            Multipart multipart = new MimeMultipart();
            // 添加text:
            BodyPart textpart = new MimeBodyPart();
            textpart.setContent("<h1>Hello</h1><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
            multipart.addBodyPart(textpart);
            // 添加image:
            BodyPart imagepart = new MimeBodyPart();
            imagepart.setFileName(fileName);
            imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "image/jpeg")));
            // 与HTML的<img src="cid:img01">关联:
            imagepart.setHeader("Content-ID", "<img01>");
            multipart.addBodyPart(imagepart);

            message.setContent(multipart);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
