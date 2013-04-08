# ML-Dev

An Eclipse plug-in for Standard ML.

ML-Dev is a plug-in for the [Eclipse IDE][eclipse] that adds support for the Standard ML
programming language. It provides features for programming in SML using Eclipse, such as
an editor with syntax highlighting and error checking, and the ability to run SML programs within
Eclipse.


## Features

-   Text editor for SML
    -   Syntax highlighting
    -   Highlighting of matching brackets
    -   Syntax errors marked while typing

-   Outline of all declarations in the file
    -   Updated as you type
    -   Selection follows editor and vice versa

-   Run SML programs within Eclipse
    -   Support for CM

-   User guide integrated into Eclipse help


## Installation

Use the following URL to install ML-Dev plug-ins via Eclipse [_Update Manager_][update-manager].

[**`http://andriusvelykis.github.io/ml-dev/updates/nightly/`**]( http://andriusvelykis.github.io/ml-dev/updates/nightly/ )

[update-manager]: http://www.vogella.com/articles/Eclipse/article.html#updatemanager


## Usage

ML-Dev _User Guide_ contains important information for running SML in Eclipse. The User Guide can
be accessed from the Eclipse help system **(Help > Help Contents)**. You can also
[read the User Guide online][mldev-guide].

Running SML programs requires an interactive SML interpreter installed on your system. The plug-in
has only been tested on SML/NJ 110.0.7, but it should work on any SML implementation that supports the
`use` primitive.


## Contributing

Please report bugs, feature requests, questions and other issues using the GitHub tracker:

[`http://github.com/andriusvelykis/ml-dev/issues`](http://github.com/andriusvelykis/ml-dev/issues)

You can also contribute to the project by forking the repository and sending [pull requests][pull-req] with your changes. We welcome various contributions!

ML-Dev is built on Eclipse platform using Java programming language. It is built using Maven and Eclipse Tycho. To build everything, run a standard Maven command:

    mvn clean install

[pull-req]: https://help.github.com/articles/using-pull-requests/


## Authors

-   Original plug-in code by **[Rahul Narain][narain]** in 2004, with the inspiration and guidance
of [Prof. Sanjiva Prasad][prasad].
-   Updates and fixes by **[Andrius Velykis][velykis]** (Newcastle University, UK).

[eclipse]: http://www.eclipse.org
[mldev-guide]: http://www.eecs.berkeley.edu/~narain/projects/mldev/userguide/
[narain]: http://www.eecs.berkeley.edu/~narain/
[prasad]: http://www.cse.iitd.ac.in/~sanjiva/
[velykis]: http://andrius.velykis.lt
