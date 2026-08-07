package androidx.navigation.testing;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.NavHostController;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestNavHostController.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\f\b\u0002\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\f\b\u0002\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/navigation/testing/TestNavHostController;", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "backStack", "", "Landroidx/navigation/NavBackStackEntry;", "getBackStack", "()Ljava/util/List;", "setCurrentDestination", "", "destId", "", "args", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "destRoute", "", "navigation-testing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestNavHostController extends NavHostController {
    public final void setCurrentDestination(int i) {
        setCurrentDestination$default(this, i, (Bundle) null, 2, (Object) null);
    }

    public final void setCurrentDestination(String destRoute) {
        Intrinsics.checkNotNullParameter(destRoute, "destRoute");
        setCurrentDestination$default(this, destRoute, (Bundle) null, 2, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestNavHostController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setNavigatorProvider(new TestNavigatorProvider());
    }

    public final List<NavBackStackEntry> getBackStack() {
        return getCurrentBackStack().getValue();
    }

    public final void setCurrentDestination(int destId, Bundle args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (!handleDeepLink(NavDeepLinkBuilder.setDestination$default(createDeepLink(), destId, (Bundle) null, 2, (Object) null).setArguments(args).createTaskStackBuilder().editIntentAt(0))) {
            throw new IllegalArgumentException("Destination does not exist on the NavGraph.".toString());
        }
    }

    public final void setCurrentDestination(String destRoute, Bundle args) {
        Intrinsics.checkNotNullParameter(destRoute, "destRoute");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!handleDeepLink(NavDeepLinkBuilder.setDestination$default(createDeepLink(), destRoute, (Bundle) null, 2, (Object) null).setArguments(args).createTaskStackBuilder().editIntentAt(0))) {
            throw new IllegalArgumentException("Destination does not exist on the NavGraph.".toString());
        }
    }

    public static /* synthetic */ void setCurrentDestination$default(TestNavHostController testNavHostController, int i, Bundle bundle, int i2, Object obj) {
        Pair[] pairArr;
        if ((i2 & 2) != 0) {
            Map mapEmptyMap = MapsKt.emptyMap();
            if (mapEmptyMap.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                for (Map.Entry entry : mapEmptyMap.entrySet()) {
                    arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            SavedStateWriter.m11040constructorimpl(bundle);
        }
        testNavHostController.setCurrentDestination(i, bundle);
    }

    public static /* synthetic */ void setCurrentDestination$default(TestNavHostController testNavHostController, String str, Bundle bundle, int i, Object obj) {
        Pair[] pairArr;
        if ((i & 2) != 0) {
            Map mapEmptyMap = MapsKt.emptyMap();
            if (mapEmptyMap.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                for (Map.Entry entry : mapEmptyMap.entrySet()) {
                    arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            SavedStateWriter.m11040constructorimpl(bundle);
        }
        testNavHostController.setCurrentDestination(str, bundle);
    }
}
