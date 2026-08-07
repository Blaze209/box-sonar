package com.pspdfkit.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import com.pspdfkit.utils.PackageManagerExtensions;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j00 {
    public static final List<String> a = CollectionsKt.listOf((Object[]) new String[]{"ttf", "otf"});

    @JvmStatic
    public static final Completable a(final Context context) {
        context.getClass();
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.j00$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws IOException {
                j00.b(context);
            }
        });
        completableFromAction.getClass();
        return completableFromAction;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080  */
    /* JADX WARN: Code duplicated, block: B:31:0x0095  */
    /* JADX WARN: Code duplicated, block: B:33:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0133  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ab, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r5) == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(android.content.Context r18) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.j00.b(android.content.Context):void");
    }

    @JvmStatic
    public static final String c(Context context) {
        String string;
        context.getClass();
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String packageName = context.getPackageName();
            packageName.getClass();
            Bundle metaData = PackageManagerExtensions.getMetaData(packageManager, packageName);
            if (metaData != null && (string = metaData.getString("nutrient_font_path")) != null) {
                return string;
            }
            PackageManager packageManager2 = context.getPackageManager();
            packageManager2.getClass();
            String packageName2 = context.getPackageName();
            packageName2.getClass();
            Bundle metaData2 = PackageManagerExtensions.getMetaData(packageManager2, packageName2);
            if (metaData2 != null) {
                return metaData2.getString("pspdfkit_font_path");
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(Context context, String str) throws IOException {
        File dir = context.getDir("__pspdfkit_assets_fonts", 0);
        ArrayList arrayList = new ArrayList();
        try {
            AssetManager assets = context.getAssets();
            assets.getClass();
            a(assets, str, arrayList);
        } catch (IOException e) {
            PdfLog.e("Nutri.InitializationUtils", e, "Error checking the files in the assets folder.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (a.contains(FilesKt.getExtension(new File((String) obj)))) {
                arrayList2.add(obj);
            }
        }
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            int i3 = i2 + 1;
            String str2 = (String) arrayList2.get(i2);
            List listSplit$default = StringsKt.split$default((CharSequence) str2, new char[]{'/'}, false, 0, 6, (Object) null);
            dir.getClass();
            File fileResolve = FilesKt.resolve(dir, (String) CollectionsKt.last(listSplit$default));
            if (!fileResolve.exists() || fileResolve.length() == 0) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileResolve);
                    try {
                        InputStream inputStreamOpen = context.getResources().getAssets().open(str2);
                        try {
                            inputStreamOpen.getClass();
                            ByteStreamsKt.copyTo$default(inputStreamOpen, fileOutputStream, 0, 2, null);
                            CloseableKt.closeFinally(inputStreamOpen, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(inputStreamOpen, th);
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(fileOutputStream, th3);
                            throw th4;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    PdfLog.e("Nutri.InitializationUtils", e2, "Error copying custom font from assets '" + str2 + "' to app storage '" + fileResolve + "'.", new Object[0]);
                }
            }
            i2 = i3;
        }
        String absolutePath = dir.getAbsolutePath();
        String[] list = dir.list();
        if (list == null || list.length == 0) {
            return null;
        }
        return absolutePath;
    }

    public static void a(AssetManager assetManager, String str, ArrayList arrayList) throws IOException {
        boolean z;
        String[] list = assetManager.list(str);
        if (list == null) {
            return;
        }
        for (String str2 : list) {
            if (str.length() != 0) {
                str2 = str + "/" + str2;
            }
            str2.getClass();
            try {
                String[] list2 = assetManager.list(str2);
                z = !(list2 == null || list2.length == 0);
            } catch (IOException unused) {
                z = false;
            }
            if (z) {
                a(assetManager, str2, arrayList);
            } else {
                arrayList.add(str2);
            }
        }
    }
}
