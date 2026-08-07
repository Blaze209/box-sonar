package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.annotations.configuration.AnnotationProperty;
import com.pspdfkit.annotations.configuration.StampAnnotationConfiguration;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class u30 extends g1<StampAnnotationConfiguration.Builder> implements StampAnnotationConfiguration.Builder {
    public final Context c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u30(Context context) {
        super(AnnotationProperty.ANNOTATION_NOTE);
        context.getClass();
        this.c = context;
    }

    @Override // com.pspdfkit.annotations.configuration.AnnotationConfiguration.Builder
    public final StampAnnotationConfiguration build() {
        j1 j1Var = this.a;
        i1<List<StampPickerItem>> i1Var = i1.B;
        j1Var.getClass();
        Object obj = j1Var.a.get(i1Var);
        if (obj == null) {
            obj = null;
        }
        if (((List) obj) == null) {
            j1 j1Var2 = this.a;
            List<StampPickerItem> defaultStampPickerItems = StampPickerItem.getDefaultStampPickerItems(this.c);
            j1Var2.getClass();
            HashMap<i1<?>, Object> map = j1Var2.a;
            defaultStampPickerItems.getClass();
            map.put(i1Var, defaultStampPickerItems);
        }
        return new v30(this.a);
    }

    @Override // com.pspdfkit.annotations.configuration.StampAnnotationConfiguration.Builder
    public final StampAnnotationConfiguration.Builder setAvailableStampPickerItems(List<? extends StampPickerItem> list) {
        list.getClass();
        j1 j1Var = this.a;
        i1<List<StampPickerItem>> i1Var = i1.B;
        ArrayList arrayList = new ArrayList(list);
        j1Var.getClass();
        j1Var.a.put(i1Var, arrayList);
        return this;
    }
}
