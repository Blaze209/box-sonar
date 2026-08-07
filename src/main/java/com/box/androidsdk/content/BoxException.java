package com.box.androidsdk.content;

import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.requests.BoxHttpResponse;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes13.dex */
public class BoxException extends Exception {
    private static final long serialVersionUID = 1;
    private BoxHttpResponse boxHttpResponse;
    private String response;
    private final int responseCode;

    public BoxException(String str) {
        super(str);
        this.responseCode = 0;
        this.boxHttpResponse = null;
        this.response = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxException(String str, BoxHttpResponse boxHttpResponse) {
        super(str, null);
        this.boxHttpResponse = boxHttpResponse;
        if (boxHttpResponse != null) {
            this.responseCode = boxHttpResponse.getResponseCode();
        } else {
            this.responseCode = 0;
        }
        try {
            this.response = boxHttpResponse.getStringBody();
        } catch (Exception unused) {
            this.response = null;
        }
    }

    public BoxException(String str, Throwable th) {
        super(str, getRootCause(th));
        this.responseCode = 0;
        this.response = null;
    }

    public BoxException(String str, int i, String str2, Throwable th) {
        super(str, getRootCause(th));
        this.responseCode = i;
        this.response = str2;
    }

    private static Throwable getRootCause(Throwable th) {
        return th instanceof BoxException ? th.getCause() : th;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponse() {
        return this.response;
    }

    public BoxError getAsBoxError() {
        try {
            BoxError boxError = new BoxError();
            boxError.createFromJson(getResponse());
            return boxError;
        } catch (Exception unused) {
            return null;
        }
    }

    public ErrorType getErrorType() {
        if ((getCause() instanceof UnknownHostException) || (getCause() instanceof ConnectException)) {
            return ErrorType.NETWORK_ERROR;
        }
        if (this instanceof CorruptedContentException) {
            return ErrorType.CORRUPTED_FILE_TRANSFER;
        }
        BoxError asBoxError = getAsBoxError();
        return ErrorType.fromErrorInfo(asBoxError != null ? asBoxError.getError() : null, getResponseCode());
    }

    public enum ErrorType {
        INVALID_GRANT_TOKEN_EXPIRED("invalid_grant", 400),
        INVALID_GRANT_INVALID_TOKEN("invalid_grant", 400),
        ACCOUNT_DEACTIVATED("account_deactivated", 400),
        ACCESS_DENIED("access_denied", 403),
        INVALID_REQUEST("invalid_request", 400),
        INVALID_CLIENT(ErrorStrings.INVALID_CLIENT, 400),
        PASSWORD_RESET_REQUIRED("password_reset_required", 400),
        TERMS_OF_SERVICE_REQUIRED("terms_of_service_required", 400),
        NO_CREDIT_CARD_TRIAL_ENDED("no_credit_card_trial_ended", 400),
        TEMPORARILY_UNAVAILABLE("temporarily_unavailable", 429),
        SERVICE_BLOCKED("service_blocked", 400),
        SERVICE_BLOCKED_2("service_blocked", 403),
        UNAUTHORIZED_DEVICE("unauthorized_device", 400),
        GRACE_PERIOD_EXPIRED("grace_period_expired", 403),
        NETWORK_ERROR("bad_connection_network_error", 0),
        LOCATION_BLOCKED("access_from_location_blocked", 403),
        IP_BLOCKED("error_access_from_ip_not_allowed", 403),
        UNAUTHORIZED("unauthorized", 401),
        NEW_OWNER_NOT_COLLABORATOR("new_owner_not_collaborator", 400),
        INTERNAL_ERROR("internal_server_error", 500),
        CORRUPTED_FILE_TRANSFER("file corrupted", 0),
        FORBIDDEN_DUE_TO_SHIELD_POLICY(BoxRequestsShare.AddCollaboration.ERROR_CODE_FORBIDDEN_BY_POLICY, 403),
        PKCE_VERIFICATION_FAILED("pkce_verification_failed", 400),
        NOT_FOUND("not_found", 404),
        OTHER("", 0);

        private final int mStatusCode;
        private final String mValue;

        ErrorType(String str, int i) {
            this.mValue = str;
            this.mStatusCode = i;
        }

        public static ErrorType fromErrorInfo(String str, int i) {
            if (i == 500) {
                return INTERNAL_ERROR;
            }
            for (ErrorType errorType : values()) {
                if (errorType.mStatusCode == i && errorType.mValue.equals(str)) {
                    return errorType;
                }
            }
            return OTHER;
        }
    }

    public static class MaxAttemptsExceeded extends BoxException {
        private final int mTimesTried;

        public MaxAttemptsExceeded(String str, int i) {
            this(str, i, null);
        }

        public MaxAttemptsExceeded(String str, int i, BoxHttpResponse boxHttpResponse) {
            super(str + i, boxHttpResponse);
            this.mTimesTried = i;
        }

        public int getTimesTried() {
            return this.mTimesTried;
        }
    }

    public static class RateLimitAttemptsExceeded extends MaxAttemptsExceeded {
        public RateLimitAttemptsExceeded(String str, int i, BoxHttpResponse boxHttpResponse) {
            super(str, i, boxHttpResponse);
        }
    }

    public static class RefreshFailure extends BoxException {
        private static final ErrorType[] fatalTypes = {ErrorType.INVALID_GRANT_INVALID_TOKEN, ErrorType.INVALID_GRANT_TOKEN_EXPIRED, ErrorType.ACCESS_DENIED, ErrorType.NO_CREDIT_CARD_TRIAL_ENDED, ErrorType.SERVICE_BLOCKED, ErrorType.SERVICE_BLOCKED_2, ErrorType.INVALID_CLIENT, ErrorType.UNAUTHORIZED_DEVICE, ErrorType.GRACE_PERIOD_EXPIRED, ErrorType.UNAUTHORIZED, ErrorType.ACCOUNT_DEACTIVATED, ErrorType.PKCE_VERIFICATION_FAILED};

        public RefreshFailure(BoxException boxException) {
            super(boxException.getMessage(), boxException.responseCode, boxException.getResponse(), boxException);
        }

        public boolean isErrorFatal() {
            ErrorType errorType = getErrorType();
            for (ErrorType errorType2 : fatalTypes) {
                if (errorType == errorType2) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class CacheImplementationNotFound extends BoxException {
        public CacheImplementationNotFound() {
            super("");
        }
    }

    public static class CacheResultUnavailable extends BoxException {
        public CacheResultUnavailable() {
            super("");
        }
    }

    @Deprecated
    public static class CacheResultUnavilable extends BoxException {
        @Deprecated
        public CacheResultUnavilable() {
            super("");
        }
    }

    public static class CorruptedContentException extends BoxException {
        private final String mExpectedSha1;
        private final String mReceivedSha1;

        public CorruptedContentException(String str, String str2, String str3) {
            super(str);
            this.mExpectedSha1 = str2;
            this.mReceivedSha1 = str3;
        }

        public String getExpectedSha1() {
            return this.mExpectedSha1;
        }

        public String getReceivedSha1() {
            return this.mReceivedSha1;
        }
    }

    public static class DownloadSSLException extends BoxException {
        public DownloadSSLException(String str, SSLException sSLException) {
            super(str, sSLException);
        }

        @Override // com.box.androidsdk.content.BoxException
        public ErrorType getErrorType() {
            if (getCause() instanceof SSLException) {
                return ErrorType.NETWORK_ERROR;
            }
            return super.getErrorType();
        }
    }
}
