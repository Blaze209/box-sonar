package io.opentelemetry.context;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
enum ThreadLocalContextStorage implements ContextStorage {
    INSTANCE;

    private static final Logger logger = Logger.getLogger(ThreadLocalContextStorage.class.getName());
    private static final ThreadLocal<Context> THREAD_LOCAL_STORAGE = new ThreadLocal<>();

    enum NoopScope implements Scope {
        INSTANCE;

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
        }
    }

    @Override // io.opentelemetry.context.ContextStorage
    public Scope attach(Context context) {
        if (context == null) {
            return NoopScope.INSTANCE;
        }
        Context contextCurrent = current();
        if (context == contextCurrent) {
            return NoopScope.INSTANCE;
        }
        THREAD_LOCAL_STORAGE.set(context);
        return new ScopeImpl(contextCurrent, context);
    }

    private class ScopeImpl implements Scope {

        @Nullable
        private final Context beforeAttach;
        private boolean closed;
        private final Context toAttach;

        private ScopeImpl(Context context, Context context2) {
            this.beforeAttach = context;
            this.toAttach = context2;
        }

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
            if (this.closed || ThreadLocalContextStorage.this.current() != this.toAttach) {
                ThreadLocalContextStorage.logger.log(Level.FINE, " Trying to close scope which does not represent current context. Ignoring the call.");
            } else {
                this.closed = true;
                ThreadLocalContextStorage.THREAD_LOCAL_STORAGE.set(this.beforeAttach);
            }
        }
    }

    @Override // io.opentelemetry.context.ContextStorage
    @Nullable
    public Context current() {
        return THREAD_LOCAL_STORAGE.get();
    }
}
