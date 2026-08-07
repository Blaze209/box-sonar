package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.ui.unit.Density;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class k40 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;

    public k40(Context context, Density density) {
        context.getClass();
        density.getClass();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__stamp_picker_horizontal_padding);
        this.a = dimension;
        this.b = density.mo750toDpu2uoSUM(dimension);
        float dimension2 = context.getResources().getDimension(R.dimen.pspdf__stamp_picker_vertical_padding);
        this.c = dimension2;
        this.d = density.mo750toDpu2uoSUM(dimension2);
        this.e = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_fab_padding));
        this.f = context.getResources().getDimension(R.dimen.pspdf__stamp_picker_color_grid_padding);
        float dimension3 = context.getResources().getDimension(R.dimen.pspdf__stamp_picker_color_grid_spacing);
        this.g = dimension3;
        this.h = density.mo750toDpu2uoSUM(dimension3);
        density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_header_padding));
    }
}
