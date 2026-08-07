package com.pspdfkit.document.formatters;

import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.instant.client.InstantJsonVersion;
import com.pspdfkit.internal.jni.NativeDataSink;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeDocumentJSONFormatter;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.pt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0087@¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010 \u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b \u0010!Js\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001c2Z\u0010'\u001aV\u0012\u0004\u0012\u00020$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c0#j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c`&0#j*\u0012\u0004\u0012\u00020$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c0#j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001c`&`&H\u0002¢\u0006\u0004\b(\u0010)J.\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,H\u0082@¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u00101¨\u00063"}, d2 = {"Lcom/pspdfkit/document/formatters/DocumentJsonFormatter;", "", "<init>", "()V", "Lcom/pspdfkit/document/PdfDocument;", "document", "Ljava/io/OutputStream;", "outputStream", "Lcom/pspdfkit/instant/client/InstantJsonVersion;", "instantJsonVersion", "", "exportDocumentJsonBlocking", "(Lcom/pspdfkit/document/PdfDocument;Ljava/io/OutputStream;Lcom/pspdfkit/instant/client/InstantJsonVersion;)V", "Lio/reactivex/rxjava3/core/Completable;", "exportDocumentJsonAsync", "(Lcom/pspdfkit/document/PdfDocument;Ljava/io/OutputStream;Lcom/pspdfkit/instant/client/InstantJsonVersion;)Lio/reactivex/rxjava3/core/Completable;", "exportDocumentJson", "(Lcom/pspdfkit/document/PdfDocument;Ljava/io/OutputStream;Lcom/pspdfkit/instant/client/InstantJsonVersion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/pspdfkit/document/providers/DataProvider;", "dataProvider", "importDocumentJsonBlocking", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/document/providers/DataProvider;)V", "importDocumentJsonAsync", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/document/providers/DataProvider;)Lio/reactivex/rxjava3/core/Completable;", "importDocumentJson", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/document/providers/DataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/pspdfkit/internal/lm;", "", "Lcom/pspdfkit/annotations/Annotation;", "removedAnnotations", "Lcom/pspdfkit/internal/jni/NativeImportDocumentJSONResult;", "nativeImportResult", "notifyAnnotationListenersOfImport", "(Lcom/pspdfkit/internal/lm;Ljava/util/List;Lcom/pspdfkit/internal/jni/NativeImportDocumentJSONResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "annotation", "Ljava/util/HashMap;", "", "Landroid/graphics/RectF;", "Lkotlin/collections/HashMap;", "topLevelNotes", "restoreNoteComments", "(Lcom/pspdfkit/annotations/Annotation;Ljava/util/HashMap;)V", "internalDocument", "providerIndex", "Lcom/pspdfkit/internal/jni/NativeDataProvider;", "nativeDataProvider", "prefetchRemovedAnnotations", "(Lcom/pspdfkit/internal/lm;ILcom/pspdfkit/internal/jni/NativeDataProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSerializationArguments", "(Lcom/pspdfkit/document/PdfDocument;)V", "validateDeserializationArguments", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocumentJsonFormatter {
    public static final int $stable = 0;
    public static final DocumentJsonFormatter INSTANCE = new DocumentJsonFormatter();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<InstantJsonVersion> entries$0 = EnumEntriesKt.enumEntries(InstantJsonVersion.values());
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$exportDocumentJson$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter", f = "DocumentJsonFormatter.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {Token.SETELEM_OP}, m = "exportDocumentJson", n = {"document", "outputStream", "instantJsonVersion", "internalPdfDocument", "nativeDocument", "dataSink", "providerIndex"}, nl = {Token.DOTDOT}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentJsonFormatter.exportDocumentJson(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$exportDocumentJsonBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter$exportDocumentJsonBlocking$1", f = "DocumentJsonFormatter.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PdfDocument $document;
        final /* synthetic */ InstantJsonVersion $instantJsonVersion;
        final /* synthetic */ OutputStream $outputStream;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18481(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, Continuation<? super C18481> continuation) {
            super(2, continuation);
            this.$document = pdfDocument;
            this.$outputStream = outputStream;
            this.$instantJsonVersion = instantJsonVersion;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18481(this.$document, this.$outputStream, this.$instantJsonVersion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PdfDocument pdfDocument = this.$document;
                OutputStream outputStream = this.$outputStream;
                InstantJsonVersion instantJsonVersion = this.$instantJsonVersion;
                this.label = 1;
                if (DocumentJsonFormatter.exportDocumentJson(pdfDocument, outputStream, instantJsonVersion, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$importDocumentJson$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter", f = "DocumentJsonFormatter.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {241, 244, 251}, m = "importDocumentJson", n = {"document", "dataProvider", "internalPdfDocument", "nativeDocument", "nativeDataProvider", "providerIndex", "document", "dataProvider", "internalPdfDocument", "nativeDocument", "nativeDataProvider", "providerIndex", "document", "dataProvider", "internalPdfDocument", "nativeDocument", "nativeDataProvider", "removedAnnotations", "nativeImportResult", "providerIndex"}, nl = {244, 243, 252}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    public static final class C18491 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C18491(Continuation<? super C18491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentJsonFormatter.importDocumentJson(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$importDocumentJsonBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter$importDocumentJsonBlocking$1", f = "DocumentJsonFormatter.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataProvider $dataProvider;
        final /* synthetic */ PdfDocument $document;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18501(PdfDocument pdfDocument, DataProvider dataProvider, Continuation<? super C18501> continuation) {
            super(2, continuation);
            this.$document = pdfDocument;
            this.$dataProvider = dataProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18501(this.$document, this.$dataProvider, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PdfDocument pdfDocument = this.$document;
                DataProvider dataProvider = this.$dataProvider;
                this.label = 1;
                if (DocumentJsonFormatter.importDocumentJson(pdfDocument, dataProvider, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$notifyAnnotationListenersOfImport$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter", f = "DocumentJsonFormatter.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {268, 284}, m = "notifyAnnotationListenersOfImport", n = {"document", "removedAnnotations", "nativeImportResult", "internalAnnotationProvider", "nativeAnnotation", "pageIndex", "annotationId", "document", "removedAnnotations", "nativeImportResult", "internalAnnotationProvider", "topLevelNotes", "nativeAnnotation", "pageIndex", "annotationId"}, nl = {269, 286}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8"}, v = 2)
    public static final class C18511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public C18511(Continuation<? super C18511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentJsonFormatter.this.notifyAnnotationListenersOfImport(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.formatters.DocumentJsonFormatter$prefetchRemovedAnnotations$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter", f = "DocumentJsonFormatter.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {353}, m = "prefetchRemovedAnnotations", n = {"internalDocument", "nativeDataProvider", "nativeDocument", "skippedAnnotationsResult", "removedNativeAnnotations", "removedAnnotations", "internalAnnotationProvider", "nativeAnnotation", "objectNumber", "pageIndex", "providerIndex"}, nl = {354}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    public static final class C18521 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C18521(Continuation<? super C18521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentJsonFormatter.this.prefetchRemovedAnnotations(null, 0, null, this);
        }
    }

    private DocumentJsonFormatter() {
    }

    @JvmStatic
    public static final Object exportDocumentJson(PdfDocument pdfDocument, OutputStream outputStream, Continuation<? super Unit> continuation) {
        return exportDocumentJson$default(pdfDocument, outputStream, null, continuation, 4, null);
    }

    public static /* synthetic */ Object exportDocumentJson$default(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            instantJsonVersion = (InstantJsonVersion) CollectionsKt.last((List) EntriesMappings.entries$0);
        }
        return exportDocumentJson(pdfDocument, outputStream, instantJsonVersion, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the suspend exportDocumentJson API instead.", replaceWith = @ReplaceWith(expression = "DocumentJsonFormatter.exportDocumentJson(document, outputStream, instantJsonVersion)", imports = {}))
    @JvmStatic
    public static final Completable exportDocumentJsonAsync(PdfDocument pdfDocument, OutputStream outputStream) {
        pdfDocument.getClass();
        outputStream.getClass();
        return exportDocumentJsonAsync$default(pdfDocument, outputStream, null, 4, null);
    }

    public static /* synthetic */ Completable exportDocumentJsonAsync$default(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            instantJsonVersion = (InstantJsonVersion) CollectionsKt.last((List) EntriesMappings.entries$0);
        }
        return exportDocumentJsonAsync(pdfDocument, outputStream, instantJsonVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exportDocumentJsonAsync$lambda$0(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion) throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new DocumentJsonFormatter$exportDocumentJsonAsync$1$1(pdfDocument, outputStream, instantJsonVersion, null), 1, null);
    }

    @JvmStatic
    public static final void exportDocumentJsonBlocking(PdfDocument pdfDocument, OutputStream outputStream) throws InterruptedException {
        pdfDocument.getClass();
        outputStream.getClass();
        exportDocumentJsonBlocking$default(pdfDocument, outputStream, null, 4, null);
    }

    public static /* synthetic */ void exportDocumentJsonBlocking$default(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, int i, Object obj) throws InterruptedException {
        if ((i & 4) != 0) {
            instantJsonVersion = (InstantJsonVersion) CollectionsKt.last((List) EntriesMappings.entries$0);
        }
        exportDocumentJsonBlocking(pdfDocument, outputStream, instantJsonVersion);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0101  */
    /* JADX WARN: Code duplicated, block: B:33:0x013b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0135, code lost:
    
        if (r8.notifyAnnotationListenersOfImport(r5, r13, r3, r0) == r1) goto L30;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object importDocumentJson(com.pspdfkit.document.PdfDocument r11, com.pspdfkit.document.providers.DataProvider r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.document.formatters.DocumentJsonFormatter.importDocumentJson(com.pspdfkit.document.PdfDocument, com.pspdfkit.document.providers.DataProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the suspend importDocumentJson API instead.", replaceWith = @ReplaceWith(expression = "DocumentJsonFormatter.importDocumentJson(document, dataProvider)", imports = {}))
    @JvmStatic
    public static final Completable importDocumentJsonAsync(final PdfDocument document, final DataProvider dataProvider) {
        document.getClass();
        dataProvider.getClass();
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.document.formatters.DocumentJsonFormatter$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws InterruptedException {
                DocumentJsonFormatter.importDocumentJsonAsync$lambda$0(document, dataProvider);
            }
        });
        completableFromAction.getClass();
        return completableFromAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void importDocumentJsonAsync$lambda$0(PdfDocument pdfDocument, DataProvider dataProvider) throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new DocumentJsonFormatter$importDocumentJsonAsync$1$1(pdfDocument, dataProvider, null), 1, null);
    }

    @JvmStatic
    public static final void importDocumentJsonBlocking(PdfDocument document, DataProvider dataProvider) throws InterruptedException {
        document.getClass();
        dataProvider.getClass();
        BuildersKt__BuildersKt.runBlocking$default(null, new C18501(document, dataProvider, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:28:0x0102  */
    /* JADX WARN: Code duplicated, block: B:33:0x0111 A[LOOP:2: B:31:0x010b->B:33:0x0111, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x0140  */
    /* JADX WARN: Code duplicated, block: B:49:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x013a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x018e, code lost:
    
        if (r1 == r3) goto L42;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00f9 -> B:26:0x00fe). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x018e -> B:43:0x0191). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyAnnotationListenersOfImport(com.pspdfkit.internal.lm r18, java.util.List<? extends com.pspdfkit.annotations.Annotation> r19, com.pspdfkit.internal.jni.NativeImportDocumentJSONResult r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.document.formatters.DocumentJsonFormatter.notifyAnnotationListenersOfImport(com.pspdfkit.internal.lm, java.util.List, com.pspdfkit.internal.jni.NativeImportDocumentJSONResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:21:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:30:0x012f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0117 -> B:26:0x011f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object prefetchRemovedAnnotations(com.pspdfkit.internal.lm r18, int r19, com.pspdfkit.internal.jni.NativeDataProvider r20, kotlin.coroutines.Continuation<? super java.util.List<? extends com.pspdfkit.annotations.Annotation>> r21) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.document.formatters.DocumentJsonFormatter.prefetchRemovedAnnotations(com.pspdfkit.internal.lm, int, com.pspdfkit.internal.jni.NativeDataProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void restoreNoteComments(Annotation annotation, HashMap<Integer, HashMap<RectF, Annotation>> topLevelNotes) {
        Annotation annotation2;
        if (annotation.getType() == AnnotationType.NOTE) {
            if (annotation.hasFlag(AnnotationFlags.HIDDEN)) {
                HashMap<RectF, Annotation> map = topLevelNotes.get(Integer.valueOf(annotation.getPageIndex()));
                if (map == null || (annotation2 = map.get(annotation.getBoundingBox())) == null) {
                    return;
                }
                annotation.setInReplyTo(annotation2);
                return;
            }
            HashMap<RectF, Annotation> map2 = topLevelNotes.get(Integer.valueOf(annotation.getPageIndex()));
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            map2.put(annotation.getBoundingBox(), annotation);
            topLevelNotes.put(Integer.valueOf(annotation.getPageIndex()), map2);
        }
    }

    private final void validateDeserializationArguments(PdfDocument document) {
        if (document.getDocumentSources().size() > 1) {
            throw new IllegalArgumentException("Can't apply annotations to documents with more than one document source.");
        }
    }

    private final void validateSerializationArguments(PdfDocument document) {
        if (document.getDocumentSources().size() > 1) {
            throw new IllegalArgumentException("Can't serialize documents with more than one document source.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @JvmStatic
    public static final Object exportDocumentJson(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        NativeDocument nativeDocument;
        int i;
        NativeDataSink nativeDataSink;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            INSTANCE.validateSerializationArguments(pdfDocument);
            pdfDocument.getClass();
            lm lmVar = (lm) pdfDocument;
            nativeDocument = lmVar.y;
            pt ptVar = new pt(outputStream);
            o3 annotationProvider = lmVar.getAnnotationProvider();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(pdfDocument);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(outputStream);
            anonymousClass1.L$2 = instantJsonVersion;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(lmVar);
            anonymousClass1.L$4 = nativeDocument;
            anonymousClass1.L$5 = ptVar;
            i = 0;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            if (annotationProvider.a(anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            nativeDataSink = ptVar;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            nativeDataSink = (NativeDataSink) anonymousClass1.L$5;
            NativeDocument nativeDocument2 = (NativeDocument) anonymousClass1.L$4;
            InstantJsonVersion instantJsonVersion2 = (InstantJsonVersion) anonymousClass1.L$2;
            ResultKt.throwOnFailure(obj);
            nativeDocument = nativeDocument2;
            instantJsonVersion = instantJsonVersion2;
        }
        NativeResult nativeResultExportJson = NativeDocumentJSONFormatter.exportJson(mr.a(instantJsonVersion), nativeDocument, i, nativeDataSink);
        nativeResultExportJson.getClass();
        if (nativeResultExportJson.getHasError()) {
            throw new DocumentJsonFormatterException(nativeResultExportJson.getErrorString());
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the suspend exportDocumentJson API instead.", replaceWith = @ReplaceWith(expression = "DocumentJsonFormatter.exportDocumentJson(document, outputStream, instantJsonVersion)", imports = {}))
    @JvmStatic
    public static final Completable exportDocumentJsonAsync(final PdfDocument document, final OutputStream outputStream, final InstantJsonVersion instantJsonVersion) {
        document.getClass();
        outputStream.getClass();
        instantJsonVersion.getClass();
        Completable completableFromAction = Completable.fromAction(new Action() { // from class: com.pspdfkit.document.formatters.DocumentJsonFormatter$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws InterruptedException {
                DocumentJsonFormatter.exportDocumentJsonAsync$lambda$0(document, outputStream, instantJsonVersion);
            }
        });
        completableFromAction.getClass();
        return completableFromAction;
    }

    @JvmStatic
    public static final void exportDocumentJsonBlocking(PdfDocument document, OutputStream outputStream, InstantJsonVersion instantJsonVersion) throws InterruptedException {
        document.getClass();
        outputStream.getClass();
        instantJsonVersion.getClass();
        BuildersKt__BuildersKt.runBlocking$default(null, new C18481(document, outputStream, instantJsonVersion, null), 1, null);
    }
}
