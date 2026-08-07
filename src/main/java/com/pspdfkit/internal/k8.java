package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.SparseArray;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx3.RxAwaitKt;
import kotlinx.coroutines.rx3.RxMaybeKt;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class k8 implements j8 {
    public final lm a;
    public final Context b;
    public final PageRenderConfiguration c;
    public final List<AnnotationType> d;
    public boolean e;
    public final ArrayList<PdfDrawableProvider> f;
    public final SparseArray<String> g;

    @DebugMetadata(c = "com.pspdfkit.internal.views.adapters.bookmarks.BookmarkMetadataResolver$getPageThumbnail$1", f = "BookmarkMetadataResolver.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {109, 118}, m = "invokeSuspend", n = {"pageSize", "pageIndex", "ratio", "renderW", "renderH", "pageSize", "options", "pageIndex", "ratio", "renderW", "renderH"}, nl = {115, -1}, s = {"L$0", "I$0", "F$0", "I$1", "I$2", "L$0", "L$1", "I$0", "F$0", "I$1", "I$2"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        public int a;
        public int b;
        public int c;
        public int d;
        public Object e;
        public Object f;
        public Integer g;
        public List h;
        public float i;
        public int j;
        public final /* synthetic */ Bookmark k;
        public final /* synthetic */ k8 l;
        public final /* synthetic */ Size m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bookmark bookmark, k8 k8Var, Size size, Continuation<? super a> continuation) {
            super(2, continuation);
            this.k = bookmark;
            this.l = k8Var;
            this.m = size;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.k, this.l, this.m, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iIntValue;
            jm jmVar;
            int i;
            int i2;
            float f;
            List<AnnotationType> list;
            Object objA;
            Size size;
            Integer num;
            int i3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.j;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                Integer pageIndex = this.k.getPageIndex();
                if (pageIndex == null) {
                    return null;
                }
                iIntValue = pageIndex.intValue();
                Size pageSize = this.l.a.getPageSize(iIntValue);
                Size size2 = this.m;
                float fMin = Math.min(size2.width / pageSize.width, size2.height / pageSize.height);
                int i5 = (int) (pageSize.width * fMin);
                int i6 = (int) (pageSize.height * fMin);
                ou ouVar = this.l.a.c;
                android.util.Size size3 = new android.util.Size(i5, i6);
                PageRenderConfiguration pageRenderConfiguration = this.l.c;
                ouVar.getClass();
                pageRenderConfiguration.getClass();
                oy oyVar = pageRenderConfiguration.renderRegion ? new oy(new Point(pageRenderConfiguration.regionX, pageRenderConfiguration.regionY), new android.util.Size(pageRenderConfiguration.regionFullPageWidth, pageRenderConfiguration.regionFullPageHeight)) : null;
                Bitmap bitmap = pageRenderConfiguration.reuseBitmap;
                int i7 = pageRenderConfiguration.paperColor;
                Integer num2 = pageRenderConfiguration.formHighlightColor;
                Integer num3 = pageRenderConfiguration.formItemHighlightColor;
                Integer num4 = pageRenderConfiguration.formRequiredFieldBorderColor;
                Integer num5 = pageRenderConfiguration.signHereOverlayBackgroundColor;
                boolean z = pageRenderConfiguration.toGrayscale;
                boolean z2 = pageRenderConfiguration.invertColors;
                boolean z3 = pageRenderConfiguration.redactionAnnotationPreviewEnabled;
                List<PdfDrawable> list2 = pageRenderConfiguration.renderedDrawables;
                list2.getClass();
                boolean z4 = pageRenderConfiguration.showSignHereOverlay;
                boolean z5 = pageRenderConfiguration.useCache;
                List<Integer> list3 = pageRenderConfiguration.excludedAnnotations;
                list3.getClass();
                List<AnnotationType> list4 = pageRenderConfiguration.excludedAnnotationTypes;
                list4.getClass();
                i = i6;
                i2 = i5;
                f = fMin;
                jmVar = new jm(ouVar, iIntValue, bitmap, size3, z5, null, oyVar, 3, i7, num2, num3, num4, num5, z2, z, list3, list4, list2, z3, z4, true);
                Integer numBoxInt = Boxing.boxInt(0);
                k8 k8Var = this.l;
                list = k8Var.d;
                lm lmVar = k8Var.a;
                ArrayList<PdfDrawableProvider> arrayList = k8Var.f;
                Context context = k8Var.b;
                this.e = SpillingKt.nullOutSpilledVariable(pageSize);
                this.f = jmVar;
                this.g = numBoxInt;
                this.h = list;
                this.a = iIntValue;
                this.i = f;
                this.b = i2;
                this.c = i;
                this.d = 10;
                this.j = 1;
                objA = qv.a(lmVar, arrayList, context, iIntValue, this);
                if (objA != coroutine_suspended) {
                    size = pageSize;
                    num = numBoxInt;
                    i3 = 10;
                }
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            int i8 = this.d;
            i = this.c;
            int i9 = this.b;
            float f2 = this.i;
            iIntValue = this.a;
            list = this.h;
            Integer num6 = this.g;
            jm jmVar2 = (jm) this.f;
            Size size4 = (Size) this.e;
            ResultKt.throwOnFailure(obj);
            objA = obj;
            i2 = i9;
            jmVar = jmVar2;
            size = size4;
            num = num6;
            i3 = i8;
            f = f2;
            jm jmVarA = jm.a(jmVar, null, null, null, i3, num, null, list, (List) objA, this.l.e, false, 1636223);
            Single<Bitmap> singleB = iu.b(jmVarA);
            this.e = SpillingKt.nullOutSpilledVariable(size);
            this.f = SpillingKt.nullOutSpilledVariable(jmVarA);
            this.g = null;
            this.h = null;
            this.a = iIntValue;
            this.i = f;
            this.b = i2;
            this.c = i;
            this.j = 2;
            Object objAwait = RxAwaitKt.await(singleB, this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public k8(lm lmVar, Context context, PdfConfiguration pdfConfiguration) {
        lmVar.getClass();
        pdfConfiguration.getClass();
        this.a = lmVar;
        this.b = context;
        PageRenderConfiguration pageRenderConfigurationA = ca.a(pdfConfiguration, lmVar);
        pageRenderConfigurationA.getClass();
        this.c = pageRenderConfigurationA;
        this.d = pdfConfiguration.getExcludedAnnotationTypes();
        this.f = new ArrayList<>();
        this.g = new SparseArray<>();
    }

    @Override // com.pspdfkit.internal.j8
    public final Maybe<String> a(final Bookmark bookmark) {
        bookmark.getClass();
        Maybe<String> maybeFromCallable = Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.internal.k8$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return k8.a(bookmark, this);
            }
        });
        maybeFromCallable.getClass();
        return maybeFromCallable;
    }

    @Override // com.pspdfkit.internal.j8
    public final String b(Bookmark bookmark) {
        bookmark.getClass();
        Integer pageIndex = bookmark.getPageIndex();
        if (pageIndex == null) {
            return null;
        }
        return this.a.getPageLabel(pageIndex.intValue(), false);
    }

    @Override // com.pspdfkit.internal.j8
    public final String c(Bookmark bookmark) {
        bookmark.getClass();
        Integer pageIndex = bookmark.getPageIndex();
        if (pageIndex == null) {
            return null;
        }
        return this.g.get(pageIndex.intValue());
    }

    public static final String a(Bookmark bookmark, k8 k8Var) {
        Integer pageIndex = bookmark.getPageIndex();
        if (pageIndex == null) {
            return null;
        }
        int iIntValue = pageIndex.intValue();
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(k8Var.a.getPageText(iIntValue), "\n", " • ", false, 4, (Object) null), StringUtils.CR, "", false, 4, (Object) null), "  ", " ", false, 4, (Object) null);
        k8Var.g.put(iIntValue, strReplace$default);
        return strReplace$default;
    }

    @Override // com.pspdfkit.internal.j8
    public final Maybe<Bitmap> a(Bookmark bookmark, Size size) {
        bookmark.getClass();
        return RxMaybeKt.rxMaybe$default(null, new a(bookmark, this, size, null), 1, null);
    }
}
