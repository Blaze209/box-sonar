package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.SegmentedButtonColors;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class PickerViewKt$PickerContent$SegmentedComposable$1 implements Function3<SingleChoiceSegmentedButtonRowScope, Composer, Integer, Unit> {
    final /* synthetic */ PickerColors $colors;
    final /* synthetic */ Function1<PickerOptionSelectedEvent, Unit> $onOptionSelected;
    final /* synthetic */ String[] $options;
    final /* synthetic */ PickerProps $props;
    final /* synthetic */ Integer $selectedIndex;
    final /* synthetic */ FunctionalComposableScope $this_PickerContent;

    /* JADX WARN: Multi-variable type inference failed */
    PickerViewKt$PickerContent$SegmentedComposable$1(String[] strArr, PickerProps pickerProps, FunctionalComposableScope functionalComposableScope, Integer num, PickerColors pickerColors, Function1<? super PickerOptionSelectedEvent, Unit> function1) {
        this.$options = strArr;
        this.$props = pickerProps;
        this.$this_PickerContent = functionalComposableScope;
        this.$selectedIndex = num;
        this.$colors = pickerColors;
        this.$onOptionSelected = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, Composer composer, Integer num) {
        invoke(singleChoiceSegmentedButtonRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1, int i, String str) {
        function1.invoke(new PickerOptionSelectedEvent(i, str));
        return Unit.INSTANCE;
    }

    public final void invoke(SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer2, "C*94@2767L82,101@2994L83,104@3202L962,98@2871L83,103@3142L15,93@2708L1466:PickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 19) == 18 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2118909852, i2, -1, "expo.modules.ui.PickerContent.SegmentedComposable.<anonymous> (PickerView.kt:92)");
        }
        String[] strArr = this.$options;
        PickerProps pickerProps = this.$props;
        FunctionalComposableScope functionalComposableScope = this.$this_PickerContent;
        Integer num = this.$selectedIndex;
        PickerColors pickerColors = this.$colors;
        final Function1<PickerOptionSelectedEvent, Unit> function1 = this.$onOptionSelected;
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            final String str = strArr[i3];
            int i5 = i4 + 1;
            int i6 = length;
            int i7 = i3;
            final int i8 = i4;
            Shape shapeItemShape = SegmentedButtonDefaults.INSTANCE.itemShape(i8, strArr.length, null, composer2, 3072, 4);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(pickerProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
            boolean z = num != null && i8 == num.intValue();
            SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
            long compose = UtilsKt.getCompose(pickerColors.getActiveBorderColor());
            long compose2 = UtilsKt.getCompose(pickerColors.getActiveContentColor());
            long compose3 = UtilsKt.getCompose(pickerColors.getInactiveBorderColor());
            long compose4 = UtilsKt.getCompose(pickerColors.getInactiveContentColor());
            long compose5 = UtilsKt.getCompose(pickerColors.getDisabledActiveBorderColor());
            FunctionalComposableScope functionalComposableScope2 = functionalComposableScope;
            Integer num2 = num;
            PickerProps pickerProps2 = pickerProps;
            boolean z2 = z;
            int i9 = i2;
            String[] strArr2 = strArr;
            PickerColors pickerColors2 = pickerColors;
            SegmentedButtonColors segmentedButtonColorsM4139colorsXqyqHi0 = segmentedButtonDefaults.m4139colorsXqyqHi0(UtilsKt.getCompose(pickerColors.getActiveContainerColor()), compose2, compose, UtilsKt.getCompose(pickerColors.getInactiveContainerColor()), compose4, compose3, UtilsKt.getCompose(pickerColors.getDisabledActiveContainerColor()), UtilsKt.getCompose(pickerColors.getDisabledActiveContentColor()), compose5, UtilsKt.getCompose(pickerColors.getDisabledInactiveContainerColor()), UtilsKt.getCompose(pickerColors.getDisabledInactiveContentColor()), UtilsKt.getCompose(pickerColors.getDisabledInactiveBorderColor()), composer, 0, 384, 0);
            composer.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composer, "CC(remember):PickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(i8) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.PickerViewKt$PickerContent$SegmentedComposable$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PickerViewKt$PickerContent$SegmentedComposable$1.invoke$lambda$2$lambda$1$lambda$0(function1, i8, str);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            SegmentedButtonKt.SegmentedButton(SingleChoiceSegmentedButtonRow, z2, (Function0<Unit>) objRememberedValue, shapeItemShape, modifierApplyModifiers, false, segmentedButtonColorsM4139colorsXqyqHi0, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1871352972, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.PickerViewKt$PickerContent$SegmentedComposable$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num3) {
                    invoke(composer3, num3.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i10) {
                    ComposerKt.sourceInformation(composer3, "C103@3144L11:PickerView.kt#v15e7d");
                    if ((i10 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1871352972, i10, -1, "expo.modules.ui.PickerContent.SegmentedComposable.<anonymous>.<anonymous>.<anonymous> (PickerView.kt:103)");
                    }
                    TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, i9 & 14, 48, 976);
            i3 = i7 + 1;
            composer2 = composer;
            function1 = function1;
            i4 = i5;
            length = i6;
            i2 = i9;
            strArr = strArr2;
            pickerProps = pickerProps2;
            functionalComposableScope = functionalComposableScope2;
            num = num2;
            pickerColors = pickerColors2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
