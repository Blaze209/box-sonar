package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a3\u0010 \u001a\u00020\u0001*\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(\u001aJ\u0010)\u001a\u00020\u0001*\u00020*2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0-H\u0082@¢\u0006\u0004\b.\u0010/\u001a1\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020*2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00105\u001a1\u00106\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020*2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00105\u001a%\u00107\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00108\u001a\u001d\u00109\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010:\u001a\u001d\u0010;\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010:\u001a\u001d\u0010<\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010:\u001a%\u0010=\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010>\u001a%\u0010?\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010>\u001a=\u0010@\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0003¢\u0006\u0002\u0010F\u001aQ\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020D2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00010K2\u0006\u0010\u0006\u001a\u00020\u00072\u001c\u0010L\u001a\u0018\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00010M¢\u0006\u0002\bO¢\u0006\u0002\bPH\u0003¢\u0006\u0002\u0010Q\u001a\u0015\u0010R\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010S\u001a?\u0010T\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0013H\u0003¢\u0006\u0004\bY\u0010Z\u001a-\u0010[\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\\\u001a\u001c\u0010]\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a5\u0010^\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020*2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00132\u0006\u0010_\u001a\u00020`H\u0003¢\u0006\u0002\u0010a\u001ap\u0010b\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010U\u001a\u00020c2\u0006\u0010d\u001a\u00020c2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00130f2\u0006\u0010g\u001a\u00020\u00132\u0006\u0010h\u001a\u00020i2!\u0010j\u001a\u001d\u0012\u0013\u0012\u00110c¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020\u00010MH\u0002¢\u0006\u0004\bm\u0010n\u001a/\u0010o\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u0013H\u0003¢\u0006\u0004\bp\u0010q\u001a_\u0010r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010U\u001a\u00020c2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u00010M2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010V\u001a\u00020W2\b\b\u0002\u0010t\u001a\u00020u2\b\b\u0002\u0010v\u001a\u00020w2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\bx\u0010y\u001a4\u0010z\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010{\u001a\u00020\"2\u0011\u0010L\u001a\r\u0012\u0004\u0012\u00020\u00010K¢\u0006\u0002\bOH\u0003¢\u0006\u0002\u0010|\u001a)\u0010}\u001a\u00020~2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u007f\u001a\u00020\u0010H\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a-\u0010\u0082\u0001\u001a\u00020\"2\u0007\u0010\u0083\u0001\u001a\u00020\"2\u0007\u0010\u0084\u0001\u001a\u00020\"2\u0007\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0002\u001a\u0019\u0010\u0087\u0001\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0002\u001a\u0016\u0010®\u0001\u001a\u00020\u0005*\u00020\u00052\u0007\u0010®\u0001\u001a\u00020\u0013H\u0003\"\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0017\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u0019\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018\"\u0015\u0010\u001a\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\"\u0015\u0010\u001b\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018\"\u0018\u0010\u001d\u001a\u00020\u0010*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0018\u00100\u001a\u000201*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\"\u001c\u0010\u0088\u0001\u001a\u00020\u0013*\u00030\u0089\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u001c\u0010\u008c\u0001\u001a\u00020\u0013*\u00030\u0089\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008b\u0001\"\u0017\u0010\u008e\u0001\u001a\u00020\t8AX\u0080\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u000f\u0010\u0091\u0001\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0092\u0001\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0095\u0001\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0096\u0001\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0097\u0001\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0098\u0001\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0099\u0001\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u009a\u0001\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010\u009e\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010\u009f\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010 \u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010¡\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010¢\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¥\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010§\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010¨\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010©\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u0013\u0010ª\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001\"\u001b\u0010«\u0001\u001a\u00030\u009c\u0001X\u0080\u0004¢\u0006\r\n\u0003\u0010\u009d\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001¨\u0006¯\u0001²\u0006\n\u0010g\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\u000b\u0010°\u0001\u001a\u00020cX\u008a\u008e\u0002²\u0006\u000b\u0010±\u0001\u001a\u00020cX\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\u000b\u0010%\u001a\u00030²\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010³\u0001\u001a\u00020&X\u008a\u008e\u0002²\u0006\f\u0010´\u0001\u001a\u00030µ\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010¶\u0001\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"TimePicker", "", "state", "Landroidx/compose/material3/TimePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "rememberTimePickerState", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "MaxHourValue", "MaxMinuteValue", "isPm", "(Landroidx/compose/material3/TimePickerState;)Z", "isHourInputValid", "isMinuteInputValid", "isInputValid", "TimePickerState", "hourForDisplay", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "moveSelector", "x", "", "y", "maxDist", TtmlNode.CENTER, "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "onTap-uYHVD98", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "VerticalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "HorizontalTimePicker", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "ClockDisplayNumbers", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalPeriodToggle", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", ViewProps.ON_CLICK, "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TimeSelector", "value", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "isValid", "TimeSelector-u8A1Dfs", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockFace", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "drawSelector", "ClockText", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/ui/focus/FocusManager;Landroidx/compose/runtime/Composer;I)V", "timeInputOnChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "prevValue", "userOverride", "Landroidx/compose/ui/node/Ref;", "a11yServicesEnabled", "errorHandler", "Landroidx/compose/material3/TimeInputErrorHandler;", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-Eb28HvY", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/node/Ref;ZLandroidx/compose/material3/TimeInputErrorHandler;Lkotlin/jvm/functions/Function1;)V", "SupportingText", "SupportingText-73flGVI", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ZLandroidx/compose/runtime/Composer;I)V", "TimePickerTextField", "onValueChange", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "CircularLayout", "radiusToSizeRatio", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "dist", "x1", "y1", "x2", "y2", "atan", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "defaultTimePickerLayoutType", "getDefaultTimePickerLayoutType", "(Landroidx/compose/runtime/Composer;I)I", "FullCircle", "HalfCircle", "QuarterCircle", "", "RadiansPerMinute", "RadiansPerHour", "SeparatorZIndex", "MaxValueForTextField", "OuterCircleToSizeRatio", "InnerCircleToSizeRatio", "ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "SupportLabelTop", "MaxDistance", "MinimumInteractiveSize", "Minutes", "Landroidx/collection/IntList;", "Hours", "ExtraHours", "PeriodToggleMargin", "TimePickerMaxHeight", "TimePickerMidHeight", "ClockDialMidContainerSize", "ClockDialMinContainerSize", "getClockDialMinContainerSize", "()F", ViewProps.VISIBLE, "material3", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter", "boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "selected"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt {
    private static final float ClockDialMidContainerSize;
    private static final float ClockDialMinContainerSize;
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final IntList ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final IntList Hours;
    private static final int MaxHourValue = 23;
    private static final int MaxMinuteValue = 59;
    private static final int MaxValueForTextField = 99;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimePickerMaxHeight;
    private static final float TimePickerMidHeight;
    private static final float OuterCircleToSizeRatio = Dp.m9687constructorimpl(101) / TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM();
    private static final float InnerCircleToSizeRatio = Dp.m9687constructorimpl(69) / TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM();
    private static final float ClockDisplayBottomMargin = Dp.m9687constructorimpl(36);
    private static final float SupportLabelTop = Dp.m9687constructorimpl(7);
    private static final float MaxDistance = Dp.m9687constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m9687constructorimpl(48);
    private static final IntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularLayout$lambda$1(Modifier modifier, float f, Function2 function2, int i, int i2, Composer composer, int i3) {
        CircularLayout(modifier, f, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockDisplayNumbers$lambda$1(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        ClockDisplayNumbers(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$1(Modifier modifier, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, boolean z, int i, Composer composer, int i2) {
        ClockFace(modifier, analogTimePickerState, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$18(Modifier modifier, AnalogTimePickerState analogTimePickerState, int i, boolean z, FocusManager focusManager, int i2, Composer composer, int i3) {
        ClockText(modifier, analogTimePickerState, i, z, focusManager, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplaySeparator$lambda$2(Modifier modifier, int i, Composer composer, int i2) {
        DisplaySeparator(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalClockDisplay$lambda$1(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        HorizontalClockDisplay(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPeriodToggle$lambda$1(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        HorizontalPeriodToggle(modifier, timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalTimePicker$lambda$2(AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2, Composer composer, int i3) {
        HorizontalTimePicker(analogTimePickerState, modifier, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$2(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, MeasurePolicy measurePolicy, Shape shape, Shape shape2, int i, Composer composer, int i2) {
        PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportingText_73flGVI$lambda$1(Modifier modifier, int i, TimePickerState timePickerState, boolean z, int i2, Composer composer, int i3) {
        m4556SupportingText73flGVI(modifier, i, timePickerState, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInput$lambda$0(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2, Composer composer, int i3) {
        TimeInput(timePickerState, modifier, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$10(Modifier modifier, TimePickerColors timePickerColors, TimePickerState timePickerState, int i, Composer composer, int i2) {
        TimeInputImpl(modifier, timePickerColors, timePickerState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$3(Modifier modifier, TextFieldValue textFieldValue, Function1 function1, TimePickerState timePickerState, int i, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TimePickerColors timePickerColors, int i2, int i3, Composer composer, int i4) {
        m4558TimePickerTextField1vLObsk(modifier, textFieldValue, function1, timePickerState, i, keyboardOptions, keyboardActions, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePicker_mT9BvqQ$lambda$4(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2, int i3, Composer composer, int i4) {
        m4557TimePickermT9BvqQ(timePickerState, modifier, timePickerColors, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_u8A1Dfs$lambda$4(Modifier modifier, int i, TimePickerState timePickerState, int i2, TimePickerColors timePickerColors, boolean z, int i3, Composer composer, int i4) {
        m4559TimeSelectoru8A1Dfs(modifier, i, timePickerState, i2, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleItem$lambda$1(boolean z, Shape shape, Function0 function0, TimePickerColors timePickerColors, Function3 function3, int i, Composer composer, int i2) {
        ToggleItem(z, shape, function0, timePickerColors, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalClockDisplay$lambda$1(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        VerticalClockDisplay(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalPeriodToggle$lambda$1(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        VerticalPeriodToggle(modifier, timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalTimePicker$lambda$2(AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2, Composer composer, int i3) {
        VerticalTimePicker(analogTimePickerState, modifier, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x017c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0185  */
    /* JADX WARN: Code duplicated, block: B:109:0x018d  */
    /* JADX WARN: Code duplicated, block: B:112:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:113:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:116:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:118:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:121:0x0209  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0123  */
    /* JADX WARN: Code duplicated, block: B:90:0x0130  */
    /* JADX WARN: Code duplicated, block: B:93:0x0137  */
    /* JADX WARN: Code duplicated, block: B:95:0x013f  */
    /* JADX WARN: Code duplicated, block: B:98:0x016f  */
    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m4557TimePickermT9BvqQ(final TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        TimePickerColors timePickerColors2;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final TimePickerColors timePickerColors3;
        final int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        TimePickerColors timePickerColorsColors;
        int i7;
        TimePickerColors timePickerColors4;
        int iM4520layoutTypesDNSZnc;
        State<Boolean> stateRememberAccessibilityServiceState;
        Object objRememberedValue;
        Ref ref;
        int i8;
        boolean z2;
        Object objRememberedValue2;
        AnalogTimePickerState analogTimePickerState;
        boolean z3;
        boolean z4;
        TimePickerKt$TimePicker$1$1 timePickerKt$TimePicker$1$1RememberedValue;
        TimePickerColors timePickerColors5;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-619286452);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePicker)N(state,modifier,colors,layoutType:c#material3.TimePickerLayoutType)244@12758L35,245@12817L27,247@12868L62,249@12977L181,249@12936L222:TimePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = ((i2 & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    timePickerColors2 = timePickerColors;
                    int i10 = composerStartRestartGroup.changed(timePickerColors2) ? 256 : 128;
                    i4 |= i10;
                } else {
                    timePickerColors2 = timePickerColors;
                }
                i4 |= i10;
            } else {
                timePickerColors2 = timePickerColors;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    i5 = i;
                    int i11 = composerStartRestartGroup.changed(i5) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    i5 = i;
                }
                i4 |= i11;
            } else {
                i5 = i;
            }
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "241@12641L8,242@12709L12");
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -897;
                    } else {
                        timePickerColorsColors = timePickerColors2;
                    }
                    if ((i3 & 8) != 0) {
                        i7 = i4 & (-7169);
                        timePickerColors4 = timePickerColorsColors;
                        iM4520layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m4520layoutTypesDNSZnc(composerStartRestartGroup, 6);
                    } else {
                        i7 = i4;
                        timePickerColors4 = timePickerColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-619286452, i7, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:243)");
                    }
                    stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866183559, "CC(remember):TimePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Ref();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ref = (Ref) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866185226, "CC(remember):TimePicker.kt#9igjgp");
                    i8 = i7 & 14;
                    if (i8 != 4 || ((i7 & 8) != 0 && composerStartRestartGroup.changed(timePickerState))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    analogTimePickerState = (AnalogTimePickerState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Integer numValueOf = Integer.valueOf(timePickerState.getHour());
                    Integer numValueOf2 = Integer.valueOf(timePickerState.getMinute());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866188833, "CC(remember):TimePicker.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(analogTimePickerState);
                    if (i8 != 4 || ((i7 & 8) != 0 && composerStartRestartGroup.changedInstance(timePickerState))) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z3 | zChangedInstance;
                    timePickerKt$TimePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4 || timePickerKt$TimePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        timePickerKt$TimePicker$1$1RememberedValue = new TimePickerKt$TimePicker$1$1(ref, analogTimePickerState, timePickerState, null);
                        composerStartRestartGroup.updateRememberedValue(timePickerKt$TimePicker$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, numValueOf2, (Function2) timePickerKt$TimePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                    if (TimePickerLayoutType.m4577equalsimpl0(iM4520layoutTypesDNSZnc, TimePickerLayoutType.INSTANCE.m4582getVerticalQJTpgSE())) {
                        composerStartRestartGroup.startReplaceGroup(2017513523);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "258@13223L179");
                        timePickerColors5 = timePickerColors4;
                        modifier4 = companion;
                        VerticalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        timePickerColors5 = timePickerColors4;
                        modifier4 = companion;
                        composerStartRestartGroup.startReplaceGroup(2017712977);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "265@13424L181");
                        HorizontalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    timePickerColors3 = timePickerColors5;
                    i6 = iM4520layoutTypesDNSZnc;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    i7 = i4;
                    companion = modifier2;
                    timePickerColors4 = timePickerColors2;
                }
                iM4520layoutTypesDNSZnc = i5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-619286452, i7, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:243)");
                }
                stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866183559, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ref = (Ref) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866185226, "CC(remember):TimePicker.kt#9igjgp");
                i8 = i7 & 14;
                if (i8 != 4) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                analogTimePickerState = (AnalogTimePickerState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Integer numValueOf3 = Integer.valueOf(timePickerState.getHour());
                Integer numValueOf4 = Integer.valueOf(timePickerState.getMinute());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866188833, "CC(remember):TimePicker.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(analogTimePickerState);
                if (i8 != 4) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                z4 = z3 | zChangedInstance2;
                timePickerKt$TimePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    timePickerKt$TimePicker$1$1RememberedValue = new TimePickerKt$TimePicker$1$1(ref, analogTimePickerState, timePickerState, null);
                    composerStartRestartGroup.updateRememberedValue(timePickerKt$TimePicker$1$1RememberedValue);
                } else {
                    timePickerKt$TimePicker$1$1RememberedValue = new TimePickerKt$TimePicker$1$1(ref, analogTimePickerState, timePickerState, null);
                    composerStartRestartGroup.updateRememberedValue(timePickerKt$TimePicker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(numValueOf3, numValueOf4, (Function2) timePickerKt$TimePicker$1$1RememberedValue, composerStartRestartGroup, 0);
                if (TimePickerLayoutType.m4577equalsimpl0(iM4520layoutTypesDNSZnc, TimePickerLayoutType.INSTANCE.m4582getVerticalQJTpgSE())) {
                    composerStartRestartGroup.startReplaceGroup(2017513523);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "258@13223L179");
                    timePickerColors5 = timePickerColors4;
                    modifier4 = companion;
                    VerticalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    timePickerColors5 = timePickerColors4;
                    modifier4 = companion;
                    composerStartRestartGroup.startReplaceGroup(2017712977);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "265@13424L181");
                    HorizontalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                timePickerColors3 = timePickerColors5;
                i6 = iM4520layoutTypesDNSZnc;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                timePickerColors3 = timePickerColors2;
                i6 = i5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.TimePicker_mT9BvqQ$lambda$4(timePickerState, modifier3, timePickerColors3, i6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                timePickerColors2 = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColors2)) {
                }
                i4 |= i10;
            } else {
                timePickerColors2 = timePickerColors;
            }
            i4 |= i10;
        } else {
            timePickerColors2 = timePickerColors;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                i5 = i;
                if (composerStartRestartGroup.changed(i5)) {
                }
                i4 |= i11;
            } else {
                i5 = i;
            }
            i4 |= i11;
        } else {
            i5 = i;
        }
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "241@12641L8,242@12709L12");
            if ((i2 & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -897;
                } else {
                    timePickerColorsColors = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i7 = i4 & (-7169);
                    timePickerColors4 = timePickerColorsColors;
                    iM4520layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m4520layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    i7 = i4;
                    timePickerColors4 = timePickerColorsColors;
                    iM4520layoutTypesDNSZnc = i5;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -897;
                } else {
                    timePickerColorsColors = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i7 = i4 & (-7169);
                    timePickerColors4 = timePickerColorsColors;
                    iM4520layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m4520layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    i7 = i4;
                    timePickerColors4 = timePickerColorsColors;
                    iM4520layoutTypesDNSZnc = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, i7, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:243)");
            }
            stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866183559, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ref = (Ref) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866185226, "CC(remember):TimePicker.kt#9igjgp");
            i8 = i7 & 14;
            if (i8 != 4) {
                z2 = true;
            } else {
                z2 = true;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new AnalogTimePickerState(timePickerState, ref);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            analogTimePickerState = (AnalogTimePickerState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Integer numValueOf5 = Integer.valueOf(timePickerState.getHour());
            Integer numValueOf6 = Integer.valueOf(timePickerState.getMinute());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866188833, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(analogTimePickerState);
            if (i8 != 4) {
                z3 = true;
            } else {
                z3 = true;
            }
            z4 = z3 | zChangedInstance3;
            timePickerKt$TimePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                timePickerKt$TimePicker$1$1RememberedValue = new TimePickerKt$TimePicker$1$1(ref, analogTimePickerState, timePickerState, null);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimePicker$1$1RememberedValue);
            } else {
                timePickerKt$TimePicker$1$1RememberedValue = new TimePickerKt$TimePicker$1$1(ref, analogTimePickerState, timePickerState, null);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimePicker$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf5, numValueOf6, (Function2) timePickerKt$TimePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            if (TimePickerLayoutType.m4577equalsimpl0(iM4520layoutTypesDNSZnc, TimePickerLayoutType.INSTANCE.m4582getVerticalQJTpgSE())) {
                composerStartRestartGroup.startReplaceGroup(2017513523);
                ComposerKt.sourceInformation(composerStartRestartGroup, "258@13223L179");
                timePickerColors5 = timePickerColors4;
                modifier4 = companion;
                VerticalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                timePickerColors5 = timePickerColors4;
                modifier4 = companion;
                composerStartRestartGroup.startReplaceGroup(2017712977);
                ComposerKt.sourceInformation(composerStartRestartGroup, "265@13424L181");
                HorizontalTimePicker(analogTimePickerState, modifier4, timePickerColors5, !TimePicker_mT9BvqQ$lambda$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, i7 & 1008, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            timePickerColors3 = timePickerColors5;
            i6 = iM4520layoutTypesDNSZnc;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            timePickerColors3 = timePickerColors2;
            i6 = i5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimePicker_mT9BvqQ$lambda$4(timePickerState, modifier3, timePickerColors3, i6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TimeInput(final TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-760850373);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeInput)N(state,modifier,colors)294@14511L38:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(timePickerColors)) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "292@14493L8");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    timePickerColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-760850373, i3, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:293)");
            }
            TimeInputImpl(modifier, timePickerColors, timePickerState, composerStartRestartGroup, ((i3 >> 3) & 126) | ((i3 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final TimePickerColors timePickerColors2 = timePickerColors;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeInput$lambda$0(timePickerState, modifier2, timePickerColors2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final TimePickerState rememberTimePickerState(final int i, final int i2, final boolean z, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1237715277, "C(rememberTimePickerState)N(initialHour,initialMinute,is24Hour)605@30373L14,608@30509L185,608@30455L239:TimePicker.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = TimeFormat_androidKt.is24HourFormat(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i3, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:606)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerStateImpl, ?> Saver = TimePickerStateImpl.INSTANCE.Saver();
        ComposerKt.sourceInformationMarkerStart(composer, -261551834, "CC(remember):TimePicker.kt#9igjgp");
        boolean z2 = true;
        boolean z3 = ((((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i2)) || (i3 & 48) == 32);
        if ((((i3 & 896) ^ 384) <= 256 || !composer.changed(z)) && (i3 & 384) != 256) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        Object objRememberedValue = composer.rememberedValue();
        if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TimePickerKt.rememberTimePickerState$lambda$0$0(i, i2, z);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerStateImpl timePickerStateImpl = (TimePickerStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerStateImpl rememberTimePickerState$lambda$0$0(int i, int i2, boolean z) {
        return new TimePickerStateImpl(i, i2, z);
    }

    public static final boolean isPm(TimePickerState timePickerState) {
        return timePickerState.getHour() >= 12;
    }

    public static final boolean isHourInputValid(TimePickerState timePickerState) {
        int hourInput = timePickerState.getHourInput();
        return hourInput >= 0 && hourInput < 24;
    }

    public static final boolean isMinuteInputValid(TimePickerState timePickerState) {
        int minuteInput = timePickerState.getMinuteInput();
        return minuteInput >= 0 && minuteInput < 60;
    }

    public static final boolean isInputValid(TimePickerState timePickerState) {
        return isMinuteInputValid(timePickerState) && isHourInputValid(timePickerState);
    }

    public static final TimePickerState TimePickerState(int i, int i2, boolean z) {
        return new TimePickerStateImpl(i, i2, z);
    }

    public static final int getHourForDisplay(TimePickerState timePickerState) {
        if (timePickerState.getIs24hour()) {
            return timePickerState.getHour() % 24;
        }
        if (timePickerState.getHour() % 12 == 0) {
            return 12;
        }
        return isPm(timePickerState) ? timePickerState.getHour() - 12 : timePickerState.getHour();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    public static final void m4566moveSelectord3b8Pxo(TimePickerState timePickerState, float f, float f2, float f3, long j) {
        if (TimePickerSelectionMode.m4586equalsimpl0(timePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) && timePickerState.getIs24hour()) {
            float fDist = dist(f, f2, IntOffset.m9815getXimpl(j), IntOffset.m9816getYimpl(j));
            if (isPm(timePickerState)) {
                timePickerState.setHour(timePickerState.getHour() - (fDist < f3 ? 0 : 12));
            } else {
                timePickerState.setHour(timePickerState.getHour() + (fDist >= f3 ? 0 : 12));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX INFO: renamed from: onTap-uYHVD98, reason: not valid java name */
    public static final Object m4568onTapuYHVD98(AnalogTimePickerState analogTimePickerState, float f, float f2, float f3, boolean z, long j, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        TimePickerKt$onTap$1 timePickerKt$onTap$1;
        float f4;
        float fRint;
        boolean z2;
        AnalogTimePickerState analogTimePickerState2;
        boolean z3;
        if (continuation instanceof TimePickerKt$onTap$1) {
            timePickerKt$onTap$1 = (TimePickerKt$onTap$1) continuation;
            if ((timePickerKt$onTap$1.label & Integer.MIN_VALUE) != 0) {
                timePickerKt$onTap$1.label -= Integer.MIN_VALUE;
            } else {
                timePickerKt$onTap$1 = new TimePickerKt$onTap$1(continuation);
            }
        } else {
            timePickerKt$onTap$1 = new TimePickerKt$onTap$1(continuation);
        }
        Object obj = timePickerKt$onTap$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = timePickerKt$onTap$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float fAtan = atan(f2 - IntOffset.m9816getYimpl(j), f - IntOffset.m9815getXimpl(j));
            if (TimePickerSelectionMode.m4586equalsimpl0(analogTimePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                f4 = RadiansPerMinute;
                fRint = ((float) Math.rint((fAtan / RadiansPerMinute) / 5.0f)) * 5.0f;
            } else {
                f4 = RadiansPerHour;
                fRint = (float) Math.rint(fAtan / RadiansPerHour);
            }
            m4566moveSelectord3b8Pxo(analogTimePickerState, f, f2, f3, j);
            timePickerKt$onTap$1.L$0 = analogTimePickerState;
            z2 = z;
            timePickerKt$onTap$1.Z$0 = z2;
            timePickerKt$onTap$1.label = 1;
            if (analogTimePickerState.rotateTo(fRint * f4, animationSpec, true, timePickerKt$onTap$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            boolean z4 = timePickerKt$onTap$1.Z$0;
            AnalogTimePickerState analogTimePickerState3 = (AnalogTimePickerState) timePickerKt$onTap$1.L$0;
            ResultKt.throwOnFailure(obj);
            z2 = z4;
            analogTimePickerState = analogTimePickerState3;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z3 = timePickerKt$onTap$1.Z$0;
            analogTimePickerState2 = (AnalogTimePickerState) timePickerKt$onTap$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        AnalogTimePickerState analogTimePickerState4 = analogTimePickerState2;
        z2 = z3;
        analogTimePickerState = analogTimePickerState4;
        if (z2) {
            analogTimePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
        }
        return Unit.INSTANCE;
        if (TimePickerSelectionMode.m4586equalsimpl0(analogTimePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) && z2) {
            timePickerKt$onTap$1.L$0 = analogTimePickerState;
            timePickerKt$onTap$1.Z$0 = z2;
            timePickerKt$onTap$1.label = 2;
            if (DelayKt.delay(100L, timePickerKt$onTap$1) != coroutine_suspended) {
                boolean z5 = z2;
                analogTimePickerState2 = analogTimePickerState;
                z3 = z5;
                AnalogTimePickerState analogTimePickerState5 = analogTimePickerState2;
                z2 = z3;
                analogTimePickerState = analogTimePickerState5;
            }
            return coroutine_suspended;
        }
        if (z2) {
            analogTimePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
        }
        return Unit.INSTANCE;
    }

    public static final long getSelectorPos(AnalogTimePickerState analogTimePickerState) {
        float fM9687constructorimpl;
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(Dp.m9687constructorimpl(TimePickerTokens.INSTANCE.m5853getClockDialSelectorHandleContainerSizeD9Ej5fM() / 2.0f) * (analogTimePickerState.m2727getCurrentDiameterD9Ej5fM() / TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM()));
        if (analogTimePickerState.getIs24hour() && isPm(analogTimePickerState) && TimePickerSelectionMode.m4586equalsimpl0(analogTimePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
            fM9687constructorimpl = Dp.m9687constructorimpl(analogTimePickerState.m2727getCurrentDiameterD9Ej5fM() * InnerCircleToSizeRatio);
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(analogTimePickerState.m2727getCurrentDiameterD9Ej5fM() * OuterCircleToSizeRatio);
        }
        float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) RangesKt.coerceAtLeast(Dp.m9685boximpl(Dp.m9687constructorimpl(fM9687constructorimpl - fM9687constructorimpl2)), Dp.m9685boximpl(Dp.m9687constructorimpl(0)))).m9701unboximpl() + fM9687constructorimpl2);
        float f = 2;
        return DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(Dp.m9687constructorimpl(((float) Math.cos(analogTimePickerState.getCurrentAngle())) * fM9687constructorimpl3) + Dp.m9687constructorimpl(analogTimePickerState.m2727getCurrentDiameterD9Ej5fM() / f)))) << 32) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(Dp.m9687constructorimpl(fM9687constructorimpl3 * ((float) Math.sin(analogTimePickerState.getCurrentAngle()))) + Dp.m9687constructorimpl(analogTimePickerState.m2727getCurrentDiameterD9Ej5fM() / f)))) & 4294967295L));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:70:0x0138  */
    /* JADX WARN: Code duplicated, block: B:73:0x0144  */
    /* JADX WARN: Code duplicated, block: B:74:0x0148  */
    /* JADX WARN: Code duplicated, block: B:79:0x017b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0202  */
    /* JADX WARN: Code duplicated, block: B:84:0x0208  */
    /* JADX WARN: Code duplicated, block: B:87:0x0213  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public static final void VerticalTimePicker(final AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, final boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TimePickerColors timePickerColors2;
        boolean z2;
        boolean z3;
        final Modifier modifier3;
        final TimePickerColors timePickerColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        TimePickerColors timePickerColorsColors;
        Modifier modifier4;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1249591487);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalTimePicker)N(state,modifier,colors,autoSwitchToMinute)1048@44370L27,1047@44324L544:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    timePickerColors2 = timePickerColors;
                    int i7 = composerStartRestartGroup.changed(timePickerColors2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    timePickerColors2 = timePickerColors;
                }
                i3 |= i7;
            } else {
                timePickerColors2 = timePickerColors;
            }
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            } else {
                z2 = z;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1044@44273L8");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        modifier4 = companion;
                        i4 = i3 & (-897);
                        timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        Modifier modifier5 = companion;
                        i4 = i3;
                        timePickerColorsColors = timePickerColors2;
                        modifier4 = modifier5;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1249591487, i4, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:1046)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1733416166, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.VerticalTimePicker$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null);
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1720573003, "C1051@44475L52,1052@44536L60,1053@44605L191,1059@44805L57:TimePicker.kt#uh7d8r");
                VerticalClockDisplay(analogTimePickerState, timePickerColorsColors, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112));
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), composerStartRestartGroup, 6);
                ClockFace(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM()), analogTimePickerState, timePickerColorsColors, z2, composerStartRestartGroup, ((i4 << 3) & 112) | 6 | (i4 & 896) | (i4 & 7168));
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, ClockFaceBottomMargin), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                timePickerColors3 = timePickerColorsColors;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                timePickerColors3 = timePickerColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.VerticalTimePicker$lambda$2(analogTimePickerState, modifier3, timePickerColors3, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                timePickerColors2 = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColors2)) {
                }
                i3 |= i7;
            } else {
                timePickerColors2 = timePickerColors;
            }
            i3 |= i7;
        } else {
            timePickerColors2 = timePickerColors;
        }
        if ((i & 3072) == 0) {
            z2 = z;
            if (composerStartRestartGroup.changed(z2)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        } else {
            z2 = z;
        }
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1044@44273L8");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    modifier4 = companion;
                    i4 = i3 & (-897);
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    Modifier modifier6 = companion;
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier6;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    modifier4 = companion;
                    i4 = i3 & (-897);
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    Modifier modifier7 = companion;
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier7;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1249591487, i4, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:1046)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1733416166, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.VerticalTimePicker$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null);
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1720573003, "C1051@44475L52,1052@44536L60,1053@44605L191,1059@44805L57:TimePicker.kt#uh7d8r");
            VerticalClockDisplay(analogTimePickerState, timePickerColorsColors, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), composerStartRestartGroup, 6);
            ClockFace(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM()), analogTimePickerState, timePickerColorsColors, z2, composerStartRestartGroup, ((i4 << 3) & 112) | 6 | (i4 & 896) | (i4 & 7168));
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, ClockFaceBottomMargin), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            timePickerColors3 = timePickerColorsColors;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            timePickerColors3 = timePickerColors2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.VerticalTimePicker$lambda$2(analogTimePickerState, modifier3, timePickerColors3, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalTimePicker$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:70:0x0137  */
    /* JADX WARN: Code duplicated, block: B:73:0x0143  */
    /* JADX WARN: Code duplicated, block: B:74:0x0147  */
    /* JADX WARN: Code duplicated, block: B:79:0x017a  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:87:0x0203  */
    /* JADX WARN: Code duplicated, block: B:89:? A[RETURN, SYNTHETIC] */
    public static final void HorizontalTimePicker(final AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, final boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TimePickerColors timePickerColors2;
        boolean z2;
        boolean z3;
        final Modifier modifier3;
        final TimePickerColors timePickerColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        TimePickerColors timePickerColorsColors;
        Modifier modifier4;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1432307537);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalTimePicker)N(state,modifier,colors,autoSwitchToMinute)1071@45132L27,1070@45089L418:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    timePickerColors2 = timePickerColors;
                    int i7 = composerStartRestartGroup.changed(timePickerColors2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    timePickerColors2 = timePickerColors;
                }
                i3 |= i7;
            } else {
                timePickerColors2 = timePickerColors;
            }
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            } else {
                z2 = z;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1067@45038L8");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        modifier4 = companion;
                        i4 = i3 & (-897);
                        timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        Modifier modifier5 = companion;
                        i4 = i3;
                        timePickerColorsColors = timePickerColors2;
                        modifier4 = modifier5;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1432307537, i4, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:1069)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2058016012, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.HorizontalTimePicker$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443384930, "C1074@45233L37,1075@45279L59,1076@45347L154:TimePicker.kt#uh7d8r");
                HorizontalClockDisplay(analogTimePickerState, timePickerColorsColors, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112));
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), composerStartRestartGroup, 6);
                ClockFace(Modifier.INSTANCE.then(new ClockFaceSizeModifier()), analogTimePickerState, timePickerColorsColors, z2, composerStartRestartGroup, ((i4 << 3) & 112) | (i4 & 896) | (i4 & 7168));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                timePickerColors3 = timePickerColorsColors;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                timePickerColors3 = timePickerColors2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.HorizontalTimePicker$lambda$2(analogTimePickerState, modifier3, timePickerColors3, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                timePickerColors2 = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColors2)) {
                }
                i3 |= i7;
            } else {
                timePickerColors2 = timePickerColors;
            }
            i3 |= i7;
        } else {
            timePickerColors2 = timePickerColors;
        }
        if ((i & 3072) == 0) {
            z2 = z;
            if (composerStartRestartGroup.changed(z2)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        } else {
            z2 = z;
        }
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1067@45038L8");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    modifier4 = companion;
                    i4 = i3 & (-897);
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    Modifier modifier6 = companion;
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier6;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    modifier4 = companion;
                    i4 = i3 & (-897);
                    timePickerColorsColors = TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    Modifier modifier7 = companion;
                    i4 = i3;
                    timePickerColorsColors = timePickerColors2;
                    modifier4 = modifier7;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1432307537, i4, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:1069)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2058016012, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.HorizontalTimePicker$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443384930, "C1074@45233L37,1075@45279L59,1076@45347L154:TimePicker.kt#uh7d8r");
            HorizontalClockDisplay(analogTimePickerState, timePickerColorsColors, composerStartRestartGroup, (i4 & 14) | ((i4 >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), composerStartRestartGroup, 6);
            ClockFace(Modifier.INSTANCE.then(new ClockFaceSizeModifier()), analogTimePickerState, timePickerColorsColors, z2, composerStartRestartGroup, ((i4 << 3) & 112) | (i4 & 896) | (i4 & 7168));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            timePickerColors3 = timePickerColorsColors;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            timePickerColors3 = timePickerColors2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.HorizontalTimePicker$lambda$2(analogTimePickerState, modifier3, timePickerColors3, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalTimePicker$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    private static final void TimeInputImpl(final Modifier modifier, final TimePickerColors timePickerColors, final TimePickerState timePickerState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeInputImpl)N(modifier,colors,state)1102@46186L35,1102@46134L87,1105@46306L37,1105@46254L89,1107@46368L27,1109@46481L133,1109@46454L160,1117@46705L137,1117@46676L166,1124@46848L4371:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i2, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:1086)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840773058, "CC(remember):TimePicker.kt#9igjgp");
            int i3 = i2 & 896;
            boolean z = i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeInputImpl$lambda$0$0(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840769216, "CC(remember):TimePicker.kt#9igjgp");
            boolean z2 = i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda59
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeInputImpl$lambda$3$0(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableStateRememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840767242, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final Ref ref = (Ref) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Integer numValueOf = Integer.valueOf(timePickerState.getHour());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840763520, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance = (i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState))) | composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changed(mutableStateRememberSaveable);
            TimePickerKt$TimeInputImpl$1$1 timePickerKt$TimeInputImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || timePickerKt$TimeInputImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$TimeInputImpl$1$1RememberedValue = new TimePickerKt$TimeInputImpl$1$1(ref, timePickerState, mutableStateRememberSaveable, null);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimeInputImpl$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimeInputImpl$1$1RememberedValue, composerStartRestartGroup, 0);
            Integer numValueOf2 = Integer.valueOf(timePickerState.getMinute());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840756348, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance2 = (i3 == 256 || ((i2 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState))) | composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changed(mutableStateRememberSaveable2);
            TimePickerKt$TimeInputImpl$2$1 timePickerKt$TimeInputImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || timePickerKt$TimeInputImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$TimeInputImpl$2$1RememberedValue = new TimePickerKt$TimeInputImpl$2$1(ref, timePickerState, mutableStateRememberSaveable2, null);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimeInputImpl$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimeInputImpl$2$1RememberedValue, composerStartRestartGroup, 0);
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1385919899, "C1126@46985L5,1131@47156L35,1132@47219L50,1138@47501L3333,1134@47279L3555:TimePicker.kt#uh7d8r");
            TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont(), composerStartRestartGroup, 6), timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null);
            final State<Boolean> stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, composerStartRestartGroup, 0, 7);
            final TimeInputErrorHandler timeInputErrorHandlerRememberTimeInputErrorHandler = TimePicker_androidKt.rememberTimeInputErrorHandler(TimeInputImpl$lambda$9$0(stateRememberAccessibilityServiceState), composerStartRestartGroup, 0);
            int i4 = i2;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(textStyleM9104copyp1EtxEg$default), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda60
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeInputImpl$lambda$9$1(mutableStateRememberSaveable, timePickerState, stateRememberAccessibilityServiceState, ref, timeInputErrorHandlerRememberTimeInputErrorHandler, timePickerColors, mutableStateRememberSaveable2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (timePickerState.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(-1432596693);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1382126833);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1217@50879L324");
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1377011131, "C1218@50947L242:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m5846getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5845getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, ((i4 >> 3) & 112) | 6 | ((i4 << 3) & 896));
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeInputImpl$lambda$10(modifier, timePickerColors, timePickerState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$hourTextValue(TimePickerState timePickerState) {
        if (isHourInputValid(timePickerState)) {
            return new TextFieldValue(CalendarLocale_jvmAndAndroidKt.toLocalString$default(getHourForDisplay(timePickerState), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
        }
        return new TextFieldValue(CalendarLocale_jvmAndAndroidKt.toLocalString$default(timePickerState.getHourInput(), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$minuteTextValue(TimePickerState timePickerState) {
        if (isMinuteInputValid(timePickerState)) {
            return new TextFieldValue(CalendarLocale_jvmAndAndroidKt.toLocalString$default(timePickerState.getMinute(), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
        }
        return new TextFieldValue(CalendarLocale_jvmAndAndroidKt.toLocalString$default(timePickerState.getMinuteInput(), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TimeInputImpl$lambda$0$0(TimePickerState timePickerState) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimeInputImpl$hourTextValue(timePickerState), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$1(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TimeInputImpl$lambda$3$0(TimePickerState timePickerState) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimeInputImpl$minuteTextValue(timePickerState), null, 2, null);
    }

    private static final TextFieldValue TimeInputImpl$lambda$4(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1(final MutableState mutableState, final TimePickerState timePickerState, final State state, final Ref ref, final TimeInputErrorHandler timeInputErrorHandler, TimePickerColors timePickerColors, final MutableState mutableState2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1139@47515L3309:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306700887, i, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:1139)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 587475143, "C1142@47633L529,1156@48239L570,1178@49250L52,1140@47537L1847,1182@49401L123,1188@49680L553,1209@50676L52,1185@49541L1269:TimePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1127329796, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState) | composer.changedInstance(timePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$3$1$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m4573invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m4573invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        int iM7979getUtf16CodePointZmokQxo = KeyEvent_androidKt.m7979getUtf16CodePointZmokQxo(keyEvent);
                        if (48 <= iM7979getUtf16CodePointZmokQxo && iM7979getUtf16CodePointZmokQxo < 58 && TextRange.m9091getStartimpl(TimePickerKt.TimeInputImpl$lambda$1(mutableState).getSelection()) == 2 && TimePickerKt.TimeInputImpl$lambda$1(mutableState).getText().length() == 2) {
                            timePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
                        }
                        return false;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, (Function1) objRememberedValue);
            TextFieldValue textFieldValueTimeInputImpl$lambda$1 = TimeInputImpl$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1127349229, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(mutableState) | composer.changed(state) | composer.changedInstance(timePickerState) | composer.changedInstance(ref) | composer.changedInstance(timeInputErrorHandler);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeInputImpl$lambda$9$1$0$1$0(timePickerState, ref, timeInputErrorHandler, mutableState, state, (TextFieldValue) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            int iM4590getHouryecRtBI = TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m9333getNumberPjHm6EE(), ImeAction.INSTANCE.m9279getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1127381063, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(timePickerState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeInputImpl$lambda$9$1$0$2$0(timePickerState, (KeyboardActionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m4558TimePickerTextField1vLObsk(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$1, function2, timePickerState, iM4590getHouryecRtBI, keyboardOptions, new KeyboardActions(null, null, (Function1) objRememberedValue3, null, null, null, 59, null), timePickerColors, composer, 24576, 0);
            DisplaySeparator(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m5845getPeriodSelectorContainerHeightD9Ej5fM()), composer, 6);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            TextFieldValue textFieldValueTimeInputImpl$lambda$4 = TimeInputImpl$lambda$4(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 1127395324, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(timePickerState) | composer.changed(mutableState2) | composer.changedInstance(r2) | composer.changed(r5) | composer.changedInstance(r3);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeInputImpl$lambda$9$1$0$3$0(timePickerState, ref, timeInputErrorHandler, mutableState2, state, (TextFieldValue) obj);
                    }
                };
                composer.updateRememberedValue(function3);
                objRememberedValue4 = function3;
            }
            Function1 function4 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            int iM4591getMinuteyecRtBI = TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI();
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m9333getNumberPjHm6EE(), ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1127426695, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(timePickerState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeInputImpl$lambda$9$1$0$4$0(timePickerState, (KeyboardActionScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m4558TimePickerTextField1vLObsk(companion3, textFieldValueTimeInputImpl$lambda$4, function4, timePickerState, iM4591getMinuteyecRtBI, keyboardOptions2, new KeyboardActions(null, null, (Function1) objRememberedValue5, null, null, null, 59, null), timePickerColors, composer, 24582, 0);
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
    public static final Unit TimeInputImpl$lambda$9$1$0$1$0(TimePickerState timePickerState, Ref ref, TimeInputErrorHandler timeInputErrorHandler, final MutableState mutableState, State state, TextFieldValue textFieldValue) {
        m4569timeInputOnChangeEb28HvY(TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI(), timePickerState, textFieldValue, TimeInputImpl$lambda$1(mutableState), ref, TimeInputImpl$lambda$9$0(state), timeInputErrorHandler, new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt.TimeInputImpl$lambda$9$1$0$1$0$0(mutableState, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1$0$1$0$0(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1$0$2$0(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1$0$3$0(TimePickerState timePickerState, Ref ref, TimeInputErrorHandler timeInputErrorHandler, final MutableState mutableState, State state, TextFieldValue textFieldValue) {
        m4569timeInputOnChangeEb28HvY(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI(), timePickerState, textFieldValue, TimeInputImpl$lambda$4(mutableState), ref, TimeInputImpl$lambda$9$0(state), timeInputErrorHandler, new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt.TimeInputImpl$lambda$9$1$0$3$0$0(mutableState, (TextFieldValue) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1$0$3$0$0(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$9$1$0$4$0(TimePickerState timePickerState, KeyboardActionScope keyboardActionScope) {
        timePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
        return Unit.INSTANCE;
    }

    private static final void HorizontalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalClockDisplay)N(state,colors)1231@51326L591:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1230)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 998514658, "C1232@51385L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            if (timePickerState.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(947523439);
            } else {
                composerStartRestartGroup.startReplaceGroup(998576161);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1234@51463L438");
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1710314390, "C1235@51540L347:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5857getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m5856getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.HorizontalClockDisplay$lambda$1(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void VerticalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalClockDisplay)N(state,colors)1251@52022L586:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1250)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1364225858, "C1252@52080L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            if (timePickerState.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(1312545323);
            } else {
                composerStartRestartGroup.startReplaceGroup(1364287361);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1254@52158L434");
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2145741896, "C1255@52237L341:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5860getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m5859getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.VerticalClockDisplay$lambda$1(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ClockDisplayNumbers(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockDisplayNumbers)N(state,colors)1272@52796L5,1275@52932L839,1271@52712L1059:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1270)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), composerStartRestartGroup, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockDisplayNumbers$lambda$0(timePickerState, timePickerColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockDisplayNumbers$lambda$1(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockDisplayNumbers$lambda$0(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1276@52942L823:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-477913269, i, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:1276)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2065728633, "C1277@52960L326,1285@53299L123,1288@53435L320:TimePicker.kt#uh7d8r");
            m4559TimeSelectoru8A1Dfs(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5863getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m5862getTimeSelectorContainerHeightD9Ej5fM()), getHourForDisplay(timePickerState), timePickerState, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI(), timePickerColors, true, composer, 199686);
            DisplaySeparator(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m5859getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer, 6);
            m4559TimeSelectoru8A1Dfs(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5863getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m5862getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getMinute(), timePickerState, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI(), timePickerColors, true, composer, 199686);
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

    private static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPeriodToggle)N(modifier,state,colors)1306@53933L1014,1334@54994L5,1336@55025L207:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1305)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 847733805, "CC(remember):TimePicker.kt#9igjgp");
            TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.start$default(cornerBasedShape, null, 1, null), ShapesKt.end$default(cornerBasedShape, null, 1, null), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.HorizontalPeriodToggle$lambda$1(modifier2, timePickerState2, timePickerColors2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalPeriodToggle)N(modifier,state,colors)1352@55392L1022,1380@56461L5,1382@56492L208:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1351)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 500805347, "CC(remember):TimePicker.kt#9igjgp");
            TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.top$default(cornerBasedShape, null, 1, null), ShapesKt.bottom$default(cornerBasedShape, null, 1, null), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.VerticalPeriodToggle$lambda$1(modifier2, timePickerState2, timePickerColors2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i) {
        int i2;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1374241901);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PeriodToggleImpl)N(modifier,state,colors,measurePolicy,startShape,endShape)1403@57078L5,1404@57148L5,1405@57183L41,1409@57304L128,1406@57229L1449:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            shape3 = shape2;
            i2 |= composerStartRestartGroup.changed(shape3) ? 131072 : 65536;
        } else {
            shape3 = shape2;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1400)");
            }
            BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(TimePickerTokens.INSTANCE.m5858getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.getPeriodSelectorBorderColor());
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            final TextStyle value2 = TypographyKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorLabelTextFont(), composerStartRestartGroup, 6);
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_time_picker_period_toggle_description), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2091525677, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.PeriodToggleImpl$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null)), borderStrokeM622BorderStrokecXLIe8U, cornerBasedShape);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBorder);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1677877212, "C1420@57715L146,1426@57910L100,1417@57602L408,1429@58023L219,1438@58365L147,1444@58561L100,1435@58255L406:TimePicker.kt#uh7d8r");
            boolean z = !isPm(timePickerState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -222966890, "CC(remember):TimePicker.kt#9igjgp");
            int i3 = i2 & 112;
            boolean z2 = i3 == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.PeriodToggleImpl$lambda$1$0$0(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = (i2 << 3) & 7168;
            ToggleItem(z, shape, (Function0) objRememberedValue2, timePickerColors, ComposableLambdaKt.rememberComposableLambda(1425358052, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimePickerKt.PeriodToggleImpl$lambda$1$1(value2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 9) & 112) | 24576 | i4);
            SpacerKt.Spacer(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.INSTANCE, "Spacer"), 2.0f), 0.0f, 1, null), timePickerColors.getPeriodSelectorBorderColor(), null, 2, null), composerStartRestartGroup, 0);
            boolean zIsPm = isPm(timePickerState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -222946089, "CC(remember):TimePicker.kt#9igjgp");
            boolean z3 = i3 == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.PeriodToggleImpl$lambda$1$2$0(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ToggleItem(zIsPm, shape3, (Function0) objRememberedValue3, timePickerColors, ComposableLambdaKt.rememberComposableLambda(-1179219109, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimePickerKt.PeriodToggleImpl$lambda$1$3(value2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 12) & 112) | 24576 | i4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.PeriodToggleImpl$lambda$2(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$1$0$0(TimePickerState timePickerState) {
        if (isPm(timePickerState) && isHourInputValid(timePickerState)) {
            timePickerState.setHour(timePickerState.getHour() - 12);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$1$1(TextStyle textStyle, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1427@57955L40,1427@57928L68:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1425358052, i, -1, "androidx.compose.material3.PeriodToggleImpl.<anonymous>.<anonymous> (TimePicker.kt:1427)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_time_picker_am), composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$1$2$0(TimePickerState timePickerState) {
        if (!isPm(timePickerState) && isHourInputValid(timePickerState)) {
            timePickerState.setHour(timePickerState.getHour() + 12);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$1$3(TextStyle textStyle, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1445@58606L40,1445@58579L68:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1179219109, i, -1, "androidx.compose.material3.PeriodToggleImpl.<anonymous>.<anonymous> (TimePicker.kt:1445)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            TextKt.m4494TextNvy7gAk(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_time_picker_pm), composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ToggleItem(final boolean z, final Shape shape, final Function0<Unit> function0, final TimePickerColors timePickerColors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1523811083);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleItem)N(checked,shape,onClick,colors,content)1464@59112L22,1470@59303L125,1462@59004L431:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1523811083, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1458)");
            }
            long jM4516periodSelectorContentColorvNxB06k$material3 = timePickerColors.m4516periodSelectorContentColorvNxB06k$material3(z);
            long jM4515periodSelectorContainerColorvNxB06k$material3 = timePickerColors.m4515periodSelectorContainerColorvNxB06k$material3(z);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, z ? 0.0f : 1.0f), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -201384031, "CC(remember):TimePicker.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.ToggleItem$lambda$0$0(z, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) objRememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(jM4515periodSelectorContainerColorvNxB06k$material3, jM4516periodSelectorContentColorvNxB06k$material3, 0L, 0L, composerStartRestartGroup, 24576, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, function3, composerStartRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & C.ENCODING_PCM_DOUBLE), 356);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ToggleItem$lambda$1(z, shape, function0, timePickerColors, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleItem$lambda$0$0(boolean z, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z);
        return Unit.INSTANCE;
    }

    private static final void DisplaySeparator(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplaySeparator)N(modifier)1480@59541L7,1489@59859L2,1489@59814L172:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i2, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1478)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default((TextStyle) objConsume, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m9493getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m9515getBothEVpEnUU(), (DefaultConstructorMarker) null), 0, 0, null, 15695871, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 113387904, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.DisplaySeparator$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClearAndSetSemantics);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2101554693, "C1490@59959L5,1490@59910L70:TimePicker.kt#uh7d8r");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(":", null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composerStartRestartGroup, 6), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleM9104copyp1EtxEg$default, composer2, 6, 0, 131066);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.DisplaySeparator$lambda$2(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplaySeparator$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: TimeSelector-u8A1Dfs, reason: not valid java name */
    private static final void m4559TimeSelectoru8A1Dfs(final Modifier modifier, final int i, final TimePickerState timePickerState, final int i2, final TimePickerColors timePickerColors, final boolean z, Composer composer, final int i3) {
        int i4;
        int i5;
        Composer composer2;
        int iM5002constructorimpl;
        long errorContainer;
        long onErrorContainer;
        Composer composerStartRestartGroup = composer.startRestartGroup(-883324461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeSelector)N(modifier,value,state,selection:c#material3.TimePickerSelectionMode,colors,isValid)1504@60260L20,1504@60236L44,1508@60375L214,1525@60966L124,1535@61301L5,1529@61110L117,1537@61346L498,1523@60882L962:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 = i;
            i4 |= composerStartRestartGroup.changed(i5) ? 32 : 16;
        } else {
            i5 = i;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-883324461, i4, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1503)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528724327, "CC(remember):TimePicker.kt#9igjgp");
            boolean z2 = (458752 & i4) == 131072;
            TimePickerKt$TimeSelector$1$1 timePickerKt$TimeSelector$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || timePickerKt$TimeSelector$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$TimeSelector$1$1RememberedValue = new TimePickerKt$TimeSelector$1$1(z, null);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimeSelector$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimeSelector$1$1RememberedValue, composerStartRestartGroup, (i4 >> 15) & 14);
            boolean zM4586equalsimpl0 = TimePickerSelectionMode.m4586equalsimpl0(timePickerState.mo2728getSelectionyecRtBI(), i2);
            if (TimePickerSelectionMode.m4586equalsimpl0(i2, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_selection);
            } else {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_selection);
            }
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1528736631);
                composerStartRestartGroup.endReplaceGroup();
                errorContainer = timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(zM4586equalsimpl0);
            } else {
                composerStartRestartGroup.startReplaceGroup(1528739041);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1518@60708L11");
                errorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getErrorContainer();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1528741173);
                composerStartRestartGroup.endReplaceGroup();
                onErrorContainer = timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(zM4586equalsimpl0);
            } else {
                composerStartRestartGroup.startReplaceGroup(1528743523);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1521@60848L11");
                onErrorContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getOnErrorContainer();
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528747023, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeSelector_u8A1Dfs$lambda$1$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528751624, "CC(remember):TimePicker.kt#9igjgp");
            boolean z3 = ((i4 & 7168) == 2048) | ((i4 & 896) == 256 || ((i4 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeSelector_u8A1Dfs$lambda$2$0(i2, timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final int i6 = i5;
            final long j = onErrorContainer;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4324Surfaced85dljk(zM4586equalsimpl0, (Function0<Unit>) function0, modifierSemantics, false, value, errorContainer, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(291874429, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeSelector_u8A1Dfs$lambda$3(i2, timePickerState, i6, j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeSelector_u8A1Dfs$lambda$4(modifier, i, timePickerState, i2, timePickerColors, z, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_u8A1Dfs$lambda$1$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8837getRadioButtono7Vup1c());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_u8A1Dfs$lambda$2$0(int i, TimePickerState timePickerState) {
        if (!TimePickerSelectionMode.m4586equalsimpl0(i, timePickerState.mo2728getSelectionyecRtBI())) {
            timePickerState.mo2730setSelection6_8s6DQ(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_u8A1Dfs$lambda$3(int i, TimePickerState timePickerState, int i2, long j, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C1539@61398L153,1545@61561L277:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(291874429, i3, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1538)");
            }
            final String strM4567numberContentDescriptiondSwYdS4 = m4567numberContentDescriptiondSwYdS4(i, timePickerState.getIs24hour(), i2, composer, 0);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 208686604, "C1547@61668L48,1546@61616L212:TimePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1253659315, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composer.changed(strM4567numberContentDescriptiondSwYdS4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeSelector_u8A1Dfs$lambda$3$0$0$0(strM4567numberContentDescriptiondSwYdS4, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(CalendarLocale_jvmAndAndroidKt.toLocalString$default(i2, 2, 0, false, null, 14, null), SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null), j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
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
    public static final Unit TimeSelector_u8A1Dfs$lambda$3$0$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final void ClockFace(final Modifier modifier, AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors, final boolean z, Composer composer, final int i) {
        int i2;
        final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-478841003);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockFace)N(modifier,state,colors,autoSwitchToMinute)1701@66705L7,1712@67159L7,1717@67360L7,1718@67375L2168,1703@66789L2754:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(analogTimePickerState2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-478841003, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1700)");
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            analogTimePickerState2 = analogTimePickerState;
            CrossfadeKt.Crossfade(analogTimePickerState2.getClockFaceValues(), drawSelector(BackgroundKt.m588backgroundbw27NRU(modifier, timePickerColors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(analogTimePickerState, z, analogTimePickerState.mo2728getSelectionyecRtBI(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6), null)), analogTimePickerState2, timePickerColors), (FiniteAnimationSpec<Float>) MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), (String) null, ComposableLambdaKt.rememberComposableLambda(747010833, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimePickerKt.ClockFace$lambda$0(timePickerColors, analogTimePickerState2, z, focusManager, (IntList) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockFace$lambda$1(modifier, analogTimePickerState2, timePickerColors, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0(final TimePickerColors timePickerColors, final AnalogTimePickerState analogTimePickerState, final boolean z, final FocusManager focusManager, final IntList intList, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(screen)1720@67482L21,1722@67571L1966,1719@67395L2142:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(747010833, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1719)");
        }
        Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM());
        ComposerKt.sourceInformationMarkerStart(composer, 617875526, "CC(remember):TimePicker.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TimePickerKt.ClockFace$lambda$0$0$0((SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CircularLayout(SemanticsModifierKt.semantics$default(modifierM1266size3ABfNKs, false, (Function1) objRememberedValue, 1, null), OuterCircleToSizeRatio, ComposableLambdaKt.rememberComposableLambda(-99063847, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TimePickerKt.ClockFace$lambda$0$1(timePickerColors, intList, analogTimePickerState, z, focusManager, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.selectableGroup(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$1(TimePickerColors timePickerColors, final IntList intList, final AnalogTimePickerState analogTimePickerState, final boolean z, final FocusManager focusManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1725@67704L1823,1723@67585L1942:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99063847, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1723)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(timePickerColors.m4499clockDialContentColorvNxB06k$material3(false))), ComposableLambdaKt.rememberComposableLambda(-596940007, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockFace$lambda$0$1$0(intList, analogTimePickerState, z, focusManager, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$1$0$0$0$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, i + 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$1$0$1(AnalogTimePickerState analogTimePickerState, boolean z, FocusManager focusManager, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*1754@69142L41,1752@69033L414:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1385767514, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1750)");
            }
            int i2 = ExtraHours._size;
            for (final int i3 = 0; i3 < i2; i3++) {
                int i4 = ExtraHours.get(i3);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1870016769, "CC(remember):TimePicker.kt#9igjgp");
                boolean zChanged = composer.changed(i3);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.ClockFace$lambda$0$1$0$1$0$0$0(i3, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), analogTimePickerState, i4, z, focusManager, composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$1$0$1$0$0$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 12 + i);
        return Unit.INSTANCE;
    }

    private static final Modifier drawSelector(Modifier modifier, final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt.drawSelector$lambda$0(analogTimePickerState, timePickerColors, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawSelector$lambda$0(AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, ContentDrawScope contentDrawScope) {
        float f = contentDrawScope.mo754toPx0680j_4(DpOffset.m9748getXD9Ej5fM(getSelectorPos(analogTimePickerState)));
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(contentDrawScope.mo754toPx0680j_4(DpOffset.m9750getYD9Ej5fM(getSelectorPos(analogTimePickerState))))) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        float f2 = ((contentDrawScope.mo754toPx0680j_4(TimePickerTokens.INSTANCE.m5853getClockDialSelectorHandleContainerSizeD9Ej5fM()) / 2.0f) * contentDrawScope.mo748roundToPx0680j_4(analogTimePickerState.m2727getCurrentDiameterD9Ej5fM())) / contentDrawScope.mo748roundToPx0680j_4(TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM());
        long selectorColor = timePickerColors.getSelectorColor();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m7376drawCircleVaOC9Bg$default(contentDrawScope2, Color.INSTANCE.m6840getBlack0d7_KjU(), f2, jM6561constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m6727getClear0nO6VwU(), 56, null);
        contentDrawScope.drawContent();
        DrawScope.m7376drawCircleVaOC9Bg$default(contentDrawScope2, selectorColor, f2, jM6561constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m6755getXor0nO6VwU(), 56, null);
        float f3 = contentDrawScope.mo754toPx0680j_4(TimePickerTokens.INSTANCE.m5854getClockDialSelectorTrackContainerWidthD9Ej5fM());
        float fCos = ((float) Math.cos(analogTimePickerState.getCurrentAngle())) * f2;
        DrawScope.m7381drawLineNGM6Ib0$default(contentDrawScope2, selectorColor, androidx.compose.ui.geometry.SizeKt.m6648getCenteruvyYCjk(contentDrawScope.mo7395getSizeNHjbRc()), Offset.m6573minusMKHz9U(jM6561constructorimpl, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(((float) Math.sin(analogTimePickerState.getCurrentAngle())) * f2)) & 4294967295L) | (Float.floatToRawIntBits(fCos) << 32))), f3, 0, null, 0.0f, null, BlendMode.INSTANCE.m6754getSrcOver0nO6VwU(), PsExtractor.VIDEO_STREAM_MASK, null);
        DrawScope.m7376drawCircleVaOC9Bg$default(contentDrawScope2, selectorColor, contentDrawScope.mo754toPx0680j_4(TimePickerTokens.INSTANCE.m5852getClockDialSelectorCenterContainerSizeD9Ej5fM()) / 2, androidx.compose.ui.geometry.SizeKt.m6648getCenteruvyYCjk(contentDrawScope.mo7395getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
        DrawScope.m7376drawCircleVaOC9Bg$default(contentDrawScope2, timePickerColors.m4499clockDialContentColorvNxB06k$material3(true), f2, jM6561constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m6737getDstOver0nO6VwU(), 56, null);
        return Unit.INSTANCE;
    }

    private static final void ClockText(Modifier modifier, final AnalogTimePickerState analogTimePickerState, final int i, final boolean z, final FocusManager focusManager, Composer composer, final int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        final CoroutineScope coroutineScope;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableInteractionSource mutableInteractionSource;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(-228814986);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockText)N(modifier,state,value,autoSwitchToMinute,focusManager)1841@71813L5,1842@71859L7,1844@71940L40,1845@72005L43,1846@72075L38,1847@72142L39,1848@72198L24,1850@72260L143,1858@72470L268,1866@72779L314,1878@73136L7,1885@73378L215,1892@73719L1455,1923@75376L188,1881@73250L2524:TimePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(analogTimePickerState) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(focusManager) ? 16384 : 8192;
        }
        int i4 = i3;
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            modifier2 = modifier;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-228814986, i4, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1840)");
            }
            TextStyle value = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), composerStartRestartGroup, 6);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            final float fMo754toPx0680j_4 = density.mo754toPx0680j_4(MaxDistance);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847859042, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m6558boximpl(Offset.INSTANCE.m6585getZeroF1C5BW0()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847856959, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m9806boximpl(IntOffset.INSTANCE.m9826getZeronOccac()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847854724, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Rect.INSTANCE.getZero(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847852579, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String strM4567numberContentDescriptiondSwYdS4 = m4567numberContentDescriptiondSwYdS4(analogTimePickerState.mo2728getSelectionyecRtBI(), analogTimePickerState.getIs24hour(), i, composerStartRestartGroup, i4 & 896);
            String localString$default = CalendarLocale_jvmAndAndroidKt.toLocalString$default(i, 0, 0, false, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847841854, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(analogTimePickerState);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TimePickerKt.ClockText$lambda$11$0(analogTimePickerState, density, mutableState5));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final State state = (State) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847831920, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(analogTimePickerState) | composerStartRestartGroup.changed(fMo754toPx0680j_4) | ((i4 & 7168) == 2048);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                coroutineScope = coroutineScope2;
                mutableState = mutableState3;
                mutableState2 = mutableState4;
                Function0 function0 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.ClockText$lambda$13$0(coroutineScope, analogTimePickerState, fMo754toPx0680j_4, z, mutableState, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function0);
                objRememberedValue7 = function0;
            } else {
                coroutineScope = coroutineScope2;
                mutableState = mutableState3;
                mutableState2 = mutableState4;
            }
            final Function0 function1 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<InputModeManager> localInputModeManager = CompositionLocalsKt.getLocalInputModeManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localInputModeManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z2 = !InputMode.m7627equalsimpl0(((InputModeManager) objConsume2).mo7633getInputModeaOaMEAU(), InputMode.INSTANCE.m7632getTouchaOaMEAU());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847812851, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TimePickerKt.ClockText$lambda$14$0(mutableState2, mutableState5, mutableState, (LayoutCoordinates) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifier2 = modifier;
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) objRememberedValue8));
            float f = MinimumInteractiveSize;
            Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(modifierMinimumInteractiveComponentSize, f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847800699, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(function1) | composerStartRestartGroup.changedInstance(focusManager);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                mutableInteractionSource = mutableInteractionSource2;
                obj = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m4571invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m4571invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && TimePickerKt.m4565isEnterZmokQxo(keyEvent)) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(mutableInteractionSource, mutableState, null), 3, null);
                        }
                        if (TimePickerKt.m4564isClickZmokQxo(keyEvent)) {
                            function1.invoke();
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(mutableInteractionSource, mutableState, null), 3, null);
                            return true;
                        }
                        if (KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY())) {
                            if (Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7746getDirectionRightEK5gGoQ())) {
                                focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6452getNextdhqQ8s());
                                return true;
                            }
                            if (Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7747getDirectionUpEK5gGoQ()) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7745getDirectionLeftEK5gGoQ())) {
                                focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6453getPreviousdhqQ8s());
                                return true;
                            }
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: TimePicker.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1", f = "TimePicker.kt", i = {}, l = {1896}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Offset> $center$delegate;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(MutableInteractionSource mutableInteractionSource, MutableState<Offset> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$interactionSource = mutableInteractionSource;
                            this.$center$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$interactionSource, this.$center$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$interactionSource.emit(new PressInteraction.Press(TimePickerKt.ClockText$lambda$2(this.$center$delegate), null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: TimePicker.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$2", f = "TimePicker.kt", i = {}, l = {1902}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Offset> $center$delegate;
                        final /* synthetic */ MutableInteractionSource $interactionSource;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(MutableInteractionSource mutableInteractionSource, MutableState<Offset> mutableState, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$interactionSource = mutableInteractionSource;
                            this.$center$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$interactionSource, this.$center$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$interactionSource.emit(new PressInteraction.Release(new PressInteraction.Press(TimePickerKt.ClockText$lambda$2(this.$center$delegate), null)), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue9;
                mutableInteractionSource = mutableInteractionSource2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable = FocusableKt.focusable(IndicationKt.indication(KeyInputModifierKt.onKeyEvent(modifierM1266size3ABfNKs, (Function1) obj), mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, Dp.m9687constructorimpl(f / 2), 0L, 5, null)), z2, mutableInteractionSource);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -847748942, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function1) | composerStartRestartGroup.changed(state);
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TimePickerKt.ClockText$lambda$16$0(function1, state, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFocusable, true, (Function1) objRememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 737770137, "C1933@75657L48,1931@75582L186:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1547821952, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(strM4567numberContentDescriptiondSwYdS4);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TimePickerKt.ClockText$lambda$17$0$0(strM4567numberContentDescriptiondSwYdS4, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(localString$default, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue11), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, value, composer2, 0, 0, 131068);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TimePickerKt.ClockText$lambda$18(modifier3, analogTimePickerState, i, z, focusManager, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$2(MutableState<Offset> mutableState) {
        return mutableState.getValue().m6579unboximpl();
    }

    private static final void ClockText$lambda$3(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m6558boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$5(MutableState<IntOffset> mutableState) {
        return mutableState.getValue().m9824unboximpl();
    }

    private static final void ClockText$lambda$6(MutableState<IntOffset> mutableState, long j) {
        mutableState.setValue(IntOffset.m9806boximpl(j));
    }

    private static final Rect ClockText$lambda$8(MutableState<Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClockText$lambda$11$0(AnalogTimePickerState analogTimePickerState, Density density, MutableState mutableState) {
        long selectorPos = getSelectorPos(analogTimePickerState);
        float fMo754toPx0680j_4 = density.mo754toPx0680j_4(DpOffset.m9748getXD9Ej5fM(selectorPos));
        return ClockText$lambda$8(mutableState).m6595containsk4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(density.mo754toPx0680j_4(DpOffset.m9750getYD9Ej5fM(selectorPos)))) & 4294967295L) | (Float.floatToRawIntBits(fMo754toPx0680j_4) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$13$0(CoroutineScope coroutineScope, AnalogTimePickerState analogTimePickerState, float f, boolean z, MutableState mutableState, MutableState mutableState2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TimePickerKt$ClockText$onClockTextClick$1$1$1(analogTimePickerState, f, z, mutableState, mutableState2, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$14$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentCoordinates = layoutCoordinates.getParentCoordinates();
        ClockText$lambda$6(mutableState, parentCoordinates != null ? IntSizeKt.m9864getCenterozmzZPI(parentCoordinates.mo8273getSizeYbymL2g()) : IntOffset.INSTANCE.m9826getZeronOccac());
        mutableState2.setValue(LayoutCoordinatesKt.boundsInParent(layoutCoordinates));
        ClockText$lambda$3(mutableState3, ClockText$lambda$8(mutableState2).m6599getCenterF1C5BW0());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$16$0(final Function0 function0, State state, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TimePickerKt.ClockText$lambda$16$0$0(function0));
            }
        }, 1, null);
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, ClockText$lambda$12(state));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClockText$lambda$16$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$17$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: timeInputOnChange-Eb28HvY, reason: not valid java name */
    private static final void m4569timeInputOnChangeEb28HvY(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, Ref<Boolean> ref, boolean z, TimeInputErrorHandler timeInputErrorHandler, Function1<? super TextFieldValue, Unit> function1) {
        int iDigitToInt;
        int i2 = 0;
        ref.setValue(false);
        if (Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
            return;
        }
        int i3 = 12;
        if (textFieldValue.getText().length() == 0) {
            if (TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                if (isPm(timePickerState) && !timePickerState.getIs24hour()) {
                    i2 = 12;
                }
                timePickerState.setHourInput(i2);
            } else {
                timePickerState.setMinuteInput(0);
            }
            function1.invoke(TextFieldValue.m9341copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (textFieldValue.getText().length() == 3 && TextRange.m9091getStartimpl(textFieldValue.getSelection()) == 1) {
                iDigitToInt = CharsKt.digitToInt(textFieldValue.getText().charAt(0));
            } else {
                iDigitToInt = Integer.parseInt(textFieldValue.getText());
            }
            if (iDigitToInt <= 99) {
                if (TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                    if (iDigitToInt != 12 || !isPm(timePickerState)) {
                        if (iDigitToInt != 12 || isPm(timePickerState) || timePickerState.getIs24hour()) {
                            if (!isPm(timePickerState) || timePickerState.getIs24hour()) {
                                i3 = 0;
                            }
                            i3 += iDigitToInt;
                        } else {
                            i3 = 0;
                        }
                    }
                    timePickerState.setHourInput(i3);
                    if (iDigitToInt > 1 && !timePickerState.getIs24hour() && !z) {
                        timePickerState.mo2730setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI());
                    }
                } else {
                    timePickerState.setMinuteInput(iDigitToInt);
                }
                function1.invoke(textFieldValue.getText().length() <= 2 ? textFieldValue : TextFieldValue.m9341copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null));
                return;
            }
            timeInputErrorHandler.onError();
        } catch (NumberFormatException unused) {
        } catch (IllegalArgumentException unused2) {
            timeInputErrorHandler.onError();
        }
    }

    /* JADX INFO: renamed from: SupportingText-73flGVI, reason: not valid java name */
    private static final void m4556SupportingText73flGVI(final Modifier modifier, final int i, final TimePickerState timePickerState, final boolean z, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        int iM5002constructorimpl;
        long value;
        Composer composerStartRestartGroup = composer.startRestartGroup(474051149);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SupportingText)N(modifier,selection:c#material3.TimePickerSelectionMode,state,isValid)2025@78478L16,2032@78721L2,2036@78851L5,2031@78635L228:TimePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= (i2 & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(474051149, i3, -1, "androidx.compose.material3.SupportingText (TimePicker.kt:2013)");
            }
            if (z && TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour);
            } else if (z) {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute);
            } else if (TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) && timePickerState.getIs24hour()) {
                Strings.Companion companion3 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_error_24h);
            } else if (!TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                Strings.Companion companion4 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_error);
            } else {
                Strings.Companion companion5 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_error);
            }
            String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, 0);
            if (!z) {
                composerStartRestartGroup.startReplaceGroup(296642354);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2028@78548L11");
                value = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getError();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(296644402);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2029@78624L5");
                value = ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            long j = value;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifier, 0.0f, SupportLabelTop, 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 296647503, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.SupportingText_73flGVI$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(strM5086getString2EP1pXo, SemanticsModifierKt.clearAndSetSemantics(modifierM1222paddingqDBjuR0$default, (Function1) objRememberedValue), j, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 2, null, TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont(), composerStartRestartGroup, 6), composer2, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 98296);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.SupportingText_73flGVI$lambda$1(modifier, i, timePickerState, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupportingText_73flGVI$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:102:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:105:0x0321  */
    /* JADX WARN: Code duplicated, block: B:107:0x032f  */
    /* JADX WARN: Code duplicated, block: B:110:0x035f  */
    /* JADX WARN: Code duplicated, block: B:112:0x038a  */
    /* JADX WARN: Code duplicated, block: B:114:0x0390  */
    /* JADX WARN: Code duplicated, block: B:115:0x0395  */
    /* JADX WARN: Code duplicated, block: B:116:0x039a  */
    /* JADX WARN: Code duplicated, block: B:118:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:121:0x03de  */
    /* JADX WARN: Code duplicated, block: B:122:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:125:0x0407  */
    /* JADX WARN: Code duplicated, block: B:128:0x0453  */
    /* JADX WARN: Code duplicated, block: B:131:0x045f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0463  */
    /* JADX WARN: Code duplicated, block: B:135:0x0488  */
    /* JADX WARN: Code duplicated, block: B:137:0x0496  */
    /* JADX WARN: Code duplicated, block: B:140:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:142:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:145:0x0683  */
    /* JADX WARN: Code duplicated, block: B:148:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:154:0x06de  */
    /* JADX WARN: Code duplicated, block: B:158:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:161:0x06ef  */
    /* JADX WARN: Code duplicated, block: B:163:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:166:0x0712  */
    /* JADX WARN: Code duplicated, block: B:168:0x0718  */
    /* JADX WARN: Code duplicated, block: B:171:0x0725  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:85:0x0100  */
    /* JADX WARN: Code duplicated, block: B:88:0x011a  */
    /* JADX WARN: Code duplicated, block: B:91:0x026a  */
    /* JADX WARN: Code duplicated, block: B:92:0x026f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0275  */
    /* JADX WARN: Code duplicated, block: B:95:0x0286  */
    /* JADX WARN: Code duplicated, block: B:98:0x02ec  */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: TimePickerTextField-1vLObsk, reason: not valid java name */
    private static final void m4558TimePickerTextField1vLObsk(final Modifier modifier, final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, TimePickerState timePickerState, int i, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, final TimePickerColors timePickerColors, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        KeyboardActions keyboardActions2;
        int i6;
        boolean z;
        Composer composer2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions4;
        Object objRememberedValue;
        FocusRequester focusRequester;
        int i7;
        boolean zM4586equalsimpl0;
        final boolean zIsMinuteInputValid;
        int i8;
        long jM4518timeSelectorContentColorvNxB06k$material3;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i9;
        int i10;
        ?? r15;
        int iM5002constructorimpl;
        final String strM5086getString2EP1pXo;
        Object objRememberedValue2;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChanged;
        Object objRememberedValue3;
        int i11;
        Object objRememberedValue4;
        boolean z2;
        boolean z3;
        TimePickerKt$TimePickerTextField$2$1 timePickerKt$TimePickerTextField$2$1RememberedValue;
        int minuteInput;
        int i12;
        final TimePickerState timePickerState2 = timePickerState;
        final int i13 = i;
        Composer composerStartRestartGroup = composer.startRestartGroup(1299172990);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerTextField)N(modifier,value,onValueChange,state,selection:c#material3.TimePickerSelectionMode,keyboardOptions,keyboardActions,colors)2052@79303L29,2053@79372L11,2054@79434L11,2056@79523L335,2077@80250L3461,2162@83749L103,2162@83717L135:TimePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldValue) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= (i2 & 4096) == 0 ? composerStartRestartGroup.changed(timePickerState2) : composerStartRestartGroup.changedInstance(timePickerState2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(i13) ? 16384 : 8192;
        }
        int i14 = i3 & 32;
        if (i14 == 0) {
            if ((196608 & i2) == 0) {
                i4 |= composerStartRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                if ((1572864 & i2) == 0) {
                    keyboardActions2 = keyboardActions;
                    if (composerStartRestartGroup.changed(keyboardActions2)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(timePickerColors)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i4 |= i12;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    keyboardOptions2 = keyboardOptions;
                    keyboardActions3 = keyboardActions2;
                } else {
                    if (i14 != 0) {
                        keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions;
                    }
                    if (i5 != 0) {
                        keyboardActions4 = KeyboardActions.INSTANCE.getDefault();
                    } else {
                        keyboardActions4 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1299172990, i4, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:2051)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1330227685, "CC(remember):TimePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    focusRequester = (FocusRequester) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i7 = i4;
                    final TextFieldColors textFieldColorsM3949colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m3949colors0hiis_0(timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true), 0L, 0L, 0L, timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getErrorContainer(), 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getOnErrorContainer(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2080374606, 4095);
                    zM4586equalsimpl0 = TimePickerSelectionMode.m4586equalsimpl0(i13, timePickerState2.mo2728getSelectionyecRtBI());
                    if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                        zIsMinuteInputValid = isHourInputValid(timePickerState2);
                    } else {
                        zIsMinuteInputValid = isMinuteInputValid(timePickerState2);
                    }
                    if (zIsMinuteInputValid) {
                        composerStartRestartGroup.startReplaceGroup(1713428167);
                        composerStartRestartGroup.endReplaceGroup();
                        jM4518timeSelectorContentColorvNxB06k$material3 = timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true);
                        i8 = 6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1713494445);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "2074@80217L11");
                        i8 = 6;
                        long error = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getError();
                        composerStartRestartGroup.endReplaceGroup();
                        jM4518timeSelectorContentColorvNxB06k$material3 = error;
                    }
                    Modifier modifierWidth = IntrinsicKt.width(modifier, IntrinsicSize.Min);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    int i15 = i8;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023500047, "C2095@80938L240,2102@81211L39,2104@81260L2220,2155@83563L38,2154@83490L215:TimePicker.kt#uh7d8r");
                    if (!zM4586equalsimpl0) {
                        i9 = i13;
                        i10 = i7;
                        r15 = 0;
                        composerStartRestartGroup.startReplaceGroup(1943723406);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2023427227);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "2079@80342L539");
                        Modifier modifierM1268sizeVpY3zN4 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                        if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                            if (isHourInputValid(timePickerState2)) {
                                minuteInput = getHourForDisplay(timePickerState2);
                            } else {
                                minuteInput = timePickerState2.getHourInput();
                            }
                        } else {
                            minuteInput = timePickerState2.getMinuteInput();
                        }
                        i10 = i7;
                        int i16 = i10 >> 3;
                        r15 = 0;
                        m4559TimeSelectoru8A1Dfs(modifierM1268sizeVpY3zN4, minuteInput, timePickerState2, i13, timePickerColors, zIsMinuteInputValid, composerStartRestartGroup, (i16 & 7168) | (i16 & 896) | 6 | ((i10 >> 9) & 57344));
                        i9 = i13;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (TimePickerSelectionMode.m4586equalsimpl0(i9, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                        Strings.Companion companion = Strings.INSTANCE;
                        iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_text_field);
                    } else {
                        Strings.Companion companion2 = Strings.INSTANCE;
                        iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_text_field);
                    }
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, r15);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173678235, "CC(remember):TimePicker.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierVisible = visible(Modifier.INSTANCE, zM4586equalsimpl0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r15);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r15);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVisible);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1787857941, "C2111@81603L151,2118@81956L7,2125@82281L11,2126@82349L11,2130@82511L959,2105@81306L2164:TimePicker.kt#uh7d8r");
                    Modifier modifierM1268sizeVpY3zN5 = SizeKt.m1268sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443153649, "CC(remember):TimePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1268sizeVpY3zN5, false, (Function1) objRememberedValue3, 1, null);
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default((TextStyle) objConsume, jM4518timeSelectorContentColorvNxB06k$material3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                    Brush.Companion companion3 = Brush.INSTANCE;
                    Pair[] pairArr = new Pair[i15];
                    pairArr[0] = TuplesKt.to(Float.valueOf(0.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    pairArr[1] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    pairArr[2] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                    pairArr[3] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                    pairArr[4] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    pairArr[5] = TuplesKt.to(Float.valueOf(1.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                    Brush brushM6770verticalGradient8A3gB4$default = Brush.Companion.m6770verticalGradient8A3gB4$default(companion3, pairArr, 0.0f, 0.0f, 0, 14, (Object) null);
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1007938103, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$1(textFieldValue, zIsMinuteInputValid, mutableInteractionSource, textFieldColorsM3949colors0hiis_0, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i17 = i10 >> 3;
                    int i18 = (i17 & 14) | 100666368 | (i17 & 112);
                    int i19 = i10 << 3;
                    boolean z4 = zIsMinuteInputValid;
                    KeyboardOptions keyboardOptions4 = keyboardOptions3;
                    i11 = i10;
                    KeyboardActions keyboardActions5 = keyboardActions4;
                    BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierSemantics$default, true, false, textStyleM9104copyp1EtxEg$default, keyboardOptions4, keyboardActions5, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, brushM6770verticalGradient8A3gB4$default, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, composerStartRestartGroup, i18 | (3670016 & i19) | (i19 & 29360128), 199680, 7696);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1173753498, "CC(remember):TimePicker.kt#9igjgp");
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    timePickerState2 = timePickerState;
                    m4556SupportingText73flGVI(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default, false, (Function1) objRememberedValue4, 1, null), i, timePickerState2, z4, composer2, ((i11 >> 9) & 112) | (i17 & 896));
                    i13 = i;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    TimePickerSelectionMode timePickerSelectionModeM4583boximpl = TimePickerSelectionMode.m4583boximpl(timePickerState2.mo2728getSelectionyecRtBI());
                    ComposerKt.sourceInformationMarkerStart(composer2, -1330085339, "CC(remember):TimePicker.kt#9igjgp");
                    if ((i11 & 7168) != 2048 || ((i11 & 4096) != 0 && composer2.changedInstance(timePickerState2))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | ((i11 & 57344) == 16384);
                    timePickerKt$TimePickerTextField$2$1RememberedValue = composer2.rememberedValue();
                    if (!z3 || timePickerKt$TimePickerTextField$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                        composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.LaunchedEffect(timePickerSelectionModeM4583boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimePickerTextField$2$1RememberedValue, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions3 = keyboardActions5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$3(modifier, textFieldValue, function1, timePickerState2, i13, keyboardOptions2, keyboardActions3, timePickerColors, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            keyboardActions2 = keyboardActions;
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(timePickerColors)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions2;
            } else {
                if (i14 != 0) {
                    keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i5 != 0) {
                    keyboardActions4 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions4 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1299172990, i4, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:2051)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1330227685, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                focusRequester = (FocusRequester) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i7 = i4;
                final TextFieldColors textFieldColorsM3949colors0hiis_1 = OutlinedTextFieldDefaults.INSTANCE.m3949colors0hiis_0(timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true), 0L, 0L, 0L, timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getErrorContainer(), 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getOnErrorContainer(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2080374606, 4095);
                zM4586equalsimpl0 = TimePickerSelectionMode.m4586equalsimpl0(i13, timePickerState2.mo2728getSelectionyecRtBI());
                if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                    zIsMinuteInputValid = isHourInputValid(timePickerState2);
                } else {
                    zIsMinuteInputValid = isMinuteInputValid(timePickerState2);
                }
                if (zIsMinuteInputValid) {
                    composerStartRestartGroup.startReplaceGroup(1713428167);
                    composerStartRestartGroup.endReplaceGroup();
                    jM4518timeSelectorContentColorvNxB06k$material3 = timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true);
                    i8 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1713494445);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "2074@80217L11");
                    i8 = 6;
                    long error2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getError();
                    composerStartRestartGroup.endReplaceGroup();
                    jM4518timeSelectorContentColorvNxB06k$material3 = error2;
                }
                Modifier modifierWidth2 = IntrinsicKt.width(modifier, IntrinsicSize.Min);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int i110 = i8;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023500047, "C2095@80938L240,2102@81211L39,2104@81260L2220,2155@83563L38,2154@83490L215:TimePicker.kt#uh7d8r");
                if (!zM4586equalsimpl0) {
                    i9 = i13;
                    i10 = i7;
                    r15 = 0;
                    composerStartRestartGroup.startReplaceGroup(1943723406);
                } else {
                    composerStartRestartGroup.startReplaceGroup(2023427227);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "2079@80342L539");
                    Modifier modifierM1268sizeVpY3zN6 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                    if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                        if (isHourInputValid(timePickerState2)) {
                            minuteInput = getHourForDisplay(timePickerState2);
                        } else {
                            minuteInput = timePickerState2.getHourInput();
                        }
                    } else {
                        minuteInput = timePickerState2.getMinuteInput();
                    }
                    i10 = i7;
                    int i111 = i10 >> 3;
                    r15 = 0;
                    m4559TimeSelectoru8A1Dfs(modifierM1268sizeVpY3zN6, minuteInput, timePickerState2, i13, timePickerColors, zIsMinuteInputValid, composerStartRestartGroup, (i111 & 7168) | (i111 & 896) | 6 | ((i10 >> 9) & 57344));
                    i9 = i13;
                }
                composerStartRestartGroup.endReplaceGroup();
                if (TimePickerSelectionMode.m4586equalsimpl0(i9, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                    Strings.Companion companion4 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_text_field);
                } else {
                    Strings.Companion companion5 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_text_field);
                }
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, r15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173678235, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierVisible2 = visible(Modifier.INSTANCE, zM4586equalsimpl0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r15);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVisible2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1787857941, "C2111@81603L151,2118@81956L7,2125@82281L11,2126@82349L11,2130@82511L959,2105@81306L2164:TimePicker.kt#uh7d8r");
                Modifier modifierM1268sizeVpY3zN7 = SizeKt.m1268sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443153649, "CC(remember):TimePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM1268sizeVpY3zN7, false, (Function1) objRememberedValue3, 1, null);
                ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localTextStyle2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextStyle textStyleM9104copyp1EtxEg$default2 = TextStyle.m9104copyp1EtxEg$default((TextStyle) objConsume2, jM4518timeSelectorContentColorvNxB06k$material3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                Brush.Companion companion6 = Brush.INSTANCE;
                Pair[] pairArr2 = new Pair[i110];
                pairArr2[0] = TuplesKt.to(Float.valueOf(0.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr2[1] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr2[2] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                pairArr2[3] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                pairArr2[4] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr2[5] = TuplesKt.to(Float.valueOf(1.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                Brush brushM6770verticalGradient8A3gB4$default2 = Brush.Companion.m6770verticalGradient8A3gB4$default(companion6, pairArr2, 0.0f, 0.0f, 0, 14, (Object) null);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1007938103, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$1(textFieldValue, zIsMinuteInputValid, mutableInteractionSource2, textFieldColorsM3949colors0hiis_1, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i112 = i10 >> 3;
                int i113 = (i112 & 14) | 100666368 | (i112 & 112);
                int i114 = i10 << 3;
                boolean z5 = zIsMinuteInputValid;
                KeyboardOptions keyboardOptions5 = keyboardOptions3;
                i11 = i10;
                KeyboardActions keyboardActions6 = keyboardActions4;
                BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierSemantics$default2, true, false, textStyleM9104copyp1EtxEg$default2, keyboardOptions5, keyboardActions6, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource2, brushM6770verticalGradient8A3gB4$default2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda2, composerStartRestartGroup, i113 | (3670016 & i114) | (i114 & 29360128), 199680, 7696);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1173753498, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                timePickerState2 = timePickerState;
                m4556SupportingText73flGVI(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default2, false, (Function1) objRememberedValue4, 1, null), i, timePickerState2, z5, composer2, ((i11 >> 9) & 112) | (i112 & 896));
                i13 = i;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                TimePickerSelectionMode timePickerSelectionModeM4583boximpl2 = TimePickerSelectionMode.m4583boximpl(timePickerState2.mo2728getSelectionyecRtBI());
                ComposerKt.sourceInformationMarkerStart(composer2, -1330085339, "CC(remember):TimePicker.kt#9igjgp");
                if ((i11 & 7168) != 2048) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                z3 = z2 | ((i11 & 57344) == 16384);
                timePickerKt$TimePickerTextField$2$1RememberedValue = composer2.rememberedValue();
                if (!z3) {
                    timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                    composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
                } else {
                    timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                    composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(timePickerSelectionModeM4583boximpl2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimePickerTextField$2$1RememberedValue, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions2 = keyboardOptions5;
                keyboardActions3 = keyboardActions6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$3(modifier, textFieldValue, function1, timePickerState2, i13, keyboardOptions2, keyboardActions3, timePickerColors, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        i5 = i3 & 64;
        if (i5 != 0) {
            if ((1572864 & i2) == 0) {
                keyboardActions2 = keyboardActions;
                if (composerStartRestartGroup.changed(keyboardActions2)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(timePickerColors)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                keyboardOptions2 = keyboardOptions;
                keyboardActions3 = keyboardActions2;
            } else {
                if (i14 != 0) {
                    keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions;
                }
                if (i5 != 0) {
                    keyboardActions4 = KeyboardActions.INSTANCE.getDefault();
                } else {
                    keyboardActions4 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1299172990, i4, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:2051)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1330227685, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                focusRequester = (FocusRequester) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i7 = i4;
                final TextFieldColors textFieldColorsM3949colors0hiis_2 = OutlinedTextFieldDefaults.INSTANCE.m3949colors0hiis_0(timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true), 0L, 0L, 0L, timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getErrorContainer(), 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getOnErrorContainer(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2080374606, 4095);
                zM4586equalsimpl0 = TimePickerSelectionMode.m4586equalsimpl0(i13, timePickerState2.mo2728getSelectionyecRtBI());
                if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                    zIsMinuteInputValid = isHourInputValid(timePickerState2);
                } else {
                    zIsMinuteInputValid = isMinuteInputValid(timePickerState2);
                }
                if (zIsMinuteInputValid) {
                    composerStartRestartGroup.startReplaceGroup(1713428167);
                    composerStartRestartGroup.endReplaceGroup();
                    jM4518timeSelectorContentColorvNxB06k$material3 = timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true);
                    i8 = 6;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1713494445);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "2074@80217L11");
                    i8 = 6;
                    long error3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getError();
                    composerStartRestartGroup.endReplaceGroup();
                    jM4518timeSelectorContentColorvNxB06k$material3 = error3;
                }
                Modifier modifierWidth3 = IntrinsicKt.width(modifier, IntrinsicSize.Min);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                int i115 = i8;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023500047, "C2095@80938L240,2102@81211L39,2104@81260L2220,2155@83563L38,2154@83490L215:TimePicker.kt#uh7d8r");
                if (!zM4586equalsimpl0) {
                    i9 = i13;
                    i10 = i7;
                    r15 = 0;
                    composerStartRestartGroup.startReplaceGroup(1943723406);
                } else {
                    composerStartRestartGroup.startReplaceGroup(2023427227);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "2079@80342L539");
                    Modifier modifierM1268sizeVpY3zN8 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                    if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                        if (isHourInputValid(timePickerState2)) {
                            minuteInput = getHourForDisplay(timePickerState2);
                        } else {
                            minuteInput = timePickerState2.getHourInput();
                        }
                    } else {
                        minuteInput = timePickerState2.getMinuteInput();
                    }
                    i10 = i7;
                    int i116 = i10 >> 3;
                    r15 = 0;
                    m4559TimeSelectoru8A1Dfs(modifierM1268sizeVpY3zN8, minuteInput, timePickerState2, i13, timePickerColors, zIsMinuteInputValid, composerStartRestartGroup, (i116 & 7168) | (i116 & 896) | 6 | ((i10 >> 9) & 57344));
                    i9 = i13;
                }
                composerStartRestartGroup.endReplaceGroup();
                if (TimePickerSelectionMode.m4586equalsimpl0(i9, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                    Strings.Companion companion7 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_text_field);
                } else {
                    Strings.Companion companion8 = Strings.INSTANCE;
                    iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_text_field);
                }
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, r15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173678235, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierVisible3 = visible(Modifier.INSTANCE, zM4586equalsimpl0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r15);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVisible3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1787857941, "C2111@81603L151,2118@81956L7,2125@82281L11,2126@82349L11,2130@82511L959,2105@81306L2164:TimePicker.kt#uh7d8r");
                Modifier modifierM1268sizeVpY3zN9 = SizeKt.m1268sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443153649, "CC(remember):TimePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierM1268sizeVpY3zN9, false, (Function1) objRememberedValue3, 1, null);
                ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localTextStyle3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TextStyle textStyleM9104copyp1EtxEg$default3 = TextStyle.m9104copyp1EtxEg$default((TextStyle) objConsume3, jM4518timeSelectorContentColorvNxB06k$material3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                Brush.Companion companion9 = Brush.INSTANCE;
                Pair[] pairArr3 = new Pair[i115];
                pairArr3[0] = TuplesKt.to(Float.valueOf(0.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr3[1] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr3[2] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                pairArr3[3] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
                pairArr3[4] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                pairArr3[5] = TuplesKt.to(Float.valueOf(1.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
                Brush brushM6770verticalGradient8A3gB4$default3 = Brush.Companion.m6770verticalGradient8A3gB4$default(companion9, pairArr3, 0.0f, 0.0f, 0, 14, (Object) null);
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1007938103, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$1(textFieldValue, zIsMinuteInputValid, mutableInteractionSource3, textFieldColorsM3949colors0hiis_2, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i117 = i10 >> 3;
                int i118 = (i117 & 14) | 100666368 | (i117 & 112);
                int i119 = i10 << 3;
                boolean z6 = zIsMinuteInputValid;
                KeyboardOptions keyboardOptions6 = keyboardOptions3;
                i11 = i10;
                KeyboardActions keyboardActions7 = keyboardActions4;
                BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierSemantics$default3, true, false, textStyleM9104copyp1EtxEg$default3, keyboardOptions6, keyboardActions7, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, brushM6770verticalGradient8A3gB4$default3, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda3, composerStartRestartGroup, i118 | (3670016 & i119) | (i119 & 29360128), 199680, 7696);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1173753498, "CC(remember):TimePicker.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                timePickerState2 = timePickerState;
                m4556SupportingText73flGVI(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default3, false, (Function1) objRememberedValue4, 1, null), i, timePickerState2, z6, composer2, ((i11 >> 9) & 112) | (i117 & 896));
                i13 = i;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                TimePickerSelectionMode timePickerSelectionModeM4583boximpl3 = TimePickerSelectionMode.m4583boximpl(timePickerState2.mo2728getSelectionyecRtBI());
                ComposerKt.sourceInformationMarkerStart(composer2, -1330085339, "CC(remember):TimePicker.kt#9igjgp");
                if ((i11 & 7168) != 2048) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                z3 = z2 | ((i11 & 57344) == 16384);
                timePickerKt$TimePickerTextField$2$1RememberedValue = composer2.rememberedValue();
                if (!z3) {
                    timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                    composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
                } else {
                    timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                    composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(timePickerSelectionModeM4583boximpl3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimePickerTextField$2$1RememberedValue, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions2 = keyboardOptions6;
                keyboardActions3 = keyboardActions7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$3(modifier, textFieldValue, function1, timePickerState2, i13, keyboardOptions2, keyboardActions3, timePickerColors, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        keyboardActions2 = keyboardActions;
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(timePickerColors)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        if ((i4 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            keyboardOptions2 = keyboardOptions;
            keyboardActions3 = keyboardActions2;
        } else {
            if (i14 != 0) {
                keyboardOptions3 = KeyboardOptions.INSTANCE.getDefault();
            } else {
                keyboardOptions3 = keyboardOptions;
            }
            if (i5 != 0) {
                keyboardActions4 = KeyboardActions.INSTANCE.getDefault();
            } else {
                keyboardActions4 = keyboardActions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1299172990, i4, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:2051)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1330227685, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            focusRequester = (FocusRequester) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i7 = i4;
            final TextFieldColors textFieldColorsM3949colors0hiis_3 = OutlinedTextFieldDefaults.INSTANCE.m3949colors0hiis_0(timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true), 0L, 0L, 0L, timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), timePickerColors.m4517timeSelectorContainerColorvNxB06k$material3(true), 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getErrorContainer(), 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getOnErrorContainer(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2080374606, 4095);
            zM4586equalsimpl0 = TimePickerSelectionMode.m4586equalsimpl0(i13, timePickerState2.mo2728getSelectionyecRtBI());
            if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                zIsMinuteInputValid = isHourInputValid(timePickerState2);
            } else {
                zIsMinuteInputValid = isMinuteInputValid(timePickerState2);
            }
            if (zIsMinuteInputValid) {
                composerStartRestartGroup.startReplaceGroup(1713428167);
                composerStartRestartGroup.endReplaceGroup();
                jM4518timeSelectorContentColorvNxB06k$material3 = timePickerColors.m4518timeSelectorContentColorvNxB06k$material3(true);
                i8 = 6;
            } else {
                composerStartRestartGroup.startReplaceGroup(1713494445);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2074@80217L11");
                i8 = 6;
                long error4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getError();
                composerStartRestartGroup.endReplaceGroup();
                jM4518timeSelectorContentColorvNxB06k$material3 = error4;
            }
            Modifier modifierWidth4 = IntrinsicKt.width(modifier, IntrinsicSize.Min);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int i1110 = i8;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWidth4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023500047, "C2095@80938L240,2102@81211L39,2104@81260L2220,2155@83563L38,2154@83490L215:TimePicker.kt#uh7d8r");
            if (!zM4586equalsimpl0) {
                i9 = i13;
                i10 = i7;
                r15 = 0;
                composerStartRestartGroup.startReplaceGroup(1943723406);
            } else {
                composerStartRestartGroup.startReplaceGroup(2023427227);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2079@80342L539");
                Modifier modifierM1268sizeVpY3zN10 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
                if (TimePickerSelectionMode.m4586equalsimpl0(i13, TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI())) {
                    if (isHourInputValid(timePickerState2)) {
                        minuteInput = getHourForDisplay(timePickerState2);
                    } else {
                        minuteInput = timePickerState2.getHourInput();
                    }
                } else {
                    minuteInput = timePickerState2.getMinuteInput();
                }
                i10 = i7;
                int i1111 = i10 >> 3;
                r15 = 0;
                m4559TimeSelectoru8A1Dfs(modifierM1268sizeVpY3zN10, minuteInput, timePickerState2, i13, timePickerColors, zIsMinuteInputValid, composerStartRestartGroup, (i1111 & 7168) | (i1111 & 896) | 6 | ((i10 >> 9) & 57344));
                i9 = i13;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (TimePickerSelectionMode.m4586equalsimpl0(i9, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                Strings.Companion companion10 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_text_field);
            } else {
                Strings.Companion companion11 = Strings.INSTANCE;
                iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_text_field);
            }
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(iM5002constructorimpl, composerStartRestartGroup, r15);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173678235, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableInteractionSource mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierVisible4 = visible(Modifier.INSTANCE, zM4586equalsimpl0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r15);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r15);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVisible4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1787857941, "C2111@81603L151,2118@81956L7,2125@82281L11,2126@82349L11,2130@82511L959,2105@81306L2164:TimePicker.kt#uh7d8r");
            Modifier modifierM1268sizeVpY3zN11 = SizeKt.m1268sizeVpY3zN4(FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester), TimeInputTokens.INSTANCE.m5849getTimeFieldContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m5848getTimeFieldContainerHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1443153649, "CC(remember):TimePicker.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierM1268sizeVpY3zN11, false, (Function1) objRememberedValue3, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle4 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localTextStyle4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextStyle textStyleM9104copyp1EtxEg$default4 = TextStyle.m9104copyp1EtxEg$default((TextStyle) objConsume4, jM4518timeSelectorContentColorvNxB06k$material3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            Brush.Companion companion12 = Brush.INSTANCE;
            Pair[] pairArr4 = new Pair[i1110];
            pairArr4[0] = TuplesKt.to(Float.valueOf(0.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
            pairArr4[1] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
            pairArr4[2] = TuplesKt.to(Float.valueOf(0.1f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
            pairArr4[3] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimary()));
            pairArr4[4] = TuplesKt.to(Float.valueOf(0.9f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
            pairArr4[5] = TuplesKt.to(Float.valueOf(1.0f), Color.m6804boximpl(Color.INSTANCE.m6849getTransparent0d7_KjU()));
            Brush brushM6770verticalGradient8A3gB4$default4 = Brush.Companion.m6770verticalGradient8A3gB4$default(companion12, pairArr4, 0.0f, 0.0f, 0, 14, (Object) null);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1007938103, true, new Function3() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$1(textFieldValue, zIsMinuteInputValid, mutableInteractionSource4, textFieldColorsM3949colors0hiis_3, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i1112 = i10 >> 3;
            int i1113 = (i1112 & 14) | 100666368 | (i1112 & 112);
            int i1114 = i10 << 3;
            boolean z7 = zIsMinuteInputValid;
            KeyboardOptions keyboardOptions7 = keyboardOptions3;
            i11 = i10;
            KeyboardActions keyboardActions8 = keyboardActions4;
            BasicTextFieldKt.BasicTextField(textFieldValue, function1, modifierSemantics$default4, true, false, textStyleM9104copyp1EtxEg$default4, keyboardOptions7, keyboardActions8, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, brushM6770verticalGradient8A3gB4$default4, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda4, composerStartRestartGroup, i1113 | (3670016 & i1114) | (i1114 & 29360128), 199680, 7696);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1173753498, "CC(remember):TimePicker.kt#9igjgp");
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$2$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            timePickerState2 = timePickerState;
            m4556SupportingText73flGVI(SemanticsModifierKt.semantics$default(modifierFillMaxWidth$default4, false, (Function1) objRememberedValue4, 1, null), i, timePickerState2, z7, composer2, ((i11 >> 9) & 112) | (i1112 & 896));
            i13 = i;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TimePickerSelectionMode timePickerSelectionModeM4583boximpl4 = TimePickerSelectionMode.m4583boximpl(timePickerState2.mo2728getSelectionyecRtBI());
            ComposerKt.sourceInformationMarkerStart(composer2, -1330085339, "CC(remember):TimePicker.kt#9igjgp");
            if ((i11 & 7168) != 2048) {
                z2 = true;
            } else {
                z2 = true;
            }
            z3 = z2 | ((i11 & 57344) == 16384);
            timePickerKt$TimePickerTextField$2$1RememberedValue = composer2.rememberedValue();
            if (!z3) {
                timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
            } else {
                timePickerKt$TimePickerTextField$2$1RememberedValue = new TimePickerKt$TimePickerTextField$2$1(timePickerState2, i13, focusRequester, null);
                composer2.updateRememberedValue(timePickerKt$TimePickerTextField$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(timePickerSelectionModeM4583boximpl4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) timePickerKt$TimePickerTextField$2$1RememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions2 = keyboardOptions7;
            keyboardActions3 = keyboardActions8;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimePickerTextField_1vLObsk$lambda$3(modifier, textFieldValue, function1, timePickerState2, i13, keyboardOptions2, keyboardActions3, timePickerColors, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$1$1$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setMaxTextLength(semanticsPropertyReceiver, 2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$1$1$1(TextFieldValue textFieldValue, final boolean z, final MutableInteractionSource mutableInteractionSource, final TextFieldColors textFieldColors, Function2 function2, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(it)2141@83031L406,2131@82555L901:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composer.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1007938103, i2, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:2131)");
            }
            OutlinedTextFieldDefaults.INSTANCE.DecorationBox(textFieldValue.getText(), function2, true, true, VisualTransformation.INSTANCE.getNone(), mutableInteractionSource, !z, null, null, null, null, null, null, null, textFieldColors, PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0)), ComposableLambdaKt.rememberComposableLambda(769667466, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimePickerTextField_1vLObsk$lambda$1$1$1$0(z, mutableInteractionSource, textFieldColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ((i2 << 3) & 112) | 224640, 14352384, 16256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$1$1$1$0(boolean z, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2146@83329L5,2142@83083L332:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(769667466, i, -1, "androidx.compose.material3.TimePickerTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:2142)");
            }
            OutlinedTextFieldDefaults.INSTANCE.m3947Container4EFweAY(true, !z, mutableInteractionSource, null, textFieldColors, ShapesKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldContainerShape(), composer, 6), 0.0f, 0.0f, composer, 100663686, 200);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$1$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        return Unit.INSTANCE;
    }

    private static final void CircularLayout(Modifier modifier, final float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1041042571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularLayout)N(modifier,radiusToSizeRatio,content)2179@84212L1660,2179@84165L1707:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1041042571, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:2178)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285477649, "CC(remember):TimePicker.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            TimePickerKt$CircularLayout$1$1 timePickerKt$CircularLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || timePickerKt$CircularLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$CircularLayout$1$1RememberedValue = new TimePickerKt$CircularLayout$1$1(f);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$CircularLayout$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$CircularLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.CircularLayout$lambda$1(modifier2, f, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m4567numberContentDescriptiondSwYdS4(int i, boolean z, int i2, Composer composer, int i3) {
        int iM5002constructorimpl;
        ComposerKt.sourceInformationMarkerStart(composer, 194237364, "C(numberContentDescription)N(selection:c#material3.TimePickerSelectionMode,is24Hour,number)2229@86308L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(194237364, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:2219)");
        }
        if (TimePickerSelectionMode.m4586equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
            Strings.Companion companion = Strings.INSTANCE;
            iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (z) {
            Strings.Companion companion2 = Strings.INSTANCE;
            iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.INSTANCE;
            iM5002constructorimpl = Strings.m5002constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String strM5087getStringqBjtwXw = Strings_androidKt.m5087getStringqBjtwXw(iM5002constructorimpl, new Object[]{Integer.valueOf(i2)}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strM5087getStringqBjtwXw;
    }

    private static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot(i - f, i2 - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float f, float f2) {
        float fAtan2 = ((float) Math.atan2(f, f2)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + FullCircle : fAtan2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m4564isClickZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && m4565isEnterZmokQxo(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isEnter-ZmokQxo, reason: not valid java name */
    public static final boolean m4565isEnterZmokQxo(android.view.KeyEvent keyEvent) {
        long jM7977getKeyZmokQxo = KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent);
        return Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7741getDirectionCenterEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7755getEnterEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7847getNumPadEnterEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7893getSpacebarEK5gGoQ());
    }

    public static final int getDefaultTimePickerLayoutType(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 435687004, "C(<get-defaultTimePickerLayoutType>)2263@87222L29:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435687004, i, -1, "androidx.compose.material3.<get-defaultTimePickerLayoutType> (TimePicker.kt:2263)");
        }
        int iDefaultTimePickerLayoutType = TimePicker_androidKt.defaultTimePickerLayoutType(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iDefaultTimePickerLayoutType;
    }

    public static final float getClockDialMinContainerSize() {
        return ClockDialMinContainerSize;
    }

    private static final Modifier visible(Modifier modifier, final boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(ViewProps.VISIBLE);
                inspectorInfo.getProperties().set(ViewProps.VISIBLE, Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean TimeInputImpl$lambda$9$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$0$1$0(IntList intList, final AnalogTimePickerState analogTimePickerState, final boolean z, final FocusManager focusManager, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C:TimePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-596940007, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1726)");
            }
            composer.startReplaceGroup(1866272197);
            ComposerKt.sourceInformation(composer, "*1734@68123L41,1733@68058L330");
            int i3 = intList._size;
            for (final int i4 = 0; i4 < i3; i4++) {
                if (!analogTimePickerState.getIs24hour() || TimePickerSelectionMode.m4586equalsimpl0(analogTimePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4591getMinuteyecRtBI())) {
                    i2 = intList.get(i4);
                } else {
                    i2 = intList.get(i4) % 12;
                }
                int i5 = i2;
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -121641742, "CC(remember):TimePicker.kt#9igjgp");
                boolean zChanged = composer.changed(i4);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TimePickerKt.ClockFace$lambda$0$1$0$0$0$0(i4, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), analogTimePickerState, i5, z, focusManager, composer, 0);
            }
            composer.endReplaceGroup();
            if (!TimePickerSelectionMode.m4586equalsimpl0(analogTimePickerState.mo2728getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m4590getHouryecRtBI()) || !analogTimePickerState.getIs24hour()) {
                composer.startReplaceGroup(1952660841);
            } else {
                composer.startReplaceGroup(2020640431);
                ComposerKt.sourceInformation(composer, "1749@68881L614,1743@68517L978");
                CircularLayout(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m5851getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m6849getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), InnerCircleToSizeRatio, ComposableLambdaKt.rememberComposableLambda(-1385767514, true, new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerKt.ClockFace$lambda$0$1$0$1(analogTimePickerState, z, focusManager, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 432, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean ClockText$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f = 24;
        ClockFaceBottomMargin = Dp.m9687constructorimpl(f);
        DisplaySeparatorWidth = Dp.m9687constructorimpl(f);
        IntList intListIntListOf = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = intListIntListOf;
        MutableIntList mutableIntList = new MutableIntList(intListIntListOf._size);
        int[] iArr = intListIntListOf.content;
        int i = intListIntListOf._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableIntList.add((iArr[i2] % 12) + 12);
        }
        ExtraHours = mutableIntList;
        PeriodToggleMargin = Dp.m9687constructorimpl(12);
        TimePickerMaxHeight = Dp.m9687constructorimpl(384);
        TimePickerMidHeight = Dp.m9687constructorimpl(330);
        ClockDialMidContainerSize = Dp.m9687constructorimpl(238);
        ClockDialMinContainerSize = Dp.m9687constructorimpl(200);
    }
}
