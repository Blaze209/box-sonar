package external.sdk.pendo.io.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import sdk.pendo.io.e.e;
import sdk.pendo.io.y.g;

/* JADX INFO: loaded from: classes4.dex */
public class HttpUrlFetcher implements external.sdk.pendo.io.glide.load.data.a<InputStream> {
    static final b DEFAULT_CONNECTION_FACTORY = new a();
    static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    static final String REDIRECT_HEADER_FIELD = "Location";
    private static final String TAG = "HttpUrlFetcher";
    private final b connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    private static class a implements b {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.HttpUrlFetcher.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url);
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, DEFAULT_CONNECTION_FACTORY);
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map<String, String> map) throws e {
        try {
            HttpURLConnection httpURLConnectionA = this.connectionFactory.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.timeout);
            httpURLConnectionA.setReadTimeout(this.timeout);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new e("URL.openConnection threw", 0, e);
        }
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 3)) {
                return -1;
            }
            Log.d(TAG, "Failed to get a response code", e);
            return -1;
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws e {
        InputStream inputStream;
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                inputStream = sdk.pendo.io.y.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                inputStream = httpURLConnection.getInputStream();
            }
            this.stream = inputStream;
            return inputStream;
        } catch (IOException e) {
            throw new e("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e);
        }
    }

    private static boolean isHttpOk(int i) {
        return i / 100 == 2;
    }

    private static boolean isHttpRedirect(int i) {
        return i / 100 == 3;
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url2, Map<String, String> map) throws e {
        if (i >= 5) {
            throw new e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionBuildAndConfigureConnection = buildAndConfigureConnection(url, map);
        this.urlConnection = httpURLConnectionBuildAndConfigureConnection;
        try {
            httpURLConnectionBuildAndConfigureConnection.connect();
            this.stream = this.urlConnection.getInputStream();
            if (this.isCancelled) {
                return null;
            }
            int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
            if (isHttpOk(httpStatusCodeOrInvalid)) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (!isHttpRedirect(httpStatusCodeOrInvalid)) {
                if (httpStatusCodeOrInvalid == -1) {
                    throw new e(httpStatusCodeOrInvalid);
                }
                try {
                    throw new e(this.urlConnection.getResponseMessage(), httpStatusCodeOrInvalid);
                } catch (IOException e) {
                    throw new e("Failed to get a response message", httpStatusCodeOrInvalid, e);
                }
            }
            String headerField = this.urlConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new e("Received empty or null redirect url", httpStatusCodeOrInvalid);
            }
            try {
                URL url3 = new URL(url, headerField);
                cleanup();
                return loadDataWithRedirects(url3, i + 1, url, map);
            } catch (MalformedURLException e2) {
                throw new e("Bad redirect url: " + headerField, httpStatusCodeOrInvalid, e2);
            }
        } catch (IOException e3) {
            throw new e("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e3);
        }
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public sdk.pendo.io.e.a getDataSource() {
        return sdk.pendo.io.e.a.REMOTE;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super InputStream> interfaceC0307a) {
        long jA = g.a();
        try {
            interfaceC0307a.a(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data for url", e);
            }
            interfaceC0307a.a((Exception) e);
        } finally {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished http url fetcher fetch in " + g.a(jA));
            }
        }
    }

    HttpUrlFetcher(GlideUrl glideUrl, int i, b bVar) {
        this.glideUrl = glideUrl;
        this.timeout = i;
        this.connectionFactory = bVar;
    }
}
