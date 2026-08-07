package com.box.android.boxai.prompt;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.components.inputbar.BasicInputBarReducer;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.InputTextFieldKt;
import com.box.android.base.presentation.components.inputbar.KeyboardAction;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.base.presentation.components.permission.PermissionHandlerComponentKt;
import com.box.android.boxai.R;
import com.box.android.boxai.voice.VoiceInputBarKt;
import com.box.android.boxai.voice.VoiceInputReducer;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aY\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0010\u001aE\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0003¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u001b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"DisabledBoxAiPromptInputBox", "", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiPromptInputBox", "state", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;", "isEnabled", "", "isPromptOperationEnabled", "onVoiceInputError", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "(Lcom/box/android/boxai/prompt/BoxAiPromptReducer$State;ZZLkotlin/jvm/functions/Function1;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "TextPromptInput", "inputState", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;", "isTextFieldEnabled", "promptOperation", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$PromptOperation;", "(Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;ZLcom/box/android/boxai/prompt/BoxAiPromptReducer$PromptOperation;ZLcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "REQUIRED_AUDIO_PERMISSION", "", "DisabledBoxAiPromptInputBoxPreview", "EmptyBoxAiPromptInputBoxPreview", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiPromptInputBoxKt {
    private static final String REQUIRED_AUDIO_PERMISSION = "android.permission.RECORD_AUDIO";

    /* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAiPromptReducer.PromptOperation.values().length];
            try {
                iArr[BoxAiPromptReducer.PromptOperation.VOICE_INPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAiPromptReducer.PromptOperation.SUBMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiPromptInputBox$lambda$3(BoxAiPromptReducer.State state, boolean z, boolean z2, Function1 function1, Store store, int i, Composer composer, int i2) {
        BoxAiPromptInputBox(state, z, z2, function1, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisabledBoxAiPromptInputBox$lambda$1(int i, Composer composer, int i2) {
        DisabledBoxAiPromptInputBox(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisabledBoxAiPromptInputBoxPreview$lambda$0(int i, Composer composer, int i2) {
        DisabledBoxAiPromptInputBoxPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyBoxAiPromptInputBoxPreview$lambda$0(int i, Composer composer, int i2) {
        EmptyBoxAiPromptInputBoxPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$3(BasicInputBarReducer.State state, boolean z, BoxAiPromptReducer.PromptOperation promptOperation, boolean z2, Store store, int i, Composer composer, int i2) {
        TextPromptInput(state, z, promptOperation, z2, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DisabledBoxAiPromptInputBox(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-585816980);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisabledBoxAiPromptInputBox)49@2315L2,41@1951L394:BoxAiPromptInputBox.kt#askcry");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-585816980, i, -1, "com.box.android.boxai.prompt.DisabledBoxAiPromptInputBox (BoxAiPromptInputBox.kt:40)");
            }
            BoxAiPromptReducer.State state = new BoxAiPromptReducer.State(false, new BasicInputBarReducer.State(new TextFieldValueUIModel("", 0, 0, null, 14, null), null), new VoiceInputReducer.State.Off(false, 1, null), null, 8, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -329389074, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            BoxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1 boxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (boxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1RememberedValue = new BoxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1(null);
                composerStartRestartGroup.updateRememberedValue(boxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAiPromptInputBox(state, false, false, (Function1) boxAiPromptInputBoxKt$DisabledBoxAiPromptInputBox$1$1RememberedValue, null, composerStartRestartGroup, 25008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.DisabledBoxAiPromptInputBox$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BoxAiPromptInputBox(final BoxAiPromptReducer.State state, final boolean z, final boolean z2, final Function1<? super Continuation<? super Unit>, ? extends Object> onVoiceInputError, final Store<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onVoiceInputError, "onVoiceInputError");
        Composer composerStartRestartGroup = composer.startRestartGroup(766546532);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiPromptInputBox)N(state,isEnabled,isPromptOperationEnabled,onVoiceInputError,store)62@2608L1079,92@3853L206,92@3811L248:BoxAiPromptInputBox.kt#askcry");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onVoiceInputError) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(766546532, i2, -1, "com.box.android.boxai.prompt.BoxAiPromptInputBox (BoxAiPromptInputBox.kt:61)");
            }
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2103027776, "C69@2887L83,73@3016L665,67@2799L882:BoxAiPromptInputBox.kt#askcry");
            Boolean boolValueOf = Boolean.valueOf(!(state.getVoiceInputState() instanceof VoiceInputReducer.State.Off));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 763448977, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiPromptInputBoxKt.BoxAiPromptInputBox$lambda$0$0$0((AnimatedContentTransitionScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            AnimatedContentKt.AnimatedContent(boolValueOf, null, (Function1) objRememberedValue, null, "Voice input", null, ComposableLambdaKt.rememberComposableLambda(643582971, true, new Function4() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return BoxAiPromptInputBoxKt.BoxAiPromptInputBox$lambda$0$1(state, store, z, z2, (AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1597824, 42);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            VoiceInputReducer.State voiceInputState = state.getVoiceInputState();
            VoiceInputReducer.State.Off off = voiceInputState instanceof VoiceInputReducer.State.Off ? (VoiceInputReducer.State.Off) voiceInputState : null;
            boolean shouldShowError = off != null ? off.getShouldShowError() : false;
            Boolean boolValueOf2 = Boolean.valueOf(shouldShowError);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2083109710, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(shouldShowError) | composerStartRestartGroup.changedInstance(onVoiceInputError) | ((i3 & 57344) == 16384);
            BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1 boxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || boxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                boxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1RememberedValue = new BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1(shouldShowError, onVoiceInputError, store, null);
                composerStartRestartGroup.updateRememberedValue(boxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) boxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1RememberedValue, composerStartRestartGroup, 0);
            if (store != null) {
                composerStartRestartGroup.startReplaceGroup(-151658510);
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4350L49,100@4094L316");
                int i4 = R.string.box_ai_microphone_permission_permanently_denied;
                AnonymousClass3 anonymousClass3 = new PropertyReference1Impl() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt.BoxAiPromptInputBox.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((BoxAiPromptReducer.State) obj).getAudioPermissionsState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2083093963, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1 boxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (boxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    boxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1RememberedValue = BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(boxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PermissionHandlerComponentKt.PermissionHandlerComponent(REQUIRED_AUDIO_PERMISSION, i4, store.scope(anonymousClass3, (Function1) ((KFunction) boxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1RememberedValue)), composerStartRestartGroup, 6);
            } else {
                composerStartRestartGroup.startReplaceGroup(-155721122);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.BoxAiPromptInputBox$lambda$3(state, z, z2, onVoiceInputError, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform BoxAiPromptInputBox$lambda$0$0$0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiPromptInputBox$lambda$0$1(BoxAiPromptReducer.State state, Store store, boolean z, boolean z2, AnimatedContentScope AnimatedContent, boolean z3, Composer composer, int i) {
        Store storeScope;
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(targetShowVoiceInput):BoxAiPromptInputBox.kt#askcry");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(643582971, i, -1, "com.box.android.boxai.prompt.BoxAiPromptInputBox.<anonymous>.<anonymous> (BoxAiPromptInputBox.kt:74)");
        }
        if (z3) {
            composer.startReplaceGroup(246350771);
            ComposerKt.sourceInformation(composer, "75@3098L212");
            VoiceInputReducer.State voiceInputState = state.getVoiceInputState();
            if (store == null) {
                composer.startReplaceGroup(246464137);
                composer.endReplaceGroup();
                storeScope = null;
            } else {
                composer.startReplaceGroup(7950456);
                ComposerKt.sourceInformation(composer, "77@3248L43");
                BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$1 boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$1 = new PropertyReference1Impl() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((BoxAiPromptReducer.State) obj).getVoiceInputState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, 7951974, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1 boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1RememberedValue = composer.rememberedValue();
                if (boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1RememberedValue = BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1.INSTANCE;
                    composer.updateRememberedValue(boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                storeScope = store.scope(boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$1, (Function1) ((KFunction) boxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1RememberedValue));
                composer.endReplaceGroup();
            }
            VoiceInputBarKt.VoiceInputBar(null, voiceInputState, storeScope, composer, 0, 1);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(246601778);
            ComposerKt.sourceInformation(composer, "80@3348L309");
            TextPromptInput(state.getTextInputState(), z, state.getPromptOperation(), z2, store, composer, BasicInputBarReducer.State.$stable);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void TextPromptInput(final BasicInputBarReducer.State state, final boolean z, final BoxAiPromptReducer.PromptOperation promptOperation, final boolean z2, final Store<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> store, Composer composer, final int i) {
        int i2;
        boolean z3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1585373974);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextPromptInput)N(inputState,isTextFieldEnabled,promptOperation,isPromptOperationEnabled,store)116@4751L7,130@5271L43,123@5012L79,126@5126L86,131@5339L1965,118@4764L2546:BoxAiPromptInputBox.kt#askcry");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(state) : composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z3 = z;
            i2 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
        } else {
            z3 = z;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(promptOperation == null ? -1 : promptOperation.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1585373974, i3, -1, "com.box.android.boxai.prompt.TextPromptInput (BoxAiPromptInputBox.kt:115)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            InputBoxValue inputBoxValue = new InputBoxValue(state.getTextField(), null, 2, null);
            int i4 = R.string.box_ai_placeholder;
            KeyboardAction keyboardAction = state.getKeyboardAction();
            String strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_placeholder, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1169019449, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            int i5 = 57344 & i3;
            boolean z4 = i5 == 16384;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiPromptInputBoxKt.TextPromptInput$lambda$0$0(store, (TextFieldValueUIModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1169023104, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
            boolean z5 = i5 == 16384;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiPromptInputBoxKt.TextPromptInput$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z6 = z3;
            composer2 = composerStartRestartGroup;
            InputTextFieldKt.InputTextField(inputBoxValue, i4, function1, (Function0) objRememberedValue2, null, z, true, null, 0, keyboardAction, strStringResource, null, ComposableLambdaKt.rememberComposableLambda(1254361651, true, new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.TextPromptInput$lambda$2(promptOperation, z2, z6, store, focusManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1572864 | InputBoxValue.$stable | ((i3 << 12) & 458752), 384, 2448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.TextPromptInput$lambda$3(state, z, promptOperation, z2, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$0$0(Store store, TextFieldValueUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (store != null) {
            store.send(BoxAiPromptReducerHelperKt.updatePrompt(BoxAiPromptReducer.Action.INSTANCE, it));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$1$0(Store store) {
        if (store != null) {
            store.send(BoxAiPromptReducerHelperKt.keyboardActionHandled(BoxAiPromptReducer.Action.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$2(BoxAiPromptReducer.PromptOperation promptOperation, boolean z, boolean z2, final Store store, final FocusManager focusManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxAiPromptInputBox.kt#askcry");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1254361651, i, -1, "com.box.android.boxai.prompt.TextPromptInput.<anonymous> (BoxAiPromptInputBox.kt:132)");
            }
            if (promptOperation == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            boolean z3 = z && z2;
            int i2 = WhenMappings.$EnumSwitchMapping$0[promptOperation.ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(-1822197659);
                ComposerKt.sourceInformation(composer, "137@5720L76,144@6093L6,141@5888L157,136@5613L906");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1444251297, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiPromptInputBoxKt.TextPromptInput$lambda$2$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierSemantics = SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue);
                long jM11500getAppPrimary0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer, -1444245840, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiPromptInputBoxKt.TextPromptInput$lambda$2$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                InputTextFieldKt.m11822InputTextFieldActionButtonY0xEhic(modifierSemantics, z3, jM11500getAppPrimary0d7_KjU, 0L, (Function0) objRememberedValue2, ComposableSingletons$BoxAiPromptInputBoxKt.INSTANCE.getLambda$2031708606$boxai_generalProdRelease(), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                composer.endReplaceGroup();
            } else {
                if (i2 != 2) {
                    composer.startReplaceGroup(-1444256619);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(-1821225561);
                ComposerKt.sourceInformation(composer, "157@6729L76,160@6841L37,161@6925L60,163@7077L163,156@6622L640");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1444219009, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiPromptInputBoxKt.TextPromptInput$lambda$2$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierSemantics2 = SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue3);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_send24, composer, 0);
                String strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_submit_prompt_talkback_label, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1444207786, "CC(remember):BoxAiPromptInputBox.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(focusManager) | composer.changed(store);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiPromptInputBoxKt.TextPromptInput$lambda$2$3$0(focusManager, store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                InputTextFieldKt.m11823InputTextFieldActionButtonnBX6wN0(modifierSemantics2, painterPainterResource, strStringResource, z3, 0L, 0L, (Function0) objRememberedValue4, composer, Painter.$stable << 3, 48);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$2$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$2$1$0(Store store) {
        if (store != null) {
            store.send(new BoxAiPromptReducer.Action.StartVoiceInput(REQUIRED_AUDIO_PERMISSION));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$2$2$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextPromptInput$lambda$2$3$0(FocusManager focusManager, Store store) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        if (store != null) {
            store.send(BoxAiPromptReducerHelperKt.submitPrompt(BoxAiPromptReducer.Action.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    private static final void DisabledBoxAiPromptInputBoxPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1089637536);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisabledBoxAiPromptInputBoxPreview)181@7540L142:BoxAiPromptInputBox.kt#askcry");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1089637536, i, -1, "com.box.android.boxai.prompt.DisabledBoxAiPromptInputBoxPreview (BoxAiPromptInputBox.kt:180)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiPromptInputBoxKt.INSTANCE.getLambda$47092011$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.DisabledBoxAiPromptInputBoxPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void EmptyBoxAiPromptInputBoxPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-14044021);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyBoxAiPromptInputBoxPreview)191@7768L379:BoxAiPromptInputBox.kt#askcry");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-14044021, i, -1, "com.box.android.boxai.prompt.EmptyBoxAiPromptInputBoxPreview (BoxAiPromptInputBox.kt:190)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiPromptInputBoxKt.INSTANCE.m12017getLambda$1017646112$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiPromptInputBoxKt.EmptyBoxAiPromptInputBoxPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
