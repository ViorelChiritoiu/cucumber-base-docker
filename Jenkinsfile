pipeline {
    agent any

    stages {

        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image') {
            steps {
                bat "docker build -t=chiritoiuviorel/cucumberbase:latest ."
            }
        }

        stage('Push Image') {
            environment {
                DOCKER_HUB = credentials('dockerhub-credentials')
            }
            steps {
                bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                bat "docker push chiritoiuviorel/cucumberbase:latest"
                bat "docker tag chiritoiuviorel/cucumberbase:latest chiritoiuviorel/cucumberbase:${env.BUILD_NUMBER}"
                bat "docker push chiritoiuviorel/cucumberbase:${env.BUILD_NUMBER}"
            }
        }
    }

    post {
        always {
            bat "docker logout"
        }
    }
}