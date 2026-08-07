package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SecureTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class SecureTextFieldKt$OutlinedSecureTextField$3 implements TextFieldDecorator {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX WARN: Multi-variable type inference failed */
    SecureTextFieldKt$OutlinedSecureTextField$3(TextFieldState textFieldState, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, TextFieldColors textFieldColors) {
        this.$state = textFieldState;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$isError = z2;
        this.$label = function2;
        this.$placeholder = function3;
        this.$leadingIcon = function4;
        this.$trailingIcon = function5;
        this.$shape = shape;
        this.$colors = textFieldColors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$1(SecureTextFieldKt$OutlinedSecureTextField$3 secureTextFieldKt$OutlinedSecureTextField$3, Function2 function2, int i, Composer composer, int i2) {
        secureTextFieldKt$OutlinedSecureTextField$3.Decoration(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.input.TextFieldDecorator
    public final void Decoration(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-741592697);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Decoration)N(innerTextField)296@16549L119,282@15944L739:SecureTextField.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-741592697, i2, -1, "androidx.compose.material.OutlinedSecureTextField.<no name provided>.Decoration (SecureTextField.kt:282)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String string = this.$state.getText().toString();
            VisualTransformation none = VisualTransformation.INSTANCE.getNone();
            final boolean z = this.$enabled;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z2 = this.$isError;
            Function2<Composer, Integer, Unit> function3 = this.$label;
            Function2<Composer, Integer, Unit> function4 = this.$placeholder;
            Function2<Composer, Integer, Unit> function5 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function6 = this.$trailingIcon;
            final Shape shape = this.$shape;
            final TextFieldColors textFieldColors = this.$colors;
            composer2 = composerStartRestartGroup;
            textFieldDefaults.OutlinedTextFieldDecorationBox(string, function2, z, true, none, mutableInteractionSource, z2, function3, function4, function5, function6, shape, textFieldColors, null, ComposableLambdaKt.rememberComposableLambda(910489071, true, new Function2() { // from class: androidx.compose.material.SecureTextFieldKt$OutlinedSecureTextField$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SecureTextFieldKt$OutlinedSecureTextField$3.Decoration$lambda$0(z, z2, mutableInteractionSource, textFieldColors, shape, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i2 << 3) & 112) | 27648, 221184, 8192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SecureTextFieldKt$OutlinedSecureTextField$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SecureTextFieldKt$OutlinedSecureTextField$3.Decoration$lambda$1(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Decoration$lambda$0(boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C297@16589L61:SecureTextField.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(910489071, i, -1, "androidx.compose.material.OutlinedSecureTextField.<no name provided>.Decoration.<anonymous> (SecureTextField.kt:297)");
            }
            TextFieldDefaults.INSTANCE.m2630BorderBoxnbWgWpA(z, z2, mutableInteractionSource, textFieldColors, shape, 0.0f, 0.0f, composer, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
