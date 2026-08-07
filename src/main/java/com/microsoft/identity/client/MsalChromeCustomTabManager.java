package com.microsoft.identity.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class MsalChromeCustomTabManager {
    private static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1;
    private static final String TAG = "MsalChromeCustomTabManager";
    private String mChromePackageWithCustomTabSupport;
    private CustomTabsIntent mCustomTabsIntent;
    private MsalCustomTabsServiceConnection mCustomTabsServiceConnection;
    private Activity mParentActivity;

    public MsalChromeCustomTabManager(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity parameter cannot be null");
        }
        this.mParentActivity = activity;
        this.mChromePackageWithCustomTabSupport = MsalUtils.getChromePackageWithCustomTabSupport(activity.getApplicationContext());
    }

    protected void verifyChromeTabOrBrowser() throws MsalClientException {
        String str = TAG + ":verifyChromeTabOrBrowser";
        if (this.mChromePackageWithCustomTabSupport == null) {
            com.microsoft.identity.common.logging.Logger.warn(str, "Custom tab is not supported by Chrome.");
        } else {
            if (MsalUtils.getChromePackage(this.mParentActivity.getApplicationContext()) != null) {
                return;
            }
            com.microsoft.identity.common.logging.Logger.warn(str, "Chrome is not installed.");
            throw new MsalClientException("chrome_not_installed", "Chrome is not installed.");
        }
    }

    public synchronized void bindCustomTabsService() {
        if (this.mChromePackageWithCustomTabSupport != null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            MsalCustomTabsServiceConnection msalCustomTabsServiceConnection = new MsalCustomTabsServiceConnection(countDownLatch);
            this.mCustomTabsServiceConnection = msalCustomTabsServiceConnection;
            CustomTabsClient.bindCustomTabsService(this.mParentActivity, this.mChromePackageWithCustomTabSupport, msalCustomTabsServiceConnection);
            CustomTabsIntent customTabsIntentBuild = (waitForServiceConnectionToEstablish(countDownLatch) ? new CustomTabsIntent.Builder(this.mCustomTabsServiceConnection.getCustomTabsSession()) : new CustomTabsIntent.Builder()).setShowTitle(true).build();
            this.mCustomTabsIntent = customTabsIntentBuild;
            customTabsIntentBuild.intent.setPackage(this.mChromePackageWithCustomTabSupport);
        }
    }

    private boolean waitForServiceConnectionToEstablish(CountDownLatch countDownLatch) {
        String str = TAG + ":waitForServiceConnectionToEstablish";
        try {
            if (countDownLatch.await(1L, TimeUnit.SECONDS)) {
                return true;
            }
            com.microsoft.identity.common.logging.Logger.warn(str, "Connection to CustomTabs timed out. Skipping warmup.");
            return false;
        } catch (InterruptedException e) {
            com.microsoft.identity.common.logging.Logger.error(str, "Failed to connect to CustomTabs. Skipping warmup.", e);
            return false;
        }
    }

    public synchronized void unbindCustomTabsService() {
        MsalCustomTabsServiceConnection msalCustomTabsServiceConnection = this.mCustomTabsServiceConnection;
        if (msalCustomTabsServiceConnection != null && msalCustomTabsServiceConnection.getCustomTabsServiceIsBound()) {
            this.mParentActivity.unbindService(this.mCustomTabsServiceConnection);
            this.mCustomTabsServiceConnection.unbindCustomTabsService();
        }
    }

    public void launchChromeTabOrBrowserForUrl(String str) {
        String str2 = TAG + ":launchChromeTabOrBrowserForUrl";
        if (this.mChromePackageWithCustomTabSupport != null && this.mCustomTabsIntent != null) {
            com.microsoft.identity.common.logging.Logger.info(str2, "ChromeCustomTab support is available, launching chrome tab.");
            this.mCustomTabsIntent.launchUrl(this.mParentActivity, Uri.parse(str));
            return;
        }
        com.microsoft.identity.common.logging.Logger.info(str2, "Chrome tab support is not available, launching chrome browser.");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setPackage(MsalUtils.getChromePackage(this.mParentActivity.getApplicationContext()));
        intent.addCategory("android.intent.category.BROWSABLE");
        this.mParentActivity.startActivity(intent);
    }

    private static class MsalCustomTabsServiceConnection extends CustomTabsServiceConnection {
        private CustomTabsClient mCustomTabsClient;
        private boolean mCustomTabsServiceIsBound;
        private CustomTabsSession mCustomTabsSession;
        private final WeakReference<CountDownLatch> mLatchWeakReference;

        MsalCustomTabsServiceConnection(CountDownLatch countDownLatch) {
            this.mLatchWeakReference = new WeakReference<>(countDownLatch);
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            CountDownLatch countDownLatch = this.mLatchWeakReference.get();
            this.mCustomTabsServiceIsBound = true;
            this.mCustomTabsClient = customTabsClient;
            customTabsClient.warmup(0L);
            this.mCustomTabsSession = this.mCustomTabsClient.newSession(null);
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            unbindCustomTabsService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unbindCustomTabsService() {
            this.mCustomTabsClient = null;
            this.mCustomTabsServiceIsBound = false;
        }

        CustomTabsSession getCustomTabsSession() {
            return this.mCustomTabsSession;
        }

        boolean getCustomTabsServiceIsBound() {
            return this.mCustomTabsServiceIsBound;
        }
    }
}
