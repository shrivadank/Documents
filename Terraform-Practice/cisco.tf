terraform {
  required_providers {
    aci = {
      source = "CiscoDevNet/aci"
      version = "2.10.1"
    }
  }
}


 variable "name_alias" {
        default = "vswitch_policy_alias"
    }    



resource "aci_vswitch_policy" "example" {
  vmm_domain_dn  = aci_vmm_domain.example.id
  annotation = "vswitch_policy_tag"
  description = "from terraform"
  name_alias = var.name[count.index]
  relation_vmm_rs_vswitch_exporter_pol {
    active_flow_time_out = "60"
    idle_flow_time_out = "15"
    sampling_rate = "0"
    target_dn = "uni/infra/vmmexporterpol-exporter_policy"
    count = 2
  }

  relation_vmm_rs_vswitch_override_cdp_if_pol = aci_cdp_interface_policy.example.id

  relation_vmm_rs_vswitch_override_fw_pol = aci_resource.example.id

  relation_vmm_rs_vswitch_override_lacp_pol = aci_lacp_policy.example.id

  relation_vmm_rs_vswitch_override_lldp_if_pol = aci_lldp_interface_policy.example.id

  relation_vmm_rs_vswitch_override_mcp_if_pol = aci_resource.example.id

  relation_vmm_rs_vswitch_override_mtu_pol = aci_resource.example.id

  relation_vmm_rs_vswitch_override_stp_pol = aci_spanning_tree_interface_policy.example.id
}