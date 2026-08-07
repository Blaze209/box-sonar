package com.box.android.coreservices.observability.appstart.apdex;

import com.box.android.coreservices.observability.appstart.AppStartDestinationPageType;
import com.box.android.coreservices.observability.appstart.AppStartType;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPage;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.domain.models.observability.AppStartupApdex;
import com.box.android.domain.services.ApdexService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStartApdexTracker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/apdex/AppStartApdexTracker;", "", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "appStartDestinationPageHolder", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "<init>", "(Lcom/box/android/domain/services/ApdexService;Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;)V", "isAppStartRecordedForPage", "", "source", "Lcom/box/android/coreservices/observability/appstart/AppStartDestinationPageType;", "consumeAppStartType", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "startDeferredAppStartIfNecessary", "", "appStartType", "identifier", "", "(Lcom/box/android/coreservices/observability/appstart/AppStartType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDeferredAppStart", "(Lcom/box/android/coreservices/observability/appstart/AppStartDestinationPageType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endAppStartIfNecessary", "appStartIdentifier", "getApdexType", "Lcom/box/android/domain/models/observability/AppStartupApdex;", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppStartApdexTracker {
    public static final String APP_START_PREFIX = "app_start_";
    private final ApdexService apdexService;
    private final IAppStartDestinationPageHolder appStartDestinationPageHolder;

    /* JADX INFO: renamed from: com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker$endAppStartIfNecessary$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppStartApdexTracker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker", f = "AppStartApdexTracker.kt", i = {0, 0, 1, 1}, l = {60, 62}, m = "endAppStartIfNecessary", n = {"source", "identifier", "source", "identifier"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppStartApdexTracker.this.endAppStartIfNecessary(null, null, this);
        }
    }

    @Inject
    public AppStartApdexTracker(ApdexService apdexService, IAppStartDestinationPageHolder appStartDestinationPageHolder) {
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        Intrinsics.checkNotNullParameter(appStartDestinationPageHolder, "appStartDestinationPageHolder");
        this.apdexService = apdexService;
        this.appStartDestinationPageHolder = appStartDestinationPageHolder;
    }

    public final boolean isAppStartRecordedForPage(AppStartDestinationPageType source) {
        Intrinsics.checkNotNullParameter(source, "source");
        IAppStartDestinationPage appStartDestinationPage = this.appStartDestinationPageHolder.getAppStartDestinationPage(source);
        if (appStartDestinationPage != null) {
            return appStartDestinationPage.isAppStartRecorded();
        }
        return false;
    }

    public final AppStartType consumeAppStartType(AppStartDestinationPageType source) {
        Intrinsics.checkNotNullParameter(source, "source");
        IAppStartDestinationPage appStartDestinationPage = this.appStartDestinationPageHolder.getAppStartDestinationPage(source);
        if (appStartDestinationPage != null) {
            return appStartDestinationPage.consumeAppStartType();
        }
        return null;
    }

    public final Object startDeferredAppStartIfNecessary(AppStartType appStartType, String str, Continuation<? super Unit> continuation) {
        Object objStartCustomizedTracker = this.apdexService.startCustomizedTracker(getApdexType(appStartType), appStartIdentifier(str), Boxing.boxLong(appStartType.getStartTime()), continuation);
        return objStartCustomizedTracker == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartCustomizedTracker : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startDeferredAppStart(AppStartDestinationPageType appStartDestinationPageType, String str, Continuation<? super Unit> continuation) {
        Object objStartDeferredAppStartIfNecessary;
        AppStartType appStartTypeConsumeAppStartType = consumeAppStartType(appStartDestinationPageType);
        return (appStartTypeConsumeAppStartType == null || (objStartDeferredAppStartIfNecessary = startDeferredAppStartIfNecessary(appStartTypeConsumeAppStartType, str, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objStartDeferredAppStartIfNecessary;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
    
        if (r9.endTrackerAsSuccess(r6, r0) == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object endAppStartIfNecessary(com.box.android.coreservices.observability.appstart.AppStartDestinationPageType r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker$endAppStartIfNecessary$1 r0 = (com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker$endAppStartIfNecessary$1 r0 = new com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker$endAppStartIfNecessary$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.coreservices.observability.appstart.AppStartDestinationPageType r6 = (com.box.android.coreservices.observability.appstart.AppStartDestinationPageType) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L81
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            com.box.android.coreservices.observability.appstart.AppStartDestinationPageType r8 = (com.box.android.coreservices.observability.appstart.AppStartDestinationPageType) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L66
        L4c:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r6.isAppStartRecordedForPage(r7)
            if (r9 == 0) goto L66
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r6.startDeferredAppStart(r7, r8, r0)
            if (r9 != r1) goto L66
            goto L80
        L66:
            com.box.android.domain.services.ApdexService r9 = r6.apdexService
            java.lang.String r6 = r6.appStartIdentifier(r8)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r6 = r9.endTrackerAsSuccess(r6, r0)
            if (r6 != r1) goto L81
        L80:
            return r1
        L81:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker.endAppStartIfNecessary(com.box.android.coreservices.observability.appstart.AppStartDestinationPageType, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String appStartIdentifier(String identifier) {
        return APP_START_PREFIX + identifier;
    }

    private final AppStartupApdex getApdexType(AppStartType appStartType) {
        if (appStartType instanceof AppStartType.Cold) {
            return AppStartupApdex.Cold.INSTANCE;
        }
        if (appStartType instanceof AppStartType.Warm) {
            return AppStartupApdex.Warm.INSTANCE;
        }
        if (appStartType instanceof AppStartType.Hot) {
            return AppStartupApdex.Hot.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
