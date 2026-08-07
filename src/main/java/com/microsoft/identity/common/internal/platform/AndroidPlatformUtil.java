package com.microsoft.identity.common.internal.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.UserManager;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.net.DefaultConnectionService;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.IntuneMAMEnrollmentIdGateway;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.ui.webview.WebViewUtil;
import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.commands.InteractiveTokenCommand;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidPlatformUtil implements IPlatformUtil {
    private static final String TAG = "AndroidPlatformUtil";
    private final Activity mActivity;
    private final Context mContext;

    private boolean isValidHubRedirectURIForNAATests(String str) {
        return false;
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public List<Map.Entry<String, String>> updateWithAndGetPlatformSpecificExtraQueryParameters(List<Map.Entry<String, String>> list) {
        return list;
    }

    public AndroidPlatformUtil(Context context, Activity activity) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public String getInstalledCompanyPortalVersion() {
        try {
            return MAMPackageManagement.getPackageInfo(this.mContext.getPackageManager(), "com.microsoft.windowsintune.companyportal", 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void throwIfNetworkNotAvailable(boolean z) throws ClientException {
        DefaultConnectionService defaultConnectionService = new DefaultConnectionService(this.mContext);
        if (z && defaultConnectionService.isNetworkDisabledFromOptimizations()) {
            throw new ClientException(ErrorStrings.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION, "Connection is not available to refresh token because power optimization is enabled. And the device is in doze mode or the app is standby");
        }
        if (!CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.DISABLE_NETWORK_CONNECTIVITY_CHECK) && !defaultConnectionService.isConnectionAvailable()) {
            throw new ClientException("device_network_not_available", "Connection is not available to refresh token");
        }
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void removeCookiesFromWebView() {
        WebViewUtil.removeCookiesFromWebView(this.mContext);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public boolean isValidCallingApp(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        String str3 = TAG + ":isValidCallingApp";
        if (isValidHubRedirectURIForNAATests(str)) {
            Logger.warn(str3, "Bypassing RedirectUri Check. This should not be enabled in PROD. " + str);
            return true;
        }
        String brokerRedirectUri = PackageHelper.getBrokerRedirectUri(this.mContext, str2);
        boolean zEqualsIgnoreCase = StringUtil.equalsIgnoreCase(str, brokerRedirectUri);
        if (str2.equals(AuthenticationConstants.Broker.AZURE_AUTHENTICATOR_APP_PACKAGE_NAME)) {
            String sha512SignatureForPackage = new PackageHelper(this.mContext.getPackageManager()).getSha512SignatureForPackage(str2);
            if (BrokerData.getProdMicrosoftAuthenticator().getSigningCertificateThumbprint().equals(sha512SignatureForPackage) || BrokerData.getDebugMicrosoftAuthenticator().getSigningCertificateThumbprint().equals(sha512SignatureForPackage)) {
                zEqualsIgnoreCase |= StringUtil.equalsIgnoreCase(str, "urn:ietf:wg:oauth:2.0:oob");
            }
        }
        if (!zEqualsIgnoreCase) {
            com.microsoft.identity.common.logging.Logger.error(str3, "Broker redirect uri is invalid. Expected: " + brokerRedirectUri + " Actual: " + str, null);
        }
        return zEqualsIgnoreCase;
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public String getEnrollmentId(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("userId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("packageName is marked non-null but is null");
        }
        return IntuneMAMEnrollmentIdGateway.getInstance().getEnrollmentId(this.mContext, str, str2);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void onReturnCommandResult(ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        optionallyReorderTasks(iCommand);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public long getNanosecondTime() {
        return SystemClock.elapsedRealtimeNanos();
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public void postCommandResult(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable is marked non-null but is null");
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public KeyManagerFactory getSslContextKeyManagerFactory() throws NoSuchAlgorithmException {
        return KeyManagerFactory.getInstance("X509");
    }

    @Override // com.microsoft.identity.common.java.util.IPlatformUtil
    public String getPackageNameFromUid(int i) {
        return MAMPackageManagement.getNameForUid(this.mContext.getPackageManager(), i);
    }

    public static ArrayList<Map.Entry<String, String>> updateWithOrDeleteWebAuthnParam(List<Map.Entry<String, String>> list, boolean z) {
        if (list == null) {
            throw new NullPointerException("originalList is marked non-null but is null");
        }
        String str = TAG + ":UpdateWithOrDeleteWebAuthnParam";
        AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(FidoConstants.WEBAUTHN_QUERY_PARAMETER_FIELD, "1");
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(list);
        if (z && !list.contains(simpleEntry)) {
            arrayList.add(simpleEntry);
        }
        return arrayList;
    }

    public static boolean isInManagedProfile(Context context) {
        if (context == null) {
            throw new NullPointerException("appContext is marked non-null but is null");
        }
        return ((UserManager) context.getSystemService("user")).isManagedProfile();
    }

    private void optionallyReorderTasks(ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        String str = TAG + ":optionallyReorderTasks";
        if (iCommand instanceof InteractiveTokenCommand) {
            if (this.mActivity == null) {
                throw new IllegalStateException("Activity cannot be null in an interactive session.");
            }
            if (!((InteractiveTokenCommandParameters) ((InteractiveTokenCommand) iCommand).getParameters()).getHandleNullTaskAffinity() || hasTaskAffinity(this.mActivity)) {
                return;
            }
            ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            if (activityManager != null) {
                activityManager.moveTaskToFront(this.mActivity.getTaskId(), 0);
            } else {
                Logger.warn(str, "ActivityManager was null; Unable to bring task for the foreground.");
            }
        }
    }

    private static boolean hasTaskAffinity(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        String str = TAG + ":hasTaskAffinity";
        PackageManager packageManager = activity.getPackageManager();
        try {
            ComponentName componentName = activity.getComponentName();
            ActivityInfo activityInfo = componentName != null ? MAMPackageManagement.getActivityInfo(packageManager, componentName, 0) : null;
            return (activityInfo == null || activityInfo.taskAffinity == null) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(str, "Unable to get ActivityInfo for activity provided to start authorization.");
            return true;
        }
    }
}
