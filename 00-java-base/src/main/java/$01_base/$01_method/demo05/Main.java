package $01_base.$01_method.demo05;

public class Main {
    public static void main(String[] args) {
        Group g = new Group();
        g.setNames(new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}); // 传入1个String[]
        g.setNames(null);
    }
}

class Group {
    private String[] names;

    public void setNames(String[] names) {
        this.names = names;
    }
}