package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.internal.views.utils.recyclerview.AutoSpanGridLayoutManager;
import com.pspdfkit.ui.actionmenu.ActionMenuItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends FrameLayout {
    public static final int[] k = R.styleable.pspdf__ActionMenu;
    public static final int l = R.attr.pspdf__actionMenuStyle;
    public static final int m = R.style.PSPDFKit_ActionMenu;
    public final f a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final wc f;
    public final RecyclerView g;
    public final e h;
    public final RecyclerView i;
    public final e j;

    /* JADX WARN: Illegal instructions before constructor call */
    public h(f fVar) {
        Context context = fVar.getContext();
        Context context2 = fVar.getContext();
        int i = l;
        int i2 = m;
        super(new ContextThemeWrapper(context, f60.b(context2, i, i2)));
        this.a = fVar;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.pspdf__action_menu_layout, (ViewGroup) this, false);
        addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
        Context context3 = getContext();
        int i3 = f.e;
        TypedArray typedArrayObtainStyledAttributes = context3.getTheme().obtainStyledAttributes(null, k, i, i2);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ActionMenu_pspdf__backgroundColor, -1);
        this.b = color;
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ActionMenu_pspdf__labelColor, ContextCompat.getColor(getContext(), R.color.pspdf__inverseSurfaceLight));
        this.c = color2;
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ActionMenu_pspdf__fixedActionsPanelBackgroundColor, ContextCompat.getColor(getContext(), R.color.pspdf__onSecondaryLight));
        this.d = color3;
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ActionMenu_pspdf__fixedActionsIconBackground, f60.a(getContext(), androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight));
        this.e = color4;
        typedArrayObtainStyledAttributes.recycle();
        yq yqVar = new yq(getContext());
        wc wcVar = new wc(getContext(), yqVar);
        this.f = wcVar;
        viewGroup.addView(wcVar, 0);
        wcVar.setTitle(R.string.pspdf__share);
        float cornerRadius = yqVar.getCornerRadius() + 2;
        a80.a(viewGroup, color, new float[]{cornerRadius, cornerRadius, cornerRadius, cornerRadius, 0.0f, 0.0f, 0.0f, 0.0f});
        e eVar = new e(new g(this), color4, color2);
        this.h = eVar;
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.pspdf__fixed_menu_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new AutoSpanGridLayoutManager(getContext(), a80.a(getContext(), 120)));
        recyclerView.setAdapter(eVar);
        this.g = recyclerView;
        recyclerView.setBackgroundColor(color3);
        e eVar2 = new e(new g(this), 0, color2);
        this.j = eVar2;
        RecyclerView recyclerView2 = (RecyclerView) viewGroup.findViewById(R.id.pspdf__standard_menu_recycler_view);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(new AutoSpanGridLayoutManager(getContext(), a80.a(getContext(), 120)));
        recyclerView2.setAdapter(eVar2);
        this.i = recyclerView2;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setFitsSystemWindows(true);
    }

    public final void a(List<ActionMenuItem> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ActionMenuItem actionMenuItem : list) {
            if (actionMenuItem.getItemType() == ActionMenuItem.MenuItemType.FIXED) {
                arrayList.add(actionMenuItem);
            } else {
                arrayList2.add(actionMenuItem);
            }
        }
        e eVar = this.h;
        int size = eVar.b.size();
        eVar.b.clear();
        eVar.b.addAll(arrayList);
        eVar.notifyItemRangeRemoved(0, size);
        eVar.notifyItemRangeInserted(0, arrayList.size());
        this.g.setVisibility(arrayList.isEmpty() ? 8 : 0);
        e eVar2 = this.j;
        int size2 = eVar2.b.size();
        eVar2.b.clear();
        eVar2.b.addAll(arrayList2);
        eVar2.notifyItemRangeRemoved(0, size2);
        eVar2.notifyItemRangeInserted(0, arrayList2.size());
        this.i.setVisibility(arrayList2.isEmpty() ? 8 : 0);
    }
}
