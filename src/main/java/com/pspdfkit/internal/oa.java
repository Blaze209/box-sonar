package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.views.FontPickerInspectorView;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class oa extends ch {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oa(Context context, RecyclerView recyclerView, List<? extends Font> list, Font font, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        super(context, recyclerView, list, font, fontPickerListener);
        context.getClass();
        recyclerView.getClass();
        list.getClass();
        font.getClass();
        fontPickerListener.getClass();
    }

    @Override // com.pspdfkit.internal.ch
    public final boolean a(Font font) {
        return (font instanceof dm) || font.getDefaultTypeface() != null;
    }

    @Override // com.pspdfkit.internal.ch
    public final void a(ch.a aVar, boolean z, Font font) {
        aVar.getClass();
        super.a(aVar, z, font);
        boolean z2 = font instanceof dm;
        TextView textView = aVar.a;
        if (z2) {
            textView.setVisibility(8);
            Drawable drawable = ContextCompat.getDrawable(this.a, ((dm) font).a);
            if (drawable != null) {
                ImageView imageView = aVar.c;
                imageView.setVisibility(0);
                int currentTextColor = aVar.a.getCurrentTextColor();
                Drawable drawableWrap = DrawableCompat.wrap(drawable);
                drawableWrap.getClass();
                DrawableCompat.setTint(drawableWrap, currentTextColor);
                imageView.setImageDrawable(drawableWrap);
            }
        } else {
            textView.setVisibility(0);
            aVar.c.setVisibility(8);
            if (!z) {
                aVar.a.setTypeface(null, 2);
            }
        }
        aVar.b.setAlpha(aVar.a.getAlpha());
    }

    @Override // com.pspdfkit.internal.ch
    public final boolean a(int i) {
        Font font = (Font) CollectionsKt.getOrNull(this.d, i);
        if (font != null) {
            return !((font instanceof dm) || font.getDefaultTypeface() != null);
        }
        return false;
    }

    @Override // com.pspdfkit.internal.ch
    public final String a(View view, Font font) {
        view.getClass();
        return font.getName();
    }
}
