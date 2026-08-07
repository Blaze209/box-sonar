package com.box.android.data.api.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiGetAnswerDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "", "answer", "", "createdAt", "contextSession", "citations", "", "Lcom/box/android/data/api/models/boxai/AiGetAnswerCitationDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAnswer", "()Ljava/lang/String;", "getCreatedAt", "getContextSession", "getCitations", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiGetAnswerDTO {
    private final String answer;
    private final List<AiGetAnswerCitationDTO> citations;
    private final String contextSession;
    private final String createdAt;

    public AiGetAnswerDTO() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiGetAnswerDTO copy$default(AiGetAnswerDTO aiGetAnswerDTO, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiGetAnswerDTO.answer;
        }
        if ((i & 2) != 0) {
            str2 = aiGetAnswerDTO.createdAt;
        }
        if ((i & 4) != 0) {
            str3 = aiGetAnswerDTO.contextSession;
        }
        if ((i & 8) != 0) {
            list = aiGetAnswerDTO.citations;
        }
        return aiGetAnswerDTO.copy(str, str2, str3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContextSession() {
        return this.contextSession;
    }

    public final List<AiGetAnswerCitationDTO> component4() {
        return this.citations;
    }

    public final AiGetAnswerDTO copy(@Json(name = "answer") String answer, @Json(name = "created_at") String createdAt, @Json(name = "contextSession") String contextSession, @Json(name = "citations") List<AiGetAnswerCitationDTO> citations) {
        Intrinsics.checkNotNullParameter(citations, "citations");
        return new AiGetAnswerDTO(answer, createdAt, contextSession, citations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiGetAnswerDTO)) {
            return false;
        }
        AiGetAnswerDTO aiGetAnswerDTO = (AiGetAnswerDTO) other;
        return Intrinsics.areEqual(this.answer, aiGetAnswerDTO.answer) && Intrinsics.areEqual(this.createdAt, aiGetAnswerDTO.createdAt) && Intrinsics.areEqual(this.contextSession, aiGetAnswerDTO.contextSession) && Intrinsics.areEqual(this.citations, aiGetAnswerDTO.citations);
    }

    public int hashCode() {
        String str = this.answer;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.contextSession;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.citations.hashCode();
    }

    public String toString() {
        return "AiGetAnswerDTO(answer=" + this.answer + ", createdAt=" + this.createdAt + ", contextSession=" + this.contextSession + ", citations=" + this.citations + ")";
    }

    public AiGetAnswerDTO(@Json(name = "answer") String str, @Json(name = "created_at") String str2, @Json(name = "contextSession") String str3, @Json(name = "citations") List<AiGetAnswerCitationDTO> citations) {
        Intrinsics.checkNotNullParameter(citations, "citations");
        this.answer = str;
        this.createdAt = str2;
        this.contextSession = str3;
        this.citations = citations;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getContextSession() {
        return this.contextSession;
    }

    public /* synthetic */ AiGetAnswerDTO(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<AiGetAnswerCitationDTO> getCitations() {
        return this.citations;
    }
}
