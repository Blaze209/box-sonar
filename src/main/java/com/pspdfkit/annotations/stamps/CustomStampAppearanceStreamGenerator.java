package com.pspdfkit.annotations.stamps;

import android.text.TextUtils;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.uw;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CustomStampAppearanceStreamGenerator implements AppearanceStreamGenerator {
    private final Map<String, AppearanceStreamGenerator> appearanceStreamGenerators = new HashMap();

    public void addAppearanceStreamGenerator(String str, AppearanceStreamGenerator appearanceStreamGenerator) {
        uw.a(!TextUtils.isEmpty(str), "Subject may not be empty.");
        uw.a(appearanceStreamGenerator, "appearanceStreamGenerator", null);
        this.appearanceStreamGenerators.put(str, appearanceStreamGenerator);
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public DataProvider getDataProviderForAnnotation(Annotation annotation, EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> enumSet) {
        uw.a(annotation, "annotation", null);
        uw.a(enumSet, "options", null);
        String subject = annotation.getSubject();
        if (subject == null || !this.appearanceStreamGenerators.containsKey(subject)) {
            return null;
        }
        return this.appearanceStreamGenerators.get(subject).getDataProviderForAnnotation(annotation, enumSet);
    }

    public void removeAppearanceStreamGenerator(String str) {
        uw.a(str, "subject", null);
        this.appearanceStreamGenerators.remove(str);
    }

    @Override // com.pspdfkit.annotations.appearance.AppearanceStreamGenerator
    public boolean shouldUseGeneratorForAnnotation(Annotation annotation) {
        String subject = annotation.getSubject();
        return subject != null && this.appearanceStreamGenerators.containsKey(subject) && this.appearanceStreamGenerators.get(subject).shouldUseGeneratorForAnnotation(annotation);
    }
}
