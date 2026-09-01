pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code from Git..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Compiling project..."
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Execute Tests') {
            steps {
                echo "Running all test cases from HTTPRequests.java..."
                sh 'mvn test -Dtest=HTTPRequests'
            }
        }
    }

    post {
        success {
            echo 'HTTPRequests test cases executed successfully.'
        }

        failure {
            echo 'Test execution failed — check the Jenkins console log.'
        }
    }
}