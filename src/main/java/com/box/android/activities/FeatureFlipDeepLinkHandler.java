package com.box.android.activities;

import android.app.Activity;
import android.net.Uri;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlip;
import com.box.android.domain.configuration.FeatureFlips;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler;", "", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "validate", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "uri", "Landroid/net/Uri;", "isDebugBuild", "", "isBetaTrack", "toggle", "", "featureFlip", "Lcom/box/android/domain/configuration/FeatureFlip;", "enabled", "Result", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeatureFlipDeepLinkHandler {
    private static final String ENABLED_OFF = "off";
    private static final String ENABLED_ON = "on";
    private final FeatureFlips featureFlips;
    public static final int $stable = 8;
    private static final Set<String> VALID_ENABLED_VALUES = SetsKt.setOf((Object[]) new String[]{"on", "off"});

    @Inject
    public FeatureFlipDeepLinkHandler(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "", "<init>", "()V", "Rejected", "UnsupportedBuild", "InvalidUrl", "Valid", "LaunchActivity", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$InvalidUrl;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$LaunchActivity;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$Rejected;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$UnsupportedBuild;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$Valid;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Result {
        public static final int $stable = 0;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$Rejected;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Rejected extends Result {
            public static final int $stable = 0;
            public static final Rejected INSTANCE = new Rejected();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Rejected)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 373888532;
            }

            public String toString() {
                return "Rejected";
            }

            private Rejected() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$UnsupportedBuild;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UnsupportedBuild extends Result {
            public static final int $stable = 0;
            public static final UnsupportedBuild INSTANCE = new UnsupportedBuild();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UnsupportedBuild)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 822008015;
            }

            public String toString() {
                return "UnsupportedBuild";
            }

            private UnsupportedBuild() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$InvalidUrl;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InvalidUrl extends Result {
            public static final int $stable = 0;
            private final String key;

            public static /* synthetic */ InvalidUrl copy$default(InvalidUrl invalidUrl, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = invalidUrl.key;
                }
                return invalidUrl.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getKey() {
                return this.key;
            }

            public final InvalidUrl copy(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return new InvalidUrl(key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InvalidUrl) && Intrinsics.areEqual(this.key, ((InvalidUrl) other).key);
            }

            public int hashCode() {
                return this.key.hashCode();
            }

            public String toString() {
                return "InvalidUrl(key=" + this.key + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InvalidUrl(String key) {
                super(null);
                Intrinsics.checkNotNullParameter(key, "key");
                this.key = key;
            }

            public final String getKey() {
                return this.key;
            }
        }

        /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$Valid;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "featureFlip", "Lcom/box/android/domain/configuration/FeatureFlip;", "enabled", "", "<init>", "(Lcom/box/android/domain/configuration/FeatureFlip;Z)V", "getFeatureFlip", "()Lcom/box/android/domain/configuration/FeatureFlip;", "getEnabled", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Valid extends Result {
            public static final int $stable = 8;
            private final boolean enabled;
            private final FeatureFlip featureFlip;

            public static /* synthetic */ Valid copy$default(Valid valid, FeatureFlip featureFlip, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    featureFlip = valid.featureFlip;
                }
                if ((i & 2) != 0) {
                    z = valid.enabled;
                }
                return valid.copy(featureFlip, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FeatureFlip getFeatureFlip() {
                return this.featureFlip;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final Valid copy(FeatureFlip featureFlip, boolean enabled) {
                Intrinsics.checkNotNullParameter(featureFlip, "featureFlip");
                return new Valid(featureFlip, enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics.areEqual(this.featureFlip, valid.featureFlip) && this.enabled == valid.enabled;
            }

            public int hashCode() {
                return (this.featureFlip.hashCode() * 31) + Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "Valid(featureFlip=" + this.featureFlip + ", enabled=" + this.enabled + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(FeatureFlip featureFlip, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(featureFlip, "featureFlip");
                this.featureFlip = featureFlip;
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final FeatureFlip getFeatureFlip() {
                return this.featureFlip;
            }
        }

        /* JADX INFO: compiled from: FeatureFlipDeepLinkHandler.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result$LaunchActivity;", "Lcom/box/android/activities/FeatureFlipDeepLinkHandler$Result;", "activityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "<init>", "(Ljava/lang/Class;)V", "getActivityClass", "()Ljava/lang/Class;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchActivity extends Result {
            public static final int $stable = 8;
            private final Class<? extends Activity> activityClass;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ LaunchActivity copy$default(LaunchActivity launchActivity, Class cls, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = launchActivity.activityClass;
                }
                return launchActivity.copy(cls);
            }

            public final Class<? extends Activity> component1() {
                return this.activityClass;
            }

            public final LaunchActivity copy(Class<? extends Activity> activityClass) {
                Intrinsics.checkNotNullParameter(activityClass, "activityClass");
                return new LaunchActivity(activityClass);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LaunchActivity) && Intrinsics.areEqual(this.activityClass, ((LaunchActivity) other).activityClass);
            }

            public int hashCode() {
                return this.activityClass.hashCode();
            }

            public String toString() {
                return "LaunchActivity(activityClass=" + this.activityClass + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchActivity(Class<? extends Activity> activityClass) {
                super(null);
                Intrinsics.checkNotNullParameter(activityClass, "activityClass");
                this.activityClass = activityClass;
            }

            public final Class<? extends Activity> getActivityClass() {
                return this.activityClass;
            }
        }
    }

    public static /* synthetic */ Result validate$default(FeatureFlipDeepLinkHandler featureFlipDeepLinkHandler, Uri uri, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = BuildConfigProvider.INSTANCE.isDebugBuild();
        }
        if ((i & 4) != 0) {
            z2 = BuildConfigProvider.INSTANCE.isBetaTrack();
        }
        return featureFlipDeepLinkHandler.validate(uri, z, z2);
    }

    public final Result validate(Uri uri, boolean isDebugBuild, boolean isBetaTrack) throws IllegalAccessException {
        if (uri == null) {
            return Result.Rejected.INSTANCE;
        }
        if (!isDebugBuild && !isBetaTrack) {
            return Result.UnsupportedBuild.INSTANCE;
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames.isEmpty()) {
            return new Result.InvalidUrl("");
        }
        Intrinsics.checkNotNull(queryParameterNames);
        String str = (String) CollectionsKt.first(queryParameterNames);
        String queryParameter = uri.getQueryParameter(str);
        if (!CollectionsKt.contains(VALID_ENABLED_VALUES, queryParameter)) {
            Intrinsics.checkNotNull(str);
            return new Result.InvalidUrl(str);
        }
        FeatureFlips featureFlips = this.featureFlips;
        Intrinsics.checkNotNull(str);
        FeatureFlip featureFlipFindByDeepLinkKey = featureFlips.findByDeepLinkKey(str);
        if (featureFlipFindByDeepLinkKey == null) {
            return new Result.InvalidUrl(str);
        }
        return new Result.Valid(featureFlipFindByDeepLinkKey, Intrinsics.areEqual(queryParameter, "on"));
    }

    public final void toggle(FeatureFlip featureFlip, boolean enabled) {
        Intrinsics.checkNotNullParameter(featureFlip, "featureFlip");
        this.featureFlips.toggleFeatureFlip(featureFlip, enabled);
    }
}
