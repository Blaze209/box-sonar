package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSession;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.net.InetAddressUtils;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class ServerHttp1IOEventHandler extends AbstractHttp1IOEventHandler {
    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.io.ModalCloseable
    public /* bridge */ /* synthetic */ void close(CloseMode closeMode) {
        super.close(closeMode);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void connected(IOSession iOSession) throws IOException {
        super.connected(iOSession);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void disconnected(IOSession iOSession) {
        super.disconnected(iOSession);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void exception(IOSession iOSession, Exception exc) {
        super.exception(iOSession, exc);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ EndpointDetails getEndpointDetails() {
        return super.getEndpointDetails();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getLocalAddress() {
        return super.getLocalAddress();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SocketAddress getRemoteAddress() {
        return super.getRemoteAddress();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ SSLSession getSSLSession() {
        return super.getSSLSession();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ Timeout getSocketTimeout() {
        return super.getSocketTimeout();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void inputReady(IOSession iOSession, ByteBuffer byteBuffer) throws IOException {
        super.inputReady(iOSession, byteBuffer);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void outputReady(IOSession iOSession) throws IOException {
        super.outputReady(iOSession);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.SocketModalCloseable
    public /* bridge */ /* synthetic */ void setSocketTimeout(Timeout timeout) {
        super.setSocketTimeout(timeout);
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.reactor.IOEventHandler
    public /* bridge */ /* synthetic */ void timeout(IOSession iOSession, Timeout timeout) throws IOException {
        super.timeout(iOSession, timeout);
    }

    public ServerHttp1IOEventHandler(ServerHttp1StreamDuplexer serverHttp1StreamDuplexer) {
        super(serverHttp1StreamDuplexer);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        InetAddressUtils.formatAddress(sb, getRemoteAddress());
        sb.append("->");
        InetAddressUtils.formatAddress(sb, getLocalAddress());
        sb.append(" [");
        this.streamDuplexer.appendState(sb);
        sb.append("]");
        return sb.toString();
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractHttp1IOEventHandler, org.apache.hc.core5.http.HttpConnection
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = super.getProtocolVersion();
        return protocolVersion != null ? protocolVersion : HttpVersion.HTTP_1_1;
    }
}
