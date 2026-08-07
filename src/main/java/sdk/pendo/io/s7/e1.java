package sdk.pendo.io.s7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.listeners.views.PendoOnItemClickListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
public class e1 {

    public static class a {
        public final WeakReference<View> a;
        private final Rect b;
        private final WindowManager.LayoutParams c;
        private WeakReference<Window> e = null;
        public final WeakReference<Object> d = null;

        public a(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams) {
            this.a = weakReference;
            View view = weakReference.get();
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                this.b = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
            } else {
                this.b = null;
            }
            this.c = layoutParams;
        }

        public WindowManager.LayoutParams a() {
            return this.c;
        }

        public Rect b() {
            return this.b;
        }

        public Window c() {
            if (this.e == null) {
                this.e = new WeakReference<>((Window) r0.a("mWindow", this.a.get()));
            }
            return this.e.get();
        }

        IBinder d() {
            return this.c.token;
        }

        public boolean e() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams == null || layoutParams.type == 1;
        }

        public boolean f() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams != null && layoutParams.type >= 1000 && layoutParams.gravity == 8388691;
        }

        public boolean g() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams != null && layoutParams.type == 2;
        }

        public boolean h() {
            return (g() || i() || f()) ? false : true;
        }

        public boolean i() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams != null && layoutParams.type == 1002;
        }

        public boolean a(int i) {
            Rect rect = this.b;
            return rect != null && rect.width() > i && this.b.height() > i;
        }
    }

    public static class b {
        private String a;
        private String b;
        private final ArrayList<String> c = new ArrayList<>();

        public String a() {
            return this.b;
        }

        public ArrayList<String> b() {
            return this.c;
        }

        public String c() {
            return this.a;
        }

        public void a(String str) {
            this.b = str;
        }

        public void b(String str) {
            this.a = str;
        }
    }

    public static Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getMeasuredWidth() + i, iArr[1] + view.getMeasuredHeight());
    }

    public static boolean a(int i) {
        return ((-16777216) & i) == 0 && (i & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    public static int b(float f) {
        return a(2, f);
    }

    public static String c(View view) {
        CharSequence contentDescription = view.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return null;
        }
        return contentDescription.toString();
    }

    public static TextView d(View view) {
        return a(view, false);
    }

    public static View e(View view) {
        if (view == null) {
            return null;
        }
        Object parent = view.getParent();
        if (!(parent instanceof View)) {
            return null;
        }
        View view2 = (View) parent;
        return j(view2) ? view2 : e(view2);
    }

    public static String f(View view) {
        try {
            int id = view.getId();
            if (id == -1 || a(id)) {
                return null;
            }
            return view.getResources().getResourceName(id);
        } catch (Resources.NotFoundException unused) {
            return null;
        } catch (Exception e) {
            PendoLogger.d(e, "ViewUtils", e.getMessage());
            return null;
        }
    }

    public static Rect g(View view) {
        Rect rect = new Rect();
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
        } catch (Exception e) {
            PendoLogger.d(e, "Attempt to read from field mVisibleInsets on a null attachInfo of the view in question.", new Object[0]);
            return rect;
        }
    }

    public static boolean h(View view) {
        if (view == null) {
            return false;
        }
        try {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets == null) {
                return false;
            }
            return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        } catch (Exception e) {
            PendoLogger.d("ViewUtils", "isKeyboardShowing error - " + e);
            return false;
        }
    }

    private static boolean i(View view) {
        return view != null && view.isShown();
    }

    public static boolean j(View view) {
        return (view instanceof AbsListView) || (view instanceof RecyclerView);
    }

    public static boolean k(View view) {
        return view.getClass().getSimpleName().toLowerCase(Locale.US).contains("tabview");
    }

    public static boolean l(View view) {
        return e(view) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(View view) {
        a(view, (WeakReference<View>) new WeakReference(view));
    }

    public static MotionEvent n(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, iArr[0], iArr[1], 0);
    }

    protected static void o(View view) {
        try {
            Context context = view.getContext();
            if (PendoInternal.y().shouldDetectClicksForAccessibility && sdk.pendo.io.s7.b.a(context)) {
                sdk.pendo.io.s7.b.a(view);
            }
        } catch (Exception e) {
            PendoLogger.w("ViewUtils Unable to set click action listener on view for accessibility: %s", e.getMessage());
        }
    }

    public static void p(final View view) {
        sdk.pendo.io.n3.a.a().a(new Runnable() { // from class: sdk.pendo.io.s7.e1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                e1.m(view);
            }
        });
    }

    public static String q(View view) {
        return view.getClass().getName();
    }

    public static String a(Bitmap.CompressFormat compressFormat, int i, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void b(View view) {
        if (view == null) {
            return;
        }
        view.dispatchTouchEvent(n(view));
    }

    private static void c(List<a> list) {
        int i;
        int i2;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<a> it = list.iterator();
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            Rect rect = it.next().b;
            if (rect != null && (i2 = rect.top) < i3) {
                i3 = i2;
            }
            if (rect != null && (i = rect.left) < i4) {
                i4 = i;
            }
        }
        Iterator<a> it2 = list.iterator();
        while (it2.hasNext()) {
            Rect rect2 = it2.next().b;
            if (rect2 != null) {
                rect2.offset(-i4, -i3);
            }
        }
    }

    public static int a(float f) {
        return a(1, f);
    }

    public static List<a> b(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = new ArrayList(list).iterator();
            while (it.hasNext()) {
                View view = (View) r0.a("mView", it.next());
                if (i(view)) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
                    if (layoutParams == null || layoutParams.getTitle() == null || !layoutParams.getTitle().toString().contains("PendoGuideVisualActivity")) {
                        if (i(view)) {
                            arrayList.add(new a(new WeakReference(view), layoutParams));
                        }
                    }
                } else {
                    PendoLogger.w("ViewUtils getRootViewsDataList -> root view is null ", new Object[0]);
                }
            }
            return arrayList;
        } catch (Exception e) {
            PendoLogger.e("ViewUtils getRootViewsDataList -> " + e.getMessage(), new Object[0]);
            return arrayList;
        }
    }

    private static int a(int i, float f) {
        DisplayMetrics displayMetricsA = a();
        if (displayMetricsA != null) {
            return (int) TypedValue.applyDimension(i, f, displayMetricsA);
        }
        return -1;
    }

    public static boolean b() {
        WeakReference<PendoDrawerListener> pendoDrawerListenerRef = PendoInternal.z().getPendoDrawerListenerRef();
        if (pendoDrawerListenerRef == null || pendoDrawerListenerRef.get() == null) {
            return false;
        }
        return pendoDrawerListenerRef.get().isDrawerOpened();
    }

    private static void a(List<a> list, Bitmap bitmap, sdk.pendo.io.t7.c cVar) {
        if (list == null) {
            PendoLogger.e("drawRootsToBitmap() viewRoot can't be null", new Object[0]);
        } else if (list.isEmpty()) {
            PendoLogger.e("drawRootsToBitmap() viewRoot can't be empty", new Object[0]);
        } else {
            new sdk.pendo.io.t7.b(list, bitmap, cVar).a();
        }
    }

    public static Bitmap b(Activity activity, sdk.pendo.io.t7.c cVar) {
        if (activity == null) {
            throw new IllegalArgumentException("Parameter activity cannot be null.");
        }
        try {
            return a(activity, cVar);
        } catch (Exception e) {
            PendoLogger.e("Unable to take screenshot to bitmap of activity " + activity.getClass().getName(), e);
            return null;
        }
    }

    private static void a(Activity activity, final List<a> list, final Bitmap bitmap, final sdk.pendo.io.t7.c cVar) throws InterruptedException {
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.s7.e1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e1.a(list, bitmap, cVar, atomicReference, countDownLatch);
            }
        });
        countDownLatch.await();
        Exception exc = (Exception) atomicReference.get();
        if (exc != null) {
            PendoLogger.e("ViewUtils", "drawRootsToBitmap on main thread", exc);
        }
    }

    private static void a(List<a> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        int i = 0;
        while (i < list.size() - 1) {
            a aVar = list.get(i);
            if (aVar.d() == null) {
                return;
            }
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                a aVar2 = list.get(i3);
                if (aVar2.e() && aVar2.d() == aVar.d()) {
                    list.remove(aVar2);
                    list.add(i, aVar2);
                    break;
                }
            }
            i = i2;
        }
    }

    public static DisplayMetrics a() {
        Context contextO = PendoInternal.o();
        if (contextO != null) {
            return contextO.getResources().getDisplayMetrics();
        }
        return null;
    }

    public static TextView a(View view, boolean z) {
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.empty()) {
            View view2 = (View) stack.pop();
            if (a(z, view2)) {
                return (TextView) view2;
            }
            if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if (a(z, childAt)) {
                        return (TextView) childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        stack.push(childAt);
                    }
                    i++;
                }
            }
        }
        return null;
    }

    public static Integer a(View view, View view2) {
        int childLayoutPosition;
        try {
            if (view instanceof AbsListView) {
                childLayoutPosition = ((AbsListView) view).getPositionForView(view2);
            } else {
                if (!(view instanceof RecyclerView)) {
                    return null;
                }
                childLayoutPosition = ((RecyclerView) view).getChildLayoutPosition(view2);
            }
            return Integer.valueOf(childLayoutPosition);
        } catch (Exception e) {
            PendoLogger.e(e, "Position in list could not be obtained", new Object[0]);
            return null;
        }
    }

    public static List<a> a(Activity activity) {
        try {
            Object objA = r0.a("mRoots", r0.a("mGlobal", activity.getWindowManager()));
            if (objA instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objA;
                if (!arrayList.isEmpty()) {
                    List<a> listB = b(arrayList);
                    if (!listB.isEmpty()) {
                        c(listB);
                        a(listB);
                        return listB;
                    }
                }
            }
            return Collections.emptyList();
        } catch (Exception e) {
            PendoLogger.w("ViewUtils getRootViews -> " + e.getMessage(), new Object[0]);
            return Collections.emptyList();
        }
    }

    public static void a(View view, boolean z, b bVar) {
        a(view, z, bVar, false);
    }

    public static void a(View view, boolean z, b bVar, boolean z2) {
        if (view == null) {
            return;
        }
        if (bVar.a() == null) {
            bVar.a(c(view));
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (z2) {
                if (text == null) {
                    return;
                }
            } else if (TextUtils.isEmpty(text)) {
                return;
            }
            String string = ((TextView) view).getText().toString();
            if (bVar.c() == null) {
                bVar.b(string);
            }
            if (z || z2) {
                bVar.b().add(string);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i), z, bVar, z2);
            i++;
        }
    }

    public static synchronized Boolean a(MotionEvent motionEvent, View view, int i, int i2) {
        if (a(motionEvent).booleanValue() && view != null) {
            return Boolean.valueOf(a(view).contains(((int) motionEvent.getX()) + i, ((int) motionEvent.getY()) + i2));
        }
        return Boolean.FALSE;
    }

    private static boolean a(boolean z, View view) {
        if (z) {
            return view instanceof TextView;
        }
        return (view instanceof TextView) && !TextUtils.isEmpty(((TextView) view).getText());
    }

    public static Boolean a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return Boolean.FALSE;
        }
        int pointerCount = motionEvent.getPointerCount();
        int actionIndex = motionEvent.getActionIndex();
        return Boolean.valueOf(actionIndex < pointerCount && actionIndex >= 0);
    }

    public static boolean a(View view, int i) {
        if (view == null) {
            return false;
        }
        try {
            if (view.getVisibility() == 8) {
                return false;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            if (!globalVisibleRect && view.getVisibility() == 0 && ((view.getWidth() == 0 || view.getHeight() == 0) && (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0 && view.getAlpha() > 0.0f)) {
                return true;
            }
            if (i == 1) {
                view.getLocalVisibleRect(rect2);
            } else {
                if (i != 0) {
                    throw new IllegalArgumentException("viewMode is illegal : " + i);
                }
                view.getWindowVisibleDisplayFrame(rect2);
            }
            return globalVisibleRect && Rect.intersects(rect2, rect);
        } catch (Exception e) {
            PendoLogger.d("ViewUtils failed to calculate isViewInsideDisplay. " + e, e.getMessage());
            return false;
        }
    }

    public static boolean a(View view, Rect rect, Rect rect2, int i) {
        if (view == null) {
            return false;
        }
        try {
            if (view.getVisibility() == 8 || !view.getGlobalVisibleRect(rect2)) {
                return false;
            }
            if (i == 1) {
                int width = view.getWidth() / 2;
                int height = view.getHeight() / 2;
                return rect2.right - width > rect.left && rect2.left + width < rect.right && rect2.bottom - height > rect.top && rect2.top + height < rect.bottom;
            }
            if (i == 0) {
                return Rect.intersects(rect, rect2);
            }
            throw new IllegalArgumentException("viewMode is illegal : " + i);
        } catch (Exception e) {
            PendoLogger.d("ViewUtils failed to calculate isViewInsideDisplay. " + e, e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, Bitmap bitmap, sdk.pendo.io.t7.c cVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        try {
            try {
                a((List<a>) list, bitmap, cVar);
            } catch (Exception e) {
                atomicReference.set(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    protected static synchronized void a(DrawerLayout drawerLayout) {
        PendoDrawerListener pendoDrawerListener;
        WeakReference<PendoDrawerListener> pendoDrawerListenerRef = PendoInternal.z().getPendoDrawerListenerRef();
        if (pendoDrawerListenerRef == null || pendoDrawerListenerRef.get() == null) {
            pendoDrawerListener = null;
        } else {
            pendoDrawerListener = pendoDrawerListenerRef.get();
            DrawerLayout drawerLayout2 = pendoDrawerListener.getDrawerLayoutRef().get();
            if (drawerLayout2 != null && drawerLayout2 == drawerLayout) {
                return;
            }
        }
        if (pendoDrawerListener == null) {
            pendoDrawerListener = new PendoDrawerListener(drawerLayout);
            PendoInternal.z().setPendoDrawerListenerRef(new WeakReference<>(pendoDrawerListener));
        } else {
            pendoDrawerListener.setDrawerLayoutReference(drawerLayout);
        }
        drawerLayout.addDrawerListener(pendoDrawerListener);
    }

    protected static void a(AbsListView absListView) {
        AdapterView.OnItemClickListener onItemClickListener = absListView.getOnItemClickListener();
        if (onItemClickListener == null || (onItemClickListener instanceof PendoOnItemClickListener)) {
            return;
        }
        PendoOnItemClickListener pendoOnItemClickListener = new PendoOnItemClickListener();
        pendoOnItemClickListener.addListener(onItemClickListener);
        absListView.setOnItemClickListener(pendoOnItemClickListener);
    }

    protected static void a(View view, WeakReference<View> weakReference) {
        try {
            o(view);
            TouchDelegate touchDelegate = view.getTouchDelegate();
            if (touchDelegate instanceof PendoTouchDelegate) {
                return;
            }
            Rect rect = new Rect();
            view.getHitRect(rect);
            PendoTouchDelegate pendoTouchDelegate = new PendoTouchDelegate(rect, view, weakReference);
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled()) {
                view.setOnTouchListener(pendoTouchDelegate);
            } else if (touchDelegate != null) {
                pendoTouchDelegate.a(touchDelegate);
            }
            view.setTouchDelegate(pendoTouchDelegate);
        } catch (Exception e) {
            PendoLogger.w("ViewUtils Unable to set touch delegate on touchDelegateView: %s", e.getMessage());
        }
    }

    private static Bitmap a(Activity activity, sdk.pendo.io.t7.c cVar) {
        try {
            List<a> listA = a(activity);
            if (listA.isEmpty()) {
                PendoLogger.e("Unable to capture any view data in " + (activity != null ? activity.getClass().getCanonicalName() : "no activity"), new Object[0]);
                return null;
            }
            Iterator<a> it = listA.iterator();
            int i = Integer.MIN_VALUE;
            int i2 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                Rect rect = it.next().b;
                int i3 = rect.right;
                if (i3 > i) {
                    i = i3;
                }
                int i4 = rect.bottom;
                if (i4 > i2) {
                    i2 = i4;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a(listA, bitmapCreateBitmap, cVar);
                return bitmapCreateBitmap;
            }
            a(activity, listA, bitmapCreateBitmap, cVar);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            PendoLogger.e("ViewUtils", "Failed to generate bitmap via screenshot", e);
            return null;
        }
    }
}
