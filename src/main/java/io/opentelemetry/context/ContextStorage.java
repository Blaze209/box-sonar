package io.opentelemetry.context;

import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ContextStorage {
    Scope attach(Context context);

    @Nullable
    Context current();

    static ContextStorage get() {
        return LazyStorage.get();
    }

    static ContextStorage defaultStorage() {
        return ThreadLocalContextStorage.INSTANCE;
    }

    static void addWrapper(Function<? super ContextStorage, ? extends ContextStorage> function) {
        ContextStorageWrappers.addWrapper(function);
    }

    default Context root() {
        return ArrayBasedContext.root();
    }
}
