DESCRIPTION = "NVIDIA TensorRT (GPU Inference Engine) for deep learning - Host libraries"
HOMEPAGE = "http://developer.nvidia.com/tensorrt"
LICENSE = "Proprietary"

inherit nvidia_devnet_downloads native

SRC_URI = "\
    ${NVIDIA_DEVNET_MIRROR}/libnvinfer5_${PV}+cuda10.0_amd64.deb;downloadfilename=libnvinfer5_${PV}+cuda10.0_arm64.deb;name=lib;subdir=tensorrt-native \
"

S = "${WORKDIR}/tensorrt-native"

LIC_FILES_CHKSUM = "file://usr/share/doc/tensorrt/TensorRT-License.pdf;md5=94f8f7da94e8db876821a443d30700c0"

do_install() {
    install -d ${D}${STAGING_DIR_NATIVE}
    cp -R ${S}/usr ${D}${STAGING_DIR_NATIVE}/
    rm -rf ${D}${STAGING_DIR_NATIVE}/usr/share
}

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_SYSROOT_STRIP = "1"
