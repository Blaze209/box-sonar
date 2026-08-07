package com.pspdfkit.initialization;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMContentProvider;

/* JADX INFO: loaded from: classes3.dex */
public class InitializationProvider extends MAMContentProvider {
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

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r2) != false) goto L39;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onCreate() {
        /*
            r6 = this;
            android.content.Context r6 = r6.getContext()
            r0 = 1
            if (r6 == 0) goto L95
            java.util.List<java.lang.String> r1 = com.pspdfkit.internal.j00.a     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = "nutrient_automatic_initialize"
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L67
            r2.getClass()     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = r6.getPackageName()     // Catch: java.lang.Throwable -> L67
            r3.getClass()     // Catch: java.lang.Throwable -> L67
            android.os.Bundle r2 = com.pspdfkit.utils.PackageManagerExtensions.getMetaData(r2, r3)     // Catch: java.lang.Throwable -> L67
            r3 = 0
            if (r2 != 0) goto L21
            goto L27
        L21:
            boolean r4 = r2.containsKey(r1)     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L29
        L27:
            r1 = r3
            goto L31
        L29:
            boolean r1 = r2.getBoolean(r1)     // Catch: java.lang.Throwable -> L67
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L67
        L31:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L67
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L3a
            goto L95
        L3a:
            java.lang.String r1 = "pspdfkit_automatic_initialize"
            android.content.pm.PackageManager r4 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L67
            r4.getClass()     // Catch: java.lang.Throwable -> L67
            java.lang.String r5 = r6.getPackageName()     // Catch: java.lang.Throwable -> L67
            r5.getClass()     // Catch: java.lang.Throwable -> L67
            android.os.Bundle r4 = com.pspdfkit.utils.PackageManagerExtensions.getMetaData(r4, r5)     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L51
            goto L60
        L51:
            boolean r5 = r4.containsKey(r1)     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L58
            goto L60
        L58:
            boolean r1 = r4.getBoolean(r1)     // Catch: java.lang.Throwable -> L67
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L67
        L60:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L67
            goto L95
        L67:
            io.reactivex.rxjava3.core.Completable r1 = com.pspdfkit.internal.j00.a(r6)
            java.lang.Class<com.pspdfkit.internal.ar> r2 = com.pspdfkit.internal.ar.class
            monitor-enter(r2)
            com.pspdfkit.internal.q10.c()     // Catch: java.lang.Throwable -> L92
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L92
            io.reactivex.rxjava3.core.Scheduler r2 = io.reactivex.rxjava3.schedulers.Schedulers.io()
            r2.getClass()
            io.reactivex.rxjava3.core.Completable r1 = r1.subscribeOn(r2)
            java.lang.String r6 = com.pspdfkit.internal.j00.c(r6)
            if (r6 == 0) goto L8e
            int r6 = r6.length()
            if (r6 != 0) goto L8a
            goto L8e
        L8a:
            r1.blockingAwait()
            goto L91
        L8e:
            r1.subscribe()
        L91:
            return r0
        L92:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        L95:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.initialization.InitializationProvider.onCreate():boolean");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
