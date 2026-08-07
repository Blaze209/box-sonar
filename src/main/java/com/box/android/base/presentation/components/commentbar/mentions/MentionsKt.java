package com.box.android.base.presentation.components.commentbar.mentions;

import android.content.res.Configuration;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.ScrollbarKt;
import com.box.android.base.compose.UserAvatarKt;
import com.box.android.cpl.Store;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Mentions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\u001aM\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aA\u0010\u0010\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00152\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a\"\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0002\"\u000e\u0010\u001f\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020 X\u0086T¢\u0006\u0002\n\u0000¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u008e\u0002"}, d2 = {"CollaboratorsMentionsPopup", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "freeSpaceToTopOfScreen", "Landroidx/compose/ui/unit/Dp;", ViewProps.PADDING_START, ViewProps.PADDING_BOTTOM, "modifier", "Landroidx/compose/ui/Modifier;", "CollaboratorsMentionsPopup-Cxxc4bg", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;FFFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollaboratorsMentionsList", "collaborators", "", "Lcom/box/androidsdk/content/models/BoxCollaborator;", "onMentionItemClick", "Lkotlin/Function1;", "(Ljava/util/List;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollaboratorsViewForMentionsItem", "collaborator", "Lkotlin/Function0;", "(Lcom/box/androidsdk/content/models/BoxCollaborator;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "handleLongPressPassOtherGesturesToChildren", "key", "", "onLongPress", "SMALL_SPACE_CONSTRAINT", "", "MINIMUM_MENTION_BAR_HEIGHT", "base_generalProdRelease", "state", "isExpanded", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MentionsKt {
    public static final int MINIMUM_MENTION_BAR_HEIGHT = 220;
    public static final int SMALL_SPACE_CONSTRAINT = 180;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsList$lambda$1(List list, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollaboratorsMentionsList(list, defaultAvatarControllerWrapper, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$2(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m11805CollaboratorsMentionsPopupCxxc4bg(store, defaultAvatarControllerWrapper, f, f2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$9(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, float f, float f2, float f3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m11805CollaboratorsMentionsPopupCxxc4bg(store, defaultAvatarControllerWrapper, f, f2, f3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsViewForMentionsItem$lambda$2(BoxCollaborator boxCollaborator, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Function0 function0, int i, Composer composer, int i2) {
        CollaboratorsViewForMentionsItem(boxCollaborator, defaultAvatarControllerWrapper, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x021b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0235  */
    /* JADX WARN: Code duplicated, block: B:106:0x0239  */
    /* JADX WARN: Code duplicated, block: B:109:0x0243  */
    /* JADX WARN: Code duplicated, block: B:110:0x0258 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    /* JADX WARN: Code duplicated, block: B:82:0x0114  */
    /* JADX WARN: Code duplicated, block: B:84:0x0122  */
    /* JADX WARN: Code duplicated, block: B:85:0x0124  */
    /* JADX WARN: Code duplicated, block: B:88:0x0139  */
    /* JADX WARN: Code duplicated, block: B:91:0x019b  */
    /* JADX WARN: Code duplicated, block: B:92:0x019d  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ac  */
    /* JADX INFO: renamed from: CollaboratorsMentionsPopup-Cxxc4bg, reason: not valid java name */
    public static final void m11805CollaboratorsMentionsPopupCxxc4bg(final Store<CollaboratorsMentionsReducer.State, CollaboratorsMentionsReducer.Action> store, final DefaultAvatarControllerWrapper avatarControllerWrapper, final float f, final float f2, final float f3, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final Modifier modifier4;
        List<BoxCollaborator> filteredCollaborators;
        List<BoxCollaborator> list;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        final MutableState mutableState;
        final SoftwareKeyboardController softwareKeyboardController;
        boolean z4;
        Object objRememberedValue2;
        boolean zChanged;
        MentionsKt$CollaboratorsMentionsPopup$3$1 mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(1592384641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollaboratorsMentionsPopup)N(store,avatarControllerWrapper,freeSpaceToTopOfScreen:c#ui.unit.Dp,paddingStart:c#ui.unit.Dp,paddingBottom:c#ui.unit.Dp,modifier)68@3119L29,74@3482L34,76@3579L7,79@3709L7,84@3890L39,89@4066L2308,82@3813L2561,139@6414L82,139@6380L116:Mentions.kt#hj0g27");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1592384641, i3, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsPopup (Mentions.kt:67)");
                }
                filteredCollaborators = CollaboratorsMentionsPopup_Cxxc4bg$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getFilteredCollaborators();
                list = filteredCollaborators;
                if (list != null || list.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    filteredCollaborators = null;
                }
                if (filteredCollaborators == null) {
                    final Modifier modifier5 = modifier4;
                    if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(180)) < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273302915, "CC(remember):Mentions.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    softwareKeyboardController = (SoftwareKeyboardController) objConsume;
                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localConfiguration);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM9687constructorimpl = Dp.m9687constructorimpl(Math.min(Dp.m9687constructorimpl(Dp.m9687constructorimpl(((Configuration) objConsume2).screenHeightDp) * 0.6f), f));
                    Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273315976, "CC(remember):Mentions.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$6$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function0 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PopupProperties popupProperties = new PopupProperties(false, true, false, false, 9, (DefaultConstructorMarker) null);
                    final List<BoxCollaborator> list2 = filteredCollaborators;
                    final boolean z5 = z3;
                    Function2 function3 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$7(f, store, z5, list2, avatarControllerWrapper, softwareKeyboardController, modifier5, f2, f3, fM9687constructorimpl, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    modifier2 = modifier5;
                    AndroidPopup_androidKt.m9942PopupK5zGePQ(bottomStart, 0L, function0, popupProperties, ComposableLambdaKt.rememberComposableLambda(1206414884, true, function3, composerStartRestartGroup, 54), composerStartRestartGroup, 27654, 2);
                    Boolean boolValueOf = Boolean.valueOf(CollaboratorsMentionsPopup_Cxxc4bg$lambda$4(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273396787, "CC(remember):Mentions.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                    mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue = new MentionsKt$CollaboratorsMentionsPopup$3$1(softwareKeyboardController, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$2(store, avatarControllerWrapper, f, f2, f3, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$9(store, avatarControllerWrapper, f, f2, f3, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1592384641, i3, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsPopup (Mentions.kt:67)");
            }
            filteredCollaborators = CollaboratorsMentionsPopup_Cxxc4bg$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getFilteredCollaborators();
            list = filteredCollaborators;
            if (list != null) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (z2) {
                filteredCollaborators = null;
            }
            if (filteredCollaborators == null) {
                final Modifier modifier6 = modifier4;
                if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(180)) < 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273302915, "CC(remember):Mentions.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localSoftwareKeyboardController2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                softwareKeyboardController = (SoftwareKeyboardController) objConsume3;
                ProvidableCompositionLocal<Configuration> localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localConfiguration2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM9687constructorimpl2 = Dp.m9687constructorimpl(Math.min(Dp.m9687constructorimpl(Dp.m9687constructorimpl(((Configuration) objConsume4).screenHeightDp) * 0.6f), f));
                Alignment bottomStart2 = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273315976, "CC(remember):Mentions.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$6$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$6$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PopupProperties popupProperties2 = new PopupProperties(false, true, false, false, 9, (DefaultConstructorMarker) null);
                final List list3 = filteredCollaborators;
                final boolean z6 = z3;
                Function2 function4 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$7(f, store, z6, list3, avatarControllerWrapper, softwareKeyboardController, modifier6, f2, f3, fM9687constructorimpl2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                modifier2 = modifier6;
                AndroidPopup_androidKt.m9942PopupK5zGePQ(bottomStart2, 0L, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(1206414884, true, function4, composerStartRestartGroup, 54), composerStartRestartGroup, 27654, 2);
                Boolean boolValueOf2 = Boolean.valueOf(CollaboratorsMentionsPopup_Cxxc4bg$lambda$4(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1273396787, "CC(remember):Mentions.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue = new MentionsKt$CollaboratorsMentionsPopup$3$1(softwareKeyboardController, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue);
                } else {
                    mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue = new MentionsKt$CollaboratorsMentionsPopup$3$1(softwareKeyboardController, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) mentionsKt$CollaboratorsMentionsPopup$3$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$2(store, avatarControllerWrapper, f, f2, f3, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$9(store, avatarControllerWrapper, f, f2, f3, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CollaboratorsMentionsPopup_Cxxc4bg$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CollaboratorsMentionsPopup_Cxxc4bg$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$6$0(Store store) {
        store.send(CollaboratorsMentionsReducer.Action.DismissRequested.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$7(float f, final Store store, boolean z, List list, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final SoftwareKeyboardController softwareKeyboardController, Modifier modifier, float f2, float f3, float f4, final MutableState mutableState, Composer composer, int i) {
        Modifier.Companion companionHandleLongPressPassOtherGesturesToChildren;
        ComposerKt.sourceInformation(composer, "C98@4601L280,92@4250L2118:Mentions.kt#hj0g27");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1206414884, i, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsPopup.<anonymous> (Mentions.kt:92)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1252height3ABfNKs(AnimationModifierKt.animateContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AnimationSpecKt.tween$default(400, 0, null, 6, null), null, 2, null), Dp.m9687constructorimpl(Math.max(f, Dp.m9687constructorimpl(220)))), "CollaboratorMentionsListDismissArea");
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -276448996, "CC(remember):Mentions.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            PointerInputEventHandler pointerInputEventHandlerRememberedValue = composer.rememberedValue();
            if (zChanged || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$2$1$1

                    /* JADX INFO: renamed from: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$2$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Mentions.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$2$1$1$1", f = "Mentions.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Store<CollaboratorsMentionsReducer.State, CollaboratorsMentionsReducer.Action> $store;
                        final /* synthetic */ PointerInputScope $this_pointerInput;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(PointerInputScope pointerInputScope, Store<CollaboratorsMentionsReducer.State, CollaboratorsMentionsReducer.Action> store, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$this_pointerInput = pointerInputScope;
                            this.$store = store;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$this_pointerInput, this.$store, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX INFO: renamed from: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$2$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: Mentions.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$2$1$1$1$1", f = "Mentions.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
                        static final class C01181 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Store<CollaboratorsMentionsReducer.State, CollaboratorsMentionsReducer.Action> $store;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C01181(Store<CollaboratorsMentionsReducer.State, CollaboratorsMentionsReducer.Action> store, Continuation<? super C01181> continuation) {
                                super(2, continuation);
                                this.$store = store;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C01181 c01181 = new C01181(this.$store, continuation);
                                c01181.L$0 = obj;
                                return c01181;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                                return ((C01181) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(awaitPointerEventScope);
                                    this.label = 1;
                                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, true, null, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                this.$store.send(CollaboratorsMentionsReducer.Action.DismissRequested.INSTANCE);
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C01181(this.$store, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, store, null), continuation);
                        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(pointerInputEventHandlerRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag, unit, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue);
            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPointerInput);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -31092061, "C113@5254L132,110@5068L1290:Mentions.kt#hj0g27");
            float f5 = 2;
            float fM9687constructorimpl = Dp.m9687constructorimpl(f5);
            boolean z2 = z && !CollaboratorsMentionsPopup_Cxxc4bg$lambda$4(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1938667822, "CC(remember):Mentions.kt#9igjgp");
            boolean zChanged2 = composer.changed(store) | composer.changed(softwareKeyboardController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$7$1$0$0(store, softwareKeyboardController, (BoxCollaborator) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.startReplaceGroup(1938693053);
            ComposerKt.sourceInformation(composer, "*132@6275L21");
            float f6 = f2 - fM9687constructorimpl;
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(f6);
            float fM9687constructorimpl3 = Dp.m9687constructorimpl(f6);
            float f7 = 0;
            Modifier modifierM6412shadows4CzXII$default = ShadowKt.m6412shadows4CzXII$default(PaddingKt.m1218padding3ABfNKs(ClipKt.clip(SizeKt.m1253heightInVpY3zN4(AnimationModifierKt.animateContentSize$default(PaddingKt.m1222paddingqDBjuR0$default(modifier, fM9687constructorimpl2, 0.0f, fM9687constructorimpl3, Dp.m9687constructorimpl(Math.max(f3, Dp.m9687constructorimpl(f7))), 2, null), AnimationSpecKt.tween$default(400, 0, null, 6, null), null, 2, null), Dp.m9687constructorimpl(f7), f4), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f5))), fM9687constructorimpl), Dp.m9687constructorimpl(1), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f5)), false, 0L, 0L, 28, null);
            if (z2) {
                Modifier.Companion companion = Modifier.INSTANCE;
                Boolean boolValueOf = Boolean.valueOf(z2);
                ComposerKt.sourceInformationMarkerStart(composer, 1075586602, "CC(remember):Mentions.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$7$1$1$0$0(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionHandleLongPressPassOtherGesturesToChildren = handleLongPressPassOtherGesturesToChildren(companion, boolValueOf, (Function0) objRememberedValue2);
            } else {
                companionHandleLongPressPassOtherGesturesToChildren = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierM6412shadows4CzXII$default.then(companionHandleLongPressPassOtherGesturesToChildren);
            composer.endReplaceGroup();
            CollaboratorsMentionsList(list, defaultAvatarControllerWrapper, function1, modifierThen, composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$7$1$0$0(Store store, SoftwareKeyboardController softwareKeyboardController, BoxCollaborator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new CollaboratorsMentionsReducer.Action.OnMentionOptionClicked(it));
        if (softwareKeyboardController != null) {
            softwareKeyboardController.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsPopup_Cxxc4bg$lambda$7$1$1$0$0(MutableState mutableState) {
        CollaboratorsMentionsPopup_Cxxc4bg$lambda$5(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0081  */
    /* JADX WARN: Code duplicated, block: B:41:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x010d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0110  */
    /* JADX WARN: Code duplicated, block: B:54:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x012d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0152  */
    /* JADX WARN: Code duplicated, block: B:64:0x0158  */
    /* JADX WARN: Code duplicated, block: B:67:0x0164  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public static final void CollaboratorsMentionsList(final List<? extends BoxCollaborator> collaborators, final DefaultAvatarControllerWrapper avatarControllerWrapper, final Function1<? super BoxCollaborator, Unit> onMentionItemClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(collaborators, "collaborators");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(onMentionItemClick, "onMentionItemClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1993799509);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollaboratorsMentionsList)N(collaborators,avatarControllerWrapper,onMentionItemClick,modifier)153@6759L23,157@6909L6,161@7091L6,159@7003L132,164@7173L291,154@6787L677:Mentions.kt#hj0g27");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(collaborators) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onMentionItemClick) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1993799509, i3, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsList (Mentions.kt:152)");
                }
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                Modifier modifier4 = companion;
                i4 = i3;
                Modifier modifierM11661scrollbareCwULMo = ScrollbarKt.m11661scrollbareCwULMo(TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.wrapContentHeight$default(companion, Alignment.INSTANCE.getBottom(), false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11537getMentionsPopupBackground0d7_KjU(), null, 2, null), "CollaboratorMentionsList"), lazyListStateRememberLazyListState, false, 0.0f, 0.0f, 0.0f, 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11537getMentionsPopupBackground0d7_KjU(), composerStartRestartGroup, 0, 62);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485892690, "CC(remember):Mentions.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(collaborators);
                if ((i4 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChangedInstance | z2 | ((i4 & 896) == 256);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MentionsKt.CollaboratorsMentionsList$lambda$0$0(collaborators, avatarControllerWrapper, onMentionItemClick, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierM11661scrollbareCwULMo, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 508);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MentionsKt.CollaboratorsMentionsList$lambda$1(collaborators, avatarControllerWrapper, onMentionItemClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1993799509, i3, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsList (Mentions.kt:152)");
            }
            LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifier5 = companion;
            i4 = i3;
            Modifier modifierM11661scrollbareCwULMo2 = ScrollbarKt.m11661scrollbareCwULMo(TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.wrapContentHeight$default(companion, Alignment.INSTANCE.getBottom(), false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11537getMentionsPopupBackground0d7_KjU(), null, 2, null), "CollaboratorMentionsList"), lazyListStateRememberLazyListState2, false, 0.0f, 0.0f, 0.0f, 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11537getMentionsPopupBackground0d7_KjU(), composerStartRestartGroup, 0, 62);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -485892690, "CC(remember):Mentions.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(collaborators);
            if ((i4 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChangedInstance2 | z2 | ((i4 & 896) == 256);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MentionsKt.CollaboratorsMentionsList$lambda$0$0(collaborators, avatarControllerWrapper, onMentionItemClick, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MentionsKt.CollaboratorsMentionsList$lambda$0$0(collaborators, avatarControllerWrapper, onMentionItemClick, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierM11661scrollbareCwULMo2, lazyListStateRememberLazyListState2, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MentionsKt.CollaboratorsMentionsList$lambda$1(collaborators, avatarControllerWrapper, onMentionItemClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsMentionsList$lambda$0$0(final List list, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function2 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MentionsKt.CollaboratorsMentionsList$lambda$0$0$0((BoxCollaborator) obj);
            }
        };
        final MentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$1 mentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BoxCollaborator boxCollaborator) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BoxCollaborator) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return mentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsList$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final BoxCollaborator boxCollaborator = (BoxCollaborator) list.get(i);
                composer.startReplaceGroup(-141829789);
                ComposerKt.sourceInformation(composer, "CN(it)*169@7408L26,166@7235L213:Mentions.kt#hj0g27");
                DefaultAvatarControllerWrapper defaultAvatarControllerWrapper2 = defaultAvatarControllerWrapper;
                ComposerKt.sourceInformationMarkerStart(composer, -1528590459, "CC(remember):Mentions.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(boxCollaborator);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsList$1$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function3.invoke(boxCollaborator);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                MentionsKt.CollaboratorsViewForMentionsItem(boxCollaborator, defaultAvatarControllerWrapper2, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CollaboratorsMentionsList$lambda$0$0$0(BoxCollaborator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String id = it.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return id;
    }

    public static final void CollaboratorsViewForMentionsItem(final BoxCollaborator collaborator, final DefaultAvatarControllerWrapper avatarControllerWrapper, final Function0<Unit> onMentionItemClick, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(collaborator, "collaborator");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(onMentionItemClick, "onMentionItemClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1528661773);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollaboratorsViewForMentionsItem)N(collaborator,avatarControllerWrapper,onMentionItemClick)185@7797L24,181@7657L1249:Mentions.kt#hj0g27");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(collaborator) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onMentionItemClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1528661773, i2, -1, "com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsViewForMentionsItem (Mentions.kt:180)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 165158789, "CC(remember):Mentions.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MentionsKt.CollaboratorsViewForMentionsItem$lambda$0$0(onMentionItemClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null);
            float f = 8;
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1219paddingVpY3zN4(modifierM632clickableoSLSa3U$default, Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(f)), "CollaboratorMentionItem");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1551723454, "C189@7944L278,197@8231L669:Mentions.kt#hj0g27");
            String id = collaborator.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            UserAvatarKt.UserAvatar(id, collaborator.getLogin(), avatarControllerWrapper.getDefaultAvatarController(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()), composerStartRestartGroup, 3072, 0);
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1632122285, "C202@8398L6,200@8317L249,210@8718L6,207@8579L311:Mentions.kt#hj0g27");
            String userName = collaborator.getUserName();
            Intrinsics.checkNotNullExpressionValue(userName, "getName(...)");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(userName, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer2, 0, 12607872, 110586);
            String login = collaborator.getLogin();
            Intrinsics.checkNotNullExpressionValue(login, "getLogin(...)");
            TextKt.m4494TextNvy7gAk(login, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(4), 0.0f, 0.0f, 13, null), BoxTheme.INSTANCE.getColors(composer2, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 48, 12607872, 110584);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MentionsKt.CollaboratorsViewForMentionsItem$lambda$2(collaborator, avatarControllerWrapper, onMentionItemClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsViewForMentionsItem$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final Modifier handleLongPressPassOtherGesturesToChildren(Modifier modifier, Object obj, final Function0<Unit> function0) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, obj, new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt.handleLongPressPassOtherGesturesToChildren.1

            /* JADX INFO: renamed from: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Mentions.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1", f = "Mentions.kt", i = {0}, l = {223}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
            static final class C01191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onLongPress;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01191(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super C01191> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$onLongPress = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01191 c01191 = new C01191(this.$this_pointerInput, this.$onLongPress, continuation);
                    c01191.L$0 = obj;
                    return c01191;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Mentions.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1$1", f = "Mentions.kt", i = {0, 1, 1}, l = {224, 230}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "longPressJob"}, s = {"L$0", "L$0", "L$1"}, v = 1)
                static final class C01201 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ Function0<Unit> $onLongPress;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01201(CoroutineScope coroutineScope, Function0<Unit> function0, Continuation<? super C01201> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$onLongPress = function0;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C01201 c01201 = new C01201(this.$$this$coroutineScope, this.$onLongPress, continuation);
                        c01201.L$0 = obj;
                        return c01201;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C01201) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
                    
                        if (r0 == r1) goto L15;
                     */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                        /*
                            r17 = this;
                            r0 = r17
                            java.lang.Object r1 = r0.L$0
                            r2 = r1
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r3 = r0.label
                            r8 = 2
                            r9 = 1
                            r10 = 0
                            if (r3 == 0) goto L2d
                            if (r3 == r9) goto L29
                            if (r3 != r8) goto L21
                            java.lang.Object r0 = r0.L$1
                            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                            kotlin.ResultKt.throwOnFailure(r18)
                            r3 = r0
                            r0 = r18
                            goto L6b
                        L21:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                            r0.<init>(r1)
                            throw r0
                        L29:
                            kotlin.ResultKt.throwOnFailure(r18)
                            goto L42
                        L2d:
                            kotlin.ResultKt.throwOnFailure(r18)
                            r5 = r0
                            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                            r0.L$0 = r2
                            r0.label = r9
                            r3 = 0
                            r4 = 0
                            r6 = 2
                            r7 = 0
                            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r3, r4, r5, r6, r7)
                            if (r3 != r1) goto L42
                            goto L6a
                        L42:
                            kotlinx.coroutines.CoroutineScope r11 = r0.$$this$coroutineScope
                            com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1$1$longPressJob$1 r3 = new com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$handleLongPressPassOtherGesturesToChildren$1$1$1$longPressJob$1
                            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r0.$onLongPress
                            r3.<init>(r4, r10)
                            r14 = r3
                            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
                            r15 = 3
                            r16 = 0
                            r12 = 0
                            r13 = 0
                            kotlinx.coroutines.Job r3 = kotlinx.coroutines.BuildersKt.launch$default(r11, r12, r13, r14, r15, r16)
                            r4 = r0
                            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                            r0.L$0 = r5
                            r0.L$1 = r3
                            r0.label = r8
                            java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r2, r10, r4, r9, r10)
                            if (r0 != r1) goto L6b
                        L6a:
                            return r1
                        L6b:
                            if (r0 == 0) goto L70
                            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r3, r10, r9, r10)
                        L70:
                            kotlin.Unit r0 = kotlin.Unit.INSTANCE
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.components.commentbar.mentions.MentionsKt.AnonymousClass1.C01191.C01201.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C01201(coroutineScope, this.$onLongPress, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C01191(pointerInputScope, function0, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }));
    }

    private static final CollaboratorsMentionsReducer.State CollaboratorsMentionsPopup_Cxxc4bg$lambda$0(State<CollaboratorsMentionsReducer.State> state) {
        return state.getValue();
    }
}
