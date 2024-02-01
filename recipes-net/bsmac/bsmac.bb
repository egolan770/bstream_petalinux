DESCRIPTION = "Assign MAC address"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42e3c987b7344c398e5e62d39b989cd4"
SECTION = "net"

SRC_URI = "git://github.com/deadpoolcode1/blockstream_mac.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# Use cmake class for building
inherit cmake

# The cmake class handles the compile step, so you don't need a custom do_compile function here.
# If you need to run additional commands during compile, consider using do_compile_prepend() or do_compile_append()

do_install() {
    install -d ${D}${bindir}
    # Note that cmake.bbclass automatically installs targets to their destination. This step might be redundant
    # unless you have additional, non-standard installation steps here.
    # If generate_MAC_set_IP is the target built by CMake, it should already be installed by the cmake class's do_install task.
    # This manual installation might be necessary only if the cmake installation step doesn't place the binary where you expect.
    bbnote "Installing generate_MAC_set_IP to ${D}${bindir}"
    install -m 0755 ${B}/generate_MAC_set_IP ${D}${bindir} # Use ${B} to refer to the build directory
}

FILES_${PN} += "${bindir}/generate_MAC_set_IP"
