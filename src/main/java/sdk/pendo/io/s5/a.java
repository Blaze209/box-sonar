package sdk.pendo.io.s5;

import android.content.Context;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/s5/a;", "", "Landroid/view/ViewGroup;", "root", "Lsdk/pendo/io/s5/a$a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s5/c;", "observer", "", "b", "Ljava/util/WeakHashMap;", "Ljava/util/WeakHashMap;", "overlays", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final WeakHashMap<ViewGroup, C0478a> overlays = new WeakHashMap<>();

    /* JADX INFO: renamed from: sdk.pendo.io.s5.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/s5/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lsdk/pendo/io/s5/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s5/b;", "b", "()Lsdk/pendo/io/s5/b;", BoxAnalyticsParams.PAGE_EXPERIENCE_OVERLAY, "", "Lsdk/pendo/io/s5/c;", "Ljava/util/Set;", "()Ljava/util/Set;", "observers", "<init>", "(Lsdk/pendo/io/s5/b;Ljava/util/Set;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class C0478a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final b overlay;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Set<c> observers;

        public C0478a(b overlay, Set<c> observers) {
            Intrinsics.checkNotNullParameter(overlay, "overlay");
            Intrinsics.checkNotNullParameter(observers, "observers");
            this.overlay = overlay;
            this.observers = observers;
        }

        public final Set<c> a() {
            return this.observers;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final b getOverlay() {
            return this.overlay;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C0478a)) {
                return false;
            }
            C0478a c0478a = (C0478a) other;
            return Intrinsics.areEqual(this.overlay, c0478a.overlay) && Intrinsics.areEqual(this.observers, c0478a.observers);
        }

        public int hashCode() {
            return (this.overlay.hashCode() * 31) + this.observers.hashCode();
        }

        public String toString() {
            return "OverlayEntry(overlay=" + this.overlay + ", observers=" + this.observers + ")";
        }
    }

    private a() {
    }

    private final C0478a a(ViewGroup root) {
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        b bVar = new b(context);
        root.addView(bVar, new ViewGroup.LayoutParams(-1, -1));
        PendoLogger.d("PendoOverlayRegistry", "createOverlay -> added overlay to root " + root.hashCode());
        return new C0478a(bVar, new LinkedHashSet());
    }

    public final void b(ViewGroup root, c observer) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(observer, "observer");
        WeakHashMap<ViewGroup, C0478a> weakHashMap = overlays;
        C0478a c0478a = weakHashMap.get(root);
        if (c0478a != null && c0478a.a().remove(observer)) {
            PendoLogger.d("PendoOverlayRegistry", "unregisterObserver -> removed observer " + observer + " from root " + root.hashCode());
            c0478a.getOverlay().b(observer);
            if (c0478a.a().isEmpty()) {
                root.removeView(c0478a.getOverlay());
                weakHashMap.remove(root);
                PendoLogger.d("PendoOverlayRegistry", "unregisterObserver -> removed overlay from root " + root.hashCode());
            }
        }
    }

    public final void a(ViewGroup root, c observer) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(observer, "observer");
        WeakHashMap<ViewGroup, C0478a> weakHashMap = overlays;
        C0478a c0478aA = weakHashMap.get(root);
        if (c0478aA == null) {
            c0478aA = a(root);
            weakHashMap.put(root, c0478aA);
        }
        Intrinsics.checkNotNull(c0478aA);
        if (c0478aA.a().add(observer)) {
            PendoLogger.d("PendoOverlayRegistry", "registerObserver -> adding observer " + observer + " to root " + root.hashCode());
            c0478aA.getOverlay().a(observer);
        }
    }
}
