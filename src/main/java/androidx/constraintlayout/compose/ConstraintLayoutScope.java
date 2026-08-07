package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\f\u0010\u0013\u001a\u00060\u0011R\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J-\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\u0002\b\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\n\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "()V", "ChildrenStartIndex", "", "childId", "childrenRefs", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Lkotlin/collections/ArrayList;", "isAnimateChanges", "", "isAnimateChanges$annotations", "()Z", "setAnimateChanges", "(Z)V", "referencesObject", "Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "createRef", "createRefs", "reset", "", "constrainAs", "Landroidx/compose/ui/Modifier;", "ref", "constrainBlock", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "Lkotlin/ExtensionFunctionType;", "ConstrainAsModifier", "ConstrainedLayoutReferences", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConstraintLayoutScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private final int ChildrenStartIndex;
    private int childId;
    private final ArrayList<ConstrainedLayoutReference> childrenRefs;
    private boolean isAnimateChanges;
    private ConstrainedLayoutReferences referencesObject;

    public static /* synthetic */ void isAnimateChanges$annotations() {
    }

    public ConstraintLayoutScope() {
        super(null);
        this.childId = this.ChildrenStartIndex;
        this.childrenRefs = new ArrayList<>();
    }

    public final ConstrainedLayoutReference createRef() {
        ArrayList<ConstrainedLayoutReference> arrayList = this.childrenRefs;
        int i = this.childId;
        this.childId = i + 1;
        ConstrainedLayoutReference constrainedLayoutReference = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList, i);
        if (constrainedLayoutReference != null) {
            return constrainedLayoutReference;
        }
        ConstrainedLayoutReference constrainedLayoutReference2 = new ConstrainedLayoutReference(Integer.valueOf(this.childId));
        this.childrenRefs.add(constrainedLayoutReference2);
        return constrainedLayoutReference2;
    }

    public final ConstrainedLayoutReferences createRefs() {
        ConstrainedLayoutReferences constrainedLayoutReferences = this.referencesObject;
        if (constrainedLayoutReferences != null) {
            return constrainedLayoutReferences;
        }
        ConstrainedLayoutReferences constrainedLayoutReferences2 = new ConstrainedLayoutReferences();
        this.referencesObject = constrainedLayoutReferences2;
        return constrainedLayoutReferences2;
    }

    /* JADX INFO: renamed from: isAnimateChanges, reason: from getter */
    public final boolean getIsAnimateChanges() {
        return this.isAnimateChanges;
    }

    public final void setAnimateChanges(boolean z) {
        this.isAnimateChanges = z;
    }

    @Override // androidx.constraintlayout.compose.ConstraintLayoutBaseScope
    public void reset() {
        super.reset();
        this.childId = this.ChildrenStartIndex;
    }

    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0086\u0002J\t\u0010\b\u001a\u00020\u0004H\u0086\u0002J\t\u0010\t\u001a\u00020\u0004H\u0086\u0002J\t\u0010\n\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0086\u0002J\t\u0010\f\u001a\u00020\u0004H\u0086\u0002J\t\u0010\r\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0086\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0086\u0002¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "", "(Landroidx/constraintlayout/compose/ConstraintLayoutScope;)V", "component1", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ConstrainedLayoutReferences {
        public ConstrainedLayoutReferences() {
        }

        public final ConstrainedLayoutReference component1() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component2() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component3() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component4() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component5() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component6() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component7() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component8() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component9() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component10() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component11() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component12() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component13() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component14() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component15() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component16() {
            return ConstraintLayoutScope.this.createRef();
        }
    }

    public final Modifier constrainAs(Modifier modifier, ConstrainedLayoutReference constrainedLayoutReference, Function1<? super ConstrainScope, Unit> function1) {
        if (this.isAnimateChanges) {
            function1.invoke(new ConstrainScope(constrainedLayoutReference.getId(), asCLContainer$constraintlayout_compose_release(constrainedLayoutReference)));
        }
        return modifier.then(new ConstrainAsModifier(constrainedLayoutReference, function1));
    }

    /* JADX INFO: compiled from: ConstraintLayout.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainAsModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "constrainBlock", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "modifyParentData", "Landroidx/constraintlayout/compose/ConstraintLayoutParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ConstrainAsModifier extends InspectorValueInfo implements ParentDataModifier {
        private final Function1<ConstrainScope, Unit> constrainBlock;
        private final ConstrainedLayoutReference ref;

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public ConstraintLayoutParentData modifyParentData(Density density, Object obj) {
            return new ConstraintLayoutParentData(this.ref, this.constrainBlock);
        }

        public int hashCode() {
            return this.constrainBlock.hashCode();
        }

        public boolean equals(Object other) {
            Function1<ConstrainScope, Unit> function1 = this.constrainBlock;
            ConstrainAsModifier constrainAsModifier = other instanceof ConstrainAsModifier ? (ConstrainAsModifier) other : null;
            return function1 == (constrainAsModifier != null ? constrainAsModifier.constrainBlock : null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ConstrainAsModifier(final ConstrainedLayoutReference constrainedLayoutReference, final Function1<? super ConstrainScope, Unit> function1) {
            super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("constrainAs");
                    inspectorInfo.getProperties().set("ref", constrainedLayoutReference);
                    inspectorInfo.getProperties().set("constrainBlock", function1);
                }
            } : InspectableValueKt.getNoInspectorInfo());
            this.ref = constrainedLayoutReference;
            this.constrainBlock = function1;
        }
    }
}
