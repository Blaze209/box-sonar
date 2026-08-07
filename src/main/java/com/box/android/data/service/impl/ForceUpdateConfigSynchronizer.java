package com.box.android.data.service.impl;

import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ForceUpdateConfigSynchronizer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer;", "", "forceUpdateRepository", "Lcom/box/android/domain/configuration/IForceUpdateRepository;", "forceUpdateCoordinator", "Lcom/box/android/domain/services/IForceUpdateCoordinator;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/domain/configuration/IForceUpdateRepository;Lcom/box/android/domain/services/IForceUpdateCoordinator;Lcom/squareup/moshi/Moshi;)V", "synchronize", "", "firebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "Companion", "ForceUpdateConfig", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateConfigSynchronizer {
    public static final String FORCE_UPDATE_CONFIG = "force_update_config_prod";
    public static final String FORCE_UPDATE_FEATURE_ENABLED = "force_update_feature_enabled_prod";
    private final IForceUpdateCoordinator forceUpdateCoordinator;
    private final IForceUpdateRepository forceUpdateRepository;
    private final Moshi moshi;

    @Inject
    public ForceUpdateConfigSynchronizer(IForceUpdateRepository forceUpdateRepository, IForceUpdateCoordinator forceUpdateCoordinator, Moshi moshi) {
        Intrinsics.checkNotNullParameter(forceUpdateRepository, "forceUpdateRepository");
        Intrinsics.checkNotNullParameter(forceUpdateCoordinator, "forceUpdateCoordinator");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.forceUpdateRepository = forceUpdateRepository;
        this.forceUpdateCoordinator = forceUpdateCoordinator;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00ea A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f4, blocks: (B:7:0x0047, B:9:0x0057, B:11:0x009f, B:12:0x00a4, B:14:0x00aa, B:15:0x00b5, B:17:0x00bb, B:18:0x00c4, B:20:0x00cb, B:22:0x00ea), top: B:30:0x0047 }] */
    public final void synchronize(FirebaseRemoteConfig firebaseRemoteConfig) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "firebaseRemoteConfig");
        BoxLogUtils.d(ExtensionsKt.getTAG(this), "Synchronizing Force Update config from Remote Config");
        boolean z = firebaseRemoteConfig.getBoolean(FORCE_UPDATE_FEATURE_ENABLED);
        this.forceUpdateRepository.saveForceUpdateFeatureEnabled(z);
        if (z) {
            String string = firebaseRemoteConfig.getString(FORCE_UPDATE_CONFIG);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (!StringsKt.isBlank(string)) {
                BoxLogUtils.v(ExtensionsKt.getTAG(this), "Parsing Force Update config JSON: " + string);
                try {
                    ForceUpdateConfig forceUpdateConfig = (ForceUpdateConfig) this.moshi.adapter(ForceUpdateConfig.class).fromJson(string);
                    if (forceUpdateConfig != null) {
                        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Parsed config - minVersion: " + forceUpdateConfig.getMinSupportedVersion() + ", unsupportedVersions: " + forceUpdateConfig.getUnsupportedVersions() + ", gqlValidation: " + forceUpdateConfig.getGqlValidationEnabled() + ", gqlAfterMonths: " + forceUpdateConfig.getGqlValidationStartAfterMonths());
                        String minSupportedVersion = forceUpdateConfig.getMinSupportedVersion();
                        if (minSupportedVersion != null) {
                            this.forceUpdateRepository.saveMinSupportedVersion(minSupportedVersion);
                        }
                        List<String> unsupportedVersions = forceUpdateConfig.getUnsupportedVersions();
                        if (unsupportedVersions != null) {
                            this.forceUpdateRepository.saveUnsupportedVersions(CollectionsKt.toSet(unsupportedVersions));
                        }
                        Boolean gqlValidationEnabled = forceUpdateConfig.getGqlValidationEnabled();
                        if (gqlValidationEnabled != null) {
                            this.forceUpdateRepository.saveGQLValidationEnabled(gqlValidationEnabled.booleanValue());
                        }
                        Integer gqlValidationStartAfterMonths = forceUpdateConfig.getGqlValidationStartAfterMonths();
                        Unit unit = null;
                        if (gqlValidationStartAfterMonths != null) {
                            this.forceUpdateRepository.saveGQLValidationAfterMonths(RangesKt.coerceAtMost(gqlValidationStartAfterMonths.intValue(), Integer.MAX_VALUE), BuildConfigProvider.monthsSinceBuild$default(BuildConfigProvider.INSTANCE, 0L, 1, null));
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            BoxLogUtils.w(ExtensionsKt.getTAG(this), "JSON parsed to null config");
                        }
                    } else {
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "JSON parsed to null config");
                    }
                } catch (Exception e) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to parse force_update_config_prod RC payload", e);
                }
            } else {
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "Force Update config JSON is blank, skipping parsing");
            }
        } else {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Force Update feature disabled, skipping JSON config parsing");
        }
        this.forceUpdateCoordinator.onRemoteConfigUpdated();
    }

    /* JADX INFO: compiled from: ForceUpdateConfigSynchronizer.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer$ForceUpdateConfig;", "", "minSupportedVersion", "", "unsupportedVersions", "", "gqlValidationEnabled", "", "gqlValidationStartAfterMonths", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getMinSupportedVersion", "()Ljava/lang/String;", "getUnsupportedVersions", "()Ljava/util/List;", "getGqlValidationEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGqlValidationStartAfterMonths", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer$ForceUpdateConfig;", "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ForceUpdateConfig {
        private final Boolean gqlValidationEnabled;
        private final Integer gqlValidationStartAfterMonths;
        private final String minSupportedVersion;
        private final List<String> unsupportedVersions;

        public ForceUpdateConfig() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ForceUpdateConfig copy$default(ForceUpdateConfig forceUpdateConfig, String str, List list, Boolean bool, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = forceUpdateConfig.minSupportedVersion;
            }
            if ((i & 2) != 0) {
                list = forceUpdateConfig.unsupportedVersions;
            }
            if ((i & 4) != 0) {
                bool = forceUpdateConfig.gqlValidationEnabled;
            }
            if ((i & 8) != 0) {
                num = forceUpdateConfig.gqlValidationStartAfterMonths;
            }
            return forceUpdateConfig.copy(str, list, bool, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMinSupportedVersion() {
            return this.minSupportedVersion;
        }

        public final List<String> component2() {
            return this.unsupportedVersions;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getGqlValidationEnabled() {
            return this.gqlValidationEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getGqlValidationStartAfterMonths() {
            return this.gqlValidationStartAfterMonths;
        }

        public final ForceUpdateConfig copy(@Json(name = "min_supported_version") String minSupportedVersion, @Json(name = "unsupported_versions") List<String> unsupportedVersions, @Json(name = "gql_validation_enabled") Boolean gqlValidationEnabled, @Json(name = "gql_validation_start_after_months") Integer gqlValidationStartAfterMonths) {
            return new ForceUpdateConfig(minSupportedVersion, unsupportedVersions, gqlValidationEnabled, gqlValidationStartAfterMonths);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ForceUpdateConfig)) {
                return false;
            }
            ForceUpdateConfig forceUpdateConfig = (ForceUpdateConfig) other;
            return Intrinsics.areEqual(this.minSupportedVersion, forceUpdateConfig.minSupportedVersion) && Intrinsics.areEqual(this.unsupportedVersions, forceUpdateConfig.unsupportedVersions) && Intrinsics.areEqual(this.gqlValidationEnabled, forceUpdateConfig.gqlValidationEnabled) && Intrinsics.areEqual(this.gqlValidationStartAfterMonths, forceUpdateConfig.gqlValidationStartAfterMonths);
        }

        public int hashCode() {
            String str = this.minSupportedVersion;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<String> list = this.unsupportedVersions;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            Boolean bool = this.gqlValidationEnabled;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Integer num = this.gqlValidationStartAfterMonths;
            return iHashCode3 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            return "ForceUpdateConfig(minSupportedVersion=" + this.minSupportedVersion + ", unsupportedVersions=" + this.unsupportedVersions + ", gqlValidationEnabled=" + this.gqlValidationEnabled + ", gqlValidationStartAfterMonths=" + this.gqlValidationStartAfterMonths + ")";
        }

        public ForceUpdateConfig(@Json(name = "min_supported_version") String str, @Json(name = "unsupported_versions") List<String> list, @Json(name = "gql_validation_enabled") Boolean bool, @Json(name = "gql_validation_start_after_months") Integer num) {
            this.minSupportedVersion = str;
            this.unsupportedVersions = list;
            this.gqlValidationEnabled = bool;
            this.gqlValidationStartAfterMonths = num;
        }

        public /* synthetic */ ForceUpdateConfig(String str, List list, Boolean bool, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : num);
        }

        public final String getMinSupportedVersion() {
            return this.minSupportedVersion;
        }

        public final List<String> getUnsupportedVersions() {
            return this.unsupportedVersions;
        }

        public final Boolean getGqlValidationEnabled() {
            return this.gqlValidationEnabled;
        }

        public final Integer getGqlValidationStartAfterMonths() {
            return this.gqlValidationStartAfterMonths;
        }
    }
}
