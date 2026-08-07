package com.pspdfkit.internal;

import android.content.Context;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.pspdfkit.instant.internal.jni.NativeHTTPClient;
import com.pspdfkit.instant.internal.jni.NativeHTTPDownloadEventHandler;
import com.pspdfkit.instant.internal.jni.NativeHTTPRequest;
import com.pspdfkit.instant.internal.jni.NativeHTTPUploadEventHandler;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public final class sj extends NativeHTTPClient {
    public final File a;
    public final OkHttpClient b;
    public final HashMap c = new HashMap();

    public sj(File file) {
        this.a = file;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.b = builder.connectTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).readTimeout(20L, TimeUnit.MINUTES).build();
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest DELETEWithData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
        return new wj(this, 4, str, bArr, null, a(map), null, nativeHTTPUploadEventHandler);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest GET(String str, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
        return new wj(this, 1, str, null, null, a(map), nativeHTTPDownloadEventHandler, null);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest POSTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
        return new wj(this, 2, str, bArr, null, a(map), nativeHTTPDownloadEventHandler, nativeHTTPUploadEventHandler);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest POSTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, NativeHTTPDownloadEventHandler nativeHTTPDownloadEventHandler, HashMap<String, String> map) {
        return new wj(this, 2, str2, null, str, a(map), nativeHTTPDownloadEventHandler, nativeHTTPUploadEventHandler);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest PUTData(byte[] bArr, String str, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
        return new wj(this, 3, str, bArr, null, a(map), null, nativeHTTPUploadEventHandler);
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeHTTPClient
    public final NativeHTTPRequest PUTFile(String str, String str2, NativeHTTPUploadEventHandler nativeHTTPUploadEventHandler, HashMap<String, String> map) {
        return new wj(this, 3, str2, null, str, a(map), null, nativeHTTPUploadEventHandler);
    }

    public final HashMap<String, String> a(HashMap<String, String> map) {
        HashMap<String, String> map2 = new HashMap<>();
        map2.putAll(map);
        map2.putAll(this.c);
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        Locale localeA = no.a(context);
        String language = localeA.getLanguage();
        String country = localeA.getCountry();
        if (!country.matches("\\p{Alpha}{2}")) {
            country = "";
        }
        StringBuilder sb = new StringBuilder(language);
        if (!country.isEmpty()) {
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR).append(country);
        }
        map2.put("Accept-Language", sb.toString());
        return map2;
    }
}
