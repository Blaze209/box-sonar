package expo.modules.kotlin.views;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"withIf", "Lexpo/modules/kotlin/views/ComposableScope;", "condition", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "with", "rowScope", "Landroidx/compose/foundation/layout/RowScope;", "columnScope", "Landroidx/compose/foundation/layout/ColumnScope;", "boxScope", "Landroidx/compose/foundation/layout/BoxScope;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExpoComposeViewKt {
    public static final ComposableScope withIf(ComposableScope composableScope, boolean z, Function1<? super ComposableScope, ComposableScope> block) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return z ? block.invoke(composableScope) : composableScope;
    }

    public static final ComposableScope with(ComposableScope composableScope, RowScope rowScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        return ComposableScope.copy$default(composableScope, rowScope, null, null, null, 14, null);
    }

    public static final ComposableScope with(ComposableScope composableScope, ColumnScope columnScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        return ComposableScope.copy$default(composableScope, null, columnScope, null, null, 13, null);
    }

    public static final ComposableScope with(ComposableScope composableScope, BoxScope boxScope) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        return ComposableScope.copy$default(composableScope, null, null, boxScope, null, 11, null);
    }

    public static final ComposableScope with(ComposableScope composableScope, NestedScrollConnection nestedScrollConnection) {
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        return ComposableScope.copy$default(composableScope, null, null, null, nestedScrollConnection, 7, null);
    }
}
