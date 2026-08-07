package io.split.android.client.network;

import androidx.core.util.Pair;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import io.split.android.client.utils.Utils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class URIBuilder {
    private final Set<Pair<String, String>> mParams;
    private String mPath;
    private String mQueryString;
    private final URI mRootURI;

    public URIBuilder(URI rootURI, String path) {
        URI uri = (URI) Utils.checkNotNull(rootURI);
        this.mRootURI = uri;
        String rawPath = uri.getRawPath();
        if (path != null && rawPath != null) {
            String str = String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, rawPath, path);
            this.mPath = str;
            String strReplace = str.replace("///", "/");
            this.mPath = strReplace;
            this.mPath = strReplace.replace("//", "/");
        } else if (rawPath != null) {
            this.mPath = rawPath;
            this.mQueryString = rootURI.getQuery();
        } else {
            this.mPath = path;
        }
        this.mParams = new LinkedHashSet();
    }

    public URIBuilder(URI rootURI) {
        this(rootURI, null);
    }

    public URIBuilder addParameter(String param, String value) {
        if (param != null && value != null) {
            this.mParams.add(new Pair<>(param, value));
        }
        return this;
    }

    public URIBuilder defaultQueryString(String queryString) {
        if (!Utils.isNullOrEmpty(queryString)) {
            this.mQueryString = queryString;
        }
        return this;
    }

    public URI build() throws URISyntaxException {
        String strSubstring;
        if (this.mParams.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Pair<String, String> pair : this.mParams) {
                sb.append(pair.first).append(SimpleComparison.EQUAL_TO_OPERATION).append(pair.second).append(MsalUtils.QUERY_STRING_DELIMITER);
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        } else {
            strSubstring = null;
        }
        if (!Utils.isNullOrEmpty(this.mQueryString)) {
            if (!Utils.isNullOrEmpty(strSubstring)) {
                if (!MsalUtils.QUERY_STRING_DELIMITER.equals(this.mQueryString.substring(0, 1))) {
                    strSubstring = strSubstring + MsalUtils.QUERY_STRING_DELIMITER;
                }
                strSubstring = strSubstring + this.mQueryString;
            } else {
                strSubstring = this.mQueryString;
            }
        }
        return new URI(this.mRootURI.getScheme(), null, this.mRootURI.getHost(), this.mRootURI.getPort(), this.mPath, strSubstring, null);
    }
}
