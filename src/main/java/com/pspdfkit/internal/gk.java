package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class gk {
    public static fk a(Context context) {
        k kVar;
        WeakReference<Object> weakReference;
        Activity activityA = a80.a(context);
        Object obj = null;
        if (activityA == null) {
            return null;
        }
        synchronized (ar.class) {
            if (ar.e == null) {
                ar.e = new k();
            }
            kVar = ar.e;
        }
        Map<Class, WeakReference<Object>> map = kVar.a.get(activityA);
        if (map != null && (weakReference = map.get(fk.class)) != null) {
            Object obj2 = weakReference.get();
            if (obj2 != null) {
                obj = obj2;
            } else {
                map.remove(fk.class);
            }
        }
        return (fk) obj;
    }

    public static int b(Activity activity) {
        if ((activity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 0) {
            return c(activity);
        }
        return 0;
    }

    public static int c(Activity activity) {
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        Rect rect = rootWindowInsets != null ? new Rect(rootWindowInsets.getStableInsetLeft(), rootWindowInsets.getStableInsetTop(), rootWindowInsets.getStableInsetRight(), rootWindowInsets.getStableInsetBottom()) : null;
        if (rect == null) {
            View decorView = activity.getWindow().getDecorView();
            WindowInsets rootWindowInsets2 = decorView.getRootWindowInsets();
            Rect rect2 = rootWindowInsets2 != null ? new Rect(rootWindowInsets2.getSystemWindowInsetLeft(), rootWindowInsets2.getSystemWindowInsetTop(), rootWindowInsets2.getSystemWindowInsetRight(), rootWindowInsets2.getSystemWindowInsetBottom()) : null;
            if (rect2 == null) {
                int width = decorView.getWidth();
                int height = decorView.getHeight();
                Rect rect3 = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect3);
                rect3.set(rect3.left, rect3.top, Math.max(0, width - rect3.right), Math.max(0, height - rect3.bottom));
                rect = rect3;
            } else {
                rect = rect2;
            }
        }
        return Math.max(0, rect.top);
    }

    public static boolean d(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 6) != 0;
    }

    public static fk.a a(Context context, fk.a aVar) {
        fk fkVarA = a(context);
        if (fkVarA == null) {
            return null;
        }
        fk.a aVar2 = new fk.a();
        fkVarA.d.add(aVar2);
        if (!fkVarA.a.l) {
            fkVarA.a();
        }
        if (aVar != null) {
            fkVarA.d.remove(aVar);
            fkVarA.b();
        }
        return aVar2;
    }

    public static int a(Activity activity) {
        if ((activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 0) {
            return tr.a(activity);
        }
        return 0;
    }
}
