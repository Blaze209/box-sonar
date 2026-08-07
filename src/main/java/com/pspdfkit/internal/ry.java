package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.core.view.ViewCompat;
import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlinx.serialization.DeserializationStrategy;
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
public final class ry extends ga<a, ty> {
    public static final Bitmap i = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    public final i50 a;
    public final boolean b;
    public final float c;
    public final NativeContentEditingCommand d;
    public final String e;
    public final KSerializer<a> f;
    public final a g;
    public final KSerializer<ty> h;

    @Serializable
    public static final class a {
        public static final b Companion = new b();
        public final String a;
        public final ng b;
        public final sy c;

        /* JADX INFO: renamed from: com.pspdfkit.internal.ry$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public static final /* synthetic */ class C0286a implements GeneratedSerializer<a> {
            public static final C0286a a;
            private static final SerialDescriptor descriptor;

            static {
                C0286a c0286a = new C0286a();
                a = c0286a;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.pspdfkit.internal.contentediting.command.RenderTextBlock.Input", c0286a, 3);
                pluginGeneratedSerialDescriptor.addElement("textBlockId", false);
                pluginGeneratedSerialDescriptor.addElement("externalControlState", false);
                pluginGeneratedSerialDescriptor.addElement("renderTextBlockParams", false);
                descriptor = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, ng.a.a, sy.a.a};
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object deserialize(Decoder decoder) {
                int i;
                String strDecodeStringElement;
                ng ngVar;
                sy syVar;
                decoder.getClass();
                SerialDescriptor serialDescriptor = descriptor;
                CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
                String strDecodeStringElement2 = null;
                if (compositeDecoderBeginStructure.decodeSequentially()) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    ngVar = (ng) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ng.a.a, null);
                    syVar = (sy) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, sy.a.a, null);
                    i = 7;
                } else {
                    boolean z = true;
                    int i2 = 0;
                    ng ngVar2 = null;
                    sy syVar2 = null;
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
                            syVar2 = (sy) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, sy.a.a, syVar2);
                            i2 |= 4;
                        }
                    }
                    i = i2;
                    strDecodeStringElement = strDecodeStringElement2;
                    ngVar = ngVar2;
                    syVar = syVar2;
                }
                compositeDecoderBeginStructure.endStructure(serialDescriptor);
                return new a(i, strDecodeStringElement, ngVar, syVar);
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
                compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, sy.a.a, aVar.c);
                compositeEncoderBeginStructure.endStructure(serialDescriptor);
            }
        }

        public static final class b {
            public final KSerializer<a> serializer() {
                return C0286a.a;
            }
        }

        public /* synthetic */ a(int i, String str, ng ngVar, sy syVar) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, C0286a.a.getDescriptor());
            }
            this.a = str;
            this.b = ngVar;
            this.c = syVar;
        }

        public a(String str, ng ngVar, sy syVar) {
            str.getClass();
            this.a = str;
            this.b = ngVar;
            this.c = syVar;
        }
    }

    public ry(int i2, i50 i50Var, Matrix matrix, Size size, boolean z, r00 r00Var, ec ecVar) {
        i50Var.getClass();
        size.getClass();
        this.a = i50Var;
        this.b = z;
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        this.c = fArr[0];
        this.d = NativeContentEditingCommand.RENDER_TEXT_BLOCK;
        this.e = "(page " + i2 + ")";
        this.f = a.Companion.serializer();
        String str = i50Var.c;
        ng ngVarE = i50Var.e();
        PageRect pageRect = new PageRect(0.0f, 0.0f, size.width, size.height);
        pageRect.updateScreenRect(matrix);
        t70 t70Var = i50Var.d.a;
        PointF pointF = new PointF(t70Var.a, size.height - t70Var.b);
        s60.a(pointF, matrix);
        this.g = new a(str, ngVarE, new sy(new t70(pageRect.getScreenRect().width(), pageRect.getScreenRect().height()), new ob(new t70(0.0f, 0.0f), new t70(pageRect.getScreenRect().width(), pageRect.getScreenRect().height())), new t70(pointF.x, pointF.y), i50Var.d.c, ecVar, r00Var));
        this.h = ty.Companion.serializer();
    }

    @Override // com.pspdfkit.internal.ga
    public final a b() {
        return this.g;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<a> c() {
        return this.f;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<ty> f() {
        return this.h;
    }

    @Override // com.pspdfkit.internal.ga
    public final String a() {
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    @Override // com.pspdfkit.internal.ga
    public final void a(ty tyVar, NativeContentEditingResult nativeContentEditingResult) {
        Bitmap bitmapCreateBitmap;
        tyVar.getClass();
        nativeContentEditingResult.getClass();
        String str = this.a.c;
        str.getClass();
        tyVar.d = str;
        tyVar.c = this.c;
        byte[] binaryData = nativeContentEditingResult.getBinaryData();
        if (binaryData != null) {
            bitmapCreateBitmap = null;
            if (binaryData.length == 0) {
                binaryData = null;
            }
            if (binaryData != null) {
                try {
                    u70 u70Var = tyVar.a.b;
                    int i2 = u70Var.a;
                    int i3 = u70Var.b;
                    int length = binaryData.length / 4;
                    a(binaryData, i2, i3, length);
                    ByteBuffer byteBufferOrder = ByteBuffer.wrap(binaryData).order(ByteOrder.BIG_ENDIAN);
                    int[] iArr = new int[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        int i5 = byteBufferOrder.getInt();
                        int i6 = i5 == 0 ? 0 : (i5 << 24) | (i5 >>> 8);
                        if (this.b) {
                            i6 ^= ViewCompat.MEASURED_SIZE_MASK;
                        }
                        iArr[i4] = i6;
                    }
                    bitmapCreateBitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.ARGB_8888);
                } catch (Exception e) {
                    PdfLog.e("RenderTextBlock", "Failed to convert binary data to bitmap for text block " + this.a.c, e);
                }
                if (bitmapCreateBitmap == null) {
                    bitmapCreateBitmap = i;
                }
            } else {
                bitmapCreateBitmap = i;
            }
        } else {
            bitmapCreateBitmap = i;
        }
        bitmapCreateBitmap.getClass();
        tyVar.b = bitmapCreateBitmap;
    }

    public static void a(byte[] bArr, int i2, int i3, int i4) {
        if (bArr.length % 4 != 0) {
            throw new IllegalStateException("Invalid binary data from native content editor: size (" + bArr.length + ") is not divisible by 4");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalStateException("Invalid display rectangle dimensions: " + i2 + "x" + i3);
        }
        int i5 = i2 * i3;
        if (i5 != i4) {
            throw new IllegalStateException("Binary data size mismatch: expected " + i5 + " pixels (" + i2 + "x" + i3 + ") but got " + i4 + " pixels");
        }
    }
}
