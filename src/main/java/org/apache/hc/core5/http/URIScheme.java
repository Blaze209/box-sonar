package org.apache.hc.core5.http;

import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public enum URIScheme {
    HTTP("http"),
    HTTPS("https");

    public final String id;

    URIScheme(String str) {
        this.id = (String) Args.notBlank(str, "id");
    }

    public String getId() {
        return this.id;
    }

    public boolean same(String str) {
        return this.id.equalsIgnoreCase(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.id;
    }
}
