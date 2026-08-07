package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Preconditions;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    private static final float CSS_LINE_HEIGHT = 1.2f;
    private static final String DEFAULT_BACKGROUND_CSS_CLASS = "default_bg";
    private float bottomPaddingFraction;
    private final CanvasSubtitleOutput canvasSubtitleOutput;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private CaptionStyleCompat style;
    private List<Cue> textCues;
    private final WebView webView;

    private static int anchorTypeToTranslatePercent(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textCues = Collections.emptyList();
        this.style = CaptionStyleCompat.DEFAULT;
        this.defaultTextSize = 0.0533f;
        this.defaultTextSizeType = 0;
        this.bottomPaddingFraction = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.canvasSubtitleOutput = canvasSubtitleOutput;
        MAMWebView mAMWebView = new MAMWebView(context, attributeSet) { // from class: androidx.media3.ui.WebViewSubtitleOutput.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            @Override // android.view.View
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = mAMWebView;
        mAMWebView.setBackgroundColor(0);
        mAMWebView.getSettings().setAllowContentAccess(false);
        addView(canvasSubtitleOutput);
        addView(mAMWebView);
    }

    @Override // androidx.media3.ui.SubtitleView.Output
    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.style = captionStyleCompat;
        this.defaultTextSize = f;
        this.defaultTextSizeType = i;
        this.bottomPaddingFraction = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.textCues.isEmpty() || !arrayList2.isEmpty()) {
            this.textCues = arrayList2;
            updateWebView();
        }
        this.canvasSubtitleOutput.update(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.textCues.isEmpty()) {
            return;
        }
        updateWebView();
    }

    public void destroy() {
        this.webView.destroy();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:27:0x010e  */
    /* JADX WARN: Code duplicated, block: B:30:0x012a  */
    /* JADX WARN: Code duplicated, block: B:31:0x012d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0147  */
    /* JADX WARN: Code duplicated, block: B:38:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0153  */
    /* JADX WARN: Code duplicated, block: B:49:0x0165  */
    /* JADX WARN: Code duplicated, block: B:53:0x0190  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:64:0x0209  */
    private void updateWebView() {
        String invariant;
        int iAnchorTypeToTranslatePercent;
        boolean z;
        String invariant2;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        Object obj;
        String str4;
        SpannedToHtmlConverter.HtmlAndCss htmlAndCssConvert;
        String str5;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        String cssRgba = HtmlUtils.toCssRgba(this.style.foregroundColor);
        String strConvertTextSizeToCss = convertTextSizeToCss(this.defaultTextSizeType, this.defaultTextSize);
        float f = CSS_LINE_HEIGHT;
        sb.append(Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", cssRgba, strConvertTextSizeToCss, Float.valueOf(CSS_LINE_HEIGHT), convertCaptionStyleToCssTextShadow(this.style)));
        HashMap map = new HashMap();
        map.put(HtmlUtils.cssAllClassDescendantsSelector(DEFAULT_BACKGROUND_CSS_CLASS), Util.formatInvariant("background-color:%s;", HtmlUtils.toCssRgba(this.style.backgroundColor)));
        int i3 = 0;
        while (i3 < this.textCues.size()) {
            Cue cue = this.textCues.get(i3);
            float f2 = cue.position != -3.4028235E38f ? cue.position * 100.0f : 50.0f;
            int iAnchorTypeToTranslatePercent2 = anchorTypeToTranslatePercent(cue.positionAnchor);
            if (cue.line != -3.4028235E38f) {
                if (cue.lineType != 1) {
                    invariant = Util.formatInvariant("%.2f%%", Float.valueOf(cue.line * 100.0f));
                    if (cue.verticalType == 1) {
                        iAnchorTypeToTranslatePercent = -anchorTypeToTranslatePercent(cue.lineAnchor);
                    } else {
                        iAnchorTypeToTranslatePercent = anchorTypeToTranslatePercent(cue.lineAnchor);
                    }
                } else {
                    f = f;
                    if (cue.line >= 0.0f) {
                        invariant = Util.formatInvariant("%.2fem", Float.valueOf(cue.line * f));
                        z = false;
                        iAnchorTypeToTranslatePercent = 0;
                    } else {
                        invariant = Util.formatInvariant("%.2fem", Float.valueOf(((-cue.line) - 1.0f) * f));
                        iAnchorTypeToTranslatePercent = 0;
                        z = true;
                    }
                }
                String str6 = invariant;
                if (cue.size != -3.4028235E38f) {
                    invariant2 = Util.formatInvariant("%.2f%%", Float.valueOf(cue.size * 100.0f));
                } else {
                    invariant2 = "fit-content";
                }
                String str7 = invariant2;
                String strConvertAlignmentToCss = convertAlignmentToCss(cue.textAlignment);
                String strConvertVerticalTypeToCss = convertVerticalTypeToCss(cue.verticalType);
                String strConvertTextSizeToCss2 = convertTextSizeToCss(cue.textSizeType, cue.textSize);
                if (cue.windowColorSet) {
                    i = cue.windowColor;
                } else {
                    i = this.style.windowColor;
                }
                String cssRgba2 = HtmlUtils.toCssRgba(i);
                i2 = cue.verticalType;
                str = "right";
                str2 = ViewProps.TOP;
                if (i2 != 1) {
                    if (z) {
                        str = "left";
                    }
                    str3 = str;
                    obj = ViewProps.TOP;
                } else if (i2 != 2) {
                    if (z) {
                        str2 = ViewProps.BOTTOM;
                    }
                    obj = "left";
                    str3 = str2;
                } else {
                    if (!z) {
                        str = "left";
                    }
                    str3 = str;
                    obj = ViewProps.TOP;
                }
                if (cue.verticalType != 2 || cue.verticalType == 1) {
                    str4 = "height";
                    int i4 = iAnchorTypeToTranslatePercent;
                    iAnchorTypeToTranslatePercent = iAnchorTypeToTranslatePercent2;
                    iAnchorTypeToTranslatePercent2 = i4;
                } else {
                    str4 = "width";
                }
                String str8 = str4;
                htmlAndCssConvert = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
                for (String str9 : map.keySet()) {
                    str5 = (String) map.put(str9, (String) map.get(str9));
                    if (str5 != null || str5.equals(map.get(str9))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.checkState(z2);
                }
                sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i3), obj, Float.valueOf(f2), str3, str6, str8, str7, strConvertAlignmentToCss, strConvertVerticalTypeToCss, strConvertTextSizeToCss2, cssRgba2, Integer.valueOf(iAnchorTypeToTranslatePercent2), Integer.valueOf(iAnchorTypeToTranslatePercent), getBlockShearTransformFunction(cue))).append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
                if (cue.multiRowAlignment != null) {
                    sb.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", convertAlignmentToCss(cue.multiRowAlignment))).append(htmlAndCssConvert.html).append("</span>");
                } else {
                    sb.append(htmlAndCssConvert.html);
                }
                sb.append("</span></div>");
                i3++;
                f = f;
            } else {
                invariant = Util.formatInvariant("%.2f%%", Float.valueOf((1.0f - this.bottomPaddingFraction) * 100.0f));
                iAnchorTypeToTranslatePercent = -100;
            }
            z = false;
            String str10 = invariant;
            if (cue.size != -3.4028235E38f) {
                invariant2 = Util.formatInvariant("%.2f%%", Float.valueOf(cue.size * 100.0f));
            } else {
                invariant2 = "fit-content";
            }
            String str11 = invariant2;
            String strConvertAlignmentToCss2 = convertAlignmentToCss(cue.textAlignment);
            String strConvertVerticalTypeToCss2 = convertVerticalTypeToCss(cue.verticalType);
            String strConvertTextSizeToCss3 = convertTextSizeToCss(cue.textSizeType, cue.textSize);
            if (cue.windowColorSet) {
                i = cue.windowColor;
            } else {
                i = this.style.windowColor;
            }
            String cssRgba3 = HtmlUtils.toCssRgba(i);
            i2 = cue.verticalType;
            str = "right";
            str2 = ViewProps.TOP;
            if (i2 != 1) {
                if (z) {
                    str = "left";
                }
                str3 = str;
                obj = ViewProps.TOP;
            } else if (i2 != 2) {
                if (z) {
                    str2 = ViewProps.BOTTOM;
                }
                obj = "left";
                str3 = str2;
            } else {
                if (!z) {
                    str = "left";
                }
                str3 = str;
                obj = ViewProps.TOP;
            }
            if (cue.verticalType != 2) {
                str4 = "height";
                int i5 = iAnchorTypeToTranslatePercent;
                iAnchorTypeToTranslatePercent = iAnchorTypeToTranslatePercent2;
                iAnchorTypeToTranslatePercent2 = i5;
            } else {
                str4 = "height";
                int i6 = iAnchorTypeToTranslatePercent;
                iAnchorTypeToTranslatePercent = iAnchorTypeToTranslatePercent2;
                iAnchorTypeToTranslatePercent2 = i6;
            }
            String str12 = str4;
            htmlAndCssConvert = SpannedToHtmlConverter.convert(cue.text, getContext().getResources().getDisplayMetrics().density);
            while (r10.hasNext()) {
                str5 = (String) map.put(str9, (String) map.get(str9));
                if (str5 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                Preconditions.checkState(z2);
            }
            sb.append(Util.formatInvariant("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i3), obj, Float.valueOf(f2), str3, str10, str12, str11, strConvertAlignmentToCss2, strConvertVerticalTypeToCss2, strConvertTextSizeToCss3, cssRgba3, Integer.valueOf(iAnchorTypeToTranslatePercent2), Integer.valueOf(iAnchorTypeToTranslatePercent), getBlockShearTransformFunction(cue))).append(Util.formatInvariant("<span class='%s'>", DEFAULT_BACKGROUND_CSS_CLASS));
            if (cue.multiRowAlignment != null) {
                sb.append(Util.formatInvariant("<span style='display:inline-block; text-align:%s;'>", convertAlignmentToCss(cue.multiRowAlignment))).append(htmlAndCssConvert.html).append("</span>");
            } else {
                sb.append(htmlAndCssConvert.html);
            }
            sb.append("</span></div>");
            i3++;
            f = f;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str13 : map.keySet()) {
            sb2.append(str13).append("{").append((String) map.get(str13)).append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, (CharSequence) sb2);
        this.webView.loadData(Base64.encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8), 1), "text/html", "base64");
    }

    private static String getBlockShearTransformFunction(Cue cue) {
        String str;
        if (cue.shearDegrees != 0.0f) {
            if (cue.verticalType == 2 || cue.verticalType == 1) {
                str = "skewY";
            } else {
                str = "skewX";
            }
            return Util.formatInvariant("%s(%.2fdeg)", str, Float.valueOf(cue.shearDegrees));
        }
        return "";
    }

    private String convertTextSizeToCss(int i, float f) {
        float fResolveTextSize = SubtitleViewUtils.resolveTextSize(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (fResolveTextSize == -3.4028235E38f) {
            return "unset";
        }
        return Util.formatInvariant("%.2fpx", Float.valueOf(fResolveTextSize / getContext().getResources().getDisplayMetrics().density));
    }

    private static String convertCaptionStyleToCssTextShadow(CaptionStyleCompat captionStyleCompat) {
        int i = captionStyleCompat.edgeType;
        if (i == 1) {
            return Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        if (i == 2) {
            return Util.formatInvariant("0.1em 0.12em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        if (i == 3) {
            return Util.formatInvariant("0.06em 0.08em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        if (i == 4) {
            return Util.formatInvariant("-0.05em -0.05em 0.15em %s", HtmlUtils.toCssRgba(captionStyleCompat.edgeColor));
        }
        return "unset";
    }

    private static String convertVerticalTypeToCss(int i) {
        if (i == 1) {
            return "vertical-rl";
        }
        if (i == 2) {
            return "vertical-lr";
        }
        return "horizontal-tb";
    }

    private static String convertAlignmentToCss(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i = AnonymousClass2.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
        if (i == 1) {
            return "start";
        }
        if (i != 2) {
            return TtmlNode.CENTER;
        }
        return "end";
    }

    /* JADX INFO: renamed from: androidx.media3.ui.WebViewSubtitleOutput$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
