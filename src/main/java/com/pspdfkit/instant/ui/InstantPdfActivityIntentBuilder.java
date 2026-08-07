package com.pspdfkit.instant.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.ul;
import com.pspdfkit.ui.PdfActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00002\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00002\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016R \u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder;", "", "Landroid/content/Context;", "context", "Lcom/pspdfkit/internal/ul;", "documentSource", "<init>", "(Landroid/content/Context;Lcom/pspdfkit/internal/ul;)V", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "configuration", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder;", "Ljava/lang/Class;", "Lcom/pspdfkit/ui/PdfActivity;", "activityClass", "(Ljava/lang/Class;)Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder;", "Landroid/content/Intent;", "build", "()Landroid/content/Intent;", "Landroid/content/Context;", "Lcom/pspdfkit/internal/ul;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "Ljava/lang/Class;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantPdfActivityIntentBuilder {
    public static final String PARAM_INSTANT_DOCUMENT_SOURCE = "Instant.InstantDocumentSource";
    private Class<? extends PdfActivity> activityClass;
    private PdfActivityConfiguration configuration;
    private final Context context;
    private final ul documentSource;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder$Companion;", "", "<init>", "()V", "PARAM_INSTANT_DOCUMENT_SOURCE", "", "fromInstantDocument", "Lcom/pspdfkit/instant/ui/InstantPdfActivityIntentBuilder;", "context", "Landroid/content/Context;", "instantServerUrl", "jwt", "checkAndAdjustConfiguration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "configuration", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PdfActivityConfiguration checkAndAdjustConfiguration(PdfActivityConfiguration configuration) {
            return (configuration == null || !configuration.getConfiguration().isContentEditingEnabled()) ? configuration : new PdfActivityConfiguration.Builder(configuration).configuration(PdfConfiguration.copy$default(configuration.getConfiguration(), null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -8388609, -1, 15, null)).build();
        }

        public final InstantPdfActivityIntentBuilder fromInstantDocument(Context context, String instantServerUrl, String jwt) {
            context.getClass();
            instantServerUrl.getClass();
            jwt.getClass();
            return new InstantPdfActivityIntentBuilder(context, new ul(instantServerUrl, jwt), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstantPdfActivityIntentBuilder(Context context, ul ulVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, ulVar);
    }

    public final InstantPdfActivityIntentBuilder activityClass(Class<? extends PdfActivity> activityClass) {
        if (activityClass != null && !InstantPdfActivity.class.isAssignableFrom(activityClass)) {
            throw new IllegalArgumentException("Passed activity class must extend InstantPdfActivity!");
        }
        this.activityClass = activityClass;
        return this;
    }

    public final Intent build() {
        if (this.activityClass == null) {
            this.activityClass = InstantPdfActivity.class;
        }
        if (this.configuration == null) {
            this.configuration = new PdfActivityConfiguration.Builder(this.context).contentEditingEnabled(false).build();
        }
        Intent intent = new Intent(this.context, this.activityClass);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Nutri.Configuration", this.configuration);
        bundle.putParcelable("Instant.InstantDocumentSource", this.documentSource);
        intent.putExtra("Nutri.InternalExtras", bundle);
        return intent;
    }

    public final InstantPdfActivityIntentBuilder configuration(PdfActivityConfiguration configuration) {
        this.configuration = INSTANCE.checkAndAdjustConfiguration(configuration);
        return this;
    }

    private InstantPdfActivityIntentBuilder(Context context, ul ulVar) {
        this.context = context;
        this.documentSource = ulVar;
    }

    public final InstantPdfActivityIntentBuilder activityClass(KClass<? extends PdfActivity> activityClass) {
        return activityClass(activityClass != null ? JvmClassMappingKt.getJavaClass((KClass) activityClass) : null);
    }
}
