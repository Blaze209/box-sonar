package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SvgPathParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J?\u0010\u001b\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001d\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u001f\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0003j\u0002`\u00042\n\u0010#\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\u00060\u0003j\u0002`\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\u00060\u0003j\u0002`\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006("}, d2 = {"Landroidx/graphics/shapes/SvgPathParser;", "", "startPosition", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(J)V", "cubics", "", "Landroidx/graphics/shapes/Cubic;", "start", "J", ViewProps.POSITION, "getPosition-1ufDz9w", "()J", "previousCommand", "Landroidx/graphics/shapes/SvgPathParser$Command;", "reflectedPreviousControlPoint", "getReflectedPreviousControlPoint-1ufDz9w", "parseCommand", "", "command", "parseAtomicCommand", "atomicCommand", "parseLine", "parseCurve", "parseArc", "curveToCubic", "a0", "c0", "c1", "a1", "curveToCubic-ArktYTI", "(JJJJ)Landroidx/graphics/shapes/Cubic;", "lineToCubic", "end", "lineToCubic-ybeJwSQ", "(JJ)Landroidx/graphics/shapes/Cubic;", "Companion", "Command", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SvgPathParser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Cubic> cubics;
    private Command previousCommand;
    private final long start;

    public /* synthetic */ SvgPathParser(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    @JvmStatic
    public static final List<Feature> parseFeatures(String str) {
        return INSTANCE.parseFeatures(str);
    }

    private SvgPathParser(long j) {
        this.cubics = new ArrayList();
        this.start = j;
        this.previousCommand = new Command('I', false, new float[0], 0, 0L, 16, null);
    }

    /* JADX INFO: compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Companion;", "", "<init>", "()V", "parseFeatures", "", "Landroidx/graphics/shapes/Feature;", "svgPath", "", "parseCubics", "Landroidx/graphics/shapes/Cubic;", "parseCubics$graphics_shapes", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Feature> parseFeatures(String svgPath) {
            Intrinsics.checkNotNullParameter(svgPath, "svgPath");
            List<Cubic> cubics$graphics_shapes = parseCubics$graphics_shapes(svgPath);
            Function2 function2 = new Function2() { // from class: androidx.graphics.shapes.SvgPathParser$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(SvgPathParser.Companion.parseFeatures$lambda$0((Cubic) obj, (Cubic) obj2));
                }
            };
            int size = cubics$graphics_shapes.size();
            int lastIndex = CollectionsKt.getLastIndex(cubics$graphics_shapes);
            int i = 0;
            while (i < lastIndex) {
                int i2 = i + 1;
                if (!((Boolean) function2.invoke(cubics$graphics_shapes.get(i), cubics$graphics_shapes.get(i2))).booleanValue()) {
                    size = i;
                    break;
                }
                i = i2;
            }
            return PolygonValidator.INSTANCE.fix(RoundedPolygonKt.RoundedPolygon$default(FeatureDetectorKt.detectFeatures(CollectionsKt.take(cubics$graphics_shapes, size)), 0.0f, 0.0f, 6, null)).getFeatures();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean parseFeatures$lambda$0(Cubic first, Cubic second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            return Math.abs(second.getAnchor0X() - first.getAnchor1X()) < 1.0E-4f && Math.abs(second.getAnchor0Y() - first.getAnchor1Y()) < 1.0E-4f;
        }

        public final List<Cubic> parseCubics$graphics_shapes(String svgPath) {
            Intrinsics.checkNotNullParameter(svgPath, "svgPath");
            List<String> listSplit = new Regex("(?=[mM])").split(svgPath, 0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            long jM315constructorimpl = FloatFloatPair.m315constructorimpl(0.0f, 0.0f);
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                List<String> listSplit2 = new Regex("(?=[a-zA-Z])").split((String) it.next(), 0);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listSplit2) {
                    if (!StringsKt.isBlank((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                Command commandM10300parseHiPawso = Command.INSTANCE.m10300parseHiPawso((String) CollectionsKt.first((List) arrayList3), jM315constructorimpl);
                long jM10271plusybeJwSQ = PointKt.m10271plusybeJwSQ(commandM10300parseHiPawso.m10298getStart1ufDz9w(), FloatFloatPair.m315constructorimpl(commandM10300parseHiPawso.get(0), commandM10300parseHiPawso.get(1)));
                SvgPathParser svgPathParser = new SvgPathParser(jM10271plusybeJwSQ, null);
                svgPathParser.parseCommand(commandM10300parseHiPawso.m10294asLineDnnuFBc(jM10271plusybeJwSQ));
                Iterator it2 = CollectionsKt.drop(arrayList3, 1).iterator();
                while (it2.hasNext()) {
                    svgPathParser.parseCommand(Command.INSTANCE.m10300parseHiPawso((String) it2.next(), svgPathParser.m10290getPosition1ufDz9w()));
                }
                listCreateListBuilder.addAll(svgPathParser.cubics);
                jM315constructorimpl = jM10271plusybeJwSQ;
            }
            return CollectionsKt.build(listCreateListBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getPosition-1ufDz9w, reason: not valid java name */
    public final long m10290getPosition1ufDz9w() {
        Cubic cubic = (Cubic) CollectionsKt.lastOrNull((List) this.cubics);
        return cubic != null ? FloatFloatPair.m315constructorimpl(cubic.getAnchor1X(), cubic.getAnchor1Y()) : this.start;
    }

    /* JADX INFO: renamed from: getReflectedPreviousControlPoint-1ufDz9w, reason: not valid java name */
    private final long m10291getReflectedPreviousControlPoint1ufDz9w() {
        return PointKt.m10271plusybeJwSQ(m10290getPosition1ufDz9w(), PointKt.m10270minusybeJwSQ(m10290getPosition1ufDz9w(), FloatFloatPair.m315constructorimpl(((Cubic) CollectionsKt.last((List) this.cubics)).getControl1X(), ((Cubic) CollectionsKt.last((List) this.cubics)).getControl1Y())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parseCommand(Command command) {
        if (command.getIsCloseCommand()) {
            this.cubics.add(m10292lineToCubicybeJwSQ(m10290getPosition1ufDz9w(), this.start));
            return;
        }
        int lastIndex = ArraysKt.getLastIndex(command.getParameters());
        int paramsCount = command.getParamsCount();
        if (paramsCount <= 0) {
            throw new IllegalArgumentException("Step must be positive, was: " + paramsCount + '.');
        }
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, lastIndex, paramsCount);
        if (progressionLastElement < 0) {
            return;
        }
        while (true) {
            parseAtomicCommand(command.m10295chunkHiPawso(i, m10290getPosition1ufDz9w()));
            if (i == progressionLastElement) {
                return;
            } else {
                i += paramsCount;
            }
        }
    }

    private final void parseAtomicCommand(Command atomicCommand) {
        if (atomicCommand.getIsLineCommand()) {
            parseLine(atomicCommand);
        } else if (atomicCommand.getIsCurveCommand()) {
            parseCurve(atomicCommand);
        } else if (atomicCommand.getIsArcCommand()) {
            parseArc(atomicCommand);
        }
        this.previousCommand = atomicCommand;
    }

    private final void parseLine(Command command) {
        Function1 function1 = new Function1() { // from class: androidx.graphics.shapes.SvgPathParser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SvgPathParser.parseLine$lambda$2(this.f$0, (FloatFloatPair) obj));
            }
        };
        char letter = command.getLetter();
        if (letter == 'h') {
            function1.invoke(FloatFloatPair.m312boximpl(FloatFloatPair.m315constructorimpl(command.x(0), PointKt.m10268getYDnnuFBc(command.m10298getStart1ufDz9w()))));
        } else if (letter == 'l') {
            function1.invoke(FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)));
        } else {
            if (letter != 'v') {
                return;
            }
            function1.invoke(FloatFloatPair.m312boximpl(FloatFloatPair.m315constructorimpl(PointKt.m10267getXDnnuFBc(command.m10298getStart1ufDz9w()), command.y(0))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseLine$lambda$2(SvgPathParser svgPathParser, FloatFloatPair floatFloatPair) {
        return svgPathParser.cubics.add(svgPathParser.m10292lineToCubicybeJwSQ(svgPathParser.m10290getPosition1ufDz9w(), floatFloatPair.getPackedValue()));
    }

    private final void parseCurve(Command command) {
        Function3 function3 = new Function3() { // from class: androidx.graphics.shapes.SvgPathParser$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(SvgPathParser.parseCurve$lambda$3(this.f$0, (FloatFloatPair) obj, (FloatFloatPair) obj2, (FloatFloatPair) obj3));
            }
        };
        char letter = command.getLetter();
        if (letter == 'c') {
            function3.invoke(FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(2, 3)), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(4, 5)));
            return;
        }
        if (letter == 'q') {
            function3.invoke(FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(2, 3)));
            return;
        }
        if (letter == 's') {
            function3.invoke(FloatFloatPair.m312boximpl(this.previousCommand.getIsBezierCommand() ? m10291getReflectedPreviousControlPoint1ufDz9w() : m10290getPosition1ufDz9w()), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(2, 3)));
        } else {
            if (letter != 't') {
                return;
            }
            long jM10291getReflectedPreviousControlPoint1ufDz9w = this.previousCommand.getIsQuadraticCurveCommand() ? m10291getReflectedPreviousControlPoint1ufDz9w() : m10290getPosition1ufDz9w();
            function3.invoke(FloatFloatPair.m312boximpl(jM10291getReflectedPreviousControlPoint1ufDz9w), FloatFloatPair.m312boximpl(jM10291getReflectedPreviousControlPoint1ufDz9w), FloatFloatPair.m312boximpl(command.m10299xyXgqJiTY(0, 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseCurve$lambda$3(SvgPathParser svgPathParser, FloatFloatPair floatFloatPair, FloatFloatPair floatFloatPair2, FloatFloatPair floatFloatPair3) {
        return svgPathParser.cubics.add(svgPathParser.m10289curveToCubicArktYTI(svgPathParser.m10290getPosition1ufDz9w(), floatFloatPair.getPackedValue(), floatFloatPair2.getPackedValue(), floatFloatPair3.getPackedValue()));
    }

    private final void parseArc(Command command) {
        long jM10299xyXgqJiTY = command.m10299xyXgqJiTY(5, 6);
        this.cubics.addAll(ArcConverter.INSTANCE.arcToCubics(PointKt.m10267getXDnnuFBc(m10290getPosition1ufDz9w()), PointKt.m10268getYDnnuFBc(m10290getPosition1ufDz9w()), PointKt.m10267getXDnnuFBc(jM10299xyXgqJiTY), PointKt.m10268getYDnnuFBc(jM10299xyXgqJiTY), command.get(0), command.get(1), command.get(2), !(command.get(3) == 0.0f), !(command.get(4) == 0.0f)));
    }

    /* JADX INFO: renamed from: curveToCubic-ArktYTI, reason: not valid java name */
    private final Cubic m10289curveToCubicArktYTI(long a0, long c0, long c1, long a1) {
        return new Cubic(new float[]{PointKt.m10267getXDnnuFBc(a0), PointKt.m10268getYDnnuFBc(a0), PointKt.m10267getXDnnuFBc(c0), PointKt.m10268getYDnnuFBc(c0), PointKt.m10267getXDnnuFBc(c1), PointKt.m10268getYDnnuFBc(c1), PointKt.m10267getXDnnuFBc(a1), PointKt.m10268getYDnnuFBc(a1)});
    }

    /* JADX INFO: renamed from: lineToCubic-ybeJwSQ, reason: not valid java name */
    private final Cubic m10292lineToCubicybeJwSQ(long start, long end) {
        return Cubic.INSTANCE.straightLine(PointKt.m10267getXDnnuFBc(start), PointKt.m10268getYDnnuFBc(start), PointKt.m10267getXDnnuFBc(end), PointKt.m10268getYDnnuFBc(end));
    }

    /* JADX INFO: compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 ?2\u00020\u0001:\u0001?B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tH\u0086\u0002J\u000e\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ\u000e\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ!\u0010$\u001a\u00060\u000bj\u0002`\f2\u0006\u0010!\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\t2\n\u0010*\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00002\n\u0010.\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00103\u001a\u00020\tH\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\u0014\u00108\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b9\u0010\u0017JF\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\fHÆ\u0001¢\u0006\u0004\b;\u0010<J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Command;", "", "letter", "", "isRelative", "", "parameters", "", "paramsCount", "", "start", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "<init>", "(CZ[FIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLetter", "()C", "()Z", "getParameters", "()[F", "getParamsCount", "()I", "getStart-1ufDz9w", "()J", "J", "isLineCommand", "isBezierCommand", "isQuadraticCurveCommand", "isCurveCommand", "isArcCommand", "isCloseCommand", PasskeyWebListener.GET_UNIQUE_KEY, "", "i", "x", "y", "xy", "j", "xy-XgqJiTY", "(II)J", "chunk", FirebaseAnalytics.Param.INDEX, "currentPosition", "chunk-HiPawso", "(IJ)Landroidx/graphics/shapes/SvgPathParser$Command;", "asLine", "newStart", "asLine-DnnuFBc", "(J)Landroidx/graphics/shapes/SvgPathParser$Command;", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component5-1ufDz9w", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-teZZwEo", "(CZ[FIJ)Landroidx/graphics/shapes/SvgPathParser$Command;", "toString", "", "Factory", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final /* data */ class Command {

        /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Map<Character, Integer> commandToParamsCount = MapsKt.mapOf(TuplesKt.to('m', 2), TuplesKt.to('l', 2), TuplesKt.to('h', 1), TuplesKt.to('v', 1), TuplesKt.to('c', 6), TuplesKt.to('s', 4), TuplesKt.to('q', 4), TuplesKt.to('t', 2), TuplesKt.to('a', 7));
        private final boolean isArcCommand;
        private final boolean isBezierCommand;
        private final boolean isCloseCommand;
        private final boolean isCurveCommand;
        private final boolean isLineCommand;
        private final boolean isQuadraticCurveCommand;
        private final boolean isRelative;
        private final char letter;
        private final float[] parameters;
        private final int paramsCount;
        private final long start;

        public /* synthetic */ Command(char c, boolean z, float[] fArr, int i, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(c, z, fArr, i, j);
        }

        /* JADX INFO: renamed from: copy-teZZwEo$default, reason: not valid java name */
        public static /* synthetic */ Command m10293copyteZZwEo$default(Command command, char c, boolean z, float[] fArr, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                c = command.letter;
            }
            if ((i2 & 2) != 0) {
                z = command.isRelative;
            }
            if ((i2 & 4) != 0) {
                fArr = command.parameters;
            }
            if ((i2 & 8) != 0) {
                i = command.paramsCount;
            }
            if ((i2 & 16) != 0) {
                j = command.start;
            }
            long j2 = j;
            return command.m10297copyteZZwEo(c, z, fArr, i, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final char getLetter() {
            return this.letter;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsRelative() {
            return this.isRelative;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float[] getParameters() {
            return this.parameters;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getParamsCount() {
            return this.paramsCount;
        }

        /* JADX INFO: renamed from: component5-1ufDz9w, reason: not valid java name and from getter */
        public final long getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: copy-teZZwEo, reason: not valid java name */
        public final Command m10297copyteZZwEo(char letter, boolean isRelative, float[] parameters, int paramsCount, long start) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            return new Command(letter, isRelative, parameters, paramsCount, start, null);
        }

        public String toString() {
            return "Command(letter=" + this.letter + ", isRelative=" + this.isRelative + ", parameters=" + Arrays.toString(this.parameters) + ", paramsCount=" + this.paramsCount + ", start=" + ((Object) FloatFloatPair.m322toStringimpl(this.start)) + ')';
        }

        private Command(char c, boolean z, float[] parameters, int i, long j) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.letter = c;
            this.isRelative = z;
            this.parameters = parameters;
            this.paramsCount = i;
            this.start = j;
            this.isLineCommand = ArraysKt.contains(new char[]{'l', 'h', 'v'}, c);
            this.isBezierCommand = ArraysKt.contains(new char[]{'c', 's'}, c);
            this.isQuadraticCurveCommand = ArraysKt.contains(new char[]{'q', 't'}, c);
            this.isCurveCommand = ArraysKt.contains(new char[]{'c', 's', 'q', 't'}, c);
            this.isArcCommand = c == 'a';
            this.isCloseCommand = c == 'z';
        }

        public final char getLetter() {
            return this.letter;
        }

        public final boolean isRelative() {
            return this.isRelative;
        }

        public final float[] getParameters() {
            return this.parameters;
        }

        public final int getParamsCount() {
            return this.paramsCount;
        }

        public /* synthetic */ Command(char c, boolean z, float[] fArr, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(c, z, fArr, i, (i2 & 16) != 0 ? FloatFloatPair.m315constructorimpl(0.0f, 0.0f) : j, null);
        }

        /* JADX INFO: renamed from: getStart-1ufDz9w, reason: not valid java name */
        public final long m10298getStart1ufDz9w() {
            return this.start;
        }

        /* JADX INFO: renamed from: androidx.graphics.shapes.SvgPathParser$Command$Factory, reason: from kotlin metadata */
        /* JADX INFO: compiled from: SvgPathParser.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/graphics/shapes/SvgPathParser$Command$Factory;", "", "<init>", "()V", "commandToParamsCount", "", "", "", "parse", "Landroidx/graphics/shapes/SvgPathParser$Command;", "input", "", "currentPosition", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "parse-HiPawso", "(Ljava/lang/String;J)Landroidx/graphics/shapes/SvgPathParser$Command;", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: parse-HiPawso, reason: not valid java name */
            public final Command m10300parseHiPawso(String input, long currentPosition) {
                Intrinsics.checkNotNullParameter(input, "input");
                char cFirst = StringsKt.first(input);
                boolean zIsLowerCase = Character.isLowerCase(cFirst);
                List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.drop(input, 1), new String[]{" ", ","}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listSplit$default) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(Float.valueOf(Float.parseFloat(StringsKt.trim((CharSequence) it.next()).toString())));
                }
                float[] floatArray = CollectionsKt.toFloatArray(arrayList3);
                char lowerCase = Character.toLowerCase(cFirst);
                Integer num = (Integer) Command.commandToParamsCount.get(Character.valueOf(Character.toLowerCase(cFirst)));
                int iIntValue = num != null ? num.intValue() : 0;
                if (!zIsLowerCase) {
                    currentPosition = FloatFloatPair.m315constructorimpl(0.0f, 0.0f);
                }
                return new Command(lowerCase, zIsLowerCase, floatArray, iIntValue, currentPosition, null);
            }
        }

        /* JADX INFO: renamed from: isLineCommand, reason: from getter */
        public final boolean getIsLineCommand() {
            return this.isLineCommand;
        }

        /* JADX INFO: renamed from: isBezierCommand, reason: from getter */
        public final boolean getIsBezierCommand() {
            return this.isBezierCommand;
        }

        /* JADX INFO: renamed from: isQuadraticCurveCommand, reason: from getter */
        public final boolean getIsQuadraticCurveCommand() {
            return this.isQuadraticCurveCommand;
        }

        /* JADX INFO: renamed from: isCurveCommand, reason: from getter */
        public final boolean getIsCurveCommand() {
            return this.isCurveCommand;
        }

        /* JADX INFO: renamed from: isArcCommand, reason: from getter */
        public final boolean getIsArcCommand() {
            return this.isArcCommand;
        }

        /* JADX INFO: renamed from: isCloseCommand, reason: from getter */
        public final boolean getIsCloseCommand() {
            return this.isCloseCommand;
        }

        public final float get(int i) {
            return this.parameters[i];
        }

        public final float x(int i) {
            float f = get(i);
            return this.isRelative ? PointKt.m10267getXDnnuFBc(this.start) + f : f;
        }

        public final float y(int i) {
            float f = get(i);
            return this.isRelative ? PointKt.m10268getYDnnuFBc(this.start) + f : f;
        }

        /* JADX INFO: renamed from: xy-XgqJiTY, reason: not valid java name */
        public final long m10299xyXgqJiTY(int i, int j) {
            long jM315constructorimpl = FloatFloatPair.m315constructorimpl(get(i), get(j));
            return this.isRelative ? PointKt.m10271plusybeJwSQ(this.start, jM315constructorimpl) : jM315constructorimpl;
        }

        /* JADX INFO: renamed from: chunk-HiPawso, reason: not valid java name */
        public final Command m10295chunkHiPawso(int index, long currentPosition) {
            return new Command(this.letter, this.isRelative, ArraysKt.sliceArray(this.parameters, RangesKt.until(index, this.paramsCount + index)), this.paramsCount, currentPosition, null);
        }

        /* JADX INFO: renamed from: asLine-DnnuFBc, reason: not valid java name */
        public final Command m10294asLineDnnuFBc(long newStart) {
            return new Command('l', this.isRelative, CollectionsKt.toFloatArray(ArraysKt.drop(this.parameters, this.paramsCount)), 2, newStart, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Command command = (Command) other;
            return this.letter == command.letter && Arrays.equals(this.parameters, command.parameters) && this.paramsCount == command.paramsCount;
        }

        public int hashCode() {
            return (((Character.hashCode(this.letter) * 31) + Arrays.hashCode(this.parameters)) * 31) + this.paramsCount;
        }
    }
}
