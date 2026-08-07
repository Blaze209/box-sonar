package io.split.android.client.network;

import android.content.Context;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes4.dex */
public class HttpClientImpl implements HttpClient {
    private final CertificateChecker mCertificateChecker;
    private final long mConnectionTimeout;
    private final DevelopmentSslConfig mDevelopmentSslConfig;
    private final Proxy mProxy;
    private final SplitUrlConnectionAuthenticator mProxyAuthenticator;
    private final long mReadTimeout;
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlSanitizer mUrlSanitizer;
    private final Map<String, String> mCommonHeaders = new HashMap();
    private final Map<String, String> mStreamingHeaders = new HashMap();

    @Override // io.split.android.client.network.HttpClient
    public void close() {
    }

    HttpClientImpl(HttpProxy proxy, SplitAuthenticator proxyAuthenticator, long readTimeout, long connectionTimeout, DevelopmentSslConfig developmentSslConfig, SSLSocketFactory sslSocketFactory, UrlSanitizer urlSanitizer, CertificateChecker certificateChecker) {
        this.mProxy = initializeProxy(proxy);
        this.mProxyAuthenticator = initializeProxyAuthenticator(proxy, proxyAuthenticator);
        this.mReadTimeout = readTimeout;
        this.mConnectionTimeout = connectionTimeout;
        this.mDevelopmentSslConfig = developmentSslConfig;
        this.mSslSocketFactory = sslSocketFactory;
        this.mUrlSanitizer = urlSanitizer;
        this.mCertificateChecker = certificateChecker;
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod requestMethod, String body, Map<String, String> headers) {
        HashMap map = new HashMap(this.mCommonHeaders);
        if (headers != null) {
            map.putAll(headers);
        }
        return new HttpRequestImpl(uri, requestMethod, body, map, this.mProxy, this.mProxyAuthenticator, this.mReadTimeout, this.mConnectionTimeout, this.mDevelopmentSslConfig, this.mSslSocketFactory, this.mUrlSanitizer, this.mCertificateChecker);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod requestMethod) {
        return request(uri, requestMethod, null);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpRequest request(URI uri, HttpMethod requestMethod, String body) {
        return request(uri, requestMethod, body, null);
    }

    @Override // io.split.android.client.network.HttpClient
    public HttpStreamRequest streamRequest(URI uri) {
        return new HttpStreamRequestImpl(uri, this.mStreamingHeaders, this.mProxy, this.mProxyAuthenticator, this.mConnectionTimeout, this.mDevelopmentSslConfig, this.mSslSocketFactory, this.mUrlSanitizer, this.mCertificateChecker);
    }

    @Override // io.split.android.client.network.HttpClient
    public void setHeader(String name, String value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException(String.format("Invalid value for header %s: %s", name, value));
        }
        this.mCommonHeaders.put(name, value);
    }

    @Override // io.split.android.client.network.HttpClient
    public void setStreamingHeader(String name, String value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException(String.format("Invalid value for streaming header %s: %s", name, value));
        }
        this.mStreamingHeaders.put(name, value);
    }

    @Override // io.split.android.client.network.HttpClient
    public void addHeaders(Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            setHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // io.split.android.client.network.HttpClient
    public void addStreamingHeaders(Map<String, String> headers) {
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            setStreamingHeader(entry.getKey(), entry.getValue());
        }
    }

    private Proxy initializeProxy(HttpProxy proxy) {
        if (proxy != null) {
            return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxy.getHost(), proxy.getPort()));
        }
        return null;
    }

    private SplitUrlConnectionAuthenticator initializeProxyAuthenticator(HttpProxy proxy, SplitAuthenticator proxyAuthenticator) {
        if (proxy == null) {
            return null;
        }
        if (proxyAuthenticator != null) {
            return new SplitUrlConnectionAuthenticator(proxyAuthenticator);
        }
        if (Utils.isNullOrEmpty(proxy.getUsername())) {
            return null;
        }
        return createBasicAuthenticator(proxy.getUsername(), proxy.getPassword());
    }

    private static SplitUrlConnectionAuthenticator createBasicAuthenticator(String username, String password) {
        return new SplitUrlConnectionAuthenticator(new SplitBasicAuthenticator(username, password, new Base64Encoder() { // from class: io.split.android.client.network.HttpClientImpl.1
            @Override // io.split.android.client.network.Base64Encoder
            public String encode(String value) {
                return Base64Util.encode(value);
            }

            @Override // io.split.android.client.network.Base64Encoder
            public String encode(byte[] bytes) {
                return Base64Util.encode(bytes);
            }
        }));
    }

    public static class Builder {
        private CertificateChecker mCertificateChecker;
        private CertificatePinningConfiguration mCertificatePinningConfiguration;
        private Context mHostAppContext;
        private HttpProxy mProxy;
        private SplitAuthenticator mProxyAuthenticator;
        private UrlSanitizer mUrlSanitizer;
        private long mReadTimeout = -1;
        private long mConnectionTimeout = -1;
        private DevelopmentSslConfig mDevelopmentSslConfig = null;
        private SSLSocketFactory mSslSocketFactory = null;

        public Builder setContext(Context context) {
            this.mHostAppContext = context;
            return this;
        }

        public Builder setProxy(HttpProxy proxy) {
            this.mProxy = proxy;
            return this;
        }

        public Builder setProxyAuthenticator(SplitAuthenticator authenticator) {
            if (authenticator != null) {
                Logger.v("Setting up proxy authenticator");
            }
            this.mProxyAuthenticator = authenticator;
            return this;
        }

        public Builder setReadTimeout(long readTimeout) {
            if (readTimeout > 0) {
                this.mReadTimeout = readTimeout;
            }
            return this;
        }

        public Builder setConnectionTimeout(long connectionTimeout) {
            if (connectionTimeout > 0) {
                this.mConnectionTimeout = connectionTimeout;
            }
            return this;
        }

        public Builder setDevelopmentSslConfig(DevelopmentSslConfig developmentSslConfig) {
            this.mDevelopmentSslConfig = developmentSslConfig;
            return this;
        }

        public Builder setUrlSanitizer(UrlSanitizer urlSanitizer) {
            this.mUrlSanitizer = urlSanitizer;
            return this;
        }

        public Builder setCertificatePinningConfiguration(CertificatePinningConfiguration certificatePinningConfiguration) {
            this.mCertificatePinningConfiguration = certificatePinningConfiguration;
            return this;
        }

        Builder setCertificateChecker(CertificateChecker certificateChecker) {
            this.mCertificateChecker = certificateChecker;
            return this;
        }

        public HttpClient build() {
            CertificateChecker certificateChecker;
            if (this.mDevelopmentSslConfig == null && LegacyTlsUpdater.couldBeOld()) {
                LegacyTlsUpdater.update(this.mHostAppContext);
                try {
                    this.mSslSocketFactory = new Tls12OnlySocketFactory();
                } catch (KeyManagementException | NoSuchAlgorithmException e) {
                    Logger.e("TLS v12 algorithm not available: " + e.getLocalizedMessage());
                } catch (Exception e2) {
                    Logger.e("Unknown TLS v12 error: " + e2.getLocalizedMessage());
                }
            }
            CertificateChecker certificateCheckerImpl = this.mCertificateChecker;
            if (certificateCheckerImpl == null) {
                if (this.mCertificatePinningConfiguration == null) {
                    certificateChecker = null;
                } else {
                    CertificatePinningConfiguration certificatePinningConfiguration = this.mCertificatePinningConfiguration;
                    DevelopmentSslConfig developmentSslConfig = this.mDevelopmentSslConfig;
                    certificateCheckerImpl = new CertificateCheckerImpl(certificatePinningConfiguration, developmentSslConfig != null ? developmentSslConfig.getTrustManager() : null);
                    certificateChecker = certificateCheckerImpl;
                }
            } else {
                certificateChecker = certificateCheckerImpl;
            }
            HttpProxy httpProxy = this.mProxy;
            SplitAuthenticator splitAuthenticator = this.mProxyAuthenticator;
            long j = this.mReadTimeout;
            long j2 = this.mConnectionTimeout;
            DevelopmentSslConfig developmentSslConfig2 = this.mDevelopmentSslConfig;
            SSLSocketFactory sSLSocketFactory = this.mSslSocketFactory;
            UrlSanitizer urlSanitizerImpl = this.mUrlSanitizer;
            if (urlSanitizerImpl == null) {
                urlSanitizerImpl = new UrlSanitizerImpl();
            }
            return new HttpClientImpl(httpProxy, splitAuthenticator, j, j2, developmentSslConfig2, sSLSocketFactory, urlSanitizerImpl, certificateChecker);
        }
    }
}
