package com.squareup.sqldelight;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Transacter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\bH&¨\u0006\t"}, d2 = {"Lcom/squareup/sqldelight/TransactionWithoutReturn;", "Lcom/squareup/sqldelight/TransactionCallbacks;", "rollback", "", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TransactionWithoutReturn extends TransactionCallbacks {
    Void rollback();

    /* JADX INFO: renamed from: transaction */
    void mo14349transaction(Function1<? super TransactionWithoutReturn, Unit> body);
}
