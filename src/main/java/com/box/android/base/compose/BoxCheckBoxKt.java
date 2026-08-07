package com.box.android.base.compose;

import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxCheckBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BoxCheckbox", "", "modifier", "Landroidx/compose/ui/Modifier;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "enabled", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "BoxCheckboxPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxCheckBoxKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxCheckbox$lambda$0(Modifier modifier, boolean z, Function1 function1, boolean z2, int i, int i2, Composer composer, int i3) {
        BoxCheckbox(modifier, z, function1, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxCheckboxPreview$lambda$0(int i, Composer composer, int i2) {
        BoxCheckboxPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

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
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x0145  */
    /* JADX WARN: Code duplicated, block: B:71:0x014b  */
    /* JADX WARN: Code duplicated, block: B:74:0x015a  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    public static final void BoxCheckbox(Modifier modifier, boolean z, Function1<? super Boolean, Unit> function1, boolean z2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z3;
        int i4;
        Function1<? super Boolean, Unit> function2;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        Composer composer2;
        final Modifier.Companion companion;
        final Function1<? super Boolean, Unit> function3;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        Function1<? super Boolean, Unit> function4;
        boolean z9;
        Composer composerStartRestartGroup = composer.startRestartGroup(462224438);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxCheckbox)N(modifier,checked,onCheckedChange,enabled)27@867L6,28@934L6,29@1003L6,30@1078L6,31@1173L6,26@823L409,21@624L614:BoxCheckBox.kt#vejmn0");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 1171) != 1170) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        companion = modifier2;
                        function3 = function2;
                        z6 = z4;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            function4 = null;
                        } else {
                            function4 = function2;
                        }
                        if (i6 != 0) {
                            z9 = true;
                        } else {
                            z9 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                        }
                        composer2 = composerStartRestartGroup;
                        z3 = z8;
                        Function1<? super Boolean, Unit> function5 = function4;
                        boolean z10 = z9;
                        CheckboxKt.Checkbox(z3, function5, TestTagKt.testTag(companion, "Checkbox:" + z8), z10, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function5;
                        z6 = z10;
                    }
                    z7 = z3;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z2;
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    function3 = function2;
                    z6 = z4;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i6 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                    }
                    composer2 = composerStartRestartGroup;
                    z3 = z8;
                    Function1<? super Boolean, Unit> function6 = function4;
                    boolean z11 = z9;
                    CheckboxKt.Checkbox(z3, function6, TestTagKt.testTag(companion, "Checkbox:" + z8), z11, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function6;
                    z6 = z11;
                }
                z7 = z3;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function2 = function1;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    function3 = function2;
                    z6 = z4;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i6 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                    }
                    composer2 = composerStartRestartGroup;
                    z3 = z8;
                    Function1<? super Boolean, Unit> function7 = function4;
                    boolean z12 = z9;
                    CheckboxKt.Checkbox(z3, function7, TestTagKt.testTag(companion, "Checkbox:" + z8), z12, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function7;
                    z6 = z12;
                }
                z7 = z3;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                function3 = function2;
                z6 = z4;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i6 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                }
                composer2 = composerStartRestartGroup;
                z3 = z8;
                Function1<? super Boolean, Unit> function8 = function4;
                boolean z13 = z9;
                CheckboxKt.Checkbox(z3, function8, TestTagKt.testTag(companion, "Checkbox:" + z8), z13, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function8;
                z6 = z13;
            }
            z7 = z3;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    function3 = function2;
                    z6 = z4;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (i6 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                    }
                    composer2 = composerStartRestartGroup;
                    z3 = z8;
                    Function1<? super Boolean, Unit> function9 = function4;
                    boolean z14 = z9;
                    CheckboxKt.Checkbox(z3, function9, TestTagKt.testTag(companion, "Checkbox:" + z8), z14, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function9;
                    z6 = z14;
                }
                z7 = z3;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                function3 = function2;
                z6 = z4;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i6 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                }
                composer2 = composerStartRestartGroup;
                z3 = z8;
                Function1<? super Boolean, Unit> function10 = function4;
                boolean z15 = z9;
                CheckboxKt.Checkbox(z3, function10, TestTagKt.testTag(companion, "Checkbox:" + z8), z15, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function10;
                z6 = z15;
            }
            z7 = z3;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function2 = function1;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                function3 = function2;
                z6 = z4;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (i6 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
                }
                composer2 = composerStartRestartGroup;
                z3 = z8;
                Function1<? super Boolean, Unit> function11 = function4;
                boolean z16 = z9;
                CheckboxKt.Checkbox(z3, function11, TestTagKt.testTag(companion, "Checkbox:" + z8), z16, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function11;
                z6 = z16;
            }
            z7 = z3;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        if ((i3 & 1171) != 1170) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
            function3 = function2;
            z6 = z4;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i9 != 0) {
                z8 = true;
            } else {
                z8 = z3;
            }
            if (i4 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            if (i6 != 0) {
                z9 = true;
            } else {
                z9 = z4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(462224438, i3, -1, "com.box.android.base.compose.BoxCheckbox (BoxCheckBox.kt:20)");
            }
            composer2 = composerStartRestartGroup;
            z3 = z8;
            Function1<? super Boolean, Unit> function12 = function4;
            boolean z17 = z9;
            CheckboxKt.Checkbox(z3, function12, TestTagKt.testTag(companion, "Checkbox:" + z8), z17, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11505getCheckboxCheckmarkColor0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11504getCheckboxCheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11506getCheckboxUncheckedColor0d7_KjU(), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, CheckboxDefaults.$stable << 18, 32), null, composer2, ((i3 >> 3) & 126) | (i3 & 7168), 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function12;
            z6 = z17;
        }
        z7 = z3;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxCheckBoxKt.BoxCheckbox$lambda$0(companion, z7, function3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxCheckboxPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1982840430);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxCheckboxPreview)39@1311L107:BoxCheckBox.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1982840430, i, -1, "com.box.android.base.compose.BoxCheckboxPreview (BoxCheckBox.kt:38)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxCheckBoxKt.INSTANCE.getLambda$1216444189$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxCheckBoxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxCheckBoxKt.BoxCheckboxPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
