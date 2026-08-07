package com.google.firebase.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.microsoft.intune.mam.client.content.MAMContentProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes14.dex */
public class FirebaseInitProvider extends MAMContentProvider {
    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseinitprovider";
    private static final String TAG = "FirebaseInitProvider";
    private static StartupTime startupTime = StartupTime.now();
    private static AtomicBoolean currentlyInitializing = new AtomicBoolean(false);

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static StartupTime getStartupTime() {
        return startupTime;
    }

    public static boolean isCurrentlyInitializing() {
        return currentlyInitializing.get();
    }

    @Override // com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public void attachInfoMAM(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfoMAM(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            currentlyInitializing.set(true);
            if (FirebaseApp.initializeApp(getContext()) == null) {
                Log.i(TAG, "FirebaseApp initialization unsuccessful");
            } else {
                Log.i(TAG, "FirebaseApp initialization successful");
            }
            return false;
        } finally {
            currentlyInitializing.set(false);
        }
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if (EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY.equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }
}
