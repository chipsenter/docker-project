pipeline {
    agent none
    stages {
        stage('Build Jar') {
            agent {
                any {
                    image 'maven:3-alpine'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'source ~/.bash_profile'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("vinsdocker/selenium-docker")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}

// pipeline {
//     // master executor should be set to 0
//     agent any
//     stages {
//         stage('Build Jar') {
//             steps {
//                 //sh
//                 sh "mvn clean package -DskipTests"
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 sh "docker build -t='fanaticsautomation/selenium-docker' ."
//             }
//         }
//         stage('Push Image') {
//             steps {
// 			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
// 			        sh "docker login --username=${user} --password=${pass}"
// 			        sh "docker push fanaticsautomation/selenium-docker:latest"
// 			    }
//             }
//         }
//     }
// }
