param psql string = 'bicep-sqlserver'

resource sqlServer 'Microsoft.Sql/servers@2014-04-01' ={
  name: psql
  location: resourceGroup().location
  properties:{
    administratorLogin: 'admin123456'
    administratorLoginPassword:'Admin@123456'
  }
}


resource sqlServerFirewallRules 'Microsoft.Sql/servers/firewallRules@2021-02-01-preview' = {
  parent: sqlServer
  name: 'bicep-firewall'
  properties: {
    startIpAddress: '1.1.1.1'
    endIpAddress: '1.1.1.1'
  }
}


resource sqlServerDatabase 'Microsoft.Sql/servers/databases@2014-04-01' = {
  parent: sqlServer
  name: 'bicep-db'
  location: resourceGroup().location
  properties: {
    collation: 'SQL_Latin1_General_CP1_CI_AS'
    edition: 'Basic'
    maxSizeBytes: '2147483648'
    requestedServiceObjectiveName: 'Basic'
  }
}
