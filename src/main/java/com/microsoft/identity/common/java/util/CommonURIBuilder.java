package com.microsoft.identity.common.java.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;

/* JADX INFO: loaded from: classes14.dex */
public class CommonURIBuilder extends URIBuilder {
    @Override // org.apache.hc.core5.net.URIBuilder
    public /* bridge */ /* synthetic */ URIBuilder addParameters(List list) {
        return addParameters((List<NameValuePair>) list);
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public /* bridge */ /* synthetic */ URIBuilder setParameters(List list) {
        return setParameters((List<NameValuePair>) list);
    }

    public CommonURIBuilder() {
    }

    public CommonURIBuilder(String str) throws URISyntaxException {
        super(str);
    }

    public CommonURIBuilder(URI uri) {
        super(uri);
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public CommonURIBuilder addParameters(List<NameValuePair> list) {
        if (list == null) {
            throw new NullPointerException("nvps is marked non-null but is null");
        }
        throw new UnsupportedOperationException("This should never be used. Either use setParameter or addParametersIfAbsent");
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public CommonURIBuilder addParameter(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        throw new UnsupportedOperationException("This should never be used. Either use setParameter or addParametersIfAbsent");
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public CommonURIBuilder setParameters(List<NameValuePair> list) {
        super.setParameters(list);
        return this;
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public CommonURIBuilder setParameters(NameValuePair... nameValuePairArr) {
        super.setParameters(nameValuePairArr);
        return this;
    }

    @Override // org.apache.hc.core5.net.URIBuilder
    public CommonURIBuilder setParameter(String str, String str2) {
        super.setParameter(str, str2);
        return this;
    }

    public CommonURIBuilder addParametersIfAbsent(Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                addParameterIfAbsent(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return this;
    }

    public CommonURIBuilder addParametersIfAbsent(List<Map.Entry<String, String>> list) {
        if (list != null) {
            for (Map.Entry<String, String> entry : list) {
                addParameterIfAbsent(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public CommonURIBuilder addParameterIfAbsent(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        if (containsParam(str)) {
            return this;
        }
        super.addParameter(str, str2);
        return this;
    }

    private boolean containsParam(String str) {
        if (str == null) {
            throw new NullPointerException("param is marked non-null but is null");
        }
        Iterator<NameValuePair> it = getQueryParams().iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String getLastPathSegment() {
        List<String> pathSegments = getPathSegments();
        if (pathSegments.isEmpty()) {
            return "";
        }
        return pathSegments.get(pathSegments.size() - 1);
    }
}
