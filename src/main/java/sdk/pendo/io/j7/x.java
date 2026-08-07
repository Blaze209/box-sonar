package sdk.pendo.io.j7;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\b\u0010\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010T\u001a\u00020\n\u0012\u0006\u0010U\u001a\u00020\n\u0012\u0006\u0010V\u001a\u00020\u0002\u0012\b\b\u0002\u0010W\u001a\u00020\u0002¢\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0017\u0010\t\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\t\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0017\u0010\u000e\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\fJ\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0016J\u0017\u0010\u0005\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0005\u0010\u0019J\u000e\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u001f\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u0017\u0010\u001d\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001d\u0010\fJ\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0017J\u000f\u0010#\u001a\u00020\"H\u0010¢\u0006\u0004\b#\u0010$J\u0013\u0010\u000e\u001a\u00060%j\u0002`&H\u0010¢\u0006\u0004\b\u000e\u0010'J-\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020*0)2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b#\u0010+R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R(\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\b6\u00100R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00118\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R(\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b?\u00102\u001a\u0004\b@\u00104R(\u0010E\u001a\u0004\u0018\u00010\u00162\b\u0010,\u001a\u0004\u0018\u00010\u00168\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00178\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR(\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bJ\u00102\u001a\u0004\bK\u00104R(\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bL\u0010.\u001a\u0004\bM\u00100R(\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bN\u0010.\u001a\u0004\bO\u00100R(\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bP\u00102\u001a\u0004\bQ\u00104R(\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00178\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bR\u0010G\u001a\u0004\bS\u0010I¨\u0006Z"}, d2 = {"Lsdk/pendo/io/j7/x;", "Lsdk/pendo/io/j7/v;", "", "textContent", "Lorg/json/JSONObject;", "b", "tagName", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "text", "e", "", "fontSize", "(Ljava/lang/Integer;)Lsdk/pendo/io/j7/v;", "fontFamily", "d", "Lsdk/pendo/io/h7/d;", "fontStyle", "Lsdk/pendo/io/h7/e;", "fontWeight", "fontColor", "textAlignment", "n", "Lsdk/pendo/io/j7/w;", "", ViewProps.LETTER_SPACING, "(Ljava/lang/Float;)Lsdk/pendo/io/j7/v;", ViewProps.LINE_HEIGHT, "o", "textDirection", "f", "textUnicodeBidi", "g", "maxLines", "percentFontSize", "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "()Ljava/lang/StringBuilder;", "input", "", "Lkotlin/Pair;", "(Ljava/lang/String;)Ljava/util/List;", "<set-?>", "G", "Ljava/lang/String;", "getText$pendoIO_release", "()Ljava/lang/String;", "H", "Ljava/lang/Integer;", "getFontSize$pendoIO_release", "()Ljava/lang/Integer;", "I", "getFontFamily$pendoIO_release", "J", "Lsdk/pendo/io/h7/d;", "getFontStyle$pendoIO_release", "()Lsdk/pendo/io/h7/d;", "K", "Lsdk/pendo/io/h7/e;", "getFontWeight$pendoIO_release", "()Lsdk/pendo/io/h7/e;", "L", "getFontColor$pendoIO_release", "M", "Lsdk/pendo/io/j7/w;", "getTextHorizontalAlignment$pendoIO_release", "()Lsdk/pendo/io/j7/w;", "textHorizontalAlignment", "N", "Ljava/lang/Float;", "getLetterSpacing$pendoIO_release", "()Ljava/lang/Float;", "O", "getLineHeight$pendoIO_release", "P", "getTextDirection$pendoIO_release", "Q", "getTextUnicodeBidi$pendoIO_release", "R", "getMaxLines$pendoIO_release", ExifInterface.LATITUDE_SOUTH, "getPercentFontSize$pendoIO_release", "id", ViewProps.Z_INDEX, "elementName", "recordingDataProperty", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class x extends v {

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private String text;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private Integer fontSize;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private String fontFamily;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private sdk.pendo.io.h7.d fontStyle;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private sdk.pendo.io.h7.e fontWeight;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private Integer fontColor;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private w textHorizontalAlignment;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private Float letterSpacing;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private Integer lineHeight;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private String textDirection;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private String textUnicodeBidi;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private Integer maxLines;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private Float percentFontSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(int i, int i2, String elementName, String recordingDataProperty) {
        super(i, i2, elementName, recordingDataProperty);
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(recordingDataProperty, "recordingDataProperty");
    }

    private final JSONObject a(String textContent, String tagName) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        d(getId() + 1);
        jSONObject.put("id", getId());
        jSONObject.put("type", sdk.pendo.io.h7.k.ELEMENT.getValue());
        jSONObject.put("tagName", tagName);
        jSONObject.put(NativeAuthConstants.GrantType.ATTRIBUTES, new JSONObject());
        jSONObject.put("childNodes", new JSONArray().put(b(textContent)));
        return jSONObject;
    }

    private final JSONObject b(String textContent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        d(getId() + 1);
        jSONObject.put("id", getId());
        jSONObject.put("type", sdk.pendo.io.h7.k.TEXT.getValue());
        jSONObject.put("textContent", textContent);
        return jSONObject;
    }

    @Override // sdk.pendo.io.j7.v
    public JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = c(this.text).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            jSONArray.put(str2 == null ? b(str) : a(str, str2));
        }
        return jSONArray;
    }

    @Override // sdk.pendo.io.j7.v
    public StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) super.d());
        if (this.text != null) {
            sb.append("overflow: visible; height: auto; white-space: pre; ");
            Integer num = this.lineHeight;
            if (num != null) {
                num.intValue();
                sb.append("line-height: " + this.lineHeight + "px; ");
            }
            String str = this.textDirection;
            if (str != null) {
                sb.append("direction: " + str + "; ");
            }
            String str2 = this.textUnicodeBidi;
            if (str2 != null) {
                sb.append("unicode-bidi: " + str2 + "; ");
            }
            Integer num2 = this.maxLines;
            if (num2 != null) {
                int iIntValue = num2.intValue();
                sb.append("-webkit-line-clamp: " + iIntValue + "; ");
                sb.append("line-clamp: " + iIntValue + "; ");
                sb.append("display: flex; -webkit-box-orient: vertical; ");
            }
        }
        Float f = this.percentFontSize;
        if (f != null) {
            sb.append("font-size: " + f.floatValue() + "vh; ");
        }
        Integer num3 = this.fontColor;
        if (num3 != null) {
            sb.append("color: " + m(num3.intValue()) + "; ");
        }
        sdk.pendo.io.h7.d dVar = this.fontStyle;
        if (dVar != null) {
            sb.append("font-style: " + dVar.getCssName() + "; ");
        }
        sdk.pendo.io.h7.e eVar = this.fontWeight;
        if (eVar != null) {
            sb.append("font-weight: " + eVar.getCssName() + "; ");
        }
        w wVar = this.textHorizontalAlignment;
        if (wVar != null) {
            sb.append(wVar.c());
        }
        String str3 = this.fontFamily;
        if (str3 != null) {
            sb.append("font-family: " + str3 + "; ");
        }
        Float f2 = this.letterSpacing;
        if (f2 != null) {
            sb.append("letter-spacing: " + f2.floatValue() + "px; ");
        }
        return sb;
    }

    public final v e(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public final v f(Integer maxLines) {
        this.maxLines = maxLines;
        return this;
    }

    public final v g(String textUnicodeBidi) {
        this.textUnicodeBidi = textUnicodeBidi;
        return this;
    }

    public final v n(int textAlignment) {
        w.a aVar;
        if (textAlignment != 2) {
            aVar = (textAlignment == 5 || textAlignment == 8388613) ? w.a.RIGHT : w.a.CENTER;
        } else {
            aVar = w.a.LEFT;
        }
        this.textHorizontalAlignment = new w(aVar);
        return this;
    }

    public final v o(int lineHeight) {
        this.lineHeight = Integer.valueOf(lineHeight);
        return this;
    }

    public /* synthetic */ x(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, (i3 & 8) != 0 ? "div" : str2);
    }

    public final v a(sdk.pendo.io.h7.d fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    public final v b(Float letterSpacing) {
        this.letterSpacing = letterSpacing;
        return this;
    }

    public final List<Pair<String, String>> c(String input) {
        if (input == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("<pendo_(\\w+)>(.*?)</pendo_\\1>"), input, 0, 2, null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            if (i < first) {
                String strSubstring = input.substring(i, first);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (strSubstring.length() > 0) {
                    arrayList.add(TuplesKt.to(strSubstring, null));
                }
            }
            arrayList.add(TuplesKt.to(matchResult.getGroupValues().get(2), matchResult.getGroupValues().get(1)));
            i = last;
        }
        if (i < input.length()) {
            String strSubstring2 = input.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            if (strSubstring2.length() > 0) {
                arrayList.add(TuplesKt.to(strSubstring2, null));
            }
        }
        return arrayList;
    }

    public final v d(Integer fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    public final v e(String text) {
        this.text = text;
        return this;
    }

    public final v f(String textDirection) {
        this.textDirection = textDirection;
        return this;
    }

    public final v a(sdk.pendo.io.h7.e fontWeight) {
        this.fontWeight = fontWeight;
        return this;
    }

    public final v d(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    public final v a(w textAlignment) {
        Intrinsics.checkNotNullParameter(textAlignment, "textAlignment");
        this.textHorizontalAlignment = textAlignment;
        return this;
    }

    public final v a(float percentFontSize) {
        this.percentFontSize = Float.valueOf(percentFontSize);
        return this;
    }
}
