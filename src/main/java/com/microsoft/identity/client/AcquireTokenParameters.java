package com.microsoft.identity.client;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AcquireTokenParameters extends TokenParameters {
    private Activity mActivity;
    private AuthenticationCallback mCallback;
    private String mDomainHint;
    private List<Map.Entry<String, String>> mExtraQueryStringParameters;
    private List<String> mExtraScopesToConsent;
    private Fragment mFragment;
    private String mLoginHint;
    private PreferredAuthMethod mPreferredAuthMethod;
    private Prompt mPrompt;

    public AcquireTokenParameters(Builder builder) {
        super(builder);
        this.mActivity = builder.mActivity;
        this.mFragment = builder.mFragment;
        this.mLoginHint = builder.mLoginHint;
        this.mDomainHint = builder.mDomainHint;
        this.mPreferredAuthMethod = builder.mPreferredAuthMethod;
        this.mPrompt = builder.mPrompt;
        this.mExtraScopesToConsent = builder.mExtraScopesToConsent;
        this.mExtraQueryStringParameters = builder.mExtraQueryStringParameters;
        this.mCallback = builder.mCallback;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public String getLoginHint() {
        return this.mLoginHint;
    }

    void setLoginHint(String str) {
        this.mLoginHint = str;
    }

    public String getDomainHint() {
        return this.mDomainHint;
    }

    void setDomainHint(String str) {
        this.mDomainHint = str;
    }

    public PreferredAuthMethod getPreferredAuthMethod() {
        return this.mPreferredAuthMethod;
    }

    public Prompt getPrompt() {
        return this.mPrompt;
    }

    public List<String> getExtraScopesToConsent() {
        return this.mExtraScopesToConsent;
    }

    public List<Map.Entry<String, String>> getExtraQueryStringParameters() {
        return this.mExtraQueryStringParameters;
    }

    public AuthenticationCallback getCallback() {
        return this.mCallback;
    }

    public static class Builder extends TokenParameters.Builder<Builder> {
        private Activity mActivity;
        private AuthenticationCallback mCallback;
        private String mDomainHint;
        private List<Map.Entry<String, String>> mExtraQueryStringParameters;
        private List<String> mExtraScopesToConsent;
        private Fragment mFragment;
        private String mLoginHint;
        private PreferredAuthMethod mPreferredAuthMethod;
        private Prompt mPrompt;

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        public Builder startAuthorizationFromActivity(Activity activity) {
            this.mActivity = activity;
            return self();
        }

        public Builder withFragment(Fragment fragment) {
            this.mFragment = fragment;
            return self();
        }

        public Builder withLoginHint(String str) {
            this.mLoginHint = str;
            return self();
        }

        public Builder withDomainHint(String str) {
            this.mDomainHint = str;
            return self();
        }

        public Builder withPreferredAuthMethod(PreferredAuthMethod preferredAuthMethod) {
            this.mPreferredAuthMethod = preferredAuthMethod;
            return self();
        }

        public Builder withPrompt(Prompt prompt) {
            this.mPrompt = prompt;
            return self();
        }

        public Builder withOtherScopesToAuthorize(List<String> list) {
            this.mExtraScopesToConsent = list;
            return self();
        }

        public Builder withAuthorizationQueryStringParameters(List<Map.Entry<String, String>> list) {
            this.mExtraQueryStringParameters = list;
            return self();
        }

        public Builder withCallback(AuthenticationCallback authenticationCallback) {
            this.mCallback = authenticationCallback;
            return self();
        }

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public AcquireTokenParameters build() {
            return new AcquireTokenParameters(this);
        }
    }
}
