package com.box.android.base.presentation.components.topbar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxButtonKt;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt;
import com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt;
import com.box.android.base.presentation.components.topbar.component.settings.SettingsButtonKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPrimaryTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxPrimaryTopBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "settingsButtonConfig", "Lcom/box/android/base/presentation/components/topbar/SettingsButtonConfig;", "jobsButtonConfig", "Lcom/box/android/base/presentation/components/topbar/JobsButtonConfig;", "centerSpaceConfig", "Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig;", "inboxButtonConfig", "Lcom/box/android/base/presentation/components/topbar/InboxButtonConfig;", "searchButtonConfig", "Lcom/box/android/base/presentation/components/topbar/SearchButtonConfig;", "(Landroidx/compose/ui/Modifier;Lcom/box/android/base/presentation/components/topbar/SettingsButtonConfig;Lcom/box/android/base/presentation/components/topbar/JobsButtonConfig;Lcom/box/android/base/presentation/components/topbar/CenterSpaceConfig;Lcom/box/android/base/presentation/components/topbar/InboxButtonConfig;Lcom/box/android/base/presentation/components/topbar/SearchButtonConfig;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxPrimaryTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPrimaryTopBar$lambda$1(Modifier modifier, SettingsButtonConfig settingsButtonConfig, JobsButtonConfig jobsButtonConfig, CenterSpaceConfig centerSpaceConfig, InboxButtonConfig inboxButtonConfig, SearchButtonConfig searchButtonConfig, int i, int i2, Composer composer, int i3) {
        BoxPrimaryTopBar(modifier, settingsButtonConfig, jobsButtonConfig, centerSpaceConfig, inboxButtonConfig, searchButtonConfig, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:105:0x022e  */
    /* JADX WARN: Code duplicated, block: B:106:0x023b  */
    /* JADX WARN: Code duplicated, block: B:108:0x024a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0292  */
    /* JADX WARN: Code duplicated, block: B:111:0x0296  */
    /* JADX WARN: Code duplicated, block: B:113:0x02df  */
    /* JADX WARN: Code duplicated, block: B:118:0x035e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0368  */
    /* JADX WARN: Code duplicated, block: B:121:0x0396  */
    /* JADX WARN: Code duplicated, block: B:122:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:124:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:125:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:128:0x0423  */
    /* JADX WARN: Code duplicated, block: B:130:0x042e  */
    /* JADX WARN: Code duplicated, block: B:132:0x043d  */
    /* JADX WARN: Code duplicated, block: B:135:0x044d  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0189  */
    /* JADX WARN: Code duplicated, block: B:98:0x0195  */
    /* JADX WARN: Code duplicated, block: B:99:0x0199  */
    public static final void BoxPrimaryTopBar(Modifier modifier, SettingsButtonConfig settingsButtonConfig, JobsButtonConfig jobsButtonConfig, CenterSpaceConfig centerSpaceConfig, InboxButtonConfig inboxButtonConfig, SearchButtonConfig searchButtonConfig, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        SettingsButtonConfig settingsButtonConfig2;
        int i4;
        JobsButtonConfig jobsButtonConfig2;
        int i5;
        int i6;
        CenterSpaceConfig centerSpaceConfig2;
        int i7;
        int i8;
        InboxButtonConfig inboxButtonConfig2;
        int i9;
        int i10;
        SearchButtonConfig searchButtonConfig2;
        int i11;
        boolean z;
        final SearchButtonConfig searchButtonConfig3;
        final SettingsButtonConfig settingsButtonConfig3;
        final Modifier modifier3;
        final JobsButtonConfig jobsButtonConfig3;
        final CenterSpaceConfig centerSpaceConfig3;
        final InboxButtonConfig inboxButtonConfig3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        CenterSpaceConfig centerSpaceConfig4;
        InboxButtonConfig inboxButtonConfig4;
        float f;
        Function0<ComposeUiNode> constructor;
        RowScopeInstance rowScopeInstance;
        Object objRememberedValue;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-901204393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxPrimaryTopBar)N(modifier,settingsButtonConfig,jobsButtonConfig,centerSpaceConfig,inboxButtonConfig,searchButtonConfig)60@3137L6,57@3030L2202:BoxPrimaryTopBar.kt#9psp5c");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                settingsButtonConfig2 = settingsButtonConfig;
                i3 |= composerStartRestartGroup.changedInstance(settingsButtonConfig2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    jobsButtonConfig2 = jobsButtonConfig;
                    if (composerStartRestartGroup.changedInstance(jobsButtonConfig2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        centerSpaceConfig2 = centerSpaceConfig;
                        if (composerStartRestartGroup.changed(centerSpaceConfig2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            inboxButtonConfig2 = inboxButtonConfig;
                            if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            searchButtonConfig2 = searchButtonConfig;
                        } else {
                            searchButtonConfig2 = searchButtonConfig;
                            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                        }
                        if ((i3 & 74899) != 74898) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            SettingsButtonConfig settingsButtonConfig4 = settingsButtonConfig2;
                            searchButtonConfig3 = searchButtonConfig2;
                            settingsButtonConfig3 = settingsButtonConfig4;
                            modifier3 = modifier2;
                            jobsButtonConfig3 = jobsButtonConfig2;
                            centerSpaceConfig3 = centerSpaceConfig2;
                            inboxButtonConfig3 = inboxButtonConfig2;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i14 != 0) {
                                settingsButtonConfig2 = null;
                            }
                            if (i4 != 0) {
                                jobsButtonConfig3 = null;
                            } else {
                                jobsButtonConfig3 = jobsButtonConfig2;
                            }
                            if (i6 != 0) {
                                centerSpaceConfig4 = null;
                            } else {
                                centerSpaceConfig4 = centerSpaceConfig2;
                            }
                            if (i8 != 0) {
                                inboxButtonConfig4 = null;
                            } else {
                                inboxButtonConfig4 = inboxButtonConfig2;
                            }
                            if (i10 != 0) {
                                searchButtonConfig2 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                            }
                            f = 4;
                            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
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
                            rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                            if (settingsButtonConfig2 == null) {
                                composerStartRestartGroup.startReplaceGroup(1897041010);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1897041011);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                                SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                                Unit unit = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            if (centerSpaceConfig4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1897274657);
                                composerStartRestartGroup.endReplaceGroup();
                                f = f;
                                i12 = 6;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1897274658);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                                    composerStartRestartGroup.startReplaceGroup(-2083418927);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                                    CenterSpaceConfig.SearchBarConfig searchBarConfig = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                                    TopBarSearchBarKt.TopBarSearchBar(searchBarConfig.getText(), searchBarConfig.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                    i12 = 6;
                                } else {
                                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                        composerStartRestartGroup.startReplaceGroup(-898492843);
                                        composerStartRestartGroup.endReplaceGroup();
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    composerStartRestartGroup.startReplaceGroup(-2083112089);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                                    String text = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                                    TextStyle boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                                    Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i12 = 6;
                                    TextKt.m4494TextNvy7gAk(text, SemanticsModifierKt.semantics$default(modifierWeight$default, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium22, composerStartRestartGroup, 0, 12582912, 131064);
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                Unit unit3 = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit4 = Unit.INSTANCE;
                            }
                            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                            if (jobsButtonConfig3 == null) {
                                composerStartRestartGroup.startReplaceGroup(1898104062);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1898104063);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                                JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                                Unit unit5 = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit6 = Unit.INSTANCE;
                            }
                            if (inboxButtonConfig4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1898272919);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1898272920);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                                InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                                Unit unit7 = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit8 = Unit.INSTANCE;
                            }
                            if (searchButtonConfig2 == null) {
                                composerStartRestartGroup.startReplaceGroup(1898401228);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1898401229);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                                IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                                Unit unit9 = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit10 = Unit.INSTANCE;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            SettingsButtonConfig settingsButtonConfig5 = settingsButtonConfig2;
                            searchButtonConfig3 = searchButtonConfig2;
                            settingsButtonConfig3 = settingsButtonConfig5;
                            modifier3 = companion;
                            centerSpaceConfig3 = centerSpaceConfig4;
                            inboxButtonConfig3 = inboxButtonConfig4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    inboxButtonConfig2 = inboxButtonConfig;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        searchButtonConfig2 = searchButtonConfig;
                    } else {
                        searchButtonConfig2 = searchButtonConfig;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        SettingsButtonConfig settingsButtonConfig6 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig6;
                        modifier3 = modifier2;
                        jobsButtonConfig3 = jobsButtonConfig2;
                        centerSpaceConfig3 = centerSpaceConfig2;
                        inboxButtonConfig3 = inboxButtonConfig2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            settingsButtonConfig2 = null;
                        }
                        if (i4 != 0) {
                            jobsButtonConfig3 = null;
                        } else {
                            jobsButtonConfig3 = jobsButtonConfig2;
                        }
                        if (i6 != 0) {
                            centerSpaceConfig4 = null;
                        } else {
                            centerSpaceConfig4 = centerSpaceConfig2;
                        }
                        if (i8 != 0) {
                            inboxButtonConfig4 = null;
                        } else {
                            inboxButtonConfig4 = inboxButtonConfig2;
                        }
                        if (i10 != 0) {
                            searchButtonConfig2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                        }
                        f = 4;
                        Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
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
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                        if (settingsButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897041010);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897041011);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                            SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                            Unit unit11 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit12 = Unit.INSTANCE;
                        }
                        if (centerSpaceConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897274657);
                            composerStartRestartGroup.endReplaceGroup();
                            f = f;
                            i12 = 6;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897274658);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-2083418927);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                                CenterSpaceConfig.SearchBarConfig searchBarConfig2 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                                TopBarSearchBarKt.TopBarSearchBar(searchBarConfig2.getText(), searchBarConfig2.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                i12 = 6;
                            } else {
                                if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                    composerStartRestartGroup.startReplaceGroup(-898492843);
                                    composerStartRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                composerStartRestartGroup.startReplaceGroup(-2083112089);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                                String text2 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                                TextStyle boxMedium23 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                                Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i12 = 6;
                                TextKt.m4494TextNvy7gAk(text2, SemanticsModifierKt.semantics$default(modifierWeight$default2, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium23, composerStartRestartGroup, 0, 12582912, 131064);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Unit unit13 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit14 = Unit.INSTANCE;
                        }
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                        if (jobsButtonConfig3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898104062);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898104063);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                            JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            Unit unit15 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit16 = Unit.INSTANCE;
                        }
                        if (inboxButtonConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898272919);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898272920);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                            InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                            Unit unit17 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit18 = Unit.INSTANCE;
                        }
                        if (searchButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898401228);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898401229);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                            IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                            Unit unit19 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit110 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        SettingsButtonConfig settingsButtonConfig7 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig7;
                        modifier3 = companion;
                        centerSpaceConfig3 = centerSpaceConfig4;
                        inboxButtonConfig3 = inboxButtonConfig4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                centerSpaceConfig2 = centerSpaceConfig;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        inboxButtonConfig2 = inboxButtonConfig;
                        if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        searchButtonConfig2 = searchButtonConfig;
                    } else {
                        searchButtonConfig2 = searchButtonConfig;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        SettingsButtonConfig settingsButtonConfig8 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig8;
                        modifier3 = modifier2;
                        jobsButtonConfig3 = jobsButtonConfig2;
                        centerSpaceConfig3 = centerSpaceConfig2;
                        inboxButtonConfig3 = inboxButtonConfig2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            settingsButtonConfig2 = null;
                        }
                        if (i4 != 0) {
                            jobsButtonConfig3 = null;
                        } else {
                            jobsButtonConfig3 = jobsButtonConfig2;
                        }
                        if (i6 != 0) {
                            centerSpaceConfig4 = null;
                        } else {
                            centerSpaceConfig4 = centerSpaceConfig2;
                        }
                        if (i8 != 0) {
                            inboxButtonConfig4 = null;
                        } else {
                            inboxButtonConfig4 = inboxButtonConfig2;
                        }
                        if (i10 != 0) {
                            searchButtonConfig2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                        }
                        f = 4;
                        Modifier modifierM1218padding3ABfNKs3 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs3);
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
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                        if (settingsButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897041010);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897041011);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                            SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                            Unit unit111 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit112 = Unit.INSTANCE;
                        }
                        if (centerSpaceConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897274657);
                            composerStartRestartGroup.endReplaceGroup();
                            f = f;
                            i12 = 6;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897274658);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-2083418927);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                                CenterSpaceConfig.SearchBarConfig searchBarConfig3 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                                TopBarSearchBarKt.TopBarSearchBar(searchBarConfig3.getText(), searchBarConfig3.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                i12 = 6;
                            } else {
                                if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                    composerStartRestartGroup.startReplaceGroup(-898492843);
                                    composerStartRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                composerStartRestartGroup.startReplaceGroup(-2083112089);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                                String text3 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                                TextStyle boxMedium24 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                                Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i12 = 6;
                                TextKt.m4494TextNvy7gAk(text3, SemanticsModifierKt.semantics$default(modifierWeight$default3, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium24, composerStartRestartGroup, 0, 12582912, 131064);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Unit unit113 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit114 = Unit.INSTANCE;
                        }
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                        if (jobsButtonConfig3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898104062);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898104063);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                            JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            Unit unit115 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit116 = Unit.INSTANCE;
                        }
                        if (inboxButtonConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898272919);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898272920);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                            InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                            Unit unit117 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit118 = Unit.INSTANCE;
                        }
                        if (searchButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898401228);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898401229);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                            IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                            Unit unit119 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit1110 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        SettingsButtonConfig settingsButtonConfig9 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig9;
                        modifier3 = companion;
                        centerSpaceConfig3 = centerSpaceConfig4;
                        inboxButtonConfig3 = inboxButtonConfig4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                inboxButtonConfig2 = inboxButtonConfig;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig10 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig10;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs4 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs4);
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
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit1111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig4 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig4.getText(), searchBarConfig4.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text4 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium25 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text4, SemanticsModifierKt.semantics$default(modifierWeight$default4, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium25, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit1113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit1115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit1117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit1119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig11 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig11;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            jobsButtonConfig2 = jobsButtonConfig;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    centerSpaceConfig2 = centerSpaceConfig;
                    if (composerStartRestartGroup.changed(centerSpaceConfig2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        inboxButtonConfig2 = inboxButtonConfig;
                        if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        searchButtonConfig2 = searchButtonConfig;
                    } else {
                        searchButtonConfig2 = searchButtonConfig;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        SettingsButtonConfig settingsButtonConfig12 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig12;
                        modifier3 = modifier2;
                        jobsButtonConfig3 = jobsButtonConfig2;
                        centerSpaceConfig3 = centerSpaceConfig2;
                        inboxButtonConfig3 = inboxButtonConfig2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            settingsButtonConfig2 = null;
                        }
                        if (i4 != 0) {
                            jobsButtonConfig3 = null;
                        } else {
                            jobsButtonConfig3 = jobsButtonConfig2;
                        }
                        if (i6 != 0) {
                            centerSpaceConfig4 = null;
                        } else {
                            centerSpaceConfig4 = centerSpaceConfig2;
                        }
                        if (i8 != 0) {
                            inboxButtonConfig4 = null;
                        } else {
                            inboxButtonConfig4 = inboxButtonConfig2;
                        }
                        if (i10 != 0) {
                            searchButtonConfig2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                        }
                        f = 4;
                        Modifier modifierM1218padding3ABfNKs5 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                        Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs5);
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
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                        if (settingsButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897041010);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897041011);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                            SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                            Unit unit11111 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit11112 = Unit.INSTANCE;
                        }
                        if (centerSpaceConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897274657);
                            composerStartRestartGroup.endReplaceGroup();
                            f = f;
                            i12 = 6;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897274658);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-2083418927);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                                CenterSpaceConfig.SearchBarConfig searchBarConfig5 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                                TopBarSearchBarKt.TopBarSearchBar(searchBarConfig5.getText(), searchBarConfig5.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                i12 = 6;
                            } else {
                                if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                    composerStartRestartGroup.startReplaceGroup(-898492843);
                                    composerStartRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                composerStartRestartGroup.startReplaceGroup(-2083112089);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                                String text5 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                                TextStyle boxMedium26 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                                Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i12 = 6;
                                TextKt.m4494TextNvy7gAk(text5, SemanticsModifierKt.semantics$default(modifierWeight$default5, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium26, composerStartRestartGroup, 0, 12582912, 131064);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Unit unit11113 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit11114 = Unit.INSTANCE;
                        }
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                        if (jobsButtonConfig3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898104062);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898104063);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                            JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            Unit unit11115 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit11116 = Unit.INSTANCE;
                        }
                        if (inboxButtonConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898272919);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898272920);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                            InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                            Unit unit11117 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit11118 = Unit.INSTANCE;
                        }
                        if (searchButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898401228);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898401229);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                            IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                            Unit unit11119 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit111110 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        SettingsButtonConfig settingsButtonConfig13 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig13;
                        modifier3 = companion;
                        centerSpaceConfig3 = centerSpaceConfig4;
                        inboxButtonConfig3 = inboxButtonConfig4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                inboxButtonConfig2 = inboxButtonConfig;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig14 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig14;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs6 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs6);
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit111111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit111112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig6 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig6.getText(), searchBarConfig6.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text6 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium27 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text6, SemanticsModifierKt.semantics$default(modifierWeight$default6, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium27, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit111113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit111114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit111115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit111116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit111117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit111118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit111119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig15 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig15;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            centerSpaceConfig2 = centerSpaceConfig;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    inboxButtonConfig2 = inboxButtonConfig;
                    if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig16 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig16;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs7 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs7);
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
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit1111111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig7 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig7.getText(), searchBarConfig7.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text7 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium28 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text7, SemanticsModifierKt.semantics$default(modifierWeight$default7, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium28, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit1111113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit1111115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit1111117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit1111119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig17 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig17;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            inboxButtonConfig2 = inboxButtonConfig;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                searchButtonConfig2 = searchButtonConfig;
            } else {
                searchButtonConfig2 = searchButtonConfig;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                SettingsButtonConfig settingsButtonConfig18 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig18;
                modifier3 = modifier2;
                jobsButtonConfig3 = jobsButtonConfig2;
                centerSpaceConfig3 = centerSpaceConfig2;
                inboxButtonConfig3 = inboxButtonConfig2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    settingsButtonConfig2 = null;
                }
                if (i4 != 0) {
                    jobsButtonConfig3 = null;
                } else {
                    jobsButtonConfig3 = jobsButtonConfig2;
                }
                if (i6 != 0) {
                    centerSpaceConfig4 = null;
                } else {
                    centerSpaceConfig4 = centerSpaceConfig2;
                }
                if (i8 != 0) {
                    inboxButtonConfig4 = null;
                } else {
                    inboxButtonConfig4 = inboxButtonConfig2;
                }
                if (i10 != 0) {
                    searchButtonConfig2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                }
                f = 4;
                Modifier modifierM1218padding3ABfNKs8 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs8);
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
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                if (settingsButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897041010);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897041011);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                    SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    Unit unit11111111 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111112 = Unit.INSTANCE;
                }
                if (centerSpaceConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897274657);
                    composerStartRestartGroup.endReplaceGroup();
                    f = f;
                    i12 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897274658);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                        composerStartRestartGroup.startReplaceGroup(-2083418927);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                        CenterSpaceConfig.SearchBarConfig searchBarConfig8 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                        TopBarSearchBarKt.TopBarSearchBar(searchBarConfig8.getText(), searchBarConfig8.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        i12 = 6;
                    } else {
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-898492843);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-2083112089);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                        String text8 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                        TextStyle boxMedium29 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                        Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i12 = 6;
                        TextKt.m4494TextNvy7gAk(text8, SemanticsModifierKt.semantics$default(modifierWeight$default8, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium29, composerStartRestartGroup, 0, 12582912, 131064);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Unit unit11111113 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111114 = Unit.INSTANCE;
                }
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                if (jobsButtonConfig3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898104062);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898104063);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                    JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    Unit unit11111115 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111116 = Unit.INSTANCE;
                }
                if (inboxButtonConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898272919);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898272920);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                    InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                    Unit unit11111117 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111118 = Unit.INSTANCE;
                }
                if (searchButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898401228);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898401229);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                    IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                    Unit unit11111119 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111110 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                SettingsButtonConfig settingsButtonConfig19 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig19;
                modifier3 = companion;
                centerSpaceConfig3 = centerSpaceConfig4;
                inboxButtonConfig3 = inboxButtonConfig4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        settingsButtonConfig2 = settingsButtonConfig;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                jobsButtonConfig2 = jobsButtonConfig;
                if (composerStartRestartGroup.changedInstance(jobsButtonConfig2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    centerSpaceConfig2 = centerSpaceConfig;
                    if (composerStartRestartGroup.changed(centerSpaceConfig2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        inboxButtonConfig2 = inboxButtonConfig;
                        if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        searchButtonConfig2 = searchButtonConfig;
                    } else {
                        searchButtonConfig2 = searchButtonConfig;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        SettingsButtonConfig settingsButtonConfig110 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig110;
                        modifier3 = modifier2;
                        jobsButtonConfig3 = jobsButtonConfig2;
                        centerSpaceConfig3 = centerSpaceConfig2;
                        inboxButtonConfig3 = inboxButtonConfig2;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            settingsButtonConfig2 = null;
                        }
                        if (i4 != 0) {
                            jobsButtonConfig3 = null;
                        } else {
                            jobsButtonConfig3 = jobsButtonConfig2;
                        }
                        if (i6 != 0) {
                            centerSpaceConfig4 = null;
                        } else {
                            centerSpaceConfig4 = centerSpaceConfig2;
                        }
                        if (i8 != 0) {
                            inboxButtonConfig4 = null;
                        } else {
                            inboxButtonConfig4 = inboxButtonConfig2;
                        }
                        if (i10 != 0) {
                            searchButtonConfig2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                        }
                        f = 4;
                        Modifier modifierM1218padding3ABfNKs9 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                        Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically9, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs9);
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
                        Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                        if (settingsButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897041010);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897041011);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                            SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                            Unit unit111111111 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit111111112 = Unit.INSTANCE;
                        }
                        if (centerSpaceConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1897274657);
                            composerStartRestartGroup.endReplaceGroup();
                            f = f;
                            i12 = 6;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1897274658);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-2083418927);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                                CenterSpaceConfig.SearchBarConfig searchBarConfig9 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                                TopBarSearchBarKt.TopBarSearchBar(searchBarConfig9.getText(), searchBarConfig9.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                i12 = 6;
                            } else {
                                if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                    composerStartRestartGroup.startReplaceGroup(-898492843);
                                    composerStartRestartGroup.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                }
                                composerStartRestartGroup.startReplaceGroup(-2083112089);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                                String text9 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                                TextStyle boxMedium210 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                                Modifier modifierWeight$default9 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i12 = 6;
                                TextKt.m4494TextNvy7gAk(text9, SemanticsModifierKt.semantics$default(modifierWeight$default9, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium210, composerStartRestartGroup, 0, 12582912, 131064);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Unit unit111111113 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit111111114 = Unit.INSTANCE;
                        }
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                        if (jobsButtonConfig3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898104062);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898104063);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                            JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                            Unit unit111111115 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit111111116 = Unit.INSTANCE;
                        }
                        if (inboxButtonConfig4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898272919);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898272920);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                            InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                            Unit unit111111117 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit111111118 = Unit.INSTANCE;
                        }
                        if (searchButtonConfig2 == null) {
                            composerStartRestartGroup.startReplaceGroup(1898401228);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1898401229);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                            IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                            Unit unit111111119 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit1111111110 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        SettingsButtonConfig settingsButtonConfig111 = settingsButtonConfig2;
                        searchButtonConfig3 = searchButtonConfig2;
                        settingsButtonConfig3 = settingsButtonConfig111;
                        modifier3 = companion;
                        centerSpaceConfig3 = centerSpaceConfig4;
                        inboxButtonConfig3 = inboxButtonConfig4;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                inboxButtonConfig2 = inboxButtonConfig;
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig112 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig112;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs10 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically10 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically10, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs10);
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
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit1111111111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig10 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig10.getText(), searchBarConfig10.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text10 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium211 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default10 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text10, SemanticsModifierKt.semantics$default(modifierWeight$default10, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium211, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit1111111113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit1111111115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit1111111117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit1111111119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig113 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig113;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            centerSpaceConfig2 = centerSpaceConfig;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    inboxButtonConfig2 = inboxButtonConfig;
                    if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig114 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig114;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs11 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically11 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs11);
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
                    Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit11111111111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig11 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig11.getText(), searchBarConfig11.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text11 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium212 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default11 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text11, SemanticsModifierKt.semantics$default(modifierWeight$default11, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium212, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit11111111113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit11111111115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit11111111117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit11111111119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit111111111110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig115 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig115;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            inboxButtonConfig2 = inboxButtonConfig;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                searchButtonConfig2 = searchButtonConfig;
            } else {
                searchButtonConfig2 = searchButtonConfig;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                SettingsButtonConfig settingsButtonConfig116 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig116;
                modifier3 = modifier2;
                jobsButtonConfig3 = jobsButtonConfig2;
                centerSpaceConfig3 = centerSpaceConfig2;
                inboxButtonConfig3 = inboxButtonConfig2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    settingsButtonConfig2 = null;
                }
                if (i4 != 0) {
                    jobsButtonConfig3 = null;
                } else {
                    jobsButtonConfig3 = jobsButtonConfig2;
                }
                if (i6 != 0) {
                    centerSpaceConfig4 = null;
                } else {
                    centerSpaceConfig4 = centerSpaceConfig2;
                }
                if (i8 != 0) {
                    inboxButtonConfig4 = null;
                } else {
                    inboxButtonConfig4 = inboxButtonConfig2;
                }
                if (i10 != 0) {
                    searchButtonConfig2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                }
                f = 4;
                Modifier modifierM1218padding3ABfNKs12 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                Alignment.Vertical centerVertically12 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically12, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs12);
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
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                if (settingsButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897041010);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897041011);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                    SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    Unit unit111111111111 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111112 = Unit.INSTANCE;
                }
                if (centerSpaceConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897274657);
                    composerStartRestartGroup.endReplaceGroup();
                    f = f;
                    i12 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897274658);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                        composerStartRestartGroup.startReplaceGroup(-2083418927);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                        CenterSpaceConfig.SearchBarConfig searchBarConfig12 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                        TopBarSearchBarKt.TopBarSearchBar(searchBarConfig12.getText(), searchBarConfig12.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        i12 = 6;
                    } else {
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-898492843);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-2083112089);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                        String text12 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                        TextStyle boxMedium213 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                        Modifier modifierWeight$default12 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i12 = 6;
                        TextKt.m4494TextNvy7gAk(text12, SemanticsModifierKt.semantics$default(modifierWeight$default12, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium213, composerStartRestartGroup, 0, 12582912, 131064);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Unit unit111111111113 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111114 = Unit.INSTANCE;
                }
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                if (jobsButtonConfig3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898104062);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898104063);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                    JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    Unit unit111111111115 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111116 = Unit.INSTANCE;
                }
                if (inboxButtonConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898272919);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898272920);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                    InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                    Unit unit111111111117 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111118 = Unit.INSTANCE;
                }
                if (searchButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898401228);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898401229);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                    IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                    Unit unit111111111119 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit1111111111110 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                SettingsButtonConfig settingsButtonConfig117 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig117;
                modifier3 = companion;
                centerSpaceConfig3 = centerSpaceConfig4;
                inboxButtonConfig3 = inboxButtonConfig4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        jobsButtonConfig2 = jobsButtonConfig;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                centerSpaceConfig2 = centerSpaceConfig;
                if (composerStartRestartGroup.changed(centerSpaceConfig2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    inboxButtonConfig2 = inboxButtonConfig;
                    if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    searchButtonConfig2 = searchButtonConfig;
                } else {
                    searchButtonConfig2 = searchButtonConfig;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    SettingsButtonConfig settingsButtonConfig118 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig118;
                    modifier3 = modifier2;
                    jobsButtonConfig3 = jobsButtonConfig2;
                    centerSpaceConfig3 = centerSpaceConfig2;
                    inboxButtonConfig3 = inboxButtonConfig2;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        settingsButtonConfig2 = null;
                    }
                    if (i4 != 0) {
                        jobsButtonConfig3 = null;
                    } else {
                        jobsButtonConfig3 = jobsButtonConfig2;
                    }
                    if (i6 != 0) {
                        centerSpaceConfig4 = null;
                    } else {
                        centerSpaceConfig4 = centerSpaceConfig2;
                    }
                    if (i8 != 0) {
                        inboxButtonConfig4 = null;
                    } else {
                        inboxButtonConfig4 = inboxButtonConfig2;
                    }
                    if (i10 != 0) {
                        searchButtonConfig2 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                    }
                    f = 4;
                    Modifier modifierM1218padding3ABfNKs13 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                    Alignment.Vertical centerVertically13 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically13, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs13);
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
                    Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                    if (settingsButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897041010);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897041011);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                        SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        Unit unit1111111111111 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111111112 = Unit.INSTANCE;
                    }
                    if (centerSpaceConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1897274657);
                        composerStartRestartGroup.endReplaceGroup();
                        f = f;
                        i12 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1897274658);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-2083418927);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                            CenterSpaceConfig.SearchBarConfig searchBarConfig13 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                            TopBarSearchBarKt.TopBarSearchBar(searchBarConfig13.getText(), searchBarConfig13.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            i12 = 6;
                        } else {
                            if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                                composerStartRestartGroup.startReplaceGroup(-898492843);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-2083112089);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                            String text13 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                            TextStyle boxMedium214 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                            Modifier modifierWeight$default13 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i12 = 6;
                            TextKt.m4494TextNvy7gAk(text13, SemanticsModifierKt.semantics$default(modifierWeight$default13, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium214, composerStartRestartGroup, 0, 12582912, 131064);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Unit unit1111111111113 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111111114 = Unit.INSTANCE;
                    }
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                    if (jobsButtonConfig3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898104062);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898104063);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                        JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                        Unit unit1111111111115 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111111116 = Unit.INSTANCE;
                    }
                    if (inboxButtonConfig4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898272919);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898272920);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                        InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                        Unit unit1111111111117 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit1111111111118 = Unit.INSTANCE;
                    }
                    if (searchButtonConfig2 == null) {
                        composerStartRestartGroup.startReplaceGroup(1898401228);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1898401229);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                        IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                        Unit unit1111111111119 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit11111111111110 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    SettingsButtonConfig settingsButtonConfig119 = settingsButtonConfig2;
                    searchButtonConfig3 = searchButtonConfig2;
                    settingsButtonConfig3 = settingsButtonConfig119;
                    modifier3 = companion;
                    centerSpaceConfig3 = centerSpaceConfig4;
                    inboxButtonConfig3 = inboxButtonConfig4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            inboxButtonConfig2 = inboxButtonConfig;
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                searchButtonConfig2 = searchButtonConfig;
            } else {
                searchButtonConfig2 = searchButtonConfig;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                SettingsButtonConfig settingsButtonConfig1110 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig1110;
                modifier3 = modifier2;
                jobsButtonConfig3 = jobsButtonConfig2;
                centerSpaceConfig3 = centerSpaceConfig2;
                inboxButtonConfig3 = inboxButtonConfig2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    settingsButtonConfig2 = null;
                }
                if (i4 != 0) {
                    jobsButtonConfig3 = null;
                } else {
                    jobsButtonConfig3 = jobsButtonConfig2;
                }
                if (i6 != 0) {
                    centerSpaceConfig4 = null;
                } else {
                    centerSpaceConfig4 = centerSpaceConfig2;
                }
                if (i8 != 0) {
                    inboxButtonConfig4 = null;
                } else {
                    inboxButtonConfig4 = inboxButtonConfig2;
                }
                if (i10 != 0) {
                    searchButtonConfig2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                }
                f = 4;
                Modifier modifierM1218padding3ABfNKs14 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                Alignment.Vertical centerVertically14 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically14, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs14);
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
                Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                if (settingsButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897041010);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897041011);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                    SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    Unit unit11111111111111 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111111111112 = Unit.INSTANCE;
                }
                if (centerSpaceConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897274657);
                    composerStartRestartGroup.endReplaceGroup();
                    f = f;
                    i12 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897274658);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                        composerStartRestartGroup.startReplaceGroup(-2083418927);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                        CenterSpaceConfig.SearchBarConfig searchBarConfig14 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                        TopBarSearchBarKt.TopBarSearchBar(searchBarConfig14.getText(), searchBarConfig14.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        i12 = 6;
                    } else {
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-898492843);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-2083112089);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                        String text14 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                        TextStyle boxMedium215 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                        Modifier modifierWeight$default14 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i12 = 6;
                        TextKt.m4494TextNvy7gAk(text14, SemanticsModifierKt.semantics$default(modifierWeight$default14, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium215, composerStartRestartGroup, 0, 12582912, 131064);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Unit unit11111111111113 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111111111114 = Unit.INSTANCE;
                }
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                if (jobsButtonConfig3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898104062);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898104063);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                    JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    Unit unit11111111111115 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111111111116 = Unit.INSTANCE;
                }
                if (inboxButtonConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898272919);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898272920);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                    InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                    Unit unit11111111111117 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit11111111111118 = Unit.INSTANCE;
                }
                if (searchButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898401228);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898401229);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                    IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                    Unit unit11111111111119 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111111110 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                SettingsButtonConfig settingsButtonConfig1111 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig1111;
                modifier3 = companion;
                centerSpaceConfig3 = centerSpaceConfig4;
                inboxButtonConfig3 = inboxButtonConfig4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        centerSpaceConfig2 = centerSpaceConfig;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                inboxButtonConfig2 = inboxButtonConfig;
                if (composerStartRestartGroup.changedInstance(inboxButtonConfig2)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                searchButtonConfig2 = searchButtonConfig;
            } else {
                searchButtonConfig2 = searchButtonConfig;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                SettingsButtonConfig settingsButtonConfig1112 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig1112;
                modifier3 = modifier2;
                jobsButtonConfig3 = jobsButtonConfig2;
                centerSpaceConfig3 = centerSpaceConfig2;
                inboxButtonConfig3 = inboxButtonConfig2;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    settingsButtonConfig2 = null;
                }
                if (i4 != 0) {
                    jobsButtonConfig3 = null;
                } else {
                    jobsButtonConfig3 = jobsButtonConfig2;
                }
                if (i6 != 0) {
                    centerSpaceConfig4 = null;
                } else {
                    centerSpaceConfig4 = centerSpaceConfig2;
                }
                if (i8 != 0) {
                    inboxButtonConfig4 = null;
                } else {
                    inboxButtonConfig4 = inboxButtonConfig2;
                }
                if (i10 != 0) {
                    searchButtonConfig2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
                }
                f = 4;
                Modifier modifierM1218padding3ABfNKs15 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
                Alignment.Vertical centerVertically15 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically15, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs15);
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
                Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
                if (settingsButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897041010);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897041011);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                    SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    Unit unit111111111111111 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111111112 = Unit.INSTANCE;
                }
                if (centerSpaceConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1897274657);
                    composerStartRestartGroup.endReplaceGroup();
                    f = f;
                    i12 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1897274658);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                        composerStartRestartGroup.startReplaceGroup(-2083418927);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                        CenterSpaceConfig.SearchBarConfig searchBarConfig15 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                        TopBarSearchBarKt.TopBarSearchBar(searchBarConfig15.getText(), searchBarConfig15.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        i12 = 6;
                    } else {
                        if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                            composerStartRestartGroup.startReplaceGroup(-898492843);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-2083112089);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                        String text15 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                        TextStyle boxMedium216 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                        Modifier modifierWeight$default15 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i12 = 6;
                        TextKt.m4494TextNvy7gAk(text15, SemanticsModifierKt.semantics$default(modifierWeight$default15, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium216, composerStartRestartGroup, 0, 12582912, 131064);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Unit unit111111111111113 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111111114 = Unit.INSTANCE;
                }
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                if (jobsButtonConfig3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898104062);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898104063);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                    JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                    Unit unit111111111111115 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111111116 = Unit.INSTANCE;
                }
                if (inboxButtonConfig4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898272919);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898272920);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                    InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                    Unit unit111111111111117 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit111111111111118 = Unit.INSTANCE;
                }
                if (searchButtonConfig2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1898401228);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1898401229);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                    IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                    Unit unit111111111111119 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit1111111111111110 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                SettingsButtonConfig settingsButtonConfig1113 = settingsButtonConfig2;
                searchButtonConfig3 = searchButtonConfig2;
                settingsButtonConfig3 = settingsButtonConfig1113;
                modifier3 = companion;
                centerSpaceConfig3 = centerSpaceConfig4;
                inboxButtonConfig3 = inboxButtonConfig4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        inboxButtonConfig2 = inboxButtonConfig;
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            searchButtonConfig2 = searchButtonConfig;
        } else {
            searchButtonConfig2 = searchButtonConfig;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(searchButtonConfig2)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
        }
        if ((i3 & 74899) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            SettingsButtonConfig settingsButtonConfig1114 = settingsButtonConfig2;
            searchButtonConfig3 = searchButtonConfig2;
            settingsButtonConfig3 = settingsButtonConfig1114;
            modifier3 = modifier2;
            jobsButtonConfig3 = jobsButtonConfig2;
            centerSpaceConfig3 = centerSpaceConfig2;
            inboxButtonConfig3 = inboxButtonConfig2;
        } else {
            if (i13 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i14 != 0) {
                settingsButtonConfig2 = null;
            }
            if (i4 != 0) {
                jobsButtonConfig3 = null;
            } else {
                jobsButtonConfig3 = jobsButtonConfig2;
            }
            if (i6 != 0) {
                centerSpaceConfig4 = null;
            } else {
                centerSpaceConfig4 = centerSpaceConfig2;
            }
            if (i8 != 0) {
                inboxButtonConfig4 = null;
            } else {
                inboxButtonConfig4 = inboxButtonConfig2;
            }
            if (i10 != 0) {
                searchButtonConfig2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-901204393, i3, -1, "com.box.android.base.presentation.components.topbar.BoxPrimaryTopBar (BoxPrimaryTopBar.kt:56)");
            }
            f = 4;
            Modifier modifierM1218padding3ABfNKs16 = PaddingKt.m1218padding3ABfNKs(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(companion, "BoxPrimaryTopBar"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(f));
            Alignment.Vertical centerVertically16 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically16, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs16);
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
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897072167, "C96@4358L39:BoxPrimaryTopBar.kt#9psp5c");
            if (settingsButtonConfig2 == null) {
                composerStartRestartGroup.startReplaceGroup(1897041010);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1897041011);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*67@3369L108,71@3490L39");
                SettingsButtonKt.SettingsButton(settingsButtonConfig2.getViewModel(), settingsButtonConfig2.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                Unit unit1111111111111111 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1111111111111112 = Unit.INSTANCE;
            }
            if (centerSpaceConfig4 == null) {
                composerStartRestartGroup.startReplaceGroup(1897274657);
                composerStartRestartGroup.endReplaceGroup();
                f = f;
                i12 = 6;
            } else {
                composerStartRestartGroup.startReplaceGroup(1897274658);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (centerSpaceConfig4 instanceof CenterSpaceConfig.SearchBarConfig) {
                    composerStartRestartGroup.startReplaceGroup(-2083418927);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3690L187");
                    CenterSpaceConfig.SearchBarConfig searchBarConfig16 = (CenterSpaceConfig.SearchBarConfig) centerSpaceConfig4;
                    TopBarSearchBarKt.TopBarSearchBar(searchBarConfig16.getText(), searchBarConfig16.getOnClick(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    i12 = 6;
                } else {
                    if (centerSpaceConfig4 instanceof CenterSpaceConfig.TitleBarConfig) {
                        composerStartRestartGroup.startReplaceGroup(-898492843);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-2083112089);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "90@4212L13,91@4268L6,85@3974L333");
                    String text16 = ((CenterSpaceConfig.TitleBarConfig) centerSpaceConfig4).getText();
                    TextStyle boxMedium217 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                    Modifier modifierWeight$default16 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -898473861, "CC(remember):BoxPrimaryTopBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$0$1$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i12 = 6;
                    TextKt.m4494TextNvy7gAk(text16, SemanticsModifierKt.semantics$default(modifierWeight$default16, false, (Function1) objRememberedValue, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, boxMedium217, composerStartRestartGroup, 0, 12582912, 131064);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
                Unit unit1111111111111113 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1111111111111114 = Unit.INSTANCE;
            }
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
            if (jobsButtonConfig3 == null) {
                composerStartRestartGroup.startReplaceGroup(1898104062);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1898104063);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*98@4442L116");
                JobsWithProgressButtonKt.JobsWithProgressButton(jobsButtonConfig3.getViewModel(), jobsButtonConfig3.getOnClick(), (Modifier) null, composerStartRestartGroup, 0, 4);
                Unit unit1111111111111115 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1111111111111116 = Unit.INSTANCE;
            }
            if (inboxButtonConfig4 == null) {
                composerStartRestartGroup.startReplaceGroup(1898272919);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1898272920);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*104@4614L59");
                InboxButtonKt.InboxButton(inboxButtonConfig4.getViewModel(), inboxButtonConfig4.getOnClick(), composerStartRestartGroup, 0);
                Unit unit1111111111111117 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1111111111111118 = Unit.INSTANCE;
            }
            if (searchButtonConfig2 == null) {
                composerStartRestartGroup.startReplaceGroup(1898401228);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1898401229);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*107@4730L486");
                IconButtonKt.IconButton(searchButtonConfig2.getOnClick(), SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(TestTagKt.testTag(Modifier.INSTANCE, "TopBar:Search")), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxPrimaryTopBarKt.INSTANCE.m11836getLambda$910396438$base_generalProdRelease(), composerStartRestartGroup, 1572912, 60);
                Unit unit1111111111111119 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit11111111111111110 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            SettingsButtonConfig settingsButtonConfig1115 = settingsButtonConfig2;
            searchButtonConfig3 = searchButtonConfig2;
            settingsButtonConfig3 = settingsButtonConfig1115;
            modifier3 = companion;
            centerSpaceConfig3 = centerSpaceConfig4;
            inboxButtonConfig3 = inboxButtonConfig4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPrimaryTopBarKt.BoxPrimaryTopBar$lambda$1(modifier3, settingsButtonConfig3, jobsButtonConfig3, centerSpaceConfig3, inboxButtonConfig3, searchButtonConfig3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPrimaryTopBar$lambda$0$1$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }
}
