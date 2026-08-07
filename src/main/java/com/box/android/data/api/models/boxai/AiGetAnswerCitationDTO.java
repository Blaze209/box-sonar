package com.box.android.data.api.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiGetAnswerDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiGetAnswerCitationDTO;", "", FirebaseAnalytics.Param.LOCATION, "", "content", "docId", "docName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "getContent", "getDocId", "getDocName", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiGetAnswerCitationDTO {
    private final String content;
    private final String docId;
    private final String docName;
    private final String location;

    public static /* synthetic */ AiGetAnswerCitationDTO copy$default(AiGetAnswerCitationDTO aiGetAnswerCitationDTO, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiGetAnswerCitationDTO.location;
        }
        if ((i & 2) != 0) {
            str2 = aiGetAnswerCitationDTO.content;
        }
        if ((i & 4) != 0) {
            str3 = aiGetAnswerCitationDTO.docId;
        }
        if ((i & 8) != 0) {
            str4 = aiGetAnswerCitationDTO.docName;
        }
        return aiGetAnswerCitationDTO.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDocName() {
        return this.docName;
    }

    public final AiGetAnswerCitationDTO copy(@Json(name = "cited_text_location") String location, @Json(name = "cited_text_content") String content, @Json(name = "cited_doc_id") String docId, @Json(name = "cited_doc_name") String docName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(docName, "docName");
        return new AiGetAnswerCitationDTO(location, content, docId, docName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiGetAnswerCitationDTO)) {
            return false;
        }
        AiGetAnswerCitationDTO aiGetAnswerCitationDTO = (AiGetAnswerCitationDTO) other;
        return Intrinsics.areEqual(this.location, aiGetAnswerCitationDTO.location) && Intrinsics.areEqual(this.content, aiGetAnswerCitationDTO.content) && Intrinsics.areEqual(this.docId, aiGetAnswerCitationDTO.docId) && Intrinsics.areEqual(this.docName, aiGetAnswerCitationDTO.docName);
    }

    public int hashCode() {
        return (((((this.location.hashCode() * 31) + this.content.hashCode()) * 31) + this.docId.hashCode()) * 31) + this.docName.hashCode();
    }

    public String toString() {
        return "AiGetAnswerCitationDTO(location=" + this.location + ", content=" + this.content + ", docId=" + this.docId + ", docName=" + this.docName + ")";
    }

    public AiGetAnswerCitationDTO(@Json(name = "cited_text_location") String location, @Json(name = "cited_text_content") String content, @Json(name = "cited_doc_id") String docId, @Json(name = "cited_doc_name") String docName) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(docName, "docName");
        this.location = location;
        this.content = content;
        this.docId = docId;
        this.docName = docName;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final String getDocName() {
        return this.docName;
    }
}
