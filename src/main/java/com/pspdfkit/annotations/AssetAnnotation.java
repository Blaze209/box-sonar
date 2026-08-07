package com.pspdfkit.annotations;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.pt;
import com.pspdfkit.utils.PdfLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AssetAnnotation extends LinkAnnotation {
    private final String LOG_TAG;
    private final String resourceId;

    public AssetAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z);
        this.LOG_TAG = "Nutri.AssetAnnotation";
        this.resourceId = str;
    }

    public String getAssetName() {
        return this.propertyManager.g(7002);
    }

    public Uri getFileUri(Context context, PdfDocument pdfDocument) {
        if (getInternal().getNativeAnnotation() == null) {
            throw new NutrientException("Annotation is not attached to the document.");
        }
        if (this.resourceId == null) {
            throw new NutrientException("Trying to extract asset from the annotation, but it has no resource id.");
        }
        String assetName = getAssetName();
        if (assetName == null) {
            throw new NutrientException("The asset name has not been defined.");
        }
        PdfLog.d("Nutri.AssetAnnotation", "Extracting temporary media file for annotation: " + toString(), new Object[0]);
        File file = new File(context.getCacheDir(), "TEMP_" + getObjectNumber() + "_" + assetName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            pt ptVar = new pt(fileOutputStream);
            ((lm) pdfDocument).getAnnotationProvider().a.q.getResource(null, getInternal().getNativeAnnotation(), this.resourceId, ptVar);
            ptVar.finish();
            fileOutputStream.close();
        } catch (IOException e) {
            PdfLog.e("Nutri.AssetAnnotation", e, "Could not retrieve resource for asset annotation: %s", this);
        }
        return Uri.fromFile(file);
    }
}
