package com.pspdfkit.document.formatters;

import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
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
@DebugMetadata(c = "com.pspdfkit.document.formatters.DocumentJsonFormatter$importDocumentJsonAsync$1$1", f = "DocumentJsonFormatter.kt", i = {}, l = {BoxCommonConstants.REQUEST_DELETE}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
public final class DocumentJsonFormatter$importDocumentJsonAsync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataProvider $dataProvider;
    final /* synthetic */ PdfDocument $document;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentJsonFormatter$importDocumentJsonAsync$1$1(PdfDocument pdfDocument, DataProvider dataProvider, Continuation<? super DocumentJsonFormatter$importDocumentJsonAsync$1$1> continuation) {
        super(2, continuation);
        this.$document = pdfDocument;
        this.$dataProvider = dataProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentJsonFormatter$importDocumentJsonAsync$1$1(this.$document, this.$dataProvider, continuation);
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
        return ((DocumentJsonFormatter$importDocumentJsonAsync$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
