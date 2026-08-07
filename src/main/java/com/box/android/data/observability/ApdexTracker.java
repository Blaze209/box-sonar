package com.box.android.data.observability;

import com.box.android.domain.models.observability.ApdexType;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexTracker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/observability/ApdexTracker;", "Lcom/box/android/domain/services/ApdexService;", "openTelemetryInstrumentation", "Lcom/box/android/data/observability/OpenTelemetryInstrumentation;", "rumObservability", "Lcom/box/android/domain/services/RumService;", "<init>", "(Lcom/box/android/data/observability/OpenTelemetryInstrumentation;Lcom/box/android/domain/services/RumService;)V", "startTracker", "", "apdex", "Lcom/box/android/domain/models/observability/ApdexType;", "identifier", "startCustomizedTracker", "startTimestamp", "", "(Lcom/box/android/domain/models/observability/ApdexType;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMilestone", "", "milestone", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "timestamp", "(Lcom/box/android/domain/models/observability/ApdexType$Milestone;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTrackerAsSuccess", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endTrackerAsFailure", "error", "Lcom/box/android/domain/models/DomainError;", "(Ljava/lang/String;Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApdexTracker implements ApdexService {
    private final OpenTelemetryInstrumentation openTelemetryInstrumentation;
    private final RumService rumObservability;

    /* JADX INFO: renamed from: com.box.android.data.observability.ApdexTracker$addMilestone$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApdexTracker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.ApdexTracker", f = "ApdexTracker.kt", i = {0, 0, 0, 1, 1, 1}, l = {30, 31}, m = "addMilestone", n = {"milestone", "identifier", "timestamp", "milestone", "identifier", "timestamp"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApdexTracker.this.addMilestone(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.ApdexTracker$endTrackerAsFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApdexTracker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.ApdexTracker", f = "ApdexTracker.kt", i = {0, 0, 1, 1}, l = {40, 41}, m = "endTrackerAsFailure", n = {"identifier", "error", "identifier", "error"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C13611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13611(Continuation<? super C13611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApdexTracker.this.endTrackerAsFailure(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.ApdexTracker$endTrackerAsSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApdexTracker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.ApdexTracker", f = "ApdexTracker.kt", i = {0, 1}, l = {35, 36}, m = "endTrackerAsSuccess", n = {"identifier", "identifier"}, s = {"L$0", "L$0"}, v = 1)
    static final class C13621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C13621(Continuation<? super C13621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApdexTracker.this.endTrackerAsSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.observability.ApdexTracker$startCustomizedTracker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApdexTracker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.observability.ApdexTracker", f = "ApdexTracker.kt", i = {0, 0, 0, 0, 0}, l = {21}, m = "startCustomizedTracker", n = {"apdex", "identifier", "startTimestamp", "it", "$i$a$-also-ApdexTracker$startCustomizedTracker$2"}, s = {"L$0", "L$1", "L$2", "L$4", "I$0"}, v = 1)
    static final class C13631 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13631(Continuation<? super C13631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApdexTracker.this.startCustomizedTracker(null, null, null, this);
        }
    }

    @Inject
    public ApdexTracker(OpenTelemetryInstrumentation openTelemetryInstrumentation, RumService rumObservability) {
        Intrinsics.checkNotNullParameter(openTelemetryInstrumentation, "openTelemetryInstrumentation");
        Intrinsics.checkNotNullParameter(rumObservability, "rumObservability");
        this.openTelemetryInstrumentation = openTelemetryInstrumentation;
        this.rumObservability = rumObservability;
    }

    @Override // com.box.android.domain.services.ApdexService
    public String startTracker(ApdexType apdex, String identifier) {
        Intrinsics.checkNotNullParameter(apdex, "apdex");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        OpenTelemetryInstrumentation.startSpan$default(this.openTelemetryInstrumentation, apdex.getName(), identifier, null, 4, null);
        this.rumObservability.startSpan(apdex.getName(), identifier);
        return identifier;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ApdexService
    public Object startCustomizedTracker(ApdexType apdexType, String str, Long l, Continuation<? super String> continuation) {
        C13631 c13631;
        if (continuation instanceof C13631) {
            c13631 = (C13631) continuation;
            if ((c13631.label & Integer.MIN_VALUE) != 0) {
                c13631.label -= Integer.MIN_VALUE;
            } else {
                c13631 = new C13631(continuation);
            }
        } else {
            c13631 = new C13631(continuation);
        }
        C13631 c13632 = c13631;
        Object obj = c13632.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13632.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c13632.I$0;
            String str2 = (String) c13632.L$3;
            ResultKt.throwOnFailure(obj);
            return str2;
        }
        ResultKt.throwOnFailure(obj);
        this.openTelemetryInstrumentation.startSpan(apdexType.getName(), str, l);
        RumService rumService = this.rumObservability;
        String name = apdexType.getName();
        c13632.L$0 = SpillingKt.nullOutSpilledVariable(apdexType);
        c13632.L$1 = SpillingKt.nullOutSpilledVariable(str);
        c13632.L$2 = SpillingKt.nullOutSpilledVariable(l);
        c13632.L$3 = str;
        c13632.L$4 = SpillingKt.nullOutSpilledVariable(str);
        c13632.I$0 = 0;
        c13632.label = 1;
        return RumService.startCustomizedSpan$default(rumService, null, name, str, null, false, l, c13632, 24, null) == coroutine_suspended ? coroutine_suspended : str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (com.box.android.domain.services.RumService.addMilestone$default(r1, r2, r3, null, r5, 4, null) == r0) goto L21;
     */
    @Override // com.box.android.domain.services.ApdexService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object addMilestone(com.box.android.domain.models.observability.ApdexType.Milestone r9, java.lang.String r10, java.lang.Long r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.box.android.data.observability.ApdexTracker.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.box.android.data.observability.ApdexTracker$addMilestone$1 r0 = (com.box.android.data.observability.ApdexTracker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.box.android.data.observability.ApdexTracker$addMilestone$1 r0 = new com.box.android.data.observability.ApdexTracker$addMilestone$1
            r0.<init>(r12)
        L19:
            r5 = r0
            java.lang.Object r12 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L54
            if (r1 == r3) goto L42
            if (r1 != r2) goto L3a
            java.lang.Object r8 = r5.L$2
            java.lang.Long r8 = (java.lang.Long) r8
            java.lang.Object r8 = r5.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r5.L$0
            com.box.android.domain.models.observability.ApdexType$Milestone r8 = (com.box.android.domain.models.observability.ApdexType.Milestone) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L96
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            java.lang.Object r9 = r5.L$2
            r11 = r9
            java.lang.Long r11 = (java.lang.Long) r11
            java.lang.Object r9 = r5.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r5.L$0
            com.box.android.domain.models.observability.ApdexType$Milestone r9 = (com.box.android.domain.models.observability.ApdexType.Milestone) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L70
        L54:
            kotlin.ResultKt.throwOnFailure(r12)
            com.box.android.data.observability.OpenTelemetryInstrumentation r12 = r8.openTelemetryInstrumentation
            java.lang.String r1 = r9.getName()
            r5.L$0 = r9
            r5.L$1 = r10
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r5.L$2 = r4
            r5.label = r3
            java.lang.Object r12 = r12.addMilestone(r1, r10, r11, r5)
            if (r12 != r0) goto L70
            goto L95
        L70:
            r3 = r10
            com.box.android.domain.services.RumService r1 = r8.rumObservability
            r8 = r2
            java.lang.String r2 = r9.getName()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r5.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r5.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r5.L$2 = r9
            r5.label = r8
            r4 = 0
            r6 = 4
            r7 = 0
            java.lang.Object r8 = com.box.android.domain.services.RumService.addMilestone$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L96
        L95:
            return r0
        L96:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.observability.ApdexTracker.addMilestone(com.box.android.domain.models.observability.ApdexType$Milestone, java.lang.String, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
    
        if (r5.endSpanAsSuccess(r6, r0) == r1) goto L21;
     */
    @Override // com.box.android.domain.services.ApdexService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object endTrackerAsSuccess(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.observability.ApdexTracker.C13621
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.observability.ApdexTracker$endTrackerAsSuccess$1 r0 = (com.box.android.data.observability.ApdexTracker.C13621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.observability.ApdexTracker$endTrackerAsSuccess$1 r0 = new com.box.android.data.observability.ApdexTracker$endTrackerAsSuccess$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.data.observability.OpenTelemetryInstrumentation r7 = r5.openTelemetryInstrumentation
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.endSpanAsSuccess(r6, r0)
            if (r7 != r1) goto L51
            goto L61
        L51:
            com.box.android.domain.services.RumService r5 = r5.rumObservability
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.endSpanAsSuccess(r6, r0)
            if (r5 != r1) goto L62
        L61:
            return r1
        L62:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.observability.ApdexTracker.endTrackerAsSuccess(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        if (r5.endSpanWithError(r6, r7, r0) == r1) goto L21;
     */
    @Override // com.box.android.domain.services.ApdexService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object endTrackerAsFailure(java.lang.String r6, com.box.android.domain.models.DomainError r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.box.android.data.observability.ApdexTracker.C13611
            if (r0 == 0) goto L14
            r0 = r8
            com.box.android.data.observability.ApdexTracker$endTrackerAsFailure$1 r0 = (com.box.android.data.observability.ApdexTracker.C13611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.box.android.data.observability.ApdexTracker$endTrackerAsFailure$1 r0 = new com.box.android.data.observability.ApdexTracker$endTrackerAsFailure$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.models.DomainError r5 = (com.box.android.domain.models.DomainError) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L73
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.domain.models.DomainError r7 = (com.box.android.domain.models.DomainError) r7
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5c
        L4a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.data.observability.OpenTelemetryInstrumentation r8 = r5.openTelemetryInstrumentation
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.endSpanWithFailure(r6, r7, r0)
            if (r8 != r1) goto L5c
            goto L72
        L5c:
            com.box.android.domain.services.RumService r5 = r5.rumObservability
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.endSpanWithError(r6, r7, r0)
            if (r5 != r1) goto L73
        L72:
            return r1
        L73:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.observability.ApdexTracker.endTrackerAsFailure(java.lang.String, com.box.android.domain.models.DomainError, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
