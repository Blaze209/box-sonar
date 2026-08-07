package org.apache.hc.core5.http.message;

import java.util.Locale;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.ReasonPhraseCatalog;
import org.apache.hc.core5.http.impl.EnglishReasonPhraseCatalog;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpResponse extends HeaderGroup implements HttpResponse {
    private static final long serialVersionUID = 1;
    private int code;
    private Locale locale;
    private final ReasonPhraseCatalog reasonCatalog;
    private String reasonPhrase;
    private ProtocolVersion version;

    public BasicHttpResponse(int i, ReasonPhraseCatalog reasonPhraseCatalog, Locale locale) {
        this.code = Args.positive(i, "Status code");
        this.reasonCatalog = reasonPhraseCatalog == null ? EnglishReasonPhraseCatalog.INSTANCE : reasonPhraseCatalog;
        this.locale = locale;
    }

    public BasicHttpResponse(int i, String str) {
        this.code = Args.positive(i, "Status code");
        this.reasonPhrase = str;
        this.reasonCatalog = EnglishReasonPhraseCatalog.INSTANCE;
    }

    public BasicHttpResponse(int i) {
        this.code = Args.positive(i, "Status code");
        this.reasonPhrase = null;
        this.reasonCatalog = EnglishReasonPhraseCatalog.INSTANCE;
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void addHeader(String str, Object obj) {
        Args.notNull(str, "Header name");
        addHeader(new BasicHeader(str, obj));
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setHeader(String str, Object obj) {
        Args.notNull(str, "Header name");
        setHeader(new BasicHeader(str, obj));
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public void setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    @Override // org.apache.hc.core5.http.HttpMessage
    public ProtocolVersion getVersion() {
        return this.version;
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public int getCode() {
        return this.code;
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setCode(int i) {
        Args.positive(i, "Status code");
        this.code = i;
        this.reasonPhrase = null;
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public String getReasonPhrase() {
        String str = this.reasonPhrase;
        return str != null ? str : getReason(this.code);
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setReasonPhrase(String str) {
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.reasonPhrase = str;
    }

    @Override // org.apache.hc.core5.http.HttpResponse
    public void setLocale(Locale locale) {
        this.locale = (Locale) Args.notNull(locale, "Locale");
    }

    protected String getReason(int i) {
        ReasonPhraseCatalog reasonPhraseCatalog = this.reasonCatalog;
        if (reasonPhraseCatalog == null) {
            return null;
        }
        Locale locale = this.locale;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return reasonPhraseCatalog.getReason(i, locale);
    }

    @Override // org.apache.hc.core5.http.message.HeaderGroup
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.code).append(' ').append(this.reasonPhrase).append(' ').append(this.version);
        return sb.toString();
    }
}
