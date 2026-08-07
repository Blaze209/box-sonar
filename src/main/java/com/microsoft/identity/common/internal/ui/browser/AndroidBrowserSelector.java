package com.microsoft.identity.common.internal.ui.browser;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsService;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.java.browser.Browser;
import com.microsoft.identity.common.java.browser.IBrowserSelector;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidBrowserSelector implements IBrowserSelector {
    private static final String LOGGING_MSG_BROWSER = "Browser: ";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private static final String TAG = "AndroidBrowserSelector";
    private final PackageManager mPackageManager;

    public AndroidBrowserSelector(Context context) {
        this.mPackageManager = context.getPackageManager();
    }

    @Override // com.microsoft.identity.common.java.browser.IBrowserSelector
    public Browser selectBrowser(List<BrowserDescriptor> list, BrowserDescriptor browserDescriptor) {
        Browser preferredBrowser;
        String str = TAG + ":select";
        Logger.verbose(str, "Select the browser to launch.");
        if (browserDescriptor != null && (preferredBrowser = getPreferredBrowser(browserDescriptor)) != null) {
            return preferredBrowser;
        }
        Browser defaultBrowser = getDefaultBrowser(list);
        if (defaultBrowser != null) {
            return defaultBrowser;
        }
        Logger.warn(str, "No available browser installed on the device.");
        return null;
    }

    private static boolean matches(BrowserDescriptor browserDescriptor, Browser browser) {
        String str = TAG + ":matches";
        if (!StringUtil.equalsIgnoreCase(browserDescriptor.getPackageName(), browser.getPackageName())) {
            return false;
        }
        if (!browserDescriptor.getSignatureHashes().equals(browser.getSignatureHashes())) {
            Logger.warn(str, LOGGING_MSG_BROWSER + browser.getPackageName() + " signature hash not match");
            return false;
        }
        if (!StringUtil.isNullOrEmpty(browserDescriptor.getVersionLowerBound()) && BrokerProtocolVersionUtil.compareSemanticVersion(browser.getVersion(), browserDescriptor.getVersionLowerBound()) == -1) {
            Logger.warn(str, LOGGING_MSG_BROWSER + browser.getPackageName() + " version too low (Expected: " + browserDescriptor.getVersionLowerBound() + " Get: " + browser.getVersion() + ")");
            return false;
        }
        if (StringUtil.isNullOrEmpty(browserDescriptor.getVersionUpperBound()) || BrokerProtocolVersionUtil.compareSemanticVersion(browser.getVersion(), browserDescriptor.getVersionUpperBound()) != 1) {
            return true;
        }
        Logger.warn(str, LOGGING_MSG_BROWSER + browser.getPackageName() + " version too high (Expected: " + browserDescriptor.getVersionUpperBound() + " Get: " + browser.getVersion() + ")");
        return false;
    }

    private Browser getPreferredBrowser(BrowserDescriptor browserDescriptor) {
        String str = TAG + ":getPreferredBrowser";
        for (Browser browser : getBrowsers(browserDescriptor)) {
            if (matches(browserDescriptor, browser)) {
                Logger.info(str, "Preferred Browser's package name: " + browser.getPackageName() + " version: " + browser.getVersion());
                return browser;
            }
        }
        return null;
    }

    private Browser getDefaultBrowser(List<BrowserDescriptor> list) {
        String str = TAG + ":getDefaultBrowser";
        for (Browser browser : getBrowsers(null)) {
            Iterator<BrowserDescriptor> it = list.iterator();
            while (it.hasNext()) {
                if (matches(it.next(), browser)) {
                    Logger.info(str, "Browser's package name: " + browser.getPackageName() + " version: " + browser.getVersion());
                    return browser;
                }
            }
        }
        return null;
    }

    protected List<Browser> getBrowsers(BrowserDescriptor browserDescriptor) {
        String str = TAG + ":getBrowsers";
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        if (browserDescriptor != null) {
            Logger.info(str, "Querying preferred browser: " + browserDescriptor.getPackageName());
            intent.setPackage(browserDescriptor.getPackageName());
        }
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(this.mPackageManager, intent, 65600);
        Logger.verbose(str, "Querying browsers. Got back " + listQueryIntentActivities.size() + " browsers.");
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            if (!isFullBrowser(resolveInfo)) {
                Logger.verbose(str, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " is not a full browser app.");
            } else {
                try {
                    PackageInfo packageInfo = PackageHelper.getPackageInfo(this.mPackageManager, resolveInfo.activityInfo.packageName);
                    boolean zIsCustomTabsServiceSupported = isCustomTabsServiceSupported(packageInfo);
                    Logger.verbose(str, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " supports custom tab: " + zIsCustomTabsServiceSupported);
                    arrayList.add(new Browser(packageInfo.packageName, PackageHelper.generateSignatureHashes(packageInfo), packageInfo.versionName, zIsCustomTabsServiceSupported));
                } catch (PackageManager.NameNotFoundException unused) {
                    Logger.warn(str, LOGGING_MSG_BROWSER + resolveInfo.activityInfo.packageName + " cannot be generated without the package info.");
                }
            }
        }
        Logger.verbose(str, null, "Found " + arrayList.size() + " browsers.");
        return arrayList;
    }

    private boolean isCustomTabsServiceSupported(PackageInfo packageInfo) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(this.mPackageManager, intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    private boolean isFullBrowser(ResolveInfo resolveInfo) {
        if (!resolveInfo.filter.hasAction("android.intent.action.VIEW") || !resolveInfo.filter.hasCategory("android.intent.category.BROWSABLE") || resolveInfo.filter.schemesIterator() == null || resolveInfo.filter.authoritiesIterator() != null) {
            return false;
        }
        Iterator<String> itSchemesIterator = resolveInfo.filter.schemesIterator();
        boolean zEquals = false;
        boolean zEquals2 = false;
        while (itSchemesIterator.hasNext()) {
            String next = itSchemesIterator.next();
            zEquals |= "http".equals(next);
            zEquals2 |= "https".equals(next);
            if (zEquals && zEquals2) {
                return true;
            }
        }
        return false;
    }
}
