package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.annotations.Annotation;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ub {
    Completable a(ArrayList arrayList);

    Maybe<List<Annotation>> a(int i);

    Maybe<List<Annotation>> a(int i, PointF pointF);

    boolean a();

    boolean a(List<? extends Annotation> list);

    Completable b(ArrayList arrayList);

    boolean b(List<? extends Annotation> list);
}
