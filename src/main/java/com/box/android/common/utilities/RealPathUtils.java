package com.box.android.common.utilities;

import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RealPathUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/box/android/common/utilities/RealPathUtils;", "", "<init>", "()V", "fileExists", "", "filePath", "", "getPathFromExtSD", "pathData", "", "([Ljava/lang/String;)Ljava/lang/String;", "isExternalStorageDocument", "uri", "Landroid/net/Uri;", "getPath", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealPathUtils {
    public static final RealPathUtils INSTANCE = new RealPathUtils();

    private RealPathUtils() {
    }

    public final boolean fileExists(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new File(filePath).exists();
    }

    private final String getPathFromExtSD(String[] pathData) {
        String str = pathData[0];
        String str2 = "/" + pathData[1];
        if (StringsKt.equals("primary", str, true)) {
            String str3 = Environment.getExternalStorageDirectory().toString() + str2;
            if (fileExists(str3)) {
                return str3;
            }
        }
        String str4 = System.getenv("SECONDARY_STORAGE");
        if (str4 != null) {
            String str5 = str4 + str2;
            if (INSTANCE.fileExists(str5)) {
                return str5;
            }
        }
        String str6 = System.getenv("EXTERNAL_STORAGE");
        if (str6 == null) {
            return null;
        }
        String str7 = str6 + str2;
        if (INSTANCE.fileExists(str7)) {
            return str7;
        }
        return null;
    }

    private final boolean isExternalStorageDocument(Uri uri) {
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final String getPath(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (isExternalStorageDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            Intrinsics.checkNotNull(documentId);
            return getPathFromExtSD((String[]) StringsKt.split$default((CharSequence) documentId, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]));
        }
        if (StringsKt.equals("file", uri.getScheme(), true)) {
            return uri.getPath();
        }
        return null;
    }
}
