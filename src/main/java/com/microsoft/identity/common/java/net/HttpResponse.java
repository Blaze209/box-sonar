package com.microsoft.identity.common.java.net;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.jcip.annotations.Immutable;

/* JADX INFO: loaded from: classes14.dex */
@Immutable
public class HttpResponse {
    private final Date mDate;
    private final String mResponseBody;
    private final Map<String, List<String>> mResponseHeaders;
    private final int mStatusCode;

    public HttpResponse(int i, String str, Map<String, List<String>> map) {
        this(new Date(), i, str, map);
    }

    public HttpResponse(Date date, int i, String str, Map<String, List<String>> map) {
        if (date == null) {
            throw new NullPointerException("date is marked non-null but is null");
        }
        this.mDate = new Date(date.getTime());
        this.mStatusCode = i;
        this.mResponseBody = str;
        this.mResponseHeaders = map;
    }

    public Date getDate() {
        return new Date(this.mDate.getTime());
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getBody() {
        return this.mResponseBody;
    }

    public Map<String, List<String>> getHeaders() {
        return this.mResponseHeaders;
    }

    @Nullable
    public String getHeaderValue(String str, int i) {
        List<String> list;
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (this.mResponseHeaders == null || i < 0 || StringUtil.isNullOrEmpty(str) || (list = this.mResponseHeaders.get(str)) == null || list.size() <= i) {
            return null;
        }
        return list.get(i);
    }

    public boolean isContentTypeMediaType(String str) {
        if (str == null) {
            throw new NullPointerException("expectedResponseType is marked non-null but is null");
        }
        String headerValue = getHeaderValue("Content-Type", 0);
        if (StringUtil.isNullOrEmpty(headerValue)) {
            return false;
        }
        return str.equalsIgnoreCase(headerValue.split(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER)[0].trim());
    }

    public String toString() {
        return "HttpResponse{mStatusCode=" + this.mStatusCode + ", mResponseBody='" + this.mResponseBody + "', mResponseHeaders=" + this.mResponseHeaders + AbstractJsonLexerKt.END_OBJ;
    }
}
