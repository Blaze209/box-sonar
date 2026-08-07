package com.pspdfkit.document.html;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.nk;
import com.pspdfkit.internal.uw;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceResponse {
    private final String charset;
    private final InputStream inputStream;
    private final String mimeType;

    public static final class EmptyInputStream extends InputStream {
        private EmptyInputStream() {
        }

        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    }

    public ResourceResponse(InputStream inputStream, String str) {
        this(inputStream, str, StandardCharsets.UTF_8.name());
    }

    public static ResourceResponse skipResource() {
        return new ResourceResponse(new EmptyInputStream(), "application/octet-stream");
    }

    public WebResourceResponse toWebResourceResponse() {
        return new WebResourceResponse(this.mimeType, this.charset, this.inputStream);
    }

    public ResourceResponse(InputStream inputStream, String str, String str2) {
        uw.a(inputStream, "inputStream", null);
        uw.a(!TextUtils.isEmpty(str), "mimeType");
        uw.a(!TextUtils.isEmpty(str2), "charset");
        this.inputStream = inputStream;
        this.mimeType = str;
        this.charset = str2;
    }

    public ResourceResponse(DataProvider dataProvider, String str) {
        this(dataProvider, str, StandardCharsets.UTF_8.name());
    }

    public ResourceResponse(DataProvider dataProvider, String str, String str2) {
        this(new nk(dataProvider), str, str2);
    }
}
