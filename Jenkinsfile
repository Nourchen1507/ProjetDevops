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

        stage('Build de l\'application Spring') {
            steps {
                sh 'docker build -t timesheet-devops:1.0 .'
            }
        }

        stage('Déploiement en DockerHub') {
            steps {
                sh 'docker login -u skander99 -p SkanderDockerhub'
                sh 'docker push skander99/timesheetdevops:1.0'
            }
        }

        stage('Lancer Docker Compose') {
            steps {
                sh 'docker compose up'
            }
        }
    }
}

