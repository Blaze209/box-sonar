package com.pspdfkit.document.library;

import androidx.core.util.Pair;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeDocumentDescriptor;
import com.pspdfkit.internal.jni.NativeDocumentLibrary;
import com.pspdfkit.internal.jni.NativeDocumentLibraryIndexStatusProgress;
import com.pspdfkit.internal.jni.NativeDocumentLibraryQuery;
import com.pspdfkit.internal.jni.NativeFTSVersion;
import com.pspdfkit.internal.jni.NativeLibraryDocumentDescriptor;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeThreadPriority;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\"\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010*\u001a\u00020\fJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003J\u001e\u0010.\u001a\u00020\u001a2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000%2\b\b\u0002\u00101\u001a\u000202J\u001e\u00103\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u0002050%2\b\b\u0002\u00101\u001a\u000202J*\u00106\u001a\u00020\u001a2\u0018\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000208070%2\b\b\u0002\u00101\u001a\u000202J,\u00109\u001a\u00020\u001a2\u001a\u00104\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u000108070%2\b\b\u0002\u00101\u001a\u000202J\u001e\u0010:\u001a\u00020\u001a2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0%2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010=\u001a\u00020\u001a2\b\b\u0002\u00101\u001a\u000202H\u0086@¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u0004\u0018\u0001052\u0006\u0010-\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u0004\u0018\u0001082\u0006\u0010-\u001a\u00020\u0003J\u0014\u0010B\u001a\u00020\u001a2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030%J\u0006\u0010D\u001a\u00020\u001aJ\u0006\u0010E\u001a\u00020\u001aJ\u000e\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u000fJ\u000e\u0010H\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\"\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030%8F¢\u0006\u0006\u001a\u0004\b)\u0010'¨\u0006K"}, d2 = {"Lcom/pspdfkit/document/library/PdfLibrary;", "", "path", "", "tokenizer", "Lcom/pspdfkit/document/library/PdfLibrary$TokenizerType;", "<init>", "(Ljava/lang/String;Lcom/pspdfkit/document/library/PdfLibrary$TokenizerType;)V", "nativeLibrary", "Lcom/pspdfkit/internal/jni/NativeDocumentLibrary;", "getNativeLibrary", "getLibraryObserverMappingSize", "", "libraryObserverMapping", "", "Lcom/pspdfkit/document/library/LibraryIndexingListener;", "Lcom/pspdfkit/document/library/LibraryObserverShim;", "dataSource", "Lcom/pspdfkit/document/library/LibraryDataSource;", "getDataSource", "()Lcom/pspdfkit/document/library/LibraryDataSource;", "setDataSource", "(Lcom/pspdfkit/document/library/LibraryDataSource;)V", "getSaveReverseText", "", "setSaveReverseText", "", "saveReverseText", "search", "searchString", "options", "Lcom/pspdfkit/document/library/QueryOptions;", "resultListener", "Lcom/pspdfkit/document/library/QueryResultListener;", "isIndexing", "()Z", "queuedUIDs", "", "getQueuedUIDs", "()Ljava/util/List;", "indexedUIDs", "getIndexedUIDs", "size", "getIndexStatusForUID", "Lcom/pspdfkit/document/library/LibraryIndexStatus;", "uid", "enqueueDocuments", "documents", "Lcom/pspdfkit/document/PdfDocument;", "indexingOptions", "Lcom/pspdfkit/document/library/IndexingOptions;", "enqueueDocumentSources", "documentSources", "Lcom/pspdfkit/document/DocumentSource;", "enqueueDocumentsWithMetadata", "Landroidx/core/util/Pair;", "", "enqueueDocumentSourcesWithMetadata", "coreUpdateIndex", "documentDescriptors", "Lcom/pspdfkit/internal/jni/NativeLibraryDocumentDescriptor;", "updateIndexFromDataSource", "(Lcom/pspdfkit/document/library/IndexingOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "indexedDocumentSourceWithUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetadataForUID", "removeDocuments", "documentUIDs", "clearIndex", "stopSearch", "addLibraryIndexingListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeLibraryIndexingListener", "TokenizerType", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PdfLibrary {
    private LibraryDataSource dataSource;
    private final Map<LibraryIndexingListener, LibraryObserverShim> libraryObserverMapping;
    private final NativeDocumentLibrary nativeLibrary;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/document/library/PdfLibrary$Companion;", "", "<init>", "()V", PasskeyWebListener.GET_UNIQUE_KEY, "Lcom/pspdfkit/document/library/PdfLibrary;", "path", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use constructor instead", replaceWith = @ReplaceWith(expression = "PdfLibrary(path)", imports = {}))
        @JvmStatic
        public final PdfLibrary get(String path) {
            path.getClass();
            return new PdfLibrary(path, null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<LibraryIndexStatus.Status> entries$0 = EnumEntriesKt.enumEntries(LibraryIndexStatus.Status.values());
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/library/PdfLibrary$TokenizerType;", "", "<init>", "(Ljava/lang/String;I)V", "PORTER", "UNICODE", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum TokenizerType {
        PORTER,
        UNICODE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<TokenizerType> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TokenizerType.values().length];
            try {
                iArr[TokenizerType.UNICODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.PdfLibrary$indexedDocumentSourceWithUid$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/pspdfkit/document/DocumentSource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.PdfLibrary$indexedDocumentSourceWithUid$2", f = "PdfLibrary.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DocumentSource>, Object> {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PdfLibrary.this.new AnonymousClass2(this.$uid, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LibraryDataSource dataSource = PdfLibrary.this.getDataSource();
            if (dataSource != null) {
                return dataSource.documentSourceForLibrary(this.$uid);
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DocumentSource> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2", f = "PdfLibrary.kt", i = {0, 0, 0, 0, 0, 0}, l = {495}, m = "invokeSuspend", n = {"$this$withContext", "uidsToRemove", "uidsToIndex", "documentSources", "completionDeferred", "tempListener"}, nl = {497}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    public static final class C18572 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LibraryDataSource $currentDataSource;
        final /* synthetic */ IndexingOptions $indexingOptions;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PdfLibrary this$0;

        /* JADX INFO: renamed from: com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2$2", f = "PdfLibrary.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, nl = {488}, s = {}, v = 2)
        public static final class C02492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CompletableDeferred<Unit> $completionDeferred;
            final /* synthetic */ PdfLibrary$updateIndexFromDataSource$2$tempListener$1 $tempListener;
            int label;
            final /* synthetic */ PdfLibrary this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02492(CompletableDeferred<Unit> completableDeferred, PdfLibrary pdfLibrary, PdfLibrary$updateIndexFromDataSource$2$tempListener$1 pdfLibrary$updateIndexFromDataSource$2$tempListener$1, Continuation<? super C02492> continuation) {
                super(2, continuation);
                this.$completionDeferred = completableDeferred;
                this.this$0 = pdfLibrary;
                this.$tempListener = pdfLibrary$updateIndexFromDataSource$2$tempListener$1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02492(this.$completionDeferred, this.this$0, this.$tempListener, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0 && i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                while (!this.$completionDeferred.isCompleted() && this.this$0.isIndexing()) {
                    this.label = 1;
                    if (DelayKt.delay(500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (!this.$completionDeferred.isCompleted() && !this.this$0.isIndexing()) {
                    this.this$0.removeLibraryIndexingListener(this.$tempListener);
                    this.$completionDeferred.complete(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18572(LibraryDataSource libraryDataSource, PdfLibrary pdfLibrary, IndexingOptions indexingOptions, Continuation<? super C18572> continuation) {
            super(2, continuation);
            this.$currentDataSource = libraryDataSource;
            this.this$0 = pdfLibrary;
            this.$indexingOptions = indexingOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18572 c18572 = new C18572(this.$currentDataSource, this.this$0, this.$indexingOptions, continuation);
            c18572.L$0 = obj;
            return c18572;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v0, types: [com.pspdfkit.document.library.LibraryIndexingListener, com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2$tempListener$1, java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$currentDataSource.libraryWillBeginIndexing();
                    List<String> listUidsOfDocumentsToBeRemovedFromLibrary = this.$currentDataSource.uidsOfDocumentsToBeRemovedFromLibrary();
                    if (!listUidsOfDocumentsToBeRemovedFromLibrary.isEmpty()) {
                        this.this$0.removeDocuments(listUidsOfDocumentsToBeRemovedFromLibrary);
                        LibraryDataSource libraryDataSource = this.$currentDataSource;
                        Iterator<T> it = listUidsOfDocumentsToBeRemovedFromLibrary.iterator();
                        while (it.hasNext()) {
                            libraryDataSource.libraryDidRemoveDocument((String) it.next());
                        }
                    }
                    List<String> listUidsOfDocumentsToBeIndexedByLibrary = this.$currentDataSource.uidsOfDocumentsToBeIndexedByLibrary();
                    ArrayList arrayList = new ArrayList();
                    for (String str : listUidsOfDocumentsToBeIndexedByLibrary) {
                        DocumentSource documentSourceDocumentSourceForLibrary = this.$currentDataSource.documentSourceForLibrary(str);
                        if (documentSourceDocumentSourceForLibrary != null) {
                            Boxing.boxBoolean(arrayList.add(documentSourceDocumentSourceForLibrary));
                        } else {
                            PdfLog.w("Nutri.PdfLibrary", "Data source returned null document source for UID: " + str, new Object[0]);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        final LibraryDataSource libraryDataSource2 = this.$currentDataSource;
                        final PdfLibrary pdfLibrary = this.this$0;
                        ?? r12 = new LibraryIndexingListener() { // from class: com.pspdfkit.document.library.PdfLibrary$updateIndexFromDataSource$2$tempListener$1
                            @Override // com.pspdfkit.document.library.LibraryIndexingListener
                            public boolean enableOnPageIndexedEvents() {
                                return false;
                            }

                            @Override // com.pspdfkit.document.library.LibraryIndexingListener
                            public void onFinishIndexingDocument(String uid, boolean success) {
                                uid.getClass();
                                LibraryDataSource libraryDataSource3 = libraryDataSource2;
                                PdfLibrary pdfLibrary2 = pdfLibrary;
                                CompletableDeferred<Unit> completableDeferred = completableDeferredCompletableDeferred$default;
                                synchronized (this) {
                                    libraryDataSource3.libraryDidFinishIndexingDocument(uid, success);
                                    if (!pdfLibrary2.isIndexing()) {
                                        pdfLibrary2.removeLibraryIndexingListener(this);
                                        completableDeferred.complete(Unit.INSTANCE);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                            }

                            @Override // com.pspdfkit.document.library.LibraryIndexingListener
                            public void onPageIndexed(String uid, int pageIndex, String pageText) {
                                uid.getClass();
                                pageText.getClass();
                            }

                            @Override // com.pspdfkit.document.library.LibraryIndexingListener
                            public void onStartIndexingDocument(String uid) {
                                uid.getClass();
                            }
                        };
                        this.this$0.addLibraryIndexingListener(r12);
                        this.this$0.enqueueDocumentSources(arrayList, this.$indexingOptions);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C02492(completableDeferredCompletableDeferred$default, this.this$0, r12, null), 3, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(listUidsOfDocumentsToBeRemovedFromLibrary);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(listUidsOfDocumentsToBeIndexedByLibrary);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(arrayList);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(r12);
                        this.label = 1;
                        if (completableDeferredCompletableDeferred$default.await(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                PdfLog.e("Nutri.PdfLibrary", "Error updating index from data source", e);
                throw e;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18572) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public PdfLibrary(String str, TokenizerType tokenizerType) throws IOException {
        str.getClass();
        if (!ar.b().a(NativeLicenseFeatures.INDEXED_FTS)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow usage of full-text search.");
        }
        NativeDocumentLibrary nativeDocumentLibraryCreate = NativeDocumentLibrary.create(str, null, null, NativeThreadPriority.VERY_LOW, (tokenizerType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[tokenizerType.ordinal()]) == 1 ? NativeDocumentLibrary.unicodeTokenizerName() : NativeDocumentLibrary.porterTokenizerName(), NativeFTSVersion.HIGHEST_AVAILABLE);
        if (nativeDocumentLibraryCreate == null) {
            throw new IOException("Could not initialize document library. Check the provided database path: " + str);
        }
        this.nativeLibrary = nativeDocumentLibraryCreate;
        this.libraryObserverMapping = new LinkedHashMap();
    }

    private final void coreUpdateIndex(List<NativeLibraryDocumentDescriptor> documentDescriptors, IndexingOptions indexingOptions) {
        this.nativeLibrary.enqueueDocumentDescriptors(new ArrayList<>(documentDescriptors), indexingOptions.createNativeEnqueueOptions$sdk_nutrient());
    }

    public static /* synthetic */ void enqueueDocumentSources$default(PdfLibrary pdfLibrary, List list, IndexingOptions indexingOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            indexingOptions = new IndexingOptions(false, false, 3, null);
        }
        pdfLibrary.enqueueDocumentSources(list, indexingOptions);
    }

    public static /* synthetic */ void enqueueDocumentSourcesWithMetadata$default(PdfLibrary pdfLibrary, List list, IndexingOptions indexingOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            indexingOptions = new IndexingOptions(false, false, 3, null);
        }
        pdfLibrary.enqueueDocumentSourcesWithMetadata(list, indexingOptions);
    }

    public static /* synthetic */ void enqueueDocuments$default(PdfLibrary pdfLibrary, List list, IndexingOptions indexingOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            indexingOptions = new IndexingOptions(false, false, 3, null);
        }
        pdfLibrary.enqueueDocuments(list, indexingOptions);
    }

    public static /* synthetic */ void enqueueDocumentsWithMetadata$default(PdfLibrary pdfLibrary, List list, IndexingOptions indexingOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            indexingOptions = new IndexingOptions(false, false, 3, null);
        }
        pdfLibrary.enqueueDocumentsWithMetadata(list, indexingOptions);
    }

    @Deprecated(message = "Use constructor instead", replaceWith = @ReplaceWith(expression = "PdfLibrary(path)", imports = {}))
    @JvmStatic
    public static final PdfLibrary get(String str) {
        return INSTANCE.get(str);
    }

    public static /* synthetic */ void search$default(PdfLibrary pdfLibrary, String str, QueryOptions queryOptions, QueryResultListener queryResultListener, int i, Object obj) {
        if ((i & 2) != 0) {
            queryOptions = null;
        }
        pdfLibrary.search(str, queryOptions, queryResultListener);
    }

    public static /* synthetic */ Object updateIndexFromDataSource$default(PdfLibrary pdfLibrary, IndexingOptions indexingOptions, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            indexingOptions = new IndexingOptions(false, false, 3, null);
        }
        return pdfLibrary.updateIndexFromDataSource(indexingOptions, continuation);
    }

    public final void addLibraryIndexingListener(LibraryIndexingListener listener) {
        listener.getClass();
        synchronized (this.libraryObserverMapping) {
            LibraryObserverShim libraryObserverShim = new LibraryObserverShim(listener);
            this.libraryObserverMapping.put(listener, libraryObserverShim);
            this.nativeLibrary.addIndexingObserver(libraryObserverShim);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIndex() {
        this.nativeLibrary.clearAllIndexes();
    }

    public final void enqueueDocumentSources(List<DocumentSource> documentSources, IndexingOptions indexingOptions) {
        documentSources.getClass();
        indexingOptions.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(documentSources, 10));
        Iterator<T> it = documentSources.iterator();
        while (it.hasNext()) {
            arrayList.add(new Pair((DocumentSource) it.next(), null));
        }
        enqueueDocumentSourcesWithMetadata(arrayList, indexingOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void enqueueDocumentSourcesWithMetadata(List<? extends Pair<DocumentSource, byte[]>> documentSources, IndexingOptions indexingOptions) {
        ArrayList arrayList;
        documentSources.getClass();
        indexingOptions.getClass();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = documentSources.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            DocumentSource documentSource = (DocumentSource) pair.first;
            byte[] bArr = (byte[]) pair.second;
            NativeDataDescriptor dataDescriptor = documentSource.toDataDescriptor();
            NativeLibraryDocumentDescriptor nativeLibraryDocumentDescriptor = null;
            if (dataDescriptor == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(dataDescriptor);
            }
            if (arrayList == null) {
                PdfLog.w("Nutri.PdfLibrary", "Failed to create data descriptor for document source with UID: " + documentSource.getUid() + ". Skipping this document.", new Object[0]);
            } else {
                nativeLibraryDocumentDescriptor = new NativeLibraryDocumentDescriptor(new NativeDocumentDescriptor(arrayList, null), bArr, null, documentSource.getUid());
            }
            if (nativeLibraryDocumentDescriptor != null) {
                arrayList2.add(nativeLibraryDocumentDescriptor);
            }
        }
        coreUpdateIndex(arrayList2, indexingOptions);
    }

    public final void enqueueDocuments(List<? extends PdfDocument> documents, IndexingOptions indexingOptions) {
        documents.getClass();
        indexingOptions.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(documents, 10));
        Iterator<T> it = documents.iterator();
        while (it.hasNext()) {
            arrayList.add(new Pair(((PdfDocument) it.next()).getDocumentSource(), null));
        }
        enqueueDocumentSourcesWithMetadata(arrayList, indexingOptions);
    }

    public final void enqueueDocumentsWithMetadata(List<? extends Pair<PdfDocument, byte[]>> documents, IndexingOptions indexingOptions) {
        documents.getClass();
        indexingOptions.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(documents, 10));
        Iterator<T> it = documents.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(new Pair(((PdfDocument) pair.first).getDocumentSource(), pair.second));
        }
        enqueueDocumentSourcesWithMetadata(arrayList, indexingOptions);
    }

    public final LibraryDataSource getDataSource() {
        return this.dataSource;
    }

    public final LibraryIndexStatus getIndexStatusForUID(String uid) {
        uid.getClass();
        NativeDocumentLibraryIndexStatusProgress nativeDocumentLibraryIndexStatusProgressIndexStatus = this.nativeLibrary.indexStatus(uid);
        nativeDocumentLibraryIndexStatusProgressIndexStatus.getClass();
        return new LibraryIndexStatus(EntriesMappings.entries$0.get(nativeDocumentLibraryIndexStatusProgressIndexStatus.getIndexStatus().ordinal()), nativeDocumentLibraryIndexStatusProgressIndexStatus.getProgress());
    }

    public final List<String> getIndexedUIDs() {
        ArrayList<String> arrayListIndexedUids = this.nativeLibrary.indexedUids();
        return arrayListIndexedUids != null ? arrayListIndexedUids : CollectionsKt.emptyList();
    }

    public final int getLibraryObserverMappingSize() {
        return this.libraryObserverMapping.size();
    }

    public final byte[] getMetadataForUID(String uid) {
        uid.getClass();
        return this.nativeLibrary.metadataForUid(uid);
    }

    public final NativeDocumentLibrary getNativeLibrary() {
        return this.nativeLibrary;
    }

    public final List<String> getQueuedUIDs() {
        ArrayList<String> arrayListQueuedUids = this.nativeLibrary.queuedUids();
        arrayListQueuedUids.getClass();
        return arrayListQueuedUids;
    }

    public final boolean getSaveReverseText() {
        return this.nativeLibrary.saveReversedText();
    }

    public final Object indexedDocumentSourceWithUid(String str, Continuation<? super DocumentSource> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, null), continuation);
    }

    public final boolean isIndexing() {
        return this.nativeLibrary.isIndexing();
    }

    public final void removeDocuments(List<String> documentUIDs) {
        documentUIDs.getClass();
        this.nativeLibrary.removeDocuments(documentUIDs instanceof ArrayList ? (ArrayList) documentUIDs : new ArrayList<>(documentUIDs));
    }

    public final void removeLibraryIndexingListener(LibraryIndexingListener listener) {
        listener.getClass();
        synchronized (this.libraryObserverMapping) {
            LibraryObserverShim libraryObserverShim = this.libraryObserverMapping.get(listener);
            if (libraryObserverShim != null) {
                this.nativeLibrary.removeIndexingObserver(libraryObserverShim);
                this.libraryObserverMapping.remove(listener);
            }
        }
    }

    public final void search(String searchString, QueryOptions options, QueryResultListener resultListener) {
        QueryOptions queryOptionsBuild;
        searchString.getClass();
        resultListener.getClass();
        if (options == null) {
            queryOptionsBuild = new QueryOptions.Builder().build();
            queryOptionsBuild.getClass();
        } else {
            queryOptionsBuild = options;
        }
        PdfLibrary$search$handler$1 pdfLibrary$search$handler$1 = new PdfLibrary$search$handler$1(resultListener);
        this.nativeLibrary.query(new NativeDocumentLibraryQuery(searchString, queryOptionsBuild.shouldIgnoreAnnotations(), queryOptionsBuild.shouldIgnoreDocumentText(), queryOptionsBuild.shouldMatchExactPhrases(), queryOptionsBuild.shouldMatchExactWords(), queryOptionsBuild.getMaximumSearchResultsPerDocument(), queryOptionsBuild.getMaximumSearchResultsTotal(), queryOptionsBuild.getMaximumPreviewResultsPerDocument(), queryOptionsBuild.getMaximumPreviewResultsTotal(), queryOptionsBuild.shouldGenerateTextPreviews(), queryOptionsBuild.getPreviewRange()), pdfLibrary$search$handler$1);
    }

    public final void setDataSource(LibraryDataSource libraryDataSource) {
        this.dataSource = libraryDataSource;
    }

    public final void setSaveReverseText(boolean saveReverseText) {
        this.nativeLibrary.setSaveReversedText(saveReverseText);
    }

    public final int size() {
        return this.nativeLibrary.indexedUidCount();
    }

    public final void stopSearch() {
        this.nativeLibrary.cancelAllPreviewTextOperations();
    }

    public final Object updateIndexFromDataSource(IndexingOptions indexingOptions, Continuation<? super Unit> continuation) {
        LibraryDataSource libraryDataSource = this.dataSource;
        if (libraryDataSource == null) {
            throw new IllegalStateException("Cannot update index from data source: no data source is set");
        }
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C18572(libraryDataSource, this, indexingOptions, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public /* synthetic */ PdfLibrary(String str, TokenizerType tokenizerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : tokenizerType);
    }
}
