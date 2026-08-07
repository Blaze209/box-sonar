package external.sdk.pendo.io.glide.request;

/* JADX INFO: loaded from: classes4.dex */
public class ThumbnailRequestCoordinator implements b, sdk.pendo.io.u.a {
    private volatile sdk.pendo.io.u.a full;
    private b.a fullState;
    private boolean isRunningDuringBegin;
    private final b parent;
    private final Object requestLock;
    private volatile sdk.pendo.io.u.a thumb;
    private b.a thumbState;

    public ThumbnailRequestCoordinator(Object obj, b bVar) {
        b.a aVar = b.a.CLEARED;
        this.fullState = aVar;
        this.thumbState = aVar;
        this.requestLock = obj;
        this.parent = bVar;
    }

    private boolean parentCanNotifyCleared() {
        b bVar = this.parent;
        return bVar == null || bVar.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        b bVar = this.parent;
        return bVar == null || bVar.canNotifyStatusChanged(this);
    }

    private boolean parentCanSetImage() {
        b bVar = this.parent;
        return bVar == null || bVar.canSetImage(this);
    }

    @Override // sdk.pendo.io.u.a
    public void begin() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = true;
            try {
                if (this.fullState != b.a.SUCCESS) {
                    b.a aVar = this.thumbState;
                    b.a aVar2 = b.a.RUNNING;
                    if (aVar != aVar2) {
                        this.thumbState = aVar2;
                        this.thumb.begin();
                    }
                }
                if (this.isRunningDuringBegin) {
                    b.a aVar3 = this.fullState;
                    b.a aVar4 = b.a.RUNNING;
                    if (aVar3 != aVar4) {
                        this.fullState = aVar4;
                        this.full.begin();
                    }
                }
                this.isRunningDuringBegin = false;
            } catch (Throwable th) {
                this.isRunningDuringBegin = false;
                throw th;
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyCleared(sdk.pendo.io.u.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && aVar.equals(this.full) && this.fullState != b.a.PAUSED;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyStatusChanged(sdk.pendo.io.u.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && aVar.equals(this.full) && !isAnyResourceSet();
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canSetImage(sdk.pendo.io.u.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanSetImage() && (aVar.equals(this.full) || this.fullState != b.a.SUCCESS);
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public void clear() {
        synchronized (this.requestLock) {
            this.isRunningDuringBegin = false;
            b.a aVar = b.a.CLEARED;
            this.fullState = aVar;
            this.thumbState = aVar;
            this.thumb.clear();
            this.full.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [external.sdk.pendo.io.glide.request.b] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // external.sdk.pendo.io.glide.request.b
    public b getRoot() {
        ?? root;
        synchronized (this.requestLock) {
            b bVar = this.parent;
            this = this;
            if (bVar != null) {
                root = bVar.getRoot();
            }
        }
        return root;
    }

    @Override // external.sdk.pendo.io.glide.request.b, sdk.pendo.io.u.a
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.thumb.isAnyResourceSet() || this.full.isAnyResourceSet();
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.CLEARED;
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.SUCCESS;
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isEquivalentTo(sdk.pendo.io.u.a aVar) {
        if (aVar instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) aVar;
            if (this.full != null ? this.full.isEquivalentTo(thumbnailRequestCoordinator.full) : thumbnailRequestCoordinator.full == null) {
                if (this.thumb == null) {
                    if (thumbnailRequestCoordinator.thumb == null) {
                        return true;
                    }
                } else if (this.thumb.isEquivalentTo(thumbnailRequestCoordinator.thumb)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.fullState == b.a.RUNNING;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestFailed(sdk.pendo.io.u.a aVar) {
        synchronized (this.requestLock) {
            if (aVar.equals(this.full)) {
                this.fullState = b.a.FAILED;
                b bVar = this.parent;
                if (bVar != null) {
                    bVar.onRequestFailed(this);
                }
            } else {
                this.thumbState = b.a.FAILED;
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestSuccess(sdk.pendo.io.u.a aVar) {
        synchronized (this.requestLock) {
            if (aVar.equals(this.thumb)) {
                this.thumbState = b.a.SUCCESS;
            } else {
                this.fullState = b.a.SUCCESS;
                b bVar = this.parent;
                if (bVar != null) {
                    bVar.onRequestSuccess(this);
                }
                if (!this.thumbState.b()) {
                    this.thumb.clear();
                }
            }
        }
    }

    @Override // sdk.pendo.io.u.a
    public void pause() {
        synchronized (this.requestLock) {
            if (!this.thumbState.b()) {
                this.thumbState = b.a.PAUSED;
                this.thumb.pause();
            }
            if (!this.fullState.b()) {
                this.fullState = b.a.PAUSED;
                this.full.pause();
            }
        }
    }

    public void setRequests(sdk.pendo.io.u.a aVar, sdk.pendo.io.u.a aVar2) {
        this.full = aVar;
        this.thumb = aVar2;
    }
}
