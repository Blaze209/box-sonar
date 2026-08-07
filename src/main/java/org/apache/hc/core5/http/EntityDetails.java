package org.apache.hc.core5.http;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface EntityDetails {
    String getContentEncoding();

    long getContentLength();

    String getContentType();

    Set<String> getTrailerNames();

    boolean isChunked();
}
