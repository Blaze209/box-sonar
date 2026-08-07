package external.sdk.pendo.io.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import external.sdk.pendo.io.glide.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.v.c;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static int tagId = R.id.glide_custom_view_target_tag;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final b sizeDeterminer;
    protected final T view;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewTarget.this.resumeMyRequest();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTarget.this.pauseMyRequest();
        }
    }

    static final class b {
        static Integer e;
        private final View a;
        private final List<c> b = new ArrayList();
        boolean c;
        private a d;

        private static final class a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<b> a;

            a(b bVar) {
                this.a = new WeakReference<>(bVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.TAG, 2)) {
                    Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                b bVar = this.a.get();
                if (bVar == null) {
                    return true;
                }
                bVar.a();
                return true;
            }
        }

        b(View view) {
            this.a = view;
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private int c() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                b(iD, iC);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        private static int a(Context context) {
            if (e == null) {
                Display defaultDisplay = ((WindowManager) k.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        private void b(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((c) it.next()).onSizeReady(i, i2);
            }
        }

        void a(c cVar) {
            int iD = d();
            int iC = c();
            if (a(iD, iC)) {
                cVar.onSizeReady(iD, iC);
                return;
            }
            if (!this.b.contains(cVar)) {
                this.b.add(cVar);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                a aVar = new a(this);
                this.d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void b(c cVar) {
            this.b.remove(cVar);
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.TAG, 4)) {
                Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.a.getContext());
        }

        private boolean a(int i, int i2) {
            return a(i) && a(i2);
        }
    }

    public ViewTarget(T t) {
        this.view = (T) k.a(t);
        this.sizeDeterminer = new b(t);
    }

    private Object getTag() {
        return this.view.getTag(tagId);
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || this.isAttachStateListenerAdded) {
            return;
        }
        this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || !this.isAttachStateListenerAdded) {
            return;
        }
        this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = false;
    }

    private void setTag(Object obj) {
        isTagUsedAtLeastOnce = true;
        this.view.setTag(tagId, obj);
    }

    @Deprecated
    public static void setTagId(int i) {
        if (isTagUsedAtLeastOnce) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = i;
    }

    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new a();
        maybeAddAttachStateListener();
        return this;
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public sdk.pendo.io.u.a getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof sdk.pendo.io.u.a) {
            return (sdk.pendo.io.u.a) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void getSize(c cVar) {
        this.sizeDeterminer.a(cVar);
    }

    public T getView() {
        return this.view;
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.b();
        if (this.isClearedByUs) {
            return;
        }
        maybeRemoveAttachStateListener();
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        maybeAddAttachStateListener();
    }

    void pauseMyRequest() {
        sdk.pendo.io.u.a request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void removeCallback(c cVar) {
        this.sizeDeterminer.b(cVar);
    }

    void resumeMyRequest() {
        sdk.pendo.io.u.a request = getRequest();
        if (request == null || !request.isCleared()) {
            return;
        }
        request.begin();
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void setRequest(sdk.pendo.io.u.a aVar) {
        setTag(aVar);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    public final ViewTarget<T, Z> waitForLayout() {
        this.sizeDeterminer.c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }
}
