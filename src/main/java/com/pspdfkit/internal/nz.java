package com.pspdfkit.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Base64;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
@Serializable
public final class nz {
    public static final b Companion = new b();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public static final /* synthetic */ class a implements GeneratedSerializer<nz> {
        public static final a a;
        private static final SerialDescriptor descriptor;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.signatures.ltv.RevocationRequest", aVar, 5);
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
            return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        public final Object deserialize(Decoder decoder) {
            String strDecodeStringElement;
            String strDecodeStringElement2;
            String strDecodeStringElement3;
            String str;
            String str2;
            int i;
            decoder.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
            if (compositeDecoderBeginStructure.decodeSequentially()) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                str = strDecodeStringElement5;
                str2 = strDecodeStringElement4;
                i = 31;
            } else {
                strDecodeStringElement = null;
                String strDecodeStringElement6 = null;
                String strDecodeStringElement7 = null;
                String strDecodeStringElement8 = null;
                String strDecodeStringElement9 = null;
                boolean z = true;
                int i2 = 0;
                while (z) {
                    int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                    if (iDecodeElementIndex == -1) {
                        z = false;
                    } else if (iDecodeElementIndex == 0) {
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iDecodeElementIndex == 1) {
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i2 |= 16;
                    }
                }
                strDecodeStringElement2 = strDecodeStringElement6;
                strDecodeStringElement3 = strDecodeStringElement7;
                str = strDecodeStringElement8;
                str2 = strDecodeStringElement9;
                i = i2;
            }
            String str3 = strDecodeStringElement;
            compositeDecoderBeginStructure.endStructure(serialDescriptor);
            return new nz(i, str3, str2, str, strDecodeStringElement2, strDecodeStringElement3);
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        @Override // kotlinx.serialization.SerializationStrategy
        public final void serialize(Encoder encoder, Object obj) {
            nz nzVar = (nz) obj;
            encoder.getClass();
            nzVar.getClass();
            SerialDescriptor serialDescriptor = descriptor;
            CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, nzVar.a);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, nzVar.b);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, nzVar.c);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, nzVar.d);
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 4, nzVar.e);
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public final KSerializer<nz> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ nz(int i, String str, String str2, String str3, String str4, String str5) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.a.getDescriptor());
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final Response a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        byte[] bArrDecode = Base64.getDecoder().decode(StringsKt.encodeToByteArray(this.b));
        OkHttpClient okHttpClientBuild = builder.build();
        Request.Builder builderAddHeader = new Request.Builder().url(this.e).addHeader("Content-Type", "application/ocsp-request");
        RequestBody.Companion companion = RequestBody.INSTANCE;
        bArrDecode.getClass();
        return okHttpClientBuild.newCall(builderAddHeader.post(RequestBody.Companion.create$default(companion, bArrDecode, (MediaType) null, 0, 0, 7, (Object) null)).build()).execute();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nz)) {
            return false;
        }
        nz nzVar = (nz) obj;
        return Intrinsics.areEqual(this.a, nzVar.a) && Intrinsics.areEqual(this.b, nzVar.b) && Intrinsics.areEqual(this.c, nzVar.c) && Intrinsics.areEqual(this.d, nzVar.d) && Intrinsics.areEqual(this.e, nzVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + z40.a(this.d, z40.a(this.c, z40.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "RevocationRequest(method=" + this.a + ", requestData=" + this.b + ", token=" + this.c + ", type=" + this.d + ", url=" + this.e + ")";
    }
}
