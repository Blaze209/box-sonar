package sdk.pendo.io.z4;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.microsoft.identity.client.internal.MsalUtils;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class g {
    private static Pattern a = Pattern.compile("^http|ws$");
    private static Pattern b = Pattern.compile("^(http|ws)s$");

    public static String a(URL url) {
        String protocol = url.getProtocol();
        int port = url.getPort();
        if (port == -1) {
            if (a.matcher(protocol).matches()) {
                port = 80;
            } else if (b.matcher(protocol).matches()) {
                port = 443;
            }
        }
        return protocol + "://" + url.getHost() + ":" + port;
    }

    public static URL a(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if (a.matcher(scheme).matches()) {
                port = 80;
            } else if (b.matcher(scheme).matches()) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        try {
            return new URL(scheme + "://" + (rawUserInfo != null ? rawUserInfo + CommentEntityDomainMapper.MENTIONS_SYMBOL : "") + uri.getHost() + (port != -1 ? ":" + port : "") + rawPath + (rawQuery != null ? MsalUtils.QUERY_STRING_SYMBOL + rawQuery : "") + (rawFragment != null ? "#" + rawFragment : ""));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
