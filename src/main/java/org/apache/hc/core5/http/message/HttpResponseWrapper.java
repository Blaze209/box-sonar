package org.apache.hc.core5.http.message;

import java.util.Locale;
import org.apache.hc.core5.http.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public class HttpResponseWrapper extends AbstractMessageWrapper<HttpResponse> implements HttpResponse {
    public HttpResponseWrapper(HttpResponse httpResponse) {
        super(httpResponse);
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public int getCode() {
        return getMessage().getCode();
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setCode(int i) {
        getMessage().setCode(i);
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public String getReasonPhrase() {
        return getMessage().getReasonPhrase();
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setReasonPhrase(String str) {
        getMessage().setReasonPhrase(str);
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public Locale getLocale() {
        return getMessage().getLocale();
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setLocale(Locale locale) {
        getMessage().setLocale(locale);
    }
}
