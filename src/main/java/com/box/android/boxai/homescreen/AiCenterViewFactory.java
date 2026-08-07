package com.box.android.boxai.homescreen;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.box.brownfieldApi.featuresNavigator.AICenterCompose;
import com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode;
import com.box.brownfieldApi.featuresNavigator.AiCenterViewHolder;
import com.box.brownfieldApi.featuresNavigator.ContentPickerListener;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.box.brownfieldApi.featuresNavigator.PreviewRequest;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiCenterViewFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017¢\u0006\u0002\u0010\u001dJi\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a0 2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001a0 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0014\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u001a0 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0*H\u0017¢\u0006\u0002\u0010+R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006,"}, d2 = {"Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "", "<init>", "()V", "viewHolder", "Lkotlin/Lazy;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterViewHolder;", "hostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "getHostSurface", "()Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "setHostSurface", "(Lcom/box/brownfieldApi/featuresNavigator/HostSurface;)V", "styleVariant", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "getStyleVariant", "()Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "setStyleVariant", "(Lcom/margelo/nitro/boxcontext/providers/StyleVariant;)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "RememberAiCenterView", "", "launchMode", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "(Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/margelo/nitro/boxcontext/providers/StyleVariant;Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;Landroidx/compose/runtime/Composer;I)V", "AiCenter", "showContentPicker", "Lkotlin/Function1;", "Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "showPreview", "Lcom/box/brownfieldApi/featuresNavigator/PreviewRequest;", "modifier", "Landroidx/compose/ui/Modifier;", "bottomOffset", "", "onSessionChanged", "onClose", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;DLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AiCenterViewFactory {
    public static final int $stable = 8;
    private HostSurface hostSurface;
    private String sessionId;
    private StyleVariant styleVariant;
    private Lazy<AiCenterViewHolder> viewHolder;

    public final HostSurface getHostSurface() {
        return this.hostSurface;
    }

    public final void setHostSurface(HostSurface hostSurface) {
        this.hostSurface = hostSurface;
    }

    public final StyleVariant getStyleVariant() {
        return this.styleVariant;
    }

    public final void setStyleVariant(StyleVariant styleVariant) {
        this.styleVariant = styleVariant;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public void RememberAiCenterView(HostSurface hostSurface, StyleVariant styleVariant, AiCenterLaunchMode launchMode, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(hostSurface, "hostSurface");
        Intrinsics.checkNotNullParameter(styleVariant, "styleVariant");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        composer.startReplaceGroup(-923934978);
        ComposerKt.sourceInformation(composer, "C(RememberAiCenterView)N(hostSurface,styleVariant,launchMode)27@1202L85,24@1096L201:AiCenterViewFactory.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-923934978, i, -1, "com.box.android.boxai.homescreen.AiCenterViewFactory.RememberAiCenterView (AiCenterViewFactory.kt:23)");
        }
        AICenterCompose aICenterCompose = AICenterCompose.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1156724691, "CC(remember):AiCenterViewFactory.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new StyleVariantChangeDelegateImpl(styleVariant);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        this.viewHolder = aICenterCompose.rememberLazyAiCenterViewHolder(launchMode, hostSurface, (StyleVariantChangeDelegateImpl) objRememberedValue, composer, ((i << 3) & 112) | ((i >> 6) & 14) | 384 | (AICenterCompose.$stable << 9), 0);
        this.styleVariant = styleVariant;
        this.hostSurface = hostSurface;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    public void AiCenter(Function1<? super ContentPickerListener, Unit> showContentPicker, Function1<? super PreviewRequest, Unit> showPreview, Modifier modifier, double d, final Function1<? super String, Unit> onSessionChanged, Function0<Unit> onClose, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(showContentPicker, "showContentPicker");
        Intrinsics.checkNotNullParameter(showPreview, "showPreview");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onSessionChanged, "onSessionChanged");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        composer.startReplaceGroup(-459075231);
        ComposerKt.sourceInformation(composer, "C(AiCenter)N(showContentPicker,showPreview,modifier,bottomOffset,onSessionChanged,onClose)49@1909L71,43@1686L327:AiCenterViewFactory.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-459075231, i, -1, "com.box.android.boxai.homescreen.AiCenterViewFactory.AiCenter (AiCenterViewFactory.kt:43)");
        }
        AICenterCompose aICenterCompose = AICenterCompose.INSTANCE;
        Lazy<AiCenterViewHolder> lazy = this.viewHolder;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolder");
            lazy = null;
        }
        AiCenterViewHolder value = lazy.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, 1210350536, "CC(remember):AiCenterViewFactory.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(this) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(onSessionChanged)) || (i & 24576) == 16384);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.boxai.homescreen.AiCenterViewFactory$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AiCenterViewFactory.AiCenter$lambda$0$0(this.f$0, onSessionChanged, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = i << 6;
        aICenterCompose.AICenter(value, d, showContentPicker, showPreview, (Function1) objRememberedValue, onClose, modifier, composer, AiCenterViewHolder.$stable | ((i >> 6) & 112) | (i2 & 896) | (i2 & 7168) | (458752 & i) | ((i << 12) & 3670016) | (AICenterCompose.$stable << 21), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenter$lambda$0$0(AiCenterViewFactory aiCenterViewFactory, Function1 function1, String str) {
        aiCenterViewFactory.sessionId = str;
        function1.invoke(str);
        return Unit.INSTANCE;
    }
}
