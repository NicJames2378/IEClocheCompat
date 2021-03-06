package com.nicjames2378.IEClocheCompat.utils;

import java.util.Random;

public class MathUtils {
    public static float normalizeToRange (float oldMin, float oldMax, float newMin, float newMax, float value) {
        return (
                ((value - oldMin)/(oldMax - oldMin))*(newMax - newMin) + newMin
                );
    }

    public static int getAmountToAddOrSubtract(int maxSubtracted, int maxAdded) {
        Random r = new Random();
        //                 ((Add for upper bound)     + 1 make upper bound inclusive) -maxSub to fix offset
        //                      Gets absolute values to prevent negativity issues. Probably worth mentioning...
        return (r.nextInt((Math.abs(maxSubtracted) + Math.abs(maxAdded))) + 1) - maxSubtracted;
    }

    public static int clampValue(float min, float max, float value) {
        if (value < min) {
            value = min;
        } else if (value > max) {
            value = max;
        }
        return (int)value;
    }

    public static float roundToPortion(float coefficient, float value) {
        return Math.round(value*coefficient)/coefficient;
    }

    public static boolean testChanceIn(int percentChance, int outOf) {
        Random r = new Random();
        // gives us an X in outOf chance, inclusive to both ends.
        return r.nextInt(outOf + 1) + 1 <= percentChance;
    }
}
