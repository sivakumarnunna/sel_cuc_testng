pipeline {

agent any

 
 tools { 
      maven 'Maven3.9.6' 
      jdk 'jdk17' 
    }
       
    stages {
    
    
    
     stage('Test') {
            steps {
               echo "${params.browsername}" 
            
    bat "mvn clean test -Dbrowsername=${params.browsername} -DparallelExecution=${params.parallelExecution} -Ddataproviderthreadcount=${params.dataproviderthreadcount}"     

    }
 
  
    }
   
 }
 }
