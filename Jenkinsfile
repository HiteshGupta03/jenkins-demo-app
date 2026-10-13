pipeline {
    agent any

    environment {
        DEPLOY_HOST = 'ubuntu@172.31.1.20'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    scp -o StrictHostKeyChecking=accept-new target/jenkins-demo-app-1.0.jar $DEPLOY_HOST:/home/ubuntu/app/app.jar
                    ssh $DEPLOY_HOST 'pkill -f "[a]pp.jar" || true'
                    ssh $DEPLOY_HOST 'nohup java -cp /home/ubuntu/app/app.jar com.hitesh.app.App > /home/ubuntu/app/app.log 2>&1 < /dev/null &'
                '''
            }
        }
    }

    post {
        success {
            echo 'Tests passed and app deployed to deploy-server.'
        }
        failure {
            echo 'Pipeline failed. Deployment skipped.'
        }
    }
}
