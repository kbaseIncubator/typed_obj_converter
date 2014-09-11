package us.kbase.toc.scripts;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.configuration.ConfigurationException;

import us.kbase.auth.AuthToken;
import us.kbase.auth.TokenFormatException;
import us.kbase.common.service.UnauthorizedException;
import us.kbase.toc.SimpleTypedObjectConverter;
import us.kbase.toc.exceptions.TypedObjectConversionException;
import us.kbase.toc.ws.WorkspaceManager;
import us.kbase.workspace.ObjectIdentity;

public class TocConvert {

	private static final String CMD_NAME = "toc-convert";
	
	public static void main(String[] args) throws TokenFormatException, UnauthorizedException, MalformedURLException, IOException, TypedObjectConversionException {
		
		// first parse options
		Options options = setupOptions();
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse( options, args);
		} catch (ParseException e) {
			System.err.println(e.getMessage()+".");
			System.err.println("Run with -h or --help for usage information.");
			System.exit(1);
		}
		
		// if we didn't get anything, that's an error
		if(cmd.getOptions().length==0) {
			System.err.println("No options given.  Run with -h or --help for usage information.");
			System.exit(1);
		}
		
		// check for a help message
		if(cmd.hasOption("h")) { 
			printHelp(options, System.out);
			System.exit(0);
		}
		
		// check if we are logged in
		KBaseConfig kbconfig = null;
		try {
			kbconfig = new KBaseConfig();
		} catch (ConfigurationException e) {
			System.err.println("Unable to get KBase client config.  Are you logged in with kb-login?");
			System.err.println(e.getMessage());
			System.exit(0);
		}
		
		if(!kbconfig.isLoggedIn()) {
			System.err.println("You must be logged in to convert data objects.  Use kbase-login.");
			System.exit(1);
		}
		WorkspaceManager wm = new WorkspaceManager(
										new URL("https://kbase.us/services/ws"),
										new AuthToken(kbconfig.getToken())
									);
		SimpleTypedObjectConverter stoc = new SimpleTypedObjectConverter(wm);
		ObjectIdentity data = new ObjectIdentity().withRef(cmd.getOptionValue("i"));
		System.out.println(data);
		ObjectIdentity converter = new ObjectIdentity().withRef(cmd.getOptionValue("c"));
		System.out.println(converter);
		stoc.convert(data, converter);
		
		
	}
	
	@SuppressWarnings("static-access")
	private static Options setupOptions() {
		Options options = new Options();
		
		Option help   = OptionBuilder
							.hasArg(false)
							.withDescription("print this help message")
							.withLongOpt("help")
							.create("h");
		options.addOption(help);
		
		Option workspace   = OptionBuilder
								.hasArg(true)
								.withArgName("workspace-name")
								.withDescription("set the default workspace")
								.withLongOpt("workspace")
								.create("w");
		options.addOption(workspace);
		
		Option input   = OptionBuilder
				.hasArg(true)
				.withArgName("ws-obj-ref")
				.withDescription("the input workspace object name or reference")
				.withLongOpt("input")
				.create("i");
		//input.setRequired(true);
		options.addOption(input);
		
		Option output   = OptionBuilder
				.hasArg(true)
				.withArgName("ws-obj-ref")
				.withDescription("the output workspace object name or reference")
				.withLongOpt("output")
				.create("o");
		//output.setRequired(true);
		options.addOption(output);
		
		Option converter   = OptionBuilder
				.hasArg(true)
				.withArgName("ws-obj-ref")
				.withDescription("the converter object name or reference")
				.withLongOpt("converter")
				.create("c");
		//converter.setRequired(true);
		options.addOption(converter);
		
		Option runlocal   = OptionBuilder
				.hasArg(false)
				.withDescription("do the conversion locally")
				.withLongOpt("local")
				.create("l");
		options.addOption(runlocal);
		
		return options;
	}
	
	
	private static void printHelp(Options options, PrintStream out) {
		PrintWriter pw = new PrintWriter(out);
		pw.println("\nNAME");
		pw.println("    "+CMD_NAME+" -- convert a workspace data object to a different type\n");
		pw.println("SYNOPSIS\n    "+CMD_NAME+" [options]\n");
		HelpFormatter formatter = new HelpFormatter();
		formatter.printOptions(pw, 120, options, 8, 4);
		pw.println("\nDESCRIPTION");
		pw.println("    Convert between data objects in the workspace.\n");
		pw.flush();
		pw.close();
	}
	
	
}
