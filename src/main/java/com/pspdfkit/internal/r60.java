package com.pspdfkit.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class r60 {
    public static final b Companion = new b();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<r60> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.signatures.timestamps.TimestampRequest", aVar, 6);
            pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.CONTENT_TYPE, false);
            pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.METHOD, false);
            pluginGeneratedSerialDescriptor.addElement("request_data", false);
            pluginGeneratedSerialDescriptor.addElement("token", false);
            pluginGeneratedSerialDescriptor.addElement("type", false);
            pluginGeneratedSerialDescriptor.addElement("url", false);
            descriptor = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String str;
            int i;
            String str2;
            String str3;
            String strDecodeStringElement2;
            String str4;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                String strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                str = strDecodeStringElement5;
                str4 = strDecodeStringElement6;
                str2 = strDecodeStringElement4;
                str3 = strDecodeStringElement3;
                i = 63;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement7 = null;
                String strDecodeStringElement8 = null;
                String strDecodeStringElement9 = null;
                String strDecodeStringElement10 = null;
                String strDecodeStringElement11 = null;
                boolean z = true;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    switch (iDecodeElementIndex) {
                        case -1:
                            z = false;
                            continue;
                        case 0:
                            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                            continue;
                        case 1:
                            strDecodeStringElement11 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                            i2 |= 2;
                            break;
                        case 2:
                            strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                            i2 |= 4;
                            break;
                        case 3:
                            strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                            i2 |= 8;
                            break;
                        case 4:
                            strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                            i2 |= 16;
                            break;
                        case 5:
                            strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                            i2 |= 32;
                            break;
                        default:
                            throw new UnknownFieldException(iDecodeElementIndex);
                    }
                }
                int i3 = i2;
                str = strDecodeStringElement8;
                i = i3;
                String str5 = strDecodeStringElement11;
                str2 = strDecodeStringElement10;
                str3 = str5;
                strDecodeStringElement2 = strDecodeStringElement7;
                str4 = strDecodeStringElement9;
            }
            String str6 = strDecodeStringElement;
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new r60(i, str6, str3, str2, str, str4, strDecodeStringElement2);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            r60 r60Var = (r60) obj;
            encoder.getClass();
            r60Var.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, r60Var.a);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, r60Var.b);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, r60Var.c);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, r60Var.d);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 4, r60Var.e);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 5, r60Var.f);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<r60> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ r60(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, a.a.getDescriptor());
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r60)) {
            return false;
        }
        r60 r60Var = (r60) obj;
        return Intrinsics.areEqual(this.a, r60Var.a) && Intrinsics.areEqual(this.b, r60Var.b) && Intrinsics.areEqual(this.c, r60Var.c) && Intrinsics.areEqual(this.d, r60Var.d) && Intrinsics.areEqual(this.e, r60Var.e) && Intrinsics.areEqual(this.f, r60Var.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + z40.a(this.e, z40.a(this.d, z40.a(this.c, z40.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "TimestampRequest(contentType=" + this.a + ", method=" + this.b + ", requestData=" + this.c + ", token=" + this.d + ", type=" + this.e + ", url=" + this.f + ")";
    }
}
