@echo off

SET HYBRIS_PLATFORM=D:\dev\Hybris\hybris\bin\platform
SET SOURCE_PLATFORMADMINISTRATION_IN_ADMIN_FOLDER=D:\dev\junior_hybris_mentoring\admin\platformadministration.xml
SET DESTINATION_PLATFORMADMINISTRATION_IN_HYBRIS__PLATFORM=D:\dev\Hybris\hybris\bin\platform\resources\ant\

copy %SOURCE_PLATFORMADMINISTRATION_IN_ADMIN_FOLDER% %DESTINATION_IN_HYBRIS_PLATFORM% 

cd %HYBRIS_PLATFORM%

call setantenv.bat

call ant runcronjob -Dcronjob=sendEmailCronJob -Dtenant=master

pause