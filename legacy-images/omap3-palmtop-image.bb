# gpe image for omap3 machines with lcd/touchscreen

require omap3-console-image.bb

SPLASH ?= "psplash"

IMAGE_INSTALL += " \
  angstrom-gpe-task-apps \
  angstrom-gpe-task-base \
  angstrom-gpe-task-game \
  angstrom-gpe-task-pim \
  angstrom-gpe-task-settings \
  angstrom-x11-base-depends \
  midori \
  mplayer \
  ${SPLASH} \
  xlsfonts \
  xmms \
  xrefresh \
 "

