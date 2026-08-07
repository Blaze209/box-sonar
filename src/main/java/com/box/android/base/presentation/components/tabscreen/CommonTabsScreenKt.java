package com.box.android.base.presentation.components.tabscreen;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TabIndicatorScope;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TabRowDefaults;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.common.utilities.BoxCommonConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u0083\u0002\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00022\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00142\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\n2\u001b\b\u0002\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\n¢\u0006\u0002\b\f2&\u0010\u001e\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\"\u0010#\u001a'\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"rememberTabsSelector", "Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/base/presentation/components/tabscreen/TabsSelector;", "CommonTabsScreen", "", "tabs", "", "startTab", "tabNameProvider", "Lkotlin/Function1;", "", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "isTabsVisible", "", "beyondViewportPageCount", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "selectedContentColor", "unselectedContentColor", "indicatorColor", "tabsSelector", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onCurrentTabChanged", "tabBadgeDataProvider", "Lcom/box/android/base/presentation/components/tabscreen/TabBadgeData;", "content", "Lkotlin/ParameterName;", "name", "currentTab", "CommonTabsScreen-DuhZ5jU", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZIJJJJLcom/box/android/base/presentation/components/tabscreen/TabsSelector;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "TabRowCountBadge", "text", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease", "currentTabIndex"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CommonTabsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$6(List list, Object obj, Function3 function3, Modifier modifier, boolean z, int i, long j, long j2, long j3, long j4, TabsSelector tabsSelector, SnackbarHostState snackbarHostState, Function1 function1, Function3 function4, Function3 function5, int i2, int i3, int i4, Composer composer, int i5) {
        m11833CommonTabsScreenDuhZ5jU(list, obj, function3, modifier, z, i, j, j2, j3, j4, tabsSelector, snackbarHostState, function1, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRowCountBadge$lambda$1(String str, Modifier modifier, String str2, int i, int i2, Composer composer, int i3) {
        TabRowCountBadge(str, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final <T> TabsSelector<T> rememberTabsSelector(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1756036169, "C(rememberTabsSelector)62@2523L27:CommonTabsScreen.kt#gqlnsh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1756036169, i, -1, "com.box.android.base.presentation.components.tabscreen.rememberTabsSelector (CommonTabsScreen.kt:62)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 371390546, "CC(remember):CommonTabsScreen.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new TabsSelector();
            composer.updateRememberedValue(objRememberedValue);
        }
        TabsSelector<T> tabsSelector = (TabsSelector) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tabsSelector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$0$0(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0139  */
    /* JADX WARN: Code duplicated, block: B:102:0x0140  */
    /* JADX WARN: Code duplicated, block: B:104:0x0146  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:107:0x014f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0154  */
    /* JADX WARN: Code duplicated, block: B:112:0x015a  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0161  */
    /* JADX WARN: Code duplicated, block: B:117:0x0169  */
    /* JADX WARN: Code duplicated, block: B:118:0x016c  */
    /* JADX WARN: Code duplicated, block: B:123:0x017b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0180  */
    /* JADX WARN: Code duplicated, block: B:126:0x0186  */
    /* JADX WARN: Code duplicated, block: B:128:0x018e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:134:0x019e  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01be  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:179:0x0239 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:180:0x023b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0242  */
    /* JADX WARN: Code duplicated, block: B:184:0x0245  */
    /* JADX WARN: Code duplicated, block: B:187:0x024a  */
    /* JADX WARN: Code duplicated, block: B:190:0x025c  */
    /* JADX WARN: Code duplicated, block: B:191:0x026b  */
    /* JADX WARN: Code duplicated, block: B:194:0x0271  */
    /* JADX WARN: Code duplicated, block: B:195:0x0280  */
    /* JADX WARN: Code duplicated, block: B:198:0x0286  */
    /* JADX WARN: Code duplicated, block: B:199:0x0296  */
    /* JADX WARN: Code duplicated, block: B:201:0x029a  */
    /* JADX WARN: Code duplicated, block: B:202:0x029c  */
    /* JADX WARN: Code duplicated, block: B:204:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:205:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:207:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:209:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:211:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:214:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:215:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:219:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:220:0x0304  */
    /* JADX WARN: Code duplicated, block: B:223:0x031d  */
    /* JADX WARN: Code duplicated, block: B:229:0x032a  */
    /* JADX WARN: Code duplicated, block: B:232:0x0333  */
    /* JADX WARN: Code duplicated, block: B:234:0x033b  */
    /* JADX WARN: Code duplicated, block: B:237:0x0369  */
    /* JADX WARN: Code duplicated, block: B:239:0x0371  */
    /* JADX WARN: Code duplicated, block: B:242:0x03da  */
    /* JADX WARN: Code duplicated, block: B:245:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:246:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:249:0x044a  */
    /* JADX WARN: Code duplicated, block: B:251:0x0452  */
    /* JADX WARN: Code duplicated, block: B:254:0x0478  */
    /* JADX WARN: Code duplicated, block: B:256:0x048d  */
    /* JADX WARN: Code duplicated, block: B:257:0x0524  */
    /* JADX WARN: Code duplicated, block: B:259:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:262:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:264:0x0604  */
    /* JADX WARN: Code duplicated, block: B:267:0x062e  */
    /* JADX WARN: Code duplicated, block: B:269:0x0636  */
    /* JADX WARN: Code duplicated, block: B:272:0x065f  */
    /* JADX WARN: Code duplicated, block: B:273:0x0661  */
    /* JADX WARN: Code duplicated, block: B:276:0x0672  */
    /* JADX WARN: Code duplicated, block: B:277:0x0674  */
    /* JADX WARN: Code duplicated, block: B:280:0x067c  */
    /* JADX WARN: Code duplicated, block: B:284:0x068b  */
    /* JADX WARN: Code duplicated, block: B:287:0x070a  */
    /* JADX WARN: Code duplicated, block: B:289:0x0720  */
    /* JADX WARN: Code duplicated, block: B:292:0x073c  */
    /* JADX WARN: Code duplicated, block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x008d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:45:0x009c  */
    /* JADX WARN: Code duplicated, block: B:46:0x009f  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00db  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:81:0x0105  */
    /* JADX WARN: Code duplicated, block: B:83:0x010b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0114  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118  */
    /* JADX WARN: Code duplicated, block: B:91:0x0120  */
    /* JADX WARN: Code duplicated, block: B:93:0x0126  */
    /* JADX WARN: Code duplicated, block: B:96:0x012f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0133  */
    /* JADX INFO: renamed from: CommonTabsScreen-DuhZ5jU, reason: not valid java name */
    public static final <T> void m11833CommonTabsScreenDuhZ5jU(final List<? extends T> tabs, final T t, final Function3<? super T, ? super Composer, ? super Integer, String> tabNameProvider, Modifier modifier, boolean z, int i, long j, long j2, long j3, long j4, TabsSelector<T> tabsSelector, SnackbarHostState snackbarHostState, Function1<? super T, Unit> function1, Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function3, final Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10;
        long jM11498getAppBackground0d7_KjU;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        final List<? extends T> list;
        Composer composer2;
        TabsSelector<T> tabsSelector2;
        final SnackbarHostState snackbarHostState2;
        final Function1<? super T, Unit> function2;
        final Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function4;
        final int i21;
        final long j5;
        final boolean z4;
        final long j6;
        final long j7;
        long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM11533getMainActiveControl0d7_KjU;
        long jM11560getTabRowUnselectedContent0d7_KjU;
        long jM11533getMainActiveControl0d7_KjU2;
        TabsSelector<T> tabsSelector3;
        SnackbarHostState snackbarHostState3;
        Function1<? super T, Unit> function5;
        int i22;
        Function1<? super T, Unit> function6;
        Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function7;
        int i23;
        long j9;
        TabsSelector<T> tabsSelector4;
        int i24;
        final long j10;
        Object objRememberedValue;
        final int i25;
        boolean z5;
        boolean z6;
        Object objRememberedValue2;
        final MutableIntState mutableIntState;
        boolean zChangedInstance;
        CommonTabsScreenKt$CommonTabsScreen$3$1 commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue;
        int i26;
        Function0<ComposeUiNode> constructor;
        Function1<? super T, Unit> function8;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        final PagerState pagerStateRememberPagerState;
        final MutableIntState mutableIntState2;
        long j11;
        PagerState pagerState;
        Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function9;
        long j12;
        List<? extends T> list2;
        final int i27;
        MutableIntState mutableIntState3;
        boolean zChanged;
        CommonTabsScreenKt$CommonTabsScreen$4$5$1 commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue;
        boolean zChanged2;
        CommonTabsScreenKt$CommonTabsScreen$4$6$1 commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue;
        boolean z7;
        boolean z8;
        boolean z9;
        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue;
        Function1<? super T, Unit> function10;
        SnackbarHostState snackbarHostState4;
        int i28;
        int i29;
        int i30;
        int i31;
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(tabNameProvider, "tabNameProvider");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-331936493);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CommonTabsScreen)N(tabs,startTab,tabNameProvider,modifier,isTabsVisible,beyondViewportPageCount,containerColor:c#ui.graphics.Color,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,indicatorColor:c#ui.graphics.Color,tabsSelector,snackbarHostState,onCurrentTabChanged,tabBadgeDataProvider,content)99@4403L57,99@4386L74,103@4495L176,103@4466L205,110@4677L4332:CommonTabsScreen.kt#gqlnsh");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(tabs) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= (i2 & 64) == 0 ? composerStartRestartGroup.changed(t) : composerStartRestartGroup.changedInstance(t) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(tabNameProvider) ? 256 : 128;
        }
        int i32 = i4 & 8;
        if (i32 == 0) {
            if ((i2 & 3072) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 != 0) {
                if ((i2 & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i9 = i;
                } else {
                    i9 = i;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i9)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i5 |= i10;
                    }
                }
                if ((i2 & 1572864) == 0) {
                    jM11498getAppBackground0d7_KjU = j;
                    if ((i4 & 64) == 0 || !composerStartRestartGroup.changed(jM11498getAppBackground0d7_KjU)) {
                        i31 = 524288;
                    } else {
                        i31 = 1048576;
                    }
                    i5 |= i31;
                } else {
                    jM11498getAppBackground0d7_KjU = j;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i4 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i30 = 4194304;
                    } else {
                        i30 = 8388608;
                    }
                    i5 |= i30;
                }
                if ((i2 & 100663296) != 0) {
                    if ((i4 & 256) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i29 = 33554432;
                    } else {
                        i29 = 67108864;
                    }
                    i5 |= i29;
                }
                if ((i2 & 805306368) != 0) {
                    if ((i4 & 512) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i28 = 268435456;
                    } else {
                        i28 = C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    i5 |= i28;
                }
                i11 = i4 & 1024;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(tabsSelector)) {
                        i13 = 4;
                    } else {
                        i13 = 2;
                    }
                    i12 = i3 | i13;
                } else {
                    i12 = i3;
                }
                i14 = i4 & 2048;
                if (i14 != 0) {
                    if ((i3 & 48) == 0) {
                        if (composerStartRestartGroup.changed(snackbarHostState)) {
                            i15 = 32;
                        } else {
                            i15 = 16;
                        }
                        i12 |= i15;
                    }
                    i16 = i12;
                    i17 = i4 & 4096;
                    if (i17 != 0) {
                        i18 = i16;
                        if ((i3 & 384) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i19 = 256;
                            } else {
                                i19 = 128;
                            }
                            i18 |= i19;
                        }
                        if ((i3 & 3072) != 0) {
                            i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                        }
                        if ((i3 & 24576) == 0) {
                            i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                        }
                        i20 = i18;
                        if ((i5 & 306783379) == 306783378 || (i20 & 9363) != 9362) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i32 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if (i8 != 0) {
                                    i9 = 1;
                                }
                                if ((i4 & 64) != 0) {
                                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                    i5 &= -3670017;
                                }
                                if ((i4 & 128) != 0) {
                                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                    i5 &= -29360129;
                                } else {
                                    jM11533getMainActiveControl0d7_KjU = j2;
                                }
                                if ((i4 & 256) != 0) {
                                    jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                    i5 &= -234881025;
                                } else {
                                    jM11560getTabRowUnselectedContent0d7_KjU = j3;
                                }
                                if ((i4 & 512) != 0) {
                                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                    i5 = (-1879048193) & i5;
                                } else {
                                    jM11533getMainActiveControl0d7_KjU2 = j4;
                                }
                                if (i11 != 0) {
                                    tabsSelector3 = null;
                                } else {
                                    tabsSelector3 = tabsSelector;
                                }
                                if (i14 != 0) {
                                    snackbarHostState3 = null;
                                } else {
                                    snackbarHostState3 = snackbarHostState;
                                }
                                if (i17 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    function5 = (Function1) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function5 = function1;
                                }
                                if ((i4 & 8192) != 0) {
                                    Function1<? super T, Unit> function11 = function5;
                                    i22 = i20 & (-7169);
                                    function6 = function11;
                                    function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                        public final Void invoke(T t2, Composer composer3, int i33) {
                                            composer3.startReplaceGroup(-2135625561);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2135625561, i33, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return null;
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                        }
                                    };
                                } else {
                                    Function1<? super T, Unit> function12 = function5;
                                    i22 = i20;
                                    function6 = function12;
                                    function7 = function3;
                                }
                                i23 = i5;
                                j9 = jM11498getAppBackground0d7_KjU;
                                tabsSelector4 = tabsSelector3;
                                i24 = i9;
                                j10 = jM11533getMainActiveControl0d7_KjU2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i4 & 64) != 0) {
                                    i5 &= -3670017;
                                }
                                if ((i4 & 128) != 0) {
                                    i5 &= -29360129;
                                }
                                if ((i4 & 256) != 0) {
                                    i5 &= -234881025;
                                }
                                if ((i4 & 512) != 0) {
                                    i5 &= -1879048193;
                                }
                                if ((i4 & 8192) != 0) {
                                    i20 &= -7169;
                                }
                                jM11533getMainActiveControl0d7_KjU = j2;
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                                snackbarHostState3 = snackbarHostState;
                                function7 = function3;
                                i22 = i20;
                                i23 = i5;
                                modifier2 = modifier2;
                                function6 = function1;
                                long j13 = jM11498getAppBackground0d7_KjU;
                                tabsSelector4 = tabsSelector;
                                i24 = i9;
                                j9 = j13;
                                j10 = j4;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                            }
                            Object[] objArr = new Object[0];
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(tabs);
                            i25 = i23;
                            if ((i25 & 112) != 32 || ((i25 & 64) != 0 && composerStartRestartGroup.changedInstance(t))) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            z6 = zChangedInstance3 | z5;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                                composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                            i26 = i25 >> 9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            tabsSelector2 = tabsSelector4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                            Modifier modifier3 = modifier2;
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function8 = function6;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                            int iCommonTabsScreen_DuhZ5jU$lambda$2 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Integer.valueOf(tabs.size());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$2, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                            composer2 = composerStartRestartGroup;
                            if (z2) {
                                composer2.startReplaceGroup(-857019399);
                                ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                                if (tabs.size() >= 4) {
                                    composer2.startReplaceGroup(-856995033);
                                    ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                                    final Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function13 = function7;
                                    final long j14 = jM11533getMainActiveControl0d7_KjU;
                                    final long j15 = jM11560getTabRowUnselectedContent0d7_KjU;
                                    mutableIntState2 = mutableIntState;
                                    long j16 = j9;
                                    TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j16, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j14, j15, function13, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                                    composer2.endReplaceGroup();
                                    list2 = tabs;
                                    j11 = j16;
                                    pagerState = pagerStateRememberPagerState;
                                    j12 = jM11533getMainActiveControl0d7_KjU;
                                    function9 = function13;
                                    i27 = i25;
                                } else {
                                    mutableIntState2 = mutableIntState;
                                    long j17 = j9;
                                    final Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function14 = function7;
                                    composer2.startReplaceGroup(-856152391);
                                    ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                                    int targetPage = pagerStateRememberPagerState.getTargetPage();
                                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        }
                                    }, composer2, 54);
                                    Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                                    final long j18 = jM11533getMainActiveControl0d7_KjU;
                                    final long j19 = jM11560getTabRowUnselectedContent0d7_KjU;
                                    Function2 function15 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j18, j19, function14, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    };
                                    list2 = tabs;
                                    function9 = function14;
                                    pagerState = pagerStateRememberPagerState;
                                    i27 = i25;
                                    int i33 = i27 >> 12;
                                    long j20 = jM11533getMainActiveControl0d7_KjU;
                                    TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage, null, j17, j20, composableLambdaRememberComposableLambda, lambda$1549156295$base_generalProdRelease, ComposableLambdaKt.rememberComposableLambda(638276552, true, function15, composer2, 54), composer2, (i33 & 7168) | (i33 & 896) | 1794048, 2);
                                    j11 = j17;
                                    j12 = j20;
                                    composer2.endReplaceGroup();
                                }
                                BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                            } else {
                                mutableIntState2 = mutableIntState;
                                j11 = j9;
                                pagerState = pagerStateRememberPagerState;
                                function9 = function7;
                                j12 = jM11533getMainActiveControl0d7_KjU;
                                list2 = tabs;
                                i27 = i25;
                                j10 = j10;
                                composer2.startReplaceGroup(-863346747);
                            }
                            composer2.endReplaceGroup();
                            Integer numValueOf = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                            ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            mutableIntState3 = mutableIntState2;
                            zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                            if (!zChanged || commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                            ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                            if (!zChanged2 || commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                            Integer numValueOf2 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                            ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            if ((i22 & 896) == 256) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            boolean zChangedInstance4 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                            if ((i22 & 112) == 32) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            z9 = z8 | zChangedInstance4;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                            if (!z9 || commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                List<? extends T> list3 = list2;
                                SnackbarHostState snackbarHostState5 = snackbarHostState3;
                                CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$1 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list3, snackbarHostState5, mutableIntState3, null);
                                function10 = function8;
                                list = list3;
                                snackbarHostState4 = snackbarHostState5;
                                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$1;
                                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                            } else {
                                list = list2;
                                function10 = function8;
                                snackbarHostState4 = snackbarHostState3;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(numValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                            long j21 = j10;
                            boolean z10 = z2;
                            int i34 = i24;
                            PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i34, 0.0f, null, null, z10, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j8 = j21;
                            i21 = i34;
                            z4 = z10;
                            j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                            snackbarHostState2 = snackbarHostState4;
                            modifier2 = modifier3;
                            function2 = function10;
                            function4 = function9;
                            j5 = j11;
                            j6 = j12;
                        } else {
                            list = tabs;
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            tabsSelector2 = tabsSelector;
                            snackbarHostState2 = snackbarHostState;
                            function2 = function1;
                            function4 = function3;
                            i21 = i9;
                            j5 = jM11498getAppBackground0d7_KjU;
                            z4 = z2;
                            j6 = j2;
                            j7 = j3;
                            j8 = j4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final List<? extends T> list4 = list;
                            final Modifier modifier4 = modifier2;
                            final long j22 = j8;
                            final TabsSelector<T> tabsSelector5 = tabsSelector2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list4, t, tabNameProvider, modifier4, z4, i21, j5, j6, j7, j22, tabsSelector5, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i18 = i16 | 384;
                    if ((i3 & 3072) != 0) {
                        i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                    }
                    if ((i3 & 24576) == 0) {
                        i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    i20 = i18;
                    if ((i5 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                        if ((i2 & 1) != 0) {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function16 = function5;
                                i22 = i20 & (-7169);
                                function6 = function16;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i35) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i35, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function17 = function5;
                                i22 = i20;
                                function6 = function17;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        } else {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function18 = function5;
                                i22 = i20 & (-7169);
                                function6 = function18;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i35) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i35, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function19 = function5;
                                i22 = i20;
                                function6 = function19;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                        }
                        Object[] objArr2 = new Object[0];
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(tabs);
                        i25 = i23;
                        if ((i25 & 112) != 32) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        z6 = zChangedInstance5 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                        i26 = i25 >> 9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        tabsSelector2 = tabsSelector4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Modifier modifier5 = modifier2;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function8 = function6;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                        int iCommonTabsScreen_DuhZ5jU$lambda$3 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$3, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                        composer2 = composerStartRestartGroup;
                        if (z2) {
                            composer2.startReplaceGroup(-857019399);
                            ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                            if (tabs.size() >= 4) {
                                composer2.startReplaceGroup(-856995033);
                                ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                                final Function3 function110 = function7;
                                final long j110 = jM11533getMainActiveControl0d7_KjU;
                                final long j111 = jM11560getTabRowUnselectedContent0d7_KjU;
                                mutableIntState2 = mutableIntState;
                                long j112 = j9;
                                TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j112, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j110, j111, function110, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                                composer2.endReplaceGroup();
                                list2 = tabs;
                                j11 = j112;
                                pagerState = pagerStateRememberPagerState;
                                j12 = jM11533getMainActiveControl0d7_KjU;
                                function9 = function110;
                                i27 = i25;
                            } else {
                                mutableIntState2 = mutableIntState;
                                long j113 = j9;
                                final Function3 function111 = function7;
                                composer2.startReplaceGroup(-856152391);
                                ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                                int targetPage2 = pagerStateRememberPagerState.getTargetPage();
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54);
                                Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease2 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                                final long j114 = jM11533getMainActiveControl0d7_KjU;
                                final long j115 = jM11560getTabRowUnselectedContent0d7_KjU;
                                Function2 function112 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j114, j115, function111, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                list2 = tabs;
                                function9 = function111;
                                pagerState = pagerStateRememberPagerState;
                                i27 = i25;
                                int i35 = i27 >> 12;
                                long j23 = jM11533getMainActiveControl0d7_KjU;
                                TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage2, null, j113, j23, composableLambdaRememberComposableLambda2, lambda$1549156295$base_generalProdRelease2, ComposableLambdaKt.rememberComposableLambda(638276552, true, function112, composer2, 54), composer2, (i35 & 7168) | (i35 & 896) | 1794048, 2);
                                j11 = j113;
                                j12 = j23;
                                composer2.endReplaceGroup();
                            }
                            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                        } else {
                            mutableIntState2 = mutableIntState;
                            j11 = j9;
                            pagerState = pagerStateRememberPagerState;
                            function9 = function7;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            list2 = tabs;
                            i27 = i25;
                            j10 = j10;
                            composer2.startReplaceGroup(-863346747);
                        }
                        composer2.endReplaceGroup();
                        Integer numValueOf3 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        mutableIntState3 = mutableIntState2;
                        zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged2) {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                        Integer numValueOf4 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        if ((i22 & 896) == 256) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean zChangedInstance6 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                        if ((i22 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance6;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                        if (z9) {
                            List<? extends T> list5 = list2;
                            SnackbarHostState snackbarHostState6 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$2 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list5, snackbarHostState6, mutableIntState3, null);
                            function10 = function8;
                            list = list5;
                            snackbarHostState4 = snackbarHostState6;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$2;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        } else {
                            List<? extends T> list6 = list2;
                            SnackbarHostState snackbarHostState7 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$3 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list6, snackbarHostState7, mutableIntState3, null);
                            function10 = function8;
                            list = list6;
                            snackbarHostState4 = snackbarHostState7;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$3;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                        long j24 = j10;
                        boolean z11 = z2;
                        int i36 = i24;
                        PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i36, 0.0f, null, null, z11, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j8 = j24;
                        i21 = i36;
                        z4 = z11;
                        j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                        snackbarHostState2 = snackbarHostState4;
                        modifier2 = modifier5;
                        function2 = function10;
                        function4 = function9;
                        j5 = j11;
                        j6 = j12;
                    } else {
                        list = tabs;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        tabsSelector2 = tabsSelector;
                        snackbarHostState2 = snackbarHostState;
                        function2 = function1;
                        function4 = function3;
                        i21 = i9;
                        j5 = jM11498getAppBackground0d7_KjU;
                        z4 = z2;
                        j6 = j2;
                        j7 = j3;
                        j8 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final List list7 = list;
                        final Modifier modifier6 = modifier2;
                        final long j25 = j8;
                        final TabsSelector tabsSelector6 = tabsSelector2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list7, t, tabNameProvider, modifier6, z4, i21, j5, j6, j7, j25, tabsSelector6, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 48;
                i16 = i12;
                i17 = i4 & 4096;
                if (i17 != 0) {
                    i18 = i16;
                    if ((i3 & 384) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i19 = 256;
                        } else {
                            i19 = 128;
                        }
                        i18 |= i19;
                    }
                    if ((i3 & 3072) != 0) {
                        i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                    }
                    if ((i3 & 24576) == 0) {
                        i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    i20 = i18;
                    if ((i5 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                        if ((i2 & 1) != 0) {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function113 = function5;
                                i22 = i20 & (-7169);
                                function6 = function113;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i37) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i37, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function114 = function5;
                                i22 = i20;
                                function6 = function114;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        } else {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function115 = function5;
                                i22 = i20 & (-7169);
                                function6 = function115;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i37) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i37, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function116 = function5;
                                i22 = i20;
                                function6 = function116;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                        }
                        Object[] objArr3 = new Object[0];
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(tabs);
                        i25 = i23;
                        if ((i25 & 112) != 32) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        z6 = zChangedInstance7 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                        i26 = i25 >> 9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        tabsSelector2 = tabsSelector4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Modifier modifier7 = modifier2;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function8 = function6;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                        int iCommonTabsScreen_DuhZ5jU$lambda$4 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$4, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                        composer2 = composerStartRestartGroup;
                        if (z2) {
                            composer2.startReplaceGroup(-857019399);
                            ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                            if (tabs.size() >= 4) {
                                composer2.startReplaceGroup(-856995033);
                                ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                                final Function3 function117 = function7;
                                final long j116 = jM11533getMainActiveControl0d7_KjU;
                                final long j117 = jM11560getTabRowUnselectedContent0d7_KjU;
                                mutableIntState2 = mutableIntState;
                                long j118 = j9;
                                TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j118, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j116, j117, function117, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                                composer2.endReplaceGroup();
                                list2 = tabs;
                                j11 = j118;
                                pagerState = pagerStateRememberPagerState;
                                j12 = jM11533getMainActiveControl0d7_KjU;
                                function9 = function117;
                                i27 = i25;
                            } else {
                                mutableIntState2 = mutableIntState;
                                long j119 = j9;
                                final Function3 function118 = function7;
                                composer2.startReplaceGroup(-856152391);
                                ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                                int targetPage3 = pagerStateRememberPagerState.getTargetPage();
                                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54);
                                Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease3 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                                final long j1110 = jM11533getMainActiveControl0d7_KjU;
                                final long j1111 = jM11560getTabRowUnselectedContent0d7_KjU;
                                Function2 function119 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1110, j1111, function118, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                list2 = tabs;
                                function9 = function118;
                                pagerState = pagerStateRememberPagerState;
                                i27 = i25;
                                int i37 = i27 >> 12;
                                long j26 = jM11533getMainActiveControl0d7_KjU;
                                TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage3, null, j119, j26, composableLambdaRememberComposableLambda3, lambda$1549156295$base_generalProdRelease3, ComposableLambdaKt.rememberComposableLambda(638276552, true, function119, composer2, 54), composer2, (i37 & 7168) | (i37 & 896) | 1794048, 2);
                                j11 = j119;
                                j12 = j26;
                                composer2.endReplaceGroup();
                            }
                            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                        } else {
                            mutableIntState2 = mutableIntState;
                            j11 = j9;
                            pagerState = pagerStateRememberPagerState;
                            function9 = function7;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            list2 = tabs;
                            i27 = i25;
                            j10 = j10;
                            composer2.startReplaceGroup(-863346747);
                        }
                        composer2.endReplaceGroup();
                        Integer numValueOf5 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        mutableIntState3 = mutableIntState2;
                        zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged2) {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                        Integer numValueOf6 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        if ((i22 & 896) == 256) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean zChangedInstance8 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                        if ((i22 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance8;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                        if (z9) {
                            List<? extends T> list8 = list2;
                            SnackbarHostState snackbarHostState8 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$4 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list8, snackbarHostState8, mutableIntState3, null);
                            function10 = function8;
                            list = list8;
                            snackbarHostState4 = snackbarHostState8;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$4;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        } else {
                            List<? extends T> list9 = list2;
                            SnackbarHostState snackbarHostState9 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$5 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list9, snackbarHostState9, mutableIntState3, null);
                            function10 = function8;
                            list = list9;
                            snackbarHostState4 = snackbarHostState9;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$5;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                        long j27 = j10;
                        boolean z12 = z2;
                        int i38 = i24;
                        PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i38, 0.0f, null, null, z12, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j8 = j27;
                        i21 = i38;
                        z4 = z12;
                        j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                        snackbarHostState2 = snackbarHostState4;
                        modifier2 = modifier7;
                        function2 = function10;
                        function4 = function9;
                        j5 = j11;
                        j6 = j12;
                    } else {
                        list = tabs;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        tabsSelector2 = tabsSelector;
                        snackbarHostState2 = snackbarHostState;
                        function2 = function1;
                        function4 = function3;
                        i21 = i9;
                        j5 = jM11498getAppBackground0d7_KjU;
                        z4 = z2;
                        j6 = j2;
                        j7 = j3;
                        j8 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final List list10 = list;
                        final Modifier modifier8 = modifier2;
                        final long j28 = j8;
                        final TabsSelector tabsSelector7 = tabsSelector2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list10, t, tabNameProvider, modifier8, z4, i21, j5, j6, j7, j28, tabsSelector7, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i18 = i16 | 384;
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function1110 = function5;
                            i22 = i20 & (-7169);
                            function6 = function1110;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i39) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i39, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function1111 = function5;
                            i22 = i20;
                            function6 = function1111;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function1112 = function5;
                            i22 = i20 & (-7169);
                            function6 = function1112;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i39) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i39, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function1113 = function5;
                            i22 = i20;
                            function6 = function1113;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr4 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance9 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier9 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$5 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$5, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function1114 = function7;
                            final long j1112 = jM11533getMainActiveControl0d7_KjU;
                            final long j1113 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j1114 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j1114, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1112, j1113, function1114, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j1114;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function1114;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j1115 = j9;
                            final Function3 function1115 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage4 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease4 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j1116 = jM11533getMainActiveControl0d7_KjU;
                            final long j1117 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function1116 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1116, j1117, function1115, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function1115;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i39 = i27 >> 12;
                            long j29 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage4, null, j1115, j29, composableLambdaRememberComposableLambda4, lambda$1549156295$base_generalProdRelease4, ComposableLambdaKt.rememberComposableLambda(638276552, true, function1116, composer2, 54), composer2, (i39 & 7168) | (i39 & 896) | 1794048, 2);
                            j11 = j1115;
                            j12 = j29;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf7 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf8 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance10 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance10;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list11 = list2;
                        SnackbarHostState snackbarHostState10 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$6 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11, snackbarHostState10, mutableIntState3, null);
                        function10 = function8;
                        list = list11;
                        snackbarHostState4 = snackbarHostState10;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$6;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list12 = list2;
                        SnackbarHostState snackbarHostState11 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$7 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list12, snackbarHostState11, mutableIntState3, null);
                        function10 = function8;
                        list = list12;
                        snackbarHostState4 = snackbarHostState11;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$7;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j210 = j10;
                    boolean z13 = z2;
                    int i310 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i310, 0.0f, null, null, z13, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j210;
                    i21 = i310;
                    z4 = z13;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier9;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list13 = list;
                    final Modifier modifier10 = modifier2;
                    final long j211 = j8;
                    final TabsSelector tabsSelector8 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list13, t, tabNameProvider, modifier10, z4, i21, j5, j6, j7, j211, tabsSelector8, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            z2 = z;
            i8 = i4 & 32;
            if (i8 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i9 = i;
            } else {
                i9 = i;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i9)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i5 |= i10;
                }
            }
            if ((i2 & 1572864) == 0) {
                jM11498getAppBackground0d7_KjU = j;
                if ((i4 & 64) == 0) {
                    i31 = 524288;
                } else {
                    i31 = 524288;
                }
                i5 |= i31;
            } else {
                jM11498getAppBackground0d7_KjU = j;
            }
            if ((i2 & 12582912) != 0) {
                if ((i4 & 128) == 0) {
                    i30 = 4194304;
                } else {
                    i30 = 4194304;
                }
                i5 |= i30;
            }
            if ((i2 & 100663296) != 0) {
                if ((i4 & 256) == 0) {
                    i29 = 33554432;
                } else {
                    i29 = 33554432;
                }
                i5 |= i29;
            }
            if ((i2 & 805306368) != 0) {
                if ((i4 & 512) == 0) {
                    i28 = 268435456;
                } else {
                    i28 = 268435456;
                }
                i5 |= i28;
            }
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(tabsSelector)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            i14 = i4 & 2048;
            if (i14 != 0) {
                if ((i3 & 48) == 0) {
                    if (composerStartRestartGroup.changed(snackbarHostState)) {
                        i15 = 32;
                    } else {
                        i15 = 16;
                    }
                    i12 |= i15;
                }
                i16 = i12;
                i17 = i4 & 4096;
                if (i17 != 0) {
                    i18 = i16;
                    if ((i3 & 384) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i19 = 256;
                        } else {
                            i19 = 128;
                        }
                        i18 |= i19;
                    }
                    if ((i3 & 3072) != 0) {
                        i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                    }
                    if ((i3 & 24576) == 0) {
                        i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    i20 = i18;
                    if ((i5 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                        if ((i2 & 1) != 0) {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function1117 = function5;
                                i22 = i20 & (-7169);
                                function6 = function1117;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i311) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i311, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function1118 = function5;
                                i22 = i20;
                                function6 = function1118;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        } else {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function1119 = function5;
                                i22 = i20 & (-7169);
                                function6 = function1119;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i311) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i311, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function11110 = function5;
                                i22 = i20;
                                function6 = function11110;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                        }
                        Object[] objArr5 = new Object[0];
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        boolean zChangedInstance11 = composerStartRestartGroup.changedInstance(tabs);
                        i25 = i23;
                        if ((i25 & 112) != 32) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        z6 = zChangedInstance11 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr5, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                        i26 = i25 >> 9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        tabsSelector2 = tabsSelector4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Modifier modifier11 = modifier2;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function8 = function6;
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
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                        int iCommonTabsScreen_DuhZ5jU$lambda$6 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$6, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                        composer2 = composerStartRestartGroup;
                        if (z2) {
                            composer2.startReplaceGroup(-857019399);
                            ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                            if (tabs.size() >= 4) {
                                composer2.startReplaceGroup(-856995033);
                                ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                                final Function3 function11111 = function7;
                                final long j1118 = jM11533getMainActiveControl0d7_KjU;
                                final long j1119 = jM11560getTabRowUnselectedContent0d7_KjU;
                                mutableIntState2 = mutableIntState;
                                long j11110 = j9;
                                TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11110, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1118, j1119, function11111, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                                composer2.endReplaceGroup();
                                list2 = tabs;
                                j11 = j11110;
                                pagerState = pagerStateRememberPagerState;
                                j12 = jM11533getMainActiveControl0d7_KjU;
                                function9 = function11111;
                                i27 = i25;
                            } else {
                                mutableIntState2 = mutableIntState;
                                long j11111 = j9;
                                final Function3 function11112 = function7;
                                composer2.startReplaceGroup(-856152391);
                                ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                                int targetPage5 = pagerStateRememberPagerState.getTargetPage();
                                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54);
                                Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease5 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                                final long j11112 = jM11533getMainActiveControl0d7_KjU;
                                final long j11113 = jM11560getTabRowUnselectedContent0d7_KjU;
                                Function2 function11113 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11112, j11113, function11112, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                list2 = tabs;
                                function9 = function11112;
                                pagerState = pagerStateRememberPagerState;
                                i27 = i25;
                                int i311 = i27 >> 12;
                                long j212 = jM11533getMainActiveControl0d7_KjU;
                                TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage5, null, j11111, j212, composableLambdaRememberComposableLambda5, lambda$1549156295$base_generalProdRelease5, ComposableLambdaKt.rememberComposableLambda(638276552, true, function11113, composer2, 54), composer2, (i311 & 7168) | (i311 & 896) | 1794048, 2);
                                j11 = j11111;
                                j12 = j212;
                                composer2.endReplaceGroup();
                            }
                            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                        } else {
                            mutableIntState2 = mutableIntState;
                            j11 = j9;
                            pagerState = pagerStateRememberPagerState;
                            function9 = function7;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            list2 = tabs;
                            i27 = i25;
                            j10 = j10;
                            composer2.startReplaceGroup(-863346747);
                        }
                        composer2.endReplaceGroup();
                        Integer numValueOf9 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        mutableIntState3 = mutableIntState2;
                        zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged2) {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                        Integer numValueOf10 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        if ((i22 & 896) == 256) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean zChangedInstance12 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                        if ((i22 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance12;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                        if (z9) {
                            List<? extends T> list14 = list2;
                            SnackbarHostState snackbarHostState12 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$8 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list14, snackbarHostState12, mutableIntState3, null);
                            function10 = function8;
                            list = list14;
                            snackbarHostState4 = snackbarHostState12;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$8;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        } else {
                            List<? extends T> list15 = list2;
                            SnackbarHostState snackbarHostState13 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$9 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list15, snackbarHostState13, mutableIntState3, null);
                            function10 = function8;
                            list = list15;
                            snackbarHostState4 = snackbarHostState13;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$9;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                        long j213 = j10;
                        boolean z14 = z2;
                        int i312 = i24;
                        PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i312, 0.0f, null, null, z14, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j8 = j213;
                        i21 = i312;
                        z4 = z14;
                        j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                        snackbarHostState2 = snackbarHostState4;
                        modifier2 = modifier11;
                        function2 = function10;
                        function4 = function9;
                        j5 = j11;
                        j6 = j12;
                    } else {
                        list = tabs;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        tabsSelector2 = tabsSelector;
                        snackbarHostState2 = snackbarHostState;
                        function2 = function1;
                        function4 = function3;
                        i21 = i9;
                        j5 = jM11498getAppBackground0d7_KjU;
                        z4 = z2;
                        j6 = j2;
                        j7 = j3;
                        j8 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final List list16 = list;
                        final Modifier modifier12 = modifier2;
                        final long j214 = j8;
                        final TabsSelector tabsSelector9 = tabsSelector2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list16, t, tabNameProvider, modifier12, z4, i21, j5, j6, j7, j214, tabsSelector9, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i18 = i16 | 384;
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function11114 = function5;
                            i22 = i20 & (-7169);
                            function6 = function11114;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i313) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i313, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function11115 = function5;
                            i22 = i20;
                            function6 = function11115;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function11116 = function5;
                            i22 = i20 & (-7169);
                            function6 = function11116;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i313) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i313, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function11117 = function5;
                            i22 = i20;
                            function6 = function11117;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr6 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance13 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance13 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr6, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier13 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$7 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$7, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function11118 = function7;
                            final long j11114 = jM11533getMainActiveControl0d7_KjU;
                            final long j11115 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j11116 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11116, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j11114, j11115, function11118, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j11116;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function11118;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j11117 = j9;
                            final Function3 function11119 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage6 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease6 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j11118 = jM11533getMainActiveControl0d7_KjU;
                            final long j11119 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function111110 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11118, j11119, function11119, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function11119;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i313 = i27 >> 12;
                            long j215 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage6, null, j11117, j215, composableLambdaRememberComposableLambda6, lambda$1549156295$base_generalProdRelease6, ComposableLambdaKt.rememberComposableLambda(638276552, true, function111110, composer2, 54), composer2, (i313 & 7168) | (i313 & 896) | 1794048, 2);
                            j11 = j11117;
                            j12 = j215;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf11 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf12 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance14 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance14;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list17 = list2;
                        SnackbarHostState snackbarHostState14 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$10 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list17, snackbarHostState14, mutableIntState3, null);
                        function10 = function8;
                        list = list17;
                        snackbarHostState4 = snackbarHostState14;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$10;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list18 = list2;
                        SnackbarHostState snackbarHostState15 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$11 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list18, snackbarHostState15, mutableIntState3, null);
                        function10 = function8;
                        list = list18;
                        snackbarHostState4 = snackbarHostState15;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$11;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j216 = j10;
                    boolean z15 = z2;
                    int i314 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i314, 0.0f, null, null, z15, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j216;
                    i21 = i314;
                    z4 = z15;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier13;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list19 = list;
                    final Modifier modifier14 = modifier2;
                    final long j217 = j8;
                    final TabsSelector tabsSelector10 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list19, t, tabNameProvider, modifier14, z4, i21, j5, j6, j7, j217, tabsSelector10, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 48;
            i16 = i12;
            i17 = i4 & 4096;
            if (i17 != 0) {
                i18 = i16;
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i19 = 256;
                    } else {
                        i19 = 128;
                    }
                    i18 |= i19;
                }
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function111111 = function5;
                            i22 = i20 & (-7169);
                            function6 = function111111;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i315) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i315, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function111112 = function5;
                            i22 = i20;
                            function6 = function111112;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function111113 = function5;
                            i22 = i20 & (-7169);
                            function6 = function111113;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i315) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i315, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function111114 = function5;
                            i22 = i20;
                            function6 = function111114;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr7 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance15 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance15 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr7, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier15 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$8 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$8, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function111115 = function7;
                            final long j111110 = jM11533getMainActiveControl0d7_KjU;
                            final long j111111 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j111112 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j111112, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j111110, j111111, function111115, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j111112;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function111115;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j111113 = j9;
                            final Function3 function111116 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage7 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease7 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j111114 = jM11533getMainActiveControl0d7_KjU;
                            final long j111115 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function111117 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j111114, j111115, function111116, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function111116;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i315 = i27 >> 12;
                            long j218 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage7, null, j111113, j218, composableLambdaRememberComposableLambda7, lambda$1549156295$base_generalProdRelease7, ComposableLambdaKt.rememberComposableLambda(638276552, true, function111117, composer2, 54), composer2, (i315 & 7168) | (i315 & 896) | 1794048, 2);
                            j11 = j111113;
                            j12 = j218;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf13 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf14 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance16 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance16;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list110 = list2;
                        SnackbarHostState snackbarHostState16 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$12 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list110, snackbarHostState16, mutableIntState3, null);
                        function10 = function8;
                        list = list110;
                        snackbarHostState4 = snackbarHostState16;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$12;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list111 = list2;
                        SnackbarHostState snackbarHostState17 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$13 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list111, snackbarHostState17, mutableIntState3, null);
                        function10 = function8;
                        list = list111;
                        snackbarHostState4 = snackbarHostState17;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$13;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j219 = j10;
                    boolean z16 = z2;
                    int i316 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i316, 0.0f, null, null, z16, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j219;
                    i21 = i316;
                    z4 = z16;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier15;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list112 = list;
                    final Modifier modifier16 = modifier2;
                    final long j2110 = j8;
                    final TabsSelector tabsSelector11 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list112, t, tabNameProvider, modifier16, z4, i21, j5, j6, j7, j2110, tabsSelector11, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i18 = i16 | 384;
            if ((i3 & 3072) != 0) {
                i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
            }
            if ((i3 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            i20 = i18;
            if ((i5 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function111118 = function5;
                        i22 = i20 & (-7169);
                        function6 = function111118;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i317) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i317, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function111119 = function5;
                        i22 = i20;
                        function6 = function111119;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function1111110 = function5;
                        i22 = i20 & (-7169);
                        function6 = function1111110;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i317) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i317, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function1111111 = function5;
                        i22 = i20;
                        function6 = function1111111;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                }
                Object[] objArr8 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                boolean zChangedInstance17 = composerStartRestartGroup.changedInstance(tabs);
                i25 = i23;
                if ((i25 & 112) != 32) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                z6 = zChangedInstance17 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr8, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                i26 = i25 >> 9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                tabsSelector2 = tabsSelector4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                Modifier modifier17 = modifier2;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function8 = function6;
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
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                int iCommonTabsScreen_DuhZ5jU$lambda$9 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$9, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                composer2 = composerStartRestartGroup;
                if (z2) {
                    composer2.startReplaceGroup(-857019399);
                    ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                    if (tabs.size() >= 4) {
                        composer2.startReplaceGroup(-856995033);
                        ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                        final Function3 function1111112 = function7;
                        final long j111116 = jM11533getMainActiveControl0d7_KjU;
                        final long j111117 = jM11560getTabRowUnselectedContent0d7_KjU;
                        mutableIntState2 = mutableIntState;
                        long j111118 = j9;
                        TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j111118, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j111116, j111117, function1111112, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                        composer2.endReplaceGroup();
                        list2 = tabs;
                        j11 = j111118;
                        pagerState = pagerStateRememberPagerState;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        function9 = function1111112;
                        i27 = i25;
                    } else {
                        mutableIntState2 = mutableIntState;
                        long j111119 = j9;
                        final Function3 function1111113 = function7;
                        composer2.startReplaceGroup(-856152391);
                        ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                        int targetPage8 = pagerStateRememberPagerState.getTargetPage();
                        ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54);
                        Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease8 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                        final long j1111110 = jM11533getMainActiveControl0d7_KjU;
                        final long j1111111 = jM11560getTabRowUnselectedContent0d7_KjU;
                        Function2 function1111114 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1111110, j1111111, function1111113, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        list2 = tabs;
                        function9 = function1111113;
                        pagerState = pagerStateRememberPagerState;
                        i27 = i25;
                        int i317 = i27 >> 12;
                        long j2111 = jM11533getMainActiveControl0d7_KjU;
                        TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage8, null, j111119, j2111, composableLambdaRememberComposableLambda8, lambda$1549156295$base_generalProdRelease8, ComposableLambdaKt.rememberComposableLambda(638276552, true, function1111114, composer2, 54), composer2, (i317 & 7168) | (i317 & 896) | 1794048, 2);
                        j11 = j111119;
                        j12 = j2111;
                        composer2.endReplaceGroup();
                    }
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                } else {
                    mutableIntState2 = mutableIntState;
                    j11 = j9;
                    pagerState = pagerStateRememberPagerState;
                    function9 = function7;
                    j12 = jM11533getMainActiveControl0d7_KjU;
                    list2 = tabs;
                    i27 = i25;
                    j10 = j10;
                    composer2.startReplaceGroup(-863346747);
                }
                composer2.endReplaceGroup();
                Integer numValueOf15 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                mutableIntState3 = mutableIntState2;
                zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                if (!zChanged2) {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                Integer numValueOf16 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                if ((i22 & 896) == 256) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance18 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                if ((i22 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance18;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                if (z9) {
                    List<? extends T> list113 = list2;
                    SnackbarHostState snackbarHostState18 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$14 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list113, snackbarHostState18, mutableIntState3, null);
                    function10 = function8;
                    list = list113;
                    snackbarHostState4 = snackbarHostState18;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$14;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                } else {
                    List<? extends T> list114 = list2;
                    SnackbarHostState snackbarHostState19 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$15 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list114, snackbarHostState19, mutableIntState3, null);
                    function10 = function8;
                    list = list114;
                    snackbarHostState4 = snackbarHostState19;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$15;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf16, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                long j2112 = j10;
                boolean z17 = z2;
                int i318 = i24;
                PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i318, 0.0f, null, null, z17, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j2112;
                i21 = i318;
                z4 = z17;
                j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                snackbarHostState2 = snackbarHostState4;
                modifier2 = modifier17;
                function2 = function10;
                function4 = function9;
                j5 = j11;
                j6 = j12;
            } else {
                list = tabs;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                tabsSelector2 = tabsSelector;
                snackbarHostState2 = snackbarHostState;
                function2 = function1;
                function4 = function3;
                i21 = i9;
                j5 = jM11498getAppBackground0d7_KjU;
                z4 = z2;
                j6 = j2;
                j7 = j3;
                j8 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final List list115 = list;
                final Modifier modifier18 = modifier2;
                final long j2113 = j8;
                final TabsSelector tabsSelector12 = tabsSelector2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list115, t, tabNameProvider, modifier18, z4, i21, j5, j6, j7, j2113, tabsSelector12, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        modifier2 = modifier;
        i6 = i4 & 16;
        if (i6 != 0) {
            if ((i2 & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i5 |= i7;
            }
            i8 = i4 & 32;
            if (i8 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i9 = i;
            } else {
                i9 = i;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i9)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i5 |= i10;
                }
            }
            if ((i2 & 1572864) == 0) {
                jM11498getAppBackground0d7_KjU = j;
                if ((i4 & 64) == 0) {
                    i31 = 524288;
                } else {
                    i31 = 524288;
                }
                i5 |= i31;
            } else {
                jM11498getAppBackground0d7_KjU = j;
            }
            if ((i2 & 12582912) != 0) {
                if ((i4 & 128) == 0) {
                    i30 = 4194304;
                } else {
                    i30 = 4194304;
                }
                i5 |= i30;
            }
            if ((i2 & 100663296) != 0) {
                if ((i4 & 256) == 0) {
                    i29 = 33554432;
                } else {
                    i29 = 33554432;
                }
                i5 |= i29;
            }
            if ((i2 & 805306368) != 0) {
                if ((i4 & 512) == 0) {
                    i28 = 268435456;
                } else {
                    i28 = 268435456;
                }
                i5 |= i28;
            }
            i11 = i4 & 1024;
            if (i11 != 0) {
                i12 = i3 | 6;
            } else if ((i3 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(tabsSelector)) {
                    i13 = 4;
                } else {
                    i13 = 2;
                }
                i12 = i3 | i13;
            } else {
                i12 = i3;
            }
            i14 = i4 & 2048;
            if (i14 != 0) {
                if ((i3 & 48) == 0) {
                    if (composerStartRestartGroup.changed(snackbarHostState)) {
                        i15 = 32;
                    } else {
                        i15 = 16;
                    }
                    i12 |= i15;
                }
                i16 = i12;
                i17 = i4 & 4096;
                if (i17 != 0) {
                    i18 = i16;
                    if ((i3 & 384) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i19 = 256;
                        } else {
                            i19 = 128;
                        }
                        i18 |= i19;
                    }
                    if ((i3 & 3072) != 0) {
                        i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                    }
                    if ((i3 & 24576) == 0) {
                        i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    i20 = i18;
                    if ((i5 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                        if ((i2 & 1) != 0) {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function1111115 = function5;
                                i22 = i20 & (-7169);
                                function6 = function1111115;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i319) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i319, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function1111116 = function5;
                                i22 = i20;
                                function6 = function1111116;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        } else {
                            if (i32 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i6 != 0) {
                                z2 = true;
                            }
                            if (i8 != 0) {
                                i9 = 1;
                            }
                            if ((i4 & 64) != 0) {
                                jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                i5 &= -3670017;
                            }
                            if ((i4 & 128) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 &= -29360129;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j2;
                            }
                            if ((i4 & 256) != 0) {
                                jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                                i5 &= -234881025;
                            } else {
                                jM11560getTabRowUnselectedContent0d7_KjU = j3;
                            }
                            if ((i4 & 512) != 0) {
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i5 = (-1879048193) & i5;
                            } else {
                                jM11533getMainActiveControl0d7_KjU2 = j4;
                            }
                            if (i11 != 0) {
                                tabsSelector3 = null;
                            } else {
                                tabsSelector3 = tabsSelector;
                            }
                            if (i14 != 0) {
                                snackbarHostState3 = null;
                            } else {
                                snackbarHostState3 = snackbarHostState;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function5 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function5 = function1;
                            }
                            if ((i4 & 8192) != 0) {
                                Function1<? super T, Unit> function1111117 = function5;
                                i22 = i20 & (-7169);
                                function6 = function1111117;
                                function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                    public final Void invoke(T t2, Composer composer3, int i319) {
                                        composer3.startReplaceGroup(-2135625561);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2135625561, i319, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceGroup();
                                        return null;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                    }
                                };
                            } else {
                                Function1<? super T, Unit> function1111118 = function5;
                                i22 = i20;
                                function6 = function1111118;
                                function7 = function3;
                            }
                            i23 = i5;
                            j9 = jM11498getAppBackground0d7_KjU;
                            tabsSelector4 = tabsSelector3;
                            i24 = i9;
                            j10 = jM11533getMainActiveControl0d7_KjU2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                        }
                        Object[] objArr9 = new Object[0];
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        boolean zChangedInstance19 = composerStartRestartGroup.changedInstance(tabs);
                        i25 = i23;
                        if ((i25 & 112) != 32) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        z6 = zChangedInstance19 | z5;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr9, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                            composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                        i26 = i25 >> 9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        tabsSelector2 = tabsSelector4;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Modifier modifier19 = modifier2;
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function8 = function6;
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
                        Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                        int iCommonTabsScreen_DuhZ5jU$lambda$10 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Integer.valueOf(tabs.size());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$10, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                        composer2 = composerStartRestartGroup;
                        if (z2) {
                            composer2.startReplaceGroup(-857019399);
                            ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                            if (tabs.size() >= 4) {
                                composer2.startReplaceGroup(-856995033);
                                ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                                final Function3 function1111119 = function7;
                                final long j1111112 = jM11533getMainActiveControl0d7_KjU;
                                final long j1111113 = jM11560getTabRowUnselectedContent0d7_KjU;
                                mutableIntState2 = mutableIntState;
                                long j1111114 = j9;
                                TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j1111114, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1111112, j1111113, function1111119, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                                composer2.endReplaceGroup();
                                list2 = tabs;
                                j11 = j1111114;
                                pagerState = pagerStateRememberPagerState;
                                j12 = jM11533getMainActiveControl0d7_KjU;
                                function9 = function1111119;
                                i27 = i25;
                            } else {
                                mutableIntState2 = mutableIntState;
                                long j1111115 = j9;
                                final Function3 function11111110 = function7;
                                composer2.startReplaceGroup(-856152391);
                                ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                                int targetPage9 = pagerStateRememberPagerState.getTargetPage();
                                ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54);
                                Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease9 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                                final long j1111116 = jM11533getMainActiveControl0d7_KjU;
                                final long j1111117 = jM11560getTabRowUnselectedContent0d7_KjU;
                                Function2 function11111111 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1111116, j1111117, function11111110, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                list2 = tabs;
                                function9 = function11111110;
                                pagerState = pagerStateRememberPagerState;
                                i27 = i25;
                                int i319 = i27 >> 12;
                                long j2114 = jM11533getMainActiveControl0d7_KjU;
                                TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage9, null, j1111115, j2114, composableLambdaRememberComposableLambda9, lambda$1549156295$base_generalProdRelease9, ComposableLambdaKt.rememberComposableLambda(638276552, true, function11111111, composer2, 54), composer2, (i319 & 7168) | (i319 & 896) | 1794048, 2);
                                j11 = j1111115;
                                j12 = j2114;
                                composer2.endReplaceGroup();
                            }
                            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                        } else {
                            mutableIntState2 = mutableIntState;
                            j11 = j9;
                            pagerState = pagerStateRememberPagerState;
                            function9 = function7;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            list2 = tabs;
                            i27 = i25;
                            j10 = j10;
                            composer2.startReplaceGroup(-863346747);
                        }
                        composer2.endReplaceGroup();
                        Integer numValueOf17 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        mutableIntState3 = mutableIntState2;
                        zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged) {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf17, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                        ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged2) {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        } else {
                            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                        Integer numValueOf18 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                        ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        if ((i22 & 896) == 256) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean zChangedInstance110 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                        if ((i22 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance110;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                        if (z9) {
                            List<? extends T> list116 = list2;
                            SnackbarHostState snackbarHostState110 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$16 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list116, snackbarHostState110, mutableIntState3, null);
                            function10 = function8;
                            list = list116;
                            snackbarHostState4 = snackbarHostState110;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$16;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        } else {
                            List<? extends T> list117 = list2;
                            SnackbarHostState snackbarHostState111 = snackbarHostState3;
                            CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$17 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list117, snackbarHostState111, mutableIntState3, null);
                            function10 = function8;
                            list = list117;
                            snackbarHostState4 = snackbarHostState111;
                            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$17;
                            composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        EffectsKt.LaunchedEffect(numValueOf18, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                        long j2115 = j10;
                        boolean z18 = z2;
                        int i3110 = i24;
                        PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i3110, 0.0f, null, null, z18, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j8 = j2115;
                        i21 = i3110;
                        z4 = z18;
                        j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                        snackbarHostState2 = snackbarHostState4;
                        modifier2 = modifier19;
                        function2 = function10;
                        function4 = function9;
                        j5 = j11;
                        j6 = j12;
                    } else {
                        list = tabs;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        tabsSelector2 = tabsSelector;
                        snackbarHostState2 = snackbarHostState;
                        function2 = function1;
                        function4 = function3;
                        i21 = i9;
                        j5 = jM11498getAppBackground0d7_KjU;
                        z4 = z2;
                        j6 = j2;
                        j7 = j3;
                        j8 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final List list118 = list;
                        final Modifier modifier110 = modifier2;
                        final long j2116 = j8;
                        final TabsSelector tabsSelector13 = tabsSelector2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list118, t, tabNameProvider, modifier110, z4, i21, j5, j6, j7, j2116, tabsSelector13, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i18 = i16 | 384;
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function11111112 = function5;
                            i22 = i20 & (-7169);
                            function6 = function11111112;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3111) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3111, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function11111113 = function5;
                            i22 = i20;
                            function6 = function11111113;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function11111114 = function5;
                            i22 = i20 & (-7169);
                            function6 = function11111114;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3111) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3111, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function11111115 = function5;
                            i22 = i20;
                            function6 = function11111115;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr10 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance111 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance111 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr10, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier111 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$11 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$11, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function11111116 = function7;
                            final long j1111118 = jM11533getMainActiveControl0d7_KjU;
                            final long j1111119 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j11111110 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11111110, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1111118, j1111119, function11111116, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j11111110;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function11111116;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j11111111 = j9;
                            final Function3 function11111117 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage10 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease10 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j11111112 = jM11533getMainActiveControl0d7_KjU;
                            final long j11111113 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function11111118 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11111112, j11111113, function11111117, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function11111117;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i3111 = i27 >> 12;
                            long j2117 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage10, null, j11111111, j2117, composableLambdaRememberComposableLambda10, lambda$1549156295$base_generalProdRelease10, ComposableLambdaKt.rememberComposableLambda(638276552, true, function11111118, composer2, 54), composer2, (i3111 & 7168) | (i3111 & 896) | 1794048, 2);
                            j11 = j11111111;
                            j12 = j2117;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf19 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf19, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf110 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance112 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance112;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list119 = list2;
                        SnackbarHostState snackbarHostState112 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$18 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list119, snackbarHostState112, mutableIntState3, null);
                        function10 = function8;
                        list = list119;
                        snackbarHostState4 = snackbarHostState112;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$18;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list1110 = list2;
                        SnackbarHostState snackbarHostState113 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$19 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1110, snackbarHostState113, mutableIntState3, null);
                        function10 = function8;
                        list = list1110;
                        snackbarHostState4 = snackbarHostState113;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$19;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j2118 = j10;
                    boolean z19 = z2;
                    int i3112 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i3112, 0.0f, null, null, z19, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j2118;
                    i21 = i3112;
                    z4 = z19;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier111;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list1111 = list;
                    final Modifier modifier112 = modifier2;
                    final long j2119 = j8;
                    final TabsSelector tabsSelector14 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list1111, t, tabNameProvider, modifier112, z4, i21, j5, j6, j7, j2119, tabsSelector14, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 48;
            i16 = i12;
            i17 = i4 & 4096;
            if (i17 != 0) {
                i18 = i16;
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i19 = 256;
                    } else {
                        i19 = 128;
                    }
                    i18 |= i19;
                }
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function11111119 = function5;
                            i22 = i20 & (-7169);
                            function6 = function11111119;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3113) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3113, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function111111110 = function5;
                            i22 = i20;
                            function6 = function111111110;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function111111111 = function5;
                            i22 = i20 & (-7169);
                            function6 = function111111111;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3113) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3113, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function111111112 = function5;
                            i22 = i20;
                            function6 = function111111112;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr11 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance113 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance113 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr11, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier113 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$12 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$12, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function111111113 = function7;
                            final long j11111114 = jM11533getMainActiveControl0d7_KjU;
                            final long j11111115 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j11111116 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11111116, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j11111114, j11111115, function111111113, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j11111116;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function111111113;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j11111117 = j9;
                            final Function3 function111111114 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage11 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease11 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j11111118 = jM11533getMainActiveControl0d7_KjU;
                            final long j11111119 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function111111115 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11111118, j11111119, function111111114, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function111111114;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i3113 = i27 >> 12;
                            long j21110 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage11, null, j11111117, j21110, composableLambdaRememberComposableLambda11, lambda$1549156295$base_generalProdRelease11, ComposableLambdaKt.rememberComposableLambda(638276552, true, function111111115, composer2, 54), composer2, (i3113 & 7168) | (i3113 & 896) | 1794048, 2);
                            j11 = j11111117;
                            j12 = j21110;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf111 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf112 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance114 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance114;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list1112 = list2;
                        SnackbarHostState snackbarHostState114 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$110 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1112, snackbarHostState114, mutableIntState3, null);
                        function10 = function8;
                        list = list1112;
                        snackbarHostState4 = snackbarHostState114;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$110;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list1113 = list2;
                        SnackbarHostState snackbarHostState115 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$111 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1113, snackbarHostState115, mutableIntState3, null);
                        function10 = function8;
                        list = list1113;
                        snackbarHostState4 = snackbarHostState115;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$111;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j21111 = j10;
                    boolean z110 = z2;
                    int i3114 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i3114, 0.0f, null, null, z110, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j21111;
                    i21 = i3114;
                    z4 = z110;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier113;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list1114 = list;
                    final Modifier modifier114 = modifier2;
                    final long j21112 = j8;
                    final TabsSelector tabsSelector15 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list1114, t, tabNameProvider, modifier114, z4, i21, j5, j6, j7, j21112, tabsSelector15, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i18 = i16 | 384;
            if ((i3 & 3072) != 0) {
                i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
            }
            if ((i3 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            i20 = i18;
            if ((i5 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function111111116 = function5;
                        i22 = i20 & (-7169);
                        function6 = function111111116;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i3115) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i3115, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function111111117 = function5;
                        i22 = i20;
                        function6 = function111111117;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function111111118 = function5;
                        i22 = i20 & (-7169);
                        function6 = function111111118;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i3115) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i3115, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function111111119 = function5;
                        i22 = i20;
                        function6 = function111111119;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                }
                Object[] objArr12 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                boolean zChangedInstance115 = composerStartRestartGroup.changedInstance(tabs);
                i25 = i23;
                if ((i25 & 112) != 32) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                z6 = zChangedInstance115 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr12, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                i26 = i25 >> 9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                tabsSelector2 = tabsSelector4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                Modifier modifier115 = modifier2;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function8 = function6;
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
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                int iCommonTabsScreen_DuhZ5jU$lambda$13 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$13, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                composer2 = composerStartRestartGroup;
                if (z2) {
                    composer2.startReplaceGroup(-857019399);
                    ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                    if (tabs.size() >= 4) {
                        composer2.startReplaceGroup(-856995033);
                        ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                        final Function3 function1111111110 = function7;
                        final long j111111110 = jM11533getMainActiveControl0d7_KjU;
                        final long j111111111 = jM11560getTabRowUnselectedContent0d7_KjU;
                        mutableIntState2 = mutableIntState;
                        long j111111112 = j9;
                        TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j111111112, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j111111110, j111111111, function1111111110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                        composer2.endReplaceGroup();
                        list2 = tabs;
                        j11 = j111111112;
                        pagerState = pagerStateRememberPagerState;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        function9 = function1111111110;
                        i27 = i25;
                    } else {
                        mutableIntState2 = mutableIntState;
                        long j111111113 = j9;
                        final Function3 function1111111111 = function7;
                        composer2.startReplaceGroup(-856152391);
                        ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                        int targetPage12 = pagerStateRememberPagerState.getTargetPage();
                        ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54);
                        Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease12 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                        final long j111111114 = jM11533getMainActiveControl0d7_KjU;
                        final long j111111115 = jM11560getTabRowUnselectedContent0d7_KjU;
                        Function2 function1111111112 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j111111114, j111111115, function1111111111, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        list2 = tabs;
                        function9 = function1111111111;
                        pagerState = pagerStateRememberPagerState;
                        i27 = i25;
                        int i3115 = i27 >> 12;
                        long j21113 = jM11533getMainActiveControl0d7_KjU;
                        TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage12, null, j111111113, j21113, composableLambdaRememberComposableLambda12, lambda$1549156295$base_generalProdRelease12, ComposableLambdaKt.rememberComposableLambda(638276552, true, function1111111112, composer2, 54), composer2, (i3115 & 7168) | (i3115 & 896) | 1794048, 2);
                        j11 = j111111113;
                        j12 = j21113;
                        composer2.endReplaceGroup();
                    }
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                } else {
                    mutableIntState2 = mutableIntState;
                    j11 = j9;
                    pagerState = pagerStateRememberPagerState;
                    function9 = function7;
                    j12 = jM11533getMainActiveControl0d7_KjU;
                    list2 = tabs;
                    i27 = i25;
                    j10 = j10;
                    composer2.startReplaceGroup(-863346747);
                }
                composer2.endReplaceGroup();
                Integer numValueOf113 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                mutableIntState3 = mutableIntState2;
                zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                if (!zChanged2) {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                Integer numValueOf114 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                if ((i22 & 896) == 256) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance116 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                if ((i22 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance116;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                if (z9) {
                    List<? extends T> list1115 = list2;
                    SnackbarHostState snackbarHostState116 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$112 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1115, snackbarHostState116, mutableIntState3, null);
                    function10 = function8;
                    list = list1115;
                    snackbarHostState4 = snackbarHostState116;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$112;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                } else {
                    List<? extends T> list1116 = list2;
                    SnackbarHostState snackbarHostState117 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$113 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1116, snackbarHostState117, mutableIntState3, null);
                    function10 = function8;
                    list = list1116;
                    snackbarHostState4 = snackbarHostState117;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$113;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                long j21114 = j10;
                boolean z111 = z2;
                int i3116 = i24;
                PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i3116, 0.0f, null, null, z111, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j21114;
                i21 = i3116;
                z4 = z111;
                j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                snackbarHostState2 = snackbarHostState4;
                modifier2 = modifier115;
                function2 = function10;
                function4 = function9;
                j5 = j11;
                j6 = j12;
            } else {
                list = tabs;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                tabsSelector2 = tabsSelector;
                snackbarHostState2 = snackbarHostState;
                function2 = function1;
                function4 = function3;
                i21 = i9;
                j5 = jM11498getAppBackground0d7_KjU;
                z4 = z2;
                j6 = j2;
                j7 = j3;
                j8 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final List list1117 = list;
                final Modifier modifier116 = modifier2;
                final long j21115 = j8;
                final TabsSelector tabsSelector16 = tabsSelector2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list1117, t, tabNameProvider, modifier116, z4, i21, j5, j6, j7, j21115, tabsSelector16, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        z2 = z;
        i8 = i4 & 32;
        if (i8 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i9 = i;
        } else {
            i9 = i;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i9)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i5 |= i10;
            }
        }
        if ((i2 & 1572864) == 0) {
            jM11498getAppBackground0d7_KjU = j;
            if ((i4 & 64) == 0) {
                i31 = 524288;
            } else {
                i31 = 524288;
            }
            i5 |= i31;
        } else {
            jM11498getAppBackground0d7_KjU = j;
        }
        if ((i2 & 12582912) != 0) {
            if ((i4 & 128) == 0) {
                i30 = 4194304;
            } else {
                i30 = 4194304;
            }
            i5 |= i30;
        }
        if ((i2 & 100663296) != 0) {
            if ((i4 & 256) == 0) {
                i29 = 33554432;
            } else {
                i29 = 33554432;
            }
            i5 |= i29;
        }
        if ((i2 & 805306368) != 0) {
            if ((i4 & 512) == 0) {
                i28 = 268435456;
            } else {
                i28 = 268435456;
            }
            i5 |= i28;
        }
        i11 = i4 & 1024;
        if (i11 != 0) {
            i12 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(tabsSelector)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i3 | i13;
        } else {
            i12 = i3;
        }
        i14 = i4 & 2048;
        if (i14 != 0) {
            if ((i3 & 48) == 0) {
                if (composerStartRestartGroup.changed(snackbarHostState)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
                i12 |= i15;
            }
            i16 = i12;
            i17 = i4 & 4096;
            if (i17 != 0) {
                i18 = i16;
                if ((i3 & 384) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i19 = 256;
                    } else {
                        i19 = 128;
                    }
                    i18 |= i19;
                }
                if ((i3 & 3072) != 0) {
                    i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
                }
                if ((i3 & 24576) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                }
                i20 = i18;
                if ((i5 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                    if ((i2 & 1) != 0) {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function1111111113 = function5;
                            i22 = i20 & (-7169);
                            function6 = function1111111113;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3117) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3117, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function1111111114 = function5;
                            i22 = i20;
                            function6 = function1111111114;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        if (i32 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i6 != 0) {
                            z2 = true;
                        }
                        if (i8 != 0) {
                            i9 = 1;
                        }
                        if ((i4 & 64) != 0) {
                            jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            i5 &= -3670017;
                        }
                        if ((i4 & 128) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 &= -29360129;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j2;
                        }
                        if ((i4 & 256) != 0) {
                            jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                            i5 &= -234881025;
                        } else {
                            jM11560getTabRowUnselectedContent0d7_KjU = j3;
                        }
                        if ((i4 & 512) != 0) {
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i5 = (-1879048193) & i5;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j4;
                        }
                        if (i11 != 0) {
                            tabsSelector3 = null;
                        } else {
                            tabsSelector3 = tabsSelector;
                        }
                        if (i14 != 0) {
                            snackbarHostState3 = null;
                        } else {
                            snackbarHostState3 = snackbarHostState;
                        }
                        if (i17 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function5 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function1;
                        }
                        if ((i4 & 8192) != 0) {
                            Function1<? super T, Unit> function1111111115 = function5;
                            i22 = i20 & (-7169);
                            function6 = function1111111115;
                            function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                                public final Void invoke(T t2, Composer composer3, int i3117) {
                                    composer3.startReplaceGroup(-2135625561);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2135625561, i3117, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                                }
                            };
                        } else {
                            Function1<? super T, Unit> function1111111116 = function5;
                            i22 = i20;
                            function6 = function1111111116;
                            function7 = function3;
                        }
                        i23 = i5;
                        j9 = jM11498getAppBackground0d7_KjU;
                        tabsSelector4 = tabsSelector3;
                        i24 = i9;
                        j10 = jM11533getMainActiveControl0d7_KjU2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                    }
                    Object[] objArr13 = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    boolean zChangedInstance117 = composerStartRestartGroup.changedInstance(tabs);
                    i25 = i23;
                    if ((i25 & 112) != 32) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    z6 = zChangedInstance117 | z5;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr13, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                        composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                    i26 = i25 >> 9;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    tabsSelector2 = tabsSelector4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    Modifier modifier117 = modifier2;
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function8 = function6;
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
                    Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                    int iCommonTabsScreen_DuhZ5jU$lambda$14 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(tabs.size());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$14, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                    composer2 = composerStartRestartGroup;
                    if (z2) {
                        composer2.startReplaceGroup(-857019399);
                        ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                        if (tabs.size() >= 4) {
                            composer2.startReplaceGroup(-856995033);
                            ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                            final Function3 function1111111117 = function7;
                            final long j111111116 = jM11533getMainActiveControl0d7_KjU;
                            final long j111111117 = jM11560getTabRowUnselectedContent0d7_KjU;
                            mutableIntState2 = mutableIntState;
                            long j111111118 = j9;
                            TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j111111118, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j111111116, j111111117, function1111111117, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                            composer2.endReplaceGroup();
                            list2 = tabs;
                            j11 = j111111118;
                            pagerState = pagerStateRememberPagerState;
                            j12 = jM11533getMainActiveControl0d7_KjU;
                            function9 = function1111111117;
                            i27 = i25;
                        } else {
                            mutableIntState2 = mutableIntState;
                            long j111111119 = j9;
                            final Function3 function1111111118 = function7;
                            composer2.startReplaceGroup(-856152391);
                            ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                            int targetPage13 = pagerStateRememberPagerState.getTargetPage();
                            ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54);
                            Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease13 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                            final long j1111111110 = jM11533getMainActiveControl0d7_KjU;
                            final long j1111111111 = jM11560getTabRowUnselectedContent0d7_KjU;
                            Function2 function1111111119 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1111111110, j1111111111, function1111111118, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            list2 = tabs;
                            function9 = function1111111118;
                            pagerState = pagerStateRememberPagerState;
                            i27 = i25;
                            int i3117 = i27 >> 12;
                            long j21116 = jM11533getMainActiveControl0d7_KjU;
                            TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage13, null, j111111119, j21116, composableLambdaRememberComposableLambda13, lambda$1549156295$base_generalProdRelease13, ComposableLambdaKt.rememberComposableLambda(638276552, true, function1111111119, composer2, 54), composer2, (i3117 & 7168) | (i3117 & 896) | 1794048, 2);
                            j11 = j111111119;
                            j12 = j21116;
                            composer2.endReplaceGroup();
                        }
                        BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                    } else {
                        mutableIntState2 = mutableIntState;
                        j11 = j9;
                        pagerState = pagerStateRememberPagerState;
                        function9 = function7;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        list2 = tabs;
                        i27 = i25;
                        j10 = j10;
                        composer2.startReplaceGroup(-863346747);
                    }
                    composer2.endReplaceGroup();
                    Integer numValueOf115 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    mutableIntState3 = mutableIntState2;
                    zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged) {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged2) {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    } else {
                        commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                    Integer numValueOf116 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                    ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    if ((i22 & 896) == 256) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean zChangedInstance118 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                    if ((i22 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance118;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                    if (z9) {
                        List<? extends T> list1118 = list2;
                        SnackbarHostState snackbarHostState118 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$114 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1118, snackbarHostState118, mutableIntState3, null);
                        function10 = function8;
                        list = list1118;
                        snackbarHostState4 = snackbarHostState118;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$114;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    } else {
                        List<? extends T> list1119 = list2;
                        SnackbarHostState snackbarHostState119 = snackbarHostState3;
                        CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$115 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list1119, snackbarHostState119, mutableIntState3, null);
                        function10 = function8;
                        list = list1119;
                        snackbarHostState4 = snackbarHostState119;
                        commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$115;
                        composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(numValueOf116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                    long j21117 = j10;
                    boolean z112 = z2;
                    int i3118 = i24;
                    PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i3118, 0.0f, null, null, z112, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j21117;
                    i21 = i3118;
                    z4 = z112;
                    j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                    snackbarHostState2 = snackbarHostState4;
                    modifier2 = modifier117;
                    function2 = function10;
                    function4 = function9;
                    j5 = j11;
                    j6 = j12;
                } else {
                    list = tabs;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    tabsSelector2 = tabsSelector;
                    snackbarHostState2 = snackbarHostState;
                    function2 = function1;
                    function4 = function3;
                    i21 = i9;
                    j5 = jM11498getAppBackground0d7_KjU;
                    z4 = z2;
                    j6 = j2;
                    j7 = j3;
                    j8 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final List list11110 = list;
                    final Modifier modifier118 = modifier2;
                    final long j21118 = j8;
                    final TabsSelector tabsSelector17 = tabsSelector2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list11110, t, tabNameProvider, modifier118, z4, i21, j5, j6, j7, j21118, tabsSelector17, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i18 = i16 | 384;
            if ((i3 & 3072) != 0) {
                i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
            }
            if ((i3 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            i20 = i18;
            if ((i5 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function11111111110 = function5;
                        i22 = i20 & (-7169);
                        function6 = function11111111110;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i3119) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i3119, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function11111111111 = function5;
                        i22 = i20;
                        function6 = function11111111111;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function11111111112 = function5;
                        i22 = i20 & (-7169);
                        function6 = function11111111112;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i3119) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i3119, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function11111111113 = function5;
                        i22 = i20;
                        function6 = function11111111113;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                }
                Object[] objArr14 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                boolean zChangedInstance119 = composerStartRestartGroup.changedInstance(tabs);
                i25 = i23;
                if ((i25 & 112) != 32) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                z6 = zChangedInstance119 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr14, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                i26 = i25 >> 9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                tabsSelector2 = tabsSelector4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                Modifier modifier119 = modifier2;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function8 = function6;
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
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                int iCommonTabsScreen_DuhZ5jU$lambda$15 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$15, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                composer2 = composerStartRestartGroup;
                if (z2) {
                    composer2.startReplaceGroup(-857019399);
                    ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                    if (tabs.size() >= 4) {
                        composer2.startReplaceGroup(-856995033);
                        ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                        final Function3 function11111111114 = function7;
                        final long j1111111112 = jM11533getMainActiveControl0d7_KjU;
                        final long j1111111113 = jM11560getTabRowUnselectedContent0d7_KjU;
                        mutableIntState2 = mutableIntState;
                        long j1111111114 = j9;
                        TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j1111111114, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1111111112, j1111111113, function11111111114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                        composer2.endReplaceGroup();
                        list2 = tabs;
                        j11 = j1111111114;
                        pagerState = pagerStateRememberPagerState;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        function9 = function11111111114;
                        i27 = i25;
                    } else {
                        mutableIntState2 = mutableIntState;
                        long j1111111115 = j9;
                        final Function3 function11111111115 = function7;
                        composer2.startReplaceGroup(-856152391);
                        ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                        int targetPage14 = pagerStateRememberPagerState.getTargetPage();
                        ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54);
                        Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease14 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                        final long j1111111116 = jM11533getMainActiveControl0d7_KjU;
                        final long j1111111117 = jM11560getTabRowUnselectedContent0d7_KjU;
                        Function2 function11111111116 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j1111111116, j1111111117, function11111111115, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        list2 = tabs;
                        function9 = function11111111115;
                        pagerState = pagerStateRememberPagerState;
                        i27 = i25;
                        int i3119 = i27 >> 12;
                        long j21119 = jM11533getMainActiveControl0d7_KjU;
                        TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage14, null, j1111111115, j21119, composableLambdaRememberComposableLambda14, lambda$1549156295$base_generalProdRelease14, ComposableLambdaKt.rememberComposableLambda(638276552, true, function11111111116, composer2, 54), composer2, (i3119 & 7168) | (i3119 & 896) | 1794048, 2);
                        j11 = j1111111115;
                        j12 = j21119;
                        composer2.endReplaceGroup();
                    }
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                } else {
                    mutableIntState2 = mutableIntState;
                    j11 = j9;
                    pagerState = pagerStateRememberPagerState;
                    function9 = function7;
                    j12 = jM11533getMainActiveControl0d7_KjU;
                    list2 = tabs;
                    i27 = i25;
                    j10 = j10;
                    composer2.startReplaceGroup(-863346747);
                }
                composer2.endReplaceGroup();
                Integer numValueOf117 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                mutableIntState3 = mutableIntState2;
                zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                if (!zChanged2) {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                Integer numValueOf118 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                if ((i22 & 896) == 256) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance1110 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                if ((i22 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance1110;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                if (z9) {
                    List<? extends T> list11111 = list2;
                    SnackbarHostState snackbarHostState1110 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$116 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11111, snackbarHostState1110, mutableIntState3, null);
                    function10 = function8;
                    list = list11111;
                    snackbarHostState4 = snackbarHostState1110;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$116;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                } else {
                    List<? extends T> list11112 = list2;
                    SnackbarHostState snackbarHostState1111 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$117 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11112, snackbarHostState1111, mutableIntState3, null);
                    function10 = function8;
                    list = list11112;
                    snackbarHostState4 = snackbarHostState1111;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$117;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                long j211110 = j10;
                boolean z113 = z2;
                int i31110 = i24;
                PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i31110, 0.0f, null, null, z113, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j211110;
                i21 = i31110;
                z4 = z113;
                j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                snackbarHostState2 = snackbarHostState4;
                modifier2 = modifier119;
                function2 = function10;
                function4 = function9;
                j5 = j11;
                j6 = j12;
            } else {
                list = tabs;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                tabsSelector2 = tabsSelector;
                snackbarHostState2 = snackbarHostState;
                function2 = function1;
                function4 = function3;
                i21 = i9;
                j5 = jM11498getAppBackground0d7_KjU;
                z4 = z2;
                j6 = j2;
                j7 = j3;
                j8 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final List list11113 = list;
                final Modifier modifier1110 = modifier2;
                final long j211111 = j8;
                final TabsSelector tabsSelector18 = tabsSelector2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list11113, t, tabNameProvider, modifier1110, z4, i21, j5, j6, j7, j211111, tabsSelector18, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 48;
        i16 = i12;
        i17 = i4 & 4096;
        if (i17 != 0) {
            i18 = i16;
            if ((i3 & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i19 = 256;
                } else {
                    i19 = 128;
                }
                i18 |= i19;
            }
            if ((i3 & 3072) != 0) {
                i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
            }
            if ((i3 & 24576) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
            }
            i20 = i18;
            if ((i5 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
                if ((i2 & 1) != 0) {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function11111111117 = function5;
                        i22 = i20 & (-7169);
                        function6 = function11111111117;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i31111) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i31111, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function11111111118 = function5;
                        i22 = i20;
                        function6 = function11111111118;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    if (i32 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if (i8 != 0) {
                        i9 = 1;
                    }
                    if ((i4 & 64) != 0) {
                        jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        i5 &= -3670017;
                    }
                    if ((i4 & 128) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 &= -29360129;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j2;
                    }
                    if ((i4 & 256) != 0) {
                        jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                        i5 &= -234881025;
                    } else {
                        jM11560getTabRowUnselectedContent0d7_KjU = j3;
                    }
                    if ((i4 & 512) != 0) {
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i5 = (-1879048193) & i5;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j4;
                    }
                    if (i11 != 0) {
                        tabsSelector3 = null;
                    } else {
                        tabsSelector3 = tabsSelector;
                    }
                    if (i14 != 0) {
                        snackbarHostState3 = null;
                    } else {
                        snackbarHostState3 = snackbarHostState;
                    }
                    if (i17 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function5 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function1;
                    }
                    if ((i4 & 8192) != 0) {
                        Function1<? super T, Unit> function11111111119 = function5;
                        i22 = i20 & (-7169);
                        function6 = function11111111119;
                        function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                            public final Void invoke(T t2, Composer composer3, int i31111) {
                                composer3.startReplaceGroup(-2135625561);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2135625561, i31111, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return null;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                            }
                        };
                    } else {
                        Function1<? super T, Unit> function111111111110 = function5;
                        i22 = i20;
                        function6 = function111111111110;
                        function7 = function3;
                    }
                    i23 = i5;
                    j9 = jM11498getAppBackground0d7_KjU;
                    tabsSelector4 = tabsSelector3;
                    i24 = i9;
                    j10 = jM11533getMainActiveControl0d7_KjU2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
                }
                Object[] objArr15 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
                boolean zChangedInstance1111 = composerStartRestartGroup.changedInstance(tabs);
                i25 = i23;
                if ((i25 & 112) != 32) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                z6 = zChangedInstance1111 | z5;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr15, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
                i26 = i25 >> 9;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                tabsSelector2 = tabsSelector4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                Modifier modifier1111 = modifier2;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function8 = function6;
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
                Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
                int iCommonTabsScreen_DuhZ5jU$lambda$16 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(tabs.size());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$16, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
                composer2 = composerStartRestartGroup;
                if (z2) {
                    composer2.startReplaceGroup(-857019399);
                    ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                    if (tabs.size() >= 4) {
                        composer2.startReplaceGroup(-856995033);
                        ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                        final Function3 function111111111111 = function7;
                        final long j1111111118 = jM11533getMainActiveControl0d7_KjU;
                        final long j1111111119 = jM11560getTabRowUnselectedContent0d7_KjU;
                        mutableIntState2 = mutableIntState;
                        long j11111111110 = j9;
                        TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11111111110, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j1111111118, j1111111119, function111111111111, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                        composer2.endReplaceGroup();
                        list2 = tabs;
                        j11 = j11111111110;
                        pagerState = pagerStateRememberPagerState;
                        j12 = jM11533getMainActiveControl0d7_KjU;
                        function9 = function111111111111;
                        i27 = i25;
                    } else {
                        mutableIntState2 = mutableIntState;
                        long j11111111111 = j9;
                        final Function3 function111111111112 = function7;
                        composer2.startReplaceGroup(-856152391);
                        ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                        int targetPage15 = pagerStateRememberPagerState.getTargetPage();
                        ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54);
                        Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease15 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                        final long j11111111112 = jM11533getMainActiveControl0d7_KjU;
                        final long j11111111113 = jM11560getTabRowUnselectedContent0d7_KjU;
                        Function2 function111111111113 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11111111112, j11111111113, function111111111112, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        list2 = tabs;
                        function9 = function111111111112;
                        pagerState = pagerStateRememberPagerState;
                        i27 = i25;
                        int i31111 = i27 >> 12;
                        long j211112 = jM11533getMainActiveControl0d7_KjU;
                        TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage15, null, j11111111111, j211112, composableLambdaRememberComposableLambda15, lambda$1549156295$base_generalProdRelease15, ComposableLambdaKt.rememberComposableLambda(638276552, true, function111111111113, composer2, 54), composer2, (i31111 & 7168) | (i31111 & 896) | 1794048, 2);
                        j11 = j11111111111;
                        j12 = j211112;
                        composer2.endReplaceGroup();
                    }
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
                } else {
                    mutableIntState2 = mutableIntState;
                    j11 = j9;
                    pagerState = pagerStateRememberPagerState;
                    function9 = function7;
                    j12 = jM11533getMainActiveControl0d7_KjU;
                    list2 = tabs;
                    i27 = i25;
                    j10 = j10;
                    composer2.startReplaceGroup(-863346747);
                }
                composer2.endReplaceGroup();
                Integer numValueOf119 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
                ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
                mutableIntState3 = mutableIntState2;
                zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
                zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
                if (!zChanged2) {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                } else {
                    commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
                Integer numValueOf1110 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
                ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
                if ((i22 & 896) == 256) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance1112 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
                if ((i22 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance1112;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
                if (z9) {
                    List<? extends T> list11114 = list2;
                    SnackbarHostState snackbarHostState1112 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$118 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11114, snackbarHostState1112, mutableIntState3, null);
                    function10 = function8;
                    list = list11114;
                    snackbarHostState4 = snackbarHostState1112;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$118;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                } else {
                    List<? extends T> list11115 = list2;
                    SnackbarHostState snackbarHostState1113 = snackbarHostState3;
                    CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$119 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11115, snackbarHostState1113, mutableIntState3, null);
                    function10 = function8;
                    list = list11115;
                    snackbarHostState4 = snackbarHostState1113;
                    commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$119;
                    composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(numValueOf1110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
                long j211113 = j10;
                boolean z114 = z2;
                int i31112 = i24;
                PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i31112, 0.0f, null, null, z114, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j211113;
                i21 = i31112;
                z4 = z114;
                j7 = jM11560getTabRowUnselectedContent0d7_KjU;
                snackbarHostState2 = snackbarHostState4;
                modifier2 = modifier1111;
                function2 = function10;
                function4 = function9;
                j5 = j11;
                j6 = j12;
            } else {
                list = tabs;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                tabsSelector2 = tabsSelector;
                snackbarHostState2 = snackbarHostState;
                function2 = function1;
                function4 = function3;
                i21 = i9;
                j5 = jM11498getAppBackground0d7_KjU;
                z4 = z2;
                j6 = j2;
                j7 = j3;
                j8 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final List list11116 = list;
                final Modifier modifier1112 = modifier2;
                final long j211114 = j8;
                final TabsSelector tabsSelector19 = tabsSelector2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list11116, t, tabNameProvider, modifier1112, z4, i21, j5, j6, j7, j211114, tabsSelector19, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i18 = i16 | 384;
        if ((i3 & 3072) != 0) {
            i18 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 1024 : 2048;
        }
        if ((i3 & 24576) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
        }
        i20 = i18;
        if ((i5 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "89@3868L6,90@3933L6,91@4004L6,92@4073L6,95@4231L2");
            if ((i2 & 1) != 0) {
                if (i32 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    i9 = 1;
                }
                if ((i4 & 64) != 0) {
                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    i5 &= -3670017;
                }
                if ((i4 & 128) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i5 &= -29360129;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j2;
                }
                if ((i4 & 256) != 0) {
                    jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                    i5 &= -234881025;
                } else {
                    jM11560getTabRowUnselectedContent0d7_KjU = j3;
                }
                if ((i4 & 512) != 0) {
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i5 = (-1879048193) & i5;
                } else {
                    jM11533getMainActiveControl0d7_KjU2 = j4;
                }
                if (i11 != 0) {
                    tabsSelector3 = null;
                } else {
                    tabsSelector3 = tabsSelector;
                }
                if (i14 != 0) {
                    snackbarHostState3 = null;
                } else {
                    snackbarHostState3 = snackbarHostState;
                }
                if (i17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function5 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function1;
                }
                if ((i4 & 8192) != 0) {
                    Function1<? super T, Unit> function111111111114 = function5;
                    i22 = i20 & (-7169);
                    function6 = function111111111114;
                    function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                        public final Void invoke(T t2, Composer composer3, int i31113) {
                            composer3.startReplaceGroup(-2135625561);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2135625561, i31113, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                        }
                    };
                } else {
                    Function1<? super T, Unit> function111111111115 = function5;
                    i22 = i20;
                    function6 = function111111111115;
                    function7 = function3;
                }
                i23 = i5;
                j9 = jM11498getAppBackground0d7_KjU;
                tabsSelector4 = tabsSelector3;
                i24 = i9;
                j10 = jM11533getMainActiveControl0d7_KjU2;
            } else {
                if (i32 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if (i8 != 0) {
                    i9 = 1;
                }
                if ((i4 & 64) != 0) {
                    jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    i5 &= -3670017;
                }
                if ((i4 & 128) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i5 &= -29360129;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j2;
                }
                if ((i4 & 256) != 0) {
                    jM11560getTabRowUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11560getTabRowUnselectedContent0d7_KjU();
                    i5 &= -234881025;
                } else {
                    jM11560getTabRowUnselectedContent0d7_KjU = j3;
                }
                if ((i4 & 512) != 0) {
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i5 = (-1879048193) & i5;
                } else {
                    jM11533getMainActiveControl0d7_KjU2 = j4;
                }
                if (i11 != 0) {
                    tabsSelector3 = null;
                } else {
                    tabsSelector3 = tabsSelector;
                }
                if (i14 != 0) {
                    snackbarHostState3 = null;
                } else {
                    snackbarHostState3 = snackbarHostState;
                }
                if (i17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163370091, "CC(remember):CommonTabsScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$0$0(obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function5 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function1;
                }
                if ((i4 & 8192) != 0) {
                    Function1<? super T, Unit> function111111111116 = function5;
                    i22 = i20 & (-7169);
                    function6 = function111111111116;
                    function7 = new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$2
                        public final Void invoke(T t2, Composer composer3, int i31113) {
                            composer3.startReplaceGroup(-2135625561);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2135625561, i31113, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous> (CommonTabsScreen.kt:96)");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
                        }
                    };
                } else {
                    Function1<? super T, Unit> function111111111117 = function5;
                    i22 = i20;
                    function6 = function111111111117;
                    function7 = function3;
                }
                i23 = i5;
                j9 = jM11498getAppBackground0d7_KjU;
                tabsSelector4 = tabsSelector3;
                i24 = i9;
                j10 = jM11533getMainActiveControl0d7_KjU2;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-331936493, i23, i22, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen (CommonTabsScreen.kt:98)");
            }
            Object[] objArr16 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163364532, "CC(remember):CommonTabsScreen.kt#9igjgp");
            boolean zChangedInstance1113 = composerStartRestartGroup.changedInstance(tabs);
            i25 = i23;
            if ((i25 & 112) != 32) {
                z5 = true;
            } else {
                z5 = true;
            }
            z6 = zChangedInstance1113 | z5;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$1$0(tabs, t);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr16, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1163361469, "CC(remember):CommonTabsScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(tabsSelector4) | composerStartRestartGroup.changedInstance(tabs) | composerStartRestartGroup.changed(mutableIntState);
            commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
            } else {
                commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$3$1(tabsSelector4, tabs, mutableIntState, null);
                composerStartRestartGroup.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(tabsSelector4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$3$1RememberedValue, composerStartRestartGroup, i22 & 14);
            i26 = i25 >> 9;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            tabsSelector2 = tabsSelector4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
            Modifier modifier1113 = modifier2;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            function8 = function6;
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
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -858535546, "C113@4819L13,111@4732L110,189@8208L149,189@8176L181,194@8393L144,194@8366L171,200@8586L128,200@8547L167,209@8892L111,205@8724L279:CommonTabsScreen.kt#gqlnsh");
            int iCommonTabsScreen_DuhZ5jU$lambda$17 = CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 110851690, "CC(remember):CommonTabsScreen.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(tabs);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(tabs.size());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(tabs.size());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            pagerStateRememberPagerState = PagerStateKt.rememberPagerState(iCommonTabsScreen_DuhZ5jU$lambda$17, 0.0f, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 2);
            composer2 = composerStartRestartGroup;
            if (z2) {
                composer2.startReplaceGroup(-857019399);
                ComposerKt.sourceInformation(composer2, "185@8089L6,185@8051L64");
                if (tabs.size() >= 4) {
                    composer2.startReplaceGroup(-856995033);
                    ComposerKt.sourceInformation(composer2, "154@6605L455,164@7153L53,150@6376L830");
                    final Function3 function111111111118 = function7;
                    final long j11111111114 = jM11533getMainActiveControl0d7_KjU;
                    final long j11111111115 = jM11560getTabRowUnselectedContent0d7_KjU;
                    mutableIntState2 = mutableIntState;
                    long j11111111116 = j9;
                    TabRowKt.m4386PrimaryScrollableTabRowcx2KkNY(pagerStateRememberPagerState.getTargetPage(), null, null, j11111111116, jM11533getMainActiveControl0d7_KjU, Dp.m9687constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(-783933130, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$2(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), ComposableSingletons$CommonTabsScreenKt.INSTANCE.m11835getLambda$946834485$base_generalProdRelease(), 0.0f, ComposableLambdaKt.rememberComposableLambda(-503011123, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$3(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState, j11111111114, j11111111115, function111111111118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, (i26 & 7168) | 819658752 | (i26 & 57344), 262);
                    composer2.endReplaceGroup();
                    list2 = tabs;
                    j11 = j11111111116;
                    pagerState = pagerStateRememberPagerState;
                    j12 = jM11533getMainActiveControl0d7_KjU;
                    function9 = function111111111118;
                    i27 = i25;
                } else {
                    mutableIntState2 = mutableIntState;
                    long j11111111117 = j9;
                    final Function3 function111111111119 = function7;
                    composer2.startReplaceGroup(-856152391);
                    ComposerKt.sourceInformation(composer2, "172@7463L455,181@7971L53,168@7244L780");
                    int targetPage16 = pagerStateRememberPagerState.getTargetPage();
                    ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-999524942, true, new Function3() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$4(pagerStateRememberPagerState, j10, (TabIndicatorScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54);
                    Function2<Composer, Integer, Unit> lambda$1549156295$base_generalProdRelease16 = ComposableSingletons$CommonTabsScreenKt.INSTANCE.getLambda$1549156295$base_generalProdRelease();
                    final long j11111111118 = jM11533getMainActiveControl0d7_KjU;
                    final long j11111111119 = jM11560getTabRowUnselectedContent0d7_KjU;
                    Function2 function1111111111110 = new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$5(tabs, pagerStateRememberPagerState, tabNameProvider, i25, mutableIntState2, j11111111118, j11111111119, function111111111119, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    list2 = tabs;
                    function9 = function111111111119;
                    pagerState = pagerStateRememberPagerState;
                    i27 = i25;
                    int i31113 = i27 >> 12;
                    long j211115 = jM11533getMainActiveControl0d7_KjU;
                    TabRowKt.m4388PrimaryTabRowpAZo6Ak(targetPage16, null, j11111111117, j211115, composableLambdaRememberComposableLambda16, lambda$1549156295$base_generalProdRelease16, ComposableLambdaKt.rememberComposableLambda(638276552, true, function1111111111110, composer2, 54), composer2, (i31113 & 7168) | (i31113 & 896) | 1794048, 2);
                    j11 = j11111111117;
                    j12 = j211115;
                    composer2.endReplaceGroup();
                }
                BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, BoxTheme.INSTANCE.getColors(composer2, 6).m11532getItemListingDivider0d7_KjU(), composer2, 0, 3);
            } else {
                mutableIntState2 = mutableIntState;
                j11 = j9;
                pagerState = pagerStateRememberPagerState;
                function9 = function7;
                j12 = jM11533getMainActiveControl0d7_KjU;
                list2 = tabs;
                i27 = i25;
                j10 = j10;
                composer2.startReplaceGroup(-863346747);
            }
            composer2.endReplaceGroup();
            Integer numValueOf1111 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState2));
            ComposerKt.sourceInformationMarkerStart(composer2, 110960274, "CC(remember):CommonTabsScreen.kt#9igjgp");
            mutableIntState3 = mutableIntState2;
            zChanged = composer2.changed(mutableIntState3) | composer2.changed(pagerState);
            commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = composer2.rememberedValue();
            if (!zChanged) {
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
            } else {
                commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$5$1(pagerState, mutableIntState3, null);
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(numValueOf1111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$5$1RememberedValue, composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, 110966189, "CC(remember):CommonTabsScreen.kt#9igjgp");
            zChanged2 = composer2.changed(pagerState) | composer2.changed(mutableIntState3);
            commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = composer2.rememberedValue();
            if (!zChanged2) {
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
            } else {
                commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue = new CommonTabsScreenKt$CommonTabsScreen$4$6$1(pagerState, mutableIntState3, null);
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$6$1RememberedValue, composer2, 0);
            Integer numValueOf1112 = Integer.valueOf(CommonTabsScreen_DuhZ5jU$lambda$2(mutableIntState3));
            ComposerKt.sourceInformationMarkerStart(composer2, 110972349, "CC(remember):CommonTabsScreen.kt#9igjgp");
            if ((i22 & 896) == 256) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean zChangedInstance1114 = z7 | composer2.changedInstance(list2) | composer2.changed(mutableIntState3);
            if ((i22 & 112) == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z8 | zChangedInstance1114;
            commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = composer2.rememberedValue();
            if (z9) {
                List<? extends T> list11117 = list2;
                SnackbarHostState snackbarHostState1114 = snackbarHostState3;
                CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$1110 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11117, snackbarHostState1114, mutableIntState3, null);
                function10 = function8;
                list = list11117;
                snackbarHostState4 = snackbarHostState1114;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$1110;
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
            } else {
                List<? extends T> list11118 = list2;
                SnackbarHostState snackbarHostState1115 = snackbarHostState3;
                CommonTabsScreenKt$CommonTabsScreen$4$7$1 commonTabsScreenKt$CommonTabsScreen$4$7$1111 = new CommonTabsScreenKt$CommonTabsScreen$4$7$1(function8, list11118, snackbarHostState1115, mutableIntState3, null);
                function10 = function8;
                list = list11118;
                snackbarHostState4 = snackbarHostState1115;
                commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue = commonTabsScreenKt$CommonTabsScreen$4$7$1111;
                composer2.updateRememberedValue(commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(numValueOf1112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) commonTabsScreenKt$CommonTabsScreen$4$7$1RememberedValue, composer2, 0);
            long j211116 = j10;
            boolean z115 = z2;
            int i31114 = i24;
            PagerKt.m1511HorizontalPager8jOkeI(pagerState, null, null, null, i31114, 0.0f, null, null, z115, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(596778236, true, new Function4() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$9(list, content, i27, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer2, 54), composer2, ((i27 << 12) & 234881024) | ((i27 >> 3) & 57344), 24576, 16110);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j8 = j211116;
            i21 = i31114;
            z4 = z115;
            j7 = jM11560getTabRowUnselectedContent0d7_KjU;
            snackbarHostState2 = snackbarHostState4;
            modifier2 = modifier1113;
            function2 = function10;
            function4 = function9;
            j5 = j11;
            j6 = j12;
        } else {
            list = tabs;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            tabsSelector2 = tabsSelector;
            snackbarHostState2 = snackbarHostState;
            function2 = function1;
            function4 = function3;
            i21 = i9;
            j5 = jM11498getAppBackground0d7_KjU;
            z4 = z2;
            j6 = j2;
            j7 = j3;
            j8 = j4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List list11119 = list;
            final Modifier modifier1114 = modifier2;
            final long j211117 = j8;
            final TabsSelector tabsSelector110 = tabsSelector2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$6(list11119, t, tabNameProvider, modifier1114, z4, i21, j5, j6, j7, j211117, tabsSelector110, snackbarHostState2, function2, function4, content, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CommonTabsScreen_DuhZ5jU$lambda$2(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableIntState CommonTabsScreen_DuhZ5jU$lambda$1$0(List list, Object obj) {
        return SnapshotIntStateKt.mutableIntStateOf(list.indexOf(obj));
    }

    private static final <T> void CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent(List<? extends T> list, PagerState pagerState, final Function3<? super T, ? super Composer, ? super Integer, String> function3, final int i, final MutableIntState mutableIntState, long j, long j2, final Function3<? super T, ? super Composer, ? super Integer, TabBadgeData> function4, Composer composer, int i2) {
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, -2139343014, "C(tabsContent):CommonTabsScreen.kt#gqlnsh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2139343014, i2, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.tabsContent (CommonTabsScreen.kt:117)");
        }
        composer2.startReplaceGroup(1380700888);
        ComposerKt.sourceInformation(composer2, "*144@6228L20,121@5054L27,122@5110L813,119@4956L1313");
        final int i3 = 0;
        for (final T t : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            boolean z = pagerState.getTargetPage() == i3;
            float f = 6;
            Modifier modifierTestTag = TestTagKt.testTag(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 0.0f, 0.0f, 12, null)), "TabRowItem:" + ((Object) function3.invoke(t, composer2, Integer.valueOf((i >> 3) & 8))));
            ComposerKt.sourceInformationMarkerStart(composer2, -676613566, "CC(remember):CommonTabsScreen.kt#9igjgp");
            boolean zChanged = composer2.changed(mutableIntState) | composer2.changed(i3);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent$1$0$0(i3, mutableIntState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TabKt.m4364TabwqdebIU(z, (Function0) objRememberedValue, modifierTestTag, false, ComposableLambdaKt.rememberComposableLambda(2075360781, true, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent$1$1(function3, t, i, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), null, j, j2, null, composer2, 24576, BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR);
            composer2 = composer;
            i3 = i4;
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent$1$0$0(int i, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent$1$1(Function3 function3, Object obj, int i, Function3 function4, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C123@5136L765:CommonTabsScreen.kt#gqlnsh");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2075360781, i2, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.tabsContent.<anonymous>.<anonymous> (CommonTabsScreen.kt:123)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 306621895, "C128@5389L20,127@5344L168,131@5541L25:CommonTabsScreen.kt#gqlnsh");
            int i3 = (i >> 3) & 8;
            TextKt.m4494TextNvy7gAk((String) function3.invoke(obj, composer, Integer.valueOf(i3)), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer, 0, 12582912, 131070);
            TabBadgeData tabBadgeData = (TabBadgeData) function4.invoke(obj, composer, Integer.valueOf(i3));
            if (tabBadgeData == null) {
                composer.startReplaceGroup(306837157);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(306837158);
                ComposerKt.sourceInformation(composer, "*132@5606L239");
                TabRowCountBadge(tabBadgeData.getText(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), tabBadgeData.getTestTag(), composer, 48, 0);
                composer.endReplaceGroup();
            }
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
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$2(PagerState pagerState, long j, TabIndicatorScope PrimaryScrollableTabRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PrimaryScrollableTabRow, "$this$PrimaryScrollableTabRow");
        ComposerKt.sourceInformation(composer, "C155@6646L392:CommonTabsScreen.kt#gqlnsh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-783933130, i, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.<anonymous> (CommonTabsScreen.kt:155)");
        }
        float f = 3;
        TabRowDefaults.INSTANCE.m4372PrimaryIndicator10LGxhE(PrimaryScrollableTabRow.tabIndicatorOffset(Modifier.INSTANCE, pagerState.getTargetPage(), true), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0.0f, j, RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 0.0f, 0.0f, 12, null), composer, (TabRowDefaults.$stable << 15) | 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$3(List list, PagerState pagerState, Function3 function3, int i, MutableIntState mutableIntState, long j, long j2, Function3 function4, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C165@7175L13:CommonTabsScreen.kt#gqlnsh");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-503011123, i2, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.<anonymous> (CommonTabsScreen.kt:165)");
            }
            CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent(list, pagerState, function3, i, mutableIntState, j, j2, function4, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$4(PagerState pagerState, long j, TabIndicatorScope PrimaryTabRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PrimaryTabRow, "$this$PrimaryTabRow");
        ComposerKt.sourceInformation(composer, "C173@7504L392:CommonTabsScreen.kt#gqlnsh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-999524942, i, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.<anonymous> (CommonTabsScreen.kt:173)");
        }
        float f = 3;
        TabRowDefaults.INSTANCE.m4372PrimaryIndicator10LGxhE(PrimaryTabRow.tabIndicatorOffset(Modifier.INSTANCE, pagerState.getTargetPage(), true), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), 0.0f, j, RoundedCornerShapeKt.m1575RoundedCornerShapea9UjIt4$default(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 0.0f, 0.0f, 12, null), composer, (TabRowDefaults.$stable << 15) | 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$5(List list, PagerState pagerState, Function3 function3, int i, MutableIntState mutableIntState, long j, long j2, Function3 function4, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C182@7993L13:CommonTabsScreen.kt#gqlnsh");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(638276552, i2, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.<anonymous> (CommonTabsScreen.kt:182)");
            }
            CommonTabsScreen_DuhZ5jU$lambda$5$tabsContent(list, pagerState, function3, i, mutableIntState, j, j2, function4, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonTabsScreen_DuhZ5jU$lambda$5$9(List list, Function3 function3, int i, PagerScope HorizontalPager, int i2, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation(composer, "CN(pageIndex)211@8969L24:CommonTabsScreen.kt#gqlnsh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(596778236, i3, -1, "com.box.android.base.presentation.components.tabscreen.CommonTabsScreen.<anonymous>.<anonymous> (CommonTabsScreen.kt:210)");
        }
        function3.invoke(list.get(i2), composer, Integer.valueOf((i >> 3) & 8));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:54:0x01df  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    private static final void TabRowCountBadge(final String str, Modifier modifier, final String str2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1435510590);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRowCountBadge)N(text,modifier,testTag)221@9213L6,218@9122L547:CommonTabsScreen.kt#gqlnsh");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
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
                    ComposerKt.traceEventStart(-1435510590, i3, -1, "com.box.android.base.presentation.components.tabscreen.TabRowCountBadge (CommonTabsScreen.kt:217)");
                }
                Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(20)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11540getNotificationContainer0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323152595, "C226@9377L6,224@9317L346:CommonTabsScreen.kt#gqlnsh");
                Modifier modifier4 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, str2), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11541getNotificationText0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), composer2, i3 & 14, 0, 130040);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommonTabsScreenKt.TabRowCountBadge$lambda$1(str, modifier3, str2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changed(str2)) {
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
                ComposerKt.traceEventStart(-1435510590, i3, -1, "com.box.android.base.presentation.components.tabscreen.TabRowCountBadge (CommonTabsScreen.kt:217)");
            }
            Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(20)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11540getNotificationContainer0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323152595, "C226@9377L6,224@9317L346:CommonTabsScreen.kt#gqlnsh");
            Modifier modifier5 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, str2), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11541getNotificationText0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(12), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), composer2, i3 & 14, 0, 130040);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommonTabsScreenKt.TabRowCountBadge$lambda$1(str, modifier3, str2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
