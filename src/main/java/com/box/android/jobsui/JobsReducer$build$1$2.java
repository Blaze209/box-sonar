package com.box.android.jobsui;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: JobsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.jobsui.JobsReducer$build$1$2", f = "JobsReducer.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class JobsReducer$build$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ JobsReducer.State $state;
    int label;
    final /* synthetic */ JobsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsReducer$build$1$2(JobsReducer jobsReducer, JobsReducer.State state, Continuation<? super JobsReducer$build$1$2> continuation) {
        super(1, continuation);
        this.this$0 = jobsReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new JobsReducer$build$1$2(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((JobsReducer$build$1$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(this.this$0, this.$state, null), this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsReducer$build$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsReducer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsReducer$build$1$2$1", f = "JobsReducer.kt", i = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {179, 182, 185}, m = "invokeSuspend", n = {"$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-JobsReducer$build$1$2$1$list$1", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-JobsReducer$build$1$2$1$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobsReducer.State $state;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ JobsReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JobsReducer jobsReducer, JobsReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = jobsReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0091  */
        /* JADX WARN: Code duplicated, block: B:20:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:26:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00e3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00cc -> B:23:0x00d0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsReducer$build$1$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
