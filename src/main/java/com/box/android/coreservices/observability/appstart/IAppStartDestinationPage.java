package com.box.android.coreservices.observability.appstart;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAppStartDestinationPage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\nH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPage;", "", "isDestinationActivity", "", "activity", "Landroid/app/Activity;", "shouldRecordAppStart", "recordAppStart", "", "appStartType", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "isAppStartRecorded", "consumeAppStartType", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAppStartDestinationPage {
    AppStartType consumeAppStartType();

    boolean isAppStartRecorded();

    boolean isDestinationActivity(Activity activity);

    void recordAppStart(AppStartType appStartType);

    boolean shouldRecordAppStart(Activity activity);
}
