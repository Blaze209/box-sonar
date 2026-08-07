package com.box.android.base.compose;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.semantics.BoxSemanticsProperties;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.OfflineBadgeType;
import com.box.android.base.models.SecondaryActionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BoxListViewItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0013\b\u0002\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001aG\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0003¢\u0006\u0004\b!\u0010\"\u001aE\u0010#\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0003¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020%H\u0003¢\u0006\u0002\u0010*\u001a\r\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010,¨\u0006-"}, d2 = {"BoxListViewItem", "", "listItemInfo", "Lcom/box/android/base/models/ListItemInfo;", "isEnabled", "", "isSelected", "isCheckboxEnabled", "clickActionsConfig", "Lcom/box/android/base/models/ClickActionsConfig;", "secondaryActionType", "Lcom/box/android/base/models/SecondaryActionType;", "footerDescriptionTextOverflow", "Landroidx/compose/ui/text/style/TextOverflow;", "isRedesignedVersion", "legacyDescriptionBadge", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "BoxListViewItem-XSU6r7E", "(Lcom/box/android/base/models/ListItemInfo;ZZZLcom/box/android/base/models/ClickActionsConfig;Lcom/box/android/base/models/SecondaryActionType;IZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ItemThumbnail", "thumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "offlineBadgeType", "Lcom/box/android/base/models/OfflineBadgeType;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "ItemThumbnail-cf5BqRc", "(Lcom/box/android/base/compose/ItemThumbnail;Lcom/box/android/base/models/OfflineBadgeType;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ItemNameAndDescription", "onUpdateClick", "ItemNameAndDescription-J2qo7bo", "(Lcom/box/android/base/models/ListItemInfo;ZZILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SecondaryActionButton", "contentDescription", "", "onSecondaryAction", "(Landroidx/compose/ui/Modifier;ZZLcom/box/android/base/models/SecondaryActionType;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getCheckboxContentDescription", "itemName", "(ZLjava/lang/String;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "BoxListViewItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxListViewItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxListViewItemPreview$lambda$0(int i, Composer composer, int i2) {
        BoxListViewItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxListViewItem_XSU6r7E$lambda$2(ListItemInfo listItemInfo, boolean z, boolean z2, boolean z3, ClickActionsConfig clickActionsConfig, SecondaryActionType secondaryActionType, int i, boolean z4, Function2 function2, int i2, int i3, Composer composer, int i4) {
        m11597BoxListViewItemXSU6r7E(listItemInfo, z, z2, z3, clickActionsConfig, secondaryActionType, i, z4, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemNameAndDescription_J2qo7bo$lambda$1(ListItemInfo listItemInfo, boolean z, boolean z2, int i, Modifier modifier, Function0 function0, int i2, int i3, Composer composer, int i4) {
        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z, z2, i, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemThumbnail_cf5BqRc$lambda$1(ItemThumbnail itemThumbnail, OfflineBadgeType offlineBadgeType, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m11599ItemThumbnailcf5BqRc(itemThumbnail, offlineBadgeType, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryActionButton$lambda$2(Modifier modifier, boolean z, boolean z2, SecondaryActionType secondaryActionType, String str, Function0 function0, int i, Composer composer, int i2) {
        SecondaryActionButton(modifier, z, z2, secondaryActionType, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0135  */
    /* JADX WARN: Code duplicated, block: B:103:0x0138  */
    /* JADX WARN: Code duplicated, block: B:104:0x013a  */
    /* JADX WARN: Code duplicated, block: B:106:0x013d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0142  */
    /* JADX WARN: Code duplicated, block: B:109:0x0145  */
    /* JADX WARN: Code duplicated, block: B:110:0x014c  */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0152  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x015e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0166  */
    /* JADX WARN: Code duplicated, block: B:122:0x0172  */
    /* JADX WARN: Code duplicated, block: B:123:0x018b  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:130:0x0212  */
    /* JADX WARN: Code duplicated, block: B:131:0x022c  */
    /* JADX WARN: Code duplicated, block: B:134:0x027c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0288  */
    /* JADX WARN: Code duplicated, block: B:138:0x028c  */
    /* JADX WARN: Code duplicated, block: B:141:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:143:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:144:0x030b  */
    /* JADX WARN: Code duplicated, block: B:147:0x0370  */
    /* JADX WARN: Code duplicated, block: B:150:0x037c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0380  */
    /* JADX WARN: Code duplicated, block: B:154:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:156:0x0414  */
    /* JADX WARN: Code duplicated, block: B:158:0x041c  */
    /* JADX WARN: Code duplicated, block: B:161:0x043e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0440  */
    /* JADX WARN: Code duplicated, block: B:165:0x0447  */
    /* JADX WARN: Code duplicated, block: B:167:0x044f  */
    /* JADX WARN: Code duplicated, block: B:169:0x047d  */
    /* JADX WARN: Code duplicated, block: B:172:0x054a  */
    /* JADX WARN: Code duplicated, block: B:175:0x0556  */
    /* JADX WARN: Code duplicated, block: B:176:0x055a  */
    /* JADX WARN: Code duplicated, block: B:179:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:180:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:182:0x060e  */
    /* JADX WARN: Code duplicated, block: B:184:0x06b2  */
    /* JADX WARN: Code duplicated, block: B:187:0x06be  */
    /* JADX WARN: Code duplicated, block: B:188:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:191:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:194:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:195:0x07dc  */
    /* JADX WARN: Code duplicated, block: B:199:0x090e  */
    /* JADX WARN: Code duplicated, block: B:201:0x091d  */
    /* JADX WARN: Code duplicated, block: B:204:0x0933  */
    /* JADX WARN: Code duplicated, block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:87:0x0106  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:93:0x0121  */
    /* JADX WARN: Code duplicated, block: B:94:0x0123  */
    /* JADX WARN: Code duplicated, block: B:97:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x012e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0131  */
    /* JADX INFO: renamed from: BoxListViewItem-XSU6r7E, reason: not valid java name */
    public static final void m11597BoxListViewItemXSU6r7E(final ListItemInfo listItemInfo, boolean z, boolean z2, boolean z3, final ClickActionsConfig clickActionsConfig, SecondaryActionType secondaryActionType, int i, boolean z4, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2, final int i3) {
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        int i6;
        int i7;
        boolean z7;
        int i8;
        int i9;
        SecondaryActionType secondaryActionType2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z8;
        final boolean z9;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        Composer composer2;
        final boolean z10;
        final boolean z11;
        final SecondaryActionType secondaryActionType3;
        final int i18;
        final boolean z12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z13;
        boolean z14;
        SecondaryActionType.None none;
        int iM9584getEllipsisgIe3tQ8;
        boolean z15;
        Function2<? super Composer, ? super Integer, Unit> lambda$941968644$base_generalProdRelease;
        long jM11530getItemListingContentBackground0d7_KjU;
        float f;
        long j;
        Modifier.Companion companionM1222paddingqDBjuR0$default;
        Function0<ComposeUiNode> constructor;
        RowScopeInstance rowScopeInstance;
        SecondaryActionType secondaryActionType4;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function4;
        boolean z16;
        boolean z17;
        Function0<ComposeUiNode> constructor2;
        Composer composer3;
        Function0<ComposeUiNode> constructor3;
        boolean z18;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor4;
        boolean z19;
        Object obj;
        int i20;
        int i21;
        float f2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Function0<ComposeUiNode> constructor5;
        final String checkboxContentDescription;
        boolean zChanged;
        Object objRememberedValue2;
        boolean z20;
        Object objRememberedValue3;
        int i22;
        Intrinsics.checkNotNullParameter(listItemInfo, "listItemInfo");
        Intrinsics.checkNotNullParameter(clickActionsConfig, "clickActionsConfig");
        Composer composerStartRestartGroup = composer.startRestartGroup(1245733954);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxListViewItem)N(listItemInfo,isEnabled,isSelected,isCheckboxEnabled,clickActionsConfig,secondaryActionType,footerDescriptionTextOverflow:c#ui.text.style.TextOverflow,isRedesignedVersion,legacyDescriptionBadge)76@3180L5200:BoxListViewItem.kt#vejmn0");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(listItemInfo) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i23 = i3 & 2;
        if (i23 == 0) {
            if ((i2 & 48) == 0) {
                z5 = z;
                i4 |= composerStartRestartGroup.changed(z5) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    z6 = z2;
                    if (composerStartRestartGroup.changed(z6)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 3072) == 0) {
                        z7 = z3;
                        if (composerStartRestartGroup.changed(z7)) {
                            i8 = 2048;
                        } else {
                            i8 = 1024;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & 24576) == 0) {
                        if (composerStartRestartGroup.changed(clickActionsConfig)) {
                            i22 = 16384;
                        } else {
                            i22 = 8192;
                        }
                        i4 |= i22;
                    }
                    i9 = i3 & 32;
                    if (i9 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        secondaryActionType2 = secondaryActionType;
                    } else {
                        secondaryActionType2 = secondaryActionType;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(secondaryActionType2)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i4 |= i10;
                        }
                    }
                    i11 = i3 & 64;
                    if (i11 != 0) {
                        i4 |= 1572864;
                        i12 = i;
                    } else {
                        i12 = i;
                        if ((i2 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(i12)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i4 |= i13;
                        }
                    }
                    i14 = i3 & 128;
                    if (i14 != 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z4)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i4 |= i15;
                    }
                    i16 = i3 & 256;
                    if (i16 != 0) {
                        if ((i2 & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 67108864;
                            } else {
                                i17 = 33554432;
                            }
                            i4 |= i17;
                        }
                        if ((i4 & 38347923) != 38347922) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            z9 = z4;
                            function3 = function2;
                            composer2 = composerStartRestartGroup;
                            z10 = z5;
                            z11 = z7;
                            secondaryActionType3 = secondaryActionType2;
                            i18 = i12;
                            z12 = z6;
                        } else {
                            if (i23 != 0) {
                                z13 = true;
                            } else {
                                z13 = z5;
                            }
                            if (i5 != 0) {
                                z6 = false;
                            }
                            if (i7 != 0) {
                                z14 = true;
                            } else {
                                z14 = z7;
                            }
                            if (i9 != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                            } else {
                                none = secondaryActionType2;
                            }
                            if (i11 != 0) {
                                iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                            } else {
                                iM9584getEllipsisgIe3tQ8 = i12;
                            }
                            if (i14 != 0) {
                                z15 = false;
                            } else {
                                z15 = z4;
                            }
                            if (i16 != 0) {
                                lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                            } else {
                                lambda$941968644$base_generalProdRelease = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                            }
                            if (z6) {
                                composerStartRestartGroup.startReplaceGroup(-1151691940);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                                jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1151618780);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                                jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Modifier modifierM642combinedClickablehoGz1lA$default = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                            if (z13) {
                                f = 1.0f;
                            } else {
                                f = 0.5f;
                            }
                            j = jM11530getItemListingContentBackground0d7_KjU;
                            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                            if (z15) {
                                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            } else {
                                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                            }
                            Modifier modifierThen = modifierM1222paddingqDBjuR0$default.then(companionM1222paddingqDBjuR0$default);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                            if (z15) {
                                composerStartRestartGroup.startReplaceGroup(1921646548);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                SpringSpec springSpec = (SpringSpec) objRememberedValue;
                                Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default);
                                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(constructor4);
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                                if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                                    z16 = z6;
                                    z19 = z14;
                                    obj = null;
                                    i20 = 8;
                                    i21 = -553112988;
                                    f2 = 0.0f;
                                    composerStartRestartGroup.startReplaceGroup(-577738843);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-573374849);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                                    checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                                    Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                                    zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default2, false, (Function1) objRememberedValue2, 1, null);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                                    if ((57344 & i4) == 16384) {
                                        z20 = true;
                                    } else {
                                        z20 = false;
                                    }
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!z20 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    obj = null;
                                    boolean z21 = z6;
                                    boolean z22 = z14;
                                    i20 = 8;
                                    i21 = -553112988;
                                    f2 = 0.0f;
                                    BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default, z21, (Function1) objRememberedValue3, z22, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                                    z16 = z21;
                                    z19 = z22;
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function5 = lambda$941968644$base_generalProdRelease;
                                int i24 = i21;
                                m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                                secondaryActionType4 = none;
                                composer3 = composerStartRestartGroup;
                                i19 = iM9584getEllipsisgIe3tQ8;
                                boolean z23 = z13;
                                m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z23, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                                z17 = z23;
                                Modifier modifierAnimateContentSize$default2 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                                ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default2);
                                constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, i24, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor5);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer3);
                                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                                if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                                    function4 = function5;
                                    composer3.startReplaceGroup(-733165348);
                                } else {
                                    composer3.startReplaceGroup(-727168026);
                                    ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                                    function4 = function5;
                                    IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj2, Object obj3) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composer3, 54), composer3, 1572912, 60);
                                }
                                composer3.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                                z18 = z19;
                            } else {
                                secondaryActionType4 = none;
                                i19 = iM9584getEllipsisgIe3tQ8;
                                int i25 = i4;
                                function4 = lambda$941968644$base_generalProdRelease;
                                z16 = z6;
                                boolean z24 = z14;
                                z17 = z13;
                                composerStartRestartGroup.startReplaceGroup(1924335116);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                                BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
                                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                                TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                                composer3 = composerStartRestartGroup;
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer3, companion);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composer3);
                                Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                                TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                                function4.invoke(composer3, Integer.valueOf((i25 >> 24) & 14));
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                int i26 = i25 >> 3;
                                SecondaryActionButton(Modifier.INSTANCE, z16, z24, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i26 & 896) | (i26 & 112) | 6 | ((i25 >> 6) & 7168));
                                z18 = z24;
                                composer3.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            int i27 = i19;
                            z12 = z16;
                            z10 = z17;
                            i18 = i27;
                            composer2 = composer3;
                            secondaryActionType3 = secondaryActionType4;
                            z9 = z15;
                            function3 = function4;
                            z11 = z18;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    if ((i4 & 38347923) != 38347922) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z4;
                        function3 = function2;
                        composer2 = composerStartRestartGroup;
                        z10 = z5;
                        z11 = z7;
                        secondaryActionType3 = secondaryActionType2;
                        i18 = i12;
                        z12 = z6;
                    } else {
                        if (i23 != 0) {
                            z13 = true;
                        } else {
                            z13 = z5;
                        }
                        if (i5 != 0) {
                            z6 = false;
                        }
                        if (i7 != 0) {
                            z14 = true;
                        } else {
                            z14 = z7;
                        }
                        if (i9 != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                        } else {
                            none = secondaryActionType2;
                        }
                        if (i11 != 0) {
                            iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                        } else {
                            iM9584getEllipsisgIe3tQ8 = i12;
                        }
                        if (i14 != 0) {
                            z15 = false;
                        } else {
                            z15 = z4;
                        }
                        if (i16 != 0) {
                            lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                        } else {
                            lambda$941968644$base_generalProdRelease = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                        }
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1151691940);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1151618780);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM642combinedClickablehoGz1lA$default2 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                        if (z13) {
                            f = 1.0f;
                        } else {
                            f = 0.5f;
                        }
                        j = jM11530getItemListingContentBackground0d7_KjU;
                        Modifier modifierM1222paddingqDBjuR0$default3 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default2, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                        if (z15) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        Modifier modifierThen2 = modifierM1222paddingqDBjuR0$default3.then(companionM1222paddingqDBjuR0$default);
                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                        if (z15) {
                            composerStartRestartGroup.startReplaceGroup(1921646548);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpringSpec springSpec2 = (SpringSpec) objRememberedValue;
                            Modifier modifierAnimateContentSize$default3 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec2, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default3);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor4);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                                z16 = z6;
                                z19 = z14;
                                obj = null;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                composerStartRestartGroup.startReplaceGroup(-577738843);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-573374849);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                                checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                                Modifier modifierM1222paddingqDBjuR0$default4 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                } else {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default4, false, (Function1) objRememberedValue2, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                                if ((57344 & i4) == 16384) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z20) {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                obj = null;
                                boolean z25 = z6;
                                boolean z26 = z14;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default2, z25, (Function1) objRememberedValue3, z26, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                                z16 = z25;
                                z19 = z26;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = lambda$941968644$base_generalProdRelease;
                            int i28 = i21;
                            m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                            secondaryActionType4 = none;
                            composer3 = composerStartRestartGroup;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            boolean z27 = z13;
                            m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z27, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                            z17 = z27;
                            Modifier modifierAnimateContentSize$default4 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec2, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap8 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default4);
                            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, i28, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor5);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                                function4 = function5;
                                composer3.startReplaceGroup(-733165348);
                            } else {
                                composer3.startReplaceGroup(-727168026);
                                ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                                function4 = function5;
                                IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer3, 54), composer3, 1572912, 60);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            z18 = z19;
                        } else {
                            secondaryActionType4 = none;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            int i29 = i4;
                            function4 = lambda$941968644$base_generalProdRelease;
                            z16 = z6;
                            boolean z28 = z14;
                            z17 = z13;
                            composerStartRestartGroup.startReplaceGroup(1924335116);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
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
                            Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                            composer3 = composerStartRestartGroup;
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composer3, 48);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap10 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer3, companion2);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance3.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                            function4.invoke(composer3, Integer.valueOf((i29 >> 24) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            int i210 = i29 >> 3;
                            SecondaryActionButton(Modifier.INSTANCE, z16, z28, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i210 & 896) | (i210 & 112) | 6 | ((i29 >> 6) & 7168));
                            z18 = z28;
                            composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        int i211 = i19;
                        z12 = z16;
                        z10 = z17;
                        i18 = i211;
                        composer2 = composer3;
                        secondaryActionType3 = secondaryActionType4;
                        z9 = z15;
                        function3 = function4;
                        z11 = z18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i4 |= 3072;
                z7 = z3;
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(clickActionsConfig)) {
                        i22 = 16384;
                    } else {
                        i22 = 8192;
                    }
                    i4 |= i22;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    secondaryActionType2 = secondaryActionType;
                } else {
                    secondaryActionType2 = secondaryActionType;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(secondaryActionType2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    i12 = i;
                } else {
                    i12 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 128;
                if (i14 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 256;
                if (i16 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i4 |= i17;
                    }
                    if ((i4 & 38347923) != 38347922) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z4;
                        function3 = function2;
                        composer2 = composerStartRestartGroup;
                        z10 = z5;
                        z11 = z7;
                        secondaryActionType3 = secondaryActionType2;
                        i18 = i12;
                        z12 = z6;
                    } else {
                        if (i23 != 0) {
                            z13 = true;
                        } else {
                            z13 = z5;
                        }
                        if (i5 != 0) {
                            z6 = false;
                        }
                        if (i7 != 0) {
                            z14 = true;
                        } else {
                            z14 = z7;
                        }
                        if (i9 != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                        } else {
                            none = secondaryActionType2;
                        }
                        if (i11 != 0) {
                            iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                        } else {
                            iM9584getEllipsisgIe3tQ8 = i12;
                        }
                        if (i14 != 0) {
                            z15 = false;
                        } else {
                            z15 = z4;
                        }
                        if (i16 != 0) {
                            lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                        } else {
                            lambda$941968644$base_generalProdRelease = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                        }
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1151691940);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1151618780);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM642combinedClickablehoGz1lA$default3 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                        if (z13) {
                            f = 1.0f;
                        } else {
                            f = 0.5f;
                        }
                        j = jM11530getItemListingContentBackground0d7_KjU;
                        Modifier modifierM1222paddingqDBjuR0$default5 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default3, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                        if (z15) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        Modifier modifierThen3 = modifierM1222paddingqDBjuR0$default5.then(companionM1222paddingqDBjuR0$default);
                        Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen3);
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
                        Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                        if (z15) {
                            composerStartRestartGroup.startReplaceGroup(1921646548);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpringSpec springSpec3 = (SpringSpec) objRememberedValue;
                            Modifier modifierAnimateContentSize$default5 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec3, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default5);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor4);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                                z16 = z6;
                                z19 = z14;
                                obj = null;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                composerStartRestartGroup.startReplaceGroup(-577738843);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-573374849);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                                checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                                Modifier modifierM1222paddingqDBjuR0$default6 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                } else {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default6, false, (Function1) objRememberedValue2, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                                if ((57344 & i4) == 16384) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z20) {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                obj = null;
                                boolean z29 = z6;
                                boolean z210 = z14;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default3, z29, (Function1) objRememberedValue3, z210, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                                z16 = z29;
                                z19 = z210;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = lambda$941968644$base_generalProdRelease;
                            int i212 = i21;
                            m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                            secondaryActionType4 = none;
                            composer3 = composerStartRestartGroup;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            boolean z211 = z13;
                            m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z211, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                            z17 = z211;
                            Modifier modifierAnimateContentSize$default6 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec3, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap13 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default6);
                            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, i212, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor5);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                                function4 = function5;
                                composer3.startReplaceGroup(-733165348);
                            } else {
                                composer3.startReplaceGroup(-727168026);
                                ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                                function4 = function5;
                                IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer3, 54), composer3, 1572912, 60);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            z18 = z19;
                        } else {
                            secondaryActionType4 = none;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            int i213 = i4;
                            function4 = lambda$941968644$base_generalProdRelease;
                            z16 = z6;
                            boolean z212 = z14;
                            z17 = z13;
                            composerStartRestartGroup.startReplaceGroup(1924335116);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                            Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
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
                            Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                            composer3 = composerStartRestartGroup;
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                            Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composer3, 48);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap15 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composer3, companion3);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance4.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                            function4.invoke(composer3, Integer.valueOf((i213 >> 24) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            int i214 = i213 >> 3;
                            SecondaryActionButton(Modifier.INSTANCE, z16, z212, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i214 & 896) | (i214 & 112) | 6 | ((i213 >> 6) & 7168));
                            z18 = z212;
                            composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        int i215 = i19;
                        z12 = z16;
                        z10 = z17;
                        i18 = i215;
                        composer2 = composer3;
                        secondaryActionType3 = secondaryActionType4;
                        z9 = z15;
                        function3 = function4;
                        z11 = z18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default4 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default7 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default4, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen4 = modifierM1222paddingqDBjuR0$default7.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen4);
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
                    Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec4 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default7 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec4, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default7);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl17 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl17, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl17, Integer.valueOf(iHashCode17), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl17, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl17, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default8 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default8, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z213 = z6;
                            boolean z214 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default4, z213, (Function1) objRememberedValue3, z214, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z213;
                            z19 = z214;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i216 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z215 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z215, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z215;
                        Modifier modifierAnimateContentSize$default8 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec4, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap18 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default8);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i216, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl18 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl18, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl18, Integer.valueOf(iHashCode18), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl18, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl18, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i217 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z216 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default4);
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
                        Composer composerM6062constructorimpl19 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl19, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl19, Integer.valueOf(iHashCode19), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl19, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl19, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap110 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composer3, companion4);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl110 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl110, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl110, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl110, Integer.valueOf(iHashCode110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl110, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance5.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i217 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i218 = i217 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z216, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i218 & 896) | (i218 & 112) | 6 | ((i217 >> 6) & 7168));
                        z18 = z216;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i219 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i219;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 384;
            z6 = z2;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    z7 = z3;
                    if (composerStartRestartGroup.changed(z7)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(clickActionsConfig)) {
                        i22 = 16384;
                    } else {
                        i22 = 8192;
                    }
                    i4 |= i22;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    secondaryActionType2 = secondaryActionType;
                } else {
                    secondaryActionType2 = secondaryActionType;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(secondaryActionType2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    i12 = i;
                } else {
                    i12 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 128;
                if (i14 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 256;
                if (i16 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i4 |= i17;
                    }
                    if ((i4 & 38347923) != 38347922) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z4;
                        function3 = function2;
                        composer2 = composerStartRestartGroup;
                        z10 = z5;
                        z11 = z7;
                        secondaryActionType3 = secondaryActionType2;
                        i18 = i12;
                        z12 = z6;
                    } else {
                        if (i23 != 0) {
                            z13 = true;
                        } else {
                            z13 = z5;
                        }
                        if (i5 != 0) {
                            z6 = false;
                        }
                        if (i7 != 0) {
                            z14 = true;
                        } else {
                            z14 = z7;
                        }
                        if (i9 != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                        } else {
                            none = secondaryActionType2;
                        }
                        if (i11 != 0) {
                            iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                        } else {
                            iM9584getEllipsisgIe3tQ8 = i12;
                        }
                        if (i14 != 0) {
                            z15 = false;
                        } else {
                            z15 = z4;
                        }
                        if (i16 != 0) {
                            lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                        } else {
                            lambda$941968644$base_generalProdRelease = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                        }
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1151691940);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1151618780);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM642combinedClickablehoGz1lA$default5 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                        if (z13) {
                            f = 1.0f;
                        } else {
                            f = 0.5f;
                        }
                        j = jM11530getItemListingContentBackground0d7_KjU;
                        Modifier modifierM1222paddingqDBjuR0$default9 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default5, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                        if (z15) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        Modifier modifierThen5 = modifierM1222paddingqDBjuR0$default9.then(companionM1222paddingqDBjuR0$default);
                        Alignment.Vertical centerVertically9 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically9, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen5);
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
                        Composer composerM6062constructorimpl111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl111, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111, Integer.valueOf(iHashCode111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                        if (z15) {
                            composerStartRestartGroup.startReplaceGroup(1921646548);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpringSpec springSpec5 = (SpringSpec) objRememberedValue;
                            Modifier modifierAnimateContentSize$default9 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec5, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default9);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor4);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl112, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl112, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl112, Integer.valueOf(iHashCode112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl112, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                                z16 = z6;
                                z19 = z14;
                                obj = null;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                composerStartRestartGroup.startReplaceGroup(-577738843);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-573374849);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                                checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                                Modifier modifierM1222paddingqDBjuR0$default10 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                } else {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default10, false, (Function1) objRememberedValue2, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                                if ((57344 & i4) == 16384) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z20) {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                obj = null;
                                boolean z217 = z6;
                                boolean z218 = z14;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default5, z217, (Function1) objRememberedValue3, z218, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                                z16 = z217;
                                z19 = z218;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = lambda$941968644$base_generalProdRelease;
                            int i2110 = i21;
                            m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                            secondaryActionType4 = none;
                            composer3 = composerStartRestartGroup;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            boolean z219 = z13;
                            m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z219, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                            z17 = z219;
                            Modifier modifierAnimateContentSize$default10 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec5, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap113 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default10);
                            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, i2110, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor5);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl113 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl113, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl113, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl113, Integer.valueOf(iHashCode113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl113, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                                function4 = function5;
                                composer3.startReplaceGroup(-733165348);
                            } else {
                                composer3.startReplaceGroup(-727168026);
                                ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                                function4 = function5;
                                IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer3, 54), composer3, 1572912, 60);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            z18 = z19;
                        } else {
                            secondaryActionType4 = none;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            int i2111 = i4;
                            function4 = lambda$941968644$base_generalProdRelease;
                            z16 = z6;
                            boolean z2110 = z14;
                            z17 = z13;
                            composerStartRestartGroup.startReplaceGroup(1924335116);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                            Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default5);
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
                            Composer composerM6062constructorimpl114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl114, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl114, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl114, Integer.valueOf(iHashCode114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl114, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                            composer3 = composerStartRestartGroup;
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                            Alignment.Vertical centerVertically10 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier.Companion companion5 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically10, composer3, 48);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap115 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composer3, companion5);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl115 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl115, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl115, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl115, Integer.valueOf(iHashCode115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl115, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance6.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                            function4.invoke(composer3, Integer.valueOf((i2111 >> 24) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            int i2112 = i2111 >> 3;
                            SecondaryActionButton(Modifier.INSTANCE, z16, z2110, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i2112 & 896) | (i2112 & 112) | 6 | ((i2111 >> 6) & 7168));
                            z18 = z2110;
                            composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        int i2113 = i19;
                        z12 = z16;
                        z10 = z17;
                        i18 = i2113;
                        composer2 = composer3;
                        secondaryActionType3 = secondaryActionType4;
                        z9 = z15;
                        function3 = function4;
                        z11 = z18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default6 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default11 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default6, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen6 = modifierM1222paddingqDBjuR0$default11.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically11 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically11, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen6);
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
                    Composer composerM6062constructorimpl116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl116, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl116, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl116, Integer.valueOf(iHashCode116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl116, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec6 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default11 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec6, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default11);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl117, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl117, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl117, Integer.valueOf(iHashCode117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl117, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default12 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default12, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z2111 = z6;
                            boolean z2112 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default6, z2111, (Function1) objRememberedValue3, z2112, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z2111;
                            z19 = z2112;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i2114 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z2113 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z2113, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z2113;
                        Modifier modifierAnimateContentSize$default12 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec6, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap118 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default12);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i2114, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl118 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl118, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl118, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl118, Integer.valueOf(iHashCode118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl118, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i2115 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z2114 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default6);
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
                        Composer composerM6062constructorimpl119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl119, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl119, currentCompositionLocalMap119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl119, Integer.valueOf(iHashCode119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl119, modifierMaterializeModifier119, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically12 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically12, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap1110 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composer3, companion6);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl1110 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl1110, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1110, currentCompositionLocalMap1110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1110, Integer.valueOf(iHashCode1110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1110, modifierMaterializeModifier1110, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance7.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i2115 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i2116 = i2115 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z2114, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i2116 & 896) | (i2116 & 112) | 6 | ((i2115 >> 6) & 7168));
                        z18 = z2114;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i2117 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i2117;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z7 = z3;
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changed(clickActionsConfig)) {
                    i22 = 16384;
                } else {
                    i22 = 8192;
                }
                i4 |= i22;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                secondaryActionType2 = secondaryActionType;
            } else {
                secondaryActionType2 = secondaryActionType;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(secondaryActionType2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                i12 = i;
            } else {
                i12 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 128;
            if (i14 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            i16 = i3 & 256;
            if (i16 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i4 |= i17;
                }
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default7 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default13 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default7, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen7 = modifierM1222paddingqDBjuR0$default13.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically13 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically13, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen7);
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
                    Composer composerM6062constructorimpl1111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1111, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111, currentCompositionLocalMap1111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111, Integer.valueOf(iHashCode1111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111, modifierMaterializeModifier1111, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec7 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default13 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec7, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default13);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl1112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl1112, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1112, currentCompositionLocalMap1112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1112, Integer.valueOf(iHashCode1112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1112, modifierMaterializeModifier1112, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default14 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default14, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z2115 = z6;
                            boolean z2116 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default7, z2115, (Function1) objRememberedValue3, z2116, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z2115;
                            z19 = z2116;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i2118 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z2117 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z2117, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z2117;
                        Modifier modifierAnimateContentSize$default14 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec7, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap1113 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default14);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i2118, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl1113 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl1113, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1113, currentCompositionLocalMap1113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1113, Integer.valueOf(iHashCode1113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1113, modifierMaterializeModifier1113, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i2119 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z2118 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap1114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default7);
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
                        Composer composerM6062constructorimpl1114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl1114, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1114, currentCompositionLocalMap1114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1114, Integer.valueOf(iHashCode1114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1114, modifierMaterializeModifier1114, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically14 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically14, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap1115 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1115 = ComposedModifierKt.materializeModifier(composer3, companion7);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl1115 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl1115, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1115, currentCompositionLocalMap1115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1115, Integer.valueOf(iHashCode1115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1115, modifierMaterializeModifier1115, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance8.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i2119 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i21110 = i2119 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z2118, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i21110 & 896) | (i21110 & 112) | 6 | ((i2119 >> 6) & 7168));
                        z18 = z2118;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i21111 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i21111;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i4 & 38347923) != 38347922) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z4;
                function3 = function2;
                composer2 = composerStartRestartGroup;
                z10 = z5;
                z11 = z7;
                secondaryActionType3 = secondaryActionType2;
                i18 = i12;
                z12 = z6;
            } else {
                if (i23 != 0) {
                    z13 = true;
                } else {
                    z13 = z5;
                }
                if (i5 != 0) {
                    z6 = false;
                }
                if (i7 != 0) {
                    z14 = true;
                } else {
                    z14 = z7;
                }
                if (i9 != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                } else {
                    none = secondaryActionType2;
                }
                if (i11 != 0) {
                    iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                } else {
                    iM9584getEllipsisgIe3tQ8 = i12;
                }
                if (i14 != 0) {
                    z15 = false;
                } else {
                    z15 = z4;
                }
                if (i16 != 0) {
                    lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                } else {
                    lambda$941968644$base_generalProdRelease = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                }
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-1151691940);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1151618780);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM642combinedClickablehoGz1lA$default8 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                if (z13) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                j = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifierM1222paddingqDBjuR0$default15 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default8, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                if (z15) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen8 = modifierM1222paddingqDBjuR0$default15.then(companionM1222paddingqDBjuR0$default);
                Alignment.Vertical centerVertically15 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically15, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode1116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen8);
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
                Composer composerM6062constructorimpl1116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl1116, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl1116, currentCompositionLocalMap1116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl1116, Integer.valueOf(iHashCode1116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl1116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl1116, modifierMaterializeModifier1116, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1921646548);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpringSpec springSpec8 = (SpringSpec) objRememberedValue;
                    Modifier modifierAnimateContentSize$default15 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec8, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default15);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl1117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1117, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1117, currentCompositionLocalMap1117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1117, Integer.valueOf(iHashCode1117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1117, modifierMaterializeModifier1117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                        z16 = z6;
                        z19 = z14;
                        obj = null;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-577738843);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-573374849);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                        checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                        Modifier modifierM1222paddingqDBjuR0$default16 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default16, false, (Function1) objRememberedValue2, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                        if ((57344 & i4) == 16384) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        obj = null;
                        boolean z2119 = z6;
                        boolean z21110 = z14;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default8, z2119, (Function1) objRememberedValue3, z21110, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                        z16 = z2119;
                        z19 = z21110;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = lambda$941968644$base_generalProdRelease;
                    int i21112 = i21;
                    m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                    secondaryActionType4 = none;
                    composer3 = composerStartRestartGroup;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    boolean z21111 = z13;
                    m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z21111, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                    z17 = z21111;
                    Modifier modifierAnimateContentSize$default16 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec8, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap1118 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default16);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, i21112, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor5);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl1118 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl1118, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1118, currentCompositionLocalMap1118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1118, Integer.valueOf(iHashCode1118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1118, modifierMaterializeModifier1118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                        function4 = function5;
                        composer3.startReplaceGroup(-733165348);
                    } else {
                        composer3.startReplaceGroup(-727168026);
                        ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                        function4 = function5;
                        IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer3, 54), composer3, 1572912, 60);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    z18 = z19;
                } else {
                    secondaryActionType4 = none;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    int i21113 = i4;
                    function4 = lambda$941968644$base_generalProdRelease;
                    z16 = z6;
                    boolean z21112 = z14;
                    z17 = z13;
                    composerStartRestartGroup.startReplaceGroup(1924335116);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                    BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                    Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default8);
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
                    Composer composerM6062constructorimpl1119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1119, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1119, currentCompositionLocalMap1119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1119, Integer.valueOf(iHashCode1119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1119, modifierMaterializeModifier1119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                    Alignment.Vertical centerVertically16 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically16, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap11110 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11110 = ComposedModifierKt.materializeModifier(composer3, companion8);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl11110 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl11110, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11110, currentCompositionLocalMap11110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11110, Integer.valueOf(iHashCode11110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11110, modifierMaterializeModifier11110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance9.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                    function4.invoke(composer3, Integer.valueOf((i21113 >> 24) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i21114 = i21113 >> 3;
                    SecondaryActionButton(Modifier.INSTANCE, z16, z21112, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i21114 & 896) | (i21114 & 112) | 6 | ((i21113 >> 6) & 7168));
                    z18 = z21112;
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                int i21115 = i19;
                z12 = z16;
                z10 = z17;
                i18 = i21115;
                composer2 = composer3;
                secondaryActionType3 = secondaryActionType4;
                z9 = z15;
                function3 = function4;
                z11 = z18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        z5 = z;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                z6 = z2;
                if (composerStartRestartGroup.changed(z6)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    z7 = z3;
                    if (composerStartRestartGroup.changed(z7)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                if ((i2 & 24576) == 0) {
                    if (composerStartRestartGroup.changed(clickActionsConfig)) {
                        i22 = 16384;
                    } else {
                        i22 = 8192;
                    }
                    i4 |= i22;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    secondaryActionType2 = secondaryActionType;
                } else {
                    secondaryActionType2 = secondaryActionType;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(secondaryActionType2)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    i12 = i;
                } else {
                    i12 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i12)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i4 |= i13;
                    }
                }
                i14 = i3 & 128;
                if (i14 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                i16 = i3 & 256;
                if (i16 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 67108864;
                        } else {
                            i17 = 33554432;
                        }
                        i4 |= i17;
                    }
                    if ((i4 & 38347923) != 38347922) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z4;
                        function3 = function2;
                        composer2 = composerStartRestartGroup;
                        z10 = z5;
                        z11 = z7;
                        secondaryActionType3 = secondaryActionType2;
                        i18 = i12;
                        z12 = z6;
                    } else {
                        if (i23 != 0) {
                            z13 = true;
                        } else {
                            z13 = z5;
                        }
                        if (i5 != 0) {
                            z6 = false;
                        }
                        if (i7 != 0) {
                            z14 = true;
                        } else {
                            z14 = z7;
                        }
                        if (i9 != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                        } else {
                            none = secondaryActionType2;
                        }
                        if (i11 != 0) {
                            iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                        } else {
                            iM9584getEllipsisgIe3tQ8 = i12;
                        }
                        if (i14 != 0) {
                            z15 = false;
                        } else {
                            z15 = z4;
                        }
                        if (i16 != 0) {
                            lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                        } else {
                            lambda$941968644$base_generalProdRelease = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                        }
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-1151691940);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1151618780);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM642combinedClickablehoGz1lA$default9 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                        if (z13) {
                            f = 1.0f;
                        } else {
                            f = 0.5f;
                        }
                        j = jM11530getItemListingContentBackground0d7_KjU;
                        Modifier modifierM1222paddingqDBjuR0$default17 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default9, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                        if (z15) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        Modifier modifierThen9 = modifierM1222paddingqDBjuR0$default17.then(companionM1222paddingqDBjuR0$default);
                        Alignment.Vertical centerVertically17 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy17 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically17, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen9);
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
                        Composer composerM6062constructorimpl11111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl11111, measurePolicyRowMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11111, currentCompositionLocalMap11111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11111, Integer.valueOf(iHashCode11111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11111, modifierMaterializeModifier11111, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                        if (z15) {
                            composerStartRestartGroup.startReplaceGroup(1921646548);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            SpringSpec springSpec9 = (SpringSpec) objRememberedValue;
                            Modifier modifierAnimateContentSize$default17 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec9, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode11112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap11112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier11112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default17);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor4);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl11112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl11112, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl11112, currentCompositionLocalMap11112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl11112, Integer.valueOf(iHashCode11112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl11112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl11112, modifierMaterializeModifier11112, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                                z16 = z6;
                                z19 = z14;
                                obj = null;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                composerStartRestartGroup.startReplaceGroup(-577738843);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-573374849);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                                checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                                Modifier modifierM1222paddingqDBjuR0$default18 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                } else {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default18, false, (Function1) objRememberedValue2, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                                if ((57344 & i4) == 16384) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z20) {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                obj = null;
                                boolean z21113 = z6;
                                boolean z21114 = z14;
                                i20 = 8;
                                i21 = -553112988;
                                f2 = 0.0f;
                                BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default9, z21113, (Function1) objRememberedValue3, z21114, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                                z16 = z21113;
                                z19 = z21114;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = lambda$941968644$base_generalProdRelease;
                            int i21116 = i21;
                            m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                            secondaryActionType4 = none;
                            composer3 = composerStartRestartGroup;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            boolean z21115 = z13;
                            m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z21115, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                            z17 = z21115;
                            Modifier modifierAnimateContentSize$default18 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec9, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode11113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap11113 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier11113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default18);
                            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, i21116, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor5);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl11113 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl11113, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl11113, currentCompositionLocalMap11113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl11113, Integer.valueOf(iHashCode11113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl11113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl11113, modifierMaterializeModifier11113, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                            if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                                function4 = function5;
                                composer3.startReplaceGroup(-733165348);
                            } else {
                                composer3.startReplaceGroup(-727168026);
                                ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                                function4 = function5;
                                IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer3, 54), composer3, 1572912, 60);
                            }
                            composer3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            z18 = z19;
                        } else {
                            secondaryActionType4 = none;
                            i19 = iM9584getEllipsisgIe3tQ8;
                            int i21117 = i4;
                            function4 = lambda$941968644$base_generalProdRelease;
                            z16 = z6;
                            boolean z21116 = z14;
                            z17 = z13;
                            composerStartRestartGroup.startReplaceGroup(1924335116);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                            Modifier modifierWeight$default9 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode11114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap11114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier11114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default9);
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
                            Composer composerM6062constructorimpl11114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl11114, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl11114, currentCompositionLocalMap11114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl11114, Integer.valueOf(iHashCode11114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl11114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl11114, modifierMaterializeModifier11114, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                            composer3 = composerStartRestartGroup;
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                            Alignment.Vertical centerVertically18 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier.Companion companion9 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy18 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically18, composer3, 48);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode11115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                            CompositionLocalMap currentCompositionLocalMap11115 = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier11115 = ComposedModifierKt.materializeModifier(composer3, companion9);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer composerM6062constructorimpl11115 = Updater.m6062constructorimpl(composer3);
                            Updater.m6070setimpl(composerM6062constructorimpl11115, measurePolicyRowMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl11115, currentCompositionLocalMap11115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl11115, Integer.valueOf(iHashCode11115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl11115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl11115, modifierMaterializeModifier11115, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance10.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                            function4.invoke(composer3, Integer.valueOf((i21117 >> 24) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            int i21118 = i21117 >> 3;
                            SecondaryActionButton(Modifier.INSTANCE, z16, z21116, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i21118 & 896) | (i21118 & 112) | 6 | ((i21117 >> 6) & 7168));
                            z18 = z21116;
                            composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        int i21119 = i19;
                        z12 = z16;
                        z10 = z17;
                        i18 = i21119;
                        composer2 = composer3;
                        secondaryActionType3 = secondaryActionType4;
                        z9 = z15;
                        function3 = function4;
                        z11 = z18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default10 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default19 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default10, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen10 = modifierM1222paddingqDBjuR0$default19.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically19 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy19 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically19, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen10);
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
                    Composer composerM6062constructorimpl11116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11116, measurePolicyRowMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11116, currentCompositionLocalMap11116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11116, Integer.valueOf(iHashCode11116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11116, modifierMaterializeModifier11116, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec10 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default19 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec10, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default19);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl11117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl11117, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11117, currentCompositionLocalMap11117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11117, Integer.valueOf(iHashCode11117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11117, modifierMaterializeModifier11117, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default110 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default110, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z21117 = z6;
                            boolean z21118 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default10, z21117, (Function1) objRememberedValue3, z21118, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z21117;
                            z19 = z21118;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i211110 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z21119 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z21119, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z21119;
                        Modifier modifierAnimateContentSize$default110 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec10, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap11118 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default110);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i211110, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl11118 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl11118, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11118, currentCompositionLocalMap11118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11118, Integer.valueOf(iHashCode11118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11118, modifierMaterializeModifier11118, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i211111 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z211110 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default10 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default10);
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
                        Composer composerM6062constructorimpl11119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl11119, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11119, currentCompositionLocalMap11119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11119, Integer.valueOf(iHashCode11119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11119, modifierMaterializeModifier11119, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically110 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion10 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically110, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap111110 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111110 = ComposedModifierKt.materializeModifier(composer3, companion10);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl111110 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl111110, measurePolicyRowMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111110, currentCompositionLocalMap111110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111110, Integer.valueOf(iHashCode111110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111110, modifierMaterializeModifier111110, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance11 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance11.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i211111 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i211112 = i211111 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z211110, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i211112 & 896) | (i211112 & 112) | 6 | ((i211111 >> 6) & 7168));
                        z18 = z211110;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i211113 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i211113;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z7 = z3;
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changed(clickActionsConfig)) {
                    i22 = 16384;
                } else {
                    i22 = 8192;
                }
                i4 |= i22;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                secondaryActionType2 = secondaryActionType;
            } else {
                secondaryActionType2 = secondaryActionType;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(secondaryActionType2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                i12 = i;
            } else {
                i12 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 128;
            if (i14 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            i16 = i3 & 256;
            if (i16 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i4 |= i17;
                }
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default11 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default111 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default11, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen11 = modifierM1222paddingqDBjuR0$default111.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically111 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically111, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode111111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap111111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen11);
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
                    Composer composerM6062constructorimpl111111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl111111, measurePolicyRowMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl111111, currentCompositionLocalMap111111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl111111, Integer.valueOf(iHashCode111111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl111111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl111111, modifierMaterializeModifier111111, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec11 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default111 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec11, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default111);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl111112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl111112, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111112, currentCompositionLocalMap111112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111112, Integer.valueOf(iHashCode111112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111112, modifierMaterializeModifier111112, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default112 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default112, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z211111 = z6;
                            boolean z211112 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default11, z211111, (Function1) objRememberedValue3, z211112, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z211111;
                            z19 = z211112;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i211114 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z211113 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z211113, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z211113;
                        Modifier modifierAnimateContentSize$default112 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec11, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap111113 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default112);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i211114, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl111113 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl111113, measurePolicyMaybeCachedBoxMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111113, currentCompositionLocalMap111113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111113, Integer.valueOf(iHashCode111113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111113, modifierMaterializeModifier111113, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i211115 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z211114 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default11 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default11);
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
                        Composer composerM6062constructorimpl111114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl111114, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111114, currentCompositionLocalMap111114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111114, Integer.valueOf(iHashCode111114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111114, modifierMaterializeModifier111114, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically112 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion11 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically112, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap111115 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111115 = ComposedModifierKt.materializeModifier(composer3, companion11);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl111115 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl111115, measurePolicyRowMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111115, currentCompositionLocalMap111115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111115, Integer.valueOf(iHashCode111115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111115, modifierMaterializeModifier111115, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance12 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance12.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i211115 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i211116 = i211115 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z211114, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i211116 & 896) | (i211116 & 112) | 6 | ((i211115 >> 6) & 7168));
                        z18 = z211114;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i211117 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i211117;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i4 & 38347923) != 38347922) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z4;
                function3 = function2;
                composer2 = composerStartRestartGroup;
                z10 = z5;
                z11 = z7;
                secondaryActionType3 = secondaryActionType2;
                i18 = i12;
                z12 = z6;
            } else {
                if (i23 != 0) {
                    z13 = true;
                } else {
                    z13 = z5;
                }
                if (i5 != 0) {
                    z6 = false;
                }
                if (i7 != 0) {
                    z14 = true;
                } else {
                    z14 = z7;
                }
                if (i9 != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                } else {
                    none = secondaryActionType2;
                }
                if (i11 != 0) {
                    iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                } else {
                    iM9584getEllipsisgIe3tQ8 = i12;
                }
                if (i14 != 0) {
                    z15 = false;
                } else {
                    z15 = z4;
                }
                if (i16 != 0) {
                    lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                } else {
                    lambda$941968644$base_generalProdRelease = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                }
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-1151691940);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1151618780);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM642combinedClickablehoGz1lA$default12 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                if (z13) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                j = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifierM1222paddingqDBjuR0$default113 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default12, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                if (z15) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen12 = modifierM1222paddingqDBjuR0$default113.then(companionM1222paddingqDBjuR0$default);
                Alignment.Vertical centerVertically113 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy113 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically113, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode111116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen12);
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
                Composer composerM6062constructorimpl111116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl111116, measurePolicyRowMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl111116, currentCompositionLocalMap111116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl111116, Integer.valueOf(iHashCode111116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl111116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl111116, modifierMaterializeModifier111116, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1921646548);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpringSpec springSpec12 = (SpringSpec) objRememberedValue;
                    Modifier modifierAnimateContentSize$default113 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec12, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode111117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap111117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default113);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl111117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl111117, measurePolicyMaybeCachedBoxMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl111117, currentCompositionLocalMap111117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl111117, Integer.valueOf(iHashCode111117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl111117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl111117, modifierMaterializeModifier111117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                        z16 = z6;
                        z19 = z14;
                        obj = null;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-577738843);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-573374849);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                        checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                        Modifier modifierM1222paddingqDBjuR0$default114 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default114, false, (Function1) objRememberedValue2, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                        if ((57344 & i4) == 16384) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        obj = null;
                        boolean z211115 = z6;
                        boolean z211116 = z14;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default12, z211115, (Function1) objRememberedValue3, z211116, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                        z16 = z211115;
                        z19 = z211116;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = lambda$941968644$base_generalProdRelease;
                    int i211118 = i21;
                    m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                    secondaryActionType4 = none;
                    composer3 = composerStartRestartGroup;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    boolean z211117 = z13;
                    m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z211117, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                    z17 = z211117;
                    Modifier modifierAnimateContentSize$default114 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec12, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode111118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap111118 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default114);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, i211118, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor5);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl111118 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl111118, measurePolicyMaybeCachedBoxMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl111118, currentCompositionLocalMap111118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl111118, Integer.valueOf(iHashCode111118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl111118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl111118, modifierMaterializeModifier111118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                        function4 = function5;
                        composer3.startReplaceGroup(-733165348);
                    } else {
                        composer3.startReplaceGroup(-727168026);
                        ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                        function4 = function5;
                        IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer3, 54), composer3, 1572912, 60);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    z18 = z19;
                } else {
                    secondaryActionType4 = none;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    int i211119 = i4;
                    function4 = lambda$941968644$base_generalProdRelease;
                    z16 = z6;
                    boolean z211118 = z14;
                    z17 = z13;
                    composerStartRestartGroup.startReplaceGroup(1924335116);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                    BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                    Modifier modifierWeight$default12 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode111119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap111119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default12);
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
                    Composer composerM6062constructorimpl111119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl111119, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl111119, currentCompositionLocalMap111119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl111119, Integer.valueOf(iHashCode111119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl111119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl111119, modifierMaterializeModifier111119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                    Alignment.Vertical centerVertically114 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier.Companion companion12 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy114 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically114, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap1111110 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111110 = ComposedModifierKt.materializeModifier(composer3, companion12);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl1111110 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl1111110, measurePolicyRowMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111110, currentCompositionLocalMap1111110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111110, Integer.valueOf(iHashCode1111110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111110, modifierMaterializeModifier1111110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance13 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance13.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                    function4.invoke(composer3, Integer.valueOf((i211119 >> 24) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i2111110 = i211119 >> 3;
                    SecondaryActionButton(Modifier.INSTANCE, z16, z211118, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i2111110 & 896) | (i2111110 & 112) | 6 | ((i211119 >> 6) & 7168));
                    z18 = z211118;
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                int i2111111 = i19;
                z12 = z16;
                z10 = z17;
                i18 = i2111111;
                composer2 = composer3;
                secondaryActionType3 = secondaryActionType4;
                z9 = z15;
                function3 = function4;
                z11 = z18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        z6 = z2;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 3072) == 0) {
                z7 = z3;
                if (composerStartRestartGroup.changed(z7)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i4 |= i8;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changed(clickActionsConfig)) {
                    i22 = 16384;
                } else {
                    i22 = 8192;
                }
                i4 |= i22;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                secondaryActionType2 = secondaryActionType;
            } else {
                secondaryActionType2 = secondaryActionType;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(secondaryActionType2)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                i12 = i;
            } else {
                i12 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i12)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i4 |= i13;
                }
            }
            i14 = i3 & 128;
            if (i14 != 0) {
                i4 |= 12582912;
            } else if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            i16 = i3 & 256;
            if (i16 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 67108864;
                    } else {
                        i17 = 33554432;
                    }
                    i4 |= i17;
                }
                if ((i4 & 38347923) != 38347922) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z4;
                    function3 = function2;
                    composer2 = composerStartRestartGroup;
                    z10 = z5;
                    z11 = z7;
                    secondaryActionType3 = secondaryActionType2;
                    i18 = i12;
                    z12 = z6;
                } else {
                    if (i23 != 0) {
                        z13 = true;
                    } else {
                        z13 = z5;
                    }
                    if (i5 != 0) {
                        z6 = false;
                    }
                    if (i7 != 0) {
                        z14 = true;
                    } else {
                        z14 = z7;
                    }
                    if (i9 != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                    } else {
                        none = secondaryActionType2;
                    }
                    if (i11 != 0) {
                        iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                    } else {
                        iM9584getEllipsisgIe3tQ8 = i12;
                    }
                    if (i14 != 0) {
                        z15 = false;
                    } else {
                        z15 = z4;
                    }
                    if (i16 != 0) {
                        lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                    } else {
                        lambda$941968644$base_generalProdRelease = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                    }
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-1151691940);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1151618780);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default13 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                    if (z13) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    j = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifierM1222paddingqDBjuR0$default115 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default13, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                    if (z15) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen13 = modifierM1222paddingqDBjuR0$default115.then(companionM1222paddingqDBjuR0$default);
                    Alignment.Vertical centerVertically115 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy115 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically115, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1111111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen13);
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
                    Composer composerM6062constructorimpl1111111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1111111, measurePolicyRowMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111111, currentCompositionLocalMap1111111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111111, Integer.valueOf(iHashCode1111111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111111, modifierMaterializeModifier1111111, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                    if (z15) {
                        composerStartRestartGroup.startReplaceGroup(1921646548);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpringSpec springSpec13 = (SpringSpec) objRememberedValue;
                        Modifier modifierAnimateContentSize$default115 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec13, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1111112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap1111112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1111112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default115);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl1111112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl1111112, measurePolicyMaybeCachedBoxMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1111112, currentCompositionLocalMap1111112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1111112, Integer.valueOf(iHashCode1111112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1111112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1111112, modifierMaterializeModifier1111112, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                            z16 = z6;
                            z19 = z14;
                            obj = null;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            composerStartRestartGroup.startReplaceGroup(-577738843);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-573374849);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                            checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                            Modifier modifierM1222paddingqDBjuR0$default116 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default116, false, (Function1) objRememberedValue2, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                            if ((57344 & i4) == 16384) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            obj = null;
                            boolean z211119 = z6;
                            boolean z2111110 = z14;
                            i20 = 8;
                            i21 = -553112988;
                            f2 = 0.0f;
                            BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default13, z211119, (Function1) objRememberedValue3, z2111110, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                            z16 = z211119;
                            z19 = z2111110;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = lambda$941968644$base_generalProdRelease;
                        int i2111112 = i21;
                        m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                        secondaryActionType4 = none;
                        composer3 = composerStartRestartGroup;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        boolean z2111111 = z13;
                        m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z2111111, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                        z17 = z2111111;
                        Modifier modifierAnimateContentSize$default116 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec13, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1111113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap1111113 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1111113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default116);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, i2111112, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor5);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl1111113 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl1111113, measurePolicyMaybeCachedBoxMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1111113, currentCompositionLocalMap1111113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1111113, Integer.valueOf(iHashCode1111113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1111113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1111113, modifierMaterializeModifier1111113, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                        if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                            function4 = function5;
                            composer3.startReplaceGroup(-733165348);
                        } else {
                            composer3.startReplaceGroup(-727168026);
                            ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                            function4 = function5;
                            IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer3, 54), composer3, 1572912, 60);
                        }
                        composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        z18 = z19;
                    } else {
                        secondaryActionType4 = none;
                        i19 = iM9584getEllipsisgIe3tQ8;
                        int i2111113 = i4;
                        function4 = lambda$941968644$base_generalProdRelease;
                        z16 = z6;
                        boolean z2111112 = z14;
                        z17 = z13;
                        composerStartRestartGroup.startReplaceGroup(1924335116);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                        Modifier modifierWeight$default13 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1111114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap1111114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1111114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default13);
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
                        Composer composerM6062constructorimpl1111114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl1111114, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1111114, currentCompositionLocalMap1111114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1111114, Integer.valueOf(iHashCode1111114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1111114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1111114, modifierMaterializeModifier1111114, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                        Alignment.Vertical centerVertically116 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Modifier.Companion companion13 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy116 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically116, composer3, 48);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode1111115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                        CompositionLocalMap currentCompositionLocalMap1111115 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier1111115 = ComposedModifierKt.materializeModifier(composer3, companion13);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM6062constructorimpl1111115 = Updater.m6062constructorimpl(composer3);
                        Updater.m6070setimpl(composerM6062constructorimpl1111115, measurePolicyRowMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl1111115, currentCompositionLocalMap1111115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl1111115, Integer.valueOf(iHashCode1111115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl1111115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl1111115, modifierMaterializeModifier1111115, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance14 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance14.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                        function4.invoke(composer3, Integer.valueOf((i2111113 >> 24) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i2111114 = i2111113 >> 3;
                        SecondaryActionButton(Modifier.INSTANCE, z16, z2111112, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i2111114 & 896) | (i2111114 & 112) | 6 | ((i2111113 >> 6) & 7168));
                        z18 = z2111112;
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    int i2111115 = i19;
                    z12 = z16;
                    z10 = z17;
                    i18 = i2111115;
                    composer2 = composer3;
                    secondaryActionType3 = secondaryActionType4;
                    z9 = z15;
                    function3 = function4;
                    z11 = z18;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i4 & 38347923) != 38347922) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z4;
                function3 = function2;
                composer2 = composerStartRestartGroup;
                z10 = z5;
                z11 = z7;
                secondaryActionType3 = secondaryActionType2;
                i18 = i12;
                z12 = z6;
            } else {
                if (i23 != 0) {
                    z13 = true;
                } else {
                    z13 = z5;
                }
                if (i5 != 0) {
                    z6 = false;
                }
                if (i7 != 0) {
                    z14 = true;
                } else {
                    z14 = z7;
                }
                if (i9 != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                } else {
                    none = secondaryActionType2;
                }
                if (i11 != 0) {
                    iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                } else {
                    iM9584getEllipsisgIe3tQ8 = i12;
                }
                if (i14 != 0) {
                    z15 = false;
                } else {
                    z15 = z4;
                }
                if (i16 != 0) {
                    lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                } else {
                    lambda$941968644$base_generalProdRelease = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                }
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-1151691940);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1151618780);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM642combinedClickablehoGz1lA$default14 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                if (z13) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                j = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifierM1222paddingqDBjuR0$default117 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default14, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                if (z15) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen14 = modifierM1222paddingqDBjuR0$default117.then(companionM1222paddingqDBjuR0$default);
                Alignment.Vertical centerVertically117 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy117 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically117, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode1111116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1111116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1111116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen14);
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
                Composer composerM6062constructorimpl1111116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl1111116, measurePolicyRowMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl1111116, currentCompositionLocalMap1111116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl1111116, Integer.valueOf(iHashCode1111116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl1111116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl1111116, modifierMaterializeModifier1111116, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1921646548);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpringSpec springSpec14 = (SpringSpec) objRememberedValue;
                    Modifier modifierAnimateContentSize$default117 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec14, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1111117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default117);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl1111117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1111117, measurePolicyMaybeCachedBoxMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111117, currentCompositionLocalMap1111117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111117, Integer.valueOf(iHashCode1111117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111117, modifierMaterializeModifier1111117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                        z16 = z6;
                        z19 = z14;
                        obj = null;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-577738843);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-573374849);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                        checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                        Modifier modifierM1222paddingqDBjuR0$default118 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default118, false, (Function1) objRememberedValue2, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                        if ((57344 & i4) == 16384) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        obj = null;
                        boolean z2111113 = z6;
                        boolean z2111114 = z14;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default14, z2111113, (Function1) objRememberedValue3, z2111114, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                        z16 = z2111113;
                        z19 = z2111114;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = lambda$941968644$base_generalProdRelease;
                    int i2111116 = i21;
                    m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                    secondaryActionType4 = none;
                    composer3 = composerStartRestartGroup;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    boolean z2111115 = z13;
                    m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z2111115, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                    z17 = z2111115;
                    Modifier modifierAnimateContentSize$default118 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec14, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap1111118 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default118);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, i2111116, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor5);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl1111118 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl1111118, measurePolicyMaybeCachedBoxMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111118, currentCompositionLocalMap1111118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111118, Integer.valueOf(iHashCode1111118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111118, modifierMaterializeModifier1111118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                        function4 = function5;
                        composer3.startReplaceGroup(-733165348);
                    } else {
                        composer3.startReplaceGroup(-727168026);
                        ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                        function4 = function5;
                        IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer3, 54), composer3, 1572912, 60);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    z18 = z19;
                } else {
                    secondaryActionType4 = none;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    int i2111117 = i4;
                    function4 = lambda$941968644$base_generalProdRelease;
                    z16 = z6;
                    boolean z2111116 = z14;
                    z17 = z13;
                    composerStartRestartGroup.startReplaceGroup(1924335116);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                    BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                    Modifier modifierWeight$default14 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode1111119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap1111119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1111119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default14);
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
                    Composer composerM6062constructorimpl1111119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl1111119, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl1111119, currentCompositionLocalMap1111119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl1111119, Integer.valueOf(iHashCode1111119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl1111119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl1111119, modifierMaterializeModifier1111119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                    Alignment.Vertical centerVertically118 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier.Companion companion14 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy118 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically118, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11111110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap11111110 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11111110 = ComposedModifierKt.materializeModifier(composer3, companion14);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl11111110 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl11111110, measurePolicyRowMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11111110, currentCompositionLocalMap11111110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11111110, Integer.valueOf(iHashCode11111110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11111110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11111110, modifierMaterializeModifier11111110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance15 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance15.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                    function4.invoke(composer3, Integer.valueOf((i2111117 >> 24) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i2111118 = i2111117 >> 3;
                    SecondaryActionButton(Modifier.INSTANCE, z16, z2111116, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i2111118 & 896) | (i2111118 & 112) | 6 | ((i2111117 >> 6) & 7168));
                    z18 = z2111116;
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                int i2111119 = i19;
                z12 = z16;
                z10 = z17;
                i18 = i2111119;
                composer2 = composer3;
                secondaryActionType3 = secondaryActionType4;
                z9 = z15;
                function3 = function4;
                z11 = z18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z7 = z3;
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changed(clickActionsConfig)) {
                i22 = 16384;
            } else {
                i22 = 8192;
            }
            i4 |= i22;
        }
        i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            secondaryActionType2 = secondaryActionType;
        } else {
            secondaryActionType2 = secondaryActionType;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(secondaryActionType2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
            i12 = i;
        } else {
            i12 = i;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i12)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i4 |= i13;
            }
        }
        i14 = i3 & 128;
        if (i14 != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z4)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i4 |= i15;
        }
        i16 = i3 & 256;
        if (i16 != 0) {
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 67108864;
                } else {
                    i17 = 33554432;
                }
                i4 |= i17;
            }
            if ((i4 & 38347923) != 38347922) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z4;
                function3 = function2;
                composer2 = composerStartRestartGroup;
                z10 = z5;
                z11 = z7;
                secondaryActionType3 = secondaryActionType2;
                i18 = i12;
                z12 = z6;
            } else {
                if (i23 != 0) {
                    z13 = true;
                } else {
                    z13 = z5;
                }
                if (i5 != 0) {
                    z6 = false;
                }
                if (i7 != 0) {
                    z14 = true;
                } else {
                    z14 = z7;
                }
                if (i9 != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                } else {
                    none = secondaryActionType2;
                }
                if (i11 != 0) {
                    iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
                } else {
                    iM9584getEllipsisgIe3tQ8 = i12;
                }
                if (i14 != 0) {
                    z15 = false;
                } else {
                    z15 = z4;
                }
                if (i16 != 0) {
                    lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
                } else {
                    lambda$941968644$base_generalProdRelease = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
                }
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-1151691940);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1151618780);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM642combinedClickablehoGz1lA$default15 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
                if (z13) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                j = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifierM1222paddingqDBjuR0$default119 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default15, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
                if (z15) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen15 = modifierM1222paddingqDBjuR0$default119.then(companionM1222paddingqDBjuR0$default);
                Alignment.Vertical centerVertically119 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy119 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically119, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11111111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11111111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11111111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen15);
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
                Composer composerM6062constructorimpl11111111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl11111111, measurePolicyRowMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11111111, currentCompositionLocalMap11111111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11111111, Integer.valueOf(iHashCode11111111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11111111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11111111, modifierMaterializeModifier11111111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
                if (z15) {
                    composerStartRestartGroup.startReplaceGroup(1921646548);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpringSpec springSpec15 = (SpringSpec) objRememberedValue;
                    Modifier modifierAnimateContentSize$default119 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec15, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11111112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11111112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11111112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default119);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl11111112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11111112, measurePolicyMaybeCachedBoxMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11111112, currentCompositionLocalMap11111112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11111112, Integer.valueOf(iHashCode11111112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11111112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11111112, modifierMaterializeModifier11111112, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                        z16 = z6;
                        z19 = z14;
                        obj = null;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        composerStartRestartGroup.startReplaceGroup(-577738843);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-573374849);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                        checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                        Modifier modifierM1222paddingqDBjuR0$default1110 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default1110, false, (Function1) objRememberedValue2, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                        if ((57344 & i4) == 16384) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        obj = null;
                        boolean z2111117 = z6;
                        boolean z2111118 = z14;
                        i20 = 8;
                        i21 = -553112988;
                        f2 = 0.0f;
                        BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default15, z2111117, (Function1) objRememberedValue3, z2111118, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                        z16 = z2111117;
                        z19 = z2111118;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = lambda$941968644$base_generalProdRelease;
                    int i21111110 = i21;
                    m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                    secondaryActionType4 = none;
                    composer3 = composerStartRestartGroup;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    boolean z2111119 = z13;
                    m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z2111119, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                    z17 = z2111119;
                    Modifier modifierAnimateContentSize$default1110 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec15, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11111113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap11111113 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11111113 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default1110);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, i21111110, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor5);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl11111113 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl11111113, measurePolicyMaybeCachedBoxMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11111113, currentCompositionLocalMap11111113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11111113, Integer.valueOf(iHashCode11111113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11111113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11111113, modifierMaterializeModifier11111113, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                    if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                        function4 = function5;
                        composer3.startReplaceGroup(-733165348);
                    } else {
                        composer3.startReplaceGroup(-727168026);
                        ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                        function4 = function5;
                        IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer3, 54), composer3, 1572912, 60);
                    }
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    z18 = z19;
                } else {
                    secondaryActionType4 = none;
                    i19 = iM9584getEllipsisgIe3tQ8;
                    int i21111111 = i4;
                    function4 = lambda$941968644$base_generalProdRelease;
                    z16 = z6;
                    boolean z21111110 = z14;
                    z17 = z13;
                    composerStartRestartGroup.startReplaceGroup(1924335116);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                    BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                    Modifier modifierWeight$default15 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11111114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11111114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11111114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default15);
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
                    Composer composerM6062constructorimpl11111114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl11111114, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11111114, currentCompositionLocalMap11111114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11111114, Integer.valueOf(iHashCode11111114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11111114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11111114, modifierMaterializeModifier11111114, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                    Alignment.Vertical centerVertically1110 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Modifier.Companion companion15 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy1110 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1110, composer3, 48);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11111115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap11111115 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11111115 = ComposedModifierKt.materializeModifier(composer3, companion15);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM6062constructorimpl11111115 = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl11111115, measurePolicyRowMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11111115, currentCompositionLocalMap11111115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11111115, Integer.valueOf(iHashCode11111115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11111115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11111115, modifierMaterializeModifier11111115, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance16 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance16.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                    function4.invoke(composer3, Integer.valueOf((i21111111 >> 24) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i21111112 = i21111111 >> 3;
                    SecondaryActionButton(Modifier.INSTANCE, z16, z21111110, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i21111112 & 896) | (i21111112 & 112) | 6 | ((i21111111 >> 6) & 7168));
                    z18 = z21111110;
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                int i21111113 = i19;
                z12 = z16;
                z10 = z17;
                i18 = i21111113;
                composer2 = composer3;
                secondaryActionType3 = secondaryActionType4;
                z9 = z15;
                function3 = function4;
                z11 = z18;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i4 & 38347923) != 38347922) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z8, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z9 = z4;
            function3 = function2;
            composer2 = composerStartRestartGroup;
            z10 = z5;
            z11 = z7;
            secondaryActionType3 = secondaryActionType2;
            i18 = i12;
            z12 = z6;
        } else {
            if (i23 != 0) {
                z13 = true;
            } else {
                z13 = z5;
            }
            if (i5 != 0) {
                z6 = false;
            }
            if (i7 != 0) {
                z14 = true;
            } else {
                z14 = z7;
            }
            if (i9 != 0) {
                none = SecondaryActionType.None.INSTANCE;
            } else {
                none = secondaryActionType2;
            }
            if (i11 != 0) {
                iM9584getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
            } else {
                iM9584getEllipsisgIe3tQ8 = i12;
            }
            if (i14 != 0) {
                z15 = false;
            } else {
                z15 = z4;
            }
            if (i16 != 0) {
                lambda$941968644$base_generalProdRelease = ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$941968644$base_generalProdRelease();
            } else {
                lambda$941968644$base_generalProdRelease = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1245733954, i4, -1, "com.box.android.base.compose.BoxListViewItem (BoxListViewItem.kt:69)");
            }
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(-1151691940);
                ComposerKt.sourceInformation(composerStartRestartGroup, "71@3059L6");
                jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11531getItemListingContentBackgroundSelected0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1151618780);
                ComposerKt.sourceInformation(composerStartRestartGroup, "73@3133L6");
                jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM642combinedClickablehoGz1lA$default16 = ClickableKt.m642combinedClickablehoGz1lA$default(Modifier.INSTANCE, z13, null, null, null, clickActionsConfig.getOnLongClick(), null, false, null, clickActionsConfig.getOnClick(), 238, null);
            if (z13) {
                f = 1.0f;
            } else {
                f = 0.5f;
            }
            j = jM11530getItemListingContentBackground0d7_KjU;
            Modifier modifierM1222paddingqDBjuR0$default1111 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default16, f), listItemInfo.getTestTag()), j, null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
            if (z15) {
                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
            } else {
                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            Modifier modifierThen16 = modifierM1222paddingqDBjuR0$default1111.then(companionM1222paddingqDBjuR0$default);
            Alignment.Vertical centerVertically1111 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy1111 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1111, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode11111116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap11111116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11111116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen16);
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
            Composer composerM6062constructorimpl11111116 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl11111116, measurePolicyRowMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl11111116, currentCompositionLocalMap11111116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl11111116, Integer.valueOf(iHashCode11111116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl11111116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl11111116, modifierMaterializeModifier11111116, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1921676030, "C:BoxListViewItem.kt#vejmn0");
            if (z15) {
                composerStartRestartGroup.startReplaceGroup(1921646548);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3953L64,97@4030L977,120@5021L200,126@5235L423,137@5672L966");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -215107426, "CC(remember):BoxListViewItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimationSpecKt.spring$default(0.0f, 1500.0f, null, 5, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpringSpec springSpec16 = (SpringSpec) objRememberedValue;
                Modifier modifierAnimateContentSize$default1111 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec16, Alignment.INSTANCE.getCenterStart(), null, 4, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11111117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11111117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11111117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnimateContentSize$default1111);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl11111117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl11111117, measurePolicyMaybeCachedBoxMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11111117, currentCompositionLocalMap11111117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11111117, Integer.valueOf(iHashCode11111117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11111117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11111117, modifierMaterializeModifier11111117, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -573429625, "C:BoxListViewItem.kt#vejmn0");
                if (Intrinsics.areEqual(none, SecondaryActionType.Checkbox.INSTANCE)) {
                    z16 = z6;
                    z19 = z14;
                    obj = null;
                    i20 = 8;
                    i21 = -553112988;
                    f2 = 0.0f;
                    composerStartRestartGroup.startReplaceGroup(-577738843);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-573374849);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "106@4434L60,115@4902L51,109@4616L99,107@4515L460");
                    checkboxContentDescription = getCheckboxContentDescription(z6, listItemInfo.getName(), composerStartRestartGroup, (i4 >> 6) & 14);
                    Modifier modifierM1222paddingqDBjuR0$default1112 = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059730192, "CC(remember):BoxListViewItem.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(checkboxContentDescription);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$0$0(checkboxContentDescription, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default1112, false, (Function1) objRememberedValue2, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2059721088, "CC(remember):BoxListViewItem.kt#9igjgp");
                    if ((57344 & i4) == 16384) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z20) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$1$1$0(clickActionsConfig, ((Boolean) obj2).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    obj = null;
                    boolean z21111111 = z6;
                    boolean z21111112 = z14;
                    i20 = 8;
                    i21 = -553112988;
                    f2 = 0.0f;
                    BoxCheckBoxKt.BoxCheckbox(modifierSemantics$default16, z21111111, (Function1) objRememberedValue3, z21111112, composerStartRestartGroup, (i4 & 7168) | ((i4 >> 3) & 112), 0);
                    z16 = z21111111;
                    z19 = z21111112;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function5 = lambda$941968644$base_generalProdRelease;
                int i21111114 = i21;
                m11599ItemThumbnailcf5BqRc(listItemInfo.getItemThumbnail(), listItemInfo.getOfflineBadgeType(), j, null, composerStartRestartGroup, 0, 8);
                secondaryActionType4 = none;
                composer3 = composerStartRestartGroup;
                i19 = iM9584getEllipsisgIe3tQ8;
                boolean z21111113 = z13;
                m11598ItemNameAndDescriptionJ2qo7bo(listItemInfo, z21111113, z16, i19, RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(i20), f2, 2, obj), 1.0f, false, 2, null), clickActionsConfig.getOnUpdateClick(), composer3, ((i4 >> 9) & 7168) | (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED), 0);
                z17 = z21111113;
                Modifier modifierAnimateContentSize$default1112 = AnimationModifierKt.animateContentSize$default(ClipKt.clipToBounds(Modifier.INSTANCE), springSpec16, Alignment.INSTANCE.getCenterEnd(), null, 4, null);
                ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11111118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap11111118 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11111118 = ComposedModifierKt.materializeModifier(composer3, modifierAnimateContentSize$default1112);
                constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, i21111114, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor5);
                } else {
                    composer3.useNode();
                }
                Composer composerM6062constructorimpl11111118 = Updater.m6062constructorimpl(composer3);
                Updater.m6070setimpl(composerM6062constructorimpl11111118, measurePolicyMaybeCachedBoxMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11111118, currentCompositionLocalMap11111118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11111118, Integer.valueOf(iHashCode11111118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11111118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11111118, modifierMaterializeModifier11111118, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -727229529, "C:BoxListViewItem.kt#vejmn0");
                if (Intrinsics.areEqual(secondaryActionType4, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
                    function4 = function5;
                    composer3.startReplaceGroup(-733165348);
                } else {
                    composer3.startReplaceGroup(-727168026);
                    ComposerKt.sourceInformation(composer3, "149@6235L371,146@6048L558");
                    function4 = function5;
                    IconButtonKt.IconButton(clickActionsConfig.getOnSecondaryActionClick(), TestTagKt.testTag(Modifier.INSTANCE, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1078490963, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$1$2$0(listItemInfo, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer3, 54), composer3, 1572912, 60);
                }
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
                z18 = z19;
            } else {
                secondaryActionType4 = none;
                i19 = iM9584getEllipsisgIe3tQ8;
                int i21111115 = i4;
                function4 = lambda$941968644$base_generalProdRelease;
                z16 = z6;
                boolean z21111114 = z14;
                z17 = z13;
                composerStartRestartGroup.startReplaceGroup(1924335116);
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@6668L135,163@6816L1219,197@8214L77,192@8049L315");
                BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(listItemInfo.getItemThumbnail(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                Modifier modifierWeight$default16 = RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11111119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11111119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11111119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default16);
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
                Composer composerM6062constructorimpl11111119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl11111119, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11111119, currentCompositionLocalMap11111119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11111119, Integer.valueOf(iHashCode11111119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11111119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11111119, modifierMaterializeModifier11111119, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1345884478, "C174@7289L6,168@6968L356,176@7341L29,177@7387L634:BoxListViewItem.kt#vejmn0");
                TextKt.m4494TextNvy7gAk(listItemInfo.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer3, 6);
                Alignment.Vertical centerVertically1112 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier.Companion companion16 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy1112 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically1112, composer3, 48);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode111111110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap111111110 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111111110 = ComposedModifierKt.materializeModifier(composer3, companion16);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composerM6062constructorimpl111111110 = Updater.m6062constructorimpl(composer3);
                Updater.m6070setimpl(composerM6062constructorimpl111111110, measurePolicyRowMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl111111110, currentCompositionLocalMap111111110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl111111110, Integer.valueOf(iHashCode111111110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl111111110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl111111110, modifierMaterializeModifier111111110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance17 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 736785349, "C186@7906L6,178@7461L490,188@7995L8:BoxListViewItem.kt#vejmn0");
                TextKt.m4494TextNvy7gAk(listItemInfo.getFooterDescription(), TestTagKt.testTag(rowScopeInstance17.weight(Modifier.INSTANCE, 1.0f, false), listItemInfo.getTestTag() + ":FooterDescription"), BoxTheme.INSTANCE.getColors(composer3, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer3, 0, 12607872, 110584);
                function4.invoke(composer3, Integer.valueOf((i21111115 >> 24) & 14));
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i21111116 = i21111115 >> 3;
                SecondaryActionButton(Modifier.INSTANCE, z16, z21111114, secondaryActionType4, StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer3, 0), clickActionsConfig.getOnSecondaryActionClick(), composer3, (i21111116 & 896) | (i21111116 & 112) | 6 | ((i21111115 >> 6) & 7168));
                z18 = z21111114;
                composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i21111117 = i19;
            z12 = z16;
            z10 = z17;
            i18 = i21111117;
            composer2 = composer3;
            secondaryActionType3 = secondaryActionType4;
            z9 = z15;
            function3 = function4;
            z11 = z18;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BoxListViewItemKt.BoxListViewItem_XSU6r7E$lambda$2(listItemInfo, z10, z12, z11, clickActionsConfig, secondaryActionType3, i18, z9, function3, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxListViewItem_XSU6r7E$lambda$1$1$1$0(ClickActionsConfig clickActionsConfig, boolean z) {
        clickActionsConfig.getOnSecondaryActionClick().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxListViewItem_XSU6r7E$lambda$1$1$0$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxListViewItem_XSU6r7E$lambda$1$2$0(ListItemInfo listItemInfo, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@6305L44,152@6400L77,153@6523L6,150@6261L323:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1078490963, i, -1, "com.box.android.base.compose.BoxListViewItem.<anonymous>.<anonymous>.<anonymous> (BoxListViewItem.kt:150)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_more_vertical, composer, 0), StringResources_androidKt.stringResource(R.string.browse_item_talkback_more_actions, new Object[]{listItemInfo.getName()}, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11584getTopLayerInteractiveSecondary0d7_KjU(), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:59:0x017a  */
    /* JADX WARN: Code duplicated, block: B:61:0x0191  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:66:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:69:0x0267  */
    /* JADX WARN: Code duplicated, block: B:72:0x0273  */
    /* JADX WARN: Code duplicated, block: B:73:0x0277  */
    /* JADX WARN: Code duplicated, block: B:78:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:80:0x031e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0340  */
    /* JADX WARN: Code duplicated, block: B:85:0x0346  */
    /* JADX WARN: Code duplicated, block: B:88:0x034f  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ItemThumbnail-cf5BqRc, reason: not valid java name */
    private static final void m11599ItemThumbnailcf5BqRc(final ItemThumbnail itemThumbnail, final OfflineBadgeType offlineBadgeType, final long j, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        BoxScopeInstance boxScopeInstance;
        float f;
        Pair pair;
        final int iIntValue;
        float fM9687constructorimpl;
        Function0<ComposeUiNode> constructor2;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1500020033);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemThumbnail)N(thumbnail,offlineBadgeType,backgroundColor:c#ui.graphics.Color,modifier)211@8563L1429:BoxListViewItem.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(itemThumbnail) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(offlineBadgeType) : composerStartRestartGroup.changedInstance(offlineBadgeType) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1500020033, i4, -1, "com.box.android.base.compose.ItemThumbnail (BoxListViewItem.kt:210)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier3 = companion;
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
                boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1883552208, "C212@8598L154:BoxListViewItem.kt#vejmn0");
                f = 4;
                BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(itemThumbnail, PaddingKt.m1218padding3ABfNKs(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), Dp.m9687constructorimpl(f)), 0.0f, null, null, composerStartRestartGroup, (i4 & 14) | 48, 28);
                if (!Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.None.INSTANCE)) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.startReplaceGroup(-1892125445);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1883350399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@9143L833");
                    RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                    if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.UpToDate.INSTANCE)) {
                        pair = TuplesKt.to(Color.m6804boximpl(BoxColorPalette.INSTANCE.m11385getLIGHT_GREEN_1150d7_KjU()), Integer.valueOf(R.drawable.ic_checkmark_underline));
                    } else {
                        pair = TuplesKt.to(Color.m6804boximpl(BoxColorPalette.INSTANCE.m11389getORANGE_1150d7_KjU()), Integer.valueOf(R.drawable.ic_arrows_spinning));
                    }
                    long jM6824unboximpl = ((Color) pair.component1()).m6824unboximpl();
                    iIntValue = ((Number) pair.component2()).intValue();
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    if (itemThumbnail instanceof ItemThumbnail.Icon) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(f);
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    RoundedCornerShape roundedCornerShape = circleShape;
                    float f2 = 2;
                    Modifier modifierAlign = boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1222paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, fM9687constructorimpl, 7, null), roundedCornerShape), j, null, 2, null), Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(12)), jM6824unboximpl, roundedCornerShape), Dp.m9687constructorimpl(f2)), Alignment.INSTANCE.getBottomEnd());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 847121761, "C240@9684L24,243@9851L93,239@9648L314:BoxListViewItem.kt#vejmn0");
                    Painter painterPainterResource = PainterResources_androidKt.painterResource(iIntValue, composerStartRestartGroup, 0);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1828448101, "CC(remember):BoxListViewItem.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(iIntValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxListViewItemKt.ItemThumbnail_cf5BqRc$lambda$0$0$0$0(iIntValue, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup = composerStartRestartGroup;
                    IconKt.m3575Iconww6aTOc(painterPainterResource, (String) null, SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue, 1, null), j, composerStartRestartGroup, Painter.$stable | 48 | ((i4 << 3) & 7168), 0);
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
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxListViewItemKt.ItemThumbnail_cf5BqRc$lambda$1(itemThumbnail, offlineBadgeType, j, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1500020033, i4, -1, "com.box.android.base.compose.ItemThumbnail (BoxListViewItem.kt:210)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier4 = companion;
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
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1883552208, "C212@8598L154:BoxListViewItem.kt#vejmn0");
            f = 4;
            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(itemThumbnail, PaddingKt.m1218padding3ABfNKs(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), Dp.m9687constructorimpl(f)), 0.0f, null, null, composerStartRestartGroup, (i4 & 14) | 48, 28);
            if (!Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.None.INSTANCE)) {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(-1892125445);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1883350399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@9143L833");
                RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
                if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.UpToDate.INSTANCE)) {
                    pair = TuplesKt.to(Color.m6804boximpl(BoxColorPalette.INSTANCE.m11385getLIGHT_GREEN_1150d7_KjU()), Integer.valueOf(R.drawable.ic_checkmark_underline));
                } else {
                    pair = TuplesKt.to(Color.m6804boximpl(BoxColorPalette.INSTANCE.m11389getORANGE_1150d7_KjU()), Integer.valueOf(R.drawable.ic_arrows_spinning));
                }
                long jM6824unboximpl2 = ((Color) pair.component1()).m6824unboximpl();
                iIntValue = ((Number) pair.component2()).intValue();
                Modifier.Companion companion4 = Modifier.INSTANCE;
                if (itemThumbnail instanceof ItemThumbnail.Icon) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(f);
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                RoundedCornerShape roundedCornerShape2 = circleShape2;
                float f3 = 2;
                Modifier modifierAlign2 = boxScopeInstance.align(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1222paddingqDBjuR0$default(companion4, 0.0f, 0.0f, 0.0f, fM9687constructorimpl, 7, null), roundedCornerShape2), j, null, 2, null), Dp.m9687constructorimpl(f3)), Dp.m9687constructorimpl(12)), jM6824unboximpl2, roundedCornerShape2), Dp.m9687constructorimpl(f3)), Alignment.INSTANCE.getBottomEnd());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign2);
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
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 847121761, "C240@9684L24,243@9851L93,239@9648L314:BoxListViewItem.kt#vejmn0");
                Painter painterPainterResource2 = PainterResources_androidKt.painterResource(iIntValue, composerStartRestartGroup, 0);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1828448101, "CC(remember):BoxListViewItem.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(iIntValue);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxListViewItemKt.ItemThumbnail_cf5BqRc$lambda$0$0$0$0(iIntValue, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxListViewItemKt.ItemThumbnail_cf5BqRc$lambda$0$0$0$0(iIntValue, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup = composerStartRestartGroup;
                IconKt.m3575Iconww6aTOc(painterPainterResource2, (String) null, SemanticsModifierKt.semantics$default(companion5, false, (Function1) objRememberedValue, 1, null), j, composerStartRestartGroup, Painter.$stable | 48 | ((i4 << 3) & 7168), 0);
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
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxListViewItemKt.ItemThumbnail_cf5BqRc$lambda$1(itemThumbnail, offlineBadgeType, j, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemThumbnail_cf5BqRc$lambda$0$0$0$0(int i, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        semantics.set(BoxSemanticsProperties.INSTANCE.getDrawable(), Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0477  */
    /* JADX WARN: Code duplicated, block: B:102:0x051a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0523  */
    /* JADX WARN: Code duplicated, block: B:106:0x0534  */
    /* JADX WARN: Code duplicated, block: B:108:0x059e  */
    /* JADX WARN: Code duplicated, block: B:111:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:112:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:114:0x0643  */
    /* JADX WARN: Code duplicated, block: B:117:0x0659  */
    /* JADX WARN: Code duplicated, block: B:119:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:122:0x06f4  */
    /* JADX WARN: Code duplicated, block: B:123:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:125:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:128:0x07cf  */
    /* JADX WARN: Code duplicated, block: B:130:0x0848  */
    /* JADX WARN: Code duplicated, block: B:133:0x0854  */
    /* JADX WARN: Code duplicated, block: B:134:0x0858  */
    /* JADX WARN: Code duplicated, block: B:136:0x08df  */
    /* JADX WARN: Code duplicated, block: B:138:0x08e6  */
    /* JADX WARN: Code duplicated, block: B:142:0x0919  */
    /* JADX WARN: Code duplicated, block: B:144:0x091f  */
    /* JADX WARN: Code duplicated, block: B:147:0x0929  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:73:0x0157  */
    /* JADX WARN: Code duplicated, block: B:76:0x0163  */
    /* JADX WARN: Code duplicated, block: B:77:0x0167  */
    /* JADX WARN: Code duplicated, block: B:80:0x029c  */
    /* JADX WARN: Code duplicated, block: B:83:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:84:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:87:0x0333  */
    /* JADX WARN: Code duplicated, block: B:88:0x034a  */
    /* JADX WARN: Code duplicated, block: B:91:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:93:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:96:0x0467  */
    /* JADX WARN: Code duplicated, block: B:99:0x0473  */
    /* JADX INFO: renamed from: ItemNameAndDescription-J2qo7bo, reason: not valid java name */
    private static final void m11598ItemNameAndDescriptionJ2qo7bo(ListItemInfo listItemInfo, final boolean z, final boolean z2, final int i, Modifier modifier, final Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        final ListItemInfo listItemInfo2;
        int i4;
        boolean z3;
        Modifier modifier2;
        boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        OfflineBadgeType offlineBadgeType;
        String footerDescription;
        Function0<ComposeUiNode> constructor;
        float f;
        Function0<ComposeUiNode> constructor2;
        char c;
        long jM11513getContentSecondary0d7_KjU;
        String str;
        String str2;
        int i5;
        Function0<ComposeUiNode> constructor3;
        Function0<ComposeUiNode> constructor4;
        Function0<ComposeUiNode> constructor5;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor6;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-216721279);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemNameAndDescription)N(listItemInfo,isEnabled,isSelected,footerDescriptionTextOverflow:c#ui.text.style.TextOverflow,modifier,onUpdateClick)267@10526L5794:BoxListViewItem.kt#vejmn0");
        if ((i2 & 6) == 0) {
            listItemInfo2 = listItemInfo;
            i4 = (composerStartRestartGroup.changed(listItemInfo2) ? 4 : 2) | i2;
        } else {
            listItemInfo2 = listItemInfo;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            z3 = z;
            i4 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
        } else {
            z3 = z;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        int i7 = i3 & 16;
        if (i7 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i2) != 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            if ((74899 & i4) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-216721279, i4, -1, "com.box.android.base.compose.ItemNameAndDescription (BoxListViewItem.kt:260)");
                }
                offlineBadgeType = listItemInfo2.getOfflineBadgeType();
                if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.Pending.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-2110708315);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "262@10346L36");
                    footerDescription = StringResources_androidKt.stringResource(R.string.downloading, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.OutOfDate.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-2110705905);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "263@10421L46");
                    footerDescription = StringResources_androidKt.stringResource(R.string.new_version_available, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2110703502);
                    composerStartRestartGroup.endReplaceGroup();
                    footerDescription = listItemInfo2.getFooterDescription();
                }
                float f2 = 4;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2133754366, "C277@10909L6,271@10636L300,279@10945L5369:BoxListViewItem.kt#vejmn0");
                Modifier modifier4 = companion;
                TextKt.m4494TextNvy7gAk(listItemInfo2.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo2.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
                f = 16;
                Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f2));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1254heightInVpY3zN4$default);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2025016289, "C284@11175L466:BoxListViewItem.kt#vejmn0");
                Modifier modifierTestTag = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), listItemInfo2.getTestTag() + ":FooterDescription");
                TextStyle boxNormal12 = BoxTheme.INSTANCE.getTypography().getBoxNormal12();
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-2004978381);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "292@11558L6");
                    c = 6;
                    jM11513getContentSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11514getContentSecondarySelected0d7_KjU();
                } else {
                    c = 6;
                    composerStartRestartGroup.startReplaceGroup(-2004976917);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "292@11604L6");
                    jM11513getContentSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                TextKt.m4494TextNvy7gAk(footerDescription, modifierTestTag, jM11513getContentSecondary0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, i, false, 1, 0, null, boxNormal12, composerStartRestartGroup, 0, ((i4 >> 3) & 896) | 12607488, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                if (listItemInfo2.getOfflineBadgeType() instanceof OfflineBadgeType.OutOfDate) {
                    composerStartRestartGroup.startReplaceGroup(-2024579035);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "300@11999L887,296@11738L1762");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2004963630, "CC(remember):BoxListViewItem.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function3() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return BoxListViewItemKt.ItemNameAndDescription_J2qo7bo$lambda$0$0$0$0((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierLayout = LayoutModifierKt.layout(companion2, (Function3) objRememberedValue);
                    float f3 = 8;
                    Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(modifierLayout, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3))), z3, null, null, null, function0, 14, null), "Item.UpdateButton:" + listItemInfo2.getName()), Dp.m9687constructorimpl(f3));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
                    constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor6);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725969239, "C326@13297L31,328@13436L6,325@13260L222:BoxListViewItem.kt#vejmn0");
                    TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.update, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 0, 12582912, 131066);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (!(listItemInfo2.getOfflineBadgeType() instanceof OfflineBadgeType.Pending)) {
                        composerStartRestartGroup.startReplaceGroup(-2036261881);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2022701241);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (listItemInfo2.getHasSharedLink()) {
                            str = "C72@3469L9:Box.kt#2w3rfo";
                            str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                            i5 = -2036261881;
                            composerStartRestartGroup.startReplaceGroup(-2036261881);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2022714602);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "337@13842L6,333@13656L649");
                            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
                            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor5);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001707450, "C341@14030L35,344@14227L6,340@13986L297:BoxListViewItem.kt#vejmn0");
                            str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                            str = "C72@3469L9:Box.kt#2w3rfo";
                            i5 = -2036261881;
                            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_link, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (listItemInfo2.getCommentsCount() > 0) {
                            composerStartRestartGroup.startReplaceGroup(i5);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2021964557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "354@14587L6,350@14399L1068");
                            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(3), 0.0f, 2, null);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_6 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(2));
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_6, centerVertically2, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
                            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor4);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1266807859, "C361@14999L6,359@14874L246,365@15189L38,368@15389L6,364@15145L300:BoxListViewItem.kt#vejmn0");
                            TextKt.m4494TextNvy7gAk(String.valueOf(listItemInfo2.getCommentsCount()), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxSemiBold10(), composerStartRestartGroup, 0, 12582912, 131066);
                            composerStartRestartGroup = composerStartRestartGroup;
                            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_comment, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (listItemInfo2.isInCollections()) {
                            composerStartRestartGroup.startReplaceGroup(i5);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-2020824842);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "378@15745L6,374@15559L713");
                            Modifier modifierTestTag2 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null), "CollectionsBadge");
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, str2);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor3);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, str);
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2039475803, "C383@15990L42,386@16194L6,382@15946L304:BoxListViewItem.kt#vejmn0");
                            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_collections, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxListViewItemKt.ItemNameAndDescription_J2qo7bo$lambda$1(listItemInfo2, z, z2, i, modifier3, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        if ((196608 & i2) != 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i4 |= i6;
        }
        if ((74899 & i4) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-216721279, i4, -1, "com.box.android.base.compose.ItemNameAndDescription (BoxListViewItem.kt:260)");
            }
            offlineBadgeType = listItemInfo2.getOfflineBadgeType();
            if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.Pending.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-2110708315);
                ComposerKt.sourceInformation(composerStartRestartGroup, "262@10346L36");
                footerDescription = StringResources_androidKt.stringResource(R.string.downloading, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(offlineBadgeType, OfflineBadgeType.OutOfDate.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-2110705905);
                ComposerKt.sourceInformation(composerStartRestartGroup, "263@10421L46");
                footerDescription = StringResources_androidKt.stringResource(R.string.new_version_available, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2110703502);
                composerStartRestartGroup.endReplaceGroup();
                footerDescription = listItemInfo2.getFooterDescription();
            }
            float f4 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_7 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_7, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2133754366, "C277@10909L6,271@10636L300,279@10945L5369:BoxListViewItem.kt#vejmn0");
            Modifier modifier5 = companion;
            TextKt.m4494TextNvy7gAk(listItemInfo2.getName(), TestTagKt.testTag(Modifier.INSTANCE, "Item:Name:" + listItemInfo2.getName()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12607872, 110584);
            f = 16;
            Modifier modifierM1254heightInVpY3zN4$default2 = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_8 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f4));
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_8, centerVertically3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1254heightInVpY3zN4$default2);
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
            Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2025016289, "C284@11175L466:BoxListViewItem.kt#vejmn0");
            Modifier modifierTestTag3 = TestTagKt.testTag(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), listItemInfo2.getTestTag() + ":FooterDescription");
            TextStyle boxNormal13 = BoxTheme.INSTANCE.getTypography().getBoxNormal12();
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-2004978381);
                ComposerKt.sourceInformation(composerStartRestartGroup, "292@11558L6");
                c = 6;
                jM11513getContentSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11514getContentSecondarySelected0d7_KjU();
            } else {
                c = 6;
                composerStartRestartGroup.startReplaceGroup(-2004976917);
                ComposerKt.sourceInformation(composerStartRestartGroup, "292@11604L6");
                jM11513getContentSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            TextKt.m4494TextNvy7gAk(footerDescription, modifierTestTag3, jM11513getContentSecondary0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, i, false, 1, 0, null, boxNormal13, composerStartRestartGroup, 0, ((i4 >> 3) & 896) | 12607488, 110584);
            composerStartRestartGroup = composerStartRestartGroup;
            if (listItemInfo2.getOfflineBadgeType() instanceof OfflineBadgeType.OutOfDate) {
                composerStartRestartGroup.startReplaceGroup(-2024579035);
                ComposerKt.sourceInformation(composerStartRestartGroup, "300@11999L887,296@11738L1762");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2004963630, "CC(remember):BoxListViewItem.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function3() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxListViewItemKt.ItemNameAndDescription_J2qo7bo$lambda$0$0$0$0((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierLayout2 = LayoutModifierKt.layout(companion3, (Function3) objRememberedValue);
                float f5 = 8;
                Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(modifierLayout2, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f5))), z3, null, null, null, function0, 14, null), "Item.UpdateButton:" + listItemInfo2.getName()), Dp.m9687constructorimpl(f5));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
                constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor6);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725969239, "C326@13297L31,328@13436L6,325@13260L222:BoxListViewItem.kt#vejmn0");
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.update, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 0, 12582912, 131066);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(listItemInfo2.getOfflineBadgeType() instanceof OfflineBadgeType.Pending)) {
                    composerStartRestartGroup.startReplaceGroup(-2036261881);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2022701241);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (listItemInfo2.getHasSharedLink()) {
                        str = "C72@3469L9:Box.kt#2w3rfo";
                        str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        i5 = -2036261881;
                        composerStartRestartGroup.startReplaceGroup(-2036261881);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2022714602);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "337@13842L6,333@13656L649");
                        Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
                        constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor5);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001707450, "C341@14030L35,344@14227L6,340@13986L297:BoxListViewItem.kt#vejmn0");
                        str2 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str = "C72@3469L9:Box.kt#2w3rfo";
                        i5 = -2036261881;
                        IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_link, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (listItemInfo2.getCommentsCount() > 0) {
                        composerStartRestartGroup.startReplaceGroup(i5);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2021964557);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "354@14587L6,350@14399L1068");
                        Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(3), 0.0f, 2, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_9 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(2));
                        Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_9, centerVertically4, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1266807859, "C361@14999L6,359@14874L246,365@15189L38,368@15389L6,364@15145L300:BoxListViewItem.kt#vejmn0");
                        TextKt.m4494TextNvy7gAk(String.valueOf(listItemInfo2.getCommentsCount()), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTypography.INSTANCE.getBoxSemiBold10(), composerStartRestartGroup, 0, 12582912, 131066);
                        composerStartRestartGroup = composerStartRestartGroup;
                        IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_comment, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (listItemInfo2.isInCollections()) {
                        composerStartRestartGroup.startReplaceGroup(i5);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-2020824842);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "378@15745L6,374@15559L713");
                        Modifier modifierTestTag4 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11528getItemListingBadgeBackground0d7_KjU(), null, 2, null), "CollectionsBadge");
                        Alignment center4 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, str2);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag4);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, str);
                        BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2039475803, "C383@15990L42,386@16194L6,382@15946L304:BoxListViewItem.kt#vejmn0");
                        IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_collections, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11529getItemListingBadgeContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxListViewItemKt.ItemNameAndDescription_J2qo7bo$lambda$1(listItemInfo2, z, z2, i, modifier3, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemNameAndDescription_J2qo7bo$lambda$0$0$0$0$0(Placeable placeable, float f, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, placeable, -layout.mo748roundToPx0680j_4(f), -layout.mo748roundToPx0680j_4(f), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final void SecondaryActionButton(final Modifier modifier, final boolean z, final boolean z2, final SecondaryActionType secondaryActionType, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z3;
        boolean z4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-244771193);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryActionButton)N(modifier,isSelected,isCheckboxEnabled,secondaryActionType,contentDescription,onSecondaryAction):BoxListViewItem.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
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
            z4 = z2;
            i2 |= composerStartRestartGroup.changed(z4) ? 256 : 128;
        } else {
            z4 = z2;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(secondaryActionType) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-244771193, i2, -1, "com.box.android.base.compose.SecondaryActionButton (BoxListViewItem.kt:403)");
            }
            if (secondaryActionType instanceof SecondaryActionType.Checkbox) {
                composerStartRestartGroup.startReplaceGroup(876166862);
                ComposerKt.sourceInformation(composerStartRestartGroup, "411@16902L66,405@16645L333");
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(modifier, Dp.m9687constructorimpl(16), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 998102729, "CC(remember):BoxListViewItem.kt#9igjgp");
                boolean z5 = (458752 & i2) == 131072;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxListViewItemKt.SecondaryActionButton$lambda$0$0(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxCheckBoxKt.BoxCheckbox(ClickableKt.m632clickableoSLSa3U$default(modifierM1220paddingVpY3zN4$default, z4, null, null, null, (Function0) objRememberedValue, 14, null), z3, null, z2, composerStartRestartGroup, (i2 & 112) | 384 | ((i2 << 3) & 7168), 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (secondaryActionType instanceof SecondaryActionType.None) {
                composerStartRestartGroup.startReplaceGroup(998106446);
                ComposerKt.sourceInformation(composerStartRestartGroup, "416@17019L39");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(modifier, Dp.m9687constructorimpl(16)), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(secondaryActionType instanceof SecondaryActionType.BottomSheetMenu)) {
                    composerStartRestartGroup.startReplaceGroup(998093087);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(876630498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@17263L246,419@17124L385");
                IconButtonKt.IconButton(function0, TestTagKt.testTag(modifier, "Item.SecondaryAction"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1190326555, true, new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxListViewItemKt.SecondaryActionButton$lambda$1(str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 15) & 14) | 1572864, 60);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxListViewItemKt.SecondaryActionButton$lambda$2(modifier, z, z2, secondaryActionType, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryActionButton$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryActionButton$lambda$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C425@17371L45,423@17281L214:BoxListViewItem.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1190326555, i, -1, "com.box.android.base.compose.SecondaryActionButton.<anonymous> (BoxListViewItem.kt:423)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_more24_android, composer, 0), str, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 384, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String getCheckboxContentDescription(boolean z, String str, Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, -675586431, "C(getCheckboxContentDescription)N(isSelected,itemName)440@17852L64:BoxListViewItem.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675586431, i, -1, "com.box.android.base.compose.getCheckboxContentDescription (BoxListViewItem.kt:434)");
        }
        if (z) {
            composer.startReplaceGroup(-178490445);
            ComposerKt.sourceInformation(composer, "436@17684L62");
            strStringResource = StringResources_androidKt.stringResource(R.string.browse_item_talkback_checkbox_checked, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-178406993);
            ComposerKt.sourceInformation(composer, "438@17768L66");
            strStringResource = StringResources_androidKt.stringResource(R.string.browse_item_talkback_checkbox_not_checked, composer, 0);
            composer.endReplaceGroup();
        }
        String str2 = StringResources_androidKt.stringResource(R.string.browse_item_talkback_checkbox, new Object[]{str}, composer, 0) + ", " + strStringResource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return str2;
    }

    private static final void BoxListViewItemPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(161749202);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxListViewItemPreview)448@18071L4560:BoxListViewItem.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(161749202, i, -1, "com.box.android.base.compose.BoxListViewItemPreview (BoxListViewItem.kt:447)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxListViewItemKt.INSTANCE.getLambda$863540061$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxListViewItemKt.BoxListViewItemPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ItemNameAndDescription_J2qo7bo$lambda$0$0$0$0(MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final float fM9687constructorimpl = Dp.m9687constructorimpl(8);
        int i = layout.mo748roundToPx0680j_4(fM9687constructorimpl) * 2;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(ConstraintsKt.m9659offsetNN6EwU(constraints.getValue(), i, i));
        return MeasureScope.layout$default(layout, RangesKt.coerceAtLeast(placeableMo8265measureBRTryo0.getWidth() - i, 0), RangesKt.coerceAtLeast(placeableMo8265measureBRTryo0.getHeight() - i, 0), null, new Function1() { // from class: com.box.android.base.compose.BoxListViewItemKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxListViewItemKt.ItemNameAndDescription_J2qo7bo$lambda$0$0$0$0$0(placeableMo8265measureBRTryo0, fM9687constructorimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
