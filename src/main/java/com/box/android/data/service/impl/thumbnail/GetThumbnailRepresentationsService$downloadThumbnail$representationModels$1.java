package com.box.android.data.service.impl.thumbnail;

import com.box.android.domain.models.RepresentationModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetThumbnailRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/box/android/domain/models/RepresentationModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.thumbnail.GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1", f = "GetThumbnailRepresentationsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1 extends SuspendLambda implements Function2<List<? extends RepresentationModel>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $dimensions;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1(String str, Continuation<? super GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1> continuation) {
        super(2, continuation);
        this.$dimensions = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1 getThumbnailRepresentationsService$downloadThumbnail$representationModels$1 = new GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1(this.$dimensions, continuation);
        getThumbnailRepresentationsService$downloadThumbnail$representationModels$1.L$0 = obj;
        return getThumbnailRepresentationsService$downloadThumbnail$representationModels$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends RepresentationModel> list, Continuation<? super Boolean> continuation) {
        return invoke2((List<RepresentationModel>) list, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<RepresentationModel> list, Continuation<? super Boolean> continuation) {
        return ((GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list2 = list;
        String str = this.$dimensions;
        boolean z = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((RepresentationModel) it.next()).getProperties().getDimensions(), str)) {
                    z = true;
                    break;
                }
            }
        }
        return Boxing.boxBoolean(z);
    }
}
