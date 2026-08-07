package com.box.androidsdk.content.auth;

import com.box.androidsdk.content.BoxApi;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxMDMData;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxHttpResponse;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
class BoxApiAuthentication extends BoxApi {
    static final String CODE_VERIFIER = "code_verifier";
    static final String GRANT_TYPE = "grant_type";
    static final String GRANT_TYPE_AUTH_CODE = "authorization_code";
    static final String GRANT_TYPE_REFRESH = "refresh_token";
    static final String OAUTH_TOKEN_REQUEST_URL = "%s/oauth2/token";
    static final String OAUTH_TOKEN_REVOKE_URL = "%s/oauth2/revoke";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String RESPONSE_TYPE_BASE_DOMAIN = "base_domain";
    static final String RESPONSE_TYPE_CODE = "code";
    static final String RESPONSE_TYPE_ERROR = "error";

    BoxApiAuthentication(BoxSession boxSession) {
        super(boxSession);
        if (boxSession.isAppFedrampHighCompliant()) {
            this.mBaseUri = BoxConstants.OAUTH_BASE_URI_FEDRAMP_COMPLIANT;
        } else {
            this.mBaseUri = BoxConstants.OAUTH_BASE_URI;
        }
    }

    @Override // com.box.androidsdk.content.BoxApi
    protected String getBaseUri() {
        if (this.mSession != null && this.mSession.getAuthInfo() != null && this.mSession.getAuthInfo().getBaseDomain() != null) {
            return String.format(BoxConstants.OAUTH_BASE_URI_TEMPLATE, this.mSession.getAuthInfo().getBaseDomain());
        }
        return super.getBaseUri();
    }

    BoxRefreshAuthRequest refreshOAuth(String str, String str2, String str3) {
        return new BoxRefreshAuthRequest(this.mSession, getTokenUrl(), str, str2, str3);
    }

    BoxCreateAuthRequest createOAuth(String str, String str2, String str3, String str4) {
        return new BoxCreateAuthRequest(this.mSession, getTokenUrl(), str, str2, str3, str4);
    }

    BoxRevokeAuthRequest revokeOAuth(String str, String str2, String str3) {
        BoxRevokeAuthRequest boxRevokeAuthRequest = new BoxRevokeAuthRequest(this.mSession, getTokenRevokeUrl(), str, str2, str3);
        boxRevokeAuthRequest.setRequestHandler(new BoxRequest.BoxRequestHandler(boxRevokeAuthRequest) { // from class: com.box.androidsdk.content.auth.BoxApiAuthentication.1
            @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
            public boolean onException(BoxRequest boxRequest, BoxHttpResponse boxHttpResponse, BoxException boxException) throws BoxException.RefreshFailure {
                return false;
            }
        });
        return boxRevokeAuthRequest;
    }

    protected String getTokenUrl() {
        return String.format(Locale.ENGLISH, OAUTH_TOKEN_REQUEST_URL, getBaseUri());
    }

    protected String getTokenRevokeUrl() {
        return String.format(Locale.ENGLISH, OAUTH_TOKEN_REVOKE_URL, getBaseUri());
    }

    static class BoxRefreshAuthRequest extends BoxRequest<BoxAuthentication.BoxAuthenticationInfo, BoxRefreshAuthRequest> {
        private static final long serialVersionUID = 8123965031279971570L;

        public BoxRefreshAuthRequest(BoxSession boxSession, String str, String str2, String str3, String str4) {
            super(BoxAuthentication.BoxAuthenticationInfo.class, str, boxSession);
            this.mContentType = BoxRequest.ContentTypes.URL_ENCODED;
            this.mRequestMethod = BoxRequest.Methods.POST;
            this.mBodyMap.put("grant_type", "refresh_token");
            this.mBodyMap.put("refresh_token", str2);
            this.mBodyMap.put("client_id", str3);
            this.mBodyMap.put("client_secret", str4);
            if (boxSession.getDeviceId() != null) {
                setDevice(boxSession.getDeviceId(), boxSession.getDeviceName());
            }
            if (boxSession.getRefreshTokenExpiresAt() != null) {
                setRefreshExpiresAt(boxSession.getRefreshTokenExpiresAt().longValue());
            }
        }

        public BoxRefreshAuthRequest setDevice(String str, String str2) {
            if (!SdkUtils.isEmptyString(str)) {
                this.mBodyMap.put(BoxConstants.KEY_BOX_DEVICE_ID, str);
            }
            if (!SdkUtils.isEmptyString(str2)) {
                this.mBodyMap.put(BoxConstants.KEY_BOX_DEVICE_NAME, str2);
            }
            return this;
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest
        protected void onSendCompleted(BoxResponse<BoxAuthentication.BoxAuthenticationInfo> boxResponse) throws BoxException {
            super.onSendCompleted(boxResponse);
            if (boxResponse.isSuccess()) {
                ((BoxAuthentication.BoxAuthenticationInfo) boxResponse.getResult()).setUser(this.mSession.getUser());
            }
        }

        public BoxRefreshAuthRequest setRefreshExpiresAt(long j) {
            this.mBodyMap.put(BoxConstants.KEY_BOX_REFRESH_TOKEN_EXPIRES_AT, Long.toString(j));
            return this;
        }
    }

    static class BoxCreateAuthRequest extends BoxRequest<BoxAuthentication.BoxAuthenticationInfo, BoxCreateAuthRequest> {
        private static final long serialVersionUID = 8123965031279971580L;

        private BoxCreateAuthRequest(BoxSession boxSession, String str, String str2, String str3, String str4, String str5) {
            super(BoxAuthentication.BoxAuthenticationInfo.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setContentType(BoxRequest.ContentTypes.URL_ENCODED);
            this.mBodyMap.put("grant_type", "authorization_code");
            this.mBodyMap.put("code", str2);
            this.mBodyMap.put("client_id", str4);
            this.mBodyMap.put("client_secret", str5);
            if (!SdkUtils.isEmptyString(str3)) {
                this.mBodyMap.put("code_verifier", str3);
            }
            if (boxSession.getDeviceId() != null) {
                setDevice(boxSession.getDeviceId(), boxSession.getDeviceName());
            }
            if (boxSession.getManagementData() != null) {
                setMdmData(boxSession.getManagementData());
            }
            if (boxSession.getRefreshTokenExpiresAt() != null) {
                setRefreshExpiresAt(boxSession.getRefreshTokenExpiresAt().longValue());
            }
        }

        private BoxCreateAuthRequest setMdmData(BoxMDMData boxMDMData) {
            if (boxMDMData != null) {
                this.mBodyMap.put(BoxMDMData.BOX_MDM_DATA, boxMDMData.toJson());
            }
            return this;
        }

        private BoxCreateAuthRequest setDevice(String str, String str2) {
            if (!SdkUtils.isEmptyString(str)) {
                this.mBodyMap.put(BoxConstants.KEY_BOX_DEVICE_ID, str);
            }
            if (!SdkUtils.isEmptyString(str2)) {
                this.mBodyMap.put(BoxConstants.KEY_BOX_DEVICE_NAME, str2);
            }
            return this;
        }

        private BoxCreateAuthRequest setRefreshExpiresAt(long j) {
            this.mBodyMap.put(BoxConstants.KEY_BOX_REFRESH_TOKEN_EXPIRES_AT, Long.toString(j));
            return this;
        }
    }

    static class BoxRevokeAuthRequest extends BoxRequest<BoxAuthentication.BoxAuthenticationInfo, BoxRevokeAuthRequest> {
        private static final long serialVersionUID = 8123965031279971548L;

        public BoxRevokeAuthRequest(BoxSession boxSession, String str, String str2, String str3, String str4) {
            super(BoxAuthentication.BoxAuthenticationInfo.class, str, boxSession);
            this.mRequestMethod = BoxRequest.Methods.POST;
            setContentType(BoxRequest.ContentTypes.URL_ENCODED);
            this.mBodyMap.put("client_id", str3);
            this.mBodyMap.put("client_secret", str4);
            this.mBodyMap.put("token", str2);
        }
    }
}
