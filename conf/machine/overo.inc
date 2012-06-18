require conf/machine/include/omap3.inc

EXTRA_IMAGEDEPENDS = "u-boot"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot"
UBOOT_MACHINE = "omap3_overo_config"
PREFERRED_VERSION_pn-u-boot = "2011.12"

PREFERRED_PROVIDER_virtual/kernel = "linux-omap3"
PREFERRED_PROVIDER_ntp = "ntp"
PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-omapfb \
           xf86-input-keyboard"
#           xf86-input-tslib

GUI_MACHINE_CLASS = "bigscreen"

SERIAL_CONSOLE = "115200 ttyO2"

IMAGE_FSTYPES += "tar.bz2"
# IMAGE_FSTYPES += "ubi tar.bz2"

# do ubiattach /dev/ubi_ctrl -m 4
# From dmesg:
# UBI: smallest flash I/O unit:    2048
# UBI: logical eraseblock size:    129024 bytes
# from ubiattach stdout:
# UBI device number 0, total 1996 LEBs
MKUBIFS_ARGS = "-m 2048 -e 129024 -c 4044"

# do ubiattach /dev/ubi_ctrl -m 4
# from dmesg:
# UBI: smallest flash I/O unit:    2048
# UBI: physical eraseblock size:   131072 bytes (128 KiB)
# UBI: sub-page size:              512
UBINIZE_ARGS = "-m 2048 -p 128KiB -s 512"
UBI_VOLNAME = "rootfs"
MACHINE_EXTRA_RDEPENDS = ""
MACHINE_EXTRA_RRECOMMENDS = ""

MACHINE_FEATURES = "kernel32 alsa apm ext3 screen usbgadget usbhost vfat wifi"
# touchscreen

