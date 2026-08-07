package sdk.pendo.io.s7;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/s7/a1;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/ViewGroup;", "viewGroup", "c", "", "childIndex", "b", "childrenCount", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a1 {
    public static final a1 a = new a1();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/s7/a1$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "I", "()I", IdentificationData.FIELD_INDEX_IN_PARENT, "<init>", "(Landroid/view/View;I)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final View view;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int indexInParent;

        public a(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.indexInParent = i;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getIndexInParent() {
            return this.indexInParent;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.view, aVar.view) && this.indexInParent == aVar.indexInParent;
        }

        public int hashCode() {
            return (this.view.hashCode() * 31) + Integer.hashCode(this.indexInParent);
        }

        public String toString() {
            return "ChildView(view=" + this.view + ", indexInParent=" + this.indexInParent + ")";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        final /* synthetic */ ViewGroup a;

        public b(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            a aVar = (a) t;
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            a aVar2 = (a) t2;
            return ComparisonsKt.compareValues(Integer.valueOf(platformStateManager.isReactNativeAnalyticsEnabled() ? a1.a.b(this.a, aVar.getIndexInParent()) : this.a.getChildDrawingOrder(aVar.getIndexInParent())), Integer.valueOf(platformStateManager.isReactNativeAnalyticsEnabled() ? a1.a.b(this.a, aVar2.getIndexInParent()) : this.a.getChildDrawingOrder(aVar2.getIndexInParent())));
        }
    }

    private a1() {
    }

    private final boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(ViewGroup viewGroup, int childIndex) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("com.facebook.react.uimanager.ViewGroupDrawingOrderHelper");
        Object objNewInstance = cls.getConstructor(ViewGroup.class).newInstance(viewGroup);
        Class<?> cls2 = Integer.TYPE;
        Object objInvoke = cls.getMethod("getChildDrawingOrder", cls2, cls2).invoke(objNewInstance, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(childIndex));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objInvoke).intValue();
    }

    public final boolean c(ViewGroup viewGroup, int childIndex) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (!a()) {
            return true;
        }
        try {
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && c(viewGroup)) {
                if (b(viewGroup, childIndex) == childIndex) {
                }
            }
            return viewGroup.getChildDrawingOrder(childIndex) == childIndex;
        } catch (Exception e) {
            PendoLogger.i("ViewGroupUtils-> Could not check for child draw order " + e, new Object[0]);
            return true;
        }
    }

    private final boolean c(ViewGroup viewGroup) {
        if (Intrinsics.areEqual(viewGroup.getClass().getSimpleName(), "ReactViewGroup")) {
            return true;
        }
        return Class.forName("com.facebook.react.views.view.ReactViewGroup").isAssignableFrom(viewGroup.getClass());
    }

    public final ArrayList<View> a(ViewGroup viewGroup, int childrenCount) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        ArrayList arrayList = new ArrayList();
        if (childrenCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                arrayList.add(new a(childAt, i));
                if (i == childrenCount) {
                    break;
                }
                i++;
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new b(viewGroup));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a) it.next()).getView());
        }
        return new ArrayList<>(arrayList2);
    }

    public final boolean b(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (!a(viewGroup)) {
            return false;
        }
        DrawerLayout drawerLayout = (DrawerLayout) viewGroup;
        return drawerLayout.isDrawerOpen(GravityCompat.START) || drawerLayout.isDrawerOpen(GravityCompat.END);
    }

    public final boolean a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return !PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && c1.a(viewGroup);
    }
}
