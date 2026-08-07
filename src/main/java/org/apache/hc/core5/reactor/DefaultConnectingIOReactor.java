package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.util.concurrent.ThreadFactory;
import org.apache.hc.core5.concurrent.DefaultThreadFactory;
import org.apache.hc.core5.function.Callback;
import org.apache.hc.core5.function.Decorator;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultConnectingIOReactor extends AbstractIOReactorBase {
    private static final ThreadFactory THREAD_FACTORY = new DefaultThreadFactory("I/O client dispatch", true);
    private final MultiCoreIOReactor ioReactor;
    private final int workerCount;
    private final IOWorkers.Selector workerSelector;
    private final SingleCoreIOReactor[] workers;

    public DefaultConnectingIOReactor(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, ThreadFactory threadFactory, Decorator<IOSession> decorator, Callback<Exception> callback, IOSessionListener iOSessionListener, Callback<IOSession> callback2) {
        Args.notNull(iOEventHandlerFactory, "Event handler factory");
        int ioThreadCount = iOReactorConfig != null ? iOReactorConfig.getIoThreadCount() : IOReactorConfig.DEFAULT.getIoThreadCount();
        this.workerCount = ioThreadCount;
        this.workers = new SingleCoreIOReactor[ioThreadCount];
        Thread[] threadArr = new Thread[ioThreadCount];
        for (int i = 0; i < this.workers.length; i++) {
            SingleCoreIOReactor singleCoreIOReactor = new SingleCoreIOReactor(callback, iOEventHandlerFactory, iOReactorConfig != null ? iOReactorConfig : IOReactorConfig.DEFAULT, decorator, iOSessionListener, callback2);
            this.workers[i] = singleCoreIOReactor;
            threadArr[i] = (threadFactory != null ? threadFactory : THREAD_FACTORY).newThread(new IOReactorWorker(singleCoreIOReactor));
        }
        this.ioReactor = new MultiCoreIOReactor(this.workers, threadArr);
        this.workerSelector = IOWorkers.newSelector(this.workers);
    }

    public DefaultConnectingIOReactor(IOEventHandlerFactory iOEventHandlerFactory, IOReactorConfig iOReactorConfig, Callback<IOSession> callback) {
        this(iOEventHandlerFactory, iOReactorConfig, null, null, null, null, callback);
    }

    public DefaultConnectingIOReactor(IOEventHandlerFactory iOEventHandlerFactory) {
        this(iOEventHandlerFactory, null, null);
    }

    @Override // org.apache.hc.core5.reactor.IOReactorService
    public void start() {
        this.ioReactor.start();
    }

    @Override // org.apache.hc.core5.reactor.IOReactor
    public IOReactorStatus getStatus() {
        return this.ioReactor.getStatus();
    }

    @Override // org.apache.hc.core5.reactor.AbstractIOReactorBase
    IOWorkers.Selector getWorkerSelector() {
        return this.workerSelector;
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
