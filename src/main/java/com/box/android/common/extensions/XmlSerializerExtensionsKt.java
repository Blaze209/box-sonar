package com.box.android.common.extensions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: XmlSerializerExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a+\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a3\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a\u001a\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\"\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001¨\u0006\u000e"}, d2 = {"document", "", "Lorg/xmlpull/v1/XmlSerializer;", "docName", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "element", "name", "content", "attribute", "kotlin.jvm.PlatformType", "value", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class XmlSerializerExtensionsKt {
    public static /* synthetic */ String document$default(XmlSerializer xmlSerializer, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "UTF-8";
        }
        return document(xmlSerializer, str, function1);
    }

    public static final String document(XmlSerializer xmlSerializer, String docName, Function1<? super XmlSerializer, Unit> init) throws IOException {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(docName, "docName");
        Intrinsics.checkNotNullParameter(init, "init");
        xmlSerializer.startDocument(docName, true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        xmlSerializer.setOutput(printStream, "utf-8");
        init.invoke(xmlSerializer);
        xmlSerializer.endDocument();
        printStream.flush();
        String string = byteArrayOutputStream.toString();
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
        element(xmlSerializer, name, (Function1<? super XmlSerializer, Unit>) new Function1() { // from class: com.box.android.common.extensions.XmlSerializerExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return XmlSerializerExtensionsKt.element$lambda$0(content, (XmlSerializer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit element$lambda$0(String str, XmlSerializer element) throws IOException {
        Intrinsics.checkNotNullParameter(element, "$this$element");
        element.text(str);
        return Unit.INSTANCE;
    }

    public static final XmlSerializer attribute(XmlSerializer xmlSerializer, String name, String value) {
        Intrinsics.checkNotNullParameter(xmlSerializer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return xmlSerializer.attribute("", name, value);
    }
}
