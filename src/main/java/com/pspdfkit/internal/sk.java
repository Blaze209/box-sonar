package com.pspdfkit.internal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public class sk extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Object a;
    public Bundle b;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = bundle;
            ?? r0 = this.a;
            if (r0 == 0 || !r0.onRestoreInstanceState(bundle)) {
                return;
            }
            this.b = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.pspdfkit.internal.tk, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        ?? r0 = this.a;
        if (r0 != 0) {
            r0.onSaveInstanceState(bundle);
        }
        this.b = bundle;
    }
}
