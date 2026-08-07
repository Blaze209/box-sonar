package expo.modules.kotlin.views;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/views/ComposableScope;", "", "rowScope", "Landroidx/compose/foundation/layout/RowScope;", "columnScope", "Landroidx/compose/foundation/layout/ColumnScope;", "boxScope", "Landroidx/compose/foundation/layout/BoxScope;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "<init>", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getRowScope", "()Landroidx/compose/foundation/layout/RowScope;", "getColumnScope", "()Landroidx/compose/foundation/layout/ColumnScope;", "getBoxScope", "()Landroidx/compose/foundation/layout/BoxScope;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ComposableScope {
    public static final int $stable = 8;
    private final BoxScope boxScope;
    private final ColumnScope columnScope;
    private final NestedScrollConnection nestedScrollConnection;
    private final RowScope rowScope;

    public ComposableScope() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ComposableScope copy$default(ComposableScope composableScope, RowScope rowScope, ColumnScope columnScope, BoxScope boxScope, NestedScrollConnection nestedScrollConnection, int i, Object obj) {
        if ((i & 1) != 0) {
            rowScope = composableScope.rowScope;
        }
        if ((i & 2) != 0) {
            columnScope = composableScope.columnScope;
        }
        if ((i & 4) != 0) {
            boxScope = composableScope.boxScope;
        }
        if ((i & 8) != 0) {
            nestedScrollConnection = composableScope.nestedScrollConnection;
        }
        return composableScope.copy(rowScope, columnScope, boxScope, nestedScrollConnection);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RowScope getRowScope() {
        return this.rowScope;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColumnScope getColumnScope() {
        return this.columnScope;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BoxScope getBoxScope() {
        return this.boxScope;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public final ComposableScope copy(RowScope rowScope, ColumnScope columnScope, BoxScope boxScope, NestedScrollConnection nestedScrollConnection) {
        return new ComposableScope(rowScope, columnScope, boxScope, nestedScrollConnection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComposableScope)) {
            return false;
        }
        ComposableScope composableScope = (ComposableScope) other;
        return Intrinsics.areEqual(this.rowScope, composableScope.rowScope) && Intrinsics.areEqual(this.columnScope, composableScope.columnScope) && Intrinsics.areEqual(this.boxScope, composableScope.boxScope) && Intrinsics.areEqual(this.nestedScrollConnection, composableScope.nestedScrollConnection);
    }

    public int hashCode() {
        RowScope rowScope = this.rowScope;
        int iHashCode = (rowScope == null ? 0 : rowScope.hashCode()) * 31;
        ColumnScope columnScope = this.columnScope;
        int iHashCode2 = (iHashCode + (columnScope == null ? 0 : columnScope.hashCode())) * 31;
        BoxScope boxScope = this.boxScope;
        int iHashCode3 = (iHashCode2 + (boxScope == null ? 0 : boxScope.hashCode())) * 31;
        NestedScrollConnection nestedScrollConnection = this.nestedScrollConnection;
        return iHashCode3 + (nestedScrollConnection != null ? nestedScrollConnection.hashCode() : 0);
    }

    public String toString() {
        return "ComposableScope(rowScope=" + this.rowScope + ", columnScope=" + this.columnScope + ", boxScope=" + this.boxScope + ", nestedScrollConnection=" + this.nestedScrollConnection + ")";
    }

    public ComposableScope(RowScope rowScope, ColumnScope columnScope, BoxScope boxScope, NestedScrollConnection nestedScrollConnection) {
        this.rowScope = rowScope;
        this.columnScope = columnScope;
        this.boxScope = boxScope;
        this.nestedScrollConnection = nestedScrollConnection;
    }

    public /* synthetic */ ComposableScope(RowScope rowScope, ColumnScope columnScope, BoxScope boxScope, NestedScrollConnection nestedScrollConnection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rowScope, (i & 2) != 0 ? null : columnScope, (i & 4) != 0 ? null : boxScope, (i & 8) != 0 ? null : nestedScrollConnection);
    }

    public final RowScope getRowScope() {
        return this.rowScope;
    }

    public final ColumnScope getColumnScope() {
        return this.columnScope;
    }

    public final BoxScope getBoxScope() {
        return this.boxScope;
    }

    public final NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }
}
