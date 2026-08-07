package expo.modules.ui;

import android.content.Context;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.viewevent.ViewEventDelegateKt;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TextInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017¢\u0006\u0002\u0010 R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lexpo/modules/ui/TextInputView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/TextInputProps;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/TextInputProps;", "onValueChanged", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "", "", "getOnValueChanged", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onValueChanged$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "textState", "Landroidx/compose/runtime/MutableState;", "value", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextInputView extends ExpoComposeView<TextInputProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TextInputView.class, "onValueChanged", "getOnValueChanged()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = ExpoComposeView.$stable | ViewEventDelegate.$stable;

    /* JADX INFO: renamed from: onValueChanged$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onValueChanged;
    private final TextInputProps props;
    private final MutableState<String> textState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(TextInputView textInputView, ComposableScope composableScope, int i, Composer composer, int i2) {
        textInputView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context, AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new TextInputProps(null, null, null, null, null, null, null, null, 255, null);
        this.onValueChanged = ViewEventDelegateKt.MapEventDispatcher$default(this, null, 1, null);
        this.textState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public TextInputProps getProps() {
        return this.props;
    }

    private final ViewEventCallback<Map<String, Object>> getOnValueChanged() {
        return this.onValueChanged.getValue(this, $$delegatedProperties[0]);
    }

    public final String getText() {
        return this.textState.getValue();
    }

    public final void setText(String str) {
        this.textState.setValue(str);
        ViewEventCallback<Map<String, Object>> onValueChanged = getOnValueChanged();
        if (str == null) {
            str = "";
        }
        onValueChanged.invoke(MapsKt.mapOf(TuplesKt.to("value", str)));
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        int iIntValue;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(682646597);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)84@3237L86,72@2672L83,76@2777L33,70@2592L737:TextInputView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(this) : composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(682646597, i3, -1, "expo.modules.ui.TextInputView.Content (TextInputView.kt:69)");
            }
            String value = this.textState.getValue();
            if (value == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String str = value;
            if (getProps().getMultiline().getValue().booleanValue()) {
                Integer value2 = getProps().getNumberOfLines().getValue();
                iIntValue = value2 != null ? value2.intValue() : Integer.MAX_VALUE;
            } else {
                iIntValue = 1;
            }
            boolean z = !getProps().getMultiline().getValue().booleanValue();
            KeyboardOptions keyboardOptionsM1668copyINvB4aQ$default = KeyboardOptions.m1668copyINvB4aQ$default(KeyboardOptions.INSTANCE.getDefault(), TextInputViewKt.autoCapitalize(getProps().getAutoCapitalize().getValue()), Boolean.valueOf(getProps().getAutocorrection().getValue().booleanValue()), TextInputViewKt.keyboardType(getProps().getKeyboardType().getValue()), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 120, (Object) null);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(getProps().getModifiers().getValue(), getAppContext(), composableScope, getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6) | ((i3 << 6) & 896));
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TextInputView.kt#9igjgp");
            boolean z2 = (i3 & 112) == 32 || ((i3 & 64) != 0 && composerStartRestartGroup.changedInstance(this));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.TextInputView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TextInputView.Content$lambda$1$lambda$0(this.f$0, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            TextFieldKt.TextField(str, (Function1<? super String, Unit>) objRememberedValue, modifierApplyModifiers, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1921531136, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.TextInputView.Content.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C76@2779L29:TextInputView.kt#v15e7d");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1921531136, i4, -1, "expo.modules.ui.TextInputView.Content.<anonymous> (TextInputView.kt:76)");
                    }
                    TextKt.m4494TextNvy7gAk(TextInputView.this.getProps().getPlaceholder().getValue(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptionsM1668copyINvB4aQ$default, (KeyboardActions) null, z, iIntValue, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 12582912, 0, 0, 7962488);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.TextInputView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextInputView.Content$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$lambda$0(TextInputView textInputView, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        textInputView.textState.setValue(it);
        textInputView.getOnValueChanged().invoke(MapsKt.mapOf(TuplesKt.to("value", it)));
        return Unit.INSTANCE;
    }
}
