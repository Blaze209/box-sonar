package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.material3.tokens.SegmentedMenuTokens;
import androidx.compose.material3.tokens.ShapeTokens;
import androidx.compose.material3.tokens.StandardMenuTokens;
import androidx.compose.material3.tokens.VibrantMenuTokens;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0007¢\u0006\u0002\u0010HJ\u001d\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0007¢\u0006\u0002\u0010KJ\r\u0010L\u001a\u00020MH\u0007¢\u0006\u0002\u0010NJ%\u0010O\u001a\u00020J2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010QJ\r\u0010O\u001a\u00020JH\u0007¢\u0006\u0002\u0010RJ%\u0010S\u001a\u00020D2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010UJ\r\u0010S\u001a\u00020DH\u0007¢\u0006\u0002\u0010VJ4\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020?2\u0011\u0010\\\u001a\r\u0012\u0004\u0012\u00020X0]¢\u0006\u0002\b^H\u0007¢\u0006\u0002\u0010_J3\u0010`\u001a\u00020X2\u0011\u0010a\u001a\r\u0012\u0004\u0012\u00020X0]¢\u0006\u0002\b^2\u0011\u0010\\\u001a\r\u0012\u0004\u0012\u00020X0]¢\u0006\u0002\b^H\u0007¢\u0006\u0002\u0010bJK\u0010L\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020\u00102\b\b\u0002\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00102\b\b\u0002\u0010f\u001a\u00020\u00102\b\b\u0002\u0010g\u001a\u00020\u00102\b\b\u0002\u0010h\u001a\u00020\u0010H\u0007¢\u0006\u0004\bi\u0010jJ}\u0010k\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00102\b\b\u0002\u0010f\u001a\u00020\u00102\b\b\u0002\u0010g\u001a\u00020\u00102\b\b\u0002\u0010h\u001a\u00020\u00102\b\b\u0002\u0010l\u001a\u00020\u00102\b\b\u0002\u0010m\u001a\u00020\u00102\b\b\u0002\u0010n\u001a\u00020\u00102\b\b\u0002\u0010o\u001a\u00020\u0010H\u0007¢\u0006\u0004\bp\u0010qJ}\u0010r\u001a\u00020M2\b\b\u0002\u0010c\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010d\u001a\u00020\u00102\b\b\u0002\u0010e\u001a\u00020\u00102\b\b\u0002\u0010f\u001a\u00020\u00102\b\b\u0002\u0010g\u001a\u00020\u00102\b\b\u0002\u0010h\u001a\u00020\u00102\b\b\u0002\u0010l\u001a\u00020\u00102\b\b\u0002\u0010m\u001a\u00020\u00102\b\b\u0002\u0010n\u001a\u00020\u00102\b\b\u0002\u0010o\u001a\u00020\u0010H\u0007¢\u0006\u0004\bs\u0010qR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u000eR\u001a\u0010 \u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u000eR\u001a\u0010&\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u000eR\u001a\u0010)\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u000eR\u001a\u0010,\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u000eR\u001a\u00102\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0015\u001a\u0004\b7\u0010\u000eR\u001e\u00108\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010\u0007R\u001e\u0010;\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010\u0007R\u001c\u0010>\u001a\u00020?8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010BR\u0018\u0010t\u001a\u00020M*\u00020u8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001e\u0010x\u001a\u00020M*\u00020u8@X\u0080\u0004¢\u0006\f\u0012\u0004\by\u0010z\u001a\u0004\b{\u0010wR\u001e\u0010|\u001a\u00020M*\u00020u8@X\u0080\u0004¢\u0006\f\u0012\u0004\b}\u0010z\u001a\u0004\b~\u0010wR\u0012\u0010\u007f\u001a\u00020?¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010BR\u0013\u0010\u0081\u0001\u001a\u00020?¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010BR$\u0010\u0083\u0001\u001a\u00020J*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R$\u0010\u0089\u0001\u001a\u00020J*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u008a\u0001\u0010\u0086\u0001\u001a\u0006\b\u008b\u0001\u0010\u0088\u0001R$\u0010\u008c\u0001\u001a\u00020J*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u008d\u0001\u0010\u0086\u0001\u001a\u0006\b\u008e\u0001\u0010\u0088\u0001R$\u0010\u008f\u0001\u001a\u00020J*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0090\u0001\u0010\u0086\u0001\u001a\u0006\b\u0091\u0001\u0010\u0088\u0001R$\u0010\u0092\u0001\u001a\u00020D*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0093\u0001\u0010\u0086\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R$\u0010\u0096\u0001\u001a\u00020D*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u0097\u0001\u0010\u0086\u0001\u001a\u0006\b\u0098\u0001\u0010\u0095\u0001R$\u0010\u0099\u0001\u001a\u00020D*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u009a\u0001\u0010\u0086\u0001\u001a\u0006\b\u009b\u0001\u0010\u0095\u0001R$\u0010\u009c\u0001\u001a\u00020D*\u00030\u0084\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u009d\u0001\u0010\u0086\u0001\u001a\u0006\b\u009e\u0001\u0010\u0095\u0001¨\u0006\u009f\u0001"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "groupStandardContainerColor", "getGroupStandardContainerColor$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getGroupStandardContainerColor", "groupVibrantContainerColor", "getGroupVibrantContainerColor$annotations", "getGroupVibrantContainerColor", "leadingGroupShape", "getLeadingGroupShape$annotations", "getLeadingGroupShape", "middleGroupShape", "getMiddleGroupShape$annotations", "getMiddleGroupShape", "trailingGroupShape", "getTrailingGroupShape$annotations", "getTrailingGroupShape", "leadingItemShape", "getLeadingItemShape$annotations", "getLeadingItemShape", "middleItemShape", "getMiddleItemShape$annotations", "getMiddleItemShape", "trailingItemShape", "getTrailingItemShape$annotations", "getTrailingItemShape", "standaloneItemShape", "getStandaloneItemShape$annotations", "getStandaloneItemShape", "selectedItemShape", "getSelectedItemShape$annotations", "getSelectedItemShape", "standaloneGroupShape", "getStandaloneGroupShape$annotations", "getStandaloneGroupShape", "inactiveGroupShape", "getInactiveGroupShape$annotations", "getInactiveGroupShape", "GroupSpacing", "getGroupSpacing-D9Ej5fM$annotations", "getGroupSpacing-D9Ej5fM", "HorizontalDividerPadding", "getHorizontalDividerPadding-D9Ej5fM$annotations", "getHorizontalDividerPadding-D9Ej5fM", "DropdownMenuGroupLabelHorizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuGroupLabelHorizontalPadding$annotations", "getDropdownMenuGroupLabelHorizontalPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "groupShape", "Landroidx/compose/material3/MenuGroupShapes;", FirebaseAnalytics.Param.INDEX, "", "count", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuGroupShapes;", "itemShape", "Landroidx/compose/material3/MenuItemShapes;", "(IILandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemShapes;", "itemColors", "Landroidx/compose/material3/MenuItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "itemShapes", "selectedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemShapes;", "groupShapes", "inactiveShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuGroupShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuGroupShapes;", "Label", "", "contentAlignment", "Landroidx/compose/ui/Alignment;", ViewProps.PADDING, "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LabelWithSupportingText", "supportingText", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "selectableItemColors", "selectedContainerColor", "selectedTextColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "selectableItemColors-HlaysQ4", "(JJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/MenuItemColors;", "selectableItemVibrantColors", "selectableItemVibrantColors-HlaysQ4", "defaultMenuItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "defaultMenuSelectableItemColors", "getDefaultMenuSelectableItemColors$material3$annotations", "(Landroidx/compose/material3/ColorScheme;)V", "getDefaultMenuSelectableItemColors$material3", "defaultMenuSelectableItemVibrantColors", "getDefaultMenuSelectableItemVibrantColors$material3$annotations", "getDefaultMenuSelectableItemVibrantColors$material3", "DropdownMenuItemContentPadding", "getDropdownMenuItemContentPadding", "DropdownMenuGroupContentPadding", "getDropdownMenuGroupContentPadding", "defaultMenuStandaloneItemShapes", "Landroidx/compose/material3/Shapes;", "getDefaultMenuStandaloneItemShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultMenuStandaloneItemShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/MenuItemShapes;", "defaultMenuLeadingItemShapes", "getDefaultMenuLeadingItemShapes$material3$annotations", "getDefaultMenuLeadingItemShapes$material3", "defaultMenuMiddleItemShapes", "getDefaultMenuMiddleItemShapes$material3$annotations", "getDefaultMenuMiddleItemShapes$material3", "defaultMenuTrailingItemShapes", "getDefaultMenuTrailingItemShapes$material3$annotations", "getDefaultMenuTrailingItemShapes$material3", "defaultMenuStandaloneGroupShapes", "getDefaultMenuStandaloneGroupShapes$material3$annotations", "getDefaultMenuStandaloneGroupShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/MenuGroupShapes;", "defaultMenuLeadingGroupShapes", "getDefaultMenuLeadingGroupShapes$material3$annotations", "getDefaultMenuLeadingGroupShapes$material3", "defaultMenuMiddleGroupShapes", "getDefaultMenuMiddleGroupShapes$material3$annotations", "getDefaultMenuMiddleGroupShapes$material3", "defaultMenuTrailingGroupShapes", "getDefaultMenuTrailingGroupShapes$material3$annotations", "getDefaultMenuTrailingGroupShapes$material3", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuDefaults {
    public static final int $stable = 0;
    private static final PaddingValues DropdownMenuGroupContentPadding;
    private static final PaddingValues DropdownMenuGroupLabelHorizontalPadding;
    private static final PaddingValues DropdownMenuItemContentPadding;
    private static final float HorizontalDividerPadding;
    public static final MenuDefaults INSTANCE = new MenuDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m5363getLevel0D9Ej5fM();
    private static final float ShadowElevation = MenuTokens.INSTANCE.m5546getContainerElevationD9Ej5fM();
    private static final float GroupSpacing = SegmentedMenuTokens.INSTANCE.m5751getSegmentedGapD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$1(MenuDefaults menuDefaults, Alignment alignment, PaddingValues paddingValues, Function2 function2, int i, int i2, Composer composer, int i3) {
        menuDefaults.Label(alignment, paddingValues, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelWithSupportingText$lambda$1(MenuDefaults menuDefaults, Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        menuDefaults.LabelWithSupportingText(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getDefaultMenuLeadingGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuLeadingItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuMiddleGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuMiddleItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuSelectableItemColors$material3$annotations(ColorScheme colorScheme) {
    }

    public static /* synthetic */ void getDefaultMenuSelectableItemVibrantColors$material3$annotations(ColorScheme colorScheme) {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuTrailingGroupShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultMenuTrailingItemShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDropdownMenuGroupLabelHorizontalPadding$annotations() {
    }

    /* JADX INFO: renamed from: getGroupSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3749getGroupSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getGroupStandardContainerColor$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getGroupVibrantContainerColor$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getHorizontalDividerPadding-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3750getHorizontalDividerPaddingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getInactiveGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLeadingGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLeadingItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMiddleGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMiddleItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSelectedItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getStandaloneGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getStandaloneItemShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getTrailingGroupShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getTrailingItemShape$annotations(Composer composer, int i) {
    }

    private MenuDefaults() {
    }

    static {
        float f = 12;
        HorizontalDividerPadding = Dp.m9687constructorimpl(f);
        DropdownMenuGroupLabelHorizontalPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(4), 0.0f, 10, null);
        float f2 = 0;
        DropdownMenuItemContentPadding = PaddingKt.m1212PaddingValuesYgX7TsA(MenuKt.getDropdownMenuItemHorizontalPadding(), Dp.m9687constructorimpl(f2));
        DropdownMenuGroupContentPadding = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f2), MenuKt.getDropdownMenuGroupVerticalPadding());
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m3754getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m3753getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1323260959, "C(<get-shape>)50@2096L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1323260959, i, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (MenuDefaults.kt:50)");
        }
        Shape value = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2079969291, "C(<get-containerColor>)54@2231L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079969291, i, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (MenuDefaults.kt:54)");
        }
        long value = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getGroupStandardContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1413243877, "C(<get-groupStandardContainerColor>)67@2761L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413243877, i, -1, "androidx.compose.material3.MenuDefaults.<get-groupStandardContainerColor> (MenuDefaults.kt:67)");
        }
        long value = ColorSchemeKt.getValue(StandardMenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getGroupVibrantContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1621528555, "C(<get-groupVibrantContainerColor>)80@3288L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1621528555, i, -1, "androidx.compose.material3.MenuDefaults.<get-groupVibrantContainerColor> (MenuDefaults.kt:80)");
        }
        long value = ColorSchemeKt.getValue(VibrantMenuTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLeadingGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1396735891, "C(<get-leadingGroupShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1396735891, i, -1, "androidx.compose.material3.MenuDefaults.<get-leadingGroupShape> (MenuDefaults.kt:87)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getMiddleGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1680742419, "C(<get-middleGroupShape>)97@3935L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1680742419, i, -1, "androidx.compose.material3.MenuDefaults.<get-middleGroupShape> (MenuDefaults.kt:97)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getGroupShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getTrailingGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 190977843, "C(<get-trailingGroupShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(190977843, i, -1, "androidx.compose.material3.MenuDefaults.<get-trailingGroupShape> (MenuDefaults.kt:104)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getLeadingItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1207397875, "C(<get-leadingItemShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1207397875, i, -1, "androidx.compose.material3.MenuDefaults.<get-leadingItemShape> (MenuDefaults.kt:116)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getMiddleItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -828031119, "C(<get-middleItemShape>)126@5057L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-828031119, i, -1, "androidx.compose.material3.MenuDefaults.<get-middleItemShape> (MenuDefaults.kt:126)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getItemShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getTrailingItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 159265919, "C(<get-trailingItemShape>):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(159265919, i, -1, "androidx.compose.material3.MenuDefaults.<get-trailingItemShape> (MenuDefaults.kt:133)");
        }
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return roundedCornerShape;
    }

    public final Shape getStandaloneItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1501278127, "C(<get-standaloneItemShape>)143@5707L15:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1501278127, i, -1, "androidx.compose.material3.MenuDefaults.<get-standaloneItemShape> (MenuDefaults.kt:143)");
        }
        Shape middleItemShape = getMiddleItemShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return middleItemShape;
    }

    public final Shape getSelectedItemShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 642731453, "C(<get-selectedItemShape>)148@5915L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642731453, i, -1, "androidx.compose.material3.MenuDefaults.<get-selectedItemShape> (MenuDefaults.kt:148)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getItemSelectedShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getStandaloneGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 555378067, "C(<get-standaloneGroupShape>)153@6124L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(555378067, i, -1, "androidx.compose.material3.MenuDefaults.<get-standaloneGroupShape> (MenuDefaults.kt:153)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getInactiveGroupShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 823797139, "C(<get-inactiveGroupShape>)158@6352L5:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(823797139, i, -1, "androidx.compose.material3.MenuDefaults.<get-inactiveGroupShape> (MenuDefaults.kt:158)");
        }
        Shape value = ShapesKt.getValue(SegmentedMenuTokens.INSTANCE.getInactiveContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getGroupSpacing-D9Ej5fM, reason: not valid java name */
    public final float m3751getGroupSpacingD9Ej5fM() {
        return GroupSpacing;
    }

    /* JADX INFO: renamed from: getHorizontalDividerPadding-D9Ej5fM, reason: not valid java name */
    public final float m3752getHorizontalDividerPaddingD9Ej5fM() {
        return HorizontalDividerPadding;
    }

    public final PaddingValues getDropdownMenuGroupLabelHorizontalPadding() {
        return DropdownMenuGroupLabelHorizontalPadding;
    }

    public final MenuGroupShapes groupShape(int i, int i2, Composer composer, int i3) {
        MenuGroupShapes defaultMenuMiddleGroupShapes$material3;
        composer.startReplaceGroup(169026395);
        ComposerKt.sourceInformation(composer, "C(groupShape)N(index,count):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(169026395, i3, -1, "androidx.compose.material3.MenuDefaults.groupShape (MenuDefaults.kt:182)");
        }
        if (i2 == 1) {
            composer.startReplaceGroup(1763746483);
            ComposerKt.sourceInformation(composer, "184@7452L6");
            MenuGroupShapes defaultMenuStandaloneGroupShapes$material3 = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultMenuStandaloneGroupShapes$material3;
        }
        composer.startReplaceGroup(1756385223);
        composer.endReplaceGroup();
        if (i == 0) {
            composer.startReplaceGroup(-774384072);
            ComposerKt.sourceInformation(composer, "188@7564L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuLeadingGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else if (i == i2 - 1) {
            composer.startReplaceGroup(-774381639);
            ComposerKt.sourceInformation(composer, "189@7640L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuTrailingGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-774379337);
            ComposerKt.sourceInformation(composer, "190@7712L6");
            defaultMenuMiddleGroupShapes$material3 = getDefaultMenuMiddleGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return defaultMenuMiddleGroupShapes$material3;
    }

    public final MenuItemShapes itemShape(int i, int i2, Composer composer, int i3) {
        MenuItemShapes defaultMenuMiddleItemShapes$material3;
        composer.startReplaceGroup(-1676944645);
        ComposerKt.sourceInformation(composer, "C(itemShape)N(index,count):MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1676944645, i3, -1, "androidx.compose.material3.MenuDefaults.itemShape (MenuDefaults.kt:205)");
        }
        if (i2 == 1) {
            composer.startReplaceGroup(1201749812);
            ComposerKt.sourceInformation(composer, "207@8431L6");
            MenuItemShapes defaultMenuStandaloneItemShapes$material3 = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultMenuStandaloneItemShapes$material3;
        }
        composer.startReplaceGroup(1193417415);
        composer.endReplaceGroup();
        if (i == 0) {
            composer.startReplaceGroup(-931060361);
            ComposerKt.sourceInformation(composer, "211@8542L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuLeadingItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else if (i == i2 - 1) {
            composer.startReplaceGroup(-931057960);
            ComposerKt.sourceInformation(composer, "212@8617L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuTrailingItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-931055690);
            ComposerKt.sourceInformation(composer, "213@8688L6");
            defaultMenuMiddleItemShapes$material3 = getDefaultMenuMiddleItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return defaultMenuMiddleItemShapes$material3;
    }

    public final MenuItemColors itemColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1208055030, "C(itemColors)221@8948L11:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1208055030, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (MenuDefaults.kt:221)");
        }
        MenuItemColors defaultMenuItemColors$material3 = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuItemColors$material3;
    }

    public final MenuItemShapes itemShapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -402947630, "C(itemShapes)N(shape,selectedShape)238@9704L6:MenuDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-402947630, i, -1, "androidx.compose.material3.MenuDefaults.itemShapes (MenuDefaults.kt:238)");
        }
        MenuItemShapes menuItemShapesCopy = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemShapesCopy;
    }

    public final MenuItemShapes itemShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -67210362, "C(itemShapes)255@10373L6:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-67210362, i, -1, "androidx.compose.material3.MenuDefaults.itemShapes (MenuDefaults.kt:255)");
        }
        MenuItemShapes defaultMenuStandaloneItemShapes$material3 = getDefaultMenuStandaloneItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuStandaloneItemShapes$material3;
    }

    public final MenuGroupShapes groupShapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1616512324, "C(groupShapes)N(shape,inactiveShape)272@11148L6:MenuDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1616512324, i, -1, "androidx.compose.material3.MenuDefaults.groupShapes (MenuDefaults.kt:272)");
        }
        MenuGroupShapes menuGroupShapesCopy = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuGroupShapesCopy;
    }

    public final MenuGroupShapes groupShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1317759024, "C(groupShapes)286@11750L6:MenuDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1317759024, i, -1, "androidx.compose.material3.MenuDefaults.groupShapes (MenuDefaults.kt:286)");
        }
        MenuGroupShapes defaultMenuStandaloneGroupShapes$material3 = getDefaultMenuStandaloneGroupShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultMenuStandaloneGroupShapes$material3;
    }

    public final void Label(final Alignment alignment, final PaddingValues paddingValues, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1670978104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Label)N(contentAlignment,padding,content)305@12520L10,305@12543L489,305@12489L543:MenuDefaults.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(alignment) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && composerStartRestartGroup.changed(paddingValues)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    alignment = Alignment.INSTANCE.getCenterStart();
                }
                if ((i2 & 2) != 0) {
                    paddingValues = DropdownMenuGroupLabelHorizontalPadding;
                    i3 &= -113;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1670978104, i3, -1, "androidx.compose.material3.MenuDefaults.Label (MenuDefaults.kt:303)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(-1723175511, true, new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.Label$lambda$0(paddingValues, alignment, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Alignment alignment2 = alignment;
        final PaddingValues paddingValues2 = paddingValues;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.Label$lambda$1(this.f$0, alignment2, paddingValues2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$0(PaddingValues paddingValues, Alignment alignment, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C306@12557L465:MenuDefaults.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1723175511, i, -1, "androidx.compose.material3.MenuDefaults.Label.<anonymous> (MenuDefaults.kt:306)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m1270sizeInqDBjuR0$default(Modifier.INSTANCE, MenuKt.getDropdownMenuItemDefaultMinWidth(), MenuKt.getDropdownMenuGroupDefaultMinHeight(), MenuKt.getDropdownMenuItemDefaultMaxWidth(), 0.0f, 8, null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1234737845, "C316@12999L9:MenuDefaults.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    public final void LabelWithSupportingText(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1578800865);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LabelWithSupportingText)N(supportingText,content)335@13573L195:MenuDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578800865, i2, -1, "androidx.compose.material3.MenuDefaults.LabelWithSupportingText (MenuDefaults.kt:333)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1071671318, "C336@13625L10,336@13594L72,337@13710L10,337@13679L79:MenuDefaults.kt#uh7d8r");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), function3, composerStartRestartGroup, i2 & 112);
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getBodyMedium(), function2, composerStartRestartGroup, (i2 << 3) & 112);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuDefaults.LabelWithSupportingText$lambda$1(this.f$0, function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: itemColors-5tl4gsc, reason: not valid java name */
    public final MenuItemColors m3755itemColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -234858382, "C(itemColors)N(textColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)364@14981L11:MenuDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-234858382, i, -1, "androidx.compose.material3.MenuDefaults.itemColors (MenuDefaults.kt:364)");
        }
        MenuItemColors menuItemColorsM3772copytNS2XkQ = getDefaultMenuItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3772copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM3772copytNS2XkQ;
    }

    /* JADX INFO: renamed from: selectableItemColors-HlaysQ4, reason: not valid java name */
    public final MenuItemColors m3756selectableItemColorsHlaysQ4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 205867483, "C(selectableItemColors)N(textColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)410@17451L11:MenuDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(205867483, i, i2, "androidx.compose.material3.MenuDefaults.selectableItemColors (MenuDefaults.kt:410)");
        }
        MenuItemColors menuItemColorsM3759copy2qZNXz8$default = MenuItemColors.m3759copy2qZNXz8$default(getDefaultMenuSelectableItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM3759copy2qZNXz8$default;
    }

    /* JADX INFO: renamed from: selectableItemVibrantColors-HlaysQ4, reason: not valid java name */
    public final MenuItemColors m3757selectableItemVibrantColorsHlaysQ4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1727700721, "C(selectableItemVibrantColors)N(textColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedTextColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)461@20226L11:MenuDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1727700721, i, i2, "androidx.compose.material3.MenuDefaults.selectableItemVibrantColors (MenuDefaults.kt:461)");
        }
        MenuItemColors menuItemColorsM3759copy2qZNXz8$default = MenuItemColors.m3759copy2qZNXz8$default(getDefaultMenuSelectableItemVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return menuItemColorsM3759copy2qZNXz8$default;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuItemColorsCached = colorScheme.getDefaultMenuItemColorsCached();
        if (defaultMenuItemColorsCached != null) {
            return defaultMenuItemColorsCached;
        }
        MenuItemColors menuItemColors = new MenuItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLabelTextColor()), ListTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultMenuItemColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final MenuItemColors getDefaultMenuSelectableItemColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuSelectableItemColorsCached = colorScheme.getDefaultMenuSelectableItemColorsCached();
        if (defaultMenuSelectableItemColorsCached != null) {
            return defaultMenuSelectableItemColorsCached;
        }
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getContainerColor());
        MenuItemColors menuItemColors = new MenuItemColors(jFromToken, ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledLabelTextColor()), StandardMenuTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledLeadingIconColor()), StandardMenuTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemDisabledTrailingIconColor()), StandardMenuTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), jFromToken2, ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, StandardMenuTokens.INSTANCE.getItemSelectedContainerColor()), null);
        colorScheme.setDefaultMenuSelectableItemColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final MenuItemColors getDefaultMenuSelectableItemVibrantColors$material3(ColorScheme colorScheme) {
        MenuItemColors defaultMenuSelectableItemVibrantColorsCached = colorScheme.getDefaultMenuSelectableItemVibrantColorsCached();
        if (defaultMenuSelectableItemVibrantColorsCached != null) {
            return defaultMenuSelectableItemVibrantColorsCached;
        }
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getContainerColor());
        MenuItemColors menuItemColors = new MenuItemColors(jFromToken, ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledLabelTextColor()), VibrantMenuTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledLeadingIconColor()), VibrantMenuTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemDisabledTrailingIconColor()), VibrantMenuTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), jFromToken2, ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, VibrantMenuTokens.INSTANCE.getItemSelectedContainerColor()), null);
        colorScheme.setDefaultMenuSelectableItemVibrantColorsCached$material3(menuItemColors);
        return menuItemColors;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }

    public final PaddingValues getDropdownMenuGroupContentPadding() {
        return DropdownMenuGroupContentPadding;
    }

    public final MenuItemShapes getDefaultMenuStandaloneItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuStandaloneItemShapesCached$material3 = shapes.getDefaultMenuStandaloneItemShapesCached();
        if (defaultMenuStandaloneItemShapesCached$material3 != null) {
            return defaultMenuStandaloneItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuStandaloneItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuLeadingItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuLeadingItemShapesCached$material3 = shapes.getDefaultMenuLeadingItemShapesCached();
        if (defaultMenuLeadingItemShapesCached$material3 != null) {
            return defaultMenuLeadingItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuLeadingItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuMiddleItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuMiddleItemShapesCached$material3 = shapes.getDefaultMenuMiddleItemShapesCached();
        if (defaultMenuMiddleItemShapesCached$material3 != null) {
            return defaultMenuMiddleItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuMiddleItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuItemShapes getDefaultMenuTrailingItemShapes$material3(Shapes shapes) {
        MenuItemShapes defaultMenuTrailingItemShapesCached$material3 = shapes.getDefaultMenuTrailingItemShapesCached();
        if (defaultMenuTrailingItemShapesCached$material3 != null) {
            return defaultMenuTrailingItemShapesCached$material3;
        }
        MenuItemShapes menuItemShapes = new MenuItemShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueExtraSmall(), ShapeTokens.INSTANCE.getCornerValueMedium(), ShapeTokens.INSTANCE.getCornerValueMedium()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getItemSelectedShape()));
        shapes.setDefaultMenuTrailingItemShapesCached$material3(menuItemShapes);
        return menuItemShapes;
    }

    public final MenuGroupShapes getDefaultMenuStandaloneGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuStandaloneGroupShapesCached$material3 = shapes.getDefaultMenuStandaloneGroupShapesCached();
        if (defaultMenuStandaloneGroupShapesCached$material3 != null) {
            return defaultMenuStandaloneGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getContainerShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuStandaloneGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuLeadingGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuLeadingGroupShapesCached$material3 = shapes.getDefaultMenuLeadingGroupShapesCached();
        if (defaultMenuLeadingGroupShapesCached$material3 != null) {
            return defaultMenuLeadingGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuLeadingGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuMiddleGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuMiddleGroupShapesCached$material3 = shapes.getDefaultMenuMiddleGroupShapesCached();
        if (defaultMenuMiddleGroupShapesCached$material3 != null) {
            return defaultMenuMiddleGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getGroupShape()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuMiddleGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }

    public final MenuGroupShapes getDefaultMenuTrailingGroupShapes$material3(Shapes shapes) {
        MenuGroupShapes defaultMenuTrailingGroupShapesCached$material3 = shapes.getDefaultMenuTrailingGroupShapesCached();
        if (defaultMenuTrailingGroupShapesCached$material3 != null) {
            return defaultMenuTrailingGroupShapesCached$material3;
        }
        MenuGroupShapes menuGroupShapes = new MenuGroupShapes(new RoundedCornerShape(ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueSmall(), ShapeTokens.INSTANCE.getCornerValueLarge(), ShapeTokens.INSTANCE.getCornerValueLarge()), ShapesKt.fromToken(shapes, SegmentedMenuTokens.INSTANCE.getInactiveContainerShape()));
        shapes.setDefaultMenuTrailingGroupShapesCached$material3(menuGroupShapes);
        return menuGroupShapes;
    }
}
