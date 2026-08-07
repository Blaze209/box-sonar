package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DatePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aE\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aO\u0010\u001f\u001a\u00020\u00032\n\u0010 \u001a\u00060!j\u0002`\"2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$\u001a\u0081\u0001\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b2\u00103\u001a£\u0001\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001a2#\u00107\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b?\u0010@\u001a\u008d\u0001\u0010A\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010B\u001aW\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\bH\u0010I\u001a£\u0001\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\b\u00105\u001a\u0004\u0018\u00010\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010N\u001a\u00020OH\u0003¢\u0006\u0002\u0010P\u001aI\u0010Q\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u0018H\u0080@¢\u0006\u0002\u0010R\u001a\u001d\u0010S\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\u0010T\u001a¢\u0001\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012\u0006\u0010X\u001a\u00020\u00152\b\u0010Y\u001a\u0004\u0018\u00010\u00152\b\u0010Z\u001a\u0004\u0018\u00010\u00152\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010K\u001a\u00020L2\b\u0010N\u001a\u0004\u0018\u00010O2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0001¢\u0006\u0002\u0010]\u001a\u0010\u0010^\u001a\u00020_2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001aL\u0010`\u001a\u00020\u0005*\u00020\u00052\u0006\u0010a\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020L2\u0006\u0010d\u001a\u00020e2\b\u0010N\u001a\u0004\u0018\u00010O2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002\u001a7\u0010f\u001a\u00020\u00012\u0006\u0010V\u001a\u00020_2\u0006\u0010\u0002\u001a\u00020L2\u0006\u0010N\u001a\u00020O2\u0006\u0010g\u001a\u00020h2\u0006\u0010d\u001a\u00020eH\u0002¢\u0006\u0004\bi\u0010j\u001a\u0018\u0010k\u001a\u00020_2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0018\u0010l\u001a\u00020_2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a7\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010o\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010t\u001ac\u0010u\u001a\u00020\u00012\u0006\u0010v\u001a\u00020n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u000f2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020n2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010~\u001a\u008a\u0001\u0010\u007f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00152#\u0010\u0080\u0001\u001a\u001e\u0012\u0014\u0012\u00120_¢\u0006\r\b8\u0012\t\b9\u0012\u0005\b\b(\u0081\u0001\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0007\u0010\u0082\u0001\u001a\u00020\u00112\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0003\u0010\u0085\u0001\u001aV\u0010\u0086\u0001\u001a\u00020\u00012\u0006\u0010v\u001a\u00020n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u000f2\u0007\u0010\u0087\u0001\u001a\u00020\u000f2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020n2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0003\u0010\u0088\u0001\u001a\u0091\u0001\u0010\u0089\u0001\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0007\u0010\u008a\u0001\u001a\u00020\u000f2\u0007\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020n2\u0007\u0010\u008e\u0001\u001a\u00020\u00052\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\r\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0003\u0010\u0094\u0001\u001aC\u0010\u0095\u0001\u001a\u00020\u00012\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0007\u0010\u0096\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0003\u0010\u0097\u0001\u001aD\u0010\u0098\u0001\u001a\u00020\u00012\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010z\u001a\u00020\u000fH\u0003¢\u0006\u0003\u0010\u009c\u0001\u001a\u001f\u0010\u009d\u0001\u001a\u00020\u000f*\u00030\u009e\u00012\u0006\u0010a\u001a\u00020\u000fH\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001\u001a\u001f\u0010¡\u0001\u001a\u00020\u000f*\u00030\u009e\u00012\u0006\u0010a\u001a\u00020\u000fH\u0002¢\u0006\u0006\b¢\u0001\u0010 \u0001\"\u001a\u0010£\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010¦\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u001a\u0010§\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010¦\u0001\u001a\u0006\b¨\u0001\u0010¥\u0001\"\u001a\u0010©\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010¦\u0001\u001a\u0006\bª\u0001\u0010¥\u0001\"\u0018\u0010«\u0001\u001a\u00030¬\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0010\u0010¯\u0001\u001a\u00030¬\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010°\u0001\u001a\u00030¬\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010±\u0001\u001a\u00020*X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¦\u0001\"\u000f\u0010²\u0001\u001a\u00020_X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010³\u0001\u001a\u00020_X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010´\u0001\u001a\u00020\u000f*\u00030\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u001c\u0010·\u0001\u001a\u00020\u000f*\u00030\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010¶\u0001\"\u001c\u0010¹\u0001\u001a\u00020\u000f*\u00030\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010¶\u0001\"\u001c\u0010»\u0001\u001a\u00020\u000f*\u00030\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010¶\u0001¨\u0006½\u0001²\u0006\u000b\u0010\u008c\u0001\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"DatePicker", "", "state", "Landroidx/compose/material3/DatePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDatePickerState", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DateEntryContainer", "modeToggleButton", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "Landroidx/compose/ui/unit/Dp;", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "Lkotlin/Function1;", "DisplayModeToggleButton-iUJLfQg", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "selectedDateMillis", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-KaiTk9E", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", ViewProps.MIN_HEIGHT, "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "onReturnFocus", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/runtime/Composer;II)V", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Ljava/util/Locale;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/focus/FocusManager;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "numberOfMonthsInRange", "", "dayOnKeyEvent", "isRtl", "isFirstDay", "isLastDay", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "goToMonth", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "goToMonth-BhxgA10", "(ILandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/focus/FocusManager;ILkotlinx/coroutines/CoroutineScope;)V", "getFirstEnabledDay", "getLastEnabledDay", "dayContentDescription", "", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Day", "text", "selected", ViewProps.ON_CLICK, "animateChecked", "enabled", "today", "inRange", "description", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "currentYearFocusRequester", "onYearShiftTabPressed", "onYearTabPressed", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "nextButtonModifier", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "onYearPickerButtonTabPressed", "yearSelectionButtonFocusRequester", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonWithTooltip", HubsObservability.HUB_ASSET_ICON, "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "isDirectionBackwards", "Landroidx/compose/ui/input/key/KeyEvent;", "isDirectionBackwards-YhN2O0w", "(Landroid/view/KeyEvent;Z)Z", "isDirectionForward", "isDirectionForward-YhN2O0w", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "()F", "F", "MonthYearHeight", "getMonthYearHeight", "DatePickerHorizontalPadding", "getDatePickerHorizontalPadding", "DatePickerModeTogglePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "DatePickerHeadlinePadding", "YearsVerticalPadding", "MaxCalendarRows", "YearsInRow", "isShiftTab", "isShiftTab-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isTab", "isTab-ZmokQxo", "isDirectionLeft", "isDirectionLeft-ZmokQxo", "isDirectionRight", "isDirectionRight-ZmokQxo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    private static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    private static final float RecommendedSizeForAccessibility = Dp.m9687constructorimpl(48);
    private static final float MonthYearHeight = Dp.m9687constructorimpl(56);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateEntryContainer_au3_HiA$lambda$2(Modifier modifier, Function2 function2, Function2 function3, Function2 function4, DatePickerColors datePickerColors, TextStyle textStyle, float f, Function2 function5, int i, Composer composer, int i2) {
        m3177DateEntryContainerau3_HiA(modifier, function2, function3, function4, datePickerColors, textStyle, f, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$7(DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2 function2, Function2 function3, boolean z, FocusRequester focusRequester, int i, int i2, Composer composer, int i3) {
        DatePicker(datePickerState, modifier, datePickerFormatter, datePickerColors, function2, function3, z, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$6(Long l, long j, Function1 function1, Function1 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        DatePickerContent(l, j, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeader_pc5RIQQ$lambda$1(Modifier modifier, Function2 function2, long j, long j2, float f, Function2 function3, int i, Composer composer, int i2) {
        m3178DatePickerHeaderpc5RIQQ(modifier, function2, j, j2, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Day$lambda$2(String str, Modifier modifier, boolean z, Function0 function0, boolean z2, boolean z3, boolean z4, boolean z5, String str2, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        Day(str, modifier, z, function0, z2, z3, z4, z5, str2, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggleButton_iUJLfQg$lambda$1(Modifier modifier, int i, Function1 function1, DatePickerColors datePickerColors, int i2, Composer composer, int i3) {
        m3181DisplayModeToggleButtoniUJLfQg(modifier, i, function1, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float HorizontalMonthsList$lambda$1$0$0$0() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float HorizontalMonthsList$lambda$1$0$0$1() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMonthsList$lambda$3(LazyListState lazyListState, Long l, Function1 function1, Function1 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Function0 function0, FocusManager focusManager, int i, int i2, Composer composer, int i3) {
        HorizontalMonthsList(lazyListState, l, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, function0, focusManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonWithTooltip$lambda$2(Function0 function0, ImageVector imageVector, String str, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        IconButtonWithTooltip(function0, imageVector, str, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Month$lambda$2(CalendarMonth calendarMonth, Function1 function1, long j, Long l, Long l2, SelectedRangeInfo selectedRangeInfo, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, Locale locale, LazyListState lazyListState, FocusManager focusManager, Function0 function0, int i, int i2, Composer composer, int i3) {
        Month(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, locale, lazyListState, focusManager, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonthsNavigation$lambda$1(Modifier modifier, boolean z, boolean z2, boolean z3, String str, Modifier modifier2, Function0 function0, Function0 function1, Function0 function2, Function0 function3, FocusRequester focusRequester, DatePickerColors datePickerColors, int i, int i2, Composer composer, int i3) {
        MonthsNavigation(modifier, z, z2, z3, str, modifier2, function0, function1, function2, function3, focusRequester, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SwitchableDateEntryContent_KaiTk9E$lambda$2$0$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SwitchableDateEntryContent_KaiTk9E$lambda$2$0$1(int i, int i2) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SwitchableDateEntryContent_KaiTk9E$lambda$2$0$2(int i, int i2) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SwitchableDateEntryContent_KaiTk9E$lambda$2$0$3(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec SwitchableDateEntryContent_KaiTk9E$lambda$2$0$4(FiniteAnimationSpec finiteAnimationSpec, IntSize intSize, IntSize intSize2) {
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$4(Long l, long j, int i, Function1 function1, Function1 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, int i2, int i3, Composer composer, int i4) {
        m3182SwitchableDateEntryContentKaiTk9E(l, j, i, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WeekDays$lambda$1(DatePickerColors datePickerColors, CalendarModel calendarModel, int i, Composer composer, int i2) {
        WeekDays(datePickerColors, calendarModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Year$lambda$3(String str, Modifier modifier, boolean z, boolean z2, Function0 function0, boolean z3, String str2, DatePickerColors datePickerColors, int i, Composer composer, int i2) {
        Year(str, modifier, z, z2, function0, z3, str2, datePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPicker$lambda$2(Modifier modifier, long j, Function1 function1, SelectableDates selectableDates, CalendarModel calendarModel, IntRange intRange, DatePickerColors datePickerColors, FocusRequester focusRequester, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        YearPicker(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, focusRequester, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPickerMenuButton$lambda$1(Function0 function0, boolean z, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        YearPickerMenuButton(function0, z, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$1(DatePickerState datePickerState, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C188@9018L189:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1655706771, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:188)");
            }
            DatePickerDefaults.INSTANCE.m3151DatePickerTitleFNtVw6o(datePickerState.mo3202getDisplayModejFl4v0(), PaddingKt.padding(Modifier.INSTANCE, DatePickerTitlePadding), datePickerColors.getTitleContentColor(), composer, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$2(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C195@9286L300:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1439279037, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
            }
            DatePickerDefaults.INSTANCE.m3150DatePickerHeadlineISIPfiY(datePickerState.getSelectedDateMillis(), datePickerState.mo3202getDisplayModejFl4v0(), datePickerFormatter, PaddingKt.padding(Modifier.INSTANCE, DatePickerHeadlinePadding), datePickerColors.getHeadlineContentColor(), composer, 199680, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x0140  */
    /* JADX WARN: Code duplicated, block: B:111:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x016d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:117:0x017d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0180  */
    /* JADX WARN: Code duplicated, block: B:120:0x0199  */
    /* JADX WARN: Code duplicated, block: B:122:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:124:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:128:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:136:0x020b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0213  */
    /* JADX WARN: Code duplicated, block: B:140:0x0217  */
    /* JADX WARN: Code duplicated, block: B:141:0x021f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0232  */
    /* JADX WARN: Code duplicated, block: B:146:0x0254  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:151:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:154:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void DatePicker(final DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z, FocusRequester focusRequester, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DatePickerColors datePickerColors2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function2RememberComposableLambda2;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        boolean z3;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter2;
        final FocusRequester focusRequester2;
        final Modifier modifier3;
        final DatePickerColors datePickerColors3;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final DatePickerFormatter datePickerFormatter3;
        final DatePickerColors datePickerColorsColors;
        boolean z5;
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function6;
        boolean z6;
        final DatePickerColors datePickerColors4;
        Modifier modifier4;
        int i13;
        FocusRequester focusRequester3;
        Object objRememberedValue;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        CalendarModel calendarModelCreateCalendarModel;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i14;
        boolean zChangedInstance;
        Composer composerStartRestartGroup = composer.startRestartGroup(1105472031);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePicker)N(state,modifier,dateFormatter,colors,title,headline,showModeToggle,focusRequester)207@9735L207,231@10616L5,234@10725L701,214@9947L1479:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i14 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(datePickerFormatter);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(datePickerFormatter);
                    }
                    if (zChangedInstance) {
                        i14 = 256;
                    } else {
                        i14 = 128;
                    }
                }
                i3 |= i14;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    datePickerColors2 = datePickerColors;
                    int i16 = composerStartRestartGroup.changed(datePickerColors2) ? 2048 : 1024;
                    i3 |= i16;
                } else {
                    datePickerColors2 = datePickerColors;
                }
                i3 |= i16;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function2RememberComposableLambda = function2;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function2RememberComposableLambda2 = function3;
                        if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(focusRequester)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter3 = datePickerFormatter;
                                }
                                if ((i2 & 8) != 0) {
                                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    datePickerColorsColors = datePickerColors2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                    i12 = 54;
                                } else {
                                    z5 = true;
                                    i12 = 54;
                                }
                                if (i6 != 0) {
                                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, i12);
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if (i10 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new FocusRequester();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    DatePickerColors datePickerColors5 = datePickerColorsColors;
                                    focusRequester3 = (FocusRequester) objRememberedValue;
                                    z6 = z2;
                                    datePickerColors4 = datePickerColors5;
                                    function6 = function2RememberComposableLambda;
                                    modifier4 = modifier2;
                                    i13 = i3;
                                } else {
                                    function6 = function2RememberComposableLambda;
                                    z6 = z2;
                                    datePickerColors4 = datePickerColorsColors;
                                    modifier4 = modifier2;
                                    i13 = i3;
                                    focusRequester3 = focusRequester;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                datePickerFormatter3 = datePickerFormatter;
                                focusRequester3 = focusRequester;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                                z6 = z2;
                                datePickerColors4 = datePickerColors2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                            }
                            Locale locale = datePickerState.getLocale();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(locale);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                if (datePickerState instanceof BaseDatePickerStateImpl) {
                                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                                } else {
                                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                                }
                                objRememberedValue3 = calendarModelCreateCalendarModel;
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            final CalendarModel calendarModel = (CalendarModel) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (z6) {
                                composerStartRestartGroup.startReplaceGroup(-690563017);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-690175393);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                            }
                            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                            float fM5324getHeaderContainerHeightD9Ej5fM = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                            final FocusRequester focusRequester4 = focusRequester3;
                            final DatePickerColors datePickerColors6 = datePickerColors4;
                            Function2 function7 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel, datePickerFormatter3, datePickerColors6, focusRequester4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                            int i17 = i13 >> 9;
                            composer2 = composerStartRestartGroup;
                            m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value, fM5324getHeaderContainerHeightD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function7, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i17 & 112) | (i17 & 896) | (57344 & (i13 << 3)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            datePickerFormatter2 = datePickerFormatter4;
                            focusRequester2 = focusRequester4;
                            z4 = z6;
                            modifier3 = modifier4;
                            function4 = function6;
                            datePickerColors3 = datePickerColors4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            datePickerFormatter2 = datePickerFormatter;
                            focusRequester2 = focusRequester;
                            modifier3 = modifier2;
                            datePickerColors3 = datePickerColors2;
                            function4 = function2RememberComposableLambda;
                            z4 = z2;
                        }
                        function5 = function2RememberComposableLambda2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z2 = z;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors7 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors7;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors8 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors8;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                        }
                        Locale locale2 = datePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel2 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-690563017);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-690175393);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value2 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM5324getHeaderContainerHeightD9Ej5fM2 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                        final FocusRequester focusRequester5 = focusRequester3;
                        final DatePickerColors datePickerColors9 = datePickerColors4;
                        Function2 function8 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel2, datePickerFormatter3, datePickerColors9, focusRequester5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter5 = datePickerFormatter3;
                        int i18 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value2, fM5324getHeaderContainerHeightD9Ej5fM2, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function8, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i18 & 112) | (i18 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter5;
                        focusRequester2 = focusRequester5;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function2RememberComposableLambda2 = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors10 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors10;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors11 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors11;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                        }
                        Locale locale3 = datePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel3 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-690563017);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-690175393);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value3 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM5324getHeaderContainerHeightD9Ej5fM3 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                        final FocusRequester focusRequester6 = focusRequester3;
                        final DatePickerColors datePickerColors12 = datePickerColors4;
                        Function2 function9 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel3, datePickerFormatter3, datePickerColors12, focusRequester6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter6 = datePickerFormatter3;
                        int i19 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value3, fM5324getHeaderContainerHeightD9Ej5fM3, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function9, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i19 & 112) | (i19 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter6;
                        focusRequester2 = focusRequester6;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors13 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors13;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors14 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors14;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale4 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel4 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value4 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM4 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester7 = focusRequester3;
                    final DatePickerColors datePickerColors15 = datePickerColors4;
                    Function2 function10 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel4, datePickerFormatter3, datePickerColors15, focusRequester7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter7 = datePickerFormatter3;
                    int i110 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value4, fM5324getHeaderContainerHeightD9Ej5fM4, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function10, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i110 & 112) | (i110 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter7;
                    focusRequester2 = focusRequester7;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2RememberComposableLambda = function2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function2RememberComposableLambda2 = function3;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors16 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors16;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors17 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors17;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                        }
                        Locale locale5 = datePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale5);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel5 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-690563017);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-690175393);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value5 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM5324getHeaderContainerHeightD9Ej5fM5 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                        final FocusRequester focusRequester8 = focusRequester3;
                        final DatePickerColors datePickerColors18 = datePickerColors4;
                        Function2 function11 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel5, datePickerFormatter3, datePickerColors18, focusRequester8, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter8 = datePickerFormatter3;
                        int i111 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value5, fM5324getHeaderContainerHeightD9Ej5fM5, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function11, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i111 & 112) | (i111 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter8;
                        focusRequester2 = focusRequester8;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors19 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors19;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors110 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors110;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale6 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale6);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel6 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value6 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM6 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester9 = focusRequester3;
                    final DatePickerColors datePickerColors111 = datePickerColors4;
                    Function2 function12 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel6, datePickerFormatter3, datePickerColors111, focusRequester9, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter9 = datePickerFormatter3;
                    int i112 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value6, fM5324getHeaderContainerHeightD9Ej5fM6, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function12, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i112 & 112) | (i112 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter9;
                    focusRequester2 = focusRequester9;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2RememberComposableLambda2 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors112 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors112;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors113 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors113;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale7 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale7);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel7 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value7 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM7 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester10 = focusRequester3;
                    final DatePickerColors datePickerColors114 = datePickerColors4;
                    Function2 function13 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel7, datePickerFormatter3, datePickerColors114, focusRequester10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter10 = datePickerFormatter3;
                    int i113 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value7, fM5324getHeaderContainerHeightD9Ej5fM7, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function13, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i113 & 112) | (i113 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter10;
                    focusRequester2 = focusRequester10;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors115 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors115;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors116 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors116;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                }
                Locale locale8 = datePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale8);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel8 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-690563017);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-690175393);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value8 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM5324getHeaderContainerHeightD9Ej5fM8 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                final FocusRequester focusRequester11 = focusRequester3;
                final DatePickerColors datePickerColors117 = datePickerColors4;
                Function2 function14 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel8, datePickerFormatter3, datePickerColors117, focusRequester11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter11 = datePickerFormatter3;
                int i114 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value8, fM5324getHeaderContainerHeightD9Ej5fM8, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function14, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i114 & 112) | (i114 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter11;
                focusRequester2 = focusRequester11;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i14 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(datePickerFormatter);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(datePickerFormatter);
                }
                if (zChangedInstance) {
                    i14 = 256;
                } else {
                    i14 = 128;
                }
            }
            i3 |= i14;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                datePickerColors2 = datePickerColors;
                if (composerStartRestartGroup.changed(datePickerColors2)) {
                }
                i3 |= i16;
            } else {
                datePickerColors2 = datePickerColors;
            }
            i3 |= i16;
        } else {
            datePickerColors2 = datePickerColors;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function2RememberComposableLambda = function2;
                if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function2RememberComposableLambda2 = function3;
                    if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(focusRequester)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors118 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors118;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i3 &= -897;
                            } else {
                                datePickerFormatter3 = datePickerFormatter;
                            }
                            if ((i2 & 8) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                datePickerColorsColors = datePickerColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                i12 = 54;
                            } else {
                                z5 = true;
                                i12 = 54;
                            }
                            if (i6 != 0) {
                                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, i12);
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new FocusRequester();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                DatePickerColors datePickerColors119 = datePickerColorsColors;
                                focusRequester3 = (FocusRequester) objRememberedValue;
                                z6 = z2;
                                datePickerColors4 = datePickerColors119;
                                function6 = function2RememberComposableLambda;
                                modifier4 = modifier2;
                                i13 = i3;
                            } else {
                                function6 = function2RememberComposableLambda;
                                z6 = z2;
                                datePickerColors4 = datePickerColorsColors;
                                modifier4 = modifier2;
                                i13 = i3;
                                focusRequester3 = focusRequester;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                        }
                        Locale locale9 = datePickerState.getLocale();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(locale9);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            if (datePickerState instanceof BaseDatePickerStateImpl) {
                                calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                            } else {
                                calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                            }
                            objRememberedValue3 = calendarModelCreateCalendarModel;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final CalendarModel calendarModel9 = (CalendarModel) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-690563017);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-690175393);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                        }
                        TextStyle value9 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                        float fM5324getHeaderContainerHeightD9Ej5fM9 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                        final FocusRequester focusRequester12 = focusRequester3;
                        final DatePickerColors datePickerColors1110 = datePickerColors4;
                        Function2 function15 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel9, datePickerFormatter3, datePickerColors1110, focusRequester12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        DatePickerFormatter datePickerFormatter12 = datePickerFormatter3;
                        int i115 = i13 >> 9;
                        composer2 = composerStartRestartGroup;
                        m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value9, fM5324getHeaderContainerHeightD9Ej5fM9, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function15, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i115 & 112) | (i115 & 896) | (57344 & (i13 << 3)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        datePickerFormatter2 = datePickerFormatter12;
                        focusRequester2 = focusRequester12;
                        z4 = z6;
                        modifier3 = modifier4;
                        function4 = function6;
                        datePickerColors3 = datePickerColors4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        datePickerFormatter2 = datePickerFormatter;
                        focusRequester2 = focusRequester;
                        modifier3 = modifier2;
                        datePickerColors3 = datePickerColors2;
                        function4 = function2RememberComposableLambda;
                        z4 = z2;
                    }
                    function5 = function2RememberComposableLambda2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1111 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1111;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1112 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1112;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale10 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel10 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value10 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM10 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester13 = focusRequester3;
                    final DatePickerColors datePickerColors1113 = datePickerColors4;
                    Function2 function16 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel10, datePickerFormatter3, datePickerColors1113, focusRequester13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter13 = datePickerFormatter3;
                    int i116 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value10, fM5324getHeaderContainerHeightD9Ej5fM10, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function16, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i116 & 112) | (i116 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter13;
                    focusRequester2 = focusRequester13;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2RememberComposableLambda2 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1114 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1114;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors1115 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors1115;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale11 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale11);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel11 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value11 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM11 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester14 = focusRequester3;
                    final DatePickerColors datePickerColors1116 = datePickerColors4;
                    Function2 function17 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel11, datePickerFormatter3, datePickerColors1116, focusRequester14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter14 = datePickerFormatter3;
                    int i117 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value11, fM5324getHeaderContainerHeightD9Ej5fM11, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function17, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i117 & 112) | (i117 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter14;
                    focusRequester2 = focusRequester14;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors1117 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors1117;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors1118 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors1118;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                }
                Locale locale12 = datePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale12);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel12 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-690563017);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-690175393);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value12 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM5324getHeaderContainerHeightD9Ej5fM12 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                final FocusRequester focusRequester15 = focusRequester3;
                final DatePickerColors datePickerColors1119 = datePickerColors4;
                Function2 function18 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel12, datePickerFormatter3, datePickerColors1119, focusRequester15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter15 = datePickerFormatter3;
                int i118 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value12, fM5324getHeaderContainerHeightD9Ej5fM12, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function18, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i118 & 112) | (i118 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter15;
                focusRequester2 = focusRequester15;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2RememberComposableLambda = function2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function2RememberComposableLambda2 = function3;
                if (composerStartRestartGroup.changedInstance(function2RememberComposableLambda2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(focusRequester)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors11110 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors11110;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i3 &= -897;
                        } else {
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        if ((i2 & 8) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            datePickerColorsColors = datePickerColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            i12 = 54;
                        } else {
                            z5 = true;
                            i12 = 54;
                        }
                        if (i6 != 0) {
                            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, i12);
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FocusRequester();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            DatePickerColors datePickerColors11111 = datePickerColorsColors;
                            focusRequester3 = (FocusRequester) objRememberedValue;
                            z6 = z2;
                            datePickerColors4 = datePickerColors11111;
                            function6 = function2RememberComposableLambda;
                            modifier4 = modifier2;
                            i13 = i3;
                        } else {
                            function6 = function2RememberComposableLambda;
                            z6 = z2;
                            datePickerColors4 = datePickerColorsColors;
                            modifier4 = modifier2;
                            i13 = i3;
                            focusRequester3 = focusRequester;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                    }
                    Locale locale13 = datePickerState.getLocale();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale13);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        if (datePickerState instanceof BaseDatePickerStateImpl) {
                            calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                        } else {
                            calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                        }
                        objRememberedValue3 = calendarModelCreateCalendarModel;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CalendarModel calendarModel13 = (CalendarModel) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-690563017);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-690175393);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    TextStyle value13 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                    float fM5324getHeaderContainerHeightD9Ej5fM13 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                    final FocusRequester focusRequester16 = focusRequester3;
                    final DatePickerColors datePickerColors11112 = datePickerColors4;
                    Function2 function19 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel13, datePickerFormatter3, datePickerColors11112, focusRequester16, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    DatePickerFormatter datePickerFormatter16 = datePickerFormatter3;
                    int i119 = i13 >> 9;
                    composer2 = composerStartRestartGroup;
                    m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value13, fM5324getHeaderContainerHeightD9Ej5fM13, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function19, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i119 & 112) | (i119 & 896) | (57344 & (i13 << 3)));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    datePickerFormatter2 = datePickerFormatter16;
                    focusRequester2 = focusRequester16;
                    z4 = z6;
                    modifier3 = modifier4;
                    function4 = function6;
                    datePickerColors3 = datePickerColors4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    datePickerFormatter2 = datePickerFormatter;
                    focusRequester2 = focusRequester;
                    modifier3 = modifier2;
                    datePickerColors3 = datePickerColors2;
                    function4 = function2RememberComposableLambda;
                    z4 = z2;
                }
                function5 = function2RememberComposableLambda2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11113 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11113;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11114 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11114;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                }
                Locale locale14 = datePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale14);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel14 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-690563017);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-690175393);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value14 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM5324getHeaderContainerHeightD9Ej5fM14 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                final FocusRequester focusRequester17 = focusRequester3;
                final DatePickerColors datePickerColors11115 = datePickerColors4;
                Function2 function110 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel14, datePickerFormatter3, datePickerColors11115, focusRequester17, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter17 = datePickerFormatter3;
                int i1110 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value14, fM5324getHeaderContainerHeightD9Ej5fM14, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function110, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1110 & 112) | (i1110 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter17;
                focusRequester2 = focusRequester17;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function2RememberComposableLambda2 = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(focusRequester)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11116 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11116;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -897;
                    } else {
                        datePickerFormatter3 = datePickerFormatter;
                    }
                    if ((i2 & 8) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        datePickerColorsColors = datePickerColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                        function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        i12 = 54;
                    } else {
                        z5 = true;
                        i12 = 54;
                    }
                    if (i6 != 0) {
                        function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, i12);
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        DatePickerColors datePickerColors11117 = datePickerColorsColors;
                        focusRequester3 = (FocusRequester) objRememberedValue;
                        z6 = z2;
                        datePickerColors4 = datePickerColors11117;
                        function6 = function2RememberComposableLambda;
                        modifier4 = modifier2;
                        i13 = i3;
                    } else {
                        function6 = function2RememberComposableLambda;
                        z6 = z2;
                        datePickerColors4 = datePickerColorsColors;
                        modifier4 = modifier2;
                        i13 = i3;
                        focusRequester3 = focusRequester;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
                }
                Locale locale15 = datePickerState.getLocale();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale15);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    if (datePickerState instanceof BaseDatePickerStateImpl) {
                        calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                    } else {
                        calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                    }
                    objRememberedValue3 = calendarModelCreateCalendarModel;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CalendarModel calendarModel15 = (CalendarModel) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-690563017);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-690175393);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                TextStyle value15 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
                float fM5324getHeaderContainerHeightD9Ej5fM15 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
                final FocusRequester focusRequester18 = focusRequester3;
                final DatePickerColors datePickerColors11118 = datePickerColors4;
                Function2 function111 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel15, datePickerFormatter3, datePickerColors11118, focusRequester18, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                DatePickerFormatter datePickerFormatter18 = datePickerFormatter3;
                int i1111 = i13 >> 9;
                composer2 = composerStartRestartGroup;
                m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value15, fM5324getHeaderContainerHeightD9Ej5fM15, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function111, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1111 & 112) | (i1111 & 896) | (57344 & (i13 << 3)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                datePickerFormatter2 = datePickerFormatter18;
                focusRequester2 = focusRequester18;
                z4 = z6;
                modifier3 = modifier4;
                function4 = function6;
                datePickerColors3 = datePickerColors4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                datePickerFormatter2 = datePickerFormatter;
                focusRequester2 = focusRequester;
                modifier3 = modifier2;
                datePickerColors3 = datePickerColors2;
                function4 = function2RememberComposableLambda;
                z4 = z2;
            }
            function5 = function2RememberComposableLambda2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z2 = z;
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(focusRequester)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "185@8841L47,186@8940L8,187@8989L224,194@9257L335,204@9668L29");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                } else {
                    datePickerFormatter3 = datePickerFormatter;
                }
                if ((i2 & 8) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    datePickerColorsColors = datePickerColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i12 = 54;
                } else {
                    z5 = true;
                    i12 = 54;
                }
                if (i6 != 0) {
                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, i12);
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    DatePickerColors datePickerColors11119 = datePickerColorsColors;
                    focusRequester3 = (FocusRequester) objRememberedValue;
                    z6 = z2;
                    datePickerColors4 = datePickerColors11119;
                    function6 = function2RememberComposableLambda;
                    modifier4 = modifier2;
                    i13 = i3;
                } else {
                    function6 = function2RememberComposableLambda;
                    z6 = z2;
                    datePickerColors4 = datePickerColorsColors;
                    modifier4 = modifier2;
                    i13 = i3;
                    focusRequester3 = focusRequester;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501703566, "CC(remember):DatePicker.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    datePickerFormatter3 = (DatePickerFormatter) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -897;
                } else {
                    datePickerFormatter3 = datePickerFormatter;
                }
                if ((i2 & 8) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    datePickerColorsColors = datePickerColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                    function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$1(datePickerState, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    i12 = 54;
                } else {
                    z5 = true;
                    i12 = 54;
                }
                if (i6 != 0) {
                    function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1439279037, z5, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.DatePicker$lambda$2(datePickerState, datePickerFormatter3, datePickerColorsColors, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, i12);
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501730012, "CC(remember):DatePicker.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    DatePickerColors datePickerColors111110 = datePickerColorsColors;
                    focusRequester3 = (FocusRequester) objRememberedValue;
                    z6 = z2;
                    datePickerColors4 = datePickerColors111110;
                    function6 = function2RememberComposableLambda;
                    modifier4 = modifier2;
                    i13 = i3;
                } else {
                    function6 = function2RememberComposableLambda;
                    z6 = z2;
                    datePickerColors4 = datePickerColorsColors;
                    modifier4 = modifier2;
                    i13 = i3;
                    focusRequester3 = focusRequester;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105472031, i13, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:205)");
            }
            Locale locale16 = datePickerState.getLocale();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1501732334, "CC(remember):DatePicker.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(locale16);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                if (datePickerState instanceof BaseDatePickerStateImpl) {
                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                } else {
                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                }
                objRememberedValue3 = calendarModelCreateCalendarModel;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                if (datePickerState instanceof BaseDatePickerStateImpl) {
                    calendarModelCreateCalendarModel = ((BaseDatePickerStateImpl) datePickerState).getCalendarModel();
                } else {
                    calendarModelCreateCalendarModel = CalendarModel_androidKt.createCalendarModel(datePickerState.getLocale());
                }
                objRememberedValue3 = calendarModelCreateCalendarModel;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final CalendarModel calendarModel16 = (CalendarModel) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(-690563017);
                ComposerKt.sourceInformation(composerStartRestartGroup, "220@10125L364");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePicker$lambda$5(datePickerState, datePickerColors4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-690175393);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            }
            TextStyle value16 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont(), composerStartRestartGroup, 6);
            float fM5324getHeaderContainerHeightD9Ej5fM16 = DatePickerModalTokens.INSTANCE.m5324getHeaderContainerHeightD9Ej5fM();
            final FocusRequester focusRequester19 = focusRequester3;
            final DatePickerColors datePickerColors111111 = datePickerColors4;
            Function2 function112 = new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePicker$lambda$6(datePickerState, calendarModel16, datePickerFormatter3, datePickerColors111111, focusRequester19, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            DatePickerFormatter datePickerFormatter19 = datePickerFormatter3;
            int i1112 = i13 >> 9;
            composer2 = composerStartRestartGroup;
            m3177DateEntryContainerau3_HiA(modifier4, function6, function2RememberComposableLambda2, composableLambdaRememberComposableLambda, datePickerColors4, value16, fM5324getHeaderContainerHeightD9Ej5fM16, ComposableLambdaKt.rememberComposableLambda(-1346903698, true, function112, composerStartRestartGroup, 54), composer2, ((i13 >> 3) & 14) | 14155776 | (i1112 & 112) | (i1112 & 896) | (57344 & (i13 << 3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            datePickerFormatter2 = datePickerFormatter19;
            focusRequester2 = focusRequester19;
            z4 = z6;
            modifier3 = modifier4;
            function4 = function6;
            datePickerColors3 = datePickerColors4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            datePickerFormatter2 = datePickerFormatter;
            focusRequester2 = focusRequester;
            modifier3 = modifier2;
            datePickerColors3 = datePickerColors2;
            function4 = function2RememberComposableLambda;
            z4 = z2;
        }
        function5 = function2RememberComposableLambda2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePicker$lambda$7(datePickerState, modifier3, datePickerFormatter2, datePickerColors3, function4, function5, z4, focusRequester2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$5(final DatePickerState datePickerState, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C224@10357L50,221@10147L324:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1483431603, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:221)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, DatePickerModeTogglePadding);
            int iMo3202getDisplayModejFl4v0 = datePickerState.mo3202getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, 351379263, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(datePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.DatePicker$lambda$5$0$0(datePickerState, (DisplayMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3181DisplayModeToggleButtoniUJLfQg(modifierPadding, iMo3202getDisplayModejFl4v0, (Function1) objRememberedValue, datePickerColors, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$5$0$0(DatePickerState datePickerState, DisplayMode displayMode) {
        datePickerState.mo3203setDisplayModevCnGnXg(displayMode.getValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$6(final DatePickerState datePickerState, CalendarModel calendarModel, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, FocusRequester focusRequester, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C239@10966L59,240@11064L91,235@10735L685:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1346903698, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:235)");
            }
            Long selectedDateMillis = datePickerState.getSelectedDateMillis();
            long displayedMonthMillis = datePickerState.getDisplayedMonthMillis();
            int iMo3202getDisplayModejFl4v0 = datePickerState.mo3202getDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composer, -1589289911, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(datePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.DatePicker$lambda$6$0$0(datePickerState, (Long) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1589286743, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(datePickerState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.DatePicker$lambda$6$1$0(datePickerState, ((Long) obj).longValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3182SwitchableDateEntryContentKaiTk9E(selectedDateMillis, displayedMonthMillis, iMo3202getDisplayModejFl4v0, function1, (Function1) objRememberedValue2, calendarModel, datePickerState.getYearRange(), datePickerFormatter, datePickerState.getSelectableDates(), datePickerColors, focusRequester, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$6$0$0(DatePickerState datePickerState, Long l) {
        datePickerState.setSelectedDateMillis(l);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePicker$lambda$6$1$0(DatePickerState datePickerState, long j) {
        datePickerState.setDisplayedMonthMillis(j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m3195rememberDatePickerStateEU0dCGE(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 2065763010, "C(rememberDatePickerState)N(initialSelectedDateMillis,initialDisplayedMonthMillis,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)389@16675L15,390@16779L384,390@16702L461:DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            l = null;
        }
        final Long l3 = l;
        final Long l4 = (i3 & 2) != 0 ? l3 : l2;
        final IntRange yearRange = (i3 & 4) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int iM3277getPickerjFl4v0 = (i3 & 8) != 0 ? DisplayMode.INSTANCE.m3277getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 16) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:388)");
        }
        final Locale localeDefaultLocale = CalendarLocale_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.INSTANCE.Saver(allDates, localeDefaultLocale);
        ComposerKt.sourceInformationMarkerStart(composer, 923378690, "CC(remember):DatePicker.kt#9igjgp");
        boolean z = true;
        boolean zChangedInstance = ((((i2 & 14) ^ 6) > 4 && composer.changed(l3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(l4)) || (i2 & 48) == 32) | composer.changedInstance(yearRange) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(iM3277getPickerjFl4v0)) || (i2 & 3072) == 2048);
        if ((((57344 & i2) ^ 24576) <= 16384 || !composer.changed(allDates)) && (i2 & 24576) != 16384) {
            z = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z | composer.changedInstance(localeDefaultLocale);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatePickerKt.rememberDatePickerState_EU0dCGE$lambda$0$0(l3, l4, yearRange, iM3277getPickerjFl4v0, allDates, localeDefaultLocale);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        datePickerStateImpl.setSelectableDates(allDates);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DatePickerStateImpl rememberDatePickerState_EU0dCGE$lambda$0$0(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m3180DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = l;
        }
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 16) != 0) {
            i = DisplayMode.INSTANCE.m3277getPickerjFl4v0();
        }
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        SelectableDates selectableDates2 = selectableDates;
        IntRange intRange2 = intRange;
        return m3179DatePickerStatesHin3Bw(locale, l, l2, intRange2, i, selectableDates2);
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m3179DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m3177DateEntryContainerau3_HiA(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function5, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Function2<? super Composer, ? super Integer, Unit> function8;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1539132883);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateEntryContainer)N(modifier,title,headline,modeToggleButton,colors,headlineTextStyle,headerMinHeight:c#ui.unit.Dp,content)1371@64166L236,1367@64018L1910:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function6 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function6) ? 32 : 16;
        } else {
            function6 = function2;
        }
        if ((i & 384) == 0) {
            function7 = function3;
            i2 |= composerStartRestartGroup.changedInstance(function7) ? 256 : 128;
        } else {
            function7 = function3;
        }
        if ((i & 3072) == 0) {
            function8 = function4;
            i2 |= composerStartRestartGroup.changedInstance(function8) ? 2048 : 1024;
        } else {
            function8 = function4;
        }
        if ((i & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? 16384 : 8192;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i) == 0) {
            textStyle2 = textStyle;
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1539132883, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1366)");
            }
            int i3 = i2;
            Modifier modifierM1270sizeInqDBjuR0$default = SizeKt.m1270sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m5318getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1637965631, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.DateEntryContainer_au3_HiA$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SemanticsModifierKt.semantics$default(modifierM1270sizeInqDBjuR0$default, false, (Function1) objRememberedValue, 1, null), datePickerColors2.getContainerColor(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1831145178, "C1385@64721L1183,1379@64470L1434,1411@65913L9:DatePicker.kt#uh7d8r");
            final Function2<? super Composer, ? super Integer, Unit> function9 = function6;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function7;
            final Function2<? super Composer, ? super Integer, Unit> function11 = function8;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final TextStyle textStyle3 = textStyle2;
            m3178DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, function2, datePickerColors2.getTitleContentColor(), datePickerColors2.getHeadlineContentColor(), f, ComposableLambdaKt.rememberComposableLambda(-1658370654, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DateEntryContainer_au3_HiA$lambda$1$0(function10, function11, function9, datePickerColors3, textStyle3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 196614 | (57344 & (i3 >> 6)));
            composer2 = composerStartRestartGroup;
            function5.invoke(composer2, Integer.valueOf((i3 >> 21) & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DateEntryContainer_au3_HiA$lambda$2(modifier, function2, function3, function4, datePickerColors, textStyle, f, function5, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateEntryContainer_au3_HiA$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateEntryContainer_au3_HiA$lambda$1$0(final Function2 function2, Function2 function3, Function2 function4, DatePickerColors datePickerColors, TextStyle textStyle, Composer composer, int i) {
        Arrangement.HorizontalOrVertical end;
        ComposerKt.sourceInformation(composer, "C1386@64735L1159:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1658370654, i, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1386)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -251319653, "C1393@65096L521:DatePicker.kt#uh7d8r");
            if (function2 != null && function3 != null) {
                end = Arrangement.INSTANCE.getSpaceBetween();
            } else if (function2 != null) {
                end = Arrangement.INSTANCE.getStart();
            } else {
                end = Arrangement.INSTANCE.getEnd();
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -516047984, "C:DatePicker.kt#uh7d8r");
            if (function2 == null) {
                composer.startReplaceGroup(-580866598);
            } else {
                composer.startReplaceGroup(-516028300);
                ComposerKt.sourceInformation(composer, "1399@65424L106,1399@65380L150");
                TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.rememberComposableLambda(-738208900, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DateEntryContainer_au3_HiA$lambda$1$0$0$0$0(rowScopeInstance, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 48);
            }
            composer.endReplaceGroup();
            if (function3 == null) {
                composer.startReplaceGroup(-515799087);
            } else {
                composer.startReplaceGroup(260455984);
                ComposerKt.sourceInformation(composer, "1403@65591L8");
                function3.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function4 == null && function2 == null && function3 == null) {
                composer.startReplaceGroup(-315631882);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-250360576);
                ComposerKt.sourceInformation(composer, "1407@65816L46");
                DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors.getDividerColor(), composer, 0, 3);
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
    public static final Unit DateEntryContainer_au3_HiA$lambda$1$0$0$0$0(RowScope rowScope, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1400@65454L50:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-738208900, i, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1400)");
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1330662525, "C1400@65492L10:DatePicker.kt#uh7d8r");
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

    /* JADX INFO: renamed from: DisplayModeToggleButton-iUJLfQg, reason: not valid java name */
    public static final void m3181DisplayModeToggleButtoniUJLfQg(final Modifier modifier, final int i, final Function1<? super DisplayMode, Unit> function1, final DatePickerColors datePickerColors, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1461252485);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplayModeToggleButton)N(modifier,displayMode:c#material3.DisplayMode,onDisplayModeChange,colors)1422@66203L658,1422@66122L739:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1461252485, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1421)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(datePickerColors.getHeadlineContentColor())), ComposableLambdaKt.rememberComposableLambda(-1734512197, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DisplayModeToggleButton_iUJLfQg$lambda$0(i, function1, modifier, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DisplayModeToggleButton_iUJLfQg$lambda$1(modifier, i, function1, datePickerColors, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggleButton_iUJLfQg$lambda$0(int i, final Function1 function1, Modifier modifier, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1734512197, i2, -1, "androidx.compose.material3.DisplayModeToggleButton.<anonymous> (DatePicker.kt:1423)");
            }
            if (DisplayMode.m3272equalsimpl0(i, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
                composer.startReplaceGroup(-101251783);
                ComposerKt.sourceInformation(composer, "1428@66475L46,1425@66315L42,1424@66266L270");
                ImageVector edit$material3 = Icons.Filled.INSTANCE.getEdit$material3();
                Strings.Companion companion = Strings.INSTANCE;
                String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_input_mode), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -418906843, "CC(remember):DatePicker.kt#9igjgp");
                boolean zChanged = composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DatePickerKt.DisplayModeToggleButton_iUJLfQg$lambda$0$0$0(function1);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                IconButtonWithTooltip((Function0) objRememberedValue, edit$material3, strM5086getString2EP1pXo, modifier, false, composer, 0, 16);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-100953904);
                ComposerKt.sourceInformation(composer, "1435@66781L49,1432@66615L43,1431@66566L279");
                ImageVector dateRange$material3 = Icons.Filled.INSTANCE.getDateRange$material3();
                Strings.Companion companion2 = Strings.INSTANCE;
                String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_calendar_mode), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -418897242, "CC(remember):DatePicker.kt#9igjgp");
                boolean zChanged2 = composer.changed(function1);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DatePickerKt.DisplayModeToggleButton_iUJLfQg$lambda$0$1$0(function1);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                IconButtonWithTooltip((Function0) objRememberedValue2, dateRange$material3, strM5086getString2EP1pXo2, modifier, false, composer, 0, 16);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggleButton_iUJLfQg$lambda$0$0$0(Function1 function1) {
        function1.invoke(DisplayMode.m3269boximpl(DisplayMode.INSTANCE.m3276getInputjFl4v0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeToggleButton_iUJLfQg$lambda$0$1$0(Function1 function1) {
        function1.invoke(DisplayMode.m3269boximpl(DisplayMode.INSTANCE.m3277getPickerjFl4v0()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SwitchableDateEntryContent-KaiTk9E, reason: not valid java name */
    private static final void m3182SwitchableDateEntryContentKaiTk9E(final Long l, final long j, final int i, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusRequester focusRequester, Composer composer, final int i2, final int i3) {
        int i4;
        IntRange intRange2;
        SelectableDates selectableDates2;
        int i5;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2053685029);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchableDateEntryContent)N(selectedDateMillis,displayedMonthMillis,displayMode:c#material3.DisplayMode,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)1461@67649L7,1464@67859L7,1466@67971L7,1468@68092L7,1470@68210L7,1474@68324L216,1480@68567L1708,1512@70333L1136,1471@68222L3247:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            intRange2 = intRange;
            i4 |= composerStartRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        } else {
            intRange2 = intRange;
        }
        if ((12582912 & i2) == 0) {
            i4 |= (16777216 & i2) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            selectableDates2 = selectableDates;
            i4 |= composerStartRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(datePickerColors) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (composerStartRestartGroup.changed(focusRequester) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 3) == 2) ? false : true, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2053685029, i4, i5, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1458)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final int i6 = -((Density) objConsume).mo748roundToPx0680j_4(Dp.m9687constructorimpl(48));
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            int i7 = i4;
            final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            DisplayMode displayModeM3269boximpl = DisplayMode.m3269boximpl(i);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093685331, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093694599, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changed(i6) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0(finiteAnimationSpecValue3, finiteAnimationSpecValue, finiteAnimationSpecValue2, i6, finiteAnimationSpecValue4, (AnimatedContentTransitionScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final IntRange intRange3 = intRange2;
            final SelectableDates selectableDates3 = selectableDates2;
            composer2 = composerStartRestartGroup;
            AnimatedContentKt.AnimatedContent(displayModeM3269boximpl, modifierSemantics$default, (Function1) objRememberedValue2, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.rememberComposableLambda(1838500091, true, new Function4() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$3(l, j, function1, function2, calendarModel, intRange3, datePickerFormatter, selectableDates3, datePickerColors, focusRequester, (AnimatedContentScope) obj, (DisplayMode) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i7 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$4(l, j, i, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ContentTransform SwitchableDateEntryContent_KaiTk9E$lambda$2$0(FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3, final int i, final FiniteAnimationSpec finiteAnimationSpec4, AnimatedContentTransitionScope animatedContentTransitionScope) {
        ContentTransform contentTransform;
        if (DisplayMode.m3272equalsimpl0(((DisplayMode) animatedContentTransitionScope.getTargetState()).getValue(), DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0$0(((Integer) obj).intValue()));
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, 0.0f, 2, null)), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec3, 0.0f, 2, null).plus(EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0$1(i, ((Integer) obj).intValue()));
                }
            })));
        } else {
            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0$2(i, ((Integer) obj).intValue()));
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, 0.0f, 2, null)), EnterExitTransitionKt.slideOutVertically(finiteAnimationSpec, new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0$3(((Integer) obj).intValue()));
                }
            }).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec3, 0.0f, 2, null)));
        }
        return animatedContentTransitionScope.using(contentTransform, AnimatedContentKt.SizeTransform(true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DatePickerKt.SwitchableDateEntryContent_KaiTk9E$lambda$2$0$4(finiteAnimationSpec4, (IntSize) obj, (IntSize) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$3(Long l, long j, Function1 function1, Function1 function2, CalendarModel calendarModel, IntRange intRange, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, FocusRequester focusRequester, AnimatedContentScope animatedContentScope, DisplayMode displayMode, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(mode:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838500091, i, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1513)");
        }
        int value = displayMode.getValue();
        if (DisplayMode.m3272equalsimpl0(value, DisplayMode.INSTANCE.m3277getPickerjFl4v0())) {
            composer.startReplaceGroup(1567031954);
            ComposerKt.sourceInformation(composer, "1515@70415L535");
            DatePickerContent(l, j, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (DisplayMode.m3272equalsimpl0(value, DisplayMode.INSTANCE.m3276getInputjFl4v0())) {
                composer.startReplaceGroup(1567050592);
                ComposerKt.sourceInformation(composer, "1527@71000L453");
                DateInputKt.DateInputContent(l, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, focusRequester, composer, 0);
            } else {
                composer.startReplaceGroup(1263481063);
            }
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void DatePickerContent(final Long l, final long j, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-434467002);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerContent)N(selectedDateMillis,displayedMonthMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors)1555@72034L64,1558@72188L466,1558@72161L493,1570@72681L24,1571@72752L25,1571@72735L42,1572@72819L7,1578@72990L40,1579@73035L8737:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434467002, i2, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1552)");
            }
            final CalendarMonth month = calendarModel.getMonth(j);
            int iCoerceAtLeast = RangesKt.coerceAtLeast(month.indexIn(intRange), 0);
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(iCoerceAtLeast, 0, composerStartRestartGroup, 0, 2);
            Integer numValueOf = Integer.valueOf(iCoerceAtLeast);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -910938504, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(iCoerceAtLeast);
            DatePickerKt$DatePickerContent$1$1 datePickerKt$DatePickerContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || datePickerKt$DatePickerContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerKt$DatePickerContent$1$1RememberedValue = new DatePickerKt$DatePickerContent$1$1(lazyListStateRememberLazyListState, iCoerceAtLeast, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$DatePickerContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$DatePickerContent$1$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -910920897, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda63
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$1$0();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -910913266, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = FocusRequester.INSTANCE.createRefs();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            FocusRequester.Companion.FocusRequesterFactory focusRequesterFactory = (FocusRequester.Companion.FocusRequesterFactory) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusRequester focusRequesterComponent1 = focusRequesterFactory.component1();
            final FocusRequester focusRequesterComponent2 = focusRequesterFactory.component2();
            final FocusRequester focusRequesterComponent3 = focusRequesterFactory.component3();
            final FocusRequester focusRequesterComponent4 = focusRequesterFactory.component4();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -520181143, "C1591@73654L511,1603@74199L520,1615@74761L42,1616@74848L448,1580@73052L2367,1629@75429L6337:DatePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f = DatePickerHorizontalPadding;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            boolean canScrollForward = lazyListStateRememberLazyListState.getCanScrollForward();
            boolean canScrollBackward = lazyListStateRememberLazyListState.getCanScrollBackward();
            boolean zDatePickerContent$lambda$2 = DatePickerContent$lambda$2(mutableState);
            String monthYear = datePickerFormatter.formatMonthYear(Long.valueOf(j), calendarModel.getLocale());
            if (monthYear == null) {
                monthYear = CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
            }
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequesterComponent1);
            String str = monthYear;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125147633, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$5$0$0(coroutineScope, lazyListStateRememberLazyListState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125130184, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$5$1$0(coroutineScope, lazyListStateRememberLazyListState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function3 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125112678, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$5$2$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function4 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1125109488, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(focusRequesterComponent3) | composerStartRestartGroup.changedInstance(focusManager);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda68
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$5$3$0(focusRequesterComponent3, focusManager);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MonthsNavigation(modifierM1220paddingVpY3zN4$default, canScrollForward, canScrollBackward, zDatePickerContent$lambda$2, str, modifierFocusRequester, function0, function3, function4, (Function0) objRememberedValue7, focusRequesterComponent2, datePickerColors, composerStartRestartGroup, 6, (i3 >> 21) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1335167820, "C1630@75447L814,1648@76461L7,1650@76586L7,1652@76721L7,1662@77271L4485,1653@76768L4988:DatePicker.kt#uh7d8r");
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1070158191, "C1631@75543L31,1642@76136L43,1632@75591L656:DatePicker.kt#uh7d8r");
            WeekDays(datePickerColors, calendarModel, composerStartRestartGroup, ((i3 >> 24) & 14) | ((i3 >> 9) & 112));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 173086879, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(focusRequesterComponent1);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda69
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.DatePickerContent$lambda$5$4$0$0$0(focusRequesterComponent1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            HorizontalMonthsList(lazyListStateRememberLazyListState, l, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, (Function0) objRememberedValue8, focusManager, composerStartRestartGroup, ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (i3 & 234881024), 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$2(mutableState), ClipKt.clipToBounds(Modifier.INSTANCE), EnterExitTransitionKt.expandVertically$default(finiteAnimationSpecValue3, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn(finiteAnimationSpecValue, 0.6f)), EnterExitTransitionKt.shrinkVertically$default(finiteAnimationSpecValue3, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpecValue2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1193716082, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerKt.DatePickerContent$lambda$5$4$1(j, mutableState, coroutineScope, lazyListStateRememberLazyListState, intRange, month, selectableDates, calendarModel, datePickerColors, focusRequesterComponent3, focusRequesterComponent2, focusRequesterComponent4, focusManager, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196656, 16);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda71
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePickerContent$lambda$6(l, j, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState DatePickerContent$lambda$1$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    private static final boolean DatePickerContent$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DatePickerContent$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$0$0(CoroutineScope coroutineScope, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$3$1$1$1(lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$1$0(CoroutineScope coroutineScope, LazyListState lazyListState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$3$2$1$1(lazyListState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$2$0(MutableState mutableState) {
        DatePickerContent$lambda$3(mutableState, !DatePickerContent$lambda$2(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$3$0(FocusRequester focusRequester, FocusManager focusManager) {
        if (!FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null)) {
            focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6448getDowndhqQ8s());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$0$0$0(FocusRequester focusRequester) {
        FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$1(long j, final MutableState mutableState, final CoroutineScope coroutineScope, final LazyListState lazyListState, final IntRange intRange, final CalendarMonth calendarMonth, SelectableDates selectableDates, CalendarModel calendarModel, DatePickerColors datePickerColors, FocusRequester focusRequester, final FocusRequester focusRequester2, final FocusRequester focusRequester3, final FocusManager focusManager, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1667@77595L48,1668@77697L30,1668@77660L4082:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193716082, i, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1667)");
        }
        Strings.Companion companion = Strings.INSTANCE;
        final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_year_picker_pane_title), composer, 0);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 404900432, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged = composer.changed(strM5086getString2EP1pXo);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DatePickerKt.DatePickerContent$lambda$5$4$1$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) objRememberedValue, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 872727202, "C1680@78471L767,1697@79569L205,1701@79819L255,1669@77751L2346,1715@80726L928,1711@80500L1224:DatePicker.kt#uh7d8r");
        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1255requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(Dp.m9687constructorimpl(RecommendedSizeForAccessibility * 7) - DividerDefaults.INSTANCE.m3278getThicknessD9Ej5fM())), DatePickerHorizontalPadding, 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, -1357300997, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged2 = composer.changed(mutableState) | composer.changedInstance(coroutineScope) | composer.changed(lazyListState) | composer.changedInstance(intRange) | composer.changed(calendarMonth);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda60
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return DatePickerKt.DatePickerContent$lambda$5$4$1$1$0$0(coroutineScope, mutableState, lazyListState, intRange, calendarMonth, ((Integer) obj2).intValue());
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        Function1 function1 = (Function1) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1357266423, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged3 = composer.changed(focusRequester2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatePickerKt.DatePickerContent$lambda$5$4$1$1$1$0(focusRequester2);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function0 = (Function0) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1357258373, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChanged4 = composer.changed(focusRequester3) | composer.changedInstance(focusManager);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DatePickerKt.DatePickerContent$lambda$5$4$1$1$2$0(focusRequester3, focusManager);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        YearPicker(modifierM1220paddingVpY3zN4$default, j, function1, selectableDates, calendarModel, intRange, datePickerColors, focusRequester, function0, (Function0) objRememberedValue4, composer, 6);
        long dividerColor = datePickerColors.getDividerColor();
        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester3);
        ComposerKt.sourceInformationMarkerStart(composer, -1357228676, "CC(remember):DatePicker.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(focusManager);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$3$5$2$2$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3196invokeZmokQxo(keyEvent.m7966unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3196invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    if (Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7747getDirectionUpEK5gGoQ()) || (KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()))) {
                        focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6453getPreviousdhqQ8s());
                        return true;
                    }
                    if (Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ())) {
                        focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6452getNextdhqQ8s());
                        return true;
                    }
                    return false;
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DividerKt.m3284HorizontalDivider9IZ8Weo(FocusModifierKt.focusTarget(KeyInputModifierKt.onKeyEvent(modifierFocusRequester, (Function1) objRememberedValue5)), 0.0f, dividerColor, composer, 0, 2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$1$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$1$1$0$0(CoroutineScope coroutineScope, MutableState mutableState, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth, int i) {
        DatePickerContent$lambda$3(mutableState, !DatePickerContent$lambda$2(mutableState));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$DatePickerContent$3$5$2$2$1$1$1(lazyListState, i, intRange, calendarMonth, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$1$1$1$0(FocusRequester focusRequester) {
        FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerContent$lambda$5$4$1$1$2$0(FocusRequester focusRequester, FocusManager focusManager) {
        FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6452getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m3178DatePickerHeaderpc5RIQQ(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final long j2, final float f, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionM1251defaultMinSizeVpY3zN4$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(2020490761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerHeader)N(modifier,title,titleContentColor:c#ui.graphics.Color,headlineContentColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,content)1754@82232L540:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2020490761, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1746)");
            }
            if (function2 != null) {
                companionM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null);
            } else {
                companionM1251defaultMinSizeVpY3zN4$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(companionM1251defaultMinSizeVpY3zN4$default);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 396879060, "C1764@82674L92:DatePicker.kt#uh7d8r");
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(315158595);
            } else {
                composerStartRestartGroup.startReplaceGroup(396894187);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1759@82462L5,1760@82566L89,1760@82480L175");
                ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1344395458, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.DatePickerHeader_pc5RIQQ$lambda$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 6) & 14) | 384);
            }
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j2)), function3, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 12) & 112));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.DatePickerHeader_pc5RIQQ$lambda$1(modifier, function2, j, j2, f, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerHeader_pc5RIQQ$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1761@82584L57:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1344395458, i, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1761)");
            }
            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 562743380, "C1761@82632L7:DatePicker.kt#uh7d8r");
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

    private static final void HorizontalMonthsList(final LazyListState lazyListState, final Long l, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function2, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final Function0<Unit> function0, final FocusManager focusManager, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super Long, Unit> function3;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        int i4;
        final LazyListState lazyListState2;
        DatePickerKt$HorizontalMonthsList$2$1 datePickerKt$HorizontalMonthsList$2$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1038629066);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalMonthsList)N(lazyListState,selectedDateMillis,onDateSelectionChange,onDisplayedMonthChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,onReturnFocus,focusManager)1785@83356L159,1791@83577L5,1791@83584L1585,1791@83520L1649,1826@85205L229,1826@85175L259:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(lazyListState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(l) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function3 = function1;
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(datePickerFormatter) : composerStartRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            selectableDates2 = selectableDates;
            i3 |= composerStartRestartGroup.changed(selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i3 |= composerStartRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(focusManager) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            lazyListState2 = lazyListState;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038629066, i3, i4, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1782)");
            }
            final CalendarDate today = calendarModel.getToday();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1690103403, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(intRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = calendarModel.getMonth(intRange.getFirst(), 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final DatePickerColors datePickerColors3 = datePickerColors2;
            int i5 = i3;
            final Function1<? super Long, Unit> function4 = function3;
            final SelectableDates selectableDates3 = selectableDates2;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-1911156825, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.HorizontalMonthsList$lambda$1(lazyListState, intRange, calendarModel, calendarMonth, function4, today, l, datePickerFormatter, selectableDates3, datePickerColors3, focusManager, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1690044165, "CC(remember):DatePicker.kt#9igjgp");
            int i6 = i5 & 14;
            boolean zChangedInstance = (i6 == 4) | ((i5 & 7168) == 2048) | composerStartRestartGroup.changedInstance(calendarModel) | composerStartRestartGroup.changedInstance(intRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, function2, calendarModel, intRange, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$HorizontalMonthsList$2$1);
            } else {
                datePickerKt$HorizontalMonthsList$2$1 = objRememberedValue2;
                lazyListState2 = lazyListState;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$HorizontalMonthsList$2$1, composerStartRestartGroup, i6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.HorizontalMonthsList$lambda$3(lazyListState2, l, function1, function2, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, function0, focusManager, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMonthsList$lambda$1(final LazyListState lazyListState, final IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final Function1 function1, final CalendarDate calendarDate, final Long l, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final FocusManager focusManager, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1797@83903L118,1801@84105L40,1802@84157L1006,1792@83594L1569:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1911156825, i, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1792)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1624304189, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.HorizontalMonthsList$lambda$1$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            FlingBehavior flingBehaviorRememberSnapFlingBehavior$material3 = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3(lazyListState, null, composer, 384, 2);
            ComposerKt.sourceInformationMarkerStart(composer, 1624313205, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(intRange) | composer.changedInstance(calendarModel) | composer.changed(calendarMonth) | composer.changed(function1) | composer.changed(calendarDate) | composer.changed(l) | composer.changedInstance(datePickerFormatter) | composer.changed(selectableDates) | composer.changed(datePickerColors) | composer.changed(lazyListState) | composer.changedInstance(focusManager) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.HorizontalMonthsList$lambda$1$1$0(intRange, calendarModel, calendarMonth, function1, calendarDate, l, datePickerFormatter, selectableDates, datePickerColors, lazyListState, focusManager, function0, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(function2);
                objRememberedValue2 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyRow(modifierSemantics$default, lazyListState, null, false, null, null, flingBehaviorRememberSnapFlingBehavior$material3, false, null, (Function1) objRememberedValue2, composer, 0, 444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMonthsList$lambda$1$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(DatePickerKt.HorizontalMonthsList$lambda$1$0$0$0());
            }
        }, new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(DatePickerKt.HorizontalMonthsList$lambda$1$0$0$1());
            }
        }, false, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMonthsList$lambda$1$1$0(IntRange intRange, final CalendarModel calendarModel, final CalendarMonth calendarMonth, final Function1 function1, final CalendarDate calendarDate, final Long l, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final LazyListState lazyListState, final FocusManager focusManager, final Function0 function0, LazyListScope lazyListScope) {
        LazyListScope.items$default(lazyListScope, numberOfMonthsInRange(intRange), null, null, ComposableLambdaKt.composableLambdaInstance(-600599685, true, new Function4() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DatePickerKt.HorizontalMonthsList$lambda$1$1$0$0(calendarModel, calendarMonth, function1, calendarDate, l, datePickerFormatter, selectableDates, datePickerColors, lazyListState, focusManager, function0, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalMonthsList$lambda$1$1$0$0(CalendarModel calendarModel, CalendarMonth calendarMonth, Function1 function1, CalendarDate calendarDate, Long l, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, LazyListState lazyListState, FocusManager focusManager, Function0 function0, LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(it)1805@84324L815:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-600599685, i3, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1804)");
            }
            CalendarMonth calendarMonthPlusMonths = calendarModel.plusMonths(calendarMonth, i);
            Modifier modifierFillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillParentMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 708728373, "C1806@84392L729:DatePicker.kt#uh7d8r");
            Month(calendarMonthPlusMonths, function1, calendarDate.getUtcTimeMillis(), l, null, null, datePickerFormatter, selectableDates, datePickerColors, calendarModel.getLocale(), lazyListState, focusManager, function0, composer, 221184, 0);
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

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, Continuation<? super Unit> continuation) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda72
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(lazyListState.getFirstVisibleItemIndex());
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.material3.DatePickerKt.updateDisplayedMonth.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(int i, Continuation<? super Unit> continuation2) {
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() / 12;
                function1.invoke(Boxing.boxLong(calendarModel.getMonth(intRange.getFirst() + firstVisibleItemIndex, (lazyListState.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
                return Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final void WeekDays(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WeekDays)N(colors,calendarModel)1867@86658L5,1869@86669L1567:DatePicker.kt#uh7d8r");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(calendarModel) ? 32 : 16;
        }
        ?? r8 = 0;
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1856)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i3 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(weekdayNames.get(i4));
            }
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            TextStyle value = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), composerStartRestartGroup, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, RecommendedSizeForAccessibility, 1, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composerStartRestartGroup, 54);
            String str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            String str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 761451639, "C:DatePicker.kt#uh7d8r");
            composerStartRestartGroup.startReplaceGroup(24563235);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*1878@87036L33,1888@87737L7,1889@87820L7,1876@86954L1266");
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i6 = 0;
            while (i6 < size2) {
                final Pair pair = (Pair) arrayList2.get(i6);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1806140369, "CC(remember):DatePicker.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(pair);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerKt.WeekDays$lambda$0$0$0$0(pair, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1270sizeInqDBjuR0$default = SizeKt.m1270sizeInqDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), DatePickerModalTokens.INSTANCE.m5320getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m5319getDateContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null);
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM9701unboximpl = ((Dp) objConsume).m9701unboximpl();
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1268sizeVpY3zN4 = SizeKt.m1268sizeVpY3zN4(modifierM1270sizeInqDBjuR0$default, fM9701unboximpl, ((Dp) objConsume2).m9701unboximpl());
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, r8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r8);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1268sizeVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1708069020, "C1893@87941L265:DatePicker.kt#uh7d8r");
                Composer composer3 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null), datePickerColors.getWeekdayContentColor(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, value, composer3, 48, 0, 130040);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                i6++;
                composerStartRestartGroup = composer3;
                str = str;
                r8 = 0;
                size2 = size2;
                str2 = str2;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.WeekDays$lambda$1(datePickerColors, calendarModel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WeekDays$lambda$0$0$0$0(Pair pair, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, (String) pair.getFirst());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:206:0x047e  */
    public static final void Month(final CalendarMonth calendarMonth, final Function1<? super Long, Unit> function1, final long j, final Long l, final Long l2, final SelectedRangeInfo selectedRangeInfo, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, final Locale locale, final LazyListState lazyListState, final FocusManager focusManager, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        int i5;
        Modifier.Companion companionDrawWithContent;
        int i6;
        Composer composer3;
        int i7;
        int i8;
        int i9;
        String str;
        boolean z;
        boolean z2;
        DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
        SelectableDates selectableDates2 = selectableDates;
        Locale locale2 = locale;
        Composer composerStartRestartGroup = composer.startRestartGroup(1724672983);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Month)N(month,onDateSelectionChange,todayMillis,startDateMillis,endDateMillis,rangeSelectionInfo,dateFormatter,selectableDates,colors,locale,lazyListState,focusManager,onReturnFocus)1931@89128L24,1932@89190L7,1937@89394L6075:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(calendarMonth) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(l) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(l2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(selectedRangeInfo) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= (i & 2097152) == 0 ? composerStartRestartGroup.changed(datePickerFormatter2) : composerStartRestartGroup.changedInstance(datePickerFormatter2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(selectableDates2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(locale2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i10 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(lazyListState) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(focusManager) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i11 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i11 & Token.DOTQUERY) == 146) ? false : true, i10 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1724672983, i10, i11, "androidx.compose.material3.Month (DatePicker.kt:1921)");
            }
            if (selectedRangeInfo != null) {
                composerStartRestartGroup.startReplaceGroup(-960393781);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1924@88911L143");
                Modifier.Companion companion = Modifier.INSTANCE;
                i5 = 458752;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -446621242, "CC(remember):DatePicker.kt#9igjgp");
                boolean z3 = ((i10 & 458752) == 131072) | ((234881024 & i10) == 67108864);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerKt.Month$lambda$0$0(selectedRangeInfo, datePickerColors, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionDrawWithContent = DrawModifierKt.drawWithContent(companion, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i5 = 458752;
                composerStartRestartGroup.startReplaceGroup(-960202325);
                composerStartRestartGroup.endReplaceGroup();
                companionDrawWithContent = Modifier.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            int i12 = i10;
            String str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z4 = objConsume == LayoutDirection.Rtl;
            int firstEnabledDay = getFirstEnabledDay(calendarMonth, selectableDates2);
            int lastEnabledDay = getLastEnabledDay(calendarMonth, selectableDates2);
            boolean z5 = z4;
            Modifier modifierThen = SizeKt.m1255requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(RecommendedSizeForAccessibility * 6)).then(companionDrawWithContent);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            String str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -27338663, "C:DatePicker.kt#uh7d8r");
            composerStartRestartGroup.startReplaceGroup(-1663449878);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*1944@89687L5766");
            int i13 = 0;
            int i14 = 6;
            int i15 = 0;
            while (i15 < i14) {
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                int i16 = i13;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str3);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int i17 = i15;
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 490098410, "C:DatePicker.kt#uh7d8r");
                composerStartRestartGroup.startReplaceGroup(-1092569031);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                i13 = i16;
                int i18 = 0;
                while (i18 < 7) {
                    if (i13 < calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() || i13 >= calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) {
                        i6 = i18;
                        composer3 = composerStartRestartGroup;
                        i7 = i12;
                        i8 = firstEnabledDay;
                        i9 = lastEnabledDay;
                        composer3.startReplaceGroup(490256726);
                        ComposerKt.sourceInformation(composer3, "1967@91026L7,1968@91121L7,1960@90576L617");
                        Modifier modifierM1270sizeInqDBjuR0$default = SizeKt.m1270sizeInqDBjuR0$default(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m5320getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m5319getDateContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null);
                        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        str = str2;
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str);
                        Object objConsume2 = composer3.consume(localMinimumInteractiveComponentSize);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        float fM9701unboximpl = ((Dp) objConsume2).m9701unboximpl();
                        ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str);
                        Object objConsume3 = composer3.consume(localMinimumInteractiveComponentSize2);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        SpacerKt.Spacer(SizeKt.m1268sizeVpY3zN4(modifierM1270sizeInqDBjuR0$default, fM9701unboximpl, ((Dp) objConsume3).m9701unboximpl()), composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(491361535);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1992@92467L366,2006@93193L457,2026@94485L39,2013@93675L1692");
                        int daysFromStartOfWeekToFirstOfMonth = i13 - calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
                        i6 = i18;
                        final long startUtcTimeMillis = calendarMonth.getStartUtcTimeMillis() + (((long) daysFromStartOfWeekToFirstOfMonth) * 86400000);
                        boolean z6 = startUtcTimeMillis == j;
                        boolean z7 = l != null && startUtcTimeMillis == l.longValue();
                        boolean z8 = l2 != null && startUtcTimeMillis == l2.longValue();
                        if (selectedRangeInfo != null) {
                            composerStartRestartGroup.startReplaceGroup(491792745);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "1980@91803L435");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092513394, "CC(remember):DatePicker.kt#9igjgp");
                            boolean zChanged = ((i12 & i5) == 131072) | composerStartRestartGroup.changed(startUtcTimeMillis);
                            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                if (startUtcTimeMillis < (l != null ? l.longValue() : Long.MAX_VALUE)) {
                                    z2 = false;
                                } else {
                                    if (startUtcTimeMillis <= (l2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean zBooleanValue = ((Boolean) ((MutableState) objRememberedValue3).getValue()).booleanValue();
                            composerStartRestartGroup.endReplaceGroup();
                            z = zBooleanValue;
                        } else {
                            i6 = i6;
                            composerStartRestartGroup.startReplaceGroup(492321698);
                            composerStartRestartGroup.endReplaceGroup();
                            z = false;
                        }
                        boolean z9 = z;
                        boolean z10 = z6;
                        String strDayContentDescription = dayContentDescription(selectedRangeInfo != null, z10, z7, z8, z9, composerStartRestartGroup, 0);
                        boolean z11 = z8;
                        boolean z12 = z7;
                        String date = datePickerFormatter2.formatDate(Long.valueOf(startUtcTimeMillis), locale2, true);
                        if (date == null) {
                            date = "";
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1092468892, "CC(remember):DatePicker.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(startUtcTimeMillis) | ((i12 & 29360128) == 8388608);
                        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = Boolean.valueOf(selectableDates2.isSelectableYear(calendarMonth.getYear()) && selectableDates2.isSelectableDate(startUtcTimeMillis));
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        boolean zBooleanValue2 = ((Boolean) objRememberedValue4).booleanValue();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        String str4 = str2;
                        i7 = i12;
                        i8 = firstEnabledDay;
                        i9 = lastEnabledDay;
                        composer3 = composerStartRestartGroup;
                        String localString$default = CalendarLocale_jvmAndAndroidKt.toLocalString$default(daysFromStartOfWeekToFirstOfMonth + 1, 0, 0, false, locale2, 7, null);
                        boolean z13 = z5;
                        Modifier modifierDayOnKeyEvent = dayOnKeyEvent(Modifier.INSTANCE, z13, i13 == i8, i13 == i9, lazyListState, coroutineScope, focusManager, function0);
                        z5 = z13;
                        boolean z14 = z12 || z11;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1092427966, "CC(remember):DatePicker.kt#9igjgp");
                        boolean zChanged3 = ((i7 & 112) == 32) | composer3.changed(startUtcTimeMillis);
                        Object objRememberedValue5 = composer3.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda38
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return DatePickerKt.Month$lambda$1$0$2$0(function1, startUtcTimeMillis);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function2 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (strDayContentDescription != null) {
                            date = strDayContentDescription + ", " + date;
                        }
                        Day(localString$default, modifierDayOnKeyEvent, z14, function2, z12, zBooleanValue2, z10, z9, date, datePickerColors, composer3, (i7 << 3) & C.ENCODING_PCM_DOUBLE);
                        composer3.endReplaceGroup();
                        str = str4;
                    }
                    i13++;
                    i18 = i6 + 1;
                    locale2 = locale;
                    str2 = str;
                    firstEnabledDay = i8;
                    composerStartRestartGroup = composer3;
                    lastEnabledDay = i9;
                    i12 = i7;
                    str3 = str3;
                    datePickerFormatter2 = datePickerFormatter;
                    selectableDates2 = selectableDates;
                }
                Composer composer4 = composerStartRestartGroup;
                composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                i15 = i17 + 1;
                locale2 = locale;
                i14 = 6;
                datePickerFormatter2 = datePickerFormatter;
                selectableDates2 = selectableDates;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Month$lambda$2(calendarMonth, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, locale, lazyListState, focusManager, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Month$lambda$0$0(SelectedRangeInfo selectedRangeInfo, DatePickerColors datePickerColors, ContentDrawScope contentDrawScope) {
        DateRangePickerKt.m3230drawRangeBackgroundmxwnekA(contentDrawScope, selectedRangeInfo, datePickerColors.getDayInSelectionRangeContainerColor());
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Month$lambda$1$0$2$0(Function1 function1, long j) {
        function1.invoke(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    private static final Modifier dayOnKeyEvent(Modifier modifier, final boolean z, boolean z2, boolean z3, final LazyListState lazyListState, final CoroutineScope coroutineScope, final FocusManager focusManager, final Function0<Unit> function0) {
        if (focusManager == null) {
            return modifier;
        }
        if (z2) {
            return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt.dayOnKeyEvent.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3199invokeZmokQxo(keyEvent.m7966unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3199invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    if (DatePickerKt.m3193isShiftTabZmokQxo(keyEvent)) {
                        function0.invoke();
                        return true;
                    }
                    if (!lazyListState.isScrollInProgress()) {
                        if (DatePickerKt.m3189isDirectionBackwardsYhN2O0w(keyEvent, z)) {
                            DatePickerKt.m3188goToMonthBhxgA10(-1, lazyListState, focusManager, FocusDirection.INSTANCE.m6453getPreviousdhqQ8s(), coroutineScope);
                            return true;
                        }
                        if (DatePickerKt.m3190isDirectionForwardYhN2O0w(keyEvent, z)) {
                            focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6452getNextdhqQ8s());
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
            });
        }
        if (z3) {
            return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt.dayOnKeyEvent.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3200invokeZmokQxo(keyEvent.m7966unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3200invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    if (DatePickerKt.m3194isTabZmokQxo(keyEvent)) {
                        if (focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6448getDowndhqQ8s())) {
                            focusManager.mo6458moveFocus3ESFkO8(z ? FocusDirection.INSTANCE.m6451getLeftdhqQ8s() : FocusDirection.INSTANCE.m6454getRightdhqQ8s());
                        } else if (!lazyListState.isScrollInProgress()) {
                            DatePickerKt.m3188goToMonthBhxgA10(1, lazyListState, focusManager, FocusDirection.INSTANCE.m6452getNextdhqQ8s(), coroutineScope);
                        }
                        return true;
                    }
                    if (!lazyListState.isScrollInProgress()) {
                        if (DatePickerKt.m3190isDirectionForwardYhN2O0w(keyEvent, z)) {
                            DatePickerKt.m3188goToMonthBhxgA10(1, lazyListState, focusManager, FocusDirection.INSTANCE.m6452getNextdhqQ8s(), coroutineScope);
                            return true;
                        }
                        if (DatePickerKt.m3189isDirectionBackwardsYhN2O0w(keyEvent, z)) {
                            focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6453getPreviousdhqQ8s());
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
            });
        }
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt.dayOnKeyEvent.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3201invokeZmokQxo(keyEvent.m7966unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3201invokeZmokQxo(android.view.KeyEvent keyEvent) {
                if (!DatePickerKt.m3190isDirectionForwardYhN2O0w(keyEvent, z)) {
                    if (DatePickerKt.m3189isDirectionBackwardsYhN2O0w(keyEvent, z)) {
                        focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6453getPreviousdhqQ8s());
                        return true;
                    }
                    return false;
                }
                focusManager.mo6458moveFocus3ESFkO8(FocusDirection.INSTANCE.m6452getNextdhqQ8s());
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: goToMonth-BhxgA10, reason: not valid java name */
    public static final void m3188goToMonthBhxgA10(int i, LazyListState lazyListState, FocusManager focusManager, int i2, CoroutineScope coroutineScope) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DatePickerKt$goToMonth$1(lazyListState, i, focusManager, i2, null), 3, null);
    }

    private static final int getFirstEnabledDay(CalendarMonth calendarMonth, SelectableDates selectableDates) {
        int daysFromStartOfWeekToFirstOfMonth = calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
        int daysFromStartOfWeekToFirstOfMonth2 = (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) - 1;
        if (selectableDates.isSelectableYear(calendarMonth.getYear())) {
            int i = 0;
            while (!selectableDates.isSelectableDate(calendarMonth.getStartUtcTimeMillis() + (((long) i) * 86400000)) && daysFromStartOfWeekToFirstOfMonth <= daysFromStartOfWeekToFirstOfMonth2) {
                i++;
                daysFromStartOfWeekToFirstOfMonth++;
            }
        }
        return daysFromStartOfWeekToFirstOfMonth;
    }

    private static final int getLastEnabledDay(CalendarMonth calendarMonth, SelectableDates selectableDates) {
        int daysFromStartOfWeekToFirstOfMonth = calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
        int daysFromStartOfWeekToFirstOfMonth2 = (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) - 1;
        if (selectableDates.isSelectableYear(calendarMonth.getYear())) {
            int i = 0;
            while (!selectableDates.isSelectableDate(calendarMonth.getEndUtcTimeMillis() - (((long) i) * 86400000)) && daysFromStartOfWeekToFirstOfMonth2 >= daysFromStartOfWeekToFirstOfMonth) {
                i++;
                daysFromStartOfWeekToFirstOfMonth2--;
            }
        }
        return daysFromStartOfWeekToFirstOfMonth2;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 502032503, "C(dayContentDescription)N(rangeSelectionEnabled,isToday,isStartDate,isEndDate,isInRange):DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:2191)");
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            composer.startReplaceGroup(974430743);
            ComposerKt.sourceInformation(composer, "");
            if (z3) {
                composer.startReplaceGroup(1416908759);
                ComposerKt.sourceInformation(composer, "2196@101172L56");
                Strings.Companion companion = Strings.INSTANCE;
                sb.append(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceGroup();
            } else if (z4) {
                composer.startReplaceGroup(1416912757);
                ComposerKt.sourceInformation(composer, "2198@101297L54");
                Strings.Companion companion2 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceGroup();
            } else {
                if (z5) {
                    composer.startReplaceGroup(1416916692);
                    ComposerKt.sourceInformation(composer, "2200@101420L53");
                    Strings.Companion companion3 = Strings.INSTANCE;
                    sb.append(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                } else {
                    composer.startReplaceGroup(874139915);
                }
                composer.endReplaceGroup();
            }
        } else {
            composer.startReplaceGroup(874139915);
        }
        composer.endReplaceGroup();
        if (z2) {
            composer.startReplaceGroup(974842237);
            ComposerKt.sourceInformation(composer, "2205@101621L54");
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            sb.append(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
        } else {
            composer.startReplaceGroup(874139915);
        }
        composer.endReplaceGroup();
        String string = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }

    private static final void Day(final String str, final Modifier modifier, final boolean z, final Function0<Unit> function0, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final String str2, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        boolean z6;
        boolean z7;
        boolean z8;
        DatePickerColors datePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-945355136);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Day)N(text,modifier,selected,onClick,animateChecked,enabled,today,inRange,description,colors)2231@102456L124,2236@102666L5,2239@102725L83,2250@103122L867,2223@102046L1943:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            z6 = z2;
            i2 |= composerStartRestartGroup.changed(z6) ? 16384 : 8192;
        } else {
            z6 = z2;
        }
        if ((196608 & i) == 0) {
            z7 = z3;
            i2 |= composerStartRestartGroup.changed(z7) ? 131072 : 65536;
        } else {
            z7 = z3;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            z8 = z5;
            i2 |= composerStartRestartGroup.changed(z8) ? 8388608 : 4194304;
        } else {
            z8 = z5;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if (!composerStartRestartGroup.shouldExecute((306783379 & i2) != 306783378, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945355136, i2, -1, "androidx.compose.material3.Day (DatePicker.kt:2222)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2046802460, "CC(remember):DatePicker.kt#9igjgp");
            boolean z9 = (234881024 & i2) == 67108864;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z9 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Day$lambda$0$0(str2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), composerStartRestartGroup, 6);
            int i3 = i2 >> 6;
            long jM6824unboximpl = datePickerColors2.dayContainerColor$material3(z, z7, z6, composerStartRestartGroup, (i3 & 14) | ((i2 >> 12) & 112) | (i3 & 896) | ((i2 >> 18) & 7168)).getValue().m6824unboximpl();
            final boolean z10 = z8;
            SurfaceKt.m4324Surfaced85dljk(z, function0, modifierSemantics, z3, value, jM6824unboximpl, 0L, 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m622BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m5323getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor()), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1126347158, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Day$lambda$1(str, datePickerColors, z4, z, z10, z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i3 & 7294, 48, 1472);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Day$lambda$2(str, modifier, z, function0, z2, z3, z4, z5, str2, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Day$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, 2, null));
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Day$lambda$1(String str, DatePickerColors datePickerColors, boolean z, boolean z2, boolean z3, boolean z4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2251@103132L851:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1126347158, i, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:2251)");
            }
            Modifier modifierM1260requiredSizeVpY3zN4 = SizeKt.m1260requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m5320getDateContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m5319getDateContainerHeightD9Ej5fM());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1260requiredSizeVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composer, 781235302, "C2262@103571L2,2265@103651L230,2259@103416L557:DatePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1775909774, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Day$lambda$1$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(str, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), datePickerColors.dayContentColor$material3(z, z2, z3, z4, composer, 0).getValue().m6824unboximpl(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 261112);
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
    public static final Unit Day$lambda$1$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    private static final void YearPicker(final Modifier modifier, final long j, final Function1<? super Integer, Unit> function1, final SelectableDates selectableDates, final CalendarModel calendarModel, final IntRange intRange, final DatePickerColors datePickerColors, final FocusRequester focusRequester, final Function0<Unit> function0, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        final long j2;
        Function1<? super Integer, Unit> function3;
        CalendarModel calendarModel2;
        IntRange intRange2;
        DatePickerColors datePickerColors2;
        Function0<Unit> function4;
        Function0<Unit> function5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-724154510);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(YearPicker)N(modifier,displayedMonthMillis,onYearSelected,selectableDates,calendarModel,yearRange,colors,currentYearFocusRequester,onYearShiftTabPressed,onYearTabPressed)2291@104455L5,2291@104462L2926,2291@104381L3007,2352@107506L44,2352@107464L86:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            j2 = j;
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        } else {
            j2 = j;
        }
        if ((i & 384) == 0) {
            function3 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function1;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(selectableDates) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            calendarModel2 = calendarModel;
            i2 |= composerStartRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((196608 & i) == 0) {
            intRange2 = intRange;
            i2 |= composerStartRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        } else {
            intRange2 = intRange;
        }
        if ((1572864 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= composerStartRestartGroup.changed(datePickerColors2) ? 1048576 : 524288;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(focusRequester) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            function4 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
        } else {
            function4 = function0;
        }
        if ((805306368 & i) == 0) {
            function5 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        } else {
            function5 = function2;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-724154510, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:2290)");
            }
            final Function0<Unit> function6 = function4;
            final Function1<? super Integer, Unit> function7 = function3;
            final IntRange intRange3 = intRange2;
            int i3 = i2;
            final CalendarModel calendarModel3 = calendarModel2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final Function0<Unit> function8 = function5;
            TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1910384865, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.YearPicker$lambda$0(calendarModel3, j2, intRange3, modifier, datePickerColors3, function6, function8, focusRequester, function7, selectableDates, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -127670338, "CC(remember):DatePicker.kt#9igjgp");
            boolean z = (29360128 & i3) == 8388608;
            DatePickerKt$YearPicker$2$1 datePickerKt$YearPicker$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || datePickerKt$YearPicker$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerKt$YearPicker$2$1RememberedValue = new DatePickerKt$YearPicker$2$1(focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$YearPicker$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(focusRequester, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$YearPicker$2$1RememberedValue, composerStartRestartGroup, (i3 >> 21) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda54
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.YearPicker$lambda$2(modifier, j, function1, selectableDates, calendarModel, intRange, datePickerColors, focusRequester, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPicker$lambda$0(final CalendarModel calendarModel, long j, final IntRange intRange, Modifier modifier, final DatePickerColors datePickerColors, final Function0 function0, final Function0 function1, final FocusRequester focusRequester, final Function1 function2, final SelectableDates selectableDates, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2295@104657L281,2308@105386L1996,2300@104947L2435:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1910384865, i, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:2292)");
            }
            final int year = calendarModel.getMonth(calendarModel.getToday()).getYear();
            final int year2 = calendarModel.getMonth(j).getYear();
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - intRange.getFirst()) - 3), 0, composer, 0, 2);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, datePickerColors.getContainerColor(), null, 2, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            GridCells.Fixed fixed2 = fixed;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(YearsVerticalPadding);
            Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
            ComposerKt.sourceInformationMarkerStart(composer, 1928851437, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(intRange) | composer.changedInstance(calendarModel) | composer.changed(function0) | composer.changed(function1) | composer.changed(year2) | composer.changed(focusRequester) | composer.changed(year) | composer.changed(function2) | composer.changed(selectableDates) | composer.changed(datePickerColors);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.YearPicker$lambda$0$0$0(intRange, calendarModel, function0, function1, year2, focusRequester, year, function2, selectableDates, datePickerColors, (LazyGridScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyGridDslKt.LazyVerticalGrid(fixed2, modifierM589backgroundbw27NRU$default, lazyGridStateRememberLazyGridState, null, false, horizontalOrVerticalM1073spacedBy0680j_4, horizontalOrVertical, null, false, null, (Function1) objRememberedValue, composer, 1769472, 0, 920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPicker$lambda$0$0$0(final IntRange intRange, final CalendarModel calendarModel, final Function0 function0, final Function0 function1, final int i, final FocusRequester focusRequester, final int i2, final Function1 function2, final SelectableDates selectableDates, final DatePickerColors datePickerColors, LazyGridScope lazyGridScope) {
        LazyGridScope.items$default(lazyGridScope, CollectionsKt.count(intRange), null, null, null, ComposableLambdaKt.composableLambdaInstance(-1895584772, true, new Function4() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return DatePickerKt.YearPicker$lambda$0$0$0$0(intRange, calendarModel, function0, function1, i, focusRequester, i2, function2, selectableDates, datePickerColors, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 14, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPicker$lambda$0$0$0$0(IntRange intRange, CalendarModel calendarModel, final Function0 function0, final Function0 function1, int i, FocusRequester focusRequester, int i2, final Function1 function2, SelectableDates selectableDates, DatePickerColors datePickerColors, LazyGridItemScope lazyGridItemScope, int i3, Composer composer, int i4) {
        int i5;
        Modifier.Companion companionFocusRequester;
        ComposerKt.sourceInformation(composer, "CN(it)2319@105973L471,2339@106942L32,2343@107178L54,2312@105593L1765:DatePicker.kt#uh7d8r");
        if ((i4 & 48) == 0) {
            i5 = i4 | (composer.changed(i3) ? 32 : 16);
        } else {
            i5 = i4;
        }
        if (!composer.shouldExecute((i5 & Token.COLONCOLON) != 144, i5 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1895584772, i5, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2310)");
            }
            final int first = i3 + intRange.getFirst();
            String localString$default = CalendarLocale_jvmAndAndroidKt.toLocalString$default(first, 0, 0, false, calendarModel.getLocale(), 7, null);
            Modifier modifierM1260requiredSizeVpY3zN4 = SizeKt.m1260requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m5330getSelectionYearContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m5329getSelectionYearContainerHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, -590814381, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$1$1$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3198invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3198invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (!DatePickerKt.m3193isShiftTabZmokQxo(keyEvent)) {
                            if (DatePickerKt.m3194isTabZmokQxo(keyEvent)) {
                                function1.invoke();
                                return true;
                            }
                            return false;
                        }
                        function0.invoke();
                        return true;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(modifierM1260requiredSizeVpY3zN4, (Function1) objRememberedValue);
            if (first == i) {
                companionFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
            } else {
                companionFocusRequester = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierOnKeyEvent.then(companionFocusRequester);
            boolean z = first == i;
            boolean z2 = first == i2;
            ComposerKt.sourceInformationMarkerStart(composer, -590783812, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged2 = composer.changed(function2) | composer.changed(first);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerKt.YearPicker$lambda$0$0$0$0$1$0(function2, first);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean zIsSelectableYear = selectableDates.isSelectableYear(first);
            Strings.Companion companion = Strings.INSTANCE;
            String str = String.format(Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_navigate_to_year_description), composer, 0), Arrays.copyOf(new Object[]{localString$default}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Year(localString$default, modifierThen, z, z2, (Function0) objRememberedValue2, zIsSelectableYear, str, datePickerColors, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPicker$lambda$0$0$0$0$1$0(Function1 function1, int i) {
        function1.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    private static final void Year(final String str, final Modifier modifier, final boolean z, final boolean z2, final Function0<Unit> function0, final boolean z3, final String str2, final DatePickerColors datePickerColors, Composer composer, final int i) {
        String str3;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1153850597);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Year)N(text,modifier,selected,currentYear,onClick,enabled,description,colors)2372@107931L394,2390@108700L112,2395@108908L5,2396@108938L58,2398@109035L638,2383@108330L1343:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            str3 = str;
            i2 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1153850597, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2370)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -748853531, "CC(remember):DatePicker.kt#9igjgp");
            boolean z4 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (!z2 || z) ? null : BorderStrokeKt.m622BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m5323getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            BorderStroke borderStroke = (BorderStroke) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -748829205, "CC(remember):DatePicker.kt#9igjgp");
            boolean z5 = (3670016 & i2) == 1048576;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Year$lambda$1$0(str2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 6;
            int i4 = i3 & 14;
            final String str4 = str3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4324Surfaced85dljk(z, function0, SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue2), z3, ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), composerStartRestartGroup, 6), datePickerColors.yearContainerColor$material3(z, z3, composerStartRestartGroup, i4 | ((i2 >> 12) & 112) | ((i2 >> 15) & 896)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-564400443, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Year$lambda$2(str4, datePickerColors, z2, z, z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i4 | ((i2 >> 9) & 112) | (i3 & 7168), 48, 1472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.Year$lambda$3(str, modifier, z, z2, function0, z3, str2, datePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Year$lambda$1$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, 2, null));
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Year$lambda$2(String str, DatePickerColors datePickerColors, boolean z, boolean z2, boolean z3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2399@109045L622:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564400443, i, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2399)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1181166895, "C2403@109291L2,2406@109371L194,2400@109136L521:DatePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1901556051, "CC(remember):DatePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.Year$lambda$2$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(str, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue), datePickerColors.yearContentColor$material3(z, z2, z3, composer, 0).getValue().m6824unboximpl(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 0, 0, 261112);
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
    public static final Unit Year$lambda$2$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    private static final void MonthsNavigation(final Modifier modifier, final boolean z, final boolean z2, final boolean z3, final String str, final Modifier modifier2, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function0<Unit> function3, final FocusRequester focusRequester, final DatePickerColors datePickerColors, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Arrangement.HorizontalOrVertical spaceBetween;
        Composer composerStartRestartGroup = composer.startRestartGroup(942117263);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MonthsNavigation)N(modifier,nextAvailable,previousAvailable,yearPickerVisible,yearPickerText,nextButtonModifier,onNextClicked,onPreviousClicked,onYearPickerButtonClicked,onYearPickerButtonTabPressed,yearSelectionButtonFocusRequester,colors)2437@110275L2432:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(focusRequester) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(datePickerColors) ? 32 : 16;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(942117263, i3, i5, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2436)");
            }
            Modifier modifierM1255requiredHeight3ABfNKs = SizeKt.m1255requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            if (z3) {
                spaceBetween = Arrangement.INSTANCE.getStart();
            } else {
                spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1255requiredHeight3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1242857958, "C2452@110877L226,2459@111115L567,2448@110655L1027:DatePicker.kt#uh7d8r");
            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1345386413, "CC(remember):DatePicker.kt#9igjgp");
            boolean z4 = ((i3 & 7168) == 2048) | ((1879048192 & i3) == 536870912);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3197invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3197invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (z3 && DatePickerKt.m3194isTabZmokQxo(keyEvent)) {
                            function3.invoke();
                            return true;
                        }
                        return false;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            YearPickerMenuButton(function2, z3, KeyInputModifierKt.onKeyEvent(modifierFocusRequester, (Function1) objRememberedValue), ComposableLambdaKt.rememberComposableLambda(921071711, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.MonthsNavigation$lambda$0$1(str, datePickerColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 24) & 14) | 3072 | ((i3 >> 6) & 112), 0);
            if (!z3) {
                composerStartRestartGroup.startReplaceGroup(-1241751848);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2475@111903L788,2475@111820L871");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(datePickerColors.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(591596400, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.MonthsNavigation$lambda$0$2(function1, z2, function0, modifier2, z, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1352692137);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.MonthsNavigation$lambda$1(modifier, z, z2, z3, str, modifier2, function0, function1, function2, function3, focusRequester, datePickerColors, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonthsNavigation$lambda$0$1(final String str, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2463@111240L362,2460@111129L543:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(921071711, i, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2460)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 386655657, "CC(remember):DatePicker.kt#9igjgp");
            boolean zChanged = composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda73
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DatePickerKt.MonthsNavigation$lambda$0$1$0$0(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(str, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), datePickerColors.getNavigationContentColor(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonthsNavigation$lambda$0$1$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MonthsNavigation$lambda$0$2(Function0 function0, boolean z, Function0 function1, Modifier modifier, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2476@111921L756:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(591596400, i, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2476)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1800355217, "C2481@112197L50,2477@111947L323,2489@112590L46,2484@112292L367:DatePicker.kt#uh7d8r");
            ImageVector keyboardArrowLeft$material3 = Icons.AutoMirrored.Filled.INSTANCE.getKeyboardArrowLeft$material3();
            Strings.Companion companion2 = Strings.INSTANCE;
            IconButtonWithTooltip(function0, keyboardArrowLeft$material3, Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_previous_month), composer, 0), null, z, composer, 0, 8);
            ImageVector keyboardArrowRight$material3 = Icons.AutoMirrored.Filled.INSTANCE.getKeyboardArrowRight$material3();
            Strings.Companion companion3 = Strings.INSTANCE;
            IconButtonWithTooltip(function1, keyboardArrowRight$material3, Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_next_month), composer, 0), modifier, z2, composer, 0, 0);
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

    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:50:0x0101  */
    /* JADX WARN: Code duplicated, block: B:53:0x010b  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    private static final void YearPickerMenuButton(final Function0<Unit> function0, final boolean z, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-709923073);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(YearPickerMenuButton)N(onClick,expanded,modifier,content)2509@113128L7,2509@113078L58,2512@113193L454,2505@112949L698:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-709923073, i3, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2504)");
                }
                RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifier2 = modifier4;
                ButtonKt.TextButton(function1, modifier2, false, (Shape) circleShape, buttonDefaults.m2878textButtonColorsro_MJ88(0L, ((Color) objConsume).m6824unboximpl(), 0L, 0L, composerStartRestartGroup, 24576, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1899489890, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DatePickerKt.YearPickerMenuButton$lambda$0(function2, z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 807075840 | ((i3 >> 3) & 112), 388);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.YearPickerMenuButton$lambda$1(function0, z, modifier3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-709923073, i3, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2504)");
            }
            RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
            ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifier2 = modifier4;
            ButtonKt.TextButton(function1, modifier2, false, (Shape) circleShape2, buttonDefaults2.m2878textButtonColorsro_MJ88(0L, ((Color) objConsume2).m6824unboximpl(), 0L, 0L, composerStartRestartGroup, 24576, 13), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1899489890, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerKt.YearPickerMenuButton$lambda$0(function2, z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 807075840 | ((i3 >> 3) & 112), 388);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.YearPickerMenuButton$lambda$1(function0, z, modifier3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit YearPickerMenuButton$lambda$0(Function2 function2, boolean z, RowScope rowScope, Composer composer, int i) {
        String strM5086getString2EP1pXo;
        ComposerKt.sourceInformation(composer, "C2513@113203L9,2514@113221L49,2515@113279L362:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899489890, i, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2513)");
            }
            function2.invoke(composer, 0);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2864getIconSpacingD9Ej5fM()), composer, 6);
            ImageVector arrowDropDown$material3 = Icons.Filled.INSTANCE.getArrowDropDown$material3();
            if (z) {
                composer.startReplaceGroup(1509384391);
                ComposerKt.sourceInformation(composer, "2519@113410L49");
                Strings.Companion companion = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_day_selection), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1509478662);
                ComposerKt.sourceInformation(composer, "2521@113505L50");
                Strings.Companion companion2 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_date_picker_switch_to_year_selection), composer, 0);
                composer.endReplaceGroup();
            }
            IconKt.m3576Iconww6aTOc(arrowDropDown$material3, strM5086getString2EP1pXo, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x0108  */
    /* JADX WARN: Code duplicated, block: B:66:0x010e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0119  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    private static final void IconButtonWithTooltip(final Function0<Unit> function0, final ImageVector imageVector, final String str, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        final Function0<Unit> function1;
        int i3;
        final ImageVector imageVector2;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-368059805);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButtonWithTooltip)N(onClick,icon,contentDescription,modifier,enabled)2539@113957L60,2540@114037L45,2541@114100L22,2542@114130L175,2537@113890L415:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            imageVector2 = imageVector;
            i3 |= composerStartRestartGroup.changed(imageVector2) ? 32 : 16;
        } else {
            imageVector2 = imageVector;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-368059805, i3, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2536)");
                    }
                    final Modifier modifier4 = companion;
                    final boolean z6 = z5;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda74
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return DatePickerKt.IconButtonWithTooltip$lambda$0(str, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda75
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.IconButtonWithTooltip$lambda$1(function1, modifier4, z6, imageVector2, str, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda76
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerKt.IconButtonWithTooltip$lambda$2(function0, imageVector, str, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368059805, i3, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2536)");
                }
                final Modifier modifier5 = companion;
                final boolean z7 = z5;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda74
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$0(str, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda75
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$1(function1, modifier5, z7, imageVector2, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                z4 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda76
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$2(function0, imageVector, str, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-368059805, i3, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2536)");
                }
                final Modifier modifier6 = companion;
                final boolean z8 = z5;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda74
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$0(str, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda75
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$1(function1, modifier6, z8, imageVector2, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                z4 = z8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda76
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerKt.IconButtonWithTooltip$lambda$2(function0, imageVector, str, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-368059805, i3, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2536)");
            }
            final Modifier modifier7 = companion;
            final boolean z9 = z5;
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new Function3() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerKt.IconButtonWithTooltip$lambda$0(str, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.IconButtonWithTooltip$lambda$1(function1, modifier7, z9, imageVector2, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663344, 248);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
            z4 = z9;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.IconButtonWithTooltip$lambda$2(function0, imageVector, str, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonWithTooltip$lambda$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C2540@114052L28,2540@114039L41:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-456272562, i2, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous> (DatePicker.kt:2540)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(1905952188, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.IconButtonWithTooltip$lambda$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonWithTooltip$lambda$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2540@114054L24:DatePicker.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1905952188, i, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous>.<anonymous> (DatePicker.kt:2540)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonWithTooltip$lambda$1(Function0 function0, Modifier modifier, boolean z, final ImageVector imageVector, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2543@114210L89,2543@114140L159:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1124908186, i, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous> (DatePicker.kt:2543)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, modifier, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-1301085432, true, new Function2() { // from class: androidx.compose.material3.DatePickerKt$$ExternalSyntheticLambda66
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerKt.IconButtonWithTooltip$lambda$1$0(imageVector, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButtonWithTooltip$lambda$1$0(ImageVector imageVector, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2544@114224L65:DatePicker.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1301085432, i, -1, "androidx.compose.material3.IconButtonWithTooltip.<anonymous>.<anonymous> (DatePicker.kt:2544)");
            }
            IconKt.m3576Iconww6aTOc(imageVector, str, (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isDirectionBackwards-YhN2O0w, reason: not valid java name */
    public static final boolean m3189isDirectionBackwardsYhN2O0w(android.view.KeyEvent keyEvent, boolean z) {
        return z ? m3192isDirectionRightZmokQxo(keyEvent) : m3191isDirectionLeftZmokQxo(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isDirectionForward-YhN2O0w, reason: not valid java name */
    public static final boolean m3190isDirectionForwardYhN2O0w(android.view.KeyEvent keyEvent, boolean z) {
        return z ? m3191isDirectionLeftZmokQxo(keyEvent) : m3192isDirectionRightZmokQxo(keyEvent);
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isShiftTab-ZmokQxo, reason: not valid java name */
    public static final boolean m3193isShiftTabZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent) && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isTab-ZmokQxo, reason: not valid java name */
    public static final boolean m3194isTabZmokQxo(android.view.KeyEvent keyEvent) {
        return !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent) && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ());
    }

    /* JADX INFO: renamed from: isDirectionLeft-ZmokQxo, reason: not valid java name */
    private static final boolean m3191isDirectionLeftZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7745getDirectionLeftEK5gGoQ());
    }

    /* JADX INFO: renamed from: isDirectionRight-ZmokQxo, reason: not valid java name */
    private static final boolean m3192isDirectionRightZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7746getDirectionRightEK5gGoQ());
    }

    static {
        float f = 12;
        DatePickerHorizontalPadding = Dp.m9687constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 3, null);
        float f2 = 24;
        float f3 = 16;
        DatePickerTitlePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f), 0.0f, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(f2), 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), 2, null);
        YearsVerticalPadding = Dp.m9687constructorimpl(f3);
    }
}
