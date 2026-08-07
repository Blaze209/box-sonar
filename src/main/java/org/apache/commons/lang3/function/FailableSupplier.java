package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface FailableSupplier<R, E extends Throwable> {
    R get() throws Throwable;
}
