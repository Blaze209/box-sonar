package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.HttpResponseFactory;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.impl.ServerSupport;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.HttpServerConnection;
import org.apache.hc.core5.http.io.HttpServerRequestHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.BasicHttpServerExpectationDecorator;
import org.apache.hc.core5.http.io.support.BasicHttpServerRequestHandler;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class HttpService {
    private final ConnectionReuseStrategy connReuseStrategy;
    private final Http1Config http1Config;
    private final HttpProcessor processor;
    private final HttpServerRequestHandler requestHandler;
    private final Http1StreamListener streamListener;

    public HttpService(HttpProcessor httpProcessor, HttpRequestMapper<HttpRequestHandler> httpRequestMapper, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory, Http1StreamListener http1StreamListener) {
        this(httpProcessor, new BasicHttpServerExpectationDecorator(new BasicHttpServerRequestHandler(httpRequestMapper, httpResponseFactory)), Http1Config.DEFAULT, connectionReuseStrategy, http1StreamListener);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestMapper<HttpRequestHandler> httpRequestMapper, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory<ClassicHttpResponse> httpResponseFactory) {
        this(httpProcessor, httpRequestMapper, connectionReuseStrategy, httpResponseFactory, (Http1StreamListener) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpServerRequestHandler httpServerRequestHandler, ConnectionReuseStrategy connectionReuseStrategy, Http1StreamListener http1StreamListener) {
        this(httpProcessor, httpServerRequestHandler, Http1Config.DEFAULT, connectionReuseStrategy, http1StreamListener);
    }

    public HttpService(HttpProcessor httpProcessor, HttpServerRequestHandler httpServerRequestHandler, Http1Config http1Config, ConnectionReuseStrategy connectionReuseStrategy, Http1StreamListener http1StreamListener) {
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.requestHandler = (HttpServerRequestHandler) Args.notNull(httpServerRequestHandler, "Request handler");
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.connReuseStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.streamListener = http1StreamListener;
    }

    public HttpService(HttpProcessor httpProcessor, HttpServerRequestHandler httpServerRequestHandler) {
        this(httpProcessor, httpServerRequestHandler, Http1Config.DEFAULT, (ConnectionReuseStrategy) null, (Http1StreamListener) null);
    }

    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws HttpException, IOException {
        HttpService httpService;
        final HttpServerConnection httpServerConnection2;
        HttpException httpException;
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        try {
            final ClassicHttpRequest classicHttpRequestReceiveRequestHeader = httpServerConnection.receiveRequestHeader();
            try {
                if (classicHttpRequestReceiveRequestHeader == null) {
                    httpServerConnection.close();
                    return;
                }
                Http1StreamListener http1StreamListener = this.streamListener;
                if (http1StreamListener != null) {
                    http1StreamListener.onRequestHead(httpServerConnection, classicHttpRequestReceiveRequestHeader);
                }
                httpServerConnection.receiveRequestEntity(classicHttpRequestReceiveRequestHeader);
                ProtocolVersion version = classicHttpRequestReceiveRequestHeader.getVersion();
                if (version != null && version.greaterEquals(HttpVersion.HTTP_2)) {
                    throw new UnsupportedHttpVersionException(version);
                }
                if (version == null) {
                    version = this.http1Config.getVersion();
                }
                httpCoreContextCast.setProtocolVersion(version);
                httpCoreContextCast.setRequest(classicHttpRequestReceiveRequestHeader);
                httpCoreContextCast.setSSLSession(httpServerConnection.getSSLSession());
                httpCoreContextCast.setEndpointDetails(httpServerConnection.getEndpointDetails());
                this.processor.process(classicHttpRequestReceiveRequestHeader, classicHttpRequestReceiveRequestHeader.getEntity(), httpCoreContextCast);
                httpService = this;
                httpServerConnection2 = httpServerConnection;
                try {
                    this.requestHandler.handle(classicHttpRequestReceiveRequestHeader, new HttpServerRequestHandler.ResponseTrigger() { // from class: org.apache.hc.core5.http.impl.io.HttpService.1
                        @Override // org.apache.hc.core5.http.io.HttpServerRequestHandler.ResponseTrigger
                        public void sendInformation(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
                            if (atomicBoolean.get()) {
                                throw new HttpException("Response already submitted");
                            }
                            if (classicHttpResponse.getCode() < 200) {
                                if (HttpService.this.streamListener != null) {
                                    HttpService.this.streamListener.onResponseHead(httpServerConnection2, classicHttpResponse);
                                }
                                httpServerConnection2.sendResponseHeader(classicHttpResponse);
                                httpServerConnection2.flush();
                                return;
                            }
                            throw new HttpException("Invalid intermediate response");
                        }

                        @Override // org.apache.hc.core5.http.io.HttpServerRequestHandler.ResponseTrigger
                        public void submitResponse(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
                            try {
                                ProtocolVersion version2 = classicHttpResponse.getVersion();
                                if (version2 != null) {
                                    if (!version2.lessEquals(HttpService.this.http1Config.getVersion())) {
                                        throw new UnsupportedHttpVersionException(version2);
                                    }
                                    httpCoreContextCast.setProtocolVersion(version2);
                                }
                                httpCoreContextCast.setResponse(classicHttpResponse);
                                HttpService.this.processor.process(classicHttpResponse, classicHttpResponse.getEntity(), httpCoreContextCast);
                                atomicBoolean.set(true);
                                httpServerConnection2.sendResponseHeader(classicHttpResponse);
                                if (HttpService.this.streamListener != null) {
                                    HttpService.this.streamListener.onResponseHead(httpServerConnection2, classicHttpResponse);
                                }
                                if (MessageSupport.canResponseHaveBody(classicHttpRequestReceiveRequestHeader.getMethod(), classicHttpResponse)) {
                                    httpServerConnection2.sendResponseEntity(classicHttpResponse);
                                }
                                EntityUtils.consume(classicHttpRequestReceiveRequestHeader.getEntity());
                                boolean zKeepAlive = HttpService.this.connReuseStrategy.keepAlive(classicHttpRequestReceiveRequestHeader, classicHttpResponse, httpCoreContextCast);
                                if (HttpService.this.streamListener != null) {
                                    HttpService.this.streamListener.onExchangeComplete(httpServerConnection2, zKeepAlive);
                                }
                                if (!zKeepAlive) {
                                    httpServerConnection2.close();
                                }
                                httpServerConnection2.flush();
                                classicHttpResponse.close();
                            } catch (Throwable th) {
                                classicHttpResponse.close();
                                throw th;
                            }
                        }
                    }, httpCoreContextCast);
                    return;
                } catch (HttpException e) {
                    e = e;
                }
            } catch (HttpException e2) {
                httpException = e2;
                httpService = this;
                httpServerConnection2 = httpServerConnection;
            }
        } catch (HttpException e3) {
            e = e3;
            httpService = this;
            httpServerConnection2 = httpServerConnection;
        }
        httpException = e;
        if (atomicBoolean.get()) {
            throw httpException;
        }
        BasicClassicHttpResponse basicClassicHttpResponse = new BasicClassicHttpResponse(500);
        try {
            httpService.handleException(httpException, basicClassicHttpResponse);
            basicClassicHttpResponse.setHeader("Connection", HeaderElements.CLOSE);
            httpCoreContextCast.setResponse(basicClassicHttpResponse);
            httpService.processor.process(basicClassicHttpResponse, basicClassicHttpResponse.getEntity(), httpCoreContextCast);
            httpServerConnection2.sendResponseHeader(basicClassicHttpResponse);
            Http1StreamListener http1StreamListener2 = httpService.streamListener;
            if (http1StreamListener2 != null) {
                http1StreamListener2.onResponseHead(httpServerConnection2, basicClassicHttpResponse);
            }
            httpServerConnection2.sendResponseEntity(basicClassicHttpResponse);
            httpServerConnection2.close();
            basicClassicHttpResponse.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    basicClassicHttpResponse.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    protected void handleException(HttpException httpException, ClassicHttpResponse classicHttpResponse) {
        classicHttpResponse.setCode(toStatusCode(httpException));
        classicHttpResponse.setEntity(new StringEntity(ServerSupport.toErrorMessage(httpException), ContentType.TEXT_PLAIN));
    }

    protected int toStatusCode(Exception exc) {
        return ServerSupport.toStatusCode(exc);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ConnectionReuseStrategy connReuseStrategy;
        private Http1Config http1Config;
        private HttpProcessor processor;
        private HttpServerRequestHandler requestHandler;
        private Http1StreamListener streamListener;

        private Builder() {
        }

        public Builder withHttpProcessor(HttpProcessor httpProcessor) {
            this.processor = httpProcessor;
            return this;
        }

        public Builder withHttpServerRequestHandler(HttpServerRequestHandler httpServerRequestHandler) {
            this.requestHandler = httpServerRequestHandler;
            return this;
        }

        public Builder withHttp1Config(Http1Config http1Config) {
            this.http1Config = http1Config;
            return this;
        }

        public Builder withConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
            this.connReuseStrategy = connectionReuseStrategy;
            return this;
        }

        public Builder withHttp1StreamListener(Http1StreamListener http1StreamListener) {
            this.streamListener = http1StreamListener;
            return this;
        }

        public HttpService build() {
            return new HttpService(this.processor, this.requestHandler, this.http1Config, this.connReuseStrategy, this.streamListener);
        }
    }
}
