package com.pspdfkit.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ch extends RecyclerView.Adapter<a> {
    public final Context a;
    public final RecyclerView b;
    public final FontPickerInspectorView.FontPickerListener c;
    public final List<Font> d;
    public Font e;
    public final LayoutInflater f;

    public static final class a extends RecyclerView.ViewHolder {
        public final TextView a;
        public final View b;
        public final ImageView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.pspdf__font_view);
            viewFindViewById.getClass();
            this.a = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.pspdf__font_checkmark);
            viewFindViewById2.getClass();
            this.b = viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.pspdf__fontname_image);
            viewFindViewById3.getClass();
            this.c = (ImageView) viewFindViewById3;
        }
    }

    public ch(Context context, RecyclerView recyclerView, List<? extends Font> list, Font font, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        context.getClass();
        recyclerView.getClass();
        list.getClass();
        font.getClass();
        fontPickerListener.getClass();
        this.a = context;
        this.b = recyclerView;
        this.c = fontPickerListener;
        this.d = CollectionsKt.toMutableList((Collection) list);
        this.e = font;
        this.f = LayoutInflater.from(context);
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(Font font) {
        return font.getDefaultTypeface() != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View viewInflate = this.f.inflate(R.layout.pspdf__view_inspector_font_list_item, viewGroup, false);
        viewInflate.getClass();
        return new a(viewInflate);
    }

    public static final void a(ch chVar, Font font, a aVar, View view) {
        chVar.c.onFontSelected(font);
        int iIndexOf = chVar.d.indexOf(chVar.e);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = chVar.b.findViewHolderForAdapterPosition(iIndexOf);
        a aVar2 = viewHolderFindViewHolderForAdapterPosition instanceof a ? (a) viewHolderFindViewHolderForAdapterPosition : null;
        if (aVar2 != null) {
            aVar2.b.setVisibility(4);
            if (chVar.a(iIndexOf)) {
                try {
                    chVar.d.remove(iIndexOf);
                    chVar.notifyItemRemoved(iIndexOf);
                } catch (Exception unused) {
                }
            }
        } else {
            chVar.notifyItemChanged(iIndexOf);
        }
        chVar.e = font;
        aVar.b.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final a aVar, int i) {
        aVar.getClass();
        final Font font = this.d.get(i);
        aVar.a.setTypeface(font.getDefaultTypeface());
        boolean zA = a(font);
        a(aVar, zA, font);
        aVar.b.setVisibility(Intrinsics.areEqual(font, this.e) ? 0 : 4);
        if (zA) {
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ch$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ch.a(this.f$0, font, aVar, view);
                }
            });
        }
        aVar.itemView.setTag(font);
    }

    public String a(View view, Font font) {
        view.getClass();
        String strA = no.a(this.a, R.string.pspdf__font_missing, view, font.getName());
        strA.getClass();
        return strA;
    }

    public void a(a aVar, boolean z, Font font) {
        aVar.getClass();
        TextView textView = aVar.a;
        if (z) {
            textView.setText(font.getName());
            aVar.a.setAlpha(1.0f);
            aVar.itemView.setEnabled(true);
        } else {
            textView.setText(a(textView, font));
            aVar.a.setAlpha(0.5f);
            aVar.itemView.setEnabled(false);
        }
    }
}
