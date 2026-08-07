package com.swmansion.rnscreens.ext;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ViewKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0001H\u0000¨\u0006\u000f"}, d2 = {"parentAsView", "Landroid/view/View;", "parentAsViewGroup", "Landroid/view/ViewGroup;", "recycle", "maybeBgColor", "", "(Landroid/view/View;)Ljava/lang/Integer;", "asViewGroupOrNull", "findFragmentOrNull", "Landroidx/fragment/app/Fragment;", "isMeasured", "", "detachFromCurrentParent", "", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt {
    public static final View parentAsView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    public static final ViewGroup parentAsViewGroup(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static final View recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup viewGroupParentAsViewGroup = parentAsViewGroup(view);
        if (viewGroupParentAsViewGroup != null) {
            viewGroupParentAsViewGroup.endViewTransition(view);
            viewGroupParentAsViewGroup.removeView(view);
        }
        view.setVisibility(0);
        view.setTranslationY(0.0f);
        return view;
    }

    public static final Integer maybeBgColor(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) background).getColor());
        }
        return null;
    }

    public static final ViewGroup asViewGroupOrNull(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public static final Fragment findFragmentOrNull(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            return ViewKt.findFragment(view);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static final boolean isMeasured(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0 && !view.isLaidOut()) ? false : true;
    }

    public static final void detachFromCurrentParent(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }
}
