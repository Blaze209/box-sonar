package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.media3.common.PlaybackException;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.MediaOptions;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.note.AuthorState;
import com.pspdfkit.annotations.sound.AudioEncoding;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ah {
    public final g3 a;
    public final Map<Integer, Function0<Object>> b = MapsKt.mapOf(TuplesKt.to(3000, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.a(this.f$0);
        }
    }), TuplesKt.to(3001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.b(this.f$0);
        }
    }), TuplesKt.to(12, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.m(this.f$0);
        }
    }), TuplesKt.to(7002, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.x(this.f$0);
        }
    }), TuplesKt.to(7003, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda38
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.I(this.f$0);
        }
    }), TuplesKt.to(19, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda50
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.T(this.f$0);
        }
    }), TuplesKt.to(23, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda58
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.e0(this.f$0);
        }
    }), TuplesKt.to(13, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda59
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.l0(this.f$0);
        }
    }), TuplesKt.to(24, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda60
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.m0(this.f$0);
        }
    }), TuplesKt.to(25, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda61
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.n0(this.f$0);
        }
    }), TuplesKt.to(14, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.c(this.f$0);
        }
    }), TuplesKt.to(9, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.d(this.f$0);
        }
    }), TuplesKt.to(10, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.e(this.f$0);
        }
    }), TuplesKt.to(3, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda44
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.f(this.f$0);
        }
    }), TuplesKt.to(22, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda55
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.g(this.f$0);
        }
    }), TuplesKt.to(7, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda62
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.h(this.f$0);
        }
    }), TuplesKt.to(6, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda63
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.i(this.f$0);
        }
    }), TuplesKt.to(9001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda64
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.j(this.f$0);
        }
    }), TuplesKt.to(15, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda65
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.k(this.f$0);
        }
    }), TuplesKt.to(1007, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.l(this.f$0);
        }
    }), TuplesKt.to(29, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.n(this.f$0);
        }
    }), TuplesKt.to(11, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.o(this.f$0);
        }
    }), TuplesKt.to(16, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.p(this.f$0);
        }
    }), TuplesKt.to(1000, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.q(this.f$0);
        }
    }), TuplesKt.to(27, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.r(this.f$0);
        }
    }), TuplesKt.to(4000, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.s(this.f$0);
        }
    }), TuplesKt.to(12001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.t(this.f$0);
        }
    }), TuplesKt.to(17, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.u(this.f$0);
        }
    }), TuplesKt.to(21, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.v(this.f$0);
        }
    }), TuplesKt.to(2000, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.w(this.f$0);
        }
    }), TuplesKt.to(100, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.y(this.f$0);
        }
    }), TuplesKt.to(102, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.z(this.f$0);
        }
    }), TuplesKt.to(104, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.A(this.f$0);
        }
    }), TuplesKt.to(101, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.B(this.f$0);
        }
    }), TuplesKt.to(11001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.C(this.f$0);
        }
    }), TuplesKt.to(11002, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.D(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.E(this.f$0);
        }
    }), TuplesKt.to(7000, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.F(this.f$0);
        }
    }), TuplesKt.to(8, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.G(this.f$0);
        }
    }), TuplesKt.to(2, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.H(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.J(this.f$0);
        }
    }), TuplesKt.to(0, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.K(this.f$0);
        }
    }), TuplesKt.to(8001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.L(this.f$0);
        }
    }), TuplesKt.to(8002, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.M(this.f$0);
        }
    }), TuplesKt.to(1, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.N(this.f$0);
        }
    }), TuplesKt.to(103, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.O(this.f$0);
        }
    }), TuplesKt.to(105, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.P(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.Q(this.f$0);
        }
    }), TuplesKt.to(8003, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.R(this.f$0);
        }
    }), TuplesKt.to(5, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.S(this.f$0);
        }
    }), TuplesKt.to(18, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.U(this.f$0);
        }
    }), TuplesKt.to(10003, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda40
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.V(this.f$0);
        }
    }), TuplesKt.to(10004, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda41
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.W(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda42
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.X(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda43
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.Y(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda45
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.Z(this.f$0);
        }
    }), TuplesKt.to(Integer.valueOf(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED), new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda46
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.a0(this.f$0);
        }
    }), TuplesKt.to(28, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda47
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.b0(this.f$0);
        }
    }), TuplesKt.to(4, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda48
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.c0(this.f$0);
        }
    }), TuplesKt.to(1001, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda49
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.d0(this.f$0);
        }
    }), TuplesKt.to(1002, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda51
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.f0(this.f$0);
        }
    }), TuplesKt.to(1004, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda52
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.g0(this.f$0);
        }
    }), TuplesKt.to(1005, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda53
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.h0(this.f$0);
        }
    }), TuplesKt.to(20, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda54
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.i0(this.f$0);
        }
    }), TuplesKt.to(26, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda56
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.j0(this.f$0);
        }
    }), TuplesKt.to(1006, new Function0() { // from class: com.pspdfkit.internal.ah$$ExternalSyntheticLambda57
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ah.k0(this.f$0);
        }
    }));

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.WIDGET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.SCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.RICHMEDIA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.SQUIGGLY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.UNDERLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationType.STRIKEOUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationType.FILE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationType.STAMP.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[AnnotationType.REDACT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            a = iArr;
        }
    }

    public ah(g3 g3Var) {
        this.a = g3Var;
    }

    public static final Object A(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(80);
        return Byte.valueOf(iA != 0 ? g3Var.b.get(iA + g3Var.a) : (byte) 0);
    }

    public static final Object B(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(44);
        return Float.valueOf(iA != 0 ? g3Var.b.getFloat(iA + g3Var.a) : 0.0f);
    }

    public static final Object C(ah ahVar) {
        g3 g3Var = ahVar.a;
        wp wpVar = new wp();
        int iA = g3Var.a(Token.GET);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            wpVar.a(i, byteBuffer);
        } else {
            wpVar = null;
        }
        return zg.c(wpVar);
    }

    public static final Object D(ah ahVar) {
        g3 g3Var = ahVar.a;
        yp ypVar = new yp();
        int iA = g3Var.a(150);
        if (iA != 0) {
            int i = iA + g3Var.a;
            int i2 = g3Var.b.getInt(i) + i;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            ypVar.a(i2, byteBuffer);
        } else {
            ypVar = null;
        }
        if (ypVar == null) {
            return null;
        }
        int iA2 = ypVar.a(8);
        float f = iA2 != 0 ? ypVar.b.getFloat(iA2 + ypVar.a) : 0.0f;
        int iA3 = ypVar.a(4);
        short s = iA3 != 0 ? ypVar.b.getShort(iA3 + ypVar.a) : (short) 0;
        Object[] enumConstants = Scale.UnitFrom.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r10 = ((Enum[]) enumConstants)[s];
        r10.getClass();
        Scale.UnitFrom unitFrom = (Scale.UnitFrom) r10;
        int iA4 = ypVar.a(10);
        float f2 = iA4 != 0 ? ypVar.b.getFloat(iA4 + ypVar.a) : 0.0f;
        int iA5 = ypVar.a(6);
        short s2 = iA5 != 0 ? ypVar.b.getShort(iA5 + ypVar.a) : (short) 0;
        Object[] enumConstants2 = Scale.UnitTo.class.getEnumConstants();
        if (enumConstants2 == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r1 = ((Enum[]) enumConstants2)[s2];
        r1.getClass();
        Scale.UnitTo unitTo = (Scale.UnitTo) r1;
        int iA6 = ypVar.a(12);
        String strB = iA6 != 0 ? ypVar.b(iA6 + ypVar.a) : null;
        int iA7 = ypVar.a(14);
        return new Scale(f, unitFrom, f2, unitTo, strB, iA7 != 0 ? ypVar.b(iA7 + ypVar.a) : null);
    }

    public static final Object E(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(Token.TARGET);
        long j = iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0;
        MediaOptions mediaOptions = MediaOptions.NO_FLAGS;
        EnumSet enumSetNoneOf = EnumSet.noneOf(MediaOptions.class);
        Object[] enumConstants = MediaOptions.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure.");
        }
        Enum[] enumArr = (Enum[]) enumConstants;
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            if ((((long) (1 << i)) & j) != 0) {
                enumSetNoneOf.add(enumArr[i]);
            }
        }
        if (mediaOptions != null && enumSetNoneOf.isEmpty()) {
            enumSetNoneOf.add(mediaOptions);
        }
        if (enumSetNoneOf.isEmpty()) {
            return null;
        }
        return enumSetNoneOf;
    }

    public static final Object F(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(130);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object G(ah ahVar) {
        g3 g3Var = ahVar.a;
        jc jcVar = new jc();
        int iA = g3Var.a(104);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            jcVar.a(i, byteBuffer);
        } else {
            jcVar = null;
        }
        if (jcVar != null) {
            return new Date(ULong.m14954constructorimpl(jcVar.b.getLong(jcVar.a)) * ((long) 1000));
        }
        return null;
    }

    public static final Object H(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(100);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object I(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(128);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object J(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(116);
        return Boolean.valueOf((iA == 0 || g3Var.b.get(iA + g3Var.a) == 0) ? false : true);
    }

    public static final Object K(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(10);
        return Integer.valueOf((int) (iA != 0 ? ULong.m14954constructorimpl(g3Var.b.getLong(iA + g3Var.a)) : 0L));
    }

    public static final Object L(ah ahVar) {
        g3 g3Var = ahVar.a;
        c9 c9Var = new c9();
        int iA = g3Var.a(Token.DOTDOT);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            c9Var.a(i, byteBuffer);
        } else {
            c9Var = null;
        }
        if (c9Var != null) {
            return Integer.valueOf(UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)));
        }
        return null;
    }

    public static final Object M(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(Token.XML);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object N(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(6);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object O(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(24);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        ArrayList arrayList = new ArrayList(iD);
        for (int i = 0; i < iD; i++) {
            g3 g3Var2 = ahVar.a;
            jw jwVar = new jw();
            int iA2 = g3Var2.a(24);
            if (iA2 != 0) {
                int iC = (i * 8) + g3Var2.c(iA2);
                ByteBuffer byteBuffer = g3Var2.b;
                byteBuffer.getClass();
                jwVar.a(iC, byteBuffer);
            } else {
                jwVar = null;
            }
            if (jwVar == null) {
                throw new IllegalStateException("Flatbuffer error: Unable to read points. Size mismatch.");
            }
            arrayList.add(new PointF(jwVar.b.getFloat(jwVar.a), jwVar.b.getFloat(jwVar.a + 4)));
        }
        return arrayList;
    }

    public static final Object P(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(82);
        return Byte.valueOf(iA != 0 ? g3Var.b.get(iA + g3Var.a) : (byte) 0);
    }

    public static final Object Q(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(22);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        ArrayList arrayList = new ArrayList(iD);
        for (int i = 0; i < iD; i++) {
            g3 g3Var2 = ahVar.a;
            gx gxVar = new gx();
            int iA2 = g3Var2.a(22);
            if (iA2 != 0) {
                int iC = (i * 32) + g3Var2.c(iA2);
                ByteBuffer byteBuffer = g3Var2.b;
                byteBuffer.getClass();
                gxVar.a(iC, byteBuffer);
            } else {
                gxVar = null;
            }
            fx fxVar = gxVar != null ? new fx(gxVar.b.getFloat(gxVar.a), gxVar.b.getFloat(gxVar.a + 4), gxVar.b.getFloat(gxVar.a + 8), gxVar.b.getFloat(gxVar.a + 12), gxVar.b.getFloat(gxVar.a + 16), gxVar.b.getFloat(gxVar.a + 20), gxVar.b.getFloat(gxVar.a + 24), gxVar.b.getFloat(gxVar.a + 28)) : null;
            if (fxVar != null) {
                arrayList.add(fxVar);
            }
        }
        return arrayList;
    }

    public static final Object R(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(Token.XMLATTR);
        return Boolean.valueOf((iA == 0 || g3Var.b.get(iA + g3Var.a) == 0) ? false : true);
    }

    public static final Object S(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(92);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object T(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(140);
        short s = iA != 0 ? g3Var.b.getShort(iA + g3Var.a) : (short) 0;
        Object[] enumConstants = AuthorState.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r2 = ((Enum[]) enumConstants)[s];
        r2.getClass();
        return r2;
    }

    public static final Object U(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(8);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object V(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(120);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object W(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(124);
        short s = (short) (iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
        Object[] enumConstants = AudioEncoding.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r2 = ((Enum[]) enumConstants)[s];
        r2.getClass();
        return r2;
    }

    public static final Object X(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(118);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object Y(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(122);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object Z(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(98);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Action a(ah ahVar) {
        g3 g3Var = ahVar.a;
        b bVar = new b();
        int iA = g3Var.a(28);
        if (iA != 0) {
            int i = iA + g3Var.a;
            int i2 = g3Var.b.getInt(i) + i;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            bVar.a(i2, byteBuffer);
        } else {
            bVar = null;
        }
        return d.a(bVar);
    }

    public static final Object a0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(96);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object b(ah ahVar) {
        return d.a(ahVar.a);
    }

    public static final Object b0(ah ahVar) {
        g3 g3Var = ahVar.a;
        ys ysVar = new ys();
        int iA = g3Var.a(Token.LET);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            ysVar.a(i, byteBuffer);
        } else {
            ysVar = null;
        }
        if (ysVar != null) {
            return Float.valueOf(ysVar.b.getFloat(ysVar.a));
        }
        return null;
    }

    public static final Object c(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(52);
        short s = iA != 0 ? g3Var.b.getShort(iA + g3Var.a) : (short) 0;
        Object[] enumConstants = BorderStyle.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r2 = ((Enum[]) enumConstants)[s];
        r2.getClass();
        return r2;
    }

    public static final Object c0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(94);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object d(ah ahVar) {
        g3 g3Var = ahVar.a;
        jx jxVar = new jx();
        int iA = g3Var.a(18);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            jxVar.a(i, byteBuffer);
        } else {
            jxVar = null;
        }
        if (jxVar != null) {
            return new RectF(jxVar.b.getFloat(jxVar.a), jxVar.b.getFloat(jxVar.a + 12), jxVar.b.getFloat(jxVar.a + 8), jxVar.b.getFloat(jxVar.a + 4));
        }
        return null;
    }

    public static final Object d0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(62);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object e(ah ahVar) {
        g3 g3Var = ahVar.a;
        c9 c9Var = new c9();
        int iA = g3Var.a(34);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            c9Var.a(i, byteBuffer);
        } else {
            c9Var = null;
        }
        if (c9Var != null) {
            return Integer.valueOf(UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)));
        }
        return null;
    }

    public static final Object e0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(48);
        short s = iA != 0 ? g3Var.b.getShort(iA + g3Var.a) : (short) 0;
        Object[] enumConstants = BlendMode.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r2 = ((Enum[]) enumConstants)[s];
        r2.getClass();
        return r2;
    }

    public static final Object f(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(90);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object f0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(64);
        return Float.valueOf(iA != 0 ? g3Var.b.getFloat(iA + g3Var.a) : 0.0f);
    }

    public static final Object g(ah ahVar) {
        g3 g3Var = ahVar.a;
        jx jxVar = new jx();
        int iA = g3Var.a(20);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            jxVar.a(i, byteBuffer);
        } else {
            jxVar = null;
        }
        if (jxVar != null) {
            return new RectF(jxVar.b.getFloat(jxVar.a), jxVar.b.getFloat(jxVar.a + 12), jxVar.b.getFloat(jxVar.a + 8), jxVar.b.getFloat(jxVar.a + 4));
        }
        return null;
    }

    public static final Object g0(ah ahVar) {
        g3 g3Var = ahVar.a;
        c9 c9Var = new c9();
        int iA = g3Var.a(42);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            c9Var.a(i, byteBuffer);
        } else {
            c9Var = null;
        }
        if (c9Var != null) {
            return Integer.valueOf(UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)));
        }
        return null;
    }

    public static final Object h(ah ahVar) {
        g3 g3Var = ahVar.a;
        jc jcVar = new jc();
        int iA = g3Var.a(102);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            jcVar.a(i, byteBuffer);
        } else {
            jcVar = null;
        }
        if (jcVar != null) {
            return new Date(ULong.m14954constructorimpl(jcVar.b.getLong(jcVar.a)) * ((long) 1000));
        }
        return null;
    }

    public static final Object h0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(68);
        return Byte.valueOf(iA != 0 ? g3Var.b.get(iA + g3Var.a) : (byte) 0);
    }

    public static final Object i(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(108);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object i0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(12);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object j(ah ahVar) {
        g3 g3Var = ahVar.a;
        fn fnVar = new fn();
        int iA = g3Var.a(14);
        if (iA != 0) {
            int i = iA + g3Var.a;
            int i2 = g3Var.b.getInt(i) + i;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            fnVar.a(i2, byteBuffer);
        } else {
            fnVar = null;
        }
        if (fnVar == null) {
            return null;
        }
        int iA2 = fnVar.a(4);
        String strB = iA2 != 0 ? fnVar.b(iA2 + fnVar.a) : null;
        if (strB == null) {
            return null;
        }
        try {
            return new JSONObject(strB);
        } catch (JSONException e) {
            PdfLog.d("Nutri.FlatbuffConverter", e, "Can't parse custom data json: %s", strB);
            return null;
        }
    }

    public static final Object j0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(84);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object k(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(50);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        if (iD == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iD);
        for (int i = 0; i < iD; i++) {
            g3 g3Var2 = ahVar.a;
            int iA2 = g3Var2.a(50);
            arrayList.add(Integer.valueOf(iA2 != 0 ? g3Var2.b.getInt((i * 4) + g3Var2.c(iA2)) : 0));
        }
        return arrayList;
    }

    public static final Object k0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(66);
        return Byte.valueOf(iA != 0 ? g3Var.b.get(iA + g3Var.a) : (byte) 0);
    }

    public static final Object l(ah ahVar) {
        g3 g3Var = ahVar.a;
        hf hfVar = new hf();
        int iA = g3Var.a(74);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            hfVar.a(i, byteBuffer);
        } else {
            hfVar = null;
        }
        if (hfVar != null) {
            return new EdgeInsets(hfVar.b.getFloat(hfVar.a), hfVar.b.getFloat(hfVar.a + 4), hfVar.b.getFloat(hfVar.a + 8), hfVar.b.getFloat(hfVar.a + 12));
        }
        return null;
    }

    public static final Object l0(ah ahVar) {
        g3 g3Var = ahVar.a;
        c9 c9Var = new c9();
        int iA = g3Var.a(36);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            c9Var.a(i, byteBuffer);
        } else {
            c9Var = null;
        }
        if (c9Var != null) {
            return Integer.valueOf(UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)));
        }
        return null;
    }

    public static final Object m(ah ahVar) {
        g3 g3Var = ahVar.a;
        ys ysVar = new ys();
        int iA = g3Var.a(46);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            ysVar.a(i, byteBuffer);
        } else {
            ysVar = null;
        }
        if (ysVar != null) {
            return Float.valueOf(ysVar.b.getFloat(ysVar.a));
        }
        return null;
    }

    public static final Object m0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(54);
        short s = iA != 0 ? g3Var.b.getShort(iA + g3Var.a) : (short) 0;
        Object[] enumConstants = BorderEffect.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
        }
        Enum r2 = ((Enum[]) enumConstants)[s];
        r2.getClass();
        return r2;
    }

    public static final Object n(ah ahVar) {
        g3 g3Var = ahVar.a;
        ys ysVar = new ys();
        int iA = g3Var.a(Token.SETCONST);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            ysVar.a(i, byteBuffer);
        } else {
            ysVar = null;
        }
        if (ysVar != null) {
            return Float.valueOf(ysVar.b.getFloat(ysVar.a));
        }
        return null;
    }

    public static final Object n0(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(56);
        return Float.valueOf(iA != 0 ? g3Var.b.getFloat(iA + g3Var.a) : 0.0f);
    }

    public static final Object o(ah ahVar) {
        g3 g3Var = ahVar.a;
        c9 c9Var = new c9();
        int iA = g3Var.a(38);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            c9Var.a(i, byteBuffer);
        } else {
            c9Var = null;
        }
        if (c9Var != null) {
            return Integer.valueOf(UInt.m14875constructorimpl(c9Var.b.getInt(c9Var.a)));
        }
        return null;
    }

    public static final Object p(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(106);
        long jM14954constructorimpl = iA != 0 ? ULong.m14954constructorimpl(g3Var.b.getLong(iA + g3Var.a)) : 0L;
        EnumSet enumSetNoneOf = EnumSet.noneOf(AnnotationFlags.class);
        Object[] enumConstants = AnnotationFlags.class.getEnumConstants();
        if (enumConstants == null) {
            throw new IllegalArgumentException("Flatbuffer enum conversion failure.");
        }
        Enum[] enumArr = (Enum[]) enumConstants;
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            if ((((long) (1 << i)) & jM14954constructorimpl) != 0) {
                enumSetNoneOf.add(enumArr[i]);
            }
        }
        if (enumSetNoneOf.isEmpty()) {
            return null;
        }
        return enumSetNoneOf;
    }

    public static final Object q(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(114);
        return Integer.valueOf(iA != 0 ? g3Var.b.get(iA + g3Var.a) : (byte) 0);
    }

    public static final Object r(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(86);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object s(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(32);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object t(ah ahVar) {
        g3 g3Var = ahVar.a;
        xl xlVar = new xl();
        int iA = g3Var.a(Token.ARRAYCOMP);
        if (iA != 0) {
            int i = iA + g3Var.a;
            ByteBuffer byteBuffer = g3Var.b;
            byteBuffer.getClass();
            xlVar.a(i, byteBuffer);
        } else {
            xlVar = null;
        }
        if (xlVar != null) {
            return Boolean.valueOf(xlVar.b.get(xlVar.a) != 0);
        }
        return null;
    }

    public static final Object u(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(138);
        return Integer.valueOf(iA != 0 ? g3Var.b.getInt(iA + g3Var.a) : 0);
    }

    public static final Object v(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(136);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object w(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(112);
        return Boolean.valueOf((iA == 0 || g3Var.b.get(iA + g3Var.a) == 0) ? false : true);
    }

    public static final Object x(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(126);
        if (iA != 0) {
            return g3Var.b(iA + g3Var.a);
        }
        return null;
    }

    public static final Object y(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(26);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        ArrayList arrayList = new ArrayList(iD);
        for (int i = 0; i < iD; i++) {
            g3 g3Var2 = ahVar.a;
            rn rnVar = new rn();
            int iA2 = g3Var2.a(26);
            if (iA2 != 0) {
                int iC = (i * 4) + g3Var2.c(iA2);
                int i2 = g3Var2.b.getInt(iC) + iC;
                ByteBuffer byteBuffer = g3Var2.b;
                byteBuffer.getClass();
                rnVar.a(i2, byteBuffer);
            } else {
                rnVar = null;
            }
            if (rnVar == null) {
                throw new IllegalStateException("Flatbuffer error: Unable to read lines. Size mismatch.");
            }
            int iA3 = rnVar.a(4);
            int iD2 = iA3 != 0 ? rnVar.d(iA3) : 0;
            if (iD2 > 0) {
                ArrayList arrayList2 = new ArrayList(iD2);
                for (int i3 = 0; i3 < iD2; i3++) {
                    df dfVar = new df();
                    int iA4 = rnVar.a(4);
                    if (iA4 != 0) {
                        int iC2 = (i3 * 12) + rnVar.c(iA4);
                        ByteBuffer byteBuffer2 = rnVar.b;
                        byteBuffer2.getClass();
                        dfVar.a(iC2, byteBuffer2);
                    } else {
                        dfVar = null;
                    }
                    if (dfVar != null) {
                        arrayList2.add(new PointF(dfVar.b.getFloat(dfVar.a), dfVar.b.getFloat(dfVar.a + 4)));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public static final Object z(ah ahVar) {
        g3 g3Var = ahVar.a;
        int iA = g3Var.a(76);
        int iD = iA != 0 ? g3Var.d(iA) : 0;
        ArrayList arrayList = new ArrayList(iD);
        for (int i = 0; i < iD; i++) {
            g3 g3Var2 = ahVar.a;
            int iA2 = g3Var2.a(76);
            short s = iA2 != 0 ? g3Var2.b.getShort((i * 2) + g3Var2.c(iA2)) : (short) 0;
            Object[] enumConstants = LineEndType.class.getEnumConstants();
            if (enumConstants == null) {
                throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
            }
            Enum r5 = ((Enum[]) enumConstants)[s];
            r5.getClass();
            arrayList.add(r5);
        }
        return arrayList;
    }

    public final void a(k3 k3Var, int i) {
        Function0<Object> function0 = this.b.get(Integer.valueOf(i));
        if (function0 != null) {
            try {
                k3Var.a(i, function0.invoke(), true);
                return;
            } catch (RuntimeException e) {
                PdfLog.e("Nutri.AnnotFlatbuffRdr", e, "Exception while reading Flatbuffers table with key: " + h3.a(i), new Object[0]);
                return;
            }
        }
        PdfLog.e("Nutri.AnnotFlatbuffRdr", "No action for Flatbuffers key " + h3.a(i) + "! It must be added to the action map!", new Object[0]);
    }
}
