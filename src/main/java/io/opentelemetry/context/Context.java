package io.opentelemetry.context;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Context {
    @Nullable
    <V> V get(ContextKey<V> contextKey);

    <V> Context with(ContextKey<V> contextKey, V v);

    static Context current() {
        Context contextCurrent = ContextStorage.get().current();
        return contextCurrent != null ? contextCurrent : root();
    }

    static Context root() {
        return ContextStorage.get().root();
    }

    static Executor taskWrapping(final Executor executor) {
        return new Executor() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                executor.execute(Context.current().wrap(runnable));
            }
        };
    }

    static ExecutorService taskWrapping(ExecutorService executorService) {
        return new CurrentContextExecutorService(executorService);
    }

    default Context with(ImplicitContextKeyed implicitContextKeyed) {
        return implicitContextKeyed.storeInContext(this);
    }

    default Scope makeCurrent() {
        return ContextStorage.get().attach(this);
    }

    default Runnable wrap(final Runnable runnable) {
        return new Runnable() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                Context.lambda$wrap$1(this.f$0, runnable);
            }
        };
    }

    static /* synthetic */ void lambda$wrap$1(Context _this, Runnable runnable) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            runnable.run();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default <T> Callable<T> wrap(final Callable<T> callable) {
        return new Callable() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Context.lambda$wrap$2(this.f$0, callable);
            }
        };
    }

    static /* synthetic */ Object lambda$wrap$2(Context _this, Callable callable) throws Exception {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            Object objCall = callable.call();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objCall;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default Executor wrap(final Executor executor) {
        return new Executor() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                executor.execute(this.f$0.wrap(runnable));
            }
        };
    }

    default ExecutorService wrap(ExecutorService executorService) {
        return new ContextExecutorService(this, executorService);
    }

    default ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService) {
        return new ContextScheduledExecutorService(this, scheduledExecutorService);
    }

    default <T, U> Function<T, U> wrapFunction(final Function<T, U> function) {
        return new Function() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Context.lambda$wrapFunction$4(this.f$0, function, obj);
            }
        };
    }

    static /* synthetic */ Object lambda$wrapFunction$4(Context _this, Function function, Object obj) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            Object objApply = function.apply(obj);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objApply;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default <T, U, V> BiFunction<T, U, V> wrapFunction(final BiFunction<T, U, V> biFunction) {
        return new BiFunction() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda6
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Context.lambda$wrapFunction$5(this.f$0, biFunction, obj, obj2);
            }
        };
    }

    static /* synthetic */ Object lambda$wrapFunction$5(Context _this, BiFunction biFunction, Object obj, Object obj2) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            Object objApply = biFunction.apply(obj, obj2);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return objApply;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default <T> Consumer<T> wrapConsumer(final Consumer<T> consumer) {
        return new Consumer() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Context.lambda$wrapConsumer$6(this.f$0, consumer, obj);
            }
        };
    }

    static /* synthetic */ void lambda$wrapConsumer$6(Context _this, Consumer consumer, Object obj) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            consumer.accept(obj);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default <T, U> BiConsumer<T, U> wrapConsumer(final BiConsumer<T, U> biConsumer) {
        return new BiConsumer() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Context.lambda$wrapConsumer$7(this.f$0, biConsumer, obj, obj2);
            }
        };
    }

    static /* synthetic */ void lambda$wrapConsumer$7(Context _this, BiConsumer biConsumer, Object obj, Object obj2) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            biConsumer.accept(obj, obj2);
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    default <T> Supplier<T> wrapSupplier(final Supplier<T> supplier) {
        return new Supplier() { // from class: io.opentelemetry.context.Context$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Context.lambda$wrapSupplier$8(this.f$0, supplier);
            }
        };
    }

    static /* synthetic */ Object lambda$wrapSupplier$8(Context _this, Supplier supplier) {
        Scope scopeMakeCurrent = _this.makeCurrent();
        try {
            Object obj = supplier.get();
            if (scopeMakeCurrent != null) {
                scopeMakeCurrent.close();
            }
            return obj;
        } catch (Throwable th) {
            if (scopeMakeCurrent != null) {
                try {
                    scopeMakeCurrent.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
