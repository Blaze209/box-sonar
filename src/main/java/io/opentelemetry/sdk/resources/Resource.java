package io.opentelemetry.sdk.resources;

import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.internal.StringUtils;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Resource {
    private static final Resource DEFAULT;
    private static final String ERROR_MESSAGE_INVALID_CHARS = " should be a ASCII string with a length greater than 0 and not exceed 255 characters.";
    private static final String ERROR_MESSAGE_INVALID_VALUE = " should be a ASCII string with a length not exceed 255 characters.";
    private static final Resource MANDATORY;
    private static final int MAX_LENGTH = 255;
    private static final Resource TELEMETRY_SDK;
    private static final Logger logger = Logger.getLogger(Resource.class.getName());
    private static final Resource EMPTY = create(Attributes.empty());

    public abstract Attributes getAttributes();

    @Nullable
    public abstract String getSchemaUrl();

    static {
        Resource resourceCreate = create(Attributes.of(ResourceAttributes.SERVICE_NAME, "unknown_service:java"));
        MANDATORY = resourceCreate;
        Resource resourceCreate2 = create(Attributes.builder().put(ResourceAttributes.TELEMETRY_SDK_NAME, "opentelemetry").put(ResourceAttributes.TELEMETRY_SDK_LANGUAGE, ResourceAttributes.TelemetrySdkLanguageValues.JAVA).put(ResourceAttributes.TELEMETRY_SDK_VERSION, readVersion()).build());
        TELEMETRY_SDK = resourceCreate2;
        DEFAULT = resourceCreate.merge(resourceCreate2);
    }

    public static Resource getDefault() {
        return DEFAULT;
    }

    public static Resource empty() {
        return EMPTY;
    }

    public static Resource create(Attributes attributes) {
        return create(attributes, null);
    }

    public static Resource create(Attributes attributes, @Nullable String str) {
        checkAttributes((Attributes) Objects.requireNonNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES));
        return new AutoValue_Resource(str, attributes);
    }

    private static String readVersion() {
        Properties properties = new Properties();
        try {
            properties.load(Resource.class.getResourceAsStream("/io/opentelemetry/sdk/common/version.properties"));
            return properties.getProperty("sdk.version", "unknown");
        } catch (Exception unused) {
            return "unknown";
        }
    }

    @Nullable
    public <T> T getAttribute(AttributeKey<T> attributeKey) {
        return (T) getAttributes().get(attributeKey);
    }

    public Resource merge(@Nullable Resource resource) {
        if (resource == null || resource == EMPTY) {
            return this;
        }
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        attributesBuilderBuilder.putAll(getAttributes());
        attributesBuilderBuilder.putAll(resource.getAttributes());
        if (resource.getSchemaUrl() == null) {
            return create(attributesBuilderBuilder.build(), getSchemaUrl());
        }
        if (getSchemaUrl() == null) {
            return create(attributesBuilderBuilder.build(), resource.getSchemaUrl());
        }
        if (!resource.getSchemaUrl().equals(getSchemaUrl())) {
            logger.info("Attempting to merge Resources with different schemaUrls. The resulting Resource will have no schemaUrl assigned. Schema 1: " + getSchemaUrl() + " Schema 2: " + resource.getSchemaUrl());
            return create(attributesBuilderBuilder.build(), null);
        }
        return create(attributesBuilderBuilder.build(), getSchemaUrl());
    }

    private static void checkAttributes(Attributes attributes) {
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.resources.Resource$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Resource.lambda$checkAttributes$0((AttributeKey) obj, obj2);
            }
        });
    }

    static /* synthetic */ void lambda$checkAttributes$0(AttributeKey attributeKey, Object obj) {
        Utils.checkArgument(isValidAndNotEmpty(attributeKey), "Attribute key should be a ASCII string with a length greater than 0 and not exceed 255 characters.");
        Objects.requireNonNull(obj, "Attribute value should be a ASCII string with a length not exceed 255 characters.");
    }

    private static boolean isValid(String str) {
        return str.length() <= 255 && StringUtils.isPrintableString(str);
    }

    private static boolean isValidAndNotEmpty(AttributeKey<?> attributeKey) {
        return !attributeKey.getKey().isEmpty() && isValid(attributeKey.getKey());
    }

    public static ResourceBuilder builder() {
        return new ResourceBuilder();
    }

    public ResourceBuilder toBuilder() {
        ResourceBuilder resourceBuilderPutAll = builder().putAll(this);
        if (getSchemaUrl() != null) {
            resourceBuilderPutAll.setSchemaUrl(getSchemaUrl());
        }
        return resourceBuilderPutAll;
    }

    Resource() {
    }
}
