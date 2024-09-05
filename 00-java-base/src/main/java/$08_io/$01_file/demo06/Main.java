package $08_io.$01_file.demo06;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(".");
        printFiles(file, 0);
    }
    public static void printFiles(File file, int deep) {
        for (File listFile : file.listFiles()) {
            String name = listFile.getName();
            if (listFile.isDirectory()) {
                System.out.println(String.format("%3d", deep) + getSpace(deep) + name + "/");
                printFiles(listFile, ++deep);
            } else {
                System.out.println(String.format("%3d", deep) + getSpace(deep) + name);
            }
        }
    }

    public static String getSpace(int deep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= deep; i++) {
            sb.append(i == 0 ? "|" : "-").append("-");
        }
        return sb.toString();
    }
}
