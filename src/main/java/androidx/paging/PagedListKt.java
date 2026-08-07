package androidx.paging;

import com.pspdfkit.annotations.NoteAnnotation;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagedList.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u0001H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"PagedList", "Landroidx/paging/PagedList;", "Value", NoteAnnotation.KEY, "dataSource", "Landroidx/paging/DataSource;", "config", "Landroidx/paging/PagedList$Config;", "notifyExecutor", "Ljava/util/concurrent/Executor;", "fetchExecutor", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "initialKey", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroidx/paging/PagedList$BoundaryCallback;Ljava/lang/Object;)Landroidx/paging/PagedList;", "paging-common-ktx"}, k = 2, mv = {1, 1, 11})
public final class PagedListKt {
    public static /* bridge */ /* synthetic */ PagedList PagedList$default(DataSource dataSource, PagedList.Config config, Executor executor, Executor executor2, PagedList.BoundaryCallback boundaryCallback, Object obj, int i, Object obj2) {
        PagedList.BoundaryCallback boundaryCallback2;
        if ((i & 16) != 0) {
            boundaryCallback2 = null;
        } else {
            boundaryCallback2 = boundaryCallback;
        }
        return PagedList(dataSource, config, executor, executor2, boundaryCallback2, (i & 32) != 0 ? null : obj);
    }

    public static final <Key, Value> PagedList<Value> PagedList(DataSource<Key, Value> dataSource, PagedList.Config config, Executor notifyExecutor, Executor fetchExecutor, PagedList.BoundaryCallback<Value> boundaryCallback, Key key) {
        Intrinsics.checkParameterIsNotNull(dataSource, "dataSource");
        Intrinsics.checkParameterIsNotNull(config, "config");
        Intrinsics.checkParameterIsNotNull(notifyExecutor, "notifyExecutor");
        Intrinsics.checkParameterIsNotNull(fetchExecutor, "fetchExecutor");
        PagedList<Value> pagedListBuild = new PagedList.Builder(dataSource, config).setNotifyExecutor(notifyExecutor).setFetchExecutor(fetchExecutor).setBoundaryCallback(boundaryCallback).setInitialKey(key).build();
        Intrinsics.checkExpressionValueIsNotNull(pagedListBuild, "PagedList.Builder(dataSo…Key)\n            .build()");
        return pagedListBuild;
    }
}
