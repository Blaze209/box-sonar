package com.box.android.browse.search.component;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.SearchBarToSearchScreenTransition;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.textfield.RequestFocusOnLaunchKt;
import com.box.android.browse.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesSearchInputField.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\f\u001aY\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\n*\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\n*\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0002\u0010\u001a\u001a%\u0010\u001b\u001a\u00020\n*\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002"}, d2 = {"FilesSearchInputField", "", "query", "", "placeholderText", "onQueryChange", "Lkotlin/Function1;", "onGoBackClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onSearchSubmitted", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SearchTextField", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "onClearButtonClick", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "placeholderTextModifier", "(Landroidx/compose/foundation/text/input/TextFieldState;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "sharedTransitionAnimatedAlpha", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedElementPlaceholder", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedElementInputRowContent", "BoxSearchTextFieldPreview", "(Landroidx/compose/runtime/Composer;I)V", "EmptyBoxSearchTextFieldPreview", "browse_generalProdRelease", "currentQuery", "alpha", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchInputFieldKt {

    /* JADX INFO: compiled from: FilesSearchInputField.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.Visible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSearchTextFieldPreview$lambda$0(int i, Composer composer, int i2) {
        BoxSearchTextFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyBoxSearchTextFieldPreview$lambda$0(int i, Composer composer, int i2) {
        EmptyBoxSearchTextFieldPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchInputField$lambda$5(String str, String str2, Function1 function1, Function0 function0, Modifier modifier, Function0 function2, int i, int i2, Composer composer, int i3) {
        FilesSearchInputField(str, str2, function1, function0, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchTextField$lambda$3(TextFieldState textFieldState, String str, Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier, Modifier modifier2, Function0 function1, int i, int i2, Composer composer, int i3) {
        SearchTextField(textFieldState, str, function0, animatedVisibilityScope, modifier, modifier2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0241  */
    /* JADX WARN: Code duplicated, block: B:103:0x0249  */
    /* JADX WARN: Code duplicated, block: B:106:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:111:0x031b  */
    /* JADX WARN: Code duplicated, block: B:112:0x031e  */
    /* JADX WARN: Code duplicated, block: B:115:0x0326  */
    /* JADX WARN: Code duplicated, block: B:117:0x032e  */
    /* JADX WARN: Code duplicated, block: B:121:0x035c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0366  */
    /* JADX WARN: Code duplicated, block: B:126:0x036e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0388  */
    /* JADX WARN: Code duplicated, block: B:131:0x038f  */
    /* JADX WARN: Code duplicated, block: B:134:0x039a  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x010b  */
    /* JADX WARN: Code duplicated, block: B:84:0x011f  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:93:0x01da  */
    /* JADX WARN: Code duplicated, block: B:94:0x01de  */
    /* JADX WARN: Code duplicated, block: B:97:0x0238  */
    /* JADX WARN: Code duplicated, block: B:98:0x023a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void FilesSearchInputField(final String query, String str, final Function1<? super String, Unit> onQueryChange, final Function0<Unit> onGoBackClick, Modifier modifier, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        String strStringResource;
        final Modifier modifier2;
        int i4;
        Function0<Unit> function1;
        int i5;
        boolean z;
        final String str2;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i6;
        String str3;
        Modifier modifier3;
        Object objRememberedValue;
        Function0<Unit> function3;
        int i7;
        final TextFieldState textFieldStateM1832rememberTextFieldStateLepunE;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        boolean z3;
        boolean z4;
        FilesSearchInputFieldKt$FilesSearchInputField$3$1 filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue;
        State stateRememberUpdatedState;
        boolean zChanged2;
        FilesSearchInputFieldKt$FilesSearchInputField$4$1 filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue;
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Intrinsics.checkNotNullParameter(onGoBackClick, "onGoBackClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1669665154);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesSearchInputField)N(query,placeholderText,onQueryChange,onGoBackClick,modifier,onSearchSubmitted)63@3103L7,64@3177L7,65@3210L43,71@3360L76,67@3259L1132,97@4478L122,97@4456L144,104@4691L27,105@4754L194,105@4723L225:FilesSearchInputField.kt#8xusuk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(query) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                strStringResource = str;
                int i8 = composerStartRestartGroup.changed(strStringResource) ? 32 : 16;
                i3 |= i8;
            } else {
                strStringResource = str;
            }
            i3 |= i8;
        } else {
            strStringResource = str;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onQueryChange) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onGoBackClick) ? 2048 : 1024;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
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
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@2844L52,61@3037L2");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 2) != 0) {
                            strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                            i3 &= -113;
                        }
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i6 = i3;
                            str3 = strStringResource;
                            modifier3 = companion;
                            function3 = (Function0) objRememberedValue;
                        } else {
                            i6 = i3;
                            str3 = strStringResource;
                            modifier3 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1669665154, i6, -1, "com.box.android.browse.search.component.FilesSearchInputField (FilesSearchInputField.kt:62)");
                        }
                        ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localSharedTransitionScope);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SharedTransitionScope sharedTransitionScope = (SharedTransitionScope) objConsume;
                        ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AnimatedVisibilityScope animatedVisibilityScope = (AnimatedVisibilityScope) objConsume2;
                        i7 = i6 & 14;
                        textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(query, 0L, composerStartRestartGroup, i7, 2);
                        Modifier modifierSharedElementInputRowContent = sharedElementInputRowContent(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(72)), sharedTransitionScope, animatedVisibilityScope, composerStartRestartGroup, 0);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier4 = modifier3;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400072399, "C76@3602L62,79@3703L51,82@3896L6,74@3509L414,88@4066L30,91@4252L72,85@3933L452:FilesSearchInputField.kt#8xusuk");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183708796, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        if ((i6 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i10 = i6;
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183693980, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str4 = str3;
                        Function0<Unit> function4 = function3;
                        SearchTextField(textFieldStateM1832rememberTextFieldStateLepunE, str4, (Function0) objRememberedValue3, animatedVisibilityScope, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), sharedElementPlaceholder(Modifier.INSTANCE, sharedTransitionScope, animatedVisibilityScope, composerStartRestartGroup, 6), function4, composerStartRestartGroup, (i10 & 112) | ((i10 << 3) & 3670016), 0);
                        function1 = function4;
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769500868, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        boolean zChanged3 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                        if (i7 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 = zChanged3 | z3;
                        filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z4 || filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                            composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue, composerStartRestartGroup, i7);
                        stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(query, composerStartRestartGroup, i7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769491964, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i10 & 896) == 256);
                        filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                            composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(textFieldStateM1832rememberTextFieldStateLepunE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str4;
                        modifier2 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = modifier2;
                    }
                    function3 = function1;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1669665154, i6, -1, "com.box.android.browse.search.component.FilesSearchInputField (FilesSearchInputField.kt:62)");
                    }
                    ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope2 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localSharedTransitionScope2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SharedTransitionScope sharedTransitionScope2 = (SharedTransitionScope) objConsume3;
                    ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope2 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AnimatedVisibilityScope animatedVisibilityScope2 = (AnimatedVisibilityScope) objConsume4;
                    i7 = i6 & 14;
                    textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(query, 0L, composerStartRestartGroup, i7, 2);
                    Modifier modifierSharedElementInputRowContent2 = sharedElementInputRowContent(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(72)), sharedTransitionScope2, animatedVisibilityScope2, composerStartRestartGroup, 0);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier5 = modifier3;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400072399, "C76@3602L62,79@3703L51,82@3896L6,74@3509L414,88@4066L30,91@4252L72,85@3933L452:FilesSearchInputField.kt#8xusuk");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183708796, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    if ((i6 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i11 = i6;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183693980, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    String str5 = str3;
                    Function0<Unit> function5 = function3;
                    SearchTextField(textFieldStateM1832rememberTextFieldStateLepunE, str5, (Function0) objRememberedValue3, animatedVisibilityScope2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), sharedElementPlaceholder(Modifier.INSTANCE, sharedTransitionScope2, animatedVisibilityScope2, composerStartRestartGroup, 6), function5, composerStartRestartGroup, (i11 & 112) | ((i11 << 3) & 3670016), 0);
                    function1 = function5;
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769500868, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    boolean zChanged4 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                    if (i7 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = zChanged4 | z3;
                    filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4) {
                        filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                        composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                    } else {
                        filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                        composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue, composerStartRestartGroup, i7);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(query, composerStartRestartGroup, i7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769491964, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i11 & 896) == 256);
                    filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                    } else {
                        filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                        composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(textFieldStateM1832rememberTextFieldStateLepunE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str5;
                    modifier2 = modifier5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = strStringResource;
                }
                function2 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$5(query, str2, onQueryChange, onGoBackClick, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2844L52,61@3037L2");
                if ((i & 1) != 0) {
                    if ((i2 & 2) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = function1;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1669665154, i6, -1, "com.box.android.browse.search.component.FilesSearchInputField (FilesSearchInputField.kt:62)");
                }
                ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope3 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localSharedTransitionScope3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SharedTransitionScope sharedTransitionScope3 = (SharedTransitionScope) objConsume5;
                ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope3 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedVisibilityScope animatedVisibilityScope3 = (AnimatedVisibilityScope) objConsume6;
                i7 = i6 & 14;
                textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(query, 0L, composerStartRestartGroup, i7, 2);
                Modifier modifierSharedElementInputRowContent3 = sharedElementInputRowContent(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(72)), sharedTransitionScope3, animatedVisibilityScope3, composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier6 = modifier3;
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
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400072399, "C76@3602L62,79@3703L51,82@3896L6,74@3509L414,88@4066L30,91@4252L72,85@3933L452:FilesSearchInputField.kt#8xusuk");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183708796, "CC(remember):FilesSearchInputField.kt#9igjgp");
                if ((i6 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i12 = i6;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183693980, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str6 = str3;
                Function0<Unit> function6 = function3;
                SearchTextField(textFieldStateM1832rememberTextFieldStateLepunE, str6, (Function0) objRememberedValue3, animatedVisibilityScope3, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), sharedElementPlaceholder(Modifier.INSTANCE, sharedTransitionScope3, animatedVisibilityScope3, composerStartRestartGroup, 6), function6, composerStartRestartGroup, (i12 & 112) | ((i12 << 3) & 3670016), 0);
                function1 = function6;
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769500868, "CC(remember):FilesSearchInputField.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                if (i7 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = zChanged5 | z3;
                filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                } else {
                    filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue, composerStartRestartGroup, i7);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(query, composerStartRestartGroup, i7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769491964, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i12 & 896) == 256);
                filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                } else {
                    filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(textFieldStateM1832rememberTextFieldStateLepunE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str6;
                modifier2 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = strStringResource;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$5(query, str2, onQueryChange, onGoBackClick, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
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
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2844L52,61@3037L2");
                if ((i & 1) != 0) {
                    if ((i2 & 2) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = function1;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = (Function0) objRememberedValue;
                    } else {
                        i6 = i3;
                        str3 = strStringResource;
                        modifier3 = companion;
                        function3 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1669665154, i6, -1, "com.box.android.browse.search.component.FilesSearchInputField (FilesSearchInputField.kt:62)");
                }
                ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope4 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localSharedTransitionScope4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SharedTransitionScope sharedTransitionScope4 = (SharedTransitionScope) objConsume7;
                ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope4 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedVisibilityScope animatedVisibilityScope4 = (AnimatedVisibilityScope) objConsume8;
                i7 = i6 & 14;
                textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(query, 0L, composerStartRestartGroup, i7, 2);
                Modifier modifierSharedElementInputRowContent4 = sharedElementInputRowContent(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(72)), sharedTransitionScope4, animatedVisibilityScope4, composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier7 = modifier3;
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
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400072399, "C76@3602L62,79@3703L51,82@3896L6,74@3509L414,88@4066L30,91@4252L72,85@3933L452:FilesSearchInputField.kt#8xusuk");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183708796, "CC(remember):FilesSearchInputField.kt#9igjgp");
                if ((i6 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i13 = i6;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183693980, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String str7 = str3;
                Function0<Unit> function7 = function3;
                SearchTextField(textFieldStateM1832rememberTextFieldStateLepunE, str7, (Function0) objRememberedValue3, animatedVisibilityScope4, RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), sharedElementPlaceholder(Modifier.INSTANCE, sharedTransitionScope4, animatedVisibilityScope4, composerStartRestartGroup, 6), function7, composerStartRestartGroup, (i13 & 112) | ((i13 << 3) & 3670016), 0);
                function1 = function7;
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769500868, "CC(remember):FilesSearchInputField.kt#9igjgp");
                boolean zChanged6 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
                if (i7 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = zChanged6 | z3;
                filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                } else {
                    filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue, composerStartRestartGroup, i7);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(query, composerStartRestartGroup, i7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769491964, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i13 & 896) == 256);
                filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                } else {
                    filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(textFieldStateM1832rememberTextFieldStateLepunE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str7;
                modifier2 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = strStringResource;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$5(query, str2, onQueryChange, onGoBackClick, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function1 = function0;
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "57@2844L52,61@3037L2");
            if ((i & 1) != 0) {
                if ((i2 & 2) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 = i3;
                    str3 = strStringResource;
                    modifier3 = companion;
                    function3 = (Function0) objRememberedValue;
                } else {
                    i6 = i3;
                    str3 = strStringResource;
                    modifier3 = companion;
                    function3 = function1;
                }
            } else {
                if ((i2 & 2) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_action_search, composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769547100, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i6 = i3;
                    str3 = strStringResource;
                    modifier3 = companion;
                    function3 = (Function0) objRememberedValue;
                } else {
                    i6 = i3;
                    str3 = strStringResource;
                    modifier3 = companion;
                    function3 = function1;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1669665154, i6, -1, "com.box.android.browse.search.component.FilesSearchInputField (FilesSearchInputField.kt:62)");
            }
            ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope5 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localSharedTransitionScope5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SharedTransitionScope sharedTransitionScope5 = (SharedTransitionScope) objConsume9;
            ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope5 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume10 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedVisibilityScope animatedVisibilityScope5 = (AnimatedVisibilityScope) objConsume10;
            i7 = i6 & 14;
            textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(query, 0L, composerStartRestartGroup, i7, 2);
            Modifier modifierSharedElementInputRowContent5 = sharedElementInputRowContent(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m9687constructorimpl(72)), sharedTransitionScope5, animatedVisibilityScope5, composerStartRestartGroup, 0);
            Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier8 = modifier3;
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
            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400072399, "C76@3602L62,79@3703L51,82@3896L6,74@3509L414,88@4066L30,91@4252L72,85@3933L452:FilesSearchInputField.kt#8xusuk");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183708796, "CC(remember):FilesSearchInputField.kt#9igjgp");
            if ((i6 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$0$0(onGoBackClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i14 = i6;
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183693980, "CC(remember):FilesSearchInputField.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesSearchInputFieldKt.FilesSearchInputField$lambda$1$1$0(textFieldStateM1832rememberTextFieldStateLepunE);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String str8 = str3;
            Function0<Unit> function8 = function3;
            SearchTextField(textFieldStateM1832rememberTextFieldStateLepunE, str8, (Function0) objRememberedValue3, animatedVisibilityScope5, RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null), sharedElementPlaceholder(Modifier.INSTANCE, sharedTransitionScope5, animatedVisibilityScope5, composerStartRestartGroup, 6), function8, composerStartRestartGroup, (i14 & 112) | ((i14 << 3) & 3670016), 0);
            function1 = function8;
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769500868, "CC(remember):FilesSearchInputField.kt#9igjgp");
            boolean zChanged7 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE);
            if (i7 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = zChanged7 | z3;
            filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
            } else {
                filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$3$1(textFieldStateM1832rememberTextFieldStateLepunE, query, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$3$1RememberedValue, composerStartRestartGroup, i7);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(query, composerStartRestartGroup, i7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1769491964, "CC(remember):FilesSearchInputField.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | composerStartRestartGroup.changed(stateRememberUpdatedState) | ((i14 & 896) == 256);
            filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
            } else {
                filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue = new FilesSearchInputFieldKt$FilesSearchInputField$4$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(textFieldStateM1832rememberTextFieldStateLepunE, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchInputFieldKt$FilesSearchInputField$4$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str8;
            modifier2 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str2 = strStringResource;
        }
        function2 = function1;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesSearchInputFieldKt.FilesSearchInputField$lambda$5(query, str2, onQueryChange, onGoBackClick, modifier2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchInputField$lambda$1$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchInputField$lambda$1$1$0(TextFieldState textFieldState) {
        TextFieldStateKt.clearText(textFieldState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0297  */
    /* JADX WARN: Code duplicated, block: B:103:0x029f  */
    /* JADX WARN: Code duplicated, block: B:106:0x030e  */
    /* JADX WARN: Code duplicated, block: B:108:0x036a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0376  */
    /* JADX WARN: Code duplicated, block: B:112:0x037a  */
    /* JADX WARN: Code duplicated, block: B:114:0x040f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0432  */
    /* JADX WARN: Code duplicated, block: B:119:0x043c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0448  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:84:0x0101  */
    /* JADX WARN: Code duplicated, block: B:87:0x0130  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:98:0x0289  */
    private static final void SearchTextField(final TextFieldState textFieldState, final String str, final Function0<Unit> function0, AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier, Modifier modifier2, Function0<Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier3;
        int i4;
        Modifier modifier4;
        int i5;
        int i6;
        Function0<Unit> function2;
        int i7;
        int i8;
        boolean z;
        final Modifier modifier5;
        final Modifier modifier6;
        final Function0<Unit> function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier7;
        final Function0<Unit> function4;
        final FocusManager focusManager;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Function0<ComposeUiNode> constructor2;
        Object objRememberedValue3;
        AnimatedVisibilityScope animatedVisibilityScope2 = animatedVisibilityScope;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1383414624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchTextField)N(state,placeholderText,onClearButtonClick,animatedVisibilityScope,modifier,placeholderTextModifier,onSearchSubmitted)122@5261L2,124@5309L7,125@5342L29,127@5377L49,129@5432L2295:FilesSearchInputField.kt#8xusuk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(animatedVisibilityScope2) ? 2048 : 1024;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                modifier3 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier3) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    modifier4 = modifier2;
                    if (composerStartRestartGroup.changed(modifier4)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((1572864 & i) == 0) {
                        function2 = function1;
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    i8 = i3;
                    if ((599187 & i8) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier3;
                        modifier6 = modifier4;
                        function3 = function2;
                    } else {
                        if (i9 != 0) {
                            modifier7 = Modifier.INSTANCE;
                        } else {
                            modifier7 = modifier3;
                        }
                        if (i4 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function0) objRememberedValue3;
                        } else {
                            function4 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                        }
                        ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localFocusManager);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        focusManager = (FocusManager) objConsume;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        FocusRequester focusRequester = (FocusRequester) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier8 = modifier4;
                        RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester, 500L, composerStartRestartGroup, 54, 0);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                        Modifier modifierTestTag = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), 1.0f, false, 2, null), "SearchTextField");
                        TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                                @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                                public final void onKeyboardAction(Function0 function5) {
                                    FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function5);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifier9 = modifier7;
                        Function0<Unit> function5 = function4;
                        BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default, keyboardOptions, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier8, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (textFieldState.getText().length() > 0) {
                            animatedVisibilityScope2 = animatedVisibilityScope;
                            composerStartRestartGroup.startReplaceGroup(1808611910);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1815708027);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                            animatedVisibilityScope2 = animatedVisibilityScope;
                            Modifier modifierSharedTransitionAnimatedAlpha = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                            composerStartRestartGroup = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier9;
                        function3 = function5;
                        modifier6 = modifier8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final AnimatedVisibilityScope animatedVisibilityScope3 = animatedVisibilityScope2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope3, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function2 = function1;
                i8 = i3;
                if ((599187 & i8) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function3 = function2;
                } else {
                    if (i9 != 0) {
                        modifier7 = Modifier.INSTANCE;
                    } else {
                        modifier7 = modifier3;
                    }
                    if (i4 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function0) objRememberedValue3;
                    } else {
                        function4 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localFocusManager2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    focusManager = (FocusManager) objConsume2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    FocusRequester focusRequester2 = (FocusRequester) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier10 = modifier4;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester2, 500L, composerStartRestartGroup, 54, 0);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                    Modifier modifierTestTag2 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance2, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester2), 1.0f, false, 2, null), "SearchTextField");
                    TextStyle textStyleM9104copyp1EtxEg$default2 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function6) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function6);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function6) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function6);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier11 = modifier7;
                    Function0<Unit> function6 = function4;
                    BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag2, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default2, keyboardOptions2, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier10, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (textFieldState.getText().length() > 0) {
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        composerStartRestartGroup.startReplaceGroup(1808611910);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1815708027);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        Modifier modifierSharedTransitionAnimatedAlpha2 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha2);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                        Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier11;
                    function3 = function6;
                    modifier6 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final AnimatedVisibilityScope animatedVisibilityScope4 = animatedVisibilityScope2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope4, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier4 = modifier2;
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((599187 & i8) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function3 = function2;
                } else {
                    if (i9 != 0) {
                        modifier7 = Modifier.INSTANCE;
                    } else {
                        modifier7 = modifier3;
                    }
                    if (i4 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function0) objRememberedValue3;
                    } else {
                        function4 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager3 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localFocusManager3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    focusManager = (FocusManager) objConsume3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    FocusRequester focusRequester3 = (FocusRequester) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier12 = modifier4;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester3, 500L, composerStartRestartGroup, 54, 0);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_6 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_6, centerVertically3, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                    Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                    Modifier modifierTestTag3 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance3, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3), 1.0f, false, 2, null), "SearchTextField");
                    TextStyle textStyleM9104copyp1EtxEg$default3 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    KeyboardOptions keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function7) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function7);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function7) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function7);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier13 = modifier7;
                    Function0<Unit> function7 = function4;
                    BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag3, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default3, keyboardOptions3, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier12, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (textFieldState.getText().length() > 0) {
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        composerStartRestartGroup.startReplaceGroup(1808611910);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1815708027);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        Modifier modifierSharedTransitionAnimatedAlpha3 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha3);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                        Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier13;
                    function3 = function7;
                    modifier6 = modifier12;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final AnimatedVisibilityScope animatedVisibilityScope5 = animatedVisibilityScope2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope5, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function2 = function1;
            i8 = i3;
            if ((599187 & i8) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                function3 = function2;
            } else {
                if (i9 != 0) {
                    modifier7 = Modifier.INSTANCE;
                } else {
                    modifier7 = modifier3;
                }
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function0) objRememberedValue3;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager4 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localFocusManager4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                focusManager = (FocusManager) objConsume4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                FocusRequester focusRequester4 = (FocusRequester) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier14 = modifier4;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester4, 500L, composerStartRestartGroup, 54, 0);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_7 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_7, centerVertically4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                Modifier modifierTestTag4 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance4, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester4), 1.0f, false, 2, null), "SearchTextField");
                TextStyle textStyleM9104copyp1EtxEg$default4 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                KeyboardOptions keyboardOptions4 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function8) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function8);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function8) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function8);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier15 = modifier7;
                Function0<Unit> function8 = function4;
                BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag4, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default4, keyboardOptions4, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier14, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                composerStartRestartGroup = composerStartRestartGroup;
                if (textFieldState.getText().length() > 0) {
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    composerStartRestartGroup.startReplaceGroup(1808611910);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1815708027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    Modifier modifierSharedTransitionAnimatedAlpha4 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha4);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier15;
                function3 = function8;
                modifier6 = modifier14;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final AnimatedVisibilityScope animatedVisibilityScope6 = animatedVisibilityScope2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope6, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier3 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                modifier4 = modifier2;
                if (composerStartRestartGroup.changed(modifier4)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((599187 & i8) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    function3 = function2;
                } else {
                    if (i9 != 0) {
                        modifier7 = Modifier.INSTANCE;
                    } else {
                        modifier7 = modifier3;
                    }
                    if (i4 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function0) objRememberedValue3;
                    } else {
                        function4 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager5 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localFocusManager5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    focusManager = (FocusManager) objConsume5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    FocusRequester focusRequester5 = (FocusRequester) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier16 = modifier4;
                    RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester5, 500L, composerStartRestartGroup, 54, 0);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_8 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_8, centerVertically5, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                    Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                    Modifier modifierTestTag5 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance5, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester5), 1.0f, false, 2, null), "SearchTextField");
                    TextStyle textStyleM9104copyp1EtxEg$default5 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    KeyboardOptions keyboardOptions5 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function9) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function9);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                            @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                            public final void onKeyboardAction(Function0 function9) {
                                FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function9);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier17 = modifier7;
                    Function0<Unit> function9 = function4;
                    BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag5, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default5, keyboardOptions5, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier16, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (textFieldState.getText().length() > 0) {
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        composerStartRestartGroup.startReplaceGroup(1808611910);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1815708027);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                        animatedVisibilityScope2 = animatedVisibilityScope;
                        Modifier modifierSharedTransitionAnimatedAlpha5 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha5);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                        Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier17;
                    function3 = function9;
                    modifier6 = modifier16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final AnimatedVisibilityScope animatedVisibilityScope7 = animatedVisibilityScope2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope7, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function2 = function1;
            i8 = i3;
            if ((599187 & i8) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                function3 = function2;
            } else {
                if (i9 != 0) {
                    modifier7 = Modifier.INSTANCE;
                } else {
                    modifier7 = modifier3;
                }
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function0) objRememberedValue3;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager6 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localFocusManager6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                focusManager = (FocusManager) objConsume6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                FocusRequester focusRequester6 = (FocusRequester) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier18 = modifier4;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester6, 500L, composerStartRestartGroup, 54, 0);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_9 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_9, centerVertically6, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                Modifier modifierTestTag6 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance6, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester6), 1.0f, false, 2, null), "SearchTextField");
                TextStyle textStyleM9104copyp1EtxEg$default6 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                KeyboardOptions keyboardOptions6 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function10) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function10) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function10);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier19 = modifier7;
                Function0<Unit> function10 = function4;
                BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag6, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default6, keyboardOptions6, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier18, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                composerStartRestartGroup = composerStartRestartGroup;
                if (textFieldState.getText().length() > 0) {
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    composerStartRestartGroup.startReplaceGroup(1808611910);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1815708027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    Modifier modifierSharedTransitionAnimatedAlpha6 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha6);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier19;
                function3 = function10;
                modifier6 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final AnimatedVisibilityScope animatedVisibilityScope8 = animatedVisibilityScope2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope8, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier4 = modifier2;
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((1572864 & i) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((599187 & i8) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                function3 = function2;
            } else {
                if (i9 != 0) {
                    modifier7 = Modifier.INSTANCE;
                } else {
                    modifier7 = modifier3;
                }
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function0) objRememberedValue3;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager7 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localFocusManager7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                focusManager = (FocusManager) objConsume7;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                FocusRequester focusRequester7 = (FocusRequester) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier110 = modifier4;
                RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester7, 500L, composerStartRestartGroup, 54, 0);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_10 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_10, centerVertically7, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
                Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
                Modifier modifierTestTag7 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance7, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester7), 1.0f, false, 2, null), "SearchTextField");
                TextStyle textStyleM9104copyp1EtxEg$default7 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                KeyboardOptions keyboardOptions7 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
                zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function11) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function11);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                        public final void onKeyboardAction(Function0 function11) {
                            FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function11);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier111 = modifier7;
                Function0<Unit> function11 = function4;
                BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag7, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default7, keyboardOptions7, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier110, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
                composerStartRestartGroup = composerStartRestartGroup;
                if (textFieldState.getText().length() > 0) {
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    composerStartRestartGroup.startReplaceGroup(1808611910);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1815708027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                    animatedVisibilityScope2 = animatedVisibilityScope;
                    Modifier modifierSharedTransitionAnimatedAlpha7 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha7);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier111;
                function3 = function11;
                modifier6 = modifier110;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final AnimatedVisibilityScope animatedVisibilityScope9 = animatedVisibilityScope2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope9, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function2 = function1;
        i8 = i3;
        if ((599187 & i8) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier5 = modifier3;
            modifier6 = modifier4;
            function3 = function2;
        } else {
            if (i9 != 0) {
                modifier7 = Modifier.INSTANCE;
            } else {
                modifier7 = modifier3;
            }
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978417346, "CC(remember):FilesSearchInputField.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function4 = (Function0) objRememberedValue3;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1383414624, i8, -1, "com.box.android.browse.search.component.SearchTextField (FilesSearchInputField.kt:123)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager8 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localFocusManager8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            focusManager = (FocusManager) objConsume8;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978419965, "CC(remember):FilesSearchInputField.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            FocusRequester focusRequester8 = (FocusRequester) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier112 = modifier4;
            RequestFocusOnLaunchKt.RequestFocusOnLaunch(focusRequester8, 500L, composerStartRestartGroup, 54, 0);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_11 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_11, centerVertically8, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
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
            Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1814230971, "C140@5871L6,142@6002L156,148@6263L6,134@5597L1498:FilesSearchInputField.kt#8xusuk");
            Modifier modifierTestTag8 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance8, FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester8), 1.0f, false, 2, null), "SearchTextField");
            TextStyle textStyleM9104copyp1EtxEg$default8 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxNormal16(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            KeyboardOptions keyboardOptions8 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9282getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474176568, "CC(remember):FilesSearchInputField.kt#9igjgp");
            zChangedInstance = ((3670016 & i8) == 1048576) | composerStartRestartGroup.changedInstance(focusManager);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                    @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                    public final void onKeyboardAction(Function0 function12) {
                        FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function12);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new KeyboardActionHandler() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda6
                    @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                    public final void onKeyboardAction(Function0 function12) {
                        FilesSearchInputFieldKt.SearchTextField$lambda$2$0$0(function4, focusManager, function12);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier113 = modifier7;
            Function0<Unit> function12 = function4;
            BasicTextFieldKt.BasicTextField(textFieldState, modifierTestTag8, false, false, (InputTransformation) null, textStyleM9104copyp1EtxEg$default8, keyboardOptions8, (KeyboardActionHandler) objRememberedValue2, (TextFieldLineLimits) TextFieldLineLimits.SingleLine.INSTANCE, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, (MutableInteractionSource) null, (Brush) new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11562getTextFieldCursor0d7_KjU(), null), (OutputTransformation) null, (TextFieldDecorator) new FilesSearchInputFieldKt$SearchTextField$2$2(str, modifier112, textFieldState, animatedVisibilityScope2), (ScrollState) null, composerStartRestartGroup, (i8 & 14) | 102236160, 0, 22044);
            composerStartRestartGroup = composerStartRestartGroup;
            if (textFieldState.getText().length() > 0) {
                animatedVisibilityScope2 = animatedVisibilityScope;
                composerStartRestartGroup.startReplaceGroup(1808611910);
            } else {
                composerStartRestartGroup.startReplaceGroup(1815708027);
                ComposerKt.sourceInformation(composerStartRestartGroup, "168@7172L54,168@7148L563");
                animatedVisibilityScope2 = animatedVisibilityScope;
                Modifier modifierSharedTransitionAnimatedAlpha8 = sharedTransitionAnimatedAlpha(Modifier.INSTANCE, animatedVisibilityScope2, composerStartRestartGroup, ((i8 >> 6) & 112) | 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedTransitionAnimatedAlpha8);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 987960005, "C172@7420L74,175@7659L6,169@7246L451:FilesSearchInputField.kt#8xusuk");
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11572getTextFieldText0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier113;
            function3 = function12;
            modifier6 = modifier112;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final AnimatedVisibilityScope animatedVisibilityScope10 = animatedVisibilityScope2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesSearchInputFieldKt.SearchTextField$lambda$3(textFieldState, str, function0, animatedVisibilityScope10, modifier5, modifier6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchTextField$lambda$2$0$0(Function0 function0, FocusManager focusManager, Function0 performDefaultAction) {
        Intrinsics.checkNotNullParameter(performDefaultAction, "performDefaultAction");
        function0.invoke();
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        performDefaultAction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sharedTransitionAnimatedAlpha(Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Object currentState;
        float f;
        float f2;
        composer.startReplaceGroup(-474957321);
        ComposerKt.sourceInformation(composer, "C(sharedTransitionAnimatedAlpha)N(animatedVisibilityScope)189@8129L252:FilesSearchInputField.kt#8xusuk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-474957321, i, -1, "com.box.android.browse.search.component.sharedTransitionAnimatedAlpha (FilesSearchInputField.kt:187)");
        }
        if (animatedVisibilityScope == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifier;
        }
        final Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
        Function3 function3 = new Function3() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FilesSearchInputFieldKt.sharedTransitionAnimatedAlpha$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composer.changed(transition);
            currentState = composer.rememberedValue();
            if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    EnterExitState currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        EnterExitState enterExitState = (EnterExitState) currentState;
        composer.startReplaceGroup(-569324514);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchInputField.kt#8xusuk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-569324514, 0, -1, "com.box.android.browse.search.component.sharedTransitionAnimatedAlpha.<anonymous> (FilesSearchInputField.kt:192)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i2 == 1) {
            f = 0.0f;
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<EnterExitState>() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$sharedTransitionAnimatedAlpha$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.animation.EnterExitState, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final EnterExitState invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterExitState enterExitState2 = (EnterExitState) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(-569324514);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchInputField.kt#8xusuk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-569324514, 0, -1, "com.box.android.browse.search.component.sharedTransitionAnimatedAlpha.<anonymous> (FilesSearchInputField.kt:192)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[enterExitState2.ordinal()];
        if (i3 == 1) {
            f2 = 0.0f;
        } else if (i3 != 2) {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged3 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<EnterExitState>>() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$sharedTransitionAnimatedAlpha$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<EnterExitState> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "FloatAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM6981graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m6981graphicsLayer_6ThJ44$default(modifier, 0.0f, 0.0f, sharedTransitionAnimatedAlpha$lambda$2(stateCreateTransitionAnimation), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524283, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM6981graphicsLayer_6ThJ44$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec sharedTransitionAnimatedAlpha$lambda$0(Transition.Segment animateFloat, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(741844492);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(741844492, i, -1, "com.box.android.browse.search.component.sharedTransitionAnimatedAlpha.<anonymous> (FilesSearchInputField.kt:190)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(200, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    private static final Modifier sharedElementPlaceholder(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Modifier modifierSharedElement$default;
        ComposerKt.sourceInformationMarkerStart(composer, 37701820, "C(sharedElementPlaceholder)N(sharedTransitionScope,animatedVisibilityScope):FilesSearchInputField.kt#8xusuk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(37701820, i, -1, "com.box.android.browse.search.component.sharedElementPlaceholder (FilesSearchInputField.kt:206)");
        }
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            composer.startReplaceGroup(-2106274842);
            ComposerKt.sourceInformation(composer, "*209@8878L62");
            modifierSharedElement$default = SharedTransitionScope.sharedElement$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_PLACEHOLDER_TEXT_KEY, composer, 6), animatedVisibilityScope, SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), null, false, 0.0f, null, 120, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-2105930246);
            composer.endReplaceGroup();
            modifierSharedElement$default = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierSharedElement$default;
    }

    private static final Modifier sharedElementInputRowContent(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Modifier modifierSharedElement$default;
        ComposerKt.sourceInformationMarkerStart(composer, 543921478, "C(sharedElementInputRowContent)N(sharedTransitionScope,animatedVisibilityScope):FilesSearchInputField.kt#8xusuk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(543921478, i, -1, "com.box.android.browse.search.component.sharedElementInputRowContent (FilesSearchInputField.kt:223)");
        }
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            composer.startReplaceGroup(-946615497);
            ComposerKt.sourceInformation(composer, "*226@9635L63");
            modifierSharedElement$default = SharedTransitionScope.sharedElement$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_INPUT_ROW_CONTENT_KEY, composer, 6), animatedVisibilityScope, SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), null, false, 0.0f, null, 120, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-946266096);
            composer.endReplaceGroup();
            modifierSharedElement$default = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierSharedElement$default;
    }

    private static final void BoxSearchTextFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1191111125);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSearchTextFieldPreview)240@10006L262:FilesSearchInputField.kt#8xusuk");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1191111125, i, -1, "com.box.android.browse.search.component.BoxSearchTextFieldPreview (FilesSearchInputField.kt:239)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$FilesSearchInputFieldKt.INSTANCE.getLambda$1826741558$browse_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesSearchInputFieldKt.BoxSearchTextFieldPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void EmptyBoxSearchTextFieldPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1736326022);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyBoxSearchTextFieldPreview)254@10344L257:FilesSearchInputField.kt#8xusuk");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1736326022, i, -1, "com.box.android.browse.search.component.EmptyBoxSearchTextFieldPreview (FilesSearchInputField.kt:253)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$FilesSearchInputFieldKt.INSTANCE.m12298getLambda$137712561$browse_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesSearchInputFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesSearchInputFieldKt.EmptyBoxSearchTextFieldPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FilesSearchInputField$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final float sharedTransitionAnimatedAlpha$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
