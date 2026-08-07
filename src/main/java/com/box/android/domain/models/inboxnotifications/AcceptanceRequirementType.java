package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "Lcom/box/android/domain/models/DomainModel;", "<init>", "()V", "isPending", "", "TermsOfService", "MFA", "StrongPassword", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AcceptanceRequirementType implements DomainModel {
    public /* synthetic */ AcceptanceRequirementType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean isPending();

    private AcceptanceRequirementType() {
    }

    /* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "isAccepted", "", BoxAnalyticsParams.ACTION_TERMS_OF_SERVICE, "Lcom/box/android/domain/models/inboxnotifications/TermsOfServiceModel;", "<init>", "(Ljava/lang/Boolean;Lcom/box/android/domain/models/inboxnotifications/TermsOfServiceModel;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTermsOfService", "()Lcom/box/android/domain/models/inboxnotifications/TermsOfServiceModel;", "isPending", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Lcom/box/android/domain/models/inboxnotifications/TermsOfServiceModel;)Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$TermsOfService;", "equals", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TermsOfService extends AcceptanceRequirementType {
        private final Boolean isAccepted;
        private final TermsOfServiceModel termsOfService;

        public static /* synthetic */ TermsOfService copy$default(TermsOfService termsOfService, Boolean bool, TermsOfServiceModel termsOfServiceModel, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = termsOfService.isAccepted;
            }
            if ((i & 2) != 0) {
                termsOfServiceModel = termsOfService.termsOfService;
            }
            return termsOfService.copy(bool, termsOfServiceModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsAccepted() {
            return this.isAccepted;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TermsOfServiceModel getTermsOfService() {
            return this.termsOfService;
        }

        public final TermsOfService copy(Boolean isAccepted, TermsOfServiceModel termsOfService) {
            return new TermsOfService(isAccepted, termsOfService);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TermsOfService)) {
                return false;
            }
            TermsOfService termsOfService = (TermsOfService) other;
            return Intrinsics.areEqual(this.isAccepted, termsOfService.isAccepted) && Intrinsics.areEqual(this.termsOfService, termsOfService.termsOfService);
        }

        public int hashCode() {
            Boolean bool = this.isAccepted;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            TermsOfServiceModel termsOfServiceModel = this.termsOfService;
            return iHashCode + (termsOfServiceModel != null ? termsOfServiceModel.hashCode() : 0);
        }

        public String toString() {
            return "TermsOfService(isAccepted=" + this.isAccepted + ", termsOfService=" + this.termsOfService + ")";
        }

        public TermsOfService(Boolean bool, TermsOfServiceModel termsOfServiceModel) {
            super(null);
            this.isAccepted = bool;
            this.termsOfService = termsOfServiceModel;
        }

        public final TermsOfServiceModel getTermsOfService() {
            return this.termsOfService;
        }

        public final Boolean isAccepted() {
            return this.isAccepted;
        }

        @Override // com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType
        public boolean isPending() {
            Boolean bool = this.isAccepted;
            return (this.termsOfService == null || (bool != null ? bool.booleanValue() : false)) ? false : true;
        }
    }

    /* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "enterpriseHasTwoFactorAuthEnabled", "", "userHasTwoFactorAuthenticationEnabled", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnterpriseHasTwoFactorAuthEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserHasTwoFactorAuthenticationEnabled", "isPending", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$MFA;", "equals", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MFA extends AcceptanceRequirementType {
        private final Boolean enterpriseHasTwoFactorAuthEnabled;
        private final Boolean userHasTwoFactorAuthenticationEnabled;

        public static /* synthetic */ MFA copy$default(MFA mfa, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = mfa.enterpriseHasTwoFactorAuthEnabled;
            }
            if ((i & 2) != 0) {
                bool2 = mfa.userHasTwoFactorAuthenticationEnabled;
            }
            return mfa.copy(bool, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getEnterpriseHasTwoFactorAuthEnabled() {
            return this.enterpriseHasTwoFactorAuthEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getUserHasTwoFactorAuthenticationEnabled() {
            return this.userHasTwoFactorAuthenticationEnabled;
        }

        public final MFA copy(Boolean enterpriseHasTwoFactorAuthEnabled, Boolean userHasTwoFactorAuthenticationEnabled) {
            return new MFA(enterpriseHasTwoFactorAuthEnabled, userHasTwoFactorAuthenticationEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MFA)) {
                return false;
            }
            MFA mfa = (MFA) other;
            return Intrinsics.areEqual(this.enterpriseHasTwoFactorAuthEnabled, mfa.enterpriseHasTwoFactorAuthEnabled) && Intrinsics.areEqual(this.userHasTwoFactorAuthenticationEnabled, mfa.userHasTwoFactorAuthenticationEnabled);
        }

        public int hashCode() {
            Boolean bool = this.enterpriseHasTwoFactorAuthEnabled;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.userHasTwoFactorAuthenticationEnabled;
            return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "MFA(enterpriseHasTwoFactorAuthEnabled=" + this.enterpriseHasTwoFactorAuthEnabled + ", userHasTwoFactorAuthenticationEnabled=" + this.userHasTwoFactorAuthenticationEnabled + ")";
        }

        public MFA(Boolean bool, Boolean bool2) {
            super(null);
            this.enterpriseHasTwoFactorAuthEnabled = bool;
            this.userHasTwoFactorAuthenticationEnabled = bool2;
        }

        public final Boolean getEnterpriseHasTwoFactorAuthEnabled() {
            return this.enterpriseHasTwoFactorAuthEnabled;
        }

        public final Boolean getUserHasTwoFactorAuthenticationEnabled() {
            return this.userHasTwoFactorAuthenticationEnabled;
        }

        @Override // com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType
        public boolean isPending() {
            Boolean bool = this.enterpriseHasTwoFactorAuthEnabled;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = this.userHasTwoFactorAuthenticationEnabled;
            return zBooleanValue && !(bool2 != null ? bool2.booleanValue() : false);
        }
    }

    /* JADX INFO: compiled from: InboxNotificationCollaborationModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "enterpriseHasStrongPasswordRequiredForExternalUsers", "", "userHasStrongPassword", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnterpriseHasStrongPasswordRequiredForExternalUsers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserHasStrongPassword", "isPending", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType$StrongPassword;", "equals", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StrongPassword extends AcceptanceRequirementType {
        private final Boolean enterpriseHasStrongPasswordRequiredForExternalUsers;
        private final Boolean userHasStrongPassword;

        public static /* synthetic */ StrongPassword copy$default(StrongPassword strongPassword, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = strongPassword.enterpriseHasStrongPasswordRequiredForExternalUsers;
            }
            if ((i & 2) != 0) {
                bool2 = strongPassword.userHasStrongPassword;
            }
            return strongPassword.copy(bool, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getEnterpriseHasStrongPasswordRequiredForExternalUsers() {
            return this.enterpriseHasStrongPasswordRequiredForExternalUsers;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getUserHasStrongPassword() {
            return this.userHasStrongPassword;
        }

        public final StrongPassword copy(Boolean enterpriseHasStrongPasswordRequiredForExternalUsers, Boolean userHasStrongPassword) {
            return new StrongPassword(enterpriseHasStrongPasswordRequiredForExternalUsers, userHasStrongPassword);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StrongPassword)) {
                return false;
            }
            StrongPassword strongPassword = (StrongPassword) other;
            return Intrinsics.areEqual(this.enterpriseHasStrongPasswordRequiredForExternalUsers, strongPassword.enterpriseHasStrongPasswordRequiredForExternalUsers) && Intrinsics.areEqual(this.userHasStrongPassword, strongPassword.userHasStrongPassword);
        }

        public int hashCode() {
            Boolean bool = this.enterpriseHasStrongPasswordRequiredForExternalUsers;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.userHasStrongPassword;
            return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "StrongPassword(enterpriseHasStrongPasswordRequiredForExternalUsers=" + this.enterpriseHasStrongPasswordRequiredForExternalUsers + ", userHasStrongPassword=" + this.userHasStrongPassword + ")";
        }

        public StrongPassword(Boolean bool, Boolean bool2) {
            super(null);
            this.enterpriseHasStrongPasswordRequiredForExternalUsers = bool;
            this.userHasStrongPassword = bool2;
        }

        public final Boolean getEnterpriseHasStrongPasswordRequiredForExternalUsers() {
            return this.enterpriseHasStrongPasswordRequiredForExternalUsers;
        }

        public final Boolean getUserHasStrongPassword() {
            return this.userHasStrongPassword;
        }

        @Override // com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType
        public boolean isPending() {
            Boolean bool = this.enterpriseHasStrongPasswordRequiredForExternalUsers;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = this.userHasStrongPassword;
            return zBooleanValue && !(bool2 != null ? bool2.booleanValue() : false);
        }
    }
}
