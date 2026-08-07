package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ContentLengthStrategy;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HeaderElements;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.LengthRequiredException;
import org.apache.hc.core5.http.NoHttpResponseException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.UnsupportedHttpVersionException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.DefaultContentLengthStrategy;
import org.apache.hc.core5.http.io.HttpClientConnection;
import org.apache.hc.core5.http.io.HttpMessageParser;
import org.apache.hc.core5.http.io.HttpMessageParserFactory;
import org.apache.hc.core5.http.io.HttpMessageWriter;
import org.apache.hc.core5.http.io.HttpMessageWriterFactory;
import org.apache.hc.core5.http.io.ResponseOutOfOrderStrategy;
import org.apache.hc.core5.http.message.MessageSupport;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private volatile boolean consistent;
    private final ContentLengthStrategy incomingContentStrategy;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final HttpMessageWriter<ClassicHttpRequest> requestWriter;
    private final ResponseOutOfOrderStrategy responseOutOfOrderStrategy;
    private final HttpMessageParser<ClassicHttpResponse> responseParser;

    protected void onRequestSubmitted(ClassicHttpRequest classicHttpRequest) {
    }

    protected void onResponseReceived(ClassicHttpResponse classicHttpResponse) {
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

    public DefaultBHttpClientConnection(Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, ResponseOutOfOrderStrategy responseOutOfOrderStrategy, HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
        super(http1Config, charsetDecoder, charsetEncoder);
        this.requestWriter = (httpMessageWriterFactory == null ? DefaultHttpRequestWriterFactory.INSTANCE : httpMessageWriterFactory).create();
        this.responseParser = (httpMessageParserFactory == null ? DefaultHttpResponseParserFactory.INSTANCE : httpMessageParserFactory).create();
        this.incomingContentStrategy = contentLengthStrategy == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy;
        this.outgoingContentStrategy = contentLengthStrategy2 == null ? DefaultContentLengthStrategy.INSTANCE : contentLengthStrategy2;
        this.responseOutOfOrderStrategy = responseOutOfOrderStrategy;
        this.consistent = true;
    }

    public DefaultBHttpClientConnection(Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<ClassicHttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<ClassicHttpResponse> httpMessageParserFactory) {
        this(http1Config, charsetDecoder, charsetEncoder, contentLengthStrategy, contentLengthStrategy2, null, httpMessageWriterFactory, httpMessageParserFactory);
    }

    public DefaultBHttpClientConnection(Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder) {
        this(http1Config, charsetDecoder, charsetEncoder, null, null, null, null);
    }

    public DefaultBHttpClientConnection(Http1Config http1Config) {
        this(http1Config, null, null);
    }

    @Override // org.apache.hc.core5.http.impl.io.BHttpConnectionBase
    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    public void bind(SSLSocket sSLSocket, Socket socket) throws IOException {
        super.bind(new SocketHolder(sSLSocket, socket));
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public void sendRequestHeader(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException {
        Args.notNull(classicHttpRequest, "HTTP request");
        this.requestWriter.write(classicHttpRequest, this.outbuffer, ensureOpen().getOutputStream());
        onRequestSubmitted(classicHttpRequest);
        incrementRequestCount();
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public void sendRequestEntity(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection;
        Args.notNull(classicHttpRequest, "HTTP request");
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        HttpEntity entity = classicHttpRequest.getEntity();
        if (entity == null) {
            return;
        }
        long jDetermineLength = this.outgoingContentStrategy.determineLength(classicHttpRequest);
        if (jDetermineLength == -9223372036854775807L) {
            throw new LengthRequiredException();
        }
        try {
            defaultBHttpClientConnection = this;
            try {
                OutputStream outputStreamCreateContentOutputStream = defaultBHttpClientConnection.createContentOutputStream(jDetermineLength, this.outbuffer, new OutputStream(socketHolderEnsureOpen, classicHttpRequest) { // from class: org.apache.hc.core5.http.impl.io.DefaultBHttpClientConnection.1
                    final InputStream socketInputStream;
                    final OutputStream socketOutputStream;
                    final SSLSocket sslSocket;
                    long totalBytes;
                    final /* synthetic */ ClassicHttpRequest val$request;
                    final /* synthetic */ SocketHolder val$socketHolder;

                    {
                        this.val$socketHolder = socketHolderEnsureOpen;
                        this.val$request = classicHttpRequest;
                        this.socketOutputStream = socketHolderEnsureOpen.getOutputStream();
                        this.socketInputStream = socketHolderEnsureOpen.getInputStream();
                        this.sslSocket = socketHolderEnsureOpen.getSSLSocket();
                    }

                    void checkTLS(SSLSocket sSLSocket) throws IOException {
                        if (sSLSocket.isInputShutdown()) {
                            throw new ConnectionClosedException();
                        }
                    }

                    void checkForEarlyResponse(long j, int i) throws IOException {
                        if (DefaultBHttpClientConnection.this.responseOutOfOrderStrategy.isEarlyResponseDetected(this.val$request, DefaultBHttpClientConnection.this, this.socketInputStream, j, i)) {
                            throw new ResponseOutOfOrderException();
                        }
                    }

                    @Override // java.io.OutputStream
                    public void write(byte[] bArr) throws IOException {
                        SSLSocket sSLSocket = this.sslSocket;
                        if (sSLSocket != null) {
                            checkTLS(sSLSocket);
                        }
                        if (DefaultBHttpClientConnection.this.responseOutOfOrderStrategy != null) {
                            checkForEarlyResponse(this.totalBytes, bArr.length);
                        }
                        this.totalBytes += (long) bArr.length;
                        this.socketOutputStream.write(bArr);
                    }

                    @Override // java.io.OutputStream
                    public void write(byte[] bArr, int i, int i2) throws IOException {
                        SSLSocket sSLSocket = this.sslSocket;
                        if (sSLSocket != null) {
                            checkTLS(sSLSocket);
                        }
                        if (DefaultBHttpClientConnection.this.responseOutOfOrderStrategy != null) {
                            checkForEarlyResponse(this.totalBytes, i2);
                        }
                        this.totalBytes += (long) i2;
                        this.socketOutputStream.write(bArr, i, i2);
                    }

                    @Override // java.io.OutputStream
                    public void write(int i) throws IOException {
                        SSLSocket sSLSocket = this.sslSocket;
                        if (sSLSocket != null) {
                            checkTLS(sSLSocket);
                        }
                        if (DefaultBHttpClientConnection.this.responseOutOfOrderStrategy != null) {
                            checkForEarlyResponse(this.totalBytes, 1);
                        }
                        this.totalBytes++;
                        this.socketOutputStream.write(i);
                    }

                    @Override // java.io.OutputStream, java.io.Flushable
                    public void flush() throws IOException {
                        this.socketOutputStream.flush();
                    }

                    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        this.socketOutputStream.close();
                    }
                }, entity.getTrailers());
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
            } catch (ResponseOutOfOrderException unused) {
                if (jDetermineLength > 0) {
                    defaultBHttpClientConnection.consistent = false;
                }
            }
        } catch (ResponseOutOfOrderException unused2) {
            defaultBHttpClientConnection = this;
        }
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public boolean isConsistent() {
        return this.consistent;
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public void terminateRequest(ClassicHttpRequest classicHttpRequest) throws HttpException, IOException {
        Args.notNull(classicHttpRequest, "HTTP request");
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        HttpEntity entity = classicHttpRequest.getEntity();
        if (entity == null) {
            return;
        }
        Iterator<String> itIterateTokens = MessageSupport.iterateTokens(classicHttpRequest, "Connection");
        while (itIterateTokens.hasNext()) {
            if (HeaderElements.CLOSE.equalsIgnoreCase(itIterateTokens.next())) {
                this.consistent = false;
                return;
            }
        }
        long jDetermineLength = this.outgoingContentStrategy.determineLength(classicHttpRequest);
        if (jDetermineLength == -1) {
            OutputStream outputStreamCreateContentOutputStream = createContentOutputStream(jDetermineLength, this.outbuffer, socketHolderEnsureOpen.getOutputStream(), entity.getTrailers());
            if (outputStreamCreateContentOutputStream != null) {
                outputStreamCreateContentOutputStream.close();
                return;
            }
            return;
        }
        if (jDetermineLength >= 0 && jDetermineLength <= 1024) {
            OutputStream outputStreamCreateContentOutputStream2 = createContentOutputStream(jDetermineLength, this.outbuffer, socketHolderEnsureOpen.getOutputStream(), null);
            try {
                entity.writeTo(outputStreamCreateContentOutputStream2);
                if (outputStreamCreateContentOutputStream2 != null) {
                    outputStreamCreateContentOutputStream2.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStreamCreateContentOutputStream2 == null) {
                        throw th2;
                    }
                    try {
                        outputStreamCreateContentOutputStream2.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        }
        this.consistent = false;
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public ClassicHttpResponse receiveResponseHeader() throws HttpException, IOException {
        ClassicHttpResponse classicHttpResponse = (ClassicHttpResponse) this.responseParser.parse(this.inBuffer, ensureOpen().getInputStream());
        if (classicHttpResponse == null) {
            throw new NoHttpResponseException("The target server failed to respond");
        }
        ProtocolVersion version = classicHttpResponse.getVersion();
        if (version != null && version.greaterEquals(HttpVersion.HTTP_2)) {
            throw new UnsupportedHttpVersionException(version);
        }
        this.version = version;
        onResponseReceived(classicHttpResponse);
        int code = classicHttpResponse.getCode();
        if (code < 100) {
            throw new ProtocolException("Invalid response: " + code);
        }
        if (classicHttpResponse.getCode() >= 200) {
            incrementResponseCount();
        }
        return classicHttpResponse;
    }

    @Override // org.apache.hc.core5.http.io.HttpClientConnection
    public void receiveResponseEntity(ClassicHttpResponse classicHttpResponse) throws HttpException, IOException {
        Args.notNull(classicHttpResponse, "HTTP response");
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        classicHttpResponse.setEntity(createIncomingEntity(classicHttpResponse, this.inBuffer, socketHolderEnsureOpen.getInputStream(), this.incomingContentStrategy.determineLength(classicHttpResponse)));
    }
}
