package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.LoaderOptions;

/* JADX INFO: loaded from: classes5.dex */
public class CustomClassLoaderConstructor extends Constructor {
    private final ClassLoader loader;

    public CustomClassLoaderConstructor(ClassLoader classLoader, LoaderOptions loaderOptions) {
        this(Object.class, classLoader, loaderOptions);
    }

    public CustomClassLoaderConstructor(Class<? extends Object> cls, ClassLoader classLoader, LoaderOptions loaderOptions) {
        super(cls, loaderOptions);
        if (classLoader == null) {
            throw new NullPointerException("Loader must be provided.");
        }
        this.loader = classLoader;
    }

    @Override // org.yaml.snakeyaml.constructor.Constructor
    protected Class<?> getClassForName(String str) throws ClassNotFoundException {
        return Class.forName(str, true, this.loader);
    }
}
