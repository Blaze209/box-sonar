package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"androidx/compose/material3/ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "exposedDropdownSize", "matchAnchorWidth", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 extends ExposedDropdownMenuBoxScopeImpl {
    final /* synthetic */ MutableState<Boolean> $alwaysFocusable;
    final /* synthetic */ MutableState<ExposedDropdownMenuAnchorType> $anchorTypeState;
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ String $toggleDescription;

    /* JADX WARN: Multi-variable type inference failed */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(FocusRequester focusRequester, boolean z, MutableState<Boolean> mutableState, String str, String str2, String str3, SoftwareKeyboardController softwareKeyboardController, MutableState<ExposedDropdownMenuAnchorType> mutableState2, Function1<? super Boolean, Unit> function1, MutableIntState mutableIntState, MutableIntState mutableIntState2) {
        this.$focusRequester = focusRequester;
        this.$expanded = z;
        this.$alwaysFocusable = mutableState;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$toggleDescription = str3;
        this.$keyboardController = softwareKeyboardController;
        this.$anchorTypeState = mutableState2;
        this.$onExpandedChange = function1;
        this.$anchorWidth$delegate = mutableIntState;
        this.$menuMaxHeight$delegate = mutableIntState2;
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    /* JADX INFO: renamed from: menuAnchor-2Hz36ac */
    public Modifier mo3330menuAnchor2Hz36ac(Modifier modifier, final String str, boolean z) {
        Modifier.Companion companionM3344expandable32CpT8;
        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(modifier, this.$focusRequester);
        final MutableState<ExposedDropdownMenuAnchorType> mutableState = this.$anchorTypeState;
        Modifier modifierThen = modifierFocusRequester.then(new ExposedDropdownMenuAnchorElement(new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.menuAnchor_2Hz36ac$lambda$0(str, mutableState);
            }
        }));
        if (!z) {
            companionM3344expandable32CpT8 = Modifier.INSTANCE;
        } else {
            Modifier.Companion companion = Modifier.INSTANCE;
            final boolean z2 = this.$expanded;
            final MutableState<ExposedDropdownMenuAnchorType> mutableState2 = this.$anchorTypeState;
            final Function1<Boolean, Unit> function1 = this.$onExpandedChange;
            companionM3344expandable32CpT8 = ExposedDropdownMenuKt.m3344expandable32CpT8(companion, z2, new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.menuAnchor_2Hz36ac$lambda$1(mutableState2, str, function1, z2);
                }
            }, str, this.$alwaysFocusable, this.$expandedDescription, this.$collapsedDescription, this.$toggleDescription, this.$keyboardController);
        }
        return modifierThen.then(companionM3344expandable32CpT8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuAnchor_2Hz36ac$lambda$0(String str, MutableState mutableState) {
        if (ExposedDropdownMenuKt.m3345hasGreaterOrEqualPriorityThanvVDBVkM(str, ((ExposedDropdownMenuAnchorType) mutableState.getValue()).getName())) {
            mutableState.setValue(ExposedDropdownMenuAnchorType.m3315boximpl(str));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit menuAnchor_2Hz36ac$lambda$1(MutableState mutableState, String str, Function1 function1, boolean z) {
        mutableState.setValue(ExposedDropdownMenuAnchorType.m3315boximpl(str));
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3 */
    public String mo3329getAnchorTypeoYjWRB4$material3() {
        return this.$anchorTypeState.getValue().getName();
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    public boolean getAlwaysFocusable$material3() {
        return this.$alwaysFocusable.getValue().booleanValue();
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    public Modifier exposedDropdownSize(Modifier modifier, final boolean z) {
        final MutableIntState mutableIntState = this.$anchorWidth$delegate;
        final MutableIntState mutableIntState2 = this.$menuMaxHeight$delegate;
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.exposedDropdownSize$lambda$2(z, mutableIntState, mutableIntState2, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult exposedDropdownSize$lambda$2(boolean z, MutableIntState mutableIntState, MutableIntState mutableIntState2, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(constraints.getValue(), ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableIntState));
        int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(constraints.getValue(), ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$8(mutableIntState2));
        int iM9642getMinWidthimpl = z ? iM9657constrainWidthK40F9xA : Constraints.m9642getMinWidthimpl(constraints.getValue());
        if (!z) {
            iM9657constrainWidthK40F9xA = Constraints.m9640getMaxWidthimpl(constraints.getValue());
        }
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), iM9642getMinWidthimpl, iM9657constrainWidthK40F9xA, 0, iM9656constrainHeightK40F9xA, 4, null));
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.exposedDropdownSize$lambda$2$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exposedDropdownSize$lambda$2$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
