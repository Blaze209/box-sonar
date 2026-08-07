package com.box.android.domain.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiAnswerModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/boxai/AiCitationModel;", "Lcom/box/android/domain/models/DomainModel;", FirebaseAnalytics.Param.LOCATION, "", "content", "", "docId", "docName", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "()Ljava/lang/String;", "getDocId", "getDocName", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/domain/models/boxai/AiCitationModel;", "equals", "", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiCitationModel implements DomainModel {
    private final String content;
    private final String docId;
    private final String docName;
    private final Integer location;

    public static /* synthetic */ AiCitationModel copy$default(AiCitationModel aiCitationModel, Integer num, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = aiCitationModel.location;
        }
        if ((i & 2) != 0) {
            str = aiCitationModel.content;
        }
        if ((i & 4) != 0) {
            str2 = aiCitationModel.docId;
        }
        if ((i & 8) != 0) {
            str3 = aiCitationModel.docName;
        }
        return aiCitationModel.copy(num, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getLocation() {
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

    public final AiCitationModel copy(Integer location, String content, String docId, String docName) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(docName, "docName");
        return new AiCitationModel(location, content, docId, docName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiCitationModel)) {
            return false;
        }
        AiCitationModel aiCitationModel = (AiCitationModel) other;
        return Intrinsics.areEqual(this.location, aiCitationModel.location) && Intrinsics.areEqual(this.content, aiCitationModel.content) && Intrinsics.areEqual(this.docId, aiCitationModel.docId) && Intrinsics.areEqual(this.docName, aiCitationModel.docName);
    }

    public int hashCode() {
        Integer num = this.location;
        return ((((((num == null ? 0 : num.hashCode()) * 31) + this.content.hashCode()) * 31) + this.docId.hashCode()) * 31) + this.docName.hashCode();
    }

    public String toString() {
        return "AiCitationModel(location=" + this.location + ", content=" + this.content + ", docId=" + this.docId + ", docName=" + this.docName + ")";
    }

    public AiCitationModel(Integer num, String content, String docId, String docName) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(docId, "docId");
        Intrinsics.checkNotNullParameter(docName, "docName");
        this.location = num;
        this.content = content;
        this.docId = docId;
        this.docName = docName;
    }

    public final Integer getLocation() {
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
