package com.box.android.utilities;

import android.content.Context;
import android.content.pm.PackageManager;
import com.box.android.domain.services.IAppInfoService;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppInfoService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/utilities/AppInfoService;", "Lcom/box/android/domain/services/IAppInfoService;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAppVersionName", "", "getAppId", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppInfoService implements IAppInfoService {
    public static final int $stable = 8;
    private final Context appContext;

    @Inject
    public AppInfoService(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    @Override // com.box.android.domain.services.IAppInfoService
    public String getAppVersionName() {
        try {
            return MAMPackageManagement.getPackageInfo(this.appContext.getPackageManager(), this.appContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // com.box.android.domain.services.IAppInfoService
    public String getAppId() {
        return "com.box.android";
    }
}
