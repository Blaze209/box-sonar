package com.pspdfkit.document.download.exceptions;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\t\n\u000b\f\r\u000eB\u0013\b\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0014\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\b\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException;", "Ljava/io/IOException;", "detailMessage", "", "<init>", "(Ljava/lang/String;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "DownloadOnMainThreadException", "OutputFolderException", "DownloadFileException", "OutputFileException", "NetworkException", "NotEnoughDiskSpaceException", "Lcom/pspdfkit/document/download/exceptions/DownloadException$DownloadFileException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException$DownloadOnMainThreadException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException$NetworkException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException$NotEnoughDiskSpaceException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException$OutputFileException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException$OutputFolderException;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DownloadException extends IOException {
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$DownloadFileException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "detailMessage", "", "<init>", "(Ljava/lang/String;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadFileException extends DownloadException {
        public static final int $stable = 8;

        public DownloadFileException(String str) {
            super(str, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$DownloadOnMainThreadException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DownloadOnMainThreadException extends DownloadException {
        public static final int $stable = 8;

        public DownloadOnMainThreadException() {
            super("Downloading a document on the main thread is not allowed.", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$NetworkException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "detailMessage", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NetworkException extends DownloadException {
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkException(String str, Throwable th) {
            super(str, th, null);
            th.getClass();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$NotEnoughDiskSpaceException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "detailMessage", "", "<init>", "(Ljava/lang/String;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NotEnoughDiskSpaceException extends DownloadException {
        public static final int $stable = 8;

        public NotEnoughDiskSpaceException(String str) {
            super(str, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$OutputFileException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "detailMessage", "", "<init>", "(Ljava/lang/String;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class OutputFileException extends DownloadException {
        public static final int $stable = 8;

        public OutputFileException(String str) {
            super(str, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/document/download/exceptions/DownloadException$OutputFolderException;", "Lcom/pspdfkit/document/download/exceptions/DownloadException;", "detailMessage", "", "<init>", "(Ljava/lang/String;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class OutputFolderException extends DownloadException {
        public static final int $stable = 8;

        public OutputFolderException(String str) {
            super(str, (DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ DownloadException(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ DownloadException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private DownloadException(String str) {
        super(str);
    }

    private DownloadException(String str, Throwable th) {
        super(str, th);
    }
}
