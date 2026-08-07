package sdk.pendo.io.actions;

import com.box.android.observability.DiagnosisParams;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.LastStepSeenConfigurationModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.models.ThrottlingConfigurationModel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/actions/GuidesConfigurationManager;", "", "()V", "DEFAULT_THROTTLING_TIME_MINUTES", "", "mLastStepSeenConfiguration", "Lsdk/pendo/io/models/LastStepSeenConfigurationModel;", "mLocalLastSeenTime", "", "Ljava/lang/Long;", "mThrottlingConfiguration", "Lsdk/pendo/io/models/ThrottlingConfigurationModel;", DiagnosisParams.CLEAR_ON_LOGOUT, "", "getIsThrottlingEnabled", "", "getLastSeenTimeMS", "()Ljava/lang/Long;", "getThrottlingIntervalMS", "setLastSeenTimeMS", "lastSeenTime", "setLastStepSeenConfigurationModel", "lastStepSeenConfigurationModel", "setThrottlingConfiguration", "throttlingConfigurationModel", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GuidesConfigurationManager {
    public static final int DEFAULT_THROTTLING_TIME_MINUTES = 5;
    public static final GuidesConfigurationManager INSTANCE = new GuidesConfigurationManager();
    private static LastStepSeenConfigurationModel mLastStepSeenConfiguration;
    private static Long mLocalLastSeenTime;
    private static ThrottlingConfigurationModel mThrottlingConfiguration;

    private GuidesConfigurationManager() {
    }

    public final void clear() {
        mLastStepSeenConfiguration = null;
        mLocalLastSeenTime = null;
        mThrottlingConfiguration = null;
    }

    public final synchronized boolean getIsThrottlingEnabled() {
        ThrottlingConfigurationModel throttlingConfigurationModel;
        throttlingConfigurationModel = mThrottlingConfiguration;
        return throttlingConfigurationModel != null ? throttlingConfigurationModel.isEnabled() : false;
    }

    public final synchronized Long getLastSeenTimeMS() {
        Long l = mLocalLastSeenTime;
        if (l != null) {
            return l;
        }
        LastStepSeenConfigurationModel lastStepSeenConfigurationModel = mLastStepSeenConfiguration;
        if (lastStepSeenConfigurationModel != null) {
            return lastStepSeenConfigurationModel != null ? Long.valueOf(lastStepSeenConfigurationModel.getTime()) : null;
        }
        return null;
    }

    public final synchronized int getThrottlingIntervalMS() {
        ThrottlingConfigurationModel throttlingConfigurationModel = mThrottlingConfiguration;
        if (throttlingConfigurationModel == null) {
            return 5000;
        }
        Intrinsics.checkNotNull(throttlingConfigurationModel);
        int interval = throttlingConfigurationModel.getInterval();
        ThrottlingConfigurationModel throttlingConfigurationModel2 = mThrottlingConfiguration;
        Intrinsics.checkNotNull(throttlingConfigurationModel2);
        String unit = throttlingConfigurationModel2.getUnit();
        Intrinsics.checkNotNullExpressionValue(unit, "getUnit(...)");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = unit.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1074026988) {
            if (iHashCode != -906279820) {
                if (iHashCode != 99228) {
                    if (iHashCode == 3208676 && lowerCase.equals("hour")) {
                        interval *= 3600;
                    }
                } else if (lowerCase.equals("day")) {
                    interval *= 86400;
                }
            } else if (!lowerCase.equals("second")) {
            }
            return interval * 1000;
        }
        lowerCase.equals("minute");
        interval *= 60;
        return interval * 1000;
    }

    public final synchronized void setLastSeenTimeMS(long lastSeenTime) {
        mLocalLastSeenTime = Long.valueOf(lastSeenTime);
    }

    public final synchronized void setLastStepSeenConfigurationModel(LastStepSeenConfigurationModel lastStepSeenConfigurationModel) {
        Intrinsics.checkNotNullParameter(lastStepSeenConfigurationModel, "lastStepSeenConfigurationModel");
        mLastStepSeenConfiguration = lastStepSeenConfigurationModel;
        String guideId = lastStepSeenConfigurationModel != null ? lastStepSeenConfigurationModel.getGuideId() : null;
        LastStepSeenConfigurationModel lastStepSeenConfigurationModel2 = mLastStepSeenConfiguration;
        String guideStepId = lastStepSeenConfigurationModel2 != null ? lastStepSeenConfigurationModel2.getGuideStepId() : null;
        if (guideId != null && guideStepId != null) {
            StepSeenManagerInterface stepSeenManager = StepSeenManager.getInstance();
            GuideModel guide = GuidesManager.INSTANCE.getGuide(guideId);
            stepSeenManager.setCurrentStepSeen(new StepSeen(guideId, guideStepId, guide != null ? guide.getGuideStepIndex(guideStepId) : null));
        }
    }

    public final synchronized void setThrottlingConfiguration(ThrottlingConfigurationModel throttlingConfigurationModel) {
        Intrinsics.checkNotNullParameter(throttlingConfigurationModel, "throttlingConfigurationModel");
        mThrottlingConfiguration = throttlingConfigurationModel;
    }
}
