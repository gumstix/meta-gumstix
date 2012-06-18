DESCRIPTION = "A task that builds every package available in the Gumsitx repository"
PR = "r16"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://../license-destdir/task-proper-tools/generic_MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit task

RDEPENDS_${PN} = "\
  task-console-image \
  python \
 "
