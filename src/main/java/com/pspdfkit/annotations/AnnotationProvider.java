package com.pspdfkit.annotations;

import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 ?2\u00020\u0001:\u0002>?J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\fJ\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H¦@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H¦@¢\u0006\u0002\u0010\u0016J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001dJ&\u0010!\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010$J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u001fJ\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H¦@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001dJ\u0016\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\tH¦@¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H&J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020-H&J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H&J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001dJ\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001dJ\u001e\u00105\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u00106\u001a\u000207H¦@¢\u0006\u0002\u00108J\"\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010\tH¦@¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u0002070\u00032\u0006\u0010\u001c\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001d¨\u0006@À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/annotations/AnnotationProvider;", "", "getAnnotations", "", "Lcom/pspdfkit/annotations/Annotation;", "pageIndex", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnotationsJson", "", "getAnnotation", "objectNumber", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uuid", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "objectNumbers", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAnnotationsOfType", "types", "", "Lcom/pspdfkit/annotations/AnnotationType;", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startIndex", "pageCount", "(Ljava/util/Set;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addAnnotationToPage", "", "annotation", "(Lcom/pspdfkit/annotations/Annotation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.Z_INDEX, "(Lcom/pspdfkit/annotations/Annotation;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAnnotationFromPage", "moveAnnotation", "fromZIndex", "toZIndex", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zIndexMove", "Lcom/pspdfkit/annotations/AnnotationZIndexMove;", "(Lcom/pspdfkit/annotations/Annotation;Lcom/pspdfkit/annotations/AnnotationZIndexMove;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getZIndex", "createAnnotationFromInstantJson", "annotationJson", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUnsavedChanges", "", "addAppearanceStreamGenerator", "appearanceStreamGenerator", "Lcom/pspdfkit/annotations/appearance/AppearanceStreamGenerator;", "addFirst", "removeAppearanceStreamGenerator", "getAnnotationReplies", "getFlattenedAnnotationReplies", "appendAnnotationState", "annotationStateChange", "Lcom/pspdfkit/annotations/note/AnnotationStateChange;", "(Lcom/pspdfkit/annotations/Annotation;Lcom/pspdfkit/annotations/note/AnnotationStateChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewSummary", "Lcom/pspdfkit/annotations/note/AnnotationReviewSummary;", "currentUser", "(Lcom/pspdfkit/annotations/Annotation;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReviewHistory", "OnAnnotationUpdatedListener", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface AnnotationProvider {
    public static final Set<AnnotationType> ALL_ANNOTATION_TYPES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcom/pspdfkit/annotations/AnnotationProvider$Companion;", "", "<init>", "()V", "ALL_ANNOTATION_TYPES", "", "Lcom/pspdfkit/annotations/AnnotationType;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<AnnotationType> entries$0 = EnumEntriesKt.enumEntries(AnnotationType.values());
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J6\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\r0\f2\u0011\u0010\u000e\u001a\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\r0\fH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "", "onAnnotationCreated", "", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "onAnnotationUpdated", "onAnnotationRemoved", "onAnnotationZOrderChanged", "pageIndex", "", "oldOrder", "", "Lkotlin/jvm/JvmSuppressWildcards;", "newOrder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnAnnotationUpdatedListener {
        void onAnnotationCreated(Annotation annotation);

        void onAnnotationRemoved(Annotation annotation);

        void onAnnotationUpdated(Annotation annotation);

        void onAnnotationZOrderChanged(int pageIndex, List<Annotation> oldOrder, List<Annotation> newOrder);
    }

    static {
        Set<AnnotationType> setUnmodifiableSet = Collections.unmodifiableSet(CollectionsKt.toSet(EntriesMappings.entries$0));
        setUnmodifiableSet.getClass();
        ALL_ANNOTATION_TYPES = setUnmodifiableSet;
    }

    Object addAnnotationToPage(Annotation annotation, int i, Continuation<? super Unit> continuation);

    Object addAnnotationToPage(Annotation annotation, Continuation<? super Unit> continuation);

    void addAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator);

    void addAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator, boolean addFirst);

    Object appendAnnotationState(Annotation annotation, AnnotationStateChange annotationStateChange, Continuation<? super Unit> continuation);

    Object createAnnotationFromInstantJson(String str, Continuation<? super Annotation> continuation);

    Object getAllAnnotationsOfType(Set<? extends AnnotationType> set, int i, int i2, Continuation<? super List<? extends Annotation>> continuation);

    Object getAllAnnotationsOfType(Set<? extends AnnotationType> set, Continuation<? super List<? extends Annotation>> continuation);

    Object getAnnotation(int i, int i2, Continuation<? super Annotation> continuation);

    Object getAnnotation(int i, String str, Continuation<? super Annotation> continuation);

    Object getAnnotationReplies(Annotation annotation, Continuation<? super List<? extends Annotation>> continuation);

    Object getAnnotations(int i, Continuation<? super List<? extends Annotation>> continuation);

    Object getAnnotations(Collection<Integer> collection, Continuation<? super List<? extends Annotation>> continuation);

    Object getAnnotationsJson(int i, Continuation<? super String> continuation);

    Object getFlattenedAnnotationReplies(Annotation annotation, Continuation<? super List<? extends Annotation>> continuation);

    Object getReviewHistory(Annotation annotation, Continuation<? super List<AnnotationStateChange>> continuation);

    Object getReviewSummary(Annotation annotation, String str, Continuation<? super AnnotationReviewSummary> continuation);

    Object getZIndex(Annotation annotation, Continuation<? super Integer> continuation);

    boolean hasUnsavedChanges();

    Object moveAnnotation(int i, int i2, int i3, Continuation<? super Unit> continuation);

    Object moveAnnotation(Annotation annotation, int i, Continuation<? super Unit> continuation);

    Object moveAnnotation(Annotation annotation, AnnotationZIndexMove annotationZIndexMove, Continuation<? super Unit> continuation);

    Object removeAnnotationFromPage(Annotation annotation, Continuation<? super Unit> continuation);

    void removeAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator);
}
