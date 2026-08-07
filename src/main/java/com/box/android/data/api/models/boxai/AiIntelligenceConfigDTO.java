package com.box.android.data.api.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* JADX INFO: compiled from: AiGetAnswerStreamingRequestDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiIntelligenceConfigDTO;", "", "hasCitationsEnabled", "", "<init>", "(Z)V", "getHasCitationsEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiIntelligenceConfigDTO {
    private final boolean hasCitationsEnabled;

    public static /* synthetic */ AiIntelligenceConfigDTO copy$default(AiIntelligenceConfigDTO aiIntelligenceConfigDTO, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aiIntelligenceConfigDTO.hasCitationsEnabled;
        }
        return aiIntelligenceConfigDTO.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasCitationsEnabled() {
        return this.hasCitationsEnabled;
    }

    public final AiIntelligenceConfigDTO copy(@Json(name = "has_citations_enabled") boolean hasCitationsEnabled) {
        return new AiIntelligenceConfigDTO(hasCitationsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AiIntelligenceConfigDTO) && this.hasCitationsEnabled == ((AiIntelligenceConfigDTO) other).hasCitationsEnabled;
    }

    public int hashCode() {
        return Boolean.hashCode(this.hasCitationsEnabled);
    }

    public String toString() {
        return "AiIntelligenceConfigDTO(hasCitationsEnabled=" + this.hasCitationsEnabled + ")";
    }

    public AiIntelligenceConfigDTO(@Json(name = "has_citations_enabled") boolean z) {
        this.hasCitationsEnabled = z;
    }

    public final boolean getHasCitationsEnabled() {
        return this.hasCitationsEnabled;
    }
}
