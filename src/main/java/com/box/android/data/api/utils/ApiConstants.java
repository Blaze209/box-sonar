package com.box.android.data.api.utils;

import com.box.androidsdk.content.utils.OAuthUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApiConstants.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/utils/ApiConstants;", "", "<init>", "()V", "BASE_URI", "", "BASE_URI_FEDRAMP", "BASE_URI_APP", "BASE_URI_ENT", "BASE_URI_APP_FEDRAMP", "BASE_URI_ENT_FEDRAMP", "UPLOAD_URI", "UPLOAD_URI_FEDRAMP", "BASE_URI_CLOUD_APP", "BASE_URI_CLOUD_ENT", "FILES_RESOURCE", "API", "APP_API", "COLLECTIONS_CFF", "APP_2_0", "UNDOC", "TOKEN_ENDPOINT", "UPLOADS_ENDPOINT", "INTELLIGENCE_ENDPOINT", "UPLOAD_SESSION_ENDPOINT", "METRICS_ENDPOINT", "MSAL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ApiConstants {
    public static final String API = "api/";
    public static final String APP_2_0 = "2.0/";
    public static final String APP_API = "app-api/";
    public static final String BASE_URI = "https://api.box.com/";
    public static final String BASE_URI_APP = "https://app.box.com/";
    public static final String BASE_URI_APP_FEDRAMP = "https://app.box-gov.com/";
    public static final String BASE_URI_CLOUD_APP = "https://cloud.app.box.com";
    public static final String BASE_URI_CLOUD_ENT = "https://cloud.ent.box.com";
    public static final String BASE_URI_ENT = "https://ent.box.com/";
    public static final String BASE_URI_ENT_FEDRAMP = "https://ent.box-gov.com/";
    public static final String BASE_URI_FEDRAMP = "https://api.box-gov.com/";
    public static final String COLLECTIONS_CFF = "collections_cff/";
    public static final String FILES_RESOURCE = "files/";
    public static final ApiConstants INSTANCE = new ApiConstants();
    public static final String INTELLIGENCE_ENDPOINT = "intelligence";
    public static final String METRICS_ENDPOINT = "index.php?rm=box_gen204_client_analytics";
    public static final String TOKEN_ENDPOINT = "oauth2/token";
    public static final String UNDOC = "undoc/";
    public static final String UPLOADS_ENDPOINT = "content";
    public static final String UPLOAD_SESSION_ENDPOINT = "upload_sessions";
    public static final String UPLOAD_URI = "https://upload.box.com/";
    public static final String UPLOAD_URI_FEDRAMP = "https://upload.box-gov.com/";

    private ApiConstants() {
    }

    /* JADX INFO: compiled from: ApiConstants.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/utils/ApiConstants$MSAL;", "", "<init>", "()V", "MSAL_AUTH_BASE_URI", "", "MSAL_AUTH_ENDPOINT", "MSAL_REDIRECT_URI", "MSAL_AUTH_TYPE", "MSAL_CODE", "MSAL_STATE", "getMSAL_STATE", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MSAL {
        public static final String MSAL_AUTH_BASE_URI = "https://account.box.com/";
        public static final String MSAL_AUTH_ENDPOINT = "oauth2/authorize";
        public static final String MSAL_AUTH_TYPE = "msal";
        public static final String MSAL_CODE = "code";
        public static final String MSAL_REDIRECT_URI = "boxlogin://login";
        public static final MSAL INSTANCE = new MSAL();
        private static final String MSAL_STATE = OAuthUtils.generateStateToken();

        private MSAL() {
        }

        public final String getMSAL_STATE() {
            return MSAL_STATE;
        }
    }
}
