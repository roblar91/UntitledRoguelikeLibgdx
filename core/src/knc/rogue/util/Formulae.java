package knc.rogue.util;

import com.artemis.E;

import java.util.Random;

public final class Formulae {
    private static Random rng = new Random();

    public static int calculateMaxHealth(E e) {
        return (int) (e.healthTotal() * (1 + e.constitutionTotal() * 0.02f));
    }

    public static int calculateMeleeDamage(E e) {
        return (int) ((rng.nextInt(3) + 2) * (1 + e.strengthTotal() * 0.01f));
    }
}