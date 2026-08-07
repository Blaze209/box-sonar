package com.yubico.yubikit.core.fido;

import com.yubico.yubikit.core.application.CommandException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class CtapException extends CommandException {
    public static final byte ERR_ACTION_TIMEOUT = 58;
    public static final byte ERR_CBOR_UNEXPECTED_TYPE = 17;
    public static final byte ERR_CHANNEL_BUSY = 6;
    public static final byte ERR_CREDENTIAL_EXCLUDED = 25;
    public static final byte ERR_EXTENSION_FIRST = -32;
    public static final byte ERR_EXTENSION_LAST = -17;
    public static final byte ERR_FP_DATABASE_FULL = 23;
    public static final byte ERR_INTEGRITY_FAILURE = 61;
    public static final byte ERR_INVALID_CBOR = 18;
    public static final byte ERR_INVALID_CHANNEL = 11;
    public static final byte ERR_INVALID_COMMAND = 1;
    public static final byte ERR_INVALID_CREDENTIAL = 34;
    public static final byte ERR_INVALID_LENGTH = 3;
    public static final byte ERR_INVALID_OPTION = 44;
    public static final byte ERR_INVALID_PARAMETER = 2;
    public static final byte ERR_INVALID_SEQ = 4;
    public static final byte ERR_INVALID_SUBCOMMAND = 62;
    public static final byte ERR_KEEPALIVE_CANCEL = 45;
    public static final byte ERR_KEY_STORE_FULL = 40;
    public static final byte ERR_LIMIT_EXCEEDED = 21;
    public static final byte ERR_LOCK_REQUIRED = 10;
    public static final byte ERR_MISSING_PARAMETER = 20;
    public static final byte ERR_NOT_ALLOWED = 48;
    public static final byte ERR_NOT_BUSY = 41;
    public static final byte ERR_NO_CREDENTIALS = 46;
    public static final byte ERR_NO_OPERATIONS = 37;
    public static final byte ERR_NO_OPERATION_PENDING = 42;
    public static final byte ERR_OPERATION_DENIED = 39;
    public static final byte ERR_OPERATION_PENDING = 36;
    public static final byte ERR_OTHER = 127;
    public static final byte ERR_PIN_AUTH_BLOCKED = 52;
    public static final byte ERR_PIN_AUTH_INVALID = 51;
    public static final byte ERR_PIN_BLOCKED = 50;
    public static final byte ERR_PIN_INVALID = 49;
    public static final byte ERR_PIN_NOT_SET = 53;
    public static final byte ERR_PIN_POLICY_VIOLATION = 55;
    public static final byte ERR_PIN_REQUIRED = 54;
    public static final byte ERR_PIN_TOKEN_EXPIRED = 56;
    public static final byte ERR_PROCESSING = 33;
    public static final byte ERR_REQUEST_TOO_LARGE = 57;
    public static final byte ERR_SPEC_LAST = -33;
    public static final byte ERR_SUCCESS = 0;
    public static final byte ERR_TIMEOUT = 5;
    public static final byte ERR_UNAUTHORIZED_PERMISSION = 64;
    public static final byte ERR_UNSUPPORTED_ALGORITHM = 38;
    public static final byte ERR_UNSUPPORTED_EXTENSION = 22;
    public static final byte ERR_UNSUPPORTED_OPTION = 43;
    public static final byte ERR_UP_REQUIRED = 59;
    public static final byte ERR_USER_ACTION_PENDING = 35;
    public static final byte ERR_USER_ACTION_TIMEOUT = 47;
    public static final byte ERR_UV_BLOCKED = 60;
    public static final byte ERR_UV_INVALID = 63;
    public static final byte ERR_VENDOR_FIRST = -16;
    public static final byte ERR_VENDOR_LAST = -1;
    private final byte ctapError;

    public CtapException(byte b) {
        super(String.format(Locale.ROOT, "CTAP error: 0x%02x", Byte.valueOf(b)));
        this.ctapError = b;
    }

    public byte getCtapError() {
        return this.ctapError;
    }
}
