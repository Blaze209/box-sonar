package com.pspdfkit.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {
    public final String[] a;
    public final int b;

    public k0(String[] strArr, int i) {
        this.a = strArr;
        this.b = i;
    }

    public static final void a(gw gwVar, FragmentManager fragmentManager) {
        if (!gwVar.isAdded()) {
            fragmentManager.beginTransaction().add(gwVar, "com.pspdfkit.internal.permission.AndroidPermissionDialogHandler.FRAGMENT_TAG").commitNow();
        }
        if (gwVar.b) {
            return;
        }
        ActivityResultLauncher<String[]> activityResultLauncher = gwVar.d;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionsRequestLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(gwVar.a);
    }

    public final void a(Context context, final FragmentManager fragmentManager, hw hwVar, Function1 function1) {
        context.getClass();
        fragmentManager.getClass();
        function1.getClass();
        for (String str : this.a) {
            str.getClass();
            if (ContextCompat.checkSelfPermission(hwVar.a, str) != 0) {
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag("com.pspdfkit.internal.permission.AndroidPermissionDialogHandler.FRAGMENT_TAG");
                if (fragmentFindFragmentByTag == null) {
                    fragmentFindFragmentByTag = new gw(this.a);
                }
                final gw gwVar = (gw) fragmentFindFragmentByTag;
                gwVar.c = function1;
                gwVar.f = this.b;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pspdfkit.internal.k0$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        k0.a(gwVar, fragmentManager);
                    }
                });
                return;
            }
        }
        function1.invoke(Boolean.TRUE);
    }
}
