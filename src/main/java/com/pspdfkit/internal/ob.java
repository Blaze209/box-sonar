package com.pspdfkit.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class ob {
    public static final b Companion = new b();
    public final t70 a;
    public final t70 b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<ob> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.ContentRect", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("offset", false);
            pluginGeneratedSerialDescriptor.addElement("size", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            t70.a aVar = t70.a.a;
            return new KSerializer[]{aVar, aVar};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            t70 t70Var;
            t70 t70Var2;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            t70 t70Var3 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                t70.a aVar = t70.a.a;
                t70Var = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, aVar, null);
                t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, aVar, null);
                i = 3;
            } else {
                boolean z = true;
                int i2 = 0;
                t70 t70Var4 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        t70Var3 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, t70.a.a, t70Var3);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        t70Var4 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, t70.a.a, t70Var4);
                        i2 |= 2;
                    }
                }
                i = i2;
                t70Var = t70Var3;
                t70Var2 = t70Var4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new ob(i, t70Var, t70Var2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            ob obVar = (ob) obj;
            encoder.getClass();
            obVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            t70.a aVar = t70.a.a;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, aVar, obVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, aVar, obVar.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<ob> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ ob(int i, t70 t70Var, t70 t70Var2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = t70Var;
        this.b = t70Var2;
    }

    public ob(t70 t70Var, t70 t70Var2) {
        this.a = t70Var;
        this.b = t70Var2;
    }
}
