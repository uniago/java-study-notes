package $03_exception.$02_catch_exception.demo1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        try {
            process1();
            process2();
            process3();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad encoding");
        } catch (IOException e) {
            System.out.println("IO error");
        }

        try {
            process1();
            process2();
            process3();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Bad encoding");
        } catch (IOException e) {
            System.out.println("IO error");
        } finally {
            System.out.println("END");
        }

        try {
            process1();
            process2();
            process3();
        } catch (IOException | NumberFormatException e) {
            // IOException或NumberFormatException
            System.out.println("Bad input");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

    private static void process1() throws UnsupportedEncodingException {
        // ...
        System.out.println("process1");
    }
    private static void process2() throws IOException {
        // ...
        System.out.println("process2");
    }

    private static void process3() throws NumberFormatException {
        // ...
        System.out.println("process3");
    }
}
