package com.box.android.domain.preview;

import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.pspdfkit.ui.transition.EpicenterTranslateClipReveal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PreviewerTypeResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0016J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005*\b\u0012\u0004\u0012\u00020\n0\u0005H\u0002J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005*\b\u0012\u0004\u0012\u00020\n0\u0005H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\n*\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\nH\u0002¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u000fH\u0002J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0011*\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/preview/PreviewerTypeResolverImpl;", "Lcom/box/android/domain/preview/PreviewerTypeResolver;", "<init>", "()V", "preferredPreviewers", "", "Lcom/box/android/domain/preview/PreviewerMapping;", BoxFile.FIELD_EXTENSION, "", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/domain/models/RepresentationModel;", "preferredGifImageRepresentations", "preferredVideoRepresentations", "findBy", BoxRepresentation.FIELD_REPRESENTATION, "Lcom/box/android/domain/models/RepresentationType;", "dimensionSize", "", "(Lcom/box/android/domain/models/RepresentationModel;)Ljava/lang/Integer;", "toPreviewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "toPreference", "(Lcom/box/android/domain/models/RepresentationType;)Ljava/lang/Integer;", "resolvePreviewerForOriginal", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewerTypeResolverImpl implements PreviewerTypeResolver {

    /* JADX INFO: compiled from: PreviewerTypeResolver.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RepresentationType.values().length];
            try {
                iArr[RepresentationType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepresentationType.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepresentationType.JPG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public PreviewerTypeResolverImpl() {
    }

    @Override // com.box.android.domain.preview.PreviewerTypeResolver
    public List<PreviewerMapping> preferredPreviewers(String extension, List<RepresentationModel> representations) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(representations, "representations");
        ArrayList arrayList = new ArrayList();
        List<RepresentationModel> listPreferredVideoRepresentations = preferredVideoRepresentations(representations);
        if (listPreferredVideoRepresentations.isEmpty()) {
            listPreferredVideoRepresentations = null;
        }
        if (listPreferredVideoRepresentations != null) {
            Iterator<T> it = listPreferredVideoRepresentations.iterator();
            while (it.hasNext()) {
                arrayList.add(new PreviewerMapping(PreviewerType.Video, new PreviewContentType.Representation((RepresentationModel) it.next())));
            }
        }
        if (SupportedFileExtensions.INSTANCE.isPlayableVideo(extension)) {
            arrayList.add(new PreviewerMapping(PreviewerType.Video, PreviewContentType.Original.INSTANCE));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            RepresentationModel representationModelFindBy = findBy(representations, RepresentationType.MP3);
            if (representationModelFindBy != null) {
                arrayList2.add(new PreviewerMapping(PreviewerType.Audio, new PreviewContentType.Representation(representationModelFindBy)));
            }
            if (SupportedFileExtensions.INSTANCE.isPlayableAudio(extension)) {
                arrayList2.add(new PreviewerMapping(PreviewerType.Audio, PreviewContentType.Original.INSTANCE));
            }
            if (arrayList2.isEmpty()) {
                if (SupportedFileExtensions.INSTANCE.isOpenableDocument(extension)) {
                    arrayList2.add(new PreviewerMapping(PreviewerType.PDF, PreviewContentType.Original.INSTANCE));
                    RepresentationModel representationModelFindBy2 = findBy(representations, RepresentationType.PDF);
                    if (representationModelFindBy2 != null) {
                        arrayList2.add(new PreviewerMapping(PreviewerType.PDF, new PreviewContentType.Representation(representationModelFindBy2)));
                        return arrayList;
                    }
                } else if (SupportedFileExtensions.INSTANCE.isOpenableGif(extension)) {
                    arrayList2.add(new PreviewerMapping(PreviewerType.GIF, PreviewContentType.Original.INSTANCE));
                    Iterator<T> it2 = preferredGifImageRepresentations(representations).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(new PreviewerMapping(PreviewerType.GIF, new PreviewContentType.Representation((RepresentationModel) it2.next())));
                    }
                } else if (SupportedFileExtensions.INSTANCE.isOpenableCode(extension)) {
                    arrayList2.add(new PreviewerMapping(PreviewerType.Code, PreviewContentType.Original.INSTANCE));
                    RepresentationModel representationModelFindBy3 = findBy(representations, RepresentationType.PDF);
                    if (representationModelFindBy3 != null) {
                        arrayList2.add(new PreviewerMapping(PreviewerType.PDF, new PreviewContentType.Representation(representationModelFindBy3)));
                        return arrayList;
                    }
                } else {
                    ArrayList<RepresentationModel> arrayList3 = new ArrayList();
                    for (Object obj : representations) {
                        RepresentationModel representationModel = (RepresentationModel) obj;
                        if (toPreviewerType(representationModel.getRepresentationType()) == PreviewerType.Image) {
                            String dimensions = representationModel.getProperties().getDimensions();
                            if (Intrinsics.areEqual(dimensions, "1024x1024") || Intrinsics.areEqual(dimensions, "2048x2048")) {
                            }
                        }
                        arrayList3.add(obj);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (RepresentationModel representationModel2 : arrayList3) {
                        PreviewerType previewerType = toPreviewerType(representationModel2.getRepresentationType());
                        Pair pair = previewerType != null ? TuplesKt.to(representationModel2, previewerType) : null;
                        if (pair != null) {
                            arrayList4.add(pair);
                        }
                    }
                    for (Pair pair2 : CollectionsKt.sortedWith(CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.box.android.domain.preview.PreviewerTypeResolverImpl$preferredPreviewers$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(this.this$0.dimensionSize((RepresentationModel) ((Pair) t2).component1()), this.this$0.dimensionSize((RepresentationModel) ((Pair) t).component1()));
                        }
                    }), new Comparator() { // from class: com.box.android.domain.preview.PreviewerTypeResolverImpl$preferredPreviewers$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(this.this$0.toPreference(((RepresentationModel) ((Pair) t).component1()).getRepresentationType()), this.this$0.toPreference(((RepresentationModel) ((Pair) t2).component1()).getRepresentationType()));
                        }
                    })) {
                        arrayList2.add(new PreviewerMapping((PreviewerType) pair2.component2(), new PreviewContentType.Representation((RepresentationModel) pair2.component1())));
                    }
                    PreviewerType previewerTypeResolvePreviewerForOriginal = resolvePreviewerForOriginal(extension);
                    if (previewerTypeResolvePreviewerForOriginal != null) {
                        arrayList2.add(new PreviewerMapping(previewerTypeResolvePreviewerForOriginal, PreviewContentType.Original.INSTANCE));
                    }
                }
            }
        }
        return arrayList;
    }

    private final List<RepresentationModel> preferredGifImageRepresentations(List<RepresentationModel> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RepresentationModel representationModel = (RepresentationModel) obj;
            if (representationModel.getRepresentationType() == RepresentationType.JPG || representationModel.getRepresentationType() == RepresentationType.PNG) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.box.android.domain.preview.PreviewerTypeResolverImpl$preferredGifImageRepresentations$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(this.this$0.dimensionSize((RepresentationModel) t2), this.this$0.dimensionSize((RepresentationModel) t));
            }
        });
    }

    private final List<RepresentationModel> preferredVideoRepresentations(List<RepresentationModel> list) {
        ArrayList arrayList = new ArrayList();
        RepresentationModel representationModelFindBy = findBy(list, RepresentationType.DASH);
        if (representationModelFindBy != null) {
            arrayList.add(representationModelFindBy);
        }
        RepresentationModel representationModelFindBy2 = findBy(list, RepresentationType.MP4);
        if (representationModelFindBy2 != null) {
            arrayList.add(representationModelFindBy2);
        }
        return arrayList;
    }

    private final RepresentationModel findBy(List<RepresentationModel> list, RepresentationType representationType) {
        Object next;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((RepresentationModel) next).getRepresentationType() == representationType) {
                return (RepresentationModel) next;
            }
        }
        next = null;
        return (RepresentationModel) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer dimensionSize(RepresentationModel representationModel) {
        String dimensions = representationModel.getProperties().getDimensions();
        if (dimensions != null) {
            return StringsKt.toIntOrNull((String) CollectionsKt.first(StringsKt.split$default((CharSequence) dimensions, new char[]{EpicenterTranslateClipReveal.StateProperty.TARGET_X}, true, 0, 4, (Object) null)));
        }
        return null;
    }

    private final PreviewerType toPreviewerType(RepresentationType representationType) {
        int i = WhenMappings.$EnumSwitchMapping$0[representationType.ordinal()];
        if (i == 1) {
            return PreviewerType.PDF;
        }
        if (i == 2 || i == 3) {
            return PreviewerType.Image;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer toPreference(RepresentationType representationType) {
        int i = WhenMappings.$EnumSwitchMapping$0[representationType.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 2 : null;
        }
        return 1;
    }

    private final PreviewerType resolvePreviewerForOriginal(String extension) {
        if (SupportedFileExtensions.INSTANCE.isOpenableImage(extension)) {
            return PreviewerType.Image;
        }
        if (SupportedFileExtensions.INSTANCE.isPlayableAudio(extension)) {
            return PreviewerType.Audio;
        }
        if (SupportedFileExtensions.INSTANCE.isPlayableVideo(extension)) {
            return PreviewerType.Video;
        }
        return null;
    }
}
