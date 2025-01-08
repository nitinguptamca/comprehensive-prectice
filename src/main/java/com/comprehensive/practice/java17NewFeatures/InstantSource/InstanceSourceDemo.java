package com.comprehensive.practice.java17NewFeatures.InstantSource;

import java.time.Instant;
import java.time.InstantSource;

/**
 * public interface InstantSource<br>
 * <h1>provides a pluggable representation of the current instant.<br>
 * to provide a safe way to access the current instant</h1>
 * <br>For example, InstantSource can be used instead of System.currentTimeMillis().<br>
 *
 *
 */
public class InstanceSourceDemo {
    public static void main(String[] args) {
        var quickTest = new AQuickTest(InstantSource.system());
        quickTest.getInstant();
    }
}

class AQuickTest {
    InstantSource source;

    public AQuickTest(InstantSource system) {
        source=system;
    }

    Instant getInstant() {
        return source.instant();
    }
}

class InstantExample {
    InstantSource instantSource;
    Instant getCurrentInstantFromInstantSource() {
        return instantSource.instant();
    }
}
