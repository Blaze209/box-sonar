package com.pspdfkit.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.ui.tabs.PdfTabBarCloseMode;
import com.pspdfkit.ui.tabs.PdfTabBarItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zv extends RecyclerView {
    public static final Object i = new Object();
    public final aw a;
    public PdfTabBarCloseMode b;
    public final e c;
    public final LinearLayoutManager d;
    public final ArrayList e;
    public PdfTabBarItem f;
    public c g;
    public final d h;

    public class a extends ItemTouchHelper.SimpleCallback {
        public a() {
            super(12, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            ((e.a) viewHolder).getClass();
            super.clearView(recyclerView, viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            zv zvVar = zv.this;
            int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
            int bindingAdapterPosition2 = viewHolder2.getBindingAdapterPosition();
            if (bindingAdapterPosition >= 0 && bindingAdapterPosition < zvVar.e.size() && bindingAdapterPosition2 >= 0 && bindingAdapterPosition2 < zvVar.e.size()) {
                PdfTabBarItem pdfTabBarItem = (PdfTabBarItem) zvVar.e.get(bindingAdapterPosition);
                c cVar = zvVar.g;
                if (cVar != null && cVar.onMoveTab(pdfTabBarItem, bindingAdapterPosition2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
            }
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PdfTabBarCloseMode.values().length];
            a = iArr;
            try {
                iArr[PdfTabBarCloseMode.CLOSE_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PdfTabBarCloseMode.CLOSE_ONLY_SELECTED_TAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PdfTabBarCloseMode.CLOSE_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface c {
        boolean onMoveTab(PdfTabBarItem pdfTabBarItem, int i);

        void onTabClosed(PdfTabBarItem pdfTabBarItem);

        void onTabSelected(PdfTabBarItem pdfTabBarItem);

        void onTabsChanged();

        boolean shouldCloseTab(PdfTabBarItem pdfTabBarItem);

        boolean shouldSelectTab(PdfTabBarItem pdfTabBarItem);
    }

    public class d implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
        public final ArrayList a = new ArrayList();
        public PdfTabBarItem b = null;

        public d() {
        }

        public final void a() {
            RecyclerView.ItemAnimator itemAnimator = zv.this.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.isRunning(this);
            }
        }

        public final void b() {
            zv.this.post(new Runnable() { // from class: com.pspdfkit.internal.zv$d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public final void onAnimationsFinished() {
            c cVar;
            if (zv.this.isAnimating()) {
                b();
                return;
            }
            if (zv.this.g != null) {
                ArrayList arrayList = this.a;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zv.this.g.onTabClosed((PdfTabBarItem) obj);
                }
            }
            this.a.clear();
            PdfTabBarItem pdfTabBarItem = this.b;
            if (pdfTabBarItem != null && (cVar = zv.this.g) != null) {
                cVar.onTabSelected(pdfTabBarItem);
            }
            this.b = null;
        }
    }

    public class e extends RecyclerView.Adapter<a> {
        public final Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return zv.this.e.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.pspdf__tab_item, viewGroup, false), zv.this.a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
            a aVar = (a) viewHolder;
            if (list.isEmpty()) {
                onBindViewHolder(aVar, i);
            } else {
                aVar.a();
            }
        }

        public class a extends RecyclerView.ViewHolder {
            public final aw a;
            public final RelativeLayout b;
            public final TextView c;
            public final ImageView d;
            public final View e;
            public PdfTabBarItem f;
            public final int g;
            public final int h;

            public a(View view, aw awVar) {
                super(view);
                this.a = awVar;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.pspdf__tab_item_container);
                this.b = relativeLayout;
                relativeLayout.setBackgroundColor(awVar.b);
                relativeLayout.getLayoutParams().height = awVar.g;
                TextView textView = (TextView) view.findViewById(R.id.pspdf__tab_text);
                this.c = textView;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.zv$e$a$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.a(view2);
                    }
                });
                textView.setTextSize(0, awVar.j);
                ImageView imageView = (ImageView) view.findViewById(R.id.pspdf__tab_close);
                this.d = imageView;
                imageView.setImageDrawable(a80.a(e.this.a, R.drawable.pspdf__ic_close, awVar.f));
                this.h = imageView.getDrawable().getIntrinsicWidth();
                this.g = ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).getMarginEnd();
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.zv$e$a$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.b(view2);
                    }
                });
                View viewFindViewById = view.findViewById(R.id.pspdf__tab_selection_indicator);
                this.e = viewFindViewById;
                viewFindViewById.setBackgroundColor(awVar.c);
            }

            public final void a(View view) {
                PdfTabBarItem pdfTabBarItem = this.f;
                if (pdfTabBarItem != null) {
                    zv zvVar = zv.this;
                    c cVar = zvVar.g;
                    if (cVar == null || cVar.shouldSelectTab(pdfTabBarItem)) {
                        zvVar.setSelectedTab(pdfTabBarItem);
                    }
                }
            }

            public final void b(View view) {
                PdfTabBarItem pdfTabBarItem = this.f;
                if (pdfTabBarItem != null) {
                    zv zvVar = zv.this;
                    c cVar = zvVar.g;
                    if (cVar == null || cVar.shouldCloseTab(pdfTabBarItem)) {
                        zvVar.a(pdfTabBarItem);
                    }
                }
            }

            public final void a() {
                int i;
                if (this.f == null) {
                    return;
                }
                int size = zv.this.e.size();
                int width = zv.this.getWidth();
                if (size > 0 && width > 0) {
                    i = width / size;
                } else {
                    i = this.g + this.a.i + this.h;
                }
                int iMax = Math.max(i, this.a.i + this.h + this.g);
                int i2 = (iMax - this.h) - this.g;
                this.c.setEllipsize(null);
                this.c.forceLayout();
                this.c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(zv.this.getMeasuredHeight(), Integer.MIN_VALUE));
                if (this.c.getMeasuredWidth() > i2) {
                    this.c.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                }
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                layoutParams.width = iMax;
                this.b.setLayoutParams(layoutParams);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(a aVar, int i) {
            PdfTabBarItem pdfTabBarItem = (PdfTabBarItem) zv.this.e.get(i);
            aVar.f = pdfTabBarItem;
            aVar.c.setText(pdfTabBarItem.getDocumentDescriptor().getTitle(zv.this.getContext()));
            ViewGroup.LayoutParams layoutParams = aVar.e.getLayoutParams();
            PdfTabBarItem pdfTabBarItem2 = zv.this.f;
            View view = aVar.itemView;
            boolean z = true;
            if (pdfTabBarItem == pdfTabBarItem2) {
                view.setSelected(true);
                aVar.c.setTextColor(aVar.a.e);
                aVar.c.setClickable(false);
                layoutParams.width = -1;
            } else {
                view.setSelected(false);
                aVar.c.setTextColor(aVar.a.d);
                aVar.c.setClickable(true);
                layoutParams.width = aVar.a.h;
            }
            int i2 = b.a[zv.this.b.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IncompatibleClassChangeError();
                    }
                } else if (pdfTabBarItem != zv.this.f) {
                }
                z = false;
            }
            aVar.d.setVisibility(z ? 0 : 8);
            aVar.d.setEnabled(z);
            aVar.a();
        }
    }

    public zv(Context context, aw awVar) {
        super(context);
        this.b = PdfTabBarCloseMode.CLOSE_ONLY_SELECTED_TAB;
        this.c = new e(getContext());
        this.d = new LinearLayoutManager(getContext(), 0, false);
        this.e = new ArrayList();
        this.f = null;
        this.h = new d();
        uw.a(awVar, "themeConfiguration", null);
        this.a = awVar;
        a();
    }

    public final void a() {
        setId(R.id.pspdf__tabs_bar_list);
        this.d.setSmoothScrollbarEnabled(false);
        setLayoutManager(this.d);
        setAdapter(this.c);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.pspdfkit.internal.zv$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                this.f$0.a(view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        });
        new ItemTouchHelper(new a()).attachToRecyclerView(this);
    }

    public final void b() {
        e eVar = this.c;
        eVar.notifyItemRangeChanged(0, zv.this.e.size(), i);
    }

    public PdfTabBarItem getSelectedTab() {
        return this.f;
    }

    public List<PdfTabBarItem> getTabs() {
        return this.e;
    }

    public void setCloseMode(PdfTabBarCloseMode pdfTabBarCloseMode) {
        if (this.b == pdfTabBarCloseMode) {
            return;
        }
        this.b = pdfTabBarCloseMode;
        this.c.notifyDataSetChanged();
    }

    public void setDelegate(c cVar) {
        this.g = cVar;
    }

    public void setSelectedTab(PdfTabBarItem pdfTabBarItem) {
        if (this.f == pdfTabBarItem) {
            return;
        }
        int iIndexOf = pdfTabBarItem != null ? this.e.indexOf(pdfTabBarItem) : -1;
        if (iIndexOf >= 0) {
            int iIndexOf2 = this.e.indexOf(this.f);
            this.f = pdfTabBarItem;
            if (iIndexOf2 >= 0) {
                this.c.notifyItemChanged(iIndexOf2);
            }
            this.c.notifyItemChanged(iIndexOf);
            int iIndexOf3 = pdfTabBarItem != null ? this.e.indexOf(pdfTabBarItem) : -1;
            if (iIndexOf3 < 0 || iIndexOf3 < this.d.findFirstCompletelyVisibleItemPosition() || iIndexOf3 > this.d.findLastCompletelyVisibleItemPosition()) {
                scrollToPosition(iIndexOf);
            }
            d dVar = this.h;
            dVar.b = this.f;
            dVar.b();
        }
    }

    public final /* synthetic */ void a(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i4 - i2 == i8 - i6 || this.e.isEmpty()) {
            return;
        }
        post(new Runnable() { // from class: com.pspdfkit.internal.zv$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public final void a(PdfTabBarItem pdfTabBarItem) {
        PdfTabBarItem pdfTabBarItem2;
        int iIndexOf = this.e.indexOf(pdfTabBarItem);
        if (iIndexOf < 0 || (pdfTabBarItem2 = (PdfTabBarItem) this.e.remove(iIndexOf)) == null) {
            return;
        }
        c cVar = this.g;
        if (cVar != null) {
            cVar.onTabsChanged();
        }
        if (this.f == pdfTabBarItem2 && this.e.size() > 1) {
            setSelectedTab((PdfTabBarItem) this.e.get(iIndexOf == 0 ? 0 : iIndexOf - 1));
        }
        this.c.notifyItemRemoved(iIndexOf);
        e eVar = this.c;
        eVar.notifyItemRangeChanged(0, zv.this.e.size(), i);
        d dVar = this.h;
        dVar.a.add(pdfTabBarItem2);
        dVar.b();
    }
}
