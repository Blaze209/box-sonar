package com.box.android.activities.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.box.android.R;
import com.box.android.application.BoxApplication;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity;
import com.box.android.base.presentation.views.BoxSDKOAuthWebView;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.androidsdk.content.auth.OAuthWebView;
import com.box.androidsdk.content.models.BoxSession;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import dagger.hilt.android.AndroidEntryPoint;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WopiOAuthActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020#H\u0016J\u0012\u0010,\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020#H\u0016J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012@\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lcom/box/android/activities/login/WopiOAuthActivity;", "Lcom/box/android/base/presentation/activities/BoxSpinnerDialogFragmentActivity;", "Lcom/box/androidsdk/content/auth/OAuthWebView$OAuthWebViewClient$WebEventListener;", "<init>", "()V", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getMUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setMUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "mBveManager", "Lcom/box/android/domain/services/IBVEManager;", "getMBveManager", "()Lcom/box/android/domain/services/IBVEManager;", "setMBveManager", "(Lcom/box/android/domain/services/IBVEManager;)V", "forceUpdateCoordinator", "Lcom/box/android/domain/services/IForceUpdateCoordinator;", "getForceUpdateCoordinator", "()Lcom/box/android/domain/services/IForceUpdateCoordinator;", "setForceUpdateCoordinator", "(Lcom/box/android/domain/services/IForceUpdateCoordinator;)V", "mWebView", "Lcom/box/android/base/presentation/views/BoxSDKOAuthWebView;", "getMWebView", "()Lcom/box/android/base/presentation/views/BoxSDKOAuthWebView;", "setMWebView", "(Lcom/box/android/base/presentation/views/BoxSDKOAuthWebView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseQueryParameters", "", "", "query", "buildUrlForAccessToken", "Landroid/net/Uri$Builder;", "clientId", "redirectUrl", "onReceivedAuthCode", "code", "baseDomain", "interceptCodeReceived", "onVerifiedEnterprise", "domain", "onAuthFailure", "", "failure", "Lcom/box/androidsdk/content/auth/OAuthWebView$AuthFailure;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class WopiOAuthActivity extends Hilt_WopiOAuthActivity implements OAuthWebView.OAuthWebViewClient.WebEventListener {
    public static final String AUTHORIZATION = "Authorization";
    public static final String CLIENT_ID = "client_id";
    public static final String CODE = "code";
    public static final String OFFICE_REQUEST_KEY = "AuthorizeUrlQueryParams";
    public static final String OFFICE_RESPONSE_KEY = "ResonponseUrlQueryParams";
    public static final String REDIRECT_URI = "redirect_uri";
    private IForceUpdateCoordinator forceUpdateCoordinator;

    @Inject
    public IBVEManager mBveManager;

    @Inject
    public IUserContextManager mUserContextManager;
    public BoxSDKOAuthWebView mWebView;
    public static final int $stable = 8;

    public final IUserContextManager getMUserContextManager() {
        IUserContextManager iUserContextManager = this.mUserContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mUserContextManager");
        return null;
    }

    public final void setMUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.mUserContextManager = iUserContextManager;
    }

    public final IBVEManager getMBveManager() {
        IBVEManager iBVEManager = this.mBveManager;
        if (iBVEManager != null) {
            return iBVEManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBveManager");
        return null;
    }

    public final void setMBveManager(IBVEManager iBVEManager) {
        Intrinsics.checkNotNullParameter(iBVEManager, "<set-?>");
        this.mBveManager = iBVEManager;
    }

    public final IForceUpdateCoordinator getForceUpdateCoordinator() {
        return this.forceUpdateCoordinator;
    }

    @Inject
    public final void setForceUpdateCoordinator(IForceUpdateCoordinator iForceUpdateCoordinator) {
        this.forceUpdateCoordinator = iForceUpdateCoordinator;
    }

    public final BoxSDKOAuthWebView getMWebView() {
        BoxSDKOAuthWebView boxSDKOAuthWebView = this.mWebView;
        if (boxSDKOAuthWebView != null) {
            return boxSDKOAuthWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWebView");
        return null;
    }

    public final void setMWebView(BoxSDKOAuthWebView boxSDKOAuthWebView) {
        Intrinsics.checkNotNullParameter(boxSDKOAuthWebView, "<set-?>");
        this.mWebView = boxSDKOAuthWebView;
    }

    @Override // com.box.android.activities.login.Hilt_WopiOAuthActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        IForceUpdateCoordinator iForceUpdateCoordinator = this.forceUpdateCoordinator;
        if (iForceUpdateCoordinator != null) {
            iForceUpdateCoordinator.enforceIfNeeded();
        }
        setContentView(R.layout.boxsdk_auth_lite);
        View viewFindViewById = findViewById(R.id.oauthview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        setMWebView((BoxSDKOAuthWebView) viewFindViewById);
        Intent intent = getIntent();
        getMWebView().getSettings().setJavaScriptEnabled(true);
        String stringExtra = intent.getStringExtra(OFFICE_REQUEST_KEY);
        String str = stringExtra;
        if (str != null && str.length() != 0) {
            Map<String, String> queryParameters = parseQueryParameters(stringExtra);
            String str2 = queryParameters.get("client_id");
            String str3 = queryParameters.get("redirect_uri");
            if (str2 == null || str3 == null) {
                return;
            }
            BoxSession boxSession = getMUserContextManager().getBoxSession(getApplicationContext());
            HashMap map = new HashMap();
            map.put("Authorization", "Bearer " + boxSession.getAuthInfo().accessToken());
            getMWebView().setWebViewClient(new OAuthWebView.OAuthWebViewClient(this, URLDecoder.decode(str3, "UTF-8")));
            String string = buildUrlForAccessToken(str2, str3).build().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            getMWebView().loadUrl(string, map);
            return;
        }
        finish();
    }

    private final Map<String, String> parseQueryParameters(String query) {
        List listSplit$default = StringsKt.split$default((CharSequence) query, new String[]{MsalUtils.QUERY_STRING_DELIMITER}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{SimpleComparison.EQUAL_TO_OPERATION}, false, 2, 2, (Object) null);
            Pair pair = listSplit$default2.size() == 2 ? TuplesKt.to(listSplit$default2.get(0), listSplit$default2.get(1)) : null;
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return MapsKt.toMap(arrayList2);
    }

    private final Uri.Builder buildUrlForAccessToken(String clientId, String redirectUrl) {
        Uri.Builder builder = new Uri.Builder();
        ConfigManager configManager = BoxApplication.getInstance().getConfigManager();
        builder.scheme(configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        builder.authority(configManager.getString(BoxConfigConstants.CONFIG_KEY_OAUTH_URL_AUTHORITY));
        builder.path(configManager.getArray(BoxConfigConstants.CONFIG_KEY_FALLBACK_PATHS_ARRAY)[0]);
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("client_id", clientId);
        builder.appendQueryParameter("redirect_uri", URLDecoder.decode(redirectUrl, "UTF-8"));
        return builder;
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String code, String baseDomain) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(baseDomain, "baseDomain");
        onReceivedAuthCode(code);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onReceivedAuthCode(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intent intent = new Intent();
        intent.putExtra(OFFICE_RESPONSE_KEY, "code=" + code);
        setResult(-1, intent);
        finish();
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void interceptCodeReceived(String code) {
        BoxIntuneMAMAuthActivity.Companion.startActivity$default(BoxIntuneMAMAuthActivity.INSTANCE, this, null, false, null, false, 24, null);
        finish();
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public void onVerifiedEnterprise(String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        getMBveManager().setVerifiedEnterprise(true);
        getMBveManager().setVerifiedEnterpriseDomain(domain);
    }

    @Override // com.box.androidsdk.content.auth.OAuthWebView.OAuthWebViewClient.WebEventListener
    public boolean onAuthFailure(OAuthWebView.AuthFailure failure) {
        Intent intent = new Intent();
        intent.putExtra(OFFICE_RESPONSE_KEY, "error=invalid_request&error_description=\"Error logging in\"");
        setResult(0, intent);
        finish();
        return true;
    }
}
