package org.apache.hc.core5.http.impl.bootstrap;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocketFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.config.NamedElementChain;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.impl.HttpProcessors;
import org.apache.hc.core5.http.impl.io.DefaultBHttpServerConnection;
import org.apache.hc.core5.http.impl.io.DefaultBHttpServerConnectionFactory;
import org.apache.hc.core5.http.impl.io.DefaultClassicHttpResponseFactory;
import org.apache.hc.core5.http.impl.io.HttpService;
import org.apache.hc.core5.http.impl.routing.RequestRouter;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.HttpFilterHandler;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.ssl.DefaultTlsSetupHandler;
import org.apache.hc.core5.http.io.support.BasicHttpServerExpectationDecorator;
import org.apache.hc.core5.http.io.support.BasicHttpServerRequestHandler;
import org.apache.hc.core5.http.io.support.HttpServerExpectationFilter;
import org.apache.hc.core5.http.io.support.HttpServerFilterChainElement;
import org.apache.hc.core5.http.io.support.HttpServerFilterChainRequestHandler;
import org.apache.hc.core5.http.io.support.TerminalServerFilter;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.http.protocol.LookupRegistry;
import org.apache.hc.core5.http.protocol.RequestHandlerRegistry;
import org.apache.hc.core5.http.protocol.UriPatternMatcher;
import org.apache.hc.core5.http.protocol.UriPatternType;
import org.apache.hc.core5.net.InetAddressUtils;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class ServerBootstrap {
    private String canonicalHostName;
    private CharCodingConfig charCodingConfig;
    private ConnectionReuseStrategy connStrategy;
    private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private ExceptionListener exceptionListener;
    private Http1Config http1Config;
    private HttpProcessor httpProcessor;
    private int listenerPort;
    private InetAddress localAddress;
    private LookupRegistry<HttpRequestHandler> lookupRegistry;
    private HttpRequestMapper<HttpRequestHandler> requestRouter;
    private HttpResponseFactory<ClassicHttpResponse> responseFactory;
    private ServerSocketFactory serverSocketFactory;
    private SocketConfig socketConfig;
    private SSLContext sslContext;
    private Callback<SSLParameters> sslSetupHandler;
    private Http1StreamListener streamListener;
    private final List<RequestRouter.Entry<HttpRequestHandler>> routeEntries = new ArrayList();
    private final List<FilterEntry<HttpFilterHandler>> filters = new ArrayList();

    private ServerBootstrap() {
    }

    public static ServerBootstrap bootstrap() {
        return new ServerBootstrap();
    }

    public final ServerBootstrap setCanonicalHostName(String str) {
        this.canonicalHostName = str;
        return this;
    }

    public final ServerBootstrap setListenerPort(int i) {
        this.listenerPort = i;
        return this;
    }

    public final ServerBootstrap setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
        return this;
    }

    public final ServerBootstrap setSocketConfig(SocketConfig socketConfig) {
        this.socketConfig = socketConfig;
        return this;
    }

    public final ServerBootstrap setHttp1Config(Http1Config http1Config) {
        this.http1Config = http1Config;
        return this;
    }

    public final ServerBootstrap setCharCodingConfig(CharCodingConfig charCodingConfig) {
        this.charCodingConfig = charCodingConfig;
        return this;
    }

    public final ServerBootstrap setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpProcessor = httpProcessor;
        return this;
    }

    public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.connStrategy = connectionReuseStrategy;
        return this;
    }

    public final ServerBootstrap setResponseFactory(HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this.responseFactory = httpResponseFactory;
        return this;
    }

    @Deprecated
    public final ServerBootstrap setLookupRegistry(LookupRegistry<HttpRequestHandler> lookupRegistry) {
        this.lookupRegistry = lookupRegistry;
        return this;
    }

    public final ServerBootstrap register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notBlank(str, "URI pattern");
        Args.notNull(httpRequestHandler, "Supplier");
        this.routeEntries.add(new RequestRouter.Entry<>(str, httpRequestHandler));
        return this;
    }

    public final ServerBootstrap register(String str, String str2, HttpRequestHandler httpRequestHandler) {
        Args.notBlank(str, "Hostname");
        Args.notBlank(str2, "URI pattern");
        Args.notNull(httpRequestHandler, "Request handler");
        this.routeEntries.add(new RequestRouter.Entry<>(str, str2, httpRequestHandler));
        return this;
    }

    @Deprecated
    public final ServerBootstrap registerVirtual(String str, String str2, HttpRequestHandler httpRequestHandler) {
        return register(str, str2, httpRequestHandler);
    }

    public final ServerBootstrap setRequestRouter(HttpRequestMapper<HttpRequestHandler> httpRequestMapper) {
        this.requestRouter = httpRequestMapper;
        return this;
    }

    public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory) {
        this.connectionFactory = httpConnectionFactory;
        return this;
    }

    public final ServerBootstrap setServerSocketFactory(ServerSocketFactory serverSocketFactory) {
        this.serverSocketFactory = serverSocketFactory;
        return this;
    }

    public final ServerBootstrap setSslContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
        return this;
    }

    public final ServerBootstrap setSslSetupHandler(Callback<SSLParameters> callback) {
        this.sslSetupHandler = callback;
        return this;
    }

    public final ServerBootstrap setExceptionListener(ExceptionListener exceptionListener) {
        this.exceptionListener = exceptionListener;
        return this;
    }

    public final ServerBootstrap setStreamListener(Http1StreamListener http1StreamListener) {
        this.streamListener = http1StreamListener;
        return this;
    }

    public final ServerBootstrap addFilterBefore(String str, String str2, HttpFilterHandler httpFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notBlank(str2, "Name");
        Args.notNull(httpFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.BEFORE, str2, httpFilterHandler, str));
        return this;
    }

    public final ServerBootstrap addFilterAfter(String str, String str2, HttpFilterHandler httpFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notBlank(str2, "Name");
        Args.notNull(httpFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.AFTER, str2, httpFilterHandler, str));
        return this;
    }

    public final ServerBootstrap replaceFilter(String str, HttpFilterHandler httpFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notNull(httpFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.REPLACE, str, httpFilterHandler, str));
        return this;
    }

    public final ServerBootstrap addFilterFirst(String str, HttpFilterHandler httpFilterHandler) {
        Args.notNull(str, "Name");
        Args.notNull(httpFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.FIRST, str, httpFilterHandler, null));
        return this;
    }

    public final ServerBootstrap addFilterLast(String str, HttpFilterHandler httpFilterHandler) {
        Args.notNull(str, "Name");
        Args.notNull(httpFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.LAST, str, httpFilterHandler, null));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [org.apache.hc.core5.http.protocol.RequestHandlerRegistry] */
    /* JADX WARN: Type inference failed for: r2v4, types: [org.apache.hc.core5.http.impl.routing.RequestRouter] */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.apache.hc.core5.http.HttpRequestMapper<org.apache.hc.core5.http.io.HttpRequestHandler>] */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.apache.hc.core5.http.HttpRequestMapper] */
    public HttpServer create() {
        ?? Create;
        HttpServerRequestHandler basicHttpServerExpectationDecorator;
        HttpConnectionFactory<? extends DefaultBHttpServerConnection> defaultBHttpServerConnectionFactory;
        String canonicalLocalHostName = this.canonicalHostName;
        if (canonicalLocalHostName == null) {
            canonicalLocalHostName = InetAddressUtils.getCanonicalLocalHostName();
        }
        HttpServerFilterChainElement httpServerFilterChainElement = null;
        if (this.lookupRegistry != null && this.requestRouter == null) {
            Create = new RequestHandlerRegistry(canonicalLocalHostName, new Supplier() { // from class: org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.function.Supplier
                public final Object get() {
                    return this.f$0.m16634x35456612();
                }
            });
            for (RequestRouter.Entry<HttpRequestHandler> entry : this.routeEntries) {
                Create.register(entry.uriAuthority != null ? entry.uriAuthority.getHostName() : null, entry.route.pattern, entry.route.handler);
            }
        } else if (this.routeEntries.isEmpty()) {
            Create = this.requestRouter;
        } else {
            Create = RequestRouter.create(new URIAuthority(canonicalLocalHostName), UriPatternType.URI_PATTERN, this.routeEntries, RequestRouter.IGNORE_PORT_AUTHORITY_RESOLVER, this.requestRouter);
        }
        if (!this.filters.isEmpty()) {
            NamedElementChain namedElementChain = new NamedElementChain();
            HttpResponseFactory httpResponseFactory = this.responseFactory;
            if (httpResponseFactory == null) {
                httpResponseFactory = DefaultClassicHttpResponseFactory.INSTANCE;
            }
            namedElementChain.addLast(new TerminalServerFilter(Create, httpResponseFactory), StandardFilter.MAIN_HANDLER.name());
            namedElementChain.addFirst(new HttpServerExpectationFilter(), StandardFilter.EXPECT_CONTINUE.name());
            for (FilterEntry<HttpFilterHandler> filterEntry : this.filters) {
                int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position[filterEntry.position.ordinal()];
                if (i == 1) {
                    namedElementChain.addAfter(filterEntry.existing, filterEntry.filterHandler, filterEntry.name);
                } else if (i == 2) {
                    namedElementChain.addBefore(filterEntry.existing, filterEntry.filterHandler, filterEntry.name);
                } else if (i == 3) {
                    namedElementChain.replace(filterEntry.existing, filterEntry.filterHandler);
                } else if (i == 4) {
                    namedElementChain.addFirst(filterEntry.filterHandler, filterEntry.name);
                } else if (i == 5) {
                    namedElementChain.addBefore(StandardFilter.MAIN_HANDLER.name(), filterEntry.filterHandler, filterEntry.name);
                }
            }
            NamedElementChain.Node last = namedElementChain.getLast();
            while (last != null) {
                HttpServerFilterChainElement httpServerFilterChainElement2 = new HttpServerFilterChainElement((HttpFilterHandler) last.getValue(), httpServerFilterChainElement);
                last = last.getPrevious();
                httpServerFilterChainElement = httpServerFilterChainElement2;
            }
            basicHttpServerExpectationDecorator = new HttpServerFilterChainRequestHandler(httpServerFilterChainElement);
        } else {
            HttpResponseFactory httpResponseFactory2 = this.responseFactory;
            if (httpResponseFactory2 == null) {
                httpResponseFactory2 = DefaultClassicHttpResponseFactory.INSTANCE;
            }
            basicHttpServerExpectationDecorator = new BasicHttpServerExpectationDecorator(new BasicHttpServerRequestHandler(Create, httpResponseFactory2));
        }
        HttpServerRequestHandler httpServerRequestHandler = basicHttpServerExpectationDecorator;
        HttpProcessor httpProcessorServer = this.httpProcessor;
        if (httpProcessorServer == null) {
            httpProcessorServer = HttpProcessors.server();
        }
        HttpProcessor httpProcessor = httpProcessorServer;
        Http1Config http1Config = this.http1Config;
        ConnectionReuseStrategy connectionReuseStrategy = this.connStrategy;
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        HttpService httpService = new HttpService(httpProcessor, httpServerRequestHandler, http1Config, connectionReuseStrategy, this.streamListener);
        HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory = this.connectionFactory;
        if (httpConnectionFactory == null) {
            defaultBHttpServerConnectionFactory = new DefaultBHttpServerConnectionFactory((((this.serverSocketFactory instanceof SSLServerSocketFactory) || this.sslContext != null) ? URIScheme.HTTPS : URIScheme.HTTP).id, this.http1Config, this.charCodingConfig);
        } else {
            defaultBHttpServerConnectionFactory = httpConnectionFactory;
        }
        int iMax = Math.max(this.listenerPort, 0);
        InetAddress inetAddress = this.localAddress;
        SocketConfig socketConfig = this.socketConfig;
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        SocketConfig socketConfig2 = socketConfig;
        ServerSocketFactory serverSocketFactory = this.serverSocketFactory;
        SSLContext sSLContext = this.sslContext;
        Callback callback = this.sslSetupHandler;
        if (callback == null) {
            callback = DefaultTlsSetupHandler.SERVER;
        }
        Callback callback2 = callback;
        ExceptionListener exceptionListener = this.exceptionListener;
        if (exceptionListener == null) {
            exceptionListener = ExceptionListener.NO_OP;
        }
        return new HttpServer(iMax, httpService, inetAddress, socketConfig2, serverSocketFactory, defaultBHttpServerConnectionFactory, sSLContext, callback2, exceptionListener);
    }

    /* JADX INFO: renamed from: lambda$create$0$org-apache-hc-core5-http-impl-bootstrap-ServerBootstrap, reason: not valid java name */
    /* synthetic */ LookupRegistry m16634x35456612() {
        LookupRegistry<HttpRequestHandler> lookupRegistry = this.lookupRegistry;
        return lookupRegistry != null ? lookupRegistry : new UriPatternMatcher();
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position;

        static {
            int[] iArr = new int[FilterEntry.Position.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position = iArr;
            try {
                iArr[FilterEntry.Position.AFTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position[FilterEntry.Position.BEFORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position[FilterEntry.Position.REPLACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position[FilterEntry.Position.FIRST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$bootstrap$FilterEntry$Position[FilterEntry.Position.LAST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
