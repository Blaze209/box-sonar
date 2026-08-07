package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.BasicEndpointDetails;
import org.apache.hc.core5.http.impl.BasicHttpConnectionMetrics;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.io.BHttpConnection;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.net.InetAddressUtils;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class BHttpConnectionBase implements BHttpConnection {
    private static final Timeout STALE_CHECK_TIMEOUT = Timeout.ofMilliseconds(1L);
    private byte[] chunkedRequestBuffer;
    final BasicHttpConnectionMetrics connMetrics;
    volatile EndpointDetails endpointDetails;
    final Http1Config http1Config;
    final SessionInputBufferImpl inBuffer;
    final SessionOutputBufferImpl outbuffer;
    final AtomicReference<SocketHolder> socketHolderRef;
    volatile ProtocolVersion version;

    BHttpConnectionBase(Http1Config http1Config, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder) {
        http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.http1Config = http1Config;
        BasicHttpTransportMetrics basicHttpTransportMetrics = new BasicHttpTransportMetrics();
        BasicHttpTransportMetrics basicHttpTransportMetrics2 = new BasicHttpTransportMetrics();
        this.inBuffer = new SessionInputBufferImpl(basicHttpTransportMetrics, http1Config.getBufferSize(), -1, http1Config.getMaxLineLength(), charsetDecoder);
        this.outbuffer = new SessionOutputBufferImpl(basicHttpTransportMetrics2, http1Config.getBufferSize(), http1Config.getChunkSizeHint(), charsetEncoder);
        this.connMetrics = new BasicHttpConnectionMetrics(basicHttpTransportMetrics, basicHttpTransportMetrics2);
        this.socketHolderRef = new AtomicReference<>();
    }

    protected SocketHolder ensureOpen() throws IOException {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            return socketHolder;
        }
        throw new ConnectionClosedException();
    }

    protected void bind(Socket socket) throws IOException {
        Args.notNull(socket, "Socket");
        bind(new SocketHolder(socket));
    }

    protected void bind(SocketHolder socketHolder) throws IOException {
        Args.notNull(socketHolder, "Socket holder");
        this.socketHolderRef.set(socketHolder);
        this.endpointDetails = null;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public boolean isOpen() {
        return this.socketHolderRef.get() != null;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public ProtocolVersion getProtocolVersion() {
        return this.version;
    }

    protected SocketHolder getSocketHolder() {
        return this.socketHolderRef.get();
    }

    protected OutputStream createContentOutputStream(long j, SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream, Supplier<List<? extends Header>> supplier) {
        if (j >= 0) {
            return new ContentLengthOutputStream(sessionOutputBuffer, outputStream, j);
        }
        if (j == -1) {
            return new ChunkedOutputStream(sessionOutputBuffer, outputStream, getChunkedRequestBuffer(), supplier);
        }
        return new IdentityOutputStream(sessionOutputBuffer, outputStream);
    }

    private byte[] getChunkedRequestBuffer() {
        if (this.chunkedRequestBuffer == null) {
            int chunkSizeHint = this.http1Config.getChunkSizeHint();
            if (chunkSizeHint <= 0) {
                chunkSizeHint = 8192;
            }
            this.chunkedRequestBuffer = new byte[chunkSizeHint];
        }
        return this.chunkedRequestBuffer;
    }

    protected InputStream createContentInputStream(long j, SessionInputBuffer sessionInputBuffer, InputStream inputStream) {
        if (j > 0) {
            return new ContentLengthInputStream(sessionInputBuffer, inputStream, j);
        }
        if (j == 0) {
            return org.apache.hc.core5.http.io.entity.EmptyInputStream.INSTANCE;
        }
        if (j == -1) {
            return new ChunkedInputStream(sessionInputBuffer, inputStream, this.http1Config);
        }
        return new IdentityInputStream(sessionInputBuffer, inputStream);
    }

    HttpEntity createIncomingEntity(HttpMessage httpMessage, SessionInputBuffer sessionInputBuffer, InputStream inputStream, long j) {
        return new IncomingHttpEntity(createContentInputStream(j, sessionInputBuffer, inputStream), j >= 0 ? j : -1L, j == -1, httpMessage.getFirstHeader("Content-Type"), httpMessage.getFirstHeader("Content-Encoding"));
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getRemoteAddress() {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            return socketHolder.getSocket().getRemoteSocketAddress();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getLocalAddress() {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            return socketHolder.getSocket().getLocalSocketAddress();
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            try {
                socketHolder.getSocket().setSoTimeout(Timeout.defaultsToInfinite(timeout).toMillisecondsIntBound());
            } catch (SocketException unused) {
            }
        }
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            try {
                return Timeout.ofMilliseconds(socketHolder.getSocket().getSoTimeout());
            } catch (SocketException unused) {
            }
        }
        return Timeout.INFINITE;
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        SocketHolder andSet = this.socketHolderRef.getAndSet(null);
        if (andSet != null) {
            SSLSocket sSLSocket = andSet.getSSLSocket();
            Socket baseSocket = andSet.getBaseSocket();
            if (closeMode == CloseMode.IMMEDIATE) {
                try {
                    baseSocket.setSoLinger(true, 0);
                } catch (IOException unused) {
                } finally {
                    Closer.closeQuietly(baseSocket);
                }
                return;
            }
            if (sSLSocket != null) {
                try {
                    if (!sSLSocket.isOutputShutdown()) {
                        sSLSocket.shutdownOutput();
                    }
                    if (!sSLSocket.isInputShutdown()) {
                        sSLSocket.shutdownInput();
                    }
                    sSLSocket.close();
                } catch (IOException unused2) {
                } finally {
                    Closer.closeQuietly(baseSocket);
                }
            }
        }
    }

    @Override // org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SocketHolder andSet = this.socketHolderRef.getAndSet(null);
        if (andSet != null) {
            Socket baseSocket = andSet.getBaseSocket();
            try {
                this.inBuffer.clear();
                this.outbuffer.flush(andSet.getOutputStream());
                SSLSocket sSLSocket = andSet.getSSLSocket();
                if (sSLSocket != null) {
                    sSLSocket.close();
                }
                if (baseSocket != null) {
                    baseSocket.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (baseSocket != null) {
                        try {
                            baseSocket.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    private int fillInputBuffer(Timeout timeout) throws IOException {
        SocketHolder socketHolderEnsureOpen = ensureOpen();
        Socket socket = socketHolderEnsureOpen.getSocket();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(timeout.toMillisecondsIntBound());
            return this.inBuffer.fillBuffer(socketHolderEnsureOpen.getInputStream());
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    protected boolean awaitInput(Timeout timeout) throws IOException {
        if (this.inBuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(timeout);
        return this.inBuffer.hasBufferedData();
    }

    @Override // org.apache.hc.core5.http.io.BHttpConnection
    public boolean isDataAvailable(Timeout timeout) throws IOException {
        ensureOpen();
        try {
            return awaitInput(timeout);
        } catch (SocketTimeoutException unused) {
            return false;
        }
    }

    @Override // org.apache.hc.core5.http.io.BHttpConnection
    public boolean isStale() throws IOException {
        if (!isOpen()) {
            return true;
        }
        try {
            return fillInputBuffer(STALE_CHECK_TIMEOUT) < 0;
        } catch (SocketException unused) {
            return true;
        } catch (SocketTimeoutException unused2) {
            return false;
        }
    }

    @Override // org.apache.hc.core5.http.io.BHttpConnection
    public void flush() throws IOException {
        this.outbuffer.flush(ensureOpen().getOutputStream());
    }

    protected void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    protected void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SSLSession getSSLSession() {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            Socket socket = socketHolder.getSocket();
            if (socket instanceof SSLSocket) {
                return ((SSLSocket) socket).getSession();
            }
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public EndpointDetails getEndpointDetails() {
        SocketHolder socketHolder;
        Timeout timeoutOfMilliseconds;
        if (this.endpointDetails == null && (socketHolder = this.socketHolderRef.get()) != null) {
            Socket socket = socketHolder.getSocket();
            try {
                timeoutOfMilliseconds = Timeout.ofMilliseconds(socket.getSoTimeout());
            } catch (SocketException unused) {
                timeoutOfMilliseconds = Timeout.INFINITE;
            }
            this.endpointDetails = new BasicEndpointDetails(socket.getRemoteSocketAddress(), socket.getLocalSocketAddress(), this.connMetrics, timeoutOfMilliseconds);
        }
        return this.endpointDetails;
    }

    public String toString() {
        SocketHolder socketHolder = this.socketHolderRef.get();
        if (socketHolder != null) {
            Socket socket = socketHolder.getSocket();
            StringBuilder sb = new StringBuilder();
            SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
            SocketAddress localSocketAddress = socket.getLocalSocketAddress();
            if (remoteSocketAddress != null && localSocketAddress != null) {
                InetAddressUtils.formatAddress(sb, localSocketAddress);
                sb.append("<->");
                InetAddressUtils.formatAddress(sb, remoteSocketAddress);
            }
            return sb.toString();
        }
        return "[Not bound]";
    }
}
