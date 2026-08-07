package com.microsoft.identity.common.java.providers;

import androidx.media3.common.PlaybackException;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class RawAuthorizationResult {
    private static final String TAG = "RawAuthorizationResult";
    private final URI mAuthorizationFinalUri;
    private final BaseException mException;
    private final ResultCode mResultCode;

    private static class RawAuthorizationResultBuilder {
        private URI authorizationFinalUri;
        private BaseException exception;
        private ResultCode resultCode;

        RawAuthorizationResultBuilder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder authorizationFinalUri(URI uri) {
            this.authorizationFinalUri = uri;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResult build() {
            return new RawAuthorizationResult(this.resultCode, this.authorizationFinalUri, this.exception);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder exception(BaseException baseException) {
            this.exception = baseException;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RawAuthorizationResultBuilder resultCode(ResultCode resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public String toString() {
            return "RawAuthorizationResult.RawAuthorizationResultBuilder(resultCode=" + this.resultCode + ", authorizationFinalUri=" + this.authorizationFinalUri + ", exception=" + this.exception + ")";
        }
    }

    RawAuthorizationResult(ResultCode resultCode, URI uri, BaseException baseException) {
        this.mResultCode = resultCode;
        this.mAuthorizationFinalUri = uri;
        this.mException = baseException;
    }

    private static RawAuthorizationResultBuilder builder() {
        return new RawAuthorizationResultBuilder();
    }

    public enum ResultCode {
        UNKNOWN(-1),
        CANCELLED(2001),
        NON_OAUTH_ERROR(2002),
        COMPLETED(PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE),
        BROKER_INSTALLATION_TRIGGERED(PlaybackException.ERROR_CODE_IO_NO_PERMISSION),
        DEVICE_REGISTRATION_REQUIRED(PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED),
        SDK_CANCELLED(2008),
        MDM_FLOW(2009),
        INSUFFICIENT_DEVICE_REGISTRATION(2010),
        TIMED_OUT(2011);

        private final int mCode;

        ResultCode(int i) {
            this.mCode = i;
        }

        static ResultCode fromInteger(Integer num) {
            if (num == null) {
                return UNKNOWN;
            }
            for (ResultCode resultCode : values()) {
                if (resultCode.mCode == num.intValue()) {
                    return resultCode;
                }
            }
            return null;
        }
    }

    public ResultCode getResultCode() {
        return this.mResultCode;
    }

    public URI getAuthorizationFinalUri() {
        return this.mAuthorizationFinalUri;
    }

    public BaseException getException() {
        return this.mException;
    }

    public static RawAuthorizationResult fromResultCode(ResultCode resultCode) {
        if (resultCode != ResultCode.NON_OAUTH_ERROR && resultCode != ResultCode.COMPLETED && resultCode != ResultCode.DEVICE_REGISTRATION_REQUIRED && resultCode != ResultCode.BROKER_INSTALLATION_TRIGGERED) {
            return builder().resultCode(resultCode).build();
        }
        throw new IllegalArgumentException("Result code " + resultCode + " should be set via other factory methods");
    }

    public static RawAuthorizationResult fromThrowable(Throwable th) {
        if (th == null) {
            throw new NullPointerException("e is marked non-null but is null");
        }
        if (!(th instanceof BaseException)) {
            return builder().resultCode(ResultCode.NON_OAUTH_ERROR).exception(ExceptionAdapter.baseExceptionFromException(th)).build();
        }
        return fromException((BaseException) th);
    }

    public static RawAuthorizationResult fromException(BaseException baseException) {
        if (baseException != null) {
            return builder().resultCode(ResultCode.NON_OAUTH_ERROR).exception(baseException).build();
        }
        throw new NullPointerException("e is marked non-null but is null");
    }

    public static RawAuthorizationResult fromRedirectUri(String str) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        try {
            URI uri = new URI(str);
            return builder().resultCode(getResultCodeFromFinalRedirectUri(uri)).authorizationFinalUri(uri).build();
        } catch (URISyntaxException e) {
            return fromException(new ClientException("malformed_url", "Failed to parse redirect URL", e));
        }
    }

    public static PropertyBag toPropertyBag(RawAuthorizationResult rawAuthorizationResult) {
        if (rawAuthorizationResult == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        PropertyBag propertyBag = new PropertyBag();
        propertyBag.put(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, Integer.valueOf(rawAuthorizationResult.mResultCode.mCode));
        propertyBag.put("com.microsoft.aad.adal:BrowserFinalUrl", rawAuthorizationResult.mAuthorizationFinalUri);
        propertyBag.put("com.microsoft.aad.adal:AuthenticationException", rawAuthorizationResult.mException);
        return propertyBag;
    }

    public static RawAuthorizationResult fromPropertyBag(PropertyBag propertyBag) {
        if (propertyBag != null) {
            return builder().resultCode(ResultCode.fromInteger((Integer) propertyBag.get(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE))).authorizationFinalUri((URI) propertyBag.get("com.microsoft.aad.adal:BrowserFinalUrl")).exception((BaseException) propertyBag.get("com.microsoft.aad.adal:AuthenticationException")).build();
        }
        throw new NullPointerException("propertyBag is marked non-null but is null");
    }

    private static ResultCode getResultCodeFromFinalRedirectUri(URI uri) throws URISyntaxException {
        if (uri == null) {
            throw new NullPointerException("uri is marked non-null but is null");
        }
        String str = TAG + "getResultCodeFromFinalRedirectUri";
        Map<String, String> parameters = UrlUtil.getParameters(uri);
        if ("msauth".equalsIgnoreCase(uri.getScheme())) {
            if (parameters.containsKey(AuthenticationConstants.AAD.APP_LINK_KEY)) {
                Logger.info(str, "Return to caller with BROWSER_CODE_WAIT_FOR_BROKER_INSTALL, and waiting for result.");
                return ResultCode.BROKER_INSTALLATION_TRIGGERED;
            }
            if (AuthenticationConstants.AAD.DEVICE_REGISTRATION_REDIRECT_URI_HOSTNAME.equalsIgnoreCase(uri.getHost())) {
                Logger.info(str, " Device needs to be registered, sending BROWSER_CODE_DEVICE_REGISTER");
                return ResultCode.DEVICE_REGISTRATION_REQUIRED;
            }
            if (AuthenticationConstants.AAD.UPGRADE_DEVICE_REGISTRATION_REDIRECT_URI_HOSTNAME.equalsIgnoreCase(uri.getHost())) {
                Logger.info(str, " Device registration needs to be upgraded, sending INSUFFICIENT_DEVICE_REGISTRATION");
                return ResultCode.INSUFFICIENT_DEVICE_REGISTRATION;
            }
        }
        if (StringUtil.equalsIgnoreCase(parameters.get(AuthenticationConstants.OAuth2.ERROR_SUBCODE), "cancel")) {
            Logger.info(str, "User cancelled the session");
            return ResultCode.CANCELLED;
        }
        return ResultCode.COMPLETED;
    }
}
