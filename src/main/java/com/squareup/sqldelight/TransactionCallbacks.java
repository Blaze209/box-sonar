package com.squareup.sqldelight;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Transacter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/squareup/sqldelight/TransactionCallbacks;", "", "afterCommit", "", "function", "Lkotlin/Function0;", "afterRollback", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TransactionCallbacks {
    void afterCommit(Function0<Unit> function);

    void afterRollback(Function0<Unit> function);
}
