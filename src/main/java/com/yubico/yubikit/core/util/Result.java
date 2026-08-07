package com.yubico.yubikit.core.util;

import java.lang.Throwable;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class Result<T, E extends Throwable> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private final E error;

    @Nullable
    private final T value;

    private Result(@Nullable T t, @Nullable E e) {
        this.value = t;
        this.error = e;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    public T getValue() throws Throwable {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw this.error;
    }

    public boolean isSuccess() {
        return this.value != null;
    }

    public boolean isError() {
        return this.error != null;
    }

    public static <T, E extends Throwable> Result<T, E> success(T t) {
        return new Result<>(t, null);
    }

    public static <T, E extends Throwable> Result<T, E> failure(E e) {
        return new Result<>(null, e);
    }

    public static <T> Result<T, Exception> of(Callable<T> callable) {
        try {
            return success(callable.call());
        } catch (Exception e) {
            return failure(e);
        }
    }
}
