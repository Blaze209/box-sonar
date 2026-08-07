package com.pspdfkit.internal;

import androidx.lifecycle.ViewModelKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.utils.PdfLog;
import java.util.List;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class eg implements AnnotationProvider.OnAnnotationUpdatedListener {
    public final /* synthetic */ fg a;

    public eg(fg fgVar) {
        this.a = fgVar;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        EmbeddedFile file;
        annotation.getClass();
        if (annotation.getType() != AnnotationType.FILE || (file = ((FileAnnotation) annotation).getFile()) == null) {
            return;
        }
        PdfLog.d("EmbeddedFiles", "File annotation created: " + file.getFileName() + " on page " + annotation.getPageIndex(), new Object[0]);
        fg fgVar = this.a;
        int pageIndex = annotation.getPageIndex();
        int i = fg.g;
        fgVar.getClass();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(fgVar), Dispatchers.getMain(), null, new bg(fgVar, file, pageIndex, null), 2, null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        EmbeddedFile file;
        annotation.getClass();
        if (annotation.getType() != AnnotationType.FILE || (file = ((FileAnnotation) annotation).getFile()) == null) {
            return;
        }
        fg fgVar = this.a;
        int pageIndex = annotation.getPageIndex();
        int i = fg.g;
        fgVar.getClass();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(fgVar), Dispatchers.getMain(), null, new dg(fgVar, pageIndex, file, null), 2, null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }
}
