package com.box.android.utilities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.box.android.R;
import com.box.android.activities.OpenFile;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileSizeUtils;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.dao.FileInfo;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.logging.FileTree;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxUtils {
    private static final String EMAIL = "email";

    private BoxUtils() {
    }

    public static void wipeTempCacheFiles(Context context) {
        try {
            if (context.getCacheDir() != null) {
                FileUtils.cleanDirectory(context.getCacheDir());
            }
        } catch (IOException unused) {
        }
    }

    public static void startPreviewIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) OpenFile.class);
        intent.putExtra("fileId", str);
        intent.putExtra(BoxCommonConstants.EXTRA_FILE_NAME, str2);
        context.startActivity(intent);
    }

    public static void reviewApplicationAction(Activity activity) {
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BoxBaseApplication.getInstance().getConfigManager().getString(BoxConfigConstants.CONFIG_KEY_MARKET_URL))));
        } catch (Exception unused) {
        }
    }

    public static void logcatBundle(Bundle bundle, Context context) {
        if ((context.getApplicationContext() instanceof BoxBaseApplication) && BuildConfigProvider.INSTANCE.isDebugBuild()) {
            for (String str : bundle.keySet()) {
                Log.i("BOX bundle", "extra: " + str + " => " + String.valueOf(bundle.get(str)) + " type " + bundle.get(str).getClass().getName());
            }
        }
    }

    public static void temporarilyDisableClass(final String str) {
        if (str.equals("com.microsoft.intune.mam.client.app.resolver.MAMResolverActivity")) {
            return;
        }
        MAMPackageManagement.setComponentEnabledSetting(BoxBaseApplication.getInstance().getPackageManager(), new ComponentName(BoxBaseApplication.getInstance(), str), 2, 1);
        new Thread() { // from class: com.box.android.utilities.BoxUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    BoxLogUtils.logException(e);
                    Thread.currentThread().interrupt();
                }
                MAMPackageManagement.setComponentEnabledSetting(BoxBaseApplication.getInstance().getPackageManager(), new ComponentName(BoxBaseApplication.getInstance(), str), 1, 1);
            }
        }.start();
    }

    public static void sendEmailForSupport(String str, String str2, boolean z, Context context) {
        String strValueOf;
        String str3;
        StringBuffer stringBuffer = new StringBuffer("\n");
        stringBuffer.append(CommonBoxUtil.LS(R.string.Please_describe_your_issue_here));
        stringBuffer.append("\n");
        stringBuffer.append(str2);
        stringBuffer.append("\n\n\n----------\n");
        try {
            str3 = MAMPackageManagement.getPackageInfo(BoxBaseApplication.getInstance().getPackageManager(), BoxBaseApplication.getInstance().getPackageName(), 0).versionName;
            strValueOf = String.valueOf(str3);
        } catch (PackageManager.NameNotFoundException unused) {
            strValueOf = "";
            str3 = "unknown version";
        }
        sendEmail(getEmailIntent(new String[]{BoxCommonConstants.ANDROID_SUPPORT_EMAIL}, ((Object) BoxBaseApplication.getInstance().getText(R.string.Box_for_Android)) + " " + str3 + " " + ((Object) BoxBaseApplication.getInstance().getText(R.string.Support)), stringBuffer.toString(), (CommonBoxUtil.LS(R.string.Diagnostic_information) + "\nDevice: " + BoxApi.getDeviceTypeIdentifier() + "\nSDK:  " + Build.VERSION.SDK_INT + "\nBugId: " + str + "\nSDK_VERSIONS: ") + "\nBuild: " + strValueOf + " " + CommonBoxUtil.LS(R.string.git_commit_tag), z ? getLogFileUris() : null));
    }

    private static ArrayList<Uri> getLogFileUris() {
        ArrayList<Uri> arrayList = new ArrayList<>();
        BoxBaseApplication boxBaseApplication = BoxBaseApplication.getInstance();
        File file = new File(boxBaseApplication.getFilesDir(), FileTree.LOGS_DIR);
        String string = boxBaseApplication.getResources().getString(R.string.fileProviderAuthority);
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    arrayList.add(FileProvider.getUriForFile(boxBaseApplication, string, file2));
                }
            }
            return arrayList;
        } catch (SecurityException e) {
            BoxLogUtils.logException(e);
            return arrayList;
        }
    }

    private static void sendEmail(Intent intent) {
        Intent intentCreateChooser = Intent.createChooser(intent, CommonBoxUtil.LS(R.string.Send_with));
        intentCreateChooser.setFlags(intentCreateChooser.getFlags() | 268435456);
        BoxBaseApplication.getInstance().startActivity(intentCreateChooser);
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, BoxAnalyticsParams.ACTION_EMAIL_SUPPORT, "success");
    }

    static Intent getEmailIntent(String[] strArr, String str, String str2, String str3, ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setFlags(intent.getFlags() | 268435456);
        intent.setType(BoxCommonConstants.EMAIL_MIME_TYPE);
        intent.putExtra("android.intent.extra.EMAIL", strArr);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2 + str3);
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(1);
        }
        return intent;
    }

    public static boolean launchSafeExternalLink(Context context, String str) {
        return launchSafeExternalLink(context, Uri.parse(str));
    }

    public static boolean launchSafeExternalLink(Context context, Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.getHost() != null && ((uri.getHost().contains(BoxPushNotificationV1.URL_AUTHORITY) || uri.getHost().contains("box.net")) && uri.getQueryParameter("redirecttoapp") == null)) {
            uri = uri.buildUpon().appendQueryParameter("redirecttoapp", "false").build();
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        return launchSafeExternalIntent(context, intent);
    }

    public static boolean launchSafeExternalIntent(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, intent, 65536);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() >= 1) {
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                if (resolveInfo != null && resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName != null && resolveInfo.activityInfo.packageName.equals(BoxBaseApplication.getInstance().getPackageName())) {
                    temporarilyDisableClass(resolveInfo.activityInfo.name);
                }
            }
            List<ResolveInfo> listQueryIntentActivities2 = MAMPackageManagement.queryIntentActivities(packageManager, intent, 65536);
            if (listQueryIntentActivities2 != null && listQueryIntentActivities2.size() >= 1) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Error unused) {
                }
            }
        }
        return false;
    }

    public static class SerializableHolder implements Serializable {
        private static final long serialVersionUID = -1893173314201681757L;
        private final Serializable mContent;

        public SerializableHolder(Serializable serializable) {
            this.mContent = serializable;
        }

        public Serializable get() {
            return this.mContent;
        }
    }

    public static boolean isUriSourceEmail(Uri uri) {
        if (uri == null) {
            return false;
        }
        String utmMedium = CommonBoxUtil.getUtmMedium(uri);
        return (utmMedium != null && utmMedium.equals("email")) || uri.getPathSegments().contains("email");
    }

    public static File getDirectory(String str) {
        if (str.equals("")) {
            return CommonBoxUtil.getDefaultLocalDirectory();
        }
        return new File(str);
    }

    public static List<FileInfo> getFiles(Context context, File file) {
        if (file == null || !file.isDirectory()) {
            return new ArrayList();
        }
        File[] fileArrListFiles = file.listFiles();
        sortFilesAlphabetically(fileArrListFiles);
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            for (File file2 : fileArrListFiles) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setIsFolder(file2.isDirectory());
                try {
                    String fileSize = FileSizeUtils.getFileSize(Long.valueOf(file2.length()));
                    if (file2.isDirectory()) {
                        fileSize = "";
                    }
                    fileInfo.setSize(fileSize);
                    fileInfo.setFilename(file2.getName());
                    fileInfo.setLastUpdated(BoxDateUtils.formatFileItemTime(file2.lastModified(), context));
                    fileInfo.setAbsolutePath(file2.getAbsolutePath());
                    arrayList.add(fileInfo);
                } catch (Exception e) {
                    BoxLogUtils.logException(context.getClass().getName(), e);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static void sortFilesAlphabetically(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 1) {
            return;
        }
        C1FileWrapper[] c1FileWrapperArr = new C1FileWrapper[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            c1FileWrapperArr[i] = new C1FileWrapper(fileArr[i]);
        }
        Arrays.sort(c1FileWrapperArr, new Comparator<C1FileWrapper>() { // from class: com.box.android.utilities.BoxUtils.2
            @Override // java.util.Comparator
            public int compare(C1FileWrapper c1FileWrapper, C1FileWrapper c1FileWrapper2) {
                if (c1FileWrapper.isDirectory && !c1FileWrapper2.isDirectory) {
                    return -1;
                }
                if (c1FileWrapper.isDirectory || !c1FileWrapper2.isDirectory) {
                    return c1FileWrapper.name.compareToIgnoreCase(c1FileWrapper2.name);
                }
                return 1;
            }
        });
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            fileArr[i2] = c1FileWrapperArr[i2].file;
        }
    }

    /* JADX INFO: renamed from: com.box.android.utilities.BoxUtils$1FileWrapper, reason: invalid class name */
    class C1FileWrapper {
        final File file;
        final boolean isDirectory;
        final String name;

        C1FileWrapper(File file) {
            this.file = file;
            this.isDirectory = file.isDirectory();
            this.name = file.getName();
        }
    }
}
