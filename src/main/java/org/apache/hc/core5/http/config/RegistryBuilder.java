package org.apache.hc.core5.http.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    RegistryBuilder() {
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty(str, "ID");
        Args.notNull(i, "Item");
        this.items.put(TextUtils.toLowerCase(str), i);
        return this;
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}
