package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultHttpClientConnection extends SocketHttpClientConnection {
    @Override // org.apache.http.impl.SocketHttpClientConnection
    public void bind(Socket socket, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        Args.notNull(httpParams, "HTTP parameters");
        assertNotOpen();
        socket.setTcpNoDelay(httpParams.getBooleanParameter("http.tcp.nodelay", true));
        socket.setSoTimeout(httpParams.getIntParameter("http.socket.timeout", 0));
        socket.setKeepAlive(httpParams.getBooleanParameter("http.socket.keepalive", false));
        int intParameter = httpParams.getIntParameter("http.socket.linger", -1);
        if (intParameter >= 0) {
            socket.setSoLinger(intParameter > 0, intParameter);
        }
        super.bind(socket, httpParams);
    }
}
