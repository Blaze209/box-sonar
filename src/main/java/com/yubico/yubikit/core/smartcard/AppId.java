package com.yubico.yubikit.core.smartcard;

import com.yubico.yubikit.core.fido.CtapException;

/* JADX INFO: loaded from: classes3.dex */
public final class AppId {
    public static final byte[] MANAGEMENT = {-96, 0, 0, 5, CtapException.ERR_OPERATION_DENIED, 71, 17, 23};
    public static final byte[] OTP = {-96, 0, 0, 5, CtapException.ERR_OPERATION_DENIED, 32, 1, 1};
    public static final byte[] OATH = {-96, 0, 0, 5, CtapException.ERR_OPERATION_DENIED, CtapException.ERR_PROCESSING, 1, 1};
    public static final byte[] PIV = {-96, 0, 0, 3, 8};
    public static final byte[] FIDO = {-96, 0, 0, 6, 71, CtapException.ERR_USER_ACTION_TIMEOUT, 0, 1};
    public static final byte[] OPENPGP = {-46, 118, 0, 1, CtapException.ERR_OPERATION_PENDING, 1};
    public static final byte[] HSMAUTH = {-96, 0, 0, 5, CtapException.ERR_OPERATION_DENIED, CtapException.ERR_PROCESSING, 7, 1};
}
