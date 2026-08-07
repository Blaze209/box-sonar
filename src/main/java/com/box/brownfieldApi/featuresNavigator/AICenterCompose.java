package com.box.brownfieldApi.featuresNavigator;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.callstack.reactnativebrownfield.ReactDelegateWrapper;
import com.callstack.reactnativebrownfield.ReactNativeBrownfield;
import com.facebook.react.ReactRootView;
import com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate;
import com.margelo.nitro.boxcontext.providers.AndroidLayoutRegistry;
import com.margelo.nitro.boxcontext.providers.HostNavigationRegistry;
import com.margelo.nitro.boxcontext.providers.StyleVariantDelegate;
import com.margelo.nitro.boxcontext.providers.StyleVariantRegistry;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AICenterCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0012J4\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0002J \u0010\u001f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\u008c\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001d0'2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001d0'2'\b\u0002\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001d\u0018\u00010'2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001002\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00103J\u009c\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001d0'2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001d0'2'\b\u0002\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001d\u0018\u00010'2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001002\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00104R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00065²\u0006)\u00106\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001d\u0018\u00010'X\u008a\u0084\u0002²\u0006\u0012\u00107\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u000100X\u008a\u0084\u0002"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/AICenterCompose;", "", "<init>", "()V", "RECIPIENT_ID_KEY", "", "CLOSE_REQUESTED_TOPIC", "INITIAL_SESSION_ID_KEY", "rememberLazyAiCenterViewHolder", "Lkotlin/Lazy;", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterViewHolder;", AICenterCompose.HOST_SURFACE_KEY, "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "styleVariantDelegate", "Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;", "initialContext", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;", AICenterCompose.INITIAL_SESSION_ID_KEY, "(Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;Lcom/box/brownfieldApi/featuresNavigator/AiCenterInitialContext;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Lkotlin/Lazy;", "HOST_SURFACE_KEY", "createAiCenterViewHolder", "activity", "Landroidx/fragment/app/FragmentActivity;", "launchMode", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "(Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;Landroidx/compose/runtime/Composer;II)Lkotlin/Lazy;", "resolveLaunchMode", "Lkotlin/Pair;", "cleanupView", "", "viewHolder", "createAiCenterViewHolderInternal", AICenterCompose.RECIPIENT_ID_KEY, "launchOptions", "Landroid/os/Bundle;", "AICenter", "bottomOffset", "", "showContentPicker", "Lkotlin/Function1;", "Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "showPreview", "Lcom/box/brownfieldApi/featuresNavigator/PreviewRequest;", "onSessionChange", "Lkotlin/ParameterName;", "name", "sessionId", "onClose", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/brownfieldApi/featuresNavigator/AiCenterViewHolder;DLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "(Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;DLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "brownfieldApi_release", "currentOnSessionChange", "currentOnClose"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AICenterCompose {
    public static final int $stable = 0;
    private static final String CLOSE_REQUESTED_TOPIC = "ai_center_close_requested";
    private static final String HOST_SURFACE_KEY = "hostSurface";
    public static final String INITIAL_SESSION_ID_KEY = "initialSessionId";
    public static final AICenterCompose INSTANCE = new AICenterCompose();
    private static final String RECIPIENT_ID_KEY = "recipientId";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AICenter$lambda$21(AICenterCompose aICenterCompose, AiCenterViewHolder aiCenterViewHolder, double d, Function1 function1, Function1 function2, Function1 function3, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        aICenterCompose.AICenter(aiCenterViewHolder, d, function1, function2, function3, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AICenter$lambda$28(AICenterCompose aICenterCompose, AiCenterLaunchMode aiCenterLaunchMode, HostSurface hostSurface, StyleVariantDelegate styleVariantDelegate, double d, Function1 function1, Function1 function2, Function1 function3, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        aICenterCompose.AICenter(aiCenterLaunchMode, hostSurface, styleVariantDelegate, d, function1, function2, function3, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private AICenterCompose() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer the launchMode overload — it makes launch intent explicit and prevents invalid combinations.", replaceWith = @ReplaceWith(expression = "rememberLazyAiCenterViewHolder(AiCenterLaunchMode.NewSession(initialContext), hostSurface, styleVariantDelegate)", imports = {"com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode"}))
    public final Lazy<AiCenterViewHolder> rememberLazyAiCenterViewHolder(HostSurface hostSurface, StyleVariantDelegate styleVariantDelegate, AiCenterInitialContext aiCenterInitialContext, String str, Composer composer, int i, int i2) {
        composer.startReplaceGroup(160575808);
        ComposerKt.sourceInformation(composer, "C(rememberLazyAiCenterViewHolder)P(!1,3)217@9017L7,218@9066L410,229@9511L237,229@9486L262:AICenterCompose.kt#bsg48e");
        final HostSurface hostSurface2 = (i2 & 1) != 0 ? null : hostSurface;
        final StyleVariantDelegate styleVariantDelegate2 = (i2 & 2) != 0 ? null : styleVariantDelegate;
        final AiCenterInitialContext aiCenterInitialContext2 = (i2 & 4) != 0 ? null : aiCenterInitialContext;
        final String str2 = (i2 & 8) != 0 ? null : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(160575808, i, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.rememberLazyAiCenterViewHolder (AICenterCompose.kt:216)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        final FragmentActivity fragmentActivity = (FragmentActivity) objConsume;
        composer.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation(composer, "CC(remember):AICenterCompose.kt#9igjgp");
        boolean zChanged = composer.changed(aiCenterInitialContext2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(str2)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = LazyKt.lazy(new Function0() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AICenterCompose.rememberLazyAiCenterViewHolder$lambda$2$lambda$1(fragmentActivity, hostSurface2, aiCenterInitialContext2, str2, styleVariantDelegate2);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        final Lazy<AiCenterViewHolder> lazy = (Lazy) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):AICenterCompose.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(lazy);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AICenterCompose.rememberLazyAiCenterViewHolder$lambda$5$lambda$4(lazy, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.DisposableEffect(lazy, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AiCenterViewHolder rememberLazyAiCenterViewHolder$lambda$2$lambda$1(FragmentActivity fragmentActivity, HostSurface hostSurface, AiCenterInitialContext aiCenterInitialContext, String str, StyleVariantDelegate styleVariantDelegate) {
        AiCenterViewHolder aiCenterViewHolderCreateAiCenterViewHolder = INSTANCE.createAiCenterViewHolder(fragmentActivity, hostSurface, aiCenterInitialContext, str);
        if (styleVariantDelegate != null) {
            StyleVariantRegistry.INSTANCE.register(aiCenterViewHolderCreateAiCenterViewHolder.getRecipientId(), styleVariantDelegate);
        }
        return aiCenterViewHolderCreateAiCenterViewHolder;
    }

    public static /* synthetic */ AiCenterViewHolder createAiCenterViewHolder$default(AICenterCompose aICenterCompose, FragmentActivity fragmentActivity, HostSurface hostSurface, AiCenterInitialContext aiCenterInitialContext, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            hostSurface = null;
        }
        if ((i & 4) != 0) {
            aiCenterInitialContext = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        return aICenterCompose.createAiCenterViewHolder(fragmentActivity, hostSurface, aiCenterInitialContext, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Prefer the launchMode overload — it makes launch intent explicit and prevents invalid combinations.", replaceWith = @ReplaceWith(expression = "createAiCenterViewHolder(activity, AiCenterLaunchMode.NewSession(initialContext), hostSurface)", imports = {"com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode"}))
    public final AiCenterViewHolder createAiCenterViewHolder(FragmentActivity activity, HostSurface hostSurface, AiCenterInitialContext initialContext, String initialSessionId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String strGenerateRecipientId = RecipientIdGeneratorKt.generateRecipientId();
        Bundle bundle = new Bundle();
        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId);
        if (hostSurface != null) {
            bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
        }
        if (initialContext != null) {
            initialContext.writeTo$brownfieldApi_release(bundle);
        }
        if (initialSessionId != null) {
            bundle.putString(INITIAL_SESSION_ID_KEY, initialSessionId);
        }
        return createAiCenterViewHolderInternal(activity, strGenerateRecipientId, bundle);
    }

    public static /* synthetic */ AiCenterViewHolder createAiCenterViewHolder$default(AICenterCompose aICenterCompose, FragmentActivity fragmentActivity, AiCenterLaunchMode aiCenterLaunchMode, HostSurface hostSurface, int i, Object obj) {
        if ((i & 4) != 0) {
            hostSurface = null;
        }
        return aICenterCompose.createAiCenterViewHolder(fragmentActivity, aiCenterLaunchMode, hostSurface);
    }

    public final AiCenterViewHolder createAiCenterViewHolder(FragmentActivity activity, AiCenterLaunchMode launchMode, HostSurface hostSurface) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        Pair<AiCenterInitialContext, String> pairResolveLaunchMode = resolveLaunchMode(launchMode);
        return createAiCenterViewHolder(activity, hostSurface, pairResolveLaunchMode.component1(), pairResolveLaunchMode.component2());
    }

    public final Lazy<AiCenterViewHolder> rememberLazyAiCenterViewHolder(AiCenterLaunchMode launchMode, HostSurface hostSurface, StyleVariantDelegate styleVariantDelegate, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        composer.startReplaceGroup(2062576774);
        ComposerKt.sourceInformation(composer, "C(rememberLazyAiCenterViewHolder)P(1)310@12705L214:AICenterCompose.kt#bsg48e");
        HostSurface hostSurface2 = (i2 & 2) != 0 ? null : hostSurface;
        StyleVariantDelegate styleVariantDelegate2 = (i2 & 4) == 0 ? styleVariantDelegate : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2062576774, i, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.rememberLazyAiCenterViewHolder (AICenterCompose.kt:307)");
        }
        Pair<AiCenterInitialContext, String> pairResolveLaunchMode = resolveLaunchMode(launchMode);
        Lazy<AiCenterViewHolder> lazyRememberLazyAiCenterViewHolder = rememberLazyAiCenterViewHolder(hostSurface2, styleVariantDelegate2, pairResolveLaunchMode.component1(), pairResolveLaunchMode.component2(), composer, ((i >> 3) & 126) | ((i << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return lazyRememberLazyAiCenterViewHolder;
    }

    private final Pair<AiCenterInitialContext, String> resolveLaunchMode(AiCenterLaunchMode launchMode) {
        if (launchMode instanceof AiCenterLaunchMode.NewSession) {
            return TuplesKt.to(((AiCenterLaunchMode.NewSession) launchMode).getSeed(), null);
        }
        if (launchMode instanceof AiCenterLaunchMode.ResumeSession) {
            return TuplesKt.to(null, ((AiCenterLaunchMode.ResumeSession) launchMode).getSessionId());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanupView(AiCenterViewHolder viewHolder) {
        viewHolder.getActivity$brownfieldApi_release().getLifecycleRegistry().removeObserver(viewHolder.getLifecycleObserver$brownfieldApi_release());
        viewHolder.getBackPressedCallback$brownfieldApi_release().remove();
        ViewParent parent = viewHolder.getView().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(viewHolder.getView());
        }
        viewHolder.getReactDelegate$brownfieldApi_release().unloadApp();
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.box.brownfieldApi.featuresNavigator.AICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1] */
    private final AiCenterViewHolder createAiCenterViewHolderInternal(final FragmentActivity activity, String recipientId, Bundle launchOptions) {
        final ReactDelegateWrapper reactDelegateWrapper = new ReactDelegateWrapper(activity, ReactNativeBrownfield.INSTANCE.getShared().getReactHost(), FeatureModule.AI_CENTER.getModuleName(), launchOptions);
        final ?? r7 = new OnBackPressedCallback() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                reactDelegateWrapper.onBackPressed();
            }
        };
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) r7;
        activity.getOnBackPressedDispatcher().addCallback(onBackPressedCallback);
        reactDelegateWrapper.setHardwareBackHandler(new Function0() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AICenterCompose.createAiCenterViewHolderInternal$lambda$9(r7, activity);
            }
        });
        DefaultLifecycleObserver defaultLifecycleObserver = new DefaultLifecycleObserver() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$createAiCenterViewHolderInternal$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onResume(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegateWrapper.onReactHostResume();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onPause(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegateWrapper.onHostPause();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegateWrapper.unloadApp();
                reactDelegateWrapper.onHostDestroy();
                owner.getLifecycleRegistry().removeObserver(this);
            }
        };
        activity.getLifecycleRegistry().addObserver(defaultLifecycleObserver);
        reactDelegateWrapper.loadApp();
        ReactRootView reactRootView = reactDelegateWrapper.getReactRootView();
        Intrinsics.checkNotNull(reactRootView);
        return new AiCenterViewHolder(reactRootView, recipientId, reactDelegateWrapper, onBackPressedCallback, activity, defaultLifecycleObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createAiCenterViewHolderInternal$lambda$9(AICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1 aICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1, FragmentActivity fragmentActivity) {
        aICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1.setEnabled(false);
        fragmentActivity.getOnBackPressedDispatcher().onBackPressed();
        aICenterCompose$createAiCenterViewHolderInternal$backPressedCallback$1.setEnabled(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0163  */
    /* JADX WARN: Code duplicated, block: B:103:0x0165  */
    /* JADX WARN: Code duplicated, block: B:106:0x016d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0175  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:118:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:120:0x020d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0215  */
    /* JADX WARN: Code duplicated, block: B:126:0x023a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0256  */
    /* JADX WARN: Code duplicated, block: B:130:0x025e  */
    /* JADX WARN: Code duplicated, block: B:134:0x0289  */
    /* JADX WARN: Code duplicated, block: B:136:0x0291  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:143:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00db  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:85:0x0101  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:91:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0115  */
    /* JADX WARN: Code duplicated, block: B:97:0x0137  */
    /* JADX WARN: Code duplicated, block: B:99:0x013f  */
    public final void AICenter(final AiCenterViewHolder viewHolder, double d, final Function1<? super ContentPickerListener, Unit> showContentPicker, final Function1<? super PreviewRequest, Unit> showPreview, Function1<? super String, Unit> function1, Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final double d2;
        int i4;
        int i5;
        int i6;
        Function1<? super String, Unit> function2;
        int i7;
        int i8;
        Function0<Unit> function3;
        int i9;
        int i10;
        Modifier.Companion companion;
        int i11;
        Function1<? super String, Unit> function4;
        Function0<Unit> function5;
        boolean zChanged;
        Object objRememberedValue;
        boolean z;
        boolean z2;
        Object objRememberedValue2;
        State stateRememberUpdatedState;
        State stateRememberUpdatedState2;
        boolean zChangedInstance;
        Object objRememberedValue3;
        Function1<? super String, Unit> function6;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        final double d3;
        final Function0<Unit> function7;
        final Modifier modifier2;
        final Function1<? super String, Unit> function8;
        boolean zChangedInstance3;
        AICenterCompose$AICenter$3$1 aICenterCompose$AICenter$3$1RememberedValue;
        boolean zChangedInstance4;
        AICenterCompose$AICenter$2$1 aICenterCompose$AICenter$2$1RememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(showContentPicker, "showContentPicker");
        Intrinsics.checkNotNullParameter(showPreview, "showPreview");
        Composer composerStartRestartGroup = composer.startRestartGroup(107846854);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AICenter)P(6!1,4,5,3,2)474@20318L120,478@20469L182,483@20690L37,484@20758L29,486@20874L368,486@20797L445,514@21936L131,513@21901L209,521@22120L58:AICenterCompose.kt#bsg48e");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(viewHolder) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                d2 = d;
                i3 |= composerStartRestartGroup.changed(d2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(showContentPicker)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(showPreview)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function3 = function0;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        companion = modifier;
                    } else {
                        companion = modifier;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(companion)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i3 & 599187) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        if (i12 != 0) {
                            d2 = 0.0d;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        } else {
                            function4 = function2;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        } else {
                            function5 = function3;
                        }
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                        }
                        String recipientId = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(recipientId);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final ContentPickerNavigationDelegate contentPickerNavigationDelegate = (ContentPickerNavigationDelegate) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        String recipientId2 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(recipientId2);
                        if ((i3 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = z | zChanged2;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                                private final double bottomOffset;

                                {
                                    this.bottomOffset = d2;
                                }

                                @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                                public double getBottomOffset() {
                                    return this.bottomOffset;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$1 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                        int i13 = i3 >> 15;
                        stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i13 & 14);
                        String recipientId3 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1746271574);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$1);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            function6 = function4;
                        } else {
                            function6 = function4;
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.DisposableEffect(recipientId3, contentPickerNavigationDelegate, aICenterCompose$AICenter$layoutDelegate$1$1, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.startReplaceGroup(561654537);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                            if (function6 != null) {
                                String recipientId4 = viewHolder.getRecipientId();
                                composerStartRestartGroup.startReplaceGroup(-1633490746);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                                zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                                aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance4 || aICenterCompose$AICenter$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                EffectsKt.LaunchedEffect(recipientId4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(561667096);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                            if (function5 != null) {
                                String recipientId5 = viewHolder.getRecipientId();
                                composerStartRestartGroup.startReplaceGroup(-1633490746);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                                zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                                aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance3 || aICenterCompose$AICenter$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                EffectsKt.LaunchedEffect(recipientId5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifier3 = companion;
                            AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier3, null, composerStartRestartGroup, i13 & 112, 4);
                            ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            d3 = d2;
                            function7 = function5;
                            modifier2 = modifier3;
                            function8 = function6;
                        }
                        objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate, aICenterCompose$AICenter$layoutDelegate$1$1, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId3, contentPickerNavigationDelegate, aICenterCompose$AICenter$layoutDelegate$1$1, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId6 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId7 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier4 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier4, null, composerStartRestartGroup, i13 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier4;
                        function8 = function6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = companion;
                        d3 = d2;
                        function8 = function2;
                        function7 = function3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function0;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    companion = modifier;
                } else {
                    companion = modifier;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(companion)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 599187) == 599186) {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId8 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId8);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate2 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId9 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(recipientId9);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged3;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$2 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i14 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i14 & 14);
                    String recipientId10 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate2) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId10, contentPickerNavigationDelegate2, aICenterCompose$AICenter$layoutDelegate$1$2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId11 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId12 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier5 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier5, null, composerStartRestartGroup, i14 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier5;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate2, aICenterCompose$AICenter$layoutDelegate$1$2, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId10, contentPickerNavigationDelegate2, aICenterCompose$AICenter$layoutDelegate$1$2, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId13 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId14 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier6 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier6, null, composerStartRestartGroup, i14 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier6;
                    function8 = function6;
                } else {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId15 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId15);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate3 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId16 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged4 = composerStartRestartGroup.changed(recipientId16);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged4;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$3 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i15 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i15 & 14);
                    String recipientId17 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate3) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId17, contentPickerNavigationDelegate3, aICenterCompose$AICenter$layoutDelegate$1$3, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId18 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId18, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId19 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId19, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier7 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier7, null, composerStartRestartGroup, i15 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier7;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate3, aICenterCompose$AICenter$layoutDelegate$1$3, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId17, contentPickerNavigationDelegate3, aICenterCompose$AICenter$layoutDelegate$1$3, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId110 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId111 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier8 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier8, null, composerStartRestartGroup, i15 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier8;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function0;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    companion = modifier;
                } else {
                    companion = modifier;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(companion)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 599187) == 599186) {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId112 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId112);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate4 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId113 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged5 = composerStartRestartGroup.changed(recipientId113);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$4 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i16 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i16 & 14);
                    String recipientId114 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate4) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId114, contentPickerNavigationDelegate4, aICenterCompose$AICenter$layoutDelegate$1$4, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId115 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId116 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier9 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier9, null, composerStartRestartGroup, i16 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier9;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate4, aICenterCompose$AICenter$layoutDelegate$1$4, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId114, contentPickerNavigationDelegate4, aICenterCompose$AICenter$layoutDelegate$1$4, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId117 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId118 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier10 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier10, null, composerStartRestartGroup, i16 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier10;
                    function8 = function6;
                } else {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId119 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId119);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate5 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId1110 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged6 = composerStartRestartGroup.changed(recipientId1110);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged6;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$5 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i17 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i17 & 14);
                    String recipientId1111 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate5) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$5);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId1111, contentPickerNavigationDelegate5, aICenterCompose$AICenter$layoutDelegate$1$5, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId1112 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId1112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId1113 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId1113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier11 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier11, null, composerStartRestartGroup, i17 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier11;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate5, aICenterCompose$AICenter$layoutDelegate$1$5, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId1111, contentPickerNavigationDelegate5, aICenterCompose$AICenter$layoutDelegate$1$5, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId1114 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId1115 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier12 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier12, null, composerStartRestartGroup, i17 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier12;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function0;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                companion = modifier;
            } else {
                companion = modifier;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(companion)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 599187) == 599186) {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId1116 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId1116);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate6 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId1117 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged7 = composerStartRestartGroup.changed(recipientId1117);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged7;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$6 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i18 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i18 & 14);
                String recipientId1118 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate6) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$6);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId1118, contentPickerNavigationDelegate6, aICenterCompose$AICenter$layoutDelegate$1$6, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId1119 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId11110 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId11110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier13 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier13, null, composerStartRestartGroup, i18 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier13;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate6, aICenterCompose$AICenter$layoutDelegate$1$6, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId1118, contentPickerNavigationDelegate6, aICenterCompose$AICenter$layoutDelegate$1$6, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId11111 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId11112 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier14 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier14, null, composerStartRestartGroup, i18 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier14;
                function8 = function6;
            } else {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId11113 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId11113);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate7 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId11114 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged8 = composerStartRestartGroup.changed(recipientId11114);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged8;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$7 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i19 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i19 & 14);
                String recipientId11115 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate7) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId11115, contentPickerNavigationDelegate7, aICenterCompose$AICenter$layoutDelegate$1$7, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId11116 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId11116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId11117 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId11117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier15 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier15, null, composerStartRestartGroup, i19 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier15;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate7, aICenterCompose$AICenter$layoutDelegate$1$7, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId11115, contentPickerNavigationDelegate7, aICenterCompose$AICenter$layoutDelegate$1$7, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId11118 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId11119 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier16 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier16, null, composerStartRestartGroup, i19 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier16;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        d2 = d;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(showContentPicker)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(showPreview)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function0;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    companion = modifier;
                } else {
                    companion = modifier;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(companion)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 599187) == 599186) {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId111110 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId111110);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate8 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId111111 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged9 = composerStartRestartGroup.changed(recipientId111111);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged9;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$8 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i110 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i110 & 14);
                    String recipientId111112 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate8) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$8);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId111112, contentPickerNavigationDelegate8, aICenterCompose$AICenter$layoutDelegate$1$8, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId111113 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId111113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId111114 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId111114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier17 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier17, null, composerStartRestartGroup, i110 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier17;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate8, aICenterCompose$AICenter$layoutDelegate$1$8, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId111112, contentPickerNavigationDelegate8, aICenterCompose$AICenter$layoutDelegate$1$8, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId111115 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId111116 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier18 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier18, null, composerStartRestartGroup, i110 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier18;
                    function8 = function6;
                } else {
                    if (i12 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                    }
                    String recipientId111117 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(recipientId111117);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ContentPickerNavigationDelegate contentPickerNavigationDelegate9 = (ContentPickerNavigationDelegate) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    String recipientId111118 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    boolean zChanged10 = composerStartRestartGroup.changed(recipientId111118);
                    if ((i3 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z | zChanged10;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                            private final double bottomOffset;

                            {
                                this.bottomOffset = d2;
                            }

                            @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                            public double getBottomOffset() {
                                return this.bottomOffset;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$9 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    int i111 = i3 >> 15;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i111 & 14);
                    String recipientId111119 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate9) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$9);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        function6 = function4;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(recipientId111119, contentPickerNavigationDelegate9, aICenterCompose$AICenter$layoutDelegate$1$9, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.startReplaceGroup(561654537);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                        if (function6 != null) {
                            String recipientId1111110 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                            aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance4) {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId1111110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(561667096);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                        if (function5 != null) {
                            String recipientId1111111 = viewHolder.getRecipientId();
                            composerStartRestartGroup.startReplaceGroup(-1633490746);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                            zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                            aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance3) {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            } else {
                                aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                                composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(recipientId1111111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifier19 = companion;
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier19, null, composerStartRestartGroup, i111 & 112, 4);
                        ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d2;
                        function7 = function5;
                        modifier2 = modifier19;
                        function8 = function6;
                    } else {
                        function6 = function4;
                    }
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate9, aICenterCompose$AICenter$layoutDelegate$1$9, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId111119, contentPickerNavigationDelegate9, aICenterCompose$AICenter$layoutDelegate$1$9, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId1111112 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1111112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId1111113 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1111113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier110 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier110, null, composerStartRestartGroup, i111 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier110;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function0;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                companion = modifier;
            } else {
                companion = modifier;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(companion)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 599187) == 599186) {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId1111114 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId1111114);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate10 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId1111115 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged11 = composerStartRestartGroup.changed(recipientId1111115);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged11;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$10 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i112 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i112 & 14);
                String recipientId1111116 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate10) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId1111116, contentPickerNavigationDelegate10, aICenterCompose$AICenter$layoutDelegate$1$10, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId1111117 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1111117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId1111118 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId1111118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier111 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier111, null, composerStartRestartGroup, i112 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier111;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate10, aICenterCompose$AICenter$layoutDelegate$1$10, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId1111116, contentPickerNavigationDelegate10, aICenterCompose$AICenter$layoutDelegate$1$10, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId1111119 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId1111119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId11111110 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier112 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier112, null, composerStartRestartGroup, i112 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier112;
                function8 = function6;
            } else {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId11111111 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId11111111);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate11 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId11111112 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged12 = composerStartRestartGroup.changed(recipientId11111112);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged12;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$11 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i113 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i113 & 14);
                String recipientId11111113 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate11) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$11);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId11111113, contentPickerNavigationDelegate11, aICenterCompose$AICenter$layoutDelegate$1$11, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId11111114 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId11111114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId11111115 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId11111115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier113 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier113, null, composerStartRestartGroup, i113 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier113;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate11, aICenterCompose$AICenter$layoutDelegate$1$11, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId11111113, contentPickerNavigationDelegate11, aICenterCompose$AICenter$layoutDelegate$1$11, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId11111116 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId11111117 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier114 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier114, null, composerStartRestartGroup, i113 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier114;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                function3 = function0;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                companion = modifier;
            } else {
                companion = modifier;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(companion)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 599187) == 599186) {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId11111118 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId11111118);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate12 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId11111119 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged13 = composerStartRestartGroup.changed(recipientId11111119);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged13;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$12 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i114 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i114 & 14);
                String recipientId111111110 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate12) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$12);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId111111110, contentPickerNavigationDelegate12, aICenterCompose$AICenter$layoutDelegate$1$12, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId111111111 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111111111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId111111112 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111111112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier115 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier115, null, composerStartRestartGroup, i114 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier115;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate12, aICenterCompose$AICenter$layoutDelegate$1$12, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId111111110, contentPickerNavigationDelegate12, aICenterCompose$AICenter$layoutDelegate$1$12, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId111111113 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId111111113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId111111114 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId111111114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier116 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier116, null, composerStartRestartGroup, i114 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier116;
                function8 = function6;
            } else {
                if (i12 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i8 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
                }
                String recipientId111111115 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(recipientId111111115);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ContentPickerNavigationDelegate contentPickerNavigationDelegate13 = (ContentPickerNavigationDelegate) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String recipientId111111116 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                boolean zChanged14 = composerStartRestartGroup.changed(recipientId111111116);
                if ((i3 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z | zChanged14;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                        private final double bottomOffset;

                        {
                            this.bottomOffset = d2;
                        }

                        @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                        public double getBottomOffset() {
                            return this.bottomOffset;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$13 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                int i115 = i3 >> 15;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i115 & 14);
                String recipientId111111117 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate13) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    function6 = function4;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(recipientId111111117, contentPickerNavigationDelegate13, aICenterCompose$AICenter$layoutDelegate$1$13, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(561654537);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                    if (function6 != null) {
                        String recipientId111111118 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                        aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4) {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111111118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(561667096);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                    if (function5 != null) {
                        String recipientId111111119 = viewHolder.getRecipientId();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                        aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3) {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        } else {
                            aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                            composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(recipientId111111119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier117 = companion;
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier117, null, composerStartRestartGroup, i115 & 112, 4);
                    ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d2;
                    function7 = function5;
                    modifier2 = modifier117;
                    function8 = function6;
                } else {
                    function6 = function4;
                }
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate13, aICenterCompose$AICenter$layoutDelegate$1$13, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId111111117, contentPickerNavigationDelegate13, aICenterCompose$AICenter$layoutDelegate$1$13, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId1111111110 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId1111111110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId1111111111 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId1111111111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier118 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier118, null, composerStartRestartGroup, i115 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier118;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3 = function0;
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
            companion = modifier;
        } else {
            companion = modifier;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(companion)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
        }
        if ((i3 & 599187) == 599186) {
            if (i12 != 0) {
                d2 = 0.0d;
            }
            if (i6 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            if (i8 != 0) {
                function5 = null;
            } else {
                function5 = function3;
            }
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
            }
            String recipientId1111111112 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(recipientId1111111112);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ContentPickerNavigationDelegate contentPickerNavigationDelegate14 = (ContentPickerNavigationDelegate) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            String recipientId1111111113 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            boolean zChanged15 = composerStartRestartGroup.changed(recipientId1111111113);
            if ((i3 & 112) == 32) {
                z = true;
            } else {
                z = false;
            }
            z2 = z | zChanged15;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                    private final double bottomOffset;

                    {
                        this.bottomOffset = d2;
                    }

                    @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                    public double getBottomOffset() {
                        return this.bottomOffset;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                    private final double bottomOffset;

                    {
                        this.bottomOffset = d2;
                    }

                    @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                    public double getBottomOffset() {
                        return this.bottomOffset;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$14 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
            int i116 = i3 >> 15;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i116 & 14);
            String recipientId1111111114 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate14) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$14);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                function6 = function4;
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId1111111114, contentPickerNavigationDelegate14, aICenterCompose$AICenter$layoutDelegate$1$14, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId1111111115 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId1111111115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId1111111116 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId1111111116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier119 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier119, null, composerStartRestartGroup, i116 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier119;
                function8 = function6;
            } else {
                function6 = function4;
            }
            objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate14, aICenterCompose$AICenter$layoutDelegate$1$14, (DisposableEffectScope) obj);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(recipientId1111111114, contentPickerNavigationDelegate14, aICenterCompose$AICenter$layoutDelegate$1$14, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.startReplaceGroup(561654537);
            ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
            if (function6 != null) {
                String recipientId1111111117 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance4) {
                    aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                } else {
                    aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(recipientId1111111117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(561667096);
            ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
            if (function5 != null) {
                String recipientId1111111118 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                } else {
                    aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(recipientId1111111118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifier1110 = companion;
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier1110, null, composerStartRestartGroup, i116 & 112, 4);
            ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            d3 = d2;
            function7 = function5;
            modifier2 = modifier1110;
            function8 = function6;
        } else {
            if (i12 != 0) {
                d2 = 0.0d;
            }
            if (i6 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            if (i8 != 0) {
                function5 = null;
            } else {
                function5 = function3;
            }
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(107846854, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:473)");
            }
            String recipientId1111111119 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(recipientId1111111119);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new ContentPickerNavigationDelegate(showContentPicker, showPreview);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ContentPickerNavigationDelegate contentPickerNavigationDelegate15 = (ContentPickerNavigationDelegate) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            String recipientId11111111110 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            boolean zChanged16 = composerStartRestartGroup.changed(recipientId11111111110);
            if ((i3 & 112) == 32) {
                z = true;
            } else {
                z = false;
            }
            z2 = z | zChanged16;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                    private final double bottomOffset;

                    {
                        this.bottomOffset = d2;
                    }

                    @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                    public double getBottomOffset() {
                        return this.bottomOffset;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new AndroidLayoutDelegate(d2) { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$layoutDelegate$1$1
                    private final double bottomOffset;

                    {
                        this.bottomOffset = d2;
                    }

                    @Override // com.margelo.nitro.boxcontext.providers.AndroidLayoutDelegate
                    public double getBottomOffset() {
                        return this.bottomOffset;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$15 = (AICenterCompose$AICenter$layoutDelegate$1$1) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
            int i117 = i3 >> 15;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function5, composerStartRestartGroup, i117 & 14);
            String recipientId11111111111 = viewHolder.getRecipientId();
            composerStartRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(contentPickerNavigationDelegate15) | composerStartRestartGroup.changed(aICenterCompose$AICenter$layoutDelegate$1$15);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                function6 = function4;
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(recipientId11111111111, contentPickerNavigationDelegate15, aICenterCompose$AICenter$layoutDelegate$1$15, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(561654537);
                ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
                if (function6 != null) {
                    String recipientId11111111112 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111111112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(561667096);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
                if (function5 != null) {
                    String recipientId11111111113 = viewHolder.getRecipientId();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    } else {
                        aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                        composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(recipientId11111111113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier1111 = companion;
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier1111, null, composerStartRestartGroup, i117 & 112, 4);
                ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d2;
                function7 = function5;
                modifier2 = modifier1111;
                function8 = function6;
            } else {
                function6 = function4;
            }
            objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AICenterCompose.AICenter$lambda$16$lambda$15(viewHolder, contentPickerNavigationDelegate15, aICenterCompose$AICenter$layoutDelegate$1$15, (DisposableEffectScope) obj);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(recipientId11111111111, contentPickerNavigationDelegate15, aICenterCompose$AICenter$layoutDelegate$1$15, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.startReplaceGroup(561654537);
            ComposerKt.sourceInformation(composerStartRestartGroup, "497@21334L295,497@21295L334");
            if (function6 != null) {
                String recipientId11111111114 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance4 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                aICenterCompose$AICenter$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance4) {
                    aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                } else {
                    aICenterCompose$AICenter$2$1RememberedValue = new AICenterCompose$AICenter$2$1(viewHolder, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$2$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(recipientId11111111114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$2$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(561667096);
            ComposerKt.sourceInformation(composerStartRestartGroup, "507@21723L158,507@21684L197");
            if (function5 != null) {
                String recipientId11111111115 = viewHolder.getRecipientId();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(viewHolder) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                aICenterCompose$AICenter$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                } else {
                    aICenterCompose$AICenter$3$1RememberedValue = new AICenterCompose$AICenter$3$1(viewHolder, stateRememberUpdatedState2, null);
                    composerStartRestartGroup.updateRememberedValue(aICenterCompose$AICenter$3$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(recipientId11111111115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aICenterCompose$AICenter$3$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(viewHolder);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$20$lambda$19(viewHolder, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifier1112 = companion;
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, modifier1112, null, composerStartRestartGroup, i117 & 112, 4);
            ReactNativeBackDismissKt.RnBackDismissHandler(viewHolder.getRecipientId(), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            d3 = d2;
            function7 = function5;
            modifier2 = modifier1112;
            function8 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AICenterCompose.AICenter$lambda$21(this.f$0, viewHolder, d3, showContentPicker, showPreview, function8, function7, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AICenter$lambda$16$lambda$15(final AiCenterViewHolder aiCenterViewHolder, ContentPickerNavigationDelegate contentPickerNavigationDelegate, AICenterCompose$AICenter$layoutDelegate$1$1 aICenterCompose$AICenter$layoutDelegate$1$1, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        HostNavigationRegistry.INSTANCE.register(aiCenterViewHolder.getRecipientId(), contentPickerNavigationDelegate);
        AndroidLayoutRegistry.INSTANCE.register(aiCenterViewHolder.getRecipientId(), aICenterCompose$AICenter$layoutDelegate$1$1);
        return new DisposableEffectResult() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$lambda$16$lambda$15$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                HostNavigationRegistry.INSTANCE.unregister(aiCenterViewHolder.getRecipientId());
                AndroidLayoutRegistry.INSTANCE.unregister(aiCenterViewHolder.getRecipientId());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameLayout AICenter$lambda$20$lambda$19(AiCenterViewHolder aiCenterViewHolder, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ViewParent parent = aiCenterViewHolder.getView().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(aiCenterViewHolder.getView());
        }
        return aiCenterViewHolder.getView();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013e  */
    /* JADX WARN: Code duplicated, block: B:101:0x0141  */
    /* JADX WARN: Code duplicated, block: B:103:0x0145  */
    /* JADX WARN: Code duplicated, block: B:105:0x014d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0150  */
    /* JADX WARN: Code duplicated, block: B:111:0x0161  */
    /* JADX WARN: Code duplicated, block: B:115:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0175  */
    /* JADX WARN: Code duplicated, block: B:119:0x017b  */
    /* JADX WARN: Code duplicated, block: B:120:0x017d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:126:0x018a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0192  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:138:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:151:0x0223  */
    /* JADX WARN: Code duplicated, block: B:153:0x0228  */
    /* JADX WARN: Code duplicated, block: B:157:0x0254  */
    /* JADX WARN: Code duplicated, block: B:159:0x025c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0288  */
    /* JADX WARN: Code duplicated, block: B:166:0x0295  */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00df  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:80:0x0102  */
    /* JADX WARN: Code duplicated, block: B:82:0x0108  */
    /* JADX WARN: Code duplicated, block: B:84:0x010e  */
    /* JADX WARN: Code duplicated, block: B:85:0x0111  */
    /* JADX WARN: Code duplicated, block: B:89:0x011b  */
    /* JADX WARN: Code duplicated, block: B:90:0x011e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0122  */
    /* JADX WARN: Code duplicated, block: B:94:0x012c  */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    public final void AICenter(final AiCenterLaunchMode launchMode, final HostSurface hostSurface, final StyleVariantDelegate styleVariantDelegate, double d, final Function1<? super ContentPickerListener, Unit> showContentPicker, final Function1<? super PreviewRequest, Unit> showPreview, Function1<? super String, Unit> function1, Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        double d2;
        int i4;
        int i5;
        int i6;
        Function1<? super String, Unit> function2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Function1<? super String, Unit> function3;
        Modifier.Companion companion;
        FragmentActivity fragmentActivity;
        boolean z;
        boolean z2;
        Object objRememberedValue;
        AiCenterInitialContext aiCenterInitialContextComponent1;
        String strComponent2;
        Bundle bundle;
        final AiCenterViewHolder aiCenterViewHolder;
        boolean zChangedInstance;
        Object objRememberedValue2;
        final double d3;
        final Function1<? super String, Unit> function4;
        final Function0<Unit> function5;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        Intrinsics.checkNotNullParameter(hostSurface, "hostSurface");
        Intrinsics.checkNotNullParameter(styleVariantDelegate, "styleVariantDelegate");
        Intrinsics.checkNotNullParameter(showContentPicker, "showContentPicker");
        Intrinsics.checkNotNullParameter(showPreview, "showPreview");
        Composer composerStartRestartGroup = composer.startRestartGroup(-847039819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AICenter)P(2,1,8!1,6,7,5,4)549@23510L7,550@23563L538,562@24140L249,562@24111L278,570@24399L297:AICenterCompose.kt#bsg48e");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(launchMode) : composerStartRestartGroup.changedInstance(launchMode) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(hostSurface.ordinal()) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(styleVariantDelegate) ? 256 : 128;
        }
        int i13 = i2 & 8;
        if (i13 == 0) {
            if ((i & 3072) == 0) {
                d2 = d;
                i3 |= composerStartRestartGroup.changed(d2) ? 2048 : 1024;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(showContentPicker)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i2 & 32) != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(showPreview)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(modifier)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i2 & 512) != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(this)) {
                            i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i12 = 268435456;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 306783379) == 306783378 || !composerStartRestartGroup.getSkipping()) {
                        if (i13 != 0) {
                            d2 = 0.0d;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function2;
                        }
                        Function0<Unit> function6 = i8 == 0 ? function0 : null;
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                        fragmentActivity = (FragmentActivity) objConsume;
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        if ((i3 & 14) != 4 || ((i3 & 8) != 0 && composerStartRestartGroup.changed(launchMode))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Function0<Unit> function7 = function6;
                        z2 = z | ((i3 & 112) == 32);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            AICenterCompose aICenterCompose = INSTANCE;
                            Pair<AiCenterInitialContext, String> pairResolveLaunchMode = aICenterCompose.resolveLaunchMode(launchMode);
                            aiCenterInitialContextComponent1 = pairResolveLaunchMode.component1();
                            strComponent2 = pairResolveLaunchMode.component2();
                            String strGenerateRecipientId = RecipientIdGeneratorKt.generateRecipientId();
                            bundle = new Bundle();
                            bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId);
                            bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                            if (aiCenterInitialContextComponent1 != null) {
                                aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                            }
                            if (strComponent2 != null) {
                                bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                            }
                            objRememberedValue = aICenterCompose.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId, bundle);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                        double d4 = d2;
                        Modifier modifier3 = companion;
                        AICenter(aiCenterViewHolder, d4, showContentPicker, showPreview, function3, function7, modifier3, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        d3 = d4;
                        function4 = function3;
                        function5 = function7;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        function4 = function2;
                        d3 = d2;
                        function5 = function0;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume2;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function8 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose2 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode2 = aICenterCompose2.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode2.component1();
                        strComponent2 = pairResolveLaunchMode2.component2();
                        String strGenerateRecipientId2 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId2);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose2.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId2, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose3 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode3 = aICenterCompose3.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode3.component1();
                        strComponent2 = pairResolveLaunchMode3.component2();
                        String strGenerateRecipientId3 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId3);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose3.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId3, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d5 = d2;
                    Modifier modifier4 = companion;
                    AICenter(aiCenterViewHolder, d5, showContentPicker, showPreview, function3, function8, modifier4, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d5;
                    function4 = function3;
                    function5 = function8;
                    modifier2 = modifier4;
                } else {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContext3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume3;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function9 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose4 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode4 = aICenterCompose4.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode4.component1();
                        strComponent2 = pairResolveLaunchMode4.component2();
                        String strGenerateRecipientId4 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId4);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose4.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId4, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose5 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode5 = aICenterCompose5.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode5.component1();
                        strComponent2 = pairResolveLaunchMode5.component2();
                        String strGenerateRecipientId5 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId5);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose5.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId5, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d6 = d2;
                    Modifier modifier5 = companion;
                    AICenter(aiCenterViewHolder, d6, showContentPicker, showPreview, function3, function9, modifier5, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d6;
                    function4 = function3;
                    function5 = function9;
                    modifier2 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i2 & 512) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((i3 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContext4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume4;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function10 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose6 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode6 = aICenterCompose6.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode6.component1();
                        strComponent2 = pairResolveLaunchMode6.component2();
                        String strGenerateRecipientId6 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId6);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose6.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId6, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose7 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode7 = aICenterCompose7.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode7.component1();
                        strComponent2 = pairResolveLaunchMode7.component2();
                        String strGenerateRecipientId7 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId7);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose7.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId7, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d7 = d2;
                    Modifier modifier6 = companion;
                    AICenter(aiCenterViewHolder, d7, showContentPicker, showPreview, function3, function10, modifier6, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d7;
                    function4 = function3;
                    function5 = function10;
                    modifier2 = modifier6;
                } else {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext5 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localContext5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume5, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume5;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function11 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose8 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode8 = aICenterCompose8.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode8.component1();
                        strComponent2 = pairResolveLaunchMode8.component2();
                        String strGenerateRecipientId8 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId8);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose8.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId8, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose9 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode9 = aICenterCompose9.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode9.component1();
                        strComponent2 = pairResolveLaunchMode9.component2();
                        String strGenerateRecipientId9 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId9);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose9.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId9, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d8 = d2;
                    Modifier modifier7 = companion;
                    AICenter(aiCenterViewHolder, d8, showContentPicker, showPreview, function3, function11, modifier7, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d8;
                    function4 = function3;
                    function5 = function11;
                    modifier2 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext6 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localContext6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume6, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume6;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function12 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose10 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode10 = aICenterCompose10.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode10.component1();
                    strComponent2 = pairResolveLaunchMode10.component2();
                    String strGenerateRecipientId10 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId10);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose10.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId10, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose11 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode11 = aICenterCompose11.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode11.component1();
                    strComponent2 = pairResolveLaunchMode11.component2();
                    String strGenerateRecipientId11 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId11);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose11.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId11, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d9 = d2;
                Modifier modifier8 = companion;
                AICenter(aiCenterViewHolder, d9, showContentPicker, showPreview, function3, function12, modifier8, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d9;
                function4 = function3;
                function5 = function12;
                modifier2 = modifier8;
            } else {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext7 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localContext7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume7, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume7;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function13 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose12 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode12 = aICenterCompose12.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode12.component1();
                    strComponent2 = pairResolveLaunchMode12.component2();
                    String strGenerateRecipientId12 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId12);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose12.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId12, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose13 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode13 = aICenterCompose13.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode13.component1();
                    strComponent2 = pairResolveLaunchMode13.component2();
                    String strGenerateRecipientId13 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId13);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose13.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId13, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d10 = d2;
                Modifier modifier9 = companion;
                AICenter(aiCenterViewHolder, d10, showContentPicker, showPreview, function3, function13, modifier9, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d10;
                function4 = function3;
                function5 = function13;
                modifier2 = modifier9;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        d2 = d;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(showContentPicker)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i2 & 32) != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(showPreview)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(modifier)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i2 & 512) != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i12 = 268435456;
                    }
                    i3 |= i12;
                }
                if ((i3 & 306783379) == 306783378) {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext8 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localContext8);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume8, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume8;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function14 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose14 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode14 = aICenterCompose14.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode14.component1();
                        strComponent2 = pairResolveLaunchMode14.component2();
                        String strGenerateRecipientId14 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId14);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose14.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId14, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose15 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode15 = aICenterCompose15.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode15.component1();
                        strComponent2 = pairResolveLaunchMode15.component2();
                        String strGenerateRecipientId15 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId15);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose15.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId15, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d11 = d2;
                    Modifier modifier10 = companion;
                    AICenter(aiCenterViewHolder, d11, showContentPicker, showPreview, function3, function14, modifier10, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d11;
                    function4 = function3;
                    function5 = function14;
                    modifier2 = modifier10;
                } else {
                    if (i13 != 0) {
                        d2 = 0.0d;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function2;
                    }
                    if (i8 == 0) {
                    }
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                    }
                    ProvidableCompositionLocal<Context> localContext9 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localContext9);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume9, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    fragmentActivity = (FragmentActivity) objConsume9;
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    if ((i3 & 14) != 4) {
                        z = true;
                    } else {
                        z = true;
                    }
                    Function0<Unit> function15 = function6;
                    z2 = z | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        AICenterCompose aICenterCompose16 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode16 = aICenterCompose16.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode16.component1();
                        strComponent2 = pairResolveLaunchMode16.component2();
                        String strGenerateRecipientId16 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId16);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose16.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId16, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        AICenterCompose aICenterCompose17 = INSTANCE;
                        Pair<AiCenterInitialContext, String> pairResolveLaunchMode17 = aICenterCompose17.resolveLaunchMode(launchMode);
                        aiCenterInitialContextComponent1 = pairResolveLaunchMode17.component1();
                        strComponent2 = pairResolveLaunchMode17.component2();
                        String strGenerateRecipientId17 = RecipientIdGeneratorKt.generateRecipientId();
                        bundle = new Bundle();
                        bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId17);
                        bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                        if (aiCenterInitialContextComponent1 != null) {
                            aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                        }
                        if (strComponent2 != null) {
                            bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                        }
                        objRememberedValue = aICenterCompose17.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId17, bundle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    double d12 = d2;
                    Modifier modifier11 = companion;
                    AICenter(aiCenterViewHolder, d12, showContentPicker, showPreview, function3, function15, modifier11, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    d3 = d12;
                    function4 = function3;
                    function5 = function15;
                    modifier2 = modifier11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) == 306783378) {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext10 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localContext10);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume10, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume10;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function16 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose18 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode18 = aICenterCompose18.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode18.component1();
                    strComponent2 = pairResolveLaunchMode18.component2();
                    String strGenerateRecipientId18 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId18);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose18.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId18, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose19 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode19 = aICenterCompose19.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode19.component1();
                    strComponent2 = pairResolveLaunchMode19.component2();
                    String strGenerateRecipientId19 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId19);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose19.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId19, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d13 = d2;
                Modifier modifier12 = companion;
                AICenter(aiCenterViewHolder, d13, showContentPicker, showPreview, function3, function16, modifier12, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d13;
                function4 = function3;
                function5 = function16;
                modifier2 = modifier12;
            } else {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext11 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localContext11);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume11, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume11;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function17 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose110 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode110 = aICenterCompose110.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode110.component1();
                    strComponent2 = pairResolveLaunchMode110.component2();
                    String strGenerateRecipientId110 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId110);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose110.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId110, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose111 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode111 = aICenterCompose111.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode111.component1();
                    strComponent2 = pairResolveLaunchMode111.component2();
                    String strGenerateRecipientId111 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId111);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose111.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId111, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d14 = d2;
                Modifier modifier13 = companion;
                AICenter(aiCenterViewHolder, d14, showContentPicker, showPreview, function3, function17, modifier13, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d14;
                function4 = function3;
                function5 = function17;
                modifier2 = modifier13;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i2 & 512) != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i12 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i12 = 268435456;
                }
                i3 |= i12;
            }
            if ((i3 & 306783379) == 306783378) {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext12 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localContext12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume12, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume12;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function18 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose112 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode112 = aICenterCompose112.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode112.component1();
                    strComponent2 = pairResolveLaunchMode112.component2();
                    String strGenerateRecipientId112 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId112);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose112.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId112, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose113 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode113 = aICenterCompose113.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode113.component1();
                    strComponent2 = pairResolveLaunchMode113.component2();
                    String strGenerateRecipientId113 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId113);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose113.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId113, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d15 = d2;
                Modifier modifier14 = companion;
                AICenter(aiCenterViewHolder, d15, showContentPicker, showPreview, function3, function18, modifier14, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d15;
                function4 = function3;
                function5 = function18;
                modifier2 = modifier14;
            } else {
                if (i13 != 0) {
                    d2 = 0.0d;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function2;
                }
                if (i8 == 0) {
                }
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
                }
                ProvidableCompositionLocal<Context> localContext13 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localContext13);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(objConsume13, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                fragmentActivity = (FragmentActivity) objConsume13;
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                if ((i3 & 14) != 4) {
                    z = true;
                } else {
                    z = true;
                }
                Function0<Unit> function19 = function6;
                z2 = z | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    AICenterCompose aICenterCompose114 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode114 = aICenterCompose114.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode114.component1();
                    strComponent2 = pairResolveLaunchMode114.component2();
                    String strGenerateRecipientId114 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId114);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose114.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId114, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    AICenterCompose aICenterCompose115 = INSTANCE;
                    Pair<AiCenterInitialContext, String> pairResolveLaunchMode115 = aICenterCompose115.resolveLaunchMode(launchMode);
                    aiCenterInitialContextComponent1 = pairResolveLaunchMode115.component1();
                    strComponent2 = pairResolveLaunchMode115.component2();
                    String strGenerateRecipientId115 = RecipientIdGeneratorKt.generateRecipientId();
                    bundle = new Bundle();
                    bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId115);
                    bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                    if (aiCenterInitialContextComponent1 != null) {
                        aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                    }
                    if (strComponent2 != null) {
                        bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                    }
                    objRememberedValue = aICenterCompose115.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId115, bundle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                double d16 = d2;
                Modifier modifier15 = companion;
                AICenter(aiCenterViewHolder, d16, showContentPicker, showPreview, function3, function19, modifier15, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                d3 = d16;
                function4 = function3;
                function5 = function19;
                modifier2 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        if ((i3 & 306783379) == 306783378) {
            if (i13 != 0) {
                d2 = 0.0d;
            }
            if (i6 != 0) {
                function3 = null;
            } else {
                function3 = function2;
            }
            if (i8 == 0) {
            }
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
            }
            ProvidableCompositionLocal<Context> localContext14 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localContext14);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(objConsume14, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            fragmentActivity = (FragmentActivity) objConsume14;
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            if ((i3 & 14) != 4) {
                z = true;
            } else {
                z = true;
            }
            Function0<Unit> function110 = function6;
            z2 = z | ((i3 & 112) == 32);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                AICenterCompose aICenterCompose116 = INSTANCE;
                Pair<AiCenterInitialContext, String> pairResolveLaunchMode116 = aICenterCompose116.resolveLaunchMode(launchMode);
                aiCenterInitialContextComponent1 = pairResolveLaunchMode116.component1();
                strComponent2 = pairResolveLaunchMode116.component2();
                String strGenerateRecipientId116 = RecipientIdGeneratorKt.generateRecipientId();
                bundle = new Bundle();
                bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId116);
                bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                if (aiCenterInitialContextComponent1 != null) {
                    aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                }
                if (strComponent2 != null) {
                    bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                }
                objRememberedValue = aICenterCompose116.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId116, bundle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                AICenterCompose aICenterCompose117 = INSTANCE;
                Pair<AiCenterInitialContext, String> pairResolveLaunchMode117 = aICenterCompose117.resolveLaunchMode(launchMode);
                aiCenterInitialContextComponent1 = pairResolveLaunchMode117.component1();
                strComponent2 = pairResolveLaunchMode117.component2();
                String strGenerateRecipientId117 = RecipientIdGeneratorKt.generateRecipientId();
                bundle = new Bundle();
                bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId117);
                bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                if (aiCenterInitialContextComponent1 != null) {
                    aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                }
                if (strComponent2 != null) {
                    bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                }
                objRememberedValue = aICenterCompose117.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId117, bundle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            double d17 = d2;
            Modifier modifier16 = companion;
            AICenter(aiCenterViewHolder, d17, showContentPicker, showPreview, function3, function110, modifier16, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            d3 = d17;
            function4 = function3;
            function5 = function110;
            modifier2 = modifier16;
        } else {
            if (i13 != 0) {
                d2 = 0.0d;
            }
            if (i6 != 0) {
                function3 = null;
            } else {
                function3 = function2;
            }
            if (i8 == 0) {
            }
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-847039819, i3, -1, "com.box.brownfieldApi.featuresNavigator.AICenterCompose.AICenter (AICenterCompose.kt:548)");
            }
            ProvidableCompositionLocal<Context> localContext15 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume15 = composerStartRestartGroup.consume(localContext15);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(objConsume15, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            fragmentActivity = (FragmentActivity) objConsume15;
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            if ((i3 & 14) != 4) {
                z = true;
            } else {
                z = true;
            }
            Function0<Unit> function111 = function6;
            z2 = z | ((i3 & 112) == 32);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                AICenterCompose aICenterCompose118 = INSTANCE;
                Pair<AiCenterInitialContext, String> pairResolveLaunchMode118 = aICenterCompose118.resolveLaunchMode(launchMode);
                aiCenterInitialContextComponent1 = pairResolveLaunchMode118.component1();
                strComponent2 = pairResolveLaunchMode118.component2();
                String strGenerateRecipientId118 = RecipientIdGeneratorKt.generateRecipientId();
                bundle = new Bundle();
                bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId118);
                bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                if (aiCenterInitialContextComponent1 != null) {
                    aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                }
                if (strComponent2 != null) {
                    bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                }
                objRememberedValue = aICenterCompose118.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId118, bundle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                AICenterCompose aICenterCompose119 = INSTANCE;
                Pair<AiCenterInitialContext, String> pairResolveLaunchMode119 = aICenterCompose119.resolveLaunchMode(launchMode);
                aiCenterInitialContextComponent1 = pairResolveLaunchMode119.component1();
                strComponent2 = pairResolveLaunchMode119.component2();
                String strGenerateRecipientId119 = RecipientIdGeneratorKt.generateRecipientId();
                bundle = new Bundle();
                bundle.putString(RECIPIENT_ID_KEY, strGenerateRecipientId119);
                bundle.putString(HOST_SURFACE_KEY, hostSurface.getValue());
                if (aiCenterInitialContextComponent1 != null) {
                    aiCenterInitialContextComponent1.writeTo$brownfieldApi_release(bundle);
                }
                if (strComponent2 != null) {
                    bundle.putString(INITIAL_SESSION_ID_KEY, strComponent2);
                }
                objRememberedValue = aICenterCompose119.createAiCenterViewHolderInternal(fragmentActivity, strGenerateRecipientId119, bundle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            aiCenterViewHolder = (AiCenterViewHolder) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AICenterCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(aiCenterViewHolder) | composerStartRestartGroup.changedInstance(styleVariantDelegate);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AICenterCompose.AICenter$lambda$27$lambda$26(aiCenterViewHolder, styleVariantDelegate, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(aiCenterViewHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            double d18 = d2;
            Modifier modifier17 = companion;
            AICenter(aiCenterViewHolder, d18, showContentPicker, showPreview, function3, function111, modifier17, composerStartRestartGroup, (i3 >> 6) & 33554416, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            d3 = d18;
            function4 = function3;
            function5 = function111;
            modifier2 = modifier17;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AICenterCompose.AICenter$lambda$28(this.f$0, launchMode, hostSurface, styleVariantDelegate, d3, showContentPicker, showPreview, function4, function5, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AICenter$lambda$27$lambda$26(final AiCenterViewHolder aiCenterViewHolder, StyleVariantDelegate styleVariantDelegate, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        StyleVariantRegistry.INSTANCE.register(aiCenterViewHolder.getRecipientId(), styleVariantDelegate);
        return new DisposableEffectResult() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$AICenter$lambda$27$lambda$26$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                StyleVariantRegistry.INSTANCE.unregister(aiCenterViewHolder.getRecipientId());
                AICenterCompose.INSTANCE.cleanupView(aiCenterViewHolder);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberLazyAiCenterViewHolder$lambda$5$lambda$4(final Lazy lazy, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.brownfieldApi.featuresNavigator.AICenterCompose$rememberLazyAiCenterViewHolder$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                if (lazy.isInitialized()) {
                    StyleVariantRegistry.INSTANCE.unregister(((AiCenterViewHolder) lazy.getValue()).getRecipientId());
                    AICenterCompose.INSTANCE.cleanupView((AiCenterViewHolder) lazy.getValue());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<String, Unit> AICenter$lambda$12(State<? extends Function1<? super String, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> AICenter$lambda$13(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}
