package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.ui.unit.Density;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class y2 {
    public final float a;
    public final float b;
    public final long c;
    public final float d;
    public final float e;
    public final long f;

    public y2(Context context, Density density) {
        context.getClass();
        density.getClass();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__annotation_list_item_height);
        density.getClass();
        density.mo750toDpu2uoSUM(dimension);
        this.a = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__annotation_list_bottom_bar_height));
        this.b = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__annotation_list_bottom_bar_elevation));
        this.c = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__annotation_list_item_title_text_size));
        this.d = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__annotation_list_item_padding));
        this.e = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__annotation_list_footer_padding));
        this.f = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__annotation_list_header_text_size));
    }
}
