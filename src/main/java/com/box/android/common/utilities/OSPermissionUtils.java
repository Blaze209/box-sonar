package com.box.android.common.utilities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSPermissionUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/box/android/common/utilities/OSPermissionUtils;", "", "<init>", "()V", "hasStoragePermission", "", "isAllFilesAccessNeeded", "requestStoragePermission", "", "context", "Landroid/app/Activity;", "requestCode", "", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OSPermissionUtils {
    public static final OSPermissionUtils INSTANCE = new OSPermissionUtils();

    private OSPermissionUtils() {
    }

    public static /* synthetic */ boolean hasStoragePermission$default(OSPermissionUtils oSPermissionUtils, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return oSPermissionUtils.hasStoragePermission(z);
    }

    public final boolean hasStoragePermission(boolean isAllFilesAccessNeeded) {
        return !isAllFilesAccessNeeded || Environment.isExternalStorageManager();
    }

    public final void requestStoragePermission(Activity context, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasStoragePermission(true)) {
            return;
        }
        context.startActivityForResult(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.fromParts("package", context.getPackageName(), null)), requestCode);
    }
}
