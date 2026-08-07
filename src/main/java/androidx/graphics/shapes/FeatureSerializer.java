package androidx.graphics.shapes;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: FeatureSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/FeatureSerializer;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureSerializer {
    private static final char CONVEX_CORNER_CHAR = 'x';
    private static final String LOG_TAG = "FeatureSerializer";
    private static final char SEPARATOR = ',';

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char EDGE_CHAR = 'n';
    private static final char CONCAVE_CORNER_CHAR = 'o';
    private static final char[] FEATURE_TAG_ARRAY = {EDGE_CHAR, 'x', CONCAVE_CORNER_CHAR};

    @JvmStatic
    public static final List<Feature> parse(String str) {
        return INSTANCE.parse(str);
    }

    @JvmStatic
    public static final String serialize(List<? extends Feature> list) {
        return INSTANCE.serialize(list);
    }

    /* JADX INFO: compiled from: FeatureSerializer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/graphics/shapes/FeatureSerializer$Companion;", "", "<init>", "()V", "serialize", "", "features", "", "Landroidx/graphics/shapes/Feature;", "parse", "serializedFeatures", "serializeFeature", "feature", "serializeCubics", "cubics", "Landroidx/graphics/shapes/Cubic;", "parseFeature", "serialized", "startIndex", "", "endIndex", "parseCubics", "removeTrailingZeroes", "SEPARATOR", "", "CONVEX_CORNER_CHAR", "CONCAVE_CORNER_CHAR", "EDGE_CHAR", "FEATURE_TAG_ARRAY", "", "LOG_TAG", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String serialize(List<? extends Feature> features) {
            Intrinsics.checkNotNullParameter(features, "features");
            StringBuilder sb = new StringBuilder("V1");
            Iterator<? extends Feature> it = features.iterator();
            while (it.hasNext()) {
                sb.append(FeatureSerializer.INSTANCE.serializeFeature(it.next()));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @JvmStatic
        public final List<Feature> parse(String serializedFeatures) {
            int length;
            Intrinsics.checkNotNullParameter(serializedFeatures, "serializedFeatures");
            String str = serializedFeatures;
            int length2 = 0;
            MatchResult matchResultFind$default = Regex.find$default(new Regex("^\\s*V(\\d+)"), str, 0, 2, null);
            if (matchResultFind$default != null && matchResultFind$default.getGroupValues().size() >= 2) {
                Intrinsics.areEqual(matchResultFind$default.getGroupValues().get(1), "1");
                length2 = matchResultFind$default.getValue().length();
            }
            MatchResult matchResultFind = new Regex("[a-zA-Z]").find(str, length2);
            if (matchResultFind == null) {
                throw new IllegalArgumentException(("Could not find any feature tags. Please mark all cubic bezier curve points belonging to a feature with one of {" + ArraysKt.joinToString$default(FeatureSerializer.FEATURE_TAG_ARRAY, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "} for V1, e.g. 'n1,1,2,2,3,3,4,4' for an edge (n) with anchor 0 (1,1), control 0 (2,2), control 1 (3,3) and anchor 1 (4,4).").toString());
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            while (matchResultFind != null) {
                int first = matchResultFind.getRange().getFirst();
                matchResultFind = matchResultFind.next();
                if (matchResultFind != null) {
                    length = matchResultFind.getRange().getFirst();
                } else {
                    length = serializedFeatures.length();
                }
                listCreateListBuilder.add(FeatureSerializer.INSTANCE.parseFeature(serializedFeatures, first, length));
            }
            return CollectionsKt.build(listCreateListBuilder);
        }

        private final String serializeFeature(Feature feature) {
            if (feature instanceof Feature.Edge) {
                return "n" + serializeCubics(feature.getCubics());
            }
            if (!(feature instanceof Feature.Corner)) {
                return "n" + serializeCubics(feature.getCubics());
            }
            return (((Feature.Corner) feature).getConvex() ? 'x' : FeatureSerializer.CONCAVE_CORNER_CHAR) + serializeCubics(feature.getCubics());
        }

        private final String serializeCubics(List<? extends Cubic> cubics) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends Cubic> it = cubics.iterator();
            while (it.hasNext()) {
                sb.append(ArraysKt.joinToString$default(it.next().getPoints(), (CharSequence) ",", (CharSequence) null, (CharSequence) null, 6, (CharSequence) "", new Function1() { // from class: androidx.graphics.shapes.FeatureSerializer$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeatureSerializer.Companion.serializeCubics$lambda$7$lambda$6(((Float) obj).floatValue());
                    }
                }, 6, (Object) null));
            }
            sb.append(FeatureSerializer.INSTANCE.removeTrailingZeroes(String.valueOf(((Cubic) CollectionsKt.last((List) cubics)).getAnchor1X())) + ',' + FeatureSerializer.INSTANCE.removeTrailingZeroes(String.valueOf(((Cubic) CollectionsKt.last((List) cubics)).getAnchor1Y())));
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence serializeCubics$lambda$7$lambda$6(float f) {
            return FeatureSerializer.INSTANCE.removeTrailingZeroes(String.valueOf(f));
        }

        private final Feature parseFeature(String serialized, int startIndex, int endIndex) {
            char cCharAt = serialized.charAt(startIndex);
            if (cCharAt == 'n') {
                return new Feature.Edge(parseCubics(serialized, startIndex + 1, endIndex));
            }
            if (cCharAt == 'o') {
                return new Feature.Corner(parseCubics(serialized, startIndex + 1, endIndex), false);
            }
            if (cCharAt == 'x') {
                return new Feature.Corner(parseCubics(serialized, startIndex + 1, endIndex), true);
            }
            return new Feature.Edge(parseCubics(serialized, startIndex + 1, endIndex));
        }

        private final List<Cubic> parseCubics(String serialized, int startIndex, int endIndex) {
            int i;
            float[] fArr = new float[8];
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            int i2 = startIndex;
            int i3 = i2;
            int i4 = 0;
            while (i2 < endIndex) {
                if (serialized.charAt(i2) != ',') {
                    i2++;
                } else {
                    int i5 = i4 + 1;
                    String strSubstring = serialized.substring(i3, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    fArr[i4] = Float.parseFloat(strSubstring);
                    i3 = i2 + 1;
                    if (i5 == 8) {
                        listCreateListBuilder.add(new Cubic(fArr));
                        float f = fArr[6];
                        float f2 = fArr[7];
                        float[] fArr2 = new float[8];
                        fArr2[0] = f;
                        fArr2[1] = f2;
                        i4 -= 5;
                        fArr = fArr2;
                    } else {
                        i4 = i5;
                    }
                    i2 = i3;
                }
            }
            int i6 = i4 + 1;
            if (i6 != 8) {
                try {
                    String strSubstring2 = serialized.substring(i3, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    Float.parseFloat(strSubstring2);
                    i = 8 - i6;
                } catch (NumberFormatException unused) {
                    i = 8 - i4;
                }
                StringBuilder sb = new StringBuilder("Received a feature with an insufficient amount of numbers for substring '");
                String strSubstring3 = serialized.substring(startIndex - 1, endIndex);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                throw new IllegalArgumentException(sb.append(strSubstring3).append("'. Wanted to create ").append(listCreateListBuilder.size() + 1).append(" continuous cubic bezier curves for this feature, but the last one is missing ").append(i).append(" more numbers separated by ','.").toString().toString());
            }
            String strSubstring4 = serialized.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
            fArr[7] = Float.parseFloat(strSubstring4);
            listCreateListBuilder.add(new Cubic(fArr));
            return CollectionsKt.build(listCreateListBuilder);
        }

        private final String removeTrailingZeroes(String str) {
            String strSubSequence;
            String strSubSequence2;
            String str2 = str;
            int length = str2.length() - 1;
            if (length < 0) {
                break;
            }
            while (true) {
                int i = length - 1;
                if (str2.charAt(length) != '0') {
                    strSubSequence = str2.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            String string = strSubSequence.toString();
            int length2 = string.length() - 1;
            if (length2 < 0) {
                break;
            }
            while (true) {
                int i2 = length2 - 1;
                if (string.charAt(length2) != '.') {
                    strSubSequence2 = string.subSequence(0, length2 + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
            return strSubSequence2.toString();
        }
    }

    private FeatureSerializer() {
    }
}
