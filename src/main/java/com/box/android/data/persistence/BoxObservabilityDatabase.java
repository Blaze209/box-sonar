package com.box.android.data.persistence;

import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import com.box.android.data.persistence.logging.MetricsDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BoxObservabilityDatabase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0086@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/data/persistence/BoxObservabilityDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "metricsLogDao", "Lcom/box/android/data/persistence/logging/MetricsDao;", "withTransactionWrapper", "", "lambda", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BoxObservabilityDatabase extends RoomDatabase {
    public abstract MetricsDao metricsLogDao();

    public final Object withTransactionWrapper(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object objWithTransaction = RoomDatabaseKt.withTransaction(this, function1, continuation);
        return objWithTransaction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithTransaction : Unit.INSTANCE;
    }
}
