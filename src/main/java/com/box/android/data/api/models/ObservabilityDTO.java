package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.dao.BoxObservability;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/models/ObservabilityDTO;", "", "rumProxyUrl", "", "rumSamplingRatio", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;)V", "getRumProxyUrl", "()Ljava/lang/String;", "getRumSamplingRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Double;)Lcom/box/android/data/api/models/ObservabilityDTO;", "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ObservabilityDTO {
    private final String rumProxyUrl;
    private final Double rumSamplingRatio;

    /* JADX WARN: Multi-variable type inference failed */
    public ObservabilityDTO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObservabilityDTO copy$default(ObservabilityDTO observabilityDTO, String str, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = observabilityDTO.rumProxyUrl;
        }
        if ((i & 2) != 0) {
            d = observabilityDTO.rumSamplingRatio;
        }
        return observabilityDTO.copy(str, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRumProxyUrl() {
        return this.rumProxyUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getRumSamplingRatio() {
        return this.rumSamplingRatio;
    }

    public final ObservabilityDTO copy(@Json(name = BoxObservability.RUM_PROXY_URL) String rumProxyUrl, @Json(name = BoxObservability.RUM_SAMPLING_RATIO) Double rumSamplingRatio) {
        return new ObservabilityDTO(rumProxyUrl, rumSamplingRatio);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObservabilityDTO)) {
            return false;
        }
        ObservabilityDTO observabilityDTO = (ObservabilityDTO) other;
        return Intrinsics.areEqual(this.rumProxyUrl, observabilityDTO.rumProxyUrl) && Intrinsics.areEqual((Object) this.rumSamplingRatio, (Object) observabilityDTO.rumSamplingRatio);
    }

    public int hashCode() {
        String str = this.rumProxyUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.rumSamplingRatio;
        return iHashCode + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "ObservabilityDTO(rumProxyUrl=" + this.rumProxyUrl + ", rumSamplingRatio=" + this.rumSamplingRatio + ")";
    }

    public ObservabilityDTO(@Json(name = BoxObservability.RUM_PROXY_URL) String str, @Json(name = BoxObservability.RUM_SAMPLING_RATIO) Double d) {
        this.rumProxyUrl = str;
        this.rumSamplingRatio = d;
    }

    public /* synthetic */ ObservabilityDTO(String str, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d);
    }

    public final String getRumProxyUrl() {
        return this.rumProxyUrl;
    }

    public final Double getRumSamplingRatio() {
        return this.rumSamplingRatio;
    }
}
