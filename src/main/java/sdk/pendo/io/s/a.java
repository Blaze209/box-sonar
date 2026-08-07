package sdk.pendo.io.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import external.sdk.pendo.io.glide.module.GlideModule;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class a {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    private ApplicationInfo a() {
        return MAMPackageManagement.getApplicationInfo(this.a.getPackageManager(), this.a.getPackageName(), 128);
    }

    public List<GlideModule> b() {
        String str;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfoA = a();
            if (applicationInfoA != null && applicationInfoA.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfoA.metaData);
                }
                for (String str2 : applicationInfoA.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfoA.metaData.get(str2))) {
                        arrayList.add(a(str2));
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Loaded Glide module: " + str2);
                        }
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    str = "Finished loading Glide modules";
                    Log.d("ManifestParser", str);
                    return arrayList;
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                str = "Got null app info metadata";
                Log.d("ManifestParser", str);
                return arrayList;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e);
            }
        }
        return arrayList;
    }

    private static GlideModule a(String str) {
        Object objNewInstance;
        try {
            Class<?> cls = Class.forName(str);
            try {
                objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                a(cls, e);
                objNewInstance = null;
            }
            if (objNewInstance instanceof GlideModule) {
                return (GlideModule) objNewInstance;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e2);
        }
    }

    private static void a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
