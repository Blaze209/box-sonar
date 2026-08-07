package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.facebook.react.uimanager.PixelUtil;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoComposeAndroidView.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/views/ExpoComposeAndroidView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/RNHostViewInterface;", "view", "Landroid/view/View;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/view/View;Lexpo/modules/kotlin/AppContext;)V", "matchContents", "", "getMatchContents", "()Z", "setMatchContents", "(Z)V", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoComposeAndroidView extends ExpoComposeView<ComposeProps> implements RNHostViewInterface {
    public static final int $stable = 8;
    private boolean matchContents;
    private final View view;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(ExpoComposeAndroidView expoComposeAndroidView, ComposableScope composableScope, int i, Composer composer, int i2) {
        expoComposeAndroidView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExpoComposeAndroidView(View view, AppContext appContext) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        super(context, appContext, false, 4, null);
        this.view = view;
    }

    @Override // expo.modules.kotlin.views.RNHostViewInterface
    public boolean getMatchContents() {
        return this.matchContents;
    }

    @Override // expo.modules.kotlin.views.RNHostViewInterface
    public void setMatchContents(boolean z) {
        this.matchContents = z;
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(134503518);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)32@970L8,31@941L168:ExpoComposeAndroidView.kt#sri11g");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 17) != 16 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(134503518, i2, -1, "expo.modules.kotlin.views.ExpoComposeAndroidView.Content (ExpoComposeAndroidView.kt:30)");
            }
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ExpoComposeAndroidView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.kotlin.views.ExpoComposeAndroidView$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExpoComposeAndroidView.Content$lambda$1$lambda$0(this.f$0, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue, SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(PixelUtil.INSTANCE.pxToDp(this.view.getWidth())), Dp.m9687constructorimpl(PixelUtil.INSTANCE.pxToDp(this.view.getHeight()))), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.kotlin.views.ExpoComposeAndroidView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpoComposeAndroidView.Content$lambda$2(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View Content$lambda$1$lambda$0(ExpoComposeAndroidView expoComposeAndroidView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return expoComposeAndroidView.view;
    }
}
