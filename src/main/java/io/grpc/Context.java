package io.grpc;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class Context {
    static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    private static final PersistentHashArrayMappedTrie<Key<?>, Object> EMPTY_ENTRIES;
    public static final Context ROOT;
    static final Logger log = Logger.getLogger(Context.class.getName());
    final CancellableContext cancellableAncestor;
    final int generation;
    final PersistentHashArrayMappedTrie<Key<?>, Object> keyValueEntries;
    private ArrayList<ExecutableListener> listeners;
    private CancellationListener parentListener;

    @interface CanIgnoreReturnValue {
    }

    public interface CancellationListener {
        void cancelled(Context context);
    }

    @interface CheckReturnValue {
    }

    static {
        PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie = new PersistentHashArrayMappedTrie<>();
        EMPTY_ENTRIES = persistentHashArrayMappedTrie;
        ROOT = new Context((Context) null, persistentHashArrayMappedTrie);
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    private static final class LazyStorage {
        static final Storage storage;

        private LazyStorage() {
        }

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t) {
        return new Key<>(str, t);
    }

    public static Context current() {
        Context contextCurrent = storage().current();
        return contextCurrent == null ? ROOT : contextCurrent;
    }

    private Context(PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie, int i) {
        this.parentListener = new ParentListener();
        this.cancellableAncestor = null;
        this.keyValueEntries = persistentHashArrayMappedTrie;
        this.generation = i;
        validateGeneration(i);
    }

    private Context(Context context, PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie) {
        this.parentListener = new ParentListener();
        this.cancellableAncestor = cancellableAncestor(context);
        this.keyValueEntries = persistentHashArrayMappedTrie;
        int i = context == null ? 0 : context.generation + 1;
        this.generation = i;
        validateGeneration(i);
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadlineAfter(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j, timeUnit), scheduledExecutorService);
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(deadline, "deadline");
        checkNotNull(scheduledExecutorService, "scheduler");
        return new CancellableContext(deadline, scheduledExecutorService);
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, this.keyValueEntries.put(key, v));
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2).put(key3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3, Key<V4> key4, V4 v4) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2).put(key3, v3).put(key4, v4));
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    boolean canBeCancelled() {
        return this.cancellableAncestor != null;
    }

    public Context attach() {
        Context contextDoAttach = storage().doAttach(this);
        return contextDoAttach == null ? ROOT : contextDoAttach;
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    boolean isCurrent() {
        return current() == this;
    }

    public boolean isCancelled() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return false;
        }
        return cancellableContext.isCancelled();
    }

    public Throwable cancellationCause() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.cancellationCause();
    }

    public Deadline getDeadline() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.getDeadline();
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        if (canBeCancelled()) {
            ExecutableListener executableListener = new ExecutableListener(executor, cancellationListener);
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else {
                    ArrayList<ExecutableListener> arrayList = this.listeners;
                    if (arrayList == null) {
                        ArrayList<ExecutableListener> arrayList2 = new ArrayList<>();
                        this.listeners = arrayList2;
                        arrayList2.add(executableListener);
                        CancellableContext cancellableContext = this.cancellableAncestor;
                        if (cancellableContext != null) {
                            cancellableContext.addListener(this.parentListener, DirectExecutor.INSTANCE);
                        }
                    } else {
                        arrayList.add(executableListener);
                    }
                }
            }
        }
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (canBeCancelled()) {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (this.listeners.get(size).listener == cancellationListener) {
                            this.listeners.remove(size);
                            break;
                        }
                    }
                    if (this.listeners.isEmpty()) {
                        CancellableContext cancellableContext = this.cancellableAncestor;
                        if (cancellableContext != null) {
                            cancellableContext.removeListener(this.parentListener);
                        }
                        this.listeners = null;
                    }
                }
            }
        }
    }

    void notifyAndClearListeners() {
        if (canBeCancelled()) {
            synchronized (this) {
                ArrayList<ExecutableListener> arrayList = this.listeners;
                if (arrayList == null) {
                    return;
                }
                this.listeners = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!(arrayList.get(i).listener instanceof ParentListener)) {
                        arrayList.get(i).deliver();
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).listener instanceof ParentListener) {
                        arrayList.get(i2).deliver();
                    }
                }
                CancellableContext cancellableContext = this.cancellableAncestor;
                if (cancellableContext != null) {
                    cancellableContext.removeListener(this.parentListener);
                }
            }
        }
    }

    int listenerCount() {
        int size;
        synchronized (this) {
            ArrayList<ExecutableListener> arrayList = this.listeners;
            size = arrayList == null ? 0 : arrayList.size();
        }
        return size;
    }

    public void run(Runnable runnable) {
        Context contextAttach = attach();
        try {
            runnable.run();
        } finally {
            detach(contextAttach);
        }
    }

    public <V> V call(Callable<V> callable) throws Exception {
        Context contextAttach = attach();
        try {
            return callable.call();
        } finally {
            detach(contextAttach);
        }
    }

    public Runnable wrap(final Runnable runnable) {
        return new Runnable() { // from class: io.grpc.Context.1
            @Override // java.lang.Runnable
            public void run() {
                Context contextAttach = Context.this.attach();
                try {
                    runnable.run();
                } finally {
                    Context.this.detach(contextAttach);
                }
            }
        };
    }

    public <C> Callable<C> wrap(final Callable<C> callable) {
        return new Callable<C>() { // from class: io.grpc.Context.2
            @Override // java.util.concurrent.Callable
            public C call() throws Exception {
                Context contextAttach = Context.this.attach();
                try {
                    return (C) callable.call();
                } finally {
                    Context.this.detach(contextAttach);
                }
            }
        };
    }

    public Executor fixedContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1FixedContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.this.wrap(runnable));
            }
        };
    }

    public static Executor currentContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1CurrentContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.current().wrap(runnable));
            }
        };
    }

    Object lookup(Key<?> key) {
        return this.keyValueEntries.get(key);
    }

    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        @Override // io.grpc.Context
        boolean canBeCancelled() {
            return true;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private CancellableContext(Context context) {
            super(context.keyValueEntries);
            this.deadline = context.getDeadline();
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private CancellableContext(Context context, Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
            super(context.keyValueEntries);
            Deadline deadline2 = context.getDeadline();
            if (deadline2 != null && deadline2.compareTo(deadline) <= 0) {
                deadline = deadline2;
            } else if (!deadline.isExpired()) {
                this.pendingDeadline = deadline.runOnExpiration(new Runnable() { // from class: io.grpc.Context.CancellableContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CancellableContext.this.cancel(new TimeoutException("context timed out"));
                        } catch (Throwable th) {
                            Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th);
                        }
                    }
                }, scheduledExecutorService);
            } else {
                cancel(new TimeoutException("context timed out"));
            }
            this.deadline = deadline;
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        @Override // io.grpc.Context
        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        @Override // io.grpc.Context
        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        public boolean cancel(Throwable th) {
            boolean z;
            synchronized (this) {
                z = false;
                if (!this.cancelled) {
                    this.cancelled = true;
                    ScheduledFuture<?> scheduledFuture = this.pendingDeadline;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = th;
                    z = true;
                }
            }
            if (z) {
                notifyAndClearListeners();
            }
            return z;
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (!super.isCancelled()) {
                    return false;
                }
                cancel(super.cancellationCause());
                return true;
            }
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // io.grpc.Context
        public Deadline getDeadline() {
            return this.deadline;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            cancel(null);
        }
    }

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String str) {
            this(str, null);
        }

        Key(String str, T t) {
            this.name = (String) Context.checkNotNull(str, "name");
            this.defaultValue = t;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T t = (T) context.lookup(this);
            return t == null ? this.defaultValue : t;
        }

        public String toString() {
            return this.name;
        }
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        @Deprecated
        public void attach(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public Context doAttach(Context context) {
            Context contextCurrent = current();
            attach(context);
            return contextCurrent;
        }
    }

    private final class ExecutableListener implements Runnable {
        private final Executor executor;
        final CancellationListener listener;

        ExecutableListener(Executor executor, CancellationListener cancellationListener) {
            this.executor = executor;
            this.listener = cancellationListener;
        }

        void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.log.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.cancelled(Context.this);
        }
    }

    private final class ParentListener implements CancellationListener {
        private ParentListener() {
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            Context context2 = Context.this;
            if (context2 instanceof CancellableContext) {
                ((CancellableContext) context2).cancel(context.cancellationCause());
            } else {
                context2.notifyAndClearListeners();
            }
        }
    }

    static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    static CancellableContext cancellableAncestor(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof CancellableContext) {
            return (CancellableContext) context;
        }
        return context.cancellableAncestor;
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }
}
