package external.sdk.pendo.io.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.manager.ConnectivityMonitor;
import external.sdk.pendo.io.glide.manager.TargetTracker;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.CustomViewTarget;
import external.sdk.pendo.io.glide.request.target.Target;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class RequestManager implements ComponentCallbacks2, sdk.pendo.io.r.b {
    private static final RequestOptions DECODE_TYPE_BITMAP = RequestOptions.decodeTypeOf(Bitmap.class).lock();
    private static final RequestOptions DECODE_TYPE_GIF = RequestOptions.decodeTypeOf(GifDrawable.class).lock();
    private static final RequestOptions DOWNLOAD_ONLY_OPTIONS = RequestOptions.diskCacheStrategyOf(sdk.pendo.io.h.a.c).priority(sdk.pendo.io.c.b.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private boolean clearOnStop;
    private final ConnectivityMonitor connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<sdk.pendo.io.u.b<Object>> defaultRequestListeners;
    protected final external.sdk.pendo.io.glide.a glide;
    final sdk.pendo.io.r.a lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private RequestOptions requestOptions;
    private final sdk.pendo.io.r.d requestTracker;
    private final TargetTracker targetTracker;
    private final sdk.pendo.io.r.c treeNode;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestManager requestManager = RequestManager.this;
            requestManager.lifecycle.a(requestManager);
        }
    }

    private static class b extends CustomViewTarget<View, Object> {
        b(View view) {
            super(view);
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onResourceReady(Object obj, external.sdk.pendo.io.glide.request.transition.a<? super Object> aVar) {
        }
    }

    private class c implements ConnectivityMonitor.a {
        private final sdk.pendo.io.r.d a;

        c(sdk.pendo.io.r.d dVar) {
            this.a = dVar;
        }

        @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor.a
        public void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    this.a.e();
                }
            }
        }
    }

    public RequestManager(external.sdk.pendo.io.glide.a aVar, sdk.pendo.io.r.a aVar2, sdk.pendo.io.r.c cVar, Context context) {
        this(aVar, aVar2, cVar, new sdk.pendo.io.r.d(), aVar.d(), context);
    }

    private synchronized void clearRequests() {
        Iterator<Target<?>> it = this.targetTracker.getAll().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.clear();
    }

    private void untrackOrDelegate(Target<?> target) {
        boolean zUntrack = untrack(target);
        sdk.pendo.io.u.a request = target.getRequest();
        if (zUntrack || this.glide.a(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.clear();
    }

    private synchronized void updateRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = this.requestOptions.apply(requestOptions);
    }

    public RequestManager addDefaultRequestListener(sdk.pendo.io.u.b<Object> bVar) {
        this.defaultRequestListeners.add(bVar);
        return this;
    }

    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions requestOptions) {
        updateRequestOptions(requestOptions);
        return this;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((external.sdk.pendo.io.glide.request.a<?>) DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((external.sdk.pendo.io.glide.request.a<?>) DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        clear(new b(view));
    }

    public synchronized RequestManager clearOnStop() {
        this.clearOnStop = true;
        return this;
    }

    public RequestBuilder<File> download(Object obj) {
        return downloadOnly().m14700load(obj);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((external.sdk.pendo.io.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    List<sdk.pendo.io.u.b<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized RequestOptions getDefaultRequestOptions() {
        return this.requestOptions;
    }

    <T> e<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.f().a(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.b();
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14704load(Bitmap bitmap) {
        return asDrawable().m14695load(bitmap);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // sdk.pendo.io.r.b
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        clearRequests();
        this.requestTracker.a();
        this.lifecycle.b(this);
        this.lifecycle.b(this.connectivityMonitor);
        l.c(this.addSelfToLifecycle);
        this.glide.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // sdk.pendo.io.r.b
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // sdk.pendo.io.r.b
    public synchronized void onStop() {
        this.targetTracker.onStop();
        if (this.clearOnStop) {
            clearRequests();
        } else {
            pauseRequests();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.c();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.d();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.f();
    }

    public synchronized void resumeRequestsRecursive() {
        l.b();
        resumeRequests();
        Iterator<RequestManager> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public synchronized RequestManager setDefaultRequestOptions(RequestOptions requestOptions) {
        setRequestOptions(requestOptions);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    protected synchronized void setRequestOptions(RequestOptions requestOptions) {
        this.requestOptions = requestOptions.mo14694clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    synchronized void track(Target<?> target, sdk.pendo.io.u.a aVar) {
        this.targetTracker.track(target);
        this.requestTracker.b(aVar);
    }

    synchronized boolean untrack(Target<?> target) {
        sdk.pendo.io.u.a request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.a(request)) {
            return false;
        }
        this.targetTracker.untrack(target);
        target.setRequest(null);
        return true;
    }

    RequestManager(external.sdk.pendo.io.glide.a aVar, sdk.pendo.io.r.a aVar2, sdk.pendo.io.r.c cVar, sdk.pendo.io.r.d dVar, external.sdk.pendo.io.glide.manager.b bVar, Context context) {
        this.targetTracker = new TargetTracker();
        a aVar3 = new a();
        this.addSelfToLifecycle = aVar3;
        this.glide = aVar;
        this.lifecycle = aVar2;
        this.treeNode = cVar;
        this.requestTracker = dVar;
        this.context = context;
        ConnectivityMonitor connectivityMonitorBuild = bVar.build(context.getApplicationContext(), new c(dVar));
        this.connectivityMonitor = connectivityMonitorBuild;
        aVar.a(this);
        if (l.d()) {
            l.b(aVar3);
        } else {
            aVar2.a(this);
        }
        aVar2.a(connectivityMonitorBuild);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(aVar.f().b());
        setRequestOptions(aVar.f().c());
    }

    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14705load(Drawable drawable) {
        return asDrawable().m14696load(drawable);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14706load(Uri uri) {
        return asDrawable().m14697load(uri);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14707load(File file) {
        return asDrawable().m14698load(file);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14708load(Integer num) {
        return asDrawable().m14699load(num);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14709load(Object obj) {
        return asDrawable().m14700load(obj);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14710load(String str) {
        return asDrawable().m14701load(str);
    }

    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14711load(URL url) {
        return asDrawable().m14702load(url);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<Drawable> m14712load(byte[] bArr) {
        return asDrawable().m14703load(bArr);
    }
}
