pipeline {
  agent any
  environment {
    OCIR_REGISTRY = "${env.OCIR_REGISTRY}"
    OCIR_ACCESS_USER = credentials('jenkins-ocir-secret-user')
    OCIR_ACCESS_KEY = credentials('jenkins-ocir-secret-key')
  }
  stages {
    stage('Build') {
      steps {
        sh './gradlew build'
      }
    }
    stage('Tag Image') {
      steps {
        sh './gradlew dockerTag'
      }
    }
    stage('Push Image') {
      steps {
        sh "sudo docker login -u ${OCIR_ACCESS_USER} -p ${OCIR_ACCESS_KEY} ${OCIR_REGISTRY}"
        sh "docker push iad.ocir.io/pickatto/demo"

      }
    }
  }
}