@echo off

rem Set variables

SET HYBRIS_DIR=D:\dev\Hybris

SET HYBRIS_CONFIG=%HYBRIS_DIR%\hybris\config
SET HYBRIS_EXTENSIONS=%HYBRIS_DIR%\hybris\bin\custom
SET CONFIG=config
SET EXTENSIONS=custom

rem Deleting default config files

if exist "%HYBRIS_CONFIG%\localextensions.xml" (
	del /F %HYBRIS_CONFIG%\localextensions.xml
) else (
	echo localextensions.xml DOES NOT EXIST
)

if exist "%HYBRIS_CONFIG%\local.properties" (
	del /F %HYBRIS_CONFIG%\local.properties
) else (
	echo local.properties DOES NOT EXIST
)

rem Linking custom config files

MKLINK /H "%HYBRIS_CONFIG%\localextensions.xml" "%CONFIG%\localextensions.xml"
MKLINK /H "%HYBRIS_CONFIG%\local.properties" "%CONFIG%\local.properties"

if exist "%HYBRIS_EXTENSIONS%" (
	RMDIR /Q /S "%HYBRIS_EXTENSIONS%"
	MKLINK /J "%HYBRIS_EXTENSIONS%" "%EXTENSIONS%"
) else (
	MKLINK /J "%HYBRIS_EXTENSIONS%" "%EXTENSIONS%"
)

pause