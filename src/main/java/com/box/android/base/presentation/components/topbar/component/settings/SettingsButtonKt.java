package com.box.android.base.presentation.components.topbar.component.settings;

import android.app.Activity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import com.box.android.base.compose.UserAvatarKt;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"SettingsButton", "", "viewModel", "Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "avatarComponentDataProvider", "Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;", "(Lcom/box/android/base/presentation/components/topbar/component/settings/AvatarComponentDataProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SettingsButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsButton$lambda$0(UserAvatarViewModel userAvatarViewModel, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SettingsButton(userAvatarViewModel, (Function0<Unit>) function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsButton$lambda$1(AvatarComponentDataProvider avatarComponentDataProvider, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SettingsButton(avatarComponentDataProvider, (Function0<Unit>) function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsButton$lambda$8(AvatarComponentDataProvider avatarComponentDataProvider, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SettingsButton(avatarComponentDataProvider, (Function0<Unit>) function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SettingsButton(final UserAvatarViewModel viewModel, Function0<Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function0;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1974074065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButton)N(viewModel,onClick,modifier)25@1012L153:SettingsButton.kt#m1q6y6");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            function0 = onClick;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1974074065, i3, -1, "com.box.android.base.presentation.components.topbar.component.settings.SettingsButton (SettingsButton.kt:24)");
            }
            function0 = onClick;
            SettingsButton(viewModel.getAvatarComponentDataProvider(), function0, modifier3, composerStartRestartGroup, i3 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function1 = function0;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsButtonKt.SettingsButton$lambda$0(viewModel, function1, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x009a  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:60:0x0108  */
    /* JADX WARN: Code duplicated, block: B:65:0x0132  */
    /* JADX WARN: Code duplicated, block: B:69:0x0164  */
    /* JADX WARN: Code duplicated, block: B:74:0x0173  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:84:0x025b  */
    /* JADX WARN: Code duplicated, block: B:85:0x025f  */
    /* JADX WARN: Code duplicated, block: B:88:0x026b  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    private static final void SettingsButton(final AvatarComponentDataProvider avatarComponentDataProvider, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        AvatarComponentDataProvider avatarComponentDataProvider2;
        final Function0<Unit> function1;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Activity activity;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final String strStringResource;
        boolean zChanged;
        Object objRememberedValue4;
        boolean z2;
        Object objRememberedValue5;
        Function0<ComposeUiNode> constructor;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-872920050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButton)N(avatarComponentDataProvider,onClick,modifier)34@1353L7,36@1389L60,37@1469L62,38@1559L70,39@1667L41,43@1770L114,49@1964L13,41@1714L507:SettingsButton.kt#m1q6y6");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(avatarComponentDataProvider) : composerStartRestartGroup.changedInstance(avatarComponentDataProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                avatarComponentDataProvider2 = avatarComponentDataProvider;
                function1 = function0;
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-872920050, i3, -1, "com.box.android.base.presentation.components.topbar.component.settings.SettingsButton (SettingsButton.kt:33)");
                }
                ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localActivity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                activity = (Activity) objConsume;
                if (activity == null) {
                    avatarComponentDataProvider2 = avatarComponentDataProvider;
                    function1 = function0;
                    modifier2 = companion;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357538870, "CC(remember):SettingsButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = avatarComponentDataProvider2.getUserId(activity);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    String str = (String) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357536308, "CC(remember):SettingsButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = avatarComponentDataProvider2.getUserName(activity);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    String str2 = (String) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357533420, "CC(remember):SettingsButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = avatarComponentDataProvider2.getAvatarController(activity);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    DefaultAvatarController defaultAvatarController = (DefaultAvatarController) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    strStringResource = StringResources_androidKt.stringResource(R.string.account_settings, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357526624, "CC(remember):SettingsButton.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(strStringResource);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SettingsButtonKt.SettingsButton$lambda$5$0(strStringResource, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(ClipKt.clip(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue4, 1, null), RoundedCornerShapeKt.getCircleShape()), Dp.m9687constructorimpl(56));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357520517, "CC(remember):SettingsButton.kt#9igjgp");
                    z2 = (i3 & 112) == 32;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SettingsButtonKt.SettingsButton$lambda$6$0(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierM1266size3ABfNKs, false, null, null, null, (Function0) objRememberedValue5, 15, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -525130549, "C52@2039L176:SettingsButton.kt#m1q6y6");
                    UserAvatarKt.UserAvatar(str, str2, defaultAvatarController, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), composerStartRestartGroup, 3126, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SettingsButtonKt.SettingsButton$lambda$1(avatarComponentDataProvider, function0, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final AvatarComponentDataProvider avatarComponentDataProvider3 = avatarComponentDataProvider2;
                final Function0<Unit> function2 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SettingsButtonKt.SettingsButton$lambda$8(avatarComponentDataProvider3, function2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            avatarComponentDataProvider2 = avatarComponentDataProvider;
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-872920050, i3, -1, "com.box.android.base.presentation.components.topbar.component.settings.SettingsButton (SettingsButton.kt:33)");
            }
            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            activity = (Activity) objConsume2;
            if (activity == null) {
                avatarComponentDataProvider2 = avatarComponentDataProvider;
                function1 = function0;
                modifier2 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357538870, "CC(remember):SettingsButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = avatarComponentDataProvider2.getUserId(activity);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                String str3 = (String) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357536308, "CC(remember):SettingsButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = avatarComponentDataProvider2.getUserName(activity);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                String str4 = (String) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357533420, "CC(remember):SettingsButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = avatarComponentDataProvider2.getAvatarController(activity);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                DefaultAvatarController defaultAvatarController2 = (DefaultAvatarController) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                strStringResource = StringResources_androidKt.stringResource(R.string.account_settings, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357526624, "CC(remember):SettingsButton.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strStringResource);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SettingsButtonKt.SettingsButton$lambda$5$0(strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SettingsButtonKt.SettingsButton$lambda$5$0(strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(ClipKt.clip(SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue4, 1, null), RoundedCornerShapeKt.getCircleShape()), Dp.m9687constructorimpl(56));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1357520517, "CC(remember):SettingsButton.kt#9igjgp");
                if ((i3 & 112) == 32) {
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsButtonKt.SettingsButton$lambda$6$0(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsButtonKt.SettingsButton$lambda$6$0(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM632clickableoSLSa3U$default2 = ClickableKt.m632clickableoSLSa3U$default(modifierM1266size3ABfNKs2, false, null, null, null, (Function0) objRememberedValue5, 15, null);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default2);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -525130549, "C52@2039L176:SettingsButton.kt#m1q6y6");
                UserAvatarKt.UserAvatar(str3, str4, defaultAvatarController2, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), composerStartRestartGroup, 3126, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    final Modifier modifier5 = companion;
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SettingsButtonKt.SettingsButton$lambda$1(avatarComponentDataProvider, function0, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final AvatarComponentDataProvider avatarComponentDataProvider4 = avatarComponentDataProvider2;
            final Function0 function3 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsButtonKt.SettingsButton$lambda$8(avatarComponentDataProvider4, function3, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsButton$lambda$5$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semantics, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsButton$lambda$6$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
