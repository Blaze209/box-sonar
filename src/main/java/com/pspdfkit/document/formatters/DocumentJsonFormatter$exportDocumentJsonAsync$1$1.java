package com.pspdfkit.document.formatters;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.instant.client.InstantJsonVersion;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter$exportDocumentJsonAsync$1$1", f = "DocumentJsonFormatter.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class DocumentJsonFormatter$exportDocumentJsonAsync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PdfDocument $document;
    final /* synthetic */ InstantJsonVersion $instantJsonVersion;
    final /* synthetic */ OutputStream $outputStream;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentJsonFormatter$exportDocumentJsonAsync$1$1(PdfDocument pdfDocument, OutputStream outputStream, InstantJsonVersion instantJsonVersion, Continuation<? super DocumentJsonFormatter$exportDocumentJsonAsync$1$1> continuation) {
        super(2, continuation);
        this.$document = pdfDocument;
        this.$outputStream = outputStream;
        this.$instantJsonVersion = instantJsonVersion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentJsonFormatter$exportDocumentJsonAsync$1$1(this.$document, this.$outputStream, this.$instantJsonVersion, continuation);
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
        return ((DocumentJsonFormatter$exportDocumentJsonAsync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
