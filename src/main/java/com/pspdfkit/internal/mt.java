package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.OutlineElement;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class mt extends nt<OutlineElement> {
    public final RecyclerView d;
    public final ProgressBar e;
    public final FrameLayout f;
    public final SearchView g;
    public final nt.b<OutlineElement> h;
    public boolean i;
    public ot j;
    public jt k;
    public String l;
    public boolean m;
    public boolean n;
    public ArrayList<Integer> o;
    public ArrayList<Integer> p;
    public Disposable q;
    public Disposable r;
    public lm s;
    public PdfOutlineView.DocumentOutlineProvider t;

    public class a implements SearchView.OnQueryTextListener {
        public final /* synthetic */ PublishSubject a;

        public a(PublishSubject publishSubject) {
            this.a = publishSubject;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextChange(String str) {
            this.a.onNext(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public final boolean onQueryTextSubmit(String str) {
            mt.this.g.clearFocus();
            return true;
        }
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public ArrayList<Integer> a;
        public ArrayList<Integer> b;
        public boolean c;
        public String d;

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

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (this.a == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeList(this.a);
            }
            if (this.b == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeList(this.b);
            }
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeString(this.d);
        }

        public b(Parcel parcel) {
            super(parcel);
            if (parcel.readByte() == 1) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.a = arrayList;
                parcel.readList(arrayList, Integer.class.getClassLoader());
            } else {
                this.a = null;
            }
            if (parcel.readByte() == 1) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                this.b = arrayList2;
                parcel.readList(arrayList2, Integer.class.getClassLoader());
            } else {
                this.b = null;
            }
            this.c = parcel.readByte() != 0;
            this.d = parcel.readString();
        }
    }

    public mt(Context context, nt.b<OutlineElement> bVar) {
        super(context);
        this.i = true;
        this.m = false;
        this.n = false;
        this.q = null;
        setId(R.id.pspdf__outline_list_view);
        setSaveEnabled(true);
        this.h = bVar;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.pspdf__outline_list_view, (ViewGroup) this, false);
        this.e = (ProgressBar) viewInflate.findViewById(R.id.pspdf__outline_progress);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.pspdf__outline_recycler_view);
        this.d = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, linearLayoutManager.getOrientation()));
        recyclerView.setOverScrollMode(2);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.pspdf__outline_pager_outline_list_no_match, (ViewGroup) this, false);
        this.f = frameLayout;
        this.l = "";
        SearchView searchView = new SearchView(context);
        this.g = searchView;
        searchView.setId(R.id.pspdf__outline_list_search_view);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint(no.a(context, R.string.pspdf__search_outline_hint, searchView));
        searchView.setImeOptions(3);
        searchView.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) searchView.findViewById(androidx.appcompat.R.id.search_edit_frame);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0f);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        searchView.findViewById(androidx.appcompat.R.id.search_plate).setBackgroundColor(0);
        View viewFindViewById = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        viewFindViewById.setPadding(0, 0, viewFindViewById.getPaddingRight(), 0);
        View viewInflate2 = LayoutInflater.from(context).inflate(R.layout.pspdf__outline_list_divider, (ViewGroup) this, false);
        addView(searchView, new LinearLayout.LayoutParams(-1, -2));
        addView(viewInflate2);
        addView(viewInflate, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapter(List<OutlineElement> list) {
        this.n = false;
        setOutlineListViewLoading(true);
        jt jtVar = new jt(getContext(), list, this.d, new jt.b() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.internal.jt.b
            public final void a(OutlineElement outlineElement) {
                this.f$0.a(outlineElement);
            }
        }, new jt.c() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.jt.c
            public final void a(boolean z) {
                this.f$0.a(z);
            }
        }, new jt.a() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.internal.jt.a
            public final void a() {
                this.f$0.e();
            }
        }, this.l);
        this.k = jtVar;
        ot otVar = this.j;
        if (otVar != null) {
            jtVar.k = otVar.c;
            jtVar.m = otVar.j;
        }
        jtVar.l = this.i;
        this.d.setAdapter(jtVar);
    }

    private void setOutlineListViewLoading(boolean z) {
        this.e.setVisibility(z ? 0 : 8);
        this.g.setVisibility(z ? 8 : 0);
        this.d.setVisibility(z ? 8 : 0);
    }

    public final void a(String str) {
        if ((this.m || !str.isEmpty()) && this.k != null) {
            boolean zIsEmpty = str.isEmpty();
            this.m = !zIsEmpty;
            if (!zIsEmpty) {
                if (this.p == null) {
                    this.p = this.k.a(false);
                }
                this.l = str;
                if (this.n) {
                    this.k.a(str);
                    return;
                }
                return;
            }
            this.l = "";
            jt jtVar = this.k;
            ArrayList<Integer> arrayList = this.p;
            jtVar.o = false;
            jtVar.g.a(false);
            if (jtVar.b.size() > 0) {
                int size = jtVar.b.size();
                jtVar.b.clear();
                jtVar.c.clear();
                if (jtVar.a) {
                    jtVar.notifyItemRangeRemoved(0, size);
                }
            }
            jtVar.a(jtVar.b.size(), jtVar.n);
            jtVar.a((List<Integer>) arrayList, false);
            this.p = null;
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void c() {
        if (this.k != null) {
            return;
        }
        PdfOutlineView.DocumentOutlineProvider documentOutlineProvider = this.t;
        if (documentOutlineProvider == null && this.s != null) {
            documentOutlineProvider = new PdfOutlineView.DocumentOutlineProvider() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.ui.PdfOutlineView.DocumentOutlineProvider
                public final Single getOutlineElements() {
                    return this.f$0.d();
                }
            };
        }
        if (documentOutlineProvider != null) {
            yz.a(this.r);
            setOutlineListViewLoading(true);
            this.r = documentOutlineProvider.getOutlineElements().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda1
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.setAdapter((List) obj);
                }
            });
        }
    }

    public final /* synthetic */ Single d() {
        return this.s.getOutlineAsync();
    }

    public final void e() {
        jt jtVar;
        jt jtVar2;
        this.n = true;
        setOutlineListViewLoading(false);
        ArrayList<Integer> arrayList = this.o;
        if (arrayList != null && !this.m && (jtVar2 = this.k) != null) {
            jtVar2.a((List<Integer>) arrayList, true);
        }
        if (!this.m || this.l.isEmpty() || (jtVar = this.k) == null) {
            return;
        }
        jtVar.a(this.l);
    }

    public PdfOutlineView.DocumentOutlineProvider getDocumentOutlineProvider() {
        return this.t;
    }

    @Override // com.pspdfkit.internal.nt
    public int getTabButtonId() {
        return R.id.pspdf__menu_pdf_outline_view_outline;
    }

    @Override // com.pspdfkit.internal.nt
    public String getTitle() {
        return no.a(getContext(), R.string.pspdf__activity_menu_outline, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        PublishSubject publishSubjectCreate = PublishSubject.create();
        this.g.setOnQueryTextListener(new a(publishSubjectCreate));
        this.q = publishSubjectCreate.debounce(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.mt$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.a((String) obj);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.setOnQueryTextListener(null);
        yz.a(this.q);
        this.q = null;
        yz.a(this.r);
        this.r = null;
        this.t = null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        ArrayList<Integer> arrayList = bVar.a;
        if (arrayList != null) {
            this.o = arrayList;
        }
        this.p = bVar.b;
        this.m = bVar.c;
        this.l = bVar.d;
        jt jtVar = this.k;
        if (jtVar != null) {
            jtVar.a((List<Integer>) arrayList, true);
            if (this.m) {
                a(this.l);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.b = this.p;
        bVar.c = this.m;
        bVar.d = this.l;
        jt jtVar = this.k;
        if (jtVar == null || !this.n) {
            bVar.a = this.o;
            return bVar;
        }
        ArrayList<Integer> arrayListA = jtVar.a(true);
        this.o = arrayListA;
        bVar.a = arrayListA;
        this.k.notifyDataSetChanged();
        return bVar;
    }

    public void setDocumentOutlineProvider(PdfOutlineView.DocumentOutlineProvider documentOutlineProvider) {
        if (this.t == documentOutlineProvider) {
            return;
        }
        this.t = documentOutlineProvider;
        this.k = null;
        if (this.b) {
            c();
        }
    }

    public void setShowPageLabels(boolean z) {
        this.i = z;
        jt jtVar = this.k;
        if (jtVar != null) {
            jtVar.l = z;
            jtVar.notifyDataSetChanged();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(lm lmVar, PdfConfiguration pdfConfiguration) {
        if (lmVar == null || this.s == lmVar) {
            return;
        }
        this.s = lmVar;
        this.k = null;
        if (this.b) {
            c();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(ot otVar) {
        this.j = otVar;
        setBackgroundColor(otVar.a);
        int i = otVar.b;
        if (i != 0) {
            this.d.setBackgroundResource(i);
        }
        jt jtVar = this.k;
        if (jtVar != null) {
            jtVar.k = otVar.c;
            jtVar.m = otVar.j;
        }
        ((EditText) this.g.findViewById(androidx.appcompat.R.id.search_src_text)).setTextColor(otVar.c);
        ((TextView) this.f.findViewById(R.id.pspdf__outline_no_match_text)).setTextColor(ColorUtils.compositeColors(ColorUtils.setAlphaComponent(otVar.c, 100), -1));
    }

    public final /* synthetic */ void a(boolean z) {
        this.d.setVisibility(z ? 8 : 0);
        this.f.setVisibility(z ? 0 : 8);
    }

    public final void a(OutlineElement outlineElement) {
        Action action = outlineElement.getAction();
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putString("action_type", action != null ? action.getType().name() : AbstractJsonLexerKt.NULL);
        i0VarA.a(Analytics.Event.TAP_OUTLINE_ELEMENT_IN_OUTLINE_LIST, bundleA);
        this.h.a(this, outlineElement);
        nt.a aVar = this.a;
        if (aVar != null) {
            aVar.hide();
        } else {
            PdfLog.e("OutlinePagerBaseView", "onHideListener is null! This shouldn't happen.\nMake sure you have called `PdfOutlineView#setDocument()` whenever a new document is loaded.", new Object[0]);
        }
    }
}
