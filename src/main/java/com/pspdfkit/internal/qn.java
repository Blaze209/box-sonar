package com.pspdfkit.internal;

import com.facebook.react.uimanager.ViewProps;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class qn {
    public static final b Companion = new b();
    public static final Lazy<KSerializer<Object>>[] j = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.qn$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return qn.a();
        }
    }), null, null, null, null, null};
    public final List<uf> a;
    public final ao b;
    public final t70 c;
    public final Lazy d;
    public final Lazy e;
    public final float f;
    public final float g;
    public final float h;
    public final Lazy i;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<qn> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.Line", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement("elements", false);
            pluginGeneratedSerialDescriptor.addElement("lineSpacing", false);
            pluginGeneratedSerialDescriptor.addElement("offset", false);
            pluginGeneratedSerialDescriptor.addElement("height", true);
            pluginGeneratedSerialDescriptor.addElement(ViewProps.TOP, true);
            pluginGeneratedSerialDescriptor.addElement(ViewProps.BOTTOM, true);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
            return new KSerializer[]{qn.j[0].getValue(), ao.a.a, t70.a.a, floatSerializer, floatSerializer, floatSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            float fDecodeFloatElement;
            float f;
            float f2;
            int i;
            List list;
            ao aoVar;
            t70 t70Var;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = qn.j;
            int i2 = 5;
            int i3 = 0;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, lazyArr[0].getValue(), null);
                ao aoVar2 = (ao) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ao.a.a, null);
                t70 t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, null);
                float fDecodeFloatElement2 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 3);
                float fDecodeFloatElement3 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 4);
                list = list2;
                i = 63;
                fDecodeFloatElement = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 5);
                aoVar = aoVar2;
                f = fDecodeFloatElement2;
                t70Var = t70Var2;
                f2 = fDecodeFloatElement3;
            } else {
                float fDecodeFloatElement4 = 0.0f;
                float fDecodeFloatElement5 = 0.0f;
                int i4 = 1;
                int i5 = 0;
                List list3 = null;
                ao aoVar3 = null;
                t70 t70Var3 = null;
                float fDecodeFloatElement6 = 0.0f;
                while (i4 != 0) {
                    int i6 = i3;
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            i3 = i6;
                            i4 = i3;
                            i2 = 5;
                            break;
                        case 0:
                            list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, lazyArr[i6].getValue(), list3);
                            i5 |= 1;
                            i3 = i6;
                            i2 = 5;
                            break;
                        case 1:
                            aoVar3 = (ao) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ao.a.a, aoVar3);
                            i5 |= 2;
                            i3 = i6;
                            break;
                        case 2:
                            t70Var3 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, t70.a.a, t70Var3);
                            i5 |= 4;
                            i3 = i6;
                            break;
                        case 3:
                            fDecodeFloatElement6 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 3);
                            i5 |= 8;
                            i3 = i6;
                            break;
                        case 4:
                            fDecodeFloatElement5 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, 4);
                            i5 |= 16;
                            i3 = i6;
                            break;
                        case 5:
                            fDecodeFloatElement4 = compositeDecoderBeginStructure.decodeFloatElement(serialDescriptor, i2);
                            i5 |= 32;
                            i3 = i6;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                fDecodeFloatElement = fDecodeFloatElement4;
                f = fDecodeFloatElement6;
                f2 = fDecodeFloatElement5;
                i = i5;
                list = list3;
                aoVar = aoVar3;
                t70Var = t70Var3;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new qn(i, list, aoVar, t70Var, f, f2, fDecodeFloatElement);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0045  */
        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            qn qnVar = (qn) obj;
            encoder.getClass();
            qnVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, qn.j[0].getValue(), qnVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ao.a.a, qnVar.b);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, t70.a.a, qnVar.c);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3)) {
                compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 3, qnVar.f);
            } else {
                float f = qnVar.f;
                ao aoVar = qnVar.b;
                if (Float.compare(f, aoVar.b + aoVar.a) != 0) {
                    compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 3, qnVar.f);
                }
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || Float.compare(qnVar.g, qnVar.c.b - qnVar.b.b) != 0) {
                compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 4, qnVar.g);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || Float.compare(qnVar.h, qnVar.c.b + qnVar.b.a) != 0) {
                compositeEncoderBeginStructure.encodeFloatElement(serialDescriptor, 5, qnVar.h);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<qn> serializer() {
            return a.a;
        }
    }

    public qn(int i, List list, ao aoVar, t70 t70Var, float f, float f2, float f3) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.a = list;
        this.b = aoVar;
        this.c = t70Var;
        this.d = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.qn$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(qn.a(this.f$0));
            }
        });
        this.e = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.qn$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(qn.b(this.f$0));
            }
        });
        if ((i & 8) == 0) {
            this.f = aoVar.b + aoVar.a;
        } else {
            this.f = f;
        }
        if ((i & 16) == 0) {
            this.g = t70Var.b - aoVar.b;
        } else {
            this.g = f2;
        }
        if ((i & 32) == 0) {
            this.h = t70Var.b + aoVar.a;
        } else {
            this.h = f3;
        }
        this.i = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.qn$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return qn.c(this.f$0);
            }
        });
    }

    public static final /* synthetic */ KSerializer a() {
        return new ArrayListSerializer(uf.a.a);
    }

    public static final float b(qn qnVar) {
        Float fValueOf;
        Iterator<T> it = qnVar.a.iterator();
        if (it.hasNext()) {
            float fMax = ((uf) it.next()).c.a;
            while (it.hasNext()) {
                fMax = Math.max(fMax, ((uf) it.next()).c.a);
            }
            fValueOf = Float.valueOf(fMax);
        } else {
            fValueOf = null;
        }
        if (fValueOf != null) {
            return fValueOf.floatValue();
        }
        return 0.0f;
    }

    public static final StringBuilder c(qn qnVar) {
        StringBuilder sb = new StringBuilder(qnVar.a.size());
        Iterator<T> it = qnVar.a.iterator();
        while (it.hasNext()) {
            sb.append(((uf) it.next()).d);
        }
        return sb;
    }

    public static final int a(qn qnVar) {
        Iterator<T> it = qnVar.a.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((uf) it.next()).d.length();
        }
        return length;
    }
}
