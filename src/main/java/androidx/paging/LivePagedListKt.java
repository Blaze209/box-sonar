package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import com.pspdfkit.annotations.NoteAnnotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LivePagedList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u0001H\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"toLiveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Value", NoteAnnotation.KEY, "Landroidx/paging/DataSource$Factory;", "config", "Landroidx/paging/PagedList$Config;", "initialLoadKey", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "fetchExecutor", "Ljava/util/concurrent/Executor;", "(Landroidx/paging/DataSource$Factory;Landroidx/paging/PagedList$Config;Ljava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "pageSize", "", "(Landroidx/paging/DataSource$Factory;ILjava/lang/Object;Landroidx/paging/PagedList$BoundaryCallback;Ljava/util/concurrent/Executor;)Landroidx/lifecycle/LiveData;", "paging-runtime-ktx_release"}, k = 2, mv = {1, 1, 11})
public final class LivePagedListKt {
    public static /* bridge */ /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, PagedList.Config config, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            Intrinsics.checkExpressionValueIsNotNull(executor, "ArchTaskExecutor.getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, config, obj, boundaryCallback, executor);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> receiver, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor fetchExecutor) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(fetchExecutor, "fetchExecutor");
        LiveData<PagedList<Value>> liveDataBuild = new LivePagedListBuilder(receiver, config).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(fetchExecutor).build();
        Intrinsics.checkExpressionValueIsNotNull(liveDataBuild, "LivePagedListBuilder(thi…tor)\n            .build()");
        return liveDataBuild;
    }

    public static /* bridge */ /* synthetic */ LiveData toLiveData$default(DataSource.Factory factory, int i, Object obj, PagedList.BoundaryCallback boundaryCallback, Executor executor, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        if ((i2 & 4) != 0) {
            boundaryCallback = null;
        }
        if ((i2 & 8) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            Intrinsics.checkExpressionValueIsNotNull(executor, "ArchTaskExecutor.getIOThreadExecutor()");
        }
        return toLiveData((DataSource.Factory<Object, Value>) factory, i, obj, boundaryCallback, executor);
    }

    public static final <Key, Value> LiveData<PagedList<Value>> toLiveData(DataSource.Factory<Key, Value> receiver, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, Executor fetchExecutor) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(fetchExecutor, "fetchExecutor");
        LiveData<PagedList<Value>> liveDataBuild = new LivePagedListBuilder(receiver, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null)).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback).setFetchExecutor(fetchExecutor).build();
        Intrinsics.checkExpressionValueIsNotNull(liveDataBuild, "LivePagedListBuilder(thi…tor)\n            .build()");
        return liveDataBuild;
    }
}
