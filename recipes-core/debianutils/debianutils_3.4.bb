# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require debianutils.inc

PR = "${INC_PR}"

do_configure_prepend() {
	sed -i -e 's:tempfile.1 which.1:which.1:g' Makefile.am
}

#SRC_URI[md5sum] = "7fdd5f8395162d8728d4b79e97b9819e"
#SRC_URI[sha256sum] = "d62e98fee5b1a758d83b62eed8d8bdec473677ff782fed89fc4ae3ba3f381401"
SRC_URI[md5sum] = "0b37e6a6f318f146741a229ab4bfe93b"
SRC_URI[sha256sum] = "0eb1443466b79b1357af1f78568f5950397789730f08031f7991d4c225c66b20"
