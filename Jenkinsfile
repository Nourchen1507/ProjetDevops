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
                sh 'mvn clean install'
            }
        }

        stage('Analyse sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=sqa_fb71cc4c2419b6108b8f63385ce7c01488e332ba'
            }
        }

        stage('Build de l\'application Spring') {
            steps {
                sh 'docker build -t skander99/achat-1.0.jar .'
            }
        }

        stage('Déploiement en DockerHub') {
            steps {
                sh 'docker login -u skander99 -p SkanderDockerhub@1'
                sh 'docker push skander99/achat-1.0.jar'
            }
        }

        stage('Lancer Docker Compose') {
            steps {
                sh 'docker compose down'
                sh 'docker compose up -d'
            }
        }
    }
}

