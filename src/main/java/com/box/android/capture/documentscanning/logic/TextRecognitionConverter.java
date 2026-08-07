package com.box.android.capture.documentscanning.logic;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Xml;
import com.box.android.common.extensions.XmlSerializerExtensionsKt;
import com.google.mlkit.vision.text.Text;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: TextRecognitionConverter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003#$%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0016\u001a\u00020\u000b*\u00020\tH\u0002J\f\u0010\u0017\u001a\u00020\u000b*\u00020\tH\u0002J\u001d\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\u00020\u001e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001eH\u0002¨\u0006&"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/TextRecognitionConverter;", "", "<init>", "()V", "convertTextToHOcr", "Lcom/box/android/capture/documentscanning/logic/TextRecognitionConversionResult;", "text", "Lcom/google/mlkit/vision/text/Text;", "bbox", "Landroid/graphics/Rect;", "dumpHOcrAndGetLanguage", "", "textBlock", "Lcom/google/mlkit/vision/text/Text$TextBlock;", "serializer", "Lorg/xmlpull/v1/XmlSerializer;", "dumpHOcr", "", "line", "Lcom/google/mlkit/vision/text/Text$Line;", "element", "Lcom/google/mlkit/vision/text/Text$Element;", "getXSize", "getBBoxString", "getTextRotation", "points", "", "Landroid/graphics/Point;", "([Landroid/graphics/Point;)Ljava/lang/String;", "calculateSlope", "", "([Landroid/graphics/Point;)I", "calculateVerticalTextAngle", "baseline", "slope", "Tags", "Attributes", "Values", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextRecognitionConverter {
    public static final int $stable = 0;
    public static final TextRecognitionConverter INSTANCE = new TextRecognitionConverter();

    private TextRecognitionConverter() {
    }

    /* JADX INFO: compiled from: TextRecognitionConverter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/TextRecognitionConverter$Tags;", "", "<init>", "()V", "HTML", "", "HEAD", "META", "BODY", "DIV", "PARAGRAPH", "SPAN", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Tags {
        public static final int $stable = 0;
        public static final String BODY = "body";
        public static final String DIV = "div";
        public static final String HEAD = "head";
        public static final String HTML = "html";
        public static final Tags INSTANCE = new Tags();
        public static final String META = "meta";
        public static final String PARAGRAPH = "p";
        public static final String SPAN = "span";

        private Tags() {
        }
    }

    /* JADX INFO: compiled from: TextRecognitionConverter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/TextRecognitionConverter$Attributes;", "", "<init>", "()V", "HTTP_EQUIV", "", "CONTENT", "TITLE", "CLASS", "ID", "LANG", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Attributes {
        public static final int $stable = 0;
        public static final String CLASS = "class";
        public static final String CONTENT = "content";
        public static final String HTTP_EQUIV = "http-equiv";
        public static final String ID = "id";
        public static final Attributes INSTANCE = new Attributes();
        public static final String LANG = "lang";
        public static final String TITLE = "title";

        private Attributes() {
        }
    }

    /* JADX INFO: compiled from: TextRecognitionConverter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/TextRecognitionConverter$Values;", "", "<init>", "()V", "IMAGE", "", "PAGE_NUMBER", "OCR_PAGE", "OCR_AREA", "OCR_PARAGRAPH", "OCR_LINE", "OCR_WORD", "OCR_X_SIZE", "OCR_ASCENDERS", "OCR_DESCENDERS", "OCR_CONFIDENCE", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Values {
        public static final int $stable = 0;
        public static final String IMAGE = "image";
        public static final Values INSTANCE = new Values();
        public static final String OCR_AREA = "ocr_carea";
        public static final String OCR_ASCENDERS = "x_ascenders";
        public static final String OCR_CONFIDENCE = "x_wconf";
        public static final String OCR_DESCENDERS = "x_descenders";
        public static final String OCR_LINE = "ocr_line";
        public static final String OCR_PAGE = "ocr_page";
        public static final String OCR_PARAGRAPH = "ocr_par";
        public static final String OCR_WORD = "ocrx_word";
        public static final String OCR_X_SIZE = "x_size";
        public static final String PAGE_NUMBER = "ppageno";

        private Values() {
        }
    }

    public final TextRecognitionConversionResult convertTextToHOcr(final Text text, final Rect bbox) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(bbox, "bbox");
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        Intrinsics.checkNotNullExpressionValue(xmlSerializerNewSerializer, "newSerializer(...)");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new TextRecognitionConversionResult(XmlSerializerExtensionsKt.document$default(xmlSerializerNewSerializer, null, new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0(bbox, text, linkedHashMap, (XmlSerializer) obj);
            }
        }, 1, null), linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0(final Rect rect, final Text text, final Map map, XmlSerializer document) throws IOException {
        Intrinsics.checkNotNullParameter(document, "$this$document");
        XmlSerializerExtensionsKt.element(document, Tags.HTML, (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0$0(rect, text, map, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0$0(final Rect rect, final Text text, final Map map, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.element(element, "head", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0$0$0((XmlSerializer) obj);
            }
        });
        XmlSerializerExtensionsKt.element(element, "body", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0$0$1(rect, text, map, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0$0$0(XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.element(element, Tags.META, (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0$0$0$0((XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0$0$0$0(XmlSerializer element) {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.attribute(element, Attributes.HTTP_EQUIV, "Content-Type");
        XmlSerializerExtensionsKt.attribute(element, "content", "text/html;charset=utf-8");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0$0$1(final Rect rect, final Text text, final Map map, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.element(element, "div", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.convertTextToHOcr$lambda$0$0$1$0(rect, text, map, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertTextToHOcr$lambda$0$0$1$0(Rect rect, Text text, Map map, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.attribute(element, Attributes.CLASS, Values.OCR_PAGE);
        XmlSerializerExtensionsKt.attribute(element, "title", "image \"\"; " + INSTANCE.getBBoxString(rect) + "; ppageno 0");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XmlSerializerExtensionsKt.attribute(element, "id", string);
        for (Text.TextBlock textBlock : text.getTextBlocks()) {
            TextRecognitionConverter textRecognitionConverter = INSTANCE;
            Intrinsics.checkNotNull(textBlock);
            String strDumpHOcrAndGetLanguage = textRecognitionConverter.dumpHOcrAndGetLanguage(textBlock, element);
            Integer num = (Integer) map.get(strDumpHOcrAndGetLanguage);
            map.put(strDumpHOcrAndGetLanguage, Integer.valueOf((num != null ? num.intValue() : 0) + textBlock.getText().length()));
        }
        return Unit.INSTANCE;
    }

    private final String dumpHOcrAndGetLanguage(final Text.TextBlock textBlock, XmlSerializer serializer) throws IOException {
        final Rect boundingBox = textBlock.getBoundingBox();
        if (boundingBox != null) {
            XmlSerializerExtensionsKt.element(serializer, "div", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextRecognitionConverter.dumpHOcrAndGetLanguage$lambda$0$0(boundingBox, textBlock, (XmlSerializer) obj);
                }
            });
        }
        String recognizedLanguage = textBlock.getRecognizedLanguage();
        Intrinsics.checkNotNullExpressionValue(recognizedLanguage, "getRecognizedLanguage(...)");
        return recognizedLanguage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpHOcrAndGetLanguage$lambda$0$0(final Rect rect, final Text.TextBlock textBlock, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.attribute(element, Attributes.CLASS, Values.OCR_AREA);
        XmlSerializerExtensionsKt.attribute(element, "title", INSTANCE.getBBoxString(rect));
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XmlSerializerExtensionsKt.attribute(element, "id", string);
        XmlSerializerExtensionsKt.element(element, "p", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.dumpHOcrAndGetLanguage$lambda$0$0$0(rect, textBlock, (XmlSerializer) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpHOcrAndGetLanguage$lambda$0$0$0(Rect rect, Text.TextBlock textBlock, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.attribute(element, Attributes.CLASS, Values.OCR_PARAGRAPH);
        XmlSerializerExtensionsKt.attribute(element, "title", INSTANCE.getBBoxString(rect));
        String recognizedLanguage = textBlock.getRecognizedLanguage();
        Intrinsics.checkNotNullExpressionValue(recognizedLanguage, "getRecognizedLanguage(...)");
        XmlSerializerExtensionsKt.attribute(element, Attributes.LANG, recognizedLanguage);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XmlSerializerExtensionsKt.attribute(element, "id", string);
        for (Text.Line line : textBlock.getLines()) {
            TextRecognitionConverter textRecognitionConverter = INSTANCE;
            Intrinsics.checkNotNull(line);
            textRecognitionConverter.dumpHOcr(line, element);
        }
        return Unit.INSTANCE;
    }

    private final void dumpHOcr(final Text.Line line, XmlSerializer serializer) throws IOException {
        XmlSerializerExtensionsKt.element(serializer, "span", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextRecognitionConverter.dumpHOcr$lambda$0(line, (XmlSerializer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpHOcr$lambda$0(Text.Line line, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        XmlSerializerExtensionsKt.attribute(element, Attributes.CLASS, Values.OCR_LINE);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XmlSerializerExtensionsKt.attribute(element, "id", string);
        Rect boundingBox = line.getBoundingBox();
        if (boundingBox != null) {
            TextRecognitionConverter textRecognitionConverter = INSTANCE;
            XmlSerializerExtensionsKt.attribute(element, "title", textRecognitionConverter.getBBoxString(boundingBox) + "; " + textRecognitionConverter.getTextRotation(line.getCornerPoints()) + "; " + textRecognitionConverter.getXSize(boundingBox) + "; x_descenders 0; x_ascenders 0");
        }
        for (Text.Element element2 : line.getElements()) {
            TextRecognitionConverter textRecognitionConverter2 = INSTANCE;
            Intrinsics.checkNotNull(element2);
            textRecognitionConverter2.dumpHOcr(element2, element);
        }
        return Unit.INSTANCE;
    }

    private final void dumpHOcr(final Text.Element element, XmlSerializer serializer) throws IOException {
        final Rect boundingBox = element.getBoundingBox();
        if (boundingBox != null) {
            XmlSerializerExtensionsKt.element(serializer, "span", (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.capture.documentscanning.logic.TextRecognitionConverter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TextRecognitionConverter.dumpHOcr$lambda$1$0(boundingBox, element, (XmlSerializer) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpHOcr$lambda$1$0(Rect rect, Text.Element element, XmlSerializer element2) throws IOException {
        Intrinsics.checkNotNullParameter(element2, "$this$element");
        XmlSerializerExtensionsKt.attribute(element2, Attributes.CLASS, Values.OCR_WORD);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XmlSerializerExtensionsKt.attribute(element2, "id", string);
        XmlSerializerExtensionsKt.attribute(element2, "title", INSTANCE.getBBoxString(rect) + "; x_wconf 90");
        element2.text(element.getText());
        return Unit.INSTANCE;
    }

    private final String getXSize(Rect rect) {
        return "x_size " + (rect.bottom - rect.top);
    }

    private final String getBBoxString(Rect rect) {
        return "bbox " + rect.left + " " + rect.top + " " + rect.right + " " + rect.bottom;
    }

    private final String getTextRotation(Point[] points) {
        if (points != null) {
            if (points[2].x - points[3].x == 0) {
                return "textangle " + INSTANCE.calculateVerticalTextAngle(points);
            }
            TextRecognitionConverter textRecognitionConverter = INSTANCE;
            return textRecognitionConverter.baseline(textRecognitionConverter.calculateSlope(points));
        }
        return baseline(0);
    }

    private final int calculateSlope(Point[] points) {
        try {
            return (points[2].y - points[3].y) / (points[2].x - points[3].x);
        } catch (ArithmeticException unused) {
            return 0;
        }
    }

    private final int calculateVerticalTextAngle(Point[] points) {
        return points[2].y - points[3].y < 0 ? 90 : -90;
    }

    private final String baseline(int slope) {
        return "baseline 0 " + slope;
    }
}
