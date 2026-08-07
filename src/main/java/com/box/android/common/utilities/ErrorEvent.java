package com.box.android.common.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleEvent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0006\u0007\bB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/common/utilities/ErrorEvent;", "Lcom/box/android/common/utilities/SingleEvent;", "Lcom/box/android/common/utilities/ErrorUIType;", "errorType", "<init>", "(Lcom/box/android/common/utilities/ErrorUIType;)V", "Toast", "SnackbarWithButton", TypedValues.Custom.NAME, "Lcom/box/android/common/utilities/ErrorEvent$Custom;", "Lcom/box/android/common/utilities/ErrorEvent$SnackbarWithButton;", "Lcom/box/android/common/utilities/ErrorEvent$Toast;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ErrorEvent extends SingleEvent<ErrorUIType> {
    public /* synthetic */ ErrorEvent(ErrorUIType errorUIType, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorUIType);
    }

    /* JADX INFO: compiled from: SingleEvent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/common/utilities/ErrorEvent$Toast;", "Lcom/box/android/common/utilities/ErrorEvent;", "message", "", "args", "", "", "<init>", "(I[Ljava/lang/String;)V", "getMessage", "()I", "getArgs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Toast extends ErrorEvent {
        private final String[] args;
        private final int message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Toast(int i, String... args) {
            super(new ErrorUIType.Toast(i, (String[]) Arrays.copyOf(args, args.length)), null);
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

    private ErrorEvent(ErrorUIType errorUIType) {
        super(errorUIType);
    }

    /* JADX INFO: compiled from: SingleEvent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/box/android/common/utilities/ErrorEvent$SnackbarWithButton;", "Lcom/box/android/common/utilities/ErrorEvent;", "message", "", "buttonText", "<init>", "(II)V", "getMessage", "()I", "getButtonText", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SnackbarWithButton extends ErrorEvent {
        private final int buttonText;
        private final int message;

        public SnackbarWithButton(int i, int i2) {
            super(new ErrorUIType.Snackbar(i, i2), null);
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/common/utilities/ErrorEvent$Custom;", "Lcom/box/android/common/utilities/ErrorEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Custom extends ErrorEvent {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String message) {
            super(new ErrorUIType.Custom(message), null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
