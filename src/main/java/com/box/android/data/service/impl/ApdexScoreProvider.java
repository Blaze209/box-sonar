package com.box.android.data.service.impl;

import com.box.android.domain.models.observability.ApdexScore;
import com.box.android.domain.models.observability.DownloadApdex;
import com.box.android.domain.models.observability.FolderNavApdex;
import com.box.android.domain.models.observability.PreviewNavApdex;
import com.box.android.domain.models.observability.RecentsLoadApdex;
import com.box.android.domain.models.observability.RecentsNavApdex;
import com.box.android.domain.models.observability.RootFolderLoadApdex;
import com.box.android.domain.models.observability.RootFolderNavApdex;
import com.box.android.domain.models.observability.UploadApdex;
import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexScoreProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\r¨\u0006!"}, d2 = {"Lcom/box/android/data/service/impl/ApdexScoreProvider;", "Lcom/box/android/domain/services/IApdexScoreProvider;", "remoteConfig", "Lcom/box/android/data/service/impl/RemoteConfig;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/service/impl/RemoteConfig;Lcom/squareup/moshi/Moshi;)V", "apdexConfigurationMap", "", "", "", "getApdexConfigurationMap", "()Ljava/util/Map;", "apdexConfigurationMap$delegate", "Lkotlin/Lazy;", "apdexMagnitudeLimitsMap", "getApdexMagnitudeLimitsMap", "apdexMagnitudeLimitsMap$delegate", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "apdexType", "duration", "magnitude", "secondaryMeasurement", "(Ljava/lang/String;DLjava/lang/Double;Ljava/lang/Double;)Lcom/box/android/domain/models/observability/ApdexScore;", "calculateApdex", "measurement", "threshold", "mapRemoteConfigKey", "key", "parseConfigIntoMap", "jsonString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApdexScoreProvider implements IApdexScoreProvider {

    /* JADX INFO: renamed from: apdexConfigurationMap$delegate, reason: from kotlin metadata */
    private final Lazy apdexConfigurationMap;

    /* JADX INFO: renamed from: apdexMagnitudeLimitsMap$delegate, reason: from kotlin metadata */
    private final Lazy apdexMagnitudeLimitsMap;
    private final Moshi moshi;
    private final RemoteConfig remoteConfig;

    @Inject
    public ApdexScoreProvider(RemoteConfig remoteConfig, Moshi moshi) {
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.remoteConfig = remoteConfig;
        this.moshi = moshi;
        this.apdexConfigurationMap = LazyKt.lazy(new Function0() { // from class: com.box.android.data.service.impl.ApdexScoreProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApdexScoreProvider.apdexConfigurationMap_delegate$lambda$0(this.f$0);
            }
        });
        this.apdexMagnitudeLimitsMap = LazyKt.lazy(new Function0() { // from class: com.box.android.data.service.impl.ApdexScoreProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApdexScoreProvider.apdexMagnitudeLimitsMap_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final Map<String, Double> getApdexConfigurationMap() {
        return (Map) this.apdexConfigurationMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map apdexConfigurationMap_delegate$lambda$0(ApdexScoreProvider apdexScoreProvider) {
        return apdexScoreProvider.parseConfigIntoMap(apdexScoreProvider.remoteConfig.getApdexThresholdsJson());
    }

    private final Map<String, Double> getApdexMagnitudeLimitsMap() {
        return (Map) this.apdexMagnitudeLimitsMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map apdexMagnitudeLimitsMap_delegate$lambda$0(ApdexScoreProvider apdexScoreProvider) {
        return apdexScoreProvider.parseConfigIntoMap(apdexScoreProvider.remoteConfig.getApdexMagnitudeLimitsJson());
    }

    @Override // com.box.android.domain.services.IApdexScoreProvider
    public ApdexScore score(String apdexType, double duration, Double magnitude, Double secondaryMeasurement) {
        Pair pair;
        Intrinsics.checkNotNullParameter(apdexType, "apdexType");
        Double d = getApdexConfigurationMap().get(apdexType + "_secondary");
        Double d2 = getApdexConfigurationMap().get(apdexType);
        if (d2 == null) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Apdex type " + apdexType + " does not have a threshold");
            return null;
        }
        double dDoubleValue = d2.doubleValue();
        Double d3 = getApdexMagnitudeLimitsMap().get(apdexType);
        boolean z = (magnitude == null || d3 == null || magnitude.doubleValue() <= d3.doubleValue()) ? false : true;
        boolean z2 = (secondaryMeasurement == null || d == null) ? false : true;
        if (z && z2) {
            pair = TuplesKt.to(secondaryMeasurement, d);
        } else {
            pair = TuplesKt.to(Double.valueOf(duration), Double.valueOf(dDoubleValue));
        }
        return calculateApdex(((Number) pair.component1()).doubleValue(), ((Number) pair.component2()).doubleValue());
    }

    private final ApdexScore calculateApdex(double measurement, double threshold) {
        if (measurement > ((double) 4) * threshold) {
            return ApdexScore.Zero.INSTANCE;
        }
        if (measurement > threshold) {
            return ApdexScore.Half.INSTANCE;
        }
        return ApdexScore.One.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String mapRemoteConfigKey(String key) {
        switch (key.hashCode()) {
            case -1633407779:
                if (key.equals("root_folder_nav_milli")) {
                    return RootFolderNavApdex.INSTANCE.getName();
                }
                break;
            case -1351250929:
                if (key.equals("upload_milli")) {
                    return UploadApdex.INSTANCE.getName();
                }
                break;
            case -731496056:
                if (key.equals("root_folder_load_milli")) {
                    return RootFolderLoadApdex.INSTANCE.getName();
                }
                break;
            case -532845154:
                if (key.equals("download_size_kb")) {
                    return DownloadApdex.INSTANCE.getName();
                }
                break;
            case -429250025:
                if (key.equals("upload_size_kb")) {
                    return UploadApdex.INSTANCE.getName();
                }
                break;
            case -394069925:
                if (key.equals("recents_load_milli")) {
                    return RecentsLoadApdex.INSTANCE.getName();
                }
                break;
            case 80998125:
                if (key.equals("download_secondary_milli_per_kb")) {
                    return DownloadApdex.INSTANCE.getName() + "_secondary";
                }
                break;
            case 503943508:
                if (key.equals("upload_secondary_milli_per_kb")) {
                    return UploadApdex.INSTANCE.getName() + "_secondary";
                }
                break;
            case 597461498:
                if (key.equals("preview_nav_milli")) {
                    return PreviewNavApdex.INSTANCE.getName();
                }
                break;
            case 981599574:
                if (key.equals("download_milli")) {
                    return DownloadApdex.INSTANCE.getName();
                }
                break;
            case 1700178720:
                if (key.equals("folder_nav_milli")) {
                    return FolderNavApdex.INSTANCE.getName();
                }
                break;
            case 1702612906:
                if (key.equals("recents_nav_milli")) {
                    return RecentsNavApdex.INSTANCE.getName();
                }
                break;
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unknown apdex key: " + key);
        return "unknown";
    }

    private final Map<String, Double> parseConfigIntoMap(String jsonString) {
        try {
            Object objFromJson = this.moshi.adapter(Types.newParameterizedType(Map.class, String.class, Double.class)).fromJson(jsonString);
            Intrinsics.checkNotNull(objFromJson);
            Map map = (Map) objFromJson;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Object obj : map.entrySet()) {
                linkedHashMap.put(mapRemoteConfigKey((String) ((Map.Entry) obj).getKey()), ((Map.Entry) obj).getValue());
            }
            return linkedHashMap;
        } catch (Exception e) {
            BoxLogUtils.e("Invalid JSON format " + e.getMessage() + " " + jsonString);
            return MapsKt.emptyMap();
        }
    }
}
