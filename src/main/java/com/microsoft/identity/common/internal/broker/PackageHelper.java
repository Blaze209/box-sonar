package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.media3.common.C;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class PackageHelper {
    private static final String DIGEST_SHA_512 = "SHA-512";
    private static final String TAG = "CallerInfo";
    private final PackageManager mPackageManager;

    public static int getPackageManagerSignaturesFlag() {
        return C.BUFFER_FLAG_FIRST_SAMPLE;
    }

    public PackageHelper(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    public PackageHelper(Context context) {
        this.mPackageManager = context.getPackageManager();
    }

    public String getSha1SignatureForPackage(String str) {
        try {
            return getSigningCertificateThumbprintForPackage(getPackageInfo(this.mPackageManager, str), false);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getSha1SignatureForPackage", "Calling App's package does not exist in PackageManager. ", "", e);
            return null;
        }
    }

    public String getSha512SignatureForPackage(String str) {
        try {
            return getSigningCertificateThumbprintForPackage(getPackageInfo(this.mPackageManager, str), true);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getSha512SignatureForPackage", "Calling App's package does not exist in PackageManager. ", "", e);
            return null;
        }
    }

    private static String getSigningCertificateThumbprintForPackage(PackageInfo packageInfo, boolean z) {
        try {
            Signature[] signatures = getSignatures(packageInfo);
            if (signatures == null || signatures.length <= 0) {
                return null;
            }
            Signature signature = signatures[0];
            MessageDigest messageDigest = MessageDigest.getInstance(z ? "SHA-512" : "SHA");
            messageDigest.update(signature.toByteArray());
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (NoSuchAlgorithmException e) {
            Logger.error("CallerInfo:getSigningCertificateThumbprintForPackage", "Digest SHA algorithm does not exists. ", "", e);
            return null;
        }
    }

    public int getUIDForPackage(String str) {
        try {
            ApplicationInfo applicationInfo = MAMPackageManagement.getApplicationInfo(this.mPackageManager, str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error("CallerInfo:getUIDForPackage", "Package is not found. ", "Package name: " + str, e);
            return 0;
        }
    }

    public boolean isPackageInstalledAndEnabled(String str) {
        boolean z = false;
        try {
            ApplicationInfo applicationInfo = MAMPackageManagement.getApplicationInfo(this.mPackageManager, str, 0);
            if (applicationInfo != null) {
                z = applicationInfo.enabled;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.verbose("CallerInfo:isPackageInstalledAndEnabled", str + " is not found");
        }
        Logger.verbose("CallerInfo:isPackageInstalledAndEnabled", str + " is installed. enabled? [" + z + "]");
        return z;
    }

    public static String getBrokerRedirectUri(Context context, String str) {
        return getBrokerRedirectUrl(str, new PackageHelper(context.getPackageManager()).getSha1SignatureForPackage(str));
    }

    public static String getBrokerRedirectUrl(String str, String str2) {
        if (!StringExtensions.isNullOrBlank(str) && !StringExtensions.isNullOrBlank(str2)) {
            try {
                return String.format("%s://%s/%s", "msauth", URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                Logger.error("CallerInfo:getBrokerRedirectUrl", "", "Encoding is not supported", e);
            }
        }
        return "";
    }

    public static Signature[] getSignatures(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.signingInfo == null) {
            return null;
        }
        if (packageInfo.signingInfo.hasMultipleSigners()) {
            return packageInfo.signingInfo.getApkContentsSigners();
        }
        return packageInfo.signingInfo.getSigningCertificateHistory();
    }

    public static Set<String> generateSignatureHashes(PackageInfo packageInfo) {
        HashSet hashSet = new HashSet();
        for (Signature signature : getSignatures(packageInfo)) {
            try {
                hashSet.add(Base64.encodeToString(MessageDigest.getInstance("SHA-512").digest(signature.toByteArray()), 10));
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("Platform does not supportSHA-512 hashing");
            }
        }
        return hashSet;
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        return MAMPackageManagement.getPackageInfo(packageManager, str, getPackageManagerSignaturesFlag());
    }

    public static Signature[] getSignatures(Context context) throws PackageManager.NameNotFoundException {
        return getSignatures(getPackageInfo(context.getPackageManager(), context.getPackageName()));
    }

    public boolean verifyIfValidTeamsPackage(String str) {
        if (!str.equals(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME) || !isPackageInstalledAndEnabled(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME)) {
            return false;
        }
        String sha512SignatureForPackage = getSha512SignatureForPackage(AuthenticationConstants.Broker.IPPHONE_APP_PACKAGE_NAME);
        return AuthenticationConstants.Broker.IPPHONE_APP_SHA512_RELEASE_SIGNATURE.equals(sha512SignatureForPackage) || AuthenticationConstants.Broker.IPPHONE_APP_SHA512_DEBUG_SIGNATURE.equals(sha512SignatureForPackage);
    }
}
