package com.pspdfkit.document.html;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceRequest {
    private final Uri url;

    public ResourceRequest(WebResourceRequest webResourceRequest) {
        this.url = webResourceRequest.getUrl();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResourceRequest) {
            return this.url.equals(((ResourceRequest) obj).url);
        }
        return false;
    }

    public Uri getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Objects.hash(this.url);
    }

    public String toString() {
        return "ResourceRequest{url=" + this.url + AbstractJsonLexerKt.END_OBJ;
    }

    public ResourceRequest(String str) {
        this.url = Uri.parse(str);
    }
}
