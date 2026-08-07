package com.pspdfkit.internal;

import com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ia implements ContentEditingFillColorConfiguration {
    public final ka a;

    public ia() {
        ka kaVar = new ka();
        this.a = kaVar;
        ja<List<Integer>> jaVar = ja.c;
        Object obj = kaVar.a.get(jaVar);
        List<Integer> list = (List) (obj == null ? null : obj);
        list = list == null ? ww.g : list;
        HashMap<ja<?>, Object> map = kaVar.a;
        list.getClass();
        map.put(jaVar, list);
    }

    @Override // com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration
    public final boolean customColorPickerEnabled() {
        ka kaVar = this.a;
        ja<Boolean> jaVar = ja.a;
        Object obj = Boolean.TRUE;
        kaVar.getClass();
        Object obj2 = kaVar.a.get(jaVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration
    public final List<Integer> getAvailableFillColors() {
        ka kaVar = this.a;
        ja<List<Integer>> jaVar = ja.c;
        float f = ww.a;
        Object obj = ww.g;
        kaVar.getClass();
        Object obj2 = kaVar.a.get(jaVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return (List) obj;
    }

    @Override // com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration
    public final int getDefaultFillColor() {
        ka kaVar = this.a;
        ja<Integer> jaVar = ja.b;
        kaVar.getClass();
        Object obj = kaVar.a.get(jaVar);
        return ((Number) (obj != null ? obj : -16777216)).intValue();
    }
}
