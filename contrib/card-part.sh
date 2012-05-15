#! /bin/sh

# part-card.sh
# (c) Copyright 2012 Andreas Müller <schnitzeltony@gmx.de>
# Licensed under terms of GPLv2
#
# This script prepares partitions on SDCards. It wraps
# http://omappedia.org/wiki/Minimal-FS_SD_Configuration by dialog based GUI.

# for debugging set DEBUG=echo
DEBUG=

run_user() {
	if [ -z $DevicePath ]; then
		SelectCardDevice || exit 1
	elif [ $# -gt 1 ]; then
		echo "Usage: $0 [Card device path]"
		exit 1;
	fi
	RootParams="$DevicePath"
}

run_root() {
	# device node valid?
	if [ ! -b $DevicePath ] ; then
		echo "$DevicePath is not a valid block device!"
		exit 1
	fi

	# check if the card is currently mounted
	MOUNTSTR=$(mount | grep $DevicePath)
	if [ -n "$MOUNTSTR" ] ; then
	    echo -e "\n$DevicePath is currenly mounted. Needs unmounting..."
	    $DEBUG umount -f ${DevicePath}?*
	fi

	$DEBUG dd if=/dev/zero of=$DevicePath bs=1024 count=1024

	# force 512 bytes / sector
	export LC_ALL=C
	SIZE=`fdisk -l $DevicePath | grep Disk | grep bytes | awk '{print $5}'`
	echo "Disk size: $SIZE bytes"
	CYLINDERS=`echo $SIZE/255/63/512 | bc`
	echo "Cylinders: $CYLINDERS"
	# setup partitions
	{
	echo ,9,0x0C,*
	echo ,,,-
	} | $DEBUG sfdisk -D -H 255 -S 63 -C $CYLINDERS $DevicePath
	# write partitions
	$DEBUG mkfs.vfat -F 32 -n "boot" ${DevicePath}1
	$DEBUG mke2fs -j -t ext3 -L "rootfs" ${DevicePath}2

}


source `dirname $0`/tools.inc
DevicePath=$1
# On the 1st call: run user
# After the 2nd call: run root
chk_root && run_root


















