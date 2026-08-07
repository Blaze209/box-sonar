package io.opentelemetry.exporter.internal;

import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public final class ExporterBuilderUtil {
    public static URI validateEndpoint(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getScheme() == null || !(uri.getScheme().equals("http") || uri.getScheme().equals("https"))) {
                throw new IllegalArgumentException("Invalid endpoint, must start with http:// or https://: " + uri);
            }
            return uri;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid endpoint, must be a URL: " + str, e);
        }
    }

    private ExporterBuilderUtil() {
    }
}
