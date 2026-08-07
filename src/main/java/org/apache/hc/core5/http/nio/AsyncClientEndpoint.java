package org.apache.hc.core5.http.nio;

import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.BasicFuture;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.concurrent.FutureContribution;
import org.apache.hc.core5.http.nio.support.BasicClientExchangeHandler;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AsyncClientEndpoint {
    public abstract void execute(AsyncClientExchangeHandler asyncClientExchangeHandler, HandlerFactory<AsyncPushConsumer> handlerFactory, HttpContext httpContext);

    public abstract boolean isConnected();

    public abstract void releaseAndDiscard();

    public abstract void releaseAndReuse();

    public void execute(AsyncClientExchangeHandler asyncClientExchangeHandler, HttpContext httpContext) {
        execute(asyncClientExchangeHandler, (HandlerFactory<AsyncPushConsumer>) null, httpContext);
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, HandlerFactory<AsyncPushConsumer> handlerFactory, HttpContext httpContext, FutureCallback<T> futureCallback) {
        final BasicFuture basicFuture = new BasicFuture(futureCallback);
        BasicClientExchangeHandler basicClientExchangeHandler = new BasicClientExchangeHandler(asyncRequestProducer, asyncResponseConsumer, new FutureContribution<T>(basicFuture) { // from class: org.apache.hc.core5.http.nio.AsyncClientEndpoint.1
            @Override // org.apache.hc.core5.concurrent.FutureCallback
            public void completed(T t) {
                basicFuture.completed(t);
            }
        });
        if (httpContext == null) {
            httpContext = HttpCoreContext.create();
        }
        execute(basicClientExchangeHandler, handlerFactory, httpContext);
        return basicFuture;
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, HttpContext httpContext, FutureCallback<T> futureCallback) {
        return execute(asyncRequestProducer, asyncResponseConsumer, null, httpContext, futureCallback);
    }

    public final <T> Future<T> execute(AsyncRequestProducer asyncRequestProducer, AsyncResponseConsumer<T> asyncResponseConsumer, FutureCallback<T> futureCallback) {
        return execute(asyncRequestProducer, asyncResponseConsumer, null, null, futureCallback);
    }
}
