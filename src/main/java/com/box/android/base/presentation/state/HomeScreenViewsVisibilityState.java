package com.box.android.base.presentation.state;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenViewsVisibilityState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "", "initialPrimaryTabRowVisible", "", "initialNavigationBarVisible", "<init>", "(ZZ)V", "<set-?>", "isPrimaryTabRowVisible", "()Z", "setPrimaryTabRowVisible", "(Z)V", "isPrimaryTabRowVisible$delegate", "Landroidx/compose/runtime/MutableState;", "isNavigationBarVisible", "setNavigationBarVisible", "isNavigationBarVisible$delegate", "showPrimaryTabRow", "", "hidePrimaryTabRow", "showNavigationBar", "hideNavigationBar", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenViewsVisibilityState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Saver<HomeScreenViewsVisibilityState, Pair<Boolean, Boolean>> Saver = SaverKt.Saver(new Function2() { // from class: com.box.android.base.presentation.state.HomeScreenViewsVisibilityState$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return HomeScreenViewsVisibilityState.Saver$lambda$0((SaverScope) obj, (HomeScreenViewsVisibilityState) obj2);
        }
    }, new Function1() { // from class: com.box.android.base.presentation.state.HomeScreenViewsVisibilityState$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HomeScreenViewsVisibilityState.Saver$lambda$1((Pair) obj);
        }
    });

    /* JADX INFO: renamed from: isNavigationBarVisible$delegate, reason: from kotlin metadata */
    private final MutableState isNavigationBarVisible;

    /* JADX INFO: renamed from: isPrimaryTabRowVisible$delegate, reason: from kotlin metadata */
    private final MutableState isPrimaryTabRowVisible;

    /* JADX WARN: Illegal instructions before constructor call */
    public HomeScreenViewsVisibilityState() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public HomeScreenViewsVisibilityState(boolean z, boolean z2) {
        this.isPrimaryTabRowVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.isNavigationBarVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
    }

    public /* synthetic */ HomeScreenViewsVisibilityState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    private final void setPrimaryTabRowVisible(boolean z) {
        this.isPrimaryTabRowVisible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPrimaryTabRowVisible() {
        return ((Boolean) this.isPrimaryTabRowVisible.getValue()).booleanValue();
    }

    private final void setNavigationBarVisible(boolean z) {
        this.isNavigationBarVisible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isNavigationBarVisible() {
        return ((Boolean) this.isNavigationBarVisible.getValue()).booleanValue();
    }

    public final void showPrimaryTabRow() {
        setPrimaryTabRowVisible(true);
    }

    public final void hidePrimaryTabRow() {
        setPrimaryTabRowVisible(false);
    }

    public final void showNavigationBar() {
        setNavigationBarVisible(true);
    }

    public final void hideNavigationBar() {
        setNavigationBarVisible(false);
    }

    /* JADX INFO: compiled from: HomeScreenViewsVisibilityState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "Lkotlin/Pair;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<HomeScreenViewsVisibilityState, Pair<Boolean, Boolean>> getSaver() {
            return HomeScreenViewsVisibilityState.Saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair Saver$lambda$0(SaverScope Saver2, HomeScreenViewsVisibilityState state) {
        Intrinsics.checkNotNullParameter(Saver2, "$this$Saver");
        Intrinsics.checkNotNullParameter(state, "state");
        return new Pair(Boolean.valueOf(state.isPrimaryTabRowVisible()), Boolean.valueOf(state.isNavigationBarVisible()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeScreenViewsVisibilityState Saver$lambda$1(Pair savedPair) {
        Intrinsics.checkNotNullParameter(savedPair, "savedPair");
        return new HomeScreenViewsVisibilityState(((Boolean) savedPair.getFirst()).booleanValue(), ((Boolean) savedPair.getSecond()).booleanValue());
    }
}
