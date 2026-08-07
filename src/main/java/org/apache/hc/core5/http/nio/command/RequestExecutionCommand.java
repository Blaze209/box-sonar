package org.apache.hc.core5.http.nio.command;

import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.hc.core5.concurrent.CancellableDependency;
import org.apache.hc.core5.http.RequestNotExecutedException;
import org.apache.hc.core5.http.nio.AsyncClientExchangeHandler;
import org.apache.hc.core5.http.nio.AsyncPushConsumer;
import org.apache.hc.core5.http.nio.HandlerFactory;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestExecutionCommand extends ExecutableCommand {
    private final CancellableDependency cancellableDependency;
    private final HttpContext context;
    private final AsyncClientExchangeHandler exchangeHandler;
    private final AtomicBoolean failed;
    private final HandlerFactory<AsyncPushConsumer> pushHandlerFactory;

    public RequestExecutionCommand(AsyncClientExchangeHandler asyncClientExchangeHandler, HandlerFactory<AsyncPushConsumer> handlerFactory, CancellableDependency cancellableDependency, HttpContext httpContext) {
        this.exchangeHandler = (AsyncClientExchangeHandler) Args.notNull(asyncClientExchangeHandler, "Handler");
        this.pushHandlerFactory = handlerFactory;
        this.cancellableDependency = cancellableDependency;
        this.context = httpContext;
        this.failed = new AtomicBoolean();
    }

    public RequestExecutionCommand(AsyncClientExchangeHandler asyncClientExchangeHandler, HandlerFactory<AsyncPushConsumer> handlerFactory, HttpContext httpContext) {
        this(asyncClientExchangeHandler, handlerFactory, null, httpContext);
    }

    public RequestExecutionCommand(AsyncClientExchangeHandler asyncClientExchangeHandler, HttpContext httpContext) {
        this(asyncClientExchangeHandler, null, null, httpContext);
    }

    public AsyncClientExchangeHandler getExchangeHandler() {
        return this.exchangeHandler;
    }

    public HandlerFactory<AsyncPushConsumer> getPushHandlerFactory() {
        return this.pushHandlerFactory;
    }

    @Override // org.apache.hc.core5.http.nio.command.ExecutableCommand
    public CancellableDependency getCancellableDependency() {
        return this.cancellableDependency;
    }

    public HttpContext getContext() {
        return this.context;
    }

    @Override // org.apache.hc.core5.http.nio.command.ExecutableCommand
    public void failed(Exception exc) {
        if (this.failed.compareAndSet(false, true)) {
            try {
                this.exchangeHandler.failed(exc);
            } finally {
                this.exchangeHandler.releaseResources();
            }
        }
    }

    @Override // org.apache.hc.core5.concurrent.Cancellable
    public boolean cancel() {
        if (!this.failed.compareAndSet(false, true)) {
            return false;
        }
        try {
            this.exchangeHandler.failed(new RequestNotExecutedException());
            return true;
        } finally {
            this.exchangeHandler.releaseResources();
        }
    }
}
