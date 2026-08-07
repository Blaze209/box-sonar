package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSONConstraintSet.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001e\u0010\u001d\u001a\u00020\u00122\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u000fH\u0016J\u0016\u0010&\u001a\u00020\n2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000fH\u0016J\b\u00100\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/constraintlayout/compose/JSONConstraintSet;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "content", "", "overrideVariables", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/constraintlayout/compose/ConstraintSet;)V", "_isDirty", "", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "overridedVariables", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "applyLayoutVariables", "", "layoutVariables", "Landroidx/constraintlayout/core/state/ConstraintSetParser$LayoutVariables;", "applyTo", "transition", "Landroidx/constraintlayout/core/state/Transition;", "type", "", "applyToState", "state", "Landroidx/constraintlayout/compose/State;", "emitDesignElements", "designElements", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/core/state/ConstraintSetParser$DesignElement;", "Lkotlin/collections/ArrayList;", "equals", "other", "", "getForcedProgress", "isDirty", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "onNewContent", "onNewProgress", "progress", "override", "name", "value", "resetForcedProgress", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JSONConstraintSet extends EditableJSONLayout implements DerivedConstraintSet {
    public static final int $stable = 0;
    private boolean _isDirty;
    private final ConstraintSet extendFrom;
    private final String overrideVariables;
    private final HashMap<String, Float> overridedVariables;

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public float getForcedProgress() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void onNewProgress(float progress) {
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void resetForcedProgress() {
    }

    public /* synthetic */ JSONConstraintSet(String str, String str2, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : constraintSet);
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    public JSONConstraintSet(String str, String str2, ConstraintSet constraintSet) {
        super(str);
        this.extendFrom = constraintSet;
        this.overridedVariables = new HashMap<>();
        this.overrideVariables = str2;
        this._isDirty = true;
        initialization();
    }

    public boolean equals(Object other) {
        if (other instanceof JSONConstraintSet) {
            return Intrinsics.areEqual(getCurrentContent(), ((JSONConstraintSet) other).getCurrentContent());
        }
        return false;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean isDirty(List<? extends Measurable> measurables) {
        return this._isDirty;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(androidx.constraintlayout.core.state.Transition transition, int type) {
        applyLayoutVariables(new ConstraintSetParser.LayoutVariables());
        ConstraintSetParser.parseJSON(getCurrentContent(), transition, type);
    }

    public final void emitDesignElements(ArrayList<ConstraintSetParser.DesignElement> designElements) {
        try {
            designElements.clear();
            ConstraintSetParser.parseDesignElementsJSON(getCurrentContent(), designElements);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.constraintlayout.compose.DerivedConstraintSet
    public void applyToState(State state) {
        ConstraintSetParser.LayoutVariables layoutVariables = new ConstraintSetParser.LayoutVariables();
        applyLayoutVariables(layoutVariables);
        try {
            ConstraintSetParser.parseJSON(getCurrentContent(), state, layoutVariables);
            this._isDirty = false;
        } catch (Exception unused) {
            this._isDirty = true;
        }
    }

    @Override // androidx.constraintlayout.compose.EditableJSONLayout
    protected void onNewContent(String content) {
        super.onNewContent(content);
        this._isDirty = true;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public ConstraintSet override(String name, float value) {
        this.overridedVariables.put(name, Float.valueOf(value));
        return this;
    }

    private final void applyLayoutVariables(ConstraintSetParser.LayoutVariables layoutVariables) {
        String str = this.overrideVariables;
        if (str != null) {
            try {
                CLObject cLObject = CLParser.parse(str);
                int size = cLObject.size();
                for (int i = 0; i < size; i++) {
                    CLElement cLElement = cLObject.get(i);
                    Intrinsics.checkNotNull(cLElement, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                    CLKey cLKey = (CLKey) cLElement;
                    layoutVariables.putOverride(cLKey.content(), cLKey.getValue().getFloat());
                }
            } catch (CLParsingException e) {
                System.err.println("exception: " + e);
            }
        }
        for (String str2 : this.overridedVariables.keySet()) {
            Float f = this.overridedVariables.get(str2);
            Intrinsics.checkNotNull(f);
            layoutVariables.putOverride(str2, f.floatValue());
        }
    }
}
