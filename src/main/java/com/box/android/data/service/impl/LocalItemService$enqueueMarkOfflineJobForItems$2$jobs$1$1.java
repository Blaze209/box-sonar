package com.box.android.data.service.impl;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LocalItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1", f = "LocalItemService.kt", i = {1, 1, 1, 1, 1}, l = {268, 282}, m = "invokeSuspend", n = {"$this$flatMap$iv", "remoteId", "jobRequest", "$i$f$flatMap", "$i$a$-flatMap-LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1$1"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
    final /* synthetic */ boolean $downloadOriginal;
    final /* synthetic */ ItemModel $item;
    final /* synthetic */ JobTags.JobSource $jobSource;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ LocalItemService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1(LocalItemService localItemService, ItemModel itemModel, JobTags.JobSource jobSource, boolean z, Continuation<? super LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1> continuation) {
        super(2, continuation);
        this.this$0 = localItemService;
        this.$item = itemModel;
        this.$jobSource = jobSource;
        this.$downloadOriginal = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1(this.this$0, this.$item, this.$jobSource, this.$downloadOriginal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return ((LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c8, code lost:
    
        if (r13 == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.LocalItemService$enqueueMarkOfflineJobForItems$2$jobs$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
