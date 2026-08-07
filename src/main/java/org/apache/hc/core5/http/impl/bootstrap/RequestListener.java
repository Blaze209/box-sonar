package org.apache.hc.core5.http.impl.bootstrap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.impl.io.HttpService;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.HttpServerConnection;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.io.SocketSupport;

/* JADX INFO: loaded from: classes5.dex */
class RequestListener implements Runnable {
    private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
    private final ExceptionListener exceptionListener;
    private final ExecutorService executorService;
    private final HttpService httpService;
    private final ServerSocket serverSocket;
    private final SocketConfig socketConfig;
    private final Callback<SSLParameters> sslSetupHandler;
    private final SSLSocketFactory sslSocketFactory;
    private final AtomicBoolean terminated = new AtomicBoolean();

    public RequestListener(SocketConfig socketConfig, ServerSocket serverSocket, HttpService httpService, HttpConnectionFactory<? extends HttpServerConnection> httpConnectionFactory, SSLSocketFactory sSLSocketFactory, Callback<SSLParameters> callback, ExceptionListener exceptionListener, ExecutorService executorService) {
        this.socketConfig = socketConfig;
        this.serverSocket = serverSocket;
        this.httpService = httpService;
        this.connectionFactory = httpConnectionFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.sslSetupHandler = callback;
        this.exceptionListener = exceptionListener;
        this.executorService = executorService;
    }

    private HttpServerConnection createConnection(Socket socket) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        socket.setSoTimeout(this.socketConfig.getSoTimeout().toMillisecondsIntBound());
        socket.setKeepAlive(this.socketConfig.isSoKeepAlive());
        socket.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
        if (this.socketConfig.getRcvBufSize() > 0) {
            socket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
        }
        if (this.socketConfig.getSndBufSize() > 0) {
            socket.setSendBufferSize(this.socketConfig.getSndBufSize());
        }
        if (this.socketConfig.getSoLinger().toSeconds() >= 0) {
            socket.setSoLinger(true, this.socketConfig.getSoLinger().toSecondsIntBound());
        }
        if (this.socketConfig.getTcpKeepIdle() > 0) {
            SocketSupport.setOption(this.serverSocket, SocketSupport.TCP_KEEPIDLE, Integer.valueOf(this.socketConfig.getTcpKeepIdle()));
        }
        if (this.socketConfig.getTcpKeepInterval() > 0) {
            SocketSupport.setOption(this.serverSocket, SocketSupport.TCP_KEEPINTERVAL, Integer.valueOf(this.socketConfig.getTcpKeepInterval()));
        }
        if (this.socketConfig.getTcpKeepCount() > 0) {
            SocketSupport.setOption(this.serverSocket, SocketSupport.TCP_KEEPCOUNT, Integer.valueOf(this.socketConfig.getTcpKeepCount()));
        }
        if (!(socket instanceof SSLSocket) && (sSLSocketFactory = this.sslSocketFactory) != null) {
            SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, (String) null, -1, false);
            sSLSocket.setUseClientMode(false);
            if (this.sslSetupHandler != null) {
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                this.sslSetupHandler.execute(sSLParameters);
                sSLSocket.setSSLParameters(sSLParameters);
            }
            try {
                sSLSocket.startHandshake();
                if (sSLSocket.getSession() == null) {
                    throw new SSLHandshakeException("SSL session not available");
                }
                return (HttpServerConnection) this.connectionFactory.createConnection(sSLSocket, socket);
            } catch (IOException e) {
                Closer.closeQuietly(sSLSocket);
                throw e;
            }
        }
        return (HttpServerConnection) this.connectionFactory.createConnection(socket);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!isTerminated() && !Thread.interrupted()) {
            try {
                Socket socketAccept = this.serverSocket.accept();
                try {
                    this.executorService.execute(new Worker(this.httpService, createConnection(socketAccept), this.exceptionListener));
                } catch (IOException | RuntimeException e) {
                    Closer.closeQuietly(socketAccept);
                    throw e;
                }
            } catch (Exception e2) {
                this.exceptionListener.onError(e2);
                return;
            }
        }
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true)) {
            this.serverSocket.close();
        }
    }
}
