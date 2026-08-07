package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import org.apache.hc.core5.concurrent.DefaultThreadFactory;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultListeningIOReactor extends AbstractIOReactorBase implements ConnectionAcceptor {
    private static final ThreadFactory DISPATCH_THREAD_FACTORY = new DefaultThreadFactory("I/O server dispatch", true);
    private static final ThreadFactory LISTENER_THREAD_FACTORY = new DefaultThreadFactory("I/O listener", true);
    private final MultiCoreIOReactor ioReactor;
    private final SingleCoreListeningIOReactor listener;
    private final int workerCount;
    private final IOWorkers.Selector workerSelector;
    private final SingleCoreIOReactor[] workers;

    public DefaultListeningIOReactor(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, ThreadFactory threadFactory, ThreadFactory threadFactory2, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, Callback<IOSession> callback2) {
        SingleCoreIOReactor[] singleCoreIOReactorArr;
        Args.notNull(iOEventHandlerFactory, "Event handler factory");
        int ioThreadCount = iOReactorConfig != null ? iOReactorConfig.getIoThreadCount() : IOReactorConfig.DEFAULT.getIoThreadCount();
        this.workerCount = ioThreadCount;
        this.workers = new SingleCoreIOReactor[ioThreadCount];
        Thread[] threadArr = new Thread[ioThreadCount + 1];
        int i = 0;
        while (true) {
            singleCoreIOReactorArr = this.workers;
            if (i >= singleCoreIOReactorArr.length) {
                break;
            }
            SingleCoreIOReactor singleCoreIOReactor = new SingleCoreIOReactor(callback, iOEventHandlerFactory, iOReactorConfig != null ? iOReactorConfig : IOReactorConfig.DEFAULT, decorator, iOSessionListener, callback2);
            this.workers[i] = singleCoreIOReactor;
            i++;
            threadArr[i] = (threadFactory != null ? threadFactory : DISPATCH_THREAD_FACTORY).newThread(new IOReactorWorker(singleCoreIOReactor));
        }
        int i2 = this.workerCount;
        IOReactor[] iOReactorArr = new IOReactor[i2 + 1];
        System.arraycopy(singleCoreIOReactorArr, 0, iOReactorArr, 1, i2);
        SingleCoreListeningIOReactor singleCoreListeningIOReactor = new SingleCoreListeningIOReactor(callback, iOReactorConfig, new Callback() { // from class: org.apache.hc.core5.reactor.DefaultListeningIOReactor$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Callback
            public final void execute(Object obj) {
                this.f$0.enqueueChannel((ChannelEntry) obj);
            }
        });
        this.listener = singleCoreListeningIOReactor;
        iOReactorArr[0] = singleCoreListeningIOReactor;
        threadArr[0] = (threadFactory2 != null ? threadFactory2 : LISTENER_THREAD_FACTORY).newThread(new IOReactorWorker(singleCoreListeningIOReactor));
        this.ioReactor = new MultiCoreIOReactor(iOReactorArr, threadArr);
        this.workerSelector = IOWorkers.newSelector(this.workers);
    }

    public DefaultListeningIOReactor(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Callback<IOSession> callback) {
        this(iOEventHandlerFactory, iOReactorConfig, null, null, null, null, null, callback);
    }

    public DefaultListeningIOReactor(IOEventHandlerFactory iOEventHandlerFactory) {
        this(iOEventHandlerFactory, null, null);
    }

    @Override // org.apache.hc.core5.reactor.IOReactorService
    public void start() {
        this.ioReactor.start();
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, Object obj, FutureCallback<ListenerEndpoint> futureCallback) {
        return this.listener.listen(socketAddress, obj, futureCallback);
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Future<ListenerEndpoint> listen(SocketAddress socketAddress, FutureCallback<ListenerEndpoint> futureCallback) {
        return listen(socketAddress, null, futureCallback);
    }

    public Future<ListenerEndpoint> listen(SocketAddress socketAddress) {
        return listen(socketAddress, null);
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public Set<ListenerEndpoint> getEndpoints() {
        return this.listener.getEndpoints();
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void pause() throws IOException {
        this.listener.pause();
    }

    @Override // org.apache.hc.core5.reactor.ConnectionAcceptor
    public void resume() throws IOException {
        this.listener.resume();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public IOReactorStatus getStatus() {
        return this.ioReactor.getStatus();
    }

    @Override // org.apache.hc.core5.reactor.AbstractIOReactorBase
    IOWorkers.Selector getWorkerSelector() {
        return this.workerSelector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enqueueChannel(ChannelEntry channelEntry) {
        try {
            this.workerSelector.next().enqueueChannel(channelEntry);
        } catch (IOReactorShutdownException unused) {
            initiateShutdown();
        }
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public void initiateShutdown() {
        this.ioReactor.initiateShutdown();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public void awaitShutdown(TimeValue timeValue) throws InterruptedException {
        this.ioReactor.awaitShutdown(timeValue);
    }

    @Override // org.apache.hc.core5.reactor.IOReactor, org.apache.hc.core5.io.ModalCloseable
    public void close(CloseMode closeMode) {
        this.ioReactor.close(closeMode);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ioReactor.close();
    }
}
