package knc.rogue.util;

import com.artemis.E;

public final class Formulae {
    public static int calculateMaxHealth(E e) {
        return (int) (e.baseHealthBaseHealth() * (1 + e.baseConstitutionBaseConstitution() * 0.05f));
    }

    public static int calculateMeleeDamage(E e) {
        return (int) (5 * (1 + e.baseStrengthBaseStrength()));
    }
}
