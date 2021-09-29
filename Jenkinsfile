pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Setup terminal') {
            steps {
                sh "source ~/.bash_profile"
                sh "mvn -version"
            }
        }
        stage('Build Jar') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='fanaticsautomation/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push fanaticsautomation/selenium-docker:latest"
			    }
            }
        }
    }
}
