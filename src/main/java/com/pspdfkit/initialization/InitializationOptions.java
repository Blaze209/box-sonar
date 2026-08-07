package com.pspdfkit.initialization;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.internal.lv;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/pspdfkit/initialization/InitializationOptions;", "", "licenseKey", "", "fontPaths", "", "crossPlatformTechnology", "Lcom/pspdfkit/initialization/CrossPlatformTechnology;", "applicationPolicy", "Lcom/pspdfkit/configuration/policy/ApplicationPolicy;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/pspdfkit/initialization/CrossPlatformTechnology;Lcom/pspdfkit/configuration/policy/ApplicationPolicy;)V", "getLicenseKey", "()Ljava/lang/String;", "getFontPaths", "()Ljava/util/List;", "getCrossPlatformTechnology", "()Lcom/pspdfkit/initialization/CrossPlatformTechnology;", "getApplicationPolicy", "()Lcom/pspdfkit/configuration/policy/ApplicationPolicy;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class InitializationOptions {
    public static final int $stable = 8;
    private final ApplicationPolicy applicationPolicy;
    private final CrossPlatformTechnology crossPlatformTechnology;
    private final List<String> fontPaths;
    private final String licenseKey;

    public InitializationOptions() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InitializationOptions copy$default(InitializationOptions initializationOptions, String str, List list, CrossPlatformTechnology crossPlatformTechnology, ApplicationPolicy applicationPolicy, int i, Object obj) {
        if ((i & 1) != 0) {
            str = initializationOptions.licenseKey;
        }
        if ((i & 2) != 0) {
            list = initializationOptions.fontPaths;
        }
        if ((i & 4) != 0) {
            crossPlatformTechnology = initializationOptions.crossPlatformTechnology;
        }
        if ((i & 8) != 0) {
            applicationPolicy = initializationOptions.applicationPolicy;
        }
        return initializationOptions.copy(str, list, crossPlatformTechnology, applicationPolicy);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLicenseKey() {
        return this.licenseKey;
    }

    public final List<String> component2() {
        return this.fontPaths;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CrossPlatformTechnology getCrossPlatformTechnology() {
        return this.crossPlatformTechnology;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ApplicationPolicy getApplicationPolicy() {
        return this.applicationPolicy;
    }

    public final InitializationOptions copy(String licenseKey, List<String> fontPaths, CrossPlatformTechnology crossPlatformTechnology, ApplicationPolicy applicationPolicy) {
        fontPaths.getClass();
        return new InitializationOptions(licenseKey, fontPaths, crossPlatformTechnology, applicationPolicy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializationOptions)) {
            return false;
        }
        InitializationOptions initializationOptions = (InitializationOptions) other;
        return Intrinsics.areEqual(this.licenseKey, initializationOptions.licenseKey) && Intrinsics.areEqual(this.fontPaths, initializationOptions.fontPaths) && this.crossPlatformTechnology == initializationOptions.crossPlatformTechnology && Intrinsics.areEqual(this.applicationPolicy, initializationOptions.applicationPolicy);
    }

    public final ApplicationPolicy getApplicationPolicy() {
        return this.applicationPolicy;
    }

    public final CrossPlatformTechnology getCrossPlatformTechnology() {
        return this.crossPlatformTechnology;
    }

    public final List<String> getFontPaths() {
        return this.fontPaths;
    }

    public final String getLicenseKey() {
        return this.licenseKey;
    }

    public int hashCode() {
        String str = this.licenseKey;
        int iA = lv.a(this.fontPaths, (str == null ? 0 : str.hashCode()) * 31, 31);
        CrossPlatformTechnology crossPlatformTechnology = this.crossPlatformTechnology;
        int iHashCode = (iA + (crossPlatformTechnology == null ? 0 : crossPlatformTechnology.hashCode())) * 31;
        ApplicationPolicy applicationPolicy = this.applicationPolicy;
        return iHashCode + (applicationPolicy != null ? applicationPolicy.hashCode() : 0);
    }

    public String toString() {
        return "InitializationOptions(licenseKey=" + this.licenseKey + ", fontPaths=" + this.fontPaths + ", crossPlatformTechnology=" + this.crossPlatformTechnology + ", applicationPolicy=" + this.applicationPolicy + ")";
    }

    public InitializationOptions(String str, List<String> list, CrossPlatformTechnology crossPlatformTechnology, ApplicationPolicy applicationPolicy) {
        list.getClass();
        this.licenseKey = str;
        this.fontPaths = list;
        this.crossPlatformTechnology = crossPlatformTechnology;
        this.applicationPolicy = applicationPolicy;
    }

    public /* synthetic */ InitializationOptions(String str, List list, CrossPlatformTechnology crossPlatformTechnology, ApplicationPolicy applicationPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : crossPlatformTechnology, (i & 8) != 0 ? null : applicationPolicy);
    }
}
