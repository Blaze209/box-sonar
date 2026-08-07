package com.box.androidsdk.content.requests;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxCacheFutureTask;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.auth.BlockedIPErrorActivity;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.listeners.ProgressListener;
import com.box.androidsdk.content.models.BoxArray;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequest<T extends BoxObject, R extends BoxRequest<T, R>> implements Serializable {
    private static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String JSON_OBJECT = "json_object";
    protected LinkedHashMap<String, Object> mBodyMap;
    Class<T> mClazz;
    protected ContentTypes mContentType;
    protected LinkedHashMap<String, String> mHeaderMap;
    private String mIfMatchEtag;
    private String mIfNoneMatchEtag;
    protected transient ProgressListener mListener;
    protected HashMap<String, String> mQueryMap;
    transient BoxRequestHandler mRequestHandler;
    protected Methods mRequestMethod;
    protected String mRequestUrlString;
    protected boolean mRequiresSocket;
    protected BoxSession mSession;
    private transient WeakReference<SSLSocketFactoryWrapper> mSocketFactoryRef;
    private String mStringBody;
    protected int mTimeout;
    private UUID requestId;

    public enum Methods {
        GET,
        POST,
        PUT,
        DELETE,
        OPTIONS
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Lcom/box/androidsdk/content/requests/BoxRequest;:Lcom/box/androidsdk/content/requests/BoxCacheableRequest;>()TT; */
    private BoxRequest getCacheableRequest() {
        return this;
    }

    protected void onSendCompleted(BoxResponse<T> boxResponse) throws BoxException {
    }

    protected BoxRequest(Class<T> cls, String str, BoxSession boxSession) {
        this.mQueryMap = new HashMap<>();
        this.mBodyMap = new LinkedHashMap<>();
        this.mHeaderMap = new LinkedHashMap<>();
        this.mContentType = ContentTypes.JSON;
        this.mRequiresSocket = false;
        this.mClazz = cls;
        this.mRequestUrlString = str;
        this.mSession = boxSession;
        this.requestId = UUID.randomUUID();
        setRequestHandler(new BoxRequestHandler(this));
    }

    protected BoxRequest(BoxRequest boxRequest) {
        this.mQueryMap = new HashMap<>();
        this.mBodyMap = new LinkedHashMap<>();
        this.mHeaderMap = new LinkedHashMap<>();
        this.mContentType = ContentTypes.JSON;
        this.mRequiresSocket = false;
        this.mSession = boxRequest.getSession();
        this.mClazz = boxRequest.mClazz;
        this.mRequestHandler = boxRequest.getRequestHandler();
        this.mRequestMethod = boxRequest.mRequestMethod;
        this.mContentType = boxRequest.mContentType;
        this.mIfMatchEtag = boxRequest.getIfMatchEtag();
        this.mListener = boxRequest.mListener;
        this.mRequestUrlString = boxRequest.mRequestUrlString;
        this.mIfNoneMatchEtag = boxRequest.getIfNoneMatchEtag();
        this.mTimeout = boxRequest.mTimeout;
        this.mStringBody = boxRequest.mStringBody;
        this.requestId = boxRequest.getRequestId();
        importRequestContentMapsFrom(boxRequest);
    }

    protected void importRequestContentMapsFrom(BoxRequest boxRequest) {
        this.mQueryMap = new HashMap<>(boxRequest.mQueryMap);
        this.mBodyMap = new LinkedHashMap<>(boxRequest.mBodyMap);
    }

    public BoxSession getSession() {
        return this.mSession;
    }

    public BoxRequestHandler getRequestHandler() {
        return this.mRequestHandler;
    }

    public R setRequestHandler(BoxRequestHandler boxRequestHandler) {
        this.mRequestHandler = boxRequestHandler;
        return this;
    }

    public R setContentType(ContentTypes contentTypes) {
        this.mContentType = contentTypes;
        return this;
    }

    public R setTimeOut(int i) {
        this.mTimeout = i;
        return this;
    }

    public final T send() throws BoxException {
        T t = null;
        try {
            e = null;
            t = (T) onSend();
        } catch (Exception e) {
            e = e;
        }
        onSendCompleted(new BoxResponse<>(t, e, this));
        if (e == null) {
            return t;
        }
        if (e instanceof BoxException) {
            throw ((BoxException) e);
        }
        throw new BoxException("unexpected exception ", e);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0096: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:55:0x0096 */
    protected T onSend() throws Throwable {
        HttpURLConnection urlConnection;
        HttpURLConnection httpURLConnection;
        BoxRequestHandler requestHandler = getRequestHandler();
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                BoxHttpRequest boxHttpRequestCreateHttpRequest = createHttpRequest();
                urlConnection = boxHttpRequestCreateHttpRequest.getUrlConnection();
                try {
                    if (this.mRequiresSocket && (urlConnection instanceof HttpsURLConnection)) {
                        SSLSocketFactoryWrapper sSLSocketFactoryWrapper = new SSLSocketFactoryWrapper(((HttpsURLConnection) urlConnection).getSSLSocketFactory());
                        this.mSocketFactoryRef = new WeakReference<>(sSLSocketFactoryWrapper);
                        ((HttpsURLConnection) urlConnection).setSSLSocketFactory(sSLSocketFactoryWrapper);
                    }
                    int i = this.mTimeout;
                    if (i > 0) {
                        urlConnection.setConnectTimeout(i);
                        urlConnection.setReadTimeout(this.mTimeout);
                    }
                    BoxHttpResponse boxHttpResponseSendRequest = sendRequest(boxHttpRequestCreateHttpRequest, urlConnection);
                    logDebug(boxHttpResponseSendRequest);
                    if (!requestHandler.isResponseSuccess(boxHttpResponseSendRequest)) {
                        throw new BoxException("An error occurred while sending the request", boxHttpResponseSendRequest);
                    }
                    T t = (T) requestHandler.onResponse(this.mClazz, boxHttpResponseSendRequest);
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    return t;
                } catch (BoxException e) {
                    e = e;
                    T t2 = (T) handleSendException(requestHandler, null, e);
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    return t2;
                } catch (IOException e2) {
                    e = e2;
                    T t3 = (T) handleSendException(requestHandler, null, e);
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    return t3;
                } catch (IllegalAccessException e3) {
                    e = e3;
                    T t4 = (T) handleSendException(requestHandler, null, e);
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    return t4;
                } catch (InstantiationException e4) {
                    e = e4;
                    T t5 = (T) handleSendException(requestHandler, null, e);
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    return t5;
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (BoxException e5) {
            e = e5;
            urlConnection = null;
        } catch (IOException e6) {
            e = e6;
            urlConnection = null;
        } catch (IllegalAccessException e7) {
            e = e7;
            urlConnection = null;
        } catch (InstantiationException e8) {
            e = e8;
            urlConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    private T handleSendException(BoxRequestHandler boxRequestHandler, BoxHttpResponse boxHttpResponse, Exception exc) throws BoxException {
        if (exc instanceof BoxException) {
            BoxException boxException = (BoxException) exc;
            if (boxRequestHandler.onException(this, boxHttpResponse, boxException)) {
                return (T) send();
            }
            throw boxException;
        }
        BoxException boxException2 = new BoxException("Couldn't connect to the Box API due to a network error.", exc);
        boxRequestHandler.onException(this, boxHttpResponse, boxException2);
        throw boxException2;
    }

    public BoxFutureTask<T> toTask() {
        return new BoxFutureTask<>(this.mClazz, this);
    }

    protected BoxHttpRequest createHttpRequest() throws BoxException, IOException {
        BoxHttpRequest boxHttpRequest = new BoxHttpRequest(buildUrl(), this.mRequestMethod, this.mListener);
        setHeaders(boxHttpRequest);
        setBody(boxHttpRequest);
        return boxHttpRequest;
    }

    protected BoxHttpResponse sendRequest(BoxHttpRequest boxHttpRequest, HttpURLConnection httpURLConnection) throws BoxException, IOException {
        BoxHttpResponse boxHttpResponse = new BoxHttpResponse(httpURLConnection);
        boxHttpResponse.open();
        return boxHttpResponse;
    }

    protected URL buildUrl() throws MalformedURLException, UnsupportedEncodingException {
        String strCreateQuery = createQuery(this.mQueryMap);
        return TextUtils.isEmpty(strCreateQuery) ? new URL(this.mRequestUrlString) : new URL(String.format(Locale.ENGLISH, "%s?%s", this.mRequestUrlString, strCreateQuery));
    }

    protected String createQuery(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        String str = "%s=%s";
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                sb.append(String.format(Locale.ENGLISH, str, URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8")));
                if (z) {
                    str = MsalUtils.QUERY_STRING_DELIMITER + str;
                    z = false;
                }
            }
        }
        return sb.toString();
    }

    protected void createHeaderMap() {
        this.mHeaderMap.clear();
        BoxAuthentication.BoxAuthenticationInfo authInfo = this.mSession.getAuthInfo();
        String strAccessToken = authInfo == null ? null : authInfo.accessToken();
        if (!SdkUtils.isEmptyString(strAccessToken)) {
            this.mHeaderMap.put("Authorization", String.format(Locale.ENGLISH, "Bearer %s", strAccessToken));
        }
        this.mHeaderMap.put("User-Agent", this.mSession.getUserAgent());
        this.mHeaderMap.put("Accept-Encoding", "gzip");
        this.mHeaderMap.put("Accept-Charset", "utf-8");
        ContentTypes contentTypes = this.mContentType;
        if (contentTypes != null) {
            this.mHeaderMap.put("Content-Type", contentTypes.toString());
        }
        String str = this.mIfMatchEtag;
        if (str != null) {
            this.mHeaderMap.put("If-Match", str);
        }
        String str2 = this.mIfNoneMatchEtag;
        if (str2 != null) {
            this.mHeaderMap.put("If-None-Match", str2);
        }
        BoxSession boxSession = this.mSession;
        if (boxSession instanceof BoxSharedLinkSession) {
            BoxSharedLinkSession boxSharedLinkSession = (BoxSharedLinkSession) boxSession;
            if (TextUtils.isEmpty(boxSharedLinkSession.getSharedLink())) {
                return;
            }
            String str3 = String.format(Locale.ENGLISH, "shared_link=%s", boxSharedLinkSession.getSharedLink());
            if (!TextUtils.isEmpty(boxSharedLinkSession.getPassword())) {
                str3 = str3 + String.format(Locale.ENGLISH, "&shared_link_password=%s", boxSharedLinkSession.getPassword());
            }
            this.mHeaderMap.put(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK, str3);
        }
    }

    protected void setHeaders(BoxHttpRequest boxHttpRequest) {
        createHeaderMap();
        for (Map.Entry<String, String> entry : this.mHeaderMap.entrySet()) {
            boxHttpRequest.addHeader(entry.getKey(), entry.getValue());
        }
    }

    protected R setIfMatchEtag(String str) {
        this.mIfMatchEtag = str;
        return this;
    }

    protected String getIfMatchEtag() {
        return this.mIfMatchEtag;
    }

    protected R setIfNoneMatchEtag(String str) {
        this.mIfNoneMatchEtag = str;
        return this;
    }

    protected String getIfNoneMatchEtag() {
        return this.mIfNoneMatchEtag;
    }

    protected void setBody(BoxHttpRequest boxHttpRequest) throws IOException {
        if (this.mBodyMap.isEmpty()) {
            return;
        }
        boxHttpRequest.setBody(new ByteArrayInputStream(getStringBody().getBytes("UTF-8")));
    }

    public String getStringBody() throws UnsupportedEncodingException {
        String str = this.mStringBody;
        if (str != null) {
            return str;
        }
        if (this.mContentType != null) {
            int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes[this.mContentType.ordinal()];
            if (i == 1) {
                JsonObject jsonObject = new JsonObject();
                Iterator<Map.Entry<String, Object>> it = this.mBodyMap.entrySet().iterator();
                while (it.hasNext()) {
                    parseHashMapEntry(jsonObject, it.next());
                }
                this.mStringBody = jsonObject.toString();
            } else if (i == 2) {
                HashMap map = new HashMap();
                for (Map.Entry<String, Object> entry : this.mBodyMap.entrySet()) {
                    map.put(entry.getKey(), (String) entry.getValue());
                }
                this.mStringBody = createQuery(map);
            } else if (i == 3) {
                this.mStringBody = ((BoxArray) this.mBodyMap.get(JSON_OBJECT)).toJson();
            }
        }
        return this.mStringBody;
    }

    /* JADX INFO: renamed from: com.box.androidsdk.content.requests.BoxRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes;

        static {
            int[] iArr = new int[ContentTypes.values().length];
            $SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes = iArr;
            try {
                iArr[ContentTypes.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes[ContentTypes.URL_ENCODED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes[ContentTypes.JSON_PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes[ContentTypes.APPLICATION_OCTET_STREAM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected void parseHashMapEntry(JsonObject jsonObject, Map.Entry<String, Object> entry) {
        Object value = entry.getValue();
        if (value instanceof BoxJsonObject) {
            jsonObject.add(entry.getKey(), parseJsonObject(value));
            return;
        }
        if (value instanceof Double) {
            jsonObject.add(entry.getKey(), Double.toString(((Double) value).doubleValue()));
            return;
        }
        if ((value instanceof Enum) || (value instanceof Boolean)) {
            jsonObject.add(entry.getKey(), value.toString());
            return;
        }
        if (value instanceof JsonArray) {
            jsonObject.add(entry.getKey(), (JsonArray) value);
            return;
        }
        if (value instanceof Long) {
            jsonObject.add(entry.getKey(), JsonValue.valueOf(((Long) value).longValue()));
            return;
        }
        if (value instanceof Integer) {
            jsonObject.add(entry.getKey(), JsonValue.valueOf(((Integer) value).intValue()));
            return;
        }
        if (value instanceof Float) {
            jsonObject.add(entry.getKey(), JsonValue.valueOf(((Float) value).floatValue()));
        } else if (value instanceof String) {
            jsonObject.add(entry.getKey(), (String) value);
        } else {
            BoxLogUtils.e("Unable to parse value " + value, new RuntimeException("Invalid value"));
        }
    }

    protected JsonValue parseJsonObject(Object obj) {
        return JsonValue.readFrom(((BoxJsonObject) obj).toJson());
    }

    protected void logDebug(BoxHttpResponse boxHttpResponse) throws BoxException {
        try {
            logRequest();
            BoxLogUtils.v(BoxConstants.TAG, String.format(Locale.ENGLISH, "Response (%s):  %s", Integer.valueOf(boxHttpResponse.getResponseCode()), boxHttpResponse.getStringBody()));
        } catch (Exception e) {
            BoxLogUtils.e("logDebug", e);
        }
    }

    protected void logRequest() {
        String string;
        try {
            string = buildUrl().toString();
        } catch (UnsupportedEncodingException | MalformedURLException unused) {
            string = null;
        }
        BoxLogUtils.v(BoxConstants.TAG, String.format(Locale.ENGLISH, "Request (%s):  %s", this.mRequestMethod, string));
        HashMap map = new HashMap(this.mHeaderMap);
        String str = (String) map.get("Authorization");
        if (str != null) {
            map.put("Authorization", str.length() > 15 ? str.substring(0, 15) + "***" : "***");
        }
        BoxLogUtils.v(BoxConstants.TAG, "Request Header", map);
        if (this.mContentType != null) {
            int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$requests$BoxRequest$ContentTypes[this.mContentType.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    HashMap map2 = new HashMap();
                    for (Map.Entry<String, Object> entry : this.mBodyMap.entrySet()) {
                        map2.put(entry.getKey(), (String) entry.getValue());
                    }
                    BoxLogUtils.v(BoxConstants.TAG, "Request Form Data", map2);
                    return;
                }
                if (i != 3) {
                    return;
                }
            }
            if (SdkUtils.isBlank(this.mStringBody)) {
                return;
            }
            BoxLogUtils.v(BoxConstants.TAG, String.format(Locale.ENGLISH, "Request JSON:  %s", this.mStringBody));
        }
    }

    protected T handleSendForCachedResult() throws BoxException {
        BoxCache cache = BoxConfig.getCache();
        if (cache == null) {
            throw new BoxException.CacheImplementationNotFound();
        }
        return (T) cache.get(getCacheableRequest());
    }

    protected <R extends BoxRequest & BoxCacheableRequest> BoxFutureTask<T> handleToTaskForCachedResult() throws BoxException {
        BoxCache cache = BoxConfig.getCache();
        if (cache == null) {
            throw new BoxException.CacheImplementationNotFound();
        }
        return new BoxCacheFutureTask(this.mClazz, getCacheableRequest(), cache);
    }

    protected void handleUpdateCache(BoxResponse<T> boxResponse) throws BoxException {
        BoxCache cache = BoxConfig.getCache();
        if (cache != null) {
            cache.put(boxResponse);
        }
    }

    public static class BoxRequestHandler<R extends BoxRequest> {
        private static final int DEFAULT_AUTH_REFRESH_RETRY = 4;
        protected static final int DEFAULT_NUM_RETRIES = 1;
        protected static final int DEFAULT_RATE_LIMIT_WAIT = 20;
        public static final String OAUTH_ERROR_HEADER = "error";
        public static final String OAUTH_INVALID_TOKEN = "invalid_token";
        public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
        protected int mNumRateLimitRetries = 0;
        private int mRefreshRetries = 0;
        protected R mRequest;

        public BoxRequestHandler(R r) {
            this.mRequest = r;
        }

        public boolean isResponseSuccess(BoxHttpResponse boxHttpResponse) {
            int responseCode = boxHttpResponse.getResponseCode();
            return (responseCode >= 200 && responseCode < 300) || responseCode == 429;
        }

        public <T extends BoxObject> T onResponse(Class<T> cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
            if (boxHttpResponse.getResponseCode() == 429) {
                return (T) retryRateLimited(boxHttpResponse);
            }
            if (Thread.currentThread().isInterrupted()) {
                disconnectForInterrupt(boxHttpResponse);
            }
            String contentType = boxHttpResponse.getContentType();
            T tNewInstance = cls.newInstance();
            if ((tNewInstance instanceof BoxJsonObject) && contentType.contains(ContentTypes.JSON.toString())) {
                ((BoxJsonObject) tNewInstance).createFromJson(boxHttpResponse.getStringBody());
            }
            return tNewInstance;
        }

        protected <T extends BoxObject> T retryRateLimited(BoxHttpResponse boxHttpResponse) throws BoxException {
            int i = this.mNumRateLimitRetries;
            if (i < 1) {
                this.mNumRateLimitRetries = i + 1;
                try {
                    Thread.sleep(getRetryAfterFromResponse(boxHttpResponse, ((int) (Math.random() * 10.0d)) + 20));
                    return (T) this.mRequest.send();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new BoxException(e.getMessage(), e);
                }
            }
            throw new BoxException.RateLimitAttemptsExceeded("Max attempts exceeded", this.mNumRateLimitRetries, boxHttpResponse);
        }

        protected void disconnectForInterrupt(BoxHttpResponse boxHttpResponse) throws BoxException {
            try {
                boxHttpResponse.getHttpURLConnection().disconnect();
            } catch (Exception e) {
                BoxLogUtils.e("Interrupt disconnect", e);
            }
            throw new BoxException("Thread interrupted request cancelled ", new InterruptedException());
        }

        public boolean onException(BoxRequest boxRequest, BoxHttpResponse boxHttpResponse, BoxException boxException) throws BoxException.RefreshFailure {
            BoxException.ErrorType errorType;
            BoxSession session = boxRequest.getSession();
            if (oauthExpired(boxHttpResponse)) {
                try {
                    BoxResponse boxResponse = session.refresh().get();
                    if (boxResponse.isSuccess()) {
                        return true;
                    }
                    if (boxResponse.getException() == null || !(boxResponse.getException() instanceof BoxException.RefreshFailure)) {
                        return false;
                    }
                    throw ((BoxException.RefreshFailure) boxResponse.getException());
                } catch (InterruptedException e) {
                    BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e2) {
                    BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e2);
                }
            } else if (authFailed(boxHttpResponse)) {
                BoxException.ErrorType errorType2 = boxException.getErrorType();
                if (!session.suppressesAuthErrorUIAfterLogin()) {
                    Context applicationContext = session.getApplicationContext();
                    if (errorType2 == BoxException.ErrorType.IP_BLOCKED || errorType2 == BoxException.ErrorType.LOCATION_BLOCKED) {
                        Intent intent = new Intent(session.getApplicationContext(), (Class<?>) BlockedIPErrorActivity.class);
                        intent.addFlags(268435456);
                        applicationContext.startActivity(intent);
                        return false;
                    }
                    if (errorType2 == BoxException.ErrorType.TERMS_OF_SERVICE_REQUIRED) {
                        SdkUtils.toastSafely(applicationContext, R.string.boxsdk_error_terms_of_service, 1);
                    }
                    try {
                        if (this.mRefreshRetries > 4) {
                            String str = " Exceeded max refresh retries for " + boxRequest.getClass().getName() + " response code" + boxException.getResponseCode() + " response " + boxHttpResponse;
                            if (boxException.getAsBoxError() != null) {
                                str = str + boxException.getAsBoxError().toJson();
                            }
                            BoxLogUtils.logException("authFailed", str, boxException);
                            return false;
                        }
                        BoxResponse boxResponse2 = session.refresh().get();
                        if (boxResponse2.isSuccess()) {
                            this.mRefreshRetries++;
                            return true;
                        }
                        if (boxResponse2.getException() == null || !(boxResponse2.getException() instanceof BoxException.RefreshFailure)) {
                            return false;
                        }
                        throw ((BoxException.RefreshFailure) boxResponse2.getException());
                    } catch (InterruptedException e3) {
                        BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e3);
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e4) {
                        BoxLogUtils.e("oauthRefresh", "Interrupted Exception", e4);
                    }
                }
            } else if (boxHttpResponse != null && boxHttpResponse.getResponseCode() == 403 && ((errorType = boxException.getErrorType()) == BoxException.ErrorType.IP_BLOCKED || errorType == BoxException.ErrorType.LOCATION_BLOCKED)) {
                Context applicationContext2 = session.getApplicationContext();
                Intent intent2 = new Intent(session.getApplicationContext(), (Class<?>) BlockedIPErrorActivity.class);
                intent2.addFlags(268435456);
                applicationContext2.startActivity(intent2);
            }
            return false;
        }

        protected static int getRetryAfterFromResponse(BoxHttpResponse boxHttpResponse, int i) {
            String headerField = boxHttpResponse.getHttpURLConnection().getHeaderField("Retry-After");
            if (!SdkUtils.isBlank(headerField)) {
                try {
                    i = Integer.parseInt(headerField);
                } catch (NumberFormatException unused) {
                }
                if (i <= 0) {
                    i = 1;
                }
            }
            return i * 1000;
        }

        private boolean authFailed(BoxHttpResponse boxHttpResponse) {
            return boxHttpResponse != null && boxHttpResponse.getResponseCode() == 401;
        }

        private boolean oauthExpired(BoxHttpResponse boxHttpResponse) {
            if (boxHttpResponse == null || 401 != boxHttpResponse.getResponseCode()) {
                return false;
            }
            String headerField = boxHttpResponse.mConnection.getHeaderField("WWW-Authenticate");
            if (!SdkUtils.isEmptyString(headerField)) {
                for (String str : headerField.split(",")) {
                    if (isInvalidTokenError(str)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isInvalidTokenError(String str) {
            String str2;
            String[] strArrSplit = str.split(SimpleComparison.EQUAL_TO_OPERATION);
            return strArrSplit.length == 2 && (str2 = strArrSplit[0]) != null && strArrSplit[1] != null && "error".equalsIgnoreCase(str2.trim()) && OAUTH_INVALID_TOKEN.equalsIgnoreCase(strArrSplit[1].replace("\"", "").trim());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.mRequestHandler = new BoxRequestHandler(this);
    }

    public UUID getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mRequestMethod);
        sb.append(this.mRequestUrlString);
        appendPairsToStringBuilder(sb, this.mHeaderMap);
        appendPairsToStringBuilder(sb, this.mQueryMap);
        return sb.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BoxRequest)) {
            return false;
        }
        BoxRequest boxRequest = (BoxRequest) obj;
        return this.mRequestMethod == boxRequest.mRequestMethod && this.mRequestUrlString.equals(boxRequest.mRequestUrlString) && areMapsSame(this.mHeaderMap, boxRequest.mHeaderMap) && areMapsSame(this.mQueryMap, boxRequest.mQueryMap);
    }

    private void appendPairsToStringBuilder(StringBuilder sb, HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
    }

    private boolean areMapsSame(Map<String, String> map, Map<String, String> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getValue().equalsIgnoreCase(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public enum ContentTypes {
        JSON("application/json"),
        URL_ENCODED("application/x-www-form-urlencoded"),
        JSON_PATCH("application/json-patch+json"),
        APPLICATION_OCTET_STREAM("application/octet-stream");

        private String mName;

        ContentTypes(String str) {
            this.mName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mName;
        }
    }

    protected Socket getSocket() {
        WeakReference<SSLSocketFactoryWrapper> weakReference = this.mSocketFactoryRef;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.mSocketFactoryRef.get().getSocket();
    }

    static class SSLSocketFactoryWrapper extends SSLSocketFactory {
        public SSLSocketFactory mFactory;
        private WeakReference<Socket> mSocket;

        public SSLSocketFactoryWrapper(SSLSocketFactory sSLSocketFactory) {
            this.mFactory = sSLSocketFactory;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return this.mFactory.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return this.mFactory.getDefaultCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            return wrapSocket(this.mFactory.createSocket(socket, str, i, z));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException {
            return wrapSocket(this.mFactory.createSocket(str, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return wrapSocket(this.mFactory.createSocket(str, i, inetAddress, i2));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return wrapSocket(this.mFactory.createSocket(inetAddress, i));
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return wrapSocket(this.mFactory.createSocket(inetAddress, i, inetAddress2, i2));
        }

        Socket wrapSocket(Socket socket) {
            this.mSocket = new WeakReference<>(socket);
            return socket;
        }

        public Socket getSocket() {
            WeakReference<Socket> weakReference = this.mSocket;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SSLSocketFactory getTLSFactory() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            BoxLogUtils.e("Unable to create SSLContext", e);
            return null;
        }
    }

    public static class TLSSSLSocketFactory extends SSLSocketFactoryWrapper {
        private final String[] TLS_VERSIONS;

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.SocketFactory
        public /* bridge */ /* synthetic */ Socket createSocket(String str, int i) throws IOException {
            return super.createSocket(str, i);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.SocketFactory
        public /* bridge */ /* synthetic */ Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return super.createSocket(str, i, inetAddress, i2);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.SocketFactory
        public /* bridge */ /* synthetic */ Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return super.createSocket(inetAddress, i);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.SocketFactory
        public /* bridge */ /* synthetic */ Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return super.createSocket(inetAddress, i, inetAddress2, i2);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.ssl.SSLSocketFactory
        public /* bridge */ /* synthetic */ Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            return super.createSocket(socket, str, i, z);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.ssl.SSLSocketFactory
        public /* bridge */ /* synthetic */ String[] getDefaultCipherSuites() {
            return super.getDefaultCipherSuites();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper
        public /* bridge */ /* synthetic */ Socket getSocket() {
            return super.getSocket();
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper, javax.net.ssl.SSLSocketFactory
        public /* bridge */ /* synthetic */ String[] getSupportedCipherSuites() {
            return super.getSupportedCipherSuites();
        }

        public TLSSSLSocketFactory() {
            super(BoxRequest.getTLSFactory());
            this.TLS_VERSIONS = new String[]{"TLSv1.1", "TLSv1.2"};
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.SSLSocketFactoryWrapper
        Socket wrapSocket(Socket socket) {
            if (socket instanceof SSLSocket) {
                ((SSLSocket) socket).setEnabledProtocols(this.TLS_VERSIONS);
            }
            return super.wrapSocket(socket);
        }
    }
}
