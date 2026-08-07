package com.microsoft.intune.mam.client;

/* JADX INFO: loaded from: classes3.dex */
public class CachedBehaviorProvider<T> {
    private Class<T> mClass;
    private T mVal;

    public CachedBehaviorProvider(Class<T> cls) {
        this.mClass = cls;
    }

    public T get() {
        T t = this.mVal;
        if (t != null) {
            return t;
        }
        synchronized (this) {
            T t2 = this.mVal;
            if (t2 != null) {
                return t2;
            }
            T component = getComponent();
            this.mVal = component;
            return component;
        }
    }

    protected T getComponent() {
        return (T) InterfaceComponentsAccess.get(this.mClass);
    }
}
