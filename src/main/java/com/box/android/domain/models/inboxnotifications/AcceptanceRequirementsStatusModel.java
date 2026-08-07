package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementsStatusModel;", "Lcom/box/android/domain/models/DomainModel;", "termsOfServiceRequirement", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "strongPasswordRequirement", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;", "twoFactorAuthenticationRequirement", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;)V", "getTermsOfServiceRequirement", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "getStrongPasswordRequirement", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;", "getTwoFactorAuthenticationRequirement", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "getPriorityPendingRequirement", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AcceptanceRequirementsStatusModel implements DomainModel {
    private final AcceptanceRequirementType.StrongPassword strongPasswordRequirement;
    private final AcceptanceRequirementType.TermsOfService termsOfServiceRequirement;
    private final AcceptanceRequirementType.MFA twoFactorAuthenticationRequirement;

    public static /* synthetic */ AcceptanceRequirementsStatusModel copy$default(AcceptanceRequirementsStatusModel acceptanceRequirementsStatusModel, AcceptanceRequirementType.TermsOfService termsOfService, AcceptanceRequirementType.StrongPassword strongPassword, AcceptanceRequirementType.MFA mfa, int i, Object obj) {
        if ((i & 1) != 0) {
            termsOfService = acceptanceRequirementsStatusModel.termsOfServiceRequirement;
        }
        if ((i & 2) != 0) {
            strongPassword = acceptanceRequirementsStatusModel.strongPasswordRequirement;
        }
        if ((i & 4) != 0) {
            mfa = acceptanceRequirementsStatusModel.twoFactorAuthenticationRequirement;
        }
        return acceptanceRequirementsStatusModel.copy(termsOfService, strongPassword, mfa);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AcceptanceRequirementType.TermsOfService getTermsOfServiceRequirement() {
        return this.termsOfServiceRequirement;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AcceptanceRequirementType.StrongPassword getStrongPasswordRequirement() {
        return this.strongPasswordRequirement;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AcceptanceRequirementType.MFA getTwoFactorAuthenticationRequirement() {
        return this.twoFactorAuthenticationRequirement;
    }

    public final AcceptanceRequirementsStatusModel copy(AcceptanceRequirementType.TermsOfService termsOfServiceRequirement, AcceptanceRequirementType.StrongPassword strongPasswordRequirement, AcceptanceRequirementType.MFA twoFactorAuthenticationRequirement) {
        Intrinsics.checkNotNullParameter(termsOfServiceRequirement, "termsOfServiceRequirement");
        Intrinsics.checkNotNullParameter(strongPasswordRequirement, "strongPasswordRequirement");
        Intrinsics.checkNotNullParameter(twoFactorAuthenticationRequirement, "twoFactorAuthenticationRequirement");
        return new AcceptanceRequirementsStatusModel(termsOfServiceRequirement, strongPasswordRequirement, twoFactorAuthenticationRequirement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AcceptanceRequirementsStatusModel)) {
            return false;
        }
        AcceptanceRequirementsStatusModel acceptanceRequirementsStatusModel = (AcceptanceRequirementsStatusModel) other;
        return Intrinsics.areEqual(this.termsOfServiceRequirement, acceptanceRequirementsStatusModel.termsOfServiceRequirement) && Intrinsics.areEqual(this.strongPasswordRequirement, acceptanceRequirementsStatusModel.strongPasswordRequirement) && Intrinsics.areEqual(this.twoFactorAuthenticationRequirement, acceptanceRequirementsStatusModel.twoFactorAuthenticationRequirement);
    }

    public int hashCode() {
        return (((this.termsOfServiceRequirement.hashCode() * 31) + this.strongPasswordRequirement.hashCode()) * 31) + this.twoFactorAuthenticationRequirement.hashCode();
    }

    public String toString() {
        return "AcceptanceRequirementsStatusModel(termsOfServiceRequirement=" + this.termsOfServiceRequirement + ", strongPasswordRequirement=" + this.strongPasswordRequirement + ", twoFactorAuthenticationRequirement=" + this.twoFactorAuthenticationRequirement + ")";
    }

    public AcceptanceRequirementsStatusModel(AcceptanceRequirementType.TermsOfService termsOfServiceRequirement, AcceptanceRequirementType.StrongPassword strongPasswordRequirement, AcceptanceRequirementType.MFA twoFactorAuthenticationRequirement) {
        Intrinsics.checkNotNullParameter(termsOfServiceRequirement, "termsOfServiceRequirement");
        Intrinsics.checkNotNullParameter(strongPasswordRequirement, "strongPasswordRequirement");
        Intrinsics.checkNotNullParameter(twoFactorAuthenticationRequirement, "twoFactorAuthenticationRequirement");
        this.termsOfServiceRequirement = termsOfServiceRequirement;
        this.strongPasswordRequirement = strongPasswordRequirement;
        this.twoFactorAuthenticationRequirement = twoFactorAuthenticationRequirement;
    }

    public final AcceptanceRequirementType.TermsOfService getTermsOfServiceRequirement() {
        return this.termsOfServiceRequirement;
    }

    public final AcceptanceRequirementType.StrongPassword getStrongPasswordRequirement() {
        return this.strongPasswordRequirement;
    }

    public final AcceptanceRequirementType.MFA getTwoFactorAuthenticationRequirement() {
        return this.twoFactorAuthenticationRequirement;
    }

    public final AcceptanceRequirementType getPriorityPendingRequirement() {
        Object next;
        Iterator it = CollectionsKt.listOf((Object[]) new AcceptanceRequirementType[]{this.termsOfServiceRequirement, this.twoFactorAuthenticationRequirement, this.strongPasswordRequirement}).iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((AcceptanceRequirementType) next).isPending()) {
                return (AcceptanceRequirementType) next;
            }
        }
        next = null;
        return (AcceptanceRequirementType) next;
    }
}
