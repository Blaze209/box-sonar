package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;

/* JADX INFO: loaded from: classes3.dex */
public interface z4<T extends Annotation> {

    public interface a<T extends Annotation> {
        void a(z4<T> z4Var);
    }

    View a();

    default void a(Matrix matrix, float f) {
    }

    void a(a<T> aVar);

    default boolean a(RectF rectF) {
        return false;
    }

    void b();

    default boolean b(boolean z) {
        return false;
    }

    default boolean e() {
        return false;
    }

    default void f() {
    }

    T getAnnotation();

    default l1 getContentScaler() {
        return null;
    }

    default PageRect getPageRect() {
        ViewGroup.LayoutParams layoutParams = a().getLayoutParams();
        if (layoutParams instanceof OverlayLayoutParams) {
            return ((OverlayLayoutParams) layoutParams).pageRect;
        }
        throw new IllegalStateException("Annotation view had unexpected LayoutParams: " + layoutParams);
    }

    default boolean h() {
        return true;
    }

    default boolean i() {
        return false;
    }

    default void m() {
    }

    void n();

    void setAnnotation(T t);
}
