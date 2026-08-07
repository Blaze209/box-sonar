package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.msafederation.MsaFederationExtensions;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleApi;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleCredential;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleParameters;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.opentelemetry.OtelContextExtension;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.TextMapPropagatorExtension;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthorizationActivityFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/AuthorizationActivityFactory;", "", "()V", "getAuthorizationActivityIntent", "Landroid/content/Intent;", "parameters", "Lcom/microsoft/identity/common/internal/providers/oauth2/AuthorizationActivityParameters;", "authorizationActivityParameters", "signInWithGoogleCredential", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleCredential;", "getAuthorizationFragmentFromStartIntent", "Landroidx/fragment/app/Fragment;", "intent", "getAuthorizationFragmentFromStartIntentWithState", "bundle", "Landroid/os/Bundle;", "signInWithGoogleAndGetAuthorizationActivityIntent", "signInWithGoogleParameters", "Lcom/microsoft/identity/common/internal/msafederation/google/SignInWithGoogleParameters;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthorizationActivityFactory {
    public static final AuthorizationActivityFactory INSTANCE = new AuthorizationActivityFactory();

    private AuthorizationActivityFactory() {
    }

    @JvmStatic
    public static final Intent getAuthorizationActivityIntent(AuthorizationActivityParameters parameters) {
        Intent intent;
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LibraryConfiguration libraryConfiguration = LibraryConfiguration.getInstance();
        if (ProcessUtil.isBrokerProcess(parameters.getContext())) {
            intent = new Intent(parameters.getContext(), (Class<?>) BrokerAuthorizationActivity.class);
        } else if (libraryConfiguration.isAuthorizationInCurrentTask() && parameters.getAuthorizationAgent() != AuthorizationAgent.WEBVIEW) {
            intent = new Intent(parameters.getContext(), (Class<?>) CurrentTaskAuthorizationActivity.class);
        } else if (parameters.getWebViewEnableSilentAuthorizationFlowTimeOutMs() != null) {
            intent = new Intent(parameters.getContext(), (Class<?>) SilentAuthorizationActivity.class);
            intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT, parameters.getWebViewEnableSilentAuthorizationFlowTimeOutMs().longValue());
        } else {
            intent = new Intent(parameters.getContext(), (Class<?>) AuthorizationActivity.class);
        }
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.AUTH_INTENT, parameters.getAuthIntent());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.REQUEST_URL, parameters.getRequestUrl());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.REDIRECT_URI, parameters.getRedirectUri());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.REQUEST_HEADERS, parameters.getRequestHeader());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.AUTHORIZATION_AGENT, parameters.getAuthorizationAgent());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_CONTROLS_ENABLED, parameters.getWebViewZoomControlsEnabled());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_ZOOM_ENABLED, parameters.getWebViewZoomEnabled());
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_WEB_CP_ENABLED, parameters.isWebViewWebCpEnabled());
        intent.putExtra("correlation_id", DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        intent.putExtra(SerializableSpanContext.SERIALIZABLE_SPAN_CONTEXT, new CommonMoshiJsonAdapter().toJson(SerializableSpanContext.builder().traceId(SpanExtension.current().getSpanContext().getTraceId()).spanId(SpanExtension.current().getSpanContext().getSpanId()).traceFlags(SpanExtension.current().getSpanContext().getTraceFlags().asByte()).build()));
        intent.putExtra(AuthenticationConstants.AuthorizationIntentKey.OTEL_CONTEXT_CARRIER, TextMapPropagatorExtension.inject(OtelContextExtension.current()));
        if (parameters.getSourceLibraryName() != null) {
            intent.putExtra("x-client-SKU", parameters.getSourceLibraryName());
        }
        if (parameters.getSourceLibraryVersion() != null) {
            intent.putExtra("x-client-Ver", parameters.getSourceLibraryVersion());
        }
        if (parameters.getUtid() != null) {
            intent.putExtra(com.microsoft.identity.common.java.AuthenticationConstants.OAuth2.UTID, parameters.getUtid());
        }
        return intent;
    }

    @JvmStatic
    public static final Fragment getAuthorizationFragmentFromStartIntent(Intent intent) {
        BrowserAuthorizationFragment browserAuthorizationFragment;
        SilentWebViewAuthorizationFragment webViewAuthorizationFragment;
        Intrinsics.checkNotNullParameter(intent, "intent");
        AuthorizationAgent authorizationAgent = (AuthorizationAgent) intent.getSerializableExtra(AuthenticationConstants.AuthorizationIntentKey.AUTHORIZATION_AGENT);
        LibraryConfiguration libraryConfiguration = LibraryConfiguration.getInstance();
        if (authorizationAgent == AuthorizationAgent.WEBVIEW) {
            if (intent.hasExtra(AuthenticationConstants.AuthorizationIntentKey.WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT)) {
                webViewAuthorizationFragment = new SilentWebViewAuthorizationFragment();
            } else {
                webViewAuthorizationFragment = new WebViewAuthorizationFragment();
            }
            return webViewAuthorizationFragment;
        }
        if (libraryConfiguration.isAuthorizationInCurrentTask()) {
            browserAuthorizationFragment = new CurrentTaskBrowserAuthorizationFragment();
        } else {
            browserAuthorizationFragment = new BrowserAuthorizationFragment();
        }
        return browserAuthorizationFragment;
    }

    @JvmStatic
    public static final Intent signInWithGoogleAndGetAuthorizationActivityIntent(AuthorizationActivityParameters authorizationActivityParameters, SignInWithGoogleParameters signInWithGoogleParameters) {
        Intrinsics.checkNotNullParameter(authorizationActivityParameters, "authorizationActivityParameters");
        Intrinsics.checkNotNullParameter(signInWithGoogleParameters, "signInWithGoogleParameters");
        return getAuthorizationActivityIntent(authorizationActivityParameters, SignInWithGoogleApi.INSTANCE.getInstance().signInSync(signInWithGoogleParameters));
    }

    @JvmStatic
    public static final Intent getAuthorizationActivityIntent(AuthorizationActivityParameters authorizationActivityParameters, SignInWithGoogleCredential signInWithGoogleCredential) throws ClientException {
        HashMap map;
        Intrinsics.checkNotNullParameter(authorizationActivityParameters, "authorizationActivityParameters");
        Intrinsics.checkNotNullParameter(signInWithGoogleCredential, "signInWithGoogleCredential");
        HashMap<String, String> requestHeader = authorizationActivityParameters.getRequestHeader();
        if (requestHeader == null || requestHeader.isEmpty()) {
            map = new HashMap();
        } else {
            map = new HashMap(authorizationActivityParameters.getRequestHeader());
        }
        HashMap map2 = map;
        map2.putAll(MsaFederationExtensions.getIdProviderHeadersForAuthorization(signInWithGoogleCredential));
        try {
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder(authorizationActivityParameters.getRequestUrl());
            Map.Entry<String, String> idProviderExtraQueryParamForAuthorization = MsaFederationExtensions.getIdProviderExtraQueryParamForAuthorization(signInWithGoogleCredential);
            commonURIBuilder.addParameterIfAbsent(idProviderExtraQueryParamForAuthorization.getKey(), idProviderExtraQueryParamForAuthorization.getValue());
            String string = commonURIBuilder.build().toString();
            Intrinsics.checkNotNullExpressionValue(string, "uriBuilder.build().toString()");
            return getAuthorizationActivityIntent(AuthorizationActivityParameters.copy$default(authorizationActivityParameters, null, null, string, null, map2, null, false, false, null, null, null, null, false, 8171, null));
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", "Failed to add id provider query parameter to request URL", e);
        }
    }

    @JvmStatic
    public static final Fragment getAuthorizationFragmentFromStartIntentWithState(Intent intent, Bundle bundle) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Fragment authorizationFragmentFromStartIntent = getAuthorizationFragmentFromStartIntent(intent);
        if (authorizationFragmentFromStartIntent instanceof AuthorizationFragment) {
            ((AuthorizationFragment) authorizationFragmentFromStartIntent).setInstanceState(bundle);
        }
        return authorizationFragmentFromStartIntent;
    }
}
