package io.split.android.client.network;

import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes4.dex */
public class HttpStreamRequestImpl implements HttpStreamRequest {
    private static final int STREAMING_READ_TIMEOUT_IN_MILLISECONDS = 80000;
    private BufferedReader mBufferedReader;
    private final CertificateChecker mCertificateChecker;
    private HttpURLConnection mConnection;
    private final long mConnectionTimeout;
    private final DevelopmentSslConfig mDevelopmentSslConfig;
    private final Map<String, String> mHeaders;
    private final Proxy mProxy;
    private final SplitUrlConnectionAuthenticator mProxyAuthenticator;
    private final SSLSocketFactory mSslSocketFactory;
    private final URI mUri;
    private final UrlSanitizer mUrlSanitizer;
    private final AtomicBoolean mWasRetried = new AtomicBoolean(false);
    private final HttpMethod mHttpMethod = HttpMethod.GET;

    HttpStreamRequestImpl(URI uri, Map<String, String> headers, Proxy proxy, SplitUrlConnectionAuthenticator proxyAuthenticator, long connectionTimeout, DevelopmentSslConfig developmentSslConfig, SSLSocketFactory sslSocketFactory, UrlSanitizer urlSanitizer, CertificateChecker certificateChecker) {
        this.mUri = (URI) Utils.checkNotNull(uri);
        this.mProxy = proxy;
        this.mUrlSanitizer = (UrlSanitizer) Utils.checkNotNull(urlSanitizer);
        this.mHeaders = new HashMap((Map) Utils.checkNotNull(headers));
        this.mProxyAuthenticator = proxyAuthenticator;
        this.mConnectionTimeout = connectionTimeout;
        this.mDevelopmentSslConfig = developmentSslConfig;
        this.mSslSocketFactory = sslSocketFactory;
        this.mCertificateChecker = certificateChecker;
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public HttpStreamResponse execute() throws HttpException {
        return getRequest();
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public void addHeader(String name, String value) {
        this.mHeaders.put(name, value);
    }

    @Override // io.split.android.client.network.HttpStreamRequest
    public void close() {
        try {
            Logger.d("Closing streaming connection");
            disconnect();
        } catch (Exception e) {
            Logger.d("Unknown error closing connection: " + e.getLocalizedMessage());
        } finally {
            if (this.mBufferedReader != null) {
                closeBufferedReader();
            }
            Logger.d("Streaming connection closed");
        }
    }

    private void closeBufferedReader() {
        try {
            this.mBufferedReader.close();
        } catch (Exception e) {
            Logger.d("Unknown error closing buffer: " + e.getLocalizedMessage());
        }
    }

    private HttpStreamResponse getRequest() throws HttpException {
        try {
            HttpURLConnection upConnection = setUpConnection(false);
            this.mConnection = upConnection;
            HttpStreamResponse httpStreamResponseBuildResponse = buildResponse(upConnection);
            return httpStreamResponseBuildResponse.getHttpStatus() == 407 ? handleAuthentication(httpStreamResponseBuildResponse) : httpStreamResponseBuildResponse;
        } catch (MalformedURLException e) {
            disconnect();
            throw new HttpException("URL is malformed: " + e.getLocalizedMessage());
        } catch (ProtocolException e2) {
            disconnect();
            throw new HttpException("Http method not allowed: " + e2.getLocalizedMessage());
        } catch (SSLPeerUnverifiedException e3) {
            disconnect();
            throw new HttpException("SSL peer not verified: " + e3.getLocalizedMessage(), HttpStatus.INTERNAL_NON_RETRYABLE.getCode());
        } catch (IOException e4) {
            disconnect();
            throw new HttpException("Something happened while retrieving data: " + e4.getLocalizedMessage());
        }
    }

    private HttpURLConnection setUpConnection(boolean useProxyAuthenticator) throws IOException {
        URL url = this.mUrlSanitizer.getUrl(this.mUri);
        if (url == null) {
            throw new IOException("Error parsing URL");
        }
        HttpURLConnection httpURLConnectionOpenConnection = HttpRequestHelper.openConnection(this.mProxy, this.mProxyAuthenticator, url, this.mHttpMethod, this.mHeaders, useProxyAuthenticator);
        HttpRequestHelper.applyTimeouts(80000L, this.mConnectionTimeout, httpURLConnectionOpenConnection);
        HttpRequestHelper.applySslConfig(this.mSslSocketFactory, this.mDevelopmentSslConfig, httpURLConnectionOpenConnection);
        httpURLConnectionOpenConnection.connect();
        HttpRequestHelper.checkPins(httpURLConnectionOpenConnection, this.mCertificateChecker);
        return httpURLConnectionOpenConnection;
    }

    private HttpStreamResponse handleAuthentication(HttpStreamResponse response) throws HttpException {
        if (this.mWasRetried.getAndSet(true)) {
            return response;
        }
        try {
            Logger.d("Retrying with proxy authentication");
            setUpConnection(true);
            return buildResponse(this.mConnection);
        } catch (Exception e) {
            throw new HttpException("Something happened while retrieving data: " + e.getLocalizedMessage());
        }
    }

    private HttpStreamResponse buildResponse(HttpURLConnection connection) throws IOException {
        InputStream inputStream;
        int responseCode = connection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300 && (inputStream = connection.getInputStream()) != null) {
            if (this.mBufferedReader != null) {
                closeBufferedReader();
            }
            this.mBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return new HttpStreamResponseImpl(responseCode, this.mBufferedReader);
        }
        return new HttpStreamResponseImpl(responseCode);
    }

    private void disconnect() {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
