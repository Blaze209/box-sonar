package com.pspdfkit.internal;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zl {
    public final FragmentManager a;
    public yl.c b;
    public yl c;

    public zl(FragmentManager fragmentManager) {
        fragmentManager.getClass();
        uw.a(fragmentManager, "fragmentManager", null);
        this.a = fragmentManager;
        this.c = (yl) fragmentManager.findFragmentByTag("com.pspdfkit.internal.document.image.IntentChooserImagePickerFragment.FRAGMENT_TAG");
    }

    public final boolean a(String str) {
        yl ylVar = this.c;
        if (ylVar == null) {
            ylVar = (yl) this.a.findFragmentByTag("com.pspdfkit.internal.document.image.IntentChooserImagePickerFragment.FRAGMENT_TAG");
            if (ylVar == null) {
                ylVar = new yl();
            }
            this.c = ylVar;
        }
        ylVar.f = str;
        yl.c cVar = this.b;
        if (cVar != null) {
            ylVar.b = cVar;
            yl.a aVar = ylVar.c;
            if (aVar != null) {
                ylVar.a(aVar);
            }
        }
        if (fi.a(this.a, ylVar, "com.pspdfkit.internal.document.image.IntentChooserImagePickerFragment.FRAGMENT_TAG")) {
            this.a.executePendingTransactions();
        }
        try {
            ArrayList arrayList = new ArrayList();
            ylVar.a(arrayList);
            Context contextRequireContext = ylVar.requireContext();
            contextRequireContext.getClass();
            Intent intentA = yl.b.a(contextRequireContext, ylVar.f, arrayList);
            ArrayList arrayList2 = new ArrayList();
            Context contextRequireContext2 = ylVar.requireContext();
            contextRequireContext2.getClass();
            Intent intentA2 = yl.b.a(contextRequireContext2, ylVar.f, arrayList2);
            if (intentA == null && intentA2 == null) {
                PdfLog.e("Nutri.IChooserIPickFrag", "Failed to capture image because the device does not support any intent action.", new Object[0]);
                return false;
            }
            ylVar.a(intentA, intentA2);
            return true;
        } catch (SecurityException e) {
            PdfLog.e("Nutri.IChooserIPickFrag", "Failed to capture image due to security exception!", e);
        }
    }
}
