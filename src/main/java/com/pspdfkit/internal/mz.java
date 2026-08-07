package com.pspdfkit.internal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes3.dex */
public final class mz {
    public final FragmentManager a;
    public final String b;

    public static class a extends Fragment {
        public Object a;

        @Override // androidx.fragment.app.Fragment
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (getParentFragment() == null) {
                setRetainInstance(true);
            }
        }
    }

    public mz(FragmentManager fragmentManager, String str) {
        this.a = fragmentManager;
        this.b = str;
    }
}
