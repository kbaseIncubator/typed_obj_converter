
package us.kbase.kbasetypedobjconverter;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import us.kbase.common.service.UObject;


/**
 * <p>Original spec-file type: Operation</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "operation",
    "spec"
})
public class Operation {

    @JsonProperty("operation")
    private String operation;
    @JsonProperty("spec")
    private UObject spec;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Operation withOperation(String operation) {
        this.operation = operation;
        return this;
    }

    @JsonProperty("spec")
    public UObject getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(UObject spec) {
        this.spec = spec;
    }

    public Operation withSpec(UObject spec) {
        this.spec = spec;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return ((((((("Operation"+" [operation=")+ operation)+", spec=")+ spec)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
