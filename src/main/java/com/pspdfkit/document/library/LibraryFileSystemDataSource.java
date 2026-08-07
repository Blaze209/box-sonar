package com.pspdfkit.document.library;

import android.net.Uri;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.utils.PdfLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J\u0010\u0010'\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\bH\u0002J\u000e\u0010+\u001a\u00020$H\u0082@¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020$H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u0013J\b\u00100\u001a\u00020$H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u001302H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001302H\u0016J\u0012\u00104\u001a\u0004\u0018\u00010\b2\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0018\u00105\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00132\u0006\u00106\u001a\u00020\tH\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0013H\u0016J\u0006\u00108\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/pspdfkit/document/library/LibraryFileSystemDataSource;", "Lcom/pspdfkit/document/library/LibraryDataSource;", "library", "Lcom/pspdfkit/document/library/PdfLibrary;", "documentsDirectory", "Ljava/io/File;", "documentHandler", "Lkotlin/Function1;", "Lcom/pspdfkit/document/DocumentSource;", "", "<init>", "(Lcom/pspdfkit/document/library/PdfLibrary;Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "libraryRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "scope", "Lkotlinx/coroutines/CoroutineScope;", "indexedItems", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/pspdfkit/document/library/FileIndexItemDescriptor;", "pendingItems", "itemsToBeRemoved", "skipHiddenFiles", "allowedPathExtensions", "", "getAllowedPathExtensions", "()Ljava/util/Set;", "setAllowedPathExtensions", "(Ljava/util/Set;)V", "isExplicitModeEnabled", "()Z", "setExplicitModeEnabled", "(Z)V", "isEnumeratingDirectory", "didAddOrModifyDocumentAtPath", "", "file", "didRemoveDocumentAtPath", "isValidDocumentFile", "getRelativePath", "createFileIndexItemDescriptor", "documentSource", "selectDocumentFiles", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateIndexedItemsFromLibrary", "indexItemDescriptorForDocumentWithUid", "uid", "libraryWillBeginIndexing", "uidsOfDocumentsToBeIndexedByLibrary", "", "uidsOfDocumentsToBeRemovedFromLibrary", "documentSourceForLibrary", "libraryDidFinishIndexingDocument", "success", "libraryDidRemoveDocument", "cleanup", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LibraryFileSystemDataSource implements LibraryDataSource {
    public static final int $stable = 8;
    private Set<String> allowedPathExtensions;
    private Function1<? super DocumentSource, Boolean> documentHandler;
    private final File documentsDirectory;
    private final ConcurrentHashMap<String, FileIndexItemDescriptor> indexedItems;
    private volatile boolean isEnumeratingDirectory;
    private boolean isExplicitModeEnabled;
    private final ConcurrentHashMap<String, FileIndexItemDescriptor> itemsToBeRemoved;
    private final WeakReference<PdfLibrary> libraryRef;
    private final ConcurrentHashMap<String, FileIndexItemDescriptor> pendingItems;
    private final CoroutineScope scope;
    private final boolean skipHiddenFiles;

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$didAddOrModifyDocumentAtPath$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$didAddOrModifyDocumentAtPath$1", f = "LibraryFileSystemDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new AnonymousClass1(this.$file, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (LibraryFileSystemDataSource.this.isValidDocumentFile(this.$file)) {
                String absolutePath = this.$file.getAbsolutePath();
                absolutePath.getClass();
                String absolutePath2 = LibraryFileSystemDataSource.this.documentsDirectory.getAbsolutePath();
                absolutePath2.getClass();
                if (StringsKt.startsWith$default(absolutePath, absolutePath2, false, 2, (Object) null)) {
                    try {
                        DocumentSource documentSource = new DocumentSource(Uri.fromFile(this.$file));
                        Function1 function1 = LibraryFileSystemDataSource.this.documentHandler;
                        if (function1 != null ? ((Boolean) function1.invoke(documentSource)).booleanValue() : true) {
                            FileIndexItemDescriptor fileIndexItemDescriptorCreateFileIndexItemDescriptor = LibraryFileSystemDataSource.this.createFileIndexItemDescriptor(this.$file, documentSource);
                            LibraryFileSystemDataSource.this.pendingItems.put(fileIndexItemDescriptorCreateFileIndexItemDescriptor.getDocumentUid(), fileIndexItemDescriptorCreateFileIndexItemDescriptor);
                            LibraryFileSystemDataSource.this.updateIndexedItemsFromLibrary();
                        }
                    } catch (Exception e) {
                        PdfLog.e("LibraryFileSystemDataSource", "Error processing document: " + this.$file.getAbsolutePath(), e);
                    }
                    return Unit.INSTANCE;
                }
            }
            PdfLog.w("LibraryFileSystemDataSource", "Ignoring invalid explicit mode file: " + this.$file.getAbsolutePath(), new Object[0]);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$didRemoveDocumentAtPath$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$didRemoveDocumentAtPath$1", f = "LibraryFileSystemDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class C18531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18531(File file, Continuation<? super C18531> continuation) {
            super(2, continuation);
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new C18531(this.$file, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String relativePath = LibraryFileSystemDataSource.this.getRelativePath(this.$file);
            Collection collectionValues = LibraryFileSystemDataSource.this.indexedItems.values();
            collectionValues.getClass();
            Iterator it = collectionValues.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((FileIndexItemDescriptor) next).getDocumentPath(), relativePath));
            FileIndexItemDescriptor fileIndexItemDescriptor = (FileIndexItemDescriptor) next;
            if (fileIndexItemDescriptor != null) {
                LibraryFileSystemDataSource.this.pendingItems.remove(fileIndexItemDescriptor.getDocumentUid());
                LibraryFileSystemDataSource.this.itemsToBeRemoved.put(fileIndexItemDescriptor.getDocumentUid(), fileIndexItemDescriptor);
                LibraryFileSystemDataSource.this.updateIndexedItemsFromLibrary();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryDidFinishIndexingDocument$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryDidFinishIndexingDocument$1", f = "LibraryFileSystemDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class C18541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18541(String str, boolean z, Continuation<? super C18541> continuation) {
            super(2, continuation);
            this.$uid = str;
            this.$success = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new C18541(this.$uid, this.$success, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FileIndexItemDescriptor fileIndexItemDescriptor = (FileIndexItemDescriptor) LibraryFileSystemDataSource.this.pendingItems.remove(this.$uid);
            if (fileIndexItemDescriptor != null && this.$success) {
                LibraryFileSystemDataSource.this.indexedItems.put(this.$uid, fileIndexItemDescriptor);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryDidRemoveDocument$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryDidRemoveDocument$1", f = "LibraryFileSystemDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class C18551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18551(String str, Continuation<? super C18551> continuation) {
            super(2, continuation);
            this.$uid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new C18551(this.$uid, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LibraryFileSystemDataSource.this.indexedItems.remove(this.$uid);
            LibraryFileSystemDataSource.this.itemsToBeRemoved.remove(this.$uid);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryWillBeginIndexing$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$libraryWillBeginIndexing$1", f = "LibraryFileSystemDataSource.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, nl = {239}, s = {}, v = 2)
    public static final class C18561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C18561(Continuation<? super C18561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new C18561(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LibraryFileSystemDataSource libraryFileSystemDataSource = LibraryFileSystemDataSource.this;
                this.label = 1;
                if (libraryFileSystemDataSource.selectDocumentFiles(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.LibraryFileSystemDataSource$selectDocumentFiles$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.LibraryFileSystemDataSource$selectDocumentFiles$2", f = "LibraryFileSystemDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LibraryFileSystemDataSource.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LibraryFileSystemDataSource libraryFileSystemDataSource = LibraryFileSystemDataSource.this;
            synchronized (libraryFileSystemDataSource) {
                if (libraryFileSystemDataSource.isEnumeratingDirectory) {
                    return Unit.INSTANCE;
                }
                libraryFileSystemDataSource.isEnumeratingDirectory = true;
                Unit unit = Unit.INSTANCE;
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    FileTreeWalk fileTreeWalkWalkTopDown = FilesKt.walkTopDown(LibraryFileSystemDataSource.this.documentsDirectory);
                    final LibraryFileSystemDataSource libraryFileSystemDataSource2 = LibraryFileSystemDataSource.this;
                    Sequence<File> sequenceFilter = SequencesKt.filter(fileTreeWalkWalkTopDown, new Function1() { // from class: com.pspdfkit.document.library.LibraryFileSystemDataSource$selectDocumentFiles$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(LibraryFileSystemDataSource.access$isValidDocumentFile(libraryFileSystemDataSource2, (File) obj2));
                        }
                    });
                    LibraryFileSystemDataSource libraryFileSystemDataSource3 = LibraryFileSystemDataSource.this;
                    for (File file : sequenceFilter) {
                        try {
                            DocumentSource documentSource = new DocumentSource(Uri.fromFile(file));
                            Function1 function1 = libraryFileSystemDataSource3.documentHandler;
                            if (function1 != null ? ((Boolean) function1.invoke(documentSource)).booleanValue() : true) {
                                FileIndexItemDescriptor fileIndexItemDescriptorCreateFileIndexItemDescriptor = libraryFileSystemDataSource3.createFileIndexItemDescriptor(file, documentSource);
                                linkedHashMap.put(fileIndexItemDescriptorCreateFileIndexItemDescriptor.getDocumentUid(), fileIndexItemDescriptorCreateFileIndexItemDescriptor);
                            }
                        } catch (Exception e) {
                            PdfLog.w("LibraryFileSystemDataSource", "Skipping invalid document: " + file.getAbsolutePath(), e);
                        }
                    }
                    LibraryFileSystemDataSource.this.pendingItems.clear();
                    LibraryFileSystemDataSource libraryFileSystemDataSource4 = LibraryFileSystemDataSource.this;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        FileIndexItemDescriptor fileIndexItemDescriptor = (FileIndexItemDescriptor) entry.getValue();
                        if (!libraryFileSystemDataSource4.indexedItems.containsKey(str)) {
                            libraryFileSystemDataSource4.pendingItems.put(str, fileIndexItemDescriptor);
                        }
                    }
                    if (!LibraryFileSystemDataSource.this.getIsExplicitModeEnabled()) {
                        LibraryFileSystemDataSource.this.itemsToBeRemoved.clear();
                        ConcurrentHashMap concurrentHashMap = LibraryFileSystemDataSource.this.indexedItems;
                        LibraryFileSystemDataSource libraryFileSystemDataSource5 = LibraryFileSystemDataSource.this;
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            String str2 = (String) entry2.getKey();
                            FileIndexItemDescriptor fileIndexItemDescriptor2 = (FileIndexItemDescriptor) entry2.getValue();
                            if (!linkedHashMap.containsKey(str2)) {
                                libraryFileSystemDataSource5.itemsToBeRemoved.put(str2, fileIndexItemDescriptor2);
                            }
                        }
                    }
                    LibraryFileSystemDataSource.this.updateIndexedItemsFromLibrary();
                    LibraryFileSystemDataSource.this.isEnumeratingDirectory = false;
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    LibraryFileSystemDataSource.this.isEnumeratingDirectory = false;
                    throw th;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public LibraryFileSystemDataSource(PdfLibrary pdfLibrary, File file, Function1<? super DocumentSource, Boolean> function1) {
        pdfLibrary.getClass();
        file.getClass();
        this.documentsDirectory = file;
        this.documentHandler = function1;
        this.libraryRef = new WeakReference<>(pdfLibrary);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.indexedItems = new ConcurrentHashMap<>();
        this.pendingItems = new ConcurrentHashMap<>();
        this.itemsToBeRemoved = new ConcurrentHashMap<>();
        this.skipHiddenFiles = true;
        this.allowedPathExtensions = SetsKt.setOf("pdf");
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException("LibraryFileSystemDataSource requires the specified path (" + file.getAbsolutePath() + ") to be a directory");
    }

    public static final /* synthetic */ boolean access$isValidDocumentFile(LibraryFileSystemDataSource libraryFileSystemDataSource, File file) {
        return libraryFileSystemDataSource.isValidDocumentFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileIndexItemDescriptor createFileIndexItemDescriptor(File file, DocumentSource documentSource) {
        String relativePath = getRelativePath(file);
        String uid = documentSource.getUid();
        uid.getClass();
        return new FileIndexItemDescriptor(relativePath, uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRelativePath(File file) {
        String absolutePath = this.documentsDirectory.getAbsolutePath();
        String absolutePath2 = file.getAbsolutePath();
        absolutePath2.getClass();
        absolutePath.getClass();
        if (StringsKt.startsWith$default(absolutePath2, absolutePath, false, 2, (Object) null)) {
            return absolutePath2.substring(absolutePath.length() + 1);
        }
        String name = file.getName();
        name.getClass();
        return name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidDocumentFile(File file) {
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        Set<String> set = this.allowedPathExtensions;
        if (set != null && !set.isEmpty()) {
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            if (!set.contains(lowerCase)) {
                return false;
            }
        }
        return (this.skipHiddenFiles && file.isHidden()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object selectDocumentFiles(Continuation<? super Unit> continuation) {
        Object objWithContext;
        return (!this.isExplicitModeEnabled && (objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIndexedItemsFromLibrary() {
        PdfLibrary pdfLibrary = this.libraryRef.get();
        if (pdfLibrary == null) {
            return;
        }
        final Set set = CollectionsKt.toSet(pdfLibrary.getIndexedUIDs());
        Set<Map.Entry<String, FileIndexItemDescriptor>> setEntrySet = this.indexedItems.entrySet();
        setEntrySet.getClass();
        CollectionsKt.removeAll(setEntrySet, new Function1() { // from class: com.pspdfkit.document.library.LibraryFileSystemDataSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LibraryFileSystemDataSource.updateIndexedItemsFromLibrary$lambda$0(set, (Map.Entry) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateIndexedItemsFromLibrary$lambda$0(Set set, Map.Entry entry) {
        entry.getClass();
        Object key = entry.getKey();
        key.getClass();
        return !set.contains((String) key);
    }

    public final void cleanup() {
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    public final void didAddOrModifyDocumentAtPath(File file) {
        file.getClass();
        if (!this.isExplicitModeEnabled) {
            throw new IllegalStateException("didAddOrModifyDocumentAtPath can only be called when explicitModeEnabled is true");
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(file, null), 3, null);
    }

    public final void didRemoveDocumentAtPath(File file) {
        file.getClass();
        if (!this.isExplicitModeEnabled) {
            throw new IllegalStateException("didRemoveDocumentAtPath can only be called when explicitModeEnabled is true");
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C18531(file, null), 3, null);
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public DocumentSource documentSourceForLibrary(String uid) {
        uid.getClass();
        FileIndexItemDescriptor fileIndexItemDescriptorIndexItemDescriptorForDocumentWithUid = indexItemDescriptorForDocumentWithUid(uid);
        if (fileIndexItemDescriptorIndexItemDescriptorForDocumentWithUid == null) {
            return null;
        }
        File file = new File(this.documentsDirectory, fileIndexItemDescriptorIndexItemDescriptorForDocumentWithUid.getDocumentPath());
        if (file.exists()) {
            return new DocumentSource(Uri.fromFile(file));
        }
        return null;
    }

    public final Set<String> getAllowedPathExtensions() {
        return this.allowedPathExtensions;
    }

    public final FileIndexItemDescriptor indexItemDescriptorForDocumentWithUid(String uid) {
        uid.getClass();
        FileIndexItemDescriptor fileIndexItemDescriptor = this.pendingItems.get(uid);
        return fileIndexItemDescriptor == null ? this.indexedItems.get(uid) : fileIndexItemDescriptor;
    }

    /* JADX INFO: renamed from: isExplicitModeEnabled, reason: from getter */
    public final boolean getIsExplicitModeEnabled() {
        return this.isExplicitModeEnabled;
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public void libraryDidFinishIndexingDocument(String uid, boolean success) {
        uid.getClass();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C18541(uid, success, null), 3, null);
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public void libraryDidRemoveDocument(String uid) {
        uid.getClass();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C18551(uid, null), 3, null);
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public void libraryWillBeginIndexing() throws InterruptedException {
        BuildersKt__BuildersKt.runBlocking$default(null, new C18561(null), 1, null);
    }

    public final void setAllowedPathExtensions(Set<String> set) {
        this.allowedPathExtensions = set;
    }

    public final void setExplicitModeEnabled(boolean z) {
        this.isExplicitModeEnabled = z;
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public List<String> uidsOfDocumentsToBeIndexedByLibrary() {
        Set<String> setKeySet = this.pendingItems.keySet();
        setKeySet.getClass();
        return CollectionsKt.toList(setKeySet);
    }

    @Override // com.pspdfkit.document.library.LibraryDataSource
    public List<String> uidsOfDocumentsToBeRemovedFromLibrary() {
        Set<String> setKeySet = this.itemsToBeRemoved.keySet();
        setKeySet.getClass();
        return CollectionsKt.toList(setKeySet);
    }

    public /* synthetic */ LibraryFileSystemDataSource(PdfLibrary pdfLibrary, File file, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pdfLibrary, file, (i & 4) != 0 ? null : function1);
    }
}
