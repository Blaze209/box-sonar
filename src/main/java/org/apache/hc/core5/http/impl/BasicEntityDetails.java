package org.apache.hc.core5.http.impl;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;

/* JADX INFO: loaded from: classes5.dex */
public final class BasicEntityDetails implements EntityDetails {
    private final ContentType contentType;
    private final long len;

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return false;
    }

    public BasicEntityDetails(long j, ContentType contentType) {
        this.len = j;
        this.contentType = contentType;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.len;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }
}
