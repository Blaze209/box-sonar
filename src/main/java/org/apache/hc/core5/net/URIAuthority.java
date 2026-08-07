package org.apache.hc.core5.net;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Objects;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.LangUtils;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public final class URIAuthority implements NamedEndpoint, Serializable {
    private static final long serialVersionUID = 1;
    private final Host host;
    private final String userInfo;

    static URIAuthority parse(CharSequence charSequence, Tokenizer.Cursor cursor) throws URISyntaxException {
        Tokenizer tokenizer = Tokenizer.INSTANCE;
        int pos = cursor.getPos();
        String content = tokenizer.parseContent(charSequence, cursor, URISupport.HOST_DELIMITERS);
        if (!cursor.atEnd() && charSequence.charAt(cursor.getPos()) == '@') {
            cursor.updatePos(cursor.getPos() + 1);
            if (TextUtils.isBlank(content)) {
            }
            return new URIAuthority(content, Host.parse(charSequence, cursor));
        }
        cursor.updatePos(pos);
        content = null;
        return new URIAuthority(content, Host.parse(charSequence, cursor));
    }

    static URIAuthority parse(CharSequence charSequence) throws URISyntaxException {
        return parse(charSequence, new Tokenizer.Cursor(0, charSequence.length()));
    }

    static void format(StringBuilder sb, URIAuthority uRIAuthority) {
        if (uRIAuthority.getUserInfo() != null) {
            sb.append(uRIAuthority.getUserInfo());
            sb.append(CommentEntityDomainMapper.MENTIONS_SYMBOL);
        }
        Host.format(sb, uRIAuthority);
    }

    static String format(URIAuthority uRIAuthority) {
        StringBuilder sb = new StringBuilder();
        format(sb, uRIAuthority);
        return sb.toString();
    }

    public URIAuthority(String str, String str2, int i) {
        this.userInfo = str;
        this.host = new Host(str2, i);
    }

    public URIAuthority(String str, int i) {
        this(null, str, i);
    }

    public URIAuthority(String str, Host host) {
        Args.notNull(host, "Host");
        this.userInfo = str;
        this.host = host;
    }

    public URIAuthority(Host host) {
        this((String) null, host);
    }

    public URIAuthority(String str, NamedEndpoint namedEndpoint) {
        Args.notNull(namedEndpoint, "Endpoint");
        this.userInfo = str;
        this.host = new Host(namedEndpoint.getHostName(), namedEndpoint.getPort());
    }

    public URIAuthority(NamedEndpoint namedEndpoint) {
        this((String) null, namedEndpoint);
    }

    public static URIAuthority create(String str) throws URISyntaxException {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        Tokenizer.Cursor cursor = new Tokenizer.Cursor(0, str.length());
        URIAuthority uRIAuthority = parse(str, cursor);
        if (cursor.atEnd()) {
            return uRIAuthority;
        }
        throw URISupport.createException(str, cursor, "Unexpected content");
    }

    public URIAuthority(String str) {
        this(null, str, -1);
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public String getHostName() {
        return this.host.getHostName();
    }

    @Override // org.apache.hc.core5.net.NamedEndpoint
    public int getPort() {
        return this.host.getPort();
    }

    public String toString() {
        return format(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof URIAuthority) {
            URIAuthority uRIAuthority = (URIAuthority) obj;
            if (Objects.equals(this.userInfo, uRIAuthority.userInfo) && Objects.equals(this.host, uRIAuthority.host)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.userInfo), this.host);
    }
}
