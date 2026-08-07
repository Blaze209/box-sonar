package io.split.android.client.storage.common;

/* JADX INFO: loaded from: classes4.dex */
public interface Storage<T> {
    void clearInMemory();

    void enablePersistence(boolean enabled);

    void push(T element);
}
