package com.box.android.observability.appstart;

import android.app.Activity;
import com.box.android.auth.AuthenticationActivity;
import com.box.android.coreservices.observability.appstart.AppStartType;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPage;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationAppStartDestinationPage.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/box/android/observability/appstart/AuthenticationAppStartDestinationPage;", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPage;", "<init>", "()V", "isDestinationActivity", "", "activity", "Landroid/app/Activity;", "shouldRecordAppStart", "recordAppStart", "", "appStartType", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "isAppStartRecorded", "consumeAppStartType", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationAppStartDestinationPage implements IAppStartDestinationPage {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: consumeAppStartType, reason: collision with other method in class */
    public Void m12792consumeAppStartType() {
        return null;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean isAppStartRecorded() {
        return false;
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public void recordAppStart(AppStartType appStartType) {
        Intrinsics.checkNotNullParameter(appStartType, "appStartType");
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean shouldRecordAppStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return false;
    }

    @Inject
    public AuthenticationAppStartDestinationPage() {
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public /* bridge */ /* synthetic */ AppStartType consumeAppStartType() {
        return (AppStartType) m12792consumeAppStartType();
    }

    @Override // com.box.android.coreservices.observability.appstart.IAppStartDestinationPage
    public boolean isDestinationActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity instanceof AuthenticationActivity;
    }
}
