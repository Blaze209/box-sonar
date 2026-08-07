package androidx.startup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMContentProvider;

/* JADX INFO: loaded from: classes9.dex */
public class InitializationProvider extends MAMContentProvider {
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                AppInitializer.getInstance(context).discoverAndInitialize();
                return true;
            }
            StartupLogger.w("Deferring initialization because `applicationContext` is null.");
            return true;
        }
        throw new StartupException("Context cannot be null");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final Uri insertMAM(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int deleteMAM(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public final int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
