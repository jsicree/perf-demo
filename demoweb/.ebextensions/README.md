#.ebextensions
This directory contains .config files used to configure the Elastic Beanstalk instances for the perf-demo project.

__01_install_DT.config__ - Downloads the Dynatrace agent from an S3 bucket and installs the agent.  
__02-move-war.config__ - Creates a shell script called 00expand-war.sh that will expand any war file deployed to Tomcat.  
__03-run-expand-war.config__ - Executes the shell script 00expand-war.sh.  
__04-tomcat.config__ - Configures Tomcat with the Dynatrace agent.  
