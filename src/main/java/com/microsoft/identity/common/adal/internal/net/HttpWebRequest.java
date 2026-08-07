package com.microsoft.identity.common.adal.internal.net;

import android.os.Debug;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class HttpWebRequest {
    private static final int DEBUG_SIMULATE_DELAY = 0;
    static final String REQUEST_METHOD_GET = "GET";
    static final String REQUEST_METHOD_POST = "POST";
    private final byte[] mRequestContent;
    private final String mRequestContentType;
    private final Map<String, String> mRequestHeaders;
    private final String mRequestMethod;
    private final URL mUrl;
    private static final int CONNECT_TIME_OUT = AuthenticationSettings.INSTANCE.getConnectTimeOut();
    private static final int READ_TIME_OUT = AuthenticationSettings.INSTANCE.getReadTimeOut();

    public HttpWebRequest(URL url, String str, Map<String, String> map) {
        this(url, str, map, null, null);
    }

    public HttpWebRequest(URL url, String str, Map<String, String> map, byte[] bArr, String str2) {
        this.mUrl = url;
        this.mRequestMethod = str;
        HashMap map2 = new HashMap();
        this.mRequestHeaders = map2;
        if (url != null) {
            map2.put("Host", url.getAuthority());
        }
        map2.putAll(map);
        this.mRequestContent = bArr;
        this.mRequestContentType = str2;
    }

    private HttpURLConnection setupConnection() throws Throwable {
        URL url = this.mUrl;
        if (url == null) {
            throw new IllegalArgumentException("requestURL");
        }
        if (!url.getProtocol().equalsIgnoreCase("http") && !this.mUrl.getProtocol().equalsIgnoreCase("https")) {
            throw new IllegalArgumentException("requestURL");
        }
        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection httpURLConnectionCreateHttpUrlConnection = HttpUrlConnectionFactory.createHttpUrlConnection(this.mUrl);
        httpURLConnectionCreateHttpUrlConnection.setConnectTimeout(CONNECT_TIME_OUT);
        for (Map.Entry<String, String> entry : this.mRequestHeaders.entrySet()) {
            httpURLConnectionCreateHttpUrlConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnectionCreateHttpUrlConnection.setReadTimeout(READ_TIME_OUT);
        httpURLConnectionCreateHttpUrlConnection.setInstanceFollowRedirects(true);
        httpURLConnectionCreateHttpUrlConnection.setUseCaches(false);
        httpURLConnectionCreateHttpUrlConnection.setRequestMethod(this.mRequestMethod);
        httpURLConnectionCreateHttpUrlConnection.setDoInput(true);
        setRequestBody(httpURLConnectionCreateHttpUrlConnection, this.mRequestContent, this.mRequestContentType);
        return httpURLConnectionCreateHttpUrlConnection;
    }

    public HttpWebResponse send() throws Throwable {
        InputStream errorStream;
        HttpURLConnection httpURLConnection = setupConnection();
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
                errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    throw e;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            String strConvertStreamToString = convertStreamToString(errorStream);
            Debug.isDebuggerConnected();
            HttpWebResponse httpWebResponse = new HttpWebResponse(responseCode, strConvertStreamToString, httpURLConnection.getHeaderFields());
            safeCloseStream(errorStream);
            return httpWebResponse;
        } catch (Throwable th) {
            safeCloseStream(null);
            throw th;
        }
    }

    private static String convertStreamToString(InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, AuthenticationConstants.CHARSET_UTF8));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    } else {
                        String string = sb.toString();
                        bufferedReader2.close();
                        return string;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void setRequestBody(HttpURLConnection httpURLConnection, byte[] bArr, String str) throws Throwable {
        OutputStream outputStream;
        if (bArr == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (str != null && !str.isEmpty()) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bArr.length));
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                safeCloseStream(outputStream);
            } catch (Throwable th) {
                th = th;
                safeCloseStream(outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
    }

    private static void safeCloseStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
