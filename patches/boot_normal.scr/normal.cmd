if fatload mmc 0 80200000 uImage.bin
then
 echo ***** Kernel: /dev/mmcblk0p1/uImage.bin *****
else
 echo ***** Kernel: /dev/mtd3 *****
 nand read 80200000 280000 400000
fi
if fatload mmc 0 81600000 ramdisk.gz
then
 echo ***** RootFS: /dev/mmcblk0p1/ramdisk.gz *****
 setenv bootargs 'console=ttyO2,115200n8 console=tty0 root=/dev/ram0 rw ramdisk_size=32768 initrd=0x81600000,32M'
 setenv console 'ttyO2,115200n8'
else
 echo ***** RootFS: /dev/mmcblk0p2 *****
 setenv bootargs 'console=ttyO2,115200n8 console=tty0 root=/dev/mmcblk0p2 rw rootwait'
 setenv console 'ttyO2,115200n8'
fi
bootm 80200000