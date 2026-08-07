package com.pspdfkit.internal.views.document.editor;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.ScaleAnimation;
import androidx.customview.view.AbsSavedState;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.internal.gt;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.l60;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.m60;
import com.pspdfkit.internal.n60;
import com.pspdfkit.internal.o60;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.processors.BehaviorProcessor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ThumbnailGridRecyclerView extends RecyclerView {
    public final m60 a;
    public final ItemTouchHelper b;
    public final com.pspdfkit.internal.views.document.editor.b c;
    public int d;
    public a e;
    public l60 f;
    public GridLayoutManager g;
    public lm h;
    public PdfConfiguration i;
    public boolean j;
    public boolean k;
    public final BehaviorProcessor<List<PdfDrawableProvider>> l;
    public final BehaviorProcessor<gt<l60>> m;
    public boolean n;
    public Integer o;

    public interface a {
        void onPageClick(int i);

        void onPageLongClick(int i);

        void onPageMoved(int i, int i2);

        void onPageSelectionStateChanged();

        void onStartDraggingPages();

        void onStopDraggingPages();
    }

    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public boolean a;
        public HashSet<Integer> b;

        public class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
            parcel.writeValue(this.b);
        }

        public b(Parcel parcel) {
            super(parcel, b.class.getClassLoader());
            this.a = parcel.readInt() == 1;
            this.b = (HashSet) parcel.readValue(HashSet.class.getClassLoader());
        }
    }

    public static /* synthetic */ Pair $r8$lambda$TJulNyHekyqzpJFvEpivOLWCfUM(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }

    public ThumbnailGridRecyclerView(Context context) {
        super(context);
        this.a = new m60();
        this.b = new ItemTouchHelper(new o60(this));
        this.c = new com.pspdfkit.internal.views.document.editor.b();
        this.l = BehaviorProcessor.create();
        this.m = BehaviorProcessor.create();
        a(context);
    }

    public static Consumer b() {
        return new Consumer() { // from class: com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                ThumbnailGridRecyclerView.a((Pair) obj);
            }
        };
    }

    private BiFunction<gt<l60>, List<PdfDrawableProvider>, Pair<gt<l60>, List<PdfDrawableProvider>>> getCombiner() {
        return new BiFunction() { // from class: com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ThumbnailGridRecyclerView.$r8$lambda$TJulNyHekyqzpJFvEpivOLWCfUM((gt) obj, (List) obj2);
            }
        };
    }

    public final void a(Context context) {
        this.d = getResources().getConfiguration().orientation == 1 ? 3 : 5;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, this.d, 1, false);
        this.g = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.01f, 1.0f, 0.01f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new LinearOutSlowInInterpolator());
        scaleAnimation.setDuration(225L);
        setLayoutAnimation(new GridLayoutAnimationController(scaleAnimation, 0.3f, 0.3f));
        Flowable.combineLatest(this.m, this.l, getCombiner()).subscribe(b());
    }

    @Override // android.view.ViewGroup
    public final void attachLayoutAnimationParameters(View view, ViewGroup.LayoutParams layoutParams, int i, int i2) {
        if (getAdapter() == null || !(getLayoutManager() instanceof GridLayoutManager)) {
            super.attachLayoutAnimationParameters(view, layoutParams, i, i2);
            return;
        }
        GridLayoutAnimationController.AnimationParameters animationParameters = (GridLayoutAnimationController.AnimationParameters) layoutParams.layoutAnimationParameters;
        if (animationParameters == null) {
            animationParameters = new GridLayoutAnimationController.AnimationParameters();
            layoutParams.layoutAnimationParameters = animationParameters;
        }
        int spanCount = ((GridLayoutManager) getLayoutManager()).getSpanCount();
        animationParameters.count = i2;
        animationParameters.index = i;
        animationParameters.columnsCount = spanCount;
        animationParameters.rowsCount = (int) Math.ceil(i2 / spanCount);
        animationParameters.column = i % spanCount;
        animationParameters.row = i / spanCount;
    }

    public final void c() {
        if (getWidth() == 0) {
            this.k = true;
            return;
        }
        l60 l60Var = this.f;
        if (l60Var != null) {
            setAdapter(l60Var);
            startLayoutAnimation();
        }
    }

    public HashSet<Integer> getSelectedPages() {
        return this.c.b;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation == 1 ? 3 : 5;
        this.d = i;
        this.g.setSpanCount(i);
        l60 l60VarA = a();
        this.f = l60VarA;
        setAdapter(l60VarA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.n = bVar.a;
        com.pspdfkit.internal.views.document.editor.b bVar2 = this.c;
        bVar2.b.addAll(bVar.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        l60 l60Var = this.f;
        if (l60Var != null) {
            bVar.a = l60Var.o;
        }
        bVar.b = this.c.b;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == 0 || i2 == 0) {
            return;
        }
        if (this.k) {
            this.f = a();
            post(new Runnable() { // from class: com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
            this.k = false;
        } else {
            l60 l60VarA = a();
            this.f = l60VarA;
            setAdapter(l60VarA);
        }
    }

    public void setDrawableProviders(List<PdfDrawableProvider> list) {
        this.l.onNext(list);
    }

    public void setHighlightedItem(int i) {
        this.o = Integer.valueOf(i);
        l60 l60Var = this.f;
        if (l60Var != null) {
            l60Var.a(i, this);
        }
    }

    public void setItemLabelBackground(int i) {
        this.a.b = i;
        l60 l60VarA = a();
        this.f = l60VarA;
        setAdapter(l60VarA);
    }

    public void setItemLabelTextStyle(int i) {
        this.a.a = i;
        l60 l60VarA = a();
        this.f = l60VarA;
        setAdapter(l60VarA);
    }

    public void setRedactionAnnotationPreviewEnabled(boolean z) {
        this.n = z;
        l60 l60Var = this.f;
        if (l60Var != null) {
            l60Var.o = z;
        }
    }

    public void setSelectedPages(Set<Integer> set) {
        com.pspdfkit.internal.views.document.editor.b bVar = this.c;
        bVar.a();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            bVar.a(it.next().intValue());
        }
    }

    public void setThumbnailGridListener(a aVar) {
        this.e = aVar;
        this.c.c = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Pair pair) throws Throwable {
        T t = ((gt) pair.first).a;
        if (t == 0) {
            return;
        }
        l60 l60Var = (l60) t;
        List list = (List) pair.second;
        l60Var.k.clear();
        l60Var.k.addAll(list);
        l60Var.notifyDataSetChanged();
    }

    public final l60 a() {
        NativeDocumentEditor nativeDocumentEditor;
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition;
        if (this.h != null && this.i != null && getWidth() != 0) {
            Context context = getContext();
            lm lmVar = this.h;
            m60 m60Var = this.a;
            a aVar = this.e;
            com.pspdfkit.internal.views.document.editor.b bVar = this.c;
            PdfConfiguration pdfConfiguration = this.i;
            int measuredWidth = getMeasuredWidth();
            int i = this.d;
            int i2 = n60.j;
            l60 l60Var = new l60(context, lmVar, m60Var, aVar, bVar, pdfConfiguration, measuredWidth / i, this.j, this.n);
            Integer num = this.o;
            if (num != null) {
                l60Var.a(num.intValue(), this);
            }
            l60 l60Var2 = this.f;
            if (l60Var2 != null && (nativeDocumentEditor = l60Var2.m) != null) {
                l60Var.m = nativeDocumentEditor;
                int i3 = l60Var.l;
                if (i3 > -1 && (viewHolderFindViewHolderForLayoutPosition = findViewHolderForLayoutPosition(i3)) != null) {
                    ((n60) ((com.pspdfkit.internal.views.document.editor.a) viewHolderFindViewHolderForLayoutPosition).itemView).setHighlighted(false);
                }
            }
            this.m.onNext(new gt<>(l60Var));
            if (this.h.getPageBinding() == PageBinding.RIGHT_EDGE) {
                setLayoutDirection(1);
                return l60Var;
            }
            setLayoutDirection(0);
            return l60Var;
        }
        this.m.onNext(new gt<>(null));
        return null;
    }

    public ThumbnailGridRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new m60();
        this.b = new ItemTouchHelper(new o60(this));
        this.c = new com.pspdfkit.internal.views.document.editor.b();
        this.l = BehaviorProcessor.create();
        this.m = BehaviorProcessor.create();
        a(context);
    }

    public ThumbnailGridRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new m60();
        this.b = new ItemTouchHelper(new o60(this));
        this.c = new com.pspdfkit.internal.views.document.editor.b();
        this.l = BehaviorProcessor.create();
        this.m = BehaviorProcessor.create();
        a(context);
    }
}
