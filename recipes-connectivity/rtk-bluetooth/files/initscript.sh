#!/bin/sh

logger "starting bluetooth initscript"

systemctl disable serial-getty@ttyAMA0.service

logger "serial-getty@ttyAMA0 disabled"

systemctl disable initscript.service

logger "initscript disabled"
