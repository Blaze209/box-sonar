package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftAuthorizationResponse extends AuthorizationResponse {
    public static final String CLOUD_GRAPH_HOST_NAME = "cloud_graph_host_name";
    public static final String CLOUD_INSTANCE_HOST_NAME = "cloud_instance_host_name";
    public static final String CLOUD_INSTANCE_NAME = "cloud_instance_name";
    public static final String DEVICE_CODE = "device_code";
    public static final String EXPIRES_IN = "expires_in";
    public static final String INTERVAL = "interval";
    public static final String MESSAGE = "message";
    public static final String SESSION_STATE = "session_state";
    public static final String USER_CODE = "user_code";
    public static final String VERIFICATION_URI = "verification_uri";

    @Expose
    protected String mCloudGraphHostName;

    @Expose
    protected String mCloudInstanceHostName;

    @Expose
    protected String mCloudInstanceName;

    @Expose
    protected String mCorrelationId;

    @Expose
    protected String mDeviceCode;

    @Expose
    protected String mExpiresIn;

    @Expose
    protected String mInterval;

    @Expose
    protected String mMessage;

    @Expose
    protected String mSessionState;

    @Expose
    protected String mUserCode;

    @Expose
    protected String mVerificationUri;

    public MicrosoftAuthorizationResponse(String str, String str2) {
        super(str, str2);
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public void setCorrelationId(String str) {
        this.mCorrelationId = str;
    }

    public String getCloudInstanceName() {
        return this.mCloudInstanceName;
    }

    public String getCloudInstanceHostName() {
        return this.mCloudInstanceHostName;
    }

    public String getCloudGraphHostName() {
        return this.mCloudGraphHostName;
    }

    public String getSessionState() {
        return this.mSessionState;
    }

    public String getDeviceCode() {
        return this.mDeviceCode;
    }

    public String getUserCode() {
        return this.mUserCode;
    }

    public String getVerificationUri() {
        return this.mVerificationUri;
    }

    public String getExpiresIn() {
        return this.mExpiresIn;
    }

    public String getInterval() {
        return this.mInterval;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
