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
    }
}

