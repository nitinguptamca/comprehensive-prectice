package com.comprehensive.practice.InterviewQA;

/**
 * <h1>This class implements the Map interface with a hash table,
 * using reference-equality in place of object-equality when comparing keys (and values). In other words, in an IdentityHashMap, two keys k1 and k2 are considered equal if and only if (k1==k2).
 * <br><br>
 * This class is not a general-purpose Map implementation! While this class implements the Map interface, it intentionally violates Map's general contract, which mandates the use of the equals method when comparing objects. This class is designed for use only in the rare cases wherein reference-equality semantics are required.
 * </h1>
 * <h2>
 *     2. Unlike HashMap, who uses hashcode to find bucket location, IdentityHashMap also doesn't use hashCode() instead it uses System.identityHashCode(object).
 * <br><br>
 * 3) Another key difference between IdentityHashMap and HashMap in Java is Speed. Since IdentityHashMap doesn't use equals() its comparatively faster than HashMap for object with expensive equals() and hashCode().
 *
 *
 * Read more: https://javarevisited.blogspot.com/2013/01/difference-between-identityhashmap-and-hashmap-java.html#ixzz83CO1Y8wJ
 *
 * </h2>
 */
public class IdentityHashMapPurposeAndUseConcept {
}
