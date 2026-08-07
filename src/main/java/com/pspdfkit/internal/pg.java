package com.pspdfkit.internal;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class pg {
    public static final b Companion = new b();
    public static final Lazy<KSerializer<Object>>[] c = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.pg$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return pg.a();
        }
    })};
    public final String a;
    public final List<qg> b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<pg> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.FaceListEntry", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("family", false);
            pluginGeneratedSerialDescriptor.addElement("variants", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{StringSerializer.INSTANCE, pg.c[1].getValue()};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            String strDecodeStringElement;
            List list;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = pg.c;
            String strDecodeStringElement2 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), null);
                i = 3;
            } else {
                boolean z = true;
                int i2 = 0;
                List list2 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), list2);
                        i2 |= 2;
                    }
                }
                i = i2;
                strDecodeStringElement = strDecodeStringElement2;
                list = list2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new pg(i, strDecodeStringElement, list);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            pg pgVar = (pg) obj;
            encoder.getClass();
            pgVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            Lazy<KSerializer<Object>>[] lazyArr = pg.c;
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, pgVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), pgVar.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<pg> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ pg(int i, String str, List list) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = str;
        this.b = list;
    }

    public static final /* synthetic */ KSerializer a() {
        return new ArrayListSerializer(qg.a.a);
    }

    public final String toString() {
        return this.a + " " + this.b;
    }
}
