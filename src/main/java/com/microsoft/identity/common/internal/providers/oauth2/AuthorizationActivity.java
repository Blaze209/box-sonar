package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.ui.DualScreenActivity;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.opentelemetry.TextMapPropagatorExtension;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
public class AuthorizationActivity extends DualScreenActivity {
    public static final String TAG = "AuthorizationActivity";
    private AuthorizationFragment mFragment;
    private Context mOtelContext;
    private SpanContext mSpanContext;

    public SpanContext getSpanContext() {
        return this.mSpanContext;
    }

    public Context getOtelContext() {
        return this.mOtelContext;
    }

    public AuthorizationFragment getFragment() {
        return this.mFragment;
    }

    @Override // com.microsoft.identity.common.internal.ui.DualScreenActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        HashMap map;
        super.onMAMCreate(bundle);
        String str = TAG + ":onCreate";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                String string = extras.getString(SerializableSpanContext.SERIALIZABLE_SPAN_CONTEXT);
                this.mSpanContext = StringUtil.isNullOrEmpty(string) ? null : (SpanContext) new CommonMoshiJsonAdapter().fromJson(string, SerializableSpanContext.class);
                if (Build.VERSION.SDK_INT >= 33) {
                    map = (HashMap) extras.getSerializable(AuthenticationConstants.AuthorizationIntentKey.OTEL_CONTEXT_CARRIER, HashMap.class);
                } else {
                    map = (HashMap) extras.getSerializable(AuthenticationConstants.AuthorizationIntentKey.OTEL_CONTEXT_CARRIER);
                }
                this.mOtelContext = TextMapPropagatorExtension.extract(map);
            } catch (TerminalException | ClassCastException | NullPointerException e) {
                Logger.error(str, "Exception thrown during extraction: " + e.getMessage(), e);
            }
        }
        Fragment authorizationFragmentFromStartIntent = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntent(getIntent());
        if (authorizationFragmentFromStartIntent instanceof AuthorizationFragment) {
            AuthorizationFragment authorizationFragment = (AuthorizationFragment) authorizationFragmentFromStartIntent;
            this.mFragment = authorizationFragment;
            authorizationFragment.setInstanceState(extras);
        } else {
            Logger.error(str, "Did not receive AuthorizationFragment from factory", new IllegalStateException("Unexpected fragment type."));
        }
        setFragment(this.mFragment);
    }
}
