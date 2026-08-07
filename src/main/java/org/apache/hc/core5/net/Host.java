package org.apache.hc.core5.net;

import java.io.Serializable;
import java.net.IDN;
import java.net.URISyntaxException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.LangUtils;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public final class Host implements NamedEndpoint, Serializable {
    private static final long serialVersionUID = 1;
    private final String lcName;
    private final String name;
    private final int port;

    static boolean isPunyCode(CharSequence charSequence) {
        return charSequence != null && charSequence.length() >= 4 && (charSequence.charAt(0) == 'x' || charSequence.charAt(0) == 'X') && ((charSequence.charAt(1) == 'n' || charSequence.charAt(1) == 'N') && charSequence.charAt(2) == '-' && charSequence.charAt(3) == '-');
    }

    public Host(String str, int i) {
        Args.notNull(str, "Host name");
        Ports.checkWithDefault(i);
        str = isPunyCode(str) ? IDN.toUnicode(str) : str;
        this.name = str;
        this.port = i;
        this.lcName = TextUtils.toLowerCase(str);
    }

    static Host parse(CharSequence charSequence, Tokenizer.Cursor cursor) throws URISyntaxException {
        String content;
        String content2;
        int i;
        Tokenizer tokenizer = Tokenizer.INSTANCE;
        boolean z = !cursor.atEnd() && charSequence.charAt(cursor.getPos()) == '[';
        if (z) {
            cursor.updatePos(cursor.getPos() + 1);
            content = tokenizer.parseContent(charSequence, cursor, URISupport.IPV6_HOST_DELIMITERS);
            if (cursor.atEnd() || charSequence.charAt(cursor.getPos()) != ']') {
                throw URISupport.createException(charSequence, cursor, "Expected an IPv6 closing bracket ']'");
            }
            cursor.updatePos(cursor.getPos() + 1);
            if (!InetAddressUtils.isIPv6(content)) {
                throw URISupport.createException(charSequence, cursor, "Expected an IPv6 address");
            }
        } else {
            content = tokenizer.parseContent(charSequence, cursor, URISupport.PORT_DELIMITERS);
        }
        if (cursor.atEnd() || charSequence.charAt(cursor.getPos()) != ':') {
            content2 = null;
        } else {
            cursor.updatePos(cursor.getPos() + 1);
            content2 = tokenizer.parseContent(charSequence, cursor, URISupport.DELIMITERS);
        }
        if (TextUtils.isBlank(content2)) {
            i = -1;
        } else {
            if (!z && content2.contains(":")) {
                throw URISupport.createException(charSequence, cursor, "Expected IPv6 address to be enclosed in brackets");
            }
            try {
                i = Integer.parseInt(content2);
            } catch (NumberFormatException unused) {
                throw URISupport.createException(charSequence, cursor, "Port is invalid");
            }
        }
        return new Host(content, i);
    }

    static Host parse(CharSequence charSequence) throws URISyntaxException {
        return parse(charSequence, new Tokenizer.Cursor(0, charSequence.length()));
    }

    static void format(StringBuilder sb, NamedEndpoint namedEndpoint) {
        String hostName = namedEndpoint.getHostName();
        if (InetAddressUtils.isIPv6(hostName)) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST).append(hostName).append(AbstractJsonLexerKt.END_LIST);
        } else if (TextUtils.isAllASCII(hostName)) {
            sb.append(hostName);
        } else {
            sb.append(IDN.toASCII(hostName));
        }
        if (namedEndpoint.getPort() != -1) {
            sb.append(":");
            sb.append(namedEndpoint.getPort());
        }
    }

    static void format(StringBuilder sb, Host host) {
        format(sb, (NamedEndpoint) host);
    }

    static String format(Host host) {
        StringBuilder sb = new StringBuilder();
        format(sb, host);
        return sb.toString();
    }

    public static Host create(String str) throws URISyntaxException {
        Args.notEmpty(str, "HTTP Host");
        Tokenizer.Cursor cursor = new Tokenizer.Cursor(0, str.length());
        Host host = parse(str, cursor);
        if (TextUtils.isBlank(host.getHostName())) {
            throw URISupport.createException(str, cursor, "Hostname is invalid");
        }
        if (cursor.atEnd()) {
            return host;
        }
        throw URISupport.createException(str, cursor, "Unexpected content");
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public String getHostName() {
        return this.name;
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public int getPort() {
        return this.port;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Host) {
            Host host = (Host) obj;
            if (this.lcName.equals(host.lcName) && this.port == host.port) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.lcName), this.port);
    }

    public String toString() {
        return format(this);
    }
}
