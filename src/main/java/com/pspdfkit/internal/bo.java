package com.pspdfkit.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.ui.inspector.views.ContentEditingLineSpacingPickerView;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class bo extends RecyclerView.Adapter<a> {
    public final Context a;
    public final ContentEditingLineSpacingPickerView b;
    public Float c;
    public final Float d;
    public final ContentEditingLineSpacingPickerView.LineSpacingPickerListener e;
    public final LayoutInflater f;
    public final Lazy g;
    public final DecimalFormat h;

    public static final class a extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.pspdf__font_view);
            viewFindViewById.getClass();
            this.a = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.pspdf__font_checkmark);
            viewFindViewById2.getClass();
            this.b = (ImageView) viewFindViewById2;
        }

        public final void a(boolean z) {
            this.itemView.setEnabled(z);
            TextView textView = this.a;
            if (z) {
                textView.setTypeface(null, 0);
                this.a.setAlpha(1.0f);
                this.b.setAlpha(1.0f);
            } else {
                textView.setTypeface(null, 2);
                this.a.setAlpha(0.5f);
                this.b.setAlpha(0.5f);
            }
        }
    }

    public bo(Context context, ContentEditingLineSpacingPickerView contentEditingLineSpacingPickerView, final List list, Float f, Float f2, ContentEditingLineSpacingPickerView.LineSpacingPickerListener lineSpacingPickerListener) {
        context.getClass();
        list.getClass();
        lineSpacingPickerListener.getClass();
        this.a = context;
        this.b = contentEditingLineSpacingPickerView;
        this.c = f;
        this.d = f2;
        this.e = lineSpacingPickerListener;
        this.f = LayoutInflater.from(context);
        this.g = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.bo$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return bo.a(this.f$0, list);
            }
        });
        this.h = new DecimalFormat("#.##");
    }

    public static final List a(bo boVar, List list) {
        Float f = boVar.d;
        if (f != null) {
            list = CollectionsKt.plus((Collection) CollectionsKt.listOf(f), (Iterable) list);
        }
        return CollectionsKt.toMutableList((Collection) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((List) this.g.getValue()).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View viewInflate = this.f.inflate(R.layout.pspdf__view_inspector_font_list_item, viewGroup, false);
        viewInflate.getClass();
        return new a(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final a aVar, int i) {
        aVar.getClass();
        final float fFloatValue = ((Number) ((List) this.g.getValue()).get(i)).floatValue();
        if (Intrinsics.areEqual(fFloatValue, this.c) || (Intrinsics.areEqual(fFloatValue, this.d) && i == 0)) {
            aVar.b.setVisibility(0);
        } else {
            aVar.b.setVisibility(4);
        }
        aVar.a.setText(this.h.format(Float.valueOf(fFloatValue)));
        if (fFloatValue == 1.0f) {
            no.a(this.a, R.string.pspdf__content_editing_line_spacing_single, null);
        } else if (fFloatValue == 2.0f) {
            no.a(this.a, R.string.pspdf__content_editing_line_spacing_double, null);
        } else {
            this.h.format(Float.valueOf(fFloatValue));
        }
        aVar.a(!Intrinsics.areEqual(fFloatValue, this.d));
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.bo$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bo.a(this.f$0, fFloatValue, aVar, view);
            }
        });
        aVar.itemView.setTag(Float.valueOf(fFloatValue));
    }

    public static final void a(bo boVar, float f, a aVar, View view) {
        boVar.e.onLineSpacingSelected(f);
        int iIndexOf = boVar.c == null ? 0 : CollectionsKt.indexOf((List<? extends Float>) boVar.g.getValue(), boVar.c);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = boVar.b.findViewHolderForAdapterPosition(iIndexOf);
        a aVar2 = viewHolderFindViewHolderForAdapterPosition instanceof a ? (a) viewHolderFindViewHolderForAdapterPosition : null;
        if (aVar2 != null) {
            aVar2.b.setVisibility(4);
            if (Intrinsics.areEqual(((Number) ((List) boVar.g.getValue()).get(iIndexOf)).floatValue(), boVar.d)) {
                try {
                    ((List) boVar.g.getValue()).remove(iIndexOf);
                    boVar.notifyItemRemoved(iIndexOf);
                } catch (Exception unused) {
                }
            }
        } else {
            boVar.notifyItemChanged(iIndexOf);
        }
        boVar.c = Float.valueOf(f);
        aVar.b.setVisibility(0);
    }
}
