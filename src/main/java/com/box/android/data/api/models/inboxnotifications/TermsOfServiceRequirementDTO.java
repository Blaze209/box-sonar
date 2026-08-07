package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;", "", "isAccepted", "", BoxAnalyticsParams.ACTION_TERMS_OF_SERVICE, "Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceDTO;", "<init>", "(Ljava/lang/Boolean;Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceDTO;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTermsOfService", "()Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceDTO;)Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TermsOfServiceRequirementDTO {
    private final Boolean isAccepted;
    private final TermsOfServiceDTO termsOfService;

    public static /* synthetic */ TermsOfServiceRequirementDTO copy$default(TermsOfServiceRequirementDTO termsOfServiceRequirementDTO, Boolean bool, TermsOfServiceDTO termsOfServiceDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = termsOfServiceRequirementDTO.isAccepted;
        }
        if ((i & 2) != 0) {
            termsOfServiceDTO = termsOfServiceRequirementDTO.termsOfService;
        }
        return termsOfServiceRequirementDTO.copy(bool, termsOfServiceDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getIsAccepted() {
        return this.isAccepted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TermsOfServiceDTO getTermsOfService() {
        return this.termsOfService;
    }

    public final TermsOfServiceRequirementDTO copy(@Json(name = "is_accepted") Boolean isAccepted, @Json(name = "terms_of_service") TermsOfServiceDTO termsOfService) {
        return new TermsOfServiceRequirementDTO(isAccepted, termsOfService);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TermsOfServiceRequirementDTO)) {
            return false;
        }
        TermsOfServiceRequirementDTO termsOfServiceRequirementDTO = (TermsOfServiceRequirementDTO) other;
        return Intrinsics.areEqual(this.isAccepted, termsOfServiceRequirementDTO.isAccepted) && Intrinsics.areEqual(this.termsOfService, termsOfServiceRequirementDTO.termsOfService);
    }

    public int hashCode() {
        Boolean bool = this.isAccepted;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        TermsOfServiceDTO termsOfServiceDTO = this.termsOfService;
        return iHashCode + (termsOfServiceDTO != null ? termsOfServiceDTO.hashCode() : 0);
    }

    public String toString() {
        return "TermsOfServiceRequirementDTO(isAccepted=" + this.isAccepted + ", termsOfService=" + this.termsOfService + ")";
    }

    public TermsOfServiceRequirementDTO(@Json(name = "is_accepted") Boolean bool, @Json(name = "terms_of_service") TermsOfServiceDTO termsOfServiceDTO) {
        this.isAccepted = bool;
        this.termsOfService = termsOfServiceDTO;
    }

    public final Boolean isAccepted() {
        return this.isAccepted;
    }

    public final TermsOfServiceDTO getTermsOfService() {
        return this.termsOfService;
    }
}
