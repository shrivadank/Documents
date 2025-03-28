provider "azurerm" {
    features {}
  
}

resource "azurerm_resource_group" "rg" {
    name = "terraform"
    location = "centralindia"
  
}

resource "azurerm_virtual_network" "vnet" {
    name = "terraform-vnet"
    address_space = [ "10.0.0.0/16" ]
    location = azurerm_resource_group.rg.location
    resource_group_name = azurerm_resource_group.rg.name
  
}

resource "azurerm_subnet" "subnet" {
    name = "terraform-subnet"
    resource_group_name = azurerm_resource_group.rg.name
    virtual_network_name = azurerm_virtual_network.vnet.name
    address_prefixes = [ "10.0.2.0/24" ]
  
}

resource "azurerm_network_interface" "nic" {
    name = "terraform-nic"
    location = azurerm_resource_group.rg.location
    resource_group_name = azurerm_resource_group.rg.name

    ip_configuration {
      name = "internal"
      subnet_id = azurerm_subnet.subnet.id
      private_ip_address_allocation = "Dynamic"
    }
   
}

resource "azurerm_windows_virtual_machine" "vm" {
    name = "terraform-vm"
    resource_group_name = azurerm_resource_group.rg.name
    location = azurerm_resource_group.rg.location
    size = "Standard_F2"
    admin_username = "shrivadan"
    admin_password = "shrivadan@1309"
    network_interface_ids = [ azurerm_network_interface.nic.id, ]
  


  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }

    source_image_reference {
    publisher = "MicrosoftWindowsServer"
    offer     = "WindowsServer"
    sku       = "2016-Datacenter"
    version   = "latest"
  }
}