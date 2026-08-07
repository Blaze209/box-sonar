package sdk.pendo.io.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    private static final ConcurrentMap<String, f> a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return MAMPackageManagement.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    public static f b(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, f> concurrentMap = a;
        f fVar = concurrentMap.get(packageName);
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context);
        f fVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, fVarC);
        return fVarPutIfAbsent == null ? fVarC : fVarPutIfAbsent;
    }

    private static f c(Context context) {
        return new ObjectKey(a(a(context)));
    }

    private static String a(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }
}
