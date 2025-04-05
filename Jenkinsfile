pipeline {
    agent any

    tools {
        maven 'Maven_3.9.6' // Make sure this is configured in Jenkins global tools
        jdk 'Java_17'       // Same for JDK
    }

    environment {
        CHROME_DRIVER = 'Driver/Chrome Driver/chromedriver-win64/chromedriver' // or set this for Windows if needed
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/TestKing239/Run-java.git'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn clean test -Dheadless=false'  // or true if you prefer
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/screenshots/*.png', allowEmptyArchive: true
        }
    }
}
