package knc.rogue.util;

import com.artemis.E;

import java.util.Random;

public final class Formulae {
    private static Random rng = new Random();

    public static int calculateMaxHealth(E e) {
        return (int) (e.baseHealthBaseHealth() * (1 + e.baseConstitutionBaseConstitution() * 0.08f));
    }

    public static int calculateMeleeDamage(E e) {
        return (int) ((rng.nextInt(3) + 2) * (1 + e.baseStrengthBaseStrength() * 0.05f));
    }
}