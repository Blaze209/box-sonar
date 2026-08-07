package com.box.android.base.compose;

import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxSwitch.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"BoxSwitch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "BoxSwitchPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxSwitchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSwitch$lambda$0(boolean z, Function1 function1, Modifier modifier, boolean z2, int i, int i2, Composer composer, int i3) {
        BoxSwitch(z, function1, modifier, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSwitchPreview$lambda$0(int i, Composer composer, int i2) {
        BoxSwitchPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x0197  */
    /* JADX WARN: Code duplicated, block: B:58:0x019c  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    public static final void BoxSwitch(final boolean z, final Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1929602882);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSwitch)N(checked,onCheckedChange,modifier,enabled)29@960L6,30@1034L6,32@1155L6,33@1226L6,34@1286L6,35@1363L6,36@1474L6,38@1640L6,39@1748L6,40@1845L6,28@911L999,23@745L1171:BoxSwitch.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) != 1170) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                } else {
                    if (i6 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1929602882, i3, -1, "com.box.android.base.compose.BoxSwitch (BoxSwitch.kt:22)");
                    }
                    composer2 = composerStartRestartGroup;
                    SwitchKt.Switch(z, onCheckedChange, modifier4, null, z5, SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, 384, (SwitchDefaults.$stable << 18) | 6, 34952), null, composerStartRestartGroup, (i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i3 << 3) & 57344), 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxSwitchKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSwitchKt.BoxSwitch$lambda$0(z, onCheckedChange, modifier3, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            if ((i3 & 1171) != 1170) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
            } else {
                if (i6 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1929602882, i3, -1, "com.box.android.base.compose.BoxSwitch (BoxSwitch.kt:22)");
                }
                composer2 = composerStartRestartGroup;
                SwitchKt.Switch(z, onCheckedChange, modifier4, null, z5, SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, 384, (SwitchDefaults.$stable << 18) | 6, 34952), null, composerStartRestartGroup, (i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i3 << 3) & 57344), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxSwitchKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSwitchKt.BoxSwitch$lambda$0(z, onCheckedChange, modifier3, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
            } else {
                if (i6 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1929602882, i3, -1, "com.box.android.base.compose.BoxSwitch (BoxSwitch.kt:22)");
                }
                composer2 = composerStartRestartGroup;
                SwitchKt.Switch(z, onCheckedChange, modifier4, null, z5, SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, 384, (SwitchDefaults.$stable << 18) | 6, 34952), null, composerStartRestartGroup, (i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i3 << 3) & 57344), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxSwitchKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSwitchKt.BoxSwitch$lambda$0(z, onCheckedChange, modifier3, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        if ((i3 & 1171) != 1170) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
        } else {
            if (i6 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1929602882, i3, -1, "com.box.android.base.compose.BoxSwitch (BoxSwitch.kt:22)");
            }
            composer2 = composerStartRestartGroup;
            SwitchKt.Switch(z, onCheckedChange, modifier4, null, z5, SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11535getMainActiveControlContent0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), 0L, composer2, 384, (SwitchDefaults.$stable << 18) | 6, 34952), null, composerStartRestartGroup, (i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | ((i3 << 3) & 57344), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxSwitchKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSwitchKt.BoxSwitch$lambda$0(z, onCheckedChange, modifier3, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxSwitchPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1621823854);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSwitchPreview)50@2040L399:BoxSwitch.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1621823854, i, -1, "com.box.android.base.compose.BoxSwitchPreview (BoxSwitch.kt:49)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxSwitchKt.INSTANCE.getLambda$1853661597$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxSwitchKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSwitchKt.BoxSwitchPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
