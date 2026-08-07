package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: loaded from: classes3.dex */
class CurrentNetworkAttributesExtractor {
    CurrentNetworkAttributesExtractor() {
    }

    Attributes extract(CurrentNetwork currentNetwork) {
        AttributesBuilder attributesBuilderPut = Attributes.builder().put(SemanticAttributes.NET_HOST_CONNECTION_TYPE, currentNetwork.getState().getHumanName());
        setIfNotNull(attributesBuilderPut, SemanticAttributes.NET_HOST_CONNECTION_SUBTYPE, currentNetwork.getSubType());
        setIfNotNull(attributesBuilderPut, SemanticAttributes.NET_HOST_CARRIER_NAME, currentNetwork.getCarrierName());
        setIfNotNull(attributesBuilderPut, SemanticAttributes.NET_HOST_CARRIER_MCC, currentNetwork.getCarrierCountryCode());
        setIfNotNull(attributesBuilderPut, SemanticAttributes.NET_HOST_CARRIER_MNC, currentNetwork.getCarrierNetworkCode());
        setIfNotNull(attributesBuilderPut, SemanticAttributes.NET_HOST_CARRIER_ICC, currentNetwork.getCarrierIsoCountryCode());
        return attributesBuilderPut.build();
    }

    private static void setIfNotNull(AttributesBuilder attributesBuilder, AttributeKey<String> attributeKey, String str) {
        if (str != null) {
            attributesBuilder.put(attributeKey, str);
        }
    }
}
