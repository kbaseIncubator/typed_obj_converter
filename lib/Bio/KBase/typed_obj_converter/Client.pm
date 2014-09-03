package Bio::KBase::typed_obj_converter::Client;

use JSON::RPC::Client;
use strict;
use Data::Dumper;
use URI;
use Bio::KBase::Exceptions;
use Bio::KBase::AuthToken;

# Client version should match Impl version
# This is a Semantic Version number,
# http://semver.org
our $VERSION = "0.1.0";

=head1 NAME

Bio::KBase::typed_obj_converter::Client

=head1 DESCRIPTION


Typed Object Converter Service


=cut

sub new
{
    my($class, $url, @args) = @_;
    
    if (!defined($url))
    {
	$url = 'https://kbase.us/services/typed_obj_converter/';
    }

    my $self = {
	client => Bio::KBase::typed_obj_converter::Client::RpcClient->new,
	url => $url,
    };

    #
    # This module requires authentication.
    #
    # We create an auth token, passing through the arguments that we were (hopefully) given.

    {
	my $token = Bio::KBase::AuthToken->new(@args);
	
	if (!$token->error_message)
	{
	    $self->{token} = $token->token;
	    $self->{client}->{token} = $token->token;
	}
    }

    my $ua = $self->{client}->ua;	 
    my $timeout = $ENV{CDMI_TIMEOUT} || (30 * 60);	 
    $ua->timeout($timeout);
    bless $self, $class;
    #    $self->_validate_version();
    return $self;
}




=head2 validate_simple_converter

  $report = $obj->validate_simple_converter($c)

=over 4

=item Parameter and return types

=begin html

<pre>
$c is a KBaseTypedObjConverter.SimpleConverter
$report is a KBaseTypedObjConverter.ConverterValidationReport
SimpleConverter is a reference to a hash where the following keys are defined:
	long_name has a value which is a string
	description has a value which is a string
	accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
	output_type has a value which is a KBaseTypedObjConverter.Type
	operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation
Type is a reference to a hash where the following keys are defined:
	mod has a value which is a string
	name has a value which is a string
	ver has a value which is a string
Operation is a reference to a hash where the following keys are defined:
	operation has a value which is a string
	spec has a value which is an UnspecifiedObject, which can hold any non-null object
ConverterValidationReport is a reference to a hash where the following keys are defined:
	is_valid has a value which is a KBaseTypedObjConverter.bool
	errors has a value which is a reference to a list where each element is a string
bool is an int

</pre>

=end html

=begin text

$c is a KBaseTypedObjConverter.SimpleConverter
$report is a KBaseTypedObjConverter.ConverterValidationReport
SimpleConverter is a reference to a hash where the following keys are defined:
	long_name has a value which is a string
	description has a value which is a string
	accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
	output_type has a value which is a KBaseTypedObjConverter.Type
	operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation
Type is a reference to a hash where the following keys are defined:
	mod has a value which is a string
	name has a value which is a string
	ver has a value which is a string
Operation is a reference to a hash where the following keys are defined:
	operation has a value which is a string
	spec has a value which is an UnspecifiedObject, which can hold any non-null object
ConverterValidationReport is a reference to a hash where the following keys are defined:
	is_valid has a value which is a KBaseTypedObjConverter.bool
	errors has a value which is a reference to a list where each element is a string
bool is an int


=end text

=item Description



=back

=cut

sub validate_simple_converter
{
    my($self, @args) = @_;

# Authentication: none

    if ((my $n = @args) != 1)
    {
	Bio::KBase::Exceptions::ArgumentValidationError->throw(error =>
							       "Invalid argument count for function validate_simple_converter (received $n, expecting 1)");
    }
    {
	my($c) = @args;

	my @_bad_arguments;
        (ref($c) eq 'HASH') or push(@_bad_arguments, "Invalid type for argument 1 \"c\" (value was \"$c\")");
        if (@_bad_arguments) {
	    my $msg = "Invalid arguments passed to validate_simple_converter:\n" . join("", map { "\t$_\n" } @_bad_arguments);
	    Bio::KBase::Exceptions::ArgumentValidationError->throw(error => $msg,
								   method_name => 'validate_simple_converter');
	}
    }

    my $result = $self->{client}->call($self->{url}, {
	method => "KBaseTypedObjConverter.validate_simple_converter",
	params => \@args,
    });
    if ($result) {
	if ($result->is_error) {
	    Bio::KBase::Exceptions::JSONRPC->throw(error => $result->error_message,
					       code => $result->content->{error}->{code},
					       method_name => 'validate_simple_converter',
					       data => $result->content->{error}->{error} # JSON::RPC::ReturnObject only supports JSONRPC 1.1 or 1.O
					      );
	} else {
	    return wantarray ? @{$result->result} : $result->result->[0];
	}
    } else {
        Bio::KBase::Exceptions::HTTP->throw(error => "Error invoking method validate_simple_converter",
					    status_line => $self->{client}->status_line,
					    method_name => 'validate_simple_converter',
				       );
    }
}



=head2 save_simple_converter

  $return = $obj->save_simple_converter($c, $target)

=over 4

=item Parameter and return types

=begin html

<pre>
$c is a KBaseTypedObjConverter.SimpleConverter
$target is a Workspace.ObjectIdentity
$return is a Workspace.object_info
SimpleConverter is a reference to a hash where the following keys are defined:
	long_name has a value which is a string
	description has a value which is a string
	accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
	output_type has a value which is a KBaseTypedObjConverter.Type
	operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation
Type is a reference to a hash where the following keys are defined:
	mod has a value which is a string
	name has a value which is a string
	ver has a value which is a string
Operation is a reference to a hash where the following keys are defined:
	operation has a value which is a string
	spec has a value which is an UnspecifiedObject, which can hold any non-null object
Workspace.ObjectIdentity is a reference to a hash where the following keys are defined:
	workspace has a value which is a Workspace.ws_name
	wsid has a value which is a Workspace.ws_id
	name has a value which is a Workspace.obj_name
	objid has a value which is a Workspace.obj_id
	ver has a value which is a Workspace.obj_ver
	ref has a value which is a Workspace.obj_ref
Workspace.ws_name is a string
Workspace.ws_id is an int
Workspace.obj_name is a string
Workspace.obj_id is an int
Workspace.obj_ver is an int
Workspace.obj_ref is a string
Workspace.object_info is a reference to a list containing 11 items:
	0: (objid) a Workspace.obj_id
	1: (name) a Workspace.obj_name
	2: (type) a Workspace.type_string
	3: (save_date) a Workspace.timestamp
	4: (version) an int
	5: (saved_by) a Workspace.username
	6: (wsid) a Workspace.ws_id
	7: (workspace) a Workspace.ws_name
	8: (chsum) a string
	9: (size) an int
	10: (meta) a Workspace.usermeta
Workspace.type_string is a string
Workspace.timestamp is a string
Workspace.username is a string
Workspace.usermeta is a reference to a hash where the key is a string and the value is a string

</pre>

=end html

=begin text

$c is a KBaseTypedObjConverter.SimpleConverter
$target is a Workspace.ObjectIdentity
$return is a Workspace.object_info
SimpleConverter is a reference to a hash where the following keys are defined:
	long_name has a value which is a string
	description has a value which is a string
	accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
	output_type has a value which is a KBaseTypedObjConverter.Type
	operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation
Type is a reference to a hash where the following keys are defined:
	mod has a value which is a string
	name has a value which is a string
	ver has a value which is a string
Operation is a reference to a hash where the following keys are defined:
	operation has a value which is a string
	spec has a value which is an UnspecifiedObject, which can hold any non-null object
Workspace.ObjectIdentity is a reference to a hash where the following keys are defined:
	workspace has a value which is a Workspace.ws_name
	wsid has a value which is a Workspace.ws_id
	name has a value which is a Workspace.obj_name
	objid has a value which is a Workspace.obj_id
	ver has a value which is a Workspace.obj_ver
	ref has a value which is a Workspace.obj_ref
Workspace.ws_name is a string
Workspace.ws_id is an int
Workspace.obj_name is a string
Workspace.obj_id is an int
Workspace.obj_ver is an int
Workspace.obj_ref is a string
Workspace.object_info is a reference to a list containing 11 items:
	0: (objid) a Workspace.obj_id
	1: (name) a Workspace.obj_name
	2: (type) a Workspace.type_string
	3: (save_date) a Workspace.timestamp
	4: (version) an int
	5: (saved_by) a Workspace.username
	6: (wsid) a Workspace.ws_id
	7: (workspace) a Workspace.ws_name
	8: (chsum) a string
	9: (size) an int
	10: (meta) a Workspace.usermeta
Workspace.type_string is a string
Workspace.timestamp is a string
Workspace.username is a string
Workspace.usermeta is a reference to a hash where the key is a string and the value is a string


=end text

=item Description



=back

=cut

sub save_simple_converter
{
    my($self, @args) = @_;

# Authentication: required

    if ((my $n = @args) != 2)
    {
	Bio::KBase::Exceptions::ArgumentValidationError->throw(error =>
							       "Invalid argument count for function save_simple_converter (received $n, expecting 2)");
    }
    {
	my($c, $target) = @args;

	my @_bad_arguments;
        (ref($c) eq 'HASH') or push(@_bad_arguments, "Invalid type for argument 1 \"c\" (value was \"$c\")");
        (ref($target) eq 'HASH') or push(@_bad_arguments, "Invalid type for argument 2 \"target\" (value was \"$target\")");
        if (@_bad_arguments) {
	    my $msg = "Invalid arguments passed to save_simple_converter:\n" . join("", map { "\t$_\n" } @_bad_arguments);
	    Bio::KBase::Exceptions::ArgumentValidationError->throw(error => $msg,
								   method_name => 'save_simple_converter');
	}
    }

    my $result = $self->{client}->call($self->{url}, {
	method => "KBaseTypedObjConverter.save_simple_converter",
	params => \@args,
    });
    if ($result) {
	if ($result->is_error) {
	    Bio::KBase::Exceptions::JSONRPC->throw(error => $result->error_message,
					       code => $result->content->{error}->{code},
					       method_name => 'save_simple_converter',
					       data => $result->content->{error}->{error} # JSON::RPC::ReturnObject only supports JSONRPC 1.1 or 1.O
					      );
	} else {
	    return wantarray ? @{$result->result} : $result->result->[0];
	}
    } else {
        Bio::KBase::Exceptions::HTTP->throw(error => "Error invoking method save_simple_converter",
					    status_line => $self->{client}->status_line,
					    method_name => 'save_simple_converter',
				       );
    }
}



=head2 convert_simple

  $return = $obj->convert_simple($params)

=over 4

=item Parameter and return types

=begin html

<pre>
$params is a KBaseTypedObjConverter.SimpleConvertParams
$return is a Workspace.object_info
SimpleConvertParams is a reference to a hash where the following keys are defined:
	input has a value which is a Workspace.ObjectIdentity
	output has a value which is a Workspace.ObjectIdentity
	simple_converter has a value which is a Workspace.ObjectIdentity
	workspace_url has a value which is a string
Workspace.ObjectIdentity is a reference to a hash where the following keys are defined:
	workspace has a value which is a Workspace.ws_name
	wsid has a value which is a Workspace.ws_id
	name has a value which is a Workspace.obj_name
	objid has a value which is a Workspace.obj_id
	ver has a value which is a Workspace.obj_ver
	ref has a value which is a Workspace.obj_ref
Workspace.ws_name is a string
Workspace.ws_id is an int
Workspace.obj_name is a string
Workspace.obj_id is an int
Workspace.obj_ver is an int
Workspace.obj_ref is a string
Workspace.object_info is a reference to a list containing 11 items:
	0: (objid) a Workspace.obj_id
	1: (name) a Workspace.obj_name
	2: (type) a Workspace.type_string
	3: (save_date) a Workspace.timestamp
	4: (version) an int
	5: (saved_by) a Workspace.username
	6: (wsid) a Workspace.ws_id
	7: (workspace) a Workspace.ws_name
	8: (chsum) a string
	9: (size) an int
	10: (meta) a Workspace.usermeta
Workspace.type_string is a string
Workspace.timestamp is a string
Workspace.username is a string
Workspace.usermeta is a reference to a hash where the key is a string and the value is a string

</pre>

=end html

=begin text

$params is a KBaseTypedObjConverter.SimpleConvertParams
$return is a Workspace.object_info
SimpleConvertParams is a reference to a hash where the following keys are defined:
	input has a value which is a Workspace.ObjectIdentity
	output has a value which is a Workspace.ObjectIdentity
	simple_converter has a value which is a Workspace.ObjectIdentity
	workspace_url has a value which is a string
Workspace.ObjectIdentity is a reference to a hash where the following keys are defined:
	workspace has a value which is a Workspace.ws_name
	wsid has a value which is a Workspace.ws_id
	name has a value which is a Workspace.obj_name
	objid has a value which is a Workspace.obj_id
	ver has a value which is a Workspace.obj_ver
	ref has a value which is a Workspace.obj_ref
Workspace.ws_name is a string
Workspace.ws_id is an int
Workspace.obj_name is a string
Workspace.obj_id is an int
Workspace.obj_ver is an int
Workspace.obj_ref is a string
Workspace.object_info is a reference to a list containing 11 items:
	0: (objid) a Workspace.obj_id
	1: (name) a Workspace.obj_name
	2: (type) a Workspace.type_string
	3: (save_date) a Workspace.timestamp
	4: (version) an int
	5: (saved_by) a Workspace.username
	6: (wsid) a Workspace.ws_id
	7: (workspace) a Workspace.ws_name
	8: (chsum) a string
	9: (size) an int
	10: (meta) a Workspace.usermeta
Workspace.type_string is a string
Workspace.timestamp is a string
Workspace.username is a string
Workspace.usermeta is a reference to a hash where the key is a string and the value is a string


=end text

=item Description



=back

=cut

sub convert_simple
{
    my($self, @args) = @_;

# Authentication: required

    if ((my $n = @args) != 1)
    {
	Bio::KBase::Exceptions::ArgumentValidationError->throw(error =>
							       "Invalid argument count for function convert_simple (received $n, expecting 1)");
    }
    {
	my($params) = @args;

	my @_bad_arguments;
        (ref($params) eq 'HASH') or push(@_bad_arguments, "Invalid type for argument 1 \"params\" (value was \"$params\")");
        if (@_bad_arguments) {
	    my $msg = "Invalid arguments passed to convert_simple:\n" . join("", map { "\t$_\n" } @_bad_arguments);
	    Bio::KBase::Exceptions::ArgumentValidationError->throw(error => $msg,
								   method_name => 'convert_simple');
	}
    }

    my $result = $self->{client}->call($self->{url}, {
	method => "KBaseTypedObjConverter.convert_simple",
	params => \@args,
    });
    if ($result) {
	if ($result->is_error) {
	    Bio::KBase::Exceptions::JSONRPC->throw(error => $result->error_message,
					       code => $result->content->{error}->{code},
					       method_name => 'convert_simple',
					       data => $result->content->{error}->{error} # JSON::RPC::ReturnObject only supports JSONRPC 1.1 or 1.O
					      );
	} else {
	    return wantarray ? @{$result->result} : $result->result->[0];
	}
    } else {
        Bio::KBase::Exceptions::HTTP->throw(error => "Error invoking method convert_simple",
					    status_line => $self->{client}->status_line,
					    method_name => 'convert_simple',
				       );
    }
}



sub version {
    my ($self) = @_;
    my $result = $self->{client}->call($self->{url}, {
        method => "KBaseTypedObjConverter.version",
        params => [],
    });
    if ($result) {
        if ($result->is_error) {
            Bio::KBase::Exceptions::JSONRPC->throw(
                error => $result->error_message,
                code => $result->content->{code},
                method_name => 'convert_simple',
            );
        } else {
            return wantarray ? @{$result->result} : $result->result->[0];
        }
    } else {
        Bio::KBase::Exceptions::HTTP->throw(
            error => "Error invoking method convert_simple",
            status_line => $self->{client}->status_line,
            method_name => 'convert_simple',
        );
    }
}

sub _validate_version {
    my ($self) = @_;
    my $svr_version = $self->version();
    my $client_version = $VERSION;
    my ($cMajor, $cMinor) = split(/\./, $client_version);
    my ($sMajor, $sMinor) = split(/\./, $svr_version);
    if ($sMajor != $cMajor) {
        Bio::KBase::Exceptions::ClientServerIncompatible->throw(
            error => "Major version numbers differ.",
            server_version => $svr_version,
            client_version => $client_version
        );
    }
    if ($sMinor < $cMinor) {
        Bio::KBase::Exceptions::ClientServerIncompatible->throw(
            error => "Client minor version greater than Server minor version.",
            server_version => $svr_version,
            client_version => $client_version
        );
    }
    if ($sMinor > $cMinor) {
        warn "New client version available for Bio::KBase::typed_obj_converter::Client\n";
    }
    if ($sMajor == 0) {
        warn "Bio::KBase::typed_obj_converter::Client version is $svr_version. API subject to change.\n";
    }
}

=head1 TYPES



=head2 bool

=over 4



=item Description

@range [0,1]


=item Definition

=begin html

<pre>
an int
</pre>

=end html

=begin text

an int

=end text

=back



=head2 Operation

=over 4



=item Definition

=begin html

<pre>
a reference to a hash where the following keys are defined:
operation has a value which is a string
spec has a value which is an UnspecifiedObject, which can hold any non-null object

</pre>

=end html

=begin text

a reference to a hash where the following keys are defined:
operation has a value which is a string
spec has a value which is an UnspecifiedObject, which can hold any non-null object


=end text

=back



=head2 Type

=over 4



=item Definition

=begin html

<pre>
a reference to a hash where the following keys are defined:
mod has a value which is a string
name has a value which is a string
ver has a value which is a string

</pre>

=end html

=begin text

a reference to a hash where the following keys are defined:
mod has a value which is a string
name has a value which is a string
ver has a value which is a string


=end text

=back



=head2 SimpleConverter

=over 4



=item Definition

=begin html

<pre>
a reference to a hash where the following keys are defined:
long_name has a value which is a string
description has a value which is a string
accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
output_type has a value which is a KBaseTypedObjConverter.Type
operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation

</pre>

=end html

=begin text

a reference to a hash where the following keys are defined:
long_name has a value which is a string
description has a value which is a string
accepted_input_types has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Type
output_type has a value which is a KBaseTypedObjConverter.Type
operations has a value which is a reference to a list where each element is a KBaseTypedObjConverter.Operation


=end text

=back



=head2 ConverterValidationReport

=over 4



=item Definition

=begin html

<pre>
a reference to a hash where the following keys are defined:
is_valid has a value which is a KBaseTypedObjConverter.bool
errors has a value which is a reference to a list where each element is a string

</pre>

=end html

=begin text

a reference to a hash where the following keys are defined:
is_valid has a value which is a KBaseTypedObjConverter.bool
errors has a value which is a reference to a list where each element is a string


=end text

=back



=head2 SimpleConvertParams

=over 4



=item Description

Specify an input typed data object to convert, the output destination of the converted object, and
the simple converter to use.  Optionally specify a Workspace endpoint.  If a workspace_url is not
provided, then the configured Workspace url is used, which will generally be the production endpoint
if this service is deployed to production, or the dev endpoint if this service is deployed to dev.
@optional workspace_url


=item Definition

=begin html

<pre>
a reference to a hash where the following keys are defined:
input has a value which is a Workspace.ObjectIdentity
output has a value which is a Workspace.ObjectIdentity
simple_converter has a value which is a Workspace.ObjectIdentity
workspace_url has a value which is a string

</pre>

=end html

=begin text

a reference to a hash where the following keys are defined:
input has a value which is a Workspace.ObjectIdentity
output has a value which is a Workspace.ObjectIdentity
simple_converter has a value which is a Workspace.ObjectIdentity
workspace_url has a value which is a string


=end text

=back



=cut

package Bio::KBase::typed_obj_converter::Client::RpcClient;
use base 'JSON::RPC::Client';
use POSIX;
use strict;

#
# Override JSON::RPC::Client::call because it doesn't handle error returns properly.
#

sub call {
    my ($self, $uri, $obj) = @_;
    my $result;


    {
	if ($uri =~ /\?/) {
	    $result = $self->_get($uri);
	}
	else {
	    Carp::croak "not hashref." unless (ref $obj eq 'HASH');
	    $result = $self->_post($uri, $obj);
	}

    }

    my $service = $obj->{method} =~ /^system\./ if ( $obj );

    $self->status_line($result->status_line);

    if ($result->is_success) {

        return unless($result->content); # notification?

        if ($service) {
            return JSON::RPC::ServiceObject->new($result, $self->json);
        }

        return JSON::RPC::ReturnObject->new($result, $self->json);
    }
    elsif ($result->content_type eq 'application/json')
    {
        return JSON::RPC::ReturnObject->new($result, $self->json);
    }
    else {
        return;
    }
}


sub _post {
    my ($self, $uri, $obj) = @_;
    my $json = $self->json;

    $obj->{version} ||= $self->{version} || '1.1';

    if ($obj->{version} eq '1.0') {
        delete $obj->{version};
        if (exists $obj->{id}) {
            $self->id($obj->{id}) if ($obj->{id}); # if undef, it is notification.
        }
        else {
            $obj->{id} = $self->id || ($self->id('JSON::RPC::Client'));
        }
    }
    else {
        # $obj->{id} = $self->id if (defined $self->id);
	# Assign a random number to the id if one hasn't been set
	$obj->{id} = (defined $self->id) ? $self->id : substr(rand(),2);
    }

    my $content = $json->encode($obj);

    $self->ua->post(
        $uri,
        Content_Type   => $self->{content_type},
        Content        => $content,
        Accept         => 'application/json',
	($self->{token} ? (Authorization => $self->{token}) : ()),
    );
}



1;
