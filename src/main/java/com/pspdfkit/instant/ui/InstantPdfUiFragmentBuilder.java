package com.pspdfkit.instant.ui;

import android.content.Context;
import android.os.Bundle;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.ul;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00002\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u00002\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001bR \u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "", "Landroid/content/Context;", "context", "Lcom/pspdfkit/internal/ul;", "documentSource", "<init>", "(Landroid/content/Context;Lcom/pspdfkit/internal/ul;)V", "Landroid/os/Bundle;", "createExtras", "()Landroid/os/Bundle;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "configuration", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "Ljava/lang/Class;", "Lcom/pspdfkit/instant/ui/InstantPdfUiFragment;", "fragmentClass", "(Ljava/lang/Class;)Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "", "pdfFragmentTag", "(Ljava/lang/String;)Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "build", "()Lcom/pspdfkit/instant/ui/InstantPdfUiFragment;", "Landroid/content/Context;", "Lcom/pspdfkit/internal/ul;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "Ljava/lang/Class;", "Ljava/lang/String;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantPdfUiFragmentBuilder {
    private PdfActivityConfiguration configuration;
    private final Context context;
    private final ul documentSource;
    private Class<? extends InstantPdfUiFragment> fragmentClass;
    private String pdfFragmentTag;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder$Companion;", "", "<init>", "()V", "fromInstantDocument", "Lcom/pspdfkit/instant/ui/InstantPdfUiFragmentBuilder;", "context", "Landroid/content/Context;", "instantServerUrl", "", "jwt", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InstantPdfUiFragmentBuilder fromInstantDocument(Context context, String instantServerUrl, String jwt) {
            context.getClass();
            instantServerUrl.getClass();
            jwt.getClass();
            return new InstantPdfUiFragmentBuilder(context, new ul(instantServerUrl, jwt), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstantPdfUiFragmentBuilder(Context context, ul ulVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, ulVar);
    }

    private final Bundle createExtras() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("Nutri.Configuration", this.configuration);
        bundle.putParcelable("Instant.InstantDocumentSource", this.documentSource);
        bundle.putString("Nutri.PdfFragmentTag", this.pdfFragmentTag);
        return bundle;
    }

    public final InstantPdfUiFragment build() {
        Class cls = this.fragmentClass;
        if (cls == null) {
            cls = InstantPdfUiFragment.class;
        }
        if (this.configuration == null) {
            this.configuration = new PdfActivityConfiguration.Builder(this.context).contentEditingEnabled(false).build();
        }
        try {
            InstantPdfUiFragment instantPdfUiFragment = (InstantPdfUiFragment) cls.getDeclaredConstructor(null).newInstance(null);
            instantPdfUiFragment.setArguments(createExtras());
            return instantPdfUiFragment;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate InstantPdfUiFragment.", e);
        }
    }

    public final InstantPdfUiFragmentBuilder configuration(PdfActivityConfiguration configuration) {
        this.configuration = InstantPdfActivityIntentBuilder.INSTANCE.checkAndAdjustConfiguration(configuration);
        return this;
    }

    public final InstantPdfUiFragmentBuilder fragmentClass(Class<? extends InstantPdfUiFragment> fragmentClass) {
        if (fragmentClass != null && !InstantPdfUiFragment.class.isAssignableFrom(fragmentClass)) {
            throw new IllegalArgumentException("Passed fragment class must extend InstantPdfUiFragment!");
        }
        this.fragmentClass = fragmentClass;
        return this;
    }

    public final InstantPdfUiFragmentBuilder pdfFragmentTag(String pdfFragmentTag) {
        if (pdfFragmentTag != null) {
            this.pdfFragmentTag = pdfFragmentTag;
            return this;
        }
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
        return this;
    }

    private InstantPdfUiFragmentBuilder(Context context, ul ulVar) {
        this.context = context;
        this.documentSource = ulVar;
        this.pdfFragmentTag = cw.DEFAULT_PDF_FRAGMENT_TAG;
    }

    public final InstantPdfUiFragmentBuilder fragmentClass(KClass<? extends InstantPdfUiFragment> fragmentClass) {
        return fragmentClass(fragmentClass != null ? JvmClassMappingKt.getJavaClass((KClass) fragmentClass) : null);
    }
}
