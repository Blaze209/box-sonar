package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.CharCodingSupport;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpServerConnectionFactory implements HttpConnectionFactory<DefaultBHttpServerConnection> {
    private final CharCodingConfig charCodingConfig;
    private final Http1Config http1Config;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParserFactory<ClassicHttpRequest> requestParserFactory;
    private final HttpMessageWriterFactory<ClassicHttpResponse> responseWriterFactory;
    private final String scheme;

    public DefaultBHttpServerConnectionFactory(String str, Http1Config http1Config, CharCodingConfig charCodingConfig, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<ClassicHttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<ClassicHttpResponse> httpMessageWriterFactory) {
        this.scheme = str;
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        this.charCodingConfig = charCodingConfig == null ? CharCodingConfig.DEFAULT : charCodingConfig;
        this.incomingContentStrategy = contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2;
        this.requestParserFactory = httpMessageParserFactory == null ? new DefaultHttpRequestParserFactory(http1Config) : httpMessageParserFactory;
        this.responseWriterFactory = httpMessageWriterFactory == null ? new DefaultHttpResponseWriterFactory(http1Config) : httpMessageWriterFactory;
    }

    public DefaultBHttpServerConnectionFactory(String str, Http1Config http1Config, CharCodingConfig charCodingConfig, HttpMessageParserFactory<ClassicHttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<ClassicHttpResponse> httpMessageWriterFactory) {
        this(str, http1Config, charCodingConfig, null, null, httpMessageParserFactory, httpMessageWriterFactory);
    }

    public DefaultBHttpServerConnectionFactory(String str, Http1Config http1Config, CharCodingConfig charCodingConfig) {
        this(str, http1Config, charCodingConfig, null, null, null, null);
    }

    DefaultBHttpServerConnection createDetached(Socket socket) {
        String str = this.scheme;
        if (str == null) {
            str = (socket instanceof SSLSocket ? URIScheme.HTTPS : URIScheme.HTTP).id;
        }
        return new DefaultBHttpServerConnection(str, this.http1Config, CharCodingSupport.createDecoder(this.charCodingConfig), CharCodingSupport.createEncoder(this.charCodingConfig), this.incomingContentStrategy, this.outgoingContentStrategy, this.requestParserFactory, this.responseWriterFactory);
    }

    @Override // org.apache.hc.core5.http.io.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(Socket socket) throws IOException {
        DefaultBHttpServerConnection defaultBHttpServerConnectionCreateDetached = createDetached(socket);
        defaultBHttpServerConnectionCreateDetached.bind(socket);
        return defaultBHttpServerConnectionCreateDetached;
    }

    @Override // org.apache.hc.core5.http.io.HttpConnectionFactory
    public DefaultBHttpServerConnection createConnection(SSLSocket sSLSocket, Socket socket) throws IOException {
        DefaultBHttpServerConnection defaultBHttpServerConnectionCreateDetached = createDetached(sSLSocket);
        defaultBHttpServerConnectionCreateDetached.bind(sSLSocket, socket);
        return defaultBHttpServerConnectionCreateDetached;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private CharCodingConfig charCodingConfig;
        private Http1Config http1Config;
        private ContentLengthStrategy incomingContentLengthStrategy;
        private ContentLengthStrategy outgoingContentLengthStrategy;
        private HttpMessageParserFactory<ClassicHttpRequest> requestParserFactory;
        private HttpMessageWriterFactory<ClassicHttpResponse> responseWriterFactory;
        private String scheme;

        private Builder() {
        }

        public Builder scheme(String str) {
            this.scheme = str;
            return this;
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

        public Builder requestParserFactory(HttpMessageParserFactory<ClassicHttpRequest> httpMessageParserFactory) {
            this.requestParserFactory = httpMessageParserFactory;
            return this;
        }

        public Builder responseWriterFactory(HttpMessageWriterFactory<ClassicHttpResponse> httpMessageWriterFactory) {
            this.responseWriterFactory = httpMessageWriterFactory;
            return this;
        }

        public DefaultBHttpServerConnectionFactory build() {
            return new DefaultBHttpServerConnectionFactory(this.scheme, this.http1Config, this.charCodingConfig, this.incomingContentLengthStrategy, this.outgoingContentLengthStrategy, this.requestParserFactory, this.responseWriterFactory);
        }
    }
}
