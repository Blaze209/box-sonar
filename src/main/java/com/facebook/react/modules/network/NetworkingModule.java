package com.facebook.react.modules.network;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.DeprecatedUpgrade;
import okio.GzipSource;

/* JADX INFO: compiled from: NetworkingModule.kt */
/* JADX INFO: loaded from: classes13.dex */
@ReactModule(name = "Networking")
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 c2\u00020\u0001:\u0005_`abcB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB#\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\u0011J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0015\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001dH\u0000¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001bH\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001fH\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001dH\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001bH\u0000¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001fH\u0000¢\u0006\u0002\b1J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0002JT\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020!H\u0016JV\u0010@\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010?\u001a\u00020!H\u0007J^\u0010C\u001a\u00020#2\u0006\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010?\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0005H\u0002J\u001c\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010A\u001a\u00020\u0018H\u0002J \u0010H\u001a\u00020#2\u0006\u0010A\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0010\u0010L\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\b\u0010M\u001a\u00020#H\u0002J\u0010\u0010N\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010O\u001a\u00020#2\u0006\u0010A\u001a\u00020\u0018H\u0002J\u0010\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020RH\u0017J\u0012\u0010S\u001a\u00020#2\b\u0010T\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u000209H\u0016J*\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u0005H\u0002J\u001e\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010;2\b\u0010^\u001a\u0004\u0018\u000104H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule;", "Lcom/facebook/fbreact/specs/NativeNetworkingAndroidSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "defaultUserAgent", "", "client", "Lokhttp3/OkHttpClient;", "networkInterceptorCreators", "", "Lcom/facebook/react/modules/network/NetworkInterceptorCreator;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;Lokhttp3/OkHttpClient;Ljava/util/List;)V", "context", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;Lokhttp3/OkHttpClient;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;)V", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "cookieHandler", "Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "cookieJarContainer", "Lcom/facebook/react/modules/network/CookieJarContainer;", "requestIds", "", "", "requestBodyHandlers", "", "Lcom/facebook/react/modules/network/NetworkingModule$RequestBodyHandler;", "uriHandlers", "Lcom/facebook/react/modules/network/NetworkingModule$UriHandler;", "responseHandlers", "Lcom/facebook/react/modules/network/NetworkingModule$ResponseHandler;", "shuttingDown", "", "initialize", "", "invalidate", "addUriHandler", "handler", "addUriHandler$ReactAndroid_release", "addRequestBodyHandler", "addRequestBodyHandler$ReactAndroid_release", "addResponseHandler", "addResponseHandler$ReactAndroid_release", "removeUriHandler", "removeUriHandler$ReactAndroid_release", "removeRequestBodyHandler", "removeRequestBodyHandler$ReactAndroid_release", "removeResponseHandler", "removeResponseHandler$ReactAndroid_release", "extractOrGenerateDevToolsRequestId", "data", "Lcom/facebook/react/bridge/ReadableMap;", "sendRequest", FirebaseAnalytics.Param.METHOD, "url", "requestIdAsDouble", "", "headers", "Lcom/facebook/react/bridge/ReadableArray;", "responseType", "useIncrementalUpdates", "timeoutAsDouble", "withCredentials", "sendRequestInternal", "requestId", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, "sendRequestInternalReal", NetworkingModule.REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID, "wrapRequestBodyWithProgressEmitter", "Lokhttp3/RequestBody;", "requestBody", "readWithProgress", "responseBody", "Lokhttp3/ResponseBody;", "addRequest", "removeRequest", "cancelAllRequests", "abortRequest", "cancelRequest", "clearCookies", "callback", "Lcom/facebook/react/bridge/Callback;", "addListener", "eventName", "removeListeners", "count", "constructMultipartBody", "Lokhttp3/MultipartBody$Builder;", "body", "contentType", "extractHeaders", "Lokhttp3/Headers;", "headersArray", "requestData", "UriHandler", "RequestBodyHandler", "ResponseHandler", "CustomClientBuilder", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID = "devToolsRequestId";
    private static final String TAG = "Networking";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    private static com.facebook.react.modules.network.CustomClientBuilder customClientBuilder;
    private final OkHttpClient client;
    private final ForwardingCookieHandler cookieHandler;
    private CookieJarContainer cookieJarContainer;
    private final String defaultUserAgent;
    private final List<RequestBodyHandler> requestBodyHandlers;
    private final Set<Integer> requestIds;
    private final List<ResponseHandler> responseHandlers;
    private boolean shuttingDown;
    private final List<UriHandler> uriHandlers;

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Deprecated(message = "To be removed in a future release. See\n        https://github.com/facebook/react-native/pull/37798#pullrequestreview-1518338914")
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$CustomClientBuilder;", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CustomClientBuilder extends com.facebook.react.modules.network.CustomClientBuilder {
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$RequestBodyHandler;", "", "supports", "", "map", "Lcom/facebook/react/bridge/ReadableMap;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RequestBodyHandler {
        boolean supports(ReadableMap map);

        RequestBody toRequestBody(ReadableMap map, String contentType);
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$ResponseHandler;", "", "supports", "", "responseType", "", "toResponseData", "Lcom/facebook/react/bridge/WritableMap;", "data", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ResponseHandler {
        boolean supports(String responseType);

        WritableMap toResponseData(byte[] data) throws IOException;
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$UriHandler;", "", "supports", "", NetworkingModule.REQUEST_BODY_KEY_URI, "Landroid/net/Uri;", "responseType", "", RemoteConfigComponent.FETCH_FILE_NAME, "Lkotlin/Pair;", "Lcom/facebook/react/bridge/WritableMap;", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UriHandler {
        Pair<WritableMap, byte[]> fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String responseType);
    }

    @JvmStatic
    public static final void setCustomClientBuilder(com.facebook.react.modules.network.CustomClientBuilder customClientBuilder2) {
        INSTANCE.setCustomClientBuilder(customClientBuilder2);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void addListener(String eventName) {
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkingModule(ReactApplicationContext reactContext, String str, OkHttpClient client, List<? extends NetworkInterceptorCreator> list) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(client, "client");
        this.cookieHandler = new ForwardingCookieHandler();
        this.requestIds = new HashSet();
        this.requestBodyHandlers = new ArrayList();
        this.uriHandlers = new ArrayList();
        this.responseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder builderNewBuilder = client.newBuilder();
            Iterator<? extends NetworkInterceptorCreator> it = list.iterator();
            while (it.hasNext()) {
                builderNewBuilder.addNetworkInterceptor(it.next().create());
            }
            client = builderNewBuilder.build();
        }
        this.client = client;
        CookieJar cookieJar = client.getCookieJar();
        this.cookieJarContainer = cookieJar instanceof CookieJarContainer ? (CookieJarContainer) cookieJar : null;
        this.defaultUserAgent = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetworkingModule(ReactApplicationContext context, String str, OkHttpClient client) {
        this(context, str, client, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(client, "client");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, null, OkHttpClientProvider.createClient(applicationContext), null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context, List<? extends NetworkInterceptorCreator> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, null, OkHttpClientProvider.createClient(applicationContext), list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NetworkingModule(ReactApplicationContext context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, str, OkHttpClientProvider.createClient(applicationContext), null);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        CookieJarContainer cookieJarContainer = this.cookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.setCookieJar(new JavaNetCookieJar(this.cookieHandler));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.shuttingDown = true;
        cancelAllRequests();
        this.cookieHandler.destroy();
        CookieJarContainer cookieJarContainer = this.cookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.removeCookieJar();
        }
        this.requestBodyHandlers.clear();
        this.responseHandlers.clear();
        this.uriHandlers.clear();
    }

    public final void addUriHandler$ReactAndroid_release(UriHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.uriHandlers.add(handler);
    }

    public final void addRequestBodyHandler$ReactAndroid_release(RequestBodyHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.requestBodyHandlers.add(handler);
    }

    public final void addResponseHandler$ReactAndroid_release(ResponseHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.responseHandlers.add(handler);
    }

    public final void removeUriHandler$ReactAndroid_release(UriHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.uriHandlers.remove(handler);
    }

    public final void removeRequestBodyHandler$ReactAndroid_release(RequestBodyHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.requestBodyHandlers.remove(handler);
    }

    public final void removeResponseHandler$ReactAndroid_release(ResponseHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.responseHandlers.remove(handler);
    }

    private final String extractOrGenerateDevToolsRequestId(ReadableMap data) {
        String string = (data != null && data.hasKey(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) && data.getType(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) == ReadableType.String) ? data.getString(REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID) : null;
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void sendRequest(String method, String url, double requestIdAsDouble, ReadableArray headers, ReadableMap data, String responseType, boolean useIncrementalUpdates, double timeoutAsDouble, boolean withCredentials) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        int i = (int) requestIdAsDouble;
        int i2 = (int) timeoutAsDouble;
        String strExtractOrGenerateDevToolsRequestId = extractOrGenerateDevToolsRequestId(data);
        try {
            sendRequestInternalReal(method, url, i, headers, data, responseType, useIncrementalUpdates, i2, withCredentials, strExtractOrGenerateDevToolsRequestId);
        } catch (Throwable th) {
            FLog.e("Networking", "Failed to send url request: " + url, th);
            NetworkEventUtil.onRequestError(getReactApplicationContextIfActiveOrWarn(), i, strExtractOrGenerateDevToolsRequestId, th.getMessage(), th);
        }
    }

    @Deprecated(message = "sendRequestInternal is internal and will be made private in a future release.")
    public final void sendRequestInternal(String method, String url, int requestId, ReadableArray headers, ReadableMap data, String responseType, boolean useIncrementalUpdates, int timeout, boolean withCredentials) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        sendRequestInternalReal(method, url, requestId, headers, data, responseType, useIncrementalUpdates, timeout, withCredentials, extractOrGenerateDevToolsRequestId(data));
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0281  */
    private final void sendRequestInternalReal(String method, final String url, final int requestId, ReadableArray headers, ReadableMap data, final String responseType, final boolean useIncrementalUpdates, int timeout, boolean withCredentials, final String devToolsRequestId) {
        String str;
        RequestBodyHandler next;
        MultipartBody emptyBody;
        Charset charset;
        UriHandler next2;
        final ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        try {
            Uri uri = Uri.parse(url);
            Iterator<UriHandler> it = this.uriHandlers.iterator();
            do {
                str = "";
                if (it.hasNext()) {
                    next2 = it.next();
                    Intrinsics.checkNotNull(uri);
                } else {
                    try {
                        Request.Builder builder = new Request.Builder();
                        if (url != null) {
                            str = url;
                        }
                        Request.Builder builderUrl = builder.url(str);
                        if (requestId != 0) {
                            builderUrl.tag(Integer.valueOf(requestId));
                        }
                        OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
                        INSTANCE.applyCustomBuilder(builderNewBuilder);
                        if (!withCredentials) {
                            builderNewBuilder.cookieJar(CookieJar.NO_COOKIES);
                        }
                        if (useIncrementalUpdates) {
                            builderNewBuilder.addNetworkInterceptor(new Interceptor() { // from class: com.facebook.react.modules.network.NetworkingModule$sendRequestInternalReal$$inlined$-addNetworkInterceptor$1
                                @Override // okhttp3.Interceptor
                                public final Response intercept(Interceptor.Chain chain) throws IOException {
                                    Intrinsics.checkNotNullParameter(chain, "chain");
                                    Response responseProceed = chain.proceed(chain.request());
                                    ResponseBody body = responseProceed.getBody();
                                    if (body == null) {
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    final String str2 = responseType;
                                    final ReactApplicationContext reactApplicationContext = reactApplicationContextIfActiveOrWarn;
                                    final int i = requestId;
                                    return responseProceed.newBuilder().body(new ProgressResponseBody(body, new ProgressListener() { // from class: com.facebook.react.modules.network.NetworkingModule$sendRequestInternalReal$1$responseBody$1
                                        private long last = System.nanoTime();

                                        public final long getLast() {
                                            return this.last;
                                        }

                                        public final void setLast(long j) {
                                            this.last = j;
                                        }

                                        @Override // com.facebook.react.modules.network.ProgressListener
                                        public void onProgress(long bytesWritten, long contentLength, boolean done) {
                                            long jNanoTime = System.nanoTime();
                                            if ((done || NetworkingModule.INSTANCE.shouldDispatch(jNanoTime, this.last)) && !Intrinsics.areEqual(str2, "text")) {
                                                NetworkEventUtil.onDataReceivedProgress(reactApplicationContext, i, bytesWritten, contentLength);
                                                this.last = jNanoTime;
                                            }
                                        }
                                    })).build();
                                }
                            });
                        }
                        if (timeout != this.client.getCallTimeoutMillis()) {
                            builderNewBuilder.callTimeout(timeout, TimeUnit.MILLISECONDS);
                        }
                        OkHttpClient okHttpClientBuild = builderNewBuilder.build();
                        Headers headersExtractHeaders = extractHeaders(headers, data);
                        if (headersExtractHeaders == null) {
                            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Unrecognized headers format", null);
                            return;
                        }
                        String str2 = headersExtractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                        String str3 = headersExtractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                        builderUrl.headers(headersExtractHeaders);
                        if (data == null) {
                            next = null;
                            break;
                        }
                        Iterator<RequestBodyHandler> it2 = this.requestBodyHandlers.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!next.supports(data));
                        if (data != null) {
                            String lowerCase = method.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (Intrinsics.areEqual(lowerCase, PasskeyWebListener.GET_UNIQUE_KEY)) {
                                emptyBody = RequestBodyUtil.getEmptyBody(method);
                            } else {
                                String lowerCase2 = method.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                if (Intrinsics.areEqual(lowerCase2, "head")) {
                                    emptyBody = RequestBodyUtil.getEmptyBody(method);
                                } else if (next != null) {
                                    emptyBody = next.toRequestBody(data, str2);
                                } else if (data.hasKey("string")) {
                                    if (str2 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                        return;
                                    }
                                    String string = data.getString("string");
                                    MediaType mediaTypeM16541deprecated_parse = MediaType.INSTANCE.m16541deprecated_parse(str2);
                                    if (RequestBodyUtil.isGzipEncoding(str3)) {
                                        emptyBody = (mediaTypeM16541deprecated_parse == null || string == null) ? null : RequestBodyUtil.createGzip(mediaTypeM16541deprecated_parse, string);
                                        if (emptyBody == null) {
                                            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Failed to gzip request body", null);
                                            return;
                                        }
                                    } else {
                                        if (mediaTypeM16541deprecated_parse == null) {
                                            charset = StandardCharsets.UTF_8;
                                        } else {
                                            charset = mediaTypeM16541deprecated_parse.charset(StandardCharsets.UTF_8);
                                            if (charset == null) {
                                                throw new IllegalStateException("Required value was null.".toString());
                                            }
                                        }
                                        if (string == null) {
                                            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Received request but body was empty", null);
                                            return;
                                        }
                                        RequestBody.Companion companion = RequestBody.INSTANCE;
                                        Intrinsics.checkNotNull(charset);
                                        byte[] bytes = string.getBytes(charset);
                                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                        emptyBody = RequestBody.Companion.create$default(companion, mediaTypeM16541deprecated_parse, bytes, 0, 0, 12, (Object) null);
                                    }
                                } else if (data.hasKey(REQUEST_BODY_KEY_BASE64)) {
                                    if (str2 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                        return;
                                    }
                                    String string2 = data.getString(REQUEST_BODY_KEY_BASE64);
                                    if (string2 == null) {
                                        throw new IllegalStateException("Required value was null.".toString());
                                    }
                                    MediaType mediaTypeM16541deprecated_parse2 = MediaType.INSTANCE.m16541deprecated_parse(str2);
                                    if (mediaTypeM16541deprecated_parse2 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Invalid content type specified: " + str2, null);
                                        return;
                                    }
                                    ByteString byteStringM16604deprecated_decodeBase64 = ByteString.INSTANCE.m16604deprecated_decodeBase64(string2);
                                    if (byteStringM16604deprecated_decodeBase64 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Request body base64 string was invalid", null);
                                        return;
                                    }
                                    emptyBody = RequestBody.INSTANCE.create(mediaTypeM16541deprecated_parse2, byteStringM16604deprecated_decodeBase64);
                                } else if (data.hasKey(REQUEST_BODY_KEY_URI)) {
                                    if (str2 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Payload is set but no content-type header specified", null);
                                        return;
                                    }
                                    String string3 = data.getString(REQUEST_BODY_KEY_URI);
                                    if (string3 == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Request body URI field was set but null", null);
                                        return;
                                    }
                                    ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
                                    InputStream fileInputStream = RequestBodyUtil.getFileInputStream(reactApplicationContext, string3);
                                    if (fileInputStream == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Could not retrieve file for uri " + string3, null);
                                        return;
                                    }
                                    emptyBody = RequestBodyUtil.create(MediaType.INSTANCE.m16541deprecated_parse(str2), fileInputStream);
                                } else if (data.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                                    if (str2 == null) {
                                        str2 = ShareTarget.ENCODING_TYPE_MULTIPART;
                                    }
                                    ReadableArray array = data.getArray(REQUEST_BODY_KEY_FORMDATA);
                                    if (array == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Received request but form data was empty", null);
                                        return;
                                    }
                                    MultipartBody.Builder builderConstructMultipartBody = constructMultipartBody(array, str2, requestId, devToolsRequestId);
                                    if (builderConstructMultipartBody == null) {
                                        return;
                                    } else {
                                        emptyBody = builderConstructMultipartBody.build();
                                    }
                                } else {
                                    emptyBody = RequestBodyUtil.getEmptyBody(method);
                                }
                            }
                        } else {
                            emptyBody = RequestBodyUtil.getEmptyBody(method);
                        }
                        builderUrl.method(method, wrapRequestBodyWithProgressEmitter(emptyBody, requestId));
                        addRequest(requestId);
                        Request requestBuild = builderUrl.build();
                        NetworkEventUtil.onCreateRequest(devToolsRequestId, requestBuild);
                        okHttpClientBuild.newCall(requestBuild).enqueue(new Callback() { // from class: com.facebook.react.modules.network.NetworkingModule.sendRequestInternalReal.2
                            @Override // okhttp3.Callback
                            public void onFailure(Call call, IOException e) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(e, "e");
                                if (NetworkingModule.this.shuttingDown) {
                                    return;
                                }
                                NetworkingModule.this.removeRequest(requestId);
                                String message = e.getMessage();
                                if (message == null) {
                                    message = "Error while executing request: " + e.getClass().getSimpleName();
                                }
                                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, message, e);
                            }

                            @Override // okhttp3.Callback
                            public void onResponse(Call call, Response response) throws IOException {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (NetworkingModule.this.shuttingDown) {
                                    return;
                                }
                                NetworkingModule.this.removeRequest(requestId);
                                NetworkEventUtil.onResponseReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, url, response);
                                try {
                                    ResponseBody body = response.getBody();
                                    if (body == null) {
                                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Response body is null", null);
                                        return;
                                    }
                                    if (StringsKt.equals("gzip", Response.header$default(response, "Content-Encoding", null, 2, null), true)) {
                                        GzipSource gzipSource = new GzipSource(body.getSource());
                                        String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
                                        body = ResponseBody.INSTANCE.create(strHeader$default != null ? MediaType.INSTANCE.m16541deprecated_parse(strHeader$default) : null, -1L, DeprecatedUpgrade.getOkio().buffer(gzipSource));
                                    }
                                    if (body != null) {
                                        for (ResponseHandler responseHandler : NetworkingModule.this.responseHandlers) {
                                            if (responseHandler.supports(responseType)) {
                                                byte[] bArrBytes = body.bytes();
                                                NetworkEventUtil.onDataReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, responseHandler.toResponseData(bArrBytes), bArrBytes);
                                                NetworkEventUtil.onRequestSuccess(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, body.getContentLength());
                                                return;
                                            }
                                        }
                                        if (useIncrementalUpdates && Intrinsics.areEqual(responseType, "text")) {
                                            NetworkingModule.this.readWithProgress(requestId, devToolsRequestId, body);
                                            NetworkEventUtil.onRequestSuccess(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, body.getContentLength());
                                            return;
                                        }
                                        String strString = "";
                                        if (Intrinsics.areEqual(responseType, "text")) {
                                            try {
                                                strString = body.string();
                                            } catch (IOException e) {
                                                if (!StringsKt.equals(response.getRequest().getMethod(), "HEAD", true)) {
                                                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, e.getMessage(), e);
                                                }
                                            }
                                        } else if (Intrinsics.areEqual(responseType, NetworkingModule.REQUEST_BODY_KEY_BASE64)) {
                                            strString = Base64.encodeToString(body.bytes(), 2);
                                        }
                                        NetworkEventUtil.onDataReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, strString, responseType);
                                        NetworkEventUtil.onRequestSuccess(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, body.getContentLength());
                                        return;
                                    }
                                    throw new IllegalStateException("Required value was null.".toString());
                                } catch (IOException e2) {
                                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, e2.getMessage(), e2);
                                }
                            }
                        });
                        return;
                    } catch (Exception e) {
                        NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, e.getMessage(), e);
                        return;
                    }
                }
            } while (!next2.supports(uri, responseType));
            Pair<WritableMap, byte[]> pairFetch = next2.fetch(uri);
            WritableMap writableMapComponent1 = pairFetch.component1();
            byte[] bArrComponent2 = pairFetch.component2();
            byte[] bytes2 = writableMapComponent1.toString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            int length = bytes2.length;
            Response.Builder builderProtocol = new Response.Builder().protocol(Protocol.HTTP_1_1);
            Request.Builder builder2 = new Request.Builder();
            if (url != null) {
                str = url;
            }
            NetworkEventUtil.onResponseReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, url, builderProtocol.request(builder2.url(str).build()).code(200).message(SemanticAttributes.OtelStatusCodeValues.OK).build());
            NetworkEventUtil.onDataReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, writableMapComponent1, bArrComponent2);
            NetworkEventUtil.onRequestSuccess(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, length);
        } catch (IOException e2) {
            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, e2.getMessage(), e2);
        }
    }

    private final RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final int requestId) {
        if (requestBody == null) {
            return null;
        }
        final ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        return RequestBodyUtil.createProgressRequest(requestBody, new ProgressListener() { // from class: com.facebook.react.modules.network.NetworkingModule.wrapRequestBodyWithProgressEmitter.1
            private long last = System.nanoTime();

            public final long getLast() {
                return this.last;
            }

            public final void setLast(long j) {
                this.last = j;
            }

            @Override // com.facebook.react.modules.network.ProgressListener
            public void onProgress(long bytesWritten, long contentLength, boolean done) {
                long jNanoTime = System.nanoTime();
                if (done || NetworkingModule.INSTANCE.shouldDispatch(jNanoTime, this.last)) {
                    NetworkEventUtil.onDataSend(reactApplicationContextIfActiveOrWarn, requestId, bytesWritten, contentLength);
                    this.last = jNanoTime;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readWithProgress(int requestId, String devToolsRequestId, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long contentLength = -1;
        try {
            Intrinsics.checkNotNull(responseBody, "null cannot be cast to non-null type com.facebook.react.modules.network.ProgressResponseBody");
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.getTotalBytesRead();
            try {
                contentLength = progressResponseBody.getContentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        long j2 = contentLength;
        long j3 = j;
        if (responseBody.get$contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            MediaType mediaType = responseBody.get$contentType();
            charset = mediaType != null ? mediaType.charset(StandardCharsets.UTF_8) : null;
            if (charset == null) {
                throw new IllegalStateException(("Null character set for Content-Type: " + responseBody.get$contentType()).toString());
            }
        }
        Intrinsics.checkNotNull(charset);
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream inputStreamByteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            while (true) {
                int i = inputStreamByteStream.read(bArr);
                if (i != -1) {
                    NetworkEventUtil.onIncrementalDataReceived(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, progressiveStringDecoder.decodeNext(bArr, i), j3, j2);
                } else {
                    inputStreamByteStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            inputStreamByteStream.close();
            throw th;
        }
    }

    private final synchronized void addRequest(int requestId) {
        this.requestIds.add(Integer.valueOf(requestId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void removeRequest(int requestId) {
        this.requestIds.remove(Integer.valueOf(requestId));
    }

    private final synchronized void cancelAllRequests() {
        Iterator<Integer> it = this.requestIds.iterator();
        while (it.hasNext()) {
            cancelRequest(it.next().intValue());
        }
        this.requestIds.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void abortRequest(double requestIdAsDouble) {
        int i = (int) requestIdAsDouble;
        cancelRequest(i);
        removeRequest(i);
    }

    private final void cancelRequest(int requestId) {
        OkHttpCallUtil.cancelTag(this.client, Integer.valueOf(requestId));
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    @ReactMethod
    public void clearCookies(com.facebook.react.bridge.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.cookieHandler.clearCookies(callback);
    }

    private final MultipartBody.Builder constructMultipartBody(ReadableArray body, String contentType, int requestId, String devToolsRequestId) {
        MediaType mediaTypeM16541deprecated_parse;
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        MultipartBody.Builder builder = new MultipartBody.Builder(null, 1, null);
        MediaType mediaTypeM16541deprecated_parse2 = MediaType.INSTANCE.m16541deprecated_parse(contentType);
        if (mediaTypeM16541deprecated_parse2 == null) {
            NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Invalid media type.", null);
            return null;
        }
        builder.setType(mediaTypeM16541deprecated_parse2);
        int size = body.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = body.getMap(i);
            if (map == null) {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Unrecognized FormData part.", null);
                return null;
            }
            Headers headersExtractHeaders = extractHeaders(map.getArray("headers"), null);
            if (headersExtractHeaders == null) {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str = headersExtractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str != null) {
                mediaTypeM16541deprecated_parse = MediaType.INSTANCE.m16541deprecated_parse(str);
                headersExtractHeaders = headersExtractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaTypeM16541deprecated_parse = null;
            }
            if (map.hasKey("string") && map.getString("string") != null) {
                String string = map.getString("string");
                if (string == null) {
                    string = "";
                }
                builder.addPart(headersExtractHeaders, RequestBody.INSTANCE.create(mediaTypeM16541deprecated_parse, string));
            } else if (map.hasKey(REQUEST_BODY_KEY_URI) && map.getString(REQUEST_BODY_KEY_URI) != null) {
                if (mediaTypeM16541deprecated_parse == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Binary FormData part needs a content-type header.", null);
                    return null;
                }
                String string2 = map.getString(REQUEST_BODY_KEY_URI);
                if (string2 == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Body must have a valid file uri", null);
                    return null;
                }
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(reactApplicationContext, string2);
                if (fileInputStream == null) {
                    NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Could not retrieve file for uri " + string2, null);
                    return null;
                }
                builder.addPart(headersExtractHeaders, RequestBodyUtil.create(mediaTypeM16541deprecated_parse, fileInputStream));
            } else {
                NetworkEventUtil.onRequestError(reactApplicationContextIfActiveOrWarn, requestId, devToolsRequestId, "Unrecognized FormData part.", null);
                Unit unit = Unit.INSTANCE;
            }
        }
        return builder;
    }

    private final Headers extractHeaders(ReadableArray headersArray, ReadableMap requestData) {
        String str;
        if (headersArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headersArray.size();
        for (int i = 0; i < size; i++) {
            ReadableArray array = headersArray.getArray(i);
            if (array != null && array.size() == 2) {
                String string = array.getString(0);
                if (string != null) {
                    string = HeaderUtil.INSTANCE.stripHeaderName(string);
                }
                String string2 = array.getString(1);
                if (string != null && string2 != null) {
                    builder.addUnsafeNonAscii(string, string2);
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.defaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (requestData == null || !requestData.hasKey("string")) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    /* JADX INFO: compiled from: NetworkingModule.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/modules/network/NetworkingModule$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "CONTENT_ENCODING_HEADER_NAME", "CONTENT_TYPE_HEADER_NAME", "REQUEST_BODY_KEY_STRING", "REQUEST_BODY_KEY_URI", "REQUEST_BODY_KEY_FORMDATA", "REQUEST_BODY_KEY_BASE64", "REQUEST_DATA_KEY_DEVTOOLS_REQUEST_ID", "USER_AGENT_HEADER_NAME", "CHUNK_TIMEOUT_NS", "", "MAX_CHUNK_SIZE_BETWEEN_FLUSHES", "customClientBuilder", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "setCustomClientBuilder", "", "ccb", "applyCustomBuilder", "builder", "Lokhttp3/OkHttpClient$Builder;", "shouldDispatch", "", "now", "", "last", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldDispatch(long now, long last) {
            return last + ((long) NetworkingModule.CHUNK_TIMEOUT_NS) < now;
        }

        private Companion() {
        }

        @JvmStatic
        public final void setCustomClientBuilder(com.facebook.react.modules.network.CustomClientBuilder ccb) {
            NetworkingModule.customClientBuilder = ccb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyCustomBuilder(OkHttpClient.Builder builder) {
            com.facebook.react.modules.network.CustomClientBuilder customClientBuilder = NetworkingModule.customClientBuilder;
            if (customClientBuilder != null) {
                customClientBuilder.apply(builder);
            }
        }
    }
}
