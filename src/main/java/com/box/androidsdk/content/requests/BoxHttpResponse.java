package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.utils.ProgressInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes13.dex */
public class BoxHttpResponse {
    private static final int BUFFER_SIZE = 8192;
    private String mBodyString;
    protected final HttpURLConnection mConnection;
    private String mContentEncoding;
    protected String mContentType;
    private InputStream mInputStream = null;
    protected int mResponseCode;
    private InputStream rawInputStream;

    private static boolean isErrorCode(int i) {
        return i >= 400;
    }

    public BoxHttpResponse(HttpURLConnection httpURLConnection) {
        this.mConnection = httpURLConnection;
    }

    public void open() throws IOException {
        this.mConnection.connect();
        this.mContentType = this.mConnection.getContentType();
        this.mResponseCode = this.mConnection.getResponseCode();
        this.mContentEncoding = this.mConnection.getContentEncoding();
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public int getContentLength() {
        return this.mConnection.getContentLength();
    }

    public String getContentType() {
        return this.mContentType;
    }

    public InputStream getBody() throws BoxException {
        return getBody(null);
    }

    public InputStream getBody(ProgressListener progressListener) throws BoxException {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            return inputStream;
        }
        String contentEncoding = this.mConnection.getContentEncoding();
        try {
            if (this.rawInputStream == null) {
                this.rawInputStream = this.mConnection.getInputStream();
            }
            if (progressListener == null) {
                this.mInputStream = this.rawInputStream;
            } else {
                this.mInputStream = new ProgressInputStream(this.rawInputStream, progressListener, getContentLength());
            }
            if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                this.mInputStream = new GZIPInputStream(this.mInputStream);
            }
            return this.mInputStream;
        } catch (IOException e) {
            throw new BoxException("Couldn't connect to the Box API due to a network error.", e);
        }
    }

    public void disconnect() throws BoxException {
        try {
            if (this.rawInputStream == null) {
                this.rawInputStream = this.mConnection.getInputStream();
            }
            byte[] bArr = new byte[8192];
            int i = this.rawInputStream.read(bArr);
            while (i != -1) {
                i = this.rawInputStream.read(bArr);
            }
            this.rawInputStream.close();
            InputStream inputStream = this.mInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new BoxException("Couldn't finish closing the connection to the Box API due to a network error or because the stream was already closed.", e);
        }
    }

    public String getStringBody() throws BoxException {
        InputStream inputStream;
        String str = this.mBodyString;
        if (str != null) {
            return str;
        }
        try {
            if (isErrorCode(this.mResponseCode)) {
                inputStream = this.mConnection.getErrorStream();
            } else {
                inputStream = this.mConnection.getInputStream();
            }
            String stream = readStream(inputStream);
            this.mBodyString = stream;
            return stream;
        } catch (IOException e) {
            throw new BoxException("Unable to get string body", e);
        }
    }

    private String readStream(InputStream inputStream) throws BoxException, IOException {
        if (inputStream == null) {
            return null;
        }
        String str = this.mContentEncoding;
        if (str != null && str.equalsIgnoreCase("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[8192];
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            for (int i = inputStreamReader.read(cArr, 0, 8192); i != -1; i = inputStreamReader.read(cArr, 0, 8192)) {
                sb.append(cArr, 0, i);
            }
            inputStreamReader.close();
            return sb.toString();
        } catch (IOException e) {
            throw new BoxException("Unable to read stream", e);
        }
    }

    public HttpURLConnection getHttpURLConnection() {
        return this.mConnection;
    }
}
