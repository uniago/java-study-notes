package $07_collection.$09_set.demo04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Message> received = List.of(
            new Message(1, "Hello!"),
            new Message(2, "发工资了吗？"),
            new Message(2, "发工资了吗？"),
            new Message(3, "去哪吃饭？"),
            new Message(3, "去哪吃饭？"),
            new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        TreeSet<Message> messageSet = new TreeSet<>(new Comparator<Message> () {
            @Override
            public int compare(Message o1, Message o2) {
                return Integer.compare(o1.sequence, o2.sequence);
            }
        });
        received = new ArrayList<>(received);
        ListIterator<Message> it = received.listIterator();
        while(it.hasNext()) {
            if (!messageSet.add(it.next())) {
                it.remove();
            }
        }
        return received;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}