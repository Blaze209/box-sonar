package com.geniusscansdk.ocr;

import java.io.IOException;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: XmlSerializerExt.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0000\u001a-\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0000\u001a5\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0000¨\u0006\u000f"}, d2 = {"document", "", "Lorg/xmlpull/v1/XmlSerializer;", "docName", "xmlStringWriter", "Ljava/io/StringWriter;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "element", "name", "content", "attribute", "value", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlSerializerExtKt {
    public static /* synthetic */ String document$default(XmlSerializer xmlSerializer, String str, StringWriter stringWriter, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "UTF-8";
        }
        if ((i & 2) != 0) {
            stringWriter = new StringWriter();
        }
        return document(xmlSerializer, str, stringWriter, function1);
    }

    public static final String document(XmlSerializer xmlSerializer, String docName, StringWriter xmlStringWriter, Function1<? super XmlSerializer, Unit> init) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(docName, "docName");
        Intrinsics.checkNotNullParameter(xmlStringWriter, "xmlStringWriter");
        Intrinsics.checkNotNullParameter(init, "init");
        xmlSerializer.startDocument(docName, true);
        xmlStringWriter.getBuffer().setLength(0);
        xmlSerializer.setOutput(xmlStringWriter);
        init.invoke(xmlSerializer);
        xmlSerializer.endDocument();
        String string = xmlStringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void element(XmlSerializer xmlSerializer, String name, Function1<? super XmlSerializer, Unit> init) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(init, "init");
        xmlSerializer.startTag("", name);
        init.invoke(xmlSerializer);
        xmlSerializer.endTag("", name);
    }

    public static final void element(XmlSerializer xmlSerializer, String name, String content, Function1<? super XmlSerializer, Unit> init) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(init, "init");
        xmlSerializer.startTag("", name);
        init.invoke(xmlSerializer);
        xmlSerializer.text(content);
        xmlSerializer.endTag("", name);
    }

    public static final void element(XmlSerializer xmlSerializer, String name, final String content) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        element(xmlSerializer, name, (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.geniusscansdk.ocr.XmlSerializerExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlSerializerExtKt.element$lambda$0(content, (XmlSerializer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit element$lambda$0(String str, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        element.text(str);
        return Unit.INSTANCE;
    }

    public static final XmlSerializer attribute(XmlSerializer xmlSerializer, String name, String value) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        XmlSerializer xmlSerializerAttribute = xmlSerializer.attribute("", name, value);
        Intrinsics.checkNotNullExpressionValue(xmlSerializerAttribute, "attribute(...)");
        return xmlSerializerAttribute;
    }
}
