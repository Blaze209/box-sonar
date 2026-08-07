package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.jcip.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class Resource {
    private final String content;
    private final String contentType;

    public Resource(String str, String str2) {
        this.content = (String) Objects.requireNonNull(str);
        this.contentType = str2;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }
}
