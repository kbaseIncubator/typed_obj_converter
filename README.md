TOC -- the Typed Object Converter
====

Overview
----
A [KBase][kb] incubator project designed to allow easy and flexible conversion between data types in the [Workspace][ws].

This code is still under development, and will probably not work for you yet, but if you
are curious or would like more information, contact: Michael at mwsneddon@lbl.gov


Dependencies
----
There are several different classes of dependencies.

For building (`make`), service/client deployment (`make deploy-*`), and tests (`make test`), dependencies are:
- jars

For rebuilding client/server libraries from the KIDL spec (`make compile-typespec` and `make compile-typespec-java`, dependencies are:
- typecomp (branch dev-prototypes)
- gen_java_types
- workspace_deluxe


[kb]: https://kbase.us
[ws]: https://github.com/kbase/workspace_deluxe