package com.microsoft.identity.common.internal.ui;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.ui.browser.DefaultBrowserAuthorizationStrategy;
import com.microsoft.identity.common.internal.ui.webview.EmbeddedWebViewAuthorizationStrategy;
import com.microsoft.identity.common.java.browser.Browser;
import com.microsoft.identity.common.java.browser.IBrowserSelector;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import com.microsoft.identity.common.logging.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidAuthorizationStrategyFactory implements IAuthorizationStrategyFactory<IAuthorizationStrategy> {
    private static final String TAG = "AndroidAuthorizationStrategyFactory";
    private final Activity mActivity;
    private final IBrowserSelector mBrowserSelector;
    private final Context mContext;
    private final Fragment mFragment;

    public static class AndroidAuthorizationStrategyFactoryBuilder {
        private Activity activity;
        private IBrowserSelector browserSelector;
        private Context context;
        private Fragment fragment;

        AndroidAuthorizationStrategyFactoryBuilder() {
        }

        public AndroidAuthorizationStrategyFactoryBuilder activity(Activity activity) {
            this.activity = activity;
            return this;
        }

        public AndroidAuthorizationStrategyFactoryBuilder browserSelector(IBrowserSelector iBrowserSelector) {
            this.browserSelector = iBrowserSelector;
            return this;
        }

        public AndroidAuthorizationStrategyFactory build() {
            return new AndroidAuthorizationStrategyFactory(this.context, this.activity, this.fragment, this.browserSelector);
        }

        public AndroidAuthorizationStrategyFactoryBuilder context(Context context) {
            this.context = context;
            return this;
        }

        public AndroidAuthorizationStrategyFactoryBuilder fragment(Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public String toString() {
            return "AndroidAuthorizationStrategyFactory.AndroidAuthorizationStrategyFactoryBuilder(context=" + this.context + ", activity=" + this.activity + ", fragment=" + this.fragment + ", browserSelector=" + this.browserSelector + ")";
        }
    }

    AndroidAuthorizationStrategyFactory(Context context, Activity activity, Fragment fragment, IBrowserSelector iBrowserSelector) {
        this.mContext = context;
        this.mActivity = activity;
        this.mFragment = fragment;
        this.mBrowserSelector = iBrowserSelector;
    }

    public static AndroidAuthorizationStrategyFactoryBuilder builder() {
        return new AndroidAuthorizationStrategyFactoryBuilder();
    }

    @Override // com.microsoft.identity.common.java.strategies.IAuthorizationStrategyFactory
    public IAuthorizationStrategy getAuthorizationStrategy(AuthorizationAgent authorizationAgent, List<BrowserDescriptor> list, BrowserDescriptor browserDescriptor, boolean z) {
        String str = TAG + ":getAuthorizationStrategy";
        Browser browserSelectBrowser = this.mBrowserSelector.selectBrowser(list, browserDescriptor);
        if (authorizationAgent == AuthorizationAgent.WEBVIEW || browserSelectBrowser == null) {
            Logger.info(str, "WebView authorization, browser: " + browserSelectBrowser);
            return getGenericAuthorizationStrategy();
        }
        Logger.info(str, "Browser authorization, browser: " + browserSelectBrowser);
        return getBrowserAuthorizationStrategy(browserSelectBrowser, z);
    }

    private IAuthorizationStrategy getBrowserAuthorizationStrategy(Browser browser, boolean z) {
        if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask()) {
            return new CurrentTaskBrowserAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment, browser);
        }
        return new DefaultBrowserAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment, z, browser);
    }

    private IAuthorizationStrategy getGenericAuthorizationStrategy() {
        return new EmbeddedWebViewAuthorizationStrategy(this.mContext, this.mActivity, this.mFragment);
    }
}
