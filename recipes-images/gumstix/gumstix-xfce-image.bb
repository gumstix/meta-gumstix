DESCRIPTION = "The Gumstix XFCE image"

require gumstix-console-image.bb

XSERVER +=  "\
  xmodmap \
  xrdb \
  setxkbmap \
 "

XFCE_INSTALL = " \
  task-xfce-base \
  gdm-systemd \
  "

XFCE_APPS = "\
  epiphany \
  web-webkit \
  network-manager-applet \
  xterm \
 "

XFCE_THEMES = " \
  gnome-icon-theme \
  gtk-engine-clearlooks \
  gtk-theme-clearlooks \
  gtk-tweak \
 "

XFCE_DOCS = " \
  exo-doc \
  thunar-doc \
  xfce4-clipman-plugin-doc \
  xfce4-notifyd-doc \
  xfce4-panel-doc \
  xfce4-screenshooter-doc \
  xfce4-session-doc \
  xfce-terminal-doc \
  xfce-utils-doc \
  xfdesktop-doc \
  xfwm4-doc \
 "
IMAGE_INSTALL += " \
  ${XSERVER} \
  ${XFCE_INSTALL} \
  ${XFCE_APPS} \
  ${XFCE_THEMES} \
  ${XFCE_DOCS} \
 "

# this section removes remnants of legacy sysvinit support
# for packages installed above
IMAGE_FILE_BLACKLIST += " \
			 /usr/share/xsessions/gnome.desktop \
			/usr/share/gdm/autostart/LoginWindow/at-spi-registryd-wrapper.desktop \
			/usr/share/gdm/autostart/LoginWindow/gnome-mag.desktop \
			/usr/share/gdm/autostart/LoginWindow/gnome-power-manager.desktop \
			/usr/share/gdm/autostart/LoginWindow/gnome-settings-daemon.desktop \
			/usr/share/gdm/autostart/LoginWindow/gok.desktop \
			/usr/share/gdm/autostart/LoginWindow/libcanberra-ready-sound.desktop \
			/usr/share/gdm/autostart/LoginWindow/metacity.desktop \
			/usr/share/gdm/autostart/LoginWindow/orca-screen-reader.desktop \
                       "

