package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b&\b'\u0018\u00002\u00020\u0001:\u0006¥\u0001¦\u0001§\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0016J'\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J'\u0010\u001d\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J'\u0010\u001d\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020&2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"J8\u0010\u001d\u001a\u00020\u00172\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0(\"\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\"¢\u0006\u0002\u0010)J.\u0010*\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b0\u00101J.\u00102\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b3\u00101J.\u00104\u001a\u0002052\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b6\u00107J:\u00108\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=J.\u0010>\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b?\u00101J¾\u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020/2\b\b\u0002\u0010G\u001a\u00020/2\b\b\u0002\u0010H\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\bV\u0010WJª\u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010X\u001a\u00020/2\b\b\u0002\u0010Y\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\bZ\u0010[J \u0001\u0010@\u001a\u00020 2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010-0(\"\u0004\u0018\u00010-2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010\\\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020Q2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020Tø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0094\u0001\u0010_\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0001\u0010`\u001a\u00020\u00072\b\b\u0001\u0010a\u001a\u00020\u00072\b\b\u0002\u0010b\u001a\u00020B2\b\b\u0002\u0010c\u001a\u00020/2\b\b\u0002\u0010d\u001a\u00020/2\b\b\u0002\u0010e\u001a\u00020;2\b\b\u0002\u0010f\u001a\u00020;2\u000e\b\u0002\u0010g\u001a\b\u0012\u0004\u0012\u00020h0(2\u000e\b\u0002\u0010i\u001a\b\u0012\u0004\u0012\u00020j0(2\b\b\u0002\u0010k\u001a\u00020lø\u0001\u0000¢\u0006\u0004\bm\u0010nJ\u0018\u0010o\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\u000e\u0010o\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010t\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bu\u0010rJ\u000e\u0010t\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010v\u001a\u0002052\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bw\u0010xJ\u000e\u0010v\u001a\u0002052\u0006\u0010s\u001a\u00020QJ\u0018\u0010y\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\bz\u0010rJ\u000e\u0010y\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010{\u001a\u00020+2\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b|\u0010rJ\u000e\u0010{\u001a\u00020+2\u0006\u0010s\u001a\u00020QJ\u0018\u0010}\u001a\u0002052\u0006\u0010p\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b~\u0010xJ\u000e\u0010}\u001a\u0002052\u0006\u0010s\u001a\u00020QJ\b\u0010\u007f\u001a\u00020\u0007H\u0002J-\u0010\u0080\u0001\u001a\u00020$2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\u0003\u0010\u0083\u0001J<\u0010\u0084\u0001\u001a\u00020 2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u00109\u001a\u00020/2\b\b\u0002\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010=J0\u0010\u0086\u0001\u001a\u00020+2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0005\b\u0087\u0001\u00101J0\u0010\u0088\u0001\u001a\u0002052\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\b\b\u0002\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0005\b\u0089\u0001\u00107J-\u0010\u008a\u0001\u001a\u00020&2\u0012\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0(\"\u00020-2\n\b\u0002\u0010\u0081\u0001\u001a\u00030\u0082\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0015\u0010\u008c\u0001\u001a\u00020B2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u00172\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0092\u0001\u001a\u00020\u0004*\u00020-H\u0000¢\u0006\u0003\b\u0093\u0001Jz\u0010\u0094\u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0095\u0001\u001a\u00020/2\t\b\u0002\u0010\u0096\u0001\u001a\u00020/2\t\b\u0002\u0010\u0097\u0001\u001a\u00020/2\t\b\u0002\u0010\u0098\u0001\u001a\u00020/2\t\b\u0002\u0010\u0099\u0001\u001a\u00020/2\t\b\u0002\u0010\u009a\u0001\u001a\u00020/2\t\b\u0002\u0010\u009b\u0001\u001a\u00020/2\t\b\u0002\u0010\u009c\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001JN\u0010 \u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0095\u0001\u001a\u00020/2\t\b\u0002\u0010\u0097\u0001\u001a\u00020/2\t\b\u0002\u0010\u0099\u0001\u001a\u00020/2\t\b\u0002\u0010\u009b\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001JN\u0010£\u0001\u001a\u00020-*\u00020-2\t\b\u0002\u0010\u0096\u0001\u001a\u00020/2\t\b\u0002\u0010\u0098\u0001\u001a\u00020/2\t\b\u0002\u0010\u009a\u0001\u001a\u00020/2\t\b\u0002\u0010\u009c\u0001\u001a\u00020/2\t\b\u0002\u0010\u009d\u0001\u001a\u00020Qø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¢\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00148\u0004X\u0085\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006¨\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "", "()V", "extendFrom", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "HelpersStartId", "", "containerObject", "getContainerObject$annotations", "getContainerObject", "()Landroidx/constraintlayout/core/parser/CLObject;", "helperId", "helpersHashCode", "getHelpersHashCode$annotations", "getHelpersHashCode", "()I", "setHelpersHashCode", "(I)V", "tasks", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "getTasks$annotations", "getTasks", "()Ljava/util/List;", "applyTo", "state", "constrain", "Landroidx/constraintlayout/compose/ConstrainScope;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "constrainBlock", "Lkotlin/ExtensionFunctionType;", "Landroidx/constraintlayout/compose/HorizontalChainScope;", "Landroidx/constraintlayout/compose/HorizontalChainReference;", "Landroidx/constraintlayout/compose/VerticalChainScope;", "Landroidx/constraintlayout/compose/VerticalChainReference;", "refs", "", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "createAbsoluteLeftBarrier", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "elements", "Landroidx/constraintlayout/compose/LayoutReference;", ViewProps.MARGIN, "Landroidx/compose/ui/unit/Dp;", "createAbsoluteLeftBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/LayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "createAbsoluteRightBarrier", "createAbsoluteRightBarrier-3ABfNKs", "createBottomBarrier", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createBottomBarrier-3ABfNKs", "([Landroidx/constraintlayout/compose/LayoutReference;F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createColumn", "spacing", "weights", "", "createColumn-lG28NQ4", "([Landroidx/constraintlayout/compose/LayoutReference;F[F)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createEndBarrier", "createEndBarrier-3ABfNKs", "createFlow", "flowVertically", "", "verticalGap", "horizontalGap", "maxElement", ViewProps.PADDING_LEFT, ViewProps.PADDING_TOP, ViewProps.PADDING_RIGHT, ViewProps.PADDING_BOTTOM, "wrapMode", "Landroidx/constraintlayout/compose/Wrap;", "verticalAlign", "Landroidx/constraintlayout/compose/VerticalAlign;", "horizontalAlign", "Landroidx/constraintlayout/compose/HorizontalAlign;", "horizontalFlowBias", "", "verticalFlowBias", "verticalStyle", "Landroidx/constraintlayout/compose/FlowStyle;", "horizontalStyle", "createFlow-Fgo90cY", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFFFFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_VERTICAL, "createFlow-6oEtc9w", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", ViewProps.PADDING, "createFlow-IkjhEj4", "([Landroidx/constraintlayout/compose/LayoutReference;ZFFIFLandroidx/constraintlayout/compose/Wrap;Landroidx/constraintlayout/compose/VerticalAlign;Landroidx/constraintlayout/compose/HorizontalAlign;FFLandroidx/constraintlayout/compose/FlowStyle;Landroidx/constraintlayout/compose/FlowStyle;)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createGrid", "rows", "columns", "isHorizontalArrangement", "verticalSpacing", "horizontalSpacing", "rowWeights", "columnWeights", "skips", "Landroidx/constraintlayout/compose/Skip;", "spans", "Landroidx/constraintlayout/compose/Span;", "flags", "Landroidx/constraintlayout/compose/GridFlag;", "createGrid-Hu23Yyw", "([Landroidx/constraintlayout/compose/LayoutReference;IIZFF[F[F[Landroidx/constraintlayout/compose/Skip;[Landroidx/constraintlayout/compose/Span;I)Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createGuidelineFromAbsoluteLeft", "offset", "createGuidelineFromAbsoluteLeft-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "fraction", "createGuidelineFromAbsoluteRight", "createGuidelineFromAbsoluteRight-0680j_4", "createGuidelineFromBottom", "createGuidelineFromBottom-0680j_4", "(F)Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "createGuidelineFromEnd", "createGuidelineFromEnd-0680j_4", "createGuidelineFromStart", "createGuidelineFromStart-0680j_4", "createGuidelineFromTop", "createGuidelineFromTop-0680j_4", "createHelperId", "createHorizontalChain", "chainStyle", "Landroidx/constraintlayout/compose/ChainStyle;", "([Landroidx/constraintlayout/compose/LayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/HorizontalChainReference;", "createRow", "createRow-lG28NQ4", "createStartBarrier", "createStartBarrier-3ABfNKs", "createTopBarrier", "createTopBarrier-3ABfNKs", "createVerticalChain", "([Landroidx/constraintlayout/compose/LayoutReference;Landroidx/constraintlayout/compose/ChainStyle;)Landroidx/constraintlayout/compose/VerticalChainReference;", "equals", "other", "hashCode", "reset", "updateHelpersHashCode", "value", "asCLContainer", "asCLContainer$constraintlayout_compose_release", "withChainParams", "startMargin", "topMargin", "endMargin", "bottomMargin", "startGoneMargin", "topGoneMargin", "endGoneMargin", "bottomGoneMargin", "weight", "withChainParams-ouYQatA", "(Landroidx/constraintlayout/compose/LayoutReference;FFFFFFFFF)Landroidx/constraintlayout/compose/LayoutReference;", "withHorizontalChainParams", "withHorizontalChainParams-YLPp7PM", "(Landroidx/constraintlayout/compose/LayoutReference;FFFFF)Landroidx/constraintlayout/compose/LayoutReference;", "withVerticalChainParams", "withVerticalChainParams-YLPp7PM", "BaselineAnchor", "HorizontalAnchor", "VerticalAnchor", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private final int HelpersStartId;
    private final CLObject containerObject;
    private int helperId;
    private int helpersHashCode;
    private final List<Function1<State, Unit>> tasks;

    public static /* synthetic */ void getContainerObject$annotations() {
    }

    public static /* synthetic */ void getHelpersHashCode$annotations() {
    }

    @Deprecated(message = "Tasks is unused, it breaks the immutability promise.")
    protected static /* synthetic */ void getTasks$annotations() {
    }

    public ConstraintLayoutBaseScope(CLObject cLObject) {
        CLObject cLObjectMo10168clone;
        this.tasks = new ArrayList();
        this.containerObject = (cLObject == null || (cLObjectMo10168clone = cLObject.mo10168clone()) == null) ? new CLObject(new char[0]) : cLObjectMo10168clone;
        this.HelpersStartId = 1000;
        this.helperId = 1000;
    }

    public ConstraintLayoutBaseScope() {
        this(null);
    }

    protected final List<Function1<State, Unit>> getTasks() {
        return this.tasks;
    }

    public final CLObject getContainerObject() {
        return this.containerObject;
    }

    public final void applyTo(State state) throws CLParsingException {
        ConstraintSetParser.populateState(this.containerObject, state, new ConstraintSetParser.LayoutVariables());
    }

    public void reset() {
        this.containerObject.clear();
        this.helperId = this.HelpersStartId;
        this.helpersHashCode = 0;
    }

    public final int getHelpersHashCode() {
        return this.helpersHashCode;
    }

    public final void setHelpersHashCode(int i) {
        this.helpersHashCode = i;
    }

    private final void updateHelpersHashCode(int value) {
        this.helpersHashCode = ((this.helpersHashCode * 1009) + value) % 1000000007;
    }

    private final int createHelperId() {
        int i = this.helperId;
        this.helperId = i + 1;
        return i;
    }

    /* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "", "id", FirebaseAnalytics.Param.INDEX, "", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;ILandroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getIndex$constraintlayout_compose_release", "()I", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", "component2$constraintlayout_compose_release", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VerticalAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public static /* synthetic */ VerticalAnchor copy$default(VerticalAnchor verticalAnchor, Object obj, int i, LayoutReference layoutReference, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = verticalAnchor.id;
            }
            if ((i2 & 2) != 0) {
                i = verticalAnchor.index;
            }
            if ((i2 & 4) != 0) {
                layoutReference = verticalAnchor.reference;
            }
            return verticalAnchor.copy(obj, i, layoutReference);
        }

        /* JADX INFO: renamed from: component1$constraintlayout_compose_release, reason: from getter */
        public final Object getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2$constraintlayout_compose_release, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LayoutReference getReference() {
            return this.reference;
        }

        public final VerticalAnchor copy(Object id, int index, LayoutReference reference) {
            return new VerticalAnchor(id, index, reference);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerticalAnchor)) {
                return false;
            }
            VerticalAnchor verticalAnchor = (VerticalAnchor) other;
            return Intrinsics.areEqual(this.id, verticalAnchor.id) && this.index == verticalAnchor.index && Intrinsics.areEqual(this.reference, verticalAnchor.reference);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "VerticalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public VerticalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    /* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "", "id", FirebaseAnalytics.Param.INDEX, "", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;ILandroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getIndex$constraintlayout_compose_release", "()I", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", "component2$constraintlayout_compose_release", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class HorizontalAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public static /* synthetic */ HorizontalAnchor copy$default(HorizontalAnchor horizontalAnchor, Object obj, int i, LayoutReference layoutReference, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = horizontalAnchor.id;
            }
            if ((i2 & 2) != 0) {
                i = horizontalAnchor.index;
            }
            if ((i2 & 4) != 0) {
                layoutReference = horizontalAnchor.reference;
            }
            return horizontalAnchor.copy(obj, i, layoutReference);
        }

        /* JADX INFO: renamed from: component1$constraintlayout_compose_release, reason: from getter */
        public final Object getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2$constraintlayout_compose_release, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LayoutReference getReference() {
            return this.reference;
        }

        public final HorizontalAnchor copy(Object id, int index, LayoutReference reference) {
            return new HorizontalAnchor(id, index, reference);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HorizontalAnchor)) {
                return false;
            }
            HorizontalAnchor horizontalAnchor = (HorizontalAnchor) other;
            return Intrinsics.areEqual(this.id, horizontalAnchor.id) && this.index == horizontalAnchor.index && Intrinsics.areEqual(this.reference, horizontalAnchor.reference);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "HorizontalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public HorizontalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    /* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00020\u0001HÀ\u0003¢\u0006\u0002\b\u000bJ\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "", "id", TypedValues.Custom.S_REFERENCE, "Landroidx/constraintlayout/compose/LayoutReference;", "(Ljava/lang/Object;Landroidx/constraintlayout/compose/LayoutReference;)V", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "getReference", "()Landroidx/constraintlayout/compose/LayoutReference;", "component1", "component1$constraintlayout_compose_release", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class BaselineAnchor {
        public static final int $stable = 0;
        private final Object id;
        private final LayoutReference reference;

        public static /* synthetic */ BaselineAnchor copy$default(BaselineAnchor baselineAnchor, Object obj, LayoutReference layoutReference, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = baselineAnchor.id;
            }
            if ((i & 2) != 0) {
                layoutReference = baselineAnchor.reference;
            }
            return baselineAnchor.copy(obj, layoutReference);
        }

        /* JADX INFO: renamed from: component1$constraintlayout_compose_release, reason: from getter */
        public final Object getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LayoutReference getReference() {
            return this.reference;
        }

        public final BaselineAnchor copy(Object id, LayoutReference reference) {
            return new BaselineAnchor(id, reference);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BaselineAnchor)) {
                return false;
            }
            BaselineAnchor baselineAnchor = (BaselineAnchor) other;
            return Intrinsics.areEqual(this.id, baselineAnchor.id) && Intrinsics.areEqual(this.reference, baselineAnchor.reference);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "BaselineAnchor(id=" + this.id + ", reference=" + this.reference + ')';
        }

        public BaselineAnchor(Object obj, LayoutReference layoutReference) {
            this.id = obj;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final LayoutReference getReference() {
            return this.reference;
        }
    }

    public final HorizontalChainScope constrain(HorizontalChainReference ref, Function1<? super HorizontalChainScope, Unit> constrainBlock) {
        HorizontalChainScope horizontalChainScope = new HorizontalChainScope(ref.getId(), asCLContainer$constraintlayout_compose_release(ref));
        constrainBlock.invoke(horizontalChainScope);
        return horizontalChainScope;
    }

    public final VerticalChainScope constrain(VerticalChainReference ref, Function1<? super VerticalChainScope, Unit> constrainBlock) {
        VerticalChainScope verticalChainScope = new VerticalChainScope(ref.getId(), asCLContainer$constraintlayout_compose_release(ref));
        constrainBlock.invoke(verticalChainScope);
        return verticalChainScope;
    }

    public final ConstrainScope constrain(ConstrainedLayoutReference ref, Function1<? super ConstrainScope, Unit> constrainBlock) {
        ConstrainScope constrainScope = new ConstrainScope(ref.getId(), asCLContainer$constraintlayout_compose_release(ref));
        constrainBlock.invoke(constrainScope);
        return constrainScope;
    }

    /* JADX INFO: renamed from: createGuidelineFromStart-0680j_4, reason: not valid java name */
    public final VerticalAnchor m10007createGuidelineFromStart0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("start", offset);
        updateHelpersHashCode(1);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createGuidelineFromAbsoluteLeft-0680j_4, reason: not valid java name */
    public final VerticalAnchor m10003createGuidelineFromAbsoluteLeft0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("left", offset);
        updateHelpersHashCode(2);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromStart(float fraction) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from("start"));
        cLArray.add(new CLNumber(fraction));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.put("percent", cLArray);
        updateHelpersHashCode(3);
        updateHelpersHashCode(Float.hashCode(fraction));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromAbsoluteLeft(float fraction) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("percent", fraction);
        updateHelpersHashCode(4);
        updateHelpersHashCode(Float.hashCode(fraction));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createGuidelineFromEnd-0680j_4, reason: not valid java name */
    public final VerticalAnchor m10006createGuidelineFromEnd0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("end", offset);
        updateHelpersHashCode(5);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createGuidelineFromAbsoluteRight-0680j_4, reason: not valid java name */
    public final VerticalAnchor m10004createGuidelineFromAbsoluteRight0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("right", offset);
        updateHelpersHashCode(6);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromEnd(float fraction) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from("end"));
        cLArray.add(new CLNumber(fraction));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.put("percent", cLArray);
        updateHelpersHashCode(3);
        updateHelpersHashCode(Float.hashCode(fraction));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final VerticalAnchor createGuidelineFromAbsoluteRight(float fraction) {
        return createGuidelineFromAbsoluteLeft(1.0f - fraction);
    }

    /* JADX INFO: renamed from: createGuidelineFromTop-0680j_4, reason: not valid java name */
    public final HorizontalAnchor m10008createGuidelineFromTop0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("start", offset);
        updateHelpersHashCode(7);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new HorizontalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final HorizontalAnchor createGuidelineFromTop(float fraction) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("percent", fraction);
        updateHelpersHashCode(8);
        updateHelpersHashCode(Float.hashCode(fraction));
        return new HorizontalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createGuidelineFromBottom-0680j_4, reason: not valid java name */
    public final HorizontalAnchor m10005createGuidelineFromBottom0680j_4(float offset) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "hGuideline");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("end", offset);
        updateHelpersHashCode(9);
        updateHelpersHashCode(Dp.m9693hashCodeimpl(offset));
        return new HorizontalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    public final HorizontalAnchor createGuidelineFromBottom(float fraction) {
        return createGuidelineFromTop(1.0f - fraction);
    }

    /* JADX INFO: renamed from: createStartBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m10010createStartBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "start");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(10);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createAbsoluteLeftBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m9994createAbsoluteLeftBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "left");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(11);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createTopBarrier-3ABfNKs, reason: not valid java name */
    public final HorizontalAnchor m10011createTopBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", ViewProps.TOP);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(12);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new HorizontalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createEndBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m9998createEndBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "end");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(13);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createAbsoluteRightBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m9995createAbsoluteRightBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "right");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(14);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new VerticalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createBottomBarrier-3ABfNKs, reason: not valid java name */
    public final HorizontalAnchor m9996createBottomBarrier3ABfNKs(LayoutReference[] elements, float margin) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        LayoutReferenceImpl layoutReferenceImpl2 = layoutReferenceImpl;
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", ViewProps.BOTTOM);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber(ViewProps.MARGIN, margin);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(15);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m9693hashCodeimpl(margin));
        return new HorizontalAnchor(layoutReferenceImpl.getId(), 0, layoutReferenceImpl2);
    }

    /* JADX INFO: renamed from: createFlow-IkjhEj4, reason: not valid java name */
    public final ConstrainedLayoutReference m10001createFlowIkjhEj4(LayoutReference[] elements, boolean flowVertically, float verticalGap, float horizontalGap, int maxElement, float padding, Wrap wrapMode, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float horizontalFlowBias, float verticalFlowBias, FlowStyle verticalStyle, FlowStyle horizontalStyle) {
        return m10000createFlowFgo90cY((LayoutReference[]) Arrays.copyOf(elements, elements.length), flowVertically, verticalGap, horizontalGap, maxElement, padding, padding, padding, padding, wrapMode, verticalAlign, horizontalAlign, horizontalFlowBias, verticalFlowBias, verticalStyle, horizontalStyle);
    }

    /* JADX INFO: renamed from: createFlow-6oEtc9w, reason: not valid java name */
    public final ConstrainedLayoutReference m9999createFlow6oEtc9w(LayoutReference[] elements, boolean flowVertically, float verticalGap, float horizontalGap, int maxElement, float paddingHorizontal, float paddingVertical, Wrap wrapMode, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float horizontalFlowBias, float verticalFlowBias, FlowStyle verticalStyle, FlowStyle horizontalStyle) {
        return m10000createFlowFgo90cY((LayoutReference[]) Arrays.copyOf(elements, elements.length), flowVertically, verticalGap, horizontalGap, maxElement, paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical, wrapMode, verticalAlign, horizontalAlign, horizontalFlowBias, verticalFlowBias, verticalStyle, horizontalStyle);
    }

    /* JADX INFO: renamed from: createFlow-Fgo90cY, reason: not valid java name */
    public final ConstrainedLayoutReference m10000createFlowFgo90cY(LayoutReference[] elements, boolean flowVertically, float verticalGap, float horizontalGap, int maxElement, float paddingLeft, float paddingTop, float paddingRight, float paddingBottom, Wrap wrapMode, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float horizontalFlowBias, float verticalFlowBias, FlowStyle verticalStyle, FlowStyle horizontalStyle) {
        ConstrainedLayoutReference constrainedLayoutReference = new ConstrainedLayoutReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            if (layoutReference != null) {
                cLArray.add(CLString.from(layoutReference.getId().toString()));
            }
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(new CLNumber(paddingLeft));
        cLArray2.add(new CLNumber(paddingTop));
        cLArray2.add(new CLNumber(paddingRight));
        cLArray2.add(new CLNumber(paddingBottom));
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(constrainedLayoutReference);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", flowVertically ? "vFlow" : "hFlow");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("vGap", verticalGap);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("hGap", horizontalGap);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("maxElement", maxElement);
        cLObjectAsCLContainer$constraintlayout_compose_release.put(ViewProps.PADDING, cLArray2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("wrap", wrapMode.getName());
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("vAlign", verticalAlign.getName());
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("hAlign", horizontalAlign.getName());
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("hFlowBias", horizontalFlowBias);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("vFlowBias", verticalFlowBias);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("vStyle", verticalStyle.getName());
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("hStyle", horizontalStyle.getName());
        updateHelpersHashCode(16);
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            LayoutReference layoutReference2 = elements[i];
            updateHelpersHashCode(layoutReference2 != null ? layoutReference2.hashCode() : 0);
        }
        return constrainedLayoutReference;
    }

    /* JADX INFO: renamed from: createRow-lG28NQ4, reason: not valid java name */
    public final ConstrainedLayoutReference m10009createRowlG28NQ4(LayoutReference[] elements, float spacing, float[] weights) {
        if (!(weights.length == 0) && elements.length != weights.length) {
            throw new IllegalArgumentException("Number of weights (" + weights.length + ") should match number of elements (" + elements.length + ").");
        }
        return m9987createGridHu23Yyw$default(this, (LayoutReference[]) Arrays.copyOf(elements, elements.length), 1, 0, false, 0.0f, spacing, null, weights, null, null, 0, 1880, null);
    }

    /* JADX INFO: renamed from: createColumn-lG28NQ4, reason: not valid java name */
    public final ConstrainedLayoutReference m9997createColumnlG28NQ4(LayoutReference[] elements, float spacing, float[] weights) {
        if (!(weights.length == 0) && elements.length != weights.length) {
            throw new IllegalArgumentException("Number of weights (" + weights.length + ") should match number of elements (" + elements.length + ").");
        }
        return m9987createGridHu23Yyw$default(this, (LayoutReference[]) Arrays.copyOf(elements, elements.length), 0, 1, false, spacing, 0.0f, weights, null, null, null, 0, 1960, null);
    }

    /* JADX INFO: renamed from: createGrid-Hu23Yyw, reason: not valid java name */
    public final ConstrainedLayoutReference m10002createGridHu23Yyw(LayoutReference[] elements, int rows, int columns, boolean isHorizontalArrangement, float verticalSpacing, float horizontalSpacing, float[] rowWeights, float[] columnWeights, Skip[] skips, Span[] spans, int flags) {
        if (!(rowWeights.length == 0) && rows > 0 && rows != rowWeights.length) {
            throw new IllegalArgumentException("Number of weights (" + rowWeights.length + ") should match number of rows (" + rows + ").");
        }
        if (!(columnWeights.length == 0) && columns > 0 && columns != columnWeights.length) {
            throw new IllegalArgumentException("Number of weights (" + columnWeights.length + ") should match number of columns (" + columns + ").");
        }
        ConstrainedLayoutReference constrainedLayoutReference = new ConstrainedLayoutReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            cLArray.add(CLString.from(layoutReference.getId().toString()));
        }
        String strJoinToString$default = rowWeights.length > 1 ? ArraysKt.joinToString$default(rowWeights, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : "";
        String strJoinToString$default2 = columnWeights.length > 1 ? ArraysKt.joinToString$default(columnWeights, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : "";
        String strJoinToString$default3 = !(skips.length == 0) ? ArraysKt.joinToString$default(skips, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Skip, CharSequence>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGrid$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Skip skip) {
                return m10015invokefXgvMDs(skip.m10144unboximpl());
            }

            /* JADX INFO: renamed from: invoke-fXgvMDs, reason: not valid java name */
            public final CharSequence m10015invokefXgvMDs(String str) {
                return str;
            }
        }, 30, (Object) null) : "";
        String strJoinToString$default4 = spans.length == 0 ? "" : ArraysKt.joinToString$default(spans, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Span, CharSequence>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGrid$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Span span) {
                return m10016invoke56oDYsA(span.m10153unboximpl());
            }

            /* JADX INFO: renamed from: invoke-56oDYsA, reason: not valid java name */
            public final CharSequence m10016invoke56oDYsA(String str) {
                return str;
            }
        }, 30, (Object) null);
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(constrainedLayoutReference);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "grid");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("orientation", isHorizontalArrangement ? 0.0f : 1.0f);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("rows", rows);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("columns", columns);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("vGap", verticalSpacing);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("hGap", horizontalSpacing);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("rowWeights", strJoinToString$default);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("columnWeights", strJoinToString$default2);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("skips", strJoinToString$default3);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("spans", strJoinToString$default4);
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("flags", flags);
        return constrainedLayoutReference;
    }

    public static /* synthetic */ HorizontalChainReference createHorizontalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createHorizontalChain");
        }
        if ((i & 2) != 0) {
            chainStyle = ChainStyle.INSTANCE.getSpread();
        }
        return constraintLayoutBaseScope.createHorizontalChain(layoutReferenceArr, chainStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.constraintlayout.core.parser.CLArray] */
    public final HorizontalChainReference createHorizontalChain(LayoutReference[] elements, ChainStyle chainStyle) {
        ?? From;
        HorizontalChainReference horizontalChainReference = new HorizontalChainReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            Object obj = layoutReference.helperParamsMap.get(Reflection.getOrCreateKotlinClass(ChainParams.class).getSimpleName());
            if (!(obj instanceof ChainParams)) {
                obj = null;
            }
            ChainParams chainParams = (ChainParams) obj;
            if (chainParams != null) {
                From = new CLArray(new char[0]);
                From.add(CLString.from(layoutReference.getId().toString()));
                From.add(new CLNumber(chainParams.getWeight()));
                From.add(new CLNumber(chainParams.getStartMargin()));
                From.add(new CLNumber(chainParams.getEndMargin()));
                From.add(new CLNumber(chainParams.getStartGoneMargin()));
                From.add(new CLNumber(chainParams.getEndGoneMargin()));
            } else {
                From = CLString.from(layoutReference.getId().toString());
            }
            cLArray.add((CLElement) From);
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(CLString.from(chainStyle.getName()));
        Float bias = chainStyle.getBias();
        cLArray2.add(new CLNumber(bias != null ? bias.floatValue() : 0.5f));
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(horizontalChainReference);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "hChain");
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("style", cLArray2);
        updateHelpersHashCode(16);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return horizontalChainReference;
    }

    public static /* synthetic */ VerticalChainReference createVerticalChain$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, ChainStyle chainStyle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createVerticalChain");
        }
        if ((i & 2) != 0) {
            chainStyle = ChainStyle.INSTANCE.getSpread();
        }
        return constraintLayoutBaseScope.createVerticalChain(layoutReferenceArr, chainStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.constraintlayout.core.parser.CLArray] */
    public final VerticalChainReference createVerticalChain(LayoutReference[] elements, ChainStyle chainStyle) {
        ?? From;
        VerticalChainReference verticalChainReference = new VerticalChainReference(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : elements) {
            Object obj = layoutReference.helperParamsMap.get(Reflection.getOrCreateKotlinClass(ChainParams.class).getSimpleName());
            if (!(obj instanceof ChainParams)) {
                obj = null;
            }
            ChainParams chainParams = (ChainParams) obj;
            if (chainParams != null) {
                From = new CLArray(new char[0]);
                From.add(CLString.from(layoutReference.getId().toString()));
                From.add(new CLNumber(chainParams.getWeight()));
                From.add(new CLNumber(chainParams.getTopMargin()));
                From.add(new CLNumber(chainParams.getBottomMargin()));
                From.add(new CLNumber(chainParams.getTopGoneMargin()));
                From.add(new CLNumber(chainParams.getBottomGoneMargin()));
            } else {
                From = CLString.from(layoutReference.getId().toString());
            }
            cLArray.add((CLElement) From);
        }
        CLArray cLArray2 = new CLArray(new char[0]);
        cLArray2.add(CLString.from(chainStyle.getName()));
        Float bias = chainStyle.getBias();
        cLArray2.add(new CLNumber(bias != null ? bias.floatValue() : 0.5f));
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(verticalChainReference);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "vChain");
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("style", cLArray2);
        updateHelpersHashCode(17);
        for (LayoutReference layoutReference2 : elements) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(chainStyle.hashCode());
        return verticalChainReference;
    }

    /* JADX INFO: renamed from: withChainParams-ouYQatA, reason: not valid java name */
    public final LayoutReference m10012withChainParamsouYQatA(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        layoutReference.setHelperParams$constraintlayout_compose_release(new ChainParams(f, f2, f3, f4, f5, f6, f7, f8, f9, null));
        return layoutReference;
    }

    public final CLObject asCLContainer$constraintlayout_compose_release(LayoutReference layoutReference) {
        String string = layoutReference.getId().toString();
        if (this.containerObject.getObjectOrNull(string) == null) {
            this.containerObject.put(string, new CLObject(new char[0]));
        }
        return this.containerObject.getObject(string);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ConstraintLayoutBaseScope) {
            return Intrinsics.areEqual(this.containerObject, ((ConstraintLayoutBaseScope) other).containerObject);
        }
        return false;
    }

    public int hashCode() {
        return this.containerObject.hashCode();
    }

    public final void constrain(ConstrainedLayoutReference[] refs, Function1<? super ConstrainScope, Unit> constrainBlock) {
        for (ConstrainedLayoutReference constrainedLayoutReference : refs) {
            constrain(constrainedLayoutReference, constrainBlock);
        }
    }

    /* JADX INFO: renamed from: createStartBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m9989createStartBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createStartBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m10010createStartBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createAbsoluteLeftBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m9979createAbsoluteLeftBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteLeftBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m9994createAbsoluteLeftBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createTopBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m9990createTopBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTopBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m10011createTopBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createEndBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m9983createEndBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createEndBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m9998createEndBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createAbsoluteRightBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ VerticalAnchor m9980createAbsoluteRightBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAbsoluteRightBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m9995createAbsoluteRightBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createBottomBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m9981createBottomBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m9996createBottomBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createFlow-IkjhEj4$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9986createFlowIkjhEj4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f4, float f5, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-IkjhEj4");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        return constraintLayoutBaseScope.m10001createFlowIkjhEj4(layoutReferenceArr, z, f, (i2 & 8) != 0 ? Dp.m9687constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m9687constructorimpl(0) : f3, (i2 & 64) != 0 ? Wrap.INSTANCE.getNone() : wrap, (i2 & 128) != 0 ? VerticalAlign.INSTANCE.getCenter() : verticalAlign, (i2 & 256) != 0 ? HorizontalAlign.INSTANCE.getCenter() : horizontalAlign, (i2 & 512) != 0 ? 0.0f : f4, (i2 & 1024) == 0 ? f5 : 0.0f, (i2 & 2048) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle, (i2 & 4096) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle2);
    }

    /* JADX INFO: renamed from: createFlow-6oEtc9w$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9984createFlow6oEtc9w$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f5, float f6, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-6oEtc9w");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        return constraintLayoutBaseScope.m9999createFlow6oEtc9w(layoutReferenceArr, z, (i2 & 4) != 0 ? Dp.m9687constructorimpl(0) : f, (i2 & 8) != 0 ? Dp.m9687constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m9687constructorimpl(0) : f3, (i2 & 64) != 0 ? Dp.m9687constructorimpl(0) : f4, (i2 & 128) != 0 ? Wrap.INSTANCE.getNone() : wrap, (i2 & 256) != 0 ? VerticalAlign.INSTANCE.getCenter() : verticalAlign, (i2 & 512) != 0 ? HorizontalAlign.INSTANCE.getCenter() : horizontalAlign, (i2 & 1024) != 0 ? 0.0f : f5, (i2 & 2048) == 0 ? f6 : 0.0f, (i2 & 4096) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle, (i2 & 8192) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle2);
    }

    /* JADX INFO: renamed from: createFlow-Fgo90cY$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9985createFlowFgo90cY$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, boolean z, float f, float f2, int i, float f3, float f4, float f5, float f6, Wrap wrap, VerticalAlign verticalAlign, HorizontalAlign horizontalAlign, float f7, float f8, FlowStyle flowStyle, FlowStyle flowStyle2, int i2, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m10000createFlowFgo90cY(layoutReferenceArr, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? Dp.m9687constructorimpl(0) : f, (i2 & 8) != 0 ? Dp.m9687constructorimpl(0) : f2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? Dp.m9687constructorimpl(0) : f3, (i2 & 64) != 0 ? Dp.m9687constructorimpl(0) : f4, (i2 & 128) != 0 ? Dp.m9687constructorimpl(0) : f5, (i2 & 256) != 0 ? Dp.m9687constructorimpl(0) : f6, (i2 & 512) != 0 ? Wrap.INSTANCE.getNone() : wrap, (i2 & 1024) != 0 ? VerticalAlign.INSTANCE.getCenter() : verticalAlign, (i2 & 2048) != 0 ? HorizontalAlign.INSTANCE.getCenter() : horizontalAlign, (i2 & 4096) != 0 ? 0.0f : f7, (i2 & 8192) == 0 ? f8 : 0.0f, (i2 & 16384) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle, (i2 & 32768) != 0 ? FlowStyle.INSTANCE.getPacked() : flowStyle2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow-Fgo90cY");
    }

    /* JADX INFO: renamed from: createRow-lG28NQ4$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9988createRowlG28NQ4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, float[] fArr, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRow-lG28NQ4");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        if ((i & 4) != 0) {
            fArr = new float[0];
        }
        return constraintLayoutBaseScope.m10009createRowlG28NQ4(layoutReferenceArr, f, fArr);
    }

    /* JADX INFO: renamed from: createColumn-lG28NQ4$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9982createColumnlG28NQ4$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, float[] fArr, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createColumn-lG28NQ4");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        if ((i & 4) != 0) {
            fArr = new float[0];
        }
        return constraintLayoutBaseScope.m9997createColumnlG28NQ4(layoutReferenceArr, f, fArr);
    }

    /* JADX INFO: renamed from: createGrid-Hu23Yyw$default, reason: not valid java name */
    public static /* synthetic */ ConstrainedLayoutReference m9987createGridHu23Yyw$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, int i, int i2, boolean z, float f, float f2, float[] fArr, float[] fArr2, Skip[] skipArr, Span[] spanArr, int i3, int i4, Object obj) {
        if (obj == null) {
            return constraintLayoutBaseScope.m10002createGridHu23Yyw(layoutReferenceArr, i, i2, (i4 & 8) != 0 ? true : z, (i4 & 16) != 0 ? Dp.m9687constructorimpl(0) : f, (i4 & 32) != 0 ? Dp.m9687constructorimpl(0) : f2, (i4 & 64) != 0 ? new float[0] : fArr, (i4 & 128) != 0 ? new float[0] : fArr2, (i4 & 256) != 0 ? new Skip[0] : skipArr, (i4 & 512) != 0 ? new Span[0] : spanArr, (i4 & 1024) != 0 ? GridFlag.INSTANCE.m10061getNonedTRCCdc() : i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createGrid-Hu23Yyw");
    }

    /* JADX INFO: renamed from: withChainParams-ouYQatA$default, reason: not valid java name */
    public static /* synthetic */ LayoutReference m9991withChainParamsouYQatA$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withChainParams-ouYQatA");
        }
        return constraintLayoutBaseScope.m10012withChainParamsouYQatA(layoutReference, (i & 1) != 0 ? Dp.m9687constructorimpl(0) : f, (i & 2) != 0 ? Dp.m9687constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m9687constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 16) != 0 ? Dp.m9687constructorimpl(0) : f5, (i & 32) != 0 ? Dp.m9687constructorimpl(0) : f6, (i & 64) != 0 ? Dp.m9687constructorimpl(0) : f7, (i & 128) != 0 ? Dp.m9687constructorimpl(0) : f8, (i & 256) != 0 ? Float.NaN : f9);
    }

    /* JADX INFO: renamed from: withHorizontalChainParams-YLPp7PM, reason: not valid java name */
    public final LayoutReference m10013withHorizontalChainParamsYLPp7PM(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5) {
        float f6 = 0;
        return m10012withChainParamsouYQatA(layoutReference, f, Dp.m9687constructorimpl(f6), f2, Dp.m9687constructorimpl(f6), f3, Dp.m9687constructorimpl(f6), f4, Dp.m9687constructorimpl(f6), f5);
    }

    /* JADX INFO: renamed from: withHorizontalChainParams-YLPp7PM$default, reason: not valid java name */
    public static /* synthetic */ LayoutReference m9992withHorizontalChainParamsYLPp7PM$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withHorizontalChainParams-YLPp7PM");
        }
        return constraintLayoutBaseScope.m10013withHorizontalChainParamsYLPp7PM(layoutReference, (i & 1) != 0 ? Dp.m9687constructorimpl(0) : f, (i & 2) != 0 ? Dp.m9687constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m9687constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 16) != 0 ? Float.NaN : f5);
    }

    /* JADX INFO: renamed from: withVerticalChainParams-YLPp7PM, reason: not valid java name */
    public final LayoutReference m10014withVerticalChainParamsYLPp7PM(LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5) {
        float f6 = 0;
        return m10012withChainParamsouYQatA(layoutReference, Dp.m9687constructorimpl(f6), f, Dp.m9687constructorimpl(f6), f2, Dp.m9687constructorimpl(f6), f3, Dp.m9687constructorimpl(f6), f4, f5);
    }

    /* JADX INFO: renamed from: withVerticalChainParams-YLPp7PM$default, reason: not valid java name */
    public static /* synthetic */ LayoutReference m9993withVerticalChainParamsYLPp7PM$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference layoutReference, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withVerticalChainParams-YLPp7PM");
        }
        return constraintLayoutBaseScope.m10014withVerticalChainParamsYLPp7PM(layoutReference, (i & 1) != 0 ? Dp.m9687constructorimpl(0) : f, (i & 2) != 0 ? Dp.m9687constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m9687constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 16) != 0 ? Float.NaN : f5);
    }
}
