package com.pspdfkit.internal;

import com.pspdfkit.instant.exceptions.InstantErrorCode;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class jj {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[InstantErrorCode.values().length];
        try {
            iArr[InstantErrorCode.REQUEST_FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[InstantErrorCode.ALREADY_AUTHENTICATING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[InstantErrorCode.ALREADY_SYNCING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[InstantErrorCode.ATTACHMENT_ALREADY_TRANSFERRED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[InstantErrorCode.ATTACHMENT_NOT_LOADED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[InstantErrorCode.ATTACHMENT_TRANSFER_IN_PROGRESS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[InstantErrorCode.AUTHENTICATION_FAILED.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[InstantErrorCode.DATABASE_ERROR.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[InstantErrorCode.INVALID_CUSTOM_DATA.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[InstantErrorCode.INVALID_JSON_STRUCTURE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[InstantErrorCode.INVALID_JWT.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[InstantErrorCode.INVALID_REQUEST.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr[InstantErrorCode.INVALID_SERVER_DATA.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr[InstantErrorCode.NO_SUCH_ATTACHMENT.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr[InstantErrorCode.NO_SUCH_ATTACHMENT_TRANSFER.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr[InstantErrorCode.OLD_CLIENT.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr[InstantErrorCode.OLD_SERVER.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr[InstantErrorCode.PAYLOAD_SIZE_LIMIT_EXCEEDED.ordinal()] = 18;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr[InstantErrorCode.READ_FAILED.ordinal()] = 19;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr[InstantErrorCode.SERVER_UUID_PENDING.ordinal()] = 20;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr[InstantErrorCode.UNKNOWN.ordinal()] = 21;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr[InstantErrorCode.UNMANAGED_ANNOTATION.ordinal()] = 22;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr[InstantErrorCode.USER_CANCELLED.ordinal()] = 23;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            iArr[InstantErrorCode.USER_MISMATCH.ordinal()] = 24;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            iArr[InstantErrorCode.WRITE_FAILED.ordinal()] = 25;
        } catch (NoSuchFieldError unused25) {
        }
        a = iArr;
    }
}
