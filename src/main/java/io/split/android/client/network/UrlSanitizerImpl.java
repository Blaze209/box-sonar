package io.split.android.client.network;

import android.net.Uri;
import io.split.android.client.utils.logger.Logger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class UrlSanitizerImpl implements UrlSanitizer {
    @Override // io.split.android.client.network.UrlSanitizer
    public URL getUrl(URI uri) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedAuthority(uri.getAuthority()).encodedFragment(uri.getFragment()).scheme(uri.getScheme()).encodedQuery(uri.getQuery());
        try {
            builder.encodedPath(uri.getPath());
        } catch (IllegalArgumentException e) {
            Logger.e(e);
        }
        try {
            return new URL(builder.build().toString());
        } catch (MalformedURLException e2) {
            Logger.e(e2.getMessage());
            return null;
        }
    }
}
