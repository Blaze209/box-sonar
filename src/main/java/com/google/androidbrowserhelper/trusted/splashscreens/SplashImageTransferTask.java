package com.google.androidbrowserhelper.trusted.splashscreens;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.TrustedWebUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes13.dex */
public class SplashImageTransferTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String FILE_NAME = "splash_image.png";
    private static final String FOLDER_NAME = "twa_splash";
    private static final String PREFS_FILE = "splashImagePrefs";
    private static final String PREF_LAST_UPDATE_TIME = "lastUpdateTime";
    private static final String TAG = "SplashImageTransferTask";
    private final AsyncTask<Void, Void, Boolean> mAsyncTask = new AsyncTask<Void, Void, Boolean>() { // from class: com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) {
            if (isCancelled()) {
                return false;
            }
            File file = new File(SplashImageTransferTask.this.mContext.getFilesDir(), SplashImageTransferTask.FOLDER_NAME);
            if (!file.exists() && !file.mkdir()) {
                Log.w(SplashImageTransferTask.TAG, "Failed to create a directory for storing a splash image");
                return false;
            }
            File file2 = new File(file, SplashImageTransferTask.FILE_NAME);
            SharedPreferences sharedPreferences = SplashImageTransferTask.this.mContext.getSharedPreferences(SplashImageTransferTask.PREFS_FILE, 0);
            long lastAppUpdateTime = getLastAppUpdateTime();
            if (file2.exists() && lastAppUpdateTime == sharedPreferences.getLong(SplashImageTransferTask.PREF_LAST_UPDATE_TIME, 0L)) {
                return Boolean.valueOf(transferToCustomTabsProvider(file2));
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    if (!isCancelled()) {
                        SplashImageTransferTask.this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        sharedPreferences.edit().putLong(SplashImageTransferTask.PREF_LAST_UPDATE_TIME, lastAppUpdateTime).commit();
                        if (!isCancelled()) {
                            Boolean boolValueOf = Boolean.valueOf(transferToCustomTabsProvider(file2));
                            fileOutputStream.close();
                            return boolValueOf;
                        }
                    }
                    fileOutputStream.close();
                    return false;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private boolean transferToCustomTabsProvider(File file) {
            return TrustedWebUtils.transferSplashImage(SplashImageTransferTask.this.mContext, file, SplashImageTransferTask.this.mAuthority, SplashImageTransferTask.this.mProviderPackage, SplashImageTransferTask.this.mSession);
        }

        private long getLastAppUpdateTime() {
            try {
                return MAMPackageManagement.getPackageInfo(SplashImageTransferTask.this.mContext.getPackageManager(), SplashImageTransferTask.this.mContext.getPackageName(), 0).lastUpdateTime;
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (SplashImageTransferTask.this.mCallback == null || isCancelled()) {
                return;
            }
            SplashImageTransferTask.this.mCallback.onFinished(bool.booleanValue());
        }
    };
    private final String mAuthority;
    private final Bitmap mBitmap;
    private Callback mCallback;
    private final Context mContext;
    private final String mProviderPackage;
    private final CustomTabsSession mSession;

    public interface Callback {
        void onFinished(boolean z);
    }

    public SplashImageTransferTask(Context context, Bitmap bitmap, String str, CustomTabsSession customTabsSession, String str2) {
        this.mContext = context.getApplicationContext();
        this.mBitmap = bitmap;
        this.mAuthority = str;
        this.mSession = customTabsSession;
        this.mProviderPackage = str2;
    }

    public void execute(Callback callback) {
        this.mCallback = callback;
        this.mAsyncTask.execute(new Void[0]);
    }

    public void cancel() {
        this.mAsyncTask.cancel(true);
        this.mCallback = null;
    }
}
