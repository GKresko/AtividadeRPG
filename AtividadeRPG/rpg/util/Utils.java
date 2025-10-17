package rpg.util;

import java.util.Random;

public class Utils {
    private static final Random rnd = new Random();

    public static int calcularDanoComCritico(int danoBase) {
        if (rnd.nextInt(100) < 10) {
            int dano = (int)Math.round(danoBase * 1.5);
            System.out.printf("CRÍTICO! dano sobe de %d para %d\n", danoBase, dano);
            return dano;
        }
        return danoBase;
    }
}
