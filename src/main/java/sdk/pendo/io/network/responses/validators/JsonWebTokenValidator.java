package sdk.pendo.io.network.responses.validators;

import external.sdk.pendo.io.jose4j.jwt.consumer.JwtConsumer;
import external.sdk.pendo.io.jose4j.jwt.consumer.JwtConsumerBuilder;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.f6.c;
import sdk.pendo.io.k0.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.t0.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004R\u001a\u0010\u000e\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/network/responses/validators/JsonWebTokenValidator;", "", "Lexternal/sdk/pendo/io/jose4j/jwt/consumer/JwtConsumer;", "generateJWT", "", "getEnvironmentPublicKey", "Lsdk/pendo/io/t0/f;", "generatePublicKey", "Lsdk/pendo/io/f6/c;", "environmentType", "", "setEnvironmentType", "json", "validate", "TAG", "Ljava/lang/String;", "getTAG$pendoIO_release", "()Ljava/lang/String;", "envType", "Lsdk/pendo/io/f6/c;", "RSA_JSON_WEB_KEY", "Lsdk/pendo/io/t0/f;", "JWT_CONSUMER", "Lexternal/sdk/pendo/io/jose4j/jwt/consumer/JwtConsumer;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class JsonWebTokenValidator {
    public static final JsonWebTokenValidator INSTANCE;
    private static JwtConsumer JWT_CONSUMER;
    private static f RSA_JSON_WEB_KEY;
    private static final String TAG;
    private static c envType;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.STAGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.DEV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        JsonWebTokenValidator jsonWebTokenValidator = new JsonWebTokenValidator();
        INSTANCE = jsonWebTokenValidator;
        Intrinsics.checkNotNullExpressionValue("JsonWebTokenValidator", "getSimpleName(...)");
        TAG = "JsonWebTokenValidator";
        envType = c.PROD;
        RSA_JSON_WEB_KEY = jsonWebTokenValidator.generatePublicKey();
        JWT_CONSUMER = jsonWebTokenValidator.generateJWT();
    }

    private JsonWebTokenValidator() {
    }

    private final synchronized JwtConsumer generateJWT() {
        if (RSA_JSON_WEB_KEY == null) {
            return null;
        }
        JwtConsumerBuilder jwtConsumerBuilderB = new JwtConsumerBuilder().b();
        f fVar = RSA_JSON_WEB_KEY;
        Intrinsics.checkNotNull(fVar);
        return jwtConsumerBuilderB.a(fVar.a()).a(sdk.pendo.io.q0.c.d).a();
    }

    private final synchronized f generatePublicKey() {
        try {
            try {
                PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(getEnvironmentPublicKey())));
                Intrinsics.checkNotNull(publicKeyGeneratePublic, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
                return new f((RSAPublicKey) publicKeyGeneratePublic);
            } catch (InvalidKeySpecException e) {
                PendoLogger.w(TAG + " Failed to generate public key with InvalidKeySpecException error: " + e, new Object[0]);
                PendoLogger.e(TAG, "CANNOT GENERATE PUBLIC KEY!", (Throwable) null);
                return null;
            }
        } catch (NoSuchAlgorithmException e2) {
            PendoLogger.d(TAG + " Failed to generate public key with NoSuchAlgorithmException error: " + e2, new Object[0]);
            PendoLogger.e(TAG, "CANNOT GENERATE PUBLIC KEY!", (Throwable) null);
            return null;
        }
    }

    private final String getEnvironmentPublicKey() {
        int i = WhenMappings.$EnumSwitchMapping$0[envType.ordinal()];
        if (i != 1) {
            return i != 2 ? "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1B6qsa2sbpc4CuFEjgRWez9nN\nMtburcr/RZ6n4iEIGcLZFfQ34whx3aGQ8ZuImAOOHnhjohaZzaW8bITEnZNa+v/h\n0vFrDGYtyJQdh1H7ejasIvWYDt+S/Pd1b8b8/ZZ6czA8fNcDDGgXmcGOCi8tK2nJ\n972K3gVzG7F581Tw6QIDAQAB" : "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbelsiqvdpzGmRF3pex4Ar1HNI\nMcadFr9rwxGUMGOn8qIcjLE4vr9T1rxm6DekW9IBGNAwGOynuA+ebTfpfPMYY8nO\nZ7gvgJ/czWhiH8IDnmHnxVeLd6O8Z+/4hl++9Yae1093QTb2k5FIekNae54Klg4N\nT0Qiqky2MfXLee1lYwIDAQAB";
        }
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv8IqRRwpH8s7EnWhLwuFqnbTA\n6iT8LqQ+nPL0WvwCtHPABV4hXd0+qj4TZo3nEew13M5uEFiD6cFlA1/l/dydjGjT\nvknbo5+6pBVWVZpCg5Rtpii3JUKMxOmJrccBCo7ICIqPIj/L9Nc5zmWMH2igKHLq\nx4N4CYzAsWwSc505vwIDAQAB";
    }

    public final String getTAG$pendoIO_release() {
        return TAG;
    }

    public final synchronized void setEnvironmentType(c environmentType) {
        Intrinsics.checkNotNullParameter(environmentType, "environmentType");
        envType = environmentType;
        RSA_JSON_WEB_KEY = generatePublicKey();
        JWT_CONSUMER = generateJWT();
    }

    public final String validate(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (RSA_JSON_WEB_KEY == null) {
            throw new IllegalStateException("RSA key is null");
        }
        JwtConsumer jwtConsumer = JWT_CONSUMER;
        if (jwtConsumer == null) {
            throw new IllegalStateException("JWT consumer null");
        }
        Intrinsics.checkNotNull(jwtConsumer);
        return jwtConsumer.b(json).j();
    }
}
