FW_DIR	:= /lib/firmware/rtlbt
FW_NAME := rtl8822cs_fw
CF_NAME := rtl8822cs_config
all:
	@echo "Copy RTL8822CS fw/config to $(FW_DIR)"
	cp -f $(FW_NAME) $(FW_DIR)/$(FW_NAME)
	cp -f $(CF_NAME) $(FW_DIR)/$(CF_NAME)
clean:
