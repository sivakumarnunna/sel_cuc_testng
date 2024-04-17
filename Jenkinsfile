pipeline {

agent any

 
 tools { 
      maven 'Maven3.9.6' 
      jdk 'jdk21' 
    }
    stages {
    
     stage('Test') {
            steps {
    echo "${params.browsername}" 
    bat "mvn clean test -Dbrowsername=${params.browsername} -Dcucumber.filter.tags=@{params.tags} -Ddataproviderthreadcount=${params.dataproviderthreadcount}"  
    }
    }
 }
 }
