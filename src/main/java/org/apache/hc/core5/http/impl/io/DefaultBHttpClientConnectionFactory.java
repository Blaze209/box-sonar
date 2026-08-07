package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.CharCodingSupport;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;
import org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpClientConnectionFactory implements HttpConnectionFactory<DefaultBHttpClientConnection> {
    private final CharCodingConfig charCodingConfig;
    private final Http1Config http1Config;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriterFactory<ClassicHttpRequest> requestWriterFactory;
    private final ResponseOutOfOrderStrategy responseOutOfOrderStrategy;
    private final HttpMessageParserFactory<ClassicHttpResponse> responseParserFactory;

    private DefaultBHttpClientConnectionFactory(Http1Config http1Config, CharCodingConfig charCodingConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, ResponseOutOfOrderStrategy responseOutOfOrderStrategy, HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        this.charCodingConfig = charCodingConfig == null ? CharCodingConfig.DEFAULT : charCodingConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.responseOutOfOrderStrategy = responseOutOfOrderStrategy;
        this.requestWriterFactory = httpMessageWriterFactory == null ? new DefaultHttpRequestWriterFactory(http1Config) : httpMessageWriterFactory;
        this.responseParserFactory = httpMessageParserFactory == null ? new DefaultHttpResponseParserFactory(http1Config) : httpMessageParserFactory;
    }

    public DefaultBHttpClientConnectionFactory(Http1Config http1Config, CharCodingConfig charCodingConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
        this(http1Config, charCodingConfig, contentLengthStrategy, contentLengthStrategy2, null, httpMessageWriterFactory, httpMessageParserFactory);
    }

    public DefaultBHttpClientConnectionFactory(Http1Config http1Config, CharCodingConfig charCodingConfig, HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
        this(http1Config, charCodingConfig, null, null, httpMessageWriterFactory, httpMessageParserFactory);
    }

    public DefaultBHttpClientConnectionFactory(Http1Config http1Config, CharCodingConfig charCodingConfig) {
        this(http1Config, charCodingConfig, null, null, null, null);
    }

    public DefaultBHttpClientConnectionFactory() {
        this(null, null, null, null, null, null);
    }

    DefaultBHttpClientConnection createDetached() {
        return new DefaultBHttpClientConnection(this.http1Config, CharCodingSupport.createDecoder(this.charCodingConfig), CharCodingSupport.createEncoder(this.charCodingConfig), this.incomingContentStrategy, this.outgoingContentStrategy, this.responseOutOfOrderStrategy, this.requestWriterFactory, this.responseParserFactory);
    }

    @Override // org.apache.hc.core5.http.io.HttpConnectionFactory
    public DefaultBHttpClientConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnectionCreateDetached = createDetached();
        defaultBHttpClientConnectionCreateDetached.bind(socket);
        return defaultBHttpClientConnectionCreateDetached;
    }

    @Override // org.apache.hc.core5.http.io.HttpConnectionFactory
    public DefaultBHttpClientConnection createConnection(SSLSocket sSLSocket, Socket socket) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnectionCreateDetached = createDetached();
        defaultBHttpClientConnectionCreateDetached.bind(sSLSocket, socket);
        return defaultBHttpClientConnectionCreateDetached;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CharCodingConfig charCodingConfig;
        private Http1Config http1Config;
        private ContentLengthStrategy incomingContentLengthStrategy;
        private ContentLengthStrategy outgoingContentLengthStrategy;
        private HttpMessageWriterFactory<ClassicHttpRequest> requestWriterFactory;
        private ResponseOutOfOrderStrategy responseOutOfOrderStrategy;
        private HttpMessageParserFactory<ClassicHttpResponse> responseParserFactory;

        private Builder() {
        }

        public Builder http1Config(Http1Config http1Config) {
            this.http1Config = http1Config;
            return this;
        }

        public Builder charCodingConfig(CharCodingConfig charCodingConfig) {
            this.charCodingConfig = charCodingConfig;
            return this;
        }

        public Builder incomingContentLengthStrategy(ContentLengthStrategy contentLengthStrategy) {
            this.incomingContentLengthStrategy = contentLengthStrategy;
            return this;
        }

        public Builder outgoingContentLengthStrategy(ContentLengthStrategy contentLengthStrategy) {
            this.outgoingContentLengthStrategy = contentLengthStrategy;
            return this;
        }

        public Builder responseOutOfOrderStrategy(ResponseOutOfOrderStrategy responseOutOfOrderStrategy) {
            this.responseOutOfOrderStrategy = responseOutOfOrderStrategy;
            return this;
        }

        public Builder requestWriterFactory(HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory) {
            this.requestWriterFactory = httpMessageWriterFactory;
            return this;
        }

        public Builder responseParserFactory(HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
            this.responseParserFactory = httpMessageParserFactory;
            return this;
        }

        public DefaultBHttpClientConnectionFactory build() {
            return new DefaultBHttpClientConnectionFactory(this.http1Config, this.charCodingConfig, this.incomingContentLengthStrategy, this.outgoingContentLengthStrategy, this.responseOutOfOrderStrategy, this.requestWriterFactory, this.responseParserFactory);
        }
    }
}
