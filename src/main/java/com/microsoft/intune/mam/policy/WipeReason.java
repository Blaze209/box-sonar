package com.microsoft.intune.mam.policy;

/* JADX INFO: loaded from: classes3.dex */
public enum WipeReason {
    PIN_MAX_RETRIES_EXCEEDED("adminPolicyMaxPinAttempts"),
    DEVICE_NON_COMPLIANT("adminPolicyJB"),
    APP_OUTDATED("adminPolicyMinApp"),
    OS_OUTDATED("adminPolicyMinOs"),
    OS_GREATER_THAN_MAX("adminPolicyMaxOs"),
    OS_PATCH_OUTDATED("adminPolicyMinPatch"),
    CP_OUTDATED("adminPolicyMinCP"),
    CP_FRESHNESS("adminPolicyMinCPFreshness"),
    UNSUPPORTED_DEVICE("adminPolicyDevice"),
    UNSUPPORTED_DEVICE_MANUFACTURER("adminPolicyDeviceManufacturer"),
    UNSUPPORTED_DEVICE_MODEL("adminPolicyDeviceModel"),
    SERVICE_WIPE("adminRemoteWipe"),
    COMPANY_PORTAL_REMOVED(null),
    POLICY_REMOVED(null),
    POLICY_REMOVED_APP_UNSTABLE(null),
    APP_UNENROLLMENT("userSignedOutWipe"),
    USER_REMOVED_ACCOUNT_AFTER_BLOCK("userSignedOutWipe"),
    USER_REMOVED_ACCOUNT_AFTER_POLICY_REQUIRED("userSignedOutWipe"),
    RE_ENROLLMENT_FAILED(null),
    MISMATCHED_IDENTITIES("mdmDifferentUserWipe"),
    WRONG_USER("userChooseAccountMAMWipe"),
    PORTAL_UNENROLLMENT("mdmUnenrollWipe"),
    DEVICE_ATTESTATION_NON_COMPLIANT("adminPolicySafetyNet"),
    ALLOWED_ACCOUNTS_NOT_ALLOWED("userAccountNotAllowed"),
    NETWORK_CONNECTIVITY_REQUIRED("adminPolicyOfflineWipe"),
    MTD_NON_COMPLIANT("adminPolicyMTD"),
    USER_ACCOUNT_DISABLED("userAccountDisabled"),
    DEVICE_LOCK_MISSING("deviceLockMissing"),
    SHARED_DEVICE_GLOBAL_SIGN_OUT("sharedDeviceGlobalSignOut"),
    DEVICE_LOCK_COMPLEXITY_CHECK_FAILED("deviceLockComplexityRequired"),
    KNOX_ATESTATION_FAILED("knoxAttestationFailed");

    private String mReasonTag;

    WipeReason(String str) {
        this.mReasonTag = str;
    }

    public String getServiceTag() {
        return this.mReasonTag;
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.policy.WipeReason$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$policy$WipeReason;

        static {
            int[] iArr = new int[WipeReason.values().length];
            $SwitchMap$com$microsoft$intune$mam$policy$WipeReason = iArr;
            try {
                iArr[WipeReason.COMPANY_PORTAL_REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$WipeReason[WipeReason.POLICY_REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$WipeReason[WipeReason.POLICY_REMOVED_APP_UNSTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean isImplicit() {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$policy$WipeReason[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
