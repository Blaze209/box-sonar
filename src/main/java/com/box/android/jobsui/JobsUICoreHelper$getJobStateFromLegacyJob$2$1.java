package com.box.android.jobsui;

import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.models.LegacyJobModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: JobsUICoreHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/compose/ItemThumbnail;", "Lkotlin/internal/Exact;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper$getJobStateFromLegacyJob$2$1", f = "JobsUICoreHelper.kt", i = {0, 1, 1, 1, 2}, l = {Token.LOCAL_BLOCK, Token.XMLEND, 140}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "it", "$i$a$-let-JobsUICoreHelper$getJobStateFromLegacyJob$2$1$1", "$this$flow"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0"}, v = 1)
final class JobsUICoreHelper$getJobStateFromLegacyJob$2$1 extends SuspendLambda implements Function2<FlowCollector<? super ItemThumbnail>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LegacyJobModel $this_with;
    final /* synthetic */ ThumbnailManager $thumbnailManager;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobsUICoreHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsUICoreHelper$getJobStateFromLegacyJob$2$1(LegacyJobModel legacyJobModel, JobsUICoreHelper jobsUICoreHelper, ThumbnailManager thumbnailManager, Continuation<? super JobsUICoreHelper$getJobStateFromLegacyJob$2$1> continuation) {
        super(2, continuation);
        this.$this_with = legacyJobModel;
        this.this$0 = jobsUICoreHelper;
        this.$thumbnailManager = thumbnailManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        JobsUICoreHelper$getJobStateFromLegacyJob$2$1 jobsUICoreHelper$getJobStateFromLegacyJob$2$1 = new JobsUICoreHelper$getJobStateFromLegacyJob$2$1(this.$this_with, this.this$0, this.$thumbnailManager, continuation);
        jobsUICoreHelper$getJobStateFromLegacyJob$2$1.L$0 = obj;
        return jobsUICoreHelper$getJobStateFromLegacyJob$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ItemThumbnail> flowCollector, Continuation<? super Unit> continuation) {
        return ((JobsUICoreHelper$getJobStateFromLegacyJob$2$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d4, code lost:
    
        if (r2.emit(r9, r8) == r1) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsUICoreHelper$getJobStateFromLegacyJob$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
