require conf/machine/include/omap3.inc

EXTRA_IMAGEDEPENDS = "u-boot-sakoman"

PREFERRED_PROVIDER_virtual/bootloader = "u-boot-sakoman"
UBOOT_MACHINE = "omap3_overo_config"
#PREFERRED_VERSION_pn-u-boot = "2011.12"

#PREFERRED_PROVIDER_virtual/kernel = "linux-omap3"
PREFERRED_PROVIDER_ntp = "ntp"
PREFERRED_PROVIDER_virtual/kernel = "linux-sakoman"  

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-omapfb \
           xf86-input-keyboard"

PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"

SERIAL_CONSOLE = "115200 ttyO2"

IMAGE_FSTYPES += "tar.bz2"

MKUBIFS_ARGS = "-m 2048 -e 129024 -c 4044"
UBINIZE_ARGS = "-m 2048 -p 128KiB -s 512"

UBI_VOLNAME = "rootfs"

MACHINE_EXTRA_RDEPENDS = "omap3-writeprom"
MACHINE_EXTRA_RRECOMMENDS = " kernel-modules"

MACHINE_FEATURES = "kernel26 alsa apm ext3 screen usbgadget usbhost vfat wifi"
