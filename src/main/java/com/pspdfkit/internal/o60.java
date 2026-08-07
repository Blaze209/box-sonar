package com.pspdfkit.internal;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class o60 extends ItemTouchHelper.Callback {
    public final ThumbnailGridRecyclerView a;

    public o60(ThumbnailGridRecyclerView thumbnailGridRecyclerView) {
        this.a = thumbnailGridRecyclerView;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        this.a.getClass();
        if (viewHolder instanceof com.pspdfkit.internal.views.document.editor.a) {
            ((com.pspdfkit.internal.views.document.editor.a) viewHolder).b();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
            return false;
        }
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.a;
        thumbnailGridRecyclerView.getClass();
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        com.pspdfkit.internal.views.document.editor.b bVar = thumbnailGridRecyclerView.c;
        boolean zContains = bVar.b.contains(Integer.valueOf(adapterPosition));
        if (zContains != bVar.b.contains(Integer.valueOf(adapterPosition2))) {
            HashSet<Integer> hashSet = bVar.b;
            if (zContains) {
                hashSet.remove(Integer.valueOf(adapterPosition));
                bVar.b.add(Integer.valueOf(adapterPosition2));
            } else {
                hashSet.remove(Integer.valueOf(adapterPosition2));
                bVar.b.add(Integer.valueOf(adapterPosition));
            }
        }
        ThumbnailGridRecyclerView.a aVar = thumbnailGridRecyclerView.e;
        if (aVar != null) {
            aVar.onPageMoved(adapterPosition, adapterPosition2);
        }
        l60 l60Var = thumbnailGridRecyclerView.f;
        if (l60Var == null) {
            return true;
        }
        l60Var.notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i != 0) {
            this.a.getClass();
            if (viewHolder instanceof com.pspdfkit.internal.views.document.editor.a) {
                ((com.pspdfkit.internal.views.document.editor.a) viewHolder).a();
            }
        }
        super.onSelectedChanged(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }
}
