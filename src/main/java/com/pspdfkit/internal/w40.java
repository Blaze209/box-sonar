package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.pspdfkit.R;
import com.pspdfkit.internal.annotations.note.ui.NoteEditorStyleBoxDetailsView;

/* JADX INFO: loaded from: classes3.dex */
public final class w40 extends rs<Object> {
    public final LinearLayout a;
    public final View b;
    public final LinearLayout c;
    public final ImageView d;
    public final TextView e;
    public final ImageView f;
    public final NoteEditorStyleBoxDetailsView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w40(View view) {
        super(view);
        view.getClass();
        View viewFindViewById = view.findViewById(R.id.pspdf__style_box_card);
        viewFindViewById.getClass();
        this.a = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.pspdf__note_item_style_box_header);
        viewFindViewById2.getClass();
        this.b = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.pspdf__note_item_style_box_detail_view_root);
        viewFindViewById3.getClass();
        this.c = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.pspdf__note_item_style_box_preview_image);
        viewFindViewById4.getClass();
        this.d = (ImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.pspdf__note_item_style_box_current_style);
        viewFindViewById5.getClass();
        this.e = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.pspdf__note_item_style_box_chevron);
        viewFindViewById6.getClass();
        this.f = (ImageView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.pspdf__note_item_style_box_details);
        viewFindViewById7.getClass();
        this.g = (NoteEditorStyleBoxDetailsView) viewFindViewById7;
    }

    public final void a(us usVar, final is isVar) {
        usVar.getClass();
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.w40$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w40.a(isVar, view);
            }
        });
        String str = usVar.d;
        if (str != null) {
            Context context = this.d.getContext();
            Integer num = ww.l.get(str);
            Drawable drawableB = a80.b(context, num != null ? num.intValue() : ww.m);
            Integer num2 = usVar.f;
            if (drawableB != null && num2 != null) {
                ColorDrawable colorDrawable = new ColorDrawable(num2.intValue());
                int iCompositeColors = ColorUtils.compositeColors(ContextCompat.getColor(context, R.color.pspdf__onSurfaceVariantLight), num2.intValue());
                Drawable drawableMutate = drawableB.mutate();
                drawableMutate.setTint(iCompositeColors);
                drawableMutate.setTintMode(PorterDuff.Mode.SRC_ATOP);
                this.d.setImageDrawable(drawableMutate);
                this.d.setContentDescription(no.a(context, ww.a(str), null));
                a80.a(this.d, colorDrawable);
            }
        }
        this.e.setText(usVar.e);
        NoteEditorStyleBoxDetailsView noteEditorStyleBoxDetailsView = this.g;
        noteEditorStyleBoxDetailsView.removeAllViews();
        noteEditorStyleBoxDetailsView.a(usVar.b, usVar.a);
        noteEditorStyleBoxDetailsView.setAdapterCallbacks(isVar);
        noteEditorStyleBoxDetailsView.setSelectedIconItem(str);
        this.f.animate().rotation(usVar.c ? 180.0f : 0.0f);
        TransitionManager.beginDelayedTransition(this.a);
        this.c.setVisibility(usVar.c ? 0 : 8);
    }

    public static final void a(es esVar, View view) {
        if (esVar != null) {
            esVar.d();
        }
    }
}
