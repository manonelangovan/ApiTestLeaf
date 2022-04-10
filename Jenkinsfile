pipeline {
  agent {
    node {
      label 'test'
    }

  }
  stages {
    stage('git') {
      parallel {
        stage('git') {
          steps {
            git(url: 'https://github.com/TestLeafInc/WebApp.git', branch: 'master')
          }
        }

        stage('stop app') {
          steps {
            bat 'startApp.bat'
          }
        }

        stage('mvn') {
          steps {
            bat 'mnv.stopapp,bat'
          }
        }

        stage('start') {
          steps {
            bat 'startApp.bat'
          }
        }

      }
    }

  }
}