package dagger.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class Providers {
    public static <T> Provider<T> asDaggerProvider(final javax.inject.Provider<T> provider) {
        Preconditions.checkNotNull(provider);
        if (provider instanceof Provider) {
            return (Provider) provider;
        }
        return new Provider<T>() { // from class: dagger.internal.Providers.1
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                return (T) provider.get();
            }
        };
    }

    private Providers() {
    }
}
