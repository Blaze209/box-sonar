package com.pspdfkit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.core.util.SparseIntArrayKt;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import com.pspdfkit.bookmarks.BookmarkProvider;
import com.pspdfkit.bookmarks.BookmarkProviderFactory;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextBlock;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.OutlineElement;
import com.pspdfkit.document.OutlineElementState;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.document.PdfBox;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfVersion;
import com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer;
import com.pspdfkit.document.download.exceptions.DownloadException;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import com.pspdfkit.document.metadata.DocumentPdfMetadata;
import com.pspdfkit.document.metadata.DocumentXmpMetadata;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.WritableDataProvider;
import com.pspdfkit.exceptions.InvalidPasswordException;
import com.pspdfkit.exceptions.InvalidSignatureException;
import com.pspdfkit.forms.FormProvider;
import com.pspdfkit.forms.FormProviderFactory;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.bx.a;
import com.pspdfkit.internal.jni.NativeDataProvider;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeDocumentOpenErrorCode;
import com.pspdfkit.internal.jni.NativeDocumentOpenResult;
import com.pspdfkit.internal.jni.NativeDocumentPermissions;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import com.pspdfkit.internal.jni.NativeDocumentSaveResult;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeMeasurementContentFormat;
import com.pspdfkit.internal.jni.NativeMeasurementPrecision;
import com.pspdfkit.internal.jni.NativeMeasurementScale;
import com.pspdfkit.internal.jni.NativeMeasurementSecondaryUnit;
import com.pspdfkit.internal.jni.NativePDFVersion;
import com.pspdfkit.internal.jni.NativePage;
import com.pspdfkit.internal.jni.NativePageBinding;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.internal.jni.NativePageInfo;
import com.pspdfkit.internal.jni.NativePdfObjectsHitDetector;
import com.pspdfkit.internal.jni.NativePlatformDocumentDigester;
import com.pspdfkit.internal.jni.NativePlatformDocumentDigesterResult;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.internal.jni.NativeTextParserOptions;
import com.pspdfkit.internal.jni.NativeTextRange;
import com.pspdfkit.internal.jni.NativeUnitFrom;
import com.pspdfkit.internal.jni.NativeUnitTo;
import com.pspdfkit.javascript.JavaScriptProvider;
import com.pspdfkit.projection.PdfProjection;
import com.pspdfkit.signatures.DocumentSignatureInfo;
import com.pspdfkit.signatures.HashAlgorithm;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public class lm implements PdfDocument {
    public static final PageRenderConfiguration Q;
    public final List<DocumentSource> A;
    public final String B;
    public final String C;
    public PdfVersion D;
    public List<OutlineElement> E;
    public final int[] F;
    public EnumSet<DocumentPermissions> G;
    public volatile boolean H;
    public volatile boolean I;
    public final PdfDocumentCheckpointer J;
    public final go<c> K;
    public boolean L;
    public final wv M;
    public final vw N;
    public final Lazy O;
    public volatile List<MeasurementValueConfiguration> P;
    public final ve a;
    public final CoroutineScope b;
    public final ou c;
    public final boolean d;
    public final o3 e;
    public final cm f;
    public final fm g;
    public final EmbeddedFilesProvider h;
    public final yd i;
    public final we j;
    public final Single<DocumentSignatureInfo> k;
    public final an l;
    public final ReentrantLock m;
    public OutlineElementState n;
    public wb o;
    public final NativePdfObjectsHitDetector p;
    public final NativeResourceManager q;
    public final DocumentSource r;
    public final int s;
    public final boolean t;
    public final byte[] u;
    public final byte[] v;
    public final byte[] w;
    public final String x;
    public final NativeDocument y;
    public Completable z;

    public static final class a implements ou.b {
        public final Size[] a;
        public final byte[] b;
        public final byte[] c;
        public final String[] d;

        public a(Size[] sizeArr, byte[] bArr, byte[] bArr2, String[] strArr) {
            this.a = sizeArr;
            this.b = bArr;
            this.c = bArr2;
            this.d = strArr;
        }

        @Override // com.pspdfkit.internal.ou.b
        public final String getPageLabel(int i, boolean z) {
            String str = this.d[i];
            return (str == null && z) ? String.valueOf(i + 1) : str;
        }

        @Override // com.pspdfkit.internal.ou.b
        public final byte getPageRotation(int i) {
            return this.b[i];
        }

        @Override // com.pspdfkit.internal.ou.b
        public final Size getPageSize(int i) {
            return this.a[i];
        }

        @Override // com.pspdfkit.internal.ou.b
        public final byte getRotationOffset(int i) {
            return this.c[i];
        }
    }

    public static final class b {
        public static NativeDocument a(List list) throws IOException {
            h00 h00Var;
            list.getClass();
            ArrayList arrayList = new ArrayList();
            String uid = ((DocumentSource) list.get(0)).getUid();
            uid.getClass();
            boolean zAreEqual = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DocumentSource documentSource = (DocumentSource) it.next();
                if (zAreEqual && documentSource.isRemoteSource()) {
                    throw new DownloadException.DownloadOnMainThreadException();
                }
                arrayList.add(documentSource.toDataDescriptor());
            }
            synchronized (ar.class) {
                if (ar.i == null) {
                    ar.i = new h00();
                }
                h00Var = ar.i;
            }
            g00 g00VarA = h00Var.a(uid);
            g00VarA.readLock().lock();
            try {
                NativeDocumentOpenResult nativeDocumentOpenResultOpen = NativeDocument.open(arrayList);
                nativeDocumentOpenResultOpen.getClass();
                if (!nativeDocumentOpenResultOpen.getHasError()) {
                    NativeDocument document = nativeDocumentOpenResultOpen.getDocument();
                    if (document == null) {
                        throw new IOException("Error while loading PdfDocument");
                    }
                    g00VarA.readLock().unlock();
                    return document;
                }
                if (nativeDocumentOpenResultOpen.getErrorCode() == NativeDocumentOpenErrorCode.ERROR_PASSWORD) {
                    throw new InvalidPasswordException("Invalid password for document.");
                }
                String errorString = nativeDocumentOpenResultOpen.getErrorString();
                errorString.getClass();
                if (StringsKt.startsWith$default(errorString, "Invalid content signature", false, 2, (Object) null)) {
                    throw new InvalidSignatureException("Invalid document signature.");
                }
                if (StringsKt.startsWith$default(errorString, "Content signatures feature is not available for this license.", false, 2, (Object) null)) {
                    throw new InvalidSignatureException("Content signatures are not supported by your Nutrient license. Please open the document without providing a signature, or upgrade your Nutrient license.");
                }
                if (StringsKt.startsWith$default(errorString, "No content signature provided.", false, 2, (Object) null)) {
                    throw new InvalidSignatureException("Content signature was missing. Your Nutrient license can only be used with signed documents.");
                }
                throw new IOException("Error while loading PdfDocument: " + nativeDocumentOpenResultOpen.getErrorString());
            } catch (Throwable th) {
                g00VarA.readLock().unlock();
                throw th;
            }
        }
    }

    public interface c {
        void onInternalDocumentSaveFailed(lm lmVar, Throwable th);

        void onInternalDocumentSaved(lm lmVar);

        void onPageBindingChanged();

        void onPageRotationOffsetChanged();
    }

    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PdfBox.values().length];
            try {
                iArr[PdfBox.CROP_BOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PdfBox.BLEED_BOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PdfBox.TRIM_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.model.InternalPdfDocument$save$1", f = "InternalPdfDocument.kt", i = {}, l = {798}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return lm.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return lm.this.new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = lm.this.e;
                this.a = 1;
                if (o3Var.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.model.InternalPdfDocument$saveToPath$1", f = "InternalPdfDocument.kt", i = {}, l = {885}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return lm.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return lm.this.new f(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = lm.this.e;
                this.a = 1;
                if (o3Var.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.model.InternalPdfDocument$setInternalRotationOffsets$2$1", f = "InternalPdfDocument.kt", i = {}, l = {1129}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return lm.this.new g(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return lm.this.new g(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = lm.this.e;
                Set<Integer> of = SetsKt.setOf(Boxing.boxInt(this.c));
                this.a = 1;
                if (o3Var.a(of, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    static {
        PageRenderConfiguration pageRenderConfigurationBuild = new PageRenderConfiguration.Builder().build();
        pageRenderConfigurationBuild.getClass();
        Q = pageRenderConfigurationBuild;
    }

    public lm() {
        throw null;
    }

    public lm(NativeDocument nativeDocument, List list, nc ncVar, x8 x8Var, DocumentSource documentSource, boolean z, final boolean z2) {
        String uid;
        byte[] changingFileId;
        byte[] permanentFileId;
        this.a = new ve(z);
        PdfDocumentCheckpointer pdfDocumentCheckpointer = null;
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.d = z2;
        this.m = new ReentrantLock();
        this.n = OutlineElementState.DEFAULT;
        this.r = documentSource;
        this.y = nativeDocument;
        this.A = list;
        this.H = true;
        this.I = true;
        this.K = new go<>();
        nativeDocument.setTextParserOptions(this.H ? EnumSet.of(NativeTextParserOptions.FILTER_WATERMARKS) : EnumSet.noneOf(NativeTextParserOptions.class));
        nativeDocument.enableAutomaticLinkExtraction(this.I);
        ArrayList<NativeDocumentProvider> documentProviders = nativeDocument.getDocumentProviders();
        documentProviders.getClass();
        NativeDocumentProvider nativeDocumentProvider = (NativeDocumentProvider) CollectionsKt.firstOrNull((List) documentProviders);
        this.s = nativeDocument.getPageCount();
        this.t = nativeDocument.hasOutline();
        byte[] documentId = nativeDocument.getDocumentId();
        documentId.getClass();
        this.u = documentId;
        this.v = (nativeDocumentProvider == null || (permanentFileId = nativeDocumentProvider.getPermanentFileId()) == null) ? new byte[0] : permanentFileId;
        this.w = (nativeDocumentProvider == null || (changingFileId = nativeDocumentProvider.getChangingFileId()) == null) ? new byte[0] : changingFileId;
        String documentIdString = nativeDocument.getDocumentIdString();
        documentIdString.getClass();
        this.x = documentIdString;
        this.F = new int[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.F[i] = nativeDocument.getProviderPageOffset(i);
        }
        String title = nativeDocument.getTitle();
        this.C = title == null ? ue.a(this.A.get(0)) : title;
        for (int i2 = this.s - 1; -1 < i2; i2--) {
            nativeDocument.getPageInfo(i2);
        }
        EnumSet<NativeDocumentPermissions> currentPermissions = nativeDocument.getCurrentPermissions();
        currentPermissions.getClass();
        this.G = r10.a(currentPermissions);
        NativePDFVersion currentPdfVersion = nativeDocument.getCurrentPdfVersion();
        currentPdfVersion.getClass();
        this.D = r10.a(currentPdfVersion);
        if (this.A.get(0).isFileSource()) {
            uid = nativeDocument.getUid();
            uid.getClass();
        } else {
            DataProvider dataProvider = this.A.get(0).getDataProvider();
            if (dataProvider == null || (uid = dataProvider.getUid()) == null) {
                throw new IllegalStateException("Non file source data provider must not be null.");
            }
        }
        this.B = uid;
        NativePdfObjectsHitDetector nativePdfObjectsHitDetectorCreate = NativePdfObjectsHitDetector.create();
        nativePdfObjectsHitDetectorCreate.getClass();
        this.p = nativePdfObjectsHitDetectorCreate;
        NativeResourceManager nativeResourceManagerCreate = NativeResourceManager.create();
        nativeResourceManagerCreate.getClass();
        this.q = nativeResourceManagerCreate;
        this.l = new an(this);
        this.e = ncVar.a(this);
        cm cmVarFromInternalDocument = BookmarkProviderFactory.fromInternalDocument(this);
        cmVarFromInternalDocument.getClass();
        this.f = cmVarFromInternalDocument;
        fm fmVarCreateFromInternalDocument = FormProviderFactory.createFromInternalDocument(this);
        fmVarCreateFromInternalDocument.getClass();
        this.g = fmVarCreateFromInternalDocument;
        this.h = new zf(this);
        this.i = ncVar.b(this);
        this.j = ncVar.c(this);
        this.M = new wv(this);
        Single<DocumentSignatureInfo> singleCache = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.a(this.f$0);
            }
        }).subscribeOn(b(5)).cache();
        singleCache.getClass();
        this.k = singleCache;
        a(EmptyCoroutineContext.INSTANCE, new pm(this, null, null));
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        this.N = new vw(context, "DocumentPreferences");
        if (x8Var != null && this.A.size() == 1) {
            DocumentSource documentSource2 = this.A.get(0);
            File checkpointFile = documentSource2.getCheckpointFile();
            if (checkpointFile == null) {
                throw new IllegalArgumentException("Checkpoint file is null.");
            }
            if (!PdfDocumentCheckpointer.isCheckpointSupported(documentSource2)) {
                throw new IllegalArgumentException("Checkpoint is not available for documents that have multiple providers or protected.");
            }
            pdfDocumentCheckpointer = new PdfDocumentCheckpointer(this, checkpointFile, x8Var, documentSource2.isCheckpointAlreadyCreated());
        }
        this.J = pdfDocumentCheckpointer;
        ou ouVar = new ou(uid, nativeDocument, z);
        this.c = ouVar;
        tq.j.add(ouVar);
        this.O = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(lm.a(z2, this));
            }
        });
        this.P = CollectionsKt.emptyList();
    }

    public static final void d(lm lmVar) {
        NativeDocument nativeDocument = lmVar.y;
        int i = lmVar.s;
        Size[] sizeArr = new Size[i];
        for (int i2 = 0; i2 < i; i2++) {
            sizeArr[i2] = new Size(0.0f, 0.0f);
        }
        int i3 = lmVar.s;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i3];
        String[] strArr = new String[i3];
        while (true) {
            i3--;
            if (-1 >= i3) {
                ou ouVar = lmVar.c;
                a aVar = new a(sizeArr, bArr, bArr2, strArr);
                ouVar.getClass();
                ouVar.f = aVar;
                return;
            }
            NativePageInfo pageInfo = nativeDocument.getPageInfo(i3);
            if (pageInfo == null) {
                throw new IllegalStateException("Page info for page " + i3 + " is null.");
            }
            Size size = pageInfo.getSize();
            size.getClass();
            sizeArr[i3] = size;
            bArr[i3] = pageInfo.getRotation();
            bArr2[i3] = pageInfo.getRotationOffset();
            strArr[i3] = nativeDocument.getPageLabel(i3, false);
        }
    }

    public final Job a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        coroutineContext.getClass();
        return BuildersKt__Builders_commonKt.launch$default(this.b, coroutineContext, null, function2, 2, null);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Completable addLongTermValidation(SignatureFormElement signatureFormElement, List<? extends X509Certificate> list) {
        signatureFormElement.getClass();
        list.getClass();
        return o.a(this, signatureFormElement, list);
    }

    public Single<Boolean> b(final DocumentSaveOptions documentSaveOptions) {
        Single<Boolean> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.a(this.f$0, documentSaveOptions);
            }
        }).subscribeOn(b(10));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public final int c(int i) {
        this.c.a(i);
        int i2 = 0;
        while (true) {
            int[] iArr = this.F;
            if (i2 >= iArr.length || i < iArr[i2]) {
                break;
            }
            i2++;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 - 1;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public BookmarkProvider getBookmarkProvider() {
        return this.f;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final byte[] getChangeId() {
        return this.w;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final int getCharIndexAt(int i, float f2, float f3) {
        NativeTextParser nativeTextParserA = this.c.b(i).a();
        if (nativeTextParserA == null) {
            return -1;
        }
        return nativeTextParserA.charIndexAt(new PointF(f2, f3), 1.0f);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final PdfDocumentCheckpointer getCheckpointer() {
        return this.J;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final DocumentSaveOptions getDefaultDocumentSaveOptions() {
        return a(true);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final byte[] getDocumentId() {
        return this.u;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getDocumentIdString() {
        return this.x;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final DocumentSignatureInfo getDocumentSignatureInfo() {
        DocumentSignatureInfo documentSignatureInfoBlockingGet = this.k.blockingGet();
        documentSignatureInfoBlockingGet.getClass();
        return documentSignatureInfoBlockingGet;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Single<DocumentSignatureInfo> getDocumentSignatureInfoAsync() {
        return this.k;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final DocumentSource getDocumentSource() {
        return this.A.get(0);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final List<DocumentSource> getDocumentSources() {
        List<DocumentSource> listUnmodifiableList = Collections.unmodifiableList(this.A);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final EmbeddedFilesProvider getEmbeddedFilesProvider() {
        return this.h;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final FormProvider getFormProvider() {
        return this.g;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final byte[] getHashForDocumentRange(List<Long> list, HashAlgorithm hashAlgorithm) {
        list.getClass();
        hashAlgorithm.getClass();
        return getHashForDocumentRange(0, list, hashAlgorithm);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final JavaScriptProvider getJavaScriptProvider() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.pspdfkit.document.OutlineElement>] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    @Override // com.pspdfkit.document.PdfDocument
    public final List<OutlineElement> getOutline() {
        ?? EmptyList;
        OutlineElement outlineElementA;
        if (this.E == null) {
            if (this.t) {
                byte[] flatbuffersOutline = this.y.getOutlineParser().getFlatbuffersOutline();
                EmptyList = new ArrayList();
                if (flatbuffersOutline != null && flatbuffersOutline.length != 0) {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(flatbuffersOutline);
                    byteBufferWrap.getClass();
                    lt ltVar = new lt();
                    byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                    ltVar.a(byteBufferWrap.position() + byteBufferWrap.getInt(byteBufferWrap.position()), byteBufferWrap);
                    int iA = ltVar.a(8);
                    if ((iA != 0 ? ltVar.d(iA) : 0) > 0) {
                        int iA2 = ltVar.a(8);
                        int iD = iA2 != 0 ? ltVar.d(iA2) : 0;
                        for (int i = 0; i < iD; i++) {
                            lt ltVar2 = new lt();
                            int iA3 = ltVar.a(8);
                            if (iA3 != 0) {
                                int iC = (i * 4) + ltVar.c(iA3);
                                int i2 = ltVar.b.getInt(iC) + iC;
                                ByteBuffer byteBuffer = ltVar.b;
                                byteBuffer.getClass();
                                ltVar2.a(i2, byteBuffer);
                            } else {
                                ltVar2 = null;
                            }
                            if (ltVar2 != null && (outlineElementA = kt.a(this, ltVar2)) != null) {
                                EmptyList.add(outlineElementA);
                            }
                        }
                    }
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            this.E = EmptyList;
            Unit unit = Unit.INSTANCE;
        }
        List<OutlineElement> list = this.E;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Outline elements shouldn't be null.");
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Single<List<OutlineElement>> getOutlineAsync() {
        Single<List<OutlineElement>> singleJust;
        List<OutlineElement> list = this.E;
        if (list != null && (singleJust = Single.just(list)) != null) {
            return singleJust;
        }
        Single<List<OutlineElement>> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.c(this.f$0);
            }
        }).subscribeOn(b(10));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final PageBinding getPageBinding() {
        NativePageBinding pageBinding = this.y.getPageBinding();
        pageBinding.getClass();
        pageBinding.getClass();
        int i = r10.a.a[pageBinding.ordinal()];
        if (i == 1) {
            return PageBinding.UNKNOWN;
        }
        if (i == 2) {
            return PageBinding.LEFT_EDGE;
        }
        if (i == 3) {
            return PageBinding.RIGHT_EDGE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final RectF getPageBox(int i, PdfBox pdfBox) {
        pdfBox.getClass();
        vv vvVarB = this.c.b(i);
        NativePage nativePage = vvVarB.c;
        RectF box = nativePage != null ? nativePage.getBox(r10.a(pdfBox)) : null;
        if (box != null) {
            return box;
        }
        int i2 = d.a[pdfBox.ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            Size pageSize = getPageSize(i);
            return new RectF(0.0f, pageSize.height, pageSize.width, 0.0f);
        }
        PdfBox pdfBox2 = PdfBox.CROP_BOX;
        pdfBox2.getClass();
        NativePage nativePage2 = vvVarB.c;
        RectF box2 = nativePage2 != null ? nativePage2.getBox(r10.a(pdfBox2)) : null;
        if (box2 != null) {
            return box2;
        }
        PdfBox pdfBox3 = PdfBox.MEDIA_BOX;
        pdfBox3.getClass();
        NativePage nativePage3 = vvVarB.c;
        RectF box3 = nativePage3 != null ? nativePage3.getBox(r10.a(pdfBox3)) : null;
        return box3 == null ? new RectF() : box3;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final int getPageCount() {
        return this.s;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Integer getPageIndexForPageLabel(String str, boolean z) {
        str.getClass();
        return this.y.getPageIndexForPageLabel(str, z);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getPageLabel(int i, boolean z) {
        this.c.a(i);
        return this.c.f.getPageLabel(i, z);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final int getPageRotation(int i) {
        this.c.a(i);
        int rotationOffset = (this.c.f.getRotationOffset(i) + this.c.f.getPageRotation(i)) % 4;
        if (rotationOffset == 1) {
            return 90;
        }
        if (rotationOffset != 2) {
            return rotationOffset != 3 ? 0 : 270;
        }
        return 180;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Size getPageSize(int i) {
        this.c.a(i);
        ou ouVar = this.c;
        ouVar.a(i);
        return ouVar.f.getPageSize(i);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getPageText(int i) {
        vv vvVarB = this.c.b(i);
        String strText = vvVarB.d;
        if (strText == null) {
            NativeTextParser nativeTextParserA = vvVarB.a();
            if (nativeTextParserA == null || (strText = nativeTextParserA.text()) == null) {
                strText = null;
            } else {
                vvVarB.d = strText;
            }
            if (strText == null) {
                return "";
            }
        }
        return strText;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final int getPageTextLength(int i) {
        NativeTextParser nativeTextParserA = this.c.b(i).a();
        if (nativeTextParserA == null) {
            return 0;
        }
        return nativeTextParserA.count();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final List<RectF> getPageTextRects(int i, int i2, int i3) {
        return getPageTextRects(i, i2, i3, false);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final DocumentPdfMetadata getPdfMetadata() {
        return this.i;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final PdfProjection getPdfProjection() {
        return this.M;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final PdfVersion getPdfVersion() {
        return this.D;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final byte[] getPermanentId() {
        return this.v;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final EnumSet<DocumentPermissions> getPermissions() {
        EnumSet enumSetClone = this.G.clone();
        enumSetClone.getClass();
        return enumSetClone;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final int getRotationOffset(int i) {
        ou ouVar = this.c;
        ouVar.a(i);
        byte rotationOffset = ouVar.f.getRotationOffset(i);
        if (rotationOffset == 1) {
            return 90;
        }
        if (rotationOffset != 2) {
            return rotationOffset != 3 ? 0 : 270;
        }
        return 180;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final SecondaryMeasurementUnit getSecondaryMeasurementUnit() {
        if (!this.N.a("secondary_measurement_units_enabled", false)) {
            return null;
        }
        if (this.y.getSecondaryMeasurementUnit() == null) {
            return SecondaryMeasurementUnit.getDefault();
        }
        NativeMeasurementSecondaryUnit secondaryMeasurementUnit = this.y.getSecondaryMeasurementUnit();
        if (secondaryMeasurementUnit == null) {
            return null;
        }
        NativeMeasurementPrecision precision = secondaryMeasurementUnit.getPrecision();
        precision.getClass();
        MeasurementPrecision measurementPrecisionA = mr.a(precision);
        NativeUnitTo unitTo = secondaryMeasurementUnit.getUnitTo();
        unitTo.getClass();
        return new SecondaryMeasurementUnit(measurementPrecisionA, mr.a(unitTo));
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getTextForBlocks(List<TextBlock> list) {
        list.getClass();
        return a(list);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getTitle() {
        if (!TextUtils.isEmpty((String) this.i.c.get(NativeProcessorConfiguration.METADATA_TITLE))) {
            return (String) this.i.c.get(NativeProcessorConfiguration.METADATA_TITLE);
        }
        if (TextUtils.isEmpty(this.C)) {
            return null;
        }
        return this.C;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getUid() {
        return this.B;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final DocumentXmpMetadata getXmpMetadata() {
        return this.j;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean hasEmbeddedFile() {
        return this.h.hasEmbeddedFiles();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean hasOutline() {
        return this.t;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean hasPermission(DocumentPermissions documentPermissions) {
        documentPermissions.getClass();
        return this.G.contains(documentPermissions);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void initPageCache() {
        initPageCacheAsync().subscribe();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Completable initPageCacheAsync() {
        g60 g60VarC;
        if (this.z == null) {
            Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda2
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    lm.d(this.f$0);
                }
            });
            synchronized (ar.class) {
                g60VarC = q10.c();
            }
            this.z = completableFromAction.subscribeOn(((m0) g60VarC).a()).cache();
        }
        Completable completable = this.z;
        if (completable != null) {
            return completable;
        }
        throw new IllegalStateException("Page cache completable shouldn't be null.");
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void invalidateCache() {
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        utVar.a(this.B, this.s).blockingAwait();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void invalidateCacheForPage(int i) {
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        utVar.a(this.B, Collections.singletonList(Integer.valueOf(i))).blockingAwait();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean isAutomaticLinkGenerationEnabled() {
        return this.I;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean isEncrypted() {
        return this.y.hasAnyPasswordSet();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean isWatermarkFilteringEnabled() {
        return this.H;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final boolean isWritableAndCanSave() {
        return this.d && !a();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Bitmap renderPageToBitmap(Context context, int i, int i2, int i3) {
        context.getClass();
        PageRenderConfiguration pageRenderConfiguration = Q;
        pageRenderConfiguration.getClass();
        Bitmap bitmapBlockingGet = renderPageToBitmapAsync(context, i, i2, i3, pageRenderConfiguration).blockingGet();
        bitmapBlockingGet.getClass();
        return bitmapBlockingGet;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Single<Bitmap> renderPageToBitmapAsync(Context context, int i, int i2, int i3) {
        context.getClass();
        return renderPageToBitmapAsync(context, i, i2, i3, Q);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public void save(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        str.getClass();
        documentSaveOptions.getClass();
        a(str, documentSaveOptions);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Completable saveAsync(final String str, final DocumentSaveOptions documentSaveOptions) {
        str.getClass();
        documentSaveOptions.getClass();
        Completable completableSubscribeOn = Completable.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.a(this.f$0, str, documentSaveOptions);
            }
        }).subscribeOn(b(10));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public boolean saveIfModified(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        str.getClass();
        documentSaveOptions.getClass();
        return b(str, documentSaveOptions);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Single<Boolean> saveIfModifiedAsync(final DocumentSaveOptions documentSaveOptions) {
        documentSaveOptions.getClass();
        Single<Boolean> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.b(this.f$0, documentSaveOptions);
            }
        }).subscribeOn(b(10));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public void setAutomaticLinkGenerationEnabled(boolean z) {
        this.m.lock();
        try {
            this.I = z;
            this.y.enableAutomaticLinkExtraction(z);
            this.e.a();
        } finally {
            this.m.unlock();
        }
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void setPageBinding(PageBinding pageBinding) {
        NativePageBinding nativePageBinding;
        pageBinding.getClass();
        PageBinding pageBinding2 = PageBinding.UNKNOWN;
        if (pageBinding == pageBinding2) {
            throw new IllegalArgumentException("You can't set the page binding to UNKNOWN.");
        }
        PageBinding pageBinding3 = getPageBinding();
        if (pageBinding3 == pageBinding2) {
            pageBinding3 = PageBinding.LEFT_EDGE;
        }
        boolean z = pageBinding != pageBinding3;
        NativeDocument nativeDocument = this.y;
        pageBinding.getClass();
        int i = r10.a.b[pageBinding.ordinal()];
        if (i == 1) {
            nativePageBinding = NativePageBinding.UNKNOWN;
        } else if (i == 2) {
            nativePageBinding = NativePageBinding.LEFTEDGE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            nativePageBinding = NativePageBinding.RIGHTEDGE;
        }
        nativeDocument.setPageBinding(nativePageBinding);
        this.L = true;
        if (z) {
            Iterator<c> it = this.K.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().onPageBindingChanged();
            }
        }
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void setRotationOffset(int i, int i2) throws InterruptedException {
        this.c.a(i2);
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        sparseIntArray.put(i2, mr.a(i));
        a(sparseIntArray);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void setRotationOffsets(SparseIntArray sparseIntArray) throws InterruptedException {
        sparseIntArray.getClass();
        SparseIntArray sparseIntArray2 = new SparseIntArray(sparseIntArray.size());
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseIntArray.keyAt(i);
            int iValueAt = sparseIntArray.valueAt(i);
            this.c.a(iKeyAt);
            sparseIntArray2.put(iKeyAt, mr.a(iValueAt));
        }
        a(sparseIntArray2);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void setSecondaryMeasurementUnit(SecondaryMeasurementUnit secondaryMeasurementUnit) {
        SecondaryMeasurementUnit secondaryMeasurementUnit2;
        secondaryMeasurementUnit.getClass();
        if (ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            NativeMeasurementSecondaryUnit secondaryMeasurementUnit3 = this.y.getSecondaryMeasurementUnit();
            if (secondaryMeasurementUnit3 == null) {
                secondaryMeasurementUnit2 = null;
            } else {
                NativeMeasurementPrecision precision = secondaryMeasurementUnit3.getPrecision();
                precision.getClass();
                MeasurementPrecision measurementPrecisionA = mr.a(precision);
                NativeUnitTo unitTo = secondaryMeasurementUnit3.getUnitTo();
                unitTo.getClass();
                secondaryMeasurementUnit2 = new SecondaryMeasurementUnit(measurementPrecisionA, mr.a(unitTo));
            }
            if (Intrinsics.areEqual(secondaryMeasurementUnit2, secondaryMeasurementUnit)) {
                return;
            }
            NativeDocument nativeDocument = this.y;
            Scale.UnitTo unit = secondaryMeasurementUnit.getUnit();
            unit.getClass();
            NativeUnitTo nativeUnitToA = mr.a(unit);
            MeasurementPrecision precision2 = secondaryMeasurementUnit.getPrecision();
            precision2.getClass();
            nativeDocument.setSecondaryMeasurementUnit(new NativeMeasurementSecondaryUnit(nativeUnitToA, mr.a(precision2)));
            o3 o3Var = this.e;
            o3Var.getClass();
            Job job = n00.a;
            if (job != null && job.isActive()) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            n00.a = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new m00(o3Var, null), 3, null);
        }
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final void setWatermarkTextFilteringEnabled(boolean z) {
        this.m.lock();
        try {
            this.H = z;
            this.y.setTextParserOptions(this.H ? EnumSet.of(NativeTextParserOptions.FILTER_WATERMARKS) : EnumSet.noneOf(NativeTextParserOptions.class));
            Iterator<vv> it = this.c.g.values().iterator();
            while (it.hasNext()) {
                it.next().d = null;
            }
        } finally {
            this.m.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    @Override // com.pspdfkit.document.PdfDocument
    public boolean wasModified() {
        boolean z;
        this.m.lock();
        try {
            if (!this.e.hasUnsavedChanges() && !this.f.hasUnsavedChanges() && !this.g.hasUnsavedChanges() && !this.i.hasUnsavedChanges() && !this.j.hasUnsavedChanges()) {
                PdfDocumentCheckpointer pdfDocumentCheckpointer = this.J;
                z = (pdfDocumentCheckpointer != null ? pdfDocumentCheckpointer.checkpointExists() : false) || this.L || this.y.needsSave();
            }
            return z;
        } finally {
            this.m.unlock();
        }
    }

    public static final DocumentSignatureInfo a(lm lmVar) {
        return new te(lmVar);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public o3 getAnnotationProvider() {
        return this.e;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final byte[] getHashForDocumentRange(int i, List<Long> list, HashAlgorithm hashAlgorithm) {
        list.getClass();
        hashAlgorithm.getClass();
        a(i);
        uw.b(list.size() % 2 == 0, "Document range must have even number of elements!");
        NativePlatformDocumentDigesterResult nativePlatformDocumentDigesterResultDigestRangeOfDocument = NativePlatformDocumentDigester.digestRangeOfDocument(this.y.getDocumentProviders().get(i), new ArrayList(list), mr.a(hashAlgorithm));
        nativePlatformDocumentDigesterResultDigestRangeOfDocument.getClass();
        if (nativePlatformDocumentDigesterResultDigestRangeOfDocument.getError() != null) {
            throw new IllegalStateException(nativePlatformDocumentDigesterResultDigestRangeOfDocument.getError());
        }
        byte[] documentDigest = nativePlatformDocumentDigesterResultDigestRangeOfDocument.getDocumentDigest();
        if (documentDigest != null) {
            return documentDigest;
        }
        throw new IllegalStateException("Document digest was null");
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final List<RectF> getPageTextRects(int i, int i2, int i3, boolean z) {
        NativeTextParser nativeTextParserA = this.c.b(i).a();
        NativeTextRange nativeTextRangeTextRectsForRange = nativeTextParserA == null ? null : nativeTextParserA.textRectsForRange(i2, i3);
        if (nativeTextRangeTextRectsForRange == null) {
            return CollectionsKt.emptyList();
        }
        if (z) {
            ArrayList<NativeRectDescriptor> markupRects = nativeTextRangeTextRectsForRange.getMarkupRects();
            markupRects.getClass();
            return r10.a(markupRects);
        }
        ArrayList<NativeRectDescriptor> rects = nativeTextRangeTextRectsForRange.getRects();
        rects.getClass();
        return r10.a(rects);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Single<Bitmap> renderPageToBitmapAsync(Context context, int i, int i2, int i3, PageRenderConfiguration pageRenderConfiguration) {
        context.getClass();
        pageRenderConfiguration.getClass();
        this.c.a(i);
        ou ouVar = this.c;
        android.util.Size size = new android.util.Size(i2, i3);
        ouVar.getClass();
        oy oyVar = pageRenderConfiguration.renderRegion ? new oy(new Point(pageRenderConfiguration.regionX, pageRenderConfiguration.regionY), new android.util.Size(pageRenderConfiguration.regionFullPageWidth, pageRenderConfiguration.regionFullPageHeight)) : null;
        Bitmap bitmap = pageRenderConfiguration.reuseBitmap;
        int i4 = pageRenderConfiguration.paperColor;
        Integer num = pageRenderConfiguration.formHighlightColor;
        Integer num2 = pageRenderConfiguration.formItemHighlightColor;
        Integer num3 = pageRenderConfiguration.formRequiredFieldBorderColor;
        Integer num4 = pageRenderConfiguration.signHereOverlayBackgroundColor;
        boolean z = pageRenderConfiguration.toGrayscale;
        boolean z2 = pageRenderConfiguration.invertColors;
        boolean z3 = pageRenderConfiguration.redactionAnnotationPreviewEnabled;
        List<PdfDrawable> list = pageRenderConfiguration.renderedDrawables;
        list.getClass();
        boolean z4 = pageRenderConfiguration.showSignHereOverlay;
        boolean z5 = pageRenderConfiguration.useCache;
        List<Integer> list2 = pageRenderConfiguration.excludedAnnotations;
        list2.getClass();
        List<AnnotationType> list3 = pageRenderConfiguration.excludedAnnotationTypes;
        list3.getClass();
        jm jmVarA = jm.a(new jm(ouVar, i, bitmap, size, z5, null, oyVar, 3, i4, num, num2, num3, num4, z2, z, list2, list3, list, z3, z4, true), null, null, null, 10, null, null, null, null, false, false, 2097023);
        return pageRenderConfiguration.renderRegion ? iu.c(jmVarA) : iu.b(jmVarA);
    }

    @Override // com.pspdfkit.document.PdfDocument
    public void save(String str) throws IOException {
        str.getClass();
        save(str, a(true));
    }

    @Override // com.pspdfkit.document.PdfDocument
    public boolean saveIfModified(DocumentSaveOptions documentSaveOptions) throws IOException {
        documentSaveOptions.getClass();
        if (!this.d) {
            return false;
        }
        this.m.lock();
        try {
            if (wasModified()) {
                return a(documentSaveOptions);
            }
            PdfLog.d("Nutri.InternalPdfDoc", "Document not modified, not saving.", new Object[0]);
            return false;
        } finally {
            this.m.unlock();
        }
    }

    public static final Boolean b(lm lmVar, DocumentSaveOptions documentSaveOptions) {
        return Boolean.valueOf(lmVar.saveIfModified(documentSaveOptions));
    }

    public final void a(int i) {
        if (i < 0 || i >= this.F.length) {
            throw new IllegalArgumentException(("Invalid document provider index " + i + ", valid range is [0, " + (this.F.length - 1) + "]").toString());
        }
    }

    public static final Boolean b(lm lmVar, String str, DocumentSaveOptions documentSaveOptions) {
        return Boolean.valueOf(lmVar.b(str, documentSaveOptions));
    }

    public static final List c(lm lmVar) {
        return lmVar.getOutline();
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getPageText(int i, int i2, int i3) {
        NativeTextParser nativeTextParserA = this.c.b(i).a();
        if (nativeTextParserA == null) {
            return "";
        }
        String strTextForRange = nativeTextParserA.textForRange(i2, i3);
        strTextForRange.getClass();
        return strTextForRange;
    }

    public boolean b(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        str.getClass();
        documentSaveOptions.getClass();
        if (!wasModified()) {
            PdfLog.d("Nutri.InternalPdfDoc", "Document not modified, not saving.", new Object[0]);
            return false;
        }
        a(str, documentSaveOptions);
        return true;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Single<Boolean> saveIfModifiedAsync(final String str, final DocumentSaveOptions documentSaveOptions) {
        str.getClass();
        documentSaveOptions.getClass();
        Single<Boolean> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.lm$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return lm.b(this.f$0, str, documentSaveOptions);
            }
        }).subscribeOn(b(10));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Completable saveAsync(String str) {
        str.getClass();
        return saveAsync(str, a(true));
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Single<Boolean> saveIfModifiedAsync() {
        return saveIfModifiedAsync(a(true));
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final String getPageText(int i, RectF rectF) {
        rectF.getClass();
        vv vvVarB = this.c.b(i);
        rectF.getClass();
        NativeTextParser nativeTextParserA = vvVarB.a();
        if (nativeTextParserA == null) {
            return "";
        }
        String textForRect = nativeTextParserA.getTextForRect(rectF);
        textForRect.getClass();
        return textForRect;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public Single<Boolean> saveIfModifiedAsync(String str) {
        str.getClass();
        return saveIfModifiedAsync(str, a(true));
    }

    public final List a(int i, List list) {
        String strTextForRange;
        list.getClass();
        vv vvVarB = this.c.b(i);
        NativeTextParser nativeTextParserA = vvVarB.a();
        if (nativeTextParserA != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ArrayList<NativeRectDescriptor> arrayListTextRectsBoundedByRect = nativeTextParserA.textRectsBoundedByRect((RectF) it.next(), true, false, false);
                arrayListTextRectsBoundedByRect.getClass();
                Iterator<NativeRectDescriptor> it2 = arrayListTextRectsBoundedByRect.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    NativeRectDescriptor next = it2.next();
                    int startPosition = next.getRange().getStartPosition();
                    int length = next.getRange().getLength();
                    NativeTextParser nativeTextParserA2 = vvVarB.a();
                    if (nativeTextParserA2 == null) {
                        strTextForRange = "";
                    } else {
                        strTextForRange = nativeTextParserA2.textForRange(startPosition, length);
                        strTextForRange.getClass();
                    }
                    TextBlock textBlockCreate = TextBlock.create(vvVarB.b, next.getRange(), CollectionsKt.listOf(next.getRect()), strTextForRange);
                    textBlockCreate.getClass();
                    arrayList.add(textBlockCreate);
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final bx.a b(int i) {
        bx bxVar = this.a.b;
        bxVar.getClass();
        return bxVar.new a(i);
    }

    public static final ArrayList b(lm lmVar) {
        ArrayList<NativeMeasurementContentFormat> measurementContentFormats = lmVar.y.getMeasurementContentFormats();
        measurementContentFormats.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(measurementContentFormats, 10));
        int size = measurementContentFormats.size();
        int i = 0;
        while (i < size) {
            NativeMeasurementContentFormat nativeMeasurementContentFormat = measurementContentFormats.get(i);
            i++;
            NativeMeasurementContentFormat nativeMeasurementContentFormat2 = nativeMeasurementContentFormat;
            nativeMeasurementContentFormat2.getClass();
            String name = nativeMeasurementContentFormat2.getName();
            NativeMeasurementScale scale = nativeMeasurementContentFormat2.getScale();
            scale.getClass();
            float from = (float) scale.getFrom();
            NativeUnitFrom unitFrom = scale.getUnitFrom();
            unitFrom.getClass();
            Scale.UnitFrom unitFromA = mr.a(unitFrom);
            float to = (float) scale.getTo();
            NativeUnitTo unitTo = scale.getUnitTo();
            unitTo.getClass();
            Scale scale2 = new Scale(from, unitFromA, to, mr.a(unitTo), scale.getFromDescription(), scale.getToDescription());
            NativeMeasurementPrecision precision = nativeMeasurementContentFormat2.getPrecision();
            precision.getClass();
            arrayList.add(new MeasurementValueConfiguration(name, scale2, mr.a(precision)));
        }
        lmVar.P = arrayList;
        return arrayList;
    }

    @Override // com.pspdfkit.document.PdfDocument
    public boolean saveIfModified() throws IOException {
        return saveIfModified(a(true));
    }

    @Override // com.pspdfkit.document.PdfDocument
    public boolean saveIfModified(String str) throws IOException {
        str.getClass();
        return saveIfModified(str, a(true));
    }

    public final String a(List<TextBlock> list) {
        list.getClass();
        if (list.isEmpty()) {
            return "";
        }
        int i = list.get(0).pageIndex;
        Iterator<TextBlock> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().pageIndex != i) {
                throw new IllegalArgumentException("All text blocks must belong to the same page!");
            }
        }
        NativeTextParser nativeTextParserA = this.c.b(i).a();
        if (nativeTextParserA == null) {
            return "";
        }
        ArrayList<Range> arrayList = new ArrayList<>(list.size());
        Iterator<TextBlock> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().range);
        }
        String textForRanges = nativeTextParserA.getTextForRanges(arrayList);
        textForRanges.getClass();
        return textForRanges;
    }

    public boolean a(DocumentSaveOptions documentSaveOptions) throws IOException {
        h00 h00Var;
        documentSaveOptions.getClass();
        if (this.d) {
            this.m.lock();
            try {
                try {
                    this.f.prepareToSave();
                    BuildersKt__BuildersKt.runBlocking$default(null, new e(null), 1, null);
                    synchronized (ar.class) {
                        if (ar.i == null) {
                            ar.i = new h00();
                        }
                        h00Var = ar.i;
                    }
                    g00 g00VarA = h00Var.a(this.B);
                    g00VarA.writeLock().lock();
                    try {
                        NativeDocumentSaveResult nativeDocumentSaveResultSave = this.y.save(mr.a(documentSaveOptions, this, false));
                        nativeDocumentSaveResultSave.getClass();
                        g00VarA.writeLock().unlock();
                        if (nativeDocumentSaveResultSave != NativeDocumentSaveResult.ERROR) {
                            EnumSet<NativeDocumentPermissions> currentPermissions = this.y.getCurrentPermissions();
                            currentPermissions.getClass();
                            this.G = r10.a(currentPermissions);
                            NativePDFVersion currentPdfVersion = this.y.getCurrentPdfVersion();
                            currentPdfVersion.getClass();
                            this.D = r10.a(currentPdfVersion);
                            this.e.b();
                            this.f.markBookmarksAsSavedToDisk();
                            this.g.markFormAsSavedToDisk();
                            this.i.a();
                            this.j.a();
                            this.L = false;
                            PdfDocumentCheckpointer pdfDocumentCheckpointer = this.J;
                            if (pdfDocumentCheckpointer != null) {
                                pdfDocumentCheckpointer.documentSavedSuccessfully();
                            }
                            Iterator<c> it = this.K.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                it.next().onInternalDocumentSaved(this);
                            }
                            boolean z = nativeDocumentSaveResultSave == NativeDocumentSaveResult.SAVED;
                            this.m.unlock();
                            return z;
                        }
                        throw new IOException("Failed to save document.");
                    } catch (Throwable th) {
                        g00VarA.writeLock().unlock();
                        throw th;
                    }
                } catch (Exception e2) {
                    Iterator<c> it2 = this.K.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        it2.next().onInternalDocumentSaveFailed(this, e2);
                    }
                    throw e2;
                }
            } catch (Throwable th2) {
                this.m.unlock();
                throw th2;
            }
        }
        throw new UnsupportedOperationException("Document can't be saved.");
    }

    public static final Object a(lm lmVar, String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        lmVar.a(str, documentSaveOptions);
        return null;
    }

    public static final Boolean a(lm lmVar, DocumentSaveOptions documentSaveOptions) {
        return Boolean.valueOf(lmVar.a(documentSaveOptions));
    }

    public void a(String str, DocumentSaveOptions documentSaveOptions) throws IOException {
        str.getClass();
        documentSaveOptions.getClass();
        this.m.lock();
        try {
            String strA = a(str);
            PdfLog.d("Nutri.InternalPdfDoc", "Saving document to " + strA, new Object[0]);
            this.f.prepareToSave();
            BuildersKt__BuildersKt.runBlocking$default(null, new f(null), 1, null);
            if (this.y.mergeToFilePath(strA, mr.a(documentSaveOptions, this, true))) {
                this.m.unlock();
                return;
            }
            throw new IOException("Failed to save document. Check logs.");
        } catch (Throwable th) {
            this.m.unlock();
            throw th;
        }
    }

    public static String a(String str) {
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "/document/raw:", false, 2, (Object) null)) {
            return StringsKt.replace$default(str, "/document/raw:", "", false, 4, (Object) null);
        }
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "/document/primary:", false, 2, (Object) null)) {
            return str;
        }
        return StringsKt.replace$default(str, "/document/primary:", Environment.getExternalStorageDirectory().getAbsolutePath() + "/", false, 4, (Object) null);
    }

    public final DocumentSaveOptions a(boolean z) {
        boolean z2 = false;
        String password = this.A.get(0).getPassword();
        EnumSet<E> enumSetClone = this.G.clone();
        if (z && ((Boolean) this.O.getValue()).booleanValue()) {
            z2 = true;
        }
        NativePDFVersion currentPdfVersion = this.y.getCurrentPdfVersion();
        currentPdfVersion.getClass();
        return new DocumentSaveOptions(password, enumSetClone, z2, r10.a(currentPdfVersion));
    }

    public static final boolean a(boolean z, lm lmVar) {
        if (z && lmVar.A.size() == 1) {
            if (lmVar.A.get(0).isFileSource()) {
                return true;
            }
            DataProvider dataProvider = lmVar.A.get(0).getDataProvider();
            if ((dataProvider instanceof WritableDataProvider) && ((WritableDataProvider) dataProvider).supportsAppending()) {
                return true;
            }
        }
        return false;
    }

    public boolean a() {
        if (this.A.size() != 1) {
            return true;
        }
        DocumentSource documentSource = this.A.get(0);
        return (documentSource.isFileSource() || (documentSource.getDataProvider() instanceof WritableDataProvider)) ? false : true;
    }

    public final Object a(MeasurementValueConfiguration measurementValueConfiguration, SuspendLambda suspendLambda) {
        PdfLog.d("Nutri.InternalPdfDoc", "Adding MeasurementValueConfiguration " + measurementValueConfiguration.getNameForDisplay(false), new Object[0]);
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new mm(this, measurementValueConfiguration, null), suspendLambda);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final Object a(MeasurementValueConfiguration measurementValueConfiguration, eq eqVar) {
        PdfLog.d("Nutri.InternalPdfDoc", "Removing MeasurementValueConfiguration " + measurementValueConfiguration.getNameForDisplay(false), new Object[0]);
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new om(this, measurementValueConfiguration, null), eqVar);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void a(SparseIntArray sparseIntArray) throws InterruptedException {
        Size size;
        int size2 = sparseIntArray.size();
        for (int i = 0; i < size2; i++) {
            int iKeyAt = sparseIntArray.keyAt(i);
            int iValueAt = sparseIntArray.valueAt(i);
            this.c.a(iKeyAt);
            NativePageInfo pageInfo = this.y.getPageInfo(iKeyAt);
            if (pageInfo != null) {
                if ((pageInfo.getRotationOffset() + iValueAt) % 2 == 1) {
                    Size size3 = pageInfo.getSize();
                    size3.getClass();
                    size = new Size(size3.height, size3.width);
                } else {
                    size = pageInfo.getSize();
                    size.getClass();
                }
                Size size4 = size;
                RectF untransformedBbox = pageInfo.getUntransformedBbox();
                untransformedBbox.getClass();
                byte rotation = (byte) ((pageInfo.getRotation() + iValueAt) % 4);
                Matrix matrix = new Matrix();
                if (rotation == 0) {
                    matrix.setValues(new float[]{1.0f, 0.0f, -untransformedBbox.left, 0.0f, 1.0f, -untransformedBbox.bottom, 0.0f, 0.0f, 1.0f});
                } else if (rotation == 1) {
                    matrix.setValues(new float[]{0.0f, 1.0f, -untransformedBbox.bottom, -1.0f, 0.0f, untransformedBbox.right, 0.0f, 0.0f, 1.0f});
                } else if (rotation == 2) {
                    matrix.setValues(new float[]{-1.0f, 0.0f, untransformedBbox.right, 0.0f, -1.0f, untransformedBbox.top, 0.0f, 0.0f, 1.0f});
                } else if (rotation == 3) {
                    matrix.setValues(new float[]{0.0f, -1.0f, untransformedBbox.top, 1.0f, 0.0f, -untransformedBbox.left, 0.0f, 0.0f, 1.0f});
                }
                Matrix matrix2 = new Matrix();
                matrix.invert(matrix2);
                byte b2 = (byte) iValueAt;
                NativePageInfo nativePageInfo = new NativePageInfo(size4, pageInfo.getBbox(), untransformedBbox, pageInfo.getRotation(), b2, matrix, matrix2, pageInfo.getAllowAnnotationCreation());
                ArrayList<NativeDocumentProvider> documentProviders = this.y.getDocumentProviders();
                documentProviders.getClass();
                int size5 = documentProviders.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size5) {
                        NativeDocumentProvider nativeDocumentProvider = documentProviders.get(i2);
                        int providerPageOffset = this.y.getProviderPageOffset(i2);
                        int pageCount = nativeDocumentProvider.getPageCount() + providerPageOffset;
                        if (providerPageOffset <= iKeyAt && iKeyAt < pageCount) {
                            nativeDocumentProvider.setPageInfo(nativePageInfo, iKeyAt - providerPageOffset);
                            ou.b bVar = this.c.f;
                            if (!(bVar instanceof a)) {
                                break;
                            }
                            a aVar = (a) bVar;
                            aVar.a[iKeyAt] = size4;
                            aVar.c[iKeyAt] = b2;
                            break;
                        }
                        i2++;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        throw new IllegalStateException(String.format(Locale.getDefault(), "Couldn't find document provider for given page index: %d", Arrays.copyOf(new Object[]{Integer.valueOf(iKeyAt)}, 1)));
                    }
                }
            }
        }
        this.y.clearPageCache();
        this.e.d.updateAnnotationTransforms();
        IntIterator intIteratorKeyIterator = SparseIntArrayKt.keyIterator(sparseIntArray);
        while (intIteratorKeyIterator.hasNext()) {
            BuildersKt__BuildersKt.runBlocking$default(null, new g(intIteratorKeyIterator.next().intValue(), null), 1, null);
        }
        Iterator<c> it = this.K.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onPageRotationOffsetChanged();
        }
    }

    public final void b(boolean z) {
        if (ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            vw vwVar = this.N;
            vwVar.getClass();
            if (vwVar.a.contains("secondary_measurement_units_enabled") && z == this.N.a("secondary_measurement_units_enabled", !z)) {
                return;
            }
            SharedPreferences.Editor editorEdit = this.N.a.edit();
            editorEdit.getClass();
            editorEdit.putBoolean("secondary_measurement_units_enabled", z).apply();
            o3 o3Var = this.e;
            o3Var.getClass();
            Job job = n00.a;
            if (job != null && job.isActive()) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            n00.a = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new m00(o3Var, null), 3, null);
        }
    }

    @Override // com.pspdfkit.document.PdfDocument
    public final Bitmap renderPageToBitmap(Context context, int i, int i2, int i3, PageRenderConfiguration pageRenderConfiguration) {
        context.getClass();
        pageRenderConfiguration.getClass();
        Bitmap bitmapBlockingGet = renderPageToBitmapAsync(context, i, i2, i3, pageRenderConfiguration).blockingGet();
        bitmapBlockingGet.getClass();
        return bitmapBlockingGet;
    }

    public lm(NativeDocument nativeDocument, boolean z, nc ncVar, DocumentSource documentSource) {
        nativeDocument.getClass();
        ArrayList<NativeDocumentProvider> documentProviders = nativeDocument.getDocumentProviders();
        documentProviders.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator<NativeDocumentProvider> it = documentProviders.iterator();
        it.getClass();
        while (it.hasNext()) {
            NativeDocumentProvider next = it.next();
            NativeDataProvider dataProvider = next.getDataProvider();
            nr nrVar = dataProvider != null ? new nr(dataProvider) : null;
            arrayList.add(new DocumentSource(nrVar == null ? Uri.fromFile(new File(next.getFilePath())) : null, nrVar, null, null));
        }
        this(nativeDocument, arrayList, ncVar, null, documentSource, false, z);
    }
}
