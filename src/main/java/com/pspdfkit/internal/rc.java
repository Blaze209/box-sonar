package com.pspdfkit.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class rc {
    public static final b Companion = new b();
    public final String a;
    public final int b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<rc> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.signatures.timestamps.DeserializeTimestampTokenRequest", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement("token", false);
            pluginGeneratedSerialDescriptor.addElement("response_code", false);
            pluginGeneratedSerialDescriptor.addElement("body", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, IntSerializer.INSTANCE, stringSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String strDecodeStringElement2;
            int iDecodeIntElement;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                i = 7;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement3 = null;
                boolean z = true;
                int iDecodeIntElement2 = 0;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else {
                        if (iDecodeElementIndex != 2) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                    }
                }
                strDecodeStringElement2 = strDecodeStringElement3;
                iDecodeIntElement = iDecodeIntElement2;
                i = i2;
            }
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new rc(i, strDecodeStringElement, iDecodeIntElement, strDecodeStringElement2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            rc rcVar = (rc) obj;
            encoder.getClass();
            rcVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, rcVar.a);
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 1, rcVar.b);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, rcVar.c);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<rc> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ rc(int i, String str, int i2, String str2) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.a.getDescriptor());
        }
        this.a = str;
        this.b = i2;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rc)) {
            return false;
        }
        rc rcVar = (rc) obj;
        return Intrinsics.areEqual(this.a, rcVar.a) && this.b == rcVar.b && Intrinsics.areEqual(this.c, rcVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + nd.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "DeserializeTimestampTokenRequest(token=" + this.a + ", responseCode=" + this.b + ", body=" + this.c + ")";
    }

    public rc(String str, int i, String str2) {
        str.getClass();
        this.a = str;
        this.b = i;
        this.c = str2;
    }
}
