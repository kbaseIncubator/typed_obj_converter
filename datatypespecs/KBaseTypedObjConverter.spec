/*
Typed Object Converter
For testing only...
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
    
    /* 
      @optional long_name
      @meta ws long_name as Long Name
      @meta ws description as Description
    */
    typedef structure {
        string long_name;
        string description;
        list <Type> accepted_input_types;
        Type output_type;
        list <Operation> operations;
    } SimpleConverter;
    
};
