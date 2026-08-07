package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import androidx.media3.extractor.ts.PsExtractor;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.utils.PdfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class hn {
    public static final WeakHashMap a = new WeakHashMap();

    public static class a extends ResultReceiver {
        public final WeakReference<d> a;

        public a(d dVar) {
            super(new Handler(Looper.getMainLooper()));
            this.a = new WeakReference<>(dVar);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            d dVar = this.a.get();
            if (dVar != null) {
                dVar.a(i == 0 || i == 2);
            }
        }
    }

    public static class b {
        public final HashSet a = new HashSet();
        public final ArrayList b = new ArrayList();
    }

    public static class c {
        public final Activity a;
        public final ViewTreeObserver.OnGlobalLayoutListener b;
        public final d c;
        public final View d;
        public int f;
        public final Rect e = new Rect();
        public int g = 0;

        public c(Activity activity, d dVar) {
            this.a = activity;
            View decorView = activity.getWindow().getDecorView();
            this.d = decorView;
            this.c = dVar;
            a(false);
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.hn$c$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.a();
                }
            };
            this.b = onGlobalLayoutListener;
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public final /* synthetic */ void a() {
            a(true);
        }

        public final void b() {
            this.d.getViewTreeObserver().removeOnGlobalLayoutListener(this.b);
        }

        public final void a(boolean z) {
            WindowInsets rootWindowInsets;
            this.d.getWindowVisibleDisplayFrame(this.e);
            int height = this.d.getHeight();
            if (this.a.isInMultiWindowMode() && (rootWindowInsets = this.d.getRootWindowInsets()) != null) {
                height = ((this.d.getHeight() + this.e.top) - rootWindowInsets.getStableInsetTop()) - rootWindowInsets.getStableInsetBottom();
            }
            int iMax = Math.max(0, height - this.e.bottom);
            if (iMax != this.f) {
                int iA = tr.a(this.a);
                int i = this.g;
                if (iMax > iA) {
                    if (i == 0) {
                        this.g = iMax;
                        if (z) {
                            this.c.a(true);
                        }
                    }
                } else if (i > 0) {
                    this.g = 0;
                    if (z) {
                        this.c.a(false);
                    }
                }
            }
            this.f = iMax;
        }
    }

    public interface d {
        void a(boolean z);
    }

    public static void a(View view, f7 f7Var) {
        a(view, (!uc.d(view.getContext()) || uc.a(view.getContext(), 540)) ? 1 : 2, f7Var);
    }

    public static IBinder b(View view) {
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null && (view.getContext() instanceof Activity)) {
            Activity activity = (Activity) view.getContext();
            if (activity.getWindow() != null) {
                return activity.getWindow().getDecorView().getWindowToken();
            }
        }
        return windowToken;
    }

    public static void c(final View view) {
        Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.hn$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                hn.d(view);
            }
        };
        synchronized (hn.class) {
            b bVarA = a(view);
            if (bVarA == null || bVarA.a.isEmpty()) {
                runnable.run();
            } else {
                bVarA.b.add(runnable);
            }
        }
    }

    public static void d(View view) {
        IBinder iBinderB = b(view);
        if (iBinderB == null) {
            PdfLog.w("Nutri.KeyboardUtils", "KeyboardUtils#hideKeyboard was called with a detached view. Hiding keyboard will not work on some device.", new Object[0]);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            throw new NullPointerException("Input method manager is not available.");
        }
        inputMethodManager.hideSoftInputFromWindow(iBinderB, 0);
    }

    public static void a(final View view, final int i, final d dVar) {
        Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.hn$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                hn.a(view, dVar, i);
            }
        };
        synchronized (hn.class) {
            b bVarA = a(view);
            if (bVarA != null && !bVarA.a.isEmpty()) {
                bVarA.b.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void a(View view, d dVar, int i) {
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            throw new NullPointerException("Input method manager is not available.");
        }
        if (dVar == null) {
            inputMethodManager.showSoftInput(view, i);
        } else {
            inputMethodManager.showSoftInput(view, i, new a(dVar));
        }
    }

    public static synchronized b a(View view) {
        IBinder iBinderB = b(view);
        if (iBinderB == null) {
            PdfLog.w("Nutri.KeyboardUtils", "Can't retrieve keyboard lock for detached view!", new Object[0]);
            return null;
        }
        return (b) a.get(iBinderB);
    }

    public static int a(Context context, int i) {
        Activity activityA = a80.a(context);
        if (activityA == null) {
            return 0;
        }
        Activity activityA2 = a80.a(context);
        int i2 = activityA2 != null ? activityA2.getWindow().getAttributes().softInputMode : 0;
        activityA.getWindow().setSoftInputMode(i);
        return i2;
    }

    public static int a(PdfActivity pdfActivity) {
        Activity activityA = a80.a(pdfActivity);
        if (activityA == null) {
            return 0;
        }
        return activityA.getWindow().getAttributes().softInputMode & PsExtractor.VIDEO_STREAM_MASK;
    }
}
