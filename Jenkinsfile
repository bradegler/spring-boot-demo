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
        sh gradlew build
      }
    }
  }
}