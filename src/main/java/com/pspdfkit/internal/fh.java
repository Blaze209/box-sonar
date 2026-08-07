package com.pspdfkit.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.ui.inspector.views.ContentEditingFontSizesPickerView;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class fh extends RecyclerView.Adapter<a> {
    public final ContentEditingFontSizesPickerView a;
    public Integer b;
    public final String c;
    public final FontPickerInspectorView.FontSizePickerListener d;
    public final LayoutInflater e;
    public final List<Integer> f;

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

    public fh(Context context, ContentEditingFontSizesPickerView contentEditingFontSizesPickerView, List list, Integer num, String str, FontPickerInspectorView.FontSizePickerListener fontSizePickerListener) {
        context.getClass();
        list.getClass();
        fontSizePickerListener.getClass();
        this.a = contentEditingFontSizesPickerView;
        this.b = num;
        this.c = str;
        this.d = fontSizePickerListener;
        this.e = LayoutInflater.from(context);
        this.f = CollectionsKt.toMutableList((Collection) (str != null ? CollectionsKt.plus((Collection) CollectionsKt.listOf(-1), (Iterable) list) : list));
    }

    public static final void a(fh fhVar, int i, a aVar, View view) {
        fhVar.d.onFontSelected(Integer.valueOf(i));
        Integer num = fhVar.b;
        int iIndexOf = num == null ? 0 : CollectionsKt.indexOf((List<? extends Integer>) fhVar.f, num);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = fhVar.a.findViewHolderForAdapterPosition(iIndexOf);
        a aVar2 = viewHolderFindViewHolderForAdapterPosition instanceof a ? (a) viewHolderFindViewHolderForAdapterPosition : null;
        if (aVar2 != null) {
            aVar2.b.setVisibility(4);
            if (fhVar.f.get(iIndexOf).intValue() == -1) {
                try {
                    fhVar.f.remove(iIndexOf);
                    fhVar.notifyItemRemoved(iIndexOf);
                } catch (Exception unused) {
                }
            }
        } else {
            fhVar.notifyItemChanged(iIndexOf);
        }
        fhVar.b = Integer.valueOf(i);
        aVar.b.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View viewInflate = this.e.inflate(R.layout.pspdf__view_inspector_font_list_item, viewGroup, false);
        viewInflate.getClass();
        return new a(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final a aVar, int i) {
        aVar.getClass();
        final int iIntValue = this.f.get(i).intValue();
        Integer num = this.b;
        if ((num != null && iIntValue == num.intValue()) || (iIntValue == -1 && i == 0)) {
            aVar.b.setVisibility(0);
        } else {
            aVar.b.setVisibility(4);
        }
        aVar.a.setText(iIntValue == -1 ? this.c : String.valueOf(iIntValue));
        aVar.a(iIntValue != -1);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.fh$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                fh.a(this.f$0, iIntValue, aVar, view);
            }
        });
        aVar.itemView.setTag(Integer.valueOf(iIntValue));
    }
}
