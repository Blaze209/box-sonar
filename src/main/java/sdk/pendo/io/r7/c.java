package sdk.pendo.io.r7;

import android.R;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.b7.j;
import sdk.pendo.io.h7.p;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J8\u0010\u0006\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J<\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u001f\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\u0006\u0010 J\u001f\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\tH\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0006\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0006\u0010$J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b#\u0010&R\u001b\u0010+\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b\u0006\u0010*¨\u0006."}, d2 = {"Lsdk/pendo/io/r7/c;", "Lsdk/pendo/io/r7/h;", "Lsdk/pendo/io/n7/a;", "Lsdk/pendo/io/s7/e1$a;", "root", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "rootView", "Landroid/graphics/Rect;", "view", "Lsdk/pendo/io/j7/c;", "parentSRNode", "Lsdk/pendo/io/r7/f;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "", "nodeId", ViewProps.Z_INDEX, "rootViewBounds", "", "Lsdk/pendo/io/j7/v;", "node", "", "roots", "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/h7/p;", "displayData", "initialZIndex", "initialSRNodeId", "Lkotlin/Pair;", "currentZIndex", "(ILandroid/view/View;)I", "windowBounds", "", "b", "(Landroid/view/View;Landroid/graphics/Rect;)Z", "c", "(Landroid/view/View;)Z", "screenBounds", "Lsdk/pendo/io/a7/a;", "Lkotlin/Lazy;", "()Lsdk/pendo/io/a7/a;", "nodesBuilder", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class c implements h, sdk.pendo.io.n7.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy nodesBuilder = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new b(this, null, null));

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class b extends Lambda implements Function0<sdk.pendo.io.a7.a> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.a7.a] */
        @Override // kotlin.jvm.functions.Function0
        public final sdk.pendo.io.a7.a invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.a7.a.class), this.b, this.c);
        }
    }

    public int a(int currentZIndex, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof AppBarLayout ? true : view instanceof BottomNavigationView) {
            return currentZIndex + 1;
        }
        if (view instanceof FloatingActionButton) {
            return currentZIndex + 2;
        }
        return view instanceof NavigationView ? currentZIndex + 3 : currentZIndex;
    }

    public final boolean b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof PendoFloatingVisualGuideView) || (view instanceof FloatingListenerButton);
    }

    public final boolean c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != -1) {
            try {
                String resourceEntryName = view.getResources().getResourceEntryName(id);
                if (resourceEntryName != null && resourceEntryName.equals("touch_outside") && !view.isFocusable() && view.getImportantForAccessibility() == 2) {
                    return true;
                }
            } catch (Resources.NotFoundException unused) {
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.n7.a.C0430a.a(this);
    }

    private final float a(e1.a root) {
        WindowManager.LayoutParams layoutParamsA = root.a();
        if (layoutParamsA != null && (layoutParamsA.flags & 2) == 2) {
            return RangesKt.coerceIn(layoutParamsA.dimAmount, 0.0f, 1.0f);
        }
        return 0.0f;
    }

    public boolean b(View view, Rect windowBounds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowBounds, "windowBounds");
        return a(view, windowBounds) || c(view) || b(view);
    }

    private final Rect a(View rootView) {
        int[] iArr = new int[2];
        rootView.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], rootView.getWidth() + i, iArr[1] + rootView.getHeight());
    }

    private final int a(v node) {
        int id = node.getId();
        if (node instanceof sdk.pendo.io.j7.c) {
            Iterator<v> it = ((sdk.pendo.io.j7.c) node).f().iterator();
            while (it.hasNext()) {
                id = Math.max(id, a(it.next()));
            }
        }
        return id;
    }

    private final void a(View view, sdk.pendo.io.j7.c parentSRNode, f result, int nodeId, int zIndex, Rect rootViewBounds) {
        if (view instanceof NavigationView) {
            sdk.pendo.io.b7.d dVar = sdk.pendo.io.b7.d.a;
            NavigationView navigationView = (NavigationView) view;
            ViewParent parent = navigationView.getParent();
            int iA = dVar.a(parent instanceof DrawerLayout ? (DrawerLayout) parent : null);
            ViewParent parent2 = navigationView.getParent();
            result.a(sdk.pendo.io.f7.a.a.a(nodeId, zIndex, rootViewBounds.right, rootViewBounds.bottom, iA, dVar.b(parent2 instanceof DrawerLayout ? (DrawerLayout) parent2 : null)), parentSRNode);
        }
    }

    private final sdk.pendo.io.a7.a a() {
        return (sdk.pendo.io.a7.a) this.nodesBuilder.getValue();
    }

    public final boolean a(View view, Rect screenBounds) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(screenBounds, "screenBounds");
        if (view.getVisibility() != 0 || view.getAlpha() <= 0.0f) {
            return true;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return !Rect.intersects(screenBounds, new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight()));
    }

    @Override // sdk.pendo.io.r7.h
    public List<v> a(List<? extends e1.a> roots, s privacyConfig, p displayData) {
        ViewGroup viewGroup;
        c cVar;
        int i;
        View view;
        int i2;
        Intrinsics.checkNotNullParameter(roots, "roots");
        s privacyConfig2 = privacyConfig;
        Intrinsics.checkNotNullParameter(privacyConfig2, "privacyConfig");
        Intrinsics.checkNotNullParameter(displayData, "displayData");
        long jCurrentTimeMillis = System.currentTimeMillis();
        f fVar = new f();
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(roots, 10));
            Iterator<T> it = roots.iterator();
            while (it.hasNext()) {
                WeakReference<View> weakReference = ((e1.a) it.next()).a;
                arrayList.add(weakReference != null ? weakReference.get() : null);
            }
            int i3 = 101;
            int i4 = 0;
            int i5 = 0;
            for (Object obj : arrayList) {
                int i6 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                if (view2 != null) {
                    if (!roots.get(i4).i() && (viewGroup = (ViewGroup) view2.findViewById(R.id.content)) != null) {
                        view2 = viewGroup;
                    }
                    Intrinsics.checkNotNull(view2);
                    float fA = a(roots.get(i4));
                    boolean z = fA > 0.0f && !fVar.a().isEmpty();
                    int size = fVar.a().size();
                    if (z) {
                        cVar = this;
                        i2 = i5 + 1;
                        view = view2;
                        i = i2;
                    } else {
                        cVar = this;
                        View view3 = view2;
                        i = i5;
                        view = view3;
                        i2 = 0;
                    }
                    Pair<Integer, Integer> pairA = cVar.a(view, privacyConfig2, fVar, i, i3);
                    int iIntValue = pairA.component1().intValue();
                    int iIntValue2 = pairA.component2().intValue();
                    int i7 = iIntValue2 + 1;
                    if (z && fVar.a().size() > size) {
                        int i8 = iIntValue2 + 2;
                        fVar.a().add(size, sdk.pendo.io.f7.a.a(sdk.pendo.io.f7.a.a, i8, i2, displayData.getWidth() + displayData.getLeftInset(), displayData.getHeight() + displayData.getTopInset(), 0, fA, 16, null));
                        i7 = i8;
                    }
                    i5 = iIntValue;
                    i3 = i7;
                }
                privacyConfig2 = privacyConfig;
                i4 = i6;
            }
        } catch (Throwable th) {
            PendoLogger.e("NativeSRScanner", "Failed to scan the layout hierarchy", th);
        }
        PendoLogger.d("NativeSRScanner", "The scan of the layout hierarchy finished in " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return fVar.a();
    }

    public Pair<Integer, Integer> a(View rootView, s privacyConfig, f result, int initialZIndex, int initialSRNodeId) {
        c cVar;
        f fVar;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Intrinsics.checkNotNullParameter(result, "result");
        Rect rectA = a(rootView);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new Triple(rootView, Integer.valueOf(initialZIndex), null));
        while (!arrayDeque.isEmpty()) {
            Triple triple = (Triple) arrayDeque.removeLast();
            View view = (View) triple.component1();
            int iIntValue = ((Number) triple.component2()).intValue();
            sdk.pendo.io.j7.c cVar2 = (sdk.pendo.io.j7.c) triple.component3();
            if (!this.b(view, rectA)) {
                initialZIndex = Math.max(initialZIndex, iIntValue);
                v vVarA = this.a().a(initialSRNodeId, view, iIntValue, privacyConfig);
                if (vVarA != null) {
                    initialSRNodeId = this.a(vVarA);
                    if (cVar2 == null) {
                        vVarA.a(j.a.a(view));
                        result.a(vVarA);
                        cVar = this;
                        fVar = result;
                    } else {
                        int i = initialSRNodeId + 1;
                        cVar = this;
                        fVar = result;
                        cVar.a(view, cVar2, fVar, i, iIntValue, rectA);
                        fVar.a(vVarA, cVar2);
                        initialSRNodeId = i;
                    }
                } else {
                    cVar = this;
                    fVar = result;
                    vVarA = null;
                }
                if (vVarA != null && (view instanceof ViewGroup) && (vVarA instanceof sdk.pendo.io.j7.c)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    while (true) {
                        childCount--;
                        if (-1 >= childCount) {
                            break;
                        }
                        View childAt = viewGroup.getChildAt(childCount);
                        Intrinsics.checkNotNull(childAt);
                        arrayDeque.add(new Triple(childAt, Integer.valueOf(cVar.a(iIntValue, childAt)), vVarA));
                    }
                }
                this = cVar;
                result = fVar;
            }
        }
        return TuplesKt.to(Integer.valueOf(initialZIndex), Integer.valueOf(initialSRNodeId));
    }
}
