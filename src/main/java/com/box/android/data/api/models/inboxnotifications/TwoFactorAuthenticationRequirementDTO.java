package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;", "", "enterpriseHasTwoFactorAuthEnabled", "", "userHasTwoFactorAuthenticationEnabled", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnterpriseHasTwoFactorAuthEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserHasTwoFactorAuthenticationEnabled", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/api/models/inboxnotifications/TwoFactorAuthenticationRequirementDTO;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TwoFactorAuthenticationRequirementDTO {
    private final Boolean enterpriseHasTwoFactorAuthEnabled;
    private final Boolean userHasTwoFactorAuthenticationEnabled;

    public static /* synthetic */ TwoFactorAuthenticationRequirementDTO copy$default(TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirementDTO, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = twoFactorAuthenticationRequirementDTO.enterpriseHasTwoFactorAuthEnabled;
        }
        if ((i & 2) != 0) {
            bool2 = twoFactorAuthenticationRequirementDTO.userHasTwoFactorAuthenticationEnabled;
        }
        return twoFactorAuthenticationRequirementDTO.copy(bool, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getEnterpriseHasTwoFactorAuthEnabled() {
        return this.enterpriseHasTwoFactorAuthEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getUserHasTwoFactorAuthenticationEnabled() {
        return this.userHasTwoFactorAuthenticationEnabled;
    }

    public final TwoFactorAuthenticationRequirementDTO copy(@Json(name = "enterprise_has_two_factor_auth_enabled") Boolean enterpriseHasTwoFactorAuthEnabled, @Json(name = "user_has_two_factor_authentication_enabled") Boolean userHasTwoFactorAuthenticationEnabled) {
        return new TwoFactorAuthenticationRequirementDTO(enterpriseHasTwoFactorAuthEnabled, userHasTwoFactorAuthenticationEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TwoFactorAuthenticationRequirementDTO)) {
            return false;
        }
        TwoFactorAuthenticationRequirementDTO twoFactorAuthenticationRequirementDTO = (TwoFactorAuthenticationRequirementDTO) other;
        return Intrinsics.areEqual(this.enterpriseHasTwoFactorAuthEnabled, twoFactorAuthenticationRequirementDTO.enterpriseHasTwoFactorAuthEnabled) && Intrinsics.areEqual(this.userHasTwoFactorAuthenticationEnabled, twoFactorAuthenticationRequirementDTO.userHasTwoFactorAuthenticationEnabled);
    }

    public int hashCode() {
        Boolean bool = this.enterpriseHasTwoFactorAuthEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.userHasTwoFactorAuthenticationEnabled;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "TwoFactorAuthenticationRequirementDTO(enterpriseHasTwoFactorAuthEnabled=" + this.enterpriseHasTwoFactorAuthEnabled + ", userHasTwoFactorAuthenticationEnabled=" + this.userHasTwoFactorAuthenticationEnabled + ")";
    }

    public TwoFactorAuthenticationRequirementDTO(@Json(name = "enterprise_has_two_factor_auth_enabled") Boolean bool, @Json(name = "user_has_two_factor_authentication_enabled") Boolean bool2) {
        this.enterpriseHasTwoFactorAuthEnabled = bool;
        this.userHasTwoFactorAuthenticationEnabled = bool2;
    }

    public final Boolean getEnterpriseHasTwoFactorAuthEnabled() {
        return this.enterpriseHasTwoFactorAuthEnabled;
    }

    public final Boolean getUserHasTwoFactorAuthenticationEnabled() {
        return this.userHasTwoFactorAuthenticationEnabled;
    }
}
