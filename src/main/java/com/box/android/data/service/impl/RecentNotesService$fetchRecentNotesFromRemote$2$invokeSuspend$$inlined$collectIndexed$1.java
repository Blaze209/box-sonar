package com.box.android.data.service.impl;

import com.box.android.data.api.models.recentnotes.RecentNoteDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", FirebaseAnalytics.Param.INDEX, "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1 implements FlowCollector<Result<? extends List<? extends RecentNoteDTO>, ? extends RemoteError>> {
    final /* synthetic */ Ref.ObjectRef $domainError$inlined;
    private int index;
    final /* synthetic */ RecentNotesService this$0;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1", f = "RecentNotesService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {128}, m = "emit", n = {"value", "$completion", "pageFetchResult", "$this$flatMap$iv", "pageDtos", "pageIndex", "$i$a$-collectIndexed-RecentNotesService$fetchRecentNotesFromRemote$2$1", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesService$fetchRecentNotesFromRemote$2$1$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1.this.emit(null, this);
        }
    }

    public RecentNotesService$fetchRecentNotesFromRemote$2$invokeSuspend$$inlined$collectIndexed$1(RecentNotesService recentNotesService, Ref.ObjectRef objectRef) {
        this.this$0 = recentNotesService;
        this.$domainError$inlined = objectRef;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r11v11, types: [T, com.box.android.domain.models.DomainError] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Result<? extends List<? extends RecentNoteDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objSaveFetchedPage = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSaveFetchedPage);
            int i2 = this.index;
            this.index = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            AnonymousClass1 anonymousClass2 = anonymousClass1;
            Result<? extends List<? extends RecentNoteDTO>, ? extends RemoteError> result2 = result;
            if (result2 instanceof Result.Success) {
                error = result2;
            } else {
                if (!(result2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result2).getValue(), null, 2, null));
            }
            if (error instanceof Result.Success) {
                List list = (List) ((Result.Success) error).getValue();
                RecentNotesService recentNotesService = this.this$0;
                boolean z = i2 == 0;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(error);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.I$3 = 0;
                anonymousClass1.label = 1;
                objSaveFetchedPage = recentNotesService.saveFetchedPage(list, z, anonymousClass1);
                if (objSaveFetchedPage == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$domainError$inlined.element = (DomainError) ((Result.Error) error).getValue();
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = anonymousClass1.I$3;
        int i4 = anonymousClass1.I$2;
        int i5 = anonymousClass1.I$1;
        int i6 = anonymousClass1.I$0;
        Object obj = anonymousClass1.L$0;
        ResultKt.throwOnFailure(objSaveFetchedPage);
        error = (Result) objSaveFetchedPage;
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            this.$domainError$inlined.element = (DomainError) ((Result.Error) error).getValue();
        }
        return Unit.INSTANCE;
    }
}
