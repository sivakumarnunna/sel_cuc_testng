pipeline {

agent any


 parameters {
     
 }
 
 tools { 
      maven 'Maven3.9.6' 
      jdk 'jdk17' 
    }
       
    stages {
    
    
    
     stage('Test') {
            steps {
    bat 'mvn clean test -Dbrowsername=${params.browsername}'        

    }
 
  
    }
   
 }
 }
