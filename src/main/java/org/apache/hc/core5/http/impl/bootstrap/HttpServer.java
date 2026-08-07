package org.apache.hc.core5.http.impl.bootstrap;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import org.apache.hc.core5.concurrent.DefaultThreadFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.io.DefaultBHttpServerConnection;
import org.apache.hc.core5.http.impl.io.DefaultBHttpServerConnectionFactory;
import org.apache.hc.core5.http.impl.io.HttpService;
import org.apache.hc.core5.http.io.HttpConnectionFactory;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.io.SocketSupport;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class HttpServer implements ModalCloseable {
    private final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private final ExceptionListener exceptionListener;
    private final HttpService httpService;
    private final InetAddress ifAddress;
    private final ThreadPoolExecutor listenerExecutorService;
    private final int port;
    private volatile RequestListener requestListener;
    private volatile ServerSocket serverSocket;
    private final ServerSocketFactory serverSocketFactory;
    private final SocketConfig socketConfig;
    private final SSLContext sslContext;
    private final Callback<SSLParameters> sslSetupHandler;
    private final AtomicReference<Status> status;
    private final WorkerPoolExecutor workerExecutorService;
    private final ThreadGroup workerThreads;

    enum Status {
        READY,
        ACTIVE,
        STOPPING
    }

    public HttpServer(int i, HttpService httpService, InetAddress inetAddress, SocketConfig socketConfig, ServerSocketFactory serverSocketFactory, HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory, SSLContext sSLContext, Callback<SSLParameters> callback, ExceptionListener exceptionListener) {
        int iNotNegative = Args.notNegative(i, "Port value is negative");
        this.port = iNotNegative;
        this.httpService = (HttpService) Args.notNull(httpService, "HTTP service");
        this.ifAddress = inetAddress;
        this.socketConfig = socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
        serverSocketFactory = serverSocketFactory == null ? ServerSocketFactory.getDefault() : serverSocketFactory;
        this.serverSocketFactory = serverSocketFactory;
        if (httpConnectionFactory == null) {
            httpConnectionFactory = new DefaultBHttpServerConnectionFactory((serverSocketFactory instanceof SSLServerSocketFactory ? URIScheme.HTTPS : URIScheme.HTTP).id, Http1Config.DEFAULT, CharCodingConfig.DEFAULT);
        }
        this.connectionFactory = httpConnectionFactory;
        this.sslContext = sSLContext;
        this.sslSetupHandler = callback;
        this.exceptionListener = exceptionListener != null ? exceptionListener : ExceptionListener.NO_OP;
        this.listenerExecutorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("HTTP-listener-" + iNotNegative));
        ThreadGroup threadGroup = new ThreadGroup("HTTP-workers");
        this.workerThreads = threadGroup;
        this.workerExecutorService = new WorkerPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("HTTP-worker", threadGroup, true));
        this.status = new AtomicReference<>(Status.READY);
    }

    public InetAddress getInetAddress() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getInetAddress();
        }
        return null;
    }

    public int getLocalPort() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getLocalPort();
        }
        return -1;
    }

    public void start() throws IOException {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, Status.READY, Status.ACTIVE)) {
            this.serverSocket = this.serverSocketFactory.createServerSocket(this.port, this.socketConfig.getBacklogSize(), this.ifAddress);
            this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
            if (this.socketConfig.getRcvBufSize() > 0) {
                this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
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
            if (this.sslSetupHandler != null && (this.serverSocket instanceof SSLServerSocket)) {
                SSLServerSocket sSLServerSocket = (SSLServerSocket) this.serverSocket;
                SSLParameters sSLParameters = sSLServerSocket.getSSLParameters();
                this.sslSetupHandler.execute(sSLParameters);
                sSLServerSocket.setSSLParameters(sSLParameters);
            }
            SocketConfig socketConfig = this.socketConfig;
            ServerSocket serverSocket = this.serverSocket;
            HttpService httpService = this.httpService;
            HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory = this.connectionFactory;
            SSLContext sSLContext = this.sslContext;
            this.requestListener = new RequestListener(socketConfig, serverSocket, httpService, httpConnectionFactory, sSLContext != null ? sSLContext.getSocketFactory() : null, this.sslSetupHandler, this.exceptionListener, this.workerExecutorService);
            this.listenerExecutorService.execute(this.requestListener);
        }
    }

    public void stop() {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.status, Status.ACTIVE, Status.STOPPING)) {
            this.listenerExecutorService.shutdownNow();
            this.workerExecutorService.shutdown();
            RequestListener requestListener = this.requestListener;
            if (requestListener != null) {
                try {
                    requestListener.terminate();
                } catch (IOException e) {
                    this.exceptionListener.onError(e);
                }
            }
            this.workerThreads.interrupt();
        }
    }

    public void initiateShutdown() {
        stop();
    }

    public void awaitTermination(TimeValue timeValue) throws InterruptedException {
        Args.notNull(timeValue, "Wait time");
        this.workerExecutorService.awaitTermination(timeValue.getDuration(), timeValue.getTimeUnit());
    }

    @Override // org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        close(closeMode, Timeout.ofSeconds(5L));
    }

    public void close(CloseMode closeMode, Timeout timeout) {
        initiateShutdown();
        if (closeMode == CloseMode.GRACEFUL) {
            try {
                awaitTermination(timeout);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        Iterator<Worker> it = this.workerExecutorService.getWorkers().iterator();
        while (it.hasNext()) {
            Closer.close(it.next().getConnection(), CloseMode.GRACEFUL);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(CloseMode.GRACEFUL);
    }
}
