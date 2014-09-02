
#include <../workspace_deluxe/workspace.spec>

/*
Typed Object Converter Service
*/
module KBaseTypedObjConverter {

    /* @range [0,1] */
    typedef int bool;

    /*  */
    typedef string type_mapper;

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
        string mapper;
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
    
    
    /* */
    typedef structure {
        Workspace.ObjectIdentity input;
        Workspace.ObjectIdentity output;
        Workspace.ObjectIdentity simple_converter;
        string workspace_url;
    } SimpleConvertParams;

    /*  */
    funcdef simple_convert(SimpleConvertParams params) returns (Workspace.object_info) authentication required;
    
    
    
    
    
    
    
    
    
    
    /*
    PROTOTYPES ....
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




