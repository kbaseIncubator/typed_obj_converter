
#include <../workspace_deluxe/workspace.spec>

/*
Typed Object Converter Service
*/
module KBaseTypedObjConverter {

    /* @range [0,1] */
    typedef int bool;

    /*  */
    typedef structure {
    	string operation;
    	UnspecifiedObject spec;
    } Operation;

    /*  */
    typedef structure {
        string mod;
        string name;
        string ver;
    } Type;
    
    /*  */
    typedef structure {
        string long_name;
        string description;
        list <Type> accepted_input_types;
        Type output_type;
        list <Operation> operations;
    } SimpleConverter;
    
    
    /*  */
    typedef structure {
        bool is_valid;
        list <string> errors;
    } ConverterValidationReport;
    
    /*  */
    funcdef validate_simple_converter(SimpleConverter c) returns (ConverterValidationReport report);
    
    /*  */
    funcdef save_simple_converter(SimpleConverter c, Workspace.ObjectIdentity target) returns (Workspace.object_info) authentication required;
    
    
    
    
    /*
        Specify an input typed data object to convert, the output destination of the converted object, and
        the simple converter to use.  Optionally specify a Workspace endpoint.  If a workspace_url is not
        provided, then the configured Workspace url is used, which will generally be the production endpoint
        if this service is deployed to production, or the dev endpoint if this service is deployed to dev.
        @optional workspace_url
    */
    typedef structure {
        Workspace.ObjectIdentity input;
        Workspace.ObjectIdentity output;
        Workspace.ObjectIdentity simple_converter;
        string workspace_url;
    } SimpleConvertParams;

    /*  */
    funcdef convert_simple(SimpleConvertParams params) returns (Workspace.object_info) authentication required;
    
    

    
    
    
    
    /*
    PROTOTYPES ....
    
    typedef structure {
        string name;
        string version;
        string description;
        
    } BuiltInConverterInfo;
    
    
    funcdef convert() returns (list<Workspace.object_info>) authentication required;
    
    
    typedef structure {
        string 
    
    } ConverterInput;

    typedef structure {
        string name;
        string version;
        string description;
        list <ConverterInputSpecification> accepted_input;
        list <ConverterOutputSpecification> output;
    } Converter;



    typedef structure {
        list <
    
    } ConversionParameters;


    funcdef convert(ConversionParameters cp) returns ;
    */
    
    
    
    
    
    
};




