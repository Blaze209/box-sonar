package com.microsoft.identity.common.java.nativeauth.providers;

import kotlin.Metadata;

/* JADX INFO: compiled from: NativeAuthConstants.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants;", "", "()V", "Capabilities", "ChallengeChannel", "ChallengeType", "GrantType", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthConstants {
    public static final NativeAuthConstants INSTANCE = new NativeAuthConstants();

    private NativeAuthConstants() {
    }

    /* JADX INFO: compiled from: NativeAuthConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$ChallengeChannel;", "", "()V", "EMAIL", "", "SMS", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ChallengeChannel {
        public static final String EMAIL = "email";
        public static final ChallengeChannel INSTANCE = new ChallengeChannel();
        public static final String SMS = "sms";

        private ChallengeChannel() {
        }
    }

    /* JADX INFO: compiled from: NativeAuthConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$GrantType;", "", "()V", "ATTRIBUTES", "", "CONTINUATION_TOKEN", "MFA_OOB", "OOB", "PASSWORD", "REDIRECT", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class GrantType {
        public static final String ATTRIBUTES = "attributes";
        public static final String CONTINUATION_TOKEN = "continuation_token";
        public static final GrantType INSTANCE = new GrantType();
        public static final String MFA_OOB = "mfa_oob";
        public static final String OOB = "oob";
        public static final String PASSWORD = "password";
        public static final String REDIRECT = "redirect";

        private GrantType() {
        }
    }

    /* JADX INFO: compiled from: NativeAuthConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$ChallengeType;", "", "()V", "OOB", "", "PASSWORD", "REDIRECT", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ChallengeType {
        public static final ChallengeType INSTANCE = new ChallengeType();
        public static final String OOB = "oob";
        public static final String PASSWORD = "password";
        public static final String REDIRECT = "redirect";

        private ChallengeType() {
        }
    }

    /* JADX INFO: compiled from: NativeAuthConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthConstants$Capabilities;", "", "()V", "MFA_REQUIRED", "", "REGISTRATION_REQUIRED", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Capabilities {
        public static final Capabilities INSTANCE = new Capabilities();
        public static final String MFA_REQUIRED = "mfa_required";
        public static final String REGISTRATION_REQUIRED = "registration_required";

        private Capabilities() {
        }
    }
}
