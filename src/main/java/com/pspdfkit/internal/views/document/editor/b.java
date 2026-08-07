package com.pspdfkit.internal.views.document.editor;

import android.util.SparseArray;
import com.pspdfkit.internal.n60;
import com.pspdfkit.utils.PdfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public ThumbnailGridRecyclerView.a c;
    public boolean d;
    public boolean e;
    public final a a = new a();
    public final HashSet<Integer> b = new HashSet<>();
    public int f = -1;

    public class a {
        public final SparseArray<WeakReference<com.pspdfkit.internal.views.document.editor.a>> a = new SparseArray<>();

        public a() {
        }
    }

    public final void a() {
        this.b.clear();
        b();
        ThumbnailGridRecyclerView.a aVar = this.c;
        if (aVar != null) {
            aVar.onPageSelectionStateChanged();
        }
    }

    public final void b() {
        com.pspdfkit.internal.views.document.editor.a aVar;
        a aVar2 = this.a;
        int size = aVar2.a.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            WeakReference<com.pspdfkit.internal.views.document.editor.a> weakReference = aVar2.a.get(aVar2.a.keyAt(i2));
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                arrayList.add(aVar);
            }
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            a((com.pspdfkit.internal.views.document.editor.a) obj);
        }
    }

    public final void a(int i) {
        a aVar = this.a;
        WeakReference<com.pspdfkit.internal.views.document.editor.a> weakReference = aVar.a.get(i);
        com.pspdfkit.internal.views.document.editor.a aVar2 = null;
        if (weakReference != null) {
            com.pspdfkit.internal.views.document.editor.a aVar3 = weakReference.get();
            if (aVar3 == null || aVar3.getBindingAdapterPosition() != i) {
                aVar.a.remove(i);
            } else {
                aVar2 = aVar3;
            }
        }
        if (aVar2 != null) {
            if (this.e) {
                boolean zContains = this.b.contains(Integer.valueOf(aVar2.getBindingAdapterPosition()));
                HashSet<Integer> hashSet = this.b;
                if (!zContains) {
                    hashSet.add(Integer.valueOf(aVar2.getBindingAdapterPosition()));
                } else {
                    hashSet.remove(Integer.valueOf(aVar2.getBindingAdapterPosition()));
                }
                ThumbnailGridRecyclerView.a aVar4 = this.c;
                if (aVar4 != null) {
                    aVar4.onPageSelectionStateChanged();
                }
                a(aVar2);
                return;
            }
            return;
        }
        PdfLog.w("Nutri.ThumbnailGrid", "Could not toggle selection for view holder at position " + i + " since no view holder for that position was known.", new Object[0]);
    }

    public final void a(com.pspdfkit.internal.views.document.editor.a aVar) {
        boolean zContains;
        boolean z = this.e;
        boolean z2 = aVar.e != z;
        aVar.e = z;
        if (z2) {
            ((n60) aVar.itemView).a(z);
        }
        if (aVar.getBindingAdapterPosition() < 0 || this.d || ((n60) aVar.itemView).isActivated() == (zContains = this.b.contains(Integer.valueOf(aVar.getBindingAdapterPosition())))) {
            return;
        }
        ((n60) aVar.itemView).setActivated(zContains);
    }
}
