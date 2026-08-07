package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.UiEndEvent;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.RequestContext;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AuthorizationFragment extends Fragment {
    private static final String TAG = "AuthorizationFragment";
    protected boolean mAuthResultSent = false;
    private final LocalBroadcaster.IReceiverCallback mCancelRequestReceiver = new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment.1
        @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
        public void onReceive(PropertyBag propertyBag) {
            AuthorizationFragment.this.cancelAuthorization(((Boolean) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, false)).booleanValue());
        }
    };
    private Bundle mInstanceState;

    void setInstanceState(Bundle bundle) {
        this.mInstanceState = bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str = TAG + ":onCreate";
        super.onCreate(bundle);
        LocalBroadcaster.INSTANCE.registerCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, this.mCancelRequestReceiver);
        if (bundle == null && this.mInstanceState == null) {
            Logger.warn(str, "No stored state. Unable to handle response");
            finish();
        } else if (bundle == null) {
            Logger.verbose(str, "Extract state from the intent bundle.");
            extractState(this.mInstanceState);
        } else {
            Logger.verbose(str, "Extract state from the saved bundle.");
            extractState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) { // from class: com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment.2
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                AuthorizationFragment.this.handleBackButtonPressed();
            }
        });
    }

    void finish() {
        LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST);
        FragmentActivity activity = getActivity();
        if (activity instanceof AuthorizationActivity) {
            activity.finish();
            return;
        }
        try {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).remove(this).commitNow();
            }
        } catch (Exception e) {
            Logger.error(TAG + "#finish", "Logged as error to capture 'cause'; Exception occurred when removing ourselves from provided FragmentManager", e);
        }
    }

    void extractState(Bundle bundle) {
        setDiagnosticContextForNewThread(bundle.getString("correlation_id"));
    }

    private static void setDiagnosticContextForNewThread(String str) {
        String str2 = TAG + ":setDiagnosticContextForAuthorizationActivity";
        RequestContext requestContext = new RequestContext();
        requestContext.put("correlation_id", str);
        DiagnosticContext.INSTANCE.setRequestContext(requestContext);
        Logger.verbose(str2, "Initializing diagnostic context for AuthorizationActivity");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        String str = TAG + ":onStop";
        FragmentActivity activity = getActivity();
        if (!this.mAuthResultSent && (activity == null || activity.isFinishing())) {
            Logger.info(str, "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
            Telemetry.emit(new UiEndEvent().isUserCancelled());
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String str = TAG + ":onDestroy";
        Logger.info(str, "");
        if (!this.mAuthResultSent) {
            Logger.info(str, "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
            Telemetry.emit(new UiEndEvent().isUserCancelled());
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST);
        super.onDestroy();
    }

    public void handleBackButtonPressed() {
        cancelAuthorization(true);
    }

    void sendResult(RawAuthorizationResult.ResultCode resultCode) {
        sendResult(RawAuthorizationResult.fromResultCode(resultCode));
    }

    void sendResult(RawAuthorizationResult rawAuthorizationResult) {
        Logger.info(TAG + ":sendResult", "Sending result from Authorization Activity, resultCode: " + rawAuthorizationResult.getResultCode());
        PropertyBag propertyBag = RawAuthorizationResult.toPropertyBag(rawAuthorizationResult);
        propertyBag.put(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, 1001);
        LocalBroadcaster.INSTANCE.broadcast(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT, propertyBag);
        this.mAuthResultSent = true;
    }

    void cancelAuthorization(boolean z) {
        String str = TAG + ":cancelAuthorization";
        if (z) {
            Logger.info(str, "Received Authorization flow cancelled by the user");
            sendResult(RawAuthorizationResult.ResultCode.CANCELLED);
        } else {
            Logger.info(str, "Received Authorization flow cancel request from SDK");
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        Telemetry.emit(new UiEndEvent().isUserCancelled());
        finish();
    }
}
