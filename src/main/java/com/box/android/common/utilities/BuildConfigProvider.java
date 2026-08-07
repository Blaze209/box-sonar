package com.box.android.common.utilities;

import com.box.android.common.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: BuildConfigProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/box/android/common/utilities/BuildConfigProvider;", "", "<init>", "()V", "isDebugBuild", "", "()Z", "isBetaTrack", "xPlatformVersion", "", "getXPlatformVersion", "()Ljava/lang/String;", "appBuiltTimestamp", "", "getAppBuiltTimestamp", "()J", "monthsSinceBuild", "", "nowMillis", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BuildConfigProvider {
    private static final boolean isBetaTrack = false;
    private static final boolean isDebugBuild = false;
    public static final BuildConfigProvider INSTANCE = new BuildConfigProvider();
    private static final String xPlatformVersion = "";
    private static final long appBuiltTimestamp = BuildConfig.APP_BUILD_TIMESTAMP;

    private BuildConfigProvider() {
    }

    public final boolean isDebugBuild() {
        return isDebugBuild;
    }

    public final boolean isBetaTrack() {
        return isBetaTrack;
    }

    public final String getXPlatformVersion() {
        return xPlatformVersion;
    }

    public final long getAppBuiltTimestamp() {
        return appBuiltTimestamp;
    }

    public static /* synthetic */ int monthsSinceBuild$default(BuildConfigProvider buildConfigProvider, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return buildConfigProvider.monthsSinceBuild(j);
    }

    public final int monthsSinceBuild(long nowMillis) {
        return DateUtils.INSTANCE.monthsDifference(appBuiltTimestamp, nowMillis);
    }
}
