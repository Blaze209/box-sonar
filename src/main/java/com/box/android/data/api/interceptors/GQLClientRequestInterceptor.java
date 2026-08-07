package com.box.android.data.api.interceptors;

import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.services.IAppInfoService;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLClientRequestInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/api/interceptors/GQLClientRequestInterceptor;", "Lokhttp3/Interceptor;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "appInfoService", "Lcom/box/android/domain/services/IAppInfoService;", "<init>", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/services/IAppInfoService;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "clientName", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLClientRequestInterceptor implements Interceptor {
    private final IAppInfoService appInfoService;
    private final IBoxAccountSettings boxAccountSettings;

    @Inject
    public GQLClientRequestInterceptor(IBoxAccountSettings boxAccountSettings, IAppInfoService appInfoService) {
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        this.boxAccountSettings = boxAccountSettings;
        this.appInfoService = appInfoService;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("x-box-client-name", clientName()).header("x-box-client-version", appVersion()).build());
    }

    private final String clientName() {
        if (this.boxAccountSettings.isEMMMode()) {
            return "box-android-mdm";
        }
        return "box-android";
    }

    private final String appVersion() {
        String appVersionName = this.appInfoService.getAppVersionName();
        return appVersionName == null ? "" : appVersionName;
    }
}
