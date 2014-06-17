#Alico 3550 image
#gives you Alico specific image for Kinetic 3550

ANGSTROM_EXTRA_INSTALL ?= "\
       u-boot \
       kernel-module-g-ether \
       devmem2"

DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
            util-linux-ng-mount util-linux-ng-umount \
            ${DISTRO_SSH_DAEMON} \
            ${ANGSTROM_EXTRA_INSTALL} \
            angstrom-version \
            ${SPLASH} \
	   "

export IMAGE_BASENAME = "alico-image"
IMAGE_LINGUAS = ""
IMAGE_FSTYPES += "jffs2 ext2.gz tar.bz2"
#IMAGE_ROOTFS_SIZE_ext2 = "131072"
#EXTRA_IMAGECMD_ext2.gz += "-i 8192"

inherit image

