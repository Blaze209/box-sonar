package org.apache.hc.core5.http.impl.bootstrap;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.http.URIScheme;
import org.apache.hc.core5.http.nio.command.ShutdownCommand;
import org.apache.hc.core5.reactor.EndpointParameters;
import org.apache.hc.core5.reactor.IOEventHandlerFactory;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.reactor.IOSession;
import org.apache.hc.core5.reactor.IOSessionListener;
import org.apache.hc.core5.reactor.ListenerEndpoint;

/* JADX INFO: loaded from: classes5.dex */
public class HttpAsyncServer extends AsyncServer {
    private final String canonicalName;

    public HttpAsyncServer(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, String str) {
        super(iOEventHandlerFactory, iOReactorConfig, decorator, callback, iOSessionListener, ShutdownCommand.GRACEFUL_NORMAL_CALLBACK);
        this.canonicalName = str;
    }

    public HttpAsyncServer(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener) {
        this(iOEventHandlerFactory, iOReactorConfig, decorator, callback, iOSessionListener, null);
    }

    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, URIScheme uRIScheme, Object obj, FutureCallback<ListenerEndpoint> futureCallback) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        String str = uRIScheme.id;
        String str2 = this.canonicalName;
        if (str2 == null) {
            str2 = "localhost";
        }
        return super.listen(socketAddress, new EndpointParameters(str, str2, inetSocketAddress.getPort(), obj), futureCallback);
    }

    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, URIScheme uRIScheme, FutureCallback<ListenerEndpoint> futureCallback) {
        return listen(socketAddress, uRIScheme, null, futureCallback);
    }

    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, URIScheme uRIScheme) {
        return listen(socketAddress, uRIScheme, null, null);
    }

    @Override // org.apache.hc.core5.http.impl.bootstrap.AsyncServer, org.apache.hc.core5.reactor.ConnectionAcceptor
    @Deprecated
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, FutureCallback<ListenerEndpoint> futureCallback) {
        return super.listen(socketAddress, futureCallback);
    }

    @Override // org.apache.hc.core5.http.impl.bootstrap.AsyncServer
    @Deprecated
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress) {
        return super.listen(socketAddress);
    }
}
