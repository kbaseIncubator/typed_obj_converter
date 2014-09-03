
package us.kbase.kbasetypedobjconverter;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import us.kbase.workspace.ObjectIdentity;


/**
 * <p>Original spec-file type: SimpleConvertParams</p>
 * <pre>
 * Specify an input typed data object to convert, the output destination of the converted object, and
 * the simple converter to use.  Optionally specify a Workspace endpoint.  If a workspace_url is not
 * provided, then the configured Workspace url is used, which will generally be the production endpoint
 * if this service is deployed to production, or the dev endpoint if this service is deployed to dev.
 * @optional workspace_url
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "input",
    "output",
    "simple_converter",
    "workspace_url"
})
public class SimpleConvertParams {

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("input")
    private ObjectIdentity input;
    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("output")
    private ObjectIdentity output;
    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("simple_converter")
    private ObjectIdentity simpleConverter;
    @JsonProperty("workspace_url")
    private String workspaceUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("input")
    public ObjectIdentity getInput() {
        return input;
    }

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("input")
    public void setInput(ObjectIdentity input) {
        this.input = input;
    }

    public SimpleConvertParams withInput(ObjectIdentity input) {
        this.input = input;
        return this;
    }

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("output")
    public ObjectIdentity getOutput() {
        return output;
    }

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("output")
    public void setOutput(ObjectIdentity output) {
        this.output = output;
    }

    public SimpleConvertParams withOutput(ObjectIdentity output) {
        this.output = output;
        return this;
    }

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("simple_converter")
    public ObjectIdentity getSimpleConverter() {
        return simpleConverter;
    }

    /**
     * <p>Original spec-file type: ObjectIdentity</p>
     * <pre>
     * An object identifier.
     * Select an object by either:
     *         One, and only one, of the numerical id or name of the workspace,
     *         where the name can also be a KBase ID including the numerical id,
     *         e.g. kb|ws.35.
     *                 ws_id wsid - the numerical ID of the workspace.
     *                 ws_name workspace - name of the workspace or the workspace ID
     *                         in KBase format, e.g. kb|ws.78.
     *         AND 
     *         One, and only one, of the numerical id or name of the object.
     *                 obj_id objid- the numerical ID of the object.
     *                 obj_name name - name of the object.
     *         OPTIONALLY
     *                 obj_ver ver - the version of the object.
     * OR an object reference string:
     *         obj_ref ref - an object reference string.
     * </pre>
     * 
     */
    @JsonProperty("simple_converter")
    public void setSimpleConverter(ObjectIdentity simpleConverter) {
        this.simpleConverter = simpleConverter;
    }

    public SimpleConvertParams withSimpleConverter(ObjectIdentity simpleConverter) {
        this.simpleConverter = simpleConverter;
        return this;
    }

    @JsonProperty("workspace_url")
    public String getWorkspaceUrl() {
        return workspaceUrl;
    }

    @JsonProperty("workspace_url")
    public void setWorkspaceUrl(String workspaceUrl) {
        this.workspaceUrl = workspaceUrl;
    }

    public SimpleConvertParams withWorkspaceUrl(String workspaceUrl) {
        this.workspaceUrl = workspaceUrl;
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
        return ((((((((((("SimpleConvertParams"+" [input=")+ input)+", output=")+ output)+", simpleConverter=")+ simpleConverter)+", workspaceUrl=")+ workspaceUrl)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
