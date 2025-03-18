targetScope= 'subscription'

resource azbicepresourcegroup 'Microsoft.Resources/resourceGroups@2023-07-01'={
  name: 'azbicepresourcegroup'
  location: 'eastus'
}


// run command

//az deployment sub create -l eastus -f rg.bicep
