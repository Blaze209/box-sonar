package com.microsoft.identity.common.java.exception;

import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.util.HashMapExtensions;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
public class ServiceException extends BaseException {
    public static final String ACCESS_DENIED = "access_denied";
    public static final int DEFAULT_STATUS_CODE = 0;
    public static final String INVALID_INSTANCE = "invalid_instance";
    public static final String INVALID_REQUEST = "invalid_request";
    public static final String INVALID_SCOPE = "invalid_scope";
    public static final String MsaGrantedRefreshTokenNotSupportedOnAadTenantErrorCode = "1000030";
    public static final String OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD = "failed_to_load_openid_configuration";
    public static final String REQUEST_THROTTLED_AT_ESTS_GATEWAY = "request_throttled_at_ESTS_gateway";
    public static final String REQUEST_TIMEOUT = "request_timeout";
    public static final String SERVICE_NOT_AVAILABLE = "service_not_available";
    public static final String UNAUTHORIZED_CLIENT = "unauthorized_client";
    public static final String UNKNOWN_ERROR = "unknown_error";
    public static final String sName = "com.microsoft.identity.common.exception.ServiceException";
    private static final long serialVersionUID = 5139563940871615046L;
    private HashMap<String, String> mHttpResponseBody;
    private HashMap<String, List<String>> mHttpResponseHeaders;
    private int mHttpStatusCode;

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public HashMap<String, String> getHttpResponseBody() {
        return this.mHttpResponseBody;
    }

    public HashMap<String, List<String>> getHttpResponseHeaders() {
        return this.mHttpResponseHeaders;
    }

    public void setHttpResponseHeaders(HashMap<String, List<String>> map) {
        this.mHttpResponseHeaders = map;
    }

    public void setHttpResponseBody(HashMap<String, String> map) {
        this.mHttpResponseBody = map;
    }

    public void setHttpResponse(HttpResponse httpResponse) throws JSONException {
        if (httpResponse != null) {
            this.mHttpStatusCode = httpResponse.getStatusCode();
            if (httpResponse.getHeaders() != null) {
                this.mHttpResponseHeaders = new HashMap<>(httpResponse.getHeaders());
            }
            if (httpResponse.getBody() != null) {
                this.mHttpResponseBody = HashMapExtensions.getJsonResponse(httpResponse);
            }
        }
    }

    public ServiceException(String str, String str2, Throwable th) {
        super(str, str2, th);
        this.mHttpResponseBody = null;
        this.mHttpResponseHeaders = null;
        this.mHttpStatusCode = 0;
    }

    public ServiceException(String str, String str2, int i, Throwable th) {
        super(str, str2, th);
        this.mHttpResponseBody = null;
        this.mHttpResponseHeaders = null;
        this.mHttpStatusCode = i;
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }
}
