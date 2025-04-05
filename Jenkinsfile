pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git(
                    url: 'https://github.com/TestKing239/Run-java.git',
                    branch: 'main',
                    credentialsId: '351ca8e3-dd4b-4514-b9d6-e3a6a80cc4c9'
                )
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test '
            }
        }
        
    }
}
