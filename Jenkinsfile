pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code from Git..."
            }
        }

        stage('Build') {
            steps {
                echo "Compiling project..."
            }
        }

        stage('Execute Tests') {
            steps {
                echo "Running test cases..."
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully.'
        }
        failure {
            echo 'Build failed — check the Extent report and console log for details.'
        }
    }
}
