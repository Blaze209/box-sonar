package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.ui.unit.Density;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class sd {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final long f;
    public final long g;
    public final long h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public final float m;

    public sd(Context context, Density density) {
        context.getClass();
        density.getClass();
        float dimension = context.getResources().getDimension(R.dimen.pspdf__document_info_group_margin_top);
        density.getClass();
        this.a = density.mo750toDpu2uoSUM(dimension);
        this.b = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_margin_bottom));
        this.c = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_margin_start));
        this.d = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_margin_end));
        this.e = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_title_margin_bottom));
        this.f = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__document_info_group_title_text_size));
        this.g = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__document_info_item_title_text_size));
        this.h = density.mo757toSpkPz2Gy4(context.getResources().getDimension(R.dimen.pspdf__document_info_item_value_text_size));
        this.i = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_content_margin_start));
        this.j = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_item_spacing));
        this.k = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_icon_size));
        this.l = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_item_title_and_value_spacing));
        this.m = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__document_info_group_icon_margin_start));
    }
}
