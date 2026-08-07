package com.microsoft.identity.common.java.exception;

/* JADX INFO: loaded from: classes14.dex */
public class ArgumentException extends BaseException {
    public static final String ACQUIRE_PRT_SSO_COOKIE_OPERATION_NAME = "acquirePrtSsoCookie";
    public static final String ACQUIRE_TOKEN_NO_FIXED_SCOPE_OPERATION_NAME = "acquireTokenNoFixedScope";
    public static final String ACQUIRE_TOKEN_OPERATION_NAME = "acquireToken";
    public static final String ACQUIRE_TOKEN_SILENT_OPERATION_NAME = "acquireTokenSilent";
    public static final String ACQUIRE_TOKEN_WITH_DEVICE_CODE_OPERATION_NAME = "acquireTokenWithDeviceCode";
    public static final String ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME = "acquireTokenWithPassword";
    public static final String AUTHENTICATION_SCHEME_ARGUMENT_NAME = "authentication_scheme";
    public static final String AUTHORITY_ARGUMENT_NAME = "authority";
    public static final String BROKER_TOKEN_REQUEST_OPERATION_NAME = "brokerTokenRequest";
    public static final String GENERATE_SHR_OPERATION_NAME = "generateShr";
    public static final String GET_ACCOUNTS_OPERATION_NAME = "getAllAccounts";
    public static final String IACCOUNT_ARGUMENT_NAME = "account";
    public static final String ILLEGAL_ARGUMENT_ERROR_CODE = "illegal_argument_exception";
    public static final String LINUX_BROKER_VERSION_NAME = "linuxBrokerVersion";
    public static final String REDIRECT_URI_ARGUMENT_NAME = "redirect_uri";
    public static final String REMOVE_ACCOUNT_OPERATION_NAME = "removeAccount";
    public static final String SCOPE_ARGUMENT_NAME = "scopes";
    public static final String sName = "com.microsoft.identity.common.exception.ArgumentException";
    private static final long serialVersionUID = -6399451133831073876L;
    private String mArgumentName;
    private String mOperationName;

    public ArgumentException(String str, String str2, String str3) {
        super(ILLEGAL_ARGUMENT_ERROR_CODE, str3);
        this.mOperationName = str;
        this.mArgumentName = str2;
    }

    public ArgumentException(String str, String str2, String str3, Throwable th) {
        super(ILLEGAL_ARGUMENT_ERROR_CODE, str3, th);
        this.mOperationName = str;
        this.mArgumentName = str2;
    }

    public String getOperationName() {
        return this.mOperationName;
    }

    public String getArgumentName() {
        return this.mArgumentName;
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }
}
