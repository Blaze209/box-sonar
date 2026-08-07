package com.pspdfkit.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class qs extends RecyclerView.Adapter<rs<?>> implements fs {
    public final Context a;
    public final us b;
    public final ArrayList c;
    public final bs d;
    public boolean e;
    public boolean f;
    public ds g;
    public is h;

    public qs(Context context) {
        context.getClass();
        this.a = context;
        this.b = new us();
        this.c = new ArrayList();
        this.d = new bs();
        this.e = true;
        setHasStableIds(true);
    }

    @Override // com.pspdfkit.internal.fs
    public final void a(List<? extends ds> list, boolean z) {
        list.getClass();
        ArrayList arrayList = this.c;
        arrayList.clear();
        arrayList.addAll(list);
        if (z && !list.isEmpty()) {
            this.g = (ds) CollectionsKt.last((List) list);
        }
        notifyDataSetChanged();
    }

    @Override // com.pspdfkit.internal.fs
    public final void b(ds dsVar) {
        dsVar.getClass();
        int iIndexOf = this.c.indexOf(dsVar);
        if (iIndexOf == -1) {
            return;
        }
        this.g = null;
        this.c.remove(iIndexOf);
        notifyItemRemoved(iIndexOf + (this.e ? 1 : 0));
    }

    @Override // com.pspdfkit.internal.fs
    public final void c(ds dsVar) {
        this.c.add(dsVar);
        this.g = dsVar;
        notifyItemInserted(this.c.size() + (this.e ? 1 : 0));
    }

    @Override // com.pspdfkit.internal.fs
    public final void d() {
        us usVar = this.b;
        usVar.c = !usVar.c;
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final boolean g() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.c.size() + (this.e ? 1 : 0) + (this.f ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            return -2L;
        }
        if (itemViewType != 1) {
            return i;
        }
        if (this.f && i == getItemCount() - 1) {
            return -3L;
        }
        return ((ds) this.c.get(i - (this.e ? 1 : 0))).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return (i == 0 && this.e) ? 0 : 1;
    }

    @Override // com.pspdfkit.internal.fs
    public final List<ds> getNoteEditorContentCards() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        rs rsVar = (rs) viewHolder;
        rsVar.getClass();
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((w40) rsVar).a(this.b, this.h);
            return;
        }
        if (itemViewType != 1) {
            return;
        }
        ea eaVar = (ea) rsVar;
        ds dsVar = (this.f && i == getItemCount() - 1) ? this.d : (ds) this.c.get(i - (this.e ? 1 : 0));
        boolean zAreEqual = Intrinsics.areEqual(this.g, dsVar);
        is isVar = this.h;
        dsVar.getClass();
        eaVar.x = zAreEqual;
        eaVar.a(dsVar, isVar);
        if (zAreEqual) {
            this.g = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.pspdf__note_editor_style_box_card_layout, viewGroup, false);
            viewInflate.getClass();
            return new w40(viewInflate);
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.pspdf__note_editor_item_card_layout, viewGroup, false);
        viewInflate2.getClass();
        return new ea(viewInflate2);
    }

    @Override // com.pspdfkit.internal.fs
    public final void setAddNewReplyBoxDisplayed(boolean z) {
        int itemCount = getItemCount();
        if (z == this.f) {
            return;
        }
        if (z) {
            this.f = true;
            notifyItemInserted(itemCount);
        } else {
            this.f = false;
            notifyItemRemoved(itemCount - 1);
        }
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxDisplayed(boolean z) {
        throw null;
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxExpanded(boolean z) {
        throw null;
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxPickerColors(List<Integer> list) {
        list.getClass();
        us usVar = this.b;
        usVar.getClass();
        ArrayList arrayList = usVar.a;
        arrayList.clear();
        arrayList.addAll(list);
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxPickerIcons(List<String> list) {
        list.getClass();
        us usVar = this.b;
        usVar.getClass();
        ArrayList arrayList = usVar.b;
        arrayList.clear();
        arrayList.addAll(list);
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxSelectedColor(int i) {
        this.b.f = Integer.valueOf(i);
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxSelectedIcon(String str) {
        us usVar = this.b;
        if (str == null || !usVar.b.contains(str)) {
            str = null;
        }
        usVar.d = str;
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final void setStyleBoxText(int i) {
        String strA = no.a(this.a, i, null);
        strA.getClass();
        us usVar = this.b;
        usVar.getClass();
        usVar.e = strA;
        a();
    }

    @Override // com.pspdfkit.internal.fs
    public final void d(ds dsVar) {
        dsVar.getClass();
        int iIndexOf = this.c.indexOf(dsVar);
        if (iIndexOf == -1) {
            return;
        }
        notifyItemChanged(iIndexOf + (this.e ? 1 : 0));
    }

    public final void a() {
        if (this.e) {
            notifyItemChanged(0);
        }
    }
}
