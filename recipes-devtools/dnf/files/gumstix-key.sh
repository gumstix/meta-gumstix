#!/bin/bash
rpm --import /usr/share/gumstixkey/gumstix.key # import Gumstix key for packages
systemctl disable gumstix-key.service  # disable itself 


