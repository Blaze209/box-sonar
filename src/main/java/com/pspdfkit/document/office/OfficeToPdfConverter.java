package com.pspdfkit.document.office;

import android.content.Context;
import android.net.Uri;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.facebook.common.util.UriUtil;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class OfficeToPdfConverter {
    private static final String ANDROID_PLATFORM = "android";
    private static final String CONVERSION_URL = "i/convert_to_pdf";
    private static final int HTTP_TIMEOUT_S = 60;
    private static final String JWT_HEADER = "x-pspdfkit-token";
    private static final String PACKAGE_NAME_HEADER = "pspdfkit-bundle-id";
    private static final String PARAMETER_FILE = "file";
    private static final String PLATFORM_HEADER = "pspdfkit-platform";
    private static final String UPLOAD_MIME_TYPE = "application/octet-stream";
    private static final String VERSION_HEADER = "pspdfkit-version";
    private final Context context;
    private final String jwt;
    private final Uri officeDocumentUri;
    private final OkHttpClient okHttpClient;
    private final Uri serverUri;

    private OfficeToPdfConverter(Context context, Uri uri, Uri uri2, String str) {
        this.context = context.getApplicationContext();
        this.officeDocumentUri = uri;
        this.serverUri = uri2;
        this.jwt = str;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.okHttpClient = builder.connectTimeout(60L, timeUnit).readTimeout(60L, timeUnit).writeTimeout(60L, timeUnit).build();
    }

    private Request createRequest(RequestBody requestBody) {
        return new Request.Builder().url(Uri.withAppendedPath(this.serverUri, CONVERSION_URL).toString()).addHeader(JWT_HEADER, this.jwt).addHeader(PLATFORM_HEADER, "android").addHeader(VERSION_HEADER, "11.3.0").addHeader(PACKAGE_NAME_HEADER, this.context.getPackageName()).post(requestBody).build();
    }

    private RequestBody createRequestBody(File file) {
        return new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", file.getName(), RequestBody.create(file, MediaType.get("application/octet-stream"))).build();
    }

    public static OfficeToPdfConverter fromUri(Context context, Uri uri, Uri uri2, String str) {
        uw.a(context, "context", null);
        uw.a(uri, "officeDocumentUri", null);
        uw.a(uri2, "serverUri", null);
        uw.a(str, "jwt", null);
        if ("content".equalsIgnoreCase(uri.getScheme()) || "file".equalsIgnoreCase(uri.getScheme()) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            return new OfficeToPdfConverter(context, uri, uri2, str);
        }
        throw new IllegalArgumentException("Unsupported URI scheme: " + uri.getScheme() + "://. Only file:// and content:// schemes are supported.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File lambda$convertToPdfAsync$0() throws Exception {
        File fileA = wg.a(this.context, "pdf");
        if (fileA == null) {
            throw new IOException("Failed to create output file.");
        }
        lambda$convertToPdfAsync$1(fileA);
        return fileA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performUpload, reason: merged with bridge method [inline-methods] */
    public void lambda$convertToPdfAsync$1(File file) throws IOException {
        File file2;
        Context context = this.context;
        Uri uri = this.officeDocumentUri;
        if (!"file".equalsIgnoreCase(uri.getScheme()) || uri.getPath().startsWith("/android_asset/")) {
            File fileA = wg.a(context, GQLCacheConstants.ID_TEMP_KEY);
            InputStream inputStreamB = wg.b(context, uri);
            if (fileA == null) {
                throw new IOException("Failed to copy file from the content provider to a temporary file.");
            }
            wg.a(inputStreamB, new FileOutputStream(fileA));
            file2 = fileA;
        } else {
            if (uri.getPath() == null) {
                throw new IllegalArgumentException("The passed in URI didn't contain a valid path.");
            }
            file2 = new File(uri.getPath());
        }
        Response responseExecute = this.okHttpClient.newCall(createRequest(createRequestBody(file2))).execute();
        try {
            if (responseExecute.code() == 200) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody == null) {
                    throw new IOException("Server didn't return any data.");
                }
                wg.a(responseBodyBody.byteStream(), fileOutputStream);
                responseExecute.close();
                return;
            }
            throw new IOException("Failed to convert document, Server returned status " + responseExecute.code() + ": " + responseExecute.message() + ", " + responseExecute.body().string());
        } catch (Throwable th) {
            if (responseExecute != null) {
                try {
                    responseExecute.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Completable convertToPdfAsync(final File file) {
        uw.a(file, "outputFile", null);
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.document.office.OfficeToPdfConverter$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$convertToPdfAsync$1(file);
            }
        }).subscribeOn(Schedulers.io());
    }

    public Single<File> convertToPdfAsync() {
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.document.office.OfficeToPdfConverter$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$convertToPdfAsync$0();
            }
        }).subscribeOn(Schedulers.io());
    }
}
