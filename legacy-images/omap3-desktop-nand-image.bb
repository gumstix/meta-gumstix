# X11 factory image for omap3 -- trimmed down to fit nand

require omap3-console-image.bb

IMAGE_LINGUAS = "en-us"

ANGSTROM_EXTRA_INSTALL ?= ""

SPLASH ?= "psplash"

APPS = " \
  abiword-meta \
  claws-mail \
  evince \
  gnome-games \
  gnome-mplayer \
  gnumeric \
  gpe-soundbite \
  midori \
  pidgin \
  vnc \
  x11vnc \
  angstrom-x11vnc-xinit \
  xterm \
 "

E_CONFIG = " \
  e-wm-config-angstrom \
 "

E_MODULES = " \
  places \
 "

E17 = " \
  e-wm \
  e-wm-menu \
  e-wm-sysactions \
  ${E_CONFIG} \
  ${E_MODULES} \
 "

FONTS = " \
  ttf-dejavu-common \
  ttf-dejavu-sans \
  ttf-dejavu-serif \
  ttf-dejavu-sans-mono \
 "  

GLES_INSTALL = " \
  libgles-omap3 \
 "


SETTINGS = " \
  networkmanager network-manager-applet networkmanager-openvpn \
  gnome-bluetooth \
  gpe-conf \
#  gpe-package \
 "

XSERVER_BASE = " \
  ${XSERVER} \
  dbus-x11 \
  fontconfig-utils \
  gnome-icon-theme angstrom-gnome-icon-theme-enable \
  gnome-themes \
  gpe-theme-clearlooks \
  gtk-engine-clearlooks \
  gpe-dm \
  gpe-session-scripts \
  hicolor-icon-theme \
  mime-support \
  xauth \
  xdg-utils \
  xhost \
  xset \
  xlsfonts \
  xrefresh \
 "

TOOLS_INSTALL += " \
  python \
  python-subprocess \
  python-unittest \
  python-compression \
  python-pyxdg \
  python-pyserial \
  python-argparse \
 "

IMAGE_INSTALL += " \
  ${APPS} \
  ${E17} \
  ${FONTS} \
  ${SETTINGS} \
  ${SPLASH} \
  ${XSERVER_BASE} \
 "

