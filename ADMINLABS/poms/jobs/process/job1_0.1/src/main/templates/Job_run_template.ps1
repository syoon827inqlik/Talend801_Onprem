$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/talend_file_enhanced-1.3.1.jar;../lib/talendagent-1.0.2.jar;../lib/audit-log4j2-1.16.1.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/json-smart-2.4.11.jar;../lib/talendCBP-1.1.4.jar;../lib/logging-event-layout-1.16.1.jar;../lib/javassist-3.30.2-GA.jar;../lib/talendboot-1.0.8.jar;../lib/commons-lang3-3.10.jar;../lib/asm-9.5.jar;../lib/dom4j-2.1.3.jar;../lib/system-routines.jar;../lib/slf4j-api-1.7.34.jar;../lib/job-audit-1.5.jar;../lib/crypto-utils-7.1.20.jar;../lib/audit-common-1.16.1.jar;../lib/accessors-smart-2.4.11.jar;job1_0_1.jar;' adminlabs.job1_0_1.job1 $args
