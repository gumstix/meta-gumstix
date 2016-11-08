require recipes-bsp/u-boot/u-boot.inc

# The license text is moved from a "COPYING" file to the beginning of
# the README on recent versions of u-boot.
LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"
LICENSE = "GPLv2+"

# To deploy a u-boot environment file, uncomment these lines
#UBOOT_ENV = "uEnv"
#SRC_URI_append = " file://uEnv.txt"
