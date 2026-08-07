package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpVersion extends ProtocolVersion {
    public static final HttpVersion[] ALL;
    public static final HttpVersion DEFAULT;
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9;
    public static final HttpVersion HTTP_1_0;
    public static final HttpVersion HTTP_1_1;
    public static final HttpVersion HTTP_2;
    public static final HttpVersion HTTP_2_0;
    private static final long serialVersionUID = -5856653513894415344L;

    static {
        HttpVersion httpVersion = new HttpVersion(0, 9);
        HTTP_0_9 = httpVersion;
        HttpVersion httpVersion2 = new HttpVersion(1, 0);
        HTTP_1_0 = httpVersion2;
        HttpVersion httpVersion3 = new HttpVersion(1, 1);
        HTTP_1_1 = httpVersion3;
        HttpVersion httpVersion4 = new HttpVersion(2, 0);
        HTTP_2_0 = httpVersion4;
        HTTP_2 = httpVersion4;
        DEFAULT = httpVersion3;
        ALL = new HttpVersion[]{httpVersion, httpVersion2, httpVersion3, httpVersion4};
    }

    public static HttpVersion get(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return HTTP_1_1;
            }
            if (i2 == 0) {
                return HTTP_1_0;
            }
        } else if (i == 2 && i2 == 0) {
            return HTTP_2_0;
        }
        return new HttpVersion(i, i2);
    }

    public HttpVersion(int i, int i2) {
        super("HTTP", i, i2);
    }
}
