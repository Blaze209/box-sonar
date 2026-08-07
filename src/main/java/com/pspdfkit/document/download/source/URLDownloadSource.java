package com.pspdfkit.document.download.source;

import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class URLDownloadSource implements DownloadSource {
    private final String LOG_TAG = "Nutri.URLDownloadSource";
    private final URL documentURL;

    public URLDownloadSource(URL url) {
        uw.a(url, "documentURL", null);
        this.documentURL = url;
    }

    @Override // com.pspdfkit.document.download.source.DownloadSource
    public InputStream open() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.documentURL.openConnection();
        uRLConnectionOpenConnection.connect();
        return uRLConnectionOpenConnection.getInputStream();
    }

    public String toString() {
        return "URLDownloadSource{documentURL=" + this.documentURL + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // com.pspdfkit.document.download.source.DownloadSource
    public long getLength() {
        try {
            return this.documentURL.openConnection().getContentLengthLong();
        } catch (IOException e) {
            PdfLog.e("Nutri.URLDownloadSource", e, "Could not query content length of the URL download source", new Object[0]);
            return -1L;
        }
    }
}
