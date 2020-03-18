package knc.rogue.util;

import com.artemis.E;
import squidpony.squidmath.RNG;

public final class Formulae {
    private static RNG rng = new RNG();

    public static int calculateMaxHealth(E e) {
        return (int) (e.healthTotal() * (1 + e.constitutionTotal() * 0.02f));
    }

    public static int calculateMeleeDamage(E e) {
        return (int) (rng.between(2, 6) * (1 + e.strengthTotal() * 0.01f));
    }
}