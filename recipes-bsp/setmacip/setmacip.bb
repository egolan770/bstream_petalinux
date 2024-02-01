SUMMARY = "Script to set MAC and IP"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = ""

do_install() {
    # Install the generateMac_IP executable to /usr/bin
    install -d ${D}${bindir}
    install -m 0755 ${FILE_DIRNAME}/generateMAC_setIP ${D}${bindir}/

    # Create a symbolic link to SetMacIp in rc3.d
    install -d ${D}/etc/rc3.d
    ln -sf /run/media/mmcblk0p1/setMACIp.bash ${D}/etc/rc3.d/S99SetMacIp
}


python () {
    bb.warn("ezra debug: FILE_DIRNAME: %s" % (d.getVar('FILE_DIRNAME')))
    bb.warn("ezra debug: D: %s, bindir: %s" % (d.getVar('D'), d.getVar('bindir')))
}

FILES_${PN} += "/usr/bin/generateMac_IP"

