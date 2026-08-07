package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class g8 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final long j;
    public final long k;

    public g8(Context context, Density density) {
        context.getClass();
        density.getClass();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__bookmark_page_image_height);
        density.getClass();
        float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(dimension);
        this.a = fMo750toDpu2uoSUM;
        this.b = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_page_image_width));
        this.c = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_bottom_bar_height));
        this.d = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_bottom_bar_elevation));
        this.e = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_horizontal_padding));
        float fMo750toDpu2uoSUM2 = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_vertical_padding));
        this.f = fMo750toDpu2uoSUM2;
        this.g = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_min_height));
        this.h = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_elevation));
        this.i = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_small_padding));
        this.j = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_title_font_size));
        this.k = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__bookmark_item_subtitle_font_size));
        Dp.m9687constructorimpl(Dp.m9687constructorimpl(fMo750toDpu2uoSUM + fMo750toDpu2uoSUM2) + fMo750toDpu2uoSUM2);
    }
}
