package com.box.android.preview.preview;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: PreviewReducerScoping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a!\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001\u001a3\u0010\t\u001a\u001f\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001\u001a3\u0010\f\u001a\u001f\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001\u001a3\u0010\u000f\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001\u001a3\u0010\u0012\u001a\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001\u001a:\u0010\f\u001a\u001f\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b\u0017\u001a:\u0010\u0012\u001a\u001f\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b\u0018\u001a:\u0010\u0019\u001a\u001f\u0012\u0004\u0012\u00020\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b\u001c\u001a:\u0010\u000f\u001a\u001f\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b\u001d\u001a:\u0010\u001e\u001a\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b!\u001a:\u0010\"\u001a\u001f\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110$¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b%\u001a:\u0010&\u001a\u001f\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0018\u00010\u0001*\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0001H\u0007¢\u0006\u0002\b)¨\u0006*"}, d2 = {"searchScope", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "Lkotlin/ParameterName;", "name", Analytics.Data.ACTION, "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "autoCompleteInputScope", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "documentStore", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$State;", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "videoStore", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "imageStore", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$State;", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "itemDocumentStore", "itemImageStore", "gifStore", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "itemGifStore", "itemVideoStore", "codeStore", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "itemCodeStore", "audioStore", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "itemAudioStore", "boxNoteStore", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "itemBoxNoteStore", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewReducerScopingKt {
    public static final Store<DocumentSearchReducer.State, DocumentSearchReducer.Action> searchScope(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> storeDocumentStore = documentStore(store);
        if (storeDocumentStore != null) {
            return storeDocumentStore.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.searchScope.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((DocumentPreviewReducer.State) obj).getSearchState();
                }
            }, C16952.INSTANCE);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$searchScope$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16952 extends FunctionReferenceImpl implements Function1<DocumentSearchReducer.Action, DocumentPreviewReducer.Action.Search> {
        public static final C16952 INSTANCE = new C16952();

        C16952() {
            super(1, DocumentPreviewReducer.Action.Search.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentPreviewReducer.Action.Search invoke(DocumentSearchReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentPreviewReducer.Action.Search(p0);
        }
    }

    public static final Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> autoCompleteInputScope(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Store<LocalState, LocalAction> storeScope;
        Store storeIfScope;
        Store<LocalState, LocalAction> storeIfScope2;
        Store<LocalState, LocalAction> storeIfScope3;
        Store<CommentWithMentionsReducer.State, CommentWithMentionsReducer.Action> storeScope2;
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> storeDocumentStore = documentStore(store);
        if (storeDocumentStore != null && (storeIfScope3 = storeDocumentStore.ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((DocumentPreviewReducer.State) obj).getCreateAnnotationState();
            }
        }, AnonymousClass2.INSTANCE)) != 0 && (storeScope2 = storeIfScope3.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CreateAnnotationReducer.State) obj).getCommentWithMentionsState();
            }
        }, AnonymousClass4.INSTANCE)) != null) {
            return storeScope2;
        }
        Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> storeImageStore = imageStore(store);
        if (storeImageStore != null && (storeIfScope2 = storeImageStore.ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ImagePreviewReducer.State) obj).getCreateAnnotationState();
            }
        }, AnonymousClass6.INSTANCE)) != 0) {
            return storeIfScope2.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.7
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((CreateAnnotationReducer.State) obj).getCommentWithMentionsState();
                }
            }, AnonymousClass8.INSTANCE);
        }
        Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> storeVideoStore = videoStore(store);
        if (storeVideoStore == null || (storeScope = storeVideoStore.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.9
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((VideoPreviewReducer.State) obj).getFrameAnnotationState();
            }
        }, AnonymousClass10.INSTANCE)) == 0 || (storeIfScope = storeScope.ifScope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.11
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((FrameAnnotationReducer.State) obj).getCreateAnnotationState();
            }
        }, AnonymousClass12.INSTANCE)) == null) {
            return null;
        }
        return storeIfScope.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.autoCompleteInputScope.13
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CreateAnnotationReducer.State) obj).getCommentWithMentionsState();
            }
        }, AnonymousClass14.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$2, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, DocumentPreviewReducer.Action.CreateAnnotation> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, DocumentPreviewReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentPreviewReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentPreviewReducer.Action.CreateAnnotation(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$4, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<CommentWithMentionsReducer.Action, CreateAnnotationReducer.Action.CommentWithMentionsAction> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1, CreateAnnotationReducer.Action.CommentWithMentionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CreateAnnotationReducer.Action.CommentWithMentionsAction invoke(CommentWithMentionsReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new CreateAnnotationReducer.Action.CommentWithMentionsAction(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$6, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, ImagePreviewReducer.Action.CreateAnnotation> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        AnonymousClass6() {
            super(1, ImagePreviewReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ImagePreviewReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new ImagePreviewReducer.Action.CreateAnnotation(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$8, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<CommentWithMentionsReducer.Action, CreateAnnotationReducer.Action.CommentWithMentionsAction> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        AnonymousClass8() {
            super(1, CreateAnnotationReducer.Action.CommentWithMentionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CreateAnnotationReducer.Action.CommentWithMentionsAction invoke(CommentWithMentionsReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new CreateAnnotationReducer.Action.CommentWithMentionsAction(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$10, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<FrameAnnotationReducer.Action, VideoPreviewReducer.Action.FrameAnnotation> {
        public static final AnonymousClass10 INSTANCE = new AnonymousClass10();

        AnonymousClass10() {
            super(1, VideoPreviewReducer.Action.FrameAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/FrameAnnotationReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final VideoPreviewReducer.Action.FrameAnnotation invoke(FrameAnnotationReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new VideoPreviewReducer.Action.FrameAnnotation(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$12, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<CreateAnnotationReducer.Action, FrameAnnotationReducer.Action.CreateAnnotation> {
        public static final AnonymousClass12 INSTANCE = new AnonymousClass12();

        AnonymousClass12() {
            super(1, FrameAnnotationReducer.Action.CreateAnnotation.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FrameAnnotationReducer.Action.CreateAnnotation invoke(CreateAnnotationReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new FrameAnnotationReducer.Action.CreateAnnotation(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$autoCompleteInputScope$14, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass14 extends FunctionReferenceImpl implements Function1<CommentWithMentionsReducer.Action, CreateAnnotationReducer.Action.CommentWithMentionsAction> {
        public static final AnonymousClass14 INSTANCE = new AnonymousClass14();

        AnonymousClass14() {
            super(1, CreateAnnotationReducer.Action.CommentWithMentionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CreateAnnotationReducer.Action.CommentWithMentionsAction invoke(CommentWithMentionsReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new CreateAnnotationReducer.Action.CommentWithMentionsAction(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$documentStore$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16872 extends FunctionReferenceImpl implements Function1<ItemPreviewReducer.Action, PreviewReducer.Action.SelectedItem> {
        public static final C16872 INSTANCE = new C16872();

        C16872() {
            super(1, PreviewReducer.Action.SelectedItem.class, "<init>", "<init>(Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PreviewReducer.Action.SelectedItem invoke(ItemPreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new PreviewReducer.Action.SelectedItem(p0);
        }
    }

    public static final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> documentStore(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return itemDocumentStore(store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.documentStore.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getPreviewItem();
            }
        }, C16872.INSTANCE));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$videoStore$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16972 extends FunctionReferenceImpl implements Function1<ItemPreviewReducer.Action, PreviewReducer.Action.SelectedItem> {
        public static final C16972 INSTANCE = new C16972();

        C16972() {
            super(1, PreviewReducer.Action.SelectedItem.class, "<init>", "<init>(Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PreviewReducer.Action.SelectedItem invoke(ItemPreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new PreviewReducer.Action.SelectedItem(p0);
        }
    }

    public static final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> videoStore(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return itemVideoStore(store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.videoStore.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getPreviewItem();
            }
        }, C16972.INSTANCE));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$imageStore$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16912 extends FunctionReferenceImpl implements Function1<ItemPreviewReducer.Action, PreviewReducer.Action.SelectedItem> {
        public static final C16912 INSTANCE = new C16912();

        C16912() {
            super(1, PreviewReducer.Action.SelectedItem.class, "<init>", "<init>(Lcom/box/android/preview/item/ItemPreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PreviewReducer.Action.SelectedItem invoke(ItemPreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new PreviewReducer.Action.SelectedItem(p0);
        }
    }

    public static final Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> imageStore(Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        return itemImageStore(store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.imageStore.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getPreviewItem();
            }
        }, C16912.INSTANCE));
    }

    public static final Store<DocumentPreviewReducer.State, DocumentPreviewReducer.Action> itemDocumentStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.documentStore.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Document.class);
        C16894 c16894 = C16894.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Document)) {
            value = null;
        }
        if (((ItemState.Document) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<DocumentPreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$documentStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<DocumentPreviewReducer.State> invoke(ItemState globalState) {
                    DocumentPreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Document)) {
                        globalState = null;
                    }
                    ItemState.Document document = (ItemState.Document) globalState;
                    if (document == null || (action = document.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, c16894);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$documentStore$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16894 extends FunctionReferenceImpl implements Function1<DocumentPreviewReducer.Action, ItemPreviewReducer.Action.DocumentPreview> {
        public static final C16894 INSTANCE = new C16894();

        C16894() {
            super(1, ItemPreviewReducer.Action.DocumentPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ItemPreviewReducer.Action.DocumentPreview invoke(DocumentPreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new ItemPreviewReducer.Action.DocumentPreview(p0);
        }
    }

    public static final Store<ImagePreviewReducer.State, ImagePreviewReducer.Action> itemImageStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.imageStore.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Image.class);
        C16934 c16934 = C16934.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Image)) {
            value = null;
        }
        if (((ItemState.Image) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<ImagePreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$imageStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<ImagePreviewReducer.State> invoke(ItemState globalState) {
                    ImagePreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Image)) {
                        globalState = null;
                    }
                    ItemState.Image image = (ItemState.Image) globalState;
                    if (image == null || (action = image.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, c16934);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$imageStore$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16934 extends FunctionReferenceImpl implements Function1<ImagePreviewReducer.Action, ItemPreviewReducer.Action.ImagePreview> {
        public static final C16934 INSTANCE = new C16934();

        C16934() {
            super(1, ItemPreviewReducer.Action.ImagePreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ItemPreviewReducer.Action.ImagePreview invoke(ImagePreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new ItemPreviewReducer.Action.ImagePreview(p0);
        }
    }

    public static final Store<GifPreviewReducer.State, GifPreviewReducer.Action> itemGifStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$gifStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Gif.class);
        PreviewReducerScopingKt$gifStore$2 previewReducerScopingKt$gifStore$2 = PreviewReducerScopingKt$gifStore$2.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Gif)) {
            value = null;
        }
        if (((ItemState.Gif) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<GifPreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$gifStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<GifPreviewReducer.State> invoke(ItemState globalState) {
                    GifPreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Gif)) {
                        globalState = null;
                    }
                    ItemState.Gif gif = (ItemState.Gif) globalState;
                    if (gif == null || (action = gif.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, previewReducerScopingKt$gifStore$2);
        }
        return null;
    }

    public static final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> itemVideoStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt.videoStore.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Video.class);
        C16994 c16994 = C16994.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Video)) {
            value = null;
        }
        if (((ItemState.Video) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<VideoPreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$videoStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<VideoPreviewReducer.State> invoke(ItemState globalState) {
                    VideoPreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Video)) {
                        globalState = null;
                    }
                    ItemState.Video video = (ItemState.Video) globalState;
                    if (video == null || (action = video.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, c16994);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerScopingKt$videoStore$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewReducerScoping.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class C16994 extends FunctionReferenceImpl implements Function1<VideoPreviewReducer.Action, ItemPreviewReducer.Action.VideoPreview> {
        public static final C16994 INSTANCE = new C16994();

        C16994() {
            super(1, ItemPreviewReducer.Action.VideoPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ItemPreviewReducer.Action.VideoPreview invoke(VideoPreviewReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new ItemPreviewReducer.Action.VideoPreview(p0);
        }
    }

    public static final Store<CodePreviewReducer.State, CodePreviewReducer.Action> itemCodeStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$codeStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Code.class);
        PreviewReducerScopingKt$codeStore$2 previewReducerScopingKt$codeStore$2 = PreviewReducerScopingKt$codeStore$2.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Code)) {
            value = null;
        }
        if (((ItemState.Code) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<CodePreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$codeStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<CodePreviewReducer.State> invoke(ItemState globalState) {
                    CodePreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Code)) {
                        globalState = null;
                    }
                    ItemState.Code code = (ItemState.Code) globalState;
                    if (code == null || (action = code.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, previewReducerScopingKt$codeStore$2);
        }
        return null;
    }

    public static final Store<AudioPreviewReducer.State, AudioPreviewReducer.Action> itemAudioStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$audioStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Audio.class);
        PreviewReducerScopingKt$audioStore$2 previewReducerScopingKt$audioStore$2 = PreviewReducerScopingKt$audioStore$2.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.Audio)) {
            value = null;
        }
        if (((ItemState.Audio) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<AudioPreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$audioStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<AudioPreviewReducer.State> invoke(ItemState globalState) {
                    AudioPreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.Audio)) {
                        globalState = null;
                    }
                    ItemState.Audio audio = (ItemState.Audio) globalState;
                    if (audio == null || (action = audio.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, previewReducerScopingKt$audioStore$2);
        }
        return null;
    }

    public static final Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> itemBoxNoteStore(Store<ItemPreviewReducer.State, ItemPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<this>");
        Store<LocalState, ItemPreviewReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$boxNoteStore$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemPreviewReducer.State) obj).getItemState();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.BoxNote.class);
        PreviewReducerScopingKt$boxNoteStore$2 previewReducerScopingKt$boxNoteStore$2 = PreviewReducerScopingKt$boxNoteStore$2.INSTANCE;
        Object value = storeScope.getState().getValue();
        if (!(value instanceof ItemState.BoxNote)) {
            value = null;
        }
        if (((ItemState.BoxNote) value) != null) {
            return storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<BoxNotePreviewReducer.State>>() { // from class: com.box.android.preview.preview.PreviewReducerScopingKt$boxNoteStore$$inlined$caseLet$1
                @Override // kotlin.jvm.functions.Function1
                public final Wrapped<BoxNotePreviewReducer.State> invoke(ItemState globalState) {
                    BoxNotePreviewReducer.State action;
                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                    if (!(globalState instanceof ItemState.BoxNote)) {
                        globalState = null;
                    }
                    ItemState.BoxNote boxNote = (ItemState.BoxNote) globalState;
                    if (boxNote == null || (action = boxNote.getAction()) == null) {
                        return null;
                    }
                    return StoreKt.wrap(action);
                }
            }, previewReducerScopingKt$boxNoteStore$2);
        }
        return null;
    }
}
