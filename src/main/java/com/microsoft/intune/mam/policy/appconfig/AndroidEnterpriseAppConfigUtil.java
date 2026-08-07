package com.microsoft.intune.mam.policy.appconfig;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidEnterpriseAppConfigUtil {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AndroidEnterpriseAppConfigUtil.class);
    private static final Set<String> MAM_ONLY_APP_CONFIG_KEYS = Collections.unmodifiableSet(new HashSet<String>() { // from class: com.microsoft.intune.mam.policy.appconfig.AndroidEnterpriseAppConfigUtil.1
        public static final long serialVersionUID = -1;

        {
            add("com.microsoft.intune.mam.managedbrowser.AppProxyRedirection");
            add("com.microsoft.intune.mam.managedbrowser.AllowListURLs");
            add("com.microsoft.intune.mam.managedbrowser.BlockListURLs");
            add("com.microsoft.intune.mam.managedbrowser.AllowTransitionOnBlock");
            add("com.microsoft.intune.mam.managedbrowser.account.syncDisabled");
            add("com.microsoft.intune.mam.managedbrowser.openInPrivateIfBlocked");
            add("com.microsoft.intune.mam.managedbrowser.durationOfOpenInPrivateSnackBar");
            add("com.microsoft.intune.mam.managedbrowser.NTLMSSOURLs");
            add("com.microsoft.intune.mam.managedbrowser.durationOfNTLMSSO");
            add("com.microsoft.intune.mam.managedbrowser.disableMvpn");
            add("com.microsoft.intune.mam.managedbrowser.proxyPacUrl");
            add("com.microsoft.outlook.ContactSync.AddressAllowed");
            add("com.microsoft.outlook.ContactSync.BirthdayAllowed");
            add("com.microsoft.outlook.ContactSync.CompanyAllowed");
            add("com.microsoft.outlook.ContactSync.DepartmentAllowed");
            add("com.microsoft.outlook.ContactSync.EmailAllowed");
            add("com.microsoft.outlook.ContactSync.InstantMessageAllowed");
            add("com.microsoft.outlook.ContactSync.JobTitleAllowed");
            add("com.microsoft.outlook.ContactSync.NicknameAllowed");
            add("com.microsoft.outlook.ContactSync.NotesAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneHomeAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneHomeFaxAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneMobileAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneOtherAllowed");
            add("com.microsoft.outlook.ContactSync.PhonePagerAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneWorkAllowed");
            add("com.microsoft.outlook.ContactSync.PhoneWorkFaxAllowed");
            add("com.microsoft.outlook.ContactSync.PrefixAllowed");
            add("com.microsoft.outlook.ContactSync.SuffixAllowed");
            add("com.microsoft.intune.useEdge");
            add("com.microsoft.intune.mam.managedbrowser.proxyPacUrl.FailOpenEnabled");
        }
    });
    private static final String MAM_ONLY_KEY_SUBSTRING = "intunemamonly";

    private AndroidEnterpriseAppConfigUtil() {
    }

    public static Bundle removeMAMAppConfigOnlyKeys(Bundle bundle, Context context, Set<String> set) {
        if (bundle == null) {
            return null;
        }
        Bundle bundleRemoveKeys = removeKeys(new Bundle(bundle), MAM_ONLY_APP_CONFIG_KEYS);
        if (bundleRemoveKeys.isEmpty()) {
            return bundleRemoveKeys;
        }
        Bundle bundleRemoveKeys2 = removeKeys(bundleRemoveKeys, set);
        if (bundleRemoveKeys2.isEmpty()) {
            return bundleRemoveKeys2;
        }
        Bundle bundleRemoveKeysNotMatching = removeKeysNotMatching(bundleRemoveKeys2, getXMLKeys(context));
        return bundleRemoveKeysNotMatching.isEmpty() ? bundleRemoveKeysNotMatching : removeKeysMatchingMAMOnly(bundleRemoveKeysNotMatching);
    }

    private static Bundle removeKeys(Bundle bundle, Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            bundle.remove(it.next());
        }
        return bundle;
    }

    private static Bundle removeKeysNotMatching(Bundle bundle, Set<String> set) {
        for (String str : new HashSet(bundle.keySet())) {
            if (!set.contains(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    private static Bundle removeKeysMatchingMAMOnly(Bundle bundle) {
        for (String str : new HashSet(bundle.keySet())) {
            if (str.toLowerCase(Locale.US).contains(MAM_ONLY_KEY_SUBSTRING)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    private static Set<String> getXMLKeys(Context context) {
        String name;
        HashSet hashSet = new HashSet();
        if (context != null) {
            int iTryGetXmlAppRestrictionsResourceId = tryGetXmlAppRestrictionsResourceId(context);
            if (iTryGetXmlAppRestrictionsResourceId == -1) {
                LOGGER.info("could not find app restrictions xml", new Object[0]);
                return hashSet;
            }
            XmlResourceParser xml = context.getResources().getXml(iTryGetXmlAppRestrictionsResourceId);
            while (true) {
                try {
                    int next = xml.next();
                    if (next == 1) {
                        break;
                    }
                    if (next == 2 && (name = xml.getName()) != null && name.equalsIgnoreCase("restriction")) {
                        String attributeValue = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "key");
                        LOGGER.info("found afw config key " + attributeValue, new Object[0]);
                        hashSet.add(attributeValue);
                    }
                } catch (IOException | XmlPullParserException unused) {
                }
            }
        }
        return hashSet;
    }

    private static int tryGetXmlAppRestrictionsResourceId(Context context) {
        try {
            ApplicationInfo applicationInfo = PackageManagerCompat.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128L);
            if (applicationInfo.metaData == null) {
                return -1;
            }
            return applicationInfo.metaData.getInt("android.content.APP_RESTRICTIONS", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }
}
