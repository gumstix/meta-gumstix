DESCRIPTION = "Full versions of tools provided by busybox"
PR = "r1"

inherit gumstix-package

INCLUDES = "\
		bash \
		bc \
		bind-utils \
		binutils-symlinks \
		bzip2 \
		console-tools \
		coreutils \
		cpio \
		debianutils \
		diffutils \
		e2fsprogs \
		fbset \
		findutils \
		gawk \
		grep \
		gzip \
		ifupdown \
		${@base_contains('DISTRO_FEATURES', 'ipv6', 'iproute2', '', d)} \
		iputils-arping \
		${@base_contains('DISTRO_FEATURES', 'ipv6', 'iputils-ping6', '', d)} \
		iputils-ping \
		iputils \
		less \
		minicom \
		mktemp \
		module-init-tools \
		ncurses-tools \
		netcat \
		net-tools \
		openrdate \
		patch \
		picocom \
		procps \
		psmisc \
		pump \
		realpath \
		sed \
		shadow \
		start-stop-daemon \
		syslog-ng \
		sysvinit \
		tar \
		tftp-hpa \
		time \
		unzip \
		util-linux \
		wget \
        "
#		inetutils \
#		tcptraceroute \

#
# binutils-symlinks provide ar in a way which conflict with busybox - #1465 for more info
#
# busybox tar does not understand '--no-same-owner' option which bitbake use
#
