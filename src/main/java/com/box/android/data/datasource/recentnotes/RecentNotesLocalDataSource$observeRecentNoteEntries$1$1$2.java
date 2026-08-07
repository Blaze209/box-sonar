package com.box.android.data.datasource.recentnotes;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.recentnotes.RecentNoteEntity;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "Lcom/box/android/data/datasource/CacheError;", "throwable", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2", f = "RecentNotesLocalDataSource.kt", i = {0, 0}, l = {29}, m = "invokeSuspend", n = {"$this$catch", "throwable"}, s = {"L$0", "L$1"}, v = 1)
final class RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends RecentNoteEntity>, ? extends CacheError>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2(Continuation<? super RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends List<? extends RecentNoteEntity>, ? extends CacheError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Result<? extends List<RecentNoteEntity>, ? extends CacheError>>) flowCollector, th, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Result<? extends List<RecentNoteEntity>, ? extends CacheError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2 recentNotesLocalDataSource$observeRecentNoteEntries$1$1$2 = new RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2(continuation);
        recentNotesLocalDataSource$observeRecentNoteEntries$1$1$2.L$0 = flowCollector;
        recentNotesLocalDataSource$observeRecentNoteEntries$1$1$2.L$1 = th;
        return recentNotesLocalDataSource$observeRecentNoteEntries$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BoxLogUtils.e(RecentNotesLocalDataSource.TAG, "Failed while collecting recent note entries", th);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit(new Result.Error(CacheError.ReadError.INSTANCE), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
