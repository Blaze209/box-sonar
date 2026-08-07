package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.actions.HideAction;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class lj<T> implements Consumer {
    public final /* synthetic */ nj a;
    public final /* synthetic */ HideAction b;

    public lj(nj njVar, HideAction hideAction) {
        this.a = njVar;
        this.b = hideAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        List<? extends Annotation> list = (List) obj;
        list.getClass();
        HideAction hideAction = this.b;
        for (Annotation annotation : list) {
            EnumSet<AnnotationFlags> flags = annotation.getFlags();
            flags.remove(AnnotationFlags.INVISIBLE);
            flags.remove(AnnotationFlags.NOVIEW);
            if (hideAction.getHideTargets()) {
                flags.add(AnnotationFlags.HIDDEN);
            } else {
                flags.remove(AnnotationFlags.HIDDEN);
            }
            annotation.setFlags(flags);
        }
        this.a.a.a(list);
    }
}
