param pappserviceplan string 
param pwebapp string 
param pappinsight string 



resource appServicePlan 'Microsoft.Web/serverfarms@2020-12-01' = {
  name: pappserviceplan
  location: resourceGroup().location
  sku: {
    name: 's1'
    capacity: 1
  }
}

// resource appServicePlan1 'Microsoft.Web/serverfarms@2020-12-01' = {
//   name: 'bicep-appServicePlan-linux'
//   kind: 'linux'
//   properties:{
//     reserved:true
//   }
//   location: resourceGroup().location
//   sku: {
//     name: 's1'
//     capacity: 1
//   }
// }

resource webApp 'Microsoft.Web/sites@2021-01-15' = {
  name: pwebapp
  location: resourceGroup().location
  
  properties: {
    serverFarmId: appServicePlan.id

  }
  dependsOn:[
    appServicePlan
  ]
}

// resource azwebappsetting 'Microsoft.Web/sites/config/appsettings@2022-09-01' = {
//   name: 'app-setting'
//   parent:webApp
//   properties:{
//     appSettings:[
//       {
//         name: 'appinsight_instrumentationkey'
//         value: 'appInsights.properties.InstrumentationKey'
//       }
//       {
//         name: 'key1'
//         value: 'value1'
//       }
//     ]
//   }
// }


resource appInsights 'Microsoft.Insights/components@2020-02-02' = {
  name: pappinsight
  location: resourceGroup().location
  kind: 'web'
  properties: {
    Application_Type: 'web'
  }
}


// run command
// az deployment group create -g azbicepresourcegroup -f AppServicePlan.bicep
