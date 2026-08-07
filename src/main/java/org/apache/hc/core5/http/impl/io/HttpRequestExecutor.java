package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionReuseStrategy;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultConnectionReuseStrategy;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.HttpResponseInformationCallback;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestExecutor {
    public static final Timeout DEFAULT_WAIT_FOR_CONTINUE = Timeout.ofSeconds(3L);
    private final ConnectionReuseStrategy connReuseStrategy;
    private final Http1Config http1Config;
    private final Http1StreamListener streamListener;

    public HttpRequestExecutor(Http1Config http1Config, ConnectionReuseStrategy connectionReuseStrategy, Http1StreamListener http1StreamListener) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.connReuseStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.streamListener = http1StreamListener;
    }

    @Deprecated
    public HttpRequestExecutor(Timeout timeout, ConnectionReuseStrategy connectionReuseStrategy, Http1StreamListener http1StreamListener) {
        this(Http1Config.custom().setWaitForContinueTimeout(timeout).build(), connectionReuseStrategy, http1StreamListener);
    }

    public HttpRequestExecutor(ConnectionReuseStrategy connectionReuseStrategy) {
        this(Http1Config.DEFAULT, connectionReuseStrategy, (Http1StreamListener) null);
    }

    public HttpRequestExecutor() {
        this(Http1Config.DEFAULT, (ConnectionReuseStrategy) null, (Http1StreamListener) null);
    }

    public ClassicHttpResponse execute(ClassicHttpRequest classicHttpRequest, HttpClientConnection httpClientConnection, HttpResponseInformationCallback httpResponseInformationCallback, HttpContext httpContext) throws HttpException, IOException {
        boolean z;
        Args.notNull(classicHttpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        HttpCoreContext httpCoreContextCastOrCreate = HttpCoreContext.castOrCreate(httpContext);
        try {
            httpCoreContextCastOrCreate.setSSLSession(httpClientConnection.getSSLSession());
            httpCoreContextCastOrCreate.setEndpointDetails(httpClientConnection.getEndpointDetails());
            httpClientConnection.sendRequestHeader(classicHttpRequest);
            Http1StreamListener http1StreamListener = this.streamListener;
            if (http1StreamListener != null) {
                http1StreamListener.onRequestHead(httpClientConnection, classicHttpRequest);
            }
            if (classicHttpRequest.getEntity() != null) {
                Header firstHeader = classicHttpRequest.getFirstHeader("Expect");
                z = firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
                if (!z) {
                    httpClientConnection.sendRequestEntity(classicHttpRequest);
                }
            } else {
                z = false;
            }
            httpClientConnection.flush();
            while (true) {
                ClassicHttpResponse classicHttpResponseReceiveResponseHeader = null;
                while (true) {
                    if (classicHttpResponseReceiveResponseHeader != null) {
                        if (MessageSupport.canResponseHaveBody(classicHttpRequest.getMethod(), classicHttpResponseReceiveResponseHeader)) {
                            httpClientConnection.receiveResponseEntity(classicHttpResponseReceiveResponseHeader);
                        }
                        return classicHttpResponseReceiveResponseHeader;
                    }
                    if (z) {
                        if (httpClientConnection.isDataAvailable(this.http1Config.getWaitForContinueTimeout() != null ? this.http1Config.getWaitForContinueTimeout() : DEFAULT_WAIT_FOR_CONTINUE)) {
                            classicHttpResponseReceiveResponseHeader = httpClientConnection.receiveResponseHeader();
                            Http1StreamListener http1StreamListener2 = this.streamListener;
                            if (http1StreamListener2 != null) {
                                http1StreamListener2.onResponseHead(httpClientConnection, classicHttpResponseReceiveResponseHeader);
                            }
                            int code = classicHttpResponseReceiveResponseHeader.getCode();
                            if (code == 100) {
                                httpClientConnection.sendRequestEntity(classicHttpRequest);
                                classicHttpResponseReceiveResponseHeader = null;
                            } else {
                                if (code < 200) {
                                    if (httpResponseInformationCallback == null) {
                                        break;
                                    }
                                    httpResponseInformationCallback.execute(classicHttpResponseReceiveResponseHeader, httpClientConnection, httpCoreContextCastOrCreate);
                                    break;
                                }
                                if (code >= 400) {
                                    httpClientConnection.terminateRequest(classicHttpRequest);
                                } else {
                                    httpClientConnection.sendRequestEntity(classicHttpRequest);
                                }
                            }
                        } else {
                            httpClientConnection.sendRequestEntity(classicHttpRequest);
                        }
                        httpClientConnection.flush();
                        z = false;
                    } else {
                        classicHttpResponseReceiveResponseHeader = httpClientConnection.receiveResponseHeader();
                        Http1StreamListener http1StreamListener3 = this.streamListener;
                        if (http1StreamListener3 != null) {
                            http1StreamListener3.onResponseHead(httpClientConnection, classicHttpResponseReceiveResponseHeader);
                        }
                        int code2 = classicHttpResponseReceiveResponseHeader.getCode();
                        if (code2 < 100) {
                            throw new ProtocolException("Invalid response: " + new StatusLine(classicHttpResponseReceiveResponseHeader));
                        }
                        if (code2 < 200) {
                            if (httpResponseInformationCallback != null && code2 != 100) {
                                httpResponseInformationCallback.execute(classicHttpResponseReceiveResponseHeader, httpClientConnection, httpCoreContextCastOrCreate);
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        } catch (IOException | RuntimeException | HttpException e) {
            Closer.closeQuietly(httpClientConnection);
            throw e;
        }
    }

    public ClassicHttpResponse execute(ClassicHttpRequest classicHttpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        return execute(classicHttpRequest, httpClientConnection, null, httpContext);
    }

    public void preProcess(ClassicHttpRequest classicHttpRequest, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(classicHttpRequest, "HTTP request");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        ProtocolVersion version = classicHttpRequest.getVersion();
        if (version != null && !version.lessEquals(this.http1Config.getVersion())) {
            throw new UnsupportedHttpVersionException(version);
        }
        HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        if (version == null) {
            version = this.http1Config.getVersion();
        }
        httpCoreContextCast.setProtocolVersion(version);
        httpCoreContextCast.setRequest(classicHttpRequest);
        httpProcessor.process(classicHttpRequest, classicHttpRequest.getEntity(), httpCoreContextCast);
    }

    public void postProcess(ClassicHttpResponse classicHttpResponse, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(classicHttpResponse, "HTTP response");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        HttpCoreContext httpCoreContextCast = HttpCoreContext.cast(httpContext);
        ProtocolVersion version = classicHttpResponse.getVersion();
        if (version != null) {
            if (version.greaterEquals(HttpVersion.HTTP_2)) {
                throw new UnsupportedHttpVersionException(version);
            }
            httpCoreContextCast.setProtocolVersion(version);
        }
        httpCoreContextCast.setResponse(classicHttpResponse);
        httpProcessor.process(classicHttpResponse, classicHttpResponse.getEntity(), httpCoreContextCast);
    }

    public boolean keepAlive(ClassicHttpRequest classicHttpRequest, ClassicHttpResponse classicHttpResponse, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "HTTP connection");
        Args.notNull(classicHttpRequest, "HTTP request");
        Args.notNull(classicHttpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        boolean z = httpClientConnection.isConsistent() && this.connReuseStrategy.keepAlive(classicHttpRequest, classicHttpResponse, httpContext);
        Http1StreamListener http1StreamListener = this.streamListener;
        if (http1StreamListener != null) {
            http1StreamListener.onExchangeComplete(httpClientConnection, z);
        }
        return z;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ConnectionReuseStrategy connReuseStrategy;
        private Http1StreamListener streamListener;
        private Timeout waitForContinue;

        private Builder() {
        }

        public Builder withWaitForContinue(Timeout timeout) {
            this.waitForContinue = timeout;
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

        public HttpRequestExecutor build() {
            return new HttpRequestExecutor(this.waitForContinue, this.connReuseStrategy, this.streamListener);
        }
    }
}
