package sdk.pendo.io.d4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public enum b implements Callable<List<Object>>, sdk.pendo.io.q3.h<Object, List<Object>> {
    INSTANCE;

    @Override // sdk.pendo.io.q3.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<Object> call() {
        return new ArrayList();
    }

    public static <T> Callable<List<T>> a() {
        return INSTANCE;
    }
}
