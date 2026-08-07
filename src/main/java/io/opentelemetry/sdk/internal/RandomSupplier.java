package io.opentelemetry.sdk.internal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public final class RandomSupplier {
    private RandomSupplier() {
    }

    public static Supplier<Random> platformDefault() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return AndroidFriendlyRandomHolder.INSTANCE;
        }
        return new Supplier() { // from class: io.opentelemetry.sdk.internal.RandomSupplier$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ThreadLocalRandom.current();
            }
        };
    }
}
