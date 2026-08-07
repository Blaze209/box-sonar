package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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
public final class c00 extends ga<a, Unit> {
    public final NativeContentEditingCommand a = NativeContentEditingCommand.SAVE_TO_DOCUMENT;
    public final String b;
    public final a c;
    public final KSerializer<a> d;
    public final DeserializationStrategy<Unit> e;

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public static final Lazy<KSerializer<Object>>[] c = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.pspdfkit.internal.c00$a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return c00.a.a();
            }
        })};
        public final String a;
        public final List<b> b;

        /* JADX INFO: renamed from: com.pspdfkit.internal.c00$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0254a implements GeneratedSerializer<a> {
            public static final C0254a a;
            private static final SerialDescriptor descriptor;

            static {
                C0254a c0254a = new C0254a();
                a = c0254a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.SaveToDocument.Input", c0254a, 2);
                pluginGeneratedSerialDescriptor.addElement("path", false);
                pluginGeneratedSerialDescriptor.addElement("textBlockSaveInfos", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, a.c[1].getValue()};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String strDecodeStringElement;
                List list;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                Lazy<KSerializer<Object>>[] lazyArr = a.c;
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
                return new a(i, strDecodeStringElement, list);
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
                Lazy<KSerializer<Object>>[] lazyArr = a.c;
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, aVar.a);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), aVar.b);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0254a.a;
            }
        }

        public /* synthetic */ a(int i, String str, List list) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, C0254a.a.getDescriptor());
            }
            this.a = str;
            this.b = list;
        }

        public static final /* synthetic */ KSerializer a() {
            return new ArrayListSerializer(b.a.a);
        }

        public a(String str, ArrayList arrayList) {
            this.a = str;
            this.b = arrayList;
        }
    }

    @Serializable
    public static final class b {
        public static final C0255b Companion = new C0255b();
        public final String a;
        public final t70 b;
        public final aj c;
        public final ng d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class a implements GeneratedSerializer<b> {
            public static final a a;
            private static final SerialDescriptor descriptor;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.SaveToDocument.TextBlockSaveInfo", aVar, 4);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("anchor", false);
                pluginGeneratedSerialDescriptor.addElement("globalEffects", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, t70.a.a, aj.a.a, ng.a.a};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String str;
                t70 t70Var;
                aj ajVar;
                ng ngVar;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    t70 t70Var2 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, t70.a.a, null);
                    aj ajVar2 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, null);
                    str = strDecodeStringElement2;
                    ngVar = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ng.a.a, null);
                    ajVar = ajVar2;
                    t70Var = t70Var2;
                    i = 15;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    t70 t70Var3 = null;
                    aj ajVar3 = null;
                    ng ngVar2 = null;
                    while (z) {
                        int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                        if (iDecodeElementIndex == -1) {
                            z = false;
                        } else if (iDecodeElementIndex == 0) {
                            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (iDecodeElementIndex == 1) {
                            t70Var3 = (t70) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, t70.a.a, t70Var3);
                            i2 |= 2;
                        } else if (iDecodeElementIndex == 2) {
                            ajVar3 = (aj) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, aj.a.a, ajVar3);
                            i2 |= 4;
                        } else {
                            if (iDecodeElementIndex != 3) {
                                throw new UnknownFieldException(iDecodeElementIndex);
                            }
                            ngVar2 = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, ng.a.a, ngVar2);
                            i2 |= 8;
                        }
                    }
                    i = i2;
                    str = strDecodeStringElement;
                    t70Var = t70Var3;
                    ajVar = ajVar3;
                    ngVar = ngVar2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new b(i, str, t70Var, ajVar, ngVar);
            }

            @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void serialize(Encoder encoder, Object obj) {
                b bVar = (b) obj;
                encoder.getClass();
                bVar.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, bVar.a);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, t70.a.a, bVar.b);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, aj.a.a, bVar.c);
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, ng.a.a, bVar.d);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        /* JADX INFO: renamed from: com.pspdfkit.internal.c00$b$b, reason: collision with other inner class name */
        public static final class C0255b {
            public final KSerializer<b> serializer() {
                return a.a;
            }
        }

        public /* synthetic */ b(int i, String str, t70 t70Var, aj ajVar, ng ngVar) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, a.a.getDescriptor());
            }
            this.a = str;
            this.b = t70Var;
            this.c = ajVar;
            this.d = ngVar;
        }

        public b(String str, t70 t70Var, aj ajVar, ng ngVar) {
            str.getClass();
            t70Var.getClass();
            ajVar.getClass();
            this.a = str;
            this.b = t70Var;
            this.c = ajVar;
            this.d = ngVar;
        }
    }

    public static final class c extends za<Unit> {
        public c(DeserializationStrategy<Unit> deserializationStrategy) {
            super(deserializationStrategy);
        }

        @Override // com.pspdfkit.internal.za
        public final String a(NativeContentEditingResult nativeContentEditingResult) {
            return "{}";
        }
    }

    public c00(String str, ArrayList arrayList) {
        this.b = "[path = " + str + ", " + arrayList.size() + " textblocks changed]";
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            i50 i50Var = (i50) obj;
            String str2 = i50Var.c;
            l50 l50Var = i50Var.d;
            arrayList2.add(new b(str2, l50Var.a, l50Var.c, i50Var.e()));
        }
        this.c = new a(str, arrayList2);
        this.d = a.Companion.serializer();
        this.e = BuiltinSerializersKt.serializer(Unit.INSTANCE);
    }

    @Override // com.pspdfkit.internal.ga
    public final String a() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ga
    public final a b() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<a> c() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.ga
    public final za<Unit> e() {
        return new c(this.e);
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<Unit> f() {
        return this.e;
    }
}
