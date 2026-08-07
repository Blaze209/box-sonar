package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.apache.hc.core5.http.io.HttpMessageParser;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.io.HttpMessageWriter;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;
import org.apache.hc.core5.http.io.HttpServerConnection;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageParser<ClassicHttpRequest> requestParser;
    private final HttpMessageWriter<ClassicHttpResponse> responseWriter;
    private final String scheme;

    protected void onRequestReceived(ClassicHttpRequest classicHttpRequest) {
    }

    protected void onResponseSubmitted(ClassicHttpResponse classicHttpResponse) {
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.io.ModalCloseable
    public /* bridge */ /* synthetic */ void close(CloseMode closeMode) {
        super.close(closeMode);
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.io.BHttpConnection
    public /* bridge */ /* synthetic */ void flush() throws IOException {
        super.flush();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ EndpointDetails getEndpointDetails() {
        return super.getEndpointDetails();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
        return super.getLocalAddress();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ ProtocolVersion getProtocolVersion() {
        return super.getProtocolVersion();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getRemoteAddress() {
        return super.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SSLSession getSSLSession() {
        return super.getSSLSession();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ Timeout getSocketTimeout() {
        return super.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.io.BHttpConnection
    public /* bridge */ /* synthetic */ boolean isDataAvailable(Timeout timeout) throws IOException {
        return super.isDataAvailable(timeout);
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.io.BHttpConnection
    public /* bridge */ /* synthetic */ boolean isStale() throws IOException {
        return super.isStale();
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ void setSocketTimeout(Timeout timeout) {
        super.setSocketTimeout(timeout);
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public DefaultBHttpServerConnection(String str, Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<ClassicHttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<ClassicHttpResponse> httpMessageWriterFactory) {
        super(http1Config, charsetDecoder, charsetEncoder);
        this.scheme = str == null ? URIScheme.HTTP.getId() : str;
        this.requestParser = (httpMessageParserFactory == null ? DefaultHttpRequestParserFactory.INSTANCE : httpMessageParserFactory).create();
        this.responseWriter = (httpMessageWriterFactory == null ? DefaultHttpResponseWriterFactory.INSTANCE : httpMessageWriterFactory).create();
        this.incomingContentStrategy = contentLengthStrategy == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy2;
    }

    public DefaultBHttpServerConnection(String str, Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder) {
        this(str, http1Config, charsetDecoder, charsetEncoder, null, null, null, null);
    }

    public DefaultBHttpServerConnection(String str, Http1Config http1Config) {
        this(str, http1Config, null, null);
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase
    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    public void bind(SSLSocket sSLSocket, Socket socket) throws IOException {
        super.bind(new SocketHolder(sSLSocket, socket));
    }

    @Override // org.apache.hc.core5.http.io.HttpServerConnection
    public ClassicHttpRequest receiveRequestHeader() throws HttpException, IOException {
        ClassicHttpRequest classicHttpRequest = (ClassicHttpRequest) this.requestParser.parse(this.inBuffer, ensureOpen().getInputStream());
        if (classicHttpRequest == null) {
            return null;
        }
        ProtocolVersion version = classicHttpRequest.getVersion();
        if (version != null && version.greaterEquals(HttpVersion.HTTP_2)) {
            throw new UnsupportedHttpVersionException(version);
        }
        classicHttpRequest.setScheme(this.scheme);
        this.version = version;
        onRequestReceived(classicHttpRequest);
        incrementRequestCount();
        return classicHttpRequest;
    }

    @Override // org.apache.hc.core5.http.io.HttpServerConnection
    public void receiveRequestEntity(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException {
        Args.notNull(classicHttpRequest, "HTTP request");
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        long jDetermineLength = this.incomingContentStrategy.determineLength(classicHttpRequest);
        if (jDetermineLength == -9223372036854775807L) {
            return;
        }
        classicHttpRequest.setEntity(createIncomingEntity(classicHttpRequest, this.inBuffer, socketHolderEnsureOpen.getInputStream(), jDetermineLength));
    }

    @Override // org.apache.hc.core5.http.io.HttpServerConnection
    public void sendResponseHeader(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
        Args.notNull(classicHttpResponse, "HTTP response");
        this.responseWriter.write(classicHttpResponse, this.outbuffer, ensureOpen().getOutputStream());
        onResponseSubmitted(classicHttpResponse);
        if (classicHttpResponse.getCode() >= 200) {
            incrementResponseCount();
        }
    }

    @Override // org.apache.hc.core5.http.io.HttpServerConnection
    public void sendResponseEntity(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
        Args.notNull(classicHttpResponse, "HTTP response");
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        HttpEntity entity = classicHttpResponse.getEntity();
        if (entity == null) {
            return;
        }
        OutputStream outputStreamCreateContentOutputStream = createContentOutputStream(this.outgoingContentStrategy.determineLength(classicHttpResponse), this.outbuffer, socketHolderEnsureOpen.getOutputStream(), entity.getTrailers());
        try {
            entity.writeTo(outputStreamCreateContentOutputStream);
            if (outputStreamCreateContentOutputStream != null) {
                outputStreamCreateContentOutputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamCreateContentOutputStream == null) {
                    throw th2;
                }
                try {
                    outputStreamCreateContentOutputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }
}
