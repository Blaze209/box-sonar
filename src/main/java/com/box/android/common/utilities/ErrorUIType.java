package com.box.android.common.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/common/utilities/ErrorUIType;", "", "<init>", "()V", "Toast", "Snackbar", TypedValues.Custom.NAME, "Lcom/box/android/common/utilities/ErrorUIType$Custom;", "Lcom/box/android/common/utilities/ErrorUIType$Snackbar;", "Lcom/box/android/common/utilities/ErrorUIType$Toast;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ErrorUIType {
    public /* synthetic */ ErrorUIType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: SingleEvent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/common/utilities/ErrorUIType$Toast;", "Lcom/box/android/common/utilities/ErrorUIType;", "message", "", "args", "", "", "<init>", "(I[Ljava/lang/String;)V", "getMessage", "()I", "getArgs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Toast extends ErrorUIType {
        private final String[] args;
        private final int message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Toast(int i, String... args) {
            super(null);
            Intrinsics.checkNotNullParameter(args, "args");
            this.message = i;
            this.args = args;
        }

        public final String[] getArgs() {
            return this.args;
        }

        public final int getMessage() {
            return this.message;
        }
    }

    private ErrorUIType() {
    }

    /* JADX INFO: compiled from: SingleEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/box/android/common/utilities/ErrorUIType$Snackbar;", "Lcom/box/android/common/utilities/ErrorUIType;", "message", "", "buttonText", "<init>", "(II)V", "getMessage", "()I", "getButtonText", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Snackbar extends ErrorUIType {
        private final int buttonText;
        private final int message;

        public Snackbar(int i, int i2) {
            super(null);
            this.message = i;
            this.buttonText = i2;
        }

        public final int getButtonText() {
            return this.buttonText;
        }

        public final int getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: SingleEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/common/utilities/ErrorUIType$Custom;", "Lcom/box/android/common/utilities/ErrorUIType;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Custom extends ErrorUIType {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
