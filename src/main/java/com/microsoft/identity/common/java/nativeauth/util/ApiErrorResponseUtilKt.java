package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ApiErrorResponseUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0001*\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\n\u001a\u000e\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u000e\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\u0010\u001a\u00020\u0001*\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u0011\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0014\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0015\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0017\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u0018\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0013\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\u0010\n\u001a\u000e\u0010\u001a\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001b\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001c\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001d\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010\u001f\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010 \u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010!\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\f\u0010\"\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010#\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010$\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010%\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010&\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u000e\u0010'\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020*0)H\u0000¨\u0006+"}, d2 = {"isAccessDenied", "", "", "isAttributeValidationFailed", "isAttributesRequired", "isAuthNotSupported", "isCredentialRequired", "isExpiredToken", "isInvalidAuthenticationType", "", "(Ljava/lang/Integer;)Z", "isInvalidChallengeTarget", "isInvalidClient", "isInvalidCredentials", "isInvalidGrant", "isInvalidOOBValue", "isInvalidParameter", "isInvalidRequest", "isInvalidUsername", "isJITRequired", "isMFARequired", "isOOB", "isOOBValueInvalid", "isPassword", "isPasswordBanned", "isPasswordChangeRequired", "isPasswordInvalid", "isPasswordRecentlyUsed", "isPasswordTooLong", "isPasswordTooShort", "isPasswordTooWeak", "isPollInProgress", "isPollSucceeded", "isPreverified", "isProviderBlocked", "isRedirect", "isUnsupportedChallengeType", "isUserAlreadyExists", "isUserNotFound", "isVerificationRequired", "toAttributeList", "", "", "common4j"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ApiErrorResponseUtilKt {
    public static final boolean isRedirect(String str) {
        return StringsKt.contentEquals(str, "redirect", true);
    }

    public static final boolean isOOB(String str) {
        return StringsKt.contentEquals(str, "oob", true);
    }

    public static final boolean isPreverified(String str) {
        return StringsKt.contentEquals(str, "preverified", true);
    }

    public static final boolean isPassword(String str) {
        return StringsKt.contentEquals(str, "password", true);
    }

    public static final boolean isCredentialRequired(String str) {
        return StringsKt.contentEquals(str, "credential_required", true);
    }

    public static final boolean isInvalidGrant(String str) {
        return StringsKt.contentEquals(str, "invalid_grant", true);
    }

    public static final boolean isInvalidRequest(String str) {
        return StringsKt.contentEquals(str, "invalid_request", true);
    }

    public static final boolean isAccessDenied(String str) {
        return StringsKt.contentEquals(str, "access_denied", true);
    }

    public static final boolean isPasswordTooWeak(String str) {
        return StringsKt.contentEquals(str, "password_too_weak", true);
    }

    public static final boolean isPasswordTooShort(String str) {
        return StringsKt.contentEquals(str, "password_too_short", true);
    }

    public static final boolean isPasswordTooLong(String str) {
        return StringsKt.contentEquals(str, "password_too_long", true);
    }

    public static final boolean isPasswordRecentlyUsed(String str) {
        return StringsKt.contentEquals(str, "password_recently_used", true);
    }

    public static final boolean isPasswordInvalid(String str) {
        return StringsKt.contentEquals(str, "password_is_invalid", true);
    }

    public static final boolean isPasswordBanned(String str) {
        return StringsKt.contentEquals(str, "password_banned", true);
    }

    public static final boolean isPollInProgress(String str) {
        return StringsKt.contentEquals(str, "in_progress", true);
    }

    public static final boolean isPollSucceeded(String str) {
        return StringsKt.contentEquals(str, TelemetryEventStrings.Value.SUCCEEDED, true);
    }

    public static final boolean isUserNotFound(String str) {
        return StringsKt.contentEquals(str, ErrorTypes.USER_NOT_FOUND, true);
    }

    public static final boolean isUnsupportedChallengeType(String str) {
        return StringsKt.contentEquals(str, "unsupported_challenge_type", true);
    }

    public static final boolean isExpiredToken(String str) {
        return StringsKt.contentEquals(str, ErrorStrings.DEVICE_CODE_FLOW_EXPIRED_TOKEN_ERROR_CODE, true);
    }

    public static final boolean isOOBValueInvalid(String str) {
        return StringsKt.contentEquals(str, "invalid_oob_value", true);
    }

    public static final boolean isInvalidParameter(Integer num) {
        return num != null && num.intValue() == 90100;
    }

    public static final boolean isInvalidCredentials(Integer num) {
        return num != null && num.intValue() == 50126;
    }

    public static final boolean isPasswordChangeRequired(Integer num) {
        return num != null && num.intValue() == 50142;
    }

    public static final boolean isInvalidAuthenticationType(Integer num) {
        return num != null && num.intValue() == 400002;
    }

    public static final boolean isInvalidChallengeTarget(Integer num) {
        return num != null && num.intValue() == 901001;
    }

    public static final boolean isProviderBlocked(String str) {
        return StringsKt.contentEquals(str, "provider_blocked_by_rep", true);
    }

    public static final boolean isMFARequired(String str) {
        return StringsKt.contentEquals(str, NativeAuthConstants.Capabilities.MFA_REQUIRED, true);
    }

    public static final boolean isJITRequired(String str) {
        return StringsKt.contentEquals(str, NativeAuthConstants.Capabilities.REGISTRATION_REQUIRED, true);
    }

    public static final boolean isVerificationRequired(String str) {
        return StringsKt.contentEquals(str, "verification_required", true);
    }

    public static final boolean isInvalidUsername(String str) {
        return str != null && StringsKt.contains((CharSequence) str, (CharSequence) "username parameter is empty or not valid", true);
    }

    public static final boolean isInvalidClient(String str) {
        return str != null && StringsKt.contains((CharSequence) str, (CharSequence) "client_id parameter is empty or not valid", true);
    }

    public static final boolean isAttributeValidationFailed(String str) {
        return StringsKt.contentEquals(str, "attribute_validation_failed", true);
    }

    public static final boolean isAttributesRequired(String str) {
        return StringsKt.contentEquals(str, "attributes_required", true);
    }

    public static final boolean isUserAlreadyExists(String str) {
        return StringsKt.contentEquals(str, SignUpErrorTypes.USER_ALREADY_EXISTS, true);
    }

    public static final boolean isAuthNotSupported(String str) {
        String str2 = str;
        return StringsKt.contentEquals(str2, SignUpErrorTypes.AUTH_NOT_SUPPORTED, true) || StringsKt.contentEquals(str2, "unsupported_auth_method", true);
    }

    public static final boolean isInvalidOOBValue(String str) {
        return StringsKt.contentEquals(str, "invalid_oob_value", true);
    }

    public static final List<String> toAttributeList(List<? extends Map<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String str = (String) ((Map) it.next()).get("name");
            if (str != null) {
                arrayList.add(str);
            }
        }
        return CollectionsKt.toList(arrayList);
    }
}
