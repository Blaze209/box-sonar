package com.swmansion.rnscreens.gamma.stack.header;

import android.R;
import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderType;
import com.swmansion.rnscreens.utils.DimensionUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \f2\u00020\u0001:\u0003\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "Small", "Collapsing", "Companion", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout$Collapsing;", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout$Small;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class StackHeaderAppBarLayout extends AppBarLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ StackHeaderAppBarLayout(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public abstract MaterialToolbar getToolbar();

    private StackHeaderAppBarLayout(Context context) {
        super(context);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        layoutParams.setBehavior(new StackHeaderAppBarLayoutBehavior());
        setLayoutParams(layoutParams);
        setLiftOnScroll(true);
        setFitsSystemWindows(true);
    }

    /* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout$Small;", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Small extends StackHeaderAppBarLayout {
        private final MaterialToolbar toolbar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Small(Context context) {
            super(context, null);
            Intrinsics.checkNotNullParameter(context, "context");
            MaterialToolbar materialToolbar = new MaterialToolbar(context);
            materialToolbar.setElevation(0.0f);
            materialToolbar.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
            this.toolbar = materialToolbar;
            addView(getToolbar());
        }

        @Override // com.swmansion.rnscreens.gamma.stack.header.StackHeaderAppBarLayout
        public MaterialToolbar getToolbar() {
            return this.toolbar;
        }
    }

    /* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout$Collapsing;", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "context", "Landroid/content/Context;", "type", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "<init>", "(Landroid/content/Context;Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;)V", "getType", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "collapsingToolbarLayout", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbarLayout$react_native_screens_release", "()Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Collapsing extends StackHeaderAppBarLayout {
        private final CollapsingToolbarLayout collapsingToolbarLayout;
        private final MaterialToolbar toolbar;
        private final StackHeaderType type;

        /* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[StackHeaderType.values().length];
                try {
                    iArr[StackHeaderType.MEDIUM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StackHeaderType.LARGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final StackHeaderType getType() {
            return this.type;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Collapsing(Context context, StackHeaderType type) {
            Pair pair;
            super(context, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            MaterialToolbar materialToolbar = new MaterialToolbar(context);
            materialToolbar.setElevation(0.0f);
            CollapsingToolbarLayout.LayoutParams layoutParams = new CollapsingToolbarLayout.LayoutParams(-1, DimensionUtilsKt.resolveDimensionAttr(context, R.attr.actionBarSize));
            layoutParams.setCollapseMode(1);
            materialToolbar.setLayoutParams(layoutParams);
            this.toolbar = materialToolbar;
            int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
            if (i == 1) {
                pair = new Pair(Integer.valueOf(com.google.android.material.R.attr.collapsingToolbarLayoutMediumStyle), Integer.valueOf(com.google.android.material.R.attr.collapsingToolbarLayoutMediumSize));
            } else if (i == 2) {
                pair = new Pair(Integer.valueOf(com.google.android.material.R.attr.collapsingToolbarLayoutLargeStyle), Integer.valueOf(com.google.android.material.R.attr.collapsingToolbarLayoutLargeSize));
            } else {
                throw new IllegalStateException("[RNScreens] Invalid header mode.".toString());
            }
            int iIntValue = ((Number) pair.component1()).intValue();
            int iIntValue2 = ((Number) pair.component2()).intValue();
            CollapsingToolbarLayout collapsingToolbarLayout = new CollapsingToolbarLayout(context, null, iIntValue);
            collapsingToolbarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, DimensionUtilsKt.resolveDimensionAttr(context, iIntValue2)));
            collapsingToolbarLayout.addView(getToolbar());
            this.collapsingToolbarLayout = collapsingToolbarLayout;
            if (type != StackHeaderType.MEDIUM && type != StackHeaderType.LARGE) {
                throw new IllegalArgumentException("[RNScreens] Collapsing StackHeaderAppBarLayout must be MEDIUM or LARGE type.".toString());
            }
            addView(collapsingToolbarLayout);
        }

        @Override // com.swmansion.rnscreens.gamma.stack.header.StackHeaderAppBarLayout
        public MaterialToolbar getToolbar() {
            return this.toolbar;
        }

        /* JADX INFO: renamed from: getCollapsingToolbarLayout$react_native_screens_release, reason: from getter */
        public final CollapsingToolbarLayout getCollapsingToolbarLayout() {
            return this.collapsingToolbarLayout;
        }
    }

    /* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "context", "Landroid/content/Context;", "type", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: StackHeaderAppBarLayout.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[StackHeaderType.values().length];
                try {
                    iArr[StackHeaderType.SMALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StackHeaderType.MEDIUM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[StackHeaderType.LARGE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StackHeaderAppBarLayout create(Context context, StackHeaderType type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return new Small(context);
            }
            if (i == 2 || i == 3) {
                return new Collapsing(context, type);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
