def call(Map config = [:]) {
    withCredentials([usernamePassword(credentialsId: config.credsId, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
        sh "docker compose build"
        sh "docker tag ${config.imageName}:latest ${config.repo}:${config.tag}"
        sh "docker tag ${config.imageName}:latest ${config.repo}:latest"
        sh "docker push ${config.repo}:${config.tag}"
        sh "docker push ${config.repo}:latest"
    }
}
