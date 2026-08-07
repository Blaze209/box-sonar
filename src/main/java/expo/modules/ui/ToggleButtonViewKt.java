package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconToggleButtonColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.ToggleButtonColors;
import androidx.compose.material3.ToggleButtonDefaults;
import androidx.compose.material3.ToggleButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.domain.metrics.hubs.HubsObservability;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButtonView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ToggleButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ToggleButtonProps;", "onCheckedChange", "Lkotlin/Function1;", "Lexpo/modules/ui/ToggleButtonValueChangeEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ToggleButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ToggleButtonViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButtonContent$lambda$8(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Function1 function1, int i, Composer composer, int i2) {
        ToggleButtonContent(functionalComposableScope, toggleButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0199  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d2  */
    public static final void ToggleButtonContent(final FunctionalComposableScope functionalComposableScope, final ToggleButtonProps props, final Function1<? super ToggleButtonValueChangeEvent, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        boolean z;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1479239328);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButtonContent)P(1)37@1297L83,41@1442L120,49@1655L120:ToggleButtonView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & Token.DOTQUERY) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479239328, i3, -1, "expo.modules.ui.ToggleButtonContent (ToggleButtonView.kt:36)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1333907423, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ToggleButtonViewKt$ToggleButtonContent$content$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C:ToggleButtonView.kt#v15e7d");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1333907423, i4, -1, "expo.modules.ui.ToggleButtonContent.<anonymous> (ToggleButtonView.kt:42)");
                    }
                    if (props.getText() != null) {
                        composer2.startReplaceGroup(-1984777960);
                        ComposerKt.sourceInformation(composer2, "43@1483L23");
                        TextKt.m4494TextNvy7gAk(props.getText(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-1984776550);
                        ComposerKt.sourceInformation(composer2, "44@1527L25");
                        functionalComposableScope.Children(functionalComposableScope.getComposableScope(), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-16635343, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.ToggleButtonViewKt$ToggleButtonContent$rowContent$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope rowScope, Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(rowScope, "<this>");
                    ComposerKt.sourceInformation(composer2, "C:ToggleButtonView.kt#v15e7d");
                    if ((i4 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-16635343, i4, -1, "expo.modules.ui.ToggleButtonContent.<anonymous> (ToggleButtonView.kt:50)");
                    }
                    if (props.getText() != null) {
                        composer2.startReplaceGroup(1193305896);
                        ComposerKt.sourceInformation(composer2, "51@1696L23");
                        TextKt.m4494TextNvy7gAk(props.getText(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1193307306);
                        ComposerKt.sourceInformation(composer2, "52@1740L25");
                        functionalComposableScope.Children(functionalComposableScope.getComposableScope(), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            String variant = props.getVariant();
            int iHashCode = variant.hashCode();
            if (iHashCode != -1460097029) {
                if (iHashCode != -76423941) {
                    if (iHashCode == 3226745 && variant.equals(HubsObservability.HUB_ASSET_ICON)) {
                        composerStartRestartGroup.startReplaceGroup(-1653655601);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@1901L53,58@1824L229");
                        boolean checked = props.getChecked();
                        boolean z2 = !props.getDisabled();
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                        boolean z3 = (i3 & 896) == 256;
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ToggleButtonViewKt.ToggleButtonContent$lambda$1$lambda$0(onCheckedChange, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        IconButtonKt.IconToggleButton(checked, (Function1<? super Boolean, Unit>) objRememberedValue2, modifierApplyModifiers, z2, (IconToggleButtonColors) null, (MutableInteractionSource) null, (Shape) null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 12582912, 112);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1652860172);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "90@2854L20,87@2697L53,85@2624L288");
                        boolean checked2 = props.getChecked();
                        boolean z4 = !props.getDisabled();
                        ToggleButtonColors toggleButtonColors = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, ToggleButtonDefaults.$stable);
                        composerStartRestartGroup.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                        if ((i3 & 896) == 256) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ToggleButtonViewKt.ToggleButtonContent$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ToggleButtonKt.ToggleButton(checked2, (Function1) objRememberedValue, modifierApplyModifiers, z4, null, toggleButtonColors, null, null, null, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 0, 6, 976);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else if (variant.equals("filledIcon")) {
                    composerStartRestartGroup.startReplaceGroup(-1653393527);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@2171L53,67@2088L235");
                    boolean checked3 = props.getChecked();
                    boolean z5 = !props.getDisabled();
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                    boolean z6 = (i3 & 896) == 256;
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonViewKt.ToggleButtonContent$lambda$3$lambda$2(onCheckedChange, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    IconButtonKt.FilledIconToggleButton(checked3, (Function1<? super Boolean, Unit>) objRememberedValue3, modifierApplyModifiers, z5, (Shape) null, (IconToggleButtonColors) null, (MutableInteractionSource) null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 12582912, 112);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1652860172);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "90@2854L20,87@2697L53,85@2624L288");
                    boolean checked4 = props.getChecked();
                    boolean z7 = !props.getDisabled();
                    ToggleButtonColors toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, ToggleButtonDefaults.$stable);
                    composerStartRestartGroup.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z) {
                        objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonViewKt.ToggleButtonContent$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonViewKt.ToggleButtonContent$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ToggleButtonKt.ToggleButton(checked4, (Function1) objRememberedValue, modifierApplyModifiers, z7, null, toggleButtonColors2, null, null, null, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 0, 6, 976);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                }
            } else if (variant.equals("outlinedIcon")) {
                composerStartRestartGroup.startReplaceGroup(-1653123641);
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@2445L53,76@2360L237");
                boolean checked5 = props.getChecked();
                boolean z8 = !props.getDisabled();
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                boolean z9 = (i3 & 896) == 256;
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z9 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonViewKt.ToggleButtonContent$lambda$5$lambda$4(onCheckedChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                IconButtonKt.OutlinedIconToggleButton(checked5, (Function1<? super Boolean, Unit>) objRememberedValue4, modifierApplyModifiers, z8, (Shape) null, (IconToggleButtonColors) null, (BorderStroke) null, (MutableInteractionSource) null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 100663296, PsExtractor.VIDEO_STREAM_MASK);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1652860172);
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@2854L20,87@2697L53,85@2624L288");
                boolean checked6 = props.getChecked();
                boolean z10 = !props.getDisabled();
                ToggleButtonColors toggleButtonColors3 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, ToggleButtonDefaults.$stable);
                composerStartRestartGroup.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ToggleButtonView.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonViewKt.ToggleButtonContent$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonViewKt.ToggleButtonContent$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                ToggleButtonKt.ToggleButton(checked6, (Function1) objRememberedValue, modifierApplyModifiers, z10, null, toggleButtonColors3, null, null, null, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 0, 6, 976);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.ToggleButtonContent$lambda$8(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButtonContent$lambda$1$lambda$0(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButtonContent$lambda$3$lambda$2(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButtonContent$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButtonContent$lambda$7$lambda$6(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }
}
