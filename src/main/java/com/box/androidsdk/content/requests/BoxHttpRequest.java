package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.listeners.ProgressListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes13.dex */
class BoxHttpRequest {
    protected final ProgressListener mListener;
    protected final HttpURLConnection mUrlConnection;

    public BoxHttpRequest(URL url, BoxRequest.Methods methods, ProgressListener progressListener) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        this.mUrlConnection = httpURLConnection;
        httpURLConnection.setRequestMethod(methods.toString());
        this.mListener = progressListener;
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new BoxRequest.TLSSSLSocketFactory());
        }
    }

    public BoxHttpRequest addHeader(String str, String str2) {
        this.mUrlConnection.addRequestProperty(str, str2);
        return this;
    }

    public BoxHttpRequest setBody(InputStream inputStream) throws IOException {
        this.mUrlConnection.setDoOutput(true);
        OutputStream outputStream = this.mUrlConnection.getOutputStream();
        int i = inputStream.read();
        while (i != -1) {
            outputStream.write(i);
            i = inputStream.read();
        }
        outputStream.close();
        return this;
    }

    public HttpURLConnection getUrlConnection() {
        return this.mUrlConnection;
    }
}
