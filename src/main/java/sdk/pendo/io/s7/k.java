package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\r\u0010\u0005¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/s7/k;", "Lsdk/pendo/io/s7/m;", "Lkotlinx/coroutines/CoroutineDispatcher;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlinx/coroutines/CoroutineDispatcher;", "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "b", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "c", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "main", "getDefault", "default", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CoroutineDispatcher io = Dispatchers.getIO();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final MainCoroutineDispatcher main = Dispatchers.getMain();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final CoroutineDispatcher default = Dispatchers.getDefault();

    @Override // sdk.pendo.io.s7.m
    /* JADX INFO: renamed from: a, reason: from getter */
    public CoroutineDispatcher getIo() {
        return this.io;
    }

    @Override // sdk.pendo.io.s7.m
    /* JADX INFO: renamed from: c, reason: from getter and merged with bridge method [inline-methods] */
    public MainCoroutineDispatcher b() {
        return this.main;
    }
}
