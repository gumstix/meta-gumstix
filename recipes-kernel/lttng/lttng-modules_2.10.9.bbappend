FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
TESTPATH = "${TMPDIR}/work-shared/${MACHINE}/kernel-source"


SRC_URI += "file://0010-Disable-kprobes-for-lttng-modules.patch;patchdir=${TESTPATH} \
"
