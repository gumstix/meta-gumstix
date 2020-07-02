DESCRIPTION = "TensorFlow C/C++ Libraries - Credit to meta-tensorflow, most of this was taken from there."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01e86893010a1b87e69a213faa753ebd"

DEPENDS = "bazel-native protobuf-native util-linux-native protobuf"
SRCREV = "c8875cbb1341f6ca14dd0ec908f1dde7d67f7808"
SRC_URI = "git://github.com/tensorflow/tensorflow.git;branch=r1.13 \
           file://0001-add-yocto-toolchain-to-support-cross-compiling.patch \
           file://0001-fix-gcc-internal-compile-error-on-qemuarm64.patch \
           file://0001-SyntaxError-around-async-keyword-on-Python-3.7.patch \
           file://0001-support-musl.patch \
           file://0001-fix-build-tensorflow-lite-examples-label_image-label.patch \
           file://0001-label_image-tweak-default-model-location.patch \
           file://0001-label_image.lite-tweak-default-model-location.patch \
           file://0001-use-local-bazel-to-workaround-bazel-paralle-issue.patch \
           file://0001-CheckFeatureOrDie-use-warning-to-avoid-die.patch \
           file://0001-grpc-Define-gettid-only-for-glibc-2.30.patch \
           file://0020-Configuration-changes-necessary-to-support-cuda-comp.patch \
           file://0021-Fix-convert_nodes-issue-with-TENSORRT-versions.patch \
           file://0022-Remove-grpc-glibc-patch-it-causes-compile-errors.patch \
           file://0023-Add-builders-for-cuda-gcc-wrappers.patch \
           file://0024-Updated-cuda_configure-to-check-nvcc-using-native-pa.patch \
           file://BUILD.cuda \
           file://BUILD.yocto_compiler \
           file://CROSSTOOL.tpl.cuda \
           file://yocto_compiler_configure.bzl \
           file://crosstool_wrapper_driver_is_not_gcc.tpl \
           file://crosstool_wrapper_host_tf_framework.tpl \
          "

S = "${WORKDIR}/git"

DEPENDS += " \
    python3 \
    python3-numpy-native \
    python3-keras-applications-native \
    python3-keras-preprocessing-native \
    python3-pip-native \
    python3-wheel-native \
    cudnn \
    cuda-cudart \
    tensorrt \
    tensorrt-native \
    cuda-tools-native \
    cuda-cudnn-native \
"

RDEPENDS_${PN} += " \
    python3 \
    python3-numpy \
    python3-keras-applications \
    python3-keras-preprocessing \
    python3-protobuf \
    python3-grpcio \
    python3-absl \
    python3-astor \
    python3-gast \
    python3-termcolor \
    python3-markdown \
    python3-werkzeug \
    tensorboard \
    tensorflow-estimator \
"

inherit python3native bazel cuda pkgconfig

export PYTHON_BIN_PATH="${PYTHON}"
export PYTHON_LIB_PATH="${STAGING_LIBDIR_NATIVE}/${PYTHON_DIR}/site-packages"

# cuda capabilities
PACKAGECONFIG ?= "33"
PACKAGECONFIG[33] = ""
PACKAGECONFIG[24] = ""
PACKAGECONFIG[25] = ""

TF_CONFIG ?= " \
    TF_NEED_CUDA=1 \
    TF_NEED_TENSORRT=1 \
    TF_CUDA_COMPUTE_CAPABILITIES=5.3 \
    TF_CUDA_VERSION=10.0 \
    TF_CUDNN_VERSION=7.5 \
    CUDA_TOOLKIT_PATH=${WORKDIR}/recipe-sysroot/usr/local/cuda-10.0/ \
    CUDNN_INSTALL_PATH=${WORKDIR}/recipe-sysroot/usr/ \
    TENSORRT_INSTALL_PATH=${WORKDIR}/recipe-sysroot/usr/ \
    TF_NEED_OPENCL_SYCL=0 \
    TF_NEED_OPENCL=0 \
    TF_CUDA_CLANG=0 \
    TF_DOWNLOAD_CLANG=0 \
    TF_ENABLE_XLA=0 \
    TF_NEED_MPI=0 \
    TF_SET_ANDROID_WORKSPACE=0 \
    GCC_HOST_COMPILER_PATH=${WORKDIR}/recipe-sysroot-native/usr/bin/aarch64-poky-linux/aarch64-poky-linux-gcc \
    LD_LIBRARY_PATH=${WORKDIR}/recipe-sysroot/lib \
"

do_configure_append () {
    CROSSTOOL_PYTHON_INCLUDE_PATH="${STAGING_INCDIR}/python${PYTHON_BASEVERSION}${PYTHON_ABI}"
    if [ ! -e ${CROSSTOOL_PYTHON_INCLUDE_PATH}/pyconfig-target.h ];then
        mv ${CROSSTOOL_PYTHON_INCLUDE_PATH}/pyconfig.h ${CROSSTOOL_PYTHON_INCLUDE_PATH}/pyconfig-target.h
    fi

    install -m 644 ${STAGING_INCDIR_NATIVE}/python${PYTHON_BASEVERSION}${PYTHON_ABI}/pyconfig.h \
        ${CROSSTOOL_PYTHON_INCLUDE_PATH}/pyconfig-native.h

    cat > ${CROSSTOOL_PYTHON_INCLUDE_PATH}/pyconfig.h <<ENDOF
#if defined (_PYTHON_INCLUDE_TARGET)
#include "pyconfig-target.h"
#elif defined (_PYTHON_INCLUDE_NATIVE)
#include "pyconfig-native.h"
#else
#error "_PYTHON_INCLUDE_TARGET or _PYTHON_INCLUDE_NATIVE is not defined"
#endif // End of #if defined (_PYTHON_INCLUDE_TARGET)

ENDOF

    mkdir -p ${S}/third_party/toolchains/yocto/
    mkdir -p ${S}/third_party/gpus/crosstool/yocto/bin/
    install -m 644 ${WORKDIR}/BUILD.cuda ${S}/third_party/toolchains/yocto/BUILD
    install -m 644 ${WORKDIR}/CROSSTOOL.tpl.cuda ${S}/third_party/toolchains/yocto/CROSSTOOL.tpl
    install -m 644 ${WORKDIR}/yocto_compiler_configure.bzl ${S}/third_party/toolchains/yocto/
    install -m 644 ${WORKDIR}/BUILD.yocto_compiler ${S}
    install -m 644 ${WORKDIR}/crosstool_wrapper_driver_is_not_gcc.tpl ${S}/third_party/gpus/crosstool/yocto/bin/
    install -m 644 ${WORKDIR}/crosstool_wrapper_host_tf_framework.tpl ${S}/third_party/gpus/crosstool/yocto/bin/

    CT_NAME=$(echo ${HOST_PREFIX} | rev | cut -c 2- | rev)
    SED_COMMAND="s#%%CT_NAME%%#${CT_NAME}#g"
    SED_COMMAND="${SED_COMMAND}; s#%%WORKDIR%%#${WORKDIR}#g"
    SED_COMMAND="${SED_COMMAND}; s#%%YOCTO_COMPILER_PATH%%#${BAZEL_OUTPUTBASE_DIR}/external/yocto_compiler#g"
    SED_COMMAND="${SED_COMMAND}; s#%%WORK_DIRECTORY%%#${WORKDIR}#g"

    sed -i "${SED_COMMAND}" ${S}/BUILD.yocto_compiler \
                            ${S}/third_party/toolchains/yocto/CROSSTOOL.tpl \
                            ${S}/WORKSPACE

    SED_COMMAND="s#--linkopt=-L=/usr/local/cuda-10.0/lib/stubs##g"
    SED_COMMAND="${SED_COMMAND}; s#--linkopt=-L=/usr/local/cuda-10.0/lib##g"
    SED_COMMAND="${SED_COMMAND}; s#--cxxopt=-I=/usr/local/cuda-10.0/include##g"
    SED_COMMAND="${SED_COMMAND}; s#--cxxopt=-I=/usr/local/cuda-10.0/include##g"
    sed -i "${SED_COMMAND}" ${S}/bazelrc

    # make sym links for libcuda.so.1
    ln -sf libcuda.so ${WORKDIR}/recipe-sysroot-native/usr/local/cuda-10.0/targets/x86_64-linux/lib/stubs/libcuda.so.1
    ln -sf libcuda.so ${WORKDIR}/recipe-sysroot/usr/local/cuda-10.0/lib/stubs/libcuda.so.1

    ${TF_CONFIG} \
    ./configure
}

TF_ARGS_EXTRA ??= ""
TF_TARGET_EXTRA ??= ""
do_compile () {
    unset CC
    ${BAZEL} build \
        ${TF_ARGS_EXTRA} \
        -c opt \
        --cpu=armeabi \
        --config=cuda \
        --config=nonccl \
        --subcommands --explain=${T}/explain.log \
        --verbose_explanations --verbose_failures \
        --crosstool_top=@local_config_yocto_compiler//:toolchain \
        --verbose_failures \
        --copt -DTF_LITE_DISABLE_X86_NEON \
        //tensorflow/tools/pip_package:build_pip_package \
        ${TF_TARGET_EXTRA}

    ${BAZEL} shutdown
}

do_install() {
    install -d ${D}${sbindir}

    export TMPDIR="${WORKDIR}"
    echo "Generating pip package"
    BDIST_OPTS="--universal" \
        ${S}/bazel-bin/tensorflow/tools/pip_package/build_pip_package ${WORKDIR}

    echo "Installing pip package"
    install -d ${D}/${PYTHON_SITEPACKAGES_DIR}
    ${STAGING_BINDIR_NATIVE}/pip3 install --disable-pip-version-check -v \
        -t ${D}/${PYTHON_SITEPACKAGES_DIR} --no-cache-dir --no-deps \
         ${WORKDIR}/tensorflow*.whl

    (
        cd ${D}${PYTHON_SITEPACKAGES_DIR}/bin;
        for app in `ls`; do
            sed -i "s:^'''exec' ${PYTHON} :'''exec' /usr/bin/python3 :g" $app
            mv $app ${D}${sbindir}
        done

    )
}

FILES_${PN}-dev = ""
INSANE_SKIP_${PN} += "dev-so \
                     "
FILES_${PN} += "${libdir}/* ${datadir}/*"
#FILES_${PN} += "${libdir}/* ${datadir}/* ${sbindir}/*"

inherit siteinfo
UNSUPPORTED_TARGET_ARCH = "powerpc"
python __anonymous() {
    target_arch = d.getVar("TARGET_ARCH")
    if target_arch in d.getVar("UNSUPPORTED_TARGET_ARCH").split():
        raise bb.parse.SkipPackage("TensorFlow does not support Target Arch '%s'" % target_arch)

    if d.getVar("SITEINFO_ENDIANNESS") == 'be':
        msg =  "\nIt failed to use pre-build model to do predict/inference on big-endian platform"
        msg += "\n(such as qemumips), since upstream does not support big-endian very well."
        msg += "\nDetails: https://github.com/tensorflow/tensorflow/issues/16364"
        bb.warn(msg)

    packageconfig = (d.getVar("PACKAGECONFIG") or "").split()
    cuda_compute = []
    if "33" in packageconfig:
        cuda_compute.append("5.3")
    if "24" in packageconfig:
        cuda_compute.append("6.2")
    if "25" in packageconfig:
        cuda_compute.append("7.2")

    tf_config = d.getVar("TF_CONFIG", True)
    tf_config = tf_config.replace("TF_CUDA_COMPUTE_CAPABILITIES=5.3","TF_CUDA_COMPUTE_CAPABILITIES=%s" % ",".join(cuda_compute))
    d.setVar("TF_CONFIG", tf_config)
}
