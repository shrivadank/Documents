param pappserviceplan string = 'bicep-appServicePlan'
param pwebapp string = 'bicep-webapp'
param pappinsight string = 'bicep-appinsight'
param psql string = 'bicep-sqlserver'


module appserviceplan 'AppServicePlan.bicep'={
  name: 'bicep-asp'
  params:{
    pappserviceplan : pappserviceplan
    pwebapp: pwebapp
    pappinsight:pappinsight
  }
}

module sqldb 'sql.bicep'={
  name:'bicep-db'
  params:{
    psql:psql
  }
}
