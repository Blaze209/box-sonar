package org.apache.hc.core5.function;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface Resolver<I, O> {
    O resolve(I i);
}
