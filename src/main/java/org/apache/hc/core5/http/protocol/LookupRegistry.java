package org.apache.hc.core5.http.protocol;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface LookupRegistry<T> {
    T lookup(String str);

    void register(String str, T t);

    void unregister(String str);
}
