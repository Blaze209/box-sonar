package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.internal.util.PackageUtils;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BrokerValidator.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bB|\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012'\u0010\n\u001a#\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000b\u0012<\u0010\u0012\u001a8\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\n\u001a#\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0012\u001a8\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerValidator;", "Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowedApps", "", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "(Landroid/content/Context;Ljava/util/Set;)V", "allowedBrokerApps", "getSigningCertificateForApp", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "Ljava/security/cert/X509Certificate;", "validateSigningCertificate", "Lkotlin/Function2;", "expectedSigningCertificateSignature", "signingCertificates", "", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "expectedSigningCertificateThumbprint", "isSignedByKnownKeys", "", "brokerData", "isValidBrokerPackage", "verifySignature", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BrokerValidator implements IBrokerValidator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerValidator.class).getSimpleName();
    private final Set<BrokerData> allowedBrokerApps;
    private final Function1<String, List<X509Certificate>> getSigningCertificateForApp;
    private final Function2<String, List<? extends X509Certificate>, Unit> validateSigningCertificate;

    public BrokerValidator(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.allowedBrokerApps = BrokerData.INSTANCE.getKnownBrokerApps();
        this.getSigningCertificateForApp = new Function1<String, List<X509Certificate>>() { // from class: com.microsoft.identity.common.internal.broker.BrokerValidator.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<X509Certificate> invoke(String packageName) throws GeneralSecurityException, PackageManager.NameNotFoundException, IOException, ClientException {
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                List<X509Certificate> certDataForApp = PackageUtils.readCertDataForApp(packageName, context);
                Intrinsics.checkNotNullExpressionValue(certDataForApp, "readCertDataForApp(packageName, context)");
                return certDataForApp;
            }
        };
        this.validateSigningCertificate = new AnonymousClass2(INSTANCE);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.BrokerValidator$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrokerValidator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<String, List<? extends X509Certificate>, Unit> {
        AnonymousClass2(Object obj) {
            super(2, obj, Companion.class, "validateSigningCertificate", "validateSigningCertificate(Ljava/lang/String;Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends X509Certificate> list) throws GeneralSecurityException, ClientException {
            invoke2(str, list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, List<? extends X509Certificate> p1) throws GeneralSecurityException, ClientException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((Companion) this.receiver).validateSigningCertificate(p0, p1);
        }
    }

    public BrokerValidator(final Context context, Set<BrokerData> allowedApps) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(allowedApps, "allowedApps");
        this.allowedBrokerApps = allowedApps;
        this.getSigningCertificateForApp = new Function1<String, List<X509Certificate>>() { // from class: com.microsoft.identity.common.internal.broker.BrokerValidator.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<X509Certificate> invoke(String packageName) throws GeneralSecurityException, PackageManager.NameNotFoundException, IOException, ClientException {
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                List<X509Certificate> certDataForApp = PackageUtils.readCertDataForApp(packageName, context);
                Intrinsics.checkNotNullExpressionValue(certDataForApp, "readCertDataForApp(packageName, context)");
                return certDataForApp;
            }
        };
        this.validateSigningCertificate = new AnonymousClass4(INSTANCE);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.BrokerValidator$4, reason: invalid class name */
    /* JADX INFO: compiled from: BrokerValidator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function2<String, List<? extends X509Certificate>, Unit> {
        AnonymousClass4(Object obj) {
            super(2, obj, Companion.class, "validateSigningCertificate", "validateSigningCertificate(Ljava/lang/String;Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends X509Certificate> list) throws GeneralSecurityException, ClientException {
            invoke2(str, list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String p0, List<? extends X509Certificate> p1) throws GeneralSecurityException, ClientException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((Companion) this.receiver).validateSigningCertificate(p0, p1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BrokerValidator(Set<BrokerData> allowedBrokerApps, Function1<? super String, ? extends List<? extends X509Certificate>> getSigningCertificateForApp, Function2<? super String, ? super List<? extends X509Certificate>, Unit> validateSigningCertificate) {
        Intrinsics.checkNotNullParameter(allowedBrokerApps, "allowedBrokerApps");
        Intrinsics.checkNotNullParameter(getSigningCertificateForApp, "getSigningCertificateForApp");
        Intrinsics.checkNotNullParameter(validateSigningCertificate, "validateSigningCertificate");
        this.allowedBrokerApps = allowedBrokerApps;
        this.getSigningCertificateForApp = getSigningCertificateForApp;
        this.validateSigningCertificate = validateSigningCertificate;
    }

    /* JADX INFO: compiled from: BrokerValidator.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/BrokerValidator$Companion;", "", "()V", "TAG", "", "validateSigningCertificate", "", "expectedSigningCertificateThumbprint", "signingCertificates", "", "Ljava/security/cert/X509Certificate;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void validateSigningCertificate(String expectedSigningCertificateThumbprint, List<? extends X509Certificate> signingCertificates) throws GeneralSecurityException, ClientException {
            Intrinsics.checkNotNullParameter(expectedSigningCertificateThumbprint, "expectedSigningCertificateThumbprint");
            Intrinsics.checkNotNullParameter(signingCertificates, "signingCertificates");
            PackageUtils.verifySignatureHash(signingCertificates, SetsKt.setOf(expectedSigningCertificateThumbprint).iterator());
            if (signingCertificates.size() > 1) {
                PackageUtils.verifyCertificateChain(signingCertificates);
            }
        }
    }

    public boolean verifySignature(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return isValidBrokerPackage(packageName);
    }

    @Override // com.microsoft.identity.common.internal.broker.IBrokerValidator
    public boolean isValidBrokerPackage(String packageName) {
        Object next;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        String str = TAG + ":isValidBrokerPackage";
        Set<BrokerData> set = this.allowedBrokerApps;
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (StringsKt.equals(((BrokerData) obj).getPackageName(), packageName, true)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!isSignedByKnownKeys((BrokerData) next));
        if (((BrokerData) next) != null) {
            return true;
        }
        Logger.info(str, packageName + " does not match with any known broker apps.");
        return false;
    }

    @Override // com.microsoft.identity.common.internal.broker.IBrokerValidator
    public boolean isSignedByKnownKeys(BrokerData brokerData) {
        Intrinsics.checkNotNullParameter(brokerData, "brokerData");
        String str = TAG + ":isSignedByKnownKeys";
        try {
            this.validateSigningCertificate.invoke(brokerData.getSigningCertificateThumbprint(), this.getSigningCertificateForApp.invoke(brokerData.getPackageName()));
            Logger.verbose(str, brokerData + " is a valid broker app.");
            return true;
        } catch (Throwable th) {
            Logger.verbose(str, brokerData + " verification failed: " + th.getMessage());
            return false;
        }
    }
}
