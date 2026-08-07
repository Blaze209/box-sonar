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
public final class pb {
    public static final b Companion = new b();
    public final u70 a;
    public final u70 b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<pb> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.models.ContentRectInt", aVar, 2);
            pluginGeneratedSerialDescriptor.addElement("offset", false);
            pluginGeneratedSerialDescriptor.addElement("size", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            u70.a aVar = u70.a.a;
            return new KSerializer[]{aVar, aVar};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            int i;
            u70 u70Var;
            u70 u70Var2;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            u70 u70Var3 = null;
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                u70.a aVar = u70.a.a;
                u70Var = (u70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, aVar, null);
                u70Var2 = (u70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, aVar, null);
                i = 3;
            } else {
                boolean z = true;
                int i2 = 0;
                u70 u70Var4 = null;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        u70Var3 = (u70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, u70.a.a, u70Var3);
                        i2 |= 1;
                    } else {
                        if (iDecodeElementIndex != 1) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        u70Var4 = (u70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, u70.a.a, u70Var4);
                        i2 |= 2;
                    }
                }
                i = i2;
                u70Var = u70Var3;
                u70Var2 = u70Var4;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new pb(i, u70Var, u70Var2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            pb pbVar = (pb) obj;
            encoder.getClass();
            pbVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            u70.a aVar = u70.a.a;
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, aVar, pbVar.a);
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, aVar, pbVar.b);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<pb> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ pb(int i, u70 u70Var, u70 u70Var2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, a.a.getDescriptor());
        }
        this.a = u70Var;
        this.b = u70Var2;
    }

    public pb(u70 u70Var, u70 u70Var2) {
        u70Var2.getClass();
        this.a = u70Var;
        this.b = u70Var2;
    }
}
