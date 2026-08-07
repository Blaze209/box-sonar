package com.box.android.activities.login;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.box.android.clientadmin.integrity.DeviceIntegrityResult;
import com.box.android.clientadmin.integrity.DeviceIntegrityVerifier;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.auth.OAuthWebView;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.StringEscapeUtils;

/* JADX INFO: loaded from: classes9.dex */
public class DeviceTrustJavascriptBridge {
    private static final String DEVICE_TRUST_INTERFACE_NAME = "DeviceTrust";
    private static final String DEVICE_TRUST_URL_END = "login/device_trust_check";
    public static final String USE_NATIVE_BROWSER_AUTH = "box_use_mobile_native_browser_auth=1";
    private static boolean mockEnabled = false;
    private static final EnumSet<DeviceTrustMockType> mockTypes = EnumSet.noneOf(DeviceTrustMockType.class);
    private DeviceTrust mDeviceTrust;

    public enum DeviceTrustMockType {
        JAILBROKEN,
        LOW_OS
    }

    public interface NativeBrowserHandler {
        boolean onNativeBrowserRequired(WebView webView, String str);
    }

    public static void enableMocking(DeviceTrustMockType... deviceTrustMockTypeArr) {
        mockEnabled = true;
        EnumSet<DeviceTrustMockType> enumSet = mockTypes;
        enumSet.clear();
        enumSet.addAll(Arrays.asList(deviceTrustMockTypeArr));
    }

    public static void disableMocking() {
        mockEnabled = false;
        mockTypes.clear();
    }

    @JavascriptInterface
    public String readDeviceTrust(String str) {
        DeviceTrust deviceTrust = new DeviceTrust();
        this.mDeviceTrust = deviceTrust;
        deviceTrust.createFromJson(str);
        return str;
    }

    public ArrayList<TrustRequirement> getAndroidDeviceTrustRequirements(DeviceIntegrityVerifier deviceIntegrityVerifier) {
        return this.mDeviceTrust.getAndroidRequirements(deviceIntegrityVerifier);
    }

    public void submitAndroidDeviceTrustResponse(WebView webView, List<TrustRequirement> list) {
        DeviceTrustResponse deviceTrustResponse = new DeviceTrustResponse(list);
        BoxLogUtils.v("device trust submitted ", deviceTrustResponse.toJson());
        webView.evaluateJavascript("window.deviceTrust.receiveResults('" + StringEscapeUtils.escapeEcmaScript(deviceTrustResponse.toJson()) + "');", null);
    }

    public void submitFailedAndroidDeviceTrustResponse(WebView webView, Exception exc) {
        DeviceTrustResponse deviceTrustResponseCreateFailedDeviceTrustResponse = DeviceTrustResponse.createFailedDeviceTrustResponse();
        if (exc != null) {
            deviceTrustResponseCreateFailedDeviceTrustResponse.setError(exc.getMessage());
        }
        BoxLogUtils.v("device trust submitted ", deviceTrustResponseCreateFailedDeviceTrustResponse.toJson());
        webView.evaluateJavascript("window.deviceTrust.receiveResults('" + StringEscapeUtils.escapeEcmaScript(deviceTrustResponseCreateFailedDeviceTrustResponse.toJson()) + "');", null);
    }

    public static class DeviceTrust extends BoxJsonObject {
        public ArrayList<TrustRequirement> getAndroidRequirements(DeviceIntegrityVerifier deviceIntegrityVerifier) {
            return getPropertyAsJsonObjectArray(TrustRequirement.getJsonObjectCreator(deviceIntegrityVerifier), "android");
        }
    }

    public static class DeviceTrustResponse extends BoxJsonObject {
        protected static final String FIELD_CHECKS = "checks";
        protected static final String FIELD_ERROR = "error";
        protected static final String FIELD_PASS = "pass";

        protected DeviceTrustResponse() {
        }

        public DeviceTrustResponse(List<TrustRequirement> list) {
            boolean z = list != null;
            JsonArray jsonArray = new JsonArray();
            for (TrustRequirement trustRequirement : list) {
                jsonArray.add(trustRequirement.toJsonObject());
                if (trustRequirement.getPass() != null && !trustRequirement.getPass().booleanValue()) {
                    z = false;
                }
            }
            set(FIELD_PASS, Boolean.valueOf(z));
            set(FIELD_CHECKS, jsonArray);
        }

        public static DeviceTrustResponse createFailedDeviceTrustResponse() {
            DeviceTrustResponse deviceTrustResponse = new DeviceTrustResponse();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(FIELD_PASS, false);
            jsonObject.add(FIELD_CHECKS, new JsonArray());
            deviceTrustResponse.createFromJson(jsonObject);
            return deviceTrustResponse;
        }

        public void setError(String str) {
            set("error", str);
        }
    }

    public static abstract class TrustRequirement extends BoxJsonObject {
        protected static final String FIELD_ERROR = "error";
        protected static final String FIELD_PASS = "pass";
        protected static final String FIELD_TYPE = "type";

        public abstract void evaluateRequirement();

        protected TrustRequirement(JsonObject jsonObject) {
            super(jsonObject);
        }

        public String getType() {
            return getPropertyAsString("type");
        }

        void setPass(boolean z) {
            set(FIELD_PASS, Boolean.valueOf(z));
        }

        public Boolean getPass() {
            return getPropertyAsBoolean(FIELD_PASS);
        }

        public void setError(String str) {
            set("error", str);
        }

        public static BoxJsonObject.BoxJsonObjectCreator<TrustRequirement> getJsonObjectCreator(final DeviceIntegrityVerifier deviceIntegrityVerifier) {
            return new BoxJsonObject.BoxJsonObjectCreator() { // from class: com.box.android.activities.login.DeviceTrustJavascriptBridge$TrustRequirement$$ExternalSyntheticLambda0
                @Override // com.box.androidsdk.content.models.BoxJsonObject.BoxJsonObjectCreator
                public final BoxJsonObject createFromJsonObject(JsonObject jsonObject) {
                    return DeviceTrustJavascriptBridge.TrustRequirement.lambda$getJsonObjectCreator$0(deviceIntegrityVerifier, jsonObject);
                }
            };
        }

        static /* synthetic */ TrustRequirement lambda$getJsonObjectCreator$0(DeviceIntegrityVerifier deviceIntegrityVerifier, JsonObject jsonObject) {
            String strAsString = jsonObject.get("type").asString();
            if (strAsString.equals(AndroidMinVersionTrustRequirement.TYPE_ANDROID_MINIMUM_OS_VERSION)) {
                return new AndroidMinVersionTrustRequirement(jsonObject);
            }
            if (strAsString.equals(NotJailBrokenTrustRequirement.TYPE_NOT_JAIL_BROKEN)) {
                return new NotJailBrokenTrustRequirement(jsonObject, deviceIntegrityVerifier);
            }
            return new UnhandledTrustRequirment(jsonObject);
        }

        public static class UnhandledTrustRequirment extends TrustRequirement {
            public UnhandledTrustRequirment(JsonObject jsonObject) {
                super(jsonObject);
            }

            @Override // com.box.android.activities.login.DeviceTrustJavascriptBridge.TrustRequirement
            public void evaluateRequirement() {
                setPass(false);
                setError("unhandled trust requirement: " + getType());
                BoxLogUtils.logException("UnhandledTrustRequirment", getType(), new RuntimeException("evaluating unhandled Trust Requirement"));
            }
        }

        public static class AndroidMinVersionTrustRequirement extends TrustRequirement {
            protected static final String FIELD_VERSION = "version";
            public static final String TYPE_ANDROID_MINIMUM_OS_VERSION = "androidMinimumOSVersion";

            public AndroidMinVersionTrustRequirement(JsonObject jsonObject) {
                super(jsonObject);
            }

            @Override // com.box.android.activities.login.DeviceTrustJavascriptBridge.TrustRequirement
            public void evaluateRequirement() {
                if (DeviceTrustJavascriptBridge.mockEnabled && DeviceTrustJavascriptBridge.mockTypes.contains(DeviceTrustMockType.LOW_OS)) {
                    setPass(false);
                    setError("mocked min-version failure");
                    return;
                }
                try {
                    String version = getVersion();
                    if (CommonBoxUtil.isAtLeastVersion(Integer.parseInt(version.substring(version.indexOf("_") + 1)))) {
                        setPass(true);
                        return;
                    }
                } catch (Exception e) {
                    setError("unhandled trust requirement: " + e.getMessage());
                    BoxLogUtils.logException("problem evaluating min version:", toJson(), e);
                }
                setPass(false);
            }

            public String getVersion() {
                return getPropertyAsString("version");
            }
        }

        public static class NotJailBrokenTrustRequirement extends TrustRequirement {
            public static final String FIELD_PLAY_INTEGRITY_UNIQUE_VALUE = "playIntegrityUniqueValue";
            public static final String INTEGRITY_TOKEN = "integrityToken";
            public static final String INTEGRITY_TOKEN_ERROR = "integrityTokenError";
            public static final String TYPE_NOT_JAIL_BROKEN = "notJailbroken";
            private final transient DeviceIntegrityVerifier deviceIntegrityVerifier;

            public NotJailBrokenTrustRequirement(JsonObject jsonObject, DeviceIntegrityVerifier deviceIntegrityVerifier) {
                super(jsonObject);
                this.deviceIntegrityVerifier = deviceIntegrityVerifier;
            }

            @Override // com.box.android.activities.login.DeviceTrustJavascriptBridge.TrustRequirement
            public void evaluateRequirement() {
                if (DeviceTrustJavascriptBridge.mockEnabled && DeviceTrustJavascriptBridge.mockTypes.contains(DeviceTrustMockType.JAILBROKEN)) {
                    setPass(false);
                    setError("mocked jailbreak failure");
                    return;
                }
                try {
                    DeviceIntegrityResult deviceIntegrityResultVerifyIntegrity = this.deviceIntegrityVerifier.verifyIntegrity(getPropertyAsString(FIELD_PLAY_INTEGRITY_UNIQUE_VALUE));
                    if (deviceIntegrityResultVerifyIntegrity instanceof DeviceIntegrityResult.IntegrityToken) {
                        setIntegrityToken(((DeviceIntegrityResult.IntegrityToken) deviceIntegrityResultVerifyIntegrity).getToken());
                    } else if (deviceIntegrityResultVerifyIntegrity instanceof DeviceIntegrityResult.IntegrityTokenError) {
                        setIntegrityTokenError(((DeviceIntegrityResult.IntegrityTokenError) deviceIntegrityResultVerifyIntegrity).getMessage());
                        setPass(false);
                    } else {
                        setPass(false);
                    }
                } catch (Exception e) {
                    setError("problem evaluating not jail broken: " + e.getMessage());
                    BoxLogUtils.logException("problem evaluating not jail broken", toJson(), e);
                    setPass(false);
                }
            }

            private void setIntegrityToken(String str) {
                set(INTEGRITY_TOKEN, str);
            }

            private void setIntegrityTokenError(String str) {
                set(INTEGRITY_TOKEN_ERROR, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DeviceTrustRequirementVerifier implements Runnable {
        private final DeviceIntegrityVerifier deviceIntegrityVerifier;
        private final DeviceTrustJavascriptBridge mDeviceTrustBridge;
        private final String mValueReceived;
        private final WeakReference<WebView> mViewWeakReference;

        DeviceTrustRequirementVerifier(String str, DeviceTrustJavascriptBridge deviceTrustJavascriptBridge, WeakReference<WebView> weakReference, DeviceIntegrityVerifier deviceIntegrityVerifier) {
            this.mValueReceived = str;
            this.mDeviceTrustBridge = deviceTrustJavascriptBridge;
            this.mViewWeakReference = weakReference;
            this.deviceIntegrityVerifier = deviceIntegrityVerifier;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.mValueReceived;
            if (str == null || str.equals(AbstractJsonLexerKt.NULL)) {
                BoxLogUtils.logException("DeviceTrustJavascriptBridge.onPageFinished", "DT check null ", new RuntimeException("JS failed to return requirements"));
                return;
            }
            try {
                ArrayList<TrustRequirement> androidDeviceTrustRequirements = this.mDeviceTrustBridge.getAndroidDeviceTrustRequirements(this.deviceIntegrityVerifier);
                int i = 0;
                for (TrustRequirement trustRequirement : androidDeviceTrustRequirements) {
                    trustRequirement.evaluateRequirement();
                    if (trustRequirement.getPass() != null && !trustRequirement.getPass().booleanValue()) {
                        i++;
                    }
                }
                notifyJavascriptWithRequirements(androidDeviceTrustRequirements);
                if (i > 0) {
                    BoxAuthentication.getInstance().onAuthenticationFailure(null, null);
                }
            } catch (Exception e) {
                notifyJavascriptWithError(e);
            }
        }

        private void notifyJavascriptWithRequirements(final ArrayList<TrustRequirement> arrayList) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.login.DeviceTrustJavascriptBridge$DeviceTrustRequirementVerifier$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$notifyJavascriptWithRequirements$0(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyJavascriptWithRequirements$0(ArrayList arrayList) {
            WebView webView = this.mViewWeakReference.get();
            if (webView == null) {
                return;
            }
            this.mDeviceTrustBridge.submitAndroidDeviceTrustResponse(webView, arrayList);
        }

        private void notifyJavascriptWithError(final Exception exc) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.login.DeviceTrustJavascriptBridge$DeviceTrustRequirementVerifier$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$notifyJavascriptWithError$1(exc);
                }
            });
            BoxLogUtils.logException("DeviceTrustJavascriptBridge.onPageFinished", "unable to perform DT check", exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyJavascriptWithError$1(Exception exc) {
            WebView webView = this.mViewWeakReference.get();
            if (webView == null) {
                return;
            }
            this.mDeviceTrustBridge.submitFailedAndroidDeviceTrustResponse(webView, exc);
        }
    }

    public static class DeviceTrustClient extends OAuthWebView.OAuthWebViewClient {
        private final DeviceIntegrityVerifier deviceIntegrityVerifier;
        DeviceTrustJavascriptBridge mDeviceTrustBridge;
        private String mLastNativeBrowserUrl;

        public DeviceTrustClient(OAuthWebView.OAuthWebViewClient.WebEventListener webEventListener, WebView webView, String str, DeviceIntegrityVerifier deviceIntegrityVerifier) {
            super(webEventListener, str);
            DeviceTrustJavascriptBridge deviceTrustJavascriptBridge = new DeviceTrustJavascriptBridge();
            this.mDeviceTrustBridge = deviceTrustJavascriptBridge;
            webView.addJavascriptInterface(deviceTrustJavascriptBridge, DeviceTrustJavascriptBridge.DEVICE_TRUST_INTERFACE_NAME);
            this.deviceIntegrityVerifier = deviceIntegrityVerifier;
        }

        @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            BoxLogUtils.v("onPageStarted ", str);
            if (checkNativeBrowserAuth(webView, str)) {
                return;
            }
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (checkNativeBrowserAuth(webView, webResourceRequest.getUrl().toString())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        private boolean checkNativeBrowserAuth(WebView webView, String str) {
            if (!str.contains(DeviceTrustJavascriptBridge.USE_NATIVE_BROWSER_AUTH) || str.equals(this.mLastNativeBrowserUrl)) {
                return false;
            }
            this.mLastNativeBrowserUrl = str;
            return (webView.getContext() instanceof NativeBrowserHandler) && ((NativeBrowserHandler) webView.getContext()).onNativeBrowserRequired(webView, str);
        }

        @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.endsWith(DeviceTrustJavascriptBridge.DEVICE_TRUST_URL_END)) {
                final WeakReference weakReference = new WeakReference(webView);
                webView.evaluateJavascript("DeviceTrust.readDeviceTrust(window.deviceTrust.requirements);", new ValueCallback<String>() { // from class: com.box.android.activities.login.DeviceTrustJavascriptBridge.DeviceTrustClient.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        BoxLogUtils.v("readDeviceTrust received value: " + str2);
                        new Thread(new DeviceTrustRequirementVerifier(str2, DeviceTrustClient.this.mDeviceTrustBridge, weakReference, DeviceTrustClient.this.deviceIntegrityVerifier)).start();
                    }
                });
            }
        }
    }
}
