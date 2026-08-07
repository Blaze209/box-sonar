package com.pspdfkit.internal.views.document.editor;

import android.graphics.Bitmap;
import android.view.View;
import androidx.recyclerview.widget.PdfViewHolderBindDirtyReporter;
import com.pspdfkit.internal.n60;
import io.reactivex.rxjava3.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends PdfViewHolderBindDirtyReporter implements View.OnClickListener, View.OnLongClickListener {
    public final ThumbnailGridRecyclerView.a a;
    public final b b;
    public Bitmap c;
    public Disposable d;
    public boolean e;

    public a(n60 n60Var, ThumbnailGridRecyclerView.a aVar, b bVar) {
        super(n60Var);
        this.e = false;
        this.a = aVar;
        this.b = bVar;
        n60Var.setOnClickListener(this);
        n60Var.setOnLongClickListener(this);
    }

    public final void a() {
        this.itemView.setElevation(this.itemView.getElevation() + 6.0f);
        n60 n60Var = (n60) this.itemView;
        boolean zIsActivated = n60Var.b.isActivated();
        View view = n60Var.b;
        if (zIsActivated) {
            n60.a(view, 1.0f, 1.2f);
        } else {
            n60.a(view, 1.0f, 1.025f);
        }
        ThumbnailGridRecyclerView.a aVar = this.a;
        if (aVar != null) {
            aVar.onStartDraggingPages();
        }
        this.b.d = true;
    }

    public final void b() {
        this.itemView.setElevation(this.itemView.getElevation() - 6.0f);
        n60 n60Var = (n60) this.itemView;
        boolean zIsActivated = n60Var.b.isActivated();
        View view = n60Var.b;
        if (zIsActivated) {
            n60.a(view, 1.2f, 1.0f);
        } else {
            n60.a(view, 1.025f, 1.0f);
        }
        ThumbnailGridRecyclerView.a aVar = this.a;
        if (aVar != null) {
            aVar.onStopDraggingPages();
        }
        this.b.d = false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.e) {
            ThumbnailGridRecyclerView.a aVar = this.a;
            if (aVar != null) {
                aVar.onPageClick(getBindingAdapterPosition());
                return;
            }
            return;
        }
        b bVar = this.b;
        if (bVar.e) {
            boolean zContains = bVar.b.contains(Integer.valueOf(getBindingAdapterPosition()));
            HashSet<Integer> hashSet = bVar.b;
            if (zContains) {
                hashSet.remove(Integer.valueOf(getBindingAdapterPosition()));
            } else {
                hashSet.add(Integer.valueOf(getBindingAdapterPosition()));
            }
            ThumbnailGridRecyclerView.a aVar2 = bVar.c;
            if (aVar2 != null) {
                aVar2.onPageSelectionStateChanged();
            }
            bVar.a(this);
        }
        ThumbnailGridRecyclerView.a aVar3 = this.a;
        if (aVar3 != null) {
            aVar3.onPageSelectionStateChanged();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ThumbnailGridRecyclerView.a aVar;
        if (this.e || (aVar = this.a) == null) {
            return true;
        }
        aVar.onPageLongClick(getBindingAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.PdfViewHolderBindDirtyReporter
    public final void onViewHolderBindDirty() {
        b bVar = this.b;
        b.a aVar = bVar.a;
        aVar.a.put(getBindingAdapterPosition(), new WeakReference<>(this));
        if (b.this.f != -1 && getBindingAdapterPosition() == b.this.f) {
            ((n60) this.itemView).setHighlighted(true);
            b.this.f = -1;
        }
        bVar.a(this);
    }
}
