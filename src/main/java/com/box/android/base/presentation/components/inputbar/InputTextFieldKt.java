package com.box.android.base.presentation.components.inputbar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import androidx.media3.extractor.WavUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.presentation.components.commentbar.MentionSpanV2;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InputTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001aª\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001aS\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0004\b\"\u0010#\u001aX\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b%\u0010&\u001a-\u0010'\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010(\u001a\u00020)H\u0003¢\u0006\u0002\u0010*\u001a\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002\u001a\r\u00100\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a\r\u00103\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a\r\u00104\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\"\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00065²\u0006\n\u00106\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"InputTextField", "", "inputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "placeHolderText", "", "onTextChanged", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "onKeyboardFocusHandled", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "isLargeSize", "scrollState", "Landroidx/compose/foundation/ScrollState;", "maxInputLines", "keyboardAction", "Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "contentDescription", "", "timestampText", "actionButton", "Landroidx/compose/runtime/Composable;", "(Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/ScrollState;ILcom/box/android/base/presentation/components/inputbar/KeyboardAction;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "InputTextFieldActionButton", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "activeTint", "Landroidx/compose/ui/graphics/Color;", "inactiveTint", ViewProps.ON_CLICK, "InputTextFieldActionButton-nBX6wN0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;ZJJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "content", "InputTextFieldActionButton-Y0xEhic", "(Landroidx/compose/ui/Modifier;ZJJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "KeyboardActionsHandler", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "hasUITextChange", "updatedValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textValue", "DEFAULT_MAX_INPUT_BAR_LINES", "InputTextFieldWithSubmitPreview", "(Landroidx/compose/runtime/Composer;I)V", "InputTextFieldLargeWithSubmitPreview", "InputTextFieldWithCustomActionPreview", "InputTextFieldLargeWithCustomActionPreview", "base_generalProdRelease", "lineCount", "value"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InputTextFieldKt {
    public static final int DEFAULT_MAX_INPUT_BAR_LINES = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextField$lambda$8(InputBoxValue inputBoxValue, int i, Function1 function1, Function0 function0, Modifier modifier, boolean z, boolean z2, ScrollState scrollState, int i2, KeyboardAction keyboardAction, String str, String str2, Function2 function2, int i3, int i4, int i5, Composer composer, int i6) {
        InputTextField(inputBoxValue, i, function1, function0, modifier, z, z2, scrollState, i2, keyboardAction, str, str2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldActionButton_Y0xEhic$lambda$2(Modifier modifier, boolean z, long j, long j2, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        m11822InputTextFieldActionButtonY0xEhic(modifier, z, j, j2, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldActionButton_nBX6wN0$lambda$1(Modifier modifier, Painter painter, String str, boolean z, long j, long j2, Function0 function0, int i, int i2, Composer composer, int i3) {
        m11823InputTextFieldActionButtonnBX6wN0(modifier, painter, str, z, j, j2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithCustomActionPreview$lambda$4(int i, Composer composer, int i2) {
        InputTextFieldLargeWithCustomActionPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithSubmitPreview$lambda$4(int i, Composer composer, int i2) {
        InputTextFieldLargeWithSubmitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithCustomActionPreview$lambda$4(int i, Composer composer, int i2) {
        InputTextFieldWithCustomActionPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithSubmitPreview$lambda$4(int i, Composer composer, int i2) {
        InputTextFieldWithSubmitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardActionsHandler$lambda$1(KeyboardAction keyboardAction, Function0 function0, FocusRequester focusRequester, int i, Composer composer, int i2) {
        KeyboardActionsHandler(keyboardAction, function0, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014a  */
    /* JADX WARN: Code duplicated, block: B:102:0x014e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0158  */
    /* JADX WARN: Code duplicated, block: B:105:0x015b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0160  */
    /* JADX WARN: Code duplicated, block: B:110:0x016a  */
    /* JADX WARN: Code duplicated, block: B:111:0x016f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0175  */
    /* JADX WARN: Code duplicated, block: B:115:0x017b  */
    /* JADX WARN: Code duplicated, block: B:116:0x017e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0186  */
    /* JADX WARN: Code duplicated, block: B:122:0x018c  */
    /* JADX WARN: Code duplicated, block: B:126:0x019e  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:138:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01da  */
    /* JADX WARN: Code duplicated, block: B:153:0x01de  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:163:0x020e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0222  */
    /* JADX WARN: Code duplicated, block: B:168:0x022c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0240  */
    /* JADX WARN: Code duplicated, block: B:174:0x0259  */
    /* JADX WARN: Code duplicated, block: B:177:0x0285  */
    /* JADX WARN: Code duplicated, block: B:179:0x028d  */
    /* JADX WARN: Code duplicated, block: B:182:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:185:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:186:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:188:0x0313  */
    /* JADX WARN: Code duplicated, block: B:189:0x0328  */
    /* JADX WARN: Code duplicated, block: B:192:0x033c  */
    /* JADX WARN: Code duplicated, block: B:193:0x033f  */
    /* JADX WARN: Code duplicated, block: B:196:0x0348  */
    /* JADX WARN: Code duplicated, block: B:197:0x0362  */
    /* JADX WARN: Code duplicated, block: B:200:0x0397  */
    /* JADX WARN: Code duplicated, block: B:201:0x0399  */
    /* JADX WARN: Code duplicated, block: B:204:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:208:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:211:0x0411  */
    /* JADX WARN: Code duplicated, block: B:214:0x041d  */
    /* JADX WARN: Code duplicated, block: B:215:0x0421  */
    /* JADX WARN: Code duplicated, block: B:218:0x0471  */
    /* JADX WARN: Code duplicated, block: B:219:0x0476  */
    /* JADX WARN: Code duplicated, block: B:222:0x052f  */
    /* JADX WARN: Code duplicated, block: B:223:0x0531  */
    /* JADX WARN: Code duplicated, block: B:226:0x0547  */
    /* JADX WARN: Code duplicated, block: B:230:0x0553  */
    /* JADX WARN: Code duplicated, block: B:233:0x0580  */
    /* JADX WARN: Code duplicated, block: B:234:0x0582  */
    /* JADX WARN: Code duplicated, block: B:237:0x058a  */
    /* JADX WARN: Code duplicated, block: B:239:0x0592  */
    /* JADX WARN: Code duplicated, block: B:242:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:243:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:246:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:247:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:250:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:254:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:257:0x0634  */
    /* JADX WARN: Code duplicated, block: B:258:0x063b  */
    /* JADX WARN: Code duplicated, block: B:261:0x064b  */
    /* JADX WARN: Code duplicated, block: B:263:0x0654 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:264:0x0656  */
    /* JADX WARN: Code duplicated, block: B:265:0x065d  */
    /* JADX WARN: Code duplicated, block: B:268:0x0675  */
    /* JADX WARN: Code duplicated, block: B:269:0x0679  */
    /* JADX WARN: Code duplicated, block: B:272:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:275:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:276:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:279:0x077c  */
    /* JADX WARN: Code duplicated, block: B:281:0x078d  */
    /* JADX WARN: Code duplicated, block: B:284:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:288:0x022e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    /* JADX WARN: Code duplicated, block: B:45:0x009e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00da  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:79:0x0104  */
    /* JADX WARN: Code duplicated, block: B:80:0x0107  */
    /* JADX WARN: Code duplicated, block: B:85:0x0116  */
    /* JADX WARN: Code duplicated, block: B:86:0x0119  */
    /* JADX WARN: Code duplicated, block: B:88:0x011d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x011f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0122  */
    /* JADX WARN: Code duplicated, block: B:93:0x0134  */
    /* JADX WARN: Code duplicated, block: B:94:0x0137  */
    /* JADX WARN: Code duplicated, block: B:99:0x0141  */
    public static final void InputTextField(final InputBoxValue inputBoxValue, int i, final Function1<? super TextFieldValueUIModel, Unit> onTextChanged, final Function0<Unit> onKeyboardFocusHandled, Modifier modifier, boolean z, boolean z2, ScrollState scrollState, int i2, KeyboardAction keyboardAction, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier modifier2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iOrdinal;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z3;
        final int i23;
        final boolean z4;
        final ScrollState scrollState2;
        final int i24;
        final KeyboardAction keyboardAction2;
        final String str3;
        Modifier modifier3;
        final boolean z5;
        final String str4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z6;
        boolean z7;
        ScrollState scrollState3;
        int i25;
        KeyboardAction keyboardAction3;
        String str5;
        String str6;
        Object objRememberedValue;
        MutableIntState mutableIntState;
        Object objRememberedValue2;
        final long jM11533getMainActiveControl0d7_KjU;
        boolean zChanged;
        Object objRememberedValue3;
        Object objRememberedValue4;
        final CoroutineScope coroutineScope;
        float fM9687constructorimpl;
        Object obj;
        Modifier.Companion companionM1254heightInVpY3zN4$default;
        float f;
        long jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU;
        boolean z8;
        Object objRememberedValue5;
        final String str7;
        Function0<ComposeUiNode> constructor;
        int length;
        boolean z9;
        boolean zChanged2;
        Object objRememberedValue6;
        final String str8;
        boolean z10;
        boolean z11;
        Object objRememberedValue7;
        boolean z12;
        boolean z13;
        boolean z14;
        Object objRememberedValue8;
        final int i26;
        final MutableIntState mutableIntState2;
        final ScrollState scrollState4;
        Alignment.Vertical bottom;
        float fM9687constructorimpl2;
        float f2;
        Function0<ComposeUiNode> constructor2;
        String text;
        int i27;
        int i28;
        final Function2<? super Composer, ? super Integer, Unit> actionButton = function2;
        Intrinsics.checkNotNullParameter(inputBoxValue, "inputBoxValue");
        Intrinsics.checkNotNullParameter(onTextChanged, "onTextChanged");
        Intrinsics.checkNotNullParameter(onKeyboardFocusHandled, "onKeyboardFocusHandled");
        Intrinsics.checkNotNullParameter(actionButton, "actionButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(1807063521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextField)N(inputBoxValue,placeHolderText,onTextChanged,onKeyboardFocusHandled,modifier,isEnabled,isLargeSize,scrollState,maxInputLines,keyboardAction,contentDescription,timestampText,actionButton)83@3609L106,86@3741L29,88@3810L6,89@3855L94,92@3975L24,114@4771L82,101@4245L4771:InputTextField.kt#epp6th");
        if ((i3 & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(inputBoxValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onTextChanged) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onKeyboardFocusHandled) ? 2048 : 1024;
        }
        int i29 = i5 & 16;
        if (i29 == 0) {
            if ((i3 & 24576) == 0) {
                modifier2 = modifier;
                i6 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i7 = i5 & 32;
            if (i7 != 0) {
                i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i6 |= i8;
            }
            i9 = i5 & 64;
            if (i9 != 0) {
                i6 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i6 |= i10;
            }
            i11 = i5 & 128;
            if (i11 != 0) {
                i6 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(scrollState)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i6 |= i12;
            }
            i13 = i5 & 256;
            if (i13 != 0) {
                if ((i3 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(i2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i6 |= i14;
                }
                i15 = i5 & 512;
                if (i15 != 0) {
                    if ((i3 & 805306368) == 0) {
                        if (keyboardAction == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = keyboardAction.ordinal();
                        }
                        if (composerStartRestartGroup.changed(iOrdinal)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i6 |= i16;
                    }
                    i17 = i5 & 1024;
                    if (i17 != 0) {
                        i18 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i19 = 4;
                        } else {
                            i19 = 2;
                        }
                        i18 = i4 | i19;
                    } else {
                        i18 = i4;
                    }
                    i20 = i5 & 2048;
                    if (i20 != 0) {
                        i18 |= 48;
                    } else if ((i4 & 48) == 0) {
                        if (composerStartRestartGroup.changed(str2)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i18 |= i21;
                    }
                    if ((i4 & 384) == 0) {
                        i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
                    }
                    i22 = i18;
                    if ((i6 & 306783379) == 306783378 || (i22 & Token.DOTQUERY) != 146) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                        i23 = i;
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z2;
                        scrollState2 = scrollState;
                        i24 = i2;
                        keyboardAction2 = keyboardAction;
                        str3 = str2;
                        modifier3 = modifier2;
                        z5 = z;
                        str4 = str;
                    } else {
                        if (i29 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            z6 = true;
                        } else {
                            z6 = z;
                        }
                        if (i9 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i11 != 0) {
                            scrollState3 = null;
                        } else {
                            scrollState3 = scrollState;
                        }
                        if (i13 != 0) {
                            i25 = 3;
                        } else {
                            i25 = i2;
                        }
                        if (i15 != 0) {
                            keyboardAction3 = null;
                        } else {
                            keyboardAction3 = keyboardAction;
                        }
                        if (i17 != 0) {
                            str5 = null;
                        } else {
                            str5 = str;
                        }
                        if (i20 != 0) {
                            str6 = null;
                        } else {
                            str6 = str2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            text = inputBoxValue.getTextFieldValue().getText();
                            i27 = 0;
                            i28 = 0;
                            while (i27 < text.length()) {
                                String str9 = text;
                                if (text.charAt(i27) == '\n') {
                                    i28++;
                                }
                                i27++;
                                text = str9;
                            }
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        TextFieldValueUIModel textFieldValue = inputBoxValue.getTextFieldValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(textFieldValue);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        TextFieldValue textFieldValue2 = (TextFieldValue) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (InputTextField$lambda$1(mutableIntState) == 1) {
                            composerStartRestartGroup.startReplaceGroup(1421293859);
                            composerStartRestartGroup.endReplaceGroup();
                            fM9687constructorimpl = Dp.m9687constructorimpl(32);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1421294489);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                            fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (z7 != 0) {
                            obj = null;
                            companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                        } else {
                            obj = null;
                            companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                        }
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                        if (z6) {
                            f = 1.0f;
                        } else {
                            f = 0.4f;
                        }
                        Modifier modifierAlpha = AlphaKt.alpha(modifierFillMaxWidth$default, f);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(1110752716);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                            jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1110843236);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                            jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(modifierAlpha, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                        if ((i22 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            str7 = str5;
                            objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            str7 = str5;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier3 = companion;
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU, false, (Function1) objRememberedValue5, 1, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        String str10 = str7;
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
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                        if (str6 != null) {
                            length = str6.length();
                        } else {
                            length = 0;
                        }
                        TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                        float f3 = 12;
                        float f4 = 2;
                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f4), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f4)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester);
                        SolidColor solidColor = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                        if ((i22 & 112) == 32) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            final int i30 = length;
                            final String str11 = str6;
                            objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                                @Override // androidx.compose.ui.text.input.VisualTransformation
                                public final TransformedText filter(AnnotatedString annotatedString) {
                                    return InputTextFieldKt.InputTextField$lambda$7$0$0(str11, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i30, annotatedString);
                                }
                            };
                            str8 = str11;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            str8 = str6;
                        }
                        VisualTransformation visualTransformation = (VisualTransformation) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                        boolean zChangedInstance = composerStartRestartGroup.changedInstance(inputBoxValue);
                        if ((i6 & 896) == 256) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = zChangedInstance | z10;
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!z11 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Function1 function1 = (Function1) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                        if ((234881024 & i6) == 67108864) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean zChangedInstance2 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if ((29360128 & i6) == 8388608) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        z14 = zChangedInstance2 | z13;
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z14 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            i26 = i25;
                            mutableIntState2 = mutableIntState;
                            scrollState4 = scrollState3;
                            objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            i26 = i25;
                            mutableIntState2 = mutableIntState;
                            scrollState4 = scrollState3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SolidColor solidColor2 = solidColor;
                        i23 = i;
                        int i31 = i6 >> 6;
                        int i32 = i26;
                        BasicTextFieldKt.BasicTextField(textFieldValue2, (Function1<? super TextFieldValue, Unit>) function1, modifierFocusRequester, z6, false, textStyleM9104copyp1EtxEg$default, (KeyboardOptions) null, (KeyboardActions) null, false, i32, 0, visualTransformation, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i31 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                            bottom = Alignment.INSTANCE.getCenterVertically();
                        } else {
                            bottom = Alignment.INSTANCE.getBottom();
                        }
                        Modifier modifierAlign = rowScopeInstance.align(companion2, bottom);
                        if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                        } else if (z7 != 0) {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                        } else {
                            fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                        }
                        Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                        if (z7 != 0) {
                            f2 = 32;
                        } else {
                            f2 = 24;
                        }
                        Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default, Dp.m9687constructorimpl(f2));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs);
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                        actionButton = function2;
                        actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                        KeyboardAction keyboardAction4 = keyboardAction3;
                        KeyboardActionsHandler(keyboardAction4, onKeyboardFocusHandled, focusRequester, composerStartRestartGroup, (i31 & 112) | ((i6 >> 27) & 14) | 384);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        keyboardAction2 = keyboardAction4;
                        scrollState2 = scrollState4;
                        z5 = z6;
                        i24 = i32;
                        z4 = z7;
                        str4 = str10;
                        str3 = str8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final int i33 = i23;
                        final Modifier modifier4 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i33, onTextChanged, onKeyboardFocusHandled, modifier4, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                i17 = i5 & 1024;
                if (i17 != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                i20 = i5 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                if ((i4 & 384) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
                }
                i22 = i18;
                if ((i6 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    i23 = i;
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    scrollState2 = scrollState;
                    i24 = i2;
                    keyboardAction2 = keyboardAction;
                    str3 = str2;
                    modifier3 = modifier2;
                    z5 = z;
                    str4 = str;
                } else {
                    if (i29 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    if (i9 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i11 != 0) {
                        scrollState3 = null;
                    } else {
                        scrollState3 = scrollState;
                    }
                    if (i13 != 0) {
                        i25 = 3;
                    } else {
                        i25 = i2;
                    }
                    if (i15 != 0) {
                        keyboardAction3 = null;
                    } else {
                        keyboardAction3 = keyboardAction;
                    }
                    if (i17 != 0) {
                        str5 = null;
                    } else {
                        str5 = str;
                    }
                    if (i20 != 0) {
                        str6 = null;
                    } else {
                        str6 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        text = inputBoxValue.getTextFieldValue().getText();
                        i27 = 0;
                        i28 = 0;
                        while (i27 < text.length()) {
                            String str12 = text;
                            if (text.charAt(i27) == '\n') {
                                i28++;
                            }
                            i27++;
                            text = str12;
                        }
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    TextFieldValueUIModel textFieldValue3 = inputBoxValue.getTextFieldValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(textFieldValue3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    TextFieldValue textFieldValue4 = (TextFieldValue) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (InputTextField$lambda$1(mutableIntState) == 1) {
                        composerStartRestartGroup.startReplaceGroup(1421293859);
                        composerStartRestartGroup.endReplaceGroup();
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1421294489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                        fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (z7 != 0) {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                    } else {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                    }
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                    if (z6) {
                        f = 1.0f;
                    } else {
                        f = 0.4f;
                    }
                    Modifier modifierAlpha2 = AlphaKt.alpha(modifierFillMaxWidth$default2, f);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(1110752716);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1110843236);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha2, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier3 = companion;
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU2, false, (Function1) objRememberedValue5, 1, null);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    String str13 = str7;
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
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                    if (str6 != null) {
                        length = str6.length();
                    } else {
                        length = 0;
                    }
                    TextStyle textStyleM9104copyp1EtxEg$default2 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                    float f5 = 12;
                    float f6 = 2;
                    Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance2, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f5), Dp.m9687constructorimpl(f6), Dp.m9687constructorimpl(f5), Dp.m9687constructorimpl(f6)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester2);
                    SolidColor solidColor3 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        final int i34 = length;
                        final String str14 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str14, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i34, annotatedString);
                            }
                        };
                        str8 = str14;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        final int i35 = length;
                        final String str15 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str15, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i35, annotatedString);
                            }
                        };
                        str8 = str15;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    VisualTransformation visualTransformation2 = (VisualTransformation) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(inputBoxValue);
                    if ((i6 & 896) == 256) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance3 | z10;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function3 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                    if ((234881024 & i6) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance4 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChangedInstance4 | z13;
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SolidColor solidColor4 = solidColor3;
                    i23 = i;
                    int i36 = i6 >> 6;
                    int i37 = i26;
                    BasicTextFieldKt.BasicTextField(textFieldValue4, (Function1<? super TextFieldValue, Unit>) function3, modifierFocusRequester2, z6, false, textStyleM9104copyp1EtxEg$default2, (KeyboardOptions) null, (KeyboardActions) null, false, i37, 0, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor4, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i36 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        bottom = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        bottom = Alignment.INSTANCE.getBottom();
                    }
                    Modifier modifierAlign2 = rowScopeInstance2.align(companion3, bottom);
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else if (z7 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                    }
                    Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign2, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                    if (z7 != 0) {
                        f2 = 32;
                    } else {
                        f2 = 24;
                    }
                    Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default2, Dp.m9687constructorimpl(f2));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                    actionButton = function2;
                    actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                    KeyboardAction keyboardAction5 = keyboardAction3;
                    KeyboardActionsHandler(keyboardAction5, onKeyboardFocusHandled, focusRequester2, composerStartRestartGroup, (i36 & 112) | ((i6 >> 27) & 14) | 384);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardAction2 = keyboardAction5;
                    scrollState2 = scrollState4;
                    z5 = z6;
                    i24 = i37;
                    z4 = z7;
                    str4 = str13;
                    str3 = str8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i38 = i23;
                    final Modifier modifier5 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i38, onTextChanged, onKeyboardFocusHandled, modifier5, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            i15 = i5 & 512;
            if (i15 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (keyboardAction == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = keyboardAction.ordinal();
                    }
                    if (composerStartRestartGroup.changed(iOrdinal)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i6 |= i16;
                }
                i17 = i5 & 1024;
                if (i17 != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                i20 = i5 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                if ((i4 & 384) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
                }
                i22 = i18;
                if ((i6 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    i23 = i;
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    scrollState2 = scrollState;
                    i24 = i2;
                    keyboardAction2 = keyboardAction;
                    str3 = str2;
                    modifier3 = modifier2;
                    z5 = z;
                    str4 = str;
                } else {
                    if (i29 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    if (i9 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i11 != 0) {
                        scrollState3 = null;
                    } else {
                        scrollState3 = scrollState;
                    }
                    if (i13 != 0) {
                        i25 = 3;
                    } else {
                        i25 = i2;
                    }
                    if (i15 != 0) {
                        keyboardAction3 = null;
                    } else {
                        keyboardAction3 = keyboardAction;
                    }
                    if (i17 != 0) {
                        str5 = null;
                    } else {
                        str5 = str;
                    }
                    if (i20 != 0) {
                        str6 = null;
                    } else {
                        str6 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        text = inputBoxValue.getTextFieldValue().getText();
                        i27 = 0;
                        i28 = 0;
                        while (i27 < text.length()) {
                            String str16 = text;
                            if (text.charAt(i27) == '\n') {
                                i28++;
                            }
                            i27++;
                            text = str16;
                        }
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    FocusRequester focusRequester3 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    TextFieldValueUIModel textFieldValue5 = inputBoxValue.getTextFieldValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(textFieldValue5);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    TextFieldValue textFieldValue6 = (TextFieldValue) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (InputTextField$lambda$1(mutableIntState) == 1) {
                        composerStartRestartGroup.startReplaceGroup(1421293859);
                        composerStartRestartGroup.endReplaceGroup();
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1421294489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                        fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (z7 != 0) {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                    } else {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                    }
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                    if (z6) {
                        f = 1.0f;
                    } else {
                        f = 0.4f;
                    }
                    Modifier modifierAlpha3 = AlphaKt.alpha(modifierFillMaxWidth$default3, f);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(1110752716);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1110843236);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM588backgroundbw27NRU3 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha3, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier3 = companion;
                    Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU3, false, (Function1) objRememberedValue5, 1, null);
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    String str17 = str7;
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
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                    if (str6 != null) {
                        length = str6.length();
                    } else {
                        length = 0;
                    }
                    TextStyle textStyleM9104copyp1EtxEg$default3 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                    float f7 = 12;
                    float f8 = 2;
                    Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance3, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f7), Dp.m9687constructorimpl(f8), Dp.m9687constructorimpl(f7), Dp.m9687constructorimpl(f8)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester3);
                    SolidColor solidColor5 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        final int i39 = length;
                        final String str18 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str18, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i39, annotatedString);
                            }
                        };
                        str8 = str18;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        final int i310 = length;
                        final String str19 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str19, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i310, annotatedString);
                            }
                        };
                        str8 = str19;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    VisualTransformation visualTransformation3 = (VisualTransformation) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                    boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(inputBoxValue);
                    if ((i6 & 896) == 256) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance5 | z10;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function4 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                    if ((234881024 & i6) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance6 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChangedInstance6 | z13;
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SolidColor solidColor6 = solidColor5;
                    i23 = i;
                    int i311 = i6 >> 6;
                    int i312 = i26;
                    BasicTextFieldKt.BasicTextField(textFieldValue6, (Function1<? super TextFieldValue, Unit>) function4, modifierFocusRequester3, z6, false, textStyleM9104copyp1EtxEg$default3, (KeyboardOptions) null, (KeyboardActions) null, false, i312, 0, visualTransformation3, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor6, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i311 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        bottom = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        bottom = Alignment.INSTANCE.getBottom();
                    }
                    Modifier modifierAlign3 = rowScopeInstance3.align(companion4, bottom);
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else if (z7 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                    }
                    Modifier modifierM1222paddingqDBjuR0$default3 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign3, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                    if (z7 != 0) {
                        f2 = 32;
                    } else {
                        f2 = 24;
                    }
                    Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default3, Dp.m9687constructorimpl(f2));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs3);
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                    actionButton = function2;
                    actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                    KeyboardAction keyboardAction6 = keyboardAction3;
                    KeyboardActionsHandler(keyboardAction6, onKeyboardFocusHandled, focusRequester3, composerStartRestartGroup, (i311 & 112) | ((i6 >> 27) & 14) | 384);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardAction2 = keyboardAction6;
                    scrollState2 = scrollState4;
                    z5 = z6;
                    i24 = i312;
                    z4 = z7;
                    str4 = str17;
                    str3 = str8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i313 = i23;
                    final Modifier modifier6 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i313, onTextChanged, onKeyboardFocusHandled, modifier6, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            i17 = i5 & 1024;
            if (i17 != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            i20 = i5 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i4 & 48) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            if ((i4 & 384) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
            }
            i22 = i18;
            if ((i6 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                i23 = i;
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                scrollState2 = scrollState;
                i24 = i2;
                keyboardAction2 = keyboardAction;
                str3 = str2;
                modifier3 = modifier2;
                z5 = z;
                str4 = str;
            } else {
                if (i29 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z6 = true;
                } else {
                    z6 = z;
                }
                if (i9 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i11 != 0) {
                    scrollState3 = null;
                } else {
                    scrollState3 = scrollState;
                }
                if (i13 != 0) {
                    i25 = 3;
                } else {
                    i25 = i2;
                }
                if (i15 != 0) {
                    keyboardAction3 = null;
                } else {
                    keyboardAction3 = keyboardAction;
                }
                if (i17 != 0) {
                    str5 = null;
                } else {
                    str5 = str;
                }
                if (i20 != 0) {
                    str6 = null;
                } else {
                    str6 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    text = inputBoxValue.getTextFieldValue().getText();
                    i27 = 0;
                    i28 = 0;
                    while (i27 < text.length()) {
                        String str110 = text;
                        if (text.charAt(i27) == '\n') {
                            i28++;
                        }
                        i27++;
                        text = str110;
                    }
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                FocusRequester focusRequester4 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                TextFieldValueUIModel textFieldValue7 = inputBoxValue.getTextFieldValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(textFieldValue7);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                TextFieldValue textFieldValue8 = (TextFieldValue) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (InputTextField$lambda$1(mutableIntState) == 1) {
                    composerStartRestartGroup.startReplaceGroup(1421293859);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9687constructorimpl = Dp.m9687constructorimpl(32);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1421294489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                    fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z7 != 0) {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                } else {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                }
                Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                if (z6) {
                    f = 1.0f;
                } else {
                    f = 0.4f;
                }
                Modifier modifierAlpha4 = AlphaKt.alpha(modifierFillMaxWidth$default4, f);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(1110752716);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1110843236);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM588backgroundbw27NRU4 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha4, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifier3 = companion;
                Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU4, false, (Function1) objRememberedValue5, 1, null);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                String str111 = str7;
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
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                if (str6 != null) {
                    length = str6.length();
                } else {
                    length = 0;
                }
                TextStyle textStyleM9104copyp1EtxEg$default4 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                float f9 = 12;
                float f10 = 2;
                Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance4, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f10), Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f10)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester4);
                SolidColor solidColor7 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    final int i314 = length;
                    final String str112 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str112, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i314, annotatedString);
                        }
                    };
                    str8 = str112;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    final int i315 = length;
                    final String str113 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str113, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i315, annotatedString);
                        }
                    };
                    str8 = str113;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                VisualTransformation visualTransformation4 = (VisualTransformation) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(inputBoxValue);
                if ((i6 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance7 | z10;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function5 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                if ((234881024 & i6) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance8 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChangedInstance8 | z13;
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SolidColor solidColor8 = solidColor7;
                i23 = i;
                int i316 = i6 >> 6;
                int i317 = i26;
                BasicTextFieldKt.BasicTextField(textFieldValue8, (Function1<? super TextFieldValue, Unit>) function5, modifierFocusRequester4, z6, false, textStyleM9104copyp1EtxEg$default4, (KeyboardOptions) null, (KeyboardActions) null, false, i317, 0, visualTransformation4, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor8, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i316 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    bottom = Alignment.INSTANCE.getCenterVertically();
                } else {
                    bottom = Alignment.INSTANCE.getBottom();
                }
                Modifier modifierAlign4 = rowScopeInstance4.align(companion5, bottom);
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else if (z7 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                } else {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                }
                Modifier modifierM1222paddingqDBjuR0$default4 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign4, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                if (z7 != 0) {
                    f2 = 32;
                } else {
                    f2 = 24;
                }
                Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default4, Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs4);
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
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                actionButton = function2;
                actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                KeyboardAction keyboardAction7 = keyboardAction3;
                KeyboardActionsHandler(keyboardAction7, onKeyboardFocusHandled, focusRequester4, composerStartRestartGroup, (i316 & 112) | ((i6 >> 27) & 14) | 384);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardAction2 = keyboardAction7;
                scrollState2 = scrollState4;
                z5 = z6;
                i24 = i317;
                z4 = z7;
                str4 = str111;
                str3 = str8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i318 = i23;
                final Modifier modifier7 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i318, onTextChanged, onKeyboardFocusHandled, modifier7, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i6 |= 24576;
        modifier2 = modifier;
        i7 = i5 & 32;
        if (i7 != 0) {
            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i6 |= i8;
        }
        i9 = i5 & 64;
        if (i9 != 0) {
            i6 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i6 |= i10;
        }
        i11 = i5 & 128;
        if (i11 != 0) {
            i6 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(scrollState)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i6 |= i12;
        }
        i13 = i5 & 256;
        if (i13 != 0) {
            if ((i3 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(i2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i6 |= i14;
            }
            i15 = i5 & 512;
            if (i15 != 0) {
                if ((i3 & 805306368) == 0) {
                    if (keyboardAction == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = keyboardAction.ordinal();
                    }
                    if (composerStartRestartGroup.changed(iOrdinal)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i6 |= i16;
                }
                i17 = i5 & 1024;
                if (i17 != 0) {
                    i18 = i4 | 6;
                } else if ((i4 & 6) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i19 = 4;
                    } else {
                        i19 = 2;
                    }
                    i18 = i4 | i19;
                } else {
                    i18 = i4;
                }
                i20 = i5 & 2048;
                if (i20 != 0) {
                    i18 |= 48;
                } else if ((i4 & 48) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i18 |= i21;
                }
                if ((i4 & 384) == 0) {
                    i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
                }
                i22 = i18;
                if ((i6 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    i23 = i;
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    scrollState2 = scrollState;
                    i24 = i2;
                    keyboardAction2 = keyboardAction;
                    str3 = str2;
                    modifier3 = modifier2;
                    z5 = z;
                    str4 = str;
                } else {
                    if (i29 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z6 = true;
                    } else {
                        z6 = z;
                    }
                    if (i9 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i11 != 0) {
                        scrollState3 = null;
                    } else {
                        scrollState3 = scrollState;
                    }
                    if (i13 != 0) {
                        i25 = 3;
                    } else {
                        i25 = i2;
                    }
                    if (i15 != 0) {
                        keyboardAction3 = null;
                    } else {
                        keyboardAction3 = keyboardAction;
                    }
                    if (i17 != 0) {
                        str5 = null;
                    } else {
                        str5 = str;
                    }
                    if (i20 != 0) {
                        str6 = null;
                    } else {
                        str6 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        text = inputBoxValue.getTextFieldValue().getText();
                        i27 = 0;
                        i28 = 0;
                        while (i27 < text.length()) {
                            String str114 = text;
                            if (text.charAt(i27) == '\n') {
                                i28++;
                            }
                            i27++;
                            text = str114;
                        }
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    FocusRequester focusRequester5 = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    TextFieldValueUIModel textFieldValue9 = inputBoxValue.getTextFieldValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(textFieldValue9);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    TextFieldValue textFieldValue10 = (TextFieldValue) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (InputTextField$lambda$1(mutableIntState) == 1) {
                        composerStartRestartGroup.startReplaceGroup(1421293859);
                        composerStartRestartGroup.endReplaceGroup();
                        fM9687constructorimpl = Dp.m9687constructorimpl(32);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1421294489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                        fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (z7 != 0) {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                    } else {
                        obj = null;
                        companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                    }
                    Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                    if (z6) {
                        f = 1.0f;
                    } else {
                        f = 0.4f;
                    }
                    Modifier modifierAlpha5 = AlphaKt.alpha(modifierFillMaxWidth$default5, f);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(1110752716);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1110843236);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                        jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierM588backgroundbw27NRU5 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha5, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        str7 = str5;
                        objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier3 = companion;
                    Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU5, false, (Function1) objRememberedValue5, 1, null);
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    String str115 = str7;
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
                    Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                    if (str6 != null) {
                        length = str6.length();
                    } else {
                        length = 0;
                    }
                    TextStyle textStyleM9104copyp1EtxEg$default5 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                    float f11 = 12;
                    float f12 = 2;
                    Modifier modifierFocusRequester5 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance5, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f11), Dp.m9687constructorimpl(f12), Dp.m9687constructorimpl(f11), Dp.m9687constructorimpl(f12)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester5);
                    SolidColor solidColor9 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                    if ((i22 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        final int i319 = length;
                        final String str116 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str116, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i319, annotatedString);
                            }
                        };
                        str8 = str116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        final int i3110 = length;
                        final String str117 = str6;
                        objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                            @Override // androidx.compose.ui.text.input.VisualTransformation
                            public final TransformedText filter(AnnotatedString annotatedString) {
                                return InputTextFieldKt.InputTextField$lambda$7$0$0(str117, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i3110, annotatedString);
                            }
                        };
                        str8 = str117;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    VisualTransformation visualTransformation5 = (VisualTransformation) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                    boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(inputBoxValue);
                    if ((i6 & 896) == 256) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = zChangedInstance9 | z10;
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function1 function6 = (Function1) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                    if ((234881024 & i6) == 67108864) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance10 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((29360128 & i6) == 8388608) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = zChangedInstance10 | z13;
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (z14) {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        i26 = i25;
                        mutableIntState2 = mutableIntState;
                        scrollState4 = scrollState3;
                        objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SolidColor solidColor10 = solidColor9;
                    i23 = i;
                    int i3111 = i6 >> 6;
                    int i3112 = i26;
                    BasicTextFieldKt.BasicTextField(textFieldValue10, (Function1<? super TextFieldValue, Unit>) function6, modifierFocusRequester5, z6, false, textStyleM9104copyp1EtxEg$default5, (KeyboardOptions) null, (KeyboardActions) null, false, i3112, 0, visualTransformation5, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor10, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3111 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        bottom = Alignment.INSTANCE.getCenterVertically();
                    } else {
                        bottom = Alignment.INSTANCE.getBottom();
                    }
                    Modifier modifierAlign5 = rowScopeInstance5.align(companion6, bottom);
                    if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else if (z7 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                    }
                    Modifier modifierM1222paddingqDBjuR0$default5 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign5, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                    if (z7 != 0) {
                        f2 = 32;
                    } else {
                        f2 = 24;
                    }
                    Modifier modifierM1266size3ABfNKs5 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default5, Dp.m9687constructorimpl(f2));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs5);
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
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                    actionButton = function2;
                    actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                    KeyboardAction keyboardAction8 = keyboardAction3;
                    KeyboardActionsHandler(keyboardAction8, onKeyboardFocusHandled, focusRequester5, composerStartRestartGroup, (i3111 & 112) | ((i6 >> 27) & 14) | 384);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardAction2 = keyboardAction8;
                    scrollState2 = scrollState4;
                    z5 = z6;
                    i24 = i3112;
                    z4 = z7;
                    str4 = str115;
                    str3 = str8;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i3113 = i23;
                    final Modifier modifier8 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i3113, onTextChanged, onKeyboardFocusHandled, modifier8, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            i17 = i5 & 1024;
            if (i17 != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            i20 = i5 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i4 & 48) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            if ((i4 & 384) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
            }
            i22 = i18;
            if ((i6 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                i23 = i;
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                scrollState2 = scrollState;
                i24 = i2;
                keyboardAction2 = keyboardAction;
                str3 = str2;
                modifier3 = modifier2;
                z5 = z;
                str4 = str;
            } else {
                if (i29 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z6 = true;
                } else {
                    z6 = z;
                }
                if (i9 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i11 != 0) {
                    scrollState3 = null;
                } else {
                    scrollState3 = scrollState;
                }
                if (i13 != 0) {
                    i25 = 3;
                } else {
                    i25 = i2;
                }
                if (i15 != 0) {
                    keyboardAction3 = null;
                } else {
                    keyboardAction3 = keyboardAction;
                }
                if (i17 != 0) {
                    str5 = null;
                } else {
                    str5 = str;
                }
                if (i20 != 0) {
                    str6 = null;
                } else {
                    str6 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    text = inputBoxValue.getTextFieldValue().getText();
                    i27 = 0;
                    i28 = 0;
                    while (i27 < text.length()) {
                        String str118 = text;
                        if (text.charAt(i27) == '\n') {
                            i28++;
                        }
                        i27++;
                        text = str118;
                    }
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                FocusRequester focusRequester6 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                TextFieldValueUIModel textFieldValue11 = inputBoxValue.getTextFieldValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(textFieldValue11);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                TextFieldValue textFieldValue12 = (TextFieldValue) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (InputTextField$lambda$1(mutableIntState) == 1) {
                    composerStartRestartGroup.startReplaceGroup(1421293859);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9687constructorimpl = Dp.m9687constructorimpl(32);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1421294489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                    fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z7 != 0) {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                } else {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                }
                Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                if (z6) {
                    f = 1.0f;
                } else {
                    f = 0.4f;
                }
                Modifier modifierAlpha6 = AlphaKt.alpha(modifierFillMaxWidth$default6, f);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(1110752716);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1110843236);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM588backgroundbw27NRU6 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha6, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifier3 = companion;
                Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU6, false, (Function1) objRememberedValue5, 1, null);
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default6);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                String str119 = str7;
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
                Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                if (str6 != null) {
                    length = str6.length();
                } else {
                    length = 0;
                }
                TextStyle textStyleM9104copyp1EtxEg$default6 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                float f13 = 12;
                float f14 = 2;
                Modifier modifierFocusRequester6 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance6, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f13), Dp.m9687constructorimpl(f14), Dp.m9687constructorimpl(f13), Dp.m9687constructorimpl(f14)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester6);
                SolidColor solidColor11 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    final int i3114 = length;
                    final String str1110 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str1110, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i3114, annotatedString);
                        }
                    };
                    str8 = str1110;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    final int i3115 = length;
                    final String str1111 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str1111, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i3115, annotatedString);
                        }
                    };
                    str8 = str1111;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                VisualTransformation visualTransformation6 = (VisualTransformation) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                boolean zChangedInstance11 = composerStartRestartGroup.changedInstance(inputBoxValue);
                if ((i6 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance11 | z10;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function7 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                if ((234881024 & i6) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance12 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChangedInstance12 | z13;
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SolidColor solidColor12 = solidColor11;
                i23 = i;
                int i3116 = i6 >> 6;
                int i3117 = i26;
                BasicTextFieldKt.BasicTextField(textFieldValue12, (Function1<? super TextFieldValue, Unit>) function7, modifierFocusRequester6, z6, false, textStyleM9104copyp1EtxEg$default6, (KeyboardOptions) null, (KeyboardActions) null, false, i3117, 0, visualTransformation6, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor12, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3116 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                Modifier.Companion companion7 = Modifier.INSTANCE;
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    bottom = Alignment.INSTANCE.getCenterVertically();
                } else {
                    bottom = Alignment.INSTANCE.getBottom();
                }
                Modifier modifierAlign6 = rowScopeInstance6.align(companion7, bottom);
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else if (z7 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                } else {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                }
                Modifier modifierM1222paddingqDBjuR0$default6 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign6, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                if (z7 != 0) {
                    f2 = 32;
                } else {
                    f2 = 24;
                }
                Modifier modifierM1266size3ABfNKs6 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default6, Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs6);
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
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                actionButton = function2;
                actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                KeyboardAction keyboardAction9 = keyboardAction3;
                KeyboardActionsHandler(keyboardAction9, onKeyboardFocusHandled, focusRequester6, composerStartRestartGroup, (i3116 & 112) | ((i6 >> 27) & 14) | 384);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardAction2 = keyboardAction9;
                scrollState2 = scrollState4;
                z5 = z6;
                i24 = i3117;
                z4 = z7;
                str4 = str119;
                str3 = str8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i3118 = i23;
                final Modifier modifier9 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i3118, onTextChanged, onKeyboardFocusHandled, modifier9, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i6 |= 100663296;
        i15 = i5 & 512;
        if (i15 != 0) {
            if ((i3 & 805306368) == 0) {
                if (keyboardAction == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = keyboardAction.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i6 |= i16;
            }
            i17 = i5 & 1024;
            if (i17 != 0) {
                i18 = i4 | 6;
            } else if ((i4 & 6) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
                i18 = i4 | i19;
            } else {
                i18 = i4;
            }
            i20 = i5 & 2048;
            if (i20 != 0) {
                i18 |= 48;
            } else if ((i4 & 48) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i18 |= i21;
            }
            if ((i4 & 384) == 0) {
                i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
            }
            i22 = i18;
            if ((i6 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                i23 = i;
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                scrollState2 = scrollState;
                i24 = i2;
                keyboardAction2 = keyboardAction;
                str3 = str2;
                modifier3 = modifier2;
                z5 = z;
                str4 = str;
            } else {
                if (i29 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z6 = true;
                } else {
                    z6 = z;
                }
                if (i9 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i11 != 0) {
                    scrollState3 = null;
                } else {
                    scrollState3 = scrollState;
                }
                if (i13 != 0) {
                    i25 = 3;
                } else {
                    i25 = i2;
                }
                if (i15 != 0) {
                    keyboardAction3 = null;
                } else {
                    keyboardAction3 = keyboardAction;
                }
                if (i17 != 0) {
                    str5 = null;
                } else {
                    str5 = str;
                }
                if (i20 != 0) {
                    str6 = null;
                } else {
                    str6 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    text = inputBoxValue.getTextFieldValue().getText();
                    i27 = 0;
                    i28 = 0;
                    while (i27 < text.length()) {
                        String str1112 = text;
                        if (text.charAt(i27) == '\n') {
                            i28++;
                        }
                        i27++;
                        text = str1112;
                    }
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                FocusRequester focusRequester7 = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                TextFieldValueUIModel textFieldValue13 = inputBoxValue.getTextFieldValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(textFieldValue13);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                TextFieldValue textFieldValue14 = (TextFieldValue) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (InputTextField$lambda$1(mutableIntState) == 1) {
                    composerStartRestartGroup.startReplaceGroup(1421293859);
                    composerStartRestartGroup.endReplaceGroup();
                    fM9687constructorimpl = Dp.m9687constructorimpl(32);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1421294489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                    fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (z7 != 0) {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
                } else {
                    obj = null;
                    companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
                }
                Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
                if (z6) {
                    f = 1.0f;
                } else {
                    f = 0.4f;
                }
                Modifier modifierAlpha7 = AlphaKt.alpha(modifierFillMaxWidth$default7, f);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(1110752716);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1110843236);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                    jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM588backgroundbw27NRU7 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha7, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (z8) {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    str7 = str5;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifier3 = companion;
                Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU7, false, (Function1) objRememberedValue5, 1, null);
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                String str1113 = str7;
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
                Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
                if (str6 != null) {
                    length = str6.length();
                } else {
                    length = 0;
                }
                TextStyle textStyleM9104copyp1EtxEg$default7 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
                float f15 = 12;
                float f16 = 2;
                Modifier modifierFocusRequester7 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance7, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f15), Dp.m9687constructorimpl(f16), Dp.m9687constructorimpl(f15), Dp.m9687constructorimpl(f16)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester7);
                SolidColor solidColor13 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
                if ((i22 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    final int i3119 = length;
                    final String str1114 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str1114, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i3119, annotatedString);
                        }
                    };
                    str8 = str1114;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    final int i31110 = length;
                    final String str1115 = str6;
                    objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                        @Override // androidx.compose.ui.text.input.VisualTransformation
                        public final TransformedText filter(AnnotatedString annotatedString) {
                            return InputTextFieldKt.InputTextField$lambda$7$0$0(str1115, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i31110, annotatedString);
                        }
                    };
                    str8 = str1115;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                VisualTransformation visualTransformation7 = (VisualTransformation) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
                boolean zChangedInstance13 = composerStartRestartGroup.changedInstance(inputBoxValue);
                if ((i6 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = zChangedInstance13 | z10;
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Function1 function8 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
                if ((234881024 & i6) == 67108864) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance14 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((29360128 & i6) == 8388608) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = zChangedInstance14 | z13;
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (z14) {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    i26 = i25;
                    mutableIntState2 = mutableIntState;
                    scrollState4 = scrollState3;
                    objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SolidColor solidColor14 = solidColor13;
                i23 = i;
                int i31111 = i6 >> 6;
                int i31112 = i26;
                BasicTextFieldKt.BasicTextField(textFieldValue14, (Function1<? super TextFieldValue, Unit>) function8, modifierFocusRequester7, z6, false, textStyleM9104copyp1EtxEg$default7, (KeyboardOptions) null, (KeyboardActions) null, false, i31112, 0, visualTransformation7, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor14, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i31111 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
                Modifier.Companion companion8 = Modifier.INSTANCE;
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    bottom = Alignment.INSTANCE.getCenterVertically();
                } else {
                    bottom = Alignment.INSTANCE.getBottom();
                }
                Modifier modifierAlign7 = rowScopeInstance7.align(companion8, bottom);
                if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else if (z7 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
                } else {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
                }
                Modifier modifierM1222paddingqDBjuR0$default7 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign7, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
                if (z7 != 0) {
                    f2 = 32;
                } else {
                    f2 = 24;
                }
                Modifier modifierM1266size3ABfNKs7 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default7, Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs7);
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
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
                actionButton = function2;
                actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                KeyboardAction keyboardAction10 = keyboardAction3;
                KeyboardActionsHandler(keyboardAction10, onKeyboardFocusHandled, focusRequester7, composerStartRestartGroup, (i31111 & 112) | ((i6 >> 27) & 14) | 384);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardAction2 = keyboardAction10;
                scrollState2 = scrollState4;
                z5 = z6;
                i24 = i31112;
                z4 = z7;
                str4 = str1113;
                str3 = str8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i31113 = i23;
                final Modifier modifier10 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i31113, onTextChanged, onKeyboardFocusHandled, modifier10, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i6 |= 805306368;
        i17 = i5 & 1024;
        if (i17 != 0) {
            i18 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            if (composerStartRestartGroup.changed(str)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i18 = i4 | i19;
        } else {
            i18 = i4;
        }
        i20 = i5 & 2048;
        if (i20 != 0) {
            i18 |= 48;
        } else if ((i4 & 48) == 0) {
            if (composerStartRestartGroup.changed(str2)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i18 |= i21;
        }
        if ((i4 & 384) == 0) {
            i18 |= composerStartRestartGroup.changedInstance(actionButton) ? 256 : 128;
        }
        i22 = i18;
        if ((i6 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            i23 = i;
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
            scrollState2 = scrollState;
            i24 = i2;
            keyboardAction2 = keyboardAction;
            str3 = str2;
            modifier3 = modifier2;
            z5 = z;
            str4 = str;
        } else {
            if (i29 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                z6 = true;
            } else {
                z6 = z;
            }
            if (i9 != 0) {
                z7 = false;
            } else {
                z7 = z2;
            }
            if (i11 != 0) {
                scrollState3 = null;
            } else {
                scrollState3 = scrollState;
            }
            if (i13 != 0) {
                i25 = 3;
            } else {
                i25 = i2;
            }
            if (i15 != 0) {
                keyboardAction3 = null;
            } else {
                keyboardAction3 = keyboardAction;
            }
            if (i17 != 0) {
                str5 = null;
            } else {
                str5 = str;
            }
            if (i20 != 0) {
                str6 = null;
            } else {
                str6 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1807063521, i6, i22, "com.box.android.base.presentation.components.inputbar.InputTextField (InputTextField.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421275371, "CC(remember):InputTextField.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                text = inputBoxValue.getTextFieldValue().getText();
                i27 = 0;
                i28 = 0;
                while (i27 < text.length()) {
                    String str1116 = text;
                    if (text.charAt(i27) == '\n') {
                        i28++;
                    }
                    i27++;
                    text = str1116;
                }
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(Math.max(i28, 1));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421279518, "CC(remember):InputTextField.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            FocusRequester focusRequester8 = (FocusRequester) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
            TextFieldValueUIModel textFieldValue15 = inputBoxValue.getTextFieldValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421283231, "CC(remember):InputTextField.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(textFieldValue15);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = inputBoxValue.getTextFieldValue().getFieldValue();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            TextFieldValue textFieldValue16 = (TextFieldValue) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (InputTextField$lambda$1(mutableIntState) == 1) {
                composerStartRestartGroup.startReplaceGroup(1421293859);
                composerStartRestartGroup.endReplaceGroup();
                fM9687constructorimpl = Dp.m9687constructorimpl(32);
            } else {
                composerStartRestartGroup.startReplaceGroup(1421294489);
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4227L6");
                fM9687constructorimpl = Dp.m9687constructorimpl(InputTextField$lambda$1(mutableIntState) * ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(20), composerStartRestartGroup, 6));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z7 != 0) {
                obj = null;
                companionM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(44), 0.0f, 2, null);
            } else {
                obj = null;
                companionM1254heightInVpY3zN4$default = Modifier.INSTANCE;
            }
            Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(companion.then(companionM1254heightInVpY3zN4$default), 0.0f, 1, obj);
            if (z6) {
                f = 1.0f;
            } else {
                f = 0.4f;
            }
            Modifier modifierAlpha8 = AlphaKt.alpha(modifierFillMaxWidth$default8, f);
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(1110752716);
                ComposerKt.sourceInformation(composerStartRestartGroup, "108@4537L6");
                jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11582getTopLayerInteractiveBackground0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1110843236);
                ComposerKt.sourceInformation(composerStartRestartGroup, "110@4628L6");
                jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM588backgroundbw27NRU8 = BackgroundKt.m588backgroundbw27NRU(modifierAlpha8, jM11583getTopLayerInteractiveBackgroundDisabled0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(18)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1421312531, "CC(remember):InputTextField.kt#9igjgp");
            if ((i22 & 14) == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z8) {
                str7 = str5;
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                str7 = str5;
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$6$0(str7, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifier3 = companion;
            Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierM588backgroundbw27NRU8, false, (Function1) objRememberedValue5, 1, null);
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default8);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            String str1117 = str7;
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
            Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1531176142, "C130@5431L6,163@6878L6,164@6940L1461,122@5055L279,156@6584L246,135@5599L646,120@4980L3431,199@8421L465,213@8895L27,215@8932L78:InputTextField.kt#epp6th");
            if (str6 != null) {
                length = str6.length();
            } else {
                length = 0;
            }
            TextStyle textStyleM9104copyp1EtxEg$default8 = TextStyle.m9104copyp1EtxEg$default(BoxTheme.INSTANCE.getTypography().getBoxMedium14(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null);
            float f17 = 12;
            float f18 = 2;
            Modifier modifierFocusRequester8 = FocusRequesterModifierKt.focusRequester(SizeKt.m1252height3ABfNKs(RowScope.weight$default(rowScopeInstance8, PaddingKt.m1221paddingqDBjuR0(BackgroundKt.m589backgroundbw27NRU$default(TestTagKt.testTag(Modifier.INSTANCE, "InputBox"), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f17), Dp.m9687constructorimpl(f18), Dp.m9687constructorimpl(f17), Dp.m9687constructorimpl(f18)), 1.0f, false, 2, null), fM9687constructorimpl), focusRequester8);
            SolidColor solidColor15 = new SolidColor(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187878286, "CC(remember):InputTextField.kt#9igjgp");
            if ((i22 & 112) == 32) {
                z9 = true;
            } else {
                z9 = false;
            }
            zChanged2 = z9 | composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) | composerStartRestartGroup.changedInstance(inputBoxValue) | composerStartRestartGroup.changed(length);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                final int i31114 = length;
                final String str1118 = str6;
                objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                    @Override // androidx.compose.ui.text.input.VisualTransformation
                    public final TransformedText filter(AnnotatedString annotatedString) {
                        return InputTextFieldKt.InputTextField$lambda$7$0$0(str1118, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i31114, annotatedString);
                    }
                };
                str8 = str1118;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                final int i31115 = length;
                final String str1119 = str6;
                objRememberedValue6 = new VisualTransformation() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda14
                    @Override // androidx.compose.ui.text.input.VisualTransformation
                    public final TransformedText filter(AnnotatedString annotatedString) {
                        return InputTextFieldKt.InputTextField$lambda$7$0$0(str1119, inputBoxValue, jM11533getMainActiveControl0d7_KjU, i31115, annotatedString);
                    }
                };
                str8 = str1119;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            VisualTransformation visualTransformation8 = (VisualTransformation) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187939788, "CC(remember):InputTextField.kt#9igjgp");
            boolean zChangedInstance15 = composerStartRestartGroup.changedInstance(inputBoxValue);
            if ((i6 & 896) == 256) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = zChangedInstance15 | z10;
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!z11) {
                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$7$1$0(inputBoxValue, onTextChanged, (TextFieldValue) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function9 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -187890893, "CC(remember):InputTextField.kt#9igjgp");
            if ((234881024 & i6) == 67108864) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean zChangedInstance16 = z12 | composerStartRestartGroup.changedInstance(coroutineScope);
            if ((29360128 & i6) == 8388608) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = zChangedInstance16 | z13;
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (z14) {
                i26 = i25;
                mutableIntState2 = mutableIntState;
                scrollState4 = scrollState3;
                objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                i26 = i25;
                mutableIntState2 = mutableIntState;
                scrollState4 = scrollState3;
                objRememberedValue8 = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return InputTextFieldKt.InputTextField$lambda$7$2$0(i26, coroutineScope, mutableIntState2, scrollState4, (TextLayoutResult) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SolidColor solidColor16 = solidColor15;
            i23 = i;
            int i31116 = i6 >> 6;
            int i31117 = i26;
            BasicTextFieldKt.BasicTextField(textFieldValue16, (Function1<? super TextFieldValue, Unit>) function9, modifierFocusRequester8, z6, false, textStyleM9104copyp1EtxEg$default8, (KeyboardOptions) null, (KeyboardActions) null, false, i31117, 0, visualTransformation8, (Function1<? super TextLayoutResult, Unit>) objRememberedValue8, (MutableInteractionSource) null, (Brush) solidColor16, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1111950176, true, new Function3() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return InputTextFieldKt.InputTextField$lambda$7$3(inputBoxValue, str8, i23, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i31116 & 7168) | ((i6 << 3) & C.ENCODING_PCM_DOUBLE), ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 9680);
            Modifier.Companion companion9 = Modifier.INSTANCE;
            if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                bottom = Alignment.INSTANCE.getCenterVertically();
            } else {
                bottom = Alignment.INSTANCE.getBottom();
            }
            Modifier modifierAlign8 = rowScopeInstance8.align(companion9, bottom);
            if (InputTextField$lambda$1(mutableIntState2) <= 1) {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            } else if (z7 != 0) {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(6);
            } else {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
            }
            Modifier modifierM1222paddingqDBjuR0$default8 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign8, 0.0f, 0.0f, 0.0f, fM9687constructorimpl2, 7, null);
            if (z7 != 0) {
                f2 = 32;
            } else {
                f2 = 24;
            }
            Modifier modifierM1266size3ABfNKs8 = SizeKt.m1266size3ABfNKs(modifierM1222paddingqDBjuR0$default8, Dp.m9687constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs8);
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
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809263326, "C211@8862L14:InputTextField.kt#epp6th");
            actionButton = function2;
            actionButton.invoke(composerStartRestartGroup, Integer.valueOf((i22 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
            KeyboardAction keyboardAction11 = keyboardAction3;
            KeyboardActionsHandler(keyboardAction11, onKeyboardFocusHandled, focusRequester8, composerStartRestartGroup, (i31116 & 112) | ((i6 >> 27) & 14) | 384);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardAction2 = keyboardAction11;
            scrollState2 = scrollState4;
            z5 = z6;
            i24 = i31117;
            z4 = z7;
            str4 = str1117;
            str3 = str8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i31118 = i23;
            final Modifier modifier11 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return InputTextFieldKt.InputTextField$lambda$8(inputBoxValue, i31118, onTextChanged, onKeyboardFocusHandled, modifier11, z5, z4, scrollState2, i24, keyboardAction2, str4, str3, actionButton, i3, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final int InputTextField$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextField$lambda$6$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (str == null) {
            str = "";
        }
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextField$lambda$7$1$0(InputBoxValue inputBoxValue, Function1 function1, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (hasUITextChange(it, inputBoxValue.getTextFieldValue())) {
            function1.invoke(new TextFieldValueUIModel(it.getText(), TextRange.m9091getStartimpl(it.getSelection()), TextRange.m9086getEndimpl(it.getSelection()), it.getComposition(), null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextField$lambda$7$3(InputBoxValue inputBoxValue, String str, int i, Function2 innerTextField, Composer composer, int i2) {
        int i3;
        int i4;
        String str2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation(composer2, "CN(innerTextField)136@5635L596:InputTextField.kt#epp6th");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer2.changedInstance(innerTextField) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (!composer2.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1111950176, i3, -1, "com.box.android.base.presentation.components.inputbar.InputTextField.<anonymous>.<anonymous> (InputTextField.kt:136)");
            }
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1560190059, "C146@6197L16:InputTextField.kt#epp6th");
            if (inputBoxValue.getTextFieldValue().getText().length() == 0 && ((str2 = str) == null || str2.length() == 0)) {
                composer2.startReplaceGroup(1560382351);
                ComposerKt.sourceInformation(composer2, "141@5946L31,143@6093L6,140@5905L249");
                i4 = i3;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer2, 0), null, BoxTheme.INSTANCE.getColors(composer2, 6).m11584getTopLayerInteractiveSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 0, 12582912, 131066);
                composer2 = composer;
            } else {
                i4 = i3;
                composer2.startReplaceGroup(1554515880);
            }
            composer2.endReplaceGroup();
            innerTextField.invoke(composer2, Integer.valueOf(i4 & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextField$lambda$7$2$0(int i, CoroutineScope coroutineScope, MutableIntState mutableIntState, ScrollState scrollState, TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setIntValue(Math.min(it.getLineCount(), i));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new InputTextFieldKt$InputTextField$3$3$1$1(scrollState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: InputTextFieldActionButton-nBX6wN0, reason: not valid java name */
    public static final void m11823InputTextFieldActionButtonnBX6wN0(Modifier modifier, final Painter painter, final String contentDescription, final boolean z, long j, long j2, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM11533getMainActiveControl0d7_KjU;
        long jM11536getMainInactiveControl0d7_KjU;
        final Modifier modifier3;
        final long j3;
        final long j4;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-926601048);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldActionButton)N(modifier,painter,contentDescription,isEnabled,activeTint:c#ui.graphics.Color,inactiveTint:c#ui.graphics.Color,onClick)235@9534L185,229@9331L394:InputTextField.kt#epp6th");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(painter) : composerStartRestartGroup.changedInstance(painter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(contentDescription) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            jM11533getMainActiveControl0d7_KjU = j;
            i3 |= ((i2 & 16) == 0 && composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) ? 16384 : 8192;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if ((i2 & 32) == 0) {
                jM11536getMainInactiveControl0d7_KjU = j2;
                int i5 = composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU) ? 131072 : 65536;
                i3 |= i5;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j2;
            }
            i3 |= i5;
        } else {
            jM11536getMainInactiveControl0d7_KjU = j2;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "225@9210L6,226@9271L6");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                }
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 16) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                    i3 &= -458753;
                }
            }
            int i6 = i3;
            long j5 = jM11533getMainActiveControl0d7_KjU;
            long j6 = jM11536getMainInactiveControl0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-926601048, i6, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldActionButton (InputTextField.kt:228)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1193409579, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldActionButton_nBX6wN0$lambda$0(painter, contentDescription, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i7 = (i6 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            int i8 = i6 >> 6;
            m11822InputTextFieldActionButtonY0xEhic(companion, z, j5, j6, onClick, composableLambdaRememberComposableLambda, composerStartRestartGroup, i7 | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            j3 = j5;
            j4 = j6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = jM11533getMainActiveControl0d7_KjU;
            j4 = jM11536getMainInactiveControl0d7_KjU;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldActionButton_nBX6wN0$lambda$1(modifier3, painter, contentDescription, z, j3, j4, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldActionButton_nBX6wN0$lambda$0(Painter painter, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C236@9548L161:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193409579, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldActionButton.<anonymous> (InputTextField.kt:236)");
            }
            IconKt.m3575Iconww6aTOc(painter, str, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, composer, Painter.$stable | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x015b  */
    /* JADX WARN: Code duplicated, block: B:104:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:111:0x0219  */
    /* JADX WARN: Code duplicated, block: B:112:0x021b  */
    /* JADX WARN: Code duplicated, block: B:115:0x024a  */
    /* JADX WARN: Code duplicated, block: B:117:0x0250  */
    /* JADX WARN: Code duplicated, block: B:120:0x025e  */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0060  */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x010a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0120  */
    /* JADX WARN: Code duplicated, block: B:96:0x014c  */
    /* JADX INFO: renamed from: InputTextFieldActionButton-Y0xEhic, reason: not valid java name */
    public static final void m11822InputTextFieldActionButtonY0xEhic(Modifier modifier, boolean z, long j, long j2, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        long jM11533getMainActiveControl0d7_KjU;
        long jM11536getMainInactiveControl0d7_KjU;
        boolean z3;
        Modifier modifier3;
        final boolean z4;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        boolean z6;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        long j5;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1278610955);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldActionButton)N(modifier,isEnabled,activeTint:c#ui.graphics.Color,inactiveTint:c#ui.graphics.Color,onClick,content)258@10166L41,254@10030L415:InputTextField.kt#epp6th");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    int i8 = composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) ? 256 : 128;
                    i3 |= i8;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i3 |= i8;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM11536getMainInactiveControl0d7_KjU = j2;
                    int i9 = composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    jM11536getMainInactiveControl0d7_KjU = j2;
                }
                i3 |= i9;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j2;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "249@9872L6,250@9933L6");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 4) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                        i3 &= -7169;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = modifier2;
                }
                z5 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1278610955, i3, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldActionButton (InputTextField.kt:253)");
                }
                Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.RoundedCornerShape(50));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384467458, "CC(remember):InputTextField.kt#9igjgp");
                z6 = (57344 & i3) == 16384;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InputTextFieldKt.InputTextFieldActionButton_Y0xEhic$lambda$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip, z5, null, null, null, (Function0) objRememberedValue, 14, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                modifier3 = companion;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 127490873, "C264@10353L76:InputTextField.kt#epp6th");
                if (z5) {
                    j5 = jM11533getMainActiveControl0d7_KjU;
                } else {
                    j5 = jM11536getMainInactiveControl0d7_KjU;
                }
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j5)), content, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            }
            j3 = jM11533getMainActiveControl0d7_KjU;
            j4 = jM11536getMainInactiveControl0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InputTextFieldKt.InputTextFieldActionButton_Y0xEhic$lambda$2(modifier4, z4, j3, j4, onClick, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM11533getMainActiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                }
                i3 |= i8;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i3 |= i8;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM11536getMainInactiveControl0d7_KjU = j2;
                if (composerStartRestartGroup.changed(jM11536getMainInactiveControl0d7_KjU)) {
                }
                i3 |= i9;
            } else {
                jM11536getMainInactiveControl0d7_KjU = j2;
            }
            i3 |= i9;
        } else {
            jM11536getMainInactiveControl0d7_KjU = j2;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "249@9872L6,250@9933L6");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i2 & 4) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                    i3 &= -7169;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i2 & 4) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM11536getMainInactiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11536getMainInactiveControl0d7_KjU();
                    i3 &= -7169;
                }
            }
            z5 = z2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1278610955, i3, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldActionButton (InputTextField.kt:253)");
            }
            Modifier modifierClip2 = ClipKt.clip(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384467458, "CC(remember):InputTextField.kt#9igjgp");
            if ((57344 & i3) == 16384) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InputTextFieldKt.InputTextFieldActionButton_Y0xEhic$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InputTextFieldKt.InputTextFieldActionButton_Y0xEhic$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default2 = ClickableKt.m632clickableoSLSa3U$default(modifierClip2, z5, null, null, null, (Function0) objRememberedValue, 14, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            modifier3 = companion;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 127490873, "C264@10353L76:InputTextField.kt#epp6th");
            if (z5) {
                j5 = jM11533getMainActiveControl0d7_KjU;
            } else {
                j5 = jM11536getMainInactiveControl0d7_KjU;
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j5)), content, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        }
        j3 = jM11533getMainActiveControl0d7_KjU;
        j4 = jM11536getMainInactiveControl0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldActionButton_Y0xEhic$lambda$2(modifier5, z4, j3, j4, onClick, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldActionButton_Y0xEhic$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void KeyboardActionsHandler(final KeyboardAction keyboardAction, final Function0<Unit> function0, final FocusRequester focusRequester, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-678281477);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(KeyboardActionsHandler)N(keyboardAction,onKeyboardFocusHandled,focusRequester)271@10660L7,272@10709L7,273@10752L312,273@10721L343:InputTextField.kt#epp6th");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(keyboardAction == null ? -1 : keyboardAction.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(focusRequester) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-678281477, i2, -1, "com.box.android.base.presentation.components.inputbar.KeyboardActionsHandler (InputTextField.kt:270)");
            }
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FocusManager focusManager = (FocusManager) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1006538963, "CC(remember):InputTextField.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChanged = (i3 == 4) | ((i2 & 896) == 256) | composerStartRestartGroup.changed(softwareKeyboardController) | composerStartRestartGroup.changedInstance(focusManager) | ((i2 & 112) == 32);
            InputTextFieldKt$KeyboardActionsHandler$1$1 inputTextFieldKt$KeyboardActionsHandler$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || inputTextFieldKt$KeyboardActionsHandler$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                inputTextFieldKt$KeyboardActionsHandler$1$1RememberedValue = new InputTextFieldKt$KeyboardActionsHandler$1$1(keyboardAction, focusRequester, softwareKeyboardController, focusManager, function0, null);
                composerStartRestartGroup.updateRememberedValue(inputTextFieldKt$KeyboardActionsHandler$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(keyboardAction, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) inputTextFieldKt$KeyboardActionsHandler$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.KeyboardActionsHandler$lambda$1(keyboardAction, function0, focusRequester, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean hasUITextChange(TextFieldValue textFieldValue, TextFieldValueUIModel textFieldValueUIModel) {
        return (Intrinsics.areEqual(textFieldValue.getText(), textFieldValueUIModel.getText()) && TextRange.m9091getStartimpl(textFieldValue.getSelection()) == textFieldValueUIModel.getSelectionStart() && TextRange.m9086getEndimpl(textFieldValue.getSelection()) == textFieldValueUIModel.getSelectionEnd()) ? false : true;
    }

    private static final void InputTextFieldWithSubmitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1943042825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldWithSubmitPreview)297@11526L73,298@11613L637,298@11604L646:InputTextField.kt#epp6th");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1943042825, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldWithSubmitPreview (InputTextField.kt:296)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1046617038, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new InputBoxValue(new TextFieldValueUIModel("test", 0, 0, null, 14, null), null, 2, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(674414046, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldWithSubmitPreview$lambda$3(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldWithSubmitPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InputBoxValue InputTextFieldWithSubmitPreview$lambda$1(MutableState<InputBoxValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithSubmitPreview$lambda$3(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C303@11799L57,306@11895L2,299@11623L621:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(674414046, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldWithSubmitPreview.<anonymous> (InputTextField.kt:299)");
            }
            InputBoxValue inputBoxValueInputTextFieldWithSubmitPreview$lambda$1 = InputTextFieldWithSubmitPreview$lambda$1(mutableState);
            int i2 = R.string.comment_bar_placeholder;
            ComposerKt.sourceInformationMarkerStart(composer, -428157481, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InputTextFieldKt.InputTextFieldWithSubmitPreview$lambda$3$0$0(mutableState, (TextFieldValueUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -428154464, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextField(inputBoxValueInputTextFieldWithSubmitPreview$lambda$1, i2, function1, (Function0) objRememberedValue2, null, false, false, null, 0, null, null, null, ComposableSingletons$InputTextFieldKt.INSTANCE.getLambda$350733301$base_generalProdRelease(), composer, 1576320, 384, 4016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithSubmitPreview$lambda$3$0$0(MutableState mutableState, TextFieldValueUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(new InputBoxValue(it, null, 2, null));
        return Unit.INSTANCE;
    }

    private static final void InputTextFieldLargeWithSubmitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-313947870);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldLargeWithSubmitPreview)322@12345L73,323@12432L636,323@12423L645:InputTextField.kt#epp6th");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-313947870, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldLargeWithSubmitPreview (InputTextField.kt:321)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1056190293, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new InputBoxValue(new TextFieldValueUIModel("test", 0, 0, null, 14, null), null, 2, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1317485715, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldLargeWithSubmitPreview$lambda$3(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldLargeWithSubmitPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InputBoxValue InputTextFieldLargeWithSubmitPreview$lambda$1(MutableState<InputBoxValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithSubmitPreview$lambda$3(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C328@12617L57,331@12713L2,324@12442L620:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1317485715, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldLargeWithSubmitPreview.<anonymous> (InputTextField.kt:324)");
            }
            InputBoxValue inputBoxValueInputTextFieldLargeWithSubmitPreview$lambda$1 = InputTextFieldLargeWithSubmitPreview$lambda$1(mutableState);
            int i2 = R.string.comment_bar_placeholder;
            ComposerKt.sourceInformationMarkerStart(composer, 911586182, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InputTextFieldKt.InputTextFieldLargeWithSubmitPreview$lambda$3$0$0(mutableState, (TextFieldValueUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 911589199, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextField(inputBoxValueInputTextFieldLargeWithSubmitPreview$lambda$1, i2, function1, (Function0) objRememberedValue2, null, false, true, null, 0, null, null, null, ComposableSingletons$InputTextFieldKt.INSTANCE.m11813getLambda$768150602$base_generalProdRelease(), composer, 1576320, 384, 4016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithSubmitPreview$lambda$3$0$0(MutableState mutableState, TextFieldValueUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(new InputBoxValue(it, null, 2, null));
        return Unit.INSTANCE;
    }

    private static final void InputTextFieldWithCustomActionPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1907275384);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldWithCustomActionPreview)347@13164L73,348@13251L846,348@13242L855:InputTextField.kt#epp6th");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907275384, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldWithCustomActionPreview (InputTextField.kt:346)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1059389279, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new InputBoxValue(new TextFieldValueUIModel("test", 0, 0, null, 14, null), null, 2, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(862373261, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldWithCustomActionPreview$lambda$3(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldWithCustomActionPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InputBoxValue InputTextFieldWithCustomActionPreview$lambda$1(MutableState<InputBoxValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithCustomActionPreview$lambda$3(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C353@13437L57,356@13533L2,349@13261L830:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(862373261, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldWithCustomActionPreview.<anonymous> (InputTextField.kt:349)");
            }
            InputBoxValue inputBoxValueInputTextFieldWithCustomActionPreview$lambda$1 = InputTextFieldWithCustomActionPreview$lambda$1(mutableState);
            int i2 = R.string.comment_bar_placeholder;
            ComposerKt.sourceInformationMarkerStart(composer, -187978298, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InputTextFieldKt.InputTextFieldWithCustomActionPreview$lambda$3$0$0(mutableState, (TextFieldValueUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -187975281, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextField(inputBoxValueInputTextFieldWithCustomActionPreview$lambda$1, i2, function1, (Function0) objRememberedValue2, null, false, false, null, 0, null, null, null, ComposableSingletons$InputTextFieldKt.INSTANCE.getLambda$711892580$base_generalProdRelease(), composer, 1576320, 384, 4016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldWithCustomActionPreview$lambda$3$0$0(MutableState mutableState, TextFieldValueUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(new InputBoxValue(it, null, 2, null));
        return Unit.INSTANCE;
    }

    private static final void InputTextFieldLargeWithCustomActionPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-299823663);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputTextFieldLargeWithCustomActionPreview)378@14198L73,379@14285L845,379@14276L854:InputTextField.kt#epp6th");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299823663, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldLargeWithCustomActionPreview (InputTextField.kt:377)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367729062, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new InputBoxValue(new TextFieldValueUIModel("test", 0, 0, null, 14, null), null, 2, null), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1005593564, true, new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldLargeWithCustomActionPreview$lambda$3(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InputTextFieldKt.InputTextFieldLargeWithCustomActionPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final InputBoxValue InputTextFieldLargeWithCustomActionPreview$lambda$1(MutableState<InputBoxValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithCustomActionPreview$lambda$3(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C384@14470L57,387@14566L2,380@14295L829:InputTextField.kt#epp6th");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1005593564, i, -1, "com.box.android.base.presentation.components.inputbar.InputTextFieldLargeWithCustomActionPreview.<anonymous> (InputTextField.kt:380)");
            }
            InputBoxValue inputBoxValueInputTextFieldLargeWithCustomActionPreview$lambda$1 = InputTextFieldLargeWithCustomActionPreview$lambda$1(mutableState);
            int i2 = R.string.comment_bar_placeholder;
            ComposerKt.sourceInformationMarkerStart(composer, 7779381, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InputTextFieldKt.InputTextFieldLargeWithCustomActionPreview$lambda$3$0$0(mutableState, (TextFieldValueUIModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 7782398, "CC(remember):InputTextField.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            InputTextField(inputBoxValueInputTextFieldLargeWithCustomActionPreview$lambda$1, i2, function1, (Function0) objRememberedValue2, null, false, true, null, 0, null, null, null, ComposableSingletons$InputTextFieldKt.INSTANCE.m11812getLambda$1762576027$base_generalProdRelease(), composer, 1576320, 384, 4016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputTextFieldLargeWithCustomActionPreview$lambda$3$0$0(MutableState mutableState, TextFieldValueUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(new InputBoxValue(it, null, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransformedText InputTextField$lambda$7$0$0(String str, final InputBoxValue inputBoxValue, long j, final int i, AnnotatedString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        if (str != null) {
            builder.append(str);
            builder.addStyle(new SpanStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null), 0, str.length());
        }
        builder.append(inputBoxValue.getTextFieldValue().getText());
        for (MentionSpanV2 mentionSpanV2 : inputBoxValue.getMentionSpans()) {
            builder.addStyle(new SpanStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null), mentionSpanV2.getStartIndex() + i, mentionSpanV2.getEndIndex() + i);
        }
        return new TransformedText(builder.toAnnotatedString(), new OffsetMapping() { // from class: com.box.android.base.presentation.components.inputbar.InputTextFieldKt$InputTextField$3$1$1$2
            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int originalToTransformed(int offset) {
                return offset + i;
            }

            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int transformedToOriginal(int offset) {
                int i2 = i;
                if (offset <= i2) {
                    return 0;
                }
                return RangesKt.coerceAtMost(offset - i2, inputBoxValue.getTextFieldValue().getText().length());
            }
        });
    }
}
