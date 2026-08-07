package sdk.pendo.io.g;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.media3.common.MimeTypes;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return c(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean b(Uri uri) {
        return c(uri) && !e(uri);
    }

    public static boolean c(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean d(Uri uri) {
        return c(uri) && e(uri);
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains(MimeTypes.BASE_TYPE_VIDEO);
    }

    public static boolean a() {
        return SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static AssetFileDescriptor a(Uri uri, ContentResolver contentResolver) {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }
}
