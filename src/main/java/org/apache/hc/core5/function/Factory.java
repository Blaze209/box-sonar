package org.apache.hc.core5.function;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface Factory<P, T> {
    T create(P p);
}
