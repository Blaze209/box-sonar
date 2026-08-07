package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import org.apache.hc.core5.http.HttpConnection;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket) throws IOException;

    default T createConnection(SSLSocket sSLSocket, Socket socket) throws IOException {
        Socket socket2 = sSLSocket;
        if (sSLSocket == null) {
            socket2 = socket;
        }
        return (T) createConnection(socket2);
    }
}
