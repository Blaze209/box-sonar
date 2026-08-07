package com.microsoft.identity.common.java.exception;

/* JADX INFO: loaded from: classes14.dex */
public final class DeviceRegistrationRequiredException extends BaseException {
    public static final String sName = "com.microsoft.identity.common.exception.DeviceRegistrationRequiredException";
    private static final long serialVersionUID = 5804977362169696152L;

    public DeviceRegistrationRequiredException(String str, String str2, String str3) {
        super(str, str2);
        if (str == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("errorDescription is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("userName is marked non-null but is null");
        }
        super.setUsername(str3);
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }
}
