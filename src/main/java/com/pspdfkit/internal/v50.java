package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.datastructures.TextSelectionRectangles;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.internal.jni.NativeTextRange;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.TextRetrievalHelper$getTouchedTextRectsAsync$1", f = "TextRetrievalHelper.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {"$this$launch"}, nl = {126}, s = {"L$0"}, v = 2)
public final class v50 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ u50 c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ lm g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Matrix i;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.TextRetrievalHelper$getTouchedTextRectsAsync$1$result$1", f = "TextRetrievalHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TextSelectionRectangles>, Object> {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ lm d;
        public final /* synthetic */ int e;
        public final /* synthetic */ Matrix f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(float f, float f2, float f3, lm lmVar, int i, Matrix matrix, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = lmVar;
            this.e = i;
            this.f = matrix;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TextSelectionRectangles> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x006b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NativeTextRange nativeTextRange;
            Pair pair;
            NativeRectDescriptor nativeRectDescriptorTextRectAt;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            float f = this.a;
            float f2 = this.b;
            float f3 = this.c;
            lm lmVar = this.d;
            int i = this.e;
            Matrix matrix = this.f;
            PointF pointF = new PointF(f, f2);
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            s60.a(pointF, matrix2);
            float fA = s60.a(f3, matrix);
            NativeTextParser nativeTextParserA = lmVar.c.b(i).a();
            RectF rect = (nativeTextParserA == null || (nativeRectDescriptorTextRectAt = nativeTextParserA.textRectAt(pointF, fA)) == null) ? null : nativeRectDescriptorTextRectAt.getRect();
            float f4 = pointF.x;
            float f5 = pointF.y;
            NativeTextParser nativeTextParserA2 = lmVar.c.b(i).a();
            if (nativeTextParserA2 == null) {
                nativeTextRange = null;
            } else {
                ArrayList<NativeTextRange> arrayListWordsAt = nativeTextParserA2.wordsAt(new PointF(f4, f5), fA);
                arrayListWordsAt.getClass();
                if (arrayListWordsAt.isEmpty()) {
                    nativeTextRange = null;
                } else {
                    nativeTextRange = arrayListWordsAt.get(0);
                }
            }
            if (nativeTextRange != null) {
                ArrayList<NativeRectDescriptor> markupRects = nativeTextRange.getMarkupRects();
                markupRects.getClass();
                ArrayList<RectF> arrayListA = r10.a(markupRects);
                ArrayList<NativeRectDescriptor> rects = nativeTextRange.getRects();
                rects.getClass();
                ArrayList<RectF> arrayListA2 = r10.a(rects);
                int iMin = Math.min(arrayListA.size(), arrayListA2.size());
                ArrayList arrayList = new ArrayList(iMin);
                ArrayList arrayList2 = new ArrayList(iMin);
                for (int i2 = 0; i2 < iMin; i2++) {
                    RectF rectF = arrayListA.get(i2);
                    rectF.getClass();
                    RectF rectF2 = rectF;
                    RectF rectF3 = arrayListA2.get(i2);
                    rectF3.getClass();
                    RectF rectF4 = rectF3;
                    if (rect == null || (rect.left < rectF2.right && rectF2.left < rect.right && rect.top > rectF2.bottom && rectF2.top > rect.bottom)) {
                        arrayList.add(rectF4);
                        arrayList2.add(rectF2);
                    } else {
                        arrayList.add(rect);
                        arrayList2.add(rect);
                    }
                }
                pair = TuplesKt.to(arrayList, arrayList2);
            } else {
                pair = null;
            }
            if (pair == null) {
                return null;
            }
            ArrayList arrayList3 = (ArrayList) pair.getFirst();
            ArrayList arrayList4 = (ArrayList) pair.getSecond();
            if (arrayList3.isEmpty()) {
                return null;
            }
            return new TextSelectionRectangles(arrayList3, arrayList4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v50(u50 u50Var, float f, float f2, float f3, lm lmVar, int i, Matrix matrix, Continuation<? super v50> continuation) {
        super(2, continuation);
        this.c = u50Var;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = lmVar;
        this.h = i;
        this.i = matrix;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        v50 v50Var = new v50(this.c, this.d, this.e, this.f, this.g, this.h, this.i, continuation);
        v50Var.b = obj;
        return v50Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((v50) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            a aVar = new a(this.d, this.e, this.f, this.g, this.h, this.i, null);
            this.b = coroutineScope;
            this.a = 1;
            obj = BuildersKt.withContext(io2, aVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TextSelectionRectangles textSelectionRectangles = (TextSelectionRectangles) obj;
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            this.c.a(textSelectionRectangles);
        }
        return Unit.INSTANCE;
    }
}
