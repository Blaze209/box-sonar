package com.pspdfkit.instant.annotations;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0010\u0011J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider;", "Lcom/pspdfkit/annotations/AnnotationProvider;", "getAnnotationForIdentifier", "Lcom/pspdfkit/annotations/Annotation;", "identifier", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdentifierForAnnotation", "annotation", "(Lcom/pspdfkit/annotations/Annotation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasUnsavedChanges", "", "addNonAnnotationChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider$OnNonAnnotationChangeListener;", "NonAnnotationChange", "OnNonAnnotationChangeListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface InstantAnnotationProvider extends AnnotationProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider$NonAnnotationChange;", "", "<init>", "(Ljava/lang/String;I)V", "COMMENT_CREATED", "COMMENT_DELETED", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum NonAnnotationChange {
        COMMENT_CREATED,
        COMMENT_DELETED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<NonAnnotationChange> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider$OnNonAnnotationChangeListener;", "", "onNonAnnotationChange", "", "change", "Lcom/pspdfkit/instant/annotations/InstantAnnotationProvider$NonAnnotationChange;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnNonAnnotationChangeListener {
        void onNonAnnotationChange(NonAnnotationChange change);
    }

    void addNonAnnotationChangeListener(OnNonAnnotationChangeListener listener);

    Object getAnnotationForIdentifier(String str, Continuation<? super Annotation> continuation);

    Object getIdentifierForAnnotation(Annotation annotation, Continuation<? super String> continuation) throws IllegalStateException;

    @Override // com.pspdfkit.annotations.AnnotationProvider
    boolean hasUnsavedChanges();
}
