package org.apache.hc.core5.http.impl.bootstrap;

import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.impl.HttpProcessors;
import org.apache.hc.core5.http.impl.nio.ClientHttp1IOEventHandlerFactory;
import org.apache.hc.core5.http.impl.nio.ClientHttp1StreamDuplexerFactory;
import org.apache.hc.core5.http.nio.ssl.BasicClientTlsStrategy;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.pool.ConnPoolListener;
import org.apache.hc.core5.pool.DefaultDisposalCallback;
import org.apache.hc.core5.pool.LaxConnPool;
import org.apache.hc.core5.pool.ManagedConnPool;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.pool.PoolReusePolicy;
import org.apache.hc.core5.pool.StrictConnPool;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncRequesterBootstrap {
    private CharCodingConfig charCodingConfig;
    private ConnPoolListener<HttpHost> connPoolListener;
    private ConnectionReuseStrategy connStrategy;
    private int defaultMaxPerRoute;
    private Callback<Exception> exceptionCallback;
    private Timeout handshakeTimeout;
    private Http1Config http1Config;
    private HttpProcessor httpProcessor;
    private IOReactorConfig ioReactorConfig;
    private Decorator<IOSession> ioSessionDecorator;
    private int maxTotal;
    private PoolConcurrencyPolicy poolConcurrencyPolicy;
    private PoolReusePolicy poolReusePolicy;
    private IOSessionListener sessionListener;
    private Http1StreamListener streamListener;
    private Timeout timeToLive;
    private TlsStrategy tlsStrategy;

    private AsyncRequesterBootstrap() {
    }

    public static AsyncRequesterBootstrap bootstrap() {
        return new AsyncRequesterBootstrap();
    }

    public final AsyncRequesterBootstrap setIOReactorConfig(IOReactorConfig iOReactorConfig) {
        this.ioReactorConfig = iOReactorConfig;
        return this;
    }

    public final AsyncRequesterBootstrap setHttp1Config(Http1Config http1Config) {
        this.http1Config = http1Config;
        return this;
    }

    public final AsyncRequesterBootstrap setCharCodingConfig(CharCodingConfig charCodingConfig) {
        this.charCodingConfig = charCodingConfig;
        return this;
    }

    public final AsyncRequesterBootstrap setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpProcessor = httpProcessor;
        return this;
    }

    public final AsyncRequesterBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.connStrategy = connectionReuseStrategy;
        return this;
    }

    public final AsyncRequesterBootstrap setDefaultMaxPerRoute(int i) {
        this.defaultMaxPerRoute = i;
        return this;
    }

    public final AsyncRequesterBootstrap setMaxTotal(int i) {
        this.maxTotal = i;
        return this;
    }

    public final AsyncRequesterBootstrap setTimeToLive(Timeout timeout) {
        this.timeToLive = timeout;
        return this;
    }

    public final AsyncRequesterBootstrap setPoolReusePolicy(PoolReusePolicy poolReusePolicy) {
        this.poolReusePolicy = poolReusePolicy;
        return this;
    }

    public final AsyncRequesterBootstrap setPoolConcurrencyPolicy(PoolConcurrencyPolicy poolConcurrencyPolicy) {
        this.poolConcurrencyPolicy = poolConcurrencyPolicy;
        return this;
    }

    public final AsyncRequesterBootstrap setTlsStrategy(TlsStrategy tlsStrategy) {
        this.tlsStrategy = tlsStrategy;
        return this;
    }

    public final AsyncRequesterBootstrap setTlsHandshakeTimeout(Timeout timeout) {
        this.handshakeTimeout = timeout;
        return this;
    }

    public final AsyncRequesterBootstrap setIOSessionDecorator(Decorator<IOSession> decorator) {
        this.ioSessionDecorator = decorator;
        return this;
    }

    public final AsyncRequesterBootstrap setExceptionCallback(Callback<Exception> callback) {
        this.exceptionCallback = callback;
        return this;
    }

    public final AsyncRequesterBootstrap setIOSessionListener(IOSessionListener iOSessionListener) {
        this.sessionListener = iOSessionListener;
        return this;
    }

    public final AsyncRequesterBootstrap setStreamListener(Http1StreamListener http1StreamListener) {
        this.streamListener = http1StreamListener;
        return this;
    }

    public final AsyncRequesterBootstrap setConnPoolListener(ConnPoolListener<HttpHost> connPoolListener) {
        this.connPoolListener = connPoolListener;
        return this;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.bootstrap.AsyncRequesterBootstrap$1, reason: invalid class name */
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

    public HttpAsyncRequester create() {
        ManagedConnPool laxConnPool;
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
        Http1Config http1Config = this.http1Config;
        if (http1Config == null) {
            http1Config = Http1Config.DEFAULT;
        }
        CharCodingConfig charCodingConfig = this.charCodingConfig;
        if (charCodingConfig == null) {
            charCodingConfig = CharCodingConfig.DEFAULT;
        }
        ClientHttp1StreamDuplexerFactory clientHttp1StreamDuplexerFactory = new ClientHttp1StreamDuplexerFactory(httpProcessorClient, http1Config, charCodingConfig, this.connStrategy, null, null, this.streamListener);
        TlsStrategy basicClientTlsStrategy = this.tlsStrategy;
        if (basicClientTlsStrategy == null) {
            basicClientTlsStrategy = new BasicClientTlsStrategy();
        }
        TlsStrategy tlsStrategy = basicClientTlsStrategy;
        return new HttpAsyncRequester(this.ioReactorConfig, new ClientHttp1IOEventHandlerFactory(clientHttp1StreamDuplexerFactory, tlsStrategy, this.handshakeTimeout), this.ioSessionDecorator, this.exceptionCallback, this.sessionListener, laxConnPool, tlsStrategy, this.handshakeTimeout);
    }
}
