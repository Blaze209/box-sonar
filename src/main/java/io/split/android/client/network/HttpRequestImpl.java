package io.split.android.client.network;

import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
public class HttpRequestImpl implements HttpRequest {
    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";
    public static final String CONTENT_TYPE = "Content-Type";
    private final String mBody;
    private final CertificateChecker mCertificateChecker;
    private final long mConnectionTimeout;
    private final DevelopmentSslConfig mDevelopmentSslConfig;
    private final Map<String, String> mHeaders;
    private final HttpMethod mHttpMethod;
    private final Proxy mProxy;
    private final SplitUrlConnectionAuthenticator mProxyAuthenticator;
    private final long mReadTimeout;
    private final SSLSocketFactory mSslSocketFactory;
    private final URI mUri;
    private final UrlSanitizer mUrlSanitizer;

    HttpRequestImpl(URI uri, HttpMethod httpMethod, String body, Map<String, String> headers, Proxy proxy, SplitUrlConnectionAuthenticator proxyAuthenticator, long readTimeout, long connectionTimeout, DevelopmentSslConfig developmentSslConfig, SSLSocketFactory sslSocketFactory, UrlSanitizer urlSanitizer, CertificateChecker certificateChecker) {
        this.mUri = (URI) Utils.checkNotNull(uri);
        this.mHttpMethod = (HttpMethod) Utils.checkNotNull(httpMethod);
        this.mBody = body;
        this.mUrlSanitizer = (UrlSanitizer) Utils.checkNotNull(urlSanitizer);
        this.mHeaders = new HashMap((Map) Utils.checkNotNull(headers));
        this.mProxy = proxy;
        this.mProxyAuthenticator = proxyAuthenticator;
        this.mReadTimeout = readTimeout;
        this.mConnectionTimeout = connectionTimeout;
        this.mDevelopmentSslConfig = developmentSslConfig;
        this.mSslSocketFactory = sslSocketFactory;
        this.mCertificateChecker = certificateChecker;
    }

    @Override // io.split.android.client.network.HttpRequest
    public HttpResponse execute() throws HttpException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$network$HttpMethod[this.mHttpMethod.ordinal()];
        if (i == 1) {
            return getRequest(atomicBoolean);
        }
        if (i == 2) {
            return postRequest(atomicBoolean);
        }
        throw new IllegalArgumentException("Request HTTP Method not valid: " + this.mHttpMethod.name());
    }

    /* JADX INFO: renamed from: io.split.android.client.network.HttpRequestImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$network$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$io$split$android$client$network$HttpMethod = iArr;
            try {
                iArr[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$network$HttpMethod[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private HttpResponse getRequest(AtomicBoolean wasRetried) throws HttpException {
        HttpURLConnection upConnection = null;
        try {
            try {
                try {
                    try {
                        upConnection = setUpConnection(false);
                        HttpResponse httpResponseBuildResponse = buildResponse(upConnection);
                        if (httpResponseBuildResponse.getHttpStatus() == 407) {
                            httpResponseBuildResponse = handleProxyAuthentication(httpResponseBuildResponse, true, wasRetried);
                        }
                        if (upConnection != null) {
                            upConnection.disconnect();
                        }
                        return httpResponseBuildResponse;
                    } catch (SSLPeerUnverifiedException e) {
                        throw new HttpException("SSL Peer Unverified: " + e.getLocalizedMessage(), HttpStatus.INTERNAL_NON_RETRYABLE.getCode());
                    }
                } catch (ProtocolException e2) {
                    throw new HttpException("Http method not allowed: " + e2.getLocalizedMessage());
                }
            } catch (MalformedURLException e3) {
                throw new HttpException("URL is malformed: " + e3.getLocalizedMessage());
            } catch (IOException e4) {
                throw new HttpException("Something happened while retrieving data: " + e4.getLocalizedMessage());
            }
        } catch (Throwable th) {
            if (upConnection != null) {
                upConnection.disconnect();
            }
            throw th;
        }
    }

    private HttpResponse postRequest(AtomicBoolean wasRetried) throws HttpException {
        if (this.mBody == null) {
            throw new HttpException("Json data is null");
        }
        HttpURLConnection upPostConnection = null;
        try {
            try {
                try {
                    upPostConnection = setUpPostConnection(false);
                    HttpResponse httpResponseBuildResponse = buildResponse(upPostConnection);
                    if (httpResponseBuildResponse.getHttpStatus() == 407) {
                        httpResponseBuildResponse = handleProxyAuthentication(httpResponseBuildResponse, false, wasRetried);
                    }
                    if (upPostConnection != null) {
                        upPostConnection.disconnect();
                    }
                    return httpResponseBuildResponse;
                } catch (IOException e) {
                    throw new HttpException("Something happened while posting data: " + e.getLocalizedMessage());
                }
            } catch (SSLPeerUnverifiedException e2) {
                throw new HttpException("SSL Peer Unverified: " + e2.getLocalizedMessage(), HttpStatus.INTERNAL_NON_RETRYABLE.getCode());
            }
        } catch (Throwable th) {
            if (upPostConnection != null) {
                upPostConnection.disconnect();
            }
            throw th;
        }
    }

    private HttpResponse handleProxyAuthentication(HttpResponse originalResponse, boolean isGet, AtomicBoolean wasRetried) throws HttpException {
        if (wasRetried.getAndSet(true)) {
            return originalResponse;
        }
        HttpURLConnection upConnection = null;
        try {
            try {
                Logger.d("Retrying with proxy authentication");
                upConnection = isGet ? setUpConnection(true) : setUpPostConnection(true);
                HttpResponse httpResponseBuildResponse = buildResponse(upConnection);
                if (upConnection != null) {
                    upConnection.disconnect();
                }
                return httpResponseBuildResponse;
            } catch (IOException e) {
                throw new HttpException("Something happened while retrieving data: " + e.getLocalizedMessage());
            }
        } catch (Throwable th) {
            if (upConnection != null) {
                upConnection.disconnect();
            }
            throw th;
        }
    }

    private HttpURLConnection setUpPostConnection(boolean useProxyAuthenticator) throws IOException {
        return setUpConnection(useProxyAuthenticator);
    }

    private HttpURLConnection setUpConnection(boolean authenticate) throws IOException {
        URL url = this.mUrlSanitizer.getUrl(this.mUri);
        if (url == null) {
            throw new IOException("Error parsing URL");
        }
        HttpURLConnection httpURLConnectionOpenConnection = HttpRequestHelper.openConnection(this.mProxy, this.mProxyAuthenticator, url, this.mHttpMethod, this.mHeaders, authenticate);
        HttpRequestHelper.applyTimeouts(this.mReadTimeout, this.mConnectionTimeout, httpURLConnectionOpenConnection);
        HttpRequestHelper.applySslConfig(this.mSslSocketFactory, this.mDevelopmentSslConfig, httpURLConnectionOpenConnection);
        String str = this.mBody;
        if (str != null && !str.trim().isEmpty()) {
            httpURLConnectionOpenConnection.setRequestProperty("Content-Type", APPLICATION_JSON_CHARSET_UTF_8);
            httpURLConnectionOpenConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnectionOpenConnection.getOutputStream();
            try {
                outputStream.write(this.mBody.getBytes());
                outputStream.flush();
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                if (outputStream == null) {
                    throw th;
                }
                try {
                    outputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        httpURLConnectionOpenConnection.connect();
        HttpRequestHelper.checkPins(httpURLConnectionOpenConnection, this.mCertificateChecker);
        return httpURLConnectionOpenConnection;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static HttpResponse buildResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            StringBuilder sb = new StringBuilder();
            InputStream inputStream = connection.getInputStream();
            if (inputStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th;
                    }
                    bufferedReader.close();
                } catch (Throwable th4) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th4;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return new HttpResponseImpl(responseCode, sb.length() > 0 ? sb.toString() : null);
        }
        return new HttpResponseImpl(responseCode);
    }
}
