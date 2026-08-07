package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLString;
import external.sdk.pendo.io.mozilla.javascript.NativeSymbol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/constraintlayout/compose/DimensionSymbol;", "", "value", "Landroidx/compose/ui/unit/Dp;", NativeSymbol.TYPE_NAME, "", "debugName", "(Landroidx/compose/ui/unit/Dp;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "asCLElement", "Landroidx/constraintlayout/core/parser/CLElement;", "isUndefined", "", "update", "", "dp", "update-0680j_4", "(F)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DimensionSymbol {
    public static final int $stable = 8;
    private final String debugName;
    private String symbol;
    private Dp value;

    public /* synthetic */ DimensionSymbol(Dp dp, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(dp, str, str2);
    }

    private DimensionSymbol(Dp dp, String str, String str2) {
        this.value = dp;
        this.symbol = str;
        this.debugName = str2;
    }

    /* JADX INFO: renamed from: update-0680j_4, reason: not valid java name */
    public final void m10048update0680j_4(float dp) {
        this.value = Dp.m9685boximpl(dp);
        this.symbol = null;
    }

    public final void update(String symbol) {
        this.value = null;
        this.symbol = symbol;
    }

    public final boolean isUndefined() {
        return this.value == null && this.symbol == null;
    }

    public final CLElement asCLElement() {
        Dp dp = this.value;
        if (dp != null) {
            return new CLNumber(dp.m9701unboximpl());
        }
        String str = this.symbol;
        if (str != null) {
            return CLString.from(str);
        }
        Log.e("CCL", "DimensionDescription: Null value & symbol for " + this.debugName + ". Using WrapContent.");
        return CLString.from("wrap");
    }
}
