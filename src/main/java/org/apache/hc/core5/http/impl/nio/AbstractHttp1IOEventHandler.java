package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class AbstractHttp1IOEventHandler implements HttpConnectionEventHandler {
    final AbstractHttp1StreamDuplexer<?, ?> streamDuplexer;

    AbstractHttp1IOEventHandler(AbstractHttp1StreamDuplexer<?, ?> abstractHttp1StreamDuplexer) {
        this.streamDuplexer = (AbstractHttp1StreamDuplexer) Args.notNull(abstractHttp1StreamDuplexer, "Stream multiplexer");
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void connected(IOSession iOSession) throws IOException {
        try {
            this.streamDuplexer.onConnect();
        } catch (HttpException e) {
            this.streamDuplexer.onException(e);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void inputReady(IOSession iOSession, ByteBuffer byteBuffer) throws IOException {
        try {
            this.streamDuplexer.onInput(byteBuffer);
        } catch (HttpException e) {
            this.streamDuplexer.onException(e);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void outputReady(IOSession iOSession) throws IOException {
        try {
            this.streamDuplexer.onOutput();
        } catch (HttpException e) {
            this.streamDuplexer.onException(e);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void timeout(IOSession iOSession, Timeout timeout) throws IOException {
        try {
            this.streamDuplexer.onTimeout(timeout);
        } catch (HttpException e) {
            this.streamDuplexer.onException(e);
        }
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void exception(IOSession iOSession, Exception exc) {
        this.streamDuplexer.onException(exc);
    }

    @Override // org.apache.hc.core5.reactor.IOEventHandler
    public void disconnected(IOSession iOSession) {
        this.streamDuplexer.onDisconnect();
    }

    @Override // org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.streamDuplexer.close();
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.streamDuplexer.close(closeMode);
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public boolean isOpen() {
        return this.streamDuplexer.isOpen();
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public void setSocketTimeout(Timeout timeout) {
        this.streamDuplexer.setSocketTimeout(timeout);
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SSLSession getSSLSession() {
        return this.streamDuplexer.getSSLSession();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public EndpointDetails getEndpointDetails() {
        return this.streamDuplexer.getEndpointDetails();
    }

    @Override // org.apache.hc.core5.http.SocketModalCloseable
    public Timeout getSocketTimeout() {
        return this.streamDuplexer.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public ProtocolVersion getProtocolVersion() {
        return this.streamDuplexer.getProtocolVersion();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getRemoteAddress() {
        return this.streamDuplexer.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.http.HttpConnection
    public SocketAddress getLocalAddress() {
        return this.streamDuplexer.getLocalAddress();
    }
}
