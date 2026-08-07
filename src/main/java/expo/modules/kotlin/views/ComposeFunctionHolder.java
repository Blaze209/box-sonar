package expo.modules.kotlin.views;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004BZ\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00121\u0010\u000b\u001a-\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u001f\u001a\u00020\u0010*\u00020 H\u0017¢\u0006\u0002\u0010!R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R;\u0010\u000b\u001a-\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u000f\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\"²\u0006\u0014\u0010\u000f\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"Lexpo/modules/kotlin/views/ComposeFunctionHolder;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/kotlin/views/ViewFunctionHolder;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "name", "", "composableContent", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Lexpo/modules/kotlin/views/ComposeProps;)V", "getName", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function4;", "getProps", "()Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "propsMutableState", "Landroidx/compose/runtime/MutableState;", "getPropsMutableState", "()Landroidx/compose/runtime/MutableState;", "Content", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComposeFunctionHolder<Props extends ComposeProps> extends ExpoComposeView<Props> implements ViewFunctionHolder {
    public static final int $stable = 8;
    private final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> composableContent;
    private final String name;
    private final Props props;
    private final MutableState<Props> propsMutableState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(ComposeFunctionHolder composeFunctionHolder, ComposableScope composableScope, int i, Composer composer, int i2) {
        composeFunctionHolder.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.views.ViewFunctionHolder
    public String getName() {
        return this.name;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public Props getProps() {
        return this.props;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ComposeFunctionHolder(Context context, AppContext appContext, String name, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> composableContent, Props props) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(composableContent, "composableContent");
        Intrinsics.checkNotNullParameter(props, "props");
        this.name = name;
        this.composableContent = composableContent;
        this.props = props;
        this.propsMutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getProps(), null, 2, null);
    }

    public final MutableState<Props> getPropsMutableState() {
        return this.propsMutableState;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(1424484963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)*250@7626L24:ExpoComposeView.kt#sri11g");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1424484963, i2, -1, "expo.modules.kotlin.views.ComposeFunctionHolder.Content (ExpoComposeView.kt:247)");
            }
            this.composableContent.invoke(new FunctionalComposableScope(this, composableScope), (Props) Content$lambda$0(this.propsMutableState), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ComposeFunctionHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeFunctionHolder.Content$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final <Props extends ComposeProps> Props Content$lambda$0(MutableState<Props> mutableState) {
        return mutableState.getValue();
    }
}
