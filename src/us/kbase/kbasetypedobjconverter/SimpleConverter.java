
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
 * <p>Original spec-file type: SimpleConverter</p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "long_name",
    "description",
    "accepted_input_types",
    "output_type",
    "mapper"
})
public class SimpleConverter {

    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("accepted_input_types")
    private List<us.kbase.kbasetypedobjconverter.Type> acceptedInputTypes;
    /**
     * <p>Original spec-file type: Type</p>
     * 
     * 
     */
    @JsonProperty("output_type")
    private us.kbase.kbasetypedobjconverter.Type outputType;
    @JsonProperty("mapper")
    private String mapper;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("long_name")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("long_name")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public SimpleConverter withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SimpleConverter withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("accepted_input_types")
    public List<us.kbase.kbasetypedobjconverter.Type> getAcceptedInputTypes() {
        return acceptedInputTypes;
    }

    @JsonProperty("accepted_input_types")
    public void setAcceptedInputTypes(List<us.kbase.kbasetypedobjconverter.Type> acceptedInputTypes) {
        this.acceptedInputTypes = acceptedInputTypes;
    }

    public SimpleConverter withAcceptedInputTypes(List<us.kbase.kbasetypedobjconverter.Type> acceptedInputTypes) {
        this.acceptedInputTypes = acceptedInputTypes;
        return this;
    }

    /**
     * <p>Original spec-file type: Type</p>
     * 
     * 
     */
    @JsonProperty("output_type")
    public us.kbase.kbasetypedobjconverter.Type getOutputType() {
        return outputType;
    }

    /**
     * <p>Original spec-file type: Type</p>
     * 
     * 
     */
    @JsonProperty("output_type")
    public void setOutputType(us.kbase.kbasetypedobjconverter.Type outputType) {
        this.outputType = outputType;
    }

    public SimpleConverter withOutputType(us.kbase.kbasetypedobjconverter.Type outputType) {
        this.outputType = outputType;
        return this;
    }

    @JsonProperty("mapper")
    public String getMapper() {
        return mapper;
    }

    @JsonProperty("mapper")
    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    public SimpleConverter withMapper(String mapper) {
        this.mapper = mapper;
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
        return ((((((((((((("SimpleConverter"+" [longName=")+ longName)+", description=")+ description)+", acceptedInputTypes=")+ acceptedInputTypes)+", outputType=")+ outputType)+", mapper=")+ mapper)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
