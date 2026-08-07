package com.box.android.base.presentation.utilities;

import androidx.core.content.ContextCompat;
import com.box.android.common.utilities.ApplicationProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/presentation/utilities/PermissionsHandler;", "Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "<init>", "()V", "isPermissionGranted", "", "permission", "", "areAllPermissionsGranted", "permissions", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionsHandler implements IPermissionsHandler {
    public static final int $stable = 0;

    @Inject
    public PermissionsHandler() {
    }

    @Override // com.box.android.base.presentation.utilities.IPermissionsHandler
    public boolean isPermissionGranted(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(ApplicationProvider.getApplication(), permission) == 0;
    }

    @Override // com.box.android.base.presentation.utilities.IPermissionsHandler
    public boolean areAllPermissionsGranted(List<String> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        List<String> list = permissions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!isPermissionGranted((String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
