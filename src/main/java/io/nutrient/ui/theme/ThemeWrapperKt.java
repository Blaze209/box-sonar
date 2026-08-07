package io.nutrient.ui.theme;

import android.content.Context;
import android.view.ContextThemeWrapper;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import com.facebook.react.modules.appstate.AppStateModule;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import com.pspdfkit.compose.theme.DocumentInfoColorScheme;
import com.pspdfkit.compose.theme.DocumentInfoIconScheme;
import com.pspdfkit.compose.theme.MainToolbarColors;
import com.pspdfkit.compose.theme.SdkTheme;
import com.pspdfkit.compose.theme.SettingsColorScheme;
import com.pspdfkit.compose.theme.ToolbarPopupColors;
import com.pspdfkit.compose.theme.UiColorScheme;
import com.pspdfkit.compose.theme.UiIconScheme;
import com.pspdfkit.compose.theme.UiThemeKt;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.l;
import com.pspdfkit.internal.yo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a5\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0000\u001a7\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aU\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u0019H\u0007¢\u0006\u0004\b&\u0010'\u001a\u009b\u0001\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00192\b\b\u0002\u0010*\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00192\b\b\u0002\u0010/\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u00192\b\b\u0002\u00102\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u0019H\u0007¢\u0006\u0004\b6\u00107\u001a_\u00108\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\u00192\b\b\u0002\u0010:\u001a\u00020\u00192\b\b\u0002\u0010;\u001a\u00020\u00192\b\b\u0002\u0010<\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020\u00192\b\b\u0002\u0010>\u001a\u00020\u00192\b\b\u0002\u0010?\u001a\u00020\u0019H\u0007¢\u0006\u0004\b@\u0010A\u001a8\u0010B\u001a\u00020\u00162\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020D2\b\b\u0002\u0010G\u001a\u00020D2\b\b\u0002\u0010H\u001a\u00020D\u001a\r\u0010I\u001a\u00020\nH\u0001¢\u0006\u0002\u0010J\u001a\r\u0010K\u001a\u00020\fH\u0001¢\u0006\u0002\u0010L\u001a\r\u0010M\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010N\u001a\r\u0010O\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010P\u001a\b\u0010Q\u001a\u00020\u0003H\u0000¨\u0006R"}, d2 = {"WithUiTheme", "", "customTheme", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/pspdfkit/compose/theme/UiColorScheme;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getDefaultXmlUiColors", "mainToolbarColors", "Lcom/pspdfkit/compose/theme/MainToolbarColors;", "settingsColorScheme", "Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "aiAssistantColorScheme", "Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "documentInfoColorScheme", "Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "(Lcom/pspdfkit/compose/theme/MainToolbarColors;Lcom/pspdfkit/compose/theme/SettingsColorScheme;Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/compose/theme/UiColorScheme;", "getDefaultUiColors", "getDefaultUiIcons", "Lcom/pspdfkit/compose/theme/UiIconScheme;", "documentInfoIconScheme", "Lcom/pspdfkit/compose/theme/DocumentInfoIconScheme;", "getMainToolbarColors", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "popupBackgroundColor", "titleTextColor", "getMainToolbarColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Lcom/pspdfkit/compose/theme/MainToolbarColors;", "getSettingsColorScheme", ColorPickerFragment.EXTRA_SELECTED_COLOR, "unselectedColor", "unselectedTextColor", AppStateModule.APP_STATE_BACKGROUND, "dividerColor", "labelTextColor", "getSettingsColorScheme-69fazGs", "(JJJJJJJLandroidx/compose/runtime/Composer;II)Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "getAiAssistantColorScheme", "containerColor", "chatBackground", "mineChatBackground", "mineChatTextColor", "innerChatBackground", "innerChatTextColor", "textFieldBackgroundColor", "textFieldTextColor", "textFieldHintColor", "retryButtonBackgroundColor", "labelColor", "iconColor", "submitButtonEnabledColor", "getAiAssistantColorScheme-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "getDocumentInfoColorScheme", "groupTitleTextColor", "itemTitleTextColor", "itemValueTextColor", "itemValueHintTextColor", "groupIconColor", "fabBackgroundColor", "fabIconColor", "getDocumentInfoColorScheme-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "getDocumentInfoIconScheme", "documentInfoContentIcon", "", "documentInfoChangesIcon", "documentInfoSizeIcon", "documentInfoFabEditIcon", "documentInfoFabDoneIcon", "defaultMainToolbarColors", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/MainToolbarColors;", "defaultSettingsColorScheme", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "defaultAiAssistantColorScheme", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "defaultDocumentInfoColorScheme", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "defaultColorScheme", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ThemeWrapperKt {
    public static final void WithUiTheme(final UiColorScheme uiColorScheme, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        uiColorScheme.getClass();
        function2.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(480383950);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(uiColorScheme) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(480383950, i2, -1, "io.nutrient.ui.theme.WithUiTheme (ThemeWrapper.kt:37)");
            }
            CompositionLocalKt.CompositionLocalProvider(UiThemeKt.getLocalPdfUiScheme().provides(new SdkTheme(uiColorScheme, getDefaultUiIcons$default(null, 1, null))), ComposableLambdaKt.rememberComposableLambda(2104076046, true, new Function2() { // from class: io.nutrient.ui.theme.ThemeWrapperKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeWrapperKt.WithUiTheme$lambda$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: io.nutrient.ui.theme.ThemeWrapperKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeWrapperKt.WithUiTheme$lambda$1(uiColorScheme, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WithUiTheme$lambda$0(Function2 function2, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2104076046, i, -1, "io.nutrient.ui.theme.WithUiTheme.<anonymous> (ThemeWrapper.kt:39)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WithUiTheme$lambda$1(UiColorScheme uiColorScheme, Function2 function2, int i, Composer composer, int i2) {
        WithUiTheme(uiColorScheme, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final AiAssistantColorScheme defaultAiAssistantColorScheme(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1302757243, i, -1, "io.nutrient.ui.theme.defaultAiAssistantColorScheme (ThemeWrapper.kt:271)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, f60.b(context, R.attr.pspdf__aiAssistantDialogStyle, R.style.PSPDFKit_AIAssistantDialog));
        int iA = f60.a(contextThemeWrapper, android.R.attr.colorAccent);
        int iA2 = f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_textcolor);
        AiAssistantColorScheme aiAssistantColorScheme = new AiAssistantColorScheme(ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_background)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_chatBackground)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_mineChatBackground)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_mineChatTextColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_innerChatBackground)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_innerChatTextColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_textFieldBackgroundColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_textFieldTextColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_textFieldHintColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_retryButtonBackgroundColor)), ColorKt.Color(iA), ColorKt.Color(iA2), ColorKt.Color(iA), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__aiassistant_submitButtonEnabledColor)), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return aiAssistantColorScheme;
    }

    public static final UiColorScheme defaultColorScheme() {
        Color.Companion companion = Color.INSTANCE;
        return new UiColorScheme(new MainToolbarColors(companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), new ToolbarPopupColors(companion.m6850getUnspecified0d7_KjU(), null), companion.m6850getUnspecified0d7_KjU(), null), new SettingsColorScheme(companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null), new AiAssistantColorScheme(companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null), new DocumentInfoColorScheme(companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), companion.m6850getUnspecified0d7_KjU(), null));
    }

    public static final DocumentInfoColorScheme defaultDocumentInfoColorScheme(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(102949279, i, -1, "io.nutrient.ui.theme.defaultDocumentInfoColorScheme (ThemeWrapper.kt:314)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, f60.b(context, R.attr.pspdf__outlineViewStyle, R.style.PSPDFKit_OutlineView));
        DocumentInfoColorScheme documentInfoColorScheme = new DocumentInfoColorScheme(ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__backgroundColor)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoGroupTitleTextColor, R.color.pspdf__secondaryLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoItemTitleTextColor, R.color.pspdf__inverseSurfaceLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoItemValueTextColor, R.color.pspdf__outlineLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoItemValueHintTextColor, R.color.pspdf__outlineVariantLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoGroupIconColor, R.color.pspdf__outlineVariantLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoFabBackgroundColor, R.color.pspdf__primaryLight)), ColorKt.Color(f60.a(contextThemeWrapper, R.attr.pspdf__documentInfoFabIconColor, R.color.pspdf__onPrimaryLight)), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return documentInfoColorScheme;
    }

    public static final MainToolbarColors defaultMainToolbarColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(900818751, i, -1, "io.nutrient.ui.theme.defaultMainToolbarColors (ThemeWrapper.kt:236)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        yo yoVar = (yo) new l(context).c.getValue();
        MainToolbarColors mainToolbarColors = new MainToolbarColors(ColorKt.Color(yoVar.a), ColorKt.Color(yoVar.b), new ToolbarPopupColors(ColorKt.Color(f60.a(new ContextThemeWrapper(context, yoVar.c), android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight)), null), ColorKt.Color(yoVar.d), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mainToolbarColors;
    }

    public static final SettingsColorScheme defaultSettingsColorScheme(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-459398049, i, -1, "io.nutrient.ui.theme.defaultSettingsColorScheme (ThemeWrapper.kt:250)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        SettingsColorScheme settingsColorScheme = new SettingsColorScheme(ColorKt.Color(f60.a(context, R.attr.pspdf__settings_selected_color)), ColorKt.Color(f60.a(context, R.attr.pspdf__settings_unselected_color)), ColorKt.Color(f60.a(context, R.attr.pspdf__settings_preset_label_textcolor)), ColorKt.Color(f60.a(context, android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight)), ColorKt.Color(f60.a(context, R.attr.pspdf__settings_divider_color, R.color.pspdf__outlineVariantLight)), ColorKt.Color(f60.a(context, R.attr.pspdf__settings_section_title_textcolor)), ColorKt.Color(f60.a(context, R.attr.pspdf__settings_section_label_textcolor)), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return settingsColorScheme;
    }

    /* JADX INFO: renamed from: getAiAssistantColorScheme-u3YEpmA, reason: not valid java name */
    public static final AiAssistantColorScheme m14740getAiAssistantColorSchemeu3YEpmA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, Composer composer, int i, int i2, int i3) {
        long background = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground() : j;
        long surface = (i3 & 2) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface() : j2;
        long secondary = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary() : j3;
        long onSecondary = (i3 & 8) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondary() : j4;
        long secondaryContainer = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondaryContainer() : j5;
        long onSecondaryContainer = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondaryContainer() : j6;
        long background2 = (i3 & 64) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground() : j7;
        long j15 = background;
        long onSecondary2 = (i3 & 128) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondary() : j8;
        long onSecondary3 = (i3 & 256) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondary() : j9;
        long onSecondaryContainer2 = (i3 & 512) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondaryContainer() : j10;
        long primary = (i3 & 1024) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j11;
        long primary2 = (i3 & 2048) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j12;
        long primary3 = (i3 & 4096) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j13;
        long secondaryContainer2 = (i3 & 8192) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondaryContainer() : j14;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1831821448, i, i2, "io.nutrient.ui.theme.getAiAssistantColorScheme (ThemeWrapper.kt:157)");
        }
        AiAssistantColorScheme aiAssistantColorScheme = new AiAssistantColorScheme(j15, surface, secondary, onSecondary, secondaryContainer, onSecondaryContainer, background2, onSecondary2, onSecondary3, onSecondaryContainer2, primary, primary2, primary3, secondaryContainer2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return aiAssistantColorScheme;
    }

    public static final UiColorScheme getDefaultUiColors(MainToolbarColors mainToolbarColors, SettingsColorScheme settingsColorScheme, AiAssistantColorScheme aiAssistantColorScheme, DocumentInfoColorScheme documentInfoColorScheme, Composer composer, int i, int i2) {
        SettingsColorScheme settingsColorScheme2;
        AiAssistantColorScheme aiAssistantColorSchemeM14740getAiAssistantColorSchemeu3YEpmA;
        AiAssistantColorScheme aiAssistantColorScheme2;
        DocumentInfoColorScheme documentInfoColorSchemeM14741getDocumentInfoColorSchemeoq7We08;
        MainToolbarColors mainToolbarColorsM14742getMainToolbarColorsro_MJ88 = (i2 & 1) != 0 ? m14742getMainToolbarColorsro_MJ88(0L, 0L, 0L, 0L, composer, 0, 15) : mainToolbarColors;
        SettingsColorScheme settingsColorSchemeM14743getSettingsColorScheme69fazGs = (i2 & 2) != 0 ? m14743getSettingsColorScheme69fazGs(0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 127) : settingsColorScheme;
        if ((i2 & 4) != 0) {
            settingsColorScheme2 = settingsColorSchemeM14743getSettingsColorScheme69fazGs;
            aiAssistantColorSchemeM14740getAiAssistantColorSchemeu3YEpmA = m14740getAiAssistantColorSchemeu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 16383);
        } else {
            settingsColorScheme2 = settingsColorSchemeM14743getSettingsColorScheme69fazGs;
            aiAssistantColorSchemeM14740getAiAssistantColorSchemeu3YEpmA = aiAssistantColorScheme;
        }
        if ((i2 & 8) != 0) {
            aiAssistantColorScheme2 = aiAssistantColorSchemeM14740getAiAssistantColorSchemeu3YEpmA;
            documentInfoColorSchemeM14741getDocumentInfoColorSchemeoq7We08 = m14741getDocumentInfoColorSchemeoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 255);
        } else {
            aiAssistantColorScheme2 = aiAssistantColorSchemeM14740getAiAssistantColorSchemeu3YEpmA;
            documentInfoColorSchemeM14741getDocumentInfoColorSchemeoq7We08 = documentInfoColorScheme;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1782640521, i, -1, "io.nutrient.ui.theme.getDefaultUiColors (ThemeWrapper.kt:66)");
        }
        UiColorScheme uiColorScheme = new UiColorScheme(mainToolbarColorsM14742getMainToolbarColorsro_MJ88, settingsColorScheme2, aiAssistantColorScheme2, documentInfoColorSchemeM14741getDocumentInfoColorSchemeoq7We08);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return uiColorScheme;
    }

    public static final UiIconScheme getDefaultUiIcons(DocumentInfoIconScheme documentInfoIconScheme) {
        documentInfoIconScheme.getClass();
        return new UiIconScheme(documentInfoIconScheme);
    }

    public static /* synthetic */ UiIconScheme getDefaultUiIcons$default(DocumentInfoIconScheme documentInfoIconScheme, int i, Object obj) {
        if ((i & 1) != 0) {
            documentInfoIconScheme = getDocumentInfoIconScheme$default(0, 0, 0, 0, 0, 31, null);
        }
        return getDefaultUiIcons(documentInfoIconScheme);
    }

    public static final UiColorScheme getDefaultXmlUiColors(MainToolbarColors mainToolbarColors, SettingsColorScheme settingsColorScheme, AiAssistantColorScheme aiAssistantColorScheme, DocumentInfoColorScheme documentInfoColorScheme, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            mainToolbarColors = defaultMainToolbarColors(composer, 0);
        }
        if ((i2 & 2) != 0) {
            settingsColorScheme = defaultSettingsColorScheme(composer, 0);
        }
        if ((i2 & 4) != 0) {
            aiAssistantColorScheme = defaultAiAssistantColorScheme(composer, 0);
        }
        if ((i2 & 8) != 0) {
            documentInfoColorScheme = defaultDocumentInfoColorScheme(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-932117500, i, -1, "io.nutrient.ui.theme.getDefaultXmlUiColors (ThemeWrapper.kt:55)");
        }
        UiColorScheme uiColorScheme = new UiColorScheme(mainToolbarColors, settingsColorScheme, aiAssistantColorScheme, documentInfoColorScheme);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return uiColorScheme;
    }

    /* JADX INFO: renamed from: getDocumentInfoColorScheme-oq7We08, reason: not valid java name */
    public static final DocumentInfoColorScheme m14741getDocumentInfoColorSchemeoq7We08(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i, int i2) {
        long background = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground() : j;
        long onBackground = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground() : j2;
        long onBackground2 = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground() : j3;
        long primary = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j4;
        long primary2 = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j5;
        long primary3 = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j6;
        long primaryContainer = (i2 & 64) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer() : j7;
        long jM3051contentColorForek8zF_U = (i2 & 128) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer(), composer, 0) : j8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-426691626, i, -1, "io.nutrient.ui.theme.getDocumentInfoColorScheme (ThemeWrapper.kt:197)");
        }
        DocumentInfoColorScheme documentInfoColorScheme = new DocumentInfoColorScheme(background, onBackground, onBackground2, primary, primary2, primary3, primaryContainer, jM3051contentColorForek8zF_U, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return documentInfoColorScheme;
    }

    public static final DocumentInfoIconScheme getDocumentInfoIconScheme(int i, int i2, int i3, int i4, int i5) {
        return new DocumentInfoIconScheme(i, i2, i3, i4, i5);
    }

    public static /* synthetic */ DocumentInfoIconScheme getDocumentInfoIconScheme$default(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = R.drawable.pspdf__ic_outline;
        }
        if ((i6 & 2) != 0) {
            i2 = R.drawable.pspdf__ic_info;
        }
        if ((i6 & 4) != 0) {
            i3 = R.drawable.pspdf__ic_size;
        }
        if ((i6 & 8) != 0) {
            i4 = R.drawable.pspdf__ic_edit;
        }
        if ((i6 & 16) != 0) {
            i5 = R.drawable.pspdf__ic_done;
        }
        return getDocumentInfoIconScheme(i, i2, i3, i4, i5);
    }

    /* JADX INFO: renamed from: getMainToolbarColors-ro_MJ88, reason: not valid java name */
    public static final MainToolbarColors m14742getMainToolbarColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground();
        }
        if ((i2 & 2) != 0) {
            j2 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimary();
        }
        if ((i2 & 4) != 0) {
            j3 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer();
        }
        if ((i2 & 8) != 0) {
            j4 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimary();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1565917472, i, -1, "io.nutrient.ui.theme.getMainToolbarColors (ThemeWrapper.kt:84)");
        }
        long j5 = j;
        MainToolbarColors mainToolbarColors = new MainToolbarColors(j5, j2, new ToolbarPopupColors(j3, null), j4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mainToolbarColors;
    }

    /* JADX INFO: renamed from: getSettingsColorScheme-69fazGs, reason: not valid java name */
    public static final SettingsColorScheme m14743getSettingsColorScheme69fazGs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int i, int i2) {
        long primary = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary() : j;
        long secondary = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary() : j2;
        long secondary2 = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondary() : j3;
        long background = (i2 & 8) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground() : j4;
        long onPrimaryContainer = (i2 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer() : j5;
        long onBackground = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground() : j6;
        long onBackground2 = (i2 & 64) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground() : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-379949685, i, -1, "io.nutrient.ui.theme.getSettingsColorScheme (ThemeWrapper.kt:112)");
        }
        SettingsColorScheme settingsColorScheme = new SettingsColorScheme(primary, secondary, secondary2, background, onPrimaryContainer, onBackground, onBackground2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return settingsColorScheme;
    }
}
