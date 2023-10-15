pipeline {
    agent any

    stages {
        stage('Récupération du code') {
            steps {
                sh 'git checkout skander'
                sh 'git pull origin skander'
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Analyse sonar') {
            steps {
                 sh 'mvn sonar:sonar -Dsonar.login=sqa_fb71cc4c2419b6108b8f63385ce7c01488e332ba'
            }
        }
    }
}

