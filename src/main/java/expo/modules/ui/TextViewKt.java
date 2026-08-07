package expo.modules.ui;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TextContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/TextProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/TextProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextContent$lambda$0(FunctionalComposableScope functionalComposableScope, TextProps textProps, int i, Composer composer, int i2) {
        TextContent(functionalComposableScope, textProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TextContent(final FunctionalComposableScope functionalComposableScope, final TextProps props, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2106325346);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextContent)184@5424L83,182@5363L474:TextView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2106325346, i2, -1, "expo.modules.ui.TextContent (TextView.kt:166)");
            }
            TypographyStyle typography = props.getTypography();
            composerStartRestartGroup.startReplaceGroup(-1249055381);
            ComposerKt.sourceInformation(composerStartRestartGroup, "168@4757L13");
            TextStyle textStyle = typography == null ? null : typography.toTextStyle(composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            if (textStyle == null) {
                textStyle = TextStyle.INSTANCE.getDefault();
            }
            Float fontSize = props.getFontSize();
            long sp = fontSize != null ? TextUnitKt.getSp(fontSize.floatValue()) : TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
            TextFontWeight fontWeight = props.getFontWeight();
            FontWeight composeFontWeight = fontWeight != null ? fontWeight.toComposeFontWeight() : null;
            TextFontStyle fontStyle = props.getFontStyle();
            FontStyle fontStyleM9202boximpl = fontStyle != null ? FontStyle.m9202boximpl(fontStyle.m14677toComposeFontStyle_LCdwA()) : null;
            TextDecorationType textDecoration = props.getTextDecoration();
            TextDecoration composeTextDecoration = textDecoration != null ? textDecoration.toComposeTextDecoration() : null;
            Float letterSpacing = props.getLetterSpacing();
            long sp2 = letterSpacing != null ? TextUnitKt.getSp(letterSpacing.floatValue()) : TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE();
            Float lineHeight = props.getLineHeight();
            TextStyle textStyleMerge = textStyle.merge(new TextStyle(0L, sp, composeFontWeight, fontStyleM9202boximpl, (FontSynthesis) null, (FontFamily) null, (String) null, sp2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, composeTextDecoration, (Shadow) null, (DrawStyle) null, 0, 0, lineHeight != null ? TextUnitKt.getSp(lineHeight.floatValue()) : TextUnit.INSTANCE.m9892getUnspecifiedXSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16641905, (DefaultConstructorMarker) null));
            String text = props.getText();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            long jColorToComposeColor = UtilsKt.colorToComposeColor(props.getColor());
            TextAlignType textAlign = props.getTextAlign();
            TextAlign textAlignM9519boximpl = textAlign != null ? TextAlign.m9519boximpl(textAlign.m14675toComposeTextAligne0LSkKk()) : null;
            TextOverflowType overflow = props.getOverflow();
            int iM14678toComposeTextOverflowgIe3tQ8 = overflow != null ? overflow.m14678toComposeTextOverflowgIe3tQ8() : TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
            Boolean softWrap = props.getSoftWrap();
            boolean zBooleanValue = softWrap != null ? softWrap.booleanValue() : true;
            Integer maxLines = props.getMaxLines();
            int iIntValue = maxLines != null ? maxLines.intValue() : Integer.MAX_VALUE;
            Integer minLines = props.getMinLines();
            TextKt.m4494TextNvy7gAk(text, modifierApplyModifiers, jColorToComposeColor, null, 0L, null, null, null, 0L, null, textAlignM9519boximpl, 0L, iM14678toComposeTextOverflowgIe3tQ8, zBooleanValue, iIntValue, minLines != null ? minLines.intValue() : 1, null, textStyleMerge, composerStartRestartGroup, 0, 0, 68600);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.TextViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextViewKt.TextContent$lambda$0(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
