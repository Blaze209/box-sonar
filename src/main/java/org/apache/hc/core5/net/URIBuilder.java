package org.apache.hc.core5.net;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.microsoft.identity.client.internal.MsalUtils;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.http.message.ParserCursor;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class URIBuilder {
    private static final char PATH_SEPARATOR = '/';
    private static final char QUERY_PARAM_SEPARATOR = '&';
    private Charset charset;
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private boolean pathRootless;
    private List<String> pathSegments;
    private int port;
    private String query;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;
    private static final char PARAM_VALUE_SEPARATOR = '=';
    private static final Tokenizer.Delimiter QUERY_PARAM_SEPARATORS = Tokenizer.delimiters('&', PARAM_VALUE_SEPARATOR);
    private static final Tokenizer.Delimiter QUERY_VALUE_SEPARATORS = Tokenizer.delimiters('&');

    public static URIBuilder localhost() throws UnknownHostException {
        return new URIBuilder().setHost(InetAddress.getLocalHost());
    }

    public static URIBuilder loopbackAddress() {
        return new URIBuilder().setHost(InetAddress.getLoopbackAddress());
    }

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String str) throws URISyntaxException {
        this(new URI(str), StandardCharsets.UTF_8);
    }

    public URIBuilder(URI uri) {
        this(uri, StandardCharsets.UTF_8);
    }

    public URIBuilder(String str, Charset charset) throws URISyntaxException {
        this(new URI(str), charset);
    }

    public URIBuilder(URI uri, Charset charset) {
        digestURI(uri, charset);
    }

    public URIBuilder setAuthority(NamedEndpoint namedEndpoint) {
        setUserInfo(null);
        setHost(namedEndpoint.getHostName());
        setPort(namedEndpoint.getPort());
        return this;
    }

    public URIBuilder setAuthority(URIAuthority uRIAuthority) {
        setUserInfo(uRIAuthority.getUserInfo());
        setHost(uRIAuthority.getHostName());
        setPort(uRIAuthority.getPort());
        return this;
    }

    public URIBuilder setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public URIAuthority getAuthority() {
        return new URIAuthority(getUserInfo(), getHost(), getPort());
    }

    public Charset getCharset() {
        return this.charset;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0052  */
    static List<NameValuePair> parseQuery(CharSequence charSequence, Charset charset, boolean z) {
        String token;
        if (charSequence == null) {
            return null;
        }
        Tokenizer tokenizer = Tokenizer.INSTANCE;
        ParserCursor parserCursor = new ParserCursor(0, charSequence.length());
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            String token2 = tokenizer.parseToken(charSequence, parserCursor, QUERY_PARAM_SEPARATORS);
            if (parserCursor.atEnd()) {
                token = null;
            } else {
                char cCharAt = charSequence.charAt(parserCursor.getPos());
                parserCursor.updatePos(parserCursor.getPos() + 1);
                if (cCharAt == '=') {
                    token = tokenizer.parseToken(charSequence, parserCursor, QUERY_VALUE_SEPARATORS);
                    if (!parserCursor.atEnd()) {
                        parserCursor.updatePos(parserCursor.getPos() + 1);
                    }
                } else {
                    token = null;
                }
            }
            if (!token2.isEmpty()) {
                arrayList.add(new BasicNameValuePair(PercentCodec.decode(token2, charset, z), PercentCodec.decode(token, charset, z)));
            }
        }
        return arrayList;
    }

    static List<String> splitPath(CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ParserCursor parserCursor = new ParserCursor(0, charSequence.length());
        if (parserCursor.atEnd()) {
            return new ArrayList(0);
        }
        if (charSequence.charAt(parserCursor.getPos()) == '/') {
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (!parserCursor.atEnd()) {
            char cCharAt = charSequence.charAt(parserCursor.getPos());
            if (cCharAt == '/') {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(cCharAt);
            }
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    static List<String> parsePath(CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        List<String> listSplitPath = splitPath(charSequence);
        ArrayList arrayList = new ArrayList(listSplitPath.size());
        Iterator<String> it = listSplitPath.iterator();
        while (it.hasNext()) {
            arrayList.add(PercentCodec.decode(it.next(), charset));
        }
        return arrayList;
    }

    static void formatPath(StringBuilder sb, Iterable<String> iterable, boolean z, Charset charset) {
        int i = 0;
        for (String str : iterable) {
            if (i > 0 || !z) {
                sb.append('/');
            }
            PercentCodec.encode(sb, str, charset);
            i++;
        }
    }

    static void formatQuery(StringBuilder sb, Iterable<? extends NameValuePair> iterable, Charset charset, boolean z) {
        int i = 0;
        for (NameValuePair nameValuePair : iterable) {
            if (i > 0) {
                sb.append('&');
            }
            PercentCodec.encode(sb, nameValuePair.getName(), charset, z);
            if (nameValuePair.getValue() != null) {
                sb.append(PARAM_VALUE_SEPARATOR);
                PercentCodec.encode(sb, nameValuePair.getValue(), charset, z);
            }
            i++;
        }
    }

    public URI build() throws URISyntaxException {
        if ((URIScheme.HTTPS.same(this.scheme) || URIScheme.HTTP.same(this.scheme)) && TextUtils.isBlank(this.host)) {
            throw new URISyntaxException(this.scheme, "http/https URI cannot have an empty host identifier");
        }
        return new URI(buildString());
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:59:0x0105  */
    private String buildString() {
        boolean z;
        String str;
        List<String> list;
        List<NameValuePair> list2;
        StringBuilder sb = new StringBuilder();
        String str2 = this.scheme;
        if (str2 != null) {
            sb.append(str2).append(AbstractJsonLexerKt.COLON);
        }
        String str3 = this.encodedSchemeSpecificPart;
        if (str3 != null) {
            sb.append(str3);
        } else {
            if (this.encodedAuthority != null) {
                sb.append("//").append(this.encodedAuthority);
            } else {
                if (this.host != null) {
                    sb.append("//");
                    String str4 = this.encodedUserInfo;
                    if (str4 != null) {
                        sb.append(str4).append(CommentEntityDomainMapper.MENTIONS_SYMBOL);
                    } else {
                        String str5 = this.userInfo;
                        if (str5 != null) {
                            int iIndexOf = str5.indexOf(58);
                            if (iIndexOf != -1) {
                                PercentCodec.encode(sb, this.userInfo.substring(0, iIndexOf), this.charset);
                                sb.append(AbstractJsonLexerKt.COLON);
                                PercentCodec.encode(sb, this.userInfo.substring(iIndexOf + 1), this.charset);
                            } else {
                                PercentCodec.encode(sb, this.userInfo, this.charset);
                            }
                            sb.append(CommentEntityDomainMapper.MENTIONS_SYMBOL);
                        }
                    }
                    if (InetAddressUtils.isIPv6(this.host)) {
                        sb.append("[").append(this.host).append("]");
                    } else {
                        sb.append(PercentCodec.encode(this.host, this.charset));
                    }
                    if (this.port >= 0) {
                        sb.append(":").append(this.port);
                    }
                } else {
                    z = false;
                }
                str = this.encodedPath;
                if (str != null) {
                    if (z && !TextUtils.isEmpty(str) && !this.encodedPath.startsWith("/")) {
                        sb.append('/');
                    }
                    sb.append(this.encodedPath);
                } else {
                    list = this.pathSegments;
                    if (list != null) {
                        formatPath(sb, list, z && this.pathRootless, this.charset);
                    }
                }
                if (this.encodedQuery != null) {
                    sb.append(MsalUtils.QUERY_STRING_SYMBOL).append(this.encodedQuery);
                } else {
                    list2 = this.queryParams;
                    if (list2 == null && !list2.isEmpty()) {
                        sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                        formatQuery(sb, this.queryParams, this.charset, false);
                    } else if (this.query != null) {
                        sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                        PercentCodec.encode(sb, this.query, this.charset, PercentCodec.URIC, false);
                    }
                }
            }
            z = true;
            str = this.encodedPath;
            if (str != null) {
                if (z) {
                    sb.append('/');
                }
                sb.append(this.encodedPath);
            } else {
                list = this.pathSegments;
                if (list != null) {
                    formatPath(sb, list, z && this.pathRootless, this.charset);
                }
            }
            if (this.encodedQuery != null) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL).append(this.encodedQuery);
            } else {
                list2 = this.queryParams;
                if (list2 == null) {
                    if (this.query != null) {
                        sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                        PercentCodec.encode(sb, this.query, this.charset, PercentCodec.URIC, false);
                    }
                } else if (this.query != null) {
                    sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                    PercentCodec.encode(sb, this.query, this.charset, PercentCodec.URIC, false);
                }
            }
        }
        if (this.encodedFragment != null) {
            sb.append("#").append(this.encodedFragment);
        } else if (this.fragment != null) {
            sb.append("#");
            PercentCodec.encode(sb, this.fragment, this.charset);
        }
        return sb.toString();
    }

    private void digestURI(URI uri, Charset charset) {
        this.scheme = uri.getScheme();
        this.encodedSchemeSpecificPart = uri.getRawSchemeSpecificPart();
        this.encodedAuthority = uri.getRawAuthority();
        String host = uri.getHost();
        boolean z = true;
        if (host != null && InetAddressUtils.isIPv6URLBracketed(host)) {
            host = host.substring(1, host.length() - 1);
        }
        this.host = host;
        this.port = uri.getPort();
        this.encodedUserInfo = uri.getRawUserInfo();
        this.userInfo = uri.getUserInfo();
        String str = this.encodedAuthority;
        if (str != null && this.host == null) {
            try {
                URIAuthority uRIAuthority = URIAuthority.parse(str);
                this.encodedUserInfo = uRIAuthority.getUserInfo();
                this.userInfo = PercentCodec.decode(uRIAuthority.getUserInfo(), charset);
                this.host = PercentCodec.decode(uRIAuthority.getHostName(), charset);
                this.port = uRIAuthority.getPort();
            } catch (URISyntaxException unused) {
            }
        }
        this.encodedPath = uri.getRawPath();
        this.pathSegments = parsePath(uri.getRawPath(), charset);
        if (uri.getRawPath() != null && uri.getRawPath().startsWith("/")) {
            z = false;
        }
        this.pathRootless = z;
        this.encodedQuery = uri.getRawQuery();
        this.queryParams = parseQuery(uri.getRawQuery(), charset, false);
        this.encodedFragment = uri.getRawFragment();
        this.fragment = uri.getFragment();
        this.charset = charset;
    }

    public URIBuilder setScheme(String str) {
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.scheme = str;
        return this;
    }

    public URIBuilder setSchemeSpecificPart(String str) {
        this.encodedSchemeSpecificPart = str;
        return this;
    }

    public URIBuilder setSchemeSpecificPart(String str, NameValuePair... nameValuePairArr) {
        return setSchemeSpecificPart(str, nameValuePairArr != null ? Arrays.asList(nameValuePairArr) : null);
    }

    public URIBuilder setSchemeSpecificPart(String str, List<NameValuePair> list) {
        this.encodedSchemeSpecificPart = null;
        if (!TextUtils.isBlank(str)) {
            StringBuilder sb = new StringBuilder(str);
            if (list != null && !list.isEmpty()) {
                sb.append(MsalUtils.QUERY_STRING_SYMBOL);
                formatQuery(sb, list, this.charset, false);
            }
            this.encodedSchemeSpecificPart = sb.toString();
        }
        return this;
    }

    public URIBuilder setUserInfo(String str) {
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.userInfo = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    @Deprecated
    public URIBuilder setUserInfo(String str, String str2) {
        return setUserInfo(str + AbstractJsonLexerKt.COLON + str2);
    }

    public URIBuilder setHost(InetAddress inetAddress) {
        this.host = inetAddress != null ? inetAddress.getHostAddress() : null;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setHost(String str) {
        this.host = str;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setHttpHost(HttpHost httpHost) {
        setScheme(httpHost.getSchemeName());
        setHost(httpHost.getHostName());
        setPort(httpHost.getPort());
        return this;
    }

    public URIBuilder setPort(int i) {
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPath(String str) {
        setPathSegments(str != null ? splitPath(str) : null);
        this.pathRootless = (str == null || str.startsWith("/")) ? false : true;
        return this;
    }

    public URIBuilder appendPath(String str) {
        if (str != null) {
            appendPathSegments(splitPath(str));
        }
        return this;
    }

    public URIBuilder setPathSegments(String... strArr) {
        return setPathSegments(Arrays.asList(strArr));
    }

    public URIBuilder appendPathSegments(String... strArr) {
        return appendPathSegments(Arrays.asList(strArr));
    }

    public URIBuilder setPathSegmentsRootless(String... strArr) {
        return setPathSegmentsRootless(Arrays.asList(strArr));
    }

    public URIBuilder setPathSegments(List<String> list) {
        this.pathSegments = (list == null || list.isEmpty()) ? null : new ArrayList(list);
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        this.pathRootless = false;
        return this;
    }

    public URIBuilder appendPathSegments(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (this.pathSegments == null) {
                this.pathSegments = new ArrayList();
            }
            this.pathSegments.addAll(list);
            this.encodedSchemeSpecificPart = null;
            this.encodedPath = null;
        }
        return this;
    }

    public URIBuilder setPathSegmentsRootless(List<String> list) {
        this.pathSegments = (list == null || list.isEmpty()) ? null : new ArrayList(list);
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        this.pathRootless = true;
        return this;
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> list) {
        List<NameValuePair> list2 = this.queryParams;
        if (list2 == null) {
            this.queryParams = new ArrayList();
        } else {
            list2.clear();
        }
        if (list != null) {
            this.queryParams.addAll(list);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameters(List<NameValuePair> list) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (list != null) {
            this.queryParams.addAll(list);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair... nameValuePairArr) {
        List<NameValuePair> list = this.queryParams;
        if (list == null) {
            this.queryParams = new ArrayList();
        } else {
            list.clear();
        }
        if (nameValuePairArr != null) {
            Collections.addAll(this.queryParams, nameValuePairArr);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder addParameter(String str, String str2) {
        return addParameter(new BasicNameValuePair(str, str2));
    }

    public URIBuilder addParameter(NameValuePair nameValuePair) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (nameValuePair != null) {
            this.queryParams.add(nameValuePair);
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder removeParameter(final String str) {
        Args.notNull(str, "param");
        List<NameValuePair> list = this.queryParams;
        if (list != null && !list.isEmpty()) {
            this.queryParams.removeIf(new Predicate() { // from class: org.apache.hc.core5.net.URIBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((NameValuePair) obj).getName().equals(str);
                }
            });
        }
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameter(final String str, String str2) {
        if (this.queryParams == null) {
            this.queryParams = new ArrayList();
        }
        if (!this.queryParams.isEmpty()) {
            this.queryParams.removeIf(new Predicate() { // from class: org.apache.hc.core5.net.URIBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((NameValuePair) obj).getName().equals(str);
                }
            });
        }
        this.queryParams.add(new BasicNameValuePair(str, str2));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String str) {
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.query = str;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String str) {
        if (TextUtils.isBlank(str)) {
            str = null;
        }
        this.fragment = str;
        this.encodedFragment = null;
        return this;
    }

    public boolean isAbsolute() {
        return this.scheme != null;
    }

    public boolean isOpaque() {
        return this.pathSegments == null && this.encodedPath == null;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSchemeSpecificPart() {
        return this.encodedSchemeSpecificPart;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isPathEmpty() {
        List<String> list = this.pathSegments;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        String str = this.encodedPath;
        return str == null || str.isEmpty();
    }

    public List<String> getPathSegments() {
        return this.pathSegments != null ? new ArrayList(this.pathSegments) : new ArrayList();
    }

    public String getPath() {
        if (this.pathSegments == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.pathSegments.iterator();
        while (it.hasNext()) {
            sb.append('/').append(it.next());
        }
        return sb.toString();
    }

    public boolean isQueryEmpty() {
        List<NameValuePair> list = this.queryParams;
        return (list == null || list.isEmpty()) && this.encodedQuery == null;
    }

    public List<NameValuePair> getQueryParams() {
        return this.queryParams != null ? new ArrayList(this.queryParams) : new ArrayList();
    }

    public NameValuePair getFirstQueryParam(final String str) {
        List<NameValuePair> list = this.queryParams;
        if (list == null) {
            return null;
        }
        return list.stream().filter(new Predicate() { // from class: org.apache.hc.core5.net.URIBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals(((NameValuePair) obj).getName());
            }
        }).findFirst().orElse(null);
    }

    public String getFragment() {
        return this.fragment;
    }

    @Deprecated
    public URIBuilder normalizeSyntax() {
        return optimize();
    }

    public URIBuilder optimize() {
        String str = this.scheme;
        if (str != null) {
            this.scheme = TextUtils.toLowerCase(str);
        }
        if (!this.pathRootless) {
            this.encodedSchemeSpecificPart = null;
            this.encodedAuthority = null;
            this.encodedUserInfo = null;
            this.encodedPath = null;
            this.encodedQuery = null;
            this.encodedFragment = null;
            String str2 = this.host;
            if (str2 != null) {
                this.host = TextUtils.toLowerCase(str2);
            }
            List<String> list = this.pathSegments;
            if (list != null) {
                if (!list.isEmpty()) {
                    LinkedList linkedList = new LinkedList();
                    for (String str3 : list) {
                        if (!str3.isEmpty() && !".".equals(str3)) {
                            if ("..".equals(str3)) {
                                if (!linkedList.isEmpty()) {
                                    linkedList.removeLast();
                                }
                            } else {
                                linkedList.addLast(str3);
                            }
                        }
                    }
                    if (!list.isEmpty() && list.get(list.size() - 1).isEmpty()) {
                        linkedList.addLast("");
                    }
                    this.pathSegments = linkedList;
                    return this;
                }
                this.pathSegments = Collections.singletonList("");
            }
        }
        return this;
    }

    public String toString() {
        return buildString();
    }
}
