package androidx.navigation.testing;

import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavViewModelStoreProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestNavigatorState.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"androidx/navigation/testing/TestNavigatorState$viewModelStoreProvider$1", "Landroidx/navigation/NavViewModelStoreProvider;", "viewModelStores", "", "", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "backStackEntryId", "navigation-testing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestNavigatorState$viewModelStoreProvider$1 implements NavViewModelStoreProvider {
    private final Map<String, ViewModelStore> viewModelStores = new LinkedHashMap();

    TestNavigatorState$viewModelStoreProvider$1() {
    }

    @Override // androidx.navigation.NavViewModelStoreProvider
    public ViewModelStore getViewModelStore(String backStackEntryId) {
        Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
        Map<String, ViewModelStore> map = this.viewModelStores;
        ViewModelStore viewModelStore = map.get(backStackEntryId);
        if (viewModelStore == null) {
            viewModelStore = new ViewModelStore();
            map.put(backStackEntryId, viewModelStore);
        }
        return viewModelStore;
    }
}
