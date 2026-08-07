package androidx.webkit;

import android.webkit.WebResourceResponse;
import androidx.webkit.internal.WebViewFeatureInternal;
import com.pspdfkit.internal.n70$a$$ExternalSyntheticRecord0;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: loaded from: classes9.dex */
public class WebResourceResponseCompat {
    private List<String> mCookies = Collections.emptyList();
    private final WebResourceResponse mWrapped;

    public static WebResourceResponseCompat toWebResourceResponseCompat(WebResourceResponse webResourceResponse) {
        int statusCode = webResourceResponse.getStatusCode();
        String reasonPhrase = webResourceResponse.getReasonPhrase();
        if (statusCode < 100) {
            statusCode = 200;
        }
        int i = statusCode;
        if (reasonPhrase == null) {
            reasonPhrase = SemanticAttributes.OtelStatusCodeValues.OK;
        }
        return new WebResourceResponseCompat(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), i, reasonPhrase, webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
    }

    public WebResourceResponseCompat(String str, String str2, InputStream inputStream) {
        WebResourceResponse webResourceResponse = new WebResourceResponse(str, str2, inputStream);
        this.mWrapped = webResourceResponse;
        webResourceResponse.setResponseHeaders(Map.of());
    }

    public WebResourceResponseCompat(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this.mWrapped = new WebResourceResponse(str, str2, i, str3, map == null ? Map.of() : map, inputStream);
    }

    public WebResourceResponse toWebResourceResponse() {
        HashMap map;
        Map<String, String> responseHeaders = this.mWrapped.getResponseHeaders();
        if (responseHeaders != null) {
            map = new HashMap(responseHeaders);
        } else {
            map = new HashMap();
        }
        HashMap map2 = map;
        if (!this.mCookies.isEmpty()) {
            map2.put(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_HEADER_NAME, serializeMultiCookieHeader(this.mCookies));
        }
        int statusCode = this.mWrapped.getStatusCode();
        String reasonPhrase = this.mWrapped.getReasonPhrase();
        if (statusCode < 100) {
            statusCode = 200;
            reasonPhrase = SemanticAttributes.OtelStatusCodeValues.OK;
        }
        return new WebResourceResponse(this.mWrapped.getMimeType(), this.mWrapped.getEncoding(), statusCode, reasonPhrase, map2, this.mWrapped.getData());
    }

    public void setMimeType(String str) {
        this.mWrapped.setMimeType(str);
    }

    public String getMimeType() {
        return this.mWrapped.getMimeType();
    }

    public void setEncoding(String str) {
        this.mWrapped.setEncoding(str);
    }

    public String getEncoding() {
        return this.mWrapped.getEncoding();
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        this.mWrapped.setStatusCodeAndReasonPhrase(i, str);
    }

    public int getStatusCode() {
        return this.mWrapped.getStatusCode();
    }

    public String getReasonPhrase() {
        return this.mWrapped.getReasonPhrase();
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mWrapped.setResponseHeaders(map);
    }

    public Map<String, String> getResponseHeaders() {
        return this.mWrapped.getResponseHeaders();
    }

    public void setData(InputStream inputStream) {
        this.mWrapped.setData(inputStream);
    }

    public InputStream getData() {
        return this.mWrapped.getData();
    }

    public void setCookies(List<String> list) {
        if (!WebViewFeatureInternal.COOKIE_INTERCEPT.isSupportedByWebView()) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
        this.mCookies = list;
    }

    public List<String> getCookies() {
        return this.mCookies;
    }

    private String serializeMultiCookieHeader(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (!n70$a$$ExternalSyntheticRecord0.m14052m(str)) {
                if (sb.length() > 0) {
                    sb.append("\u0000");
                }
                sb.append(str.trim());
            }
        }
        return sb.toString();
    }
}
