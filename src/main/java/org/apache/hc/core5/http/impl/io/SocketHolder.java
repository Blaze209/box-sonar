package org.apache.hc.core5.http.impl.io;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocket;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class SocketHolder {
    private final Socket baseSocket;
    private final AtomicReference<InputStream> inputStreamRef;
    private final AtomicReference<OutputStream> outputStreamRef;
    private final SSLSocket sslSocket;

    public SocketHolder(SSLSocket sSLSocket, Socket socket) {
        this.sslSocket = (SSLSocket) Args.notNull(sSLSocket, "SSL Socket");
        this.baseSocket = (Socket) Args.notNull(socket, "Socket");
        this.inputStreamRef = new AtomicReference<>();
        this.outputStreamRef = new AtomicReference<>();
    }

    public SocketHolder(Socket socket) {
        this.baseSocket = (Socket) Args.notNull(socket, "Socket");
        this.sslSocket = null;
        this.inputStreamRef = new AtomicReference<>();
        this.outputStreamRef = new AtomicReference<>();
    }

    public final Socket getSocket() {
        SSLSocket sSLSocket = this.sslSocket;
        return sSLSocket != null ? sSLSocket : this.baseSocket;
    }

    public Socket getBaseSocket() {
        return this.baseSocket;
    }

    public SSLSocket getSSLSocket() {
        return this.sslSocket;
    }

    public final InputStream getInputStream() throws IOException {
        InputStream inputStream = this.inputStreamRef.get();
        if (inputStream != null) {
            return inputStream;
        }
        InputStream inputStream2 = getInputStream(getSocket());
        return PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.inputStreamRef, null, inputStream2) ? inputStream2 : this.inputStreamRef.get();
    }

    protected InputStream getInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    protected OutputStream getOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    public final OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = this.outputStreamRef.get();
        if (outputStream != null) {
            return outputStream;
        }
        OutputStream outputStream2 = getOutputStream(getSocket());
        return PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.outputStreamRef, null, outputStream2) ? outputStream2 : this.outputStreamRef.get();
    }

    public String toString() {
        return "SocketHolder{sslSocket=" + this.sslSocket + ", baseSocket=" + this.baseSocket + AbstractJsonLexerKt.END_OBJ;
    }
}
