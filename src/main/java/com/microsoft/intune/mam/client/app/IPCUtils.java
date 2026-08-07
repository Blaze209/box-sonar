package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.os.Binder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class IPCUtils {
    private IPCUtils() {
    }

    public static List<String> getCallingPackageCandidates(Context context) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packagesForUid == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(packagesForUid);
    }
}
