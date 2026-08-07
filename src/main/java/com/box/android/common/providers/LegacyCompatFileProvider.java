package com.box.android.common.providers;

import android.database.Cursor;
import android.net.Uri;
import android.util.LruCache;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class LegacyCompatFileProvider extends FileProvider {
    private static LruCache<String, String> mUriMapping = new LruCache<>(10);

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (getFilePath(uri) == null) {
            return super.queryMAM(uri, strArr, str, strArr2, str2);
        }
        LegacyCompatCursorWrapper legacyCompatCursorWrapper = new LegacyCompatCursorWrapper(super.queryMAM(uri, strArr, str, strArr2, str2));
        legacyCompatCursorWrapper.setOriginalFilePath(getFilePath(uri));
        return legacyCompatCursorWrapper;
    }

    public static void addUriMapping(Uri uri, File file) {
        mUriMapping.put(uri.toString(), file.getAbsolutePath());
    }

    private static String getFilePath(Uri uri) {
        return mUriMapping.get(uri.toString());
    }
}
