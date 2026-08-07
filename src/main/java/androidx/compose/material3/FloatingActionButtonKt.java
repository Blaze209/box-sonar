package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
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
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabMediumTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabMediumTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001an\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u0012\u001an\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0012\u001an\u0010\u001e\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001f\u0010\u0012\u001ay\u0010 \u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0010¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b$\u0010%\u001ay\u0010&\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0010¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b'\u0010%\u001ay\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0010¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b)\u0010%\u001ay\u0010*\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0010¢\u0006\u0002\b#H\u0007¢\u0006\u0004\b+\u0010%\u001a\u008b\u0001\u0010 \u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b0\u00101\u001a\u008b\u0001\u0010&\u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b2\u00101\u001a\u008b\u0001\u0010(\u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b3\u00101\u001a\u008b\u0001\u0010*\u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b4\u00101\u001a»\u0001\u0010*\u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003¢\u0006\u0004\b8\u00109\u001aJ\u0010:\u001a\u00020\u0005*\u00020\u00052\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010A2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010AH\u0007\u001a\r\u0010[\u001a\u00020\\H\u0003¢\u0006\u0002\u0010]\u001a\r\u0010^\u001a\u00020_H\u0003¢\u0006\u0002\u0010`\"\u0010\u0010C\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010E\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010F\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010G\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010H\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010K\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010L\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010M\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010N\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010O\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u000e\u0010P\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010Q\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010R\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010S\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010T\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010U\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u000e\u0010V\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010W\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010X\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010Y\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D\"\u0010\u0010Z\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006a"}, d2 = {"FloatingActionButton", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", ViewProps.MIN_WIDTH, "Landroidx/compose/ui/unit/Dp;", ViewProps.MIN_HEIGHT, "FloatingActionButton-lF-WlFE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "MediumFloatingActionButton", "MediumFloatingActionButton-X-z6DiA", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "SmallExtendedFloatingActionButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "SmallExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MediumExtendedFloatingActionButton", "MediumExtendedFloatingActionButton-X-z6DiA", "LargeExtendedFloatingActionButton", "LargeExtendedFloatingActionButton-X-z6DiA", "ExtendedFloatingActionButton", "ExtendedFloatingActionButton-X-z6DiA", "text", HubsObservability.HUB_ASSET_ICON, "expanded", "", "SmallExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "MediumExtendedFloatingActionButton-ElI5-7k", "LargeExtendedFloatingActionButton-ElI5-7k", "ExtendedFloatingActionButton-ElI5-7k", "startPadding", "endPadding", "iconPadding", "ExtendedFloatingActionButton-qtIzBjc", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFFFFLandroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "animateFloatingActionButton", ViewProps.VISIBLE, "alignment", "Landroidx/compose/ui/Alignment;", "targetScale", "", "scaleAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "alphaAnimationSpec", "SmallExtendedFabMinimumWidth", "F", "SmallExtendedFabMinimumHeight", "SmallExtendedFabPaddingStart", "SmallExtendedFabPaddingEnd", "SmallExtendedFabIconPadding", "SmallExtendedFabTextStyle", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MediumExtendedFabMinimumWidth", "MediumExtendedFabMinimumHeight", "MediumExtendedFabPaddingStart", "MediumExtendedFabPaddingEnd", "MediumExtendedFabIconPadding", "MediumExtendedFabTextStyle", "LargeExtendedFabMinimumWidth", "LargeExtendedFabMinimumHeight", "LargeExtendedFabPaddingStart", "LargeExtendedFabPaddingEnd", "LargeExtendedFabIconPadding", "LargeExtendedFabTextStyle", "ExtendedFabStartIconPadding", "ExtendedFabEndIconPadding", "ExtendedFabTextPadding", "ExtendedFabMinimumWidth", "extendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "extendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonKt {
    private static final float ExtendedFabEndIconPadding;
    private static final float ExtendedFabStartIconPadding;
    private static final float LargeExtendedFabIconPadding;
    private static final float MediumExtendedFabIconPadding;
    private static final float SmallExtendedFabMinimumWidth = ExtendedFabSmallTokens.INSTANCE.m5389getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabMinimumHeight = ExtendedFabSmallTokens.INSTANCE.m5389getContainerHeightD9Ej5fM();
    private static final float SmallExtendedFabPaddingStart = ExtendedFabSmallTokens.INSTANCE.m5392getLeadingSpaceD9Ej5fM();
    private static final float SmallExtendedFabPaddingEnd = ExtendedFabSmallTokens.INSTANCE.m5393getTrailingSpaceD9Ej5fM();
    private static final float SmallExtendedFabIconPadding = ExtendedFabSmallTokens.INSTANCE.m5390getIconLabelSpaceD9Ej5fM();
    private static final TypographyKeyTokens SmallExtendedFabTextStyle = TypographyKeyTokens.TitleMedium;
    private static final float MediumExtendedFabMinimumWidth = ExtendedFabMediumTokens.INSTANCE.m5374getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabMinimumHeight = ExtendedFabMediumTokens.INSTANCE.m5374getContainerHeightD9Ej5fM();
    private static final float MediumExtendedFabPaddingStart = ExtendedFabMediumTokens.INSTANCE.m5377getLeadingSpaceD9Ej5fM();
    private static final float MediumExtendedFabPaddingEnd = ExtendedFabMediumTokens.INSTANCE.m5378getTrailingSpaceD9Ej5fM();
    private static final TypographyKeyTokens MediumExtendedFabTextStyle = TypographyKeyTokens.TitleLarge;
    private static final float LargeExtendedFabMinimumWidth = ExtendedFabLargeTokens.INSTANCE.m5369getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabMinimumHeight = ExtendedFabLargeTokens.INSTANCE.m5369getContainerHeightD9Ej5fM();
    private static final float LargeExtendedFabPaddingStart = ExtendedFabLargeTokens.INSTANCE.m5372getLeadingSpaceD9Ej5fM();
    private static final float LargeExtendedFabPaddingEnd = ExtendedFabLargeTokens.INSTANCE.m5373getTrailingSpaceD9Ej5fM();
    private static final TypographyKeyTokens LargeExtendedFabTextStyle = TypographyKeyTokens.HeadlineSmall;
    private static final float ExtendedFabTextPadding = Dp.m9687constructorimpl(20);
    private static final float ExtendedFabMinimumWidth = Dp.m9687constructorimpl(80);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$1(Function2 function2, Function2 function3, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3391ExtendedFloatingActionButtonElI57k(function2, function3, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$1(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3392ExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec ExtendedFloatingActionButton_qtIzBjc$lambda$0$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1114419602);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1114419602, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:958)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec ExtendedFloatingActionButton_qtIzBjc$lambda$0$2(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-781713402);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-781713402, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:960)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$1(Function2 function2, Function2 function3, Function0 function0, TextStyle textStyle, float f, float f2, float f3, float f4, float f5, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function0, textStyle, f, f2, f3, f4, f5, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3394FloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$3(Function0 function0, TextStyle textStyle, float f, float f2, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        m3395FloatingActionButtonlFWlFE(function0, textStyle, f, f2, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(Function2 function2, Function2 function3, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3396LargeExtendedFloatingActionButtonElI57k(function2, function3, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeExtendedFloatingActionButton_X_z6DiA$lambda$1(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3397LargeExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeFloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3398LargeFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(Function2 function2, Function2 function3, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3399MediumExtendedFloatingActionButtonElI57k(function2, function3, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumExtendedFloatingActionButton_X_z6DiA$lambda$1(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3400MediumExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumFloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3401MediumFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(Function2 function2, Function2 function3, Function0 function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m3402SmallExtendedFloatingActionButtonElI57k(function2, function3, function0, modifier, z, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallExtendedFloatingActionButton_X_z6DiA$lambda$1(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3403SmallExtendedFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallFloatingActionButton_X_z6DiA$lambda$0(Function0 function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Function2 function2, int i, int i2, Composer composer, int i3) {
        m3404SmallFloatingActionButtonXz6DiA(function0, modifier, shape, j, j2, floatingActionButtonElevation, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x013a  */
    /* JADX WARN: Code duplicated, block: B:108:0x013f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0144  */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:116:0x015e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:122:0x0174  */
    /* JADX WARN: Code duplicated, block: B:123:0x0190  */
    /* JADX WARN: Code duplicated, block: B:125:0x0199  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:133:0x0209  */
    /* JADX WARN: Code duplicated, block: B:135:0x021b  */
    /* JADX WARN: Code duplicated, block: B:138:0x022f  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX INFO: renamed from: FloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3394FloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function3;
        boolean z;
        final Modifier modifier3;
        final Shape shape3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape4;
        long containerColor;
        int i6;
        int i7;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape5;
        long j7;
        int i8;
        long j8;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(748201188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)142@7017L5,140@6931L325:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i13 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) == 0) {
                j3 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 24576) == 0) {
                j4 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                j4 = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((12582912 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                } else {
                    function3 = function2;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "133@6601L5,134@6665L14,135@6707L31,136@6816L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 16) != 0) {
                            long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                            j4 = jM3051contentColorForek8zF_U;
                        }
                        i6 = i3;
                        if ((i2 & 32) != 0) {
                            i7 = 6;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i6 & (-458753);
                        } else {
                            i7 = 6;
                            i3 = i6;
                        }
                        if (i4 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        shape5 = shape4;
                        j7 = containerColor;
                        i8 = 748201188;
                        j8 = j4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        i7 = 6;
                        companion = modifier2;
                        shape5 = shape2;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = j3;
                        j8 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = 748201188;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:140)");
                    }
                    int i15 = i3 << 9;
                    m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i7), FabBaselineTokens.INSTANCE.m5395getContainerWidthD9Ej5fM(), FabBaselineTokens.INSTANCE.m5394getContainerHeightD9Ej5fM(), companion, shape5, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function3, composerStartRestartGroup, (i3 & 14) | 3456 | (57344 & i15) | (458752 & i15) | (3670016 & i15) | (29360128 & i15) | (234881024 & i15) | (i15 & C.ENCODING_PCM_DOUBLE), (i3 >> 21) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    shape3 = shape5;
                    j5 = j7;
                    j6 = j8;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape3 = shape2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j5 = j3;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_X_z6DiA$lambda$0(function0, modifier3, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            } else {
                function3 = function2;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "133@6601L5,134@6665L14,135@6707L31,136@6816L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                        j4 = jM3051contentColorForek8zF_U2;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape5 = shape4;
                    j7 = containerColor;
                    i8 = 748201188;
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                        j4 = jM3051contentColorForek8zF_U3;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape5 = shape4;
                    j7 = containerColor;
                    i8 = 748201188;
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:140)");
                }
                int i16 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i7), FabBaselineTokens.INSTANCE.m5395getContainerWidthD9Ej5fM(), FabBaselineTokens.INSTANCE.m5394getContainerHeightD9Ej5fM(), companion, shape5, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function3, composerStartRestartGroup, (i3 & 14) | 3456 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (29360128 & i16) | (234881024 & i16) | (i16 & C.ENCODING_PCM_DOUBLE), (i3 >> 21) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                shape3 = shape5;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_X_z6DiA$lambda$0(function0, modifier3, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            j3 = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            j4 = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            j4 = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((12582912 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            } else {
                function3 = function2;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "133@6601L5,134@6665L14,135@6707L31,136@6816L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U4 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                        j4 = jM3051contentColorForek8zF_U4;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape5 = shape4;
                    j7 = containerColor;
                    i8 = 748201188;
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U5 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                        j4 = jM3051contentColorForek8zF_U5;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape5 = shape4;
                    j7 = containerColor;
                    i8 = 748201188;
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:140)");
                }
                int i17 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i7), FabBaselineTokens.INSTANCE.m5395getContainerWidthD9Ej5fM(), FabBaselineTokens.INSTANCE.m5394getContainerHeightD9Ej5fM(), companion, shape5, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function3, composerStartRestartGroup, (i3 & 14) | 3456 | (57344 & i17) | (458752 & i17) | (3670016 & i17) | (29360128 & i17) | (234881024 & i17) | (i17 & C.ENCODING_PCM_DOUBLE), (i3 >> 21) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                shape3 = shape5;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_X_z6DiA$lambda$0(function0, modifier3, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) == 0) {
            function3 = function2;
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        } else {
            function3 = function2;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "133@6601L5,134@6665L14,135@6707L31,136@6816L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U6 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                    j4 = jM3051contentColorForek8zF_U6;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    i3 = i6;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                shape5 = shape4;
                j7 = containerColor;
                i8 = 748201188;
                j8 = j4;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U7 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                    j4 = jM3051contentColorForek8zF_U7;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    i3 = i6;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                shape5 = shape4;
                j7 = containerColor;
                i8 = 748201188;
                j8 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:140)");
            }
            int i18 = i3 << 9;
            m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, i7), FabBaselineTokens.INSTANCE.m5395getContainerWidthD9Ej5fM(), FabBaselineTokens.INSTANCE.m5394getContainerHeightD9Ej5fM(), companion, shape5, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function3, composerStartRestartGroup, (i3 & 14) | 3456 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), (i3 >> 21) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            shape3 = shape5;
            j5 = j7;
            j6 = j8;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j5 = j3;
            j6 = j4;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_X_z6DiA$lambda$0(function0, modifier3, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x0134  */
    /* JADX WARN: Code duplicated, block: B:109:0x013c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0145  */
    /* JADX WARN: Code duplicated, block: B:114:0x015f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x0196  */
    /* JADX WARN: Code duplicated, block: B:132:0x019b  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:150:0x0208  */
    /* JADX WARN: Code duplicated, block: B:151:0x020a  */
    /* JADX WARN: Code duplicated, block: B:155:0x021b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0227  */
    /* JADX WARN: Code duplicated, block: B:160:0x0244  */
    /* JADX WARN: Code duplicated, block: B:162:0x0256  */
    /* JADX WARN: Code duplicated, block: B:165:0x0273  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:170:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:173:0x0305  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106  */
    /* JADX WARN: Code duplicated, block: B:97:0x0115  */
    /* JADX WARN: Code duplicated, block: B:99:0x011b  */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX INFO: renamed from: FloatingActionButton-lF-WlFE, reason: not valid java name */
    private static final void m3395FloatingActionButtonlFWlFE(final Function0<Unit> function0, final TextStyle textStyle, final float f, final float f2, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        Shape shape2;
        int i5;
        long jM3051contentColorForek8zF_U;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final Shape shape3;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape4;
        long containerColor;
        int i10;
        boolean z2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z3;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape5;
        long j5;
        long j6;
        ?? r11;
        MutableInteractionSource mutableInteractionSource5;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i11;
        int i12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(121669932);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButton)N(onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)172@8000L22,177@8205L54,179@8320L330,170@7926L724:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
        }
        int i14 = i3 & 16;
        if (i14 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    shape2 = shape;
                    int i15 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                    i4 |= i15;
                } else {
                    shape2 = shape;
                }
                i4 |= i15;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                int i16 = i4;
                if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                    i13 = 524288;
                } else {
                    i13 = 1048576;
                }
                i5 = i16 | i13;
            } else {
                i5 = i4;
            }
            if ((i & 12582912) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i12 = 4194304;
                } else {
                    i12 = 8388608;
                }
                i5 |= i12;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            if ((i & 100663296) != 0) {
                i5 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i6 = i3 & 512;
            if (i6 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i5 |= i7;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 4;
                    } else {
                        i11 = 2;
                    }
                    i8 = i2 | i11;
                } else {
                    i8 = i2;
                }
                i9 = i8;
                if ((i5 & 306783379) == 306783378 || (i9 & 3) != 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@7475L5,162@7539L14,163@7581L31,164@7690L11");
                    char c = 6;
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i3 & 32) != 0) {
                            i5 &= -458753;
                            shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i5 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                            i5 &= -29360129;
                        }
                        i10 = i5;
                        if ((i3 & 256) != 0) {
                            z2 = false;
                            mutableInteractionSource3 = null;
                            z3 = true;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i5 = i10 & (-234881025);
                        } else {
                            z2 = false;
                            mutableInteractionSource3 = null;
                            z3 = true;
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            i5 = i10;
                        }
                        modifier2 = companion;
                        if (i6 != 0) {
                            mutableInteractionSource4 = mutableInteractionSource3;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        shape5 = shape4;
                        j5 = containerColor;
                        j6 = jM3051contentColorForek8zF_U;
                        r11 = z3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i3 & 64) != 0) {
                            i5 &= -3670017;
                        }
                        if ((i3 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        j5 = j;
                        z2 = false;
                        c = 6;
                        mutableInteractionSource3 = null;
                        j6 = jM3051contentColorForek8zF_U;
                        i9 = i9;
                        r11 = 1;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        mutableInteractionSource4 = mutableInteractionSource;
                        shape5 = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(121669932, i5, i9, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:167)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-282853233);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "169@7882L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960707027, "CC(remember):FloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(960706376);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960710786, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final long j7 = j6;
                    int i17 = i5 >> 6;
                    SurfaceKt.m4326Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, z2, (Function1) objRememberedValue, r11, mutableInteractionSource3), false, shape5, j5, j6, floatingActionButtonElevationM3374elevationxZ9QkE.getDefaultElevation(), floatingActionButtonElevationM3374elevationxZ9QkE.shadowElevation$material3(mutableInteractionSource5, composerStartRestartGroup, (i5 >> 21) & 112).getValue().m9701unboximpl(), null, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1779603465, r11, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$2(j7, textStyle, f, f2, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | (i17 & 7168) | (57344 & i17) | (i17 & 458752), 6, 260);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier2;
                    shape3 = shape5;
                    j4 = j5;
                    j3 = j6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = jM3051contentColorForek8zF_U;
                    j4 = j;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$3(function0, textStyle, f, f2, modifier3, shape3, j4, j3, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i8 = i2 | i11;
            } else {
                i8 = i2;
            }
            i9 = i8;
            if ((i5 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@7475L5,162@7539L14,163@7581L31,164@7690L11");
                char c2 = 6;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 32) != 0) {
                        i5 &= -458753;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i5 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                        i5 &= -29360129;
                    }
                    i10 = i5;
                    if ((i3 & 256) != 0) {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i5 = i10 & (-234881025);
                    } else {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        i5 = i10;
                    }
                    modifier2 = companion;
                    if (i6 != 0) {
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    shape5 = shape4;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    r11 = z3;
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 32) != 0) {
                        i5 &= -458753;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i5 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                        i5 &= -29360129;
                    }
                    i10 = i5;
                    if ((i3 & 256) != 0) {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i5 = i10 & (-234881025);
                    } else {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        i5 = i10;
                    }
                    modifier2 = companion;
                    if (i6 != 0) {
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    shape5 = shape4;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    r11 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(121669932, i5, i9, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:167)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-282853233);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "169@7882L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960707027, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(960706376);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960710786, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long j8 = j6;
                int i18 = i5 >> 6;
                SurfaceKt.m4326Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, z2, (Function1) objRememberedValue, r11, mutableInteractionSource3), false, shape5, j5, j6, floatingActionButtonElevationM3374elevationxZ9QkE.getDefaultElevation(), floatingActionButtonElevationM3374elevationxZ9QkE.shadowElevation$material3(mutableInteractionSource5, composerStartRestartGroup, (i5 >> 21) & 112).getValue().m9701unboximpl(), null, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1779603465, r11, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$2(j8, textStyle, f, f2, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | (i18 & 7168) | (57344 & i18) | (i18 & 458752), 6, 260);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier2;
                shape3 = shape5;
                j4 = j5;
                j3 = j6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = jM3051contentColorForek8zF_U;
                j4 = j;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$3(function0, textStyle, f, f2, modifier3, shape3, j4, j3, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i4 |= i15;
            } else {
                shape2 = shape;
            }
            i4 |= i15;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            int i19 = i4;
            if ((i3 & 64) == 0) {
                i13 = 524288;
            } else {
                i13 = 524288;
            }
            i5 = i19 | i13;
        } else {
            i5 = i4;
        }
        if ((i & 12582912) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i3 & 128) == 0) {
                i12 = 4194304;
            } else {
                i12 = 4194304;
            }
            i5 |= i12;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        if ((i & 100663296) != 0) {
            i5 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
        }
        i6 = i3 & 512;
        if (i6 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i7 = 268435456;
                }
                i5 |= i7;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i8 = i2 | i11;
            } else {
                i8 = i2;
            }
            i9 = i8;
            if ((i5 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@7475L5,162@7539L14,163@7581L31,164@7690L11");
                char c3 = 6;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 32) != 0) {
                        i5 &= -458753;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i5 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                        i5 &= -29360129;
                    }
                    i10 = i5;
                    if ((i3 & 256) != 0) {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i5 = i10 & (-234881025);
                    } else {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        i5 = i10;
                    }
                    modifier2 = companion;
                    if (i6 != 0) {
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    shape5 = shape4;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    r11 = z3;
                } else {
                    if (i14 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 32) != 0) {
                        i5 &= -458753;
                        shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i5 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                        i5 &= -29360129;
                    }
                    i10 = i5;
                    if ((i3 & 256) != 0) {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i5 = i10 & (-234881025);
                    } else {
                        z2 = false;
                        mutableInteractionSource3 = null;
                        z3 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        i5 = i10;
                    }
                    modifier2 = companion;
                    if (i6 != 0) {
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    shape5 = shape4;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    r11 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(121669932, i5, i9, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:167)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-282853233);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "169@7882L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960707027, "CC(remember):FloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(960706376);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960710786, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final long j9 = j6;
                int i110 = i5 >> 6;
                SurfaceKt.m4326Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, z2, (Function1) objRememberedValue, r11, mutableInteractionSource3), false, shape5, j5, j6, floatingActionButtonElevationM3374elevationxZ9QkE.getDefaultElevation(), floatingActionButtonElevationM3374elevationxZ9QkE.shadowElevation$material3(mutableInteractionSource5, composerStartRestartGroup, (i5 >> 21) & 112).getValue().m9701unboximpl(), null, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1779603465, r11, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$2(j9, textStyle, f, f2, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | (i110 & 7168) | (57344 & i110) | (i110 & 458752), 6, 260);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource4;
                modifier3 = modifier2;
                shape3 = shape5;
                j4 = j5;
                j3 = j6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                floatingActionButtonElevation2 = floatingActionButtonElevation;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = jM3051contentColorForek8zF_U;
                j4 = j;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$3(function0, textStyle, f, f2, modifier3, shape3, j4, j3, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i8 = i2 | i11;
        } else {
            i8 = i2;
        }
        i9 = i8;
        if ((i5 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "161@7475L5,162@7539L14,163@7581L31,164@7690L11");
            char c4 = 6;
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 32) != 0) {
                    i5 &= -458753;
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i5 &= -3670017;
                } else {
                    containerColor = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                    i5 &= -29360129;
                }
                i10 = i5;
                if ((i3 & 256) != 0) {
                    z2 = false;
                    mutableInteractionSource3 = null;
                    z3 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i5 = i10 & (-234881025);
                } else {
                    z2 = false;
                    mutableInteractionSource3 = null;
                    z3 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    i5 = i10;
                }
                modifier2 = companion;
                if (i6 != 0) {
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                shape5 = shape4;
                j5 = containerColor;
                j6 = jM3051contentColorForek8zF_U;
                r11 = z3;
            } else {
                if (i14 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 32) != 0) {
                    i5 &= -458753;
                    shape4 = FloatingActionButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i5 &= -3670017;
                } else {
                    containerColor = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i5 >> 18) & 14);
                    i5 &= -29360129;
                }
                i10 = i5;
                if ((i3 & 256) != 0) {
                    z2 = false;
                    mutableInteractionSource3 = null;
                    z3 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i5 = i10 & (-234881025);
                } else {
                    z2 = false;
                    mutableInteractionSource3 = null;
                    z3 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    i5 = i10;
                }
                modifier2 = companion;
                if (i6 != 0) {
                    mutableInteractionSource4 = mutableInteractionSource3;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                shape5 = shape4;
                j5 = containerColor;
                j6 = jM3051contentColorForek8zF_U;
                r11 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(121669932, i5, i9, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:167)");
            }
            if (mutableInteractionSource4 == null) {
                composerStartRestartGroup.startReplaceGroup(-282853233);
                ComposerKt.sourceInformation(composerStartRestartGroup, "169@7882L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960707027, "CC(remember):FloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
            } else {
                composerStartRestartGroup.startReplaceGroup(960706376);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 960710786, "CC(remember):FloatingActionButton.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final long j10 = j6;
            int i111 = i5 >> 6;
            SurfaceKt.m4326Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, z2, (Function1) objRememberedValue, r11, mutableInteractionSource3), false, shape5, j5, j6, floatingActionButtonElevationM3374elevationxZ9QkE.getDefaultElevation(), floatingActionButtonElevationM3374elevationxZ9QkE.shadowElevation$material3(mutableInteractionSource5, composerStartRestartGroup, (i5 >> 21) & 112).getValue().m9701unboximpl(), null, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-1779603465, r11, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$2(j10, textStyle, f, f2, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i5 & 14) | (i111 & 7168) | (57344 & i111) | (i111 & 458752), 6, 260);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource2 = mutableInteractionSource4;
            modifier3 = modifier2;
            shape3 = shape5;
            j4 = j5;
            j3 = j6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            floatingActionButtonElevation2 = floatingActionButtonElevation;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            shape3 = shape2;
            j3 = jM3051contentColorForek8zF_U;
            j4 = j;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$3(function0, textStyle, f, f2, modifier3, shape3, j4, j3, floatingActionButtonElevation2, mutableInteractionSource2, function2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$2(long j, TextStyle textStyle, final float f, final float f2, final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C180@8411L233,180@8330L314:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1779603465, i, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:180)");
            }
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(j, textStyle, ComposableLambdaKt.rememberComposableLambda(-1767363041, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButton_lF_WlFE$lambda$2$0(f, f2, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButton_lF_WlFE$lambda$2$0(float f, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@8425L209:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1767363041, i, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:181)");
            }
            Modifier modifierM1250defaultMinSizeVpY3zN4 = SizeKt.m1250defaultMinSizeVpY3zN4(Modifier.INSTANCE, f, f2);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1250defaultMinSizeVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -339027051, "C185@8611L9:FloatingActionButton.kt#uh7d8r");
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

    /* JADX WARN: Code duplicated, block: B:106:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x0138  */
    /* JADX WARN: Code duplicated, block: B:111:0x0140  */
    /* JADX WARN: Code duplicated, block: B:112:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x015f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0165  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:123:0x018f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0195  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:135:0x0206  */
    /* JADX WARN: Code duplicated, block: B:138:0x021a  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX INFO: renamed from: SmallFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3404SmallFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape smallShape;
        int i6;
        long containerColor;
        int i7;
        long j7;
        int i8;
        MutableInteractionSource mutableInteractionSource4;
        long j8;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(26608441);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmallFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)234@11010L441:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                companion = modifier;
                i3 |= composerStartRestartGroup.changed(companion) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i13 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) == 0) {
                j3 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 24576) == 0) {
                j4 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                j4 = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@10675L10,228@10744L14,229@10786L31,230@10895L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                        } else {
                            smallShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            i6 = i3 & (-7169);
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            i6 = i3;
                            containerColor = j3;
                        }
                        if ((i2 & 16) != 0) {
                            long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                            i6 &= -57345;
                            j4 = jM3051contentColorForek8zF_U;
                        }
                        i7 = i6;
                        if ((i2 & 32) != 0) {
                            j7 = containerColor;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            j7 = containerColor;
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            i8 = 26608441;
                            mutableInteractionSource4 = null;
                        } else {
                            i8 = 26608441;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        j8 = j4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = j3;
                        j8 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = 26608441;
                        smallShape = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:233)");
                    }
                    m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabSmallTokens.INSTANCE.m5424getContainerWidthD9Ej5fM(), FabSmallTokens.INSTANCE.m5423getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    shape3 = smallShape;
                    j5 = j7;
                    j6 = j8;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    shape3 = shape2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j5 = j3;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@10675L10,228@10744L14,229@10786L31,230@10895L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U2;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 26608441;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 26608441;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U3;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 26608441;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 26608441;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:233)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabSmallTokens.INSTANCE.m5424getContainerWidthD9Ej5fM(), FabSmallTokens.INSTANCE.m5423getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = smallShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        companion = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            j3 = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            j4 = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            j4 = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@10675L10,228@10744L14,229@10786L31,230@10895L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U4 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U4;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 26608441;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 26608441;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                    } else {
                        smallShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U5 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U5;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 26608441;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 26608441;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:233)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabSmallTokens.INSTANCE.m5424getContainerWidthD9Ej5fM(), FabSmallTokens.INSTANCE.m5423getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = smallShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "227@10675L10,228@10744L14,229@10786L31,230@10895L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U6 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U6;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = 26608441;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = 26608441;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    smallShape = FloatingActionButtonDefaults.INSTANCE.getSmallShape(composerStartRestartGroup, 6);
                } else {
                    smallShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U7 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U7;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = 26608441;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = 26608441;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:233)");
            }
            m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabSmallTokens.INSTANCE.m5424getContainerWidthD9Ej5fM(), FabSmallTokens.INSTANCE.m5423getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), smallShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            shape3 = smallShape;
            j5 = j7;
            j6 = j8;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = companion;
            shape3 = shape2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j5 = j3;
            j6 = j4;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.SmallFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x0138  */
    /* JADX WARN: Code duplicated, block: B:111:0x0140  */
    /* JADX WARN: Code duplicated, block: B:112:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x015f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0165  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:123:0x018f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0195  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:135:0x0206  */
    /* JADX WARN: Code duplicated, block: B:138:0x021a  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX INFO: renamed from: MediumFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3401MediumFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape mediumShape;
        int i6;
        long containerColor;
        int i7;
        long j7;
        int i8;
        MutableInteractionSource mutableInteractionSource4;
        long j8;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1276794641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MediumFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)291@13734L443:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                companion = modifier;
                i3 |= composerStartRestartGroup.changed(companion) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i13 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) == 0) {
                j3 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 24576) == 0) {
                j4 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                j4 = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "284@13398L11,285@13468L14,286@13510L31,287@13619L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                        } else {
                            mediumShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            i6 = i3 & (-7169);
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            i6 = i3;
                            containerColor = j3;
                        }
                        if ((i2 & 16) != 0) {
                            long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                            i6 &= -57345;
                            j4 = jM3051contentColorForek8zF_U;
                        }
                        i7 = i6;
                        if ((i2 & 32) != 0) {
                            j7 = containerColor;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            j7 = containerColor;
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            i8 = -1276794641;
                            mutableInteractionSource4 = null;
                        } else {
                            i8 = -1276794641;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        j8 = j4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = j3;
                        j8 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = -1276794641;
                        mediumShape = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumFloatingActionButton (FloatingActionButton.kt:290)");
                    }
                    m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabMediumTokens.INSTANCE.m5401getContainerWidthD9Ej5fM(), FabMediumTokens.INSTANCE.m5400getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), mediumShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    shape3 = mediumShape;
                    j5 = j7;
                    j6 = j8;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    shape3 = shape2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j5 = j3;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "284@13398L11,285@13468L14,286@13510L31,287@13619L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                    } else {
                        mediumShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U2;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = -1276794641;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = -1276794641;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                    } else {
                        mediumShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U3;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = -1276794641;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = -1276794641;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumFloatingActionButton (FloatingActionButton.kt:290)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabMediumTokens.INSTANCE.m5401getContainerWidthD9Ej5fM(), FabMediumTokens.INSTANCE.m5400getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), mediumShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = mediumShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        companion = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            j3 = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            j4 = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            j4 = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "284@13398L11,285@13468L14,286@13510L31,287@13619L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                    } else {
                        mediumShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U4 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U4;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = -1276794641;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = -1276794641;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                    } else {
                        mediumShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U5 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U5;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = -1276794641;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = -1276794641;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumFloatingActionButton (FloatingActionButton.kt:290)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabMediumTokens.INSTANCE.m5401getContainerWidthD9Ej5fM(), FabMediumTokens.INSTANCE.m5400getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), mediumShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = mediumShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "284@13398L11,285@13468L14,286@13510L31,287@13619L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                } else {
                    mediumShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U6 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U6;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = -1276794641;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = -1276794641;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    mediumShape = FloatingActionButtonDefaults.INSTANCE.getMediumShape(composerStartRestartGroup, 6);
                } else {
                    mediumShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U7 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U7;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = -1276794641;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = -1276794641;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumFloatingActionButton (FloatingActionButton.kt:290)");
            }
            m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabMediumTokens.INSTANCE.m5401getContainerWidthD9Ej5fM(), FabMediumTokens.INSTANCE.m5400getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), mediumShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            shape3 = mediumShape;
            j5 = j7;
            j6 = j8;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = companion;
            shape3 = shape2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j5 = j3;
            j6 = j4;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.MediumFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x0138  */
    /* JADX WARN: Code duplicated, block: B:111:0x0140  */
    /* JADX WARN: Code duplicated, block: B:112:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x015f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0165  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:123:0x018f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0195  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:135:0x0206  */
    /* JADX WARN: Code duplicated, block: B:138:0x021a  */
    /* JADX WARN: Code duplicated, block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:54:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX INFO: renamed from: LargeFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3398LargeFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Shape shape2;
        long j3;
        long j4;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Shape largeShape;
        int i6;
        long containerColor;
        int i7;
        long j7;
        int i8;
        MutableInteractionSource mutableInteractionSource4;
        long j8;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1274576261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LargeFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)350@16537L441:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                companion = modifier;
                i3 |= composerStartRestartGroup.changed(companion) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i13 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) == 0) {
                j3 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 24576) == 0) {
                j4 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                j4 = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "343@16202L10,344@16271L14,345@16313L31,346@16422L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                        } else {
                            largeShape = shape2;
                        }
                        if ((i2 & 8) != 0) {
                            i6 = i3 & (-7169);
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            i6 = i3;
                            containerColor = j3;
                        }
                        if ((i2 & 16) != 0) {
                            long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                            i6 &= -57345;
                            j4 = jM3051contentColorForek8zF_U;
                        }
                        i7 = i6;
                        if ((i2 & 32) != 0) {
                            j7 = containerColor;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            j7 = containerColor;
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            i8 = 1274576261;
                            mutableInteractionSource4 = null;
                        } else {
                            i8 = 1274576261;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        j8 = j4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = j3;
                        j8 = j4;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = 1274576261;
                        largeShape = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:349)");
                    }
                    m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabLargeTokens.INSTANCE.m5398getContainerWidthD9Ej5fM(), FabLargeTokens.INSTANCE.m5397getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    shape3 = largeShape;
                    j5 = j7;
                    j6 = j8;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    shape3 = shape2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j5 = j3;
                    j6 = j4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "343@16202L10,344@16271L14,345@16313L31,346@16422L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U2;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 1274576261;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 1274576261;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U3;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 1274576261;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 1274576261;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:349)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabLargeTokens.INSTANCE.m5398getContainerWidthD9Ej5fM(), FabLargeTokens.INSTANCE.m5397getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = largeShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        companion = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            j3 = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            j4 = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            j4 = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "343@16202L10,344@16271L14,345@16313L31,346@16422L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U4 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U4;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 1274576261;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 1274576261;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = companion;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                    } else {
                        largeShape = shape2;
                    }
                    if ((i2 & 8) != 0) {
                        i6 = i3 & (-7169);
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        i6 = i3;
                        containerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U5 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j4 = jM3051contentColorForek8zF_U5;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = containerColor;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = containerColor;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        i8 = 1274576261;
                        mutableInteractionSource4 = null;
                    } else {
                        i8 = 1274576261;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    j8 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:349)");
                }
                m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabLargeTokens.INSTANCE.m5398getContainerWidthD9Ej5fM(), FabLargeTokens.INSTANCE.m5397getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                shape3 = largeShape;
                j5 = j7;
                j6 = j8;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                shape3 = shape2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j5 = j3;
                j6 = j4;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "343@16202L10,344@16271L14,345@16313L31,346@16422L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U6 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U6;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = 1274576261;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = 1274576261;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = companion;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    largeShape = FloatingActionButtonDefaults.INSTANCE.getLargeShape(composerStartRestartGroup, 6);
                } else {
                    largeShape = shape2;
                }
                if ((i2 & 8) != 0) {
                    i6 = i3 & (-7169);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i3;
                    containerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U7 = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j4 = jM3051contentColorForek8zF_U7;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = containerColor;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = containerColor;
                    i3 = i7;
                }
                if (i4 != 0) {
                    i8 = 1274576261;
                    mutableInteractionSource4 = null;
                } else {
                    i8 = 1274576261;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                j8 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:349)");
            }
            m3394FloatingActionButtonXz6DiA(function0, SizeKt.m1270sizeInqDBjuR0$default(companion, FabLargeTokens.INSTANCE.m5398getContainerWidthD9Ej5fM(), FabLargeTokens.INSTANCE.m5397getContainerHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), largeShape, j7, j8, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource4, function2, composerStartRestartGroup, i3 & 33554318, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            shape3 = largeShape;
            j5 = j7;
            j6 = j8;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = companion;
            shape3 = shape2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j5 = j3;
            j6 = j4;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.LargeFloatingActionButton_X_z6DiA$lambda$0(function0, modifier2, shape3, j5, j6, floatingActionButtonElevation2, mutableInteractionSource3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x018e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0197  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:129:0x0213  */
    /* JADX WARN: Code duplicated, block: B:131:0x0225  */
    /* JADX WARN: Code duplicated, block: B:134:0x023a  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x0104  */
    /* JADX INFO: renamed from: SmallExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3403SmallExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape smallExtendedFabShape;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape3;
        int i6;
        int i7;
        long j5;
        Modifier modifier3;
        long j6;
        Shape shape4;
        long j7;
        boolean z2;
        int i8;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource4;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(560925343);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmallExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)409@19371L5,418@19692L365,407@19276L781:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    smallExtendedFabShape = shape;
                    int i13 = composerStartRestartGroup.changed(smallExtendedFabShape) ? 256 : 128;
                    i3 |= i13;
                } else {
                    smallExtendedFabShape = shape;
                }
                i3 |= i13;
            } else {
                smallExtendedFabShape = shape;
            }
            if ((i & 3072) == 0) {
                containerColor = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 24576) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "400@18921L21,401@19001L14,402@19043L31,403@19152L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        shape3 = smallExtendedFabShape;
                        if ((i2 & 8) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        i6 = i3;
                        if ((i2 & 32) != 0) {
                            j5 = containerColor;
                            i7 = 6;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i6 & (-458753);
                        } else {
                            i7 = 6;
                            j5 = containerColor;
                            i3 = i6;
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            i8 = 560925343;
                            mutableInteractionSource4 = null;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            z2 = true;
                        } else {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            z2 = true;
                            i8 = 560925343;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier;
                        i7 = 6;
                        z2 = true;
                        shape4 = smallExtendedFabShape;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = containerColor;
                        j6 = jM3051contentColorForek8zF_U;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = 560925343;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:406)");
                    }
                    int i15 = (i3 & 14) | 3456;
                    int i16 = i3 << 9;
                    m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, i7), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1545824013, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i15 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (29360128 & i16) | (234881024 & i16) | (i16 & C.ENCODING_PCM_DOUBLE), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    shape2 = shape4;
                    j3 = j7;
                    j4 = j6;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    shape2 = smallExtendedFabShape;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j3 = containerColor;
                    j4 = jM3051contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "400@18921L21,401@19001L14,402@19043L31,403@19152L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = smallExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = 560925343;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = 560925343;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = smallExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = 560925343;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = 560925343;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:406)");
                }
                int i17 = (i3 & 14) | 3456;
                int i18 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, i7), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1545824013, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i17 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = smallExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                smallExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(smallExtendedFabShape)) {
                }
                i3 |= i13;
            } else {
                smallExtendedFabShape = shape;
            }
            i3 |= i13;
        } else {
            smallExtendedFabShape = shape;
        }
        if ((i & 3072) == 0) {
            containerColor = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 24576) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "400@18921L21,401@19001L14,402@19043L31,403@19152L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = smallExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = 560925343;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = 560925343;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = smallExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = 560925343;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = 560925343;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:406)");
                }
                int i19 = (i3 & 14) | 3456;
                int i110 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, i7), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1545824013, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i19 | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (234881024 & i110) | (i110 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = smallExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "400@18921L21,401@19001L14,402@19043L31,403@19152L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = smallExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = 560925343;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = 560925343;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = smallExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = 560925343;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = 560925343;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:406)");
            }
            int i111 = (i3 & 14) | 3456;
            int i112 = i3 << 9;
            m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, i7), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(1545824013, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i111 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & C.ENCODING_PCM_DOUBLE), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            shape2 = shape4;
            j3 = j7;
            j4 = j6;
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = smallExtendedFabShape;
            mutableInteractionSource3 = mutableInteractionSource2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j3 = containerColor;
            j4 = jM3051contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.SmallExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallExtendedFloatingActionButton_X_z6DiA$lambda$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C419@19702L349:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1545824013, i, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:419)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, SmallExtendedFabPaddingStart, 0.0f, SmallExtendedFabPaddingEnd, 0.0f, 10, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:105:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x018e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0197  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:129:0x0213  */
    /* JADX WARN: Code duplicated, block: B:131:0x0225  */
    /* JADX WARN: Code duplicated, block: B:134:0x023a  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x0104  */
    /* JADX INFO: renamed from: MediumExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3400MediumExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape mediumExtendedFabShape;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape3;
        int i6;
        int i7;
        long j5;
        Modifier modifier3;
        long j6;
        Shape shape4;
        long j7;
        boolean z2;
        int i8;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource4;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1729062315);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MediumExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)475@22456L5,484@22779L367,473@22360L786:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    mediumExtendedFabShape = shape;
                    int i13 = composerStartRestartGroup.changed(mediumExtendedFabShape) ? 256 : 128;
                    i3 |= i13;
                } else {
                    mediumExtendedFabShape = shape;
                }
                i3 |= i13;
            } else {
                mediumExtendedFabShape = shape;
            }
            if ((i & 3072) == 0) {
                containerColor = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 24576) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "466@22004L22,467@22085L14,468@22127L31,469@22236L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        shape3 = mediumExtendedFabShape;
                        if ((i2 & 8) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        i6 = i3;
                        if ((i2 & 32) != 0) {
                            j5 = containerColor;
                            i7 = 6;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i6 & (-458753);
                        } else {
                            i7 = 6;
                            j5 = containerColor;
                            i3 = i6;
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            i8 = -1729062315;
                            mutableInteractionSource4 = null;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            z2 = true;
                        } else {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            z2 = true;
                            i8 = -1729062315;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier;
                        i7 = 6;
                        z2 = true;
                        shape4 = mediumExtendedFabShape;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = containerColor;
                        j6 = jM3051contentColorForek8zF_U;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = -1729062315;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:472)");
                    }
                    int i15 = (i3 & 14) | 3456;
                    int i16 = i3 << 9;
                    m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, i7), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1261974617, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i15 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (29360128 & i16) | (234881024 & i16) | (i16 & C.ENCODING_PCM_DOUBLE), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    shape2 = shape4;
                    j3 = j7;
                    j4 = j6;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    shape2 = mediumExtendedFabShape;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j3 = containerColor;
                    j4 = jM3051contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "466@22004L22,467@22085L14,468@22127L31,469@22236L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = mediumExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1729062315;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1729062315;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = mediumExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1729062315;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1729062315;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:472)");
                }
                int i17 = (i3 & 14) | 3456;
                int i18 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, i7), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1261974617, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i17 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = mediumExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                mediumExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(mediumExtendedFabShape)) {
                }
                i3 |= i13;
            } else {
                mediumExtendedFabShape = shape;
            }
            i3 |= i13;
        } else {
            mediumExtendedFabShape = shape;
        }
        if ((i & 3072) == 0) {
            containerColor = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 24576) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "466@22004L22,467@22085L14,468@22127L31,469@22236L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = mediumExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1729062315;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1729062315;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = mediumExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1729062315;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1729062315;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:472)");
                }
                int i19 = (i3 & 14) | 3456;
                int i110 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, i7), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1261974617, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i19 | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (234881024 & i110) | (i110 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = mediumExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "466@22004L22,467@22085L14,468@22127L31,469@22236L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = mediumExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = -1729062315;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = -1729062315;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = mediumExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = -1729062315;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = -1729062315;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:472)");
            }
            int i111 = (i3 & 14) | 3456;
            int i112 = i3 << 9;
            m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, i7), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1261974617, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i111 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & C.ENCODING_PCM_DOUBLE), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            shape2 = shape4;
            j3 = j7;
            j4 = j6;
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = mediumExtendedFabShape;
            mutableInteractionSource3 = mutableInteractionSource2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j3 = containerColor;
            j4 = jM3051contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.MediumExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediumExtendedFloatingActionButton_X_z6DiA$lambda$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C485@22789L351:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1261974617, i, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:485)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, MediumExtendedFabPaddingStart, 0.0f, MediumExtendedFabPaddingEnd, 0.0f, 10, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:105:0x0139 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0140  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x018e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0197  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:129:0x0213  */
    /* JADX WARN: Code duplicated, block: B:131:0x0225  */
    /* JADX WARN: Code duplicated, block: B:134:0x023a  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x0104  */
    /* JADX INFO: renamed from: LargeExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3397LargeExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape largeExtendedFabShape;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape3;
        int i6;
        int i7;
        long j5;
        Modifier modifier3;
        long j6;
        Shape shape4;
        long j7;
        boolean z2;
        int i8;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        MutableInteractionSource mutableInteractionSource4;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1962379029);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LargeExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)541@25539L5,550@25860L365,539@25444L781:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    largeExtendedFabShape = shape;
                    int i13 = composerStartRestartGroup.changed(largeExtendedFabShape) ? 256 : 128;
                    i3 |= i13;
                } else {
                    largeExtendedFabShape = shape;
                }
                i3 |= i13;
            } else {
                largeExtendedFabShape = shape;
            }
            if ((i & 3072) == 0) {
                containerColor = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 24576) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "532@25089L21,533@25169L14,534@25211L31,535@25320L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        shape3 = largeExtendedFabShape;
                        if ((i2 & 8) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        i6 = i3;
                        if ((i2 & 32) != 0) {
                            j5 = containerColor;
                            i7 = 6;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i6 & (-458753);
                        } else {
                            i7 = 6;
                            j5 = containerColor;
                            i3 = i6;
                        }
                        if (i4 != 0) {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            i8 = -1962379029;
                            mutableInteractionSource4 = null;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            z2 = true;
                        } else {
                            modifier3 = companion;
                            j6 = jM3051contentColorForek8zF_U;
                            shape4 = shape3;
                            j7 = j5;
                            z2 = true;
                            i8 = -1962379029;
                            floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier;
                        i7 = 6;
                        z2 = true;
                        shape4 = largeExtendedFabShape;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j7 = containerColor;
                        j6 = jM3051contentColorForek8zF_U;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = -1962379029;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:538)");
                    }
                    int i15 = (i3 & 14) | 3456;
                    int i16 = i3 << 9;
                    m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, i7), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-977480359, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i15 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (29360128 & i16) | (234881024 & i16) | (i16 & C.ENCODING_PCM_DOUBLE), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    shape2 = shape4;
                    j3 = j7;
                    j4 = j6;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    shape2 = largeExtendedFabShape;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j3 = containerColor;
                    j4 = jM3051contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "532@25089L21,533@25169L14,534@25211L31,535@25320L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = largeExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1962379029;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1962379029;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = largeExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1962379029;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1962379029;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:538)");
                }
                int i17 = (i3 & 14) | 3456;
                int i18 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, i7), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-977480359, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i17 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (29360128 & i18) | (234881024 & i18) | (i18 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = largeExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                largeExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(largeExtendedFabShape)) {
                }
                i3 |= i13;
            } else {
                largeExtendedFabShape = shape;
            }
            i3 |= i13;
        } else {
            largeExtendedFabShape = shape;
        }
        if ((i & 3072) == 0) {
            containerColor = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 24576) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "532@25089L21,533@25169L14,534@25211L31,535@25320L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = largeExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1962379029;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1962379029;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    shape3 = largeExtendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    i6 = i3;
                    if ((i2 & 32) != 0) {
                        j5 = containerColor;
                        i7 = 6;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i6 & (-458753);
                    } else {
                        i7 = 6;
                        j5 = containerColor;
                        i3 = i6;
                    }
                    if (i4 != 0) {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        i8 = -1962379029;
                        mutableInteractionSource4 = null;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        z2 = true;
                    } else {
                        modifier3 = companion;
                        j6 = jM3051contentColorForek8zF_U;
                        shape4 = shape3;
                        j7 = j5;
                        z2 = true;
                        i8 = -1962379029;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:538)");
                }
                int i19 = (i3 & 14) | 3456;
                int i110 = i3 << 9;
                m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, i7), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-977480359, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i19 | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (29360128 & i110) | (234881024 & i110) | (i110 & C.ENCODING_PCM_DOUBLE), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape4;
                j3 = j7;
                j4 = j6;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = largeExtendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "532@25089L21,533@25169L14,534@25211L31,535@25320L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = largeExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = -1962379029;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = -1962379029;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                shape3 = largeExtendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                i6 = i3;
                if ((i2 & 32) != 0) {
                    j5 = containerColor;
                    i7 = 6;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i6 & (-458753);
                } else {
                    i7 = 6;
                    j5 = containerColor;
                    i3 = i6;
                }
                if (i4 != 0) {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    i8 = -1962379029;
                    mutableInteractionSource4 = null;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    z2 = true;
                } else {
                    modifier3 = companion;
                    j6 = jM3051contentColorForek8zF_U;
                    shape4 = shape3;
                    j7 = j5;
                    z2 = true;
                    i8 = -1962379029;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:538)");
            }
            int i111 = (i3 & 14) | 3456;
            int i112 = i3 << 9;
            m3395FloatingActionButtonlFWlFE(function0, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, i7), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, modifier3, shape4, j7, j6, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-977480359, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i111 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & C.ENCODING_PCM_DOUBLE), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            shape2 = shape4;
            j3 = j7;
            j4 = j6;
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = largeExtendedFabShape;
            mutableInteractionSource3 = mutableInteractionSource2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j3 = containerColor;
            j4 = jM3051contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.LargeExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeExtendedFloatingActionButton_X_z6DiA$lambda$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C551@25870L349:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-977480359, i, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:551)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, LargeExtendedFabPaddingStart, 0.0f, LargeExtendedFabPaddingEnd, 0.0f, 10, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:105:0x0136 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x013d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x0154  */
    /* JADX WARN: Code duplicated, block: B:116:0x0162  */
    /* JADX WARN: Code duplicated, block: B:119:0x0173  */
    /* JADX WARN: Code duplicated, block: B:120:0x0190  */
    /* JADX WARN: Code duplicated, block: B:122:0x0199  */
    /* JADX WARN: Code duplicated, block: B:123:0x019f  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:130:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:132:0x0207  */
    /* JADX WARN: Code duplicated, block: B:135:0x021c  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-X-z6DiA, reason: not valid java name */
    public static final void m3392ExtendedFloatingActionButtonXz6DiA(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape extendedFabShape;
        long containerColor;
        long j3;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z;
        final Modifier modifier2;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i6;
        long j6;
        int i7;
        long j7;
        boolean z2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        long j8;
        int i8;
        Modifier modifier3;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1039585610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)614@28824L335,606@28561L598:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    extendedFabShape = shape;
                    int i13 = composerStartRestartGroup.changed(extendedFabShape) ? 256 : 128;
                    i3 |= i13;
                } else {
                    extendedFabShape = shape;
                }
                i3 |= i13;
            } else {
                extendedFabShape = shape;
            }
            if ((i & 3072) == 0) {
                containerColor = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(containerColor)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i3 |= i11;
            } else {
                containerColor = j;
            }
            if ((i & 24576) == 0) {
                j3 = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i10 = 8192;
                } else {
                    i10 = 16384;
                }
                i3 |= i10;
            } else {
                j3 = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 131072 : 65536;
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "599@28211L16,600@28286L14,601@28328L31,602@28437L11");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        Shape shape4 = extendedFabShape;
                        if ((i2 & 8) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        i6 = i3;
                        j6 = containerColor;
                        if ((i2 & 16) != 0) {
                            long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                            i6 &= -57345;
                            j3 = jM3051contentColorForek8zF_U;
                        }
                        i7 = i6;
                        if ((i2 & 32) != 0) {
                            j7 = j6;
                            z2 = true;
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i3 = i7 & (-458753);
                        } else {
                            j7 = j6;
                            z2 = true;
                            i3 = i7;
                        }
                        if (i4 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        shape3 = shape4;
                        j8 = j7;
                        i8 = 1039585610;
                        modifier3 = companion;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        z2 = true;
                        floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j3 = j3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i8 = 1039585610;
                        modifier3 = modifier;
                        shape3 = extendedFabShape;
                        j8 = containerColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:605)");
                    }
                    m3394FloatingActionButtonXz6DiA(function0, modifier3, shape3, j8, j3, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1233936436, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j3;
                    floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    shape2 = extendedFabShape;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j4 = containerColor;
                    j5 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "599@28211L16,600@28286L14,601@28328L31,602@28437L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    Shape shape5 = extendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    i6 = i3;
                    j6 = containerColor;
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j3 = jM3051contentColorForek8zF_U2;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = j6;
                        z2 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = j6;
                        z2 = true;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape3 = shape5;
                    j8 = j7;
                    i8 = 1039585610;
                    modifier3 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    Shape shape6 = extendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    i6 = i3;
                    j6 = containerColor;
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j3 = jM3051contentColorForek8zF_U3;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = j6;
                        z2 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = j6;
                        z2 = true;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape3 = shape6;
                    j8 = j7;
                    i8 = 1039585610;
                    modifier3 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:605)");
                }
                m3394FloatingActionButtonXz6DiA(function0, modifier3, shape3, j8, j3, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1233936436, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape3;
                j4 = j8;
                j5 = j3;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = extendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j4 = containerColor;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                extendedFabShape = shape;
                if (composerStartRestartGroup.changed(extendedFabShape)) {
                }
                i3 |= i13;
            } else {
                extendedFabShape = shape;
            }
            i3 |= i13;
        } else {
            extendedFabShape = shape;
        }
        if ((i & 3072) == 0) {
            containerColor = j;
            if ((i2 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i3 |= i11;
        } else {
            containerColor = j;
        }
        if ((i & 24576) == 0) {
            j3 = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            j3 = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "599@28211L16,600@28286L14,601@28328L31,602@28437L11");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    Shape shape7 = extendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    i6 = i3;
                    j6 = containerColor;
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U4 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j3 = jM3051contentColorForek8zF_U4;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = j6;
                        z2 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = j6;
                        z2 = true;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape3 = shape7;
                    j8 = j7;
                    i8 = 1039585610;
                    modifier3 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    Shape shape8 = extendedFabShape;
                    if ((i2 & 8) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    i6 = i3;
                    j6 = containerColor;
                    if ((i2 & 16) != 0) {
                        long jM3051contentColorForek8zF_U5 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                        i6 &= -57345;
                        j3 = jM3051contentColorForek8zF_U5;
                    }
                    i7 = i6;
                    if ((i2 & 32) != 0) {
                        j7 = j6;
                        z2 = true;
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i3 = i7 & (-458753);
                    } else {
                        j7 = j6;
                        z2 = true;
                        i3 = i7;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    shape3 = shape8;
                    j8 = j7;
                    i8 = 1039585610;
                    modifier3 = companion;
                    floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:605)");
                }
                m3394FloatingActionButtonXz6DiA(function0, modifier3, shape3, j8, j3, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1233936436, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                shape2 = shape3;
                j4 = j8;
                j5 = j3;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = extendedFabShape;
                mutableInteractionSource3 = mutableInteractionSource2;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j4 = containerColor;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "599@28211L16,600@28286L14,601@28328L31,602@28437L11");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                Shape shape9 = extendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                i6 = i3;
                j6 = containerColor;
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U6 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j3 = jM3051contentColorForek8zF_U6;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = j6;
                    z2 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = j6;
                    z2 = true;
                    i3 = i7;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                shape3 = shape9;
                j8 = j7;
                i8 = 1039585610;
                modifier3 = companion;
                floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                Shape shape10 = extendedFabShape;
                if ((i2 & 8) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                i6 = i3;
                j6 = containerColor;
                if ((i2 & 16) != 0) {
                    long jM3051contentColorForek8zF_U7 = ColorSchemeKt.m3051contentColorForek8zF_U(j6, composerStartRestartGroup, (i6 >> 9) & 14);
                    i6 &= -57345;
                    j3 = jM3051contentColorForek8zF_U7;
                }
                i7 = i6;
                if ((i2 & 32) != 0) {
                    j7 = j6;
                    z2 = true;
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i3 = i7 & (-458753);
                } else {
                    j7 = j6;
                    z2 = true;
                    i3 = i7;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                shape3 = shape10;
                j8 = j7;
                i8 = 1039585610;
                modifier3 = companion;
                floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:605)");
            }
            m3394FloatingActionButtonXz6DiA(function0, modifier3, shape3, j8, j3, floatingActionButtonElevation3, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1233936436, z2, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            shape2 = shape3;
            j4 = j8;
            j5 = j3;
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = extendedFabShape;
            mutableInteractionSource3 = mutableInteractionSource2;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j4 = containerColor;
            j5 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_X_z6DiA$lambda$1(function0, modifier2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C615@28834L319:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1233936436, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:615)");
            }
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1270sizeInqDBjuR0$default(Modifier.INSTANCE, ExtendedFabMinimumWidth, 0.0f, 0.0f, 0.0f, 14, null), ExtendedFabTextPadding, 0.0f, 2, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1220paddingVpY3zN4$default);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0136  */
    /* JADX WARN: Code duplicated, block: B:110:0x014f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x018b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0190  */
    /* JADX WARN: Code duplicated, block: B:136:0x019d  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x0205  */
    /* JADX WARN: Code duplicated, block: B:155:0x0249  */
    /* JADX WARN: Code duplicated, block: B:157:0x025b  */
    /* JADX WARN: Code duplicated, block: B:160:0x026e  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    /* JADX INFO: renamed from: SmallExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m3402SmallExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape smallExtendedFabShape;
        long j3;
        int i6;
        int i7;
        int i8;
        boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        long j6;
        Shape shape3;
        long j7;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1146347203);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmallExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)679@32111L5,675@31966L647:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
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
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        smallExtendedFabShape = shape;
                        int i11 = composerStartRestartGroup.changed(smallExtendedFabShape) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        smallExtendedFabShape = shape;
                    }
                    i3 |= i11;
                } else {
                    smallExtendedFabShape = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        int i12 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                if ((12582912 & i) == 0) {
                    int i13 = i3;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i9 = 4194304;
                    } else {
                        i9 = 8388608;
                    }
                    i6 = i13 | i9;
                } else {
                    i6 = i3;
                }
                if ((i & 100663296) != 0) {
                    i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i8 = 268435456;
                        }
                        i6 |= i8;
                    }
                    if ((i6 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                                smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i6 &= -3670017;
                            } else {
                                containerColor = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                                i6 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i6 &= -234881025;
                            } else {
                                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier4 = modifier2;
                            j6 = containerColor;
                            shape3 = smallExtendedFabShape;
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            j7 = j2;
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = smallExtendedFabShape;
                            j6 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                        }
                        m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        shape2 = shape3;
                        j4 = j6;
                        j5 = j7;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = smallExtendedFabShape;
                        j4 = j3;
                        j5 = j2;
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = smallExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    smallExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(smallExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    smallExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                smallExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i14 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i14 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = smallExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = smallExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    smallExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(smallExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    smallExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                smallExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i15 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i15 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = smallExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = smallExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = smallExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                smallExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(smallExtendedFabShape)) {
                }
                i3 |= i11;
            } else {
                smallExtendedFabShape = shape;
            }
            i3 |= i11;
        } else {
            smallExtendedFabShape = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            i3 |= i12;
        } else {
            j3 = j;
        }
        if ((12582912 & i) == 0) {
            int i16 = i3;
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i6 = i16 | i9;
        } else {
            i6 = i3;
        }
        if ((i & 100663296) != 0) {
            i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
        }
        i7 = i2 & 512;
        if (i7 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i6 |= i8;
            }
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = smallExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = smallExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 805306368;
        if ((i6 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "669@31657L21,670@31737L14,671@31779L31,672@31888L11");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = smallExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    smallExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getSmallExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = smallExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1146347203, i6, -1, "androidx.compose.material3.SmallExtendedFloatingActionButton (FloatingActionButton.kt:675)");
            }
            m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(SmallExtendedFabTextStyle, composerStartRestartGroup, 6), SmallExtendedFabMinimumWidth, SmallExtendedFabMinimumHeight, SmallExtendedFabPaddingStart, SmallExtendedFabPaddingEnd, SmallExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z5;
            shape2 = shape3;
            j4 = j6;
            j5 = j7;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z4 = z2;
            shape2 = smallExtendedFabShape;
            j4 = j3;
            j5 = j2;
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.SmallExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0136  */
    /* JADX WARN: Code duplicated, block: B:110:0x014f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x018b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0190  */
    /* JADX WARN: Code duplicated, block: B:136:0x019d  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x0205  */
    /* JADX WARN: Code duplicated, block: B:155:0x0249  */
    /* JADX WARN: Code duplicated, block: B:157:0x025b  */
    /* JADX WARN: Code duplicated, block: B:160:0x026e  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    /* JADX INFO: renamed from: MediumExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m3399MediumExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape mediumExtendedFabShape;
        long j3;
        int i6;
        int i7;
        int i8;
        boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        long j6;
        Shape shape3;
        long j7;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-685923341);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MediumExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)747@35570L5,743@35424L653:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
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
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        mediumExtendedFabShape = shape;
                        int i11 = composerStartRestartGroup.changed(mediumExtendedFabShape) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        mediumExtendedFabShape = shape;
                    }
                    i3 |= i11;
                } else {
                    mediumExtendedFabShape = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        int i12 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                if ((12582912 & i) == 0) {
                    int i13 = i3;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i9 = 4194304;
                    } else {
                        i9 = 8388608;
                    }
                    i6 = i13 | i9;
                } else {
                    i6 = i3;
                }
                if ((i & 100663296) != 0) {
                    i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i8 = 268435456;
                        }
                        i6 |= i8;
                    }
                    if ((i6 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                                mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i6 &= -3670017;
                            } else {
                                containerColor = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                                i6 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i6 &= -234881025;
                            } else {
                                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier4 = modifier2;
                            j6 = containerColor;
                            shape3 = mediumExtendedFabShape;
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            j7 = j2;
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = mediumExtendedFabShape;
                            j6 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                        }
                        m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        shape2 = shape3;
                        j4 = j6;
                        j5 = j7;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = mediumExtendedFabShape;
                        j4 = j3;
                        j5 = j2;
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = mediumExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    mediumExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(mediumExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    mediumExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                mediumExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i14 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i14 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = mediumExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = mediumExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    mediumExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(mediumExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    mediumExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                mediumExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i15 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i15 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = mediumExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = mediumExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = mediumExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                mediumExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(mediumExtendedFabShape)) {
                }
                i3 |= i11;
            } else {
                mediumExtendedFabShape = shape;
            }
            i3 |= i11;
        } else {
            mediumExtendedFabShape = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            i3 |= i12;
        } else {
            j3 = j;
        }
        if ((12582912 & i) == 0) {
            int i16 = i3;
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i6 = i16 | i9;
        } else {
            i6 = i3;
        }
        if ((i & 100663296) != 0) {
            i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
        }
        i7 = i2 & 512;
        if (i7 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i6 |= i8;
            }
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = mediumExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = mediumExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 805306368;
        if ((i6 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "737@35114L22,738@35195L14,739@35237L31,740@35346L11");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = mediumExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    mediumExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getMediumExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = mediumExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-685923341, i6, -1, "androidx.compose.material3.MediumExtendedFloatingActionButton (FloatingActionButton.kt:743)");
            }
            m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(MediumExtendedFabTextStyle, composerStartRestartGroup, 6), MediumExtendedFabMinimumWidth, MediumExtendedFabMinimumHeight, MediumExtendedFabPaddingStart, MediumExtendedFabPaddingEnd, MediumExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z5;
            shape2 = shape3;
            j4 = j6;
            j5 = j7;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z4 = z2;
            shape2 = mediumExtendedFabShape;
            j4 = j3;
            j5 = j2;
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.MediumExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0136  */
    /* JADX WARN: Code duplicated, block: B:110:0x014f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x018b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0190  */
    /* JADX WARN: Code duplicated, block: B:136:0x019d  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:144:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x0205  */
    /* JADX WARN: Code duplicated, block: B:155:0x0249  */
    /* JADX WARN: Code duplicated, block: B:157:0x025b  */
    /* JADX WARN: Code duplicated, block: B:160:0x026e  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    /* JADX INFO: renamed from: LargeExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m3396LargeExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape largeExtendedFabShape;
        long j3;
        int i6;
        int i7;
        int i8;
        boolean z3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        long j6;
        Shape shape3;
        long j7;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-844339831);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LargeExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)815@39027L5,811@38882L647:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
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
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        largeExtendedFabShape = shape;
                        int i11 = composerStartRestartGroup.changed(largeExtendedFabShape) ? 131072 : 65536;
                        i3 |= i11;
                    } else {
                        largeExtendedFabShape = shape;
                    }
                    i3 |= i11;
                } else {
                    largeExtendedFabShape = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j;
                        int i12 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                if ((12582912 & i) == 0) {
                    int i13 = i3;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i9 = 4194304;
                    } else {
                        i9 = 8388608;
                    }
                    i6 = i13 | i9;
                } else {
                    i6 = i3;
                }
                if ((i & 100663296) != 0) {
                    i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
                }
                i7 = i2 & 512;
                if (i7 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i8 = 268435456;
                        }
                        i6 |= i8;
                    }
                    if ((i6 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                                largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 64) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i6 &= -3670017;
                            } else {
                                containerColor = j3;
                            }
                            if ((i2 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                                i6 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i6 &= -234881025;
                            } else {
                                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier4 = modifier2;
                            j6 = containerColor;
                            shape3 = largeExtendedFabShape;
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i6 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i6 &= -234881025;
                            }
                            j7 = j2;
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = largeExtendedFabShape;
                            j6 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                        }
                        m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        shape2 = shape3;
                        j4 = j6;
                        j5 = j7;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = largeExtendedFabShape;
                        j4 = j3;
                        j5 = j2;
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 805306368;
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = largeExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    largeExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(largeExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    largeExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                largeExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i14 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i14 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = largeExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = largeExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    largeExtendedFabShape = shape;
                    if (composerStartRestartGroup.changed(largeExtendedFabShape)) {
                    }
                    i3 |= i11;
                } else {
                    largeExtendedFabShape = shape;
                }
                i3 |= i11;
            } else {
                largeExtendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((12582912 & i) == 0) {
                int i15 = i3;
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 = i15 | i9;
            } else {
                i6 = i3;
            }
            if ((i & 100663296) != 0) {
                i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
            }
            i7 = i2 & 512;
            if (i7 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i6 |= i8;
                }
                if ((i6 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                            largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            containerColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                            i6 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i6 &= -234881025;
                        } else {
                            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        j6 = containerColor;
                        shape3 = largeExtendedFabShape;
                        j7 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                    }
                    m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j6;
                    j5 = j7;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = largeExtendedFabShape;
                    j4 = j3;
                    j5 = j2;
                    floatingActionButtonElevation2 = floatingActionButtonElevation;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 805306368;
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = largeExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                largeExtendedFabShape = shape;
                if (composerStartRestartGroup.changed(largeExtendedFabShape)) {
                }
                i3 |= i11;
            } else {
                largeExtendedFabShape = shape;
            }
            i3 |= i11;
        } else {
            largeExtendedFabShape = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            i3 |= i12;
        } else {
            j3 = j;
        }
        if ((12582912 & i) == 0) {
            int i16 = i3;
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i6 = i16 | i9;
        } else {
            i6 = i3;
        }
        if ((i & 100663296) != 0) {
            i6 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 33554432 : 67108864;
        }
        i7 = i2 & 512;
        if (i7 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i6 |= i8;
            }
            if ((i6 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 32) != 0) {
                        i6 &= -458753;
                        largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        containerColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                        i6 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i6 &= -234881025;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    j6 = containerColor;
                    shape3 = largeExtendedFabShape;
                    j7 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
                }
                m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                j4 = j6;
                j5 = j7;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = largeExtendedFabShape;
                j4 = j3;
                j5 = j2;
                floatingActionButtonElevation2 = floatingActionButtonElevation;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 805306368;
        if ((i6 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "805@38573L21,806@38653L14,807@38695L31,808@38804L11");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = largeExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 == 0) {
                }
                if ((i2 & 32) != 0) {
                    i6 &= -458753;
                    largeExtendedFabShape = FloatingActionButtonDefaults.INSTANCE.getLargeExtendedFabShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    containerColor = j3;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 18) & 14);
                    i6 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i6 &= -234881025;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                j6 = containerColor;
                shape3 = largeExtendedFabShape;
                j7 = jM3051contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-844339831, i6, -1, "androidx.compose.material3.LargeExtendedFloatingActionButton (FloatingActionButton.kt:811)");
            }
            m3393ExtendedFloatingActionButtonqtIzBjc(function2, function3, function1, TypographyKt.getValue(LargeExtendedFabTextStyle, composerStartRestartGroup, 6), LargeExtendedFabMinimumWidth, LargeExtendedFabMinimumHeight, LargeExtendedFabPaddingStart, LargeExtendedFabPaddingEnd, LargeExtendedFabIconPadding, modifier4, z5, shape3, j6, j7, floatingActionButtonElevationM3374elevationxZ9QkE, mutableInteractionSource3, composerStartRestartGroup, (i6 & 14) | 115040256 | (i6 & 112) | (i6 & 896) | (1879048192 & (i6 << 18)), (i6 >> 12) & 524286, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z5;
            shape2 = shape3;
            j4 = j6;
            j5 = j7;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z4 = z2;
            shape2 = largeExtendedFabShape;
            j4 = j3;
            j5 = j2;
            floatingActionButtonElevation2 = floatingActionButtonElevation;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.LargeExtendedFloatingActionButton_ElI5_7k$lambda$0(function2, function3, function0, modifier3, z4, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0122  */
    /* JADX WARN: Code duplicated, block: B:103:0x0124  */
    /* JADX WARN: Code duplicated, block: B:106:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0145  */
    /* JADX WARN: Code duplicated, block: B:124:0x016b A[PHI: r6 r8 r9 r10 r12 r17 r20
      0x016b: PHI (r6v9 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r8v6 boolean) = (r8v3 boolean), (r8v2 boolean) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r9v15 androidx.compose.ui.graphics.Shape) = (r9v10 androidx.compose.ui.graphics.Shape), (r9v7 androidx.compose.ui.graphics.Shape) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r10v7 long) = (r10v4 long), (r10v3 long) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r12v11 androidx.compose.material3.FloatingActionButtonElevation) = 
      (r12v5 androidx.compose.material3.FloatingActionButtonElevation)
      (r12v2 androidx.compose.material3.FloatingActionButtonElevation)
     binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r17v16 int) = (r17v9 int), (r17v20 int) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]
      0x016b: PHI (r20v5 long) = (r20v2 long), (r20v6 long) binds: [B:143:0x01d8, B:123:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0179  */
    /* JADX WARN: Code duplicated, block: B:129:0x0180  */
    /* JADX WARN: Code duplicated, block: B:132:0x0186  */
    /* JADX WARN: Code duplicated, block: B:135:0x0195  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x01da  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:150:0x0232  */
    /* JADX WARN: Code duplicated, block: B:152:0x0243  */
    /* JADX WARN: Code duplicated, block: B:155:0x0257  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0101  */
    /* JADX WARN: Code duplicated, block: B:96:0x0109  */
    /* JADX WARN: Code duplicated, block: B:97:0x010c  */
    /* JADX INFO: renamed from: ExtendedFloatingActionButton-ElI5-7k, reason: not valid java name */
    public static final void m3391ExtendedFloatingActionButtonElI57k(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        Shape extendedFabShape;
        long containerColor;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        int i6;
        int i7;
        int i8;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j3;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final long j4;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM3051contentColorForek8zF_U;
        MutableInteractionSource mutableInteractionSource3;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1161000600);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)889@42652L1159,881@42389L1422:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
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
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        extendedFabShape = shape;
                        int i12 = composerStartRestartGroup.changed(extendedFabShape) ? 131072 : 65536;
                        i3 |= i12;
                    } else {
                        extendedFabShape = shape;
                    }
                    i3 |= i12;
                } else {
                    extendedFabShape = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        containerColor = j;
                        int i13 = composerStartRestartGroup.changed(containerColor) ? 1048576 : 524288;
                        i3 |= i13;
                    } else {
                        containerColor = j;
                    }
                    i3 |= i13;
                } else {
                    containerColor = j;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i10 = 4194304;
                    } else {
                        i10 = 8388608;
                    }
                    i3 |= i10;
                }
                if ((i & 100663296) == 0) {
                    if ((i2 & 256) == 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                        int i14 = composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE) ? 67108864 : 33554432;
                        i3 |= i14;
                    } else {
                        floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    }
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i6 = i2 & 512;
                if (i6 != 0) {
                    if ((805306368 & i) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i7 = 268435456;
                        }
                        i3 |= i7;
                    }
                    i8 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 32) != 0) {
                                extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i8 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                                i8 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i2 & 256) != 0) {
                                floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                                i8 &= -234881025;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource3 = null;
                            }
                            long j5 = containerColor;
                            FloatingActionButtonElevation floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                            i9 = i8;
                            Shape shape3 = extendedFabShape;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                            }
                            int i15 = i9 >> 6;
                            int i16 = i9 >> 9;
                            Modifier modifier4 = modifier2;
                            m3394FloatingActionButtonXz6DiA(function0, modifier4, shape3, j5, jM3051contentColorForek8zF_U, floatingActionButtonElevation3, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 12582912 | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (i16 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z2;
                            modifier3 = modifier4;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = jM3051contentColorForek8zF_U;
                            floatingActionButtonElevation2 = floatingActionButtonElevation3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i8 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            jM3051contentColorForek8zF_U = j2;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        long j6 = containerColor;
                        FloatingActionButtonElevation floatingActionButtonElevation4 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        i9 = i8;
                        Shape shape4 = extendedFabShape;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                        }
                        int i17 = i9 >> 6;
                        int i18 = i9 >> 9;
                        Modifier modifier5 = modifier2;
                        m3394FloatingActionButtonXz6DiA(function0, modifier5, shape4, j6, jM3051contentColorForek8zF_U, floatingActionButtonElevation4, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 12582912 | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z2;
                        modifier3 = modifier5;
                        shape2 = shape4;
                        j3 = j6;
                        j4 = jM3051contentColorForek8zF_U;
                        floatingActionButtonElevation2 = floatingActionButtonElevation4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = extendedFabShape;
                        j3 = containerColor;
                        floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                        j4 = j2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i8 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    long j7 = containerColor;
                    FloatingActionButtonElevation floatingActionButtonElevation5 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    i9 = i8;
                    Shape shape5 = extendedFabShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                    }
                    int i19 = i9 >> 6;
                    int i110 = i9 >> 9;
                    Modifier modifier6 = modifier2;
                    m3394FloatingActionButtonXz6DiA(function0, modifier6, shape5, j7, jM3051contentColorForek8zF_U, floatingActionButtonElevation5, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 112) | (i19 & 14) | 12582912 | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z2;
                    modifier3 = modifier6;
                    shape2 = shape5;
                    j3 = j7;
                    j4 = jM3051contentColorForek8zF_U;
                    floatingActionButtonElevation2 = floatingActionButtonElevation5;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = extendedFabShape;
                    j3 = containerColor;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j4 = j2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    extendedFabShape = shape;
                    if (composerStartRestartGroup.changed(extendedFabShape)) {
                    }
                    i3 |= i12;
                } else {
                    extendedFabShape = shape;
                }
                i3 |= i12;
            } else {
                extendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    containerColor = j;
                    if (composerStartRestartGroup.changed(containerColor)) {
                    }
                    i3 |= i13;
                } else {
                    containerColor = j;
                }
                i3 |= i13;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((i & 100663296) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                    }
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                if ((805306368 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    long j8 = containerColor;
                    FloatingActionButtonElevation floatingActionButtonElevation6 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    i9 = i8;
                    Shape shape6 = extendedFabShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                    }
                    int i111 = i9 >> 6;
                    int i112 = i9 >> 9;
                    Modifier modifier7 = modifier2;
                    m3394FloatingActionButtonXz6DiA(function0, modifier7, shape6, j8, jM3051contentColorForek8zF_U, floatingActionButtonElevation6, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i111 & 112) | (i111 & 14) | 12582912 | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z2;
                    modifier3 = modifier7;
                    shape2 = shape6;
                    j3 = j8;
                    j4 = jM3051contentColorForek8zF_U;
                    floatingActionButtonElevation2 = floatingActionButtonElevation6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = extendedFabShape;
                    j3 = containerColor;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j4 = j2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i8 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                long j9 = containerColor;
                FloatingActionButtonElevation floatingActionButtonElevation7 = floatingActionButtonElevationM3374elevationxZ9QkE;
                i9 = i8;
                Shape shape7 = extendedFabShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                }
                int i113 = i9 >> 6;
                int i114 = i9 >> 9;
                Modifier modifier8 = modifier2;
                m3394FloatingActionButtonXz6DiA(function0, modifier8, shape7, j9, jM3051contentColorForek8zF_U, floatingActionButtonElevation7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 12582912 | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z2;
                modifier3 = modifier8;
                shape2 = shape7;
                j3 = j9;
                j4 = jM3051contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation7;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = extendedFabShape;
                j3 = containerColor;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j4 = j2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    extendedFabShape = shape;
                    if (composerStartRestartGroup.changed(extendedFabShape)) {
                    }
                    i3 |= i12;
                } else {
                    extendedFabShape = shape;
                }
                i3 |= i12;
            } else {
                extendedFabShape = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    containerColor = j;
                    if (composerStartRestartGroup.changed(containerColor)) {
                    }
                    i3 |= i13;
                } else {
                    containerColor = j;
                }
                i3 |= i13;
            } else {
                containerColor = j;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((i & 100663296) == 0) {
                if ((i2 & 256) == 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                    if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                    }
                    i3 |= i14;
                } else {
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i6 = i2 & 512;
            if (i6 != 0) {
                if ((805306368 & i) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i7 = 268435456;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                            i8 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i8 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                            i8 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i2 & 256) != 0) {
                            floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                            i8 &= -234881025;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    long j10 = containerColor;
                    FloatingActionButtonElevation floatingActionButtonElevation8 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    i9 = i8;
                    Shape shape8 = extendedFabShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                    }
                    int i115 = i9 >> 6;
                    int i116 = i9 >> 9;
                    Modifier modifier9 = modifier2;
                    m3394FloatingActionButtonXz6DiA(function0, modifier9, shape8, j10, jM3051contentColorForek8zF_U, floatingActionButtonElevation8, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i115 & 112) | (i115 & 14) | 12582912 | (i116 & 896) | (i116 & 7168) | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z2;
                    modifier3 = modifier9;
                    shape2 = shape8;
                    j3 = j10;
                    j4 = jM3051contentColorForek8zF_U;
                    floatingActionButtonElevation2 = floatingActionButtonElevation8;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = extendedFabShape;
                    j3 = containerColor;
                    floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                    j4 = j2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i8 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                long j11 = containerColor;
                FloatingActionButtonElevation floatingActionButtonElevation9 = floatingActionButtonElevationM3374elevationxZ9QkE;
                i9 = i8;
                Shape shape9 = extendedFabShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                }
                int i117 = i9 >> 6;
                int i118 = i9 >> 9;
                Modifier modifier10 = modifier2;
                m3394FloatingActionButtonXz6DiA(function0, modifier10, shape9, j11, jM3051contentColorForek8zF_U, floatingActionButtonElevation9, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i117 & 112) | (i117 & 14) | 12582912 | (i118 & 896) | (i118 & 7168) | (57344 & i118) | (458752 & i118) | (i118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z2;
                modifier3 = modifier10;
                shape2 = shape9;
                j3 = j11;
                j4 = jM3051contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation9;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = extendedFabShape;
                j3 = containerColor;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j4 = j2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                extendedFabShape = shape;
                if (composerStartRestartGroup.changed(extendedFabShape)) {
                }
                i3 |= i12;
            } else {
                extendedFabShape = shape;
            }
            i3 |= i12;
        } else {
            extendedFabShape = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i13;
            } else {
                containerColor = j;
            }
            i3 |= i13;
        } else {
            containerColor = j;
        }
        if ((i & 12582912) != 0) {
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i3 |= i10;
        }
        if ((i & 100663296) == 0) {
            if ((i2 & 256) == 0) {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                if (composerStartRestartGroup.changed(floatingActionButtonElevationM3374elevationxZ9QkE)) {
                }
                i3 |= i14;
            } else {
                floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
            }
            i3 |= i14;
        } else {
            floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
        }
        i6 = i2 & 512;
        if (i6 != 0) {
            if ((805306368 & i) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i7 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i7 = 268435456;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                        i8 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i8 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                        i8 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                        i8 &= -234881025;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                long j12 = containerColor;
                FloatingActionButtonElevation floatingActionButtonElevation10 = floatingActionButtonElevationM3374elevationxZ9QkE;
                i9 = i8;
                Shape shape10 = extendedFabShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
                }
                int i119 = i9 >> 6;
                int i1110 = i9 >> 9;
                Modifier modifier11 = modifier2;
                m3394FloatingActionButtonXz6DiA(function0, modifier11, shape10, j12, jM3051contentColorForek8zF_U, floatingActionButtonElevation10, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i119 & 112) | (i119 & 14) | 12582912 | (i1110 & 896) | (i1110 & 7168) | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z2;
                modifier3 = modifier11;
                shape2 = shape10;
                j3 = j12;
                j4 = jM3051contentColorForek8zF_U;
                floatingActionButtonElevation2 = floatingActionButtonElevation10;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = extendedFabShape;
                j3 = containerColor;
                floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
                j4 = j2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        i8 = i3;
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "875@42085L16,876@42160L14,877@42202L31,878@42311L11");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i8 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i8 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                if (i6 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i8 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i8 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i8 >> 18) & 14);
                    i8 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    i8 &= -234881025;
                }
                if (i6 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            long j13 = containerColor;
            FloatingActionButtonElevation floatingActionButtonElevation11 = floatingActionButtonElevationM3374elevationxZ9QkE;
            i9 = i8;
            Shape shape11 = extendedFabShape;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161000600, i9, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:880)");
            }
            int i1111 = i9 >> 6;
            int i1112 = i9 >> 9;
            Modifier modifier12 = modifier2;
            m3394FloatingActionButtonXz6DiA(function0, modifier12, shape11, j13, jM3051contentColorForek8zF_U, floatingActionButtonElevation11, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(632971498, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0(z2, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i1111 & 112) | (i1111 & 14) | 12582912 | (i1112 & 896) | (i1112 & 7168) | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z2;
            modifier3 = modifier12;
            shape2 = shape11;
            j3 = j13;
            j4 = jM3051contentColorForek8zF_U;
            floatingActionButtonElevation2 = floatingActionButtonElevation11;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            shape2 = extendedFabShape;
            j3 = containerColor;
            floatingActionButtonElevation2 = floatingActionButtonElevationM3374elevationxZ9QkE;
            j4 = j2;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$1(function2, function3, function0, modifier3, z4, shape2, j3, j4, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$0(boolean z, Function2 function2, final Function2 function3, Composer composer, int i) {
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        float fM5395getContainerWidthD9Ej5fM;
        ComposerKt.sourceInformation(composer, "C893@42814L991:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632971498, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:890)");
            }
            if (z) {
                fM9687constructorimpl = ExtendedFabStartIconPadding;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            float f = fM9687constructorimpl;
            if (z) {
                fM9687constructorimpl2 = ExtendedFabTextPadding;
            } else {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            }
            float f2 = fM9687constructorimpl2;
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                fM5395getContainerWidthD9Ej5fM = ExtendedFabMinimumWidth;
            } else {
                fM5395getContainerWidthD9Ej5fM = FabBaselineTokens.INSTANCE.m5395getContainerWidthD9Ej5fM();
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1270sizeInqDBjuR0$default(companion, fM5395getContainerWidthD9Ej5fM, 0.0f, 0.0f, 0.0f, 14, null), f, 0.0f, f2, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical start = z ? arrangement.getStart() : arrangement.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -145916491, "C907@43411L6,910@43510L28,911@43563L30,912@43609L186,908@43430L365:FloatingActionButton.kt#uh7d8r");
            function2.invoke(composer, 0);
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z, (Modifier) null, extendedFabExpandAnimation(composer, 0), extendedFabCollapseAnimation(composer, 0), (String) null, ComposableLambdaKt.rememberComposableLambda(-660008666, true, new Function3() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0$0$0(function3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 18);
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
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$0$0$0(Function2 function2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C913@43661L2,913@43627L154:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-660008666, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:913)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1386833448, "CC(remember):FloatingActionButton.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_ElI5_7k$lambda$0$0$0$0$0((SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue);
        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierClearAndSetSemantics);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1331490131, "C914@43687L49,915@43757L6:FloatingActionButton.kt#uh7d8r");
        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, ExtendedFabEndIconPadding), composer, 6);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$0$0$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: ExtendedFloatingActionButton-qtIzBjc, reason: not valid java name */
    private static final void m3393ExtendedFloatingActionButtonqtIzBjc(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, final TextStyle textStyle, final float f, final float f2, final float f3, final float f4, final float f5, Modifier modifier, boolean z, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        long j3;
        Composer composer2;
        final Modifier modifier2;
        final boolean z2;
        final Shape shape2;
        final long j4;
        final long j5;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        boolean z3;
        Shape extendedFabShape;
        int i6;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        FloatingActionButtonElevation floatingActionButtonElevationM3374elevationxZ9QkE;
        MutableInteractionSource mutableInteractionSource3;
        long j6;
        Shape shape3;
        long j7;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(193103278);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExtendedFloatingActionButton)N(text,icon,onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,startPadding:c#ui.unit.Dp,endPadding:c#ui.unit.Dp,iconPadding:c#ui.unit.Dp,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)952@44870L1923,941@44505L2288:FloatingActionButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i8 = 1024;
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i4 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i4 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i4 |= composerStartRestartGroup.changed(f5) ? 67108864 : 33554432;
        }
        int i9 = i3 & 512;
        if (i9 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i10 = i3 & 1024;
        if (i10 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= ((i3 & 2048) == 0 && composerStartRestartGroup.changed(shape)) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= ((i3 & 4096) == 0 && composerStartRestartGroup.changed(j)) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            j3 = j2;
            if ((i3 & 8192) == 0 && composerStartRestartGroup.changed(j3)) {
                i8 = 2048;
            }
            i5 |= i8;
        } else {
            j3 = j2;
        }
        if ((i2 & 24576) == 0) {
            i5 |= ((i3 & 16384) == 0 && composerStartRestartGroup.changed(floatingActionButtonElevation)) ? 16384 : 8192;
        }
        int i11 = i3 & 32768;
        if (i11 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i5 & 74899) == 74898) ? false : true, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "935@44201L16,936@44276L14,937@44318L31,938@44427L11");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 2048) != 0) {
                    i5 &= -113;
                }
                i7 = i5;
                if ((i3 & 4096) != 0) {
                    i7 &= -897;
                }
                if ((i3 & 8192) != 0) {
                    i7 &= -7169;
                }
                if ((i3 & 16384) != 0) {
                    i7 &= -57345;
                }
                companion = modifier;
                z3 = z;
                shape3 = shape;
                j7 = j;
                floatingActionButtonElevation3 = floatingActionButtonElevation;
                mutableInteractionSource3 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                j6 = j3;
            } else {
                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                z3 = i10 != 0 ? true : z;
                if ((i3 & 2048) != 0) {
                    extendedFabShape = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(composerStartRestartGroup, 6);
                    i5 &= -113;
                } else {
                    extendedFabShape = shape;
                }
                int i12 = i5;
                if ((i3 & 4096) != 0) {
                    i6 = i12 & (-897);
                    containerColor = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    i6 = i12;
                    containerColor = j;
                }
                if ((i3 & 8192) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i6 >> 6) & 14);
                    i6 &= -7169;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                long j8 = containerColor;
                if ((i3 & 16384) != 0) {
                    floatingActionButtonElevationM3374elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m3374elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 24576, 15);
                    composer2 = composerStartRestartGroup;
                    i6 &= -57345;
                } else {
                    composer2 = composerStartRestartGroup;
                    floatingActionButtonElevationM3374elevationxZ9QkE = floatingActionButtonElevation;
                }
                mutableInteractionSource3 = i11 != 0 ? null : mutableInteractionSource;
                j6 = jM3051contentColorForek8zF_U;
                shape3 = extendedFabShape;
                j7 = j8;
                floatingActionButtonElevation3 = floatingActionButtonElevationM3374elevationxZ9QkE;
                i7 = i6;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(193103278, i4, i7, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:940)");
            }
            final boolean z4 = z3;
            int i13 = i4 >> 6;
            int i14 = (i13 & 112) | (i13 & 14) | 3456 | ((i4 >> 15) & 57344);
            int i15 = i7 << 12;
            Modifier modifier3 = companion;
            m3395FloatingActionButtonlFWlFE(function0, textStyle, Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM(), modifier3, shape3, j7, j6, floatingActionButtonElevation3, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-827388388, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0(z4, f, f2, f3, f4, function3, f5, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, i14 | (458752 & i15) | (3670016 & i15) | (29360128 & i15) | (234881024 & i15) | (i15 & C.ENCODING_PCM_DOUBLE), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            mutableInteractionSource2 = mutableInteractionSource3;
            j5 = j6;
            shape2 = shape3;
            j4 = j7;
            z2 = z4;
            modifier2 = modifier3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            z2 = z;
            shape2 = shape;
            j4 = j;
            j5 = j2;
            floatingActionButtonElevation2 = floatingActionButtonElevation;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$1(function2, function3, function0, textStyle, f, f2, f3, f4, f5, modifier2, z2, shape2, j4, j5, floatingActionButtonElevation2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ExtendedFloatingActionButton_qtIzBjc$lambda$0$4$0(float f, State state, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int iLerp = MathHelpersKt.lerp(measureScope.mo748roundToPx0680j_4(f), measurable.maxIntrinsicWidth(Constraints.m9639getMaxHeightimpl(constraints.getValue())), ((Number) state.getValue()).floatValue());
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, iLerp, placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$4$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$0$4$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$0$0(Transition transition) {
        return ((Number) transition.getCurrentState()).floatValue() == 0.0f && !transition.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$2$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier animateFloatingActionButton$default(Modifier modifier, boolean z, Alignment alignment, float f, AnimationSpec animationSpec, AnimationSpec animationSpec2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = FloatingActionButtonDefaults.INSTANCE.getShowHideTargetScale$material3();
        }
        return animateFloatingActionButton(modifier, z, alignment, f, (i & 8) != 0 ? null : animationSpec, (i & 16) != 0 ? null : animationSpec2);
    }

    public static final Modifier animateFloatingActionButton(Modifier modifier, boolean z, Alignment alignment, float f, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        return modifier.then(new FabVisibleModifier(z, alignment, f, animationSpec, animationSpec2));
    }

    static {
        float f = 12;
        MediumExtendedFabIconPadding = Dp.m9687constructorimpl(f);
        float f2 = 16;
        LargeExtendedFabIconPadding = Dp.m9687constructorimpl(f2);
        ExtendedFabStartIconPadding = Dp.m9687constructorimpl(f2);
        ExtendedFabEndIconPadding = Dp.m9687constructorimpl(f);
    }

    private static final ExitTransition extendedFabCollapseAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -56172201, "C(extendedFabCollapseAnimation)1466@65956L7,1469@66065L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-56172201, i, -1, "androidx.compose.material3.extendedFabCollapseAnimation (FloatingActionButton.kt:1464)");
        }
        ExitTransition exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), Alignment.INSTANCE.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return exitTransitionPlus;
    }

    private static final EnterTransition extendedFabExpandAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -719787506, "C(extendedFabExpandAnimation)1477@66334L7,1480@66440L7:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-719787506, i, -1, "androidx.compose.material3.extendedFabExpandAnimation (FloatingActionButton.kt:1475)");
        }
        EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), 0.0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6), Alignment.INSTANCE.getStart(), false, null, 12, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterTransitionPlus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$0(boolean z, final float f, float f2, float f3, float f4, Function2 function2, float f5, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C953@44903L68,955@45114L14,956@45198L14,958@45278L59,960@45403L62,963@45534L435,961@45474L1313:FloatingActionButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-827388388, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:953)");
            }
            final Transition transitionUpdateTransition = TransitionKt.updateTransition(Float.valueOf(z ? 1.0f : 0.0f), "expanded state", composer, 48, 0);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            Function3 function4 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$0(finiteAnimationSpecValue, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            float fFloatValue = ((Number) transitionUpdateTransition.getCurrentState()).floatValue();
            composer.startReplaceGroup(-157343033);
            ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:958)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Float fValueOf = Float.valueOf(fFloatValue);
            float fFloatValue2 = ((Number) transitionUpdateTransition.getTargetState()).floatValue();
            composer.startReplaceGroup(-157343033);
            ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:958)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(fFloatValue2), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter, "FloatAnimation", composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function3 function5 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$2(finiteAnimationSpecValue2, (Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            float fFloatValue3 = ((Number) transitionUpdateTransition.getCurrentState()).floatValue();
            composer.startReplaceGroup(175363167);
            ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:960)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(fFloatValue3);
            float fFloatValue4 = ((Number) transitionUpdateTransition.getTargetState()).floatValue();
            composer.startReplaceGroup(175363167);
            ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:960)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(fFloatValue4), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "FloatAnimation", composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -551269425, "CC(remember):FloatingActionButton.kt#9igjgp");
            boolean zChanged = composer.changed(f) | composer.changed(stateCreateTransitionAnimation);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$4$0(f, stateCreateTransitionAnimation, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1270sizeInqDBjuR0$default(LayoutModifierKt.layout(companion, (Function3) objRememberedValue), f, f2, 0.0f, 0.0f, 12, null), f3, 0.0f, f4, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 65394718, "C974@46196L6,976@46252L196:FloatingActionButton.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -2076099068, "CC(remember):FloatingActionButton.kt#9igjgp");
            boolean zChanged2 = composer.changed(transitionUpdateTransition);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$0$0(transitionUpdateTransition));
                    }
                });
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (((Boolean) ((State) objRememberedValue2).getValue()).booleanValue()) {
                composer.startReplaceGroup(19549282);
            } else {
                composer.startReplaceGroup(65675329);
                ComposerKt.sourceInformation(composer, "983@46561L2,984@46603L39,982@46506L257");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2076089374, "CC(remember):FloatingActionButton.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) objRememberedValue3);
                ComposerKt.sourceInformationMarkerStart(composer, -2076087993, "CC(remember):FloatingActionButton.kt#9igjgp");
                boolean zChanged3 = composer.changed(stateCreateTransitionAnimation2);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonKt.ExtendedFloatingActionButton_qtIzBjc$lambda$0$5$2$0(stateCreateTransitionAnimation2, (GraphicsLayerScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierClearAndSetSemantics, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -545340570, "C986@46683L35,987@46739L6:FloatingActionButton.kt#uh7d8r");
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, f5), composer, 0);
                function3.invoke(composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
