package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0099\u0001\u001a\u00020\u00112\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0003\b\u009b\u0001J\u0019\u0010\u009c\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u009d\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b\u009e\u0001J\u0010\u0010\u009f\u0001\u001a\u00030\u0092\u0001H\u0000¢\u0006\u0003\b \u0001J\u001a\u0010¡\u0001\u001a\u00020\u00112\t\b\u0002\u0010¢\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b£\u0001J\u000f\u0010¤\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b¥\u0001J\u001c\u0010¦\u0001\u001a\u00020\u00112\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010eH\u0000¢\u0006\u0003\b¨\u0001J\u001b\u0010©\u0001\u001a\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001b\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b®\u0001\u0010¬\u0001J\u000f\u0010¯\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b°\u0001J\u000f\u0010º\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b»\u0001J\u0010\u0010¼\u0001\u001a\u00020XH\u0080\b¢\u0006\u0003\b½\u0001J\u0013\u0010¾\u0001\u001a\u00020\u0011H\u0080@¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0019\u0010Á\u0001\u001a\u0012\u0012\u0005\u0012\u00030Ã\u0001\u0012\u0004\u0012\u00020h\u0018\u00010Â\u0001H\u0002J\u000f\u0010Ä\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÅ\u0001J\u0010\u0010Æ\u0001\u001a\u00020XH\u0080\b¢\u0006\u0003\bÇ\u0001J\u000f\u0010È\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÉ\u0001J\u0010\u0010Ê\u0001\u001a\u00020XH\u0080\b¢\u0006\u0003\bË\u0001J\u000f\u0010Ì\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÍ\u0001J\u000f\u0010Î\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÏ\u0001J\u001d\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\t\b\u0002\u0010Ò\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÓ\u0001J\u001c\u0010Ô\u0001\u001a\u0004\u0018\u00010$2\t\b\u0002\u0010Ò\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÕ\u0001J\u0012\u0010Ö\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0000¢\u0006\u0003\b×\u0001J\u0018\u0010Ö\u0001\u001a\u00020\u00112\u0007\u0010Ø\u0001\u001a\u00020$H\u0000¢\u0006\u0003\b×\u0001J\u0012\u0010Ù\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0000¢\u0006\u0003\bÚ\u0001J\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010$H\u0000¢\u0006\u0003\bÜ\u0001J\u000f\u0010Ý\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÞ\u0001J\u000f\u0010ß\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bà\u0001J\u001b\u0010á\u0001\u001a\u00020e2\u0007\u0010\u009d\u0001\u001a\u00020XH\u0000¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0019\u0010ä\u0001\u001a\u00030å\u00012\u0007\u0010\u009d\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bæ\u0001J\u001c\u0010ç\u0001\u001a\u00020e2\b\u0010è\u0001\u001a\u00030é\u0001H\u0000¢\u0006\u0006\bê\u0001\u0010ë\u0001J\u0012\u0010ì\u0001\u001a\u00020\u00112\u0007\u0010í\u0001\u001a\u00020XH\u0002J\u000f\u0010î\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bï\u0001J\f\u0010ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0002J\u000f\u0010ñ\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bò\u0001J\u0019\u0010ó\u0001\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020e¢\u0006\u0006\bô\u0001\u0010¬\u0001J\u000f\u0010õ\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bö\u0001J\n\u0010÷\u0001\u001a\u00030ø\u0001H\u0002JH\u0010ù\u0001\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\u00102\u0007\u0010ú\u0001\u001a\u00020e2\u0007\u0010û\u0001\u001a\u00020X2\u0007\u0010\u009d\u0001\u001a\u00020X2\b\u0010ü\u0001\u001a\u00030ý\u00012\u0007\u0010þ\u0001\u001a\u00020XH\u0002¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J\u0013\u0010\u0081\u0002\u001a\u00020\u00112\b\u0010\u0082\u0002\u001a\u00030\u0083\u0002H\u0002J$\u0010\u0084\u0002\u001a\u00020\u00102\u0007\u0010\u0085\u0002\u001a\u00020$2\u0007\u0010\u009a\u0001\u001a\u00020hH\u0002¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010`\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010_\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR/\u0010k\u001a\u0004\u0018\u00010j2\b\u0010W\u001a\u0004\u0018\u00010j8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010_\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR/\u0010q\u001a\u0004\u0018\u00010e2\b\u0010W\u001a\u0004\u0018\u00010e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010_\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010|\u001a\u0004\u0018\u00010hX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R/\u0010\u0081\u0001\u001a\u00020X2\u0006\u0010W\u001a\u00020X8B@BX\u0082\u008e\u0002¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010_\u001a\u0005\b\u0082\u0001\u0010[\"\u0005\b\u0083\u0001\u0010]R,\u0010\u0085\u0001\u001a\u00030\u0086\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0015\u0010\u008d\u0001\u001a\u00030\u008e\u00018F¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010±\u0001\u001a\u00020XX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010[\"\u0005\b³\u0001\u0010]R\u001e\u0010´\u0001\u001a\u00020X8@X\u0080\u0004¢\u0006\u000f\u0012\u0006\bµ\u0001\u0010\u0088\u0001\u001a\u0005\b¶\u0001\u0010[R\u0016\u0010·\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010[R\u0016\u0010¸\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010[¨\u0006\u0088\u0002"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "getOnValueChange$foundation", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "getValue$foundation", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation", "()Landroidx/compose/ui/text/AnnotatedString;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation", "(Lkotlin/jvm/functions/Function0;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "", ComposeIdentificationData.FIELD_IS_EDITABLE_TEXT, "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragBeginSelection", "Landroidx/compose/ui/text/TextRange;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "previousRawDragOffset", "", "oldValue", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "latestSelection", "getLatestSelection-MzsxiRA$foundation", "()Landroidx/compose/ui/text/TextRange;", "setLatestSelection-OEnZFl4$foundation", "(Landroidx/compose/ui/text/TextRange;)V", "hasAvailableTextToPaste", "getHasAvailableTextToPaste", "setHasAvailableTextToPaste", "hasAvailableTextToPaste$delegate", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation$annotations", "()V", "getToolbarRequester$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "contextMenuAreaModifier", "Landroidx/compose/ui/Modifier;", "getContextMenuAreaModifier", "()Landroidx/compose/ui/Modifier;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation", "()Landroidx/compose/foundation/text/TextDragObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "maybeSuggestSelection", "selection", "maybeSuggestSelection-OEnZFl4", "handleDragObserver", "isStartHandle", "handleDragObserver$foundation", "cursorDragObserver", "cursorDragObserver$foundation", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation", "exitSelectionMode", "exitSelectionMode$foundation", "deselect", ViewProps.POSITION, "deselect-_kEHs6E$foundation", "setSelectionPreviewHighlight", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation", "(J)V", "setDeletionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation", "clearPreviewHighlight", "clearPreviewHighlight$foundation", "textToolbarShownViaProvider", "getTextToolbarShownViaProvider$foundation", "setTextToolbarShownViaProvider$foundation", "textToolbarShown", "getTextToolbarShown$foundation$annotations", "getTextToolbarShown$foundation", "isPassword", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_HAS_SELECTION, "getHasSelection", "canShowCopyMenuItem", "canShowCopyMenuItem$foundation", "isCopyAllowed", "isCopyAllowed$foundation", "updateClipboardEntry", "updateClipboardEntry$foundation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContextTextAndSelection", "Lkotlin/Pair;", "", "canShowPasteMenuItem", "canShowPasteMenuItem$foundation", "isPasteAllowed", "isPasteAllowed$foundation", "canShowCutMenuItem", "canShowCutMenuItem$foundation", "isCutAllowed", "isCutAllowed$foundation", "canShowSelectAllMenuItem", "canShowSelectAllMenuItem$foundation", "canShowAutofillMenuItem", "canShowAutofillMenuItem$foundation", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation", "copyWithResult", "copyWithResult$foundation", "paste", "paste$foundation", "text", "cut", "cut$foundation", "cutWithResult", "cutWithResult$foundation", "selectAll", "selectAll$foundation", "autofill", "autofill$foundation", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation", "(Z)J", "getHandleLineHeight", "", "getHandleLineHeight$foundation", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation", "(Landroidx/compose/ui/unit/Density;)J", "updateFloatingToolbar", "show", "showSelectionToolbar", "showSelectionToolbar$foundation", "showSelectionToolbarViaTextToolbar", "hideSelectionToolbar", "hideSelectionToolbar$foundation", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "isTextChanged", "isTextChanged$foundation", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "createTextFieldValue", "annotatedString", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private long dragBeginPosition;
    private TextRange dragBeginSelection;
    private long dragTotalDistance;

    /* JADX INFO: renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* JADX INFO: renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;

    /* JADX INFO: renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;

    /* JADX INFO: renamed from: hasAvailableTextToPaste$delegate, reason: from kotlin metadata */
    private final MutableState hasAvailableTextToPaste;
    private TextRange latestSelection;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private boolean textToolbarShownViaProvider;
    private ToolbarRequester toolbarRequester;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState<TextFieldValue> valueState;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getTextToolbarShown$foundation$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation$annotations() {
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionManager.onValueChange$lambda$0((TextFieldValue) obj);
            }
        };
        this.valueState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        this.editable = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.enabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.dragBeginPosition = Offset.INSTANCE.m6585getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m6585getZeroF1C5BW0();
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.hasAvailableTextToPaste = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private TextRange runningSelection;
            private boolean isLongPressSelectionOnly = true;
            private SelectionAdjustment selectionAdjustmentMode = SelectionAdjustment.INSTANCE.getNone();

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo1717onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public void mo1719onStart3MmeM6k(long startPoint, SelectionAdjustment selectionAdjustment) {
                long j;
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                if (this.this$0.getEnabled() && this.this$0.getDraggingHandle() == null) {
                    this.this$0.setDraggingHandle(Handle.SelectionEnd);
                    this.this$0.previousRawDragOffset = -1;
                    this.isLongPressSelectionOnly = true;
                    this.selectionAdjustmentMode = selectionAdjustment;
                    this.this$0.hideSelectionToolbar$foundation();
                    LegacyTextFieldState state = this.this$0.getState();
                    if (state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m1761isPositionOnTextk4lQ0M(startPoint)) {
                        j = startPoint;
                        LegacyTextFieldState state2 = this.this$0.getState();
                        if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                            int iTransformedToOriginal = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1759getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, null));
                            TextFieldValue textFieldValueM2204createTextFieldValueFDrldGo = textFieldSelectionManager.m2204createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation().getAnnotatedString(), TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo7590performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m7607getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation().invoke(textFieldValueM2204createTextFieldValueFDrldGo);
                            textFieldSelectionManager.m2216setLatestSelectionOEnZFl4$foundation(TextRange.m9079boximpl(textFieldValueM2204createTextFieldValueFDrldGo.getSelection()));
                        }
                        this.isLongPressSelectionOnly = false;
                    } else {
                        if (this.this$0.getValue$foundation().getText().length() == 0) {
                            return;
                        }
                        this.this$0.enterSelectionMode$foundation(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                        long jM2208updateSelection8UEBfa8 = textFieldSelectionManager2.m2208updateSelection8UEBfa8(TextFieldValue.m9340copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation(), (AnnotatedString) null, TextRange.INSTANCE.m9096getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, this.selectionAdjustmentMode, true);
                        j = startPoint;
                        this.this$0.dragBeginSelection = TextRange.m9079boximpl(jM2208updateSelection8UEBfa8);
                        this.runningSelection = TextRange.m9079boximpl(jM2208updateSelection8UEBfa8);
                    }
                    this.this$0.setHandleState(HandleState.None);
                    this.this$0.dragBeginPosition = j;
                    TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                    textFieldSelectionManager3.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(textFieldSelectionManager3.dragBeginPosition));
                    this.this$0.dragTotalDistance = Offset.INSTANCE.m6585getZeroF1C5BW0();
                }
            }

            /* JADX WARN: Code duplicated, block: B:20:0x00b5  */
            /* JADX WARN: Code duplicated, block: B:22:0x00bc  */
            /* JADX WARN: Code duplicated, block: B:23:0x00c5  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo1718onDragk4lQ0M(long delta) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager textFieldSelectionManager;
                TextRange textRange;
                int iM1760getOffsetForPosition3MmeM6k;
                long jM2208updateSelection8UEBfa8;
                SelectionAdjustment word;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.dragTotalDistance = Offset.m6574plusMKHz9U(textFieldSelectionManager2.dragTotalDistance, delta);
                LegacyTextFieldState state = this.this$0.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                    textFieldSelectionManager3.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(Offset.m6574plusMKHz9U(textFieldSelectionManager3.dragBeginPosition, textFieldSelectionManager3.dragTotalDistance)));
                    if (textFieldSelectionManager3.dragBeginSelection != null) {
                        textFieldSelectionManager = textFieldSelectionManager3;
                        textRange = textFieldSelectionManager.dragBeginSelection;
                        if (textRange != null) {
                            iM1760getOffsetForPosition3MmeM6k = TextRange.m9091getStartimpl(textRange.getPackedValue());
                        } else {
                            iM1760getOffsetForPosition3MmeM6k = layoutResult.m1760getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                        }
                        Offset offsetM2210getCurrentDragPosition_m7T9E = textFieldSelectionManager.m2210getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E);
                        int iM1760getOffsetForPosition3MmeM6k2 = layoutResult.m1760getOffsetForPosition3MmeM6k(offsetM2210getCurrentDragPosition_m7T9E.m6579unboximpl(), false);
                        if (textFieldSelectionManager.dragBeginSelection != null) {
                        }
                        TextFieldValue value$foundation = textFieldSelectionManager.getValue$foundation();
                        Offset offsetM2210getCurrentDragPosition_m7T9E2 = textFieldSelectionManager.m2210getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E2);
                        jM2208updateSelection8UEBfa8 = textFieldSelectionManager.m2208updateSelection8UEBfa8(value$foundation, offsetM2210getCurrentDragPosition_m7T9E2.m6579unboximpl(), false, false, this.selectionAdjustmentMode, true);
                    } else {
                        Offset offsetM2210getCurrentDragPosition_m7T9E3 = textFieldSelectionManager3.m2210getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E3);
                        if (layoutResult.m1761isPositionOnTextk4lQ0M(offsetM2210getCurrentDragPosition_m7T9E3.m6579unboximpl())) {
                            textFieldSelectionManager = textFieldSelectionManager3;
                            textRange = textFieldSelectionManager.dragBeginSelection;
                            if (textRange != null) {
                                iM1760getOffsetForPosition3MmeM6k = TextRange.m9091getStartimpl(textRange.getPackedValue());
                            } else {
                                iM1760getOffsetForPosition3MmeM6k = layoutResult.m1760getOffsetForPosition3MmeM6k(textFieldSelectionManager.dragBeginPosition, false);
                            }
                            Offset offsetM2210getCurrentDragPosition_m7T9E4 = textFieldSelectionManager.m2210getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E4);
                            int iM1760getOffsetForPosition3MmeM6k3 = layoutResult.m1760getOffsetForPosition3MmeM6k(offsetM2210getCurrentDragPosition_m7T9E4.m6579unboximpl(), false);
                            if (textFieldSelectionManager.dragBeginSelection != null && iM1760getOffsetForPosition3MmeM6k == iM1760getOffsetForPosition3MmeM6k3) {
                                return;
                            }
                            TextFieldValue value$foundation2 = textFieldSelectionManager.getValue$foundation();
                            Offset offsetM2210getCurrentDragPosition_m7T9E5 = textFieldSelectionManager.m2210getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E5);
                            jM2208updateSelection8UEBfa8 = textFieldSelectionManager.m2208updateSelection8UEBfa8(value$foundation2, offsetM2210getCurrentDragPosition_m7T9E5.m6579unboximpl(), false, false, this.selectionAdjustmentMode, true);
                        } else {
                            int iTransformedToOriginal = textFieldSelectionManager3.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1759getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager3.dragBeginPosition, false, 2, null));
                            OffsetMapping offsetMapping = textFieldSelectionManager3.getOffsetMapping();
                            Offset offsetM2210getCurrentDragPosition_m7T9E6 = textFieldSelectionManager3.m2210getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E6);
                            if (iTransformedToOriginal == offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1759getOffsetForPosition3MmeM6k$default(layoutResult, offsetM2210getCurrentDragPosition_m7T9E6.m6579unboximpl(), false, 2, null))) {
                                word = SelectionAdjustment.INSTANCE.getNone();
                            } else {
                                word = SelectionAdjustment.INSTANCE.getWord();
                            }
                            SelectionAdjustment selectionAdjustment = word;
                            TextFieldValue value$foundation3 = textFieldSelectionManager3.getValue$foundation();
                            Offset offsetM2210getCurrentDragPosition_m7T9E7 = textFieldSelectionManager3.m2210getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E7);
                            textFieldSelectionManager = textFieldSelectionManager3;
                            jM2208updateSelection8UEBfa8 = textFieldSelectionManager.m2208updateSelection8UEBfa8(value$foundation3, offsetM2210getCurrentDragPosition_m7T9E7.m6579unboximpl(), false, false, selectionAdjustment, true);
                        }
                    }
                    this.runningSelection = TextRange.m9079boximpl(jM2208updateSelection8UEBfa8);
                    if (!TextRange.m9083equalsimpl(jM2208updateSelection8UEBfa8, textFieldSelectionManager.dragBeginSelection)) {
                        this.isLongPressSelectionOnly = false;
                    }
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            private final void onEnd() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m2207setCurrentDragPosition_kEHs6E(null);
                this.selectionAdjustmentMode = SelectionAdjustment.INSTANCE.getNone();
                this.this$0.updateFloatingToolbar(true);
                TextRange textRange = this.runningSelection;
                boolean zM9085getCollapsedimpl = TextRange.m9085getCollapsedimpl(textRange != null ? textRange.getPackedValue() : this.this$0.getValue$foundation().getSelection());
                this.this$0.setHandleState(zM9085getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state = this.this$0.getState();
                if (state != null) {
                    state.setShowSelectionHandleStart(!zM9085getCollapsedimpl && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this.this$0, true));
                }
                LegacyTextFieldState state2 = this.this$0.getState();
                if (state2 != null) {
                    state2.setShowSelectionHandleEnd(!zM9085getCollapsedimpl && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this.this$0, false));
                }
                LegacyTextFieldState state3 = this.this$0.getState();
                if (state3 != null) {
                    state3.setShowCursorHandle(zM9085getCollapsedimpl && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this.this$0, true));
                }
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                    textFieldSelectionManager.m2206maybeSuggestSelectionOEnZFl4(textFieldSelectionManager.dragBeginSelection);
                }
                this.this$0.dragBeginSelection = null;
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            private TextRange initialSelection;
            private boolean isDoubleOrTripleClickSelectionOnly = true;

            /* JADX INFO: renamed from: isDoubleOrTripleClickSelectionOnly, reason: from getter */
            public final boolean getIsDoubleOrTripleClickSelectionOnly() {
                return this.isDoubleOrTripleClickSelectionOnly;
            }

            public final void setDoubleOrTripleClickSelectionOnly(boolean z) {
                this.isDoubleOrTripleClickSelectionOnly = z;
            }

            public final TextRange getInitialSelection() {
                return this.initialSelection;
            }

            public final void setInitialSelection(TextRange textRange) {
                this.initialSelection = textRange;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtend-k-4lQ0M */
            public boolean mo2040onExtendk4lQ0M(long downPosition) {
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || state.getLayoutResult() == null || !this.this$0.getEnabled()) {
                    return false;
                }
                this.this$0.previousRawDragOffset = -1;
                FocusRequester focusRequester = this.this$0.getFocusRequester();
                if (focusRequester != null) {
                    FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
                updateMouseSelection(this.this$0.getValue$foundation(), downPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo2041onExtendDragk4lQ0M(long dragPosition) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation(), dragPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onStart-9KIMszo */
            public boolean mo2042onStart9KIMszo(long downPosition, SelectionAdjustment adjustment, int clickCount) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = this.this$0.getFocusRequester();
                if (focusRequester != null) {
                    FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
                this.this$0.dragBeginPosition = downPosition;
                this.this$0.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation$default(this.this$0, false, 1, null);
                long jUpdateMouseSelection = updateMouseSelection(this.this$0.getValue$foundation(), this.this$0.dragBeginPosition, true, adjustment);
                if (clickCount >= 2) {
                    this.isDoubleOrTripleClickSelectionOnly = true;
                    this.initialSelection = TextRange.m9079boximpl(jUpdateMouseSelection);
                }
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onDrag-3MmeM6k */
            public boolean mo2039onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation(), dragPosition, false, adjustment);
                return true;
            }

            public final long updateMouseSelection(TextFieldValue value, long currentPosition, boolean isStartOfSelection, SelectionAdjustment adjustment) {
                long jM2208updateSelection8UEBfa8 = this.this$0.m2208updateSelection8UEBfa8(value, currentPosition, isStartOfSelection, false, adjustment, false);
                if (!TextRange.m9083equalsimpl(jM2208updateSelection8UEBfa8, this.initialSelection)) {
                    this.isDoubleOrTripleClickSelectionOnly = false;
                }
                this.this$0.setHandleState(TextRange.m9085getCollapsedimpl(jM2208updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
                return jM2208updateSelection8UEBfa8;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
                if (this.isDoubleOrTripleClickSelectionOnly) {
                    this.this$0.m2206maybeSuggestSelectionOEnZFl4(this.initialSelection);
                }
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* JADX INFO: renamed from: getOffsetMapping$foundation, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onValueChange$lambda$0(TextFieldValue textFieldValue) {
        return Unit.INSTANCE;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    /* JADX INFO: renamed from: getState$foundation, reason: from getter */
    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final void setState$foundation(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final TextFieldValue getValue$foundation() {
        return this.valueState.getValue();
    }

    public final void setValue$foundation(TextFieldValue textFieldValue) {
        this.valueState.setValue(textFieldValue);
        this.latestSelection = TextRange.m9079boximpl(textFieldValue.getSelection());
    }

    public final AnnotatedString getTransformedText$foundation() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    /* JADX INFO: renamed from: getVisualTransformation$foundation, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final Function0<Unit> getRequestAutofillAction$foundation() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction$foundation(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    /* JADX INFO: renamed from: getClipboard$foundation, reason: from getter */
    public final Clipboard getClipboard() {
        return this.clipboard;
    }

    public final void setClipboard$foundation(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    /* JADX INFO: renamed from: getCoroutineScope$foundation, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    /* JADX INFO: renamed from: getPlatformSelectionBehaviors$foundation, reason: from getter */
    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors() {
        return this.platformSelectionBehaviors;
    }

    public final void setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors platformSelectionBehaviors) {
        this.platformSelectionBehaviors = platformSelectionBehaviors;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m2207setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m2210getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* JADX INFO: renamed from: getLatestSelection-MzsxiRA$foundation, reason: not valid java name and from getter */
    public final TextRange getLatestSelection() {
        return this.latestSelection;
    }

    /* JADX INFO: renamed from: setLatestSelection-OEnZFl4$foundation, reason: not valid java name */
    public final void m2216setLatestSelectionOEnZFl4$foundation(TextRange textRange) {
        this.latestSelection = textRange;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getHasAvailableTextToPaste() {
        return ((Boolean) this.hasAvailableTextToPaste.getValue()).booleanValue();
    }

    private final void setHasAvailableTextToPaste(boolean z) {
        this.hasAvailableTextToPaste.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: getToolbarRequester$foundation, reason: from getter */
    public final ToolbarRequester getToolbarRequester() {
        return this.toolbarRequester;
    }

    public final void setToolbarRequester$foundation(ToolbarRequester toolbarRequester) {
        this.toolbarRequester = toolbarRequester;
    }

    public final Modifier getContextMenuAreaModifier() {
        return !getEnabled() ? Modifier.INSTANCE : TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(Modifier.INSTANCE, new TextFieldSelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new TextFieldSelectionManager$contextMenuAreaModifier$2(this, null), new TextFieldSelectionManager$contextMenuAreaModifier$3(this, null), new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionManager._get_contextMenuAreaModifier_$lambda$0(this.f$0, (LayoutCoordinates) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect _get_contextMenuAreaModifier_$lambda$0(TextFieldSelectionManager textFieldSelectionManager, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        Rect contentRect = textFieldSelectionManager.getContentRect();
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        if (legacyTextFieldState == null || (layoutCoordinates2 = legacyTextFieldState.getLayoutCoordinates()) == null) {
            return null;
        }
        return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(contentRect, layoutCoordinates2, layoutCoordinates);
    }

    /* JADX INFO: renamed from: getTouchSelectionObserver$foundation, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    /* JADX INFO: renamed from: getMouseSelectionObserver$foundation, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    public final void m2206maybeSuggestSelectionOEnZFl4(TextRange selection) {
        PlatformSelectionBehaviors platformSelectionBehaviors;
        AnnotatedString transformedText$foundation;
        String text;
        CoroutineScope coroutineScope;
        if (selection == null || (platformSelectionBehaviors = this.platformSelectionBehaviors) == null || (transformedText$foundation = getTransformedText$foundation()) == null || (text = transformedText$foundation.getText()) == null) {
            return;
        }
        OffsetMapping offsetMapping = this.offsetMapping;
        long jTextRange = TextRangeKt.TextRange(offsetMapping.originalToTransformed(TextRange.m9091getStartimpl(selection.getPackedValue())), offsetMapping.originalToTransformed(TextRange.m9086getEndimpl(selection.getPackedValue())));
        if (text.length() <= 0 || TextRange.m9085getCollapsedimpl(jTextRange) || (coroutineScope = this.coroutineScope) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TextFieldSelectionManager$maybeSuggestSelection$1(platformSelectionBehaviors, text, jTextRange, selection, this, offsetMapping, null), 3, null);
    }

    public final TextDragObserver handleDragObserver$foundation(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public void mo1719onStart3MmeM6k(long startPoint, SelectionAdjustment selectionAdjustment) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo1717onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                this.this$0.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long jM2148getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2148getAdjustedCoordinatesk4lQ0M(this.this$0.m2212getHandlePositiontuRUvjQ$foundation(isStartHandle));
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult.m1763translateInnerToDecorationCoordinatesMKHz9U$foundation(jM2148getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation;
                this.this$0.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m6585getZeroF1C5BW0();
                this.this$0.previousRawDragOffset = -1;
                LegacyTextFieldState state2 = this.this$0.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m2207setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo1718onDragk4lQ0M(long delta) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m6574plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(Offset.m6574plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, this.this$0.dragTotalDistance)));
                TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                TextFieldValue value$foundation = textFieldSelectionManager3.getValue$foundation();
                Offset offsetM2210getCurrentDragPosition_m7T9E = this.this$0.m2210getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m2208updateSelection8UEBfa8(value$foundation, offsetM2210getCurrentDragPosition_m7T9E.m6579unboximpl(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m2207setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo1717onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m2207setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public void mo1719onStart3MmeM6k(long startPoint, SelectionAdjustment selectionAdjustment) {
                TextLayoutResultProxy layoutResult;
                long jM2148getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2148getAdjustedCoordinatesk4lQ0M(this.this$0.m2212getHandlePositiontuRUvjQ$foundation(true));
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation = layoutResult.m1763translateInnerToDecorationCoordinatesMKHz9U$foundation(jM2148getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation;
                this.this$0.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(jM1763translateInnerToDecorationCoordinatesMKHz9U$foundation));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m6585getZeroF1C5BW0();
                this.this$0.setDraggingHandle(Handle.Cursor);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo1718onDragk4lQ0M(long delta) {
                TextLayoutResultProxy layoutResult;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m6574plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m2207setCurrentDragPosition_kEHs6E(Offset.m6558boximpl(Offset.m6574plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset offsetM2210getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m2210getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(offsetM2210getCurrentDragPosition_m7T9E);
                int iTransformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1759getOffsetForPosition3MmeM6k$default(layoutResult, offsetM2210getCurrentDragPosition_m7T9E.m6579unboximpl(), false, 2, null));
                long jTextRange = TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal);
                if (TextRange.m9084equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation().getSelection())) {
                    return;
                }
                LegacyTextFieldState state2 = textFieldSelectionManager2.getState();
                if ((state2 == null || state2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo7590performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m7607getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange$foundation().invoke(textFieldSelectionManager2.m2204createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().getAnnotatedString(), jTextRange));
                textFieldSelectionManager2.m2216setLatestSelectionOEnZFl4$foundation(TextRange.m9079boximpl(jTextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m2207setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation(z);
    }

    public final void enterSelectionMode$foundation(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        this.oldValue = getValue$foundation();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation$default, reason: not valid java name */
    public static /* synthetic */ void m2205deselect_kEHs6E$foundation$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m2209deselect_kEHs6E$foundation(offset);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation, reason: not valid java name */
    public final void m2209deselect_kEHs6E$foundation(Offset position) {
        int iM9088getMaximpl;
        if (!TextRange.m9085getCollapsedimpl(getValue$foundation().getSelection())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (position != null && layoutResult != null) {
                iM9088getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1759getOffsetForPosition3MmeM6k$default(layoutResult, position.m6579unboximpl(), false, 2, null));
            } else {
                iM9088getMaximpl = TextRange.m9088getMaximpl(getValue$foundation().getSelection());
            }
            TextFieldValue textFieldValueM9340copy3r_uNRQ$default = TextFieldValue.m9340copy3r_uNRQ$default(getValue$foundation(), (AnnotatedString) null, TextRangeKt.TextRange(iM9088getMaximpl), (TextRange) null, 5, (Object) null);
            this.onValueChange.invoke(textFieldValueM9340copy3r_uNRQ$default);
            this.latestSelection = TextRange.m9079boximpl(textFieldValueM9340copy3r_uNRQ$default.getSelection());
        }
        setHandleState((position == null || getValue$foundation().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation, reason: not valid java name */
    public final void m2217setSelectionPreviewHighlight5zctL8$foundation(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1688setSelectionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1685setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m9096getZerod9O1mEE());
        }
        if (TextRange.m9085getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation();
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation, reason: not valid java name */
    public final void m2215setDeletionPreviewHighlight5zctL8$foundation(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1685setDeletionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1688setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m9096getZerod9O1mEE());
        }
        if (TextRange.m9085getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation();
    }

    public final void clearPreviewHighlight$foundation() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1685setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m9096getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1688setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m9096getZerod9O1mEE());
        }
    }

    /* JADX INFO: renamed from: getTextToolbarShownViaProvider$foundation, reason: from getter */
    public final boolean getTextToolbarShownViaProvider() {
        return this.textToolbarShownViaProvider;
    }

    public final void setTextToolbarShownViaProvider$foundation(boolean z) {
        this.textToolbarShownViaProvider = z;
    }

    public final boolean getTextToolbarShown$foundation() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            return this.textToolbarShownViaProvider;
        }
        TextToolbar textToolbar = this.textToolbar;
        return (textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPassword() {
        return this.visualTransformation instanceof PasswordVisualTransformation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSelection() {
        return !TextRange.m9085getCollapsedimpl(getValue$foundation().getSelection());
    }

    public final boolean isCopyAllowed$foundation() {
        return getHasSelection() && !isPassword();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateClipboardEntry$foundation(Continuation<? super Unit> continuation) {
        TextFieldSelectionManager$updateClipboardEntry$1 textFieldSelectionManager$updateClipboardEntry$1;
        if (continuation instanceof TextFieldSelectionManager$updateClipboardEntry$1) {
            textFieldSelectionManager$updateClipboardEntry$1 = (TextFieldSelectionManager$updateClipboardEntry$1) continuation;
            if ((textFieldSelectionManager$updateClipboardEntry$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$updateClipboardEntry$1.label -= Integer.MIN_VALUE;
            } else {
                textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuation);
            }
        } else {
            textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuation);
        }
        Object objHasAvailableTextToPaste = textFieldSelectionManager$updateClipboardEntry$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = textFieldSelectionManager$updateClipboardEntry$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objHasAvailableTextToPaste);
            Clipboard clipboard = this.clipboard;
            if (clipboard != null && ClipboardUtils_androidKt.isReadSupported(clipboard)) {
                textFieldSelectionManager$updateClipboardEntry$1.L$0 = this;
                textFieldSelectionManager$updateClipboardEntry$1.label = 1;
                objHasAvailableTextToPaste = TextFieldSelectionManager_androidKt.hasAvailableTextToPaste(this, textFieldSelectionManager$updateClipboardEntry$1);
                if (objHasAvailableTextToPaste == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (TextFieldSelectionManager) textFieldSelectionManager$updateClipboardEntry$1.L$0;
        ResultKt.throwOnFailure(objHasAvailableTextToPaste);
        this.setHasAvailableTextToPaste(((Boolean) objHasAvailableTextToPaste).booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, TextRange> getContextTextAndSelection() {
        String text;
        TextRange textRange;
        AnnotatedString transformedText$foundation = getTransformedText$foundation();
        if (transformedText$foundation == null || (text = transformedText$foundation.getText()) == null || (textRange = this.latestSelection) == null) {
            return null;
        }
        long packedValue = textRange.getPackedValue();
        return new Pair<>(text, TextRange.m9079boximpl(TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m9091getStartimpl(packedValue)), this.offsetMapping.originalToTransformed(TextRange.m9086getEndimpl(packedValue)))));
    }

    public final boolean isPasteAllowed$foundation() {
        return getEditable();
    }

    public final boolean isCutAllowed$foundation() {
        return getHasSelection() && getEditable() && !isPassword();
    }

    public final boolean canShowSelectAllMenuItem$foundation() {
        return TextRange.m9087getLengthimpl(getValue$foundation().getSelection()) != getValue$foundation().getText().length();
    }

    public final boolean canShowAutofillMenuItem$foundation() {
        return getEditable() && TextRange.m9085getCollapsedimpl(getValue$foundation().getSelection());
    }

    public static /* synthetic */ Job copy$foundation$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionManager.copy$foundation(z);
    }

    public final Job copy$foundation(boolean cancelSelection) {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, cancelSelection, null), 1, null);
        }
        return null;
    }

    public static /* synthetic */ AnnotatedString copyWithResult$foundation$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionManager.copyWithResult$foundation(z);
    }

    public final Job paste$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null), 1, null);
        }
        return null;
    }

    public final Job cut$foundation() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, null), 1, null);
        }
        return null;
    }

    public final void selectAll$foundation() {
        TextFieldValue textFieldValueM2204createTextFieldValueFDrldGo = m2204createTextFieldValueFDrldGo(getValue$foundation().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation().getText().length()));
        this.onValueChange.invoke(textFieldValueM2204createTextFieldValueFDrldGo);
        this.latestSelection = TextRange.m9079boximpl(textFieldValueM2204createTextFieldValueFDrldGo.getSelection());
        this.oldValue = TextFieldValue.m9340copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, textFieldValueM2204createTextFieldValueFDrldGo.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation(true);
    }

    public final void autofill$foundation() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation, reason: not valid java name */
    public final long m2212getHandlePositiontuRUvjQ$foundation(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation = getTransformedText$foundation();
        if (transformedText$foundation == null) {
            return Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.m9091getStartimpl(selection) : TextRange.m9086getEndimpl(selection)), isStartHandle, TextRange.m9090getReversedimpl(getValue$foundation().getSelection()));
    }

    public final float getHandleLineHeight$foundation(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int iM9091getStartimpl = isStartHandle ? TextRange.m9091getStartimpl(getValue$foundation().getSelection()) : TextRange.m9086getEndimpl(getValue$foundation().getSelection());
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.getLineHeight(value, iM9091getStartimpl);
    }

    /* JADX INFO: renamed from: getCursorPosition-tuRUvjQ$foundation, reason: not valid java name */
    public final long m2211getCursorPositiontuRUvjQ$foundation(Density density) {
        int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m9091getStartimpl(getValue$foundation().getSelection()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(iOriginalToTransformed, 0, value.getLayoutInput().getText().length()));
        return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(cursorRect.getBottom())) & 4294967295L) | (((long) Float.floatToRawIntBits(cursorRect.getLeft() + (density.mo754toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2))) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation();
        } else {
            hideSelectionToolbar$foundation();
        }
    }

    public final void showSelectionToolbar$foundation() {
        LegacyTextFieldState legacyTextFieldState;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getEnabled() && ((legacyTextFieldState = this.state) == null || legacyTextFieldState.isInTouchMode())) {
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                    this.toolbarRequester.show();
                    return;
                } else {
                    showSelectionToolbarViaTextToolbar();
                    return;
                }
            }
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldSelectionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1", f = "TextFieldSelectionManager.kt", i = {}, l = {1078}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TextFieldSelectionManager.this.new AnonymousClass1(continuation);
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
                if (TextFieldSelectionManager.this.updateClipboardEntry$foundation(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Snapshot.Companion companion = Snapshot.INSTANCE;
            final TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                Function0<Unit> function0 = textFieldSelectionManager.canShowCopyMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionManager.AnonymousClass1.invokeSuspend$lambda$0$0(textFieldSelectionManager);
                    }
                } : null;
                Function0<Unit> function1 = textFieldSelectionManager.canShowCutMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionManager.AnonymousClass1.invokeSuspend$lambda$0$1(textFieldSelectionManager);
                    }
                } : null;
                Function0<Unit> function2 = textFieldSelectionManager.canShowPasteMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionManager.AnonymousClass1.invokeSuspend$lambda$0$2(textFieldSelectionManager);
                    }
                } : null;
                Function0<Unit> function3 = textFieldSelectionManager.canShowSelectAllMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionManager.AnonymousClass1.invokeSuspend$lambda$0$3(textFieldSelectionManager);
                    }
                } : null;
                Function0<Unit> function4 = textFieldSelectionManager.canShowAutofillMenuItem$foundation() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionManager.AnonymousClass1.invokeSuspend$lambda$0$4(textFieldSelectionManager);
                    }
                } : null;
                TextToolbar textToolbar = textFieldSelectionManager.getTextToolbar();
                if (textToolbar != null) {
                    textToolbar.showMenu(textFieldSelectionManager.getContentRect(), function0, function2, function1, function3, function4);
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(TextFieldSelectionManager textFieldSelectionManager) {
            CoroutineScope coroutineScope = textFieldSelectionManager.getCoroutineScope();
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$copy$1$1(textFieldSelectionManager, null), 1, null);
            }
            textFieldSelectionManager.hideSelectionToolbar$foundation();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$1(TextFieldSelectionManager textFieldSelectionManager) {
            CoroutineScope coroutineScope = textFieldSelectionManager.getCoroutineScope();
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$cut$1$1(textFieldSelectionManager, null), 1, null);
            }
            textFieldSelectionManager.hideSelectionToolbar$foundation();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$2(TextFieldSelectionManager textFieldSelectionManager) {
            CoroutineScope coroutineScope = textFieldSelectionManager.getCoroutineScope();
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1$1$paste$1$1(textFieldSelectionManager, null), 1, null);
            }
            textFieldSelectionManager.hideSelectionToolbar$foundation();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$3(TextFieldSelectionManager textFieldSelectionManager) {
            textFieldSelectionManager.selectAll$foundation();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$4(TextFieldSelectionManager textFieldSelectionManager) {
            textFieldSelectionManager.autofill$foundation();
            return Unit.INSTANCE;
        }
    }

    private final Job showSelectionToolbarViaTextToolbar() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(null), 1, null);
        }
        return null;
    }

    public final void hideSelectionToolbar$foundation() {
        TextToolbar textToolbar;
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* JADX INFO: renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    public final void m2214selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || TextLayoutHelperKt.m1757isPositionInsideSelectionuaM50fQ(layoutResult.getValue(), layoutResult.m1762translateDecorationToInnerCoordinatesMKHz9U$foundation(position), TextRange.m9079boximpl(getValue$foundation().getSelection()))) {
            return;
        }
        m2208updateSelection8UEBfa8(getValue$foundation(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
    }

    public final boolean isTextChanged$foundation() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation().getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        char c;
        long j;
        float fIntBitsToFloat;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getIsLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m9091getStartimpl(getValue$foundation().getSelection()));
                int iOriginalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m9086getEndimpl(getValue$foundation().getSelection()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long jM6585getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m6585getZeroF1C5BW0() : layoutCoordinates4.mo8276localToRootMKHz9U(m2212getHandlePositiontuRUvjQ$foundation(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long jM6585getZeroF1C5BW1 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m6585getZeroF1C5BW0() : layoutCoordinates3.mo8276localToRootMKHz9U(m2212getHandlePositiontuRUvjQ$foundation(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float fIntBitsToFloat2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    c = ' ';
                    j = 4294967295L;
                    fIntBitsToFloat = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    c = ' ';
                    j = 4294967295L;
                    fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinates2.mo8276localToRootMKHz9U(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(iOriginalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutCoordinates.mo8276localToRootMKHz9U(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << c) | (((long) Float.floatToRawIntBits((layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(iOriginalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())) & j))) & j));
                }
                int i = (int) (jM6585getZeroF1C5BW0 >> c);
                int i2 = (int) (jM6585getZeroF1C5BW1 >> c);
                return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (jM6585getZeroF1C5BW0 & j)), Float.intBitsToFloat((int) (jM6585getZeroF1C5BW1 & j))) + (Dp.m9687constructorimpl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m2208updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m9096getZerod9O1mEE();
        }
        long jTextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m9091getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m9086getEndimpl(value.getSelection())));
        boolean z = false;
        int iM1760getOffsetForPosition3MmeM6k = layoutResult.m1760getOffsetForPosition3MmeM6k(currentPosition, false);
        int iM9091getStartimpl = (isStartHandle || isStartOfSelection) ? iM1760getOffsetForPosition3MmeM6k : TextRange.m9091getStartimpl(jTextRange);
        int iM9086getEndimpl = (!isStartHandle || isStartOfSelection) ? iM1760getOffsetForPosition3MmeM6k : TextRange.m9086getEndimpl(jTextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (isStartOfSelection || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout selectionLayoutM2152getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m2152getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), iM9091getStartimpl, iM9086getEndimpl, i, jTextRange, isStartOfSelection, isStartHandle);
        if (!selectionLayoutM2152getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = selectionLayoutM2152getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = iM1760getOffsetForPosition3MmeM6k;
        Selection selectionAdjust = adjustment.adjust(selectionLayoutM2152getTextFieldSelectionLayoutRcvTLA);
        long jTextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(selectionAdjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(selectionAdjust.getEnd().getOffset()));
        if (TextRange.m9084equalsimpl0(jTextRange2, value.getSelection())) {
            return value.getSelection();
        }
        boolean z2 = TextRange.m9090getReversedimpl(jTextRange2) != TextRange.m9090getReversedimpl(value.getSelection()) && TextRange.m9084equalsimpl0(TextRangeKt.TextRange(TextRange.m9086getEndimpl(jTextRange2), TextRange.m9091getStartimpl(jTextRange2)), value.getSelection());
        boolean z3 = TextRange.m9085getCollapsedimpl(jTextRange2) && TextRange.m9085getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection && value.getText().length() > 0 && !z2 && !z3 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo7590performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m7607getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m2204createTextFieldValueFDrldGo(value.getAnnotatedString(), jTextRange2));
        this.latestSelection = TextRange.m9079boximpl(jTextRange2);
        if (!isTouchBasedSelection) {
            updateFloatingToolbar(!TextRange.m9085getCollapsedimpl(jTextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m9085getCollapsedimpl(jTextRange2) && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m9085getCollapsedimpl(jTextRange2) && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 != null) {
            if (TextRange.m9085getCollapsedimpl(jTextRange2) && TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(this, true)) {
                z = true;
            }
            legacyTextFieldState5.setShowCursorHandle(z);
        }
        return jTextRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m2204createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }

    public final boolean canShowCopyMenuItem$foundation() {
        Clipboard clipboard;
        return getHasSelection() && !isPassword() && (clipboard = this.clipboard) != null && ClipboardUtils_androidKt.isWriteSupported(clipboard);
    }

    public final boolean canShowPasteMenuItem$foundation() {
        Clipboard clipboard;
        return getEditable() && getHasAvailableTextToPaste() && (clipboard = this.clipboard) != null && ClipboardUtils_androidKt.isReadSupported(clipboard);
    }

    public final boolean canShowCutMenuItem$foundation() {
        Clipboard clipboard;
        return getHasSelection() && getEditable() && !isPassword() && (clipboard = this.clipboard) != null && ClipboardUtils_androidKt.isWriteSupported(clipboard);
    }

    public final AnnotatedString copyWithResult$foundation(boolean cancelSelection) {
        if (!getHasSelection() || isPassword()) {
            return null;
        }
        AnnotatedString selectedText = TextFieldValueKt.getSelectedText(getValue$foundation());
        if (!cancelSelection) {
            return selectedText;
        }
        int iM9088getMaximpl = TextRange.m9088getMaximpl(getValue$foundation().getSelection());
        this.onValueChange.invoke(m2204createTextFieldValueFDrldGo(getValue$foundation().getAnnotatedString(), TextRangeKt.TextRange(iM9088getMaximpl, iM9088getMaximpl)));
        setHandleState(HandleState.None);
        return selectedText;
    }

    public final void paste$foundation(AnnotatedString text) {
        if (getEditable()) {
            AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation(), getValue$foundation().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation(), getValue$foundation().getText().length()));
            int iM9089getMinimpl = TextRange.m9089getMinimpl(getValue$foundation().getSelection()) + text.length();
            this.onValueChange.invoke(m2204createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM9089getMinimpl, iM9089getMinimpl)));
            setHandleState(HandleState.None);
            UndoManager undoManager = this.undoManager;
            if (undoManager != null) {
                undoManager.forceNextSnapshot();
            }
        }
    }

    public final AnnotatedString cutWithResult$foundation() {
        if (!getHasSelection() || !getEditable() || isPassword()) {
            return null;
        }
        AnnotatedString selectedText = TextFieldValueKt.getSelectedText(getValue$foundation());
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation(), getValue$foundation().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation(), getValue$foundation().getText().length()));
        int iM9089getMinimpl = TextRange.m9089getMinimpl(getValue$foundation().getSelection());
        this.onValueChange.invoke(m2204createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM9089getMinimpl, iM9089getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return selectedText;
    }
}
