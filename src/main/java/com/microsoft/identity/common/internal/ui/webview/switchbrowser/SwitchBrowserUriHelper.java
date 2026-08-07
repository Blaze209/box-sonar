package com.microsoft.identity.common.internal.ui.webview.switchbrowser;

import android.net.Uri;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SwitchBrowserUriHelper.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000ej\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ6\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000ej\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000fH\u0002J \u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/switchbrowser/SwitchBrowserUriHelper;", "", "()V", "STATE_VALIDATION_REQUIRED", "", "getSTATE_VALIDATION_REQUIRED$common_distRelease", "()Z", "STATE_VALIDATION_REQUIRED$delegate", "Lkotlin/Lazy;", "TAG", "", "addStateToQueryParams", "", "queryParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "state", "methodTag", "buildProcessUri", "Landroid/net/Uri;", "uri", "buildResumeUri", "actionUri", "buildSwitchBrowserUri", "isSwitchBrowserRedirectUrl", "url", "redirectUrl", "switchBrowserPath", "statesMatch", "authorizationUrl", "validateActionUri", "actionUriString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchBrowserUriHelper {
    public static final SwitchBrowserUriHelper INSTANCE = new SwitchBrowserUriHelper();

    /* JADX INFO: renamed from: STATE_VALIDATION_REQUIRED$delegate, reason: from kotlin metadata */
    private static final Lazy STATE_VALIDATION_REQUIRED = LazyKt.lazy(new Function0<Boolean>() { // from class: com.microsoft.identity.common.internal.ui.webview.switchbrowser.SwitchBrowserUriHelper$STATE_VALIDATION_REQUIRED$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.SWITCH_BROWSER_PROTOCOL_REQUIRES_STATE));
        }
    });
    private static final String TAG = "SwitchBrowserUriHelper";

    private SwitchBrowserUriHelper() {
    }

    public final boolean getSTATE_VALIDATION_REQUIRED$common_distRelease() {
        return ((Boolean) STATE_VALIDATION_REQUIRED.getValue()).booleanValue();
    }

    public final Uri buildProcessUri(Uri uri) throws UnsupportedOperationException, IllegalArgumentException, NullPointerException, ClientException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter("code");
        String str = queryParameter;
        if (str == null || str.length() == 0) {
            ClientException clientException = new ClientException("malformed_url", "switch browser code is null or empty");
            Logger.error("SwitchBrowserUriHelper:buildProcessUri", "switch browser code is null or empty", clientException);
            throw clientException;
        }
        String queryParameter2 = uri.getQueryParameter(AuthenticationConstants.SWITCH_BROWSER.ACTION_URI);
        String str2 = queryParameter2;
        if (str2 == null || str2.length() == 0) {
            ClientException clientException2 = new ClientException("malformed_url", "switch browser action uri is null or empty");
            Logger.error("SwitchBrowserUriHelper:buildProcessUri", "switch browser action uri is null or empty", clientException2);
            throw clientException2;
        }
        validateActionUri(queryParameter2);
        String queryParameter3 = uri.getQueryParameter("state");
        HashMap<String, String> map = new HashMap<>();
        map.put("code", queryParameter);
        addStateToQueryParams(map, queryParameter3, "SwitchBrowserUriHelper:buildProcessUri");
        return buildSwitchBrowserUri(queryParameter2, map);
    }

    public final Uri buildResumeUri(String actionUri, String state) throws ClientException {
        Intrinsics.checkNotNullParameter(actionUri, "actionUri");
        validateActionUri(actionUri);
        HashMap<String, String> map = new HashMap<>();
        addStateToQueryParams(map, state, "SwitchBrowserUriHelper:buildResumeUri");
        return buildSwitchBrowserUri(actionUri, map);
    }

    public final boolean isSwitchBrowserRedirectUrl(String url, String redirectUrl, String switchBrowserPath) {
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(switchBrowserPath, "switchBrowserPath");
        if (url == null) {
            return false;
        }
        return StringsKt.startsWith(url, redirectUrl + '/' + switchBrowserPath, true);
    }

    public final void statesMatch(String authorizationUrl, String state) throws ClientException {
        Intrinsics.checkNotNullParameter(authorizationUrl, "authorizationUrl");
        if (!getSTATE_VALIDATION_REQUIRED$common_distRelease()) {
            Logger.info("SwitchBrowserUriHelper:statesMatch", "State validation is not required.");
            return;
        }
        Span spanCurrent = SpanExtension.current();
        String str = state;
        if (str == null || str.length() == 0) {
            ClientException clientException = new ClientException("state_mismatch", "State is null.");
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(clientException);
            spanCurrent.end();
            throw clientException;
        }
        String queryParameter = Uri.parse(authorizationUrl).getQueryParameter("state");
        String str2 = queryParameter;
        if (str2 == null || str2.length() == 0) {
            ClientException clientException2 = new ClientException("state_mismatch", "Authorization request state is null.");
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(clientException2);
            spanCurrent.end();
            throw clientException2;
        }
        if (!Intrinsics.areEqual(state, queryParameter)) {
            ClientException clientException3 = new ClientException("state_mismatch", "State does not match with the auth request state.");
            spanCurrent.setStatus(StatusCode.ERROR);
            spanCurrent.recordException(clientException3);
            spanCurrent.end();
            throw clientException3;
        }
        Logger.info("SwitchBrowserUriHelper:statesMatch", "States match.");
    }

    private final void addStateToQueryParams(HashMap<String, String> queryParams, String state, String methodTag) throws ClientException {
        if (getSTATE_VALIDATION_REQUIRED$common_distRelease()) {
            String str = state;
            if (str == null || str.length() == 0) {
                ClientException clientException = new ClientException(ClientException.MISSING_PARAMETER, "State is null or empty");
                Logger.error(methodTag, "State is null or empty", clientException);
                throw clientException;
            }
            queryParams.put("state", state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Uri buildSwitchBrowserUri$default(SwitchBrowserUriHelper switchBrowserUriHelper, String str, HashMap map, int i, Object obj) throws UnsupportedOperationException, IllegalArgumentException, NullPointerException {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        return switchBrowserUriHelper.buildSwitchBrowserUri(str, map);
    }

    private final Uri buildSwitchBrowserUri(String actionUri, HashMap<String, String> queryParams) throws UnsupportedOperationException, IllegalArgumentException, NullPointerException {
        Uri.Builder builderBuildUpon = Uri.parse(actionUri).buildUpon();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "queryParams.entries");
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        Uri uriBuild = builderBuildUpon.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "uriBuilder.build()");
        return uriBuild;
    }

    private final void validateActionUri(String actionUriString) throws ClientException {
        if (!AzureActiveDirectory.isInitialized()) {
            Logger.warn("SwitchBrowserUriHelper:validateActionUri", "AzureActiveDirectory is not initialized. Performing cloud discovery.");
            try {
                AzureActiveDirectory.performCloudDiscovery();
            } catch (Exception e) {
                Exception exc = e;
                Logger.error("SwitchBrowserUriHelper:validateActionUri", "Failed to perform cloud discovery for AAD authorities.", exc);
                throw new ClientException("io_error", "Failed to perform cloud discovery for AAD authorities.", exc);
            }
        }
        try {
            URL url = new URL(actionUriString);
            if (AzureActiveDirectory.isValidCloudHost(url)) {
                return;
            }
            String str = "Authority '" + url.getHost() + "' is not a valid AAD authority";
            ClientException clientException = new ClientException("unknown_authority", str);
            Logger.error("SwitchBrowserUriHelper:validateActionUri", str, clientException);
            throw clientException;
        } catch (MalformedURLException e2) {
            String str2 = "Malformed action URI: '" + actionUriString + '\'';
            MalformedURLException malformedURLException = e2;
            Logger.error("SwitchBrowserUriHelper:validateActionUri", str2, malformedURLException);
            throw new ClientException("malformed_url", str2, malformedURLException);
        }
    }
}
