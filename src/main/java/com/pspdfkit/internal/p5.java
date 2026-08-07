package com.pspdfkit.internal;

import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.StyleInfo$$serializer;
import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.utils.Size;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
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
public final class p5 extends ha<a> {
    public final NativeContentEditingCommand d;
    public final KSerializer<a> e;
    public final a f;

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final String a;
        public final ng b;
        public final StyleInfo c;

        /* JADX INFO: renamed from: com.pspdfkit.internal.p5$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0280a implements GeneratedSerializer<a> {
            public static final C0280a a;
            private static final SerialDescriptor descriptor;

            static {
                C0280a c0280a = new C0280a();
                a = c0280a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.ApplyFormat.Input", c0280a, 3);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                pluginGeneratedSerialDescriptor.addElement("formatModifications", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, ng.a.a, StyleInfo$$serializer.INSTANCE};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String strDecodeStringElement;
                ng ngVar;
                StyleInfo styleInfo;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement2 = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    ngVar = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, null);
                    styleInfo = (StyleInfo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, null);
                    i = 7;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    ng ngVar2 = null;
                    StyleInfo styleInfo2 = null;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            ngVar2 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, ngVar2);
                            i2 |= 2;
                        } else {
                            if (iDecodeElementIndex != 2) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            styleInfo2 = (StyleInfo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, styleInfo2);
                            i2 |= 4;
                        }
                    }
                    i = i2;
                    strDecodeStringElement = strDecodeStringElement2;
                    ngVar = ngVar2;
                    styleInfo = styleInfo2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, strDecodeStringElement, ngVar, styleInfo);
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                a aVar = (a) obj;
                encoder.getClass();
                aVar.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, aVar.a);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ng.a.a, aVar.b);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, StyleInfo$$serializer.INSTANCE, aVar.c);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0280a.a;
            }
        }

        public /* synthetic */ a(int i, String str, ng ngVar, StyleInfo styleInfo) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, C0280a.a.getDescriptor());
            }
            this.a = str;
            this.b = ngVar;
            this.c = styleInfo;
        }

        public a(String str, ng ngVar, StyleInfo styleInfo) {
            str.getClass();
            styleInfo.getClass();
            this.a = str;
            this.b = ngVar;
            this.c = styleInfo;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(i50 i50Var, Size size, StyleInfo styleInfo) {
        super(i50Var, size);
        i50Var.getClass();
        styleInfo.getClass();
        this.d = NativeContentEditingCommand.APPLY_FORMAT;
        this.e = a.Companion.serializer();
        this.f = new a(i50Var.c, i50Var.e(), styleInfo);
    }

    @Override // com.pspdfkit.internal.ga
    public final Object b() {
        return this.f;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy c() {
        return this.e;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.d;
    }
}
