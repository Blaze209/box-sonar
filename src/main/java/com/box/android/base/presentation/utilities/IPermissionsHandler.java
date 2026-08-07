package com.box.android.base.presentation.utilities;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PermissionsHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "", "isPermissionGranted", "", "permission", "", "areAllPermissionsGranted", "permissions", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPermissionsHandler {
    boolean areAllPermissionsGranted(List<String> permissions);

    boolean isPermissionGranted(String permission);
}
