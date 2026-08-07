package org.apache.hc.core5.http.impl.bootstrap;

import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.config.NamedElementChain;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.impl.HttpProcessors;
import org.apache.hc.core5.http.impl.nio.DefaultHttpRequestParserFactory;
import org.apache.hc.core5.http.impl.nio.DefaultHttpResponseWriterFactory;
import org.apache.hc.core5.http.impl.nio.ServerHttp1IOEventHandlerFactory;
import org.apache.hc.core5.http.impl.nio.ServerHttp1StreamDuplexerFactory;
import org.apache.hc.core5.http.impl.routing.RequestRouter;
import org.apache.hc.core5.http.nio.AsyncFilterHandler;
import org.apache.hc.core5.http.nio.AsyncServerExchangeHandler;
import org.apache.hc.core5.http.nio.AsyncServerRequestHandler;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.http.nio.support.AsyncServerExpectationFilter;
import org.apache.hc.core5.http.nio.support.AsyncServerFilterChainElement;
import org.apache.hc.core5.http.nio.support.AsyncServerFilterChainExchangeHandlerFactory;
import org.apache.hc.core5.http.nio.support.BasicAsyncServerExpectationDecorator;
import org.apache.hc.core5.http.nio.support.BasicServerExchangeHandler;
import org.apache.hc.core5.http.nio.support.DefaultAsyncResponseExchangeHandlerFactory;
import org.apache.hc.core5.http.nio.support.TerminalAsyncServerFilter;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.http.protocol.LookupRegistry;
import org.apache.hc.core5.http.protocol.RequestHandlerRegistry;
import org.apache.hc.core5.http.protocol.UriPatternMatcher;
import org.apache.hc.core5.http.protocol.UriPatternType;
import org.apache.hc.core5.net.InetAddressUtils;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class AsyncServerBootstrap {
    private String canonicalHostName;
    private CharCodingConfig charCodingConfig;
    private ConnectionReuseStrategy connStrategy;
    private Callback<Exception> exceptionCallback;
    private Timeout handshakeTimeout;
    private Http1Config http1Config;
    private HttpProcessor httpProcessor;
    private IOReactorConfig ioReactorConfig;
    private Decorator<IOSession> ioSessionDecorator;
    private LookupRegistry<Supplier<AsyncServerExchangeHandler>> lookupRegistry;
    private HttpRequestMapper<Supplier<AsyncServerExchangeHandler>> requestRouter;
    private IOSessionListener sessionListener;
    private Http1StreamListener streamListener;
    private TlsStrategy tlsStrategy;
    private final List<RequestRouter.Entry<Supplier<AsyncServerExchangeHandler>>> routeEntries = new ArrayList();
    private final List<FilterEntry<AsyncFilterHandler>> filters = new ArrayList();

    private AsyncServerBootstrap() {
    }

    public static AsyncServerBootstrap bootstrap() {
        return new AsyncServerBootstrap();
    }

    public final AsyncServerBootstrap setCanonicalHostName(String str) {
        this.canonicalHostName = str;
        return this;
    }

    public final AsyncServerBootstrap setIOReactorConfig(IOReactorConfig iOReactorConfig) {
        this.ioReactorConfig = iOReactorConfig;
        return this;
    }

    public final AsyncServerBootstrap setHttp1Config(Http1Config http1Config) {
        this.http1Config = http1Config;
        return this;
    }

    public final AsyncServerBootstrap setCharCodingConfig(CharCodingConfig charCodingConfig) {
        this.charCodingConfig = charCodingConfig;
        return this;
    }

    public final AsyncServerBootstrap setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpProcessor = httpProcessor;
        return this;
    }

    public final AsyncServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.connStrategy = connectionReuseStrategy;
        return this;
    }

    public final AsyncServerBootstrap setTlsStrategy(TlsStrategy tlsStrategy) {
        this.tlsStrategy = tlsStrategy;
        return this;
    }

    public final AsyncServerBootstrap setTlsHandshakeTimeout(Timeout timeout) {
        this.handshakeTimeout = timeout;
        return this;
    }

    public final AsyncServerBootstrap setIOSessionDecorator(Decorator<IOSession> decorator) {
        this.ioSessionDecorator = decorator;
        return this;
    }

    public final AsyncServerBootstrap setExceptionCallback(Callback<Exception> callback) {
        this.exceptionCallback = callback;
        return this;
    }

    public final AsyncServerBootstrap setIOSessionListener(IOSessionListener iOSessionListener) {
        this.sessionListener = iOSessionListener;
        return this;
    }

    @Deprecated
    public final AsyncServerBootstrap setLookupRegistry(LookupRegistry<Supplier<AsyncServerExchangeHandler>> lookupRegistry) {
        this.lookupRegistry = lookupRegistry;
        return this;
    }

    public final AsyncServerBootstrap setRequestRouter(HttpRequestMapper<Supplier<AsyncServerExchangeHandler>> httpRequestMapper) {
        this.requestRouter = httpRequestMapper;
        return this;
    }

    public final AsyncServerBootstrap setStreamListener(Http1StreamListener http1StreamListener) {
        this.streamListener = http1StreamListener;
        return this;
    }

    public final AsyncServerBootstrap register(String str, Supplier<AsyncServerExchangeHandler> supplier) {
        Args.notBlank(str, "URI pattern");
        Args.notNull(supplier, "Exchange handler supplier");
        this.routeEntries.add(new RequestRouter.Entry<>(str, supplier));
        return this;
    }

    public final AsyncServerBootstrap register(String str, String str2, Supplier<AsyncServerExchangeHandler> supplier) {
        Args.notBlank(str, "Hostname");
        Args.notBlank(str2, "URI pattern");
        Args.notNull(supplier, "Exchange handler supplier");
        this.routeEntries.add(new RequestRouter.Entry<>(str, str2, supplier));
        return this;
    }

    @Deprecated
    public final AsyncServerBootstrap registerVirtual(String str, String str2, Supplier<AsyncServerExchangeHandler> supplier) {
        return register(str, str2, supplier);
    }

    static /* synthetic */ AsyncServerExchangeHandler lambda$register$0(AsyncServerRequestHandler asyncServerRequestHandler) {
        return new BasicServerExchangeHandler(asyncServerRequestHandler);
    }

    public final <T> AsyncServerBootstrap register(String str, final AsyncServerRequestHandler<T> asyncServerRequestHandler) {
        register(str, new Supplier() { // from class: org.apache.hc.core5.http.impl.bootstrap.AsyncServerBootstrap$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return AsyncServerBootstrap.lambda$register$0(asyncServerRequestHandler);
            }
        });
        return this;
    }

    static /* synthetic */ AsyncServerExchangeHandler lambda$register$1(AsyncServerRequestHandler asyncServerRequestHandler) {
        return new BasicServerExchangeHandler(asyncServerRequestHandler);
    }

    public final <T> AsyncServerBootstrap register(String str, String str2, final AsyncServerRequestHandler<T> asyncServerRequestHandler) {
        register(str, str2, new Supplier() { // from class: org.apache.hc.core5.http.impl.bootstrap.AsyncServerBootstrap$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return AsyncServerBootstrap.lambda$register$1(asyncServerRequestHandler);
            }
        });
        return this;
    }

    @Deprecated
    public final <T> AsyncServerBootstrap registerVirtual(String str, String str2, AsyncServerRequestHandler<T> asyncServerRequestHandler) {
        return register(str, str2, asyncServerRequestHandler);
    }

    public final AsyncServerBootstrap addFilterBefore(String str, String str2, AsyncFilterHandler asyncFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notBlank(str2, "Name");
        Args.notNull(asyncFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.BEFORE, str2, asyncFilterHandler, str));
        return this;
    }

    public final AsyncServerBootstrap addFilterAfter(String str, String str2, AsyncFilterHandler asyncFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notBlank(str2, "Name");
        Args.notNull(asyncFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.AFTER, str2, asyncFilterHandler, str));
        return this;
    }

    public final AsyncServerBootstrap replaceFilter(String str, AsyncFilterHandler asyncFilterHandler) {
        Args.notBlank(str, "Existing");
        Args.notNull(asyncFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.REPLACE, str, asyncFilterHandler, str));
        return this;
    }

    public final AsyncServerBootstrap addFilterFirst(String str, AsyncFilterHandler asyncFilterHandler) {
        Args.notNull(str, "Name");
        Args.notNull(asyncFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.FIRST, str, asyncFilterHandler, null));
        return this;
    }

    public final AsyncServerBootstrap addFilterLast(String str, AsyncFilterHandler asyncFilterHandler) {
        Args.notNull(str, "Name");
        Args.notNull(asyncFilterHandler, "Filter handler");
        this.filters.add(new FilterEntry<>(FilterEntry.Position.LAST, str, asyncFilterHandler, null));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [org.apache.hc.core5.http.protocol.RequestHandlerRegistry] */
    /* JADX WARN: Type inference failed for: r1v4, types: [org.apache.hc.core5.http.impl.routing.RequestRouter] */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.apache.hc.core5.http.HttpRequestMapper<org.apache.hc.core5.function.Supplier<org.apache.hc.core5.http.nio.AsyncServerExchangeHandler>>] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.apache.hc.core5.http.HttpRequestMapper] */
    public HttpAsyncServer create() {
        ?? Create;
        HandlerFactory defaultAsyncResponseExchangeHandlerFactory;
        String canonicalLocalHostName = this.canonicalHostName;
        if (canonicalLocalHostName == null) {
            canonicalLocalHostName = InetAddressUtils.getCanonicalLocalHostName();
        }
        AsyncServerFilterChainElement asyncServerFilterChainElement = null;
        if (this.lookupRegistry != null && this.requestRouter == null) {
            Create = new RequestHandlerRegistry(canonicalLocalHostName, new Supplier() { // from class: org.apache.hc.core5.http.impl.bootstrap.AsyncServerBootstrap$$ExternalSyntheticLambda2
                @Override // org.apache.hc.core5.function.Supplier
                public final Object get() {
                    return this.f$0.m16631xc9430c46();
                }
            });
            for (RequestRouter.Entry<Supplier<AsyncServerExchangeHandler>> entry : this.routeEntries) {
                Create.register(entry.uriAuthority != null ? entry.uriAuthority.getHostName() : null, entry.route.pattern, entry.route.handler);
            }
        } else if (this.routeEntries.isEmpty()) {
            Create = this.requestRouter;
        } else {
            Create = RequestRouter.create(new URIAuthority(canonicalLocalHostName), UriPatternType.URI_PATTERN, this.routeEntries, RequestRouter.IGNORE_PORT_AUTHORITY_RESOLVER, this.requestRouter);
        }
        if (!this.filters.isEmpty()) {
            NamedElementChain namedElementChain = new NamedElementChain();
            namedElementChain.addLast(new TerminalAsyncServerFilter(new DefaultAsyncResponseExchangeHandlerFactory(Create)), StandardFilter.MAIN_HANDLER.name());
            namedElementChain.addFirst(new AsyncServerExpectationFilter(), StandardFilter.EXPECT_CONTINUE.name());
            for (FilterEntry<AsyncFilterHandler> filterEntry : this.filters) {
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
                AsyncServerFilterChainElement asyncServerFilterChainElement2 = new AsyncServerFilterChainElement((AsyncFilterHandler) last.getValue(), asyncServerFilterChainElement);
                last = last.getPrevious();
                asyncServerFilterChainElement = asyncServerFilterChainElement2;
            }
            defaultAsyncResponseExchangeHandlerFactory = new AsyncServerFilterChainExchangeHandlerFactory(asyncServerFilterChainElement, this.exceptionCallback);
        } else {
            defaultAsyncResponseExchangeHandlerFactory = new DefaultAsyncResponseExchangeHandlerFactory(Create, new Decorator() { // from class: org.apache.hc.core5.http.impl.bootstrap.AsyncServerBootstrap$$ExternalSyntheticLambda3
                @Override // org.apache.hc.core5.function.Decorator
                public final Object decorate(Object obj) {
                    return this.f$0.m16632x5d817be5((AsyncServerExchangeHandler) obj);
                }
            });
        }
        HandlerFactory handlerFactory = defaultAsyncResponseExchangeHandlerFactory;
        HttpProcessor httpProcessorServer = this.httpProcessor;
        if (httpProcessorServer == null) {
            httpProcessorServer = HttpProcessors.server();
        }
        HttpProcessor httpProcessor = httpProcessorServer;
        Http1Config http1Config = this.http1Config;
        CharCodingConfig charCodingConfig = this.charCodingConfig;
        if (charCodingConfig == null) {
            charCodingConfig = CharCodingConfig.DEFAULT;
        }
        CharCodingConfig charCodingConfig2 = charCodingConfig;
        ConnectionReuseStrategy connectionReuseStrategy = this.connStrategy;
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        return new HttpAsyncServer(new ServerHttp1IOEventHandlerFactory(new ServerHttp1StreamDuplexerFactory(httpProcessor, handlerFactory, http1Config, charCodingConfig2, connectionReuseStrategy, new DefaultHttpRequestParserFactory(this.http1Config), new DefaultHttpResponseWriterFactory(this.http1Config), DefaultContentLengthStrategy.INSTANCE, DefaultContentLengthStrategy.INSTANCE, this.streamListener), this.tlsStrategy, this.handshakeTimeout), this.ioReactorConfig, this.ioSessionDecorator, this.exceptionCallback, this.sessionListener);
    }

    /* JADX INFO: renamed from: lambda$create$2$org-apache-hc-core5-http-impl-bootstrap-AsyncServerBootstrap, reason: not valid java name */
    /* synthetic */ LookupRegistry m16631xc9430c46() {
        LookupRegistry<Supplier<AsyncServerExchangeHandler>> lookupRegistry = this.lookupRegistry;
        return lookupRegistry != null ? lookupRegistry : new UriPatternMatcher();
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.bootstrap.AsyncServerBootstrap$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: lambda$create$3$org-apache-hc-core5-http-impl-bootstrap-AsyncServerBootstrap, reason: not valid java name */
    /* synthetic */ AsyncServerExchangeHandler m16632x5d817be5(AsyncServerExchangeHandler asyncServerExchangeHandler) {
        return new BasicAsyncServerExpectationDecorator(asyncServerExchangeHandler, this.exceptionCallback);
    }
}
