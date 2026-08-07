package com.facebook.react.animated;

import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterpolationAnimatedNode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\r\u0010\u001b\u001a\u00020\rH\u0010¢\u0006\u0002\b\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode;", "Lcom/facebook/react/animated/ValueAnimatedNode;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "<init>", "(Lcom/facebook/react/bridge/ReadableMap;)V", "inputRange", "", "outputRange", "", "outputType", "Lcom/facebook/react/animated/InterpolationAnimatedNode$OutputType;", "pattern", "", "extrapolateLeft", "extrapolateRight", "parent", "objectValue", "onAttachedToNode", "", "Lcom/facebook/react/animated/AnimatedNode;", "onAttachedToNode$ReactAndroid_release", "onDetachedFromNode", "onDetachedFromNode$ReactAndroid_release", "update", "update$ReactAndroid_release", "getAnimatedObject", "prettyPrint", "prettyPrint$ReactAndroid_release", "OutputType", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InterpolationAnimatedNode extends ValueAnimatedNode {
    private static final String COLOR_OUTPUT_TYPE = "color";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
    public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
    public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
    private static final Pattern numericPattern;
    private final String extrapolateLeft;
    private final String extrapolateRight;
    private final double[] inputRange;
    private Object objectValue;
    private Object outputRange;
    private OutputType outputType;
    private ValueAnimatedNode parent;
    private String pattern;

    /* JADX INFO: compiled from: InterpolationAnimatedNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode$OutputType;", "", "<init>", "(Ljava/lang/String;I)V", "Number", "Color", "String", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private enum OutputType {
        Number,
        Color,
        String;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<OutputType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: InterpolationAnimatedNode.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputType.values().length];
            try {
                iArr[OutputType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputType.Color.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutputType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterpolationAnimatedNode(ReadableMap config) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Companion companion = INSTANCE;
        this.inputRange = companion.fromDoubleArray(config.getArray("inputRange"));
        this.extrapolateLeft = config.getString("extrapolateLeft");
        this.extrapolateRight = config.getString("extrapolateRight");
        ReadableArray array = config.getArray("outputRange");
        if (Intrinsics.areEqual("color", config.getString("outputType"))) {
            this.outputType = OutputType.Color;
            this.outputRange = companion.fromIntArray(array);
            return;
        }
        if ((array != null ? array.getType(0) : null) == ReadableType.String) {
            this.outputType = OutputType.String;
            this.outputRange = companion.fromStringPattern(array);
            this.pattern = array.getString(0);
        } else {
            this.outputType = OutputType.Number;
            this.outputRange = companion.fromDoubleArray(array);
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onAttachedToNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.parent != null) {
            throw new IllegalStateException("Parent already attached".toString());
        }
        if (!(parent instanceof ValueAnimatedNode)) {
            throw new IllegalArgumentException("Parent is of an invalid type".toString());
        }
        this.parent = (ValueAnimatedNode) parent;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onDetachedFromNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent != this.parent) {
            throw new IllegalArgumentException("Invalid parent node provided".toString());
        }
        this.parent = null;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update$ReactAndroid_release() {
        String str;
        ValueAnimatedNode valueAnimatedNode = this.parent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            OutputType outputType = this.outputType;
            int i = outputType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[outputType.ordinal()];
            if (i == 1) {
                Companion companion = INSTANCE;
                double[] dArr = this.inputRange;
                Object obj = this.outputRange;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
                this.nodeValue = companion.interpolate(value, dArr, (double[]) obj, this.extrapolateLeft, this.extrapolateRight);
                return;
            }
            if (i == 2) {
                Companion companion2 = INSTANCE;
                double[] dArr2 = this.inputRange;
                Object obj2 = this.outputRange;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.IntArray");
                this.objectValue = Integer.valueOf(companion2.interpolateColor(value, dArr2, (int[]) obj2));
                return;
            }
            if (i == 3 && (str = this.pattern) != null) {
                Companion companion3 = INSTANCE;
                double[] dArr3 = this.inputRange;
                Object obj3 = this.outputRange;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.DoubleArray>");
                this.objectValue = companion3.interpolateString(str, value, dArr3, (double[][]) obj3, this.extrapolateLeft, this.extrapolateRight);
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode
    /* JADX INFO: renamed from: getAnimatedObject, reason: from getter */
    public Object getObjectValue() {
        return this.objectValue;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint$ReactAndroid_release() {
        return "InterpolationAnimatedNode[" + this.tag + "] super: " + super.prettyPrint$ReactAndroid_release();
    }

    /* JADX INFO: compiled from: InterpolationAnimatedNode.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0013JB\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J2\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0010JE\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode$Companion;", "", "<init>", "()V", "EXTRAPOLATE_TYPE_IDENTITY", "", "EXTRAPOLATE_TYPE_CLAMP", "EXTRAPOLATE_TYPE_EXTEND", "numericPattern", "Ljava/util/regex/Pattern;", "COLOR_OUTPUT_TYPE", "fromDoubleArray", "", "array", "Lcom/facebook/react/bridge/ReadableArray;", "fromIntArray", "", "fromStringPattern", "", "(Lcom/facebook/react/bridge/ReadableArray;)[[D", "interpolate", "", "value", "inputMin", "inputMax", "outputMin", "outputMax", "extrapolateLeft", "extrapolateRight", "inputRange", "outputRange", "interpolateColor", "", "interpolateString", "pattern", "(Ljava/lang/String;D[D[[DLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "findRangeIndex", "ranges", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[] fromDoubleArray(ReadableArray array) {
            if (array != null) {
                int size = array.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = array.getDouble(i);
                }
                return dArr;
            }
            return new double[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] fromIntArray(ReadableArray array) {
            if (array != null) {
                int size = array.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = array.getInt(i);
                }
                return iArr;
            }
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[][] fromStringPattern(ReadableArray array) {
            int size = array.size();
            double[][] dArr = new double[size][];
            Pattern pattern = InterpolationAnimatedNode.numericPattern;
            String string = array.getString(0);
            if (string == null) {
                string = "";
            }
            Matcher matcher = pattern.matcher(string);
            ArrayList arrayList = new ArrayList();
            while (matcher.find()) {
                String strGroup = matcher.group();
                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                arrayList.add(Double.valueOf(Double.parseDouble(strGroup)));
            }
            int size2 = arrayList.size();
            double[] dArr2 = new double[size2];
            int size3 = arrayList.size();
            for (int i = 0; i < size3; i++) {
                dArr2[i] = ((Number) arrayList.get(i)).doubleValue();
            }
            dArr[0] = dArr2;
            for (int i2 = 1; i2 < size; i2++) {
                double[] dArr3 = new double[size2];
                Pattern pattern2 = InterpolationAnimatedNode.numericPattern;
                String string2 = array.getString(i2);
                if (string2 == null) {
                    string2 = "";
                }
                Matcher matcher2 = pattern2.matcher(string2);
                for (int i3 = 0; matcher2.find() && i3 < size2; i3++) {
                    String strGroup2 = matcher2.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                    dArr3[i3] = Double.parseDouble(strGroup2);
                }
                dArr[i2] = dArr3;
            }
            return dArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        
            if (r21.equals(com.facebook.react.animated.InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND) != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
        
            if (r22.equals(com.facebook.react.animated.InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND) != false) goto L38;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final double interpolate(double r11, double r13, double r15, double r17, double r19, java.lang.String r21, java.lang.String r22) {
            /*
                r10 = this;
                r10 = r21
                r0 = r22
                int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                java.lang.String r2 = "clamp"
                java.lang.String r3 = "identity"
                java.lang.String r4 = "extend"
                r5 = 94742715(0x5a5a8bb, float:1.5578507E-35)
                r6 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
                r7 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
                java.lang.String r8 = "Invalid extrapolation type "
                if (r1 >= 0) goto L54
                if (r10 == 0) goto L3b
                int r9 = r10.hashCode()
                if (r9 == r7) goto L34
                if (r9 == r6) goto L2d
                if (r9 != r5) goto L3b
                boolean r11 = r10.equals(r2)
                if (r11 == 0) goto L3b
                r11 = r13
                goto L54
            L2d:
                boolean r0 = r10.equals(r3)
                if (r0 == 0) goto L3b
                return r11
            L34:
                boolean r9 = r10.equals(r4)
                if (r9 == 0) goto L3b
                goto L54
            L3b:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r11 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>(r8)
                java.lang.StringBuilder r10 = r12.append(r10)
                java.lang.String r12 = "for left extrapolation"
                java.lang.StringBuilder r10 = r10.append(r12)
                java.lang.String r10 = r10.toString()
                r11.<init>(r10)
                throw r11
            L54:
                int r10 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
                if (r10 <= 0) goto L93
                if (r0 == 0) goto L7a
                int r10 = r0.hashCode()
                if (r10 == r7) goto L73
                if (r10 == r6) goto L6c
                if (r10 != r5) goto L7a
                boolean r10 = r0.equals(r2)
                if (r10 == 0) goto L7a
                r11 = r15
                goto L93
            L6c:
                boolean r10 = r0.equals(r3)
                if (r10 == 0) goto L7a
                return r11
            L73:
                boolean r10 = r0.equals(r4)
                if (r10 == 0) goto L7a
                goto L93
            L7a:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r10 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>(r8)
                java.lang.StringBuilder r11 = r11.append(r0)
                java.lang.String r12 = "for right extrapolation"
                java.lang.StringBuilder r11 = r11.append(r12)
                java.lang.String r11 = r11.toString()
                r10.<init>(r11)
                throw r10
            L93:
                int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
                if (r10 != 0) goto L98
                return r17
            L98:
                int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r10 != 0) goto La0
                if (r1 > 0) goto L9f
                return r17
            L9f:
                return r19
            La0:
                double r0 = r19 - r17
                double r11 = r11 - r13
                double r0 = r0 * r11
                double r10 = r15 - r13
                double r0 = r0 / r10
                double r10 = r17 + r0
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.Companion.interpolate(double, double, double, double, double, java.lang.String, java.lang.String):double");
        }

        public final double interpolate(double value, double[] inputRange, double[] outputRange, String extrapolateLeft, String extrapolateRight) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(value, inputRange);
            int i = iFindRangeIndex + 1;
            return interpolate(value, inputRange[iFindRangeIndex], inputRange[i], outputRange[iFindRangeIndex], outputRange[i], extrapolateLeft, extrapolateRight);
        }

        public final int interpolateColor(double value, double[] inputRange, int[] outputRange) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(value, inputRange);
            int i = outputRange[iFindRangeIndex];
            int i2 = iFindRangeIndex + 1;
            int i3 = outputRange[i2];
            if (i != i3) {
                double d = inputRange[iFindRangeIndex];
                double d2 = inputRange[i2];
                if (d != d2) {
                    return ColorUtils.blendARGB(i, i3, (float) ((value - d) / (d2 - d)));
                }
                if (value > d) {
                    return i3;
                }
            }
            return i;
        }

        public final String interpolateString(String pattern, double value, double[] inputRange, double[][] outputRange, String extrapolateLeft, String extrapolateRight) {
            double[] inputRange2 = inputRange;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(inputRange2, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            Companion companion = this;
            double d = value;
            int iFindRangeIndex = companion.findRangeIndex(d, inputRange2);
            StringBuffer stringBuffer = new StringBuffer(pattern.length());
            Matcher matcher = InterpolationAnimatedNode.numericPattern.matcher(pattern);
            int i = 0;
            while (matcher.find()) {
                double[] dArr = outputRange[iFindRangeIndex];
                if (i >= dArr.length) {
                    break;
                }
                StringBuffer stringBuffer2 = stringBuffer;
                int i2 = i;
                int i3 = iFindRangeIndex + 1;
                double dInterpolate = companion.interpolate(d, inputRange2[iFindRangeIndex], inputRange2[i3], dArr[i2], outputRange[i3][i2], extrapolateLeft, extrapolateRight);
                int i4 = (int) dInterpolate;
                matcher.appendReplacement(stringBuffer2, ((double) i4) == dInterpolate ? String.valueOf(i4) : String.valueOf(dInterpolate));
                i = i2 + 1;
                companion = this;
                d = value;
                stringBuffer = stringBuffer2;
                inputRange2 = inputRange;
            }
            StringBuffer stringBuffer3 = stringBuffer;
            matcher.appendTail(stringBuffer3);
            String string = stringBuffer3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private final int findRangeIndex(double value, double[] ranges) {
            int i = 1;
            while (i < ranges.length - 1 && ranges[i] < value) {
                i++;
            }
            return i - 1;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        numericPattern = patternCompile;
    }
}
