package org.apache.hc.core5.http.impl.bootstrap;

import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.impl.io.HttpService;
import org.apache.hc.core5.http.io.HttpServerConnection;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.io.CloseMode;

/* JADX INFO: loaded from: classes5.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionListener exceptionListener;
    private final HttpService httpservice;

    Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionListener exceptionListener) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionListener = exceptionListener;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!Thread.interrupted() && this.conn.isOpen()) {
            try {
                try {
                    this.httpservice.handleRequest(this.conn, HttpCoreContext.create());
                } catch (Exception e) {
                    this.exceptionListener.onError(this.conn, e);
                }
            } catch (Throwable th) {
                this.conn.close(CloseMode.IMMEDIATE);
                throw th;
            }
        }
        this.conn.close();
        this.conn.close(CloseMode.IMMEDIATE);
    }
}
