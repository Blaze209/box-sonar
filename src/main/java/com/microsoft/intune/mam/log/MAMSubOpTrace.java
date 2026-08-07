package com.microsoft.intune.mam.log;

/* JADX INFO: loaded from: classes3.dex */
public enum MAMSubOpTrace implements SubOpTrace {
    ACTIVITY_ON_MAM_CREATE("onMAMCreate"),
    ACTIVITY_ON_CREATE_COMMON("onCreate common"),
    ACTIVITY_ON_MAM_RESUME("onMAMResume"),
    ACTIVITY_ON_RESUME_COMMON("onResume common"),
    APP_ATTACH_BASE_CONTEXT("attachBaseContext"),
    APP_ON_CREATE("onCreate"),
    APP_ON_MAM_CREATE("onMAMCreate"),
    PROXY_CLIPBOARD("Ensure clipboard proxy"),
    CL_AUTH_FRAGMENT_STARTUP("CL auth fragment startup"),
    CL_DIALOG_FRAGMENT_STARTUP("CL dialog fragment startup"),
    CL_GET_ACCESS_FRAGMENT_STARTUP("CL get-access fragment startup"),
    ENCRYPTION_KEY_GET("get enc key"),
    ENCRYPTION_KEY_PREFETCH("prefetch enc key"),
    ENCRYPTION_MANAGER_INIT("FEM init"),
    ENCRYPTION_MANAGER_INSTALL_NATIVE_HOOKS("install native hooks"),
    LOAD_INTERNAL_DISABLED("check load internal disabled"),
    LOAD_NATIVE_LIBS("load native libs"),
    MAM_CLIENT_INIT("MAMClient ensure init"),
    POLICY_CHECK("mustCheckPolicies"),
    GET_MDM_CONTEXT("get agent context and sig check"),
    INIT_ONLINE_COMPS("init online components"),
    TEST_IPC("test ipc"),
    STARTUP_ACTIVITY_TRAMPOLINE("startup activity trampoline"),
    IN_HOUSE_ORIGIN_CHECKS("inHouseOriginChecks"),
    MAM_RASP_CHECKS("mamRaspChecks"),
    OMADM_RASP_CHECKS("omadmRaspChecks");

    private final String originalValue;

    MAMSubOpTrace() {
        this.originalValue = null;
    }

    MAMSubOpTrace(String str) {
        this.originalValue = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        String str = this.originalValue;
        return str != null ? str : super.toString();
    }
}
