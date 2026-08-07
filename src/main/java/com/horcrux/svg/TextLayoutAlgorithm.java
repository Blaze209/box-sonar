package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        double advance;
        char character;
        TextView element;
        int index;
        double x = 0.0d;
        double y = 0.0d;
        double rotate = 0.0d;
        boolean hidden = false;
        boolean middle = false;
        boolean resolved = false;
        boolean xSpecified = false;
        boolean ySpecified = false;
        boolean addressable = true;
        boolean anchoredChunk = false;
        boolean rotateSpecified = false;
        boolean firstCharacterInResolvedDescendant = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            } else {
                while (i < str.length()) {
                    arrayList2.add(tSpanView);
                    arrayList.add(textPathView);
                    i++;
                }
                sb.append(str);
                return;
            }
        }
        TextPathView textPathView2 = view instanceof TextPathView ? (TextPathView) view : textPathView;
        while (i < textPathView2.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView2.getChildAt(i), textPathView2);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:146:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver] */
    CharacterInformation[] layoutText(LayoutInput layoutInput) {
        CharacterInformation[] characterInformationArr;
        boolean z;
        boolean z2;
        boolean z3;
        char c;
        TextView textView = layoutInput.text;
        StringBuilder sb = new StringBuilder();
        ArrayList<TextView> arrayList = new ArrayList<>();
        ArrayList<TextPathView> arrayList2 = new ArrayList<>();
        getSubTreeTypographicCharacterPositions(arrayList2, arrayList, sb, textView, null);
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        final CharacterInformation[] characterInformationArr2 = new CharacterInformation[length];
        for (int i = 0; i < length; i++) {
            characterInformationArr2[i] = new CharacterInformation(i, charArray[i]);
        }
        if (length != 0) {
            PointF[] pointFArr = new PointF[length];
            for (int i2 = 0; i2 < length; i2++) {
                pointFArr[i2] = new PointF(0.0f, 0.0f);
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                characterInformationArr2[i3].addressable = true;
                characterInformationArr2[i3].middle = false;
                characterInformationArr2[i3].anchoredChunk = i3 == 0;
                if (characterInformationArr2[i3].addressable && !characterInformationArr2[i3].middle) {
                    pointFArr[i3].set(0.0f, 0.0f);
                } else if (i3 > 0) {
                    pointFArr[i3].set(pointFArr[i3 - 1]);
                }
                i3++;
            }
            String[] strArr = new String[length];
            String[] strArr2 = new String[length];
            new C1CharacterPositioningResolver(characterInformationArr2, strArr, strArr2, new String[length], new String[length]);
            PointF pointF = new PointF(0.0f, 0.0f);
            for (int i4 = 0; i4 < length; i4++) {
                if (strArr[i4].equals("")) {
                    strArr[i4] = "0";
                }
                if (strArr2[i4].equals("")) {
                    strArr2[i4] = "0";
                }
                pointF.x += Float.parseFloat(strArr[i4]);
                pointF.y += Float.parseFloat(strArr2[i4]);
                characterInformationArr2[i4].x = pointFArr[i4].x + pointF.x;
                characterInformationArr2[i4].y = pointFArr[i4].y + pointF.y;
            }
            new Object() { // from class: com.horcrux.svg.TextLayoutAlgorithm.1TextLengthResolver
                int global;

                /* JADX INFO: Access modifiers changed from: private */
                public void resolveTextLength(TextView textView2) {
                    Class<?> cls = textView2.getClass();
                    boolean z4 = textView2.mTextLength != null;
                    if (cls == TSpanView.class && z4) {
                        TSpanView tSpanView = (TSpanView) textView2;
                        String str = tSpanView.mContent;
                        int i5 = this.global;
                        int length2 = (str == null ? 0 : str.length()) + i5;
                        double dMax = Double.NEGATIVE_INFINITY;
                        int i6 = i5;
                        double dMin = Double.POSITIVE_INFINITY;
                        while (i6 <= length2) {
                            if (characterInformationArr2[i5].addressable) {
                                char c2 = characterInformationArr2[i5].character;
                                if (c2 == '\n' || c2 == '\r') {
                                    return;
                                }
                                double d = characterInformationArr2[i6].x;
                                double d2 = characterInformationArr2[i6].advance + d;
                                dMin = Math.min(dMin, Math.min(d, d2));
                                dMax = Math.max(dMax, Math.max(d, d2));
                            }
                            i6++;
                            i5 = i5;
                        }
                        int i7 = i5;
                        if (dMin != Double.POSITIVE_INFINITY) {
                            double d3 = textView2.mTextLength.value - (dMax - dMin);
                            int length3 = 0;
                            int i8 = 0;
                            for (int i9 = 0; i9 < textView2.getChildCount(); i9++) {
                                if (((TextPathView) textView2.getChildAt(i9)).mTextLength == null) {
                                    String str2 = tSpanView.mContent;
                                    length3 += str2 == null ? 0 : str2.length();
                                } else {
                                    characterInformationArr2[length3].firstCharacterInResolvedDescendant = true;
                                    i8++;
                                }
                            }
                            double d4 = d3 / ((double) (length3 + (i8 - 1)));
                            double d5 = 0.0d;
                            for (int i10 = i7; i10 <= length2; i10++) {
                                characterInformationArr2[i10].x += d5;
                                if (!characterInformationArr2[i10].middle && (!characterInformationArr2[i10].resolved || characterInformationArr2[i10].firstCharacterInResolvedDescendant)) {
                                    d5 += d4;
                                }
                            }
                        }
                    }
                }
            }.resolveTextLength(textView);
            pointF.set(0.0f, 0.0f);
            int i5 = 1;
            while (i5 < length) {
                String str = strArr[i5];
                if (str != null) {
                    pointF.x = (float) (Double.parseDouble(str) - characterInformationArr2[i5].x);
                }
                String str2 = strArr2[i5];
                if (str2 != null) {
                    pointF.y = (float) (Double.parseDouble(str2) - characterInformationArr2[i5].y);
                }
                characterInformationArr2[i5].x += (double) pointF.x;
                characterInformationArr2[i5].y += (double) pointF.y;
                if (characterInformationArr2[i5].middle && characterInformationArr2[i5].anchoredChunk) {
                    characterInformationArr2[i5].anchoredChunk = false;
                }
                i5++;
                if (i5 < length) {
                    characterInformationArr2[i5].anchoredChunk = true;
                }
            }
            int i6 = 0;
            int i7 = 0;
            double dMin = Double.POSITIVE_INFINITY;
            double dMax = Double.NEGATIVE_INFINITY;
            double d = Double.POSITIVE_INFINITY;
            double d2 = Double.NEGATIVE_INFINITY;
            while (i6 < length) {
                if (characterInformationArr2[i6].addressable) {
                    if (characterInformationArr2[i6].anchoredChunk) {
                        d = dMin;
                        d2 = dMax;
                        dMin = Double.POSITIVE_INFINITY;
                        dMax = Double.NEGATIVE_INFINITY;
                    }
                    double d3 = characterInformationArr2[i6].x;
                    double d4 = characterInformationArr2[i6].advance + d3;
                    dMin = Math.min(dMin, Math.min(d3, d4));
                    dMax = Math.max(dMax, Math.max(d3, d4));
                    if ((i6 > 0 && characterInformationArr2[i6].anchoredChunk && d != Double.POSITIVE_INFINITY) || i6 == length - 1) {
                        TextProperties.TextAnchor textAnchor = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction = TextProperties.Direction.ltr;
                        int i8 = length - 1;
                        if (i6 == i8) {
                            d = dMin;
                            d2 = dMax;
                        }
                        double d5 = characterInformationArr2[i7].x;
                        int i9 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                        if (i9 != 1) {
                            if (i9 == 2) {
                                TextProperties.Direction direction2 = TextProperties.Direction.ltr;
                                d5 -= (d + d2) / 2.0d;
                            } else if (i9 == 3) {
                                if (direction == TextProperties.Direction.ltr) {
                                    d5 -= d2;
                                } else {
                                    d5 -= d;
                                }
                            }
                        } else if (direction == TextProperties.Direction.ltr) {
                            d5 -= d;
                        } else {
                            d5 -= d2;
                        }
                        int i10 = i6 == i8 ? i6 : i6 - 1;
                        while (i7 <= i10) {
                            characterInformationArr2[i7].x += d5;
                            i7++;
                        }
                        i7 = i6;
                    }
                }
                i6++;
            }
            PointF pointF2 = new PointF(0.0f, 0.0f);
            PathMeasure pathMeasure = new PathMeasure();
            ?? r3 = 0;
            Path textPath = null;
            boolean z4 = false;
            int i11 = 0;
            boolean z5 = false;
            while (i11 < length) {
                TextPathView textPathView = arrayList2.get(i11);
                if (textPathView == 0 || !characterInformationArr2[i11].addressable) {
                    characterInformationArr = characterInformationArr2;
                    z = z4;
                } else {
                    textPath = textPathView.getTextPath(r3, r3);
                    if (!characterInformationArr2[i11].middle) {
                        textPathView.getSide();
                        TextProperties.TextPathSide textPathSide = TextProperties.TextPathSide.right;
                        pathMeasure.setPath(textPath, false);
                        double length2 = pathMeasure.getLength();
                        double d6 = textPathView.getStartOffset().value;
                        z = z4;
                        double d7 = characterInformationArr2[i11].advance;
                        characterInformationArr = characterInformationArr2;
                        double d8 = characterInformationArr2[i11].x;
                        double d9 = characterInformationArr[i11].y;
                        double d10 = characterInformationArr[i11].rotate;
                        double d11 = d8 + (d7 / 2.0d) + d6;
                        if (!pathMeasure.isClosed() && (d11 < 0.0d || d11 > length2)) {
                            characterInformationArr[i11].hidden = true;
                        }
                        if (pathMeasure.isClosed()) {
                            TextProperties.TextAnchor textAnchor2 = TextProperties.TextAnchor.start;
                            TextProperties.Direction direction3 = TextProperties.Direction.ltr;
                            double d12 = characterInformationArr[i7].x;
                            int i12 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor2.ordinal()];
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    if (i12 != 3) {
                                        c = 1;
                                    } else if (direction3 != TextProperties.Direction.ltr) {
                                        c = 1;
                                        if (d11 < 0.0d || d11 > length2) {
                                            characterInformationArr[i11].hidden = true;
                                        }
                                    } else if (d11 < (-length2) || d11 > 0.0d) {
                                        c = 1;
                                        characterInformationArr[i11].hidden = true;
                                    } else {
                                        c = 1;
                                    }
                                } else if (d11 < (-length2) / 2.0d || d11 > length2 / 2.0d) {
                                    c = 1;
                                    characterInformationArr[i11].hidden = true;
                                } else {
                                    c = 1;
                                }
                            } else if (direction3 != TextProperties.Direction.ltr) {
                                c = 1;
                                if (d11 < (-length2) || d11 > 0.0d) {
                                    characterInformationArr[i11].hidden = true;
                                }
                            } else if (d11 < 0.0d || d11 > length2) {
                                c = 1;
                                characterInformationArr[i11].hidden = true;
                            } else {
                                c = 1;
                            }
                        } else {
                            c = 1;
                        }
                        double d13 = d11 % length2;
                        if (!characterInformationArr[i11].hidden) {
                            float[] fArr = new float[2];
                            pathMeasure.getPosTan((float) d13, new float[2], fArr);
                            double dAtan2 = Math.atan2(fArr[c], fArr[0]) * 57.29577951308232d;
                            double d14 = 90.0d + dAtan2;
                            Math.cos(d14);
                            Math.sin(d14);
                            characterInformationArr[i11].rotate += dAtan2;
                        }
                    } else {
                        characterInformationArr = characterInformationArr2;
                        z = z4;
                        int i13 = i11 - 1;
                        characterInformationArr[i11].x = characterInformationArr[i13].x;
                        characterInformationArr[i11].y = characterInformationArr[i13].y;
                        characterInformationArr[i11].rotate = characterInformationArr[i13].rotate;
                    }
                    z5 = true;
                }
                if (textPathView == 0 && characterInformationArr[i11].addressable) {
                    if (z5) {
                        pathMeasure.setPath(textPath, false);
                        float[] fArr2 = new float[2];
                        pathMeasure.getPosTan(pathMeasure.getLength(), fArr2, null);
                        pointF2.set(fArr2[0], fArr2[1]);
                        z2 = false;
                        z3 = true;
                    } else {
                        z2 = z5;
                        z3 = z;
                    }
                    if (z3) {
                        if (characterInformationArr[i11].anchoredChunk) {
                            z4 = false;
                            z5 = z2;
                        } else {
                            characterInformationArr[i11].x += (double) pointF2.x;
                            characterInformationArr[i11].y += (double) pointF2.y;
                        }
                    }
                    z4 = z3;
                    z5 = z2;
                } else {
                    z4 = z;
                }
                i11++;
                characterInformationArr2 = characterInformationArr;
                r3 = 0;
            }
        }
        return characterInformationArr2;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver, reason: invalid class name */
    class C1CharacterPositioningResolver {
        private int global;
        private boolean horizontal;
        private boolean in_text_path;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        private C1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.global = 0;
            this.horizontal = true;
            this.in_text_path = false;
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            boolean z = true;
            if (textView.getClass() == TextView.class || textView.getClass() == TSpanView.class) {
                int i = this.global;
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                String[] strArr3 = new String[0];
                String[] strArr4 = new String[0];
                double[] dArr = new double[0];
                int iMax = !this.in_text_path ? Math.max(0, 0) : 0;
                String str = ((TSpanView) textView).mContent;
                int length = str == null ? 0 : str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i + i2;
                    if (this.result[i4].addressable) {
                        this.result[i4].anchoredChunk = i3 < iMax ? z : false;
                        if (i3 < 0) {
                            this.resolve_x[i4] = strArr[i3];
                        }
                        boolean z2 = this.in_text_path;
                        if (z2 && !this.horizontal) {
                            this.resolve_x[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_y[i4] = strArr2[i3];
                        }
                        if (z2 && this.horizontal) {
                            this.resolve_y[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_dx[i4] = strArr3[i3];
                        }
                        if (i3 < 0) {
                            this.resolve_dy[i4] = strArr4[i3];
                        }
                        if (i3 < 0) {
                            this.result[i4].rotate = dArr[i3];
                        }
                    }
                    i3++;
                    i2++;
                    z = true;
                }
                return;
            }
            if (textView.getClass() == TextPathView.class) {
                this.result[this.global].anchoredChunk = true;
                this.in_text_path = true;
                for (int i5 = 0; i5 < textView.getChildCount(); i5++) {
                    resolveCharacterPositioning((TextView) textView.getChildAt(i5));
                }
                if (textView instanceof TextPathView) {
                    this.in_text_path = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;

        static {
            int[] iArr = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr;
            try {
                iArr[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
