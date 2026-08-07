package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/AcceptanceRequirementsStatusDTO;", "", "termsOfServiceRequirement", "Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;", "strongPasswordRequirement", "Lcom/box/android/data/api/models/inboxnotifications/StrongPasswordRequirementDTO;", "twoFactorAuthenticationRequirement", "Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;", "<init>", "(Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;Lcom/box/android/data/api/models/inboxnotifications/StrongPasswordRequirementDTO;Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;)V", "getTermsOfServiceRequirement", "()Lcom/box/android/data/api/models/inboxnotifications/TermsOfServiceRequirementDTO;", "getStrongPasswordRequirement", "()Lcom/box/android/data/api/models/inboxnotifications/StrongPasswordRequirementDTO;", "getTwoFactorAuthenticationRequirement", "()Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AcceptanceRequirementsStatusDTO {
    private final StrongPasswordRequirementDTO strongPasswordRequirement;
    private final TermsOfServiceRequirementDTO termsOfServiceRequirement;
    private final TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirement;

    public static /* synthetic */ AcceptanceRequirementsStatusDTO copy$default(AcceptanceRequirementsStatusDTO acceptanceRequirementsStatusDTO, TermsOfServiceRequirementDTO termsOfServiceRequirementDTO, StrongPasswordRequirementDTO strongPasswordRequirementDTO, TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirementDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            termsOfServiceRequirementDTO = acceptanceRequirementsStatusDTO.termsOfServiceRequirement;
        }
        if ((i & 2) != 0) {
            strongPasswordRequirementDTO = acceptanceRequirementsStatusDTO.strongPasswordRequirement;
        }
        if ((i & 4) != 0) {
            twoFactorAuthenticationRequirementDTO = acceptanceRequirementsStatusDTO.twoFactorAuthenticationRequirement;
        }
        return acceptanceRequirementsStatusDTO.copy(termsOfServiceRequirementDTO, strongPasswordRequirementDTO, twoFactorAuthenticationRequirementDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TermsOfServiceRequirementDTO getTermsOfServiceRequirement() {
        return this.termsOfServiceRequirement;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StrongPasswordRequirementDTO getStrongPasswordRequirement() {
        return this.strongPasswordRequirement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TwoFactorAuthenticationRequirementDTO getTwoFactorAuthenticationRequirement() {
        return this.twoFactorAuthenticationRequirement;
    }

    public final AcceptanceRequirementsStatusDTO copy(@Json(name = "terms_of_service_requirement") TermsOfServiceRequirementDTO termsOfServiceRequirement, @Json(name = "strong_password_requirement") StrongPasswordRequirementDTO strongPasswordRequirement, @Json(name = "two_factor_authentication_requirement") TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirement) {
        Intrinsics.checkNotNullParameter(termsOfServiceRequirement, "termsOfServiceRequirement");
        Intrinsics.checkNotNullParameter(strongPasswordRequirement, "strongPasswordRequirement");
        Intrinsics.checkNotNullParameter(twoFactorAuthenticationRequirement, "twoFactorAuthenticationRequirement");
        return new AcceptanceRequirementsStatusDTO(termsOfServiceRequirement, strongPasswordRequirement, twoFactorAuthenticationRequirement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AcceptanceRequirementsStatusDTO)) {
            return false;
        }
        AcceptanceRequirementsStatusDTO acceptanceRequirementsStatusDTO = (AcceptanceRequirementsStatusDTO) other;
        return Intrinsics.areEqual(this.termsOfServiceRequirement, acceptanceRequirementsStatusDTO.termsOfServiceRequirement) && Intrinsics.areEqual(this.strongPasswordRequirement, acceptanceRequirementsStatusDTO.strongPasswordRequirement) && Intrinsics.areEqual(this.twoFactorAuthenticationRequirement, acceptanceRequirementsStatusDTO.twoFactorAuthenticationRequirement);
    }

    public int hashCode() {
        return (((this.termsOfServiceRequirement.hashCode() * 31) + this.strongPasswordRequirement.hashCode()) * 31) + this.twoFactorAuthenticationRequirement.hashCode();
    }

    public String toString() {
        return "AcceptanceRequirementsStatusDTO(termsOfServiceRequirement=" + this.termsOfServiceRequirement + ", strongPasswordRequirement=" + this.strongPasswordRequirement + ", twoFactorAuthenticationRequirement=" + this.twoFactorAuthenticationRequirement + ")";
    }

    public AcceptanceRequirementsStatusDTO(@Json(name = "terms_of_service_requirement") TermsOfServiceRequirementDTO termsOfServiceRequirement, @Json(name = "strong_password_requirement") StrongPasswordRequirementDTO strongPasswordRequirement, @Json(name = "two_factor_authentication_requirement") TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirement) {
        Intrinsics.checkNotNullParameter(termsOfServiceRequirement, "termsOfServiceRequirement");
        Intrinsics.checkNotNullParameter(strongPasswordRequirement, "strongPasswordRequirement");
        Intrinsics.checkNotNullParameter(twoFactorAuthenticationRequirement, "twoFactorAuthenticationRequirement");
        this.termsOfServiceRequirement = termsOfServiceRequirement;
        this.strongPasswordRequirement = strongPasswordRequirement;
        this.twoFactorAuthenticationRequirement = twoFactorAuthenticationRequirement;
    }

    public final TermsOfServiceRequirementDTO getTermsOfServiceRequirement() {
        return this.termsOfServiceRequirement;
    }

    public final StrongPasswordRequirementDTO getStrongPasswordRequirement() {
        return this.strongPasswordRequirement;
    }

    public final TwoFactorAuthenticationRequirementDTO getTwoFactorAuthenticationRequirement() {
        return this.twoFactorAuthenticationRequirement;
    }
}
