package external.sdk.pendo.io.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class GlideUrl implements f {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$[]";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final a headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    public GlideUrl(String str) {
        this(str, a.b);
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(f.a);
        }
        return this.cacheKeyBytes;
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String string = this.stringUrl;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) k.a(this.url)).toString();
            }
            this.safeStringUrl = Uri.encode(string, ALLOWED_URI_CHARS);
        }
        return this.safeStringUrl;
    }

    private URL getSafeUrl() {
        if (this.safeUrl == null) {
            this.safeUrl = new URL(getSafeStringUrl());
        }
        return this.safeUrl;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            if (getCacheKey().equals(glideUrl.getCacheKey()) && this.headers.equals(glideUrl.headers)) {
                return true;
            }
        }
        return false;
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        return str != null ? str : ((URL) k.a(this.url)).toString();
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = getCacheKey().hashCode();
            this.hashCode = iHashCode;
            this.hashCode = (iHashCode * 31) + this.headers.hashCode();
        }
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    public URL toURL() {
        return getSafeUrl();
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(getCacheKeyBytes());
    }

    public GlideUrl(String str, a aVar) {
        this.url = null;
        this.stringUrl = k.a(str);
        this.headers = (a) k.a(aVar);
    }

    public GlideUrl(URL url) {
        this(url, a.b);
    }

    public GlideUrl(URL url, a aVar) {
        this.url = (URL) k.a(url);
        this.stringUrl = null;
        this.headers = (a) k.a(aVar);
    }
}
