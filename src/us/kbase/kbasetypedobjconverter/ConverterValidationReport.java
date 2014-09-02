
package us.kbase.kbasetypedobjconverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * <p>Original spec-file type: ConverterValidationReport</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "is_valid",
    "errors"
})
public class ConverterValidationReport {

    @JsonProperty("is_valid")
    private Long isValid;
    @JsonProperty("errors")
    private List<String> errors;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    @JsonProperty("is_valid")
    public Long getIsValid() {
        return isValid;
    }

    @JsonProperty("is_valid")
    public void setIsValid(Long isValid) {
        this.isValid = isValid;
    }

    public ConverterValidationReport withIsValid(Long isValid) {
        this.isValid = isValid;
        return this;
    }

    @JsonProperty("errors")
    public List<String> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ConverterValidationReport withErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public java.lang.String toString() {
        return ((((((("ConverterValidationReport"+" [isValid=")+ isValid)+", errors=")+ errors)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
