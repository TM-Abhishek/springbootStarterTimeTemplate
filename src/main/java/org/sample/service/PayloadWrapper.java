package org.sample.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"data", "meta", "errors"})
public class PayloadWrapper implements Serializable {

    @JsonProperty("data")
    private Object data;
    @JsonProperty("meta")
    private MetaInfo meta;
    private String errorCode;

    public PayloadWrapper(Object data, MetaInfo meta) {
        this.data = data;
        this.meta = meta;
    }

    public static PayloadWrapper generateResponse(Object data, MetaInfo metaInfo) {
        PayloadWrapper payloadWrapper = new PayloadWrapper();
        MetaInfo meta = metaInfo == null ? new MetaInfo() : metaInfo;
        payloadWrapper.setData(data);
        payloadWrapper.setMeta(meta);
        return payloadWrapper;
    }
}
