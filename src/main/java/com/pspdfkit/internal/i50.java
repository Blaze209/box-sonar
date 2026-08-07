package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.FaceMismatch;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.exceptions.NutrientException;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class i50 extends j50 {
    public static final b Companion = new b();
    public final String c;
    public final l50 d;
    public g70 e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<i50> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.TextBlock", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("id", false);
            pluginGeneratedSerialDescriptor.addElement("textBlock", false);
            pluginGeneratedSerialDescriptor.addElement("updateInfo", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, l50.a.a, g70.a.a};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            l50 l50Var;
            g70 g70Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                l50Var = (l50) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, l50.a.a, null);
                g70Var = (g70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, g70.a.a, null);
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                l50 l50Var2 = null;
                g70 g70Var2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        l50Var2 = (l50) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, l50.a.a, l50Var2);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        g70Var2 = (g70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, g70.a.a, g70Var2);
                        i2 |= 4;
                    }
                }
                i = i2;
                strDecodeStringElement = strDecodeStringElement2;
                l50Var = l50Var2;
                g70Var = g70Var2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new i50(i, strDecodeStringElement, l50Var, g70Var);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            i50 i50Var = (i50) obj;
            encoder.getClass();
            i50Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, i50Var.c);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, l50.a.a, i50Var.d);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, g70.a.a, i50Var.e);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<i50> serializer() {
            return a.a;
        }
    }

    public static final class c {
        public final uf a;

        public c(qn qnVar, uf ufVar) {
            this.a = ufVar;
        }
    }

    public /* synthetic */ i50(int i, String str, l50 l50Var, g70 g70Var) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.c = str;
        this.d = l50Var;
        this.e = g70Var;
    }

    @Override // com.pspdfkit.internal.j50
    public final String a() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.j50
    public final m50 b() {
        return this.d;
    }

    public final qn c(int i) {
        return this.e.f.a.get(i);
    }

    public final StyleInfo d() {
        jo joVar;
        jo joVar2;
        c7 c7Var;
        c7 c7Var2;
        a7 a7Var;
        qg qgVar;
        c7 c7Var3;
        a7 a7Var2;
        qg qgVar2;
        c7 c7Var4;
        a7 a7Var3;
        tc tcVar = this.e.e;
        StyleInfo styleInfo = tcVar.c;
        if (styleInfo != null) {
            return styleInfo;
        }
        zq zqVar = tcVar.a;
        Float fValueOf = null;
        String str = (zqVar == null || (c7Var4 = zqVar.c) == null || (a7Var3 = c7Var4.a) == null) ? null : a7Var3.a;
        FaceMismatch faceMismatch = tcVar.b;
        Boolean boolValueOf = (zqVar == null || (c7Var3 = zqVar.c) == null || (a7Var2 = c7Var3.a) == null || (qgVar2 = a7Var2.b) == null) ? null : Boolean.valueOf(qgVar2.a);
        zq zqVar2 = tcVar.a;
        Boolean boolValueOf2 = (zqVar2 == null || (c7Var2 = zqVar2.c) == null || (a7Var = c7Var2.a) == null || (qgVar = a7Var.b) == null) ? null : Boolean.valueOf(qgVar.b);
        zq zqVar3 = tcVar.a;
        Float fValueOf2 = (zqVar3 == null || (c7Var = zqVar3.c) == null) ? null : Float.valueOf(c7Var.b);
        zq zqVar4 = tcVar.a;
        Integer numValueOf = zqVar4 != null ? Integer.valueOf(zqVar4.a) : null;
        zq zqVar5 = tcVar.a;
        Float fValueOf3 = (zqVar5 == null || (joVar2 = zqVar5.b) == null) ? null : Float.valueOf(joVar2.b);
        zq zqVar6 = tcVar.a;
        if (zqVar6 != null && (joVar = zqVar6.b) != null) {
            fValueOf = Float.valueOf(joVar.a);
        }
        return new StyleInfo(str, faceMismatch, boolValueOf, boolValueOf2, fValueOf2, numValueOf, fValueOf3, fValueOf);
    }

    public final ng e() {
        l50 l50Var = this.d;
        return new ng(l50Var.f, l50Var.b, a(this, this.e.e.c), this.d.d);
    }

    public static ng a(i50 i50Var, Float f, Alignment alignment, Float f2, int i) {
        if ((i & 1) != 0) {
            f = i50Var.d.f;
        }
        if ((i & 2) != 0) {
            alignment = i50Var.d.b;
        }
        if ((i & 4) != 0) {
            f2 = i50Var.d.d;
        }
        i50Var.getClass();
        alignment.getClass();
        return new ng(f, alignment, i50Var.e().c, f2);
    }

    public final int b(int i) {
        Iterator<T> it = this.e.f.a.iterator();
        int length = 0;
        while (it.hasNext()) {
            for (uf ufVar : ((qn) it.next()).a) {
                if (ufVar.a == i) {
                    return length;
                }
                length += ufVar.d.length();
            }
        }
        return length;
    }

    @Override // com.pspdfkit.internal.j50
    public final h70 c() {
        return this.e;
    }

    public final c d(int i) {
        if (i >= 0) {
            int iIntValue = i;
            for (qn qnVar : this.e.f.a) {
                if (iIntValue >= ((Number) qnVar.d.getValue()).intValue()) {
                    iIntValue -= ((Number) qnVar.d.getValue()).intValue();
                } else {
                    List<uf> list = qnVar.a;
                    int lastIndex = 0;
                    int length = 0;
                    for (Object obj : list) {
                        int i2 = lastIndex + 1;
                        if (lastIndex < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        uf ufVar = (uf) obj;
                        if (length < iIntValue) {
                            length += ufVar.d.length();
                            lastIndex = i2;
                        } else {
                            return new c(qnVar, list.get(lastIndex));
                        }
                    }
                    lastIndex = CollectionsKt.getLastIndex(qnVar.a);
                    return new c(qnVar, list.get(lastIndex));
                }
            }
        }
        throw new NutrientException("No TextBlock Element at index " + i + " (true).");
    }

    public static zq a(i50 i50Var, StyleInfo styleInfo) {
        c7 c7Var;
        c7 c7Var2;
        a7 a7Var;
        qg qgVar;
        c7 c7Var3;
        a7 a7Var2;
        qg qgVar2;
        c7 c7Var4;
        a7 a7Var3;
        jo joVar;
        jo joVar2;
        zq zqVar = i50Var.e.e.a;
        zq zqVar2 = i50Var.d.g;
        i50Var.getClass();
        zqVar2.getClass();
        Float fValueOf = null;
        Integer color = styleInfo != null ? styleInfo.getColor() : null;
        Integer numValueOf = zqVar != null ? Integer.valueOf(zqVar.a) : null;
        Integer numValueOf2 = Integer.valueOf(zqVar2.a);
        if (color == null) {
            color = numValueOf == null ? numValueOf2 : numValueOf;
        }
        int iIntValue = color.intValue();
        Float skew = styleInfo != null ? styleInfo.getSkew() : null;
        Float fValueOf2 = (zqVar == null || (joVar2 = zqVar.b) == null) ? null : Float.valueOf(joVar2.a);
        Float fValueOf3 = Float.valueOf(zqVar2.b.a);
        if (skew == null) {
            skew = fValueOf2 == null ? fValueOf3 : fValueOf2;
        }
        float fFloatValue = skew.floatValue();
        Float xScale = styleInfo != null ? styleInfo.getXScale() : null;
        Float fValueOf4 = (zqVar == null || (joVar = zqVar.b) == null) ? null : Float.valueOf(joVar.b);
        Float fValueOf5 = Float.valueOf(zqVar2.b.b);
        if (xScale == null) {
            xScale = fValueOf4 == null ? fValueOf5 : fValueOf4;
        }
        jo joVar3 = new jo(fFloatValue, xScale.floatValue());
        String family = styleInfo != null ? styleInfo.getFamily() : null;
        String str = (zqVar == null || (c7Var4 = zqVar.c) == null || (a7Var3 = c7Var4.a) == null) ? null : a7Var3.a;
        String str2 = zqVar2.c.a.a;
        if (family == null) {
            family = str == null ? str2 : str;
        }
        Boolean bold = styleInfo != null ? styleInfo.getBold() : null;
        Boolean boolValueOf = (zqVar == null || (c7Var3 = zqVar.c) == null || (a7Var2 = c7Var3.a) == null || (qgVar2 = a7Var2.b) == null) ? null : Boolean.valueOf(qgVar2.a);
        Boolean boolValueOf2 = Boolean.valueOf(zqVar2.c.a.b.a);
        if (bold == null) {
            bold = boolValueOf == null ? boolValueOf2 : boolValueOf;
        }
        boolean zBooleanValue = bold.booleanValue();
        Boolean italic = styleInfo != null ? styleInfo.getItalic() : null;
        Boolean boolValueOf3 = (zqVar == null || (c7Var2 = zqVar.c) == null || (a7Var = c7Var2.a) == null || (qgVar = a7Var.b) == null) ? null : Boolean.valueOf(qgVar.b);
        Boolean boolValueOf4 = Boolean.valueOf(zqVar2.c.a.b.b);
        if (italic == null) {
            italic = boolValueOf3 == null ? boolValueOf4 : boolValueOf3;
        }
        a7 a7Var4 = new a7(family, new qg(zBooleanValue, italic.booleanValue()));
        Float size = styleInfo != null ? styleInfo.getSize() : null;
        if (zqVar != null && (c7Var = zqVar.c) != null) {
            fValueOf = Float.valueOf(c7Var.b);
        }
        Float fValueOf6 = Float.valueOf(zqVar2.c.b);
        if (size == null) {
            size = fValueOf == null ? fValueOf6 : fValueOf;
        }
        return new zq(iIntValue, joVar3, new c7(a7Var4, size.floatValue()));
    }

    public final StyleInfo a(g70 g70Var) {
        g70Var.getClass();
        g70 g70Var2 = this.e;
        zq zqVar = g70Var2.e.a;
        tc tcVar = g70Var.e;
        tcVar.getClass();
        g70Var2.e = tcVar;
        g70 g70Var3 = this.e;
        tc tcVar2 = g70Var3.e;
        if (tcVar2.a == null) {
            tcVar2.a = zqVar;
        }
        dc dcVar = g70Var.d;
        dcVar.getClass();
        g70Var3.d = dcVar;
        this.e.h = g70Var.h;
        return d();
    }

    public final int a(int i) {
        try {
            uf ufVar = d(i).a;
            ufVar.getClass();
            return ufVar.a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
