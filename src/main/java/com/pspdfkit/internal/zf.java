package com.pspdfkit.internal;

import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProviderBlocking;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class zf implements EmbeddedFilesProvider {
    public final lm a;

    public class a implements EmbeddedFilesProvider.EmbeddedFilesCallback {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onFilesFound(Collection<EmbeddedFile> collection, Collection<EmbeddedFile> collection2, int i, boolean z) {
            if (!z) {
                return true;
            }
            this.a.addAll(collection);
            return true;
        }
    }

    public class b implements EmbeddedFilesProvider.EmbeddedFilesCallback {
        public final /* synthetic */ AtomicBoolean a;

        public b(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onFilesFound(Collection<EmbeddedFile> collection, Collection<EmbeddedFile> collection2, int i, boolean z) {
            if (collection.isEmpty()) {
                return true;
            }
            this.a.set(true);
            return false;
        }
    }

    public class c implements EmbeddedFilesProvider.EmbeddedFilesCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ EmbeddedFile[] b;

        public c(String str, EmbeddedFile[] embeddedFileArr) {
            this.a = str;
            this.b = embeddedFileArr;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onFilesFound(Collection<EmbeddedFile> collection, Collection<EmbeddedFile> collection2, int i, boolean z) {
            for (EmbeddedFile embeddedFile : collection2) {
                if (this.a.equals(embeddedFile.getFileName())) {
                    this.b[0] = embeddedFile;
                    return false;
                }
            }
            return true;
        }
    }

    public class d implements EmbeddedFilesProvider.EmbeddedFilesCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ EmbeddedFile[] b;

        public d(String str, EmbeddedFile[] embeddedFileArr) {
            this.a = str;
            this.b = embeddedFileArr;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onFilesFound(Collection<EmbeddedFile> collection, Collection<EmbeddedFile> collection2, int i, boolean z) {
            for (EmbeddedFile embeddedFile : collection2) {
                if (this.a.equals(embeddedFile.getId())) {
                    this.b[0] = embeddedFile;
                    return false;
                }
            }
            return true;
        }
    }

    public zf(lm lmVar) {
        this.a = lmVar;
    }

    public final /* synthetic */ SingleSource a(boolean z) throws Throwable {
        return Single.just(getEmbeddedFiles(z));
    }

    public final /* synthetic */ MaybeSource b(boolean z, String str) throws Throwable {
        EmbeddedFile[] embeddedFileArr = {null};
        getEmbeddedFilesProgressive(z, new d(str, embeddedFileArr));
        EmbeddedFile embeddedFile = embeddedFileArr[0];
        return embeddedFile != null ? Maybe.just(embeddedFile) : Maybe.empty();
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final Maybe<EmbeddedFile> getEmbeddedFileWithFileNameAsync(final String str, final boolean z) {
        uw.a(str, BoxCommonConstants.EXTRA_FILE_NAME, null);
        return Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.zf$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.a(z, str);
            }
        }).subscribeOn(this.a.b(5));
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final Maybe<EmbeddedFile> getEmbeddedFileWithIdAsync(final String str, final boolean z) {
        uw.a(str, "id", null);
        return Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.zf$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.b(z, str);
            }
        }).subscribeOn(this.a.b(5));
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final List<EmbeddedFile> getEmbeddedFiles(boolean z) {
        ArrayList arrayList = new ArrayList();
        getEmbeddedFilesProgressive(z, new a(arrayList));
        return arrayList;
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final Single<List<EmbeddedFile>> getEmbeddedFilesAsync(final boolean z) {
        return Single.defer(new Supplier() { // from class: com.pspdfkit.internal.zf$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.a(z);
            }
        }).subscribeOn(this.a.b(5));
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final void getEmbeddedFilesProgressive(boolean z, EmbeddedFilesProvider.EmbeddedFilesCallback embeddedFilesCallback) {
        EmbeddedFile file;
        try {
            ArrayList arrayList = new ArrayList();
            lm lmVar = this.a;
            ArrayList<String> arrayListFindEmbeddedFiles = lmVar.q.findEmbeddedFiles(lmVar.y);
            if (!arrayListFindEmbeddedFiles.isEmpty()) {
                if (!embeddedFilesCallback.onPageProgress(-1, z ? this.a.s : 0)) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayListFindEmbeddedFiles.size();
                int i = 0;
                while (i < size) {
                    String str = arrayListFindEmbeddedFiles.get(i);
                    i++;
                    wf wfVar = new wf(this.a, str);
                    arrayList.add(wfVar);
                    arrayList2.add(wfVar);
                }
                if (!embeddedFilesCallback.onFilesFound(arrayList, arrayList2, -1, !z)) {
                    return;
                }
            }
            if (z) {
                int i2 = this.a.s;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (!embeddedFilesCallback.onPageProgress(i3, i2)) {
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Annotation annotation : AnnotationProviderBlocking.getAnnotationsBlocking(this.a.getAnnotationProvider(), i3)) {
                        if (annotation.getType() == AnnotationType.FILE && (file = ((FileAnnotation) annotation).getFile()) != null) {
                            arrayList.add(file);
                            arrayList3.add(file);
                        }
                    }
                    if (!arrayList3.isEmpty() && !embeddedFilesCallback.onFilesFound(arrayList, arrayList3, i3, false)) {
                        return;
                    }
                }
                embeddedFilesCallback.onFilesFound(arrayList, new ArrayList<>(), i2 - 1, true);
            }
        } catch (Exception e) {
            embeddedFilesCallback.onError(e);
        }
    }

    @Override // com.pspdfkit.document.files.EmbeddedFilesProvider
    public final boolean hasEmbeddedFiles() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        getEmbeddedFilesProgressive(true, new b(atomicBoolean));
        return atomicBoolean.get();
    }

    public final /* synthetic */ MaybeSource a(boolean z, String str) throws Throwable {
        EmbeddedFile[] embeddedFileArr = {null};
        getEmbeddedFilesProgressive(z, new c(str, embeddedFileArr));
        EmbeddedFile embeddedFile = embeddedFileArr[0];
        return embeddedFile != null ? Maybe.just(embeddedFile) : Maybe.empty();
    }
}
