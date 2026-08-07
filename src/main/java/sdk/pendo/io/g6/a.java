package sdk.pendo.io.g6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.l4.r;
import sdk.pendo.io.models.networkReponses.GuideContentResponse;
import sdk.pendo.io.n4.f;
import sdk.pendo.io.n4.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lsdk/pendo/io/g6/a;", "", "", "url", "Lsdk/pendo/io/l4/r;", "Lsdk/pendo/io/models/networkReponses/GuideContentResponse;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface a {
    @f
    Object a(@y String str, Continuation<? super r<GuideContentResponse>> continuation);
}
