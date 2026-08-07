package sdk.pendo.io.k7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.m7.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\rJ#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/k7/a;", "", "", "json", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", BoxIterator.FIELD_LIMIT, "", "Lsdk/pendo/io/m7/c;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "", "isSending", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface a {
    Object a(int i, Continuation<? super List<c>> continuation);

    Object a(long j, Continuation<? super Unit> continuation);

    Object a(long j, boolean z, Continuation<? super Unit> continuation);

    Object a(String str, Continuation<? super Unit> continuation);

    Object a(Continuation<? super Long> continuation);

    Object b(Continuation<? super Integer> continuation);

    Object c(Continuation<? super Unit> continuation);
}
