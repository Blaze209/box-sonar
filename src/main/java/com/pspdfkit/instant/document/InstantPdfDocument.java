package com.pspdfkit.instant.document;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.instant.annotations.InstantAnnotationProvider;
import com.pspdfkit.instant.client.InstantClient;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 -2\u00020\u0001:\u0001-J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH&J\u000e\u0010\u0012\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H'J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\rH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u001f\u001a\u00020\u001dX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006.À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/instant/document/InstantPdfDocument;", "Lcom/pspdfkit/document/PdfDocument;", "getAnnotationProvider", "Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider;", "instantClient", "Lcom/pspdfkit/instant/client/InstantClient;", "getInstantClient", "()Lcom/pspdfkit/instant/client/InstantClient;", "instantDocumentDescriptor", "Lcom/pspdfkit/instant/client/InstantDocumentDescriptor;", "getInstantDocumentDescriptor", "()Lcom/pspdfkit/instant/client/InstantDocumentDescriptor;", "reauthenticateWithJwt", "", "jwt", "", "reauthenticateWithJwtAsync", "Lio/reactivex/rxjava3/core/Completable;", "syncAnnotations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncAnnotationsAsync", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/pspdfkit/instant/client/InstantProgress;", "addInstantDocumentListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/instant/listeners/InstantDocumentListener;", "removeInstantDocumentListener", "notifyConnectivityChanged", "isConnected", "", "removeLocalStorage", "isListeningToServerChanges", "()Z", "setListeningToServerChanges", "(Z)V", "delayForSyncingLocalChanges", "", "getDelayForSyncingLocalChanges", "()J", "setDelayForSyncingLocalChanges", "(J)V", "documentState", "Lcom/pspdfkit/instant/document/InstantDocumentState;", "getDocumentState", "()Lcom/pspdfkit/instant/document/InstantDocumentState;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface InstantPdfDocument extends PdfDocument {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final long SYNC_LOCAL_CHANGES_DISABLED = Long.MAX_VALUE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/instant/document/InstantPdfDocument$Companion;", "", "<init>", "()V", "SYNC_LOCAL_CHANGES_DISABLED", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long SYNC_LOCAL_CHANGES_DISABLED = Long.MAX_VALUE;

        private Companion() {
        }
    }

    void addInstantDocumentListener(InstantDocumentListener listener);

    @Override // com.pspdfkit.document.PdfDocument
    InstantAnnotationProvider getAnnotationProvider();

    long getDelayForSyncingLocalChanges();

    InstantDocumentState getDocumentState();

    InstantClient getInstantClient();

    InstantDocumentDescriptor getInstantDocumentDescriptor();

    boolean isListeningToServerChanges();

    void notifyConnectivityChanged(boolean isConnected);

    void reauthenticateWithJwt(String jwt);

    Completable reauthenticateWithJwtAsync(String jwt);

    void removeInstantDocumentListener(InstantDocumentListener listener);

    void removeLocalStorage();

    void setDelayForSyncingLocalChanges(long j);

    void setListeningToServerChanges(boolean z);

    Object syncAnnotations(Continuation<? super Unit> continuation);

    @Deprecated(message = "Use syncAnnotations() from a coroutine context instead", replaceWith = @ReplaceWith(expression = "syncAnnotations()", imports = {}))
    Flowable<InstantProgress> syncAnnotationsAsync();
}
