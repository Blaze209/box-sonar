package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\b\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/DimensionDescription;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "value", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "valueSymbol", "", "(Ljava/lang/String;)V", "(Landroidx/compose/ui/unit/Dp;Ljava/lang/String;)V", "max", "Landroidx/constraintlayout/compose/DimensionSymbol;", "getMax$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/DimensionSymbol;", "min", "getMin$constraintlayout_compose_release", "asCLElement", "Landroidx/constraintlayout/core/parser/CLElement;", "asCLElement$constraintlayout_compose_release", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DimensionDescription implements Dimension.Coercible, Dimension.MinCoercible, Dimension.MaxCoercible, Dimension {
    public static final int $stable = 8;
    private final DimensionSymbol max;
    private final DimensionSymbol min;
    private final DimensionSymbol valueSymbol;

    public /* synthetic */ DimensionDescription(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    private DimensionDescription(Dp dp, String str) {
        this.valueSymbol = new DimensionSymbol(dp, str, "base", null);
        this.min = new DimensionSymbol(null, null, "min", null);
        this.max = new DimensionSymbol(null, null, "max", null);
    }

    private DimensionDescription(float f) {
        this(Dp.m9685boximpl(f), (String) null);
    }

    public DimensionDescription(String str) {
        this((Dp) null, str);
    }

    /* JADX INFO: renamed from: getMin$constraintlayout_compose_release, reason: from getter */
    public final DimensionSymbol getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: getMax$constraintlayout_compose_release, reason: from getter */
    public final DimensionSymbol getMax() {
        return this.max;
    }

    public final CLElement asCLElement$constraintlayout_compose_release() {
        if (this.min.isUndefined() && this.max.isUndefined()) {
            return this.valueSymbol.asCLElement();
        }
        CLObject cLObject = new CLObject(new char[0]);
        if (!this.min.isUndefined()) {
            cLObject.put("min", this.min.asCLElement());
        }
        if (!this.max.isUndefined()) {
            cLObject.put("max", this.max.asCLElement());
        }
        cLObject.put("value", this.valueSymbol.asCLElement());
        return cLObject;
    }
}
