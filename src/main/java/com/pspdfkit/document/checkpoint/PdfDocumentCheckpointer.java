package com.pspdfkit.document.checkpoint;

import android.content.Context;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.u40;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.x8;
import com.pspdfkit.internal.yz;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDocumentCheckpointer {
    private static final String EXTENSION = "pscpt";
    private static final String LOG_TAG = "Nutri.PdfDocCheckpoint";
    private final File checkpointDir;
    private final AtomicBoolean checkpointExistsInMemory;
    private final File checkpointFile;
    private final String checkpointFolderPath;
    private final AtomicBoolean dirty;
    private final lm document;
    private final long maxAllowedCheckpointAgeMs;
    private final AtomicBoolean saving;
    private PdfDocumentCheckpointingStrategy strategy;
    private final long timedCheckpointIntervalMs;
    private Disposable timedStrategyDisposable;

    public PdfDocumentCheckpointer(lm lmVar, File file, x8 x8Var, boolean z) {
        this.document = lmVar;
        this.checkpointFile = file;
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IllegalStateException("Can't find checkpoint file parent directory: " + file.getPath());
        }
        this.checkpointDir = parentFile;
        this.strategy = PdfDocumentCheckpointingStrategy.MANUAL;
        x8Var.getClass();
        this.timedCheckpointIntervalMs = 30000L;
        this.checkpointFolderPath = "PSPDFDocumentCheckpoints";
        this.maxAllowedCheckpointAgeMs = 604800000L;
        new Thread(new Runnable() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        }).start();
        this.dirty = new AtomicBoolean(false);
        this.saving = new AtomicBoolean(false);
        this.checkpointExistsInMemory = new AtomicBoolean(z);
    }

    private int cleanStaleCheckpoints() {
        if (this.checkpointDir.exists() && !this.checkpointDir.isDirectory()) {
            throw new AssertionError("Abstract pathname denoted by checkpoint folder must be a directory.");
        }
        synchronized (this) {
            if (!this.checkpointDir.exists()) {
                return 0;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.maxAllowedCheckpointAgeMs;
            int i = 0;
            for (File file : this.checkpointDir.listFiles()) {
                if (!this.checkpointFile.getPath().equals(file.getPath()) && file.lastModified() < jCurrentTimeMillis && file.delete()) {
                    i++;
                }
            }
            return i;
        }
    }

    private static File generateCheckpointPath(Context context, String str, String str2) {
        File filesDir = context.getFilesDir();
        try {
            str = u40.c(str);
        } catch (NoSuchAlgorithmException unused) {
        }
        File file = new File(filesDir, String.format(nv.a(new StringBuilder().append(str2), File.separator, "%s.pscpt"), str));
        PdfLog.d(LOG_TAG, "Generated checkpoint path %s.", file.getPath());
        return file;
    }

    public static boolean isCheckpointSupported(DocumentSource documentSource) {
        if (documentSource.getPassword() == null) {
            return documentSource.getDataProvider() == null || documentSource.getDataProvider().getUid() != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$deleteCheckpointAsync$7() throws Exception {
        PdfLog.d(LOG_TAG, "Deleting checkpoint file at %s", this.checkpointFile.getPath());
        boolean zDelete = this.checkpointFile.delete();
        this.checkpointExistsInMemory.set(false);
        return Boolean.valueOf(zDelete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        int iCleanStaleCheckpoints = cleanStaleCheckpoints();
        if (iCleanStaleCheckpoints > 0) {
            PdfLog.d(LOG_TAG, iCleanStaleCheckpoints + " checkpoints cleaned.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveCheckpointAsync$2(Disposable disposable) throws Throwable {
        this.saving.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean lambda$saveCheckpointAsync$3(Boolean bool) throws Throwable {
        if (!bool.booleanValue()) {
            PdfLog.d(LOG_TAG, "Latest changes already saved.", new Object[0]);
            return Boolean.FALSE;
        }
        PdfLog.d(LOG_TAG, "Saving checkpoint to file %s.", this.checkpointFile.getPath());
        if (!this.checkpointDir.exists()) {
            PdfLog.d(LOG_TAG, "Creating %s folder.", this.checkpointFolderPath);
            this.checkpointDir.mkdir();
        }
        this.document.y.saveCheckpoint(this.checkpointFile.getPath());
        this.checkpointExistsInMemory.set(true);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveCheckpointAsync$6() throws Throwable {
        this.saving.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$setTimedStrategy$1(Long l) throws Throwable {
        return saveCheckpointAsync();
    }

    private void performImmediateSaveChanges() {
        Single<Boolean> singleSaveCheckpointAsync = saveCheckpointAsync();
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        singleSaveCheckpointAsync.subscribeOn(schedulerIo).subscribe();
    }

    public static List<DocumentSource> setCheckpointPath(Context context, DocumentSource documentSource, String str) {
        File fileGenerateCheckpointPath = generateCheckpointPath(context, documentSource.getUid(), str);
        boolean z = fileGenerateCheckpointPath.exists() && fileGenerateCheckpointPath.isFile();
        if (z) {
            PdfLog.d(LOG_TAG, "Found valid pre-existing checkpoint.", new Object[0]);
        }
        return Collections.singletonList(new DocumentSource(documentSource, fileGenerateCheckpointPath, z));
    }

    private void setTimedStrategy() {
        Observable<Long> observableInterval = Observable.interval(this.timedCheckpointIntervalMs, TimeUnit.MILLISECONDS);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        this.timedStrategyDisposable = observableInterval.observeOn(schedulerIo).flatMapSingle(new Function() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$setTimedStrategy$1((Long) obj);
            }
        }).subscribe();
    }

    public boolean checkpointExists() {
        return this.checkpointExistsInMemory.get();
    }

    public void deleteAllCheckpoints() {
        if (this.checkpointDir.exists()) {
            if (!this.checkpointDir.isDirectory()) {
                throw new AssertionError("The file denoted by the checkpoint folder pathname is not a directory.");
            }
            int i = 0;
            for (File file : this.checkpointDir.listFiles()) {
                if (file.delete()) {
                    i++;
                }
            }
            if (i > 0) {
                PdfLog.d(LOG_TAG, i + " checkpoints deleted.", new Object[0]);
            }
        }
    }

    public boolean deleteCheckpoint() {
        return deleteCheckpointAsync().blockingGet().booleanValue();
    }

    public Single<Boolean> deleteCheckpointAsync() {
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$deleteCheckpointAsync$7();
            }
        }).doOnError(new Consumer() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.e(PdfDocumentCheckpointer.LOG_TAG, "Error when deleting checkpoint file." + ((Throwable) obj).getMessage(), new Object[0]);
            }
        }).doOnSuccess(new Consumer() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda10
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.d(PdfDocumentCheckpointer.LOG_TAG, nv.a(new StringBuilder("Checkpoint file "), ((Boolean) obj).booleanValue() ? "" : "not ", "deleted."), new Object[0]);
            }
        });
    }

    public void documentSavedSuccessfully() {
        PdfLog.d(LOG_TAG, "Document saved successfully.", new Object[0]);
        this.dirty.set(false);
        deleteCheckpoint();
    }

    public PdfDocumentCheckpointingStrategy getStrategy() {
        return this.strategy;
    }

    public boolean isDirty() {
        return this.dirty.get();
    }

    public boolean isSaving() {
        return this.saving.get();
    }

    public void onDocumentModified() {
        PdfLog.d(LOG_TAG, "Document modified.", new Object[0]);
        this.dirty.set(true);
        if (this.strategy.equals(PdfDocumentCheckpointingStrategy.IMMEDIATE)) {
            performImmediateSaveChanges();
        }
    }

    public boolean saveCheckpoint() {
        return saveCheckpointAsync().blockingGet().booleanValue();
    }

    public Single<Boolean> saveCheckpointAsync() {
        final AtomicBoolean atomicBoolean = this.dirty;
        Objects.requireNonNull(atomicBoolean);
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Boolean.valueOf(atomicBoolean.get());
            }
        }).doOnSubscribe(new Consumer() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$saveCheckpointAsync$2((Disposable) obj);
            }
        }).map(new Function() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$saveCheckpointAsync$3((Boolean) obj);
            }
        }).doOnSuccess(new Consumer() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.d(PdfDocumentCheckpointer.LOG_TAG, "Checkpoint %s", ((Boolean) obj).booleanValue() ? "was saved." : "not saved.");
            }
        }).doOnError(new Consumer() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda5
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.e(PdfDocumentCheckpointer.LOG_TAG, "Error when saving the checkpoint " + ((Throwable) obj).getMessage(), new Object[0]);
            }
        }).doFinally(new Action() { // from class: com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer$$ExternalSyntheticLambda6
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$saveCheckpointAsync$6();
            }
        });
    }

    public void setStrategy(PdfDocumentCheckpointingStrategy pdfDocumentCheckpointingStrategy) {
        uw.a(pdfDocumentCheckpointingStrategy, "strategy", null);
        if (this.strategy.equals(pdfDocumentCheckpointingStrategy)) {
            return;
        }
        this.strategy = pdfDocumentCheckpointingStrategy;
        boolean zEquals = pdfDocumentCheckpointingStrategy.equals(PdfDocumentCheckpointingStrategy.TIMED);
        Disposable disposable = this.timedStrategyDisposable;
        if (!zEquals) {
            yz.a(disposable);
            this.timedStrategyDisposable = null;
        } else if (disposable == null || disposable.isDisposed()) {
            setTimedStrategy();
        }
        if (pdfDocumentCheckpointingStrategy.equals(PdfDocumentCheckpointingStrategy.IMMEDIATE)) {
            performImmediateSaveChanges();
        }
    }
}
