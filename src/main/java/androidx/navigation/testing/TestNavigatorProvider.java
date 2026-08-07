package androidx.navigation.testing;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TestNavigatorProvider.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\b*\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/navigation/testing/TestNavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "<init>", "()V", "navigator", "androidx/navigation/testing/TestNavigatorProvider$navigator$1", "Landroidx/navigation/testing/TestNavigatorProvider$navigator$1;", "getNavigator", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "name", "", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "navigation-testing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestNavigatorProvider extends NavigatorProvider {
    private final TestNavigatorProvider$navigator$1 navigator;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.navigation.testing.TestNavigatorProvider$navigator$1] */
    public TestNavigatorProvider() {
        ?? r0 = new Navigator<NavDestination>() { // from class: androidx.navigation.testing.TestNavigatorProvider$navigator$1
            @Override // androidx.navigation.Navigator
            public NavDestination createDestination() {
                return new NavDestination("test");
            }
        };
        this.navigator = r0;
        addNavigator(new NavGraphNavigator(this));
        addNavigator("test", (Navigator) r0);
    }

    @Override // androidx.navigation.NavigatorProvider
    public <T extends Navigator<? extends NavDestination>> T getNavigator(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return (T) super.getNavigator(name);
        } catch (IllegalStateException unused) {
            TestNavigatorProvider$navigator$1 testNavigatorProvider$navigator$1 = this.navigator;
            Intrinsics.checkNotNull(testNavigatorProvider$navigator$1, "null cannot be cast to non-null type T of androidx.navigation.testing.TestNavigatorProvider.getNavigator");
            return testNavigatorProvider$navigator$1;
        }
    }
}
