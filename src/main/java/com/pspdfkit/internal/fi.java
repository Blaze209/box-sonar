package com.pspdfkit.internal;

import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fi {
    public static final boolean a(FragmentManager fragmentManager, Fragment fragment, String str) {
        fragmentManager.getClass();
        fragment.getClass();
        str.getClass();
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("addFragment() may only be called from the main thread.");
        }
        if (fragment.isAdded()) {
            return false;
        }
        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(fragment, str);
        fragmentTransactionAdd.getClass();
        fragmentTransactionAdd.commit();
        return true;
    }

    public static final void a(FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.getClass();
        fragment.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            FragmentTransaction fragmentTransactionRemove = fragmentManager.beginTransaction().remove(fragment);
            fragmentTransactionRemove.getClass();
            fragmentTransactionRemove.commitNow();
            return;
        }
        throw new IllegalStateException("removeFragment() may only be called from the main thread.");
    }

    public static final void a(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        fragmentManager.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            FragmentTransaction fragmentTransactionRemove = fragmentManager.beginTransaction().remove(fragment);
            fragmentTransactionRemove.getClass();
            if (z) {
                fragmentTransactionRemove.commitNowAllowingStateLoss();
                return;
            } else {
                fragmentTransactionRemove.commitAllowingStateLoss();
                return;
            }
        }
        throw new IllegalStateException("removeFragmentAllowingStateLoss() may only be called from the main thread.");
    }
}
