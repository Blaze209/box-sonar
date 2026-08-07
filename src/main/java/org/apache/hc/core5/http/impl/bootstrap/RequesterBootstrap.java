package org.apache.hc.core5.http.impl.bootstrap;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultAddressResolver;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.impl.HttpProcessors;
import org.apache.hc.core5.http.impl.io.DefaultBHttpClientConnectionFactory;
import org.apache.hc.core5.http.impl.io.HttpRequestExecutor;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.ssl.DefaultTlsSetupHandler;
import org.apache.hc.core5.http.io.ssl.SSLSessionVerifier;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.pool.ConnPoolListener;
import org.apache.hc.core5.pool.DefaultDisposalCallback;
import org.apache.hc.core5.pool.LaxConnPool;
import org.apache.hc.core5.pool.ManagedConnPool;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.pool.StrictConnPool;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class RequesterBootstrap {
    private ConnPoolListener<HttpHost> connPoolListener;
    private ConnectionReuseStrategy connReuseStrategy;
    private HttpConnectionFactory<? extends HttpClientConnection> connectFactory;
    private int defaultMaxPerRoute;
    private Http1Config http1Config;
    private HttpProcessor httpProcessor;
    private int maxTotal;
    private PoolConcurrencyPolicy poolConcurrencyPolicy;
    private PoolReusePolicy poolReusePolicy;
    private SocketConfig socketConfig;
    private SSLSessionVerifier sslSessionVerifier;
    private Callback<SSLParameters> sslSetupHandler;
    private SSLSocketFactory sslSocketFactory;
    private Http1StreamListener streamListener;
    private Timeout timeToLive;

    private RequesterBootstrap() {
    }

    public static RequesterBootstrap bootstrap() {
        return new RequesterBootstrap();
    }

    public final RequesterBootstrap setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpProcessor = httpProcessor;
        return this;
    }

    public final RequesterBootstrap setHttp1Config(Http1Config http1Config) {
        this.http1Config = http1Config;
        return this;
    }

    public final RequesterBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.connReuseStrategy = connectionReuseStrategy;
        return this;
    }

    public final RequesterBootstrap setSocketConfig(SocketConfig socketConfig) {
        this.socketConfig = socketConfig;
        return this;
    }

    public final RequesterBootstrap setConnectionFactory(HttpConnectionFactory<? extends HttpClientConnection> httpConnectionFactory) {
        this.connectFactory = httpConnectionFactory;
        return this;
    }

    public final RequesterBootstrap setSslContext(SSLContext sSLContext) {
        this.sslSocketFactory = sSLContext != null ? sSLContext.getSocketFactory() : null;
        return this;
    }

    public final RequesterBootstrap setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public final RequesterBootstrap setSslSetupHandler(Callback<SSLParameters> callback) {
        this.sslSetupHandler = callback;
        return this;
    }

    public final RequesterBootstrap setSslSessionVerifier(SSLSessionVerifier sSLSessionVerifier) {
        this.sslSessionVerifier = sSLSessionVerifier;
        return this;
    }

    public final RequesterBootstrap setDefaultMaxPerRoute(int i) {
        this.defaultMaxPerRoute = i;
        return this;
    }

    public final RequesterBootstrap setMaxTotal(int i) {
        this.maxTotal = i;
        return this;
    }

    public final RequesterBootstrap setTimeToLive(Timeout timeout) {
        this.timeToLive = timeout;
        return this;
    }

    public final RequesterBootstrap setPoolReusePolicy(PoolReusePolicy poolReusePolicy) {
        this.poolReusePolicy = poolReusePolicy;
        return this;
    }

    public final RequesterBootstrap setPoolConcurrencyPolicy(PoolConcurrencyPolicy poolConcurrencyPolicy) {
        this.poolConcurrencyPolicy = poolConcurrencyPolicy;
        return this;
    }

    public final RequesterBootstrap setStreamListener(Http1StreamListener http1StreamListener) {
        this.streamListener = http1StreamListener;
        return this;
    }

    public final RequesterBootstrap setConnPoolListener(ConnPoolListener<HttpHost> connPoolListener) {
        this.connPoolListener = connPoolListener;
        return this;
    }

    public HttpRequester create() {
        ManagedConnPool laxConnPool;
        Http1Config http1Config = this.http1Config;
        ConnectionReuseStrategy connectionReuseStrategy = this.connReuseStrategy;
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutor(http1Config, connectionReuseStrategy, this.streamListener);
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$hc$core5$pool$PoolConcurrencyPolicy;
        PoolConcurrencyPolicy poolConcurrencyPolicy = this.poolConcurrencyPolicy;
        if (poolConcurrencyPolicy == null) {
            poolConcurrencyPolicy = PoolConcurrencyPolicy.STRICT;
        }
        if (iArr[poolConcurrencyPolicy.ordinal()] == 1) {
            int i = this.defaultMaxPerRoute;
            laxConnPool = new LaxConnPool(i > 0 ? i : 20, this.timeToLive, this.poolReusePolicy, new DefaultDisposalCallback(), this.connPoolListener);
        } else {
            int i2 = this.defaultMaxPerRoute;
            int i3 = i2 > 0 ? i2 : 20;
            int i4 = this.maxTotal;
            if (i4 <= 0) {
                i4 = 50;
            }
            laxConnPool = new StrictConnPool(i3, i4, this.timeToLive, this.poolReusePolicy, new DefaultDisposalCallback(), this.connPoolListener);
        }
        HttpProcessor httpProcessorClient = this.httpProcessor;
        if (httpProcessorClient == null) {
            httpProcessorClient = HttpProcessors.client();
        }
        SocketConfig socketConfig = this.socketConfig;
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        HttpConnectionFactory defaultBHttpClientConnectionFactory = this.connectFactory;
        if (defaultBHttpClientConnectionFactory == null) {
            defaultBHttpClientConnectionFactory = new DefaultBHttpClientConnectionFactory(this.http1Config, CharCodingConfig.DEFAULT);
        }
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        Callback callback = this.sslSetupHandler;
        if (callback == null) {
            callback = DefaultTlsSetupHandler.CLIENT;
        }
        return new HttpRequester(httpRequestExecutor, httpProcessorClient, laxConnPool, socketConfig, defaultBHttpClientConnectionFactory, sSLSocketFactory, callback, this.sslSessionVerifier, DefaultAddressResolver.INSTANCE);
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.bootstrap.RequesterBootstrap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$pool$PoolConcurrencyPolicy;

        static {
            int[] iArr = new int[PoolConcurrencyPolicy.values().length];
            $SwitchMap$org$apache$hc$core5$pool$PoolConcurrencyPolicy = iArr;
            try {
                iArr[PoolConcurrencyPolicy.LAX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$pool$PoolConcurrencyPolicy[PoolConcurrencyPolicy.STRICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
