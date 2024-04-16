pipeline {

agent any
 
 tools { 
      maven 'Maven3.9.6' 
      jdk 'jdk17' 
    }
       
    stages {
    
      stage('Checkout') {
            steps {
                // Checkout your code from version control
                git 'https://github.com/your/repository.git'
            }
        }
    
     stage('Test') {
            steps {
bat 'mvn clean test'        

    }
 
  
    }
   
 }
 }
