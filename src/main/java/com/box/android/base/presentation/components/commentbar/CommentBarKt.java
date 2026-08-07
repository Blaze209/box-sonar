package com.box.android.base.presentation.components.commentbar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.UserAvatarUIModel;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.base.presentation.components.commentbar.mentions.MentionsKt;
import com.box.android.base.presentation.components.inputbar.InputBarKt;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.KeyboardAction;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.cpl.Store;
import com.box.androidsdk.content.auth.OAuthActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import okio.Utf8;

/* JADX INFO: compiled from: CommentBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aQ\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014H\u0003¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0018*\u00020\u0019H\u0002\"\u000e\u0010\u001b\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"CommentBar", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", OAuthActivity.USER_ID, "", "userName", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Lcom/box/android/cpl/Store;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "TimestampToggle", "config", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "onToggleChanged", "Lkotlin/Function1;", "", "(Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "getPlaceholder", "", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Shown;", "getPostButton", "SMALL_SPACE_CONSTRAINT", "base_generalProdRelease", "state", "freeSpaceToTopOfScreen", "isGloballyPositioned"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommentBarKt {
    private static final int SMALL_SPACE_CONSTRAINT = 230;

    /* JADX INFO: compiled from: CommentBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CommentWithMentionsReducer.InputBoxState.InputBoxType.values().length];
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.REPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$1(Store store, String str, String str2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Modifier modifier, ScrollState scrollState, int i, int i2, Composer composer, int i3) {
        CommentBar(store, str, str2, defaultAvatarControllerWrapper, modifier, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$11(Store store, String str, String str2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Modifier modifier, ScrollState scrollState, int i, int i2, Composer composer, int i3) {
        CommentBar(store, str, str2, defaultAvatarControllerWrapper, modifier, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimestampToggle$lambda$1(TimestampedCommentConfig timestampedCommentConfig, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        TimestampToggle(timestampedCommentConfig, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:107:0x0232  */
    /* JADX WARN: Code duplicated, block: B:110:0x0257  */
    /* JADX WARN: Code duplicated, block: B:113:0x026b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0270  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:120:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x0329  */
    /* JADX WARN: Code duplicated, block: B:127:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:129:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:130:0x03de  */
    /* JADX WARN: Code duplicated, block: B:133:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:135:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:137:0x0402  */
    /* JADX WARN: Code duplicated, block: B:140:0x0433  */
    /* JADX WARN: Code duplicated, block: B:141:0x043b  */
    /* JADX WARN: Code duplicated, block: B:144:0x0489  */
    /* JADX WARN: Code duplicated, block: B:145:0x048c  */
    /* JADX WARN: Code duplicated, block: B:148:0x0496  */
    /* JADX WARN: Code duplicated, block: B:150:0x049e  */
    /* JADX WARN: Code duplicated, block: B:153:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:154:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:157:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:160:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:164:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:165:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:168:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:171:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:175:0x053f  */
    /* JADX WARN: Code duplicated, block: B:176:0x054c  */
    /* JADX WARN: Code duplicated, block: B:178:0x055d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0592  */
    /* JADX WARN: Code duplicated, block: B:181:0x0594  */
    /* JADX WARN: Code duplicated, block: B:184:0x059c  */
    /* JADX WARN: Code duplicated, block: B:188:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:190:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:193:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:194:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:197:0x0613  */
    /* JADX WARN: Code duplicated, block: B:199:0x061a  */
    /* JADX WARN: Code duplicated, block: B:202:0x0627  */
    /* JADX WARN: Code duplicated, block: B:203:0x0639 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:204:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x008c  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:79:0x0108  */
    /* JADX WARN: Code duplicated, block: B:82:0x0115  */
    /* JADX WARN: Code duplicated, block: B:84:0x0134  */
    /* JADX WARN: Code duplicated, block: B:85:0x0136  */
    /* JADX WARN: Code duplicated, block: B:88:0x0154  */
    /* JADX WARN: Code duplicated, block: B:91:0x0172  */
    /* JADX WARN: Code duplicated, block: B:94:0x0189  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b2  */
    public static final void CommentBar(final Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> store, final String userId, final String str, final DefaultAvatarControllerWrapper avatarControllerWrapper, Modifier modifier, ScrollState scrollState, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        ScrollState scrollState2;
        int i5;
        boolean z;
        final Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> store2;
        Composer composer2;
        final Modifier modifier3;
        final ScrollState scrollState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Modifier modifier4;
        final ScrollState scrollState4;
        State stateCollectAsStateWithLifecycle;
        CommentWithMentionsReducer.InputBoxState inputBoxState;
        CommentWithMentionsReducer.InputBoxState.Shown shown;
        TimestampedCommentConfig timestampedCommentConfig;
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        Object objRememberedValue;
        final MutableIntState mutableIntState;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean z2;
        String str2;
        CommentWithMentionsReducer.InputBoxState.Shown shown2;
        Object objRememberedValue3;
        CommentBarKt$CommentBar$2$1 commentBarKt$CommentBar$2$1RememberedValue;
        Arrangement arrangement;
        Arrangement.Vertical bottom;
        Function0<ComposeUiNode> constructor;
        CommentBarKt$CommentBar$3$collaboratorsStore$2$1 commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue;
        float f;
        float f2;
        int i6;
        boolean z3;
        float fM9687constructorimpl3;
        boolean z4;
        InputBoxValue inputBoxValue;
        int i7;
        boolean z5;
        Object objRememberedValue4;
        boolean z6;
        Object objRememberedValue5;
        InputBoxValue inputBoxValue2;
        Function0 function0;
        boolean z7;
        Object objRememberedValue6;
        Function0 function1;
        TimestampedCommentConfig timestampedCommentConfig2;
        boolean z8;
        Object objRememberedValue7;
        boolean z9;
        Object objRememberedValue8;
        boolean z10;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1175689973);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommentBar)N(store,userId,userName,avatarControllerWrapper,modifier,scrollState)58@2768L29,64@3145L33,68@3406L34,79@3827L6,84@4046L196,90@4347L3,77@3758L3840:CommentBar.kt#czks8q");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(userId) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 2048 : 1024;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    scrollState2 = scrollState;
                    if (composerStartRestartGroup.changed(scrollState2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    store2 = store;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    scrollState3 = scrollState2;
                } else {
                    if (i8 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    scrollState4 = i4 == 0 ? scrollState2 : null;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1175689973, i3, -1, "com.box.android.base.presentation.components.commentbar.CommentBar (CommentBar.kt:57)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    inputBoxState = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getInputBoxState();
                    if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.Shown) {
                        shown = (CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState;
                    } else {
                        shown = null;
                    }
                    if (shown == null) {
                        ScrollState scrollState5 = scrollState4;
                        timestampedCommentConfig = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        fM9687constructorimpl = Dp.m9687constructorimpl(36);
                        float fM11609getBottomBarHeightD9Ej5fM = BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM();
                        if (timestampedCommentConfig != null) {
                            fM9687constructorimpl2 = fM9687constructorimpl;
                        } else {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                        }
                        float fM9687constructorimpl4 = Dp.m9687constructorimpl(fM11609getBottomBarHeightD9Ej5fM + fM9687constructorimpl2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261643124, "CC(remember):CommentBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261634771, "CC(remember):CommentBar.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (CommentBar$lambda$6(mutableState)) {
                            composerStartRestartGroup.startReplaceGroup(-261631900);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "69@3518L6");
                            if (Dp.m9686compareTo0680j_4(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0), Dp.m9687constructorimpl(SMALL_SPACE_CONSTRAINT)) < 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            z2 = z10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(479346929);
                            composerStartRestartGroup.endReplaceGroup();
                            z2 = false;
                        }
                        if (timestampedCommentConfig == null && timestampedCommentConfig.getEnabled()) {
                            str2 = TimestampUtil.INSTANCE.formatTimestampForDisplay(timestampedCommentConfig.getTimestampForSubmission()) + " ";
                        } else {
                            str2 = null;
                        }
                        Modifier modifier5 = modifier4;
                        shown2 = shown;
                        Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1254heightInVpY3zN4$default(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(modifier4, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11581getTopLayerBackground0d7_KjU(), null, 2, null))), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM(), 0.0f, 2, null), "CommentBar");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261614129, "CC(remember):CommentBar.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommentBarKt.CommentBar$lambda$8$0(mutableIntState, mutableState, (LayoutCoordinates) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag, (Function1) objRememberedValue3);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261604690, "CC(remember):CommentBar.kt#9igjgp");
                        commentBarKt$CommentBar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (commentBarKt$CommentBar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            commentBarKt$CommentBar$2$1RememberedValue = new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$2$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierOnGloballyPositioned, unit, (PointerInputEventHandler) commentBarKt$CommentBar$2$1RememberedValue);
                        arrangement = Arrangement.INSTANCE;
                        if (z2) {
                            bottom = arrangement.getBottom();
                        } else {
                            bottom = arrangement.getTop();
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(bottom, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277192749, "C95@4566L48,98@4787L10,98@4798L17,106@5291L6,99@4846L498,109@5354L22,139@6735L103,133@6478L99,136@6607L98,118@5674L1174:CommentBar.kt#czks8q");
                        CommentBarKt$CommentBar$3$collaboratorsStore$1 commentBarKt$CommentBar$3$collaboratorsStore$1 = new PropertyReference1Impl() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$3$collaboratorsStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((CommentWithMentionsReducer.State) obj).getMentionsState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563131493, "CC(remember):CommentBar.kt#9igjgp");
                        commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = CommentBarKt$CommentBar$3$collaboratorsStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        f = 16;
                        f2 = 8;
                        i6 = i3;
                        MentionsKt.m11805CollaboratorsMentionsPopupCxxc4bg(store.scope(commentBarKt$CommentBar$3$collaboratorsStore$1, (Function1) ((KFunction) commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue)), avatarControllerWrapper, Dp.m9687constructorimpl(Dp.m9687constructorimpl(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0) + fM9687constructorimpl4) - WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop()), Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(f) + BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()) + Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(fM9687constructorimpl4 - Dp.m9687constructorimpl(14)), null, composerStartRestartGroup, ((i3 >> 6) & 112) | 3072, 32);
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
                        if (shown2.getInputBoxType() == CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY) {
                            composerStartRestartGroup.startReplaceGroup(278091159);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@5513L67,111@5468L126");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563161816, "CC(remember):CommentBar.kt#9igjgp");
                            if ((i6 & 14) == 4) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (!z9 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CommentBarKt.CommentBar$lambda$10$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ModifyHeaderKt.ModifyHeader((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(278242935);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "115@5624L30");
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                        if (z2) {
                            z3 = false;
                            fM9687constructorimpl3 = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl3 = Dp.m9687constructorimpl(f);
                            z3 = false;
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1222paddingqDBjuR0$default(modifierM1220paddingVpY3zN4$default, 0.0f, 0.0f, 0.0f, fM9687constructorimpl3, 7, null), 0.0f, 1, null);
                        UserAvatarUIModel userAvatarUIModel = new UserAvatarUIModel(userId, str);
                        z4 = z3;
                        inputBoxValue = shown2.getInputBoxValue();
                        boolean isEnabled = shown2.getIsEnabled();
                        int placeholder = getPlaceholder(shown2);
                        int postButton = getPostButton(shown2);
                        int i9 = R.string.submit_comment_talkback_label;
                        KeyboardAction keyboardAction = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getKeyboardAction();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563200956, "CC(remember):CommentBar.kt#9igjgp");
                        i7 = i6 & 14;
                        if (i7 == 4) {
                            z5 = true;
                        } else {
                            z5 = z4;
                        }
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function3 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563192728, "CC(remember):CommentBar.kt#9igjgp");
                        if (i7 == 4) {
                            z6 = true;
                        } else {
                            z6 = z4;
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (z6) {
                            inputBoxValue2 = inputBoxValue;
                        } else {
                            inputBoxValue2 = inputBoxValue;
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            }
                            function0 = (Function0) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                            if (i7 == 4) {
                                z7 = true;
                            } else {
                                z7 = z4;
                            }
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (z7) {
                                function1 = function0;
                            } else {
                                function1 = function0;
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                InputBarKt.InputBar(modifierFillMaxWidth$default, inputBoxValue2, isEnabled, placeholder, postButton, i9, avatarControllerWrapper, userAvatarUIModel, scrollState5, 0, keyboardAction, str2, function3, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                                composer2 = composerStartRestartGroup;
                                timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                                if (timestampedCommentConfig2 == null) {
                                    composer2.startReplaceGroup(279589977);
                                    composer2.endReplaceGroup();
                                    store2 = store;
                                } else {
                                    composer2.startReplaceGroup(279589978);
                                    ComposerKt.sourceInformation(composer2, "");
                                    if (timestampedCommentConfig2.getShouldShowToggle()) {
                                        store2 = store;
                                        composer2.startReplaceGroup(-1307786326);
                                    } else {
                                        composer2.startReplaceGroup(-1300817030);
                                        ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                        Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                        if (i7 == 4) {
                                            z8 = true;
                                        } else {
                                            z8 = z4;
                                        }
                                        objRememberedValue7 = composer2.rememberedValue();
                                        if (!z8 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            store2 = store;
                                            objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj) {
                                                    return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                                }
                                            };
                                            composer2.updateRememberedValue(objRememberedValue7);
                                        } else {
                                            store2 = store;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs, (Function1) objRememberedValue7, composer2, 48, 0);
                                    }
                                    composer2.endReplaceGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                    composer2.endReplaceGroup();
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                if (z2) {
                                    composer2.startReplaceGroup(280158394);
                                    ComposerKt.sourceInformation(composer2, "161@7555L27");
                                    BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                                } else {
                                    composer2.startReplaceGroup(272675149);
                                }
                                composer2.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                scrollState3 = scrollState5;
                                modifier3 = modifier5;
                            }
                            objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommentBarKt.CommentBar$lambda$10$4$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            InputBarKt.InputBar(modifierFillMaxWidth$default, inputBoxValue2, isEnabled, placeholder, postButton, i9, avatarControllerWrapper, userAvatarUIModel, scrollState5, 0, keyboardAction, str2, function3, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                            composer2 = composerStartRestartGroup;
                            timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                            if (timestampedCommentConfig2 == null) {
                                composer2.startReplaceGroup(279589977);
                                composer2.endReplaceGroup();
                                store2 = store;
                            } else {
                                composer2.startReplaceGroup(279589978);
                                ComposerKt.sourceInformation(composer2, "");
                                if (timestampedCommentConfig2.getShouldShowToggle()) {
                                    store2 = store;
                                    composer2.startReplaceGroup(-1307786326);
                                } else {
                                    composer2.startReplaceGroup(-1300817030);
                                    ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                    Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                    if (i7 == 4) {
                                        z8 = true;
                                    } else {
                                        z8 = z4;
                                    }
                                    objRememberedValue7 = composer2.rememberedValue();
                                    if (z8) {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs2, (Function1) objRememberedValue7, composer2, 48, 0);
                                }
                                composer2.endReplaceGroup();
                                Unit unit4 = Unit.INSTANCE;
                                composer2.endReplaceGroup();
                                Unit unit5 = Unit.INSTANCE;
                            }
                            if (z2) {
                                composer2.startReplaceGroup(280158394);
                                ComposerKt.sourceInformation(composer2, "161@7555L27");
                                BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                            } else {
                                composer2.startReplaceGroup(272675149);
                            }
                            composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scrollState3 = scrollState5;
                            modifier3 = modifier5;
                        }
                        objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        function0 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                        if (i7 == 4) {
                            z7 = true;
                        } else {
                            z7 = z4;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            function1 = function0;
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            InputBarKt.InputBar(modifierFillMaxWidth$default, inputBoxValue2, isEnabled, placeholder, postButton, i9, avatarControllerWrapper, userAvatarUIModel, scrollState5, 0, keyboardAction, str2, function3, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                            composer2 = composerStartRestartGroup;
                            timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                            if (timestampedCommentConfig2 == null) {
                                composer2.startReplaceGroup(279589977);
                                composer2.endReplaceGroup();
                                store2 = store;
                            } else {
                                composer2.startReplaceGroup(279589978);
                                ComposerKt.sourceInformation(composer2, "");
                                if (timestampedCommentConfig2.getShouldShowToggle()) {
                                    store2 = store;
                                    composer2.startReplaceGroup(-1307786326);
                                } else {
                                    composer2.startReplaceGroup(-1300817030);
                                    ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                    Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                    if (i7 == 4) {
                                        z8 = true;
                                    } else {
                                        z8 = z4;
                                    }
                                    objRememberedValue7 = composer2.rememberedValue();
                                    if (z8) {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs3, (Function1) objRememberedValue7, composer2, 48, 0);
                                }
                                composer2.endReplaceGroup();
                                Unit unit6 = Unit.INSTANCE;
                                composer2.endReplaceGroup();
                                Unit unit7 = Unit.INSTANCE;
                            }
                            if (z2) {
                                composer2.startReplaceGroup(280158394);
                                ComposerKt.sourceInformation(composer2, "161@7555L27");
                                BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                            } else {
                                composer2.startReplaceGroup(272675149);
                            }
                            composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scrollState3 = scrollState5;
                            modifier3 = modifier5;
                        } else {
                            function1 = function0;
                        }
                        objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default, inputBoxValue2, isEnabled, placeholder, postButton, i9, avatarControllerWrapper, userAvatarUIModel, scrollState5, 0, keyboardAction, str2, function3, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs4 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs4, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit8 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit9 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState5;
                        modifier3 = modifier5;
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            return;
                        }
                        final Modifier modifier6 = modifier4;
                        function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommentBarKt.CommentBar$lambda$1(store, userId, str, avatarControllerWrapper, modifier6, scrollState4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> store3 = store2;
                    function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommentBarKt.CommentBar$lambda$11(store3, userId, str, avatarControllerWrapper, modifier3, scrollState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            scrollState2 = scrollState;
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                store2 = store;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState3 = scrollState2;
            } else {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1175689973, i3, -1, "com.box.android.base.presentation.components.commentbar.CommentBar (CommentBar.kt:57)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                inputBoxState = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getInputBoxState();
                if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.Shown) {
                    shown = (CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState;
                } else {
                    shown = null;
                }
                if (shown == null) {
                    ScrollState scrollState6 = scrollState4;
                    timestampedCommentConfig = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    fM9687constructorimpl = Dp.m9687constructorimpl(36);
                    float fM11609getBottomBarHeightD9Ej5fM2 = BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM();
                    if (timestampedCommentConfig != null) {
                        fM9687constructorimpl2 = fM9687constructorimpl;
                    } else {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    }
                    float fM9687constructorimpl5 = Dp.m9687constructorimpl(fM11609getBottomBarHeightD9Ej5fM2 + fM9687constructorimpl2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261643124, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261634771, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (CommentBar$lambda$6(mutableState)) {
                        composerStartRestartGroup.startReplaceGroup(-261631900);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3518L6");
                        if (Dp.m9686compareTo0680j_4(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0), Dp.m9687constructorimpl(SMALL_SPACE_CONSTRAINT)) < 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        z2 = z10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(479346929);
                        composerStartRestartGroup.endReplaceGroup();
                        z2 = false;
                    }
                    if (timestampedCommentConfig == null) {
                        str2 = null;
                    } else {
                        str2 = null;
                    }
                    Modifier modifier7 = modifier4;
                    shown2 = shown;
                    Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.m1254heightInVpY3zN4$default(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(modifier4, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11581getTopLayerBackground0d7_KjU(), null, 2, null))), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM(), 0.0f, 2, null), "CommentBar");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261614129, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$8$0(mutableIntState, mutableState, (LayoutCoordinates) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag2, (Function1) objRememberedValue3);
                    Unit unit10 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261604690, "CC(remember):CommentBar.kt#9igjgp");
                    commentBarKt$CommentBar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (commentBarKt$CommentBar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        commentBarKt$CommentBar$2$1RememberedValue = new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$2$1
                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierOnGloballyPositioned2, unit10, (PointerInputEventHandler) commentBarKt$CommentBar$2$1RememberedValue);
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(bottom, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277192749, "C95@4566L48,98@4787L10,98@4798L17,106@5291L6,99@4846L498,109@5354L22,139@6735L103,133@6478L99,136@6607L98,118@5674L1174:CommentBar.kt#czks8q");
                    CommentBarKt$CommentBar$3$collaboratorsStore$1 commentBarKt$CommentBar$3$collaboratorsStore$2 = new PropertyReference1Impl() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$3$collaboratorsStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((CommentWithMentionsReducer.State) obj).getMentionsState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563131493, "CC(remember):CommentBar.kt#9igjgp");
                    commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = CommentBarKt$CommentBar$3$collaboratorsStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    f = 16;
                    f2 = 8;
                    i6 = i3;
                    MentionsKt.m11805CollaboratorsMentionsPopupCxxc4bg(store.scope(commentBarKt$CommentBar$3$collaboratorsStore$2, (Function1) ((KFunction) commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue)), avatarControllerWrapper, Dp.m9687constructorimpl(Dp.m9687constructorimpl(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0) + fM9687constructorimpl5) - WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop()), Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(f) + BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()) + Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(fM9687constructorimpl5 - Dp.m9687constructorimpl(14)), null, composerStartRestartGroup, ((i3 >> 6) & 112) | 3072, 32);
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
                    if (shown2.getInputBoxType() == CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY) {
                        composerStartRestartGroup.startReplaceGroup(278091159);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@5513L67,111@5468L126");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563161816, "CC(remember):CommentBar.kt#9igjgp");
                        if ((i6 & 14) == 4) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommentBarKt.CommentBar$lambda$10$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommentBarKt.CommentBar$lambda$10$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ModifyHeaderKt.ModifyHeader((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(278242935);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "115@5624L30");
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                    if (z2) {
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(f);
                        z3 = false;
                    } else {
                        z3 = false;
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(0);
                    }
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m1222paddingqDBjuR0$default(modifierM1220paddingVpY3zN4$default2, 0.0f, 0.0f, 0.0f, fM9687constructorimpl3, 7, null), 0.0f, 1, null);
                    UserAvatarUIModel userAvatarUIModel2 = new UserAvatarUIModel(userId, str);
                    z4 = z3;
                    inputBoxValue = shown2.getInputBoxValue();
                    boolean isEnabled2 = shown2.getIsEnabled();
                    int placeholder2 = getPlaceholder(shown2);
                    int postButton2 = getPostButton(shown2);
                    int i10 = R.string.submit_comment_talkback_label;
                    KeyboardAction keyboardAction2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getKeyboardAction();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563200956, "CC(remember):CommentBar.kt#9igjgp");
                    i7 = i6 & 14;
                    if (i7 == 4) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function4 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563192728, "CC(remember):CommentBar.kt#9igjgp");
                    if (i7 == 4) {
                        z6 = true;
                    } else {
                        z6 = z4;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        inputBoxValue2 = inputBoxValue;
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        }
                        function0 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                        if (i7 == 4) {
                            z7 = true;
                        } else {
                            z7 = z4;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            function1 = function0;
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            InputBarKt.InputBar(modifierFillMaxWidth$default2, inputBoxValue2, isEnabled2, placeholder2, postButton2, i10, avatarControllerWrapper, userAvatarUIModel2, scrollState6, 0, keyboardAction2, str2, function4, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                            composer2 = composerStartRestartGroup;
                            timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                            if (timestampedCommentConfig2 == null) {
                                composer2.startReplaceGroup(279589977);
                                composer2.endReplaceGroup();
                                store2 = store;
                            } else {
                                composer2.startReplaceGroup(279589978);
                                ComposerKt.sourceInformation(composer2, "");
                                if (timestampedCommentConfig2.getShouldShowToggle()) {
                                    store2 = store;
                                    composer2.startReplaceGroup(-1307786326);
                                } else {
                                    composer2.startReplaceGroup(-1300817030);
                                    ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                    Modifier modifierM1252height3ABfNKs5 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                    if (i7 == 4) {
                                        z8 = true;
                                    } else {
                                        z8 = z4;
                                    }
                                    objRememberedValue7 = composer2.rememberedValue();
                                    if (z8) {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs5, (Function1) objRememberedValue7, composer2, 48, 0);
                                }
                                composer2.endReplaceGroup();
                                Unit unit11 = Unit.INSTANCE;
                                composer2.endReplaceGroup();
                                Unit unit12 = Unit.INSTANCE;
                            }
                            if (z2) {
                                composer2.startReplaceGroup(280158394);
                                ComposerKt.sourceInformation(composer2, "161@7555L27");
                                BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                            } else {
                                composer2.startReplaceGroup(272675149);
                            }
                            composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scrollState3 = scrollState6;
                            modifier3 = modifier7;
                        } else {
                            function1 = function0;
                        }
                        objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default2, inputBoxValue2, isEnabled2, placeholder2, postButton2, i10, avatarControllerWrapper, userAvatarUIModel2, scrollState6, 0, keyboardAction2, str2, function4, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs6 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs6, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit13 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit14 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState6;
                        modifier3 = modifier7;
                    } else {
                        inputBoxValue2 = inputBoxValue;
                    }
                    objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommentBarKt.CommentBar$lambda$10$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    function0 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                    if (i7 == 4) {
                        z7 = true;
                    } else {
                        z7 = z4;
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        function1 = function0;
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default2, inputBoxValue2, isEnabled2, placeholder2, postButton2, i10, avatarControllerWrapper, userAvatarUIModel2, scrollState6, 0, keyboardAction2, str2, function4, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs7 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs7, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit15 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit16 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState6;
                        modifier3 = modifier7;
                    } else {
                        function1 = function0;
                    }
                    objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommentBarKt.CommentBar$lambda$10$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InputBarKt.InputBar(modifierFillMaxWidth$default2, inputBoxValue2, isEnabled2, placeholder2, postButton2, i10, avatarControllerWrapper, userAvatarUIModel2, scrollState6, 0, keyboardAction2, str2, function4, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                    composer2 = composerStartRestartGroup;
                    timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    if (timestampedCommentConfig2 == null) {
                        composer2.startReplaceGroup(279589977);
                        composer2.endReplaceGroup();
                        store2 = store;
                    } else {
                        composer2.startReplaceGroup(279589978);
                        ComposerKt.sourceInformation(composer2, "");
                        if (timestampedCommentConfig2.getShouldShowToggle()) {
                            store2 = store;
                            composer2.startReplaceGroup(-1307786326);
                        } else {
                            composer2.startReplaceGroup(-1300817030);
                            ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                            Modifier modifierM1252height3ABfNKs8 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                            ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                            if (i7 == 4) {
                                z8 = true;
                            } else {
                                z8 = z4;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (z8) {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs8, (Function1) objRememberedValue7, composer2, 48, 0);
                        }
                        composer2.endReplaceGroup();
                        Unit unit17 = Unit.INSTANCE;
                        composer2.endReplaceGroup();
                        Unit unit18 = Unit.INSTANCE;
                    }
                    if (z2) {
                        composer2.startReplaceGroup(280158394);
                        ComposerKt.sourceInformation(composer2, "161@7555L27");
                        BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                    } else {
                        composer2.startReplaceGroup(272675149);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scrollState3 = scrollState6;
                    modifier3 = modifier7;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final Modifier modifier8 = modifier4;
                    function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommentBarKt.CommentBar$lambda$1(store, userId, str, avatarControllerWrapper, modifier8, scrollState4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Store store4 = store2;
                function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommentBarKt.CommentBar$lambda$11(store4, userId, str, avatarControllerWrapper, modifier3, scrollState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                scrollState2 = scrollState;
                if (composerStartRestartGroup.changed(scrollState2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                store2 = store;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                scrollState3 = scrollState2;
            } else {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1175689973, i3, -1, "com.box.android.base.presentation.components.commentbar.CommentBar (CommentBar.kt:57)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                inputBoxState = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getInputBoxState();
                if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.Shown) {
                    shown = (CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState;
                } else {
                    shown = null;
                }
                if (shown == null) {
                    ScrollState scrollState7 = scrollState4;
                    timestampedCommentConfig = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    fM9687constructorimpl = Dp.m9687constructorimpl(36);
                    float fM11609getBottomBarHeightD9Ej5fM3 = BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM();
                    if (timestampedCommentConfig != null) {
                        fM9687constructorimpl2 = fM9687constructorimpl;
                    } else {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    }
                    float fM9687constructorimpl6 = Dp.m9687constructorimpl(fM11609getBottomBarHeightD9Ej5fM3 + fM9687constructorimpl2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261643124, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261634771, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (CommentBar$lambda$6(mutableState)) {
                        composerStartRestartGroup.startReplaceGroup(-261631900);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3518L6");
                        if (Dp.m9686compareTo0680j_4(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0), Dp.m9687constructorimpl(SMALL_SPACE_CONSTRAINT)) < 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        z2 = z10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(479346929);
                        composerStartRestartGroup.endReplaceGroup();
                        z2 = false;
                    }
                    if (timestampedCommentConfig == null) {
                        str2 = null;
                    } else {
                        str2 = null;
                    }
                    Modifier modifier9 = modifier4;
                    shown2 = shown;
                    Modifier modifierTestTag3 = TestTagKt.testTag(SizeKt.m1254heightInVpY3zN4$default(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(modifier4, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11581getTopLayerBackground0d7_KjU(), null, 2, null))), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM(), 0.0f, 2, null), "CommentBar");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261614129, "CC(remember):CommentBar.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$8$0(mutableIntState, mutableState, (LayoutCoordinates) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag3, (Function1) objRememberedValue3);
                    Unit unit19 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261604690, "CC(remember):CommentBar.kt#9igjgp");
                    commentBarKt$CommentBar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (commentBarKt$CommentBar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        commentBarKt$CommentBar$2$1RememberedValue = new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$2$1
                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput(modifierOnGloballyPositioned3, unit19, (PointerInputEventHandler) commentBarKt$CommentBar$2$1RememberedValue);
                    arrangement = Arrangement.INSTANCE;
                    if (z2) {
                        bottom = arrangement.getTop();
                    } else {
                        bottom = arrangement.getBottom();
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(bottom, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277192749, "C95@4566L48,98@4787L10,98@4798L17,106@5291L6,99@4846L498,109@5354L22,139@6735L103,133@6478L99,136@6607L98,118@5674L1174:CommentBar.kt#czks8q");
                    CommentBarKt$CommentBar$3$collaboratorsStore$1 commentBarKt$CommentBar$3$collaboratorsStore$3 = new PropertyReference1Impl() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$3$collaboratorsStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((CommentWithMentionsReducer.State) obj).getMentionsState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563131493, "CC(remember):CommentBar.kt#9igjgp");
                    commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = CommentBarKt$CommentBar$3$collaboratorsStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    f = 16;
                    f2 = 8;
                    i6 = i3;
                    MentionsKt.m11805CollaboratorsMentionsPopupCxxc4bg(store.scope(commentBarKt$CommentBar$3$collaboratorsStore$3, (Function1) ((KFunction) commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue)), avatarControllerWrapper, Dp.m9687constructorimpl(Dp.m9687constructorimpl(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0) + fM9687constructorimpl6) - WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop()), Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(f) + BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()) + Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(fM9687constructorimpl6 - Dp.m9687constructorimpl(14)), null, composerStartRestartGroup, ((i3 >> 6) & 112) | 3072, 32);
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
                    if (shown2.getInputBoxType() == CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY) {
                        composerStartRestartGroup.startReplaceGroup(278091159);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@5513L67,111@5468L126");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563161816, "CC(remember):CommentBar.kt#9igjgp");
                        if ((i6 & 14) == 4) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommentBarKt.CommentBar$lambda$10$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommentBarKt.CommentBar$lambda$10$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ModifyHeaderKt.ModifyHeader((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(278242935);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "115@5624L30");
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM1220paddingVpY3zN4$default3 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                    if (z2) {
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(f);
                        z3 = false;
                    } else {
                        z3 = false;
                        fM9687constructorimpl3 = Dp.m9687constructorimpl(0);
                    }
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(PaddingKt.m1222paddingqDBjuR0$default(modifierM1220paddingVpY3zN4$default3, 0.0f, 0.0f, 0.0f, fM9687constructorimpl3, 7, null), 0.0f, 1, null);
                    UserAvatarUIModel userAvatarUIModel3 = new UserAvatarUIModel(userId, str);
                    z4 = z3;
                    inputBoxValue = shown2.getInputBoxValue();
                    boolean isEnabled3 = shown2.getIsEnabled();
                    int placeholder3 = getPlaceholder(shown2);
                    int postButton3 = getPostButton(shown2);
                    int i11 = R.string.submit_comment_talkback_label;
                    KeyboardAction keyboardAction3 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getKeyboardAction();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563200956, "CC(remember):CommentBar.kt#9igjgp");
                    i7 = i6 & 14;
                    if (i7 == 4) {
                        z5 = true;
                    } else {
                        z5 = z4;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function5 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563192728, "CC(remember):CommentBar.kt#9igjgp");
                    if (i7 == 4) {
                        z6 = true;
                    } else {
                        z6 = z4;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        inputBoxValue2 = inputBoxValue;
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        }
                        function0 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                        if (i7 == 4) {
                            z7 = true;
                        } else {
                            z7 = z4;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (z7) {
                            function1 = function0;
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            InputBarKt.InputBar(modifierFillMaxWidth$default3, inputBoxValue2, isEnabled3, placeholder3, postButton3, i11, avatarControllerWrapper, userAvatarUIModel3, scrollState7, 0, keyboardAction3, str2, function5, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                            composer2 = composerStartRestartGroup;
                            timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                            if (timestampedCommentConfig2 == null) {
                                composer2.startReplaceGroup(279589977);
                                composer2.endReplaceGroup();
                                store2 = store;
                            } else {
                                composer2.startReplaceGroup(279589978);
                                ComposerKt.sourceInformation(composer2, "");
                                if (timestampedCommentConfig2.getShouldShowToggle()) {
                                    store2 = store;
                                    composer2.startReplaceGroup(-1307786326);
                                } else {
                                    composer2.startReplaceGroup(-1300817030);
                                    ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                    Modifier modifierM1252height3ABfNKs9 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                    if (i7 == 4) {
                                        z8 = true;
                                    } else {
                                        z8 = z4;
                                    }
                                    objRememberedValue7 = composer2.rememberedValue();
                                    if (z8) {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    } else {
                                        store2 = store;
                                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs9, (Function1) objRememberedValue7, composer2, 48, 0);
                                }
                                composer2.endReplaceGroup();
                                Unit unit110 = Unit.INSTANCE;
                                composer2.endReplaceGroup();
                                Unit unit111 = Unit.INSTANCE;
                            }
                            if (z2) {
                                composer2.startReplaceGroup(280158394);
                                ComposerKt.sourceInformation(composer2, "161@7555L27");
                                BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                            } else {
                                composer2.startReplaceGroup(272675149);
                            }
                            composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scrollState3 = scrollState7;
                            modifier3 = modifier9;
                        } else {
                            function1 = function0;
                        }
                        objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default3, inputBoxValue2, isEnabled3, placeholder3, postButton3, i11, avatarControllerWrapper, userAvatarUIModel3, scrollState7, 0, keyboardAction3, str2, function5, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs10 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs10, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit112 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit113 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState7;
                        modifier3 = modifier9;
                    } else {
                        inputBoxValue2 = inputBoxValue;
                    }
                    objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommentBarKt.CommentBar$lambda$10$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    function0 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                    if (i7 == 4) {
                        z7 = true;
                    } else {
                        z7 = z4;
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        function1 = function0;
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default3, inputBoxValue2, isEnabled3, placeholder3, postButton3, i11, avatarControllerWrapper, userAvatarUIModel3, scrollState7, 0, keyboardAction3, str2, function5, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs11 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs11, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit114 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit115 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState7;
                        modifier3 = modifier9;
                    } else {
                        function1 = function0;
                    }
                    objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommentBarKt.CommentBar$lambda$10$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InputBarKt.InputBar(modifierFillMaxWidth$default3, inputBoxValue2, isEnabled3, placeholder3, postButton3, i11, avatarControllerWrapper, userAvatarUIModel3, scrollState7, 0, keyboardAction3, str2, function5, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                    composer2 = composerStartRestartGroup;
                    timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    if (timestampedCommentConfig2 == null) {
                        composer2.startReplaceGroup(279589977);
                        composer2.endReplaceGroup();
                        store2 = store;
                    } else {
                        composer2.startReplaceGroup(279589978);
                        ComposerKt.sourceInformation(composer2, "");
                        if (timestampedCommentConfig2.getShouldShowToggle()) {
                            store2 = store;
                            composer2.startReplaceGroup(-1307786326);
                        } else {
                            composer2.startReplaceGroup(-1300817030);
                            ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                            Modifier modifierM1252height3ABfNKs12 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                            ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                            if (i7 == 4) {
                                z8 = true;
                            } else {
                                z8 = z4;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (z8) {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs12, (Function1) objRememberedValue7, composer2, 48, 0);
                        }
                        composer2.endReplaceGroup();
                        Unit unit116 = Unit.INSTANCE;
                        composer2.endReplaceGroup();
                        Unit unit117 = Unit.INSTANCE;
                    }
                    if (z2) {
                        composer2.startReplaceGroup(280158394);
                        ComposerKt.sourceInformation(composer2, "161@7555L27");
                        BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                    } else {
                        composer2.startReplaceGroup(272675149);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scrollState3 = scrollState7;
                    modifier3 = modifier9;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final Modifier modifier10 = modifier4;
                    function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommentBarKt.CommentBar$lambda$1(store, userId, str, avatarControllerWrapper, modifier10, scrollState4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Store store5 = store2;
                function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommentBarKt.CommentBar$lambda$11(store5, userId, str, avatarControllerWrapper, modifier3, scrollState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        scrollState2 = scrollState;
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            store2 = store;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState3 = scrollState2;
        } else {
            if (i8 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1175689973, i3, -1, "com.box.android.base.presentation.components.commentbar.CommentBar (CommentBar.kt:57)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            inputBoxState = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getInputBoxState();
            if (inputBoxState instanceof CommentWithMentionsReducer.InputBoxState.Shown) {
                shown = (CommentWithMentionsReducer.InputBoxState.Shown) inputBoxState;
            } else {
                shown = null;
            }
            if (shown == null) {
                ScrollState scrollState8 = scrollState4;
                timestampedCommentConfig = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                fM9687constructorimpl = Dp.m9687constructorimpl(36);
                float fM11609getBottomBarHeightD9Ej5fM4 = BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM();
                if (timestampedCommentConfig != null) {
                    fM9687constructorimpl2 = fM9687constructorimpl;
                } else {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                }
                float fM9687constructorimpl7 = Dp.m9687constructorimpl(fM11609getBottomBarHeightD9Ej5fM4 + fM9687constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261643124, "CC(remember):CommentBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261634771, "CC(remember):CommentBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (CommentBar$lambda$6(mutableState)) {
                    composerStartRestartGroup.startReplaceGroup(-261631900);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3518L6");
                    if (Dp.m9686compareTo0680j_4(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0), Dp.m9687constructorimpl(SMALL_SPACE_CONSTRAINT)) < 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    z2 = z10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(479346929);
                    composerStartRestartGroup.endReplaceGroup();
                    z2 = false;
                }
                if (timestampedCommentConfig == null) {
                    str2 = null;
                } else {
                    str2 = null;
                }
                Modifier modifier11 = modifier4;
                shown2 = shown;
                Modifier modifierTestTag4 = TestTagKt.testTag(SizeKt.m1254heightInVpY3zN4$default(WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(modifier4, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11581getTopLayerBackground0d7_KjU(), null, 2, null))), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM(), 0.0f, 2, null), "CommentBar");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261614129, "CC(remember):CommentBar.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommentBarKt.CommentBar$lambda$8$0(mutableIntState, mutableState, (LayoutCoordinates) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag4, (Function1) objRememberedValue3);
                Unit unit118 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -261604690, "CC(remember):CommentBar.kt#9igjgp");
                commentBarKt$CommentBar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (commentBarKt$CommentBar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    commentBarKt$CommentBar$2$1RememberedValue = new PointerInputEventHandler() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$2$1
                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput4 = SuspendingPointerInputFilterKt.pointerInput(modifierOnGloballyPositioned4, unit118, (PointerInputEventHandler) commentBarKt$CommentBar$2$1RememberedValue);
                arrangement = Arrangement.INSTANCE;
                if (z2) {
                    bottom = arrangement.getTop();
                } else {
                    bottom = arrangement.getBottom();
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(bottom, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 277192749, "C95@4566L48,98@4787L10,98@4798L17,106@5291L6,99@4846L498,109@5354L22,139@6735L103,133@6478L99,136@6607L98,118@5674L1174:CommentBar.kt#czks8q");
                CommentBarKt$CommentBar$3$collaboratorsStore$1 commentBarKt$CommentBar$3$collaboratorsStore$4 = new PropertyReference1Impl() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$CommentBar$3$collaboratorsStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((CommentWithMentionsReducer.State) obj).getMentionsState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563131493, "CC(remember):CommentBar.kt#9igjgp");
                commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue = CommentBarKt$CommentBar$3$collaboratorsStore$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                f = 16;
                f2 = 8;
                i6 = i3;
                MentionsKt.m11805CollaboratorsMentionsPopupCxxc4bg(store.scope(commentBarKt$CommentBar$3$collaboratorsStore$4, (Function1) ((KFunction) commentBarKt$CommentBar$3$collaboratorsStore$2$1RememberedValue)), avatarControllerWrapper, Dp.m9687constructorimpl(Dp.m9687constructorimpl(ComposeUtilsKt.toDp(CommentBar$lambda$3(mutableIntState), composerStartRestartGroup, 0) + fM9687constructorimpl7) - WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0).getTop()), Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(f) + BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()) + Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(fM9687constructorimpl7 - Dp.m9687constructorimpl(14)), null, composerStartRestartGroup, ((i3 >> 6) & 112) | 3072, 32);
                BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
                if (shown2.getInputBoxType() == CommentWithMentionsReducer.InputBoxState.InputBoxType.MODIFY) {
                    composerStartRestartGroup.startReplaceGroup(278091159);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@5513L67,111@5468L126");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563161816, "CC(remember):CommentBar.kt#9igjgp");
                    if ((i6 & 14) == 4) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommentBarKt.CommentBar$lambda$10$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ModifyHeaderKt.ModifyHeader((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(278242935);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "115@5624L30");
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM1220paddingVpY3zN4$default4 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                if (z2) {
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(f);
                    z3 = false;
                } else {
                    z3 = false;
                    fM9687constructorimpl3 = Dp.m9687constructorimpl(0);
                }
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(PaddingKt.m1222paddingqDBjuR0$default(modifierM1220paddingVpY3zN4$default4, 0.0f, 0.0f, 0.0f, fM9687constructorimpl3, 7, null), 0.0f, 1, null);
                UserAvatarUIModel userAvatarUIModel4 = new UserAvatarUIModel(userId, str);
                z4 = z3;
                inputBoxValue = shown2.getInputBoxValue();
                boolean isEnabled4 = shown2.getIsEnabled();
                int placeholder4 = getPlaceholder(shown2);
                int postButton4 = getPostButton(shown2);
                int i12 = R.string.submit_comment_talkback_label;
                KeyboardAction keyboardAction4 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getKeyboardAction();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563200956, "CC(remember):CommentBar.kt#9igjgp");
                i7 = i6 & 14;
                if (i7 == 4) {
                    z5 = true;
                } else {
                    z5 = z4;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommentBarKt.CommentBar$lambda$10$2$0(store, (TextFieldValueUIModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function6 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563192728, "CC(remember):CommentBar.kt#9igjgp");
                if (i7 == 4) {
                    z6 = true;
                } else {
                    z6 = z4;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    inputBoxValue2 = inputBoxValue;
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    }
                    function0 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                    if (i7 == 4) {
                        z7 = true;
                    } else {
                        z7 = z4;
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        function1 = function0;
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        InputBarKt.InputBar(modifierFillMaxWidth$default4, inputBoxValue2, isEnabled4, placeholder4, postButton4, i12, avatarControllerWrapper, userAvatarUIModel4, scrollState8, 0, keyboardAction4, str2, function6, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                        composer2 = composerStartRestartGroup;
                        timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                        if (timestampedCommentConfig2 == null) {
                            composer2.startReplaceGroup(279589977);
                            composer2.endReplaceGroup();
                            store2 = store;
                        } else {
                            composer2.startReplaceGroup(279589978);
                            ComposerKt.sourceInformation(composer2, "");
                            if (timestampedCommentConfig2.getShouldShowToggle()) {
                                store2 = store;
                                composer2.startReplaceGroup(-1307786326);
                            } else {
                                composer2.startReplaceGroup(-1300817030);
                                ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                                Modifier modifierM1252height3ABfNKs13 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                                ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                                if (i7 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = z4;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (z8) {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                } else {
                                    store2 = store;
                                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs13, (Function1) objRememberedValue7, composer2, 48, 0);
                            }
                            composer2.endReplaceGroup();
                            Unit unit119 = Unit.INSTANCE;
                            composer2.endReplaceGroup();
                            Unit unit1110 = Unit.INSTANCE;
                        }
                        if (z2) {
                            composer2.startReplaceGroup(280158394);
                            ComposerKt.sourceInformation(composer2, "161@7555L27");
                            BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                        } else {
                            composer2.startReplaceGroup(272675149);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scrollState3 = scrollState8;
                        modifier3 = modifier11;
                    } else {
                        function1 = function0;
                    }
                    objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommentBarKt.CommentBar$lambda$10$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InputBarKt.InputBar(modifierFillMaxWidth$default4, inputBoxValue2, isEnabled4, placeholder4, postButton4, i12, avatarControllerWrapper, userAvatarUIModel4, scrollState8, 0, keyboardAction4, str2, function6, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                    composer2 = composerStartRestartGroup;
                    timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    if (timestampedCommentConfig2 == null) {
                        composer2.startReplaceGroup(279589977);
                        composer2.endReplaceGroup();
                        store2 = store;
                    } else {
                        composer2.startReplaceGroup(279589978);
                        ComposerKt.sourceInformation(composer2, "");
                        if (timestampedCommentConfig2.getShouldShowToggle()) {
                            store2 = store;
                            composer2.startReplaceGroup(-1307786326);
                        } else {
                            composer2.startReplaceGroup(-1300817030);
                            ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                            Modifier modifierM1252height3ABfNKs14 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                            ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                            if (i7 == 4) {
                                z8 = true;
                            } else {
                                z8 = z4;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (z8) {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs14, (Function1) objRememberedValue7, composer2, 48, 0);
                        }
                        composer2.endReplaceGroup();
                        Unit unit1111 = Unit.INSTANCE;
                        composer2.endReplaceGroup();
                        Unit unit1112 = Unit.INSTANCE;
                    }
                    if (z2) {
                        composer2.startReplaceGroup(280158394);
                        ComposerKt.sourceInformation(composer2, "161@7555L27");
                        BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                    } else {
                        composer2.startReplaceGroup(272675149);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scrollState3 = scrollState8;
                    modifier3 = modifier11;
                } else {
                    inputBoxValue2 = inputBoxValue;
                }
                objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommentBarKt.CommentBar$lambda$10$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                function0 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 563196855, "CC(remember):CommentBar.kt#9igjgp");
                if (i7 == 4) {
                    z7 = true;
                } else {
                    z7 = z4;
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    function1 = function0;
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    InputBarKt.InputBar(modifierFillMaxWidth$default4, inputBoxValue2, isEnabled4, placeholder4, postButton4, i12, avatarControllerWrapper, userAvatarUIModel4, scrollState8, 0, keyboardAction4, str2, function6, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                    composer2 = composerStartRestartGroup;
                    timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                    if (timestampedCommentConfig2 == null) {
                        composer2.startReplaceGroup(279589977);
                        composer2.endReplaceGroup();
                        store2 = store;
                    } else {
                        composer2.startReplaceGroup(279589978);
                        ComposerKt.sourceInformation(composer2, "");
                        if (timestampedCommentConfig2.getShouldShowToggle()) {
                            store2 = store;
                            composer2.startReplaceGroup(-1307786326);
                        } else {
                            composer2.startReplaceGroup(-1300817030);
                            ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                            Modifier modifierM1252height3ABfNKs15 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                            ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                            if (i7 == 4) {
                                z8 = true;
                            } else {
                                z8 = z4;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (z8) {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                store2 = store;
                                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs15, (Function1) objRememberedValue7, composer2, 48, 0);
                        }
                        composer2.endReplaceGroup();
                        Unit unit1113 = Unit.INSTANCE;
                        composer2.endReplaceGroup();
                        Unit unit1114 = Unit.INSTANCE;
                    }
                    if (z2) {
                        composer2.startReplaceGroup(280158394);
                        ComposerKt.sourceInformation(composer2, "161@7555L27");
                        BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                    } else {
                        composer2.startReplaceGroup(272675149);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scrollState3 = scrollState8;
                    modifier3 = modifier11;
                } else {
                    function1 = function0;
                }
                objRememberedValue6 = new Function0() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommentBarKt.CommentBar$lambda$10$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                InputBarKt.InputBar(modifierFillMaxWidth$default4, inputBoxValue2, isEnabled4, placeholder4, postButton4, i12, avatarControllerWrapper, userAvatarUIModel4, scrollState8, 0, keyboardAction4, str2, function6, function1, (Function0) objRememberedValue6, composerStartRestartGroup, (i6 << 9) & 238551040, 0, 512);
                composer2 = composerStartRestartGroup;
                timestampedCommentConfig2 = CommentBar$lambda$0(stateCollectAsStateWithLifecycle).getTimestampedCommentConfig();
                if (timestampedCommentConfig2 == null) {
                    composer2.startReplaceGroup(279589977);
                    composer2.endReplaceGroup();
                    store2 = store;
                } else {
                    composer2.startReplaceGroup(279589978);
                    ComposerKt.sourceInformation(composer2, "");
                    if (timestampedCommentConfig2.getShouldShowToggle()) {
                        store2 = store;
                        composer2.startReplaceGroup(-1307786326);
                    } else {
                        composer2.startReplaceGroup(-1300817030);
                        ComposerKt.sourceInformation(composer2, "153@7325L148,147@7027L464");
                        Modifier modifierM1252height3ABfNKs16 = SizeKt.m1252height3ABfNKs(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2)), fM9687constructorimpl);
                        ComposerKt.sourceInformationMarkerStart(composer2, -319046740, "CC(remember):CommentBar.kt#9igjgp");
                        if (i7 == 4) {
                            z8 = true;
                        } else {
                            z8 = z4;
                        }
                        objRememberedValue7 = composer2.rememberedValue();
                        if (z8) {
                            store2 = store;
                            objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            store2 = store;
                            objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommentBarKt.CommentBar$lambda$10$5$0$0(store2, ((Boolean) obj).booleanValue());
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        TimestampToggle(timestampedCommentConfig2, modifierM1252height3ABfNKs16, (Function1) objRememberedValue7, composer2, 48, 0);
                    }
                    composer2.endReplaceGroup();
                    Unit unit1115 = Unit.INSTANCE;
                    composer2.endReplaceGroup();
                    Unit unit1116 = Unit.INSTANCE;
                }
                if (z2) {
                    composer2.startReplaceGroup(280158394);
                    ComposerKt.sourceInformation(composer2, "161@7555L27");
                    BoxKt.Box(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), composer2, 6);
                } else {
                    composer2.startReplaceGroup(272675149);
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scrollState3 = scrollState8;
                modifier3 = modifier11;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final Modifier modifier12 = modifier4;
                function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommentBarKt.CommentBar$lambda$1(store, userId, str, avatarControllerWrapper, modifier12, scrollState4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Store store6 = store2;
            function2 = new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommentBarKt.CommentBar$lambda$11(store6, userId, str, avatarControllerWrapper, modifier3, scrollState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final int CommentBar$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final boolean CommentBar$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CommentBar$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$8$0(MutableIntState mutableIntState, MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setIntValue((int) Float.intBitsToFloat((int) (LayoutCoordinatesKt.positionInRoot(it) & 4294967295L)));
        CommentBar$lambda$7(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$10$1$0(Store store) {
        store.send(CommentWithMentionsReducer.Action.ExitModifyClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$10$3$0(Store store) {
        store.send(CommentWithMentionsReducer.Action.KeyboardActionHandled.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$10$4$0(Store store) {
        store.send(CommentWithMentionsReducer.Action.SubmitCommentClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$10$2$0(Store store, TextFieldValueUIModel text) {
        Intrinsics.checkNotNullParameter(text, "text");
        store.send(new CommentWithMentionsReducer.Action.TextChanged(text, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommentBar$lambda$10$5$0$0(Store store, boolean z) {
        store.send(new CommentWithMentionsReducer.Action.ToggleCommentWithTimestamp(z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:50:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:55:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:58:0x0231  */
    /* JADX WARN: Code duplicated, block: B:60:0x0237  */
    /* JADX WARN: Code duplicated, block: B:63:0x0243  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    private static final void TimestampToggle(TimestampedCommentConfig timestampedCommentConfig, Modifier modifier, final Function1<? super Boolean, Unit> function1, Composer composer, final int i, final int i2) {
        final TimestampedCommentConfig timestampedCommentConfig2;
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        Object objRememberedValue;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(559785334);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimestampToggle)N(config,modifier,onToggleChanged)172@7898L702:CommentBar.kt#czks8q");
        if ((i & 6) == 0) {
            timestampedCommentConfig2 = timestampedCommentConfig;
            i3 = (composerStartRestartGroup.changed(timestampedCommentConfig2) ? 4 : 2) | i;
        } else {
            timestampedCommentConfig2 = timestampedCommentConfig;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
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
                    ComposerKt.traceEventStart(559785334, i3, -1, "com.box.android.base.presentation.components.commentbar.TimestampToggle (CommentBar.kt:171)");
                }
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -880746694, "C177@8028L54,179@8166L6,176@8003L234,189@8546L6,188@8493L91,185@8388L67,182@8246L348:CommentBar.kt#czks8q");
                Modifier modifier4 = companion;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.comment_with_timestamp_toggle, composerStartRestartGroup, 0), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium12(), composerStartRestartGroup, 0, 12582912, 131064);
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "TimestampToggleSwitch");
                boolean enabled = timestampedCommentConfig2.getEnabled();
                SwitchColors switchColorsM4356colorsV1nXRL4 = SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, SwitchDefaults.$stable << 18, Utf8.REPLACEMENT_CODE_POINT);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 802884605, "CC(remember):CommentBar.kt#9igjgp");
                z2 = (i3 & 896) == 256;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CommentBarKt.TimestampToggle$lambda$0$0$0(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwitchKt.Switch(enabled, (Function1) objRememberedValue, modifierTestTag, null, false, switchColorsM4356colorsV1nXRL4, null, composerStartRestartGroup, 384, 88);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommentBarKt.TimestampToggle$lambda$1(timestampedCommentConfig2, modifier3, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
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
                ComposerKt.traceEventStart(559785334, i3, -1, "com.box.android.base.presentation.components.commentbar.TimestampToggle (CommentBar.kt:171)");
            }
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -880746694, "C177@8028L54,179@8166L6,176@8003L234,189@8546L6,188@8493L91,185@8388L67,182@8246L348:CommentBar.kt#czks8q");
            Modifier modifier5 = companion;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.comment_with_timestamp_toggle, composerStartRestartGroup, 0), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium12(), composerStartRestartGroup, 0, 12582912, 131064);
            Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, "TimestampToggleSwitch");
            boolean enabled2 = timestampedCommentConfig2.getEnabled();
            SwitchColors switchColorsM4356colorsV1nXRL5 = SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, SwitchDefaults.$stable << 18, Utf8.REPLACEMENT_CODE_POINT);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 802884605, "CC(remember):CommentBar.kt#9igjgp");
            if ((i3 & 896) == 256) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CommentBarKt.TimestampToggle$lambda$0$0$0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CommentBarKt.TimestampToggle$lambda$0$0$0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(enabled2, (Function1) objRememberedValue, modifierTestTag2, null, false, switchColorsM4356colorsV1nXRL5, null, composerStartRestartGroup, 384, 88);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommentBarKt.TimestampToggle$lambda$1(timestampedCommentConfig2, modifier3, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimestampToggle$lambda$0$0$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    private static final int getPlaceholder(CommentWithMentionsReducer.InputBoxState.Shown shown) {
        int i = WhenMappings.$EnumSwitchMapping$0[shown.getInputBoxType().ordinal()];
        if (i == 1) {
            return R.string.reply_bar_placeholder;
        }
        if (i == 2) {
            return R.string.comment_bar_placeholder;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.comment_bar_placeholder;
    }

    private static final int getPostButton(CommentWithMentionsReducer.InputBoxState.Shown shown) {
        int i = WhenMappings.$EnumSwitchMapping$0[shown.getInputBoxType().ordinal()];
        if (i == 1 || i == 2) {
            return R.drawable.ic_send24;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.drawable.ic_accept_edit_comment;
    }

    private static final CommentWithMentionsReducer.State CommentBar$lambda$0(State<CommentWithMentionsReducer.State> state) {
        return state.getValue();
    }
}
