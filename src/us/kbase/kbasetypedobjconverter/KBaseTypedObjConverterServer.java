package us.kbase.kbasetypedobjconverter;

import java.util.Map;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonServerMethod;
import us.kbase.common.service.JsonServerServlet;
import us.kbase.common.service.Tuple11;
import us.kbase.workspace.ObjectIdentity;

//BEGIN_HEADER
//END_HEADER

/**
 * <p>Original spec-file module name: KBaseTypedObjConverter</p>
 * <pre>
 * Typed Object Converter Service
 * </pre>
 */
public class KBaseTypedObjConverterServer extends JsonServerServlet {
    private static final long serialVersionUID = 1L;

    //BEGIN_CLASS_HEADER
    //END_CLASS_HEADER

    public KBaseTypedObjConverterServer() throws Exception {
        super("KBaseTypedObjConverter");
        //BEGIN_CONSTRUCTOR
        //END_CONSTRUCTOR
    }

    /**
     * <p>Original spec-file function name: validate_simple_converter</p>
     * <pre>
     * </pre>
     * @param   c   instance of type {@link us.kbase.kbasetypedobjconverter.SimpleConverter SimpleConverter}
     * @return   parameter "report" of type {@link us.kbase.kbasetypedobjconverter.ConverterValidationReport ConverterValidationReport}
     */
    @JsonServerMethod(rpc = "KBaseTypedObjConverter.validate_simple_converter")
    public ConverterValidationReport validateSimpleConverter(SimpleConverter c) throws Exception {
        ConverterValidationReport returnVal = null;
        //BEGIN validate_simple_converter
        //END validate_simple_converter
        return returnVal;
    }

    /**
     * <p>Original spec-file function name: save_simple_converter</p>
     * <pre>
     * </pre>
     * @param   c   instance of type {@link us.kbase.kbasetypedobjconverter.SimpleConverter SimpleConverter}
     * @param   target   instance of type {@link us.kbase.workspace.ObjectIdentity ObjectIdentity}
     * @return   instance of original type "object_info" (Information about an object, including user provided metadata. obj_id objid - the numerical id of the object. obj_name name - the name of the object. type_string type - the type of the object. timestamp save_date - the save date of the object. obj_ver ver - the version of the object. username saved_by - the user that saved or copied the object. ws_id wsid - the workspace containing the object. ws_name workspace - the workspace containing the object. string chsum - the md5 checksum of the object. int size - the size of the object in bytes. usermeta meta - arbitrary user-supplied metadata about the object.) &rarr; tuple of size 11: parameter "objid" of original type "obj_id" (The unique, permanent numerical ID of an object.), parameter "name" of original type "obj_name" (A string used as a name for an object. Any string consisting of alphanumeric characters and the characters |._- that is not an integer is acceptable.), parameter "type" of original type "type_string" (A type string. Specifies the type and its version in a single string in the format [module].[typename]-[major].[minor]: module - a string. The module name of the typespec containing the type. typename - a string. The name of the type as assigned by the typedef statement. major - an integer. The major version of the type. A change in the major version implies the type has changed in a non-backwards compatible way. minor - an integer. The minor version of the type. A change in the minor version implies that the type has changed in a way that is backwards compatible with previous type definitions. In many cases, the major and minor versions are optional, and if not provided the most recent version will be used. Example: MyModule.MyType-3.1), parameter "save_date" of original type "timestamp" (A time in the format YYYY-MM-DDThh:mm:ssZ, where Z is either the character Z (representing the UTC timezone) or the difference in time to UTC in the format +/-HHMM, eg: 2012-12-17T23:24:06-0500 (EST time) 2013-04-03T08:56:32+0000 (UTC time) 2013-04-03T08:56:32Z (UTC time)), parameter "version" of Long, parameter "saved_by" of original type "username" (Login name of a KBase user account.), parameter "wsid" of original type "ws_id" (The unique, permanent numerical ID of a workspace.), parameter "workspace" of original type "ws_name" (A string used as a name for a workspace. Any string consisting of alphanumeric characters and "_", ".", or "-" that is not an integer is acceptable. The name may optionally be prefixed with the workspace owner's user name and a colon, e.g. kbasetest:my_workspace.), parameter "chsum" of String, parameter "size" of Long, parameter "meta" of original type "usermeta" (User provided metadata about an object. Arbitrary key-value pairs provided by the user.) &rarr; mapping from String to String
     */
    @JsonServerMethod(rpc = "KBaseTypedObjConverter.save_simple_converter")
    public Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String,String>> saveSimpleConverter(SimpleConverter c, ObjectIdentity target, AuthToken authPart) throws Exception {
        Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String,String>> returnVal = null;
        //BEGIN save_simple_converter
        //END save_simple_converter
        return returnVal;
    }

    /**
     * <p>Original spec-file function name: simple_convert</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.kbasetypedobjconverter.SimpleConvertParams SimpleConvertParams}
     * @return   instance of original type "object_info" (Information about an object, including user provided metadata. obj_id objid - the numerical id of the object. obj_name name - the name of the object. type_string type - the type of the object. timestamp save_date - the save date of the object. obj_ver ver - the version of the object. username saved_by - the user that saved or copied the object. ws_id wsid - the workspace containing the object. ws_name workspace - the workspace containing the object. string chsum - the md5 checksum of the object. int size - the size of the object in bytes. usermeta meta - arbitrary user-supplied metadata about the object.) &rarr; tuple of size 11: parameter "objid" of original type "obj_id" (The unique, permanent numerical ID of an object.), parameter "name" of original type "obj_name" (A string used as a name for an object. Any string consisting of alphanumeric characters and the characters |._- that is not an integer is acceptable.), parameter "type" of original type "type_string" (A type string. Specifies the type and its version in a single string in the format [module].[typename]-[major].[minor]: module - a string. The module name of the typespec containing the type. typename - a string. The name of the type as assigned by the typedef statement. major - an integer. The major version of the type. A change in the major version implies the type has changed in a non-backwards compatible way. minor - an integer. The minor version of the type. A change in the minor version implies that the type has changed in a way that is backwards compatible with previous type definitions. In many cases, the major and minor versions are optional, and if not provided the most recent version will be used. Example: MyModule.MyType-3.1), parameter "save_date" of original type "timestamp" (A time in the format YYYY-MM-DDThh:mm:ssZ, where Z is either the character Z (representing the UTC timezone) or the difference in time to UTC in the format +/-HHMM, eg: 2012-12-17T23:24:06-0500 (EST time) 2013-04-03T08:56:32+0000 (UTC time) 2013-04-03T08:56:32Z (UTC time)), parameter "version" of Long, parameter "saved_by" of original type "username" (Login name of a KBase user account.), parameter "wsid" of original type "ws_id" (The unique, permanent numerical ID of a workspace.), parameter "workspace" of original type "ws_name" (A string used as a name for a workspace. Any string consisting of alphanumeric characters and "_", ".", or "-" that is not an integer is acceptable. The name may optionally be prefixed with the workspace owner's user name and a colon, e.g. kbasetest:my_workspace.), parameter "chsum" of String, parameter "size" of Long, parameter "meta" of original type "usermeta" (User provided metadata about an object. Arbitrary key-value pairs provided by the user.) &rarr; mapping from String to String
     */
    @JsonServerMethod(rpc = "KBaseTypedObjConverter.simple_convert")
    public Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String,String>> simpleConvert(SimpleConvertParams params, AuthToken authPart) throws Exception {
        Tuple11<Long, String, String, String, Long, String, Long, String, String, Long, Map<String,String>> returnVal = null;
        //BEGIN simple_convert
        //END simple_convert
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: <program> <server_port>");
            return;
        }
        new KBaseTypedObjConverterServer().startupServer(Integer.parseInt(args[0]));
    }
}
