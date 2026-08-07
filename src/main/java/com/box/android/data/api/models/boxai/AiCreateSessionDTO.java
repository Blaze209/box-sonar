package com.box.android.data.api.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiCreateSessionDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiCreateSessionDTO;", "", "metadataDTO", "Lcom/box/android/data/api/models/boxai/AiCreateSessionMetadataDTO;", "encodedSession", "", "<init>", "(Lcom/box/android/data/api/models/boxai/AiCreateSessionMetadataDTO;Ljava/lang/String;)V", "getMetadataDTO", "()Lcom/box/android/data/api/models/boxai/AiCreateSessionMetadataDTO;", "getEncodedSession", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiCreateSessionDTO {
    private final String encodedSession;
    private final AiCreateSessionMetadataDTO metadataDTO;

    public static /* synthetic */ AiCreateSessionDTO copy$default(AiCreateSessionDTO aiCreateSessionDTO, AiCreateSessionMetadataDTO aiCreateSessionMetadataDTO, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            aiCreateSessionMetadataDTO = aiCreateSessionDTO.metadataDTO;
        }
        if ((i & 2) != 0) {
            str = aiCreateSessionDTO.encodedSession;
        }
        return aiCreateSessionDTO.copy(aiCreateSessionMetadataDTO, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AiCreateSessionMetadataDTO getMetadataDTO() {
        return this.metadataDTO;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEncodedSession() {
        return this.encodedSession;
    }

    public final AiCreateSessionDTO copy(@Json(name = "metadata") AiCreateSessionMetadataDTO metadataDTO, @Json(name = "encoded_session") String encodedSession) {
        Intrinsics.checkNotNullParameter(metadataDTO, "metadataDTO");
        Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
        return new AiCreateSessionDTO(metadataDTO, encodedSession);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiCreateSessionDTO)) {
            return false;
        }
        AiCreateSessionDTO aiCreateSessionDTO = (AiCreateSessionDTO) other;
        return Intrinsics.areEqual(this.metadataDTO, aiCreateSessionDTO.metadataDTO) && Intrinsics.areEqual(this.encodedSession, aiCreateSessionDTO.encodedSession);
    }

    public int hashCode() {
        return (this.metadataDTO.hashCode() * 31) + this.encodedSession.hashCode();
    }

    public String toString() {
        return "AiCreateSessionDTO(metadataDTO=" + this.metadataDTO + ", encodedSession=" + this.encodedSession + ")";
    }

    public AiCreateSessionDTO(@Json(name = "metadata") AiCreateSessionMetadataDTO metadataDTO, @Json(name = "encoded_session") String encodedSession) {
        Intrinsics.checkNotNullParameter(metadataDTO, "metadataDTO");
        Intrinsics.checkNotNullParameter(encodedSession, "encodedSession");
        this.metadataDTO = metadataDTO;
        this.encodedSession = encodedSession;
    }

    public final AiCreateSessionMetadataDTO getMetadataDTO() {
        return this.metadataDTO;
    }

    public final String getEncodedSession() {
        return this.encodedSession;
    }
}
