package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (java.lang.Integer.parseInt(r4[0].getValue()) < 0) goto L14;
     */
    @Override // cz.msebera.android.httpclient.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean keepAlive(cz.msebera.android.httpclient.HttpResponse r5, cz.msebera.android.httpclient.protocol.HttpContext r6) {
        /*
            r4 = this;
            java.lang.String r0 = "HTTP response"
            cz.msebera.android.httpclient.util.Args.notNull(r5, r0)
            java.lang.String r0 = "HTTP context"
            cz.msebera.android.httpclient.util.Args.notNull(r6, r0)
            cz.msebera.android.httpclient.StatusLine r6 = r5.getStatusLine()
            cz.msebera.android.httpclient.ProtocolVersion r6 = r6.getProtocolVersion()
            java.lang.String r0 = "Transfer-Encoding"
            cz.msebera.android.httpclient.Header r0 = r5.getFirstHeader(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L29
            java.lang.String r4 = "chunked"
            java.lang.String r0 = r0.getValue()
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto L45
            return r2
        L29:
            boolean r4 = r4.canResponseHaveBody(r5)
            if (r4 == 0) goto L45
            java.lang.String r4 = "Content-Length"
            cz.msebera.android.httpclient.Header[] r4 = r5.getHeaders(r4)
            int r0 = r4.length
            if (r0 != r1) goto L44
            r4 = r4[r2]
            java.lang.String r4 = r4.getValue()     // Catch: java.lang.NumberFormatException -> L44
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L44
            if (r4 >= 0) goto L45
        L44:
            return r2
        L45:
            java.lang.String r4 = "Connection"
            cz.msebera.android.httpclient.Header[] r4 = r5.getHeaders(r4)
            int r0 = r4.length
            if (r0 != 0) goto L54
            java.lang.String r4 = "Proxy-Connection"
            cz.msebera.android.httpclient.Header[] r4 = r5.getHeaders(r4)
        L54:
            int r5 = r4.length
            if (r5 == 0) goto L84
            cz.msebera.android.httpclient.message.BasicTokenIterator r5 = new cz.msebera.android.httpclient.message.BasicTokenIterator     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            cz.msebera.android.httpclient.message.BasicHeaderIterator r0 = new cz.msebera.android.httpclient.message.BasicHeaderIterator     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            r3 = 0
            r0.<init>(r4, r3)     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            r5.<init>(r0)     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            r4 = r2
        L63:
            boolean r0 = r5.hasNext()     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            if (r0 == 0) goto L80
            java.lang.String r0 = r5.nextToken()     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            java.lang.String r3 = "Close"
            boolean r3 = r3.equalsIgnoreCase(r0)     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            if (r3 == 0) goto L76
            return r2
        L76:
            java.lang.String r3 = "Keep-Alive"
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch: cz.msebera.android.httpclient.ParseException -> L83
            if (r0 == 0) goto L63
            r4 = r1
            goto L63
        L80:
            if (r4 == 0) goto L84
            return r1
        L83:
            return r2
        L84:
            cz.msebera.android.httpclient.HttpVersion r4 = cz.msebera.android.httpclient.HttpVersion.HTTP_1_0
            boolean r4 = r6.lessEquals(r4)
            r4 = r4 ^ r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy.keepAlive(cz.msebera.android.httpclient.HttpResponse, cz.msebera.android.httpclient.protocol.HttpContext):boolean");
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }
}
