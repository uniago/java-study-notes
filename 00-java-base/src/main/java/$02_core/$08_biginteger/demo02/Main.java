package $02_core.$08_biginteger.demo02;// BigInteger to float
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("999999").pow(99);
        System.out.println(n); // 999901004850843154764304477976514369139655131740633508461194231534839921730061928165918468524559784711035127337458000315861841709428648449965581720563036528559778975449288816486108390262378384273170489214859673210348574933590756152010150151328940519978842541428941575809198981648563222986501427953560053044625798093604122762079193632166451298745515082518566720858255910313691329603648838009949658744782958530043017504914393433729464748384929764551655116938062519252825189492597754483209164432338340725827672754454905076614553527220234774443152131030423470815523140235624156848995149000098999999
        float f = n.floatValue();
        System.out.println(f); // Infinity
    }
}