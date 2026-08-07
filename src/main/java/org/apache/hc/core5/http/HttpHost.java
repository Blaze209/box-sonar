package org.apache.hc.core5.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import org.apache.hc.core5.net.Host;
import org.apache.hc.core5.net.NamedEndpoint;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.LangUtils;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpHost implements NamedEndpoint, Serializable {
    public static final URIScheme DEFAULT_SCHEME = URIScheme.HTTP;
    private static final long serialVersionUID = -7529410654042457626L;
    private final InetAddress address;
    private final Host host;
    private final String schemeName;

    public HttpHost(String str, InetAddress inetAddress, String str2, int i) {
        Args.containsNoBlanks(str2, "Host name");
        this.host = new Host(str2, i);
        this.schemeName = str != null ? TextUtils.toLowerCase(str) : DEFAULT_SCHEME.id;
        this.address = inetAddress;
    }

    public HttpHost(String str, String str2, int i) {
        this(str, null, str2, i);
    }

    public HttpHost(String str, int i) {
        this((String) null, str, i);
    }

    public HttpHost(String str, String str2) {
        this(str, str2, -1);
    }

    public static HttpHost create(String str) throws URISyntaxException {
        String strSubstring;
        Args.notEmpty(str, "HTTP Host");
        int iIndexOf = str.indexOf("://");
        if (iIndexOf > 0) {
            strSubstring = str.substring(0, iIndexOf);
            if (TextUtils.containsBlanks(strSubstring)) {
                throw new URISyntaxException(str, "scheme contains blanks");
            }
            str = str.substring(iIndexOf + 3);
        } else {
            strSubstring = null;
        }
        return new HttpHost(strSubstring, Host.create(str));
    }

    public static HttpHost create(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = URIScheme.HTTP.getId();
        }
        return new HttpHost(scheme, uri.getHost(), uri.getPort());
    }

    public HttpHost(String str) {
        this((String) null, str, -1);
    }

    public HttpHost(String str, InetAddress inetAddress, int i) {
        this(str, (InetAddress) Args.notNull(inetAddress, "Inet address"), inetAddress.getHostName(), i);
    }

    public HttpHost(InetAddress inetAddress, int i) {
        this((String) null, inetAddress, i);
    }

    public HttpHost(InetAddress inetAddress) {
        this((String) null, inetAddress, -1);
    }

    public HttpHost(String str, NamedEndpoint namedEndpoint) {
        this(str, ((NamedEndpoint) Args.notNull(namedEndpoint, "Named endpoint")).getHostName(), namedEndpoint.getPort());
    }

    @Deprecated
    public HttpHost(URIAuthority uRIAuthority) {
        this((String) null, uRIAuthority);
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public String getHostName() {
        return this.host.getHostName();
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public int getPort() {
        return this.host.getPort();
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String toURI() {
        return this.schemeName + "://" + this.host.toString();
    }

    public String toHostString() {
        return this.host.toString();
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpHost) {
            HttpHost httpHost = (HttpHost) obj;
            if (this.schemeName.equals(httpHost.schemeName) && this.host.equals(httpHost.host) && Objects.equals(this.address, httpHost.address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.schemeName), this.host), this.address);
    }
}
