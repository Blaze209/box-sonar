package external.sdk.pendo.io.glide.request;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorRequestCoordinator implements b, sdk.pendo.io.u.a {
    private volatile sdk.pendo.io.u.a error;
    private b.a errorState;
    private final b parent;
    private volatile sdk.pendo.io.u.a primary;
    private b.a primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object obj, b bVar) {
        b.a aVar = b.a.CLEARED;
        this.primaryState = aVar;
        this.errorState = aVar;
        this.requestLock = obj;
        this.parent = bVar;
    }

    private boolean isValidRequestForStatusChanged(sdk.pendo.io.u.a aVar) {
        b.a aVar2 = this.primaryState;
        b.a aVar3 = b.a.FAILED;
        if (aVar2 != aVar3) {
            return aVar.equals(this.primary);
        }
        if (!aVar.equals(this.error)) {
            return false;
        }
        b.a aVar4 = this.errorState;
        return aVar4 == b.a.SUCCESS || aVar4 == aVar3;
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
            b.a aVar = this.primaryState;
            b.a aVar2 = b.a.RUNNING;
            if (aVar != aVar2) {
                this.primaryState = aVar2;
                this.primary.begin();
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyCleared(sdk.pendo.io.u.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyCleared() && aVar.equals(this.primary);
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canNotifyStatusChanged(sdk.pendo.io.u.a aVar) {
        boolean z;
        synchronized (this.requestLock) {
            z = parentCanNotifyStatusChanged() && isValidRequestForStatusChanged(aVar);
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public boolean canSetImage(sdk.pendo.io.u.a aVar) {
        boolean zParentCanSetImage;
        synchronized (this.requestLock) {
            zParentCanSetImage = parentCanSetImage();
        }
        return zParentCanSetImage;
    }

    @Override // sdk.pendo.io.u.a
    public void clear() {
        synchronized (this.requestLock) {
            b.a aVar = b.a.CLEARED;
            this.primaryState = aVar;
            this.primary.clear();
            if (this.errorState != aVar) {
                this.errorState = aVar;
                this.error.clear();
            }
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
            z = this.primary.isAnyResourceSet() || this.error.isAnyResourceSet();
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            b.a aVar = this.primaryState;
            b.a aVar2 = b.a.CLEARED;
            z = aVar == aVar2 && this.errorState == aVar2;
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            b.a aVar = this.primaryState;
            b.a aVar2 = b.a.SUCCESS;
            z = aVar == aVar2 || this.errorState == aVar2;
        }
        return z;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isEquivalentTo(sdk.pendo.io.u.a aVar) {
        if (aVar instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) aVar;
            if (this.primary.isEquivalentTo(errorRequestCoordinator.primary) && this.error.isEquivalentTo(errorRequestCoordinator.error)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.u.a
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            b.a aVar = this.primaryState;
            b.a aVar2 = b.a.RUNNING;
            z = aVar == aVar2 || this.errorState == aVar2;
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestFailed(sdk.pendo.io.u.a aVar) {
        synchronized (this.requestLock) {
            if (aVar.equals(this.error)) {
                this.errorState = b.a.FAILED;
                b bVar = this.parent;
                if (bVar != null) {
                    bVar.onRequestFailed(this);
                }
            } else {
                this.primaryState = b.a.FAILED;
                b.a aVar2 = this.errorState;
                b.a aVar3 = b.a.RUNNING;
                if (aVar2 != aVar3) {
                    this.errorState = aVar3;
                    this.error.begin();
                }
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.request.b
    public void onRequestSuccess(sdk.pendo.io.u.a aVar) {
        synchronized (this.requestLock) {
            if (aVar.equals(this.primary)) {
                this.primaryState = b.a.SUCCESS;
            } else if (aVar.equals(this.error)) {
                this.errorState = b.a.SUCCESS;
            }
            b bVar = this.parent;
            if (bVar != null) {
                bVar.onRequestSuccess(this);
            }
        }
    }

    @Override // sdk.pendo.io.u.a
    public void pause() {
        synchronized (this.requestLock) {
            b.a aVar = this.primaryState;
            b.a aVar2 = b.a.RUNNING;
            if (aVar == aVar2) {
                this.primaryState = b.a.PAUSED;
                this.primary.pause();
            }
            if (this.errorState == aVar2) {
                this.errorState = b.a.PAUSED;
                this.error.pause();
            }
        }
    }

    public void setRequests(sdk.pendo.io.u.a aVar, sdk.pendo.io.u.a aVar2) {
        this.primary = aVar;
        this.error = aVar2;
    }
}
