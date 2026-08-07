package com.geniusscansdk.ocr;

import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import com.geniusscansdk.Size;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: SpatialString.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a(\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0000\u001a\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¨\u0006\u0016"}, d2 = {"description", "", "Lcom/geniusscansdk/ocr/SpatialString;", "toSpatialFloat", "Lcom/geniusscansdk/ocr/SpatialFloat;", "intersects", "", "areaOfInterestFromTopOfText", "", "topAndBottomOfText", "Lkotlin/Pair;", "hocrToSpatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "hocr", "fileSize", "Lcom/geniusscansdk/Size;", "readSpanLine", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "readLine", "readSpanWord", "readWord", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SpatialStringKt {
    public static final String description(SpatialString spatialString) {
        Intrinsics.checkNotNullParameter(spatialString, "<this>");
        RectangleF boundingBox = spatialString.getBoundingBox();
        if (boundingBox == null) {
            boundingBox = new RectangleF();
        }
        return boundingBox + " / " + spatialString.getString();
    }

    public static final SpatialFloat toSpatialFloat(SpatialString spatialString) {
        MatchGroupCollection groups;
        Intrinsics.checkNotNullParameter(spatialString, "<this>");
        Pattern patternCompile = Pattern.compile("(?<![.,\\d])(?<integer>[OIl0-9]+((?<thousandsSeparator>[ ,.])[OIl0-9]{3,})*)(?!\\k<thousandsSeparator>)[.,](?<fractional>[OIl0-9]{2})(?![.,\\d])");
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(TypedValues.Custom.S_INT, 1), TuplesKt.to("fractional", 4));
        Intrinsics.checkNotNull(patternCompile);
        MatchResult matchResultFind = new Regex(patternCompile).find(spatialString.getString(), 0);
        if (matchResultFind == null || (groups = matchResultFind.getGroups()) == null) {
            return null;
        }
        Object obj = mapMapOf.get(TypedValues.Custom.S_INT);
        Intrinsics.checkNotNull(obj);
        MatchGroup matchGroup = groups.get(((Number) obj).intValue());
        if (matchGroup == null) {
            return null;
        }
        String strReplacingLettersConfusedWithDigits = StringHelperKt.replacingLettersConfusedWithDigits(matchGroup.getValue());
        StringBuilder sb = new StringBuilder();
        int length = strReplacingLettersConfusedWithDigits.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strReplacingLettersConfusedWithDigits.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        MatchGroupCollection groups2 = matchResultFind.getGroups();
        Object obj2 = mapMapOf.get("fractional");
        Intrinsics.checkNotNull(obj2);
        MatchGroup matchGroup2 = groups2.get(((Number) obj2).intValue());
        Intrinsics.checkNotNull(matchGroup2);
        String strReplacingLettersConfusedWithDigits2 = StringHelperKt.replacingLettersConfusedWithDigits(matchGroup2.getValue());
        StringBuilder sb2 = new StringBuilder();
        int length2 = strReplacingLettersConfusedWithDigits2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char cCharAt2 = strReplacingLettersConfusedWithDigits2.charAt(i2);
            if (Character.isDigit(cCharAt2)) {
                sb2.append(cCharAt2);
            }
        }
        return new SpatialFloat(Double.parseDouble(string + "." + sb2.toString()), spatialString.getBoundingBox(), spatialString.getDocumentSize());
    }

    public static final boolean intersects(SpatialString spatialString, float f, Pair<Float, Float> topAndBottomOfText) {
        Intrinsics.checkNotNullParameter(spatialString, "<this>");
        Intrinsics.checkNotNullParameter(topAndBottomOfText, "topAndBottomOfText");
        if (spatialString.getBoundingBox() == null) {
            return true;
        }
        RectangleF rectangleF = new RectangleF(0.0f, topAndBottomOfText.getFirst().floatValue(), spatialString.getDocumentSize().getWidth(), topAndBottomOfText.getFirst().floatValue() + (f * (topAndBottomOfText.getSecond().floatValue() - topAndBottomOfText.getFirst().floatValue())));
        return spatialString.getBoundingBox().intersects(rectangleF.getLeft(), rectangleF.getTop(), rectangleF.getRight(), rectangleF.getBottom());
    }

    public static final SpatialText hocrToSpatialText(String hocr, Size fileSize) throws XmlPullParserException, IOException {
        SpatialString spanLine;
        Intrinsics.checkNotNullParameter(hocr, "hocr");
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        Intrinsics.checkNotNullExpressionValue(xmlPullParserNewPullParser, "newPullParser(...)");
        xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        byte[] bytes = hocr.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes), null);
        xmlPullParserNewPullParser.nextTag();
        ArrayList arrayList = new ArrayList();
        xmlPullParserNewPullParser.require(2, null, TextRecognitionConverter.Tags.HTML);
        while (xmlPullParserNewPullParser.next() != 1) {
            if (xmlPullParserNewPullParser.getEventType() == 2 && Intrinsics.areEqual(xmlPullParserNewPullParser.getName(), "span") && (spanLine = readSpanLine(xmlPullParserNewPullParser, fileSize)) != null) {
                arrayList.add(spanLine);
            }
        }
        return new SpatialText(arrayList);
    }

    public static final SpatialString readSpanLine(XmlPullParser parser, Size fileSize) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        if (Intrinsics.areEqual(parser.getAttributeValue(null, TextRecognitionConverter.Attributes.CLASS), TextRecognitionConverter.Values.OCR_LINE)) {
            return readLine(parser, fileSize);
        }
        return null;
    }

    public static final SpatialString readLine(XmlPullParser parser, Size size) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Size fileSize = size;
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        String attributeValue = parser.getAttributeValue(null, "title");
        Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) StringsKt.removePrefix((String) StringsKt.split$default((CharSequence) attributeValue, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null).get(0), (CharSequence) "bbox")).toString(), new String[]{" "}, false, 0, 6, (Object) null);
        RectangleF rectangleF = new RectangleF(Float.parseFloat((String) listSplit$default.get(0)), Float.parseFloat((String) listSplit$default.get(1)), Float.parseFloat((String) listSplit$default.get(2)), Float.parseFloat((String) listSplit$default.get(3)));
        ArrayList arrayList = new ArrayList();
        while (true) {
            parser.next();
            if (parser.getEventType() == 2) {
                break;
            }
            fileSize = size;
        }
        SpatialString spanWord = readSpanWord(parser, size);
        while (spanWord != null) {
            arrayList.add(spanWord);
            while (true) {
                parser.next();
                if (parser.getEventType() == 3 && Intrinsics.areEqual(parser.getName(), "span")) {
                    break;
                }
            }
            do {
                parser.next();
            } while (parser.getEventType() == 4);
            if (parser.getEventType() == 3 && Intrinsics.areEqual(parser.getName(), "span")) {
                break;
            }
            spanWord = readSpanWord(parser, size);
        }
        ArrayList arrayList2 = arrayList;
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, " ", null, null, 0, null, new Function1() { // from class: com.geniusscansdk.ocr.SpatialStringKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SpatialStringKt.readLine$lambda$4((SpatialString) obj);
            }
        }, 30, null);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Double.valueOf(((SpatialString) it.next()).getConfidence()));
        }
        return new SpatialString(strJoinToString$default, CollectionsKt.averageOfDouble(arrayList3), rectangleF, fileSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence readLine$lambda$4(SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getString();
    }

    public static final SpatialString readSpanWord(XmlPullParser parser, Size fileSize) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        if (Intrinsics.areEqual(parser.getAttributeValue(null, TextRecognitionConverter.Attributes.CLASS), TextRecognitionConverter.Values.OCR_WORD)) {
            return readWord(parser, fileSize);
        }
        return null;
    }

    public static final SpatialString readWord(XmlPullParser parser, Size fileSize) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(fileSize, "fileSize");
        String attributeValue = parser.getAttributeValue(null, "title");
        Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
        List listSplit$default = StringsKt.split$default((CharSequence) attributeValue, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null);
        List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) StringsKt.removePrefix((String) listSplit$default.get(0), (CharSequence) "bbox")).toString(), new String[]{" "}, false, 0, 6, (Object) null);
        RectangleF rectangleF = new RectangleF(Float.parseFloat((String) listSplit$default2.get(0)), Float.parseFloat((String) listSplit$default2.get(1)), Float.parseFloat((String) listSplit$default2.get(2)), Float.parseFloat((String) listSplit$default2.get(3)));
        double d = Double.parseDouble(StringsKt.trim((CharSequence) StringsKt.removePrefix(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString(), (CharSequence) TextRecognitionConverter.Values.OCR_CONFIDENCE)).toString());
        do {
            parser.next();
        } while (parser.getText() == null);
        String text = parser.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (StringsKt.isBlank(text)) {
            return null;
        }
        String text2 = parser.getText();
        Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
        return new SpatialString(text2, d, rectangleF, fileSize);
    }
}
