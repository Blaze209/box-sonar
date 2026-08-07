package com.microsoft.identity.client;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class SignInParameters {
    private Activity activity;
    private AuthenticationCallback callback;
    private String loginHint;
    private Prompt prompt;
    private List<String> scopes;

    public static class SignInParametersBuilder {
        private Activity activity;
        private AuthenticationCallback callback;
        private String loginHint;
        private Prompt prompt;
        private ArrayList<String> scopes;

        SignInParametersBuilder() {
        }

        public SignInParameters build() {
            List listEmptyList;
            ArrayList<String> arrayList = this.scopes;
            int size = arrayList == null ? 0 : arrayList.size();
            if (size != 0) {
                listEmptyList = size != 1 ? Collections.unmodifiableList(new ArrayList(this.scopes)) : Collections.singletonList(this.scopes.get(0));
            } else {
                listEmptyList = Collections.emptyList();
            }
            return new SignInParameters(this.activity, this.loginHint, listEmptyList, this.prompt, this.callback);
        }

        public SignInParametersBuilder clearScopes() {
            ArrayList<String> arrayList = this.scopes;
            if (arrayList != null) {
                arrayList.clear();
            }
            return this;
        }

        public String toString() {
            return "SignInParameters.SignInParametersBuilder(activity=" + this.activity + ", loginHint=" + this.loginHint + ", scopes=" + this.scopes + ", prompt=" + this.prompt + ", callback=" + this.callback + ")";
        }

        public SignInParametersBuilder withActivity(Activity activity) {
            if (activity == null) {
                throw new NullPointerException("activity is marked non-null but is null");
            }
            this.activity = activity;
            return this;
        }

        public SignInParametersBuilder withCallback(AuthenticationCallback authenticationCallback) {
            if (authenticationCallback == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            this.callback = authenticationCallback;
            return this;
        }

        public SignInParametersBuilder withLoginHint(String str) {
            this.loginHint = str;
            return this;
        }

        public SignInParametersBuilder withPrompt(Prompt prompt) {
            this.prompt = prompt;
            return this;
        }

        public SignInParametersBuilder withScope(String str) {
            if (this.scopes == null) {
                this.scopes = new ArrayList<>();
            }
            this.scopes.add(str);
            return this;
        }

        public SignInParametersBuilder withScopes(Collection<? extends String> collection) {
            if (collection == null) {
                throw new NullPointerException("scopes cannot be null");
            }
            if (this.scopes == null) {
                this.scopes = new ArrayList<>();
            }
            this.scopes.addAll(collection);
            return this;
        }
    }

    SignInParameters(Activity activity, String str, List<String> list, Prompt prompt, AuthenticationCallback authenticationCallback) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        if (authenticationCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        this.activity = activity;
        this.loginHint = str;
        this.scopes = list;
        this.prompt = prompt;
        this.callback = authenticationCallback;
    }

    public static SignInParametersBuilder builder() {
        return new SignInParametersBuilder();
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof SignInParameters;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInParameters)) {
            return false;
        }
        SignInParameters signInParameters = (SignInParameters) obj;
        if (!signInParameters.canEqual(this)) {
            return false;
        }
        Activity activity = getActivity();
        Activity activity2 = signInParameters.getActivity();
        if (activity != null ? !activity.equals(activity2) : activity2 != null) {
            return false;
        }
        String loginHint = getLoginHint();
        String loginHint2 = signInParameters.getLoginHint();
        if (loginHint != null ? !loginHint.equals(loginHint2) : loginHint2 != null) {
            return false;
        }
        List<String> scopes = getScopes();
        List<String> scopes2 = signInParameters.getScopes();
        if (scopes != null ? !scopes.equals(scopes2) : scopes2 != null) {
            return false;
        }
        Prompt prompt = getPrompt();
        Prompt prompt2 = signInParameters.getPrompt();
        if (prompt != null ? !prompt.equals(prompt2) : prompt2 != null) {
            return false;
        }
        AuthenticationCallback callback = getCallback();
        AuthenticationCallback callback2 = signInParameters.getCallback();
        return callback != null ? callback.equals(callback2) : callback2 == null;
    }

    public int hashCode() {
        Activity activity = getActivity();
        int iHashCode = activity == null ? 43 : activity.hashCode();
        String loginHint = getLoginHint();
        int iHashCode2 = ((iHashCode + 59) * 59) + (loginHint == null ? 43 : loginHint.hashCode());
        List<String> scopes = getScopes();
        int iHashCode3 = (iHashCode2 * 59) + (scopes == null ? 43 : scopes.hashCode());
        Prompt prompt = getPrompt();
        int i = iHashCode3 * 59;
        int iHashCode4 = prompt == null ? 43 : prompt.hashCode();
        AuthenticationCallback callback = getCallback();
        return ((i + iHashCode4) * 59) + (callback != null ? callback.hashCode() : 43);
    }

    public void setActivity(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.activity = activity;
    }

    public void setCallback(AuthenticationCallback authenticationCallback) {
        if (authenticationCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        this.callback = authenticationCallback;
    }

    public void setLoginHint(String str) {
        this.loginHint = str;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setScopes(List<String> list) {
        if (list == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        this.scopes = list;
    }

    public String toString() {
        return "SignInParameters(activity=" + getActivity() + ", loginHint=" + getLoginHint() + ", scopes=" + getScopes() + ", prompt=" + getPrompt() + ", callback=" + getCallback() + ")";
    }

    public Activity getActivity() {
        return this.activity;
    }

    public String getLoginHint() {
        return this.loginHint;
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    public Prompt getPrompt() {
        return this.prompt;
    }

    public AuthenticationCallback getCallback() {
        return this.callback;
    }
}
