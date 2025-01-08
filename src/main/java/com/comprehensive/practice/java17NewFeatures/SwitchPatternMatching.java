package com.comprehensive.practice.java17NewFeatures;

import com.comprehensive.practice.java17NewFeatures.sealed.Circle;
import com.comprehensive.practice.java17NewFeatures.sealed.Triangle;

/**
 * <li>
 *     Restore Always-Strict Floating-Point Semantics
 *     The default floating-point operations are strict or strictfp, both of which guarantee the same results from the floating-point
 *     calculations on every platform.</li>
 *      <li>Enhanced Pseudo-Random Number Generators</li>
 *      <li>Deprecate the Applet API for Removal</li>
 *      <li>Remove the Experimental AOT and JIT Compiler </li>
 *      <li>Deprecate the Security Manager for Removal  </li>
 *
 */
public class SwitchPatternMatching {
  /*  static float getFloat(Object o) {
        return switch (o) {
            case Integer i -> i.floatValue();
            case Double d -> d.floatValue();
            case String s -> Float.parseFloat(s);
            default -> 0f;
        };
    }

    public static void main(String[] args) {
        System.out.println("Integer : "+getFloat(12));
        System.out.println("Double : "+getFloat(12.33d));
        System.out.println("String : "+getFloat("22.32"));

    }*/
}
