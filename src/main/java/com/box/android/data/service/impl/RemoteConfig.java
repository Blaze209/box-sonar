package com.box.android.data.service.impl;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteConfig.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/service/impl/RemoteConfig;", "", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "forceUpdateConfigSynchronizer", "Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer;", "<init>", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer;)V", "apdexThresholdsJson", "", "getApdexThresholdsJson", "()Ljava/lang/String;", "setApdexThresholdsJson", "(Ljava/lang/String;)V", "apdexMagnitudeLimitsJson", "getApdexMagnitudeLimitsJson", "setApdexMagnitudeLimitsJson", "init", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RemoteConfig {
    public static final String APDEX_MAGNITUDE_LIMITS = "apdex_magnitude_limits";
    public static final String APDEX_THRESHOLDS = "apdex_thresholds";
    private String apdexMagnitudeLimitsJson;
    private String apdexThresholdsJson;
    private final FirebaseRemoteConfig firebaseRemoteConfig;
    private final ForceUpdateConfigSynchronizer forceUpdateConfigSynchronizer;

    @Inject
    public RemoteConfig(FirebaseRemoteConfig firebaseRemoteConfig, ForceUpdateConfigSynchronizer forceUpdateConfigSynchronizer) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "firebaseRemoteConfig");
        Intrinsics.checkNotNullParameter(forceUpdateConfigSynchronizer, "forceUpdateConfigSynchronizer");
        this.firebaseRemoteConfig = firebaseRemoteConfig;
        this.forceUpdateConfigSynchronizer = forceUpdateConfigSynchronizer;
        this.apdexThresholdsJson = "";
        this.apdexMagnitudeLimitsJson = "";
    }

    public final String getApdexThresholdsJson() {
        return this.apdexThresholdsJson;
    }

    public final void setApdexThresholdsJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apdexThresholdsJson = str;
    }

    public final String getApdexMagnitudeLimitsJson() {
        return this.apdexMagnitudeLimitsJson;
    }

    public final void setApdexMagnitudeLimitsJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.apdexMagnitudeLimitsJson = str;
    }

    public final void init() {
        this.firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener() { // from class: com.box.android.data.service.impl.RemoteConfig$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                RemoteConfig.init$lambda$0$0(this.f$0, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0$0(RemoteConfig remoteConfig, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            String string = remoteConfig.firebaseRemoteConfig.getString(APDEX_THRESHOLDS);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            remoteConfig.apdexThresholdsJson = string;
            String string2 = remoteConfig.firebaseRemoteConfig.getString(APDEX_MAGNITUDE_LIMITS);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            remoteConfig.apdexMagnitudeLimitsJson = string2;
            remoteConfig.forceUpdateConfigSynchronizer.synchronize(remoteConfig.firebaseRemoteConfig);
            BoxLogUtils.d("Remote Config Fetch Successful");
            return;
        }
        BoxLogUtils.e("Remote Config Fetch Failed");
    }
}
