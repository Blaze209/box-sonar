package org.apache.hc.core5.http;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponse extends HttpMessage {
    int getCode();

    Locale getLocale();

    String getReasonPhrase();

    void setCode(int i);

    void setLocale(Locale locale);

    void setReasonPhrase(String str);
}
