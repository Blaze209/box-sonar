package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class l60 extends RecyclerView.Adapter<com.pspdfkit.internal.views.document.editor.a> {
    public final Context a;
    public final lm b;
    public final com.pspdfkit.internal.views.document.editor.b c;
    public final ThumbnailGridRecyclerView.a d;
    public final m60 e;
    public final int f;
    public final ArrayList<AnnotationType> g;
    public boolean j;
    public NativeDocumentEditor m;
    public boolean o;
    public final PageRenderConfiguration p;
    public final PriorityQueue<a> h = new PriorityQueue<>(15, new Comparator() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return l60.a((l60.a) obj, (l60.a) obj2);
        }
    });
    public final Handler i = new Handler();
    public final ArrayList k = new ArrayList();
    public int l = -1;
    public final Runnable n = new Runnable() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.a();
        }
    };

    public static final class a {
        public final com.pspdfkit.internal.views.document.editor.a a;
        public final int b;
        public final int c;
        public final int d;

        public a(com.pspdfkit.internal.views.document.editor.a aVar, int i, int i2, int i3) {
            this.a = aVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public l60(Context context, lm lmVar, m60 m60Var, ThumbnailGridRecyclerView.a aVar, com.pspdfkit.internal.views.document.editor.b bVar, PdfConfiguration pdfConfiguration, int i, boolean z, boolean z2) {
        this.a = context;
        this.b = lmVar;
        this.e = m60Var;
        this.p = ca.a(pdfConfiguration, lmVar);
        this.j = z;
        this.d = aVar;
        this.c = bVar;
        this.f = i;
        this.g = new ArrayList<>(pdfConfiguration.getExcludedAnnotationTypes());
        this.o = z2;
    }

    public final SingleSource a(final com.pspdfkit.internal.views.document.editor.a aVar, int i, int i2, final int i3) throws Throwable {
        y7 y7Var = q10.c;
        if (y7Var == null) {
            y7Var = new y7();
            q10.c = y7Var;
        }
        y7Var.c(aVar.c);
        y7 y7Var2 = q10.c;
        if (y7Var2 == null) {
            y7Var2 = new y7();
            q10.c = y7Var2;
        }
        Bitmap bitmapA = y7Var2.a(i, i2);
        aVar.c = bitmapA;
        NativeDocumentEditor nativeDocumentEditor = this.m;
        lm lmVar = this.b;
        return nativeDocumentEditor != null ? iu.a(km.a(lmVar.c, i3, bitmapA, null, this.p, 10, nativeDocumentEditor, Boolean.valueOf(this.o), this.g, Collections.EMPTY_LIST, null)) : qv.a(lmVar, this.k, this.a, i3).map(new Function() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(i3, aVar, (List) obj);
            }
        }).flatMap(new Function() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return iu.b((jm) obj);
            }
        });
    }

    public final Supplier<SingleSource<? extends Bitmap>> b(final com.pspdfkit.internal.views.document.editor.a aVar, final int i, final int i2, final int i3) {
        return new Supplier() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.a(aVar, i2, i3, i);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        NativeDocumentEditor nativeDocumentEditor = this.m;
        return nativeDocumentEditor == null ? this.b.s : nativeDocumentEditor.getPageCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        com.pspdfkit.internal.views.document.editor.a aVar = (com.pspdfkit.internal.views.document.editor.a) viewHolder;
        Iterator<a> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().a == aVar) {
                it.remove();
            }
        }
        yz.a(aVar.d);
        aVar.d = null;
        n60 n60Var = (n60) aVar.itemView;
        boolean z = false;
        boolean z2 = this.m != null;
        if (z2 || !this.j) {
            n60Var.setItemLabelText(String.valueOf(i + 1));
        } else {
            n60Var.setItemLabelText(this.b.getPageLabel(i, true));
        }
        n60Var.setItemLabelStyle(this.e.a);
        n60Var.setItemLabelBackground(this.e.b);
        if (!z2 && i == this.l) {
            z = true;
        }
        n60Var.setHighlighted(z);
        Size rotatedPageSize = z2 ? this.m.getRotatedPageSize(i) : this.b.getPageSize(i);
        float f = rotatedPageSize.width;
        float f2 = rotatedPageSize.height;
        if (f == 0.0f || f2 == 0.0f) {
            n60Var.setThumbnailDrawable(new ColorDrawable(-1));
            return;
        }
        int i3 = this.f;
        float f3 = i3;
        int i4 = (int) ((f2 / f) * f3);
        if (i4 / f2 < f3 / f) {
            i3 = (int) ((((double) i4) / ((double) f2)) * ((double) f));
            i2 = i4;
        } else {
            i2 = (int) ((((double) i3) / ((double) f)) * ((double) f2));
        }
        ViewGroup.LayoutParams layoutParams = n60Var.getThumbnailView().getLayoutParams();
        if (layoutParams.width != i3 || layoutParams.height != i2) {
            layoutParams.width = this.f;
            layoutParams.height = i4;
            n60Var.getThumbnailView().setLayoutParams(layoutParams);
        }
        PageRenderConfiguration pageRenderConfiguration = this.p;
        boolean z3 = pageRenderConfiguration.invertColors;
        int iA = pageRenderConfiguration.paperColor;
        if (z3) {
            iA = ff.a(iA);
        }
        n60Var.setThumbnailDrawable(new p8(iA, this.f, i4));
        n60Var.setContentDescription(no.a(this.a, R.string.pspdf__page_with_number, n60Var, Integer.valueOf(i + 1)));
        n60Var.setTag(Integer.valueOf(i));
        this.h.add(new a(aVar, i, i3, i2));
        this.i.removeCallbacks(this.n);
        this.i.postDelayed(this.n, 100L);
        this.c.a(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new com.pspdfkit.internal.views.document.editor.a(new n60(this.a), this.d, this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        ((com.pspdfkit.internal.views.document.editor.a) viewHolder).itemView.clearAnimation();
    }

    public static /* synthetic */ int a(a aVar, a aVar2) {
        int i = aVar.b;
        int i2 = aVar2.b;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public final void a(int i, ThumbnailGridRecyclerView thumbnailGridRecyclerView) {
        if (this.m != null) {
            return;
        }
        int i2 = this.l;
        if (i2 <= -1 || i != i2) {
            this.l = i;
            int childCount = thumbnailGridRecyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = thumbnailGridRecyclerView.getChildAt(i3);
                int childAdapterPosition = thumbnailGridRecyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition == i || childAdapterPosition == i2) {
                    ((n60) ((com.pspdfkit.internal.views.document.editor.a) thumbnailGridRecyclerView.getChildViewHolder(childAt)).itemView).setHighlighted(childAdapterPosition == i);
                }
            }
        }
    }

    public final void a() {
        g60 g60VarC;
        a aVarPoll = this.h.poll();
        if (aVarPoll != null) {
            com.pspdfkit.internal.views.document.editor.a aVar = aVarPoll.a;
            int i = aVarPoll.b;
            Single map = Single.defer(b(aVar, i, aVarPoll.c, aVarPoll.d)).map(a(((n60) aVar.itemView).getThumbnailDrawable(), SystemClock.uptimeMillis()));
            synchronized (ar.class) {
                g60VarC = q10.c();
            }
            aVar.d = (Disposable) map.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new k60(this, aVar, i));
        }
    }

    public final Function<Bitmap, rg> a(final Drawable drawable, final long j) {
        return new Function() { // from class: com.pspdfkit.internal.l60$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(j, drawable, (Bitmap) obj);
            }
        };
    }

    public final /* synthetic */ rg a(long j, Drawable drawable, Bitmap bitmap) throws Throwable {
        return new rg(this.a.getResources(), bitmap, drawable, SystemClock.uptimeMillis() - j > 50);
    }

    public final jm a(int i, com.pspdfkit.internal.views.document.editor.a aVar, List list) throws Throwable {
        return km.a(this.b.c, i, aVar.c, null, this.p, 5, null, Boolean.valueOf(this.o), this.g, list, 0);
    }
}
