package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.net.Uri;
import com.microsoft.intune.mam.client.MetaDataReader;
import com.microsoft.intune.mam.client.app.AppUtils;
import com.microsoft.intune.mam.client.app.AuthCallbackUtils;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.http.KnownClouds;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MAMServiceLookupOperationsImpl implements MAMServiceLookupThread.Operations {
    private static final String APPID_NAME = "AppId";
    private static final String APPVERSION_NAME = "AppVersion";
    private static final int CONNECTION_RETRY_COUNT = 3;
    private static final String HEADER_UNLICENSED_RETRY_INTERVAL = "MobileApplicationManagement-RetryAfterMinutes";
    private static final int HTTP_CONNECT_TIMEOUT_MILLIS = 30000;
    private static final int HTTP_FWLINK_SLEEP_RETRY_MILLIS = 50;
    private static final int HTTP_READ_TIMEOUT_MILLIS = 60000;
    private static final String ISTARGETED_URL = "ApplicationInstances(guid'00000000-0000-0000-0000-000000000000')/IsTargeted";
    private static final String OS_NAME = "Os";
    private static final String PLATFORM = "android";
    private static final String SDKVERSION_NAME = "SdkVersion";
    private final MAMServiceAuthenticationCallbackExtended mAuthCallback;
    private final Context mContext;
    private final MAMServiceQueryParameters mMAMServiceQueryParameters;
    private final SSLSocketFactory mSSLSocketFactory;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMServiceLookupOperationsImpl.class);
    public static final long MIN_UNLICENSED_RETRY_INTERVAL_MS = TimeUnit.MINUTES.toMillis(30);
    public static final long MAX_UNLICENSED_RETRY_INTERVAL_MS = TimeUnit.DAYS.toMillis(7);
    private HttpURLConnection mConnection = null;
    private String mRequestId = null;

    public MAMServiceLookupOperationsImpl(Context context, SSLSocketFactory sSLSocketFactory, MAMServiceAuthenticationCallbackExtended mAMServiceAuthenticationCallbackExtended, MAMServiceQueryParameters mAMServiceQueryParameters) {
        this.mContext = context;
        this.mSSLSocketFactory = sSLSocketFactory;
        this.mAuthCallback = mAMServiceAuthenticationCallbackExtended;
        this.mMAMServiceQueryParameters = mAMServiceQueryParameters;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void acquireToken(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (this.mAuthCallback != null) {
            acquireTokenFromCallback(mAMServiceSupportData);
        } else {
            LOGGER.warning("Neither a token nor a callback was provided to MAMServiceLookupOperations.", new Object[0]);
        }
    }

    private void acquireTokenFromCallback(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (validateParamsForAuthCallback(mAMServiceSupportData)) {
            mAMServiceSupportData.mMamServiceToken = AuthCallbackUtils.acquireMAMServiceToken(this.mAuthCallback, mAMServiceSupportData.mIdentity);
            if (mAMServiceSupportData.mMamServiceToken == null) {
                mAMServiceSupportData.mError = MAMWEError.APP_DID_NOT_PROVIDE_TOKEN;
            }
        }
    }

    private boolean validateParamsForAuthCallback(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (mAMServiceSupportData == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_AUTH_CALLBACK, "null supportData passed to acquireTokenFromCallback() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mIdentity.canonicalUPN() == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_AUTH_CALLBACK, "required UPN not provided for acquireTokenFromCallback() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mIdentity.aadId() != null) {
            return true;
        }
        LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_AUTH_CALLBACK, "required AAD ID not provided for acquireTokenFromCallback() -- programmer error.", new Object[0]);
        return false;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void getLookupServiceUrl(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (validateParamsForGetLookupServiceUrl(mAMServiceSupportData)) {
            getLookupServiceUrl(getLookupFWLink(mAMServiceSupportData.mPackageName, mAMServiceSupportData.mIdentity.authority()), mAMServiceSupportData);
        }
    }

    private boolean validateParamsForGetLookupServiceUrl(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (mAMServiceSupportData == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_FETCH, "null supportData passed to getLookupServiceUrl() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mPackageName != null) {
            return true;
        }
        LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_FETCH, "required package name not provided for getLookupServiceUrl() -- programmer error.", new Object[0]);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00bc A[PHI: r2
      0x00bc: PHI (r2v10 java.net.HttpURLConnection) = (r2v4 java.net.HttpURLConnection), (r2v9 java.net.HttpURLConnection), (r2v26 java.net.HttpURLConnection) binds: [B:31:0x00ba, B:26:0x00ab, B:15:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x00bf A[SYNTHETIC] */
    private void getLookupServiceUrl(String str, MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        int responseCode;
        for (int i = 0; i < 3; i++) {
            this.mConnection = null;
            this.mRequestId = null;
            if (i <= 0) {
                mAMServiceSupportData.mError = MAMWEError.NONE_KNOWN;
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                this.mConnection = httpURLConnection3;
                httpURLConnection3.setInstanceFollowRedirects(false);
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setReadTimeout(60000);
                responseCode = this.mConnection.getResponseCode();
                if (responseCode != 302) {
                    LOGGER.warning("Failed to get lookup service url from FWLink; status = " + String.valueOf(responseCode) + " " + this.mConnection.getResponseMessage(), new Object[0]);
                    httpURLConnection2 = this.mConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
                String headerField = this.mConnection.getHeaderField("Location");
                LOGGER.info("Retrieved lookup service URL: {0} ", headerField);
                mAMServiceSupportData.mLookupServiceUrl = headerField;
                httpURLConnection = this.mConnection;
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
                return;
            }
            try {
                try {
                    try {
                        LOGGER.info("Retrying retrieve lookup service URL operation...", new Object[0]);
                        Thread.sleep(50L);
                        mAMServiceSupportData.mError = MAMWEError.NONE_KNOWN;
                        HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL(str).openConnection();
                        this.mConnection = httpURLConnection4;
                        httpURLConnection4.setInstanceFollowRedirects(false);
                        this.mConnection.setConnectTimeout(30000);
                        this.mConnection.setReadTimeout(60000);
                        responseCode = this.mConnection.getResponseCode();
                        if (responseCode != 302 && responseCode != 301) {
                            LOGGER.warning("Failed to get lookup service url from FWLink; status = " + String.valueOf(responseCode) + " " + this.mConnection.getResponseMessage(), new Object[0]);
                            httpURLConnection2 = this.mConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        }
                        String headerField2 = this.mConnection.getHeaderField("Location");
                        LOGGER.info("Retrieved lookup service URL: {0} ", headerField2);
                        mAMServiceSupportData.mLookupServiceUrl = headerField2;
                        httpURLConnection = this.mConnection;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (IOException e) {
                        LOGGER.log(Level.WARNING, "Failed to get lookup service url from FWLink", e);
                        mAMServiceSupportData.mError = MAMWEError.NETWORK_ERROR;
                        httpURLConnection2 = this.mConnection;
                        if (httpURLConnection2 != null) {
                        }
                    }
                } catch (InterruptedException e2) {
                    LOGGER.log(Level.WARNING, "Failed to sleep between fwlink request retries", e2);
                    httpURLConnection2 = this.mConnection;
                    if (httpURLConnection2 != null) {
                    }
                } catch (MalformedURLException e3) {
                    LOGGER.log(Level.WARNING, String.format("Could not create URL from lookup fwlink %s.", str), e3);
                    httpURLConnection = this.mConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
                return;
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection5 = this.mConnection;
                if (httpURLConnection5 != null) {
                    httpURLConnection5.disconnect();
                }
                throw th;
            }
        }
    }

    private String getLookupFWLink(String str, String str2) {
        try {
            String mAMServiceFWLinkOverride = new MetaDataReader(this.mContext, str).getMAMServiceFWLinkOverride();
            if (mAMServiceFWLinkOverride != null) {
                LOGGER.info("overriding default FWLink with manifest value: " + mAMServiceFWLinkOverride, new Object[0]);
                return mAMServiceFWLinkOverride;
            }
        } catch (AssertionError e) {
            LOGGER.log(Level.WARNING, "error looking for FWLink override", e);
        }
        String mAMServiceFWLink = KnownClouds.fromAuthority(str2).getMAMServiceFWLink();
        LOGGER.info("using FWLink value: " + mAMServiceFWLink, new Object[0]);
        return mAMServiceFWLink;
    }

    private boolean isHTTPMAMServiceAllowed() {
        return new MetaDataReader(this.mContext).isDebugHTTPMAMServiceAllowed();
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void queryLookupService(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        HttpURLConnection httpURLConnection;
        if (validateParamsForQueryLookupService(mAMServiceSupportData)) {
            this.mConnection = null;
            this.mRequestId = getActivityId();
            String strAuthHeaderFromToken = MAMServiceAuthentication.authHeaderFromToken(mAMServiceSupportData.mMamServiceToken);
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenSecureConnection = openSecureConnection(new MAMServiceURLBuilderImpl().setURL(new URL(mAMServiceSupportData.mLookupServiceUrl)).setLookupServiceApiVersion().setQueryParameters(this.mMAMServiceQueryParameters).build());
                    this.mConnection = httpURLConnectionOpenSecureConnection;
                    httpURLConnectionOpenSecureConnection.setRequestProperty("Accept", "application/json");
                    this.mConnection.setRequestProperty("Authorization", strAuthHeaderFromToken);
                    this.mConnection.setRequestProperty(APPID_NAME, mAMServiceSupportData.mPackageName);
                    this.mConnection.setRequestProperty("client-request-id", this.mRequestId);
                    this.mConnection.setConnectTimeout(30000);
                    this.mConnection.setReadTimeout(60000);
                    MAMLogger mAMLogger = LOGGER;
                    mAMLogger.info("Querying lookup service with URL: " + mAMServiceSupportData.mLookupServiceUrl + " activity id: " + this.mRequestId, new Object[0]);
                    int responseCode = this.mConnection.getResponseCode();
                    if (responseCode == 200) {
                        String responseContent = getResponseContent(this.mConnection);
                        if (responseContent != null && !responseContent.isEmpty()) {
                            mAMLogger.info("Lookup Service returned response: {0}", responseContent);
                            mAMServiceSupportData.mMamServiceUrls = getUrlsFromJson(responseContent);
                        }
                        mAMLogger.warning("Failed to get MAM service url from lookup service; response body was empty; activity id: {0}", this.mRequestId);
                        HttpURLConnection httpURLConnection2 = this.mConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                    if (responseCode == 404) {
                        mAMServiceSupportData.mUnlicensedRetryIntervalMs = getEnrollmentRetryIntervalFromResponse(this.mConnection);
                    }
                    mAMLogger.warning("Failed to get MAM service url from lookup service; activity id: {0}; status = " + String.valueOf(responseCode) + " " + this.mConnection.getResponseMessage(), this.mRequestId);
                    HttpURLConnection httpURLConnection3 = this.mConnection;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Failed to get MAM service url from lookup service due to network error; activity id: {0}", e, this.mRequestId);
                    mAMServiceSupportData.mError = MAMWEError.NETWORK_ERROR;
                    httpURLConnection = this.mConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e2) {
                    LOGGER.log(Level.WARNING, "Failed to get MAM service url from lookup service; activity id: {0}", e2, this.mRequestId);
                    httpURLConnection = this.mConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection4 = this.mConnection;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
                throw th;
            }
        }
    }

    private static long getEnrollmentRetryIntervalFromResponse(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HEADER_UNLICENSED_RETRY_INTERVAL);
        long millis = MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS;
        if (headerField == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_RETRY_INTERVAL_RESPONSE, "Could not find expected header field in Location Service response: MobileApplicationManagement-RetryAfterMinutes", new Object[0]);
            return MAMWERetryScheduler.DEFAULT_UNLICENSED_RETRY_INTERVAL_MS;
        }
        try {
            millis = TimeUnit.MINUTES.toMillis(Long.parseLong(headerField));
            LOGGER.info("Received {0} = {1} from Location Service.", HEADER_UNLICENSED_RETRY_INTERVAL, Long.valueOf(millis));
        } catch (NumberFormatException e) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_RETRY_INTERVAL_RESPONSE, "Failed to get Location Service retry interval, could not parse header string as long.", e);
        }
        long j = MIN_UNLICENSED_RETRY_INTERVAL_MS;
        if (millis < j) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_RETRY_INTERVAL_RESPONSE, "Location Service sent retry interval that is too short, received {0}, using {1}", Long.valueOf(millis), Long.valueOf(j));
            return j;
        }
        long j2 = MAX_UNLICENSED_RETRY_INTERVAL_MS;
        if (millis <= j2) {
            return millis;
        }
        LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_RETRY_INTERVAL_RESPONSE, "Location Service sent retry interval that is too long, received {0}, using {1}", Long.valueOf(millis), Long.valueOf(j2));
        return j2;
    }

    private boolean validateParamsForQueryLookupService(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (mAMServiceSupportData == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_QUERY, "null supportData passed to queryLookupService() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mMamServiceToken == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_QUERY, "required MAMService token not provided for queryLookupService() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mLookupServiceUrl == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_QUERY, "required lookup service URL not provided for queryLookupService() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mPackageName != null) {
            return true;
        }
        LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_QUERY, "required package name not provided for queryLookupService() -- programmer error.", new Object[0]);
        return false;
    }

    private static String getResponseContent(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        if (inputStream == null) {
            return null;
        }
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        while (true) {
            int i = inputStreamReader.read(cArr, 0, 1024);
            if (i >= 0) {
                sb.append(cArr, 0, i);
            } else {
                return sb.toString();
            }
        }
    }

    private static Map<String, String> getUrlsFromJson(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("Services");
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("ServiceName");
            String string2 = jSONObject.getString("Url");
            LOGGER.info("found service {0} with URL {1}", string, string2);
            map.put(string.toLowerCase(Locale.US), string2);
        }
        return map;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public void getIsTargeted(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        HttpURLConnection httpURLConnection;
        if (validateParamsForGetIsTargeted(mAMServiceSupportData)) {
            String strAuthHeaderFromToken = MAMServiceAuthentication.authHeaderFromToken(mAMServiceSupportData.mMamServiceToken);
            this.mConnection = null;
            this.mRequestId = getActivityId();
            try {
                try {
                    String isTargetedPostBody = getIsTargetedPostBody(mAMServiceSupportData.mPackageName);
                    MAMLogger mAMLogger = LOGGER;
                    mAMLogger.info("Checking if user is targeted for policy.  POSTing " + isTargetedPostBody + " with activity id: " + this.mRequestId, new Object[0]);
                    this.mConnection = getIsTargetedPostConnection(mAMServiceSupportData.getMAMServiceUrl(), strAuthHeaderFromToken, isTargetedPostBody, this.mRequestId);
                    DataOutputStream dataOutputStream = new DataOutputStream(this.mConnection.getOutputStream());
                    dataOutputStream.writeBytes(isTargetedPostBody);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    int responseCode = this.mConnection.getResponseCode();
                    if (responseCode == 200) {
                        String responseContent = getResponseContent(this.mConnection);
                        if (responseContent != null && !responseContent.isEmpty()) {
                            mAMLogger.info("IsTargeted response: {0} ", responseContent);
                            mAMServiceSupportData.mIsTargeted = Boolean.valueOf(new JSONObject(responseContent).getBoolean("value"));
                        }
                        mAMLogger.warning("Failed to get JSON response from MAM Service; response body was empty.", new Object[0]);
                        HttpURLConnection httpURLConnection2 = this.mConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                    mAMLogger.warning("Failed to get JSON response from MAM Service; activity id: {0}; status = " + String.valueOf(responseCode) + " " + this.mConnection.getResponseMessage(), this.mRequestId);
                    HttpURLConnection httpURLConnection3 = this.mConnection;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Failed to query the MAMService for policy targeting due to network error, activity id: {0}", e, this.mRequestId);
                    mAMServiceSupportData.mError = MAMWEError.NETWORK_ERROR;
                    httpURLConnection = this.mConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e2) {
                    LOGGER.log(Level.WARNING, "Failed to query the MAMService for policy targeting, activity id: {0}", e2, this.mRequestId);
                    httpURLConnection = this.mConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection4 = this.mConnection;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
                throw th;
            }
        }
    }

    private boolean validateParamsForGetIsTargeted(MAMServiceLookupThread.MAMServiceSupportData mAMServiceSupportData) {
        if (mAMServiceSupportData == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_IS_TARGETED, "null supportData passed to getIsTargeted() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mMamServiceToken == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_IS_TARGETED, "required MAMService token not provided for getIsTargeted() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.getMAMServiceUrl() == null) {
            LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_IS_TARGETED, "required MAMService URL not provided for getIsTargeted() -- programmer error.", new Object[0]);
            return false;
        }
        if (mAMServiceSupportData.mPackageName != null) {
            return true;
        }
        LOGGER.error(MAMInterfaceError.LOOKUP_INVALID_PARAMS_FOR_IS_TARGETED, "required package name not provided for getIsTargeted() -- programmer error.", new Object[0]);
        return false;
    }

    private String getIsTargetedPostBody(String str) throws JSONException {
        String packageVersion = AppUtils.getPackageVersion(this.mContext, str, "1.0");
        String strVersionString = MAMServiceReleaseVersion.versionString();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(APPID_NAME, str);
        jSONObject.put(APPVERSION_NAME, packageVersion);
        jSONObject.put(SDKVERSION_NAME, strVersionString);
        jSONObject.put(OS_NAME, "android");
        return jSONObject.toString();
    }

    private HttpURLConnection getIsTargetedPostConnection(String str, String str2, String str3, String str4) throws IOException {
        HttpURLConnection httpURLConnectionOpenSecureConnection = openSecureConnection(new MAMServiceURLBuilderImpl().setURL(new URL(Uri.withAppendedPath(Uri.parse(str), ISTARGETED_URL).toString())).setIsTargetedApiVersion().setQueryParameters(this.mMAMServiceQueryParameters).build());
        httpURLConnectionOpenSecureConnection.setRequestMethod("POST");
        httpURLConnectionOpenSecureConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnectionOpenSecureConnection.setRequestProperty("Authorization", str2);
        httpURLConnectionOpenSecureConnection.setRequestProperty("Prefer", "return-content");
        httpURLConnectionOpenSecureConnection.setRequestProperty("Content-Length", "" + Integer.toString(str3.getBytes().length));
        httpURLConnectionOpenSecureConnection.setRequestProperty("client-request-id", str4);
        httpURLConnectionOpenSecureConnection.setUseCaches(false);
        httpURLConnectionOpenSecureConnection.setDoInput(true);
        httpURLConnectionOpenSecureConnection.setDoOutput(true);
        httpURLConnectionOpenSecureConnection.setConnectTimeout(30000);
        httpURLConnectionOpenSecureConnection.setReadTimeout(60000);
        return httpURLConnectionOpenSecureConnection;
    }

    private String getActivityId() {
        return "{" + UUID.randomUUID().toString().toUpperCase(Locale.getDefault()) + "}";
    }

    private HttpURLConnection openSecureConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
        if (sSLSocketFactory != null) {
            if (!(httpURLConnection instanceof HttpsURLConnection)) {
                if (!isHTTPMAMServiceAllowed()) {
                    throw new MalformedURLException("https scheme is required for MAMService URLs.  Invalid URL: " + url.toString());
                }
            } else {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return httpURLConnection;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public HttpURLConnection getLastConnection() {
        return this.mConnection;
    }

    @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Operations
    public String getLastRequestId() {
        return this.mRequestId;
    }
}
