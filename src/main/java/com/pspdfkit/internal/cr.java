package com.pspdfkit.internal;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cr extends RecyclerView.Adapter {
    public final ArrayList b = new ArrayList();
    public final HashMap<a, List<? extends a>> c = new HashMap<>();
    public boolean a = true;

    public interface a {
        void a(int i);

        boolean a();

        List<? extends a> getChildren();
    }

    public final void a(int i, Collection<? extends a> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.b.addAll(i, collection);
        if (this.a) {
            notifyItemRangeInserted(i, collection.size());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.b.size();
    }

    public final void a(int i) {
        notifyItemChanged(i);
        if (i < 0 || i >= this.b.size()) {
            return;
        }
        a aVar = (a) this.b.get(i);
        if (aVar.getChildren() == null || aVar.getChildren().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int size = aVar.getChildren().size() - 1; size >= 0; size--) {
            arrayList2.add(aVar.getChildren().get(size));
        }
        int i2 = 0;
        while (!arrayList2.isEmpty()) {
            a aVar2 = (a) arrayList2.remove(arrayList2.size() - 1);
            arrayList.add(aVar2);
            i2++;
            if (aVar2.getChildren() != null && !aVar2.getChildren().isEmpty() && !aVar2.a()) {
                for (int size2 = aVar2.getChildren().size() - 1; size2 >= 0; size2--) {
                    arrayList2.add(aVar2.getChildren().get(size2));
                }
            }
            this.b.remove(aVar2);
        }
        this.c.put(aVar, arrayList);
        aVar.a(i2);
        notifyItemRangeRemoved(i + 1, i2);
    }

    public final ArrayList<Integer> a(boolean z) {
        boolean z2 = this.a;
        this.a = false;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < this.b.size(); i++) {
            if (((a) this.b.get(i)).a()) {
                a aVar = (a) this.b.get(i);
                if (aVar.a()) {
                    List<? extends a> listRemove = this.c.remove(aVar);
                    aVar.a(0);
                    a(i + 1, listRemove);
                }
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (z) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                a(arrayList.get(size).intValue());
            }
        }
        this.a = z2;
        return arrayList;
    }

    public final void a(List<Integer> list, boolean z) {
        if (list == null) {
            return;
        }
        boolean z2 = this.a;
        this.a = false;
        if (z) {
            for (int i = 0; i < this.b.size(); i++) {
                if (((a) this.b.get(i)).a()) {
                    a aVar = (a) this.b.get(i);
                    if (aVar.a()) {
                        List<? extends a> listRemove = this.c.remove(aVar);
                        aVar.a(0);
                        a(i + 1, listRemove);
                    }
                }
            }
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            a(list.get(size).intValue());
        }
        this.a = z2;
        if (z2) {
            notifyDataSetChanged();
        }
    }
}
