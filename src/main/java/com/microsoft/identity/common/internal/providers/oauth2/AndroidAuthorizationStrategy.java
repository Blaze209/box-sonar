package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AndroidAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> implements IAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private final WeakReference<Activity> mReferencedActivity;
    private final WeakReference<Context> mReferencedApplicationContext;
    private final WeakReference<Fragment> mReferencedFragment;

    public AndroidAuthorizationStrategy(Context context, Activity activity, Fragment fragment) {
        if (context == null) {
            throw new NullPointerException("applicationContext is marked non-null but is null");
        }
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.mReferencedApplicationContext = new WeakReference<>(context);
        this.mReferencedActivity = new WeakReference<>(activity);
        this.mReferencedFragment = new WeakReference<>(fragment);
    }

    protected Context getApplicationContext() {
        return this.mReferencedApplicationContext.get();
    }

    protected void launchIntent(Intent intent) throws ClientException {
        if (intent == null) {
            throw new NullPointerException("intent is marked non-null but is null");
        }
        Fragment fragment = this.mReferencedFragment.get();
        if (fragment != null) {
            Fragment authorizationFragmentFromStartIntentWithState = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntentWithState(intent, intent.getExtras());
            FragmentManager fragmentManager = fragment.getFragmentManager();
            if (fragmentManager == null) {
                throw new ClientException("null_object", "Fragment Manager is null");
            }
            fragmentManager.beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).add(fragment.getId(), authorizationFragmentFromStartIntentWithState, Fragment.class.getName()).commit();
            return;
        }
        Activity activity = this.mReferencedActivity.get();
        if (activity == null) {
            throw new ClientException("null_object", "Referenced activity is null");
        }
        activity.startActivity(intent);
    }
}
