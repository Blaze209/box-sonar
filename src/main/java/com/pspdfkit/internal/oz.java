package com.pspdfkit.internal;

import java.util.Base64;
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
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class oz {
    public static final b Companion = new b();
    public final String a;
    public final String b;
    public final int c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<oz> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.signatures.ltv.RevocationResponse", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("type", true);
            pluginGeneratedSerialDescriptor.addElement("token", false);
            pluginGeneratedSerialDescriptor.addElement("response_code", false);
            pluginGeneratedSerialDescriptor.addElement("body", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, stringSerializer, IntSerializer.INSTANCE, stringSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String strDecodeStringElement2;
            int i;
            String str;
            int i2;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                i = iDecodeIntElement;
                str = strDecodeStringElement3;
                i2 = 15;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement4 = null;
                String strDecodeStringElement5 = null;
                boolean z = true;
                int iDecodeIntElement2 = 0;
                int i3 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i3 |= 4;
                    } else {
                        if (iDecodeElementIndex != 3) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i3 |= 8;
                    }
                }
                strDecodeStringElement2 = strDecodeStringElement4;
                i = iDecodeIntElement2;
                str = strDecodeStringElement5;
                i2 = i3;
            }
            String str2 = strDecodeStringElement;
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new oz(i2, str2, str, i, strDecodeStringElement2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            oz ozVar = (oz) obj;
            encoder.getClass();
            ozVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(ozVar.a, "pspdfkit/http-response")) {
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, ozVar.a);
            }
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, ozVar.b);
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 2, ozVar.c);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, ozVar.d);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public static oz a(String str, Response response) {
            str.getClass();
            response.getClass();
            String strEncodeToString = Base64.getEncoder().encodeToString(response.body().bytes());
            int iCode = response.code();
            strEncodeToString.getClass();
            return new oz(str, iCode, strEncodeToString);
        }

        public final KSerializer<oz> serializer() {
            return a.a;
        }
    }

    public oz(String str, int i, String str2) {
        str.getClass();
        str2.getClass();
        this.a = "pspdfkit/http-response";
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oz)) {
            return false;
        }
        oz ozVar = (oz) obj;
        return Intrinsics.areEqual(this.a, ozVar.a) && Intrinsics.areEqual(this.b, ozVar.b) && this.c == ozVar.c && Intrinsics.areEqual(this.d, ozVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + nd.a(this.c, z40.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "RevocationResponse(type=" + this.a + ", token=" + this.b + ", responseCode=" + this.c + ", body=" + this.d + ")";
    }

    public /* synthetic */ oz(int i, String str, String str2, int i2, String str3) {
        if (14 != (i & 14)) {
            PluginExceptionsKt.throwMissingFieldException(i, 14, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = "pspdfkit/http-response";
        } else {
            this.a = str;
        }
        this.b = str2;
        this.c = i2;
        this.d = str3;
    }
}
