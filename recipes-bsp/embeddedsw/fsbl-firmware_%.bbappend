SRC_URI:append = " \
        file://0001-FSBL.patch \
        "
  
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
  
#Add debug for FSBL(optional)
#XSCTH_BUILD_DEBUG = "1"
  
#Enable appropriate FSBL debug or compiler flags
YAML_COMPILER_FLAGS:append = ""
