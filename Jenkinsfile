pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9.9'  // Specify the Maven version
        jdk 'Java 11'        // Specify the JDK version
    }

    environment {
        DOCKER_IMAGE = 'comeback'
    }



 stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/saimagit/comeback.git'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
         stage('Test') {
            steps {
                script {
                    // Run unit tests
                    bat 'mvn test'
                    echo 'i did it'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    /// Build the Docker image
                    bat 'docker build -t comeback .'
                }
            }
        }

        stage('Deploy Docker Container') {
            steps {
                script {
                    // Run the Docker container
                    bat 'docker run -d -p 8081:8080 comeback'
                }
            }
        }
    }
}