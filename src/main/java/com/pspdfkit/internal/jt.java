package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.document.OutlineElement;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class jt extends cr {
    public final RecyclerView d;
    public final b f;
    public final c g;
    public final a h;
    public final LayoutInflater i;
    public final int j;
    public int k;
    public boolean l;
    public Disposable p;
    public int m = 0;
    public boolean o = false;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final ArrayList<e> n = new ArrayList<>();

    public interface a {
        void a();
    }

    public interface b {
        void a(OutlineElement outlineElement);
    }

    public interface c {
        void a(boolean z);
    }

    public static class d extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final TextView c;
        public final View d;

        public d(View view, int i) {
            super(view);
            this.d = view;
            this.b = (TextView) view.findViewById(R.id.pspdf__outline_text);
            this.c = (TextView) view.findViewById(R.id.pspdf__outline_page_number);
            ImageView imageView = (ImageView) view.findViewById(R.id.pspdf__outline_expand_group);
            this.a = imageView;
            imageView.setBackgroundColor(0);
            if (i != 0) {
                Drawable drawable = imageView.getDrawable();
                drawable.getClass();
                Drawable drawableWrap = DrawableCompat.wrap(drawable);
                drawableWrap.getClass();
                DrawableCompat.setTint(drawableWrap, i);
                imageView.setImageDrawable(drawableWrap);
            }
        }
    }

    public static class e implements cr.a {
        public final OutlineElement a;
        public final int b;
        public final ArrayList c;
        public int d;
        public final e e;

        public e(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.e = eVar.e;
            this.d = 0;
        }

        @Override // com.pspdfkit.internal.cr.a
        public final boolean a() {
            return this.d > 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.b == eVar.b && this.a.equals(eVar.a)) {
                e eVar2 = this.e;
                e eVar3 = eVar.e;
                if (eVar2 == null ? eVar3 == null : eVar2.equals(eVar3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.pspdfkit.internal.cr.a
        public final List<e> getChildren() {
            return this.c;
        }

        public final int hashCode() {
            int iHashCode = (this.a.hashCode() + (this.b * 31)) * 31;
            e eVar = this.e;
            return iHashCode + (eVar != null ? eVar.hashCode() : 0);
        }

        @Override // com.pspdfkit.internal.cr.a
        public final void a(int i) {
            this.d = i;
        }

        public e(OutlineElement outlineElement, int i, e eVar) {
            this.a = outlineElement;
            this.b = i;
            this.c = new ArrayList(outlineElement.getChildren().size());
            this.e = eVar;
            Iterator<OutlineElement> it = outlineElement.getChildren().iterator();
            while (it.hasNext()) {
                this.c.add(new e(it.next(), this.b + 1, this));
            }
        }
    }

    public jt(Context context, List<OutlineElement> list, RecyclerView recyclerView, b bVar, c cVar, a aVar, String str) {
        this.i = (LayoutInflater) context.getSystemService("layout_inflater");
        this.j = (int) un.a(context, 1, 16);
        this.d = recyclerView;
        this.f = bVar;
        this.g = cVar;
        this.h = aVar;
        a(list, str);
    }

    public final void a(ArrayList arrayList) throws Throwable {
        if (this.b.size() > 0) {
            int size = this.b.size();
            this.b.clear();
            this.c.clear();
            if (this.a) {
                notifyItemRangeRemoved(0, size);
            }
        }
        a(this.b.size(), arrayList);
        this.g.a(arrayList.isEmpty());
    }

    public final void b(e eVar, ArrayList<e> arrayList) {
        this.n.add(eVar);
        arrayList.add(eVar);
        ArrayList arrayList2 = eVar.c;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            b((e) obj, arrayList);
        }
    }

    public final void c(View view, View view2) {
        int childLayoutPosition = this.d.getChildLayoutPosition(view);
        if (childLayoutPosition == -1 || childLayoutPosition < 0 || childLayoutPosition >= this.b.size()) {
            return;
        }
        this.f.a(((e) ((cr.a) this.b.get(childLayoutPosition))).a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return (((cr.a) this.b.get(i)).a() || ((cr.a) this.b.get(i)).getChildren().size() != 0) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                throw new IllegalStateException("unknown viewType");
            }
            a(viewHolder, (e) ((cr.a) this.b.get(i))).a.setVisibility(4);
            return;
        }
        e eVar = (e) ((cr.a) this.b.get(i));
        d dVarA = a(viewHolder, eVar);
        dVarA.a.setClickable(!this.o);
        boolean zA = eVar.a();
        ImageView imageView = dVarA.a;
        if (zA) {
            imageView.setRotation(180.0f);
        } else {
            imageView.setRotation(0.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0 && i != 1) {
            throw new IllegalStateException("unknown viewType");
        }
        final View viewInflate = this.i.inflate(R.layout.pspdf__outline_pager_outline_list_item, viewGroup, false);
        d dVar = new d(viewInflate, this.m);
        viewInflate.findViewById(R.id.pspdf__outline_expand_group).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(viewInflate, view);
            }
        });
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(viewInflate, view);
            }
        });
        return dVar;
    }

    public final void b(final View view, final View view2) {
        if (!this.o && this.e.compareAndSet(false, true)) {
            int childLayoutPosition = this.d.getChildLayoutPosition(view);
            if (childLayoutPosition >= 0 && childLayoutPosition < this.b.size()) {
                if (((cr.a) this.b.get(childLayoutPosition)).a()) {
                    cr.a aVar = (cr.a) this.b.get(childLayoutPosition);
                    if (aVar.a()) {
                        List<? extends cr.a> listRemove = this.c.remove(aVar);
                        aVar.a(0);
                        a(childLayoutPosition + 1, listRemove);
                    }
                } else {
                    a(childLayoutPosition);
                }
            }
            view2.animate().setDuration(150L).rotation(view2.getRotation() == 180.0f ? 0.0f : 180.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(view, view2);
                }
            });
        }
    }

    public final void a(final List<OutlineElement> list, final String str) {
        g60 g60VarC;
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.a(list);
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        singleFromCallable.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(str, (Pair) obj);
            }
        });
    }

    public final ArrayList b(String str) throws Exception {
        String str2;
        this.o = true;
        ArrayList arrayList = new ArrayList();
        ArrayList<e> arrayList2 = this.n;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            e eVar = arrayList2.get(i);
            i++;
            e eVar2 = eVar;
            String title = eVar2.a.getTitle();
            if (title != null) {
                int length = str.length();
                if (length == 0) {
                    str2 = str;
                } else {
                    char lowerCase = Character.toLowerCase(str.charAt(0));
                    char upperCase = Character.toUpperCase(str.charAt(0));
                    int length2 = title.length() - length;
                    while (true) {
                        if (length2 < 0) {
                            str2 = str;
                        } else {
                            char cCharAt = title.charAt(length2);
                            if (cCharAt == lowerCase || cCharAt == upperCase) {
                                str2 = str;
                                if (title.regionMatches(true, length2, str2, 0, length)) {
                                }
                            } else {
                                str2 = str;
                            }
                            length2--;
                            str = str2;
                        }
                    }
                }
                a(eVar2.e, arrayList);
                e eVar3 = new e(eVar2);
                ArrayList arrayList3 = eVar3.c;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    eVar3.d = eVar3.c.size();
                }
                arrayList.add(eVar3);
            } else {
                str2 = str;
            }
            str = str2;
        }
        return arrayList;
    }

    public final Pair a(List list) throws Exception {
        ArrayList arrayList;
        ArrayList<e> arrayList2 = new ArrayList<>();
        HashMap map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            b(new e((OutlineElement) list.get(i), 0, null), arrayList2);
        }
        for (int size = this.n.size() - 1; size >= 0; size--) {
            e eVar = this.n.get(size);
            if (!eVar.a.isExpanded() && (arrayList = eVar.c) != null && !arrayList.isEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (int size2 = eVar.c.size() - 1; size2 >= 0; size2--) {
                    arrayList4.add((e) eVar.c.get(size2));
                }
                int i2 = 0;
                while (!arrayList4.isEmpty()) {
                    e eVar2 = (e) arrayList4.remove(arrayList4.size() - 1);
                    arrayList3.add(eVar2);
                    i2++;
                    ArrayList arrayList5 = eVar2.c;
                    if (arrayList5 != null && !arrayList5.isEmpty() && !eVar2.a()) {
                        for (int size3 = eVar2.c.size() - 1; size3 >= 0; size3--) {
                            arrayList4.add((e) eVar2.c.get(size3));
                        }
                    }
                    arrayList2.remove(eVar2);
                }
                map.put(eVar, arrayList3);
                eVar.d = i2;
            }
        }
        return new Pair(arrayList2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, Pair pair) throws Throwable {
        if (str.isEmpty()) {
            Collection<? extends cr.a> collection = (Collection) pair.first;
            HashMap map = (HashMap) pair.second;
            a(this.b.size(), collection);
            this.c.putAll(map);
        }
        a(str);
        this.h.a();
    }

    public final void a(View view, View view2) {
        int childLayoutPosition = this.d.getChildLayoutPosition(view);
        if (childLayoutPosition > 0 && childLayoutPosition < this.b.size()) {
            view2.setRotation(((cr.a) this.b.get(childLayoutPosition)).a() ? 180.0f : 0.0f);
        }
        this.e.set(false);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
    public final d a(RecyclerView.ViewHolder viewHolder, e eVar) {
        int color;
        String strValueOf;
        int color2;
        d dVar = (d) viewHolder;
        dVar.b.setText(eVar.a.getTitle());
        dVar.c.setText(eVar.a.getPageLabel());
        TextView textView = dVar.b;
        if (eVar.a.getColor() != -16777216) {
            color = eVar.a.getColor();
        } else {
            color = this.k;
        }
        textView.setTextColor(color);
        dVar.b.setTypeface(eVar.a.getTypeface(), eVar.a.getStyle());
        Action action = eVar.a.getAction();
        if (action != null) {
            ActionType type = action.getType();
            ActionType actionType = ActionType.GOTO;
            if (type == actionType) {
                dVar.c.setVisibility(0);
                TextView textView2 = dVar.c;
                OutlineElement outlineElement = eVar.a;
                Action action2 = outlineElement.getAction();
                if (action2 == null || action2.getType() != actionType) {
                    strValueOf = null;
                } else if (outlineElement.getPageLabel() != null && this.l) {
                    strValueOf = outlineElement.getPageLabel();
                } else {
                    strValueOf = String.valueOf(((GoToAction) action2).getPageIndex() + 1);
                }
                textView2.setText(strValueOf);
                TextView textView3 = dVar.c;
                if (eVar.a.getColor() != -16777216) {
                    color2 = eVar.a.getColor();
                } else {
                    color2 = this.k;
                }
                textView3.setTextColor(color2);
                dVar.c.setTypeface(eVar.a.getTypeface(), eVar.a.getStyle());
            } else {
                dVar.c.setVisibility(8);
            }
        } else {
            dVar.c.setVisibility(8);
        }
        int i = eVar.b;
        if (i == 0) {
            dVar.d.setPadding(0, 0, 0, 0);
            return dVar;
        }
        dVar.d.setPadding(this.j * i, 0, 0, 0);
        return dVar;
    }

    public final void a(final String str) {
        yz.a(this.p);
        if (str.isEmpty()) {
            this.g.a(false);
            return;
        }
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.b(str);
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        this.p = singleFromCallable.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.jt$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((ArrayList) obj);
            }
        });
    }

    public static void a(e eVar, ArrayList arrayList) {
        if (eVar == null) {
            return;
        }
        a(eVar.e, arrayList);
        int iIndexOf = arrayList.indexOf(eVar);
        if (iIndexOf == -1) {
            arrayList.add(new e(eVar));
        } else {
            ((e) arrayList.get(iIndexOf)).d = 0;
        }
    }
}
