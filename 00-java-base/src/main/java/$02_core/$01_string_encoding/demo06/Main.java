package $02_core.$01_string_encoding.demo06;// int[]
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
        // this.scores = scores;
        this.scores = scores.clone();
        // this.scores = Arrays.copyOf(scores, scores.length);
        // int[] ints = new int[scores.length];
        // for (int i = 0; i < scores.length; i++) {
        //     ints[i] = scores[i];
        // }
        // this.scores = ints;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}