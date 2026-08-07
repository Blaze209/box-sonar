package org.apache.hc.core5.http.impl.bootstrap;

/* JADX INFO: loaded from: classes5.dex */
final class FilterEntry<T> {
    final String existing;
    final T filterHandler;
    final String name;
    final Position position;

    enum Position {
        BEFORE,
        AFTER,
        REPLACE,
        FIRST,
        LAST
    }

    FilterEntry(Position position, String str, T t, String str2) {
        this.position = position;
        this.name = str;
        this.filterHandler = t;
        this.existing = str2;
    }
}
