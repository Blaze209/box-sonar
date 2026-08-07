package com.pspdfkit.document.providers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.PdfLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002*+B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0012\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006,"}, d2 = {"Lcom/pspdfkit/document/providers/ContentResolverDataProvider;", "Lcom/pspdfkit/document/providers/InputStreamDataProvider;", "Landroid/os/Parcelable;", "Lcom/pspdfkit/document/providers/WritableDataProvider;", "Lcom/pspdfkit/document/providers/UriDataProvider;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "fileSize", "", "title", "", "writeProcess", "Lcom/pspdfkit/document/providers/ContentResolverDataProvider$WriteProcess;", "supportsAppending", "", "Ljava/lang/Boolean;", "openInputStream", "Ljava/io/InputStream;", "getSize", "queryFileSize", "getUid", "getTitle", "describeContents", "", "writeToParcel", "", "dest", "flags", "canWrite", "startWrite", "writeMode", "Lcom/pspdfkit/document/providers/WritableDataProvider$WriteMode;", "write", "data", "", "finishWrite", "getUri", "WriteProcess", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentResolverDataProvider extends InputStreamDataProvider implements Parcelable, WritableDataProvider, UriDataProvider {
    private static final String LOG_TAG = "Nutri.ContResolverDProv";
    private long fileSize;
    private Boolean supportsAppending;
    private String title;
    private final Uri uri;
    private WriteProcess writeProcess;
    public static final int $stable = 8;
    public static final Parcelable.Creator<ContentResolverDataProvider> CREATOR = new Parcelable.Creator<ContentResolverDataProvider>() { // from class: com.pspdfkit.document.providers.ContentResolverDataProvider$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentResolverDataProvider createFromParcel(Parcel source) {
            source.getClass();
            return new ContentResolverDataProvider(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentResolverDataProvider[] newArray(int size) {
            return new ContentResolverDataProvider[size];
        }
    };

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/document/providers/ContentResolverDataProvider$WriteProcess;", "", "context", "Landroid/content/Context;", "currentWriteMode", "Lcom/pspdfkit/document/providers/WritableDataProvider$WriteMode;", "<init>", "(Lcom/pspdfkit/document/providers/ContentResolverDataProvider;Landroid/content/Context;Lcom/pspdfkit/document/providers/WritableDataProvider$WriteMode;)V", "outputStream", "Ljava/io/BufferedOutputStream;", "tempFilePath", "", "start", "", "write", "data", "", "finish", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class WriteProcess {
        private final Context context;
        private final WritableDataProvider.WriteMode currentWriteMode;
        private BufferedOutputStream outputStream;
        private String tempFilePath;
        final /* synthetic */ ContentResolverDataProvider this$0;

        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[WritableDataProvider.WriteMode.values().length];
                try {
                    iArr[WritableDataProvider.WriteMode.REWRITE_FILE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WritableDataProvider.WriteMode.APPEND_TO_FILE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public WriteProcess(ContentResolverDataProvider contentResolverDataProvider, Context context, WritableDataProvider.WriteMode writeMode) {
            context.getClass();
            writeMode.getClass();
            this.this$0 = contentResolverDataProvider;
            this.context = context;
            this.currentWriteMode = writeMode;
        }

        public final boolean finish() {
            if (this.outputStream == null) {
                return false;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.currentWriteMode.ordinal()];
            if (i == 1) {
                try {
                    BufferedOutputStream bufferedOutputStream = this.outputStream;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    this.outputStream = null;
                    PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Tempfile written, transferring to content provider...", new Object[0]);
                    OutputStream outputStreamOpenOutputStream = MAMContentResolverManagement.openOutputStream(this.context.getContentResolver(), this.this$0.uri, "w");
                    if (outputStreamOpenOutputStream == null) {
                        PdfLog.e(ContentResolverDataProvider.LOG_TAG, "Could not open output stream for URI " + this.this$0.uri, new Object[0]);
                        return false;
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStreamOpenOutputStream);
                    FileInputStream fileInputStream = new FileInputStream(this.tempFilePath);
                    wg.a(fileInputStream, bufferedOutputStream2);
                    fileInputStream.close();
                    bufferedOutputStream2.close();
                    PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Done.", new Object[0]);
                } catch (Exception e) {
                    PdfLog.e(ContentResolverDataProvider.LOG_TAG, e, "Error finishing write!", new Object[0]);
                    return false;
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                try {
                    BufferedOutputStream bufferedOutputStream3 = this.outputStream;
                    if (bufferedOutputStream3 != null) {
                        bufferedOutputStream3.close();
                    }
                    this.outputStream = null;
                    PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Append done.", new Object[0]);
                } catch (Exception e2) {
                    PdfLog.e(ContentResolverDataProvider.LOG_TAG, e2, "Error finishing append!", new Object[0]);
                    return false;
                }
            }
            return true;
        }

        public final boolean start() {
            int i = WhenMappings.$EnumSwitchMapping$0[this.currentWriteMode.ordinal()];
            if (i == 1) {
                try {
                    File fileA = wg.a(this.context, "pdf");
                    String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
                    this.tempFilePath = absolutePath;
                    if (absolutePath == null) {
                        return false;
                    }
                    PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Starting write to temporary file %s...", absolutePath);
                    this.outputStream = new BufferedOutputStream(new FileOutputStream(this.tempFilePath));
                    return true;
                } catch (FileNotFoundException e) {
                    PdfLog.e(ContentResolverDataProvider.LOG_TAG, e, "Error creating a temp file!", new Object[0]);
                    return false;
                }
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Starting append to output file %s...", this.this$0.uri);
            try {
                OutputStream outputStreamOpenOutputStream = MAMContentResolverManagement.openOutputStream(this.context.getContentResolver(), this.this$0.uri, "wa");
                if (outputStreamOpenOutputStream != null) {
                    this.outputStream = new BufferedOutputStream(outputStreamOpenOutputStream);
                    return true;
                }
                PdfLog.e(ContentResolverDataProvider.LOG_TAG, "Could not open output stream for URI " + this.this$0.uri, new Object[0]);
                return false;
            } catch (Exception e2) {
                PdfLog.e(ContentResolverDataProvider.LOG_TAG, e2, "Could not start append to output stream!", new Object[0]);
                return false;
            }
        }

        public final boolean write(byte[] data) {
            data.getClass();
            try {
                BufferedOutputStream bufferedOutputStream = this.outputStream;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(data);
                }
                PdfLog.v(ContentResolverDataProvider.LOG_TAG, "Written %d data...", Integer.valueOf(data.length));
                return true;
            } catch (IOException e) {
                PdfLog.e(ContentResolverDataProvider.LOG_TAG, e, "Error writing data!", new Object[0]);
                return false;
            }
        }
    }

    public /* synthetic */ ContentResolverDataProvider(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final long queryFileSize() {
        long j;
        Context context = getContext();
        Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), this.uri, new String[]{"_size"}, null, null, null);
        if (cursorQuery != null) {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
            }
            String string = cursorQuery.getString(0);
            cursorQuery.close();
            j = string != null ? Long.parseLong(string) : -1L;
            PdfLog.v(LOG_TAG, "File size is %d.", Long.valueOf(j));
        } else {
            j = -1;
        }
        if (j <= 0) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = MAMContentResolverManagement.openFileDescriptor(context.getContentResolver(), this.uri, "r");
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    PdfLog.v(LOG_TAG, "File size from PFD is %d.", Long.valueOf(statSize));
                    if (statSize != -1) {
                        return statSize;
                    }
                }
            } catch (IOException e) {
                PdfLog.e(LOG_TAG, "Error on getting size from ParcelFileDescriptor.", e);
                return j;
            }
        }
        return j;
    }

    @Override // com.pspdfkit.document.providers.WritableDataProvider
    public boolean canWrite() {
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.pspdfkit.document.providers.WritableDataProvider
    public boolean finishWrite() {
        WriteProcess writeProcess = this.writeProcess;
        if (writeProcess == null) {
            return false;
        }
        boolean zFinish = writeProcess.finish();
        this.writeProcess = null;
        this.fileSize = -1L;
        try {
            reopenInputStream();
            return zFinish;
        } catch (Exception e) {
            PdfLog.e(LOG_TAG, e, "Error reopening the input stream.", new Object[0]);
            return false;
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public long getSize() throws InterruptedException {
        long j = this.fileSize;
        if (j != -1) {
            return j;
        }
        long jQueryFileSize = queryFileSize();
        this.fileSize = jQueryFileSize;
        if (jQueryFileSize <= 0 && !Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000L);
                this.fileSize = queryFileSize();
            }
        }
        return this.fileSize;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    @Override // com.pspdfkit.document.providers.DataProvider
    public String getTitle() {
        String strA;
        String str = this.title;
        if (str != null) {
            return str;
        }
        Cursor cursorQuery = MAMContentResolverManagement.query(getContext().getContentResolver(), this.uri, new String[]{"_display_name"}, null, null, null);
        Unit unit = null;
        if (cursorQuery != null) {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
            }
            strA = cursorQuery.getString(0);
            cursorQuery.close();
        } else {
            strA = null;
        }
        if (strA == null) {
            strA = wg.a(this.uri);
        } else {
            String lastPathSegment = this.uri.getLastPathSegment();
            if (lastPathSegment != null) {
                if (Intrinsics.areEqual(strA, new File(lastPathSegment).getName())) {
                    strA = wg.a(this.uri);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                strA = wg.a(this.uri);
            }
        }
        this.title = strA;
        return strA;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public String getUid() {
        String string = this.uri.toString();
        string.getClass();
        return string;
    }

    @Override // com.pspdfkit.document.providers.UriDataProvider
    public Uri getUri() {
        Uri uriBuild = this.uri.buildUpon().build();
        uriBuild.getClass();
        return uriBuild;
    }

    @Override // com.pspdfkit.document.providers.InputStreamDataProvider
    public InputStream openInputStream() throws IOException {
        InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(getContext().getContentResolver(), this.uri);
        Uri uri = this.uri;
        if (inputStreamOpenInputStream == null) {
            throw new IOException("Could not open input stream for URI " + uri);
        }
        PdfLog.v(LOG_TAG, "Reopened input stream %s.", uri.toString());
        return inputStreamOpenInputStream;
    }

    @Override // com.pspdfkit.document.providers.WritableDataProvider
    public boolean startWrite(WritableDataProvider.WriteMode writeMode) {
        writeMode.getClass();
        if (this.writeProcess != null) {
            PdfLog.e(LOG_TAG, "Attempted to write to a ContentResolverDataProvider before finishing previous write!", new Object[0]);
            return false;
        }
        wg.a(getContext(), true, Arrays.asList(getUri()));
        WriteProcess writeProcess = new WriteProcess(this, getContext(), writeMode);
        this.writeProcess = writeProcess;
        return writeProcess.start();
    }

    @Override // com.pspdfkit.document.providers.WritableDataProvider
    public boolean supportsAppending() {
        Boolean bool = this.supportsAppending;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (getSize() != -1) {
            try {
                OutputStream outputStreamOpenOutputStream = MAMContentResolverManagement.openOutputStream(getContext().getContentResolver(), this.uri, "wa");
                if (outputStreamOpenOutputStream != null) {
                    outputStreamOpenOutputStream.close();
                }
                z = !Intrinsics.areEqual(this.uri.getAuthority(), "com.google.android.apps.docs.storage.legacy");
            } catch (Exception unused) {
                PdfLog.w(LOG_TAG, "Content provider for " + this.uri + " does not support appending.", new Object[0]);
            }
        }
        this.supportsAppending = Boolean.valueOf(z);
        return z;
    }

    @Override // com.pspdfkit.document.providers.WritableDataProvider
    public boolean write(byte[] data) {
        data.getClass();
        WriteProcess writeProcess = this.writeProcess;
        if (writeProcess != null) {
            return writeProcess.write(data);
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeParcelable(this.uri, 0);
    }

    public ContentResolverDataProvider(Uri uri) {
        uri.getClass();
        this.uri = uri;
        this.fileSize = -1L;
        wg.a(getContext(), false, Arrays.asList(uri));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ContentResolverDataProvider(Parcel parcel) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 33) {
            uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader(), Uri.class);
        } else {
            uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        }
        this((Uri) Objects.requireNonNull(uri));
    }
}
