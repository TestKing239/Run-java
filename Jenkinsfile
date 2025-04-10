pipeline {
    agent any

    environment {
        CHROME_DRIVER = 'Driver/Chrome Driver/chromedriver-win64/chromedriver.exe' // Use .exe on Windows
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/TestKing239/Run-java.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn test -Dheadless=false' // Set true if you want to run without browser
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
