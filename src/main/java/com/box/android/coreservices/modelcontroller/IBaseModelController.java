package com.box.android.coreservices.modelcontroller;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBaseModelController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007JR\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\t\"\u0014\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\rH&JB\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\t\"\u0014\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000bH&J\\\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00030\t\"\u001e\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b*\b\u0012\u0004\u0012\u0002H\u00030\u0006\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\rH&JL\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00030\t\"\u001e\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000b*\b\u0012\u0004\u0012\u0002H\u00030\u0006\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\n0\u000bH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "Lcom/box/android/domain/services/IBaseModelControllerService;", "getFromLocalOrRemote", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/androidsdk/content/models/BoxObject;", "request", "Lcom/box/androidsdk/content/requests/BoxCacheableRequest;", "(Lcom/box/androidsdk/content/requests/BoxCacheableRequest;)Lcom/box/androidsdk/content/models/BoxObject;", "performRemote", "Lcom/box/android/coreservices/modelcontroller/BoxAppFutureTask;", "R", "Lcom/box/androidsdk/content/requests/BoxRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/coreservices/modelcontroller/BoxAppFutureTask$OnCompletedListener;", "performLocal", "keyValueStore", "Lcom/box/android/domain/localrepo/IKeyValueStore;", "getKeyValueStore", "()Lcom/box/android/domain/localrepo/IKeyValueStore;", "getParentId", "", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "RequestIdUtility", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBaseModelController extends IBaseModelControllerService {

    /* JADX INFO: renamed from: RequestIdUtility, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    <T extends BoxObject> T getFromLocalOrRemote(BoxCacheableRequest<T> request) throws BoxException;

    IKeyValueStore getKeyValueStore();

    String getParentId(BoxItem boxItem) throws SQLException;

    <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask<T> performLocal(BoxRequest<T, R> request);

    <R extends BoxRequest<T, R> & BoxCacheableRequest<T>, T extends BoxObject> BoxAppFutureTask<T> performLocal(BoxRequest<T, R> request, BoxAppFutureTask.OnCompletedListener<T> listener);

    <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask<T> performRemote(BoxRequest<T, R> request);

    <R extends BoxRequest<T, R>, T extends BoxObject> BoxAppFutureTask<T> performRemote(BoxRequest<T, R> request, BoxAppFutureTask.OnCompletedListener<T> listener);

    /* JADX INFO: renamed from: com.box.android.coreservices.modelcontroller.IBaseModelController$RequestIdUtility, reason: from kotlin metadata */
    /* JADX INFO: compiled from: IBaseModelController.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/android/coreservices/modelcontroller/IBaseModelController$RequestIdUtility;", "", "<init>", "()V", "globalFutureTaskRequestId", "Ljava/util/concurrent/atomic/AtomicLong;", "getNextRequestId", "", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final AtomicLong globalFutureTaskRequestId = new AtomicLong();

        private Companion() {
        }

        public final long getNextRequestId() {
            return globalFutureTaskRequestId.incrementAndGet();
        }
    }
}
