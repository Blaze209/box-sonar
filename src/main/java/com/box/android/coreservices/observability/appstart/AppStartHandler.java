package com.box.android.coreservices.observability.appstart;

import android.app.Activity;
import android.app.Application;
import com.box.android.coreservices.observability.appstart.helpers.AppStartActivityLifecycleCallbacks;
import com.box.android.coreservices.observability.appstart.helpers.ColdStartCalculation;
import com.box.android.domain.services.IAppInBackgroundService;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStartHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0007J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/AppStartHandler;", "", "appInBackgroundService", "Lcom/box/android/domain/services/IAppInBackgroundService;", "coldStartCalculation", "Lcom/box/android/coreservices/observability/appstart/helpers/ColdStartCalculation;", "<init>", "(Lcom/box/android/domain/services/IAppInBackgroundService;Lcom/box/android/coreservices/observability/appstart/helpers/ColdStartCalculation;)V", "isColdStart", "", "isColdStart$annotations", "()V", "()Z", "setColdStart", "(Z)V", "destinationPageHolder", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "onBoxApplicationCreated", "", "app", "Landroid/app/Application;", "onActivityPreCreated", "activity", "Landroid/app/Activity;", "activityPreCreatedTime", "", "onActivityPreStarted", "activityPreStartedTime", "checkForColdStart", "appStartDestinationPage", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPage;", "checkForWarmStart", "checkForHotStart", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppStartHandler {
    private final IAppInBackgroundService appInBackgroundService;
    private final ColdStartCalculation coldStartCalculation;
    private IAppStartDestinationPageHolder destinationPageHolder;
    private boolean isColdStart;

    public static /* synthetic */ void isColdStart$annotations() {
    }

    @Inject
    public AppStartHandler(IAppInBackgroundService appInBackgroundService, ColdStartCalculation coldStartCalculation) {
        Intrinsics.checkNotNullParameter(appInBackgroundService, "appInBackgroundService");
        Intrinsics.checkNotNullParameter(coldStartCalculation, "coldStartCalculation");
        this.appInBackgroundService = appInBackgroundService;
        this.coldStartCalculation = coldStartCalculation;
    }

    /* JADX INFO: renamed from: isColdStart, reason: from getter */
    public final boolean getIsColdStart() {
        return this.isColdStart;
    }

    public final void setColdStart(boolean z) {
        this.isColdStart = z;
    }

    public final void onBoxApplicationCreated(Application app, IAppStartDestinationPageHolder destinationPageHolder) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(destinationPageHolder, "destinationPageHolder");
        this.isColdStart = true;
        this.destinationPageHolder = destinationPageHolder;
        app.registerActivityLifecycleCallbacks(new AppStartActivityLifecycleCallbacks(new AnonymousClass1(this), new AnonymousClass2(this)));
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.observability.appstart.AppStartHandler$onBoxApplicationCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppStartHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Activity, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, AppStartHandler.class, "onActivityPreCreated", "onActivityPreCreated(Landroid/app/Activity;J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
            invoke2(activity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            AppStartHandler.onActivityPreCreated$default((AppStartHandler) this.receiver, p0, 0L, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.observability.appstart.AppStartHandler$onBoxApplicationCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppStartHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function1<Activity, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, AppStartHandler.class, "onActivityPreStarted", "onActivityPreStarted(Landroid/app/Activity;J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
            invoke2(activity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            AppStartHandler.onActivityPreStarted$default((AppStartHandler) this.receiver, p0, 0L, 2, null);
        }
    }

    public static /* synthetic */ void onActivityPreCreated$default(AppStartHandler appStartHandler, Activity activity, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        appStartHandler.onActivityPreCreated(activity, j);
    }

    public final void onActivityPreCreated(Activity activity, long activityPreCreatedTime) {
        IAppStartDestinationPage appStartDestinationPage;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IAppStartDestinationPageHolder iAppStartDestinationPageHolder = this.destinationPageHolder;
        if (iAppStartDestinationPageHolder != null && (appStartDestinationPage = iAppStartDestinationPageHolder.getAppStartDestinationPage(activity)) != null) {
            if (!appStartDestinationPage.shouldRecordAppStart(activity) || checkForColdStart(appStartDestinationPage)) {
                return;
            }
            checkForWarmStart(appStartDestinationPage, activityPreCreatedTime);
            return;
        }
        this.isColdStart = false;
    }

    public static /* synthetic */ void onActivityPreStarted$default(AppStartHandler appStartHandler, Activity activity, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        appStartHandler.onActivityPreStarted(activity, j);
    }

    public final void onActivityPreStarted(Activity activity, long activityPreStartedTime) {
        IAppStartDestinationPage appStartDestinationPage;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IAppStartDestinationPageHolder iAppStartDestinationPageHolder = this.destinationPageHolder;
        if (iAppStartDestinationPageHolder == null || (appStartDestinationPage = iAppStartDestinationPageHolder.getAppStartDestinationPage(activity)) == null) {
            return;
        }
        if (!appStartDestinationPage.shouldRecordAppStart(activity)) {
            appStartDestinationPage = null;
        }
        if (appStartDestinationPage != null) {
            checkForHotStart(appStartDestinationPage, activityPreStartedTime);
        }
    }

    private final boolean checkForColdStart(IAppStartDestinationPage appStartDestinationPage) {
        if (!this.isColdStart) {
            return false;
        }
        this.isColdStart = false;
        appStartDestinationPage.recordAppStart(new AppStartType.Cold(this.coldStartCalculation.calculateTime()));
        return true;
    }

    private final void checkForWarmStart(IAppStartDestinationPage appStartDestinationPage, long activityPreCreatedTime) {
        if (!this.appInBackgroundService.isAppInBackground() || appStartDestinationPage.isAppStartRecorded()) {
            return;
        }
        appStartDestinationPage.recordAppStart(new AppStartType.Warm(activityPreCreatedTime));
    }

    private final void checkForHotStart(IAppStartDestinationPage appStartDestinationPage, long activityPreStartedTime) {
        if (!this.appInBackgroundService.isAppInBackground() || appStartDestinationPage.isAppStartRecorded()) {
            return;
        }
        appStartDestinationPage.recordAppStart(new AppStartType.Hot(activityPreStartedTime));
    }
}
