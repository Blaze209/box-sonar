package com.pspdfkit.internal;

import android.content.Context;
import android.os.Build;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: com.pspdfkit.internal.a$a, reason: collision with other inner class name */
    public static class C0250a {
        public static ArrayList a(Context context) {
            if (Objects.equals(Build.DEVICE, "robolectric")) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                ZipFile zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String name = enumerationEntries.nextElement().getName();
                        if (name.startsWith("lib")) {
                            arrayList.add(name);
                        }
                    }
                    zipFile.close();
                    return arrayList;
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                PdfLog.d("Nutri.AbiVerifier", e, "Failed to enumerate files in APK.", new Object[0]);
                return arrayList;
            }
        }
    }

    public static Single<Boolean> a(final Context context) {
        g60 g60VarC;
        if (!uc.c(context)) {
            return Single.just(Boolean.TRUE);
        }
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.a$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.b(context);
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        return singleFromCallable.subscribeOn(((m0) g60VarC).a());
    }

    public static /* synthetic */ Boolean b(Context context) throws Exception {
        ArrayList arrayListA = C0250a.a(context);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int size = arrayListA.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            String str = (String) obj;
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf >= 0) {
                String strSubstring = str.substring(4, iLastIndexOf);
                hashSet.add(strSubstring);
                if (str.endsWith("libpspdfkit.so")) {
                    hashSet2.add(strSubstring);
                }
            }
        }
        if (hashSet2.containsAll(hashSet)) {
            return Boolean.TRUE;
        }
        hashSet.removeAll(hashSet2);
        PdfLog.e("Nutri.AbiVerifier", "*********************************************************************************", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!   NDK Libraries containing architectures not supported by Nutrient found!", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!   Nutrient doesn't support " + hashSet, new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!   Make sure you only keep " + hashSet2 + " in your APK!", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!   See https://www.nutrient.io/guides/android/troubleshooting/abi-set-not-compatible/ for instructions on how to set up abiFilters.", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "!!", new Object[0]);
        PdfLog.e("Nutri.AbiVerifier", "*********************************************************************************", new Object[0]);
        return Boolean.FALSE;
    }
}
