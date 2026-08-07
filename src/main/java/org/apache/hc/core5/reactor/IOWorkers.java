package org.apache.hc.core5.reactor;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
final class IOWorkers {

    interface Selector {
        SingleCoreIOReactor next();
    }

    private static boolean isPowerOfTwo(int i) {
        return ((-i) & i) == i;
    }

    IOWorkers() {
    }

    static Selector newSelector(SingleCoreIOReactor[] singleCoreIOReactorArr) {
        return isPowerOfTwo(singleCoreIOReactorArr.length) ? new PowerOfTwoSelector(singleCoreIOReactorArr) : new GenericSelector(singleCoreIOReactorArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validate(SingleCoreIOReactor singleCoreIOReactor) {
        if (singleCoreIOReactor.getStatus() == IOReactorStatus.SHUT_DOWN) {
            throw new IOReactorShutdownException("I/O reactor has been shut down");
        }
    }

    private static final class PowerOfTwoSelector implements Selector {
        private final SingleCoreIOReactor[] dispatchers;
        private final AtomicInteger idx = new AtomicInteger(0);

        PowerOfTwoSelector(SingleCoreIOReactor[] singleCoreIOReactorArr) {
            this.dispatchers = singleCoreIOReactorArr;
        }

        @Override // org.apache.hc.core5.reactor.IOWorkers.Selector
        public SingleCoreIOReactor next() {
            SingleCoreIOReactor singleCoreIOReactor = this.dispatchers[(this.dispatchers.length - 1) & this.idx.getAndIncrement()];
            IOWorkers.validate(singleCoreIOReactor);
            return singleCoreIOReactor;
        }
    }

    private static final class GenericSelector implements Selector {
        private final SingleCoreIOReactor[] dispatchers;
        private final AtomicInteger idx = new AtomicInteger(0);

        GenericSelector(SingleCoreIOReactor[] singleCoreIOReactorArr) {
            this.dispatchers = singleCoreIOReactorArr;
        }

        @Override // org.apache.hc.core5.reactor.IOWorkers.Selector
        public SingleCoreIOReactor next() {
            SingleCoreIOReactor singleCoreIOReactor = this.dispatchers[(this.idx.getAndIncrement() & Integer.MAX_VALUE) % this.dispatchers.length];
            IOWorkers.validate(singleCoreIOReactor);
            return singleCoreIOReactor;
        }
    }
}
