package com.geniusscansdk.camera;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.readablecodeflow.ReadableCodeConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DetectionMode.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/camera/DetectionMode;", "", "Disabled", "Document", "ReadableCode", "Lcom/geniusscansdk/camera/DetectionMode$Disabled;", "Lcom/geniusscansdk/camera/DetectionMode$Document;", "Lcom/geniusscansdk/camera/DetectionMode$ReadableCode;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DetectionMode {

    /* JADX INFO: compiled from: DetectionMode.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/camera/DetectionMode$Disabled;", "Lcom/geniusscansdk/camera/DetectionMode;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Disabled implements DetectionMode {
        public static final Disabled INSTANCE = new Disabled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Disabled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2132370806;
        }

        public String toString() {
            return "Disabled";
        }

        private Disabled() {
        }
    }

    /* JADX INFO: compiled from: DetectionMode.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/geniusscansdk/camera/DetectionMode$Document;", "Lcom/geniusscansdk/camera/DetectionMode;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Document implements DetectionMode {
        public static final Document INSTANCE = new Document();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Document)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1571816427;
        }

        public String toString() {
            return "Document";
        }

        private Document() {
        }
    }

    /* JADX INFO: compiled from: DetectionMode.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/geniusscansdk/camera/DetectionMode$ReadableCode;", "Lcom/geniusscansdk/camera/DetectionMode;", "configuration", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "<init>", "(Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;)V", "getConfiguration", "()Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ReadableCode implements DetectionMode {
        private final ReadableCodeConfiguration configuration;

        public static /* synthetic */ ReadableCode copy$default(ReadableCode readableCode, ReadableCodeConfiguration readableCodeConfiguration, int i, Object obj) {
            if ((i & 1) != 0) {
                readableCodeConfiguration = readableCode.configuration;
            }
            return readableCode.copy(readableCodeConfiguration);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ReadableCodeConfiguration getConfiguration() {
            return this.configuration;
        }

        public final ReadableCode copy(ReadableCodeConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return new ReadableCode(configuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ReadableCode) && Intrinsics.areEqual(this.configuration, ((ReadableCode) other).configuration);
        }

        public int hashCode() {
            return this.configuration.hashCode();
        }

        public String toString() {
            return "ReadableCode(configuration=" + this.configuration + ")";
        }

        public ReadableCode(ReadableCodeConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            this.configuration = configuration;
        }

        public final ReadableCodeConfiguration getConfiguration() {
            return this.configuration;
        }
    }
}
