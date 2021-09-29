pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            agent any {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='fanaticsautomation/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push fanaticsautomation/selenium-docker:latest"
			    }
            }
        }
    }
}
// pipeline {
//     agent none
//     stages {
//         stage('Build Jar') {
//             agent any {
//                 docker {
//                     image 'maven:3-alpine'
//                     args '-v /root/.m2:/root/.m2'
//                 }
//             }
//             steps {
//                 sh 'mvn clean package -DskipTests'
//             }
//         }
//         stage('Build Image') {
//             steps {
//                 script {
//                 	app = docker.build("fanaticsautomation/selenium-docker")
//                 }
//             }
//         }
//         stage('Push Image') {
//             steps {
//                 script {
// 			        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
// 			        	app.push("${BUILD_NUMBER}")
// 			            app.push("latest")
// 			        }
//                 }
//             }
//         }
//     }
// }