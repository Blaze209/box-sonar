package com.pspdfkit.internal;

import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeInstantErrorCode;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayerState;
import java.util.HashMap;
import java.util.Locale;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public final class lr {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[NativeServerDocumentLayerState.values().length];
            b = iArr;
            try {
                iArr[NativeServerDocumentLayerState.NEEDS_RECORD_CONTENT_MIGRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[NativeServerDocumentLayerState.MIGRATING_RECORD_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[NativeServerDocumentLayerState.NEEDS_RESET_FOR_DATABASE_MIGRATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[NativeServerDocumentLayerState.RESETTING_FOR_DATABASE_MIGRATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[NativeServerDocumentLayerState.CLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[NativeServerDocumentLayerState.PENDING_CHANGES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[NativeServerDocumentLayerState.PUSHING_CHANGES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[NativeServerDocumentLayerState.FETCHING_CHANGES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[NativeServerDocumentLayerState.INVALID.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[NativeInstantErrorCode.values().length];
            a = iArr2;
            try {
                iArr2[NativeInstantErrorCode.USER_CANCELLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[NativeInstantErrorCode.AUTHENTICATION_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[NativeInstantErrorCode.ALREADY_AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[NativeInstantErrorCode.ALREADY_SYNCING.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[NativeInstantErrorCode.REQUEST_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[NativeInstantErrorCode.OLD_CLIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[NativeInstantErrorCode.OLD_SERVER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[NativeInstantErrorCode.INVALID_REQUEST.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[NativeInstantErrorCode.PAYLOAD_SIZE_LIMIT_EXCEEDED.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[NativeInstantErrorCode.INVALID_SERVER_DATA.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[NativeInstantErrorCode.WRITE_FAILED.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[NativeInstantErrorCode.READ_FAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[NativeInstantErrorCode.DATABASE_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[NativeInstantErrorCode.DATABASE_NEEDS_CONTENT_MIGRATION.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[NativeInstantErrorCode.DATABASE_IS_PERFORMING_CONTENT_MIGRATION.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[NativeInstantErrorCode.SERVER_UUID_PENDING.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[NativeInstantErrorCode.INVALID_JWT.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[NativeInstantErrorCode.USER_MISMATCH.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                a[NativeInstantErrorCode.ATTACHMENT_NOT_LOADED.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                a[NativeInstantErrorCode.NO_SUCH_ATTACHMENT.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                a[NativeInstantErrorCode.ATTACHMENT_TRANSFER_IN_PROGRESS.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                a[NativeInstantErrorCode.ATTACHMENT_ALREADY_TRANSFERRED.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[NativeInstantErrorCode.NO_SUCH_ATTACHMENT_TRANSFER.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[NativeInstantErrorCode.UNMANAGED_ANNOTATION.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[NativeInstantErrorCode.INVALID_CUSTOM_DATA.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                a[NativeInstantErrorCode.INVALID_JSON_STRUCTURE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    public static HashMap<String, String> a(Headers headers) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < headers.size(); i++) {
            String lowerCase = headers.name(i).toLowerCase(Locale.US);
            String strValue = headers.value(i);
            if (map.containsKey(lowerCase)) {
                strValue = map.get(lowerCase) + ", " + strValue;
            }
            map.put(lowerCase, strValue);
        }
        return map;
    }

    public static InstantErrorCode a(NativeInstantErrorCode nativeInstantErrorCode) {
        if (nativeInstantErrorCode != null && nativeInstantErrorCode != NativeInstantErrorCode.UNKNOWN) {
            switch (a.a[nativeInstantErrorCode.ordinal()]) {
                case 1:
                    return InstantErrorCode.USER_CANCELLED;
                case 2:
                    return InstantErrorCode.AUTHENTICATION_FAILED;
                case 3:
                    return InstantErrorCode.UNKNOWN;
                case 4:
                    return InstantErrorCode.ALREADY_SYNCING;
                case 5:
                    return InstantErrorCode.REQUEST_FAILED;
                case 6:
                    return InstantErrorCode.OLD_CLIENT;
                case 7:
                    return InstantErrorCode.OLD_SERVER;
                case 8:
                    return InstantErrorCode.INVALID_REQUEST;
                case 9:
                    return InstantErrorCode.PAYLOAD_SIZE_LIMIT_EXCEEDED;
                case 10:
                    return InstantErrorCode.INVALID_SERVER_DATA;
                case 11:
                    return InstantErrorCode.WRITE_FAILED;
                case 12:
                    return InstantErrorCode.READ_FAILED;
                case 13:
                    return InstantErrorCode.DATABASE_ERROR;
                case 14:
                case 15:
                    new IllegalArgumentException("Android neither needs nor supports content migrations - yet.");
                    return InstantErrorCode.UNKNOWN;
                case 16:
                    return InstantErrorCode.SERVER_UUID_PENDING;
                case 17:
                    return InstantErrorCode.INVALID_JWT;
                case 18:
                    return InstantErrorCode.USER_MISMATCH;
                case 19:
                    return InstantErrorCode.ATTACHMENT_NOT_LOADED;
                case 20:
                    return InstantErrorCode.NO_SUCH_ATTACHMENT;
                case 21:
                    return InstantErrorCode.ATTACHMENT_TRANSFER_IN_PROGRESS;
                case 22:
                    return InstantErrorCode.ATTACHMENT_ALREADY_TRANSFERRED;
                case 23:
                    return InstantErrorCode.NO_SUCH_ATTACHMENT_TRANSFER;
                case 24:
                    return InstantErrorCode.UNMANAGED_ANNOTATION;
                case 25:
                    return InstantErrorCode.INVALID_CUSTOM_DATA;
                case 26:
                    return InstantErrorCode.INVALID_JSON_STRUCTURE;
                default:
                    new IllegalArgumentException("Not implemented conversion for NativeInstantErrorCode: " + nativeInstantErrorCode);
                    return InstantErrorCode.UNKNOWN;
            }
        }
        return InstantErrorCode.UNKNOWN;
    }

    public static InstantException a(NativeInstantError nativeInstantError) {
        return new InstantException(a(nativeInstantError.getCode()), nativeInstantError.getMessage(), nativeInstantError.getUnderlyingError());
    }
}
