package com.box.android.base.compose.popup;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MenuDefaults;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxPopupMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"BoxPopupMenu", "", "expanded", "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "menuItems", "", "Lcom/box/android/base/compose/popup/model/PopupMenuItem;", "modifier", "Landroidx/compose/ui/Modifier;", "width", "Landroidx/compose/ui/unit/Dp;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "BoxPopupMenu-UTokNlU", "(ZLkotlin/jvm/functions/Function0;Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/unit/Dp;JLandroidx/compose/runtime/Composer;II)V", "BoxPopupMenuItems", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "toPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;", "(Lcom/box/android/base/compose/popup/model/PopupMenuItem$IconResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "PopupMenuPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease", "expandedStart", "expandedEnd"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxPopupMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenuItems$lambda$1(List list, int i, Composer composer, int i2) {
        BoxPopupMenuItems(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenu_UTokNlU$lambda$2(boolean z, Function0 function0, List list, Modifier modifier, Dp dp, long j, int i, int i2, Composer composer, int i3) {
        m11733BoxPopupMenuUTokNlU(z, function0, list, modifier, dp, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupMenuPreview$lambda$8(int i, Composer composer, int i2) {
        PopupMenuPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:84:0x0100  */
    /* JADX WARN: Code duplicated, block: B:85:0x010e  */
    /* JADX WARN: Code duplicated, block: B:88:0x011e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x0134  */
    /* JADX WARN: Code duplicated, block: B:95:0x018c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0195  */
    /* JADX INFO: renamed from: BoxPopupMenu-UTokNlU, reason: not valid java name */
    public static final void m11733BoxPopupMenuUTokNlU(final boolean z, final Function0<Unit> onDismiss, final List<PopupMenuItem> menuItems, Modifier modifier, Dp dp, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Dp dp2;
        long jM9758getZeroRKDOV3M;
        boolean z2;
        final Modifier modifier3;
        final Dp dp3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Dp dpM9685boximpl;
        int i4;
        Modifier modifier4;
        Dp dp4;
        Modifier.Companion companionM1271width3ABfNKs;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1229012822);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxPopupMenu)N(expanded,onDismiss,menuItems,modifier,width:c#ui.unit.Dp,offset:c#ui.unit.DpOffset)62@2635L6,64@2689L44,56@2384L349:BoxPopupMenu.kt#ro1tcy");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(menuItems) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    dp2 = dp;
                    int i6 = composerStartRestartGroup.changed(dp2) ? 16384 : 8192;
                    i3 |= i6;
                } else {
                    dp2 = dp;
                }
                i3 |= i6;
            } else {
                dp2 = dp;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM9758getZeroRKDOV3M = j;
                    int i7 = composerStartRestartGroup.changed(jM9758getZeroRKDOV3M) ? 131072 : 65536;
                    i3 |= i7;
                } else {
                    jM9758getZeroRKDOV3M = j;
                }
                i3 |= i7;
            } else {
                jM9758getZeroRKDOV3M = j;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        dpM9685boximpl = Dp.m9685boximpl(BoxPopupMenuDefaults.INSTANCE.m11730getDefaultWidthD9Ej5fM());
                        i3 &= -57345;
                    } else {
                        dpM9685boximpl = dp2;
                    }
                    if ((i2 & 32) != 0) {
                        Modifier modifier5 = companion;
                        i4 = i3 & (-458753);
                        modifier4 = modifier5;
                        dp4 = dpM9685boximpl;
                        jM9758getZeroRKDOV3M = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                    } else {
                        Modifier modifier6 = companion;
                        i4 = i3;
                        modifier4 = modifier6;
                        dp4 = dpM9685boximpl;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    i4 = i3;
                    modifier4 = modifier2;
                    dp4 = dp2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1229012822, i4, -1, "com.box.android.base.compose.popup.BoxPopupMenu (BoxPopupMenu.kt:55)");
                }
                if (dp4 != null) {
                    companionM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, dp4.m9701unboximpl());
                    if (companionM1271width3ABfNKs == null) {
                        companionM1271width3ABfNKs = Modifier.INSTANCE;
                    }
                } else {
                    companionM1271width3ABfNKs = Modifier.INSTANCE;
                }
                Modifier modifier7 = modifier4;
                long j3 = jM9758getZeroRKDOV3M;
                AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(z, onDismiss, modifier4.then(companionM1271width3ABfNKs), j3, null, null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(4)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1669898575, true, new Function3() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxPopupMenuKt.BoxPopupMenu_UTokNlU$lambda$1(menuItems, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 126) | ((i4 >> 6) & 7168), 48, 1840);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                dp3 = dp4;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                dp3 = dp2;
                j2 = jM9758getZeroRKDOV3M;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPopupMenuKt.BoxPopupMenu_UTokNlU$lambda$2(z, onDismiss, menuItems, modifier3, dp3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                dp2 = dp;
                if (composerStartRestartGroup.changed(dp2)) {
                }
                i3 |= i6;
            } else {
                dp2 = dp;
            }
            i3 |= i6;
        } else {
            dp2 = dp;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                jM9758getZeroRKDOV3M = j;
                if (composerStartRestartGroup.changed(jM9758getZeroRKDOV3M)) {
                }
                i3 |= i7;
            } else {
                jM9758getZeroRKDOV3M = j;
            }
            i3 |= i7;
        } else {
            jM9758getZeroRKDOV3M = j;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    dpM9685boximpl = Dp.m9685boximpl(BoxPopupMenuDefaults.INSTANCE.m11730getDefaultWidthD9Ej5fM());
                    i3 &= -57345;
                } else {
                    dpM9685boximpl = dp2;
                }
                if ((i2 & 32) != 0) {
                    Modifier modifier8 = companion;
                    i4 = i3 & (-458753);
                    modifier4 = modifier8;
                    dp4 = dpM9685boximpl;
                    jM9758getZeroRKDOV3M = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                } else {
                    Modifier modifier9 = companion;
                    i4 = i3;
                    modifier4 = modifier9;
                    dp4 = dpM9685boximpl;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    dpM9685boximpl = Dp.m9685boximpl(BoxPopupMenuDefaults.INSTANCE.m11730getDefaultWidthD9Ej5fM());
                    i3 &= -57345;
                } else {
                    dpM9685boximpl = dp2;
                }
                if ((i2 & 32) != 0) {
                    Modifier modifier10 = companion;
                    i4 = i3 & (-458753);
                    modifier4 = modifier10;
                    dp4 = dpM9685boximpl;
                    jM9758getZeroRKDOV3M = DpOffset.INSTANCE.m9758getZeroRKDOV3M();
                } else {
                    Modifier modifier11 = companion;
                    i4 = i3;
                    modifier4 = modifier11;
                    dp4 = dpM9685boximpl;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229012822, i4, -1, "com.box.android.base.compose.popup.BoxPopupMenu (BoxPopupMenu.kt:55)");
            }
            if (dp4 != null) {
                companionM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, dp4.m9701unboximpl());
                if (companionM1271width3ABfNKs == null) {
                    companionM1271width3ABfNKs = Modifier.INSTANCE;
                }
            } else {
                companionM1271width3ABfNKs = Modifier.INSTANCE;
            }
            Modifier modifier12 = modifier4;
            long j4 = jM9758getZeroRKDOV3M;
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(z, onDismiss, modifier4.then(companionM1271width3ABfNKs), j4, null, null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(4)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11542getPopupBackground0d7_KjU(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1669898575, true, new Function3() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxPopupMenuKt.BoxPopupMenu_UTokNlU$lambda$1(menuItems, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 126) | ((i4 >> 6) & 7168), 48, 1840);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j4;
            dp3 = dp4;
            modifier3 = modifier12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            dp3 = dp2;
            j2 = jM9758getZeroRKDOV3M;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPopupMenuKt.BoxPopupMenu_UTokNlU$lambda$2(z, onDismiss, menuItems, modifier3, dp3, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenu_UTokNlU$lambda$1(List list, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C65@2699L28:BoxPopupMenu.kt#ro1tcy");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1669898575, i, -1, "com.box.android.base.compose.popup.BoxPopupMenu.<anonymous> (BoxPopupMenu.kt:65)");
            }
            BoxPopupMenuItems(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void BoxPopupMenuItems(final List<PopupMenuItem> menuItems, Composer composer, final int i) {
        int i2;
        String value;
        ComposableLambda composableLambda;
        Intrinsics.checkNotNullParameter(menuItems, "menuItems");
        Composer composerStartRestartGroup = composer.startRestartGroup(1857156540);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxPopupMenuItems)N(menuItems)*104@4034L6,105@4097L6,106@4167L6,107@4237L6,108@4353L6,109@4476L6,103@3985L573,77@3102L152,76@3065L1503:BoxPopupMenu.kt#ro1tcy");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(menuItems) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = 0;
        boolean z = true;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1857156540, i2, -1, "com.box.android.base.compose.popup.BoxPopupMenuItems (BoxPopupMenu.kt:70)");
            }
            Iterator it = menuItems.iterator();
            while (it.hasNext()) {
                PopupMenuItem popupMenuItem = (PopupMenuItem) it.next();
                PopupMenuItem.TextSource text = popupMenuItem.getText();
                if (text instanceof PopupMenuItem.TextSource.Resource) {
                    composerStartRestartGroup.startReplaceGroup(968156035);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "73@2948L32");
                    value = StringResources_androidKt.stringResource(((PopupMenuItem.TextSource.Resource) text).getResId(), composerStartRestartGroup, i3);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (!(text instanceof PopupMenuItem.TextSource.Value)) {
                        composerStartRestartGroup.startReplaceGroup(968153383);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(968158984);
                    composerStartRestartGroup.endReplaceGroup();
                    value = ((PopupMenuItem.TextSource.Value) text).getValue();
                }
                PaddingValues contentPadding = popupMenuItem.getContentPadding();
                Function0<Unit> onClick = popupMenuItem.getOnClick();
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, value);
                final PopupMenuItem.IconResource leadingIcon = popupMenuItem.getLeadingIcon();
                ComposableLambda composableLambdaRememberComposableLambda = null;
                if (leadingIcon == null) {
                    composerStartRestartGroup.startReplaceGroup(-51443287);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-51443286);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*87@3467L169");
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1232947492, z, new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPopupMenuKt.BoxPopupMenuItems$lambda$0$0$0(leadingIcon, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda2;
                }
                final PopupMenuItem.IconResource trailingIcon = popupMenuItem.getTrailingIcon();
                if (trailingIcon == null) {
                    composerStartRestartGroup.startReplaceGroup(-51184375);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-51184374);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*95@3728L169");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2007918113, z, new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxPopupMenuKt.BoxPopupMenuItems$lambda$0$1$0(trailingIcon, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposableLambda composableLambda2 = composableLambdaRememberComposableLambda;
                boolean zIsEnabled = popupMenuItem.isEnabled();
                final String str = value;
                boolean z2 = z;
                Composer composer2 = composerStartRestartGroup;
                MenuItemColors menuItemColorsM3755itemColors5tl4gsc = MenuDefaults.INSTANCE.m3755itemColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composer2, MenuDefaults.$stable << 18, 0);
                composerStartRestartGroup = composer2;
                AndroidMenu_androidKt.DropdownMenuItem(ComposableLambdaKt.rememberComposableLambda(711629011, z2, new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxPopupMenuKt.BoxPopupMenuItems$lambda$0$2(str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), onClick, modifierTestTag, composableLambda, composableLambda2, zIsEnabled, menuItemColorsM3755itemColors5tl4gsc, contentPadding, null, composerStartRestartGroup, 6, 256);
                it = it;
                z = z2;
                i3 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPopupMenuKt.BoxPopupMenuItems$lambda$1(menuItems, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenuItems$lambda$0$2(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3120L120:BoxPopupMenu.kt#ro1tcy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(711629011, i, -1, "com.box.android.base.compose.popup.BoxPopupMenuItems.<anonymous>.<anonymous> (BoxPopupMenu.kt:78)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 12582912, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenuItems$lambda$0$0$0(PopupMenuItem.IconResource iconResource, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3534L11,88@3489L129:BoxPopupMenu.kt#ro1tcy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1232947492, i, -1, "com.box.android.base.compose.popup.BoxPopupMenuItems.<anonymous>.<anonymous>.<anonymous> (BoxPopupMenu.kt:88)");
            }
            IconKt.m3575Iconww6aTOc(toPainter(iconResource, composer, 0), (String) null, (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxPopupMenuItems$lambda$0$1$0(PopupMenuItem.IconResource iconResource, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C97@3795L11,96@3750L129:BoxPopupMenu.kt#ro1tcy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2007918113, i, -1, "com.box.android.base.compose.popup.BoxPopupMenuItems.<anonymous>.<anonymous>.<anonymous> (BoxPopupMenu.kt:96)");
            }
            IconKt.m3575Iconww6aTOc(toPainter(iconResource, composer, 0), (String) null, (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Painter toPainter(PopupMenuItem.IconResource iconResource, Composer composer, int i) {
        VectorPainter vectorPainterPainterResource;
        ComposerKt.sourceInformationMarkerStart(composer, -722399498, "C(toPainter):BoxPopupMenu.kt#ro1tcy");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-722399498, i, -1, "com.box.android.base.compose.popup.toPainter (BoxPopupMenu.kt:116)");
        }
        if (iconResource instanceof PopupMenuItem.IconResource.DrawableResource) {
            composer.startReplaceGroup(1558788012);
            ComposerKt.sourceInformation(composer, "117@4711L22");
            vectorPainterPainterResource = PainterResources_androidKt.painterResource(((PopupMenuItem.IconResource.DrawableResource) iconResource).getValue(), composer, 0);
            composer.endReplaceGroup();
        } else {
            if (!(iconResource instanceof PopupMenuItem.IconResource.ImageVectorResource)) {
                composer.startReplaceGroup(1558785992);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(1558790578);
            ComposerKt.sourceInformation(composer, "118@4791L28");
            VectorPainter vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(((PopupMenuItem.IconResource.ImageVectorResource) iconResource).getValue(), composer, 0);
            composer.endReplaceGroup();
            vectorPainterPainterResource = vectorPainterRememberVectorPainter;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainterPainterResource;
    }

    private static final void PopupMenuPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(32122163);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PopupMenuPreview)131@5073L34,132@5131L34,142@5434L1535,142@5425L1544:BoxPopupMenu.kt#ro1tcy");
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32122163, i, -1, "com.box.android.base.compose.popup.PopupMenuPreview (BoxPopupMenu.kt:130)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 804629205, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 804631061, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(804633020);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*136@5299L3");
            ArrayList arrayList = new ArrayList(4);
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = R.string.account_settings;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1020506323, "CC(remember):BoxPopupMenu.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                arrayList.add(new PopupMenuItem(i3, function0, Integer.valueOf(R.drawable.ic_settings_outline), (Integer) null, (PaddingValues) null, i2 % 2 == 0, 24, (DefaultConstructorMarker) null));
            }
            final ArrayList arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(669232776, true, new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPopupMenuKt.PopupMenuPreview$lambda$7(arrayList2, mutableState, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxPopupMenuKt.PopupMenuPreview$lambda$8(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PopupMenuPreview$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PopupMenuPreview$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PopupMenuPreview$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PopupMenuPreview$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupMenuPreview$lambda$7(List list, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C143@5444L758,164@6212L751:BoxPopupMenu.kt#ro1tcy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(669232776, i, -1, "com.box.android.base.compose.popup.PopupMenuPreview.<anonymous> (BoxPopupMenu.kt:143)");
            }
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getTopStart(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierWrapContentSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1208924486, "C151@5794L34,148@5589L381,158@6067L25,156@5983L209:BoxPopupMenu.kt#ro1tcy");
            ButtonItemIconResource.ImageVectorResource imageVectorResource = new ButtonItemIconResource.ImageVectorResource(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE));
            ComposerKt.sourceInformationMarkerStart(composer, 1147382212, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxPopupMenuKt.PopupMenuPreview$lambda$7$0$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, "", imageVectorResource, false, 17, null), BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6846getLightGray0d7_KjU(), null, 2, null), null, 0L, 0.0f, composer, 48, 28);
            boolean zPopupMenuPreview$lambda$1 = PopupMenuPreview$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1147390939, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxPopupMenuKt.PopupMenuPreview$lambda$7$0$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            float f = 8;
            m11733BoxPopupMenuUTokNlU(zPopupMenuPreview$lambda$1, (Function0) objRememberedValue2, list, null, null, DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) << 32)), composer, 196656, 24);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierWrapContentSize$default2 = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getTopEnd(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWrapContentSize$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1774594850, "C172@6560L30,169@6355L377,180@6866L23,177@6745L208:BoxPopupMenu.kt#ro1tcy");
            ButtonItemIconResource.ImageVectorResource imageVectorResource2 = new ButtonItemIconResource.ImageVectorResource(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE));
            ComposerKt.sourceInformationMarkerStart(composer, 2135460969, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxPopupMenuKt.PopupMenuPreview$lambda$7$1$0$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue3, "", imageVectorResource2, false, 17, null), BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m6846getLightGray0d7_KjU(), null, 2, null), null, 0L, 0.0f, composer, 48, 28);
            boolean zPopupMenuPreview$lambda$4 = PopupMenuPreview$lambda$4(mutableState2);
            long jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(-8))) << 32));
            ComposerKt.sourceInformationMarkerStart(composer, 2135470754, "CC(remember):BoxPopupMenu.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.base.compose.popup.BoxPopupMenuKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxPopupMenuKt.PopupMenuPreview$lambda$7$1$1$0(mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m11733BoxPopupMenuUTokNlU(zPopupMenuPreview$lambda$4, (Function0) objRememberedValue4, list, null, null, jM9743constructorimpl, composer, 196656, 24);
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
    public static final Unit PopupMenuPreview$lambda$7$0$0$0(MutableState mutableState) {
        PopupMenuPreview$lambda$2(mutableState, !PopupMenuPreview$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupMenuPreview$lambda$7$0$1$0(MutableState mutableState) {
        PopupMenuPreview$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupMenuPreview$lambda$7$1$0$0(MutableState mutableState) {
        PopupMenuPreview$lambda$5(mutableState, !PopupMenuPreview$lambda$4(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PopupMenuPreview$lambda$7$1$1$0(MutableState mutableState) {
        PopupMenuPreview$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }
}
