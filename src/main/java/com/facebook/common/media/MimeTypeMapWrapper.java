package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import androidx.media3.common.MimeTypes;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class MimeTypeMapWrapper {
    private static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();
    private static final Map<String, String> sMimeTypeToExtensionMap = ImmutableMap.of(MimeTypes.IMAGE_HEIF, "heif", MimeTypes.IMAGE_HEIC, "heic");
    private static final Map<String, String> sExtensionToMimeTypeMap = ImmutableMap.of("heif", MimeTypes.IMAGE_HEIF, "heic", MimeTypes.IMAGE_HEIC);

    public static String getExtensionFromMimeType(String str) {
        String str2 = sMimeTypeToExtensionMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        String str2 = sExtensionToMimeTypeMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(String str) {
        return sExtensionToMimeTypeMap.containsKey(str) || sMimeTypeMap.hasExtension(str);
    }

    public static boolean hasMimeType(String str) {
        return sMimeTypeToExtensionMap.containsKey(str) || sMimeTypeMap.hasMimeType(str);
    }
}
